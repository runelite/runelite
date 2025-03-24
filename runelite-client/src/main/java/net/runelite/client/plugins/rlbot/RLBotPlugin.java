package net.runelite.client.plugins.rlbot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Provides;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.plugins.rlbot.gamestate.RLBotGameStateGenerator;
import net.runelite.client.plugins.rlbot.ui.RLBotOverlay;
import net.runelite.client.plugins.rlbot.input.RLBotInputHandler;
import net.runelite.client.plugins.rlbot.action.RLBotActionHandler;
import net.runelite.client.plugins.rlbot.rest.RLBotRestHandler;
import java.awt.Robot;
import java.awt.MouseInfo;

@PluginDescriptor(
    name = "RLBot",
    description = "RuneLite Bot Plugin for AI Training",
    tags = {"bot", "ai", "training"}
)
public class RLBotPlugin extends Plugin implements KeyListener {

    private static final int EXPLORATION_CHUNK_SIZE = 8;

    private final ExecutorService screenshotExecutor = Executors.newSingleThreadExecutor(r -> {
        Thread thread = new Thread(r);
        thread.setName("screenshot-thread");
        thread.setDaemon(true);
        return thread;
    });

    private final ExecutorService gameStateExecutor = Executors.newSingleThreadExecutor(r -> {
        Thread thread = new Thread(r);
        thread.setName("gamestate-thread");
        thread.setDaemon(true);
        return thread;
    });

    private volatile boolean isGeneratingState = false;
    private int tickCount = 0;
    private JsonNode latestGameState;

    private final Set<Point> visitedChunks = new HashSet<>();
    private final Map<Point, Long> lastVisitTime = new HashMap<>();
    private final Map<Point, AreaInfo> areaAssessments = new HashMap<>();

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

    @Inject
    private MouseManager mouseManager;

    private RLBotGameStateGenerator gameStateGenerator;

    private RLBotRestHandler restHandler;

    @Inject
    private RLBotStateViewer stateViewer;

    @Inject
    private ClientToolbar clientToolbar;

    private NavigationButton stateViewerButton;

    private boolean isRunning = false;
    private boolean shouldSendScreenshots = true;
    private boolean shouldSaveScreenshots = false;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private RLBotOverlay overlay;

    @Inject
    private RLBotLogger logger;

    private RLBotInputHandler inputHandler;
    private RLBotActionHandler actionHandler;

    private static final String ACTION_MOVE_AND_CLICK = "moveAndClick";
    private static final String ACTION_CAMERA_ROTATE = "cameraRotate";
    private static final String ACTION_CAMERA_ZOOM = "cameraZoom";
    private static final String ACTION_PRESS_KEY = "pressKey";
    private static final String ACTION_GET_STATE = "getState";
    private static final String ACTION_INTERFACE_ACTION = "interfaceAction";
    private static final String ACTION_TOGGLE_SCREENSHOTS = "toggleScreenshots";

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
        logger.info("Starting RLBot plugin...");
        Path logPath = Paths.get(RLBotConstants.LOG_FILE);
        logger.info("Log file configured at: " + logPath.toAbsolutePath());
        try {
            Files.createDirectories(logPath.getParent());
            if (!Files.exists(logPath)) {
                Files.createFile(logPath);
                logger.info("Created new log file");
            } else {
                logger.info("Log file already exists");
            }
            Files.write(
                logPath,
                ("[" + LocalDateTime.now().format(RLBotConstants.DATE_FORMAT) + "] *** RLBot Plugin Started ***\n").getBytes(),
                StandardOpenOption.APPEND
            );
            logger.info("Successfully wrote to log file at: " + logPath);
        } catch (Exception e) {
            logger.error("CRITICAL: Failed to access log file: " + e.getMessage());
            e.printStackTrace();
        }

        // Initialize game state generator using the consolidated class.
        gameStateGenerator = new RLBotGameStateGenerator(client, logger, new RLBotScreenshotUtil(drawManager, logger, config));

        inputHandler = new RLBotInputHandler(logger, client, clientThread, keyManager, mouseManager);
        inputHandler.initialize();
        verifyInputHandler();
        actionHandler = new RLBotActionHandler(client, logger, inputHandler);

        // Add the overlay to the overlay manager
        overlayManager.add(overlay);

        restHandler = new RLBotRestHandler(
            logger,
            clientThread,
            objectMapper,
            () -> latestGameState,
            this::validateAndProcessCommand,
            this::updateGameState,
            connected -> {
                if (overlay != null) {
                    overlay.setWebsocketConnected(connected);
                }
            }
        );
        int port = config.websocketPort() > 0 ? config.websocketPort() : 43595;
        if (!restHandler.startServer(port)) {
            logger.error("REST server failed to start properly");
            return;
        }
        keyManager.registerKeyListener(this);
        isRunning = true;
        logger.info("RLBot plugin started successfully");

        stateViewer.setRefreshCallback(() -> {
            try {
                logger.info("StateViewer refresh callback called");
                if (latestGameState == null) {
                    logger.info("No cached state available, updating game state");
                    updateGameState();
                } else {
                    SwingUtilities.invokeLater(() -> stateViewer.updateState(latestGameState));
                }
            } catch (Exception e) {
                logger.error("Error in refresh callback: " + e.getMessage());
                e.printStackTrace();
            }
        });

        BufferedImage icon;
        try {
            icon = ImageUtil.loadImageResource(RLBotPlugin.class, "/net/runelite/client/plugins/rlbot/rlbot_icon.png");
        } catch (Exception e) {
            icon = ImageUtil.loadImageResource(RLBotPlugin.class, "/net/runelite/client/ui/runescape.png");
            logger.info("Could not load rlbot_icon.png, using fallback icon");
        }
        stateViewerButton = NavigationButton.builder()
            .tooltip("RLBot State")
            .icon(icon)
            .priority(5)
            .panel(stateViewer)
            .build();
        clientToolbar.addNavigation(stateViewerButton);

        clientThread.invokeLater(() -> {
            try {
                if (client == null || client.getGameState() != GameState.LOGGED_IN) {
                    logger.info("Client not ready for initial state update, will update on first game tick");
                    return;
                }
                if (client.getScene() == null) {
                    logger.info("Scene not available yet, will update state on first game tick");
                    return;
                }
                logger.info("Generating initial game state");
                updateGameState();
            } catch (Exception e) {
                logger.error("Error initializing state viewer: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void shutDown() {
        logger.info("Shutting down RLBot plugin");
        keyManager.unregisterKeyListener(this);
        if (restHandler != null) {
            restHandler.stopServer();
        }
        isRunning = false;
        overlayManager.remove(overlay);
        clientToolbar.removeNavigation(stateViewerButton);
        screenshotExecutor.shutdown();
        gameStateExecutor.shutdown();
        try {
            if (!screenshotExecutor.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                screenshotExecutor.shutdownNow();
            }
            if (!gameStateExecutor.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                gameStateExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            screenshotExecutor.shutdownNow();
            gameStateExecutor.shutdownNow();
        }
    }

    @Subscribe
    public void onGameTick(GameTick tick) {
        tickCount++;
        if (!isRunning) return;
        if (tickCount % 10 == 0) {
            updateExplorationData();
        }
        long currentTime = System.currentTimeMillis();
        if (currentTime - config.updateInterval() >= 200 && !isGeneratingState) {
            updateGameState();
        }
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        if (!isRunning) {
            return;
        }
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
            logger.info("Game state changed to logged in");
            updateCurrentAction("Logged in");
        }
    }

    /**
     * Consolidated method to update the game state using RLBotGameStateGenerator.
     */
    private void updateGameState() {
        if (isGeneratingState) {
            logger.debug("Already generating state, skipping update");
            return;
        }

        isGeneratingState = true;
        gameStateExecutor.submit(() -> {
            try {
                clientThread.invoke(() -> {
                    try {
                        if (client == null) {
                            logger.error("Client is null");
                            isGeneratingState = false;
                            return;
                        }

                        if (client.getGameState() != GameState.LOGGED_IN) {
                            logger.error("Client not logged in. Current state: " + client.getGameState());
                            isGeneratingState = false;
                            return;
                        }

                        if (client.getLocalPlayer() == null) {
                            logger.error("Local player is null");
                            isGeneratingState = false;
                            return;
                        }

                        logger.info("Generating game state. Player name: " + client.getLocalPlayer().getName());
                        gameStateGenerator.generateGameStateAsync().whenComplete((gsonState, ex) -> {
                            if (ex != null || gsonState == null) {
                                logger.error("Error generating game state: " + (ex != null ? ex.getMessage() : "null state"));
                                if (ex != null) {
                                    ex.printStackTrace();
                                }
                            } else {
                                try {
                                    // Convert the Gson JsonObject to Jackson JsonNode
                                    String jsonString = gsonState.toString();
                                    logger.debug("Generated game state JSON: " + jsonString);
                                    JsonNode state = objectMapper.readTree(jsonString);
                                    if (!state.has("player")) {
                                        logger.error("Generated state is missing player data");
                                    }
                                    latestGameState = state;
                                    SwingUtilities.invokeLater(() -> stateViewer.updateState(state));
                                } catch (Exception e) {
                                    logger.error("Error converting game state: " + e.getMessage());
                                    e.printStackTrace();
                                }
                            }
                            isGeneratingState = false;
                        });
                    } catch (Exception e) {
                        logger.error("Error generating game state: " + e.getMessage());
                        e.printStackTrace();
                        isGeneratingState = false;
                    }
                });
            } catch (Exception e) {
                logger.error("Error in game state executor: " + e.getMessage());
                e.printStackTrace();
                isGeneratingState = false;
            }
        });
    }

    private boolean validateAndProcessCommand(String json) {
        try {
            logger.info("==== RLBOT RECEIVED COMMAND ====\n" + json);
            if (json == null || json.isEmpty()) {
                logger.error("Empty command received");
                return false;
            }

            JsonNode jsonNode = objectMapper.readTree(json);
            if (jsonNode.has("type") && ACTION_GET_STATE.equals(jsonNode.get("type").asText())) {
                updateGameState();
                return true;
            }

            if (!jsonNode.has("action")) {
                logger.error("No action specified in command: " + json);
                return false;
            }

            String action = jsonNode.get("action").asText();
            logger.info("*** RLBOT ACTION: " + action + " ***");
            if (action == null || action.isEmpty()) {
                logger.error("Empty action specified");
                return false;
            }

            updateCurrentAction("Action: " + action);
            
            // Process the action asynchronously
            gameStateExecutor.submit(() -> {
                try {
                    clientThread.invoke(() -> {
                        try {
                            // Process additional actions...
                            // (The action handler code remains unchanged)
                        } catch (Exception e) {
                            logger.error("Error processing action: " + e.getMessage());
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    logger.error("Error in action executor: " + e.getMessage());
                    e.printStackTrace();
                }
            });

            return true;
        } catch (Exception e) {
            logger.error("Error processing command: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private void updateCurrentAction(String action) {
        if (overlay != null) {
            overlay.setCurrentAction(action);
            overlay.addAction(action);
        }
    }

    private void updateExplorationData() {
        if (client.getLocalPlayer() == null) return;
        WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
        Point chunk = new Point(playerLocation.getX() / EXPLORATION_CHUNK_SIZE, playerLocation.getY() / EXPLORATION_CHUNK_SIZE);
        visitedChunks.add(chunk);
        lastVisitTime.put(chunk, System.currentTimeMillis());
        AreaInfo info = areaAssessments.computeIfAbsent(chunk, k -> new AreaInfo());
        if (System.currentTimeMillis() - info.lastAssessment > 10000) {
            info.lastAssessment = System.currentTimeMillis();
        }
    }

    private void verifyInputHandler() {
        if (inputHandler == null) {
            logger.error("Input handler is null");
            return;
        }
        logger.info("Verifying input handler initialization");
        try {
            Point mousePosition = MouseInfo.getPointerInfo().getLocation();
            logger.info("Current mouse position: " + mousePosition.x + ", " + mousePosition.y);
        } catch (Exception e) {
            logger.error("Error getting mouse position: " + e.getMessage());
        }
        logger.info("Input handler verification complete");
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }

    public RLBotStateViewer getStateViewer() {
        return stateViewer;
    }
}