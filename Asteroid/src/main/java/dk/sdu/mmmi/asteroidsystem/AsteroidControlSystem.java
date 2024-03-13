package dk.sdu.mmmi.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService {

//    double chanceToSpawn = 1;

    @Override
    public void process(GameData gameData, World world) {
        Random random = new Random();

        // Chance to spawn 1
        int randomInt = random.nextInt(50);

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
            asteroid.setX(asteroid.getX() + changeX * 0.5);
            asteroid.setY(asteroid.getY() + changeY * 0.5);


            if(asteroid.getHitPoints()==7){

                Entity asteroid1 = new Asteroid();
                asteroid1.setPolygonCoordinates(10, 0, 3, 3, 0, 10, -3, 3, -10, 0, -3, -3, 0, -10, 3, -3);
                asteroid1.setX(asteroid.getX());
                asteroid1.setY(asteroid.getY());
                asteroid1.setRotation(asteroid.getRotation()+90);
                asteroid1.setHitPoints(6);
                asteroid1.setDmg(10);
                world.addEntity(asteroid1);

                // Second asteroid
                Entity asteroid2 = new Asteroid();
                asteroid2.setPolygonCoordinates(10, 0, 3, 3, 0, 10, -3, 3, -10, 0, -3, -3, 0, -10, 3, -3);
                asteroid2.setX(asteroid.getX());
                asteroid2.setY(asteroid.getY());
                asteroid2.setRotation(asteroid.getRotation()-90);
                asteroid2.setHitPoints(6);
                asteroid2.setDmg(10);
                world.addEntity(asteroid2);

                world.removeEntity(asteroid);

//                // Second asteroid
//                Entity asteroid2 = new Asteroid();
//                asteroid2.setPolygonCoordinates(5, 0, 3, 3, 0, 5, -3, 3, -5, 0, -3, -3, 0, -5, 3, -3);
//                asteroid2.setX(asteroid.getX());
//                asteroid2.setY(asteroid.getY());
//                asteroid2.setRotation(asteroid.getRotation()+90);
//                asteroid2.setHitPoints(10);
//                world.addEntity(asteroid2);
            }

            if(asteroid.getHitPoints()==3){


                Entity asteroid1 = new Asteroid();
                asteroid1.setPolygonCoordinates(3, 0, 2, 2, 0, 3, -2, 2, -3, 0, -2, -2, 0, -3, 2, -2);
                asteroid1.setX(asteroid.getX());
                asteroid1.setY(asteroid.getY());
                asteroid1.setRotation(asteroid.getRotation()+90);
                asteroid1.setHitPoints(2);
                asteroid1.setDmg(10);
                world.addEntity(asteroid1);

                // Second asteroid
                Entity asteroid2 = new Asteroid();
                asteroid2.setPolygonCoordinates(3, 0, 2, 2, 0, 3, -2, 2, -3, 0, -2, -2, 0, -3, 2, -2);
                asteroid2.setX(asteroid.getX());
                asteroid2.setY(asteroid.getY());
                asteroid2.setRotation(asteroid.getRotation()-90);
                asteroid2.setHitPoints(2);
                asteroid2.setDmg(10);
                world.addEntity(asteroid2);

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
//        System.out.println(chanceToSpawn+ "First");

//        double chance = 50;
//        chance=chance*chanceToSpawn;
//        if(chance<1){
//            chance = 1;
//        }

        // Chance to spawn 2
//        double spawnRate = random.nextDouble(chance);


//        if(spawnRate<1){
            int randomInt = random.nextInt(gameData.getDisplayWidth())+1;

            Entity asteroid1 = new Asteroid();
            asteroid1.setPolygonCoordinates(10, 0, 7, 7, 0, 10, -7, 7, -10, 0, -7, -7, 0, -10, 7, -7);
            asteroid1.setX(randomInt);
            asteroid1.setY(0);
            asteroid1.setRotation(90);
            asteroid1.setHitPoints(10);
            asteroid1.setDmg(10);

        world.addEntity(asteroid1);
            // Higher chance to spawn
//            chanceToSpawn=chanceToSpawn*0.8;
//            System.out.println(chanceToSpawn);
//        }

//        return asteroid1;
    }


}
