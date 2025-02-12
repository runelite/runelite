package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.*;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.toolbox.core.MouseMovement;
import net.runelite.client.plugins.toolbox.core.MouseTracker;
import net.runelite.client.ui.ClientToolbar;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.overlay.OverlayManager;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;

@PluginDescriptor(
        name = "Alder Rise Plugin",
        description = "Toolbox - Woodcutting",
        tags = {"toolbox", "leveling", "woodcutting"},
        enabledByDefault = false
)
@Slf4j
public class AlderRisePlugin extends Plugin{

    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private ConfigManager configManager;

    @Inject
    private RuneLiteConfig runeLiteConfig;

    @Inject
    private ChatColorConfig chatColorConfig;

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private Notifier notifier;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private AlderRiseConfig config;

    @Inject
    private AlderRiseOverlay overlay;

    @Inject
    private MouseOverlay mouseOverlay;

    @Inject
    private MouseManager mouseManager;

    @Inject
    private MouseTracker mouseTracker;

    @Inject
    private MouseMovement mouseMovement;

    private static final int MIN_UPDATE_INTERVAL_MS = 147;  // Min time interval between checks (100ms)
    private static final int MAX_UPDATE_INTERVAL_MS = 543;
    public static final String GROUP_ID_PLUGIN_PATH = "toolbox.leveling.woodcutting.alder_rise";

    // Define a map to link config keys to their corresponding handler methods
    private final Map<String, Consumer<AlderRiseConfig>> configHandlers = new HashMap<>();

    ExecutorService executor = Executors.newSingleThreadExecutor();

    private final AlderRiseScript script;

    @Getter
    private GameObject currentTree;
    @Getter
    private Tile currentTreeTile;

    public AlderRisePlugin(){
        super();
        script = new AlderRiseScript();
        // Call the setup function asynchronously
        CompletableFuture.runAsync(this::_configure_config_handlers);
    }

    @Provides
    AlderRiseConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(AlderRiseConfig.class);
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        log.trace("onGameTick Complete");
    }


    @Subscribe
    public void onGameObjectDespawned(GameObjectDespawned event) {
        if (currentTree == null) {
            return;
        }

        GameObject despawned = event.getGameObject();
        if (despawned == null) {
            return;
        }

        // Compare positions to check if it's the same tree
        WorldPoint despawnedLocation = despawned.getWorldLocation();
        WorldPoint trackedLocation = currentTree.getWorldLocation();

        if (despawnedLocation.equals(trackedLocation) && despawned.getId() == currentTree.getId()) {
            currentTree = null; // Tree is cut down
            currentTreeTile = null;
            log.info("Tree has been cut down!");
        }
    }

    @Subscribe
    public void onChatMessage(ChatMessage event)
    {
        log.trace("Toolbox - onChatMessage");
    }

    @Subscribe
    public void onPlayerSpawned(PlayerSpawned event)
    {
        log.trace("Toolbox - onPlayerSpawned");
    }

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event)
    {
        log.trace("Toolbox - onItemContainerChanged");
    }

    @Subscribe
    public void onInteractingChanged(InteractingChanged event)
    {
        log.trace("Toolbox - onInteractingChanged");
    }

    @Subscribe
    public void onAnimationChanged(AnimationChanged event)
    {
        log.trace("Toolbox - onAnimationChanged");
    }

    @Override
    protected void startUp() throws Exception
    {
        //Always set the
        //String configGroup = getConfigGroup(AlderRiseConfig.class);
        String configGroup = AlderRiseConfig.class.getAnnotation(ConfigGroup.class).value();

        // Reset the "enableRegularTree" config to false on startup
        configManager.setConfiguration(configGroup, "enableRegularTree", false);


        //overlayManager.add(overlay);
        overlayManager.add(mouseOverlay);
        executor = Executors.newSingleThreadExecutor();
        super.startUp();
        mouseManager.registerMouseListener(mouseTracker);
        log.debug("startUp Complete");
    }

    @Override
    protected void shutDown() throws Exception
    {
        //overlayManager.remove(overlay);
        overlayManager.remove(mouseOverlay);
        executor.shutdown();
        super.shutDown();
        mouseManager.unregisterMouseListener(mouseTracker);
        log.debug("shutDown Complete");
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event) {
        AlderRiseConfig config = configManager.getConfig(AlderRiseConfig.class);

        String group = event.getGroup();
        String key = event.getKey();

        log.debug(String.format("inConfigChange - {%s} - {%s} - {%s}", AlderRiseConfig.class, group, key));

        // Check if the config item is us
        if (group.equalsIgnoreCase(GROUP_ID_PLUGIN_PATH))
        {
            // Get the handler based on the key
            Consumer<AlderRiseConfig> handler = configHandlers.get(key);
            if (handler != null) {
                // Invoke the handler
                handler.accept(config);
            } else {
                log.warn(String.format("No handler found for key: %s", key));
            }
        }
    }

    private void _configure_config_handlers(){
        configHandlers.put("enablePlugin", this::_enable_plugin);
        configHandlers.put("enableRegularTree", this::_enable_regular_tree);
        configHandlers.put("logLevel", this::_set_log_level);
    }

    private void _enable_plugin(AlderRiseConfig config){
        boolean _enable = config.enablePlugin();
        log.info(String.format("enablePlugin == {%s}", _enable));
    }

    private void _enable_regular_tree(AlderRiseConfig config){
        boolean _enable = config.enableRegularTree();
        log.info(String.format("enableRegularTree == {%s}", _enable));
        if (_enable){

            executor.submit(() -> _move("Tree"));

        }
        else{
        }
    }

    private void _set_log_level(AlderRiseConfig config){
        Level new_level = config.logLevel().toLogbackLevel();
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        ch.qos.logback.classic.Logger rootLogger = loggerContext.getLogger("root");
        rootLogger.setLevel(new_level);
        log.info(String.format("LogLevel == {%s}", new_level));
    }

    private void _move(String treeName){

        int MAX_DISTANCE = 2400;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("Starting Searching Game Objects");
        double closestDistance = Double.MAX_VALUE;
        GameObject closestTree = null;

        Scene scene = client.getScene();
        LocalPoint currentLocation = client.getLocalPlayer().getLocalLocation();
        Tile[][][] tiles = scene.getTiles();

        int z = client.getPlane();

        for (int x = 0; x < Constants.SCENE_SIZE; ++x) {
            for (int y = 0; y < Constants.SCENE_SIZE; ++y) {
                Tile tile = tiles[z][x][y];

                if (tile == null) {
                    continue;
                }

                Player player = client.getLocalPlayer();
                if (player == null) {
                    continue;
                }

                GameObject[] gameObjects = tile.getGameObjects();
                //log.info("Game Objects found: " + gameObjects.length);
                for (GameObject gameObject : gameObjects) {

                    if (gameObject != null && gameObject.getSceneMinLocation().equals(tile.getSceneLocation())){
                        if (script.isTree(gameObject, treeName)){
                            //log.info(String.format("Tile object is good: ID{%s},MinLocation{%s}", gameObject.getId(), gameObject.getSceneMinLocation().equals(tile.getSceneLocation())));

                            LocalPoint treePosition = gameObject.getLocalLocation();
                            double distance = currentLocation.distanceTo(treePosition);

                            // Update the closest tree if we found a closer one
                            if (distance < closestDistance) {
                                closestDistance = distance;
                                closestTree = gameObject;
                                currentTreeTile = tile;
                            }
                        }
                    }
                }
            }
        }

        if (closestTree != null){
            this.currentTree = closestTree;

            Model model = getModelFromGameObject(closestTree);
            LocalPoint localPoint = closestTree.getLocalLocation();
            if (model == null){ return; }

            // Retrieve the model’s vertex data
            float[] verticesX = model.getVerticesX();
            float[] verticesY = model.getVerticesY();
            float[] verticesZ = model.getVerticesZ();

            float minX = Float.MAX_VALUE, maxX = Float.MIN_VALUE;
            float minY = Float.MAX_VALUE, maxY = Float.MIN_VALUE;

            for (int i = 0; i < verticesX.length; i++) {
                float x = verticesX[i] + localPoint.getX(); // Adjust for local position
                float y = verticesZ[i] + localPoint.getY(); // Use Z for depth

                // Find the min/max boundaries
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }

            // Log the boundaries
            log.info("Model Bounds - minX:{} maxX:{} minY:{} maxY:{}", minX, maxX, minY, maxY);

        }

    }

    public Model getModelFromGameObject(GameObject gameObject){
        TileObject tileObject = (TileObject) this.currentTree;  // Cast to TileObject
        Model model = extractModel(((GameObject) tileObject).getRenderable());
        return model;
    }

    public Point getRandomPointInsideModel(Model model, LocalPoint modelLocation, Player player) {
        // Step 1: Get the vertices of the model (you already have these)
        float[] vertexX = model.getVerticesX();
        float[] vertexY = model.getVerticesY();
        float[] vertexZ = model.getVerticesZ();

        // Step 2: Transform 3D coordinates into screen space
        int screenWidth = client.getCanvasWidth();
        int screenHeight = client.getCanvasHeight();
        int randomTries = 10;  // Try multiple times to find a valid point

        Random rand = new Random();

        // Try to find a valid random point inside the projected model bounds
        for (int i = 0; i < randomTries; i++) {
            // Randomly select a point in the model's 3D space (use the bounding box or specific coordinates)
            int randomIndex = rand.nextInt(vertexX.length);
            float randomX = vertexX[randomIndex];
            float randomY = vertexY[randomIndex];
            float randomZ = vertexZ[randomIndex];

            // Step 3: Convert the random point to LocalPoint (for easier manipulation)
            LocalPoint randomLocalPoint = new LocalPoint((int) randomX, (int) randomY);
            log.info("randomLocalPoint:" + randomLocalPoint);

            int plane = client.getPlane();  // Get the current plane of the object
            int modelHeight = client.getTileHeights()[plane]
                    [modelLocation.getSceneX()][modelLocation.getSceneY()]; // Get height at model location

            Point screenPoint = Perspective.localToCanvas(client, randomLocalPoint, modelHeight);

            // Step 5: Check if the point lies inside the bounds of the model on screen
            if (screenPoint != null) {
                boolean isInside = isInsideModelBounds(screenPoint, model);
                log.info(String.format("isInsideModelBounds:Flag:{%s}, Point{%s}" , isInside, screenPoint));
                if (isInside){
                    return screenPoint;
                }
            }
        }

        return null;  // Return null if no valid point found after multiple tries
    }

    // Method to check if a point is inside the model's projected 2D bounds
    private boolean isInsideModelBounds(Point point, Model model) {
        // Assuming model has a method to get its 2D bounds
        Rectangle modelBounds = getModelBounds(model);

        return modelBounds.contains(point.getX(), point.getY());

        // Check if the point is inside the bounds
        //return modelBounds.contains(point);
    }

    // Method to get the 2D bounds of the model (could use bounding box)
    private Rectangle getModelBounds(Model model) {
        // You would need to implement logic to calculate the 2D bounds based on the model's vertices
        // or use the model's projected bounding box
        float[] vertexX = model.getVerticesX();
        float[] vertexY = model.getVerticesY();

        float minX = Float.MAX_VALUE, minY = Float.MAX_VALUE, maxX = Float.MIN_VALUE, maxY = Float.MIN_VALUE;

        // Calculate the bounding box from the vertices
        for (int i = 0; i < vertexX.length; i++) {
            if (vertexX[i] < minX) minX = vertexX[i];
            if (vertexX[i] > maxX) maxX = vertexX[i];
            if (vertexY[i] < minY) minY = vertexY[i];
            if (vertexY[i] > maxY) maxY = vertexY[i];
        }

        // Create and return a Rectangle that represents the model's 2D bounds
        return new Rectangle((int) minX, (int) minY, (int) (maxX - minX), (int) (maxY - minY));
    }

    private Model extractModel(Renderable renderable) {
        if (renderable == null) {
            return null;
        }
        return renderable instanceof Model ? (Model) renderable : renderable.getModel();
    }
}