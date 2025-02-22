package net.runelite.client.plugins.rlbot;

import com.google.inject.Provides;
import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;
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
import net.runelite.api.events.GameStateChanged;
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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import java.awt.MouseInfo;
import javax.swing.SwingUtilities;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import net.runelite.api.VarClientInt;
import net.runelite.api.ScriptID;
import net.runelite.api.TileItem;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.file.StandardOpenOption;

@PluginDescriptor(
    name = "RLBot",
    description = "RuneLite Bot Plugin for AI Training",
    tags = {"bot", "ai", "training"}
)
public class RLBotPlugin extends Plugin {
    private static final String LOG_FILE = "/Users/danielgleason/Desktop/Code/my_code/runescape_bot_runelite/rlbot/logs/rlbot.log";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    
    private void log(String level, String message) {
        try {
            String logEntry = String.format("%s [%s] %s%n", 
                LocalDateTime.now().format(DATE_FORMAT), 
                level, 
                message);
            Files.write(Paths.get(LOG_FILE), 
                       logEntry.getBytes(), 
                       StandardOpenOption.CREATE, 
                       StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logInfo(String message) {
        log("INFO", message);
    }

    private void logError(String message) {
        log("ERROR", message);
    }

    private void logDebug(String message) {
        log("DEBUG", message);
    }

    private void logWarn(String message) {
        log("WARN", message);
    }

    // Constants for movement
    private static final int CAMERA_ROTATE_AMOUNT = 45;
    private static final float CAMERA_ZOOM_AMOUNT = 25f;
    private static final int EXPLORATION_CHUNK_SIZE = 8; // Size of each exploration chunk
    private static final int MOUSE_LERP_STEPS = 10;
    private static final long MOUSE_MOVE_TIME = 150;

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private RLBotConfig config;

    @Inject
    private ObjectMapper objectMapper;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private RLBotOverlay overlay;

    @Inject
    private ItemManager itemManager;

    private WebSocketServer server;
    private boolean isRunning = false;
    private JsonNode commandSchema;
    private JsonNode stateSchema;

    private final Set<Point> visitedChunks = new HashSet<>();
    private final Map<Point, Long> lastVisitTime = new HashMap<>();
    private final Map<Point, AreaInfo> areaAssessments = new HashMap<>();

    // Add tracking variables for health changes
    private int lastHealth = -1;
    private int lastMaxHealth = -1;

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
            // Load schemas
            String commandSchemaPath = "/Users/danielgleason/Desktop/Code/my_code/runescape_bot_runelite/rlbot/command_schema.json";
            String stateSchemaPath = "/Users/danielgleason/Desktop/Code/my_code/runescape_bot_runelite/rlbot/state_schema.json";
            logInfo("Command schema path: " + commandSchemaPath);
            logInfo("State schema path: " + stateSchemaPath);
            
            String commandSchemaStr = Files.readString(Path.of(commandSchemaPath));
            String stateSchemaStr = Files.readString(Path.of(stateSchemaPath));

            commandSchema = objectMapper.readTree(commandSchemaStr);
            stateSchema = objectMapper.readTree(stateSchemaStr);

            // Set up logging
            java.nio.file.Path logDir = java.nio.file.Paths.get("/Users/danielgleason/Desktop/Code/my_code/runescape_bot_runelite/rlbot/logs");
            Files.createDirectories(logDir);
            java.nio.file.Path logFile = logDir.resolve("rlbot.log");
            
            logInfo("Starting RLBot plugin...");
            
            // Start WebSocket server
            startWebSocketServer();
            
            // Verify server is running
            if (server == null) {
                logError("WebSocket server failed to start properly");
                return;
            }
            
            isRunning = true;
            overlayManager.add(overlay);
            logInfo("RLBot plugin started successfully");
            
        } catch (Exception e) {
            logError("Error during plugin startup: " + e.getMessage());
        }
    }

    @Override
    protected void shutDown() {
        logInfo("Shutting down RLBot plugin");
        stopWebSocketServer();
        isRunning = false;
        overlayManager.remove(overlay);
    }

    private void startWebSocketServer() {
        if (server != null) {
            logInfo("WebSocket server already running");
            return;
        }

        try {
            int port = config.getPort();
            logInfo("Starting WebSocket server on port " + port);
            
            server = new WebSocketServer(new InetSocketAddress(port)) {
                @Override
                public void onOpen(WebSocket conn, ClientHandshake handshake) {
                    logInfo("New WebSocket connection established from: " + conn.getRemoteSocketAddress());
                }

                @Override
                public void onClose(WebSocket conn, int code, String reason, boolean remote) {
                    logInfo("WebSocket connection closed: " + reason);
                }

                @Override
                public void onMessage(WebSocket conn, String message) {
                    logInfo("Received message from " + conn.getRemoteSocketAddress() + ": " + message);
                    validateAndProcessCommand(message);
                }

                @Override
                public void onError(WebSocket conn, Exception ex) {
                    logError("WebSocket error: " + ex.getMessage());
                }

                @Override
                public void onStart() {
                    logInfo("WebSocket server started successfully on port " + getPort());
                }
            };

            server.setReuseAddr(true); // Allow port reuse
            server.start();
            logInfo("WebSocket server initialization completed. Waiting for connections on port " + port);
        } catch (Exception e) {
            logError("Error starting WebSocket server: " + e.getMessage());
            if (server != null) {
                try {
                    server.stop();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    logError("Interrupted while stopping WebSocket server");
                }
                server = null;
            }
        }
    }

    private void stopWebSocketServer() {
        if (server == null) return;

        try {
            server.stop();
            logInfo("WebSocket server stopped");
        } catch (InterruptedException e) {
            logError("Error stopping server: " + e.getMessage());
        }
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        if (!isRunning || server == null) return;

        try {
            JsonNode gameState = generateGameState();
            validateGameState(gameState);
            
            // Debug log the state
            logDebug("Generated game state: " + gameState.toString());
            
            // Send state to connected clients
            for (WebSocket conn : server.getConnections()) {
                if (conn.isOpen()) {
                    conn.send(objectMapper.writeValueAsString(gameState));
                }
            }
        } catch (Exception e) {
            logError("Error processing game tick: " + e.getMessage());
        }
    }

    private void validateCommand(JsonNode command) throws IllegalArgumentException {
        if (!command.has("action")) {
            throw new IllegalArgumentException("Command must have an 'action' field");
        }
        if (!command.has("data")) {
            throw new IllegalArgumentException("Command must have a 'data' field");
        }

        String action = command.get("action").asText();
        JsonNode data = command.get("data");

        switch (action) {
            case "moveAndClick":
                validateMoveAndClick(data);
                break;
            case "camera_rotate":
                validateCameraRotate(data);
                break;
            case "camera_zoom":
                validateCameraZoom(data);
                break;
            default:
                throw new IllegalArgumentException("Unknown action: " + action);
        }
    }

    private void validateMoveAndClick(JsonNode data) throws IllegalArgumentException {
        if (!data.has("targetType")) {
            throw new IllegalArgumentException("moveAndClick command must have a 'targetType' field");
        }
        if (!data.has("action")) {
            throw new IllegalArgumentException("moveAndClick command must have an 'action' field");
        }

        String targetType = data.get("targetType").asText();
        String action = data.get("action").asText();

        switch (targetType) {
            case "npc":
                if (!data.has("npcId")) {
                    throw new IllegalArgumentException("npc target must have an 'npcId' field");
                }
                if (!"Attack".equals(action)) {
                    throw new IllegalArgumentException("npc target must have 'Attack' action");
                }
                break;
            case "coordinates":
                if (!data.has("x") || !data.has("y")) {
                    throw new IllegalArgumentException("coordinates target must have 'x' and 'y' fields");
                }
                if (!"Move".equals(action)) {
                    throw new IllegalArgumentException("coordinates target must have 'Move' action");
                }
                break;
            case "ground_item":
                if (!data.has("name") || !data.has("x") || !data.has("y")) {
                    throw new IllegalArgumentException("ground_item target must have 'name', 'x', and 'y' fields");
                }
                if (!"Take".equals(action)) {
                    throw new IllegalArgumentException("ground_item target must have 'Take' action");
                }
                break;
            case "object":
                if (!data.has("objectId") || !data.has("x") || !data.has("y")) {
                    throw new IllegalArgumentException("object target must have 'objectId', 'x', and 'y' fields");
                }
                if (!"Use".equals(action)) {
                    throw new IllegalArgumentException("object target must have 'Use' action");
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown targetType: " + targetType);
        }
    }

    private void validateCameraRotate(JsonNode data) throws IllegalArgumentException {
        if (!data.has("right")) {
            throw new IllegalArgumentException("camera_rotate command must have a 'right' field");
        }
    }

    private void validateCameraZoom(JsonNode data) throws IllegalArgumentException {
        if (!data.has("in")) {
            throw new IllegalArgumentException("camera_zoom command must have an 'in' field");
        }
    }

    private void validateGameState(JsonNode state) throws IllegalArgumentException {
        if (!state.has("player")) {
            throw new IllegalArgumentException("Game state must have a 'player' field");
        }
        if (!state.has("npcs")) {
            throw new IllegalArgumentException("Game state must have an 'npcs' field");
        }
        if (!state.has("objects")) {
            throw new IllegalArgumentException("Game state must have an 'objects' field");
        }
        if (!state.has("groundItems")) {
            throw new IllegalArgumentException("Game state must have a 'groundItems' field");
        }

        JsonNode player = state.get("player");
        if (!player.has("location") || !player.has("health") || !player.has("inCombat") || !player.has("runEnergy") || !player.has("skills")) {
            throw new IllegalArgumentException("Player state must have 'location', 'health', 'inCombat', 'runEnergy', and 'skills' fields");
        }
    }

    private void validateAndProcessCommand(String message) {
        try {
            JsonNode command = objectMapper.readTree(message);
            logDebug("Received command: " + command.toString());
            validateCommand(command);
            
            // Process command based on action type
            String action = command.get("action").asText();
            JsonNode data = command.get("data");
            
            // Only log at info level for important actions
            if (action.equals("moveAndClick")) {
                logInfo(String.format("Processing moveAndClick - Target: %s, Action: %s", 
                    data.get("targetType").asText(), 
                    data.get("action").asText()));
            } else {
                logDebug(String.format("Processing command - Action: %s, Data: %s", action, data));
            }
            
            switch (action) {
                case "moveAndClick":
                    handleMoveAndClick(data);
                    break;
                case "camera_rotate":
                    handleCameraRotate(data);
                    break;
                case "camera_zoom":
                    handleCameraZoom(data);
                    break;
                default:
                    logWarn("Unknown action type: " + action);
            }
        } catch (Exception e) {
            logError("Error validating/processing command: " + e.getMessage());
        }
    }

    private void handleMoveAndClick(JsonNode data) {
        clientThread.invoke(() -> {
            try {
                Point target = null;
                String targetType = data.get("targetType").asText();
                
                switch (targetType) {
                    case "npc":
                        int npcId = data.get("npcId").asInt();
                        NPC npc = findNPCById(npcId);
                        if (npc != null) {
                            target = worldToCanvas(npc.getWorldLocation());
                        }
                        break;
                        
                    case "coordinates":
                        int x = data.get("x").asInt();
                        int y = data.get("y").asInt();
                        target = worldToCanvas(new WorldPoint(x, y, client.getPlane()));
                        break;
                        
                    case "object":
                        int objectId = data.get("objectId").asInt();
                        x = data.get("x").asInt();
                        y = data.get("y").asInt();
                        WorldPoint objLocation = new WorldPoint(x, y, client.getPlane());
                        GameObject targetObj = findGameObject(objectId, objLocation);
                        if (targetObj != null) {
                            target = worldToCanvas(targetObj.getWorldLocation());
                        }
                        break;
                        
                    case "ground_item":
                        String itemName = data.get("name").asText();
                        x = data.get("x").asInt();
                        y = data.get("y").asInt();
                        WorldPoint itemLocation = new WorldPoint(x, y, client.getPlane());
                        TileItem groundItem = findGroundItem(itemName, itemLocation);
                        if (groundItem != null) {
                            target = worldToCanvas(itemLocation);
                        }
                        break;
                }
                
                if (target != null) {
                    smoothMouseMove(target);
                }
            } catch (Exception e) {
                logError("Error in handleMoveAndClick: " + e.getMessage());
            }
        });
    }

    private void smoothMouseMove(Point target) {
        try {
            Canvas canvas = client.getCanvas();
            if (canvas == null) {
                logError("Canvas is null, cannot move mouse");
                return;
            }

            Point currentMouse = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(currentMouse, canvas);
            
            logDebug(String.format("Moving mouse from (%d, %d) to (%d, %d)", 
                currentMouse.x, currentMouse.y, target.x, target.y));
            
            // Remove intermediate step logging
            long stepDelay = MOUSE_MOVE_TIME / MOUSE_LERP_STEPS;
            
            for (int i = 1; i <= MOUSE_LERP_STEPS; i++) {
                float t = (float)i / MOUSE_LERP_STEPS;
                t = 1.0f - (1.0f - t) * (1.0f - t); // Ease out quad
                
                int lerpX = (int)(currentMouse.x + (target.x - currentMouse.x) * t);
                int lerpY = (int)(currentMouse.y + (target.y - currentMouse.y) * t);
                
                MouseEvent moved = new MouseEvent(
                    canvas, MouseEvent.MOUSE_MOVED,
                    System.currentTimeMillis(), 0,
                    lerpX, lerpY, 0, false, MouseEvent.NOBUTTON
                );
                canvas.dispatchEvent(moved);
                overlay.addCursorPosition(new Point(lerpX, lerpY));
                
                Thread.sleep(stepDelay);
            }

            // Only log the final click
            logDebug("Clicking at target location");
            
            MouseEvent pressed = new MouseEvent(
                canvas, MouseEvent.MOUSE_PRESSED,
                System.currentTimeMillis(), 0, target.x, target.y,
                1, false, MouseEvent.BUTTON1
            );
            canvas.dispatchEvent(pressed);
            
            Thread.sleep(2);
            
            MouseEvent released = new MouseEvent(
                canvas, MouseEvent.MOUSE_RELEASED,
                System.currentTimeMillis() + 2, 0, target.x, target.y,
                1, false, MouseEvent.BUTTON1
            );
            canvas.dispatchEvent(released);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logError("Mouse movement interrupted");
        } catch (Exception e) {
            logError("Error during mouse movement: " + e.getMessage());
        }
    }

    private void handleCameraRotate(JsonNode data) {
        boolean right = data.get("right").asBoolean();
        int degrees = data.has("degrees") ? data.get("degrees").asInt() : CAMERA_ROTATE_AMOUNT;
        
        clientThread.invoke(() -> {
            try {
                // Get current yaw and add/subtract rotation amount
                int currentYaw = client.getCameraYawTarget();
                int yawChange = degrees * (right ? 1 : -1);
                int newYaw = (currentYaw + yawChange) & 2047; // Keep within 0-2047 range
                
                // Set new camera yaw
                client.setCameraYawTarget(newYaw);
                
                logDebug(String.format("Rotating camera %s by %d degrees", 
                    right ? "right" : "left", degrees));
            } catch (Exception e) {
                logError("Error rotating camera: " + e.getMessage());
            }
        });
    }

    private void handleCameraZoom(JsonNode data) {
        int zoom = data.get("zoom").asInt();
        clientThread.invoke(() -> {
            try {
                client.runScript(ScriptID.CAMERA_DO_ZOOM, zoom, zoom);
            } catch (Exception e) {
                logWarn("Error setting camera zoom");
            }
        });
    }

    private NPC findNPCById(int id) {
        return client.getNpcs().stream()
            .filter(npc -> npc.getId() == id)
            .findFirst()
            .orElse(null);
    }

    private Point worldToCanvas(WorldPoint worldPoint) {
        if (client.getGameState() != GameState.LOGGED_IN) return null;

        LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);
        if (localPoint == null) return null;

        net.runelite.api.Point canvasPoint = Perspective.localToCanvas(client, localPoint, client.getPlane());
        if (canvasPoint == null) return null;

        return new Point(canvasPoint.getX(), canvasPoint.getY());
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
                    logError("Error updating experience in overlay: " + e.getMessage());
                }
            });
        }
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        if (!isRunning) {
            return;
        }

        if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
            clientThread.invoke(() -> {
                try {
                    overlay.initializeExpTracking();
                    logInfo("Experience tracking initialized after login");
                } catch (Exception e) {
                    logError("Error initializing experience tracking: " + e.getMessage());
                }
            });
        }
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
        visitedChunks.add(chunk);

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

    private GameObject findGameObject(int objectId, WorldPoint location) {
        if (client.getGameState() != GameState.LOGGED_IN) return null;

        Scene scene = client.getScene();
        Tile[][][] tiles = scene.getTiles();
        int plane = location.getPlane();
        
        // Convert world point to scene coordinates
        int sceneX = location.getX() - scene.getBaseX();
        int sceneY = location.getY() - scene.getBaseY();
        
        // Check if coordinates are within bounds
        if (sceneX < 0 || sceneY < 0 || sceneX >= Constants.SCENE_SIZE || sceneY >= Constants.SCENE_SIZE) {
            return null;
        }

        Tile tile = tiles[plane][sceneX][sceneY];
        if (tile == null) return null;

        // Search for the object with matching ID
        for (GameObject obj : tile.getGameObjects()) {
            if (obj != null && obj.getId() == objectId) {
                return obj;
            }
        }
        
        return null;
    }

    private TileItem findGroundItem(String itemName, WorldPoint location) {
        if (client.getGameState() != GameState.LOGGED_IN) return null;

        Scene scene = client.getScene();
        Tile[][][] tiles = scene.getTiles();
        int plane = location.getPlane();
        
        // Convert world point to scene coordinates
        int sceneX = location.getX() - scene.getBaseX();
        int sceneY = location.getY() - scene.getBaseY();
        
        // Check if coordinates are within bounds
        if (sceneX < 0 || sceneY < 0 || sceneX >= Constants.SCENE_SIZE || sceneY >= Constants.SCENE_SIZE) {
            return null;
        }

        Tile tile = tiles[plane][sceneX][sceneY];
        if (tile == null) return null;

        // Get ground items on the tile
        List<TileItem> groundItems = tile.getGroundItems();
        if (groundItems == null) return null;

        // Find the item with matching name
        for (TileItem item : groundItems) {
            if (item == null) continue;
            
            ItemComposition itemComp = itemManager.getItemComposition(item.getId());
            if (itemComp != null && itemName.equalsIgnoreCase(itemComp.getName())) {
                return item;
            }
        }
        
        return null;
    }

    private JsonNode generateGameState() {
        ObjectNode state = objectMapper.createObjectNode();
        
        // Player info
        ObjectNode player = objectMapper.createObjectNode();
        Player localPlayer = client.getLocalPlayer();
        if (localPlayer != null) {
            // Location
            ObjectNode location = objectMapper.createObjectNode();
            WorldPoint worldLoc = localPlayer.getWorldLocation();
            location.put("x", worldLoc.getX());
            location.put("y", worldLoc.getY());
            location.put("plane", worldLoc.getPlane());
            player.set("location", location);
            
            // Health
            ObjectNode health = objectMapper.createObjectNode();
            int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
            int maxHealth = client.getRealSkillLevel(Skill.HITPOINTS);
            // Only log health changes
            if (currentHealth != lastHealth || maxHealth != lastMaxHealth) {
                logInfo(String.format("Health changed - Current: %d, Max: %d", currentHealth, maxHealth));
                lastHealth = currentHealth;
                lastMaxHealth = maxHealth;
            }
            health.put("current", currentHealth);
            health.put("maximum", maxHealth);
            player.set("health", health);
            
            // Combat state
            player.put("inCombat", localPlayer.getInteracting() != null);
            player.put("runEnergy", client.getEnergy() / 100.0);
            
            // Skills
            ObjectNode skills = objectMapper.createObjectNode();
            for (Skill skill : Skill.values()) {
                ObjectNode skillNode = objectMapper.createObjectNode();
                skillNode.put("level", client.getBoostedSkillLevel(skill));
                skillNode.put("realLevel", client.getRealSkillLevel(skill));
                skillNode.put("experience", client.getSkillExperience(skill));
                skills.set(skill.getName(), skillNode);
            }
            player.set("skills", skills);
        }
        state.set("player", player);
        
        // Add debug logging for player object
        logInfo("Player object being sent: " + player.toString());
        
        // NPCs
        ArrayNode npcs = objectMapper.createArrayNode();
        for (NPC npc : client.getNpcs()) {
            if (npc == null) continue;
            
            ObjectNode npcNode = objectMapper.createObjectNode();
            npcNode.put("id", npc.getId());
            npcNode.put("name", npc.getName());
            npcNode.put("combatLevel", npc.getCombatLevel());
            
            // Location
            ObjectNode location = objectMapper.createObjectNode();
            WorldPoint npcLoc = npc.getWorldLocation();
            location.put("x", npcLoc.getX());
            location.put("y", npcLoc.getY());
            location.put("plane", npcLoc.getPlane());
            npcNode.set("location", location);
            
            // Health
            ObjectNode health = objectMapper.createObjectNode();
            Integer healthRatio = npc.getHealthRatio();
            health.put("current", healthRatio != null ? healthRatio : 100);
            health.put("maximum", 100);
            npcNode.set("health", health);
            
            npcNode.put("interacting", npc.getInteracting() != null);
            if (localPlayer != null) {
                npcNode.put("distance", npc.getWorldLocation().distanceTo(localPlayer.getWorldLocation()));
            }
            npcs.add(npcNode);
        }
        state.set("npcs", npcs);
        
        // Game objects
        ArrayNode objects = objectMapper.createArrayNode();
        Scene scene = client.getScene();
        Tile[][][] tiles = scene.getTiles();
        for (int z = 0; z < Constants.MAX_Z; z++) {
            for (int x = 0; x < Constants.SCENE_SIZE; x++) {
                for (int y = 0; y < Constants.SCENE_SIZE; y++) {
                    Tile tile = tiles[z][x][y];
                    if (tile == null) continue;
                    
                    for (GameObject object : tile.getGameObjects()) {
                        if (object == null) continue;
                        
                        ObjectNode objectNode = objectMapper.createObjectNode();
                        objectNode.put("id", object.getId());
                        
                        ObjectComposition objComp = client.getObjectDefinition(object.getId());
                        if (objComp != null) {
                            objectNode.put("name", objComp.getName());
                            
                            // Location
                            ObjectNode location = objectMapper.createObjectNode();
                            WorldPoint objLoc = object.getWorldLocation();
                            location.put("x", objLoc.getX());
                            location.put("y", objLoc.getY());
                            location.put("plane", objLoc.getPlane());
                            objectNode.set("location", location);
                            
                            // Actions
                            ArrayNode actions = objectMapper.createArrayNode();
                            for (String action : objComp.getActions()) {
                                if (action != null) actions.add(action);
                            }
                            objectNode.set("actions", actions);
                            
                            objects.add(objectNode);
                        }
                    }
                }
            }
        }
        state.set("objects", objects);
        
        // Ground items
        ArrayNode groundItems = objectMapper.createArrayNode();
        for (Tile[][] plane : tiles) {
            for (Tile[] row : plane) {
                for (Tile tile : row) {
                    if (tile == null) continue;
                    
                    List<TileItem> items = tile.getGroundItems();
                    if (items != null) {
                        for (TileItem item : items) {
                            if (item == null) continue;
                            
                            ObjectNode itemNode = objectMapper.createObjectNode();
                            itemNode.put("id", item.getId());
                            
                            ItemComposition itemComp = itemManager.getItemComposition(item.getId());
                            if (itemComp != null) {
                                itemNode.put("name", itemComp.getName());
                                itemNode.put("quantity", item.getQuantity());
                                
                                // Location
                                ObjectNode location = objectMapper.createObjectNode();
                                WorldPoint itemLoc = tile.getWorldLocation();
                                location.put("x", itemLoc.getX());
                                location.put("y", itemLoc.getY());
                                location.put("plane", itemLoc.getPlane());
                                itemNode.set("location", location);
                                
                                groundItems.add(itemNode);
                            }
                        }
                    }
                }
            }
        }
        state.set("groundItems", groundItems);
        
        // Only log full state at debug level
        logDebug("Generated game state: " + state.toString());
        
        return state;
    }
} 