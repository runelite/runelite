package net.runelite.client.plugins.rlbot;

import com.google.inject.Provides;
import java.awt.Canvas;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyEvent;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
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
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Iterator;
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
import javax.swing.SwingUtilities;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import lombok.Builder;
import net.runelite.client.ui.PluginPanel;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Module;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTree;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.plugins.rlbot.RLBotOverlay;

@PluginDescriptor(
    name = "RLBot",
    description = "RuneLite Bot Plugin for AI Training",
    tags = {"bot", "ai", "training"}
)
public class RLBotPlugin extends Plugin implements KeyListener {
    private static final String LOG_FILE = "/Users/danielgleason/Desktop/Code/my_code/runescape_bot_runelite/rlbot/logs/rlbot-plugin.log";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final String SCREENSHOTS_DIR = "/Users/danielgleason/Desktop/Code/my_code/runescape_bot_runelite/rlbot/screenshots";
    
    // Constants for movement
    private static final int CAMERA_ROTATE_AMOUNT = 45;
    private static final float CAMERA_ZOOM_AMOUNT = 25f;
    private static final int EXPLORATION_CHUNK_SIZE = 8; // Size of each exploration chunk
    private static final int MOUSE_LERP_STEPS = 3;  // Reduced from 5 to 3 steps
    private static final long MOUSE_MOVE_TIME = 50;  // Reduced from 75 to 50ms
    private static final long MIN_MOVE_DELAY = 25;  // Minimum delay for very short movements
    private static final long MAX_MOVE_DELAY = 75;  // Maximum delay for long movements

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

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private RLBotConfig config;

    @Inject
    private ObjectMapper objectMapper;

    @Inject
    private ItemManager itemManager;

    @Inject
    private DrawManager drawManager;

    @Inject
    private KeyManager keyManager;

    // Renamed from server to webSocketServer to avoid duplication
    private WebSocketServer webSocketServer;

    @Inject
    private RLBotStateViewer stateViewer;

    @Inject
    private ClientToolbar clientToolbar;

    private NavigationButton stateViewerButton;

    private boolean isRunning = false;
    private int tickCount = 0;
    private JsonNode latestGameState; // Store the latest game state for manual refresh
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

    @Inject
    private OverlayManager overlayManager;
    
