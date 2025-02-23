package net.runelite.client.plugins.rlbot;

import com.google.inject.Provides;
import java.awt.Canvas;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
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
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.WorldView;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.DrawManager;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.ItemManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import net.runelite.api.TileItem;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.file.StandardOpenOption;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Iterator;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.imageio.ImageWriter;
import javax.imageio.ImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.IIOImage;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.awt.Graphics;

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
            // Create parent directories if they don't exist
            Path logPath = Paths.get(LOG_FILE);
            Files.createDirectories(logPath.getParent());
            
            String logEntry = String.format("%s [%s] %s%n", 
                LocalDateTime.now().format(DATE_FORMAT), 
                level, 
                message);
            Files.write(logPath, 
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
    private static final int MOUSE_LERP_STEPS = 3;  // Reduced from 5 to 3 steps
    private static final long MOUSE_MOVE_TIME = 50;  // Reduced from 75 to 50ms
    private static final long MIN_MOVE_DELAY = 25;  // Minimum delay for very short movements
    private static final long MAX_MOVE_DELAY = 75;  // Maximum delay for long movements

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

    @Inject
    private DrawManager drawManager;

    private WebSocketServer server;
    private boolean isRunning = false;
    private JsonNode commandSchema;
    private JsonNode stateSchema;
    private boolean shouldSendScreenshots = true; // Flag to control screenshot sending
    private boolean shouldSaveScreenshots = false; // Flag to control saving screenshots to disk

    private final Set<Point> visitedChunks = new HashSet<>();
    private final Map<Point, Long> lastVisitTime = new HashMap<>();
    private final Map<Point, AreaInfo> areaAssessments = new HashMap<>();

    // Add tracking variables for health changes
    private int lastHealth = -1;
    private int lastMaxHealth = -1;
    private boolean wasDeadLastTick = false;  // Add this to track death state

    private volatile String pendingScreenshot = null;

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
                    logInfo("New WebSocket connection established from " + conn.getRemoteSocketAddress());
                    
                    // Send initial state
                    clientThread.invoke(() -> {
                        try {
                            JsonNode gameState = generateGameState();
                            if (gameState == null) {
                                gameState = objectMapper.createObjectNode();
                                ((ObjectNode)gameState).put("status", "initializing");
                            }
                            conn.send(objectMapper.writeValueAsString(gameState));
                        } catch (Exception e) {
                            logError("Error sending initial state: " + e.getMessage());
                        }
                    });
                }

                @Override
                public void onClose(WebSocket conn, int code, String reason, boolean remote) {
                    logInfo("WebSocket connection closed: " + reason);
                }

                @Override
                public void onMessage(WebSocket conn, String message) {
                    try {
                        validateAndProcessCommand(message);
                    } catch (Exception e) {
                        logError("Error processing message: " + e.getMessage());
                        try {
                            ObjectNode errorResponse = objectMapper.createObjectNode();
                            errorResponse.put("error", e.getMessage());
                            conn.send(errorResponse.toString());
                        } catch (Exception sendError) {
                            logError("Error sending error response: " + sendError.getMessage());
                        }
                    }
                }

                @Override
                public void onError(WebSocket conn, Exception ex) {
                    logError("WebSocket error: " + ex.getMessage());
                }

                @Override
                public void onStart() {
                    logInfo("WebSocket server started on port " + getPort());
                }
            };

            server.setReuseAddr(true);
            server.setConnectionLostTimeout(60); // Increased timeout
            server.start();
        } catch (Exception e) {
            logError("Error starting WebSocket server: " + e.getMessage());
            if (server != null) {
                try {
                    server.stop();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
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
        if (!isRunning) {
            return;
        }

        clientThread.invoke(() -> {
            try {
                // Update exploration data
                updateExplorationData();
                
                // Update overlay with current state
                if (client.getLocalPlayer() != null) {
                    overlay.setStatus(client.getLocalPlayer().getInteracting() != null ? "In Combat" : "Idle");
                    overlay.updateExperienceGained();
                }

                // Generate and send game state
                if (server != null && !server.getConnections().isEmpty()) {
                    JsonNode gameState = generateGameState();
                    
                    // Always send at least a minimal state
                    if (gameState == null) {
                        gameState = objectMapper.createObjectNode();
                        ((ObjectNode)gameState).put("status", "waiting");
                    }
                    
                    // Send state to all connected clients
                    String stateJson = objectMapper.writeValueAsString(gameState);
                    for (WebSocket conn : server.getConnections()) {
                        if (conn.isOpen()) {
                            conn.send(stateJson);
                        }
                    }
                }
            } catch (Exception e) {
                logError("Error in game tick: " + e.getMessage());
            }
        });
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
            validateCommand(command);
            
            // Process command based on action type
            String action = command.get("action").asText();
            JsonNode data = command.get("data");
            
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
            logError("Command error: " + e.getMessage());
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
                return;
            }

            // Get current mouse position
            Point currentMouse = new Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());
            
            // Calculate distance
            double distance = Math.sqrt(
                Math.pow(target.x - currentMouse.x, 2) + 
                Math.pow(target.y - currentMouse.y, 2)
            );
            
            // For very short movements, just move directly
            if (distance < 50) {
                MouseEvent moved = new MouseEvent(
                    canvas, MouseEvent.MOUSE_MOVED,
                    System.currentTimeMillis(), 0,
                    target.x, target.y, 0, false, MouseEvent.NOBUTTON
                );
                canvas.dispatchEvent(moved);
                Thread.sleep(MIN_MOVE_DELAY);
            } else {
                // Adjust steps and timing based on distance
                int steps = Math.min(MOUSE_LERP_STEPS, Math.max(2, (int)(distance / 150)));
                long moveTime = Math.min(MAX_MOVE_DELAY, Math.max(MIN_MOVE_DELAY, (long)(distance / 4)));
                long stepDelay = moveTime / steps;
                
                // Pre-create all mouse events
                MouseEvent[] moveEvents = new MouseEvent[steps];
                for (int i = 1; i <= steps; i++) {
                    float t = (float)i / steps;
                    // Ease out quad
                    t = 1.0f - (1.0f - t) * (1.0f - t);
                    
                    int lerpX = (int)(currentMouse.x + (target.x - currentMouse.x) * t);
                    int lerpY = (int)(currentMouse.y + (target.y - currentMouse.y) * t);
                    
                    moveEvents[i-1] = new MouseEvent(
                        canvas, MouseEvent.MOUSE_MOVED,
                        System.currentTimeMillis(), 0,
                        lerpX, lerpY, 0, false, MouseEvent.NOBUTTON
                    );
                }
                
                // Dispatch all move events with delays
                for (int i = 0; i < steps; i++) {
                    canvas.dispatchEvent(moveEvents[i]);
                    if (i % 2 == 0) { // Update cursor trail less frequently
                        overlay.addCursorPosition(new Point(moveEvents[i].getX(), moveEvents[i].getY()));
                    }
                    Thread.sleep(stepDelay);
                }
            }
            
            // Combine press, release and click events
            long eventTime = System.currentTimeMillis();
            MouseEvent[] clickEvents = {
                new MouseEvent(canvas, MouseEvent.MOUSE_PRESSED, eventTime, MouseEvent.BUTTON1_DOWN_MASK,
                    target.x, target.y, 1, false, MouseEvent.BUTTON1),
                new MouseEvent(canvas, MouseEvent.MOUSE_RELEASED, eventTime, MouseEvent.BUTTON1_DOWN_MASK,
                    target.x, target.y, 1, false, MouseEvent.BUTTON1),
                new MouseEvent(canvas, MouseEvent.MOUSE_CLICKED, eventTime, MouseEvent.BUTTON1_DOWN_MASK,
                    target.x, target.y, 1, false, MouseEvent.BUTTON1)
            };
            
            // Dispatch click events without delays
            for (MouseEvent event : clickEvents) {
                canvas.dispatchEvent(event);
            }
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            logError("Mouse movement error: " + e.getMessage());
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
        boolean zoomIn = data.get("in").asBoolean();
        clientThread.invoke(() -> {
            try {
                Canvas canvas = client.getCanvas();
                if (canvas != null) {
                    // Create a mouse wheel event to simulate scrolling
                    MouseWheelEvent wheel = new MouseWheelEvent(
                        canvas,
                        MouseEvent.MOUSE_WHEEL,
                        System.currentTimeMillis(),
                        0,
                        canvas.getWidth() / 2,  // center X
                        canvas.getHeight() / 2, // center Y
                        1,  // click count
                        false,  // popup trigger
                        MouseWheelEvent.WHEEL_UNIT_SCROLL,
                        (int)CAMERA_ZOOM_AMOUNT,  // scroll amount
                        zoomIn ? -1 : 1  // wheel rotation (negative for zoom in, positive for zoom out)
                    );
                    canvas.dispatchEvent(wheel);
                    logDebug(String.format("Camera zoom %s event dispatched with amount %f", zoomIn ? "in" : "out", CAMERA_ZOOM_AMOUNT));
                }
            } catch (Exception e) {
                logError("Error handling camera zoom: " + e.getMessage());
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
        if (client.getGameState() != GameState.LOGGED_IN) {
            logError("Cannot convert coordinates - client not logged in");
            return null;
        }

        LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);
        if (localPoint == null) {
            logError(String.format("Failed to convert world point (%d, %d, %d) to local point", 
                worldPoint.getX(), worldPoint.getY(), worldPoint.getPlane()));
            return null;
        }

        net.runelite.api.Point canvasPoint = Perspective.localToCanvas(client, localPoint, worldPoint.getPlane());
        if (canvasPoint == null) {
            logError(String.format("Failed to convert local point to canvas point for world point (%d, %d, %d)", 
                worldPoint.getX(), worldPoint.getY(), worldPoint.getPlane()));
            return null;
        }

        // Check if point is on screen
        int x = canvasPoint.getX();
        int y = canvasPoint.getY();
        if (x < 0 || y < 0 || x >= client.getCanvasWidth() || y >= client.getCanvasHeight()) {
            logError(String.format("Canvas point (%d, %d) is outside viewport for world point (%d, %d, %d)", 
                x, y, worldPoint.getX(), worldPoint.getY(), worldPoint.getPlane()));
            return null;
        }

        logInfo(String.format("Successfully converted world point (%d, %d, %d) to canvas point (%d, %d)", 
            worldPoint.getX(), worldPoint.getY(), worldPoint.getPlane(), x, y));

        return new Point(x, y);
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

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned) {
        if (!isRunning) {
            return;
        }

        NPC npc = npcDespawned.getNpc();
        if (npc.isDead() && npc.getInteracting() == client.getLocalPlayer()) {
            clientThread.invoke(() -> {
                try {
                    overlay.incrementNPCKilled();
                    logInfo("NPC killed: " + npc.getName());
                } catch (Exception e) {
                    logError("Error incrementing NPC kill count: " + e.getMessage());
                }
            });
        }
    }

    @Subscribe
    public void onHitsplatApplied(HitsplatApplied hitsplatApplied) {
        if (!isRunning) {
            return;
        }

        Actor target = hitsplatApplied.getActor();
        // Only count damage to NPCs
        if (target instanceof NPC && target.getInteracting() == client.getLocalPlayer()) {
            Hitsplat hitsplat = hitsplatApplied.getHitsplat();
            // Only count damage dealt by the player
            if (hitsplat.isMine()) {
                clientThread.invoke(() -> {
                    try {
                        overlay.addDamageDealt(hitsplat.getAmount());
                        logDebug("Damage dealt: " + hitsplat.getAmount());
                    } catch (Exception e) {
                        logError("Error adding damage dealt: " + e.getMessage());
                    }
                });
            }
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

    private String captureGameScreen() {
        if (client == null || client.getGameState() != GameState.LOGGED_IN) {
            return null;
        }

        try {
            CompletableFuture<String> future = new CompletableFuture<>();
            
            clientThread.invoke(() -> {
                try {
                    // Use smaller fixed dimensions
                    final int targetWidth = 160;
                    final int targetHeight = 120;
                    
                    final BufferedImage screenshot = new BufferedImage(
                        targetWidth,
                        targetHeight,
                        BufferedImage.TYPE_INT_RGB
                    );

                    drawManager.requestNextFrameListener(image -> {
                        try {
                            if (image == null) {
                                future.complete(null);
                                return;
                            }

                            // Scale directly to target size
                            Graphics2D g2d = screenshot.createGraphics();
                            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                            g2d.drawImage(image, 0, 0, targetWidth, targetHeight, null);
                            g2d.dispose();

                            // Encode directly to JPEG with low quality
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            ImageWriter writer = ImageIO.getImageWritersByFormatName("JPEG").next();
                            ImageWriteParam param = writer.getDefaultWriteParam();
                            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                            param.setCompressionQuality(0.3f);

                            try (ImageOutputStream ios = ImageIO.createImageOutputStream(out)) {
                                writer.setOutput(ios);
                                writer.write(null, new IIOImage(screenshot, null, null), param);
                            }
                            writer.dispose();

                            future.complete(Base64.getEncoder().encodeToString(out.toByteArray()));
                        } catch (Exception e) {
                            future.complete(null);
                        }
                    });
                } catch (Exception e) {
                    future.complete(null);
                }
            });

            return future.get(500, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            return null;
        }
    }

    private JsonNode generateGameState() {
        ObjectNode state = objectMapper.createObjectNode();
        
        // Add player info
        ObjectNode player = state.putObject("player");
        ObjectNode location = player.putObject("location");
        location.put("x", client.getLocalPlayer().getWorldLocation().getX());
        location.put("y", client.getLocalPlayer().getWorldLocation().getY());
        location.put("plane", client.getLocalPlayer().getWorldLocation().getPlane());
        
        ObjectNode health = player.putObject("health");
        health.put("current", client.getBoostedSkillLevel(Skill.HITPOINTS));
        health.put("maximum", client.getRealSkillLevel(Skill.HITPOINTS));
        
        player.put("inCombat", client.getLocalPlayer().getInteracting() != null);
        player.put("runEnergy", client.getEnergy() / 100.0);
        
        ObjectNode skills = player.putObject("skills");
        for (Skill skill : Skill.values()) {
            ObjectNode skillNode = skills.putObject(skill.getName());
            skillNode.put("level", client.getBoostedSkillLevel(skill));
            skillNode.put("realLevel", client.getRealSkillLevel(skill));
            skillNode.put("experience", client.getSkillExperience(skill));
        }
        
        // Add NPCs info
        ArrayNode npcs = state.putArray("npcs");
        WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
        client.getNpcs().forEach(npc -> {
            if (npc != null) {
                ObjectNode npcNode = npcs.addObject();
                npcNode.put("id", npc.getId());
                npcNode.put("name", npc.getName());
                npcNode.put("combatLevel", npc.getCombatLevel());
                
                ObjectNode npcLocation = npcNode.putObject("location");
                WorldPoint npcWorldLocation = npc.getWorldLocation();
                npcLocation.put("x", npcWorldLocation.getX());
                npcLocation.put("y", npcWorldLocation.getY());
                npcLocation.put("plane", npcWorldLocation.getPlane());
                
                ObjectNode npcHealth = npcNode.putObject("health");
                npcHealth.put("current", npc.getHealthRatio() != -1 ? npc.getHealthRatio() : 100);
                npcHealth.put("maximum", 100);
                
                npcNode.put("interacting", npc.getInteracting() != null);
                npcNode.put("distance", npcWorldLocation.distanceTo(playerLocation));
            }
        });
        
        // Add empty objects array with required fields
        ArrayNode objects = state.putArray("objects");
        // Add a single dummy object to satisfy schema
        ObjectNode dummyObject = objects.addObject();
        dummyObject.put("id", -1);
        dummyObject.put("name", "dummy");
        ObjectNode dummyLocation = dummyObject.putObject("location");
        dummyLocation.put("x", 0);
        dummyLocation.put("y", 0);
        dummyLocation.put("plane", 0);
        ArrayNode actions = dummyObject.putArray("actions");
        actions.add("dummy");

        // Add empty groundItems array with required fields
        ArrayNode groundItems = state.putArray("groundItems");
        // Add a single dummy ground item to satisfy schema
        ObjectNode dummyItem = groundItems.addObject();
        dummyItem.put("id", -1);
        dummyItem.put("name", "dummy");
        dummyItem.put("quantity", 0);
        ObjectNode itemLocation = dummyItem.putObject("location");
        itemLocation.put("x", 0);
        itemLocation.put("y", 0);
        itemLocation.put("plane", 0);
        
        return state;
    }
} 