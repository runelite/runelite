package net.runelite.client.plugins.rlbot;

import com.google.inject.Provides;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Skill;
import net.runelite.api.VarClientInt;
import net.runelite.api.ScriptID;
import net.runelite.api.events.GameTick;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import com.google.gson.Gson;
import lombok.Getter;
import net.runelite.api.MenuAction;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.Actor;
import net.runelite.api.Hitsplat;
import net.runelite.api.events.StatChanged;

@PluginDescriptor(
    name = "RLBot",
    description = "Plugin for bot control via WebSocket",
    tags = {"bot", "automation"}
)
@Slf4j
public class RLBotPlugin extends Plugin {
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

    private WebSocketServer server;
    private boolean isRunning = false;

    // Constants for movement
    private static final int MOVE_DISTANCE = 3;
    private static final int CAMERA_ROTATE_AMOUNT = 45;
    private static final float CAMERA_ZOOM_AMOUNT = 25f;

    @Inject
    private RLBotOverlay overlay;

    @Getter
    private int lastCursorX = -1;
    @Getter
    private int lastCursorY = -1;
    @Getter
    private String lastCursorColor = "yellow";
    @Getter
    private long lastCursorTime = 0;

    private static final int CURSOR_MOVE_DELAY = 50; // ms delay after cursor movement
    private static final int ACTION_DELAY = 600; // ms delay between actions
    private static final int CURSOR_FADE_DURATION = 1000; // ms duration for cursor trail to fade
    private long lastActionTime = 0;

