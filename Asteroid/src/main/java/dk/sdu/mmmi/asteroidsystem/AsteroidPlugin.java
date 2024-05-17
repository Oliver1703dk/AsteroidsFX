package dk.sdu.mmmi.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityParts.LifePart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {

        Entity asteroid1 = new Asteroid();
        asteroid1.setPolygonCoordinates(20, 0, 14, 14, 0, 20,
                -14, 14, -20, 0, -14, -14, 0, -20, 14, -14);
        asteroid1.setX(gameData.getDisplayWidth()/2);
        asteroid1.setY(0);
        asteroid1.setRotation(90);
        asteroid1.add(new LifePart(10, 10));

        return asteroid1;
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity e : world.getEntities()) {
            if (e.getClass() == Asteroid.class) {
                world.removeEntity(e);
            }
        }
    }

}
