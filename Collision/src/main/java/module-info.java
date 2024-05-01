import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

module Collision {
    requires Common;
    requires CommonBullet;
    requires Asteroid;
    requires java.net.http;
    provides IEntityProcessingService with dk.sdu.mmmi.collisionsystem.CollisionControlSystem;
}