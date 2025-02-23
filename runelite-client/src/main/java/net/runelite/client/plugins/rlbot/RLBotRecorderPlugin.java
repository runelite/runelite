package net.runelite.client.plugins.rlbot;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.DrawManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Base64;
import java.awt.Canvas;

@PluginDescriptor(
    name = "RLBot Recorder",
    description = "Records human gameplay for imitation learning",
    tags = {"bot", "ai", "training", "recording"}
)
public class RLBotRecorderPlugin extends Plugin {
    private static final String RECORDINGS_DIR = "/Users/danielgleason/Desktop/Code/my_code/runescape_bot_runelite/rlbot/recordings";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
    private static final int SCREENSHOT_INTERVAL = 5; // Take screenshot every 5 game ticks
    
    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private RLBotConfig config;

    @Inject
    private ObjectMapper objectMapper;

    @Inject
    private DrawManager drawManager;

    private boolean isRecording = false;
    private String currentRecordingDir;
    private int tickCount = 0;
    private ConcurrentLinkedQueue<GameAction> actionQueue = new ConcurrentLinkedQueue<>();
    private long lastActionTime = 0;
    private static final long MIN_ACTION_INTERVAL = 50; // Minimum 50ms between actions

    private class GameAction {
        String type;
        int x;
        int y;
        int button;
        long timestamp;
        String key;

        GameAction(String type, int x, int y, int button) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.button = button;
            this.timestamp = System.currentTimeMillis();
        }

        GameAction(String type, String key) {
            this.type = type;
            this.key = key;
            this.timestamp = System.currentTimeMillis();
        }
    }

    @Provides
    RLBotConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(RLBotConfig.class);
    }

    @Override
    protected void startUp() {
        try {
            Files.createDirectories(Paths.get(RECORDINGS_DIR));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startRecording() {
        if (isRecording) return;
        
        String timestamp = LocalDateTime.now().format(DATE_FORMAT);
        currentRecordingDir = RECORDINGS_DIR + "/" + timestamp;
        try {
            Files.createDirectories(Paths.get(currentRecordingDir));
            Files.createDirectories(Paths.get(currentRecordingDir + "/screenshots"));
            Files.createDirectories(Paths.get(currentRecordingDir + "/actions"));
            isRecording = true;
            tickCount = 0;
            actionQueue.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopRecording() {
        isRecording = false;
        // Save any remaining actions
        saveActions();
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        if (!isRecording || client.getGameState() != net.runelite.api.GameState.LOGGED_IN) return;

        tickCount++;
        
        // Save actions from queue
        saveActions();

        // Take screenshot every SCREENSHOT_INTERVAL ticks
        if (tickCount % SCREENSHOT_INTERVAL == 0) {
            takeScreenshot();
        }

        // Save game state
        saveGameState();
    }

    private void takeScreenshot() {
        drawManager.requestNextFrameListener(image -> {
            try {
                String filename = String.format("%s/screenshots/screenshot_%d.png", currentRecordingDir, tickCount);
                BufferedImage bufferedImage = (BufferedImage) image;
                ImageIO.write(bufferedImage, "png", new File(filename));
                
                // Also save as base64 for consistency with training data
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", outputStream);
                String base64Screenshot = Base64.getEncoder().encodeToString(outputStream.toByteArray());
                
                String base64Filename = String.format("%s/screenshots/screenshot_%d.b64", currentRecordingDir, tickCount);
                Files.write(Paths.get(base64Filename), base64Screenshot.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void saveGameState() {
        try {
            String filename = String.format("%s/state_%d.json", currentRecordingDir, tickCount);
            objectMapper.writeValue(new File(filename), generateGameState());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveActions() {
        if (actionQueue.isEmpty()) return;

        try {
            String filename = String.format("%s/actions/actions_%d.json", currentRecordingDir, tickCount);
            objectMapper.writeValue(new File(filename), actionQueue.toArray());
            actionQueue.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void onClientTick(ClientTick event) {
        if (!isRecording) return;
        
        // Get current mouse position
        net.runelite.api.Point mousePos = client.getMouseCanvasPosition();
        if (mousePos != null) {
            // Record mouse movement
            queueAction(new GameAction("move", mousePos.getX(), mousePos.getY(), -1));
        }
    }

    @Subscribe
    public void onFocusChanged(FocusChanged event) {
        if (!isRecording) return;
        queueAction(new GameAction("focus", event.isFocused() ? "gained" : "lost"));
    }

    private boolean isGameCanvasClick(MouseEvent event) {
        Canvas canvas = client.getCanvas();
        return canvas != null && event.getSource() == canvas;
    }

    private boolean isGameCanvasKey(KeyEvent event) {
        Canvas canvas = client.getCanvas();
        return canvas != null && event.getSource() == canvas;
    }

    private void queueAction(GameAction action) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastActionTime >= MIN_ACTION_INTERVAL) {
            actionQueue.offer(action);
            lastActionTime = currentTime;
        }
    }

    private JsonNode generateGameState() {
        ObjectNode state = objectMapper.createObjectNode();
        
        // Add player info
        if (client.getLocalPlayer() != null) {
            ObjectNode player = objectMapper.createObjectNode();
            WorldPoint pos = client.getLocalPlayer().getWorldLocation();
            
            ObjectNode location = objectMapper.createObjectNode();
            location.put("x", pos.getX());
            location.put("y", pos.getY());
            location.put("plane", pos.getPlane());
            player.set("location", location);
            
            player.put("health", client.getBoostedSkillLevel(Skill.HITPOINTS));
            player.put("maxHealth", client.getRealSkillLevel(Skill.HITPOINTS));
            player.put("inCombat", client.getLocalPlayer().getInteracting() != null);
            
            state.set("player", player);
        }
        
        return state;
    }
} 