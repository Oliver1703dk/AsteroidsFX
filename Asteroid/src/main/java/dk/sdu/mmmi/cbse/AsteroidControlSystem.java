package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService {


    @Override
    public void process(GameData gameData, World world) {
        Random random = new Random();

        // Chance to spawn 1
        int randomInt = random.nextInt(50);

        for (Entity asteroid : world.getEntities(HelloWorld.class)) {
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
            asteroid.setX(asteroid.getX() + changeX * 0.5);
            asteroid.setY(asteroid.getY() + changeY * 0.5);


            if(asteroid.getHitPoints()==7){

                createMediumAsteroid(asteroid, world, -90);
                createMediumAsteroid(asteroid, world, 90);
                world.removeEntity(asteroid);

            }

            if(asteroid.getHitPoints()==3){

                createSmallAsteroid(asteroid, world, -90);
                createSmallAsteroid(asteroid, world, 90);
                world.removeEntity(asteroid);



            }


        }


        if (randomInt==1){
            // Add entities to the world
//            Entity asteroid;
            createAsteroid(gameData, world);
//            world.addEntity(asteroid);
        }

    }

    public void createAsteroid(GameData gameData, World world) {
        Random random = new Random();

            int randomInt = random.nextInt(gameData.getDisplayWidth())+1;

            Entity asteroid1 = new HelloWorld();
            asteroid1.setPolygonCoordinates(30, 0, 20, 20, 0, 30, -20, 20, -30, 0, -20, -20, 0, -30, 20, -20);
            asteroid1.setX(randomInt);
            asteroid1.setY(0);
            asteroid1.setRotation(90);
            asteroid1.setHitPoints(10);
            asteroid1.setDmg(10);

        world.addEntity(asteroid1);
    }

    public void createMediumAsteroid(Entity asteroid, World world, int rotation){
        // Second asteroid
        Entity asteroid1 = new HelloWorld();
        asteroid1.setPolygonCoordinates(20, 0, 14, 14, 0, 20, -14, 14, -20, 0, -14, -14, 0, -20, 14, -14);
        asteroid1.setX(asteroid.getX());
        asteroid1.setY(asteroid.getY());
        asteroid1.setRotation(asteroid.getRotation()+rotation);
        asteroid1.setHitPoints(6);
        asteroid1.setDmg(10);
        world.addEntity(asteroid1);
    }

    public void createSmallAsteroid(Entity asteroid, World world, int rotation){
        Entity asteroid1 = new HelloWorld();
        asteroid1.setPolygonCoordinates(10, 0, 7, 7, 0, 10, -7, 7, -10, 0, -7, -7, 0, -10, 7, -7);
        asteroid1.setX(asteroid.getX());
        asteroid1.setY(asteroid.getY());
        asteroid1.setRotation(asteroid.getRotation()+rotation);
        asteroid1.setHitPoints(2);
        asteroid1.setDmg(10);
        world.addEntity(asteroid1);
    }


}
