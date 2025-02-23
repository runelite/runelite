package net.runelite.client.plugins.rlbot;

import com.google.inject.Provides;
import java.awt.Canvas;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyEvent;
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
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.KeyListener;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import net.runelite.api.widgets.WidgetInfo;

@PluginDescriptor(
    name = "RLBot",
    description = "RuneLite Bot Plugin for AI Training",
    tags = {"bot", "ai", "training"}
)
public class RLBotPlugin extends Plugin implements KeyListener {
    private static final String LOG_FILE = "/Users/danielgleason/Desktop/Code/my_code/runescape_bot_runelite/rlbot/logs/rlbot-plugin.log";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final String SCREENSHOTS_DIR = "/Users/danielgleason/Desktop/Code/my_code/runescape_bot_runelite/rlbot/screenshots";
    
    // Add executor service for screenshot handling
    private final ExecutorService screenshotExecutor = Executors.newSingleThreadExecutor(r -> {
        Thread thread = new Thread(r);
        thread.setName("screenshot-thread");
        thread.setDaemon(true);
        return thread;
    });
    private volatile String lastScreenshot = null;
    private long lastScreenshotTime = 0;
    private static final long SCREENSHOT_COOLDOWN = 100; // Minimum ms between screenshots

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

    @Inject
    private KeyManager keyManager;

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
            
            keyManager.registerKeyListener(this);
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
        keyManager.unregisterKeyListener(this);
        stopWebSocketServer();
        isRunning = false;
        overlayManager.remove(overlay);
        screenshotExecutor.shutdown();
        try {
            if (!screenshotExecutor.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                screenshotExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            screenshotExecutor.shutdownNow();
        }
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

        // Update screenshot asynchronously if enabled
        if (shouldSendScreenshots) {
            updateScreenshotAsync();
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
            case "pressKey":
                validatePressKey(data);
                break;
            case "interfaceAction":
                validateInterfaceAction(data);
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

    private void validatePressKey(JsonNode data) throws IllegalArgumentException {
        if (!data.has("key")) {
            throw new IllegalArgumentException("pressKey command must have a 'key' field");
        }
    }

    private void validateInterfaceAction(JsonNode data) throws IllegalArgumentException {
        if (!data.has("interfaceId")) {
            throw new IllegalArgumentException("interfaceAction command must have an 'interfaceId' field");
        }
        if (!data.has("groupId")) {
            throw new IllegalArgumentException("interfaceAction command must have a 'groupId' field");
        }
        if (!data.has("optionText")) {
            throw new IllegalArgumentException("interfaceAction command must have an 'optionText' field");
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
                case "pressKey":
                    handlePressKey(data);
                    break;
                case "interfaceAction":
                    handleInterfaceAction(data);
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

            // Get current mouse position from RuneLite's API
            net.runelite.api.Point clientMouse = client.getMouseCanvasPosition();
            Point currentMouse = new Point(clientMouse.getX(), clientMouse.getY());
            
            // Calculate distance
            double distance = Math.sqrt(
                Math.pow(target.x - currentMouse.x, 2) + 
                Math.pow(target.y - currentMouse.y, 2)
            );
            
            // For very short movements, just move directly
            if (distance < 50) {
                // Create and dispatch the move event
                MouseEvent moved = new MouseEvent(
                    canvas, MouseEvent.MOUSE_MOVED,
                    System.currentTimeMillis(), 0,
                    target.x, target.y, 0, false, MouseEvent.NOBUTTON
                );
                canvas.dispatchEvent(moved);
                
                // Update overlay with the actual canvas position
                overlay.addCursorPosition(target);
                Thread.sleep(MIN_MOVE_DELAY);
            } else {
                // Adjust steps and timing based on distance
                int steps = Math.min(MOUSE_LERP_STEPS, Math.max(2, (int)(distance / 150)));
                long moveTime = Math.min(MAX_MOVE_DELAY, Math.max(MIN_MOVE_DELAY, (long)(distance / 4)));
                long stepDelay = moveTime / steps;
                
                // Pre-create all mouse events
                MouseEvent[] moveEvents = new MouseEvent[steps];
                Point[] positions = new Point[steps];
                
                for (int i = 1; i <= steps; i++) {
                    float t = (float)i / steps;
                    // Ease out quad
                    t = 1.0f - (1.0f - t) * (1.0f - t);
                    
                    int lerpX = (int)(currentMouse.x + (target.x - currentMouse.x) * t);
                    int lerpY = (int)(currentMouse.y + (target.y - currentMouse.y) * t);
                    
                    positions[i-1] = new Point(lerpX, lerpY);
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
                        overlay.addCursorPosition(positions[i]);
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
            
            // Ensure final position is updated in overlay
            overlay.addCursorPosition(target);
            
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

    private void handlePressKey(JsonNode data) {
        String key = data.get("key").asText();
        clientThread.invoke(() -> {
            try {
                Canvas canvas = client.getCanvas();
                if (canvas != null) {
                    // Convert key string to KeyEvent code
                    int keyCode = getKeyCode(key);
                    if (keyCode != KeyEvent.VK_UNDEFINED) {
                        // Send key press event
                        KeyEvent pressEvent = new KeyEvent(
                            canvas,
                            KeyEvent.KEY_PRESSED,
                            System.currentTimeMillis(),
                            0,
                            keyCode,
                            KeyEvent.CHAR_UNDEFINED
                        );
                        canvas.dispatchEvent(pressEvent);

                        // Send key release event
                        KeyEvent releaseEvent = new KeyEvent(
                            canvas,
                            KeyEvent.KEY_RELEASED,
                            System.currentTimeMillis(),
                            0,
                            keyCode,
                            KeyEvent.CHAR_UNDEFINED
                        );
                        canvas.dispatchEvent(releaseEvent);
                        
                        logDebug("Key event dispatched for key: " + key);
                    } else {
                        logError("Invalid key: " + key);
                    }
                }
            } catch (Exception e) {
                logError("Error handling key press: " + e.getMessage());
            }
        });
    }

    private int getKeyCode(String key) {
        // Map common key names to KeyEvent codes
        switch (key.toUpperCase()) {
            case "ESCAPE":
                return KeyEvent.VK_ESCAPE;
            case "ENTER":
                return KeyEvent.VK_ENTER;
            case "SPACE":
                return KeyEvent.VK_SPACE;
            case "TAB":
                return KeyEvent.VK_TAB;
            case "BACKSPACE":
                return KeyEvent.VK_BACK_SPACE;
            default:
                // For single characters, try to get the key code directly
                if (key.length() == 1) {
                    return KeyEvent.getExtendedKeyCodeForChar(key.charAt(0));
                }
                return KeyEvent.VK_UNDEFINED;
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

                            // Save to file if enabled
                            if (config.saveScreenshots()) {
                                try {
                                    Path screenshotsPath = Paths.get(SCREENSHOTS_DIR);
                                    Files.createDirectories(screenshotsPath);
                                    String filename = String.format("screenshot_%s.jpg", 
                                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS")));
                                    Path filePath = screenshotsPath.resolve(filename);
                                    ImageIO.write(screenshot, "jpg", filePath.toFile());
                                    logDebug("Screenshot saved to: " + filePath);
                                } catch (IOException e) {
                                    logError("Failed to save screenshot: " + e.getMessage());
                                }
                            }

                            // Encode for websocket transmission
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

    private void updateScreenshotAsync() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastScreenshotTime < SCREENSHOT_COOLDOWN) {
            return; // Skip if too soon since last screenshot
        }

        CompletableFuture.supplyAsync(() -> {
            try {
                return captureGameScreen();
            } catch (Exception e) {
                logError("Error capturing screenshot: " + e.getMessage());
                return null;
            }
        }, screenshotExecutor).thenAccept(screenshot -> {
            if (screenshot != null) {
                lastScreenshot = screenshot;
                lastScreenshotTime = System.currentTimeMillis();
            }
        });
    }

    private JsonNode generateGameState() {
        ObjectNode state = objectMapper.createObjectNode();
        
        if (client.getGameState() != GameState.LOGGED_IN) {
            state.put("status", "not_logged_in");
            return state;
        }

        try {
            // Add player info first - this is critical
            ObjectNode player = state.putObject("player");
            ObjectNode location = player.putObject("location");
            WorldPoint playerLoc = client.getLocalPlayer().getWorldLocation();
            location.put("x", playerLoc.getX());
            location.put("y", playerLoc.getY());
            location.put("plane", playerLoc.getPlane());
            
            ObjectNode health = player.putObject("health");
            health.put("current", client.getBoostedSkillLevel(Skill.HITPOINTS));
            health.put("maximum", client.getRealSkillLevel(Skill.HITPOINTS));
            
            player.put("inCombat", client.getLocalPlayer().getInteracting() != null);
            player.put("isRunning", client.getVarpValue(173) == 1);
            player.put("runEnergy", client.getEnergy() / 100.0);
            
            // Process all skills to ensure schema compliance
            ObjectNode skills = player.putObject("skills");
            for (Skill skill : Skill.values()) {
                if (skill != Skill.OVERALL) {  // Skip overall since it's a calculated value
                    ObjectNode skillNode = skills.putObject(skill.getName().toUpperCase());
                    skillNode.put("level", client.getBoostedSkillLevel(skill));
                    skillNode.put("realLevel", client.getRealSkillLevel(skill));
                    skillNode.put("experience", client.getSkillExperience(skill));
                }
            }
            
            // Process NPCs - limit to nearby and relevant only
            ArrayNode npcs = state.putArray("npcs");
            WorldPoint playerPos = client.getLocalPlayer().getWorldLocation();
            client.getNpcs().stream()
                .filter(npc -> npc != null && 
                             npc.getWorldLocation().distanceTo(playerPos) <= 15)  // Only NPCs within 15 tiles
                .limit(10)  // Limit to 10 NPCs
                .forEach(npc -> {
                    ObjectNode npcNode = npcs.addObject();
                    npcNode.put("id", npc.getId());
                    npcNode.put("name", npc.getName());
                    npcNode.put("combatLevel", npc.getCombatLevel());
                    npcNode.put("distance", npc.getWorldLocation().distanceTo(playerPos));
                    npcNode.put("interacting", npc.getInteracting() == client.getLocalPlayer());
                    
                    ObjectNode npcLocation = npcNode.putObject("location");
                    WorldPoint npcPos = npc.getWorldLocation();
                    npcLocation.put("x", npcPos.getX());
                    npcLocation.put("y", npcPos.getY());
                    npcLocation.put("plane", npcPos.getPlane());
                    
                    ObjectNode npcHealth = npcNode.putObject("health");
                    npcHealth.put("current", npc.getHealthRatio() != -1 ? npc.getHealthRatio() : 100);
                    npcHealth.put("maximum", 100);
                });
            
            // Process game objects - deduplicate and limit to nearby only
            ArrayNode objects = state.putArray("objects");
            Scene scene = client.getScene();
            Tile[][][] tiles = scene.getTiles();
            int plane = client.getPlane();
            int radius = 10;  // 10 tile radius
            
            // Use a set to track unique object IDs at each location
            Set<String> processedObjects = new HashSet<>();
            
            int playerRegionX = playerPos.getX() - client.getBaseX();
            int playerRegionY = playerPos.getY() - client.getBaseY();
            
            for (int x = Math.max(0, playerRegionX - radius); x < Math.min(Constants.SCENE_SIZE, playerRegionX + radius); x++) {
                for (int y = Math.max(0, playerRegionY - radius); y < Math.min(Constants.SCENE_SIZE, playerRegionY + radius); y++) {
                    Tile tile = tiles[plane][x][y];
                    if (tile == null) continue;
                    
                    for (GameObject obj : tile.getGameObjects()) {
                        if (obj == null) continue;
                        
                        ObjectComposition objComp = client.getObjectDefinition(obj.getId());
                        if (objComp == null || objComp.getActions() == null || objComp.getActions().length == 0) continue;
                        
                        WorldPoint worldLoc = obj.getWorldLocation();
                        String objKey = obj.getId() + ":" + worldLoc.getX() + ":" + worldLoc.getY() + ":" + worldLoc.getPlane();
                        
                        // Skip if we've already processed this object at this location
                        if (!processedObjects.add(objKey)) continue;
                        
                        ObjectNode gameObj = objects.addObject();
                        gameObj.put("id", obj.getId());
                        gameObj.put("name", objComp.getName());
                        
                        ObjectNode objLocation = gameObj.putObject("location");
                        objLocation.put("x", worldLoc.getX());
                        objLocation.put("y", worldLoc.getY());
                        objLocation.put("plane", worldLoc.getPlane());
                        
                        ArrayNode actions = gameObj.putArray("actions");
                        for (String action : objComp.getActions()) {
                            if (action != null) {
                                actions.add(action);
                            }
                        }
                    }
                }
            }
            
            // Process ground items - only nearby and valuable
            ArrayNode groundItems = state.putArray("groundItems");
            for (Tile[][] planeTiles : tiles) {
                for (Tile[] row : planeTiles) {
                    for (Tile tile : row) {
                        if (tile == null) continue;
                        
                        WorldPoint tileLocation = tile.getWorldLocation();
                        if (tileLocation.distanceTo(playerPos) > radius) continue;
                        
                        List<TileItem> items = tile.getGroundItems();
                        if (items == null) continue;
                        
                        for (TileItem item : items) {
                            if (item == null) continue;
                            
                            ItemComposition itemComp = client.getItemDefinition(item.getId());
                            if (itemComp == null || itemComp.getPrice() < 100) continue;  // Skip low value items
                            
                            ObjectNode groundItem = groundItems.addObject();
                            groundItem.put("id", item.getId());
                            groundItem.put("name", itemComp.getName());
                            groundItem.put("quantity", item.getQuantity());
                            
                            ObjectNode itemLocation = groundItem.putObject("location");
                            itemLocation.put("x", tileLocation.getX());
                            itemLocation.put("y", tileLocation.getY());
                            itemLocation.put("plane", tileLocation.getPlane());
                        }
                    }
                }
            }
            
            // Process interfaces
            ArrayNode interfaces = state.putArray("interfaces");
            refreshWidgets(interfaces);
            
            return state;
        } catch (Exception e) {
            logError("Error generating game state: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private boolean hasContent(Widget widget) {
        if (widget == null) return false;
        
        // Check if widget has any meaningful content
        String text = widget.getText();
        String name = widget.getName();
        String[] actions = widget.getActions();
        
        return (text != null && !text.trim().isEmpty()) ||
               (name != null && !name.trim().isEmpty()) ||
               (actions != null && actions.length > 0 && Arrays.stream(actions).anyMatch(a -> a != null && !a.trim().isEmpty()));
    }

    private void refreshWidgets(ArrayNode interfaces) {
        if (client.getGameState() != GameState.LOGGED_IN) {
            return;
        }

        Widget[] rootWidgets = client.getWidgetRoots();
        if (rootWidgets == null) {
            return;
        }

        // Process widgets in batches to prevent overwhelming the connection
        int processedCount = 0;
        final int BATCH_SIZE = 50;  // Process 50 widgets at a time

        for (Widget widget : rootWidgets) {
            if (widget == null || widget.isHidden()) {
                continue;
            }

            // Add root widget node to JSON
            ObjectNode widgetNode = interfaces.addObject();
            addWidgetInfo(widgetNode, widget, "R");
            
            // Process children recursively with batch limiting
            processedCount = processChildren(widgetNode, widget, processedCount, BATCH_SIZE);
            
            // If we've hit our batch limit, stop processing
            if (processedCount >= BATCH_SIZE) {
                logDebug("Widget processing limited to prevent buffer overflow");
                break;
            }
        }
    }

    private int processChildren(ObjectNode parentNode, Widget widget, int processedCount, int batchLimit) {
        if (processedCount >= batchLimit) {
            return processedCount;
        }

        // Process dynamic children
        Widget[] dynamicChildren = widget.getDynamicChildren();
        if (dynamicChildren != null && dynamicChildren.length > 0) {
            ArrayNode dynChildren = parentNode.putArray("dynamicChildren");
            for (Widget child : dynamicChildren) {
                if (child != null && !child.isHidden() && hasContent(child)) {
                    ObjectNode childNode = dynChildren.addObject();
                    addWidgetInfo(childNode, child, "D");
                    processedCount++;
                    if (processedCount >= batchLimit) {
                        return processedCount;
                    }
                    processedCount = processChildren(childNode, child, processedCount, batchLimit);
                }
            }
        }

        // Process static children
        Widget[] staticChildren = widget.getStaticChildren();
        if (staticChildren != null && staticChildren.length > 0 && processedCount < batchLimit) {
            ArrayNode statChildren = parentNode.putArray("staticChildren");
            for (Widget child : staticChildren) {
                if (child != null && !child.isHidden() && hasContent(child)) {
                    ObjectNode childNode = statChildren.addObject();
                    addWidgetInfo(childNode, child, "S");
                    processedCount++;
                    if (processedCount >= batchLimit) {
                        return processedCount;
                    }
                    processedCount = processChildren(childNode, child, processedCount, batchLimit);
                }
            }
        }

        // Process nested children
        Widget[] nestedChildren = widget.getNestedChildren();
        if (nestedChildren != null && nestedChildren.length > 0 && processedCount < batchLimit) {
            ArrayNode nestChildren = parentNode.putArray("nestedChildren");
            for (Widget child : nestedChildren) {
                if (child != null && !child.isHidden() && hasContent(child)) {
                    ObjectNode childNode = nestChildren.addObject();
                    addWidgetInfo(childNode, child, "N");
                    processedCount++;
                    if (processedCount >= batchLimit) {
                        return processedCount;
                    }
                    processedCount = processChildren(childNode, child, processedCount, batchLimit);
                }
            }
        }

        return processedCount;
    }

    private void addWidgetInfo(ObjectNode node, Widget widget, String type) {
        if (widget == null || (type != "R" && widget.isHidden())) {
            return;
        }

        // Required fields from schema
        node.put("id", widget.getId());
        node.put("type", type);
        node.put("index", widget.getIndex());
        node.put("groupId", widget.getId() >> 16);
        node.put("hidden", widget.isHidden());
        node.put("selfHidden", widget.isSelfHidden());
        
        // Optional fields with content
        String text = widget.getText();
        if (text != null && !text.trim().isEmpty()) {
            node.put("text", text);
        }
        
        String name = widget.getName();
        if (name != null && !name.trim().isEmpty()) {
            node.put("name", name);
        }
        
        // Item info if present
        int itemId = widget.getItemId();
        if (itemId > 0) {
            node.put("itemId", itemId);
            node.put("itemQuantity", widget.getItemQuantity());
        }
        
        // Model and sprite info
        int modelId = widget.getModelId();
        if (modelId > 0) {
            node.put("modelId", modelId);
            node.put("modelType", widget.getModelType());
            node.put("modelZoom", widget.getModelZoom());
            node.put("rotationX", widget.getRotationX());
            node.put("rotationY", widget.getRotationY());
            node.put("rotationZ", widget.getRotationZ());
        }
        
        int spriteId = widget.getSpriteId();
        if (spriteId > 0) {
            node.put("spriteId", spriteId);
        }
        
        // Position and size
        node.put("relativeX", widget.getRelativeX());
        node.put("relativeY", widget.getRelativeY());
        node.put("width", widget.getWidth());
        node.put("height", widget.getHeight());
        
        // Original dimensions
        node.put("originalX", widget.getOriginalX());
        node.put("originalY", widget.getOriginalY());
        node.put("originalWidth", widget.getOriginalWidth());
        node.put("originalHeight", widget.getOriginalHeight());
        
        // Scroll info
        node.put("scrollX", widget.getScrollX());
        node.put("scrollY", widget.getScrollY());
        node.put("scrollWidth", widget.getScrollWidth());
        node.put("scrollHeight", widget.getScrollHeight());
        
        // Text appearance
        node.put("textColor", widget.getTextColor());
        node.put("opacity", widget.getOpacity());
        node.put("fontId", widget.getFontId());
        node.put("textShadowed", widget.getTextShadowed());
        
        // Click behavior
        node.put("noClickThrough", widget.getNoClickThrough());
        node.put("noScrollThrough", widget.getNoScrollThrough());
        node.put("clickMask", widget.getClickMask());
        
        String targetVerb = widget.getTargetVerb();
        if (targetVerb != null && !targetVerb.trim().isEmpty()) {
            node.put("targetVerb", targetVerb);
        }
        
        // Animation
        int animationId = widget.getAnimationId();
        if (animationId > 0) {
            node.put("animationId", animationId);
        }
        
        // Actions
        String[] widgetActions = widget.getActions();
        if (widgetActions != null && widgetActions.length > 0) {
            ArrayNode actions = node.putArray("actions");
            for (String action : widgetActions) {
                if (action != null && !action.trim().isEmpty()) {
                    actions.add(action);
                }
            }
        }
    }

    private ObjectNode addWidgetToNode(ObjectNode node, Widget widget) {
        // This method is now deprecated in favor of addWidgetInfo
        // Keeping it for backward compatibility
        addWidgetInfo(node, widget, "");
        return node;
    }

    // KeyListener implementation
    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed for our purposes
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Not needed for our purposes
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed for our purposes
    }

    @Override
    public void focusLost() {
        // Not needed for our purposes
    }

    @Override
    public boolean isEnabledOnLoginScreen() {
        return false;  // Only enable when logged in
    }

    private void checkWidget(WidgetInfo info) {
        if (info == null) return;
        
        Widget widget = client.getWidget(info);
        if (widget == null) return;

        // Only log if widget has any content or is visible
        if (!widget.isHidden() || widget.getText() != null || widget.getName() != null || widget.getActions() != null) {
            // Log basic widget info
            logDebug(String.format("\nWidget %s", info.name()));
            logDebug(String.format("  ID: %d (Group: %d, Child: %d)", 
                widget.getId(), 
                info.getGroupId(),
                info.getChildId()));
            logDebug(String.format("  Position: (%d, %d), Size: %dx%d, Hidden: %b, Type: %d",
                widget.getRelativeX(),
                widget.getRelativeY(),
                widget.getWidth(),
                widget.getHeight(),
                widget.isHidden(),
                widget.getType()));
            
            // Log content if exists
            String name = widget.getName();
            String text = widget.getText();
            String[] actions = widget.getActions();
            
            if (name != null && !name.isEmpty()) {
                logDebug("  Name: '" + name + "'");
            }
            if (text != null && !text.isEmpty()) {
                logDebug("  Text: '" + text + "'");
            }
            if (actions != null && actions.length > 0) {
                logDebug("  Actions: " + Arrays.toString(actions));
            }
            
            // Check all types of children
            Widget[] dynamicChildren = widget.getDynamicChildren();
            Widget[] staticChildren = widget.getStaticChildren();
            Widget[] nestedChildren = widget.getNestedChildren();
            
            if (dynamicChildren != null && dynamicChildren.length > 0) {
                logDebug("  Dynamic Children: " + dynamicChildren.length);
                for (Widget child : dynamicChildren) {
                    if (child == null || child.isHidden()) continue;
                    
                    name = child.getName();
                    text = child.getText();
                    actions = child.getActions();
                    
                    if ((name != null && !name.isEmpty()) || 
                        (text != null && !text.isEmpty()) || 
                        (actions != null && actions.length > 0)) {
                        
                        logDebug(String.format("    Child [%d] Type: %d", child.getId(), child.getType()));
                        if (name != null && !name.isEmpty()) {
                            logDebug("      Name: '" + name + "'");
                        }
                        if (text != null && !text.isEmpty()) {
                            logDebug("      Text: '" + text + "'");
                        }
                        if (actions != null && actions.length > 0) {
                            logDebug("      Actions: " + Arrays.toString(actions));
                        }
                    }
                }
            }
            
            if (staticChildren != null && staticChildren.length > 0) {
                logDebug("  Static Children: " + staticChildren.length);
                for (Widget child : staticChildren) {
                    if (child == null || child.isHidden()) continue;
                    
                    name = child.getName();
                    text = child.getText();
                    actions = child.getActions();
                    
                    if ((name != null && !name.isEmpty()) || 
                        (text != null && !text.isEmpty()) || 
                        (actions != null && actions.length > 0)) {
                        
                        logDebug(String.format("    Child [%d] Type: %d", child.getId(), child.getType()));
                        if (name != null && !name.isEmpty()) {
                            logDebug("      Name: '" + name + "'");
                        }
                        if (text != null && !text.isEmpty()) {
                            logDebug("      Text: '" + text + "'");
                        }
                        if (actions != null && actions.length > 0) {
                            logDebug("      Actions: " + Arrays.toString(actions));
                        }
                    }
                }
            }
            
            if (nestedChildren != null && nestedChildren.length > 0) {
                logDebug("  Nested Children: " + nestedChildren.length);
                for (Widget child : nestedChildren) {
                    if (child == null || child.isHidden()) continue;
                    
                    name = child.getName();
                    text = child.getText();
                    actions = child.getActions();
                    
                    if ((name != null && !name.isEmpty()) || 
                        (text != null && !text.isEmpty()) || 
                        (actions != null && actions.length > 0)) {
                        
                        logDebug(String.format("    Child [%d] Type: %d", child.getId(), child.getType()));
                        if (name != null && !name.isEmpty()) {
                            logDebug("      Name: '" + name + "'");
                        }
                        if (text != null && !text.isEmpty()) {
                            logDebug("      Text: '" + text + "'");
                        }
                        if (actions != null && actions.length > 0) {
                            logDebug("      Actions: " + Arrays.toString(actions));
                        }
                    }
                }
            }
        }
    }

    private void handleInterfaceAction(JsonNode data) {
        clientThread.invoke(() -> {
            try {
                int interfaceId = data.get("interfaceId").asInt();
                int groupId = data.get("groupId").asInt();
                String optionText = data.get("optionText").asText();

                // Special handling for toggle run
                if (interfaceId == 10485787 && groupId == 160 && "Toggle Run".equals(optionText)) {
                    Widget runOrbWidget = client.getWidget(WidgetInfo.MINIMAP_TOGGLE_RUN_ORB);
                    if (runOrbWidget != null) {
                        boolean currentRunState = client.getVarpValue(173) == 1;
                        logInfo("Toggling run state from " + (currentRunState ? "on" : "off") + " to " + (!currentRunState ? "on" : "off"));
                        
                        client.createMenuEntry(-1)
                            .setOption("Toggle Run")
                            .setTarget("")
                            .setType(MenuAction.CC_OP)
                            .setParam0(1)  // First option
                            .setParam1(runOrbWidget.getId())
                            .onClick(e -> logInfo("Run state toggled from " + (currentRunState ? "on" : "off") + " to " + (!currentRunState ? "on" : "off")));
                        return;
                    }
                }

                // Regular interface handling
                Widget[] widgets = client.getWidgetRoots();
                if (widgets != null) {
                    for (Widget widget : widgets) {
                        if (widget == null) continue;
                        
                        Widget[] children = widget.getDynamicChildren();
                        if (children == null) continue;
                        
                        for (Widget child : children) {
                            if (child == null || child.isHidden()) continue;
                            
                            if (child.getId() == interfaceId) {
                                // Found the widget, simulate click
                                String[] actions = child.getActions();
                                if (actions != null) {
                                    for (int i = 0; i < actions.length; i++) {
                                        if (actions[i] != null && actions[i].equals(optionText)) {
                                            // Create menu entry for the action
                                            client.createMenuEntry(
                                                -1)
                                                .setOption(optionText)
                                                .setTarget("")
                                                .setType(MenuAction.CC_OP)
                                                .setParam0(i + 1)
                                                .setParam1(child.getId())
                                                .onClick(e -> {
                                                    // Log the interaction
                                                    logInfo(String.format("Clicked interface option: %s on widget %d", 
                                                        optionText, child.getId()));
                                                });
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                logError("Error in handleInterfaceAction: " + e.getMessage());
            }
        });
    }
} 