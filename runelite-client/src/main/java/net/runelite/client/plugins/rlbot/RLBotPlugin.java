package net.runelite.client.plugins.rlbot;

/**
 * WebSocket Command Schema:
 * {
 *     "action": string,   // Command type: "moveAndClick", "camera_rotate", "camera_zoom"
 *     "data": {
 *         // For action = "moveAndClick":
 *         "targetType": string,  // "coordinates", "npc", "object"
 *         "x": number,          // Required for coordinates and object
 *         "y": number,          // Required for coordinates and object
 *         "npcId": number,      // Required for npc
 *         "name": string,       // Required for object
 *         "action": string,     // "Move", "Attack", "Take", etc.
 *         
 *         // For action = "camera_rotate":
 *         "right": boolean,     // true = rotate right, false = rotate left
 *         
 *         // For action = "camera_zoom":
 *         "in": boolean         // true = zoom in, false = zoom out
 *     }
 * }
 */

import com.google.inject.Provides;
import java.awt.Canvas;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.StatChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.WorldView;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import com.google.gson.Gson;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.coords.LocalPoint;
import java.awt.event.KeyEvent;
import net.runelite.client.game.ItemManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@PluginDescriptor(
    name = "RLBot",
    description = "Plugin for bot control via WebSocket",
    tags = {"bot", "automation"}
)
public class RLBotPlugin extends Plugin {
    private static final java.util.logging.Logger fileLogger = java.util.logging.Logger.getLogger("RLBotPlugin");
    
    // Constants for movement
    private static final int CAMERA_ROTATE_AMOUNT = 45;
    private static final float CAMERA_ZOOM_AMOUNT = 25f;
    private static final int EXPLORATION_CHUNK_SIZE = 8; // Size of each exploration chunk

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private RLBotConfig config;

    @Inject
    private Gson gson;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private RLBotOverlay overlay;

    @Inject
    private ItemManager itemManager;

    private WebSocketServer server;
    private boolean isRunning = false;

    private final Set<Point> visitedChunks = new HashSet<>();
    private final Map<Point, Long> lastVisitTime = new HashMap<>();
    private final Map<Point, AreaInfo> areaAssessments = new HashMap<>();

    private static class AreaInfo {
        int npcDensity;
        int resourceDensity;
        double averageNpcLevel;
        long lastAssessment;

        AreaInfo() {
            this.npcDensity = 0;
            this.resourceDensity = 0;
            this.averageNpcLevel = 0;
            this.lastAssessment = System.currentTimeMillis();
        }
    }

