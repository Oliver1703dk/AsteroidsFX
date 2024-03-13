package dk.sdu.mmmi.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
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
        asteroid1.setPolygonCoordinates(10, 0, 7, 7, 0, 10, -7, 7, -10, 0, -7, -7, 0, -10, 7, -7);
        asteroid1.setX(gameData.getDisplayWidth()/2);
        asteroid1.setY(0);
        asteroid1.setRotation(90);
        asteroid1.setHitPoints(10);
        asteroid1.setDmg(10);

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
