package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityParts.LifePart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX * 3);
            bullet.setY(bullet.getY() + changeY * 3);


            if (bullet.getX() < 0) {
                world.removeEntity(bullet);
            }

            if (bullet.getX() > gameData.getDisplayWidth()) {
                world.removeEntity(bullet);
            }

            if (bullet.getY() < 0) {
                world.removeEntity(bullet);
            }

            if (bullet.getY() > gameData.getDisplayHeight()) {
                world.removeEntity(bullet);
            }
            LifePart lifePart = (LifePart) bullet.getPart(LifePart.class);
            if(lifePart.getLife()<=0){
                world.removeEntity(bullet);
            }
            lifePart.process(gameData, bullet);




        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        Entity bullet = new Bullet();
        bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);
        bullet.setX(shooter.getX());
        bullet.setY(shooter.getY());
        bullet.add(new LifePart(1, 1));

        bullet.setRotation(shooter.getRotation());
        double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
        double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
        bullet.setX(bullet.getX() + changeX * 10);
        bullet.setY(bullet.getY() + changeY * 10);
        return bullet;
    }
}