    @Provides
    RLBotConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(RLBotConfig.class);
    }

    @Override
    protected void startUp() {
        try {
            java.nio.file.Path logDir = java.nio.file.Paths.get("rlbot/logs");
            java.nio.file.Files.createDirectories(logDir);
            java.util.logging.FileHandler fileHandler = new java.util.logging.FileHandler(logDir.resolve("rlbot.log").toString(), true);
            fileHandler.setFormatter(new java.util.logging.SimpleFormatter());
            fileLogger.addHandler(fileHandler);
            fileLogger.setLevel(java.util.logging.Level.INFO);
            
            fileLogger.info("Starting RLBot plugin");
            overlayManager.add(overlay);
            startWebSocketServer();
        } catch (Exception e) {
            fileLogger.severe("Error during plugin startup: " + e.getMessage());
        }
    }

    @Override
    protected void shutDown() {
        fileLogger.info("Shutting down RLBot plugin");
        overlayManager.remove(overlay);
        stopWebSocketServer();
    }

    private void startWebSocketServer() {
        server = new WebSocketServer(new InetSocketAddress(config.getPort())) {
            @Override
            public void onOpen(WebSocket conn, ClientHandshake handshake) {
                String msg = "New WebSocket connection established from: " + conn.getRemoteSocketAddress();
                fileLogger.info(msg);
            }

            @Override
            public void onClose(WebSocket conn, int code, String reason, boolean remote) {
                String msg = "WebSocket connection closed: " + reason;
                fileLogger.info(msg);
            }

            @Override
            public void onMessage(WebSocket conn, String message) {
                fileLogger.info("Received message from " + conn.getRemoteSocketAddress() + ": " + message);
                try {
                    Map<String, Object> data = gson.fromJson(message, Map.class);
                    String action = (String) data.get("action");
                    Map<String, Object> actionData = (Map<String, Object>) data.get("data");
                    
                    if (action == null || actionData == null) {
                        throw new IllegalArgumentException("Invalid message format: missing action or data");
                    }
                    
                    switch (action) {
                        case "moveAndClick":
                            handleMoveAndClick(actionData);
                            break;
                        case "camera_rotate":
                            handleCameraRotate(actionData);
                            break;
                        case "camera_zoom":
                            handleCameraZoom(actionData);
                            break;
                        default:
                            String msg = "Unknown action: " + action;
                            fileLogger.warning(msg);
                    }
                } catch (Exception e) {
                    String msg = "Error handling message: " + e.getMessage();
                    fileLogger.severe(msg);
                }
            }

            @Override
            public void onError(WebSocket conn, Exception ex) {
                String msg = "WebSocket error: " + ex.getMessage();
                fileLogger.severe(msg);
            }

            @Override
            public void onStart() {
                String msg = "WebSocket server started on port " + config.getPort();
                fileLogger.info(msg);
                isRunning = true;
            }
        };

        try {
            // Set connection timeout
            server.setConnectionLostTimeout(30);
            // Start the server in a separate thread
            Thread serverThread = new Thread(() -> {
                try {
                    server.run();
                } catch (Exception e) {
                    String msg = "WebSocket server error: " + e.getMessage();
                    fileLogger.severe(msg);
                    isRunning = false;
                }
            });
            serverThread.setDaemon(true);
            serverThread.start();
            
            // Wait for server to start with proper timeout
            if (!waitForServerStart()) {
                String msg = "Failed to start WebSocket server after timeout";
                fileLogger.severe(msg);
                throw new RuntimeException(msg);
            }
            
            String msg = "WebSocket server successfully started and listening on port " + config.getPort();
            fileLogger.info(msg);
        } catch (Exception e) {
            String msg = "Failed to start WebSocket server: " + e.getMessage();
            fileLogger.severe(msg);
            isRunning = false;
            throw new RuntimeException(msg, e);
        }
    }

    private boolean waitForServerStart() {
        long startTime = System.currentTimeMillis();
        long timeout = TimeUnit.SECONDS.toMillis(10); // 10 second timeout
        
        while (!isRunning && System.currentTimeMillis() - startTime < timeout) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        
        return isRunning;
    }

    private void stopWebSocketServer() {
        if (server != null && isRunning) {
            try {
                server.stop(1000); // Wait up to 1 second for clean shutdown
                isRunning = false;
                fileLogger.info("WebSocket server stopped");
            } catch (InterruptedException e) {
                fileLogger.severe("Error stopping WebSocket server: " + e.getMessage());
            }
        }
    }

    private boolean isObstructed(WorldPoint target) {
        if (client.getLocalPlayer() == null) {
            return true;
        }

        // Get WorldView and check it's not null
        WorldView worldView = client.getTopLevelWorldView();
        if (worldView == null) {
            return true;
        }

        // Get scene and collision maps from WorldView
        Scene scene = worldView.getScene();
        CollisionData[] collisionMaps = worldView.getCollisionMaps();
        int z = target.getPlane();
        
        if (collisionMaps == null || z >= collisionMaps.length) {
            return true;
        }
        
        CollisionData collisionData = collisionMaps[z];
        if (collisionData == null) {
            return true;
        }
        
        // Get scene coordinates
        int sceneX = target.getX() - scene.getBaseX();
        int sceneY = target.getY() - scene.getBaseY();
        
        // Check if coordinates are within bounds
        if (sceneX < 0 || sceneY < 0 || sceneX >= 104 || sceneY >= 104) {
            return true;
        }

        // Check collision flag at target location
        int[][] flags = collisionData.getFlags();
        if (flags == null) {
            return true;
        }
        
        int flag = flags[sceneX][sceneY];
        boolean blocked = (flag & CollisionDataFlag.BLOCK_MOVEMENT_FULL) != 0;
        
        // Check for game objects (trees, doors, etc.)
        Tile targetTile = scene.getTiles()[z][sceneX][sceneY];
        if (targetTile != null) {
            GameObject[] objects = targetTile.getGameObjects();
            if (objects != null) {
                for (GameObject obj : objects) {
                    if (obj != null && isBlockingObject(obj)) {
                        blocked = true;
                        break;
                    }
                }
            }
        }

        return blocked;
    }

    private boolean isBlockingObject(GameObject obj) {
        // List of object IDs that should be considered blocking
        // This list should be expanded based on your needs
        int[] blockingObjects = {
            // Doors
            1519, 1516, 1517, 1520,  // Various door types
            // Trees
            1278, 1276, 1277, 1280,  // Various tree types
            // Walls
            1551, 1552, 1553,        // Various wall types
            // Gates
            1558, 1559, 1560         // Various gate types
        };

        int objId = obj.getId();
        for (int blockingId : blockingObjects) {
            if (objId == blockingId) {
                return true;
            }
        }

        // Check object actions for keywords that suggest it's blocking
        ObjectComposition objComp = client.getObjectDefinition(objId);
        if (objComp != null) {
            String[] actions = objComp.getActions();
            if (actions != null) {
                for (String action : actions) {
                    if (action != null && (
                        action.toLowerCase().contains("open") ||
                        action.toLowerCase().contains("close") ||
                        action.toLowerCase().contains("climb") ||
                        action.toLowerCase().contains("push") ||
                        action.toLowerCase().contains("use")
                    )) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isInterfaceOpen() {
        Widget[] widgets = client.getWidgetRoots();
        if (widgets == null) {
            return false;
        }

        // Check for common interfaces that should be closed
        int[] interfaceGroups = {
            WidgetID.INVENTORY_GROUP_ID,
            WidgetID.SKILLS_GROUP_ID,
            WidgetID.QUESTLIST_GROUP_ID,
            WidgetID.EQUIPMENT_GROUP_ID,
            WidgetID.PRAYER_GROUP_ID,
            WidgetID.SPELLBOOK_GROUP_ID,
            WidgetID.BANK_GROUP_ID,
            WidgetID.GRAND_EXCHANGE_GROUP_ID
        };

        for (Widget widget : widgets) {
            if (widget == null) continue;
            
            int groupId = widget.getId() >> 16;
            for (int targetGroup : interfaceGroups) {
                if (groupId == targetGroup && !widget.isHidden()) {
                    return true;
                }
            }
        }

        return false;
    }

    private void closeInterfaces() {
        // Press ESC key to close interfaces
        clientThread.invoke(() -> {
            // Use raw script ID for closing modal
            client.runScript(2622);
            
            // Create and dispatch key events
            KeyEvent escPressed = new KeyEvent(client.getCanvas(), KeyEvent.KEY_PRESSED, 
                System.currentTimeMillis(), 0, KeyEvent.VK_ESCAPE, KeyEvent.CHAR_UNDEFINED);
            KeyEvent escReleased = new KeyEvent(client.getCanvas(), KeyEvent.KEY_RELEASED,
                System.currentTimeMillis(), 0, KeyEvent.VK_ESCAPE, KeyEvent.CHAR_UNDEFINED);

            client.getCanvas().dispatchEvent(escPressed);
            client.getCanvas().dispatchEvent(escReleased);
        });
    }

    private void handleMoveAndClick(Map<String, Object> data) {
        try {
            fileLogger.info("=== Starting click action ===");
            fileLogger.info("Received click data: " + gson.toJson(data));

            // Get target coordinates or object
            Point target;
            final String targetType = (String) data.get("targetType");
            final String action = (String) data.getOrDefault("action", "Click");
            
            fileLogger.info(String.format("Processing %s action on %s", action, targetType));
            
            // Determine target point based on target type
            switch (targetType) {
                case "coordinates":
                    int x = ((Number) data.get("x")).intValue();
                    int y = ((Number) data.get("y")).intValue();
                    WorldPoint worldPoint = new WorldPoint(x, y, client.getPlane());
                    fileLogger.info(String.format("Walking to coordinates: (%d, %d) on plane %d", x, y, client.getPlane()));
                    target = worldToCanvas(worldPoint);
                    break;
                    
                case "npc":
                    int npcId = ((Number) data.get("npcId")).intValue();
                    fileLogger.info("Looking for NPC with ID: " + npcId);
                    NPC npc = findNPCById(npcId);
                    if (npc == null) {
                        fileLogger.warning("NPC not found: " + npcId);
                        return;
                    }
                    fileLogger.info(String.format("Found NPC: %s (level %d) at %s", 
                        npc.getName(), npc.getCombatLevel(), npc.getWorldLocation()));
                    target = worldToCanvas(npc.getWorldLocation());
                    break;
                    
                case "object":
                    String objectName = (String) data.get("name");
                    WorldPoint location = new WorldPoint(
                        ((Number) data.get("x")).intValue(),
                        ((Number) data.get("y")).intValue(),
                        client.getPlane()
                    );
                    fileLogger.info(String.format("Looking for object '%s' at %s", objectName, location));
                    GameObject obj = findGameObject(location, objectName);
                    if (obj == null) {
                        fileLogger.warning("Object not found: " + objectName + " at " + location);
                        return;
                    }
                    fileLogger.info(String.format("Found object: %s (ID: %d) at %s", 
                        objectName, obj.getId(), obj.getWorldLocation()));
                    target = worldToCanvas(obj.getWorldLocation());
                    break;
                    
                default:
                    fileLogger.warning("Unknown target type: " + targetType);
                    return;
            }

            if (target == null) {
                fileLogger.warning("Failed to get target point - target is off screen or invalid");
                return;
            }
            fileLogger.info(String.format("Converted world location to canvas point: %s", target));

            // Check if point is off screen or blocked by interface
            if (isInterfaceOverlapping(target)) {
                fileLogger.warning("Click location blocked by interface");
                fileLogger.info("Attempting to close interfaces...");
                closeInterfaces();
                return;
            }

            // Execute click sequence on client thread
            clientThread.invoke(() -> {
                try {
                    // Get canvas and ensure it's available
                    Canvas canvas = client.getCanvas();
                    if (canvas == null) {
                        fileLogger.warning("Canvas is null");
                        return;
                    }

                    // Move cursor to target location
                    MouseEvent moved = new MouseEvent(
                        canvas,
                        MouseEvent.MOUSE_MOVED,
                        System.currentTimeMillis(),
                        0,
                        (int)target.getX(),
                        (int)target.getY(),
                        0,
                        false,
                        MouseEvent.NOBUTTON
                    );
                    canvas.dispatchEvent(moved);

                    // Press mouse
                    MouseEvent pressed = new MouseEvent(
                        canvas,
                        MouseEvent.MOUSE_PRESSED,
                        System.currentTimeMillis(),
                        0,
                        (int)target.getX(),
                        (int)target.getY(),
                        1,
                        false,
                        MouseEvent.BUTTON1
                    );
                    canvas.dispatchEvent(pressed);

                    // Release mouse
                    MouseEvent released = new MouseEvent(
                        canvas,
                        MouseEvent.MOUSE_RELEASED,
                        System.currentTimeMillis(),
                        0,
                        (int)target.getX(),
                        (int)target.getY(),
                        1,
                        false,
                        MouseEvent.BUTTON1
                    );
                    canvas.dispatchEvent(released);

                    // Click mouse
                    MouseEvent clicked = new MouseEvent(
                        canvas,
                        MouseEvent.MOUSE_CLICKED,
                        System.currentTimeMillis(),
                        0,
                        (int)target.getX(),
                        (int)target.getY(),
                        1,
                        false,
                        MouseEvent.BUTTON1
                    );
                    canvas.dispatchEvent(clicked);

                    // Log action
                    fileLogger.info(String.format("Executed click at %s", target));
                } catch (Exception e) {
                    fileLogger.severe("Error executing click sequence: " + e.getMessage());
                }
            });
            
            fileLogger.info("=== Click action completed ===\n");
            
        } catch (Exception e) {
            String msg = "Error in handleMoveAndClick: " + e.getMessage();
            fileLogger.severe(msg);
            e.printStackTrace(new java.io.PrintWriter(new java.io.StringWriter()) {
                @Override
                public void println(Object x) {
                    fileLogger.severe(String.valueOf(x));
                }
            });
        }
    }

    private NPC findNPCById(int id) {
        return client.getNpcs().stream()
            .filter(npc -> npc.getId() == id)
            .findFirst()
            .orElse(null);
    }

    private Point worldToCanvas(WorldPoint worldPoint) {
        if (client.getGameState() != GameState.LOGGED_IN) {
            fileLogger.warning("Cannot convert coordinates - client not logged in");
            return null;
        }

        LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);
        if (localPoint == null) {
            fileLogger.warning("Cannot convert world point to local: " + worldPoint);
            return null;
        }

        net.runelite.api.Point canvasPoint = Perspective.localToCanvas(client, localPoint, client.getPlane());
        if (canvasPoint == null) {
            fileLogger.warning("Cannot convert local point to canvas: " + localPoint);
            return null;
        }

        fileLogger.info(String.format("Converting coordinates: World(%s) -> Local(%s) -> Canvas(%s)", 
            worldPoint, localPoint, canvasPoint));

        // Get client dimensions
        int canvasX = canvasPoint.getX();
        int canvasY = canvasPoint.getY();

        // Apply scaling if the client is stretched
        if (client.isStretchedEnabled()) {
            // Get stretched dimensions
            Dimension stretched = client.getStretchedDimensions();
            Dimension real = client.getRealDimensions();
            float width = (float) (stretched.width / real.getWidth());
            float height = (float) (stretched.height / real.getHeight());

            // Apply scaling
            int oldX = canvasX;
            int oldY = canvasY;
            canvasX = Math.round(canvasX * width);
            canvasY = Math.round(canvasY * height);
            fileLogger.info(String.format("Applied scaling: (%d,%d) -> (%d,%d) [scale: %.2f,%.2f]", 
                oldX, oldY, canvasX, canvasY, width, height));
        }

        // Ensure point is within canvas bounds
        Canvas canvas = client.getCanvas();
        if (canvas != null) {
            int oldX = canvasX;
            int oldY = canvasY;
            canvasX = Math.min(Math.max(canvasX, 0), canvas.getWidth());
            canvasY = Math.min(Math.max(canvasY, 0), canvas.getHeight());
            if (oldX != canvasX || oldY != canvasY) {
                fileLogger.info(String.format("Adjusted point to stay within bounds: (%d,%d) -> (%d,%d)", 
                    oldX, oldY, canvasX, canvasY));
            }
        }

        return new Point(canvasX, canvasY);
    }

    private GameObject findGameObject(WorldPoint location, String name) {
        Tile tile = client.getScene().getTiles()[client.getPlane()][location.getX()][location.getY()];
        if (tile != null) {
            return Arrays.stream(tile.getGameObjects())
                .filter(obj -> obj != null && 
                    obj.getRenderable() != null)
                .filter(obj -> {
                    ObjectComposition def = client.getObjectDefinition(obj.getId());
                    return def != null && def.getName().equalsIgnoreCase(name);
                })
                .findFirst()
                .orElse(null);
        }
        return null;
    }

    private void handleCameraRotate(Map<String, Object> data) {
        boolean right = (boolean) data.get("right");
        int amount = right ? CAMERA_ROTATE_AMOUNT : -CAMERA_ROTATE_AMOUNT;
        
        clientThread.invoke(() -> {
            try {
                client.setCameraYawTarget(client.getCameraYaw() + amount);
            } catch (Exception e) {
                fileLogger.severe("Error rotating camera: " + e.getMessage());
            }
        });
    }

    private void handleCameraZoom(Map<String, Object> data) {
        boolean zoomIn = (boolean) data.get("in");
        float amount = zoomIn ? -CAMERA_ZOOM_AMOUNT : CAMERA_ZOOM_AMOUNT;
        
        clientThread.invoke(() -> {
            try {
                int currentZoom = client.getVarcIntValue(VarClientInt.CAMERA_ZOOM_RESIZABLE_VIEWPORT);
                int newZoom = currentZoom + (int)amount;
                // Use raw script ID for camera zoom
                client.runScript(42, newZoom, newZoom);
            } catch (Exception e) {
                fileLogger.severe("Error zooming camera: " + e.getMessage());
            }
        });
    }

    private Point worldToChunk(WorldPoint point) {
        return new Point(
            point.getX() / EXPLORATION_CHUNK_SIZE,
            point.getY() / EXPLORATION_CHUNK_SIZE
        );
    }

    private void updateExplorationData() {
        if (client.getLocalPlayer() == null) return;

        WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
        Point chunk = worldToChunk(playerLocation);
        
        // Track visited chunk
        if (visitedChunks.add(chunk)) {
            // New chunk discovered
            overlay.addReward(5.0, "New area discovered!");
        }

        // Update visit time
        lastVisitTime.put(chunk, System.currentTimeMillis());

        // Assess area every 10 seconds
        AreaInfo info = areaAssessments.computeIfAbsent(chunk, k -> new AreaInfo());
        if (System.currentTimeMillis() - info.lastAssessment > 10000) {
            assessArea(chunk, info);
        }
    }

    private void assessArea(Point chunk, AreaInfo info) {
        // Count NPCs and calculate average level
        List<NPC> nearbyNpcs = client.getNpcs().stream()
            .filter(npc -> worldToChunk(npc.getWorldLocation()).equals(chunk))
            .collect(Collectors.toList());

        info.npcDensity = nearbyNpcs.size();
        info.averageNpcLevel = nearbyNpcs.stream()
            .mapToInt(NPC::getCombatLevel)
            .average()
            .orElse(0);

        // Count resource objects (trees, rocks, etc.)
        info.resourceDensity = (int) Arrays.stream(client.getScene().getTiles()[client.getPlane()])
            .flatMap(row -> row == null ? Stream.empty() : Arrays.stream(row))
            .filter(Objects::nonNull)
            .filter(tile -> worldToChunk(tile.getWorldLocation()).equals(chunk))
            .map(Tile::getGameObjects)
            .filter(Objects::nonNull)
            .flatMap(Arrays::stream)
            .filter(Objects::nonNull)
            .filter(this::isResource)
            .count();

        info.lastAssessment = System.currentTimeMillis();

        // Add rewards based on area quality
        double areaScore = calculateAreaScore(info);
        if (areaScore > 0.7) {
            overlay.addReward(10.0, "High-value area discovered!");
        } else if (areaScore > 0.4) {
            overlay.addReward(5.0, "Decent area discovered!");
        }
    }

    private boolean isResource(GameObject obj) {
        if (obj == null) return false;
        ObjectComposition def = client.getObjectDefinition(obj.getId());
        if (def == null) return false;

        String name = def.getName().toLowerCase();
        return name.contains("tree") || 
               name.contains("rock") || 
               name.contains("ore") ||
               name.contains("fishing spot");
    }

    private double calculateAreaScore(AreaInfo info) {
        // Normalize each factor to 0-1 range
        double npcScore = Math.min(info.npcDensity / 10.0, 1.0) * 0.4;
        double levelScore = Math.min(info.averageNpcLevel / 100.0, 1.0) * 0.3;
        double resourceScore = Math.min(info.resourceDensity / 5.0, 1.0) * 0.3;

        return npcScore + levelScore + resourceScore;
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        if (!isRunning || server == null) {
            return;
        }

        // Update exploration data
        updateExplorationData();

        // Broadcast game state to connected clients
        try {
            String gameState = createGameState();
            for (WebSocket conn : server.getConnections()) {
                conn.send(gameState);
            }
        } catch (Exception e) {
            fileLogger.severe("Error broadcasting game state: " + e.getMessage());
        }
    }

    @Subscribe
    public void onStatChanged(StatChanged statChanged) {
        if (!isRunning) {
            return;
        }

        // Update overlay for combat skill changes
        Skill skill = statChanged.getSkill();
        if (skill == Skill.ATTACK || skill == Skill.STRENGTH || 
            skill == Skill.DEFENCE || skill == Skill.RANGED || 
            skill == Skill.MAGIC || skill == Skill.HITPOINTS) {
            clientThread.invoke(() -> {
                try {
                    overlay.updateExperienceGained();
                } catch (Exception e) {
                    fileLogger.severe("Error updating experience in overlay: " + e.getMessage());
                }
            });
        }
    }

    private String createGameState() {
        Map<String, Object> state = new HashMap<>();
        
        if (client.getLocalPlayer() != null) {
            // Player location and basic stats
            WorldPoint loc = client.getLocalPlayer().getWorldLocation();
            Map<String, Integer> playerLocation = new HashMap<>();
            playerLocation.put("x", loc.getX());
            playerLocation.put("y", loc.getY());
            playerLocation.put("plane", loc.getPlane());
            state.put("playerLocation", playerLocation);
            
            // Player stats
            state.put("playerHealth", client.getBoostedSkillLevel(Skill.HITPOINTS));
            state.put("playerMaxHealth", client.getRealSkillLevel(Skill.HITPOINTS));
            state.put("playerAnimation", client.getLocalPlayer().getAnimation());
            state.put("inCombat", client.getLocalPlayer().getInteracting() != null);
            state.put("playerRunEnergy", client.getEnergy());
            
            // Combat stats
            Map<String, Map<String, Integer>> skills = new HashMap<>();
            for (Skill skill : Skill.values()) {
                Map<String, Integer> skillData = new HashMap<>();
                skillData.put("level", client.getBoostedSkillLevel(skill));
                skillData.put("realLevel", client.getRealSkillLevel(skill));
                skillData.put("experience", client.getSkillExperience(skill));
                skills.put(skill.getName(), skillData);
            }
            state.put("skills", skills);
            
            // NPCs
            List<Map<String, Object>> npcs = new ArrayList<>();
            for (NPC npc : client.getNpcs()) {
                if (npc == null) continue;
                
                Map<String, Object> npcData = new HashMap<>();
                WorldPoint npcLoc = npc.getWorldLocation();
                npcData.put("id", npc.getId());
                npcData.put("name", npc.getName());
                npcData.put("combatLevel", npc.getCombatLevel());
                npcData.put("animation", npc.getAnimation());
                npcData.put("interacting", npc.getInteracting() != null);
                
                Map<String, Integer> location = new HashMap<>();
                location.put("x", npcLoc.getX());
                location.put("y", npcLoc.getY());
                location.put("plane", npcLoc.getPlane());
                npcData.put("location", location);
                
                npcs.add(npcData);
            }
            state.put("npcs", npcs);
            
            // Ground items
            List<Map<String, Object>> groundItems = new ArrayList<>();
            Scene scene = client.getScene();
            Tile[][][] tiles = scene.getTiles();
            for (int z = 0; z < tiles.length; z++) {
                for (int x = 0; x < tiles[z].length; x++) {
                    for (int y = 0; y < tiles[z][x].length; y++) {
                        Tile tile = tiles[z][x][y];
                        if (tile == null) continue;
                        
                        List<TileItem> items = tile.getGroundItems();
                        if (items == null) continue;
                        
                        for (TileItem item : items) {
                            if (item == null) continue;
                            
                            ItemComposition itemComp = itemManager.getItemComposition(item.getId());
                            WorldPoint itemLoc = tile.getWorldLocation();
                            Map<String, Object> itemData = new HashMap<>();
                            itemData.put("id", item.getId());
                            itemData.put("name", itemComp.getName());
                            itemData.put("quantity", item.getQuantity());
                            itemData.put("gePrice", itemComp.getPrice());
                            itemData.put("haPrice", itemComp.getHaPrice());
                            
                            Map<String, Integer> location = new HashMap<>();
                            location.put("x", itemLoc.getX());
                            location.put("y", itemLoc.getY());
                            location.put("plane", itemLoc.getPlane());
                            itemData.put("location", location);
                            
                            // Calculate distance to player
                            double distance = Math.sqrt(
                                Math.pow(loc.getX() - itemLoc.getX(), 2) +
                                Math.pow(loc.getY() - itemLoc.getY(), 2)
                            );
                            itemData.put("distance", distance);
                            
                            groundItems.add(itemData);
                        }
                    }
                }
            }
            state.put("groundItems", groundItems);
            
            // Interface state
            state.put("interfacesOpen", isInterfaceOpen());
            
            // Path obstruction
            state.put("pathObstructed", isObstructed(client.getLocalPlayer().getWorldLocation()));
        }
        
        try {
            return gson.toJson(state);
        } catch (Exception e) {
            fileLogger.severe("Error converting game state to JSON: " + e.getMessage());
            return "{}";  // Return empty JSON object on error
        }
    }

    private boolean isInterfaceOverlapping(Point point) {
        Widget[] widgets = client.getWidgetRoots();
        if (widgets == null) {
            return false;
        }

        // Check inventory specifically
        for (Widget widget : widgets) {
            if (widget == null) continue;
            
            if ((widget.getId() >> 16) == WidgetID.INVENTORY_GROUP_ID && !widget.isHidden() && widget.getBounds().contains(point)) {
                fileLogger.info("Click blocked by inventory interface");
                return true;
            }
        }

        // Check all visible widgets
        for (Widget widget : widgets) {
            if (widget == null || widget.isHidden()) continue;
            
            // Skip non-blocking widgets like minimap, combat overlay, etc.
            if (isNonBlockingWidget(widget)) continue;
            
            if (widget.getBounds().contains(point)) {
                fileLogger.info("Click blocked by interface: " + widget.getName());
                return true;
            }
        }
        return false;
    }

    private boolean isNonBlockingWidget(Widget widget) {
        // List of widget group IDs that should not block clicks
        int[] nonBlockingGroups = {
            WidgetID.MINIMAP_GROUP_ID,
            WidgetID.COMBAT_GROUP_ID,
            WidgetID.FIXED_VIEWPORT_GROUP_ID,
            WidgetID.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX_GROUP_ID,
            WidgetID.RESIZABLE_VIEWPORT_BOTTOM_LINE_GROUP_ID
        };

        int groupId = widget.getId() >> 16;
        for (int nonBlockingGroup : nonBlockingGroups) {
            if (groupId == nonBlockingGroup) {
                return true;
            }
        }
        return false;
    }
} 