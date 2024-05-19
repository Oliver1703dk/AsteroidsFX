package dk.sdu.mmmi.collisionsystem;


import dk.sdu.mmmi.cbse.common.data.Entity;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollisionControlSystemTest {


    private GameData gameData;
    private World world;
    private CollisionControlSystem collisionControlSystem;

    @BeforeEach
    void setUp() {
        gameData = new GameData();
        world = new World();
        collisionControlSystem = new CollisionControlSystem();
    }


    @AfterEach
    void tearDown() {
        gameData = null;
        world = null;
        collisionControlSystem = null;
    }


    @Test
    void isCollision() {
        Entity asteroid = new Entity();
        Entity bullet = new Entity();
        asteroid.setPolygonCoordinates(20, 0, 14, 14, 0, 20, -14, 14, -20, 0, -14, -14, 0, -20, 14, -14);
        bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);

        asteroid.setX(10);
        asteroid.setY(10);
        bullet.setX(11);
        bullet.setY(11);

        assertTrue(collisionControlSystem.isCollision(asteroid, bullet));
    }
    @Test
    void isNotCollision() {
        Entity asteroid = new Entity();
        Entity bullet = new Entity();
        asteroid.setPolygonCoordinates(20, 0, 14, 14, 0, 20, -14, 14, -20, 0, -14, -14, 0, -20, 14, -14);
        bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);

        asteroid.setX(10);
        asteroid.setY(10);
        bullet.setX(150);
        bullet.setY(150);

        assertFalse(collisionControlSystem.isCollision(asteroid, bullet));
    }




}