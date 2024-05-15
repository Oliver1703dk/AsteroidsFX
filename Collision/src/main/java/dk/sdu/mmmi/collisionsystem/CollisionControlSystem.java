package dk.sdu.mmmi.collisionsystem;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityParts.LifePart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.OptionalDouble;

import static java.lang.Math.sqrt;

public class CollisionControlSystem implements IPostEntityProcessingService {


    @Override
    public void process(GameData gameData, World world) {

        for (Entity entity : world.getEntities()) {
            for (Entity entity1 : world.getEntities()) {
                if (isCollision(entity, entity1) && entity.getClass() != entity1.getClass()) {
                    LifePart lifePart = (LifePart) entity.getPart(LifePart.class);
                    LifePart lifePart1 = (LifePart) entity1.getPart(LifePart.class);

                    int entityDmg = lifePart.getDmg();
                    int entityDmg1 = lifePart1.getDmg();
                    int entityLife = lifePart.getLife();
                    int entityLife1 = lifePart1.getLife();

//                    System.out.println(entityDmg);
//                    System.out.println(entityDmg1);
//                    entity.setHitPoints(entity.getHitPoints() - entityDmg1);
//                    entity1.setHitPoints(entity1.getHitPoints() - entityDmg);


                    lifePart.setLife(entityLife - entityDmg1);
                    lifePart1.setLife(entityLife1 - entityDmg);

                    // Change hitpoints
                    if (lifePart1.getLife() < 1) {
                        world.removeEntity(entity1);
                    }
                    if (lifePart.getLife() < 1) {
                        world.removeEntity(entity);
                    }


//                    world.removeEntity(entity);
//                    world.removeEntity(entity1);
                }
            }

        }


    }


    public boolean isCollision(Entity e1, Entity e2) {

        double x1 = e1.getX();
        double y1 = e1.getY();

        double x2 = e2.getX();
        double y2 = e2.getY();

        double result = sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
        double e1Width = e1.getWidth() / 2;
        double e2Width = e2.getWidth() / 2;


        if (result < e1Width + e2Width) {
            return true;
        }

        return false;
    }


}
