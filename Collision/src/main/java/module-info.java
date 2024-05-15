import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires CommonBullet;
    requires Asteroid;
    requires java.net.http;
    provides IPostEntityProcessingService with dk.sdu.mmmi.collisionsystem.CollisionControlSystem;
}