    @Inject
    private RLBotOverlay overlay;

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
    protected void startUp() throws Exception {
        logInfo("Starting RLBot plugin...");
        startWebSocketServer();

        if (webSocketServer == null) {
            logError("WebSocket server failed to start properly");
            return;
        }

        keyManager.registerKeyListener(this);
        isRunning = true;
        
        // Register the overlay
        overlayManager.add(overlay);
        
        logInfo("RLBot plugin started successfully");

        stateViewer.setRefreshCallback(() -> {
            try {
                logInfo("StateViewer refresh callback called");
                
                // Use the latest game state if available, otherwise generate a new one
                final JsonNode stateToUse;
                
                if (latestGameState == null) {
                    logInfo("No cached state available, generating new game state");
                    stateToUse = generateGameState();
                } else {
                    logInfo("Using cached game state from latest tick");
                    stateToUse = latestGameState;
                }
                
                if (stateToUse != null) {
                    logInfo("Updating state viewer with game state");
                    
                    // Use a final reference to avoid capture issues
                    final JsonNode finalState = stateToUse;
                    
                    SwingUtilities.invokeLater(() -> {
                        try {
                            stateViewer.updateState(finalState);
                            logInfo("State viewer updated via refresh callback");
                        } catch (Exception e) {
                            logError("Error updating state viewer in refresh callback: " + e.getMessage());
                            e.printStackTrace();
                        }
                    });
                } else {
                    logError("Cannot update state viewer - game state is null");
                }
            } catch (Exception e) {
                logError("Error in refresh callback: " + e.getMessage());
                e.printStackTrace();
            }
        });

        BufferedImage icon;
        try {
            icon = ImageUtil.loadImageResource(getClass(), "rlbot_icon.png");
        } catch (Exception e) {
            // Use a fallback icon from RuneLite's UI
            icon = ImageUtil.loadImageResource(RLBotPlugin.class, "/net/runelite/client/ui/runescape.png");
            logInfo("Could not load rlbot_icon.png, using fallback icon");
        }

        stateViewerButton = NavigationButton.builder()
            .tooltip("RLBot State")
            .icon(icon)
            .priority(5)
            .panel(stateViewer)
            .build();

        clientToolbar.addNavigation(stateViewerButton);

        // Perform an initial update of the state viewer
        clientThread.invokeLater(() -> {
            try {
                // Wait until client is fully loaded before generating initial state
                if (client == null || client.getGameState() != GameState.LOGGED_IN) {
                    logInfo("Client not ready for initial state update, will update on first game tick");
                    return;
                }
                
                // Additional safety check for scene
                if (client.getScene() == null) {
                    logInfo("Scene not available yet, will update state on first game tick");
                    return;
                }
                
                logInfo("Generating initial game state");
                JsonNode initialState = generateGameState();
                if (initialState != null) {
                    // Store the initial state
                    latestGameState = initialState;
                    
                    // Update the UI with the initial state
                    SwingUtilities.invokeLater(() -> {
                        stateViewer.updateState(initialState);
                        logInfo("State viewer initialized with initial game state");
                    });
                } else {
                    logInfo("Initial game state generation returned null, will update on first game tick");
                }
            } catch (Exception e) {
                logError("Error initializing state viewer: " + e.getMessage());
                e.printStackTrace();
                logInfo("State viewer will be updated on first game tick");
            }
        });
    }
    
    @Override
    protected void shutDown() {
        logInfo("Shutting down RLBot plugin");
        keyManager.unregisterKeyListener(this);
        stopWebSocketServer();
        isRunning = false;
        
        // Remove the overlay
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
        if (webSocketServer != null) {
            logInfo("WebSocket server already running");
            return;
        }

        try {
            // Use port 43595 by default to match Python client
            int port = config.getPort() > 0 ? config.getPort() : 43595;
            logInfo("Starting WebSocket server on port " + port);
            
            RLBotWebSocketServer server = new RLBotWebSocketServer(new InetSocketAddress("localhost", port));
            webSocketServer = server;
            
            // Server configuration
            server.setReuseAddr(true);
            server.setConnectionLostTimeout(300); // Increased timeout to 5 minutes
            
            // Start the server in a separate thread
            Thread serverThread = new Thread(() -> {
                try {
                    server.start();
                } catch (Exception e) {
                    logError("Error in WebSocket server thread: " + e.getMessage());
                    e.printStackTrace();
                }
            }, "websocket-server");
            serverThread.setDaemon(true);
            serverThread.start();
            
            // Wait for server to start
            int maxWaitTime = 10000; // 10 seconds
            long startTime = System.currentTimeMillis();
            while (!server.isStarted() && System.currentTimeMillis() - startTime < maxWaitTime) {
                Thread.sleep(100);
            }
            
            if (!server.isStarted()) {
                logError("WebSocket server failed to start within timeout period");
                stopWebSocketServer();
                return;
            }
            
            // Create a thread to periodically log connection status
            Thread monitorThread = new Thread(() -> {
                try {
                    while (webSocketServer != null) {
                        Thread.sleep(60000); // Log every minute
                        if (webSocketServer.getConnections().isEmpty()) {
                            logInfo("WebSocket server running but no active connections");
                        } else {
                            logInfo("WebSocket server has " + webSocketServer.getConnections().size() + " active connections");
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "ws-monitor");
            monitorThread.setDaemon(true);
            monitorThread.start();
            
        } catch (Exception e) {
            logError("Error starting WebSocket server: " + e.getMessage());
            e.printStackTrace();
            if (webSocketServer != null) {
                try {
                    webSocketServer.stop();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                webSocketServer = null;
            }
        }
    }

    private void stopWebSocketServer() {
        if (webSocketServer == null) return;

        try {
            webSocketServer.stop();
            logInfo("WebSocket server stopped");
        } catch (InterruptedException e) {
            logError("Error stopping server: " + e.getMessage());
        }
    }

    private void updateStateViewer(JsonNode gameState) {
        // Store the latest game state but don't update UI
        if (gameState == null) {
            logError("Cannot update state viewer - game state is null");
            return;
        }
        
        // Just store the state for later refresh - don't update UI
        this.latestGameState = gameState;
        logDebug("Game state stored for manual refresh");
    }
    
    @Subscribe
    public void onGameTick(GameTick tick) {
        tickCount++;
        
        // Track mouse position for cursor trail - always update regardless of whether bot is running
        net.runelite.api.Point mouseCanvasPosition = client.getMouseCanvasPosition();
        if (mouseCanvasPosition != null) {
            java.awt.Point point = new java.awt.Point((int)mouseCanvasPosition.getX(), (int)mouseCanvasPosition.getY());
            overlay.updateCursorPosition(point);
        }
        
        if (!isRunning) return;
        
        // Update exploration data periodically - every 10 ticks
        if (tickCount % 10 == 0) {
            updateExplorationData();
        }
        
        // Original code for getting game state
        latestGameState = generateGameState();
    }

    private void logUpperLevelWidgetIds()
    {
        // Execute on the client thread to ensure thread safety
        clientThread.invoke(() -> {
            if (client == null || client.getGameState() != GameState.LOGGED_IN)
            {
                logInfo("Client not ready for widget logging");
                return;
            }
            
            Widget[] rootWidgets = client.getWidgetRoots();
            if (rootWidgets == null || rootWidgets.length == 0)
            {
                logInfo("No root widgets found");
                return;
            }
            
            StringBuilder sb = new StringBuilder("Upper level widget IDs:\n");
            for (Widget widget : rootWidgets)
            {
                if (widget != null)
                {
                    sb.append(String.format("ID: %d, Group ID: %d, Child ID: %d, Type: %d, IsVisible: %b, Text: %s\n",
                            widget.getId(), widget.getParentId(), widget.getIndex(),
                            widget.getType(), !widget.isHidden(), widget.getText()));
                }
            }
            
            logInfo(sb.toString());
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
                    // Skip interface actions for now
                    logWarn("Interface actions are not implemented yet");
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
                
                // Remove overlay update
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
                    // Remove overlay update
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
            
            // Remove overlay update
            
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
        ObjectComposition objComp = client.getObjectDefinition(obj.getId());
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

        // We don't need to update experience for the simplified overlay
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        if (!isRunning) {
            return;
        }

        if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
            clientThread.invoke(() -> {
                try {
                    // Clear trail on login
                    overlay.clearTrail();
                    logInfo("Game state changed to logged in");
                } catch (Exception e) {
                    logError("Error handling game state change: " + e.getMessage());
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
                    // We don't need to track NPC kills for the simplified overlay
                    logInfo("NPC killed: " + npc.getName());
                } catch (Exception e) {
                    logError("Error handling NPC despawn: " + e.getMessage());
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
                        // We don't need to track damage for the simplified overlay
                        logDebug("Damage dealt: " + hitsplat.getAmount());
                    } catch (Exception e) {
                        logError("Error handling hitsplat: " + e.getMessage());
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
        List<TileItem> itemsList = tile.getGroundItems();
        if (itemsList == null) return null;

        // Find the item with matching name
        for (TileItem item : itemsList) {
            if (item == null) continue;
            
            ItemComposition itemComp = client.getItemDefinition(item.getId());
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
            
            // Skip if we're taking screenshots too frequently
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastScreenshotTime < SCREENSHOT_COOLDOWN) {
                return lastScreenshot;  // Return the most recent screenshot instead
            }
            
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

                            String encoded = Base64.getEncoder().encodeToString(out.toByteArray());
                            lastScreenshot = encoded;  // Cache the screenshot
                            lastScreenshotTime = currentTime;  // Update timestamp
                            
                            future.complete(encoded);
                        } catch (Exception e) {
                            future.complete(null);
                            logError("Error processing screenshot frame: " + e.getMessage());
                        }
                    });
                } catch (Exception e) {
                    future.complete(null);
                    logError("Error requesting screenshot frame: " + e.getMessage());
                }
            });

            return future.get(500, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            logError("Error capturing screenshot: " + e.getMessage());
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

    public JsonNode generateGameState() {
        if (client == null || !client.getGameState().equals(GameState.LOGGED_IN)) {
            logInfo("Cannot generate game state - client not logged in");
            return null;
        }

        ObjectNode state = objectMapper.createObjectNode();

        try {
            // Player info
            ObjectNode player = state.putObject("player");
            Player localPlayer = client.getLocalPlayer();
            
            if (localPlayer == null) {
                logInfo("Cannot generate game state - local player is null");
                return null;
            }
            
            // Location info
            ObjectNode locationNode = player.putObject("location");
            WorldPoint location = localPlayer.getWorldLocation();
            locationNode.put("x", location.getX());
            locationNode.put("y", location.getY());
            locationNode.put("plane", location.getPlane());
            
            // Health info
            ObjectNode healthNode = player.putObject("health");
            healthNode.put("current", client.getBoostedSkillLevel(Skill.HITPOINTS));
            healthNode.put("maximum", client.getRealSkillLevel(Skill.HITPOINTS));
            
            player.put("inCombat", localPlayer.getInteracting() != null);
            player.put("isRunning", client.getVarpValue(173) == 1);
            player.put("runEnergy", client.getEnergy());
            
            // Skills info
            ObjectNode skills = player.putObject("skills");
            for (Skill skill : Skill.values()) {
                ObjectNode skillNode = skills.putObject(skill.getName().toLowerCase());
                skillNode.put("level", client.getBoostedSkillLevel(skill));
                skillNode.put("realLevel", client.getRealSkillLevel(skill));
                skillNode.put("experience", client.getSkillExperience(skill));
            }

            // NPCs array
            ArrayNode npcs = state.putArray("npcs");
            for (NPC npc : client.getNpcs()) {
                if (npc == null) continue;
                ObjectNode npcNode = npcs.addObject();
                npcNode.put("id", npc.getId());
                String npcName = npc.getName();
                npcNode.put("name", npcName != null ? npcName : "");
                npcNode.put("combatLevel", npc.getCombatLevel());
                
                WorldPoint npcLoc = npc.getWorldLocation();
                ObjectNode npcLocation = npcNode.putObject("location");
                npcLocation.put("x", npcLoc.getX());
                npcLocation.put("y", npcLoc.getY());
                npcLocation.put("plane", npcLoc.getPlane());
                
                ObjectNode npcHealth = npcNode.putObject("health");
                Integer healthRatio = npc.getHealthRatio();
                npcHealth.put("current", healthRatio != null ? healthRatio : 100);
                npcHealth.put("maximum", 100);
                
                npcNode.put("interacting", npc.getInteracting() != null);
                npcNode.put("distance", location.distanceTo(npcLoc));
            }

            // Objects array
            ArrayNode objects = state.putArray("objects");
            Scene scene = client.getScene();
            if (scene != null) {
                Tile[][][] tiles = scene.getTiles();
                if (tiles != null) {
                    int z = client.getPlane();
                    for (int x = 0; x < Constants.SCENE_SIZE; x++) {
                        for (int y = 0; y < Constants.SCENE_SIZE; y++) {
                            Tile tile = tiles[z][x][y];
                            if (tile == null) continue;
                            
                            GameObject[] gameObjects = tile.getGameObjects();
                            if (gameObjects != null) {
                                for (GameObject obj : gameObjects) {
                                    if (obj == null) continue;
                                    ObjectNode objNode = objects.addObject();
                                    objNode.put("id", obj.getId());
                                    
                                    WorldPoint objLoc = obj.getWorldLocation();
                                    ObjectNode objLocation = objNode.putObject("location");
                                    objLocation.put("x", objLoc.getX());
                                    objLocation.put("y", objLoc.getY());
                                    objLocation.put("plane", objLoc.getPlane());
                                    
                                    objNode.put("name", objectComposition(obj) != null ? objectComposition(obj) : "");
                                    
                                    // Add actions array
                                    ObjectComposition objComp = client.getObjectDefinition(obj.getId());
                                    if (objComp != null && objComp.getActions() != null) {
                                        ArrayNode actions = objNode.putArray("actions");
                                        for (String action : objComp.getActions()) {
                                            if (action != null) {
                                                actions.add(action);
                                            } else {
                                                // Add empty string for null actions to ensure consistent types
                                                actions.add("");
                                            }
                                        }
                                    } else {
                                        // Ensure actions is at least an empty array
                                        objNode.putArray("actions");
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Ground items array
            ArrayNode groundItems = state.putArray("groundItems");
            if (scene != null && scene.getTiles() != null) {
                int z = client.getPlane();
                for (Tile[][] plane : scene.getTiles()) {
                    if (plane == null) continue;
                    for (Tile[] row : plane) {
                        if (row == null) continue;
                        for (Tile tile : row) {
                            if (tile == null) continue;
                            List<TileItem> items = tile.getGroundItems();
                            if (items == null) continue;
                            for (TileItem item : items) {
                                if (item == null || item.getId() <= 0) continue;  // Changed from -1 to handle null case
                                ObjectNode itemNode = groundItems.addObject();
                                itemNode.put("id", item.getId());
                                itemNode.put("name", itemManager.getItemComposition(item.getId()).getName());
                                itemNode.put("quantity", item.getQuantity());
                                
                                WorldPoint itemLoc = tile.getWorldLocation();
                                ObjectNode itemLocation = itemNode.putObject("location");
                                itemLocation.put("x", itemLoc.getX());
                                itemLocation.put("y", itemLoc.getY());
                                itemLocation.put("plane", itemLoc.getPlane());
                            }
                        }
                    }
                }
            }

            // Add interfaces array
            ArrayNode interfaces = state.putArray("interfaces");
            Widget[] widgets = client.getWidgetRoots();
            if (widgets != null) {
                for (Widget widget : widgets) {
                    if (widget == null || widget.isHidden()) continue;
                    ObjectNode interfaceNode = interfaces.addObject();
                    interfaceNode.put("id", widget.getId());
                    interfaceNode.put("type", String.valueOf(widget.getType()));
                    // Ensure widget text is always a string
                    String text = widget.getText();
                    interfaceNode.put("text", text != null ? text : "");
                    
                    // Add actions array
                    if (widget.getActions() != null) {
                        ArrayNode actions = interfaceNode.putArray("actions");
                        for (String action : widget.getActions()) {
                            if (action != null) {
                                actions.add(action);
                            } else {
                                // Add empty string for null actions to ensure consistent types
                                actions.add("");
                            }
                        }
                    } else {
                        // Ensure actions is at least an empty array
                        interfaceNode.putArray("actions");
                    }
                }
            }

            // Add interface and path state
            state.put("interfacesOpen", isInterfaceOpen());
            state.put("pathObstructed", false);

            // Add exploration info
            ObjectNode exploration = state.putObject("exploration");
            ObjectNode currentChunk = exploration.putObject("currentChunk");
            Point chunk = worldToChunk(location);
            currentChunk.put("x", chunk.x);
            currentChunk.put("y", chunk.y);
            exploration.put("visitedChunks", visitedChunks.size());

            return state;
        } catch (Exception e) {
            logError("Error generating game state: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private String objectComposition(GameObject object) {
        if (object == null) {
            return "null";
        }
        ObjectComposition def = client.getObjectDefinition(object.getId());
        return def != null ? def.getName() : "unknown";
    }

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

    public RLBotStateViewer getStateViewer() {
        return stateViewer;
    }

    private class RLBotWebSocketServer extends WebSocketServer {
        private volatile boolean hasStarted = false;
        
        public RLBotWebSocketServer(InetSocketAddress address) {
            super(address);
        }
        
        @Override
        public void onOpen(WebSocket conn, ClientHandshake handshake) {
            String address = conn.getRemoteSocketAddress().toString();
            logInfo("New WebSocket connection established from " + address);
            
            // Send initial state to new connection using client thread and wait for result
            clientThread.invoke(() -> {
                try {
                    logInfo("Generating initial state on client thread for new connection: " + address);
                    JsonNode gameState = generateGameState();
                    if (gameState != null) {
                        final String stateJson = objectMapper.writeValueAsString(gameState);
                        conn.send(stateJson);
                        logInfo("Sent initial state to new connection: " + address);
                    } else {
                        logError("Failed to generate initial state for: " + address);
                        ObjectNode errorResponse = objectMapper.createObjectNode();
                        errorResponse.put("error", "Failed to generate initial state: The player might not be logged in");
                        conn.send(errorResponse.toString());
                    }
                } catch (Exception e) {
                    logError("Error generating initial state: " + e.getMessage());
                    try {
                        ObjectNode errorResponse = objectMapper.createObjectNode();
                        errorResponse.put("error", "Failed to generate initial state: " + e.getMessage());
                        conn.send(errorResponse.toString());
                    } catch (Exception sendError) {
                        logError("Error sending error response: " + sendError.getMessage());
                    }
                }
            });
        }

        @Override
        public void onMessage(WebSocket conn, String message) {
            // Always use the client thread for any game-related processing
            clientThread.invoke(() -> {
                try {
                    logInfo("Processing message on client thread: " + message);
                    if (message.equals("state") || message.equals("getState")) {
                        JsonNode gameState = generateGameState();
                        final String response;
                        if (gameState != null) {
                            response = objectMapper.writeValueAsString(gameState);
                            logInfo("Generated state in response to request");
                        } else {
                            logError("Failed to generate game state for request");
                            response = "{\"error\": \"Failed to generate game state\"}";
                        }
                        
                        conn.send(response);
                    } else {
                        // Process other commands
                        logInfo("Processing command: " + message);
                        validateAndProcessCommand(message);
                        
                        // Send updated state after processing command
                        JsonNode gameState = generateGameState();
                        if (gameState != null) {
                            final String stateJson = objectMapper.writeValueAsString(gameState);
                            conn.send(stateJson);
                            logInfo("Sent updated state after command");
                        }
                    }
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
            });
        }

        @Override
        public void onClose(WebSocket conn, int code, String reason, boolean remote) {
            logInfo("WebSocket connection closed: " + conn.getRemoteSocketAddress() + 
                   ", code: " + code + ", reason: " + reason + ", remote: " + remote);
        }

        @Override
        public void onError(WebSocket conn, Exception ex) {
            String address = conn != null ? conn.getRemoteSocketAddress().toString() : "unknown";
            logError("WebSocket error with " + address + ": " + ex.getMessage());
            ex.printStackTrace();
        }

        @Override
        public void onStart() {
            hasStarted = true;
            logInfo("WebSocket server started successfully on port " + getPort());
            logInfo("Connect using: ws://localhost:" + getPort());
        }

        public boolean isStarted() {
            return hasStarted;
        }
    }
} 