    @Provides
    RLBotConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(RLBotConfig.class);
    }

    @Override
    protected void startUp() {
        log.info("Starting RLBot plugin");
        overlayManager.add(overlay);
        startWebSocketServer();
    }

    @Override
    protected void shutDown() {
        log.info("Shutting down RLBot plugin");
        overlayManager.remove(overlay);
        stopWebSocketServer();
    }

    private void startWebSocketServer() {
        server = new WebSocketServer(new InetSocketAddress(config.getPort())) {
            @Override
            public void onOpen(WebSocket conn, ClientHandshake handshake) {
                log.info("New WebSocket connection established from: " + conn.getRemoteSocketAddress());
            }

            @Override
            public void onClose(WebSocket conn, int code, String reason, boolean remote) {
                log.info("WebSocket connection closed: " + reason);
            }

            @Override
            public void onMessage(WebSocket conn, String message) {
                log.info("Received message from " + conn.getRemoteSocketAddress() + ": " + message);
                try {
                    Map<String, Object> data = gson.fromJson(message, Map.class);
                    String action = (String) data.get("action");
                    Map<String, Object> actionData = (Map<String, Object>) data.get("data");
                    
                    switch (action) {
                        case "move":
                            handleMove(actionData);
                            break;
                        case "camera_rotate":
                            handleCameraRotate(actionData);
                            break;
                        case "camera_zoom":
                            handleCameraZoom(actionData);
                            break;
                        case "attack":
                            handleAttack(actionData);
                            break;
                        case "click":
                            handleClick(actionData);
                            break;
                        case "mousemove":
                            handleMouseMove(actionData);
                            break;
                        case "interact":
                            handleInteract(actionData);
                            break;
                        default:
                            log.warn("Unknown action: {}", action);
                    }
                } catch (Exception e) {
                    log.error("Error handling message", e);
                }
            }

            @Override
            public void onError(WebSocket conn, Exception ex) {
                log.error("WebSocket error", ex);
            }

            @Override
            public void onStart() {
                log.info("WebSocket server started on port " + config.getPort());
                isRunning = true;
            }
        };

        server.start();
    }

    private void stopWebSocketServer() {
        if (server != null && isRunning) {
            try {
                server.stop();
                isRunning = false;
            } catch (InterruptedException e) {
                log.error("Error stopping WebSocket server", e);
            }
        }
    }

    private MouseEvent createMouseEvent(Point point, int button, int id) {
        return new MouseEvent(
            client.getCanvas(), // source component
            id, // id
            System.currentTimeMillis(), // when
            0, // modifiers
            point.x, // x
            point.y, // y
            1, // click count
            false, // popup trigger
            button // button
        );
    }

    private void moveCursorTo(Canvas canvas, Point target) {
        // Add delay between actions
        long currentTime = System.currentTimeMillis();
        long timeSinceLastAction = currentTime - lastActionTime;
        if (timeSinceLastAction < ACTION_DELAY) {
            try {
                Thread.sleep(ACTION_DELAY - timeSinceLastAction);
            } catch (InterruptedException e) {
                log.warn("Action delay interrupted", e);
            }
        }

        // First move cursor to position
        MouseEvent moved = createMouseEvent(target, MouseEvent.NOBUTTON, MouseEvent.MOUSE_MOVED);
        canvas.dispatchEvent(moved);
        drawCursor(target.x, target.y, "yellow");
        
        // Small delay to ensure move is registered and visible
        try {
            Thread.sleep(CURSOR_MOVE_DELAY);
        } catch (InterruptedException e) {
            log.warn("Cursor move delay interrupted", e);
        }

        lastActionTime = System.currentTimeMillis();
    }

    private void handleMove(Map<String, Object> data) {
        try {
            int worldX = ((Number) data.get("x")).intValue();
            int worldY = ((Number) data.get("y")).intValue();
            log.info("Moving to world coordinates: ({}, {})", worldX, worldY);

            clientThread.invoke(() -> {
                try {
                    WorldPoint worldPoint = new WorldPoint(worldX, worldY, client.getPlane());
                    LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);
                    if (localPoint != null) {
                        net.runelite.api.Point rlPoint = Perspective.localToCanvas(client, localPoint, client.getPlane());
                        if (rlPoint != null) {
                            Point screenPoint = new Point(rlPoint.getX(), rlPoint.getY());
                            moveCursorTo(client.getCanvas(), screenPoint);
                            dispatchMouseEvent(MouseEvent.MOUSE_PRESSED, screenPoint);
                            dispatchMouseEvent(MouseEvent.MOUSE_RELEASED, screenPoint);
                            dispatchMouseEvent(MouseEvent.MOUSE_CLICKED, screenPoint);
                            drawCursor(screenPoint.x, screenPoint.y, "yellow");
                        }
                    }
                } catch (Exception e) {
                    log.error("Error handling move", e);
                }
            });
        } catch (Exception e) {
            log.error("Error handling move command", e);
        }
    }

    private void handleCameraRotate(Map<String, Object> data) {
        boolean right = (boolean) data.get("right");
        int amount = right ? CAMERA_ROTATE_AMOUNT : -CAMERA_ROTATE_AMOUNT;
        
        clientThread.invoke(() -> {
            try {
                client.setCameraYawTarget(client.getCameraYaw() + amount);
            } catch (Exception e) {
                log.error("Error rotating camera", e);
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
                client.runScript(ScriptID.CAMERA_DO_ZOOM, newZoom, newZoom);
            } catch (Exception e) {
                log.error("Error zooming camera", e);
            }
        });
    }

    private void handleAttack(Map<String, Object> data) {
        int targetId = ((Number) data.get("targetId")).intValue();
        
        clientThread.invoke(() -> {
            try {
                // Find the NPC
                NPC target = client.getNpcs().stream()
                    .filter(npc -> npc.getIndex() == targetId)
                    .findFirst()
                    .orElse(null);
                
                if (target == null) {
                    log.error("Target NPC not found: {}", targetId);
                    return;
                }

                // Get the target's location on screen
                net.runelite.api.Point rlPoint = Perspective.localToCanvas(client, target.getLocalLocation(), client.getPlane());
                if (rlPoint == null) {
                    log.error("Target not on screen");
                    return;
                }

                Point targetPoint = new Point(rlPoint.getX(), rlPoint.getY());
                Canvas canvas = client.getCanvas();

                // Move cursor first
                moveCursorTo(canvas, targetPoint);

                // Left click to attack
                MouseEvent pressed = createMouseEvent(targetPoint, MouseEvent.BUTTON1, MouseEvent.MOUSE_PRESSED);
                canvas.dispatchEvent(pressed);
                
                MouseEvent released = createMouseEvent(targetPoint, MouseEvent.BUTTON1, MouseEvent.MOUSE_RELEASED);
                canvas.dispatchEvent(released);
                
                MouseEvent clicked = createMouseEvent(targetPoint, MouseEvent.BUTTON1, MouseEvent.MOUSE_CLICKED);
                canvas.dispatchEvent(clicked);
                
                drawCursor(targetPoint.x, targetPoint.y, "red");
            } catch (Exception e) {
                log.error("Error handling attack", e);
            }
        });
    }

    private void handleClick(Object data) {
        log.info("Handling click event: {}", data);
        
        Map<String, Object> clickData = (Map<String, Object>) data;
        double x = ((Number) clickData.get("x")).doubleValue();
        double y = ((Number) clickData.get("y")).doubleValue();
        boolean rightClick = clickData.containsKey("rightClick") && (boolean) clickData.get("rightClick");
        
        Point clickPoint = new Point((int) x, (int) y);
        log.info("Click point: {}, rightClick: {}", clickPoint, rightClick);
        
        clientThread.invoke(() -> {
            try {
                Canvas canvas = client.getCanvas();
                if (canvas == null) {
                    log.error("Canvas is null, cannot dispatch mouse events");
                    return;
                }
                
                // Move cursor first
                moveCursorTo(canvas, clickPoint);
                
                // Mouse pressed
                int button = rightClick ? MouseEvent.BUTTON3 : MouseEvent.BUTTON1;
                MouseEvent pressed = createMouseEvent(clickPoint, button, MouseEvent.MOUSE_PRESSED);
                canvas.dispatchEvent(pressed);
                drawCursor((int) x, (int) y, rightClick ? "red" : "yellow");
                
                // Mouse released
                MouseEvent released = createMouseEvent(clickPoint, button, MouseEvent.MOUSE_RELEASED);
                canvas.dispatchEvent(released);
                
                // Mouse clicked
                MouseEvent clicked = createMouseEvent(clickPoint, button, MouseEvent.MOUSE_CLICKED);
                canvas.dispatchEvent(clicked);
            } catch (Exception e) {
                log.error("Error handling click event", e);
            }
        });
    }

    private void handleMouseMove(Object data) {
        log.info("Handling mouse move event: {}", data);
        
        Map<String, Object> moveData = (Map<String, Object>) data;
        double x = ((Number) moveData.get("x")).doubleValue();
        double y = ((Number) moveData.get("y")).doubleValue();
        
        Point movePoint = new Point((int) x, (int) y);
        log.info("Move point: {}", movePoint);
        
        clientThread.invoke(() -> {
            try {
                Canvas canvas = client.getCanvas();
                if (canvas == null) {
                    log.error("Canvas is null, cannot dispatch mouse events");
                    return;
                }
                
                // Move cursor
                moveCursorTo(canvas, movePoint);
            } catch (Exception e) {
                log.error("Error handling mouse move event", e);
            }
        });
    }

    private void handleInteract(Object data) {
        log.info("Handling interact event: {}", data);
        
        Map<String, Object> interactData = (Map<String, Object>) data;
        String target = (String) interactData.get("target");
        String action = (String) interactData.get("action");
        double x = ((Number) interactData.get("x")).doubleValue();
        double y = ((Number) interactData.get("y")).doubleValue();
        
        Point interactPoint = new Point((int) x, (int) y);
        log.info("Interact point: {}, target: {}, action: {}", interactPoint, target, action);
        
        clientThread.invoke(() -> {
            try {
                Canvas canvas = client.getCanvas();
                if (canvas == null) {
                    log.error("Canvas is null, cannot dispatch mouse events");
                    return;
                }
                
                // Move cursor first
                moveCursorTo(canvas, interactPoint);
                
                // Right click to open menu
                MouseEvent pressed = createMouseEvent(interactPoint, MouseEvent.BUTTON3, MouseEvent.MOUSE_PRESSED);
                canvas.dispatchEvent(pressed);
                
                MouseEvent released = createMouseEvent(interactPoint, MouseEvent.BUTTON3, MouseEvent.MOUSE_RELEASED);
                canvas.dispatchEvent(released);
                
                MouseEvent clicked = createMouseEvent(interactPoint, MouseEvent.BUTTON3, MouseEvent.MOUSE_CLICKED);
                canvas.dispatchEvent(clicked);
                
                drawCursor((int) x, (int) y, "red");
            } catch (Exception e) {
                log.error("Error handling interact event", e);
            }
        });
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        if (!isRunning || server == null) {
            return;
        }

        // Broadcast game state to connected clients
        try {
            String gameState = createGameState();
            for (WebSocket conn : server.getConnections()) {
                conn.send(gameState);
            }
        } catch (Exception e) {
            log.error("Error broadcasting game state", e);
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
                    // The overlay will handle the experience calculation
                    overlay.updateExperienceGained();
                } catch (Exception e) {
                    log.error("Error updating experience in overlay", e);
                }
            });
        }
    }

    private String createGameState() {
        Map<String, Object> state = new HashMap<>();
        
        if (client.getLocalPlayer() != null) {
            state.put("playerLocation", client.getLocalPlayer().getWorldLocation());
            state.put("playerHealth", client.getBoostedSkillLevel(Skill.HITPOINTS));
            state.put("playerMaxHealth", client.getRealSkillLevel(Skill.HITPOINTS));
            state.put("playerAnimation", client.getLocalPlayer().getAnimation());
            state.put("inCombat", client.getLocalPlayer().getInteracting() != null);
            state.put("playerRunEnergy", client.getEnergy());
            
            // Track last hit damage
            Actor interacting = client.getLocalPlayer().getInteracting();
            if (interacting instanceof NPC) {
                NPC npc = (NPC) interacting;
                Integer healthRatio = npc.getHealthRatio();
                int lastHitsplat = healthRatio != null ? healthRatio : 0;
                state.put("lastHitsplat", lastHitsplat);
                boolean isKilled = npc.isDead();
                state.put("npcKilled", isKilled);
                
                // Update overlay statistics
                if (isKilled) {
                    overlay.incrementNPCKilled();
                }
                if (lastHitsplat > 0) {
                    overlay.addDamageDealt(lastHitsplat);
                }
            }
            
            // Track player's last received hit
            int totalDamage = 0;
            if (client.getLocalPlayer().getHealthScale() > 0) {
                int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
                int maxHealth = client.getRealSkillLevel(Skill.HITPOINTS);
                totalDamage = maxHealth - currentHealth;
            }
            state.put("playerLastHit", totalDamage);
            
            // Add nearby NPCs
            List<Map<String, Object>> npcs = client.getNpcs().stream()
                .filter(npc -> npc.getWorldLocation().distanceTo(client.getLocalPlayer().getWorldLocation()) <= 15)
                .map(npc -> Map.of(
                    "id", npc.getIndex(),
                    "name", npc.getName(),
                    "combatLevel", npc.getCombatLevel(),
                    "health", npc.getHealthRatio(),
                    "location", npc.getWorldLocation(),
                    "interacting", npc.getInteracting() != null,
                    "isDead", npc.isDead()
                ))
                .collect(Collectors.toList());
            state.put("npcs", npcs);
            
            // Add skills with experience tracking
            Map<String, Object> skills = new HashMap<>();
            for (Skill skill : Skill.values()) {
                skills.put(skill.getName(), Map.of(
                    "level", client.getRealSkillLevel(skill),
                    "boostedLevel", client.getBoostedSkillLevel(skill),
                    "experience", client.getSkillExperience(skill)
                ));
            }
            state.put("skills", skills);
        }
        
        return gson.toJson(state);
    }

    private void drawCursor(int x, int y, String color) {
        lastCursorX = x;
        lastCursorY = y;
        lastCursorColor = color;
        lastCursorTime = System.currentTimeMillis() + CURSOR_FADE_DURATION;
    }

    public boolean shouldDrawCursor() {
        return System.currentTimeMillis() < lastCursorTime;
    }

    public Point getCursorPosition() {
        return new Point(lastCursorX, lastCursorY);
    }

    public Color getCursorColor() {
        return lastCursorColor.equals("red") ? Color.RED : Color.YELLOW;
    }

    private void dispatchMouseEvent(int type, Point point) {
        MouseEvent event = createMouseEvent(point, MouseEvent.NOBUTTON, type);
        client.getCanvas().dispatchEvent(event);
    }
} 