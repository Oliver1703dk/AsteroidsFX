import dk.sdu.mmmi.cbse.EntityProcessor;
import dk.sdu.mmmi.cbse.AsteroidControlSystem;
import dk.sdu.mmmi.cbse.AsteroidPlugin;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Asteroid {
    exports dk.sdu.mmmi.cbse;
    requires Common;
    provides IGamePluginService with AsteroidPlugin;
    provides IEntityProcessingService with AsteroidControlSystem, EntityProcessor;
}

