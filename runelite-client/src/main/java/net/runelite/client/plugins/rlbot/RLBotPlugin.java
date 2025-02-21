package net.runelite.client.plugins.rlbot;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.game.ItemManager;
import net.runelite.client.callback.ClientThread;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import com.google.gson.Gson;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import net.runelite.client.util.Text;
import net.runelite.api.MenuAction;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.time.Instant;
import java.awt.Dimension;

@PluginDescriptor(
    name = "RL Bot",
    description = "Exposes RuneLite API for AI agents",
    tags = {"bot", "ai", "machine learning"}
)
@Slf4j
public class RLBotPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private ItemManager itemManager;

    @Inject
    private RLBotConfig config;

    @Inject
    private OverlayManager overlayManager;

    private WebSocketServer wsServer;
    private final Gson gson = new Gson();
    private final List<WebSocket> connectedClients = new CopyOnWriteArrayList<>();
    private static final int CAMERA_PITCH_MAX = 2047;
    private static final int CAMERA_YAW_MAX = 2047;
    private static final int CAMERA_ZOOM_MAX = 2000;
    private static final int CAMERA_ZOOM_MIN = 128;

    private final List<VisualElement> visualElements = new CopyOnWriteArrayList<>();
    private RLBotOverlay overlay;

    @Provides
    RLBotConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(RLBotConfig.class);
    }

    @Override
    protected void startUp() {
        overlay = new RLBotOverlay(this);
        overlayManager.add(overlay);
        wsServer = new WebSocketServer(new InetSocketAddress(config.getPort())) {
            @Override
            public void onOpen(WebSocket conn, ClientHandshake handshake) {
                log.info("New connection from: " + conn.getRemoteSocketAddress());
                connectedClients.add(conn);
            }

            @Override
            public void onClose(WebSocket conn, int code, String reason, boolean remote) {
                log.info("Closed connection: " + conn.getRemoteSocketAddress());
                connectedClients.remove(conn);
            }

            @Override
            public void onMessage(WebSocket conn, String message) {
                handleCommand(conn, message);
            }

            @Override
            public void onError(WebSocket conn, Exception ex) {
                log.error("WebSocket error:", ex);
            }

            @Override
            public void onStart() {
                log.info("WebSocket server started on port " + config.getPort());
            }
        };
        wsServer.start();
    }

    @Override
    protected void shutDown() {
        overlayManager.remove(overlay);
        visualElements.clear();
        try {
            wsServer.stop();
        } catch (Exception e) {
            log.error("Error stopping WebSocket server:", e);
        }
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        if (client.getGameState() != GameState.LOGGED_IN) {
            return;
        }

        GameStateData state = getGameState();
        String json = gson.toJson(state);
        
        for (WebSocket client : connectedClients) {
            client.send(json);
        }
    }

    private void handleCommand(WebSocket conn, String message) {
        try {
            Command cmd = gson.fromJson(message, Command.class);
            clientThread.invoke(() -> {
                switch (cmd.action) {
                    case "click":
                        handleClick(cmd.data);
                        break;
                    case "move_mouse":
                        handleMouseMove(cmd.data);
                        break;
                    case "interact":
                        handleInteract(cmd.data);
                        break;
                    case "inventory":
                        handleInventory(cmd.data);
                        break;
                    case "camera":
                        handleCamera(cmd.data);
                        break;
                    case "key":
                        handleKey(cmd.data);
                        break;
                    case "scroll":
                        handleScroll(cmd.data);
                        break;
                    case "draw_line":
                        handleDrawLine(cmd.data);
                        break;
                    case "draw_cursor":
                        handleDrawCursor(cmd.data);
                        break;
                }
            });
        } catch (Exception e) {
            log.error("Error handling command:", e);
        }
    }

    private void handleClick(Object data) {
        Map<String, Object> clickData = (Map<String, Object>) data;
        Point point = new Point(
            ((Number) clickData.get("x")).intValue(),
            ((Number) clickData.get("y")).intValue()
        );
        boolean rightClick = clickData.containsKey("rightClick") && (boolean) clickData.get("rightClick");
        
        MouseEvent pressed = createMouseEvent(point, rightClick ? MouseEvent.BUTTON3 : MouseEvent.BUTTON1,
            MouseEvent.MOUSE_PRESSED);
        MouseEvent released = createMouseEvent(point, rightClick ? MouseEvent.BUTTON3 : MouseEvent.BUTTON1,
            MouseEvent.MOUSE_RELEASED);
        MouseEvent clicked = createMouseEvent(point, rightClick ? MouseEvent.BUTTON3 : MouseEvent.BUTTON1,
            MouseEvent.MOUSE_CLICKED);
        
        client.getCanvas().dispatchEvent(pressed);
        client.getCanvas().dispatchEvent(released);
        client.getCanvas().dispatchEvent(clicked);
    }

    private void handleMouseMove(Object data) {
        Map<String, Object> moveData = (Map<String, Object>) data;
        Point point = new Point(
            ((Number) moveData.get("x")).intValue(),
            ((Number) moveData.get("y")).intValue()
        );
        
        // Move the mouse
        MouseEvent moved = createMouseEvent(point, MouseEvent.NOBUTTON, MouseEvent.MOUSE_MOVED);
        client.getCanvas().dispatchEvent(moved);
        
        // Draw cursor if requested
        if (moveData.containsKey("show_cursor") && (boolean) moveData.get("show_cursor")) {
            drawCursor(point.x, point.y, "yellow", 100);
        }
    }

    private void handleCamera(Object data) {
        Map<String, Object> cameraData = (Map<String, Object>) data;
        
        if (cameraData.containsKey("yaw")) {
            int yaw = ((Number) cameraData.get("yaw")).intValue();
            client.setCameraYawTarget(yaw);
        }
        
        if (cameraData.containsKey("pitch")) {
            int pitch = ((Number) cameraData.get("pitch")).intValue();
            client.setCameraPitchTarget(pitch);
        }
        
        if (cameraData.containsKey("zoom")) {
            int zoom = ((Number) cameraData.get("zoom")).intValue();
            client.setMinimapZoom(zoom);
        }

        // Note: These camera position methods are not available in the API
        // We'll need to use alternative methods or modify the API if needed
        /*
        if (cameraData.containsKey("x")) {
            int x = ((Number) cameraData.get("x")).intValue();
            client.setCameraX(x);
        }

        if (cameraData.containsKey("y")) {
            int y = ((Number) cameraData.get("y")).intValue();
            client.setCameraY(y);
        }

        if (cameraData.containsKey("z")) {
            int z = ((Number) cameraData.get("z")).intValue();
            client.setCameraZ(z);
        }
        */
    }

    private void handleKey(Object data) {
        Map<String, Object> keyData = (Map<String, Object>) data;
        int keyCode = ((Number) keyData.get("keyCode")).intValue();
        boolean pressed = keyData.containsKey("pressed") ? (boolean) keyData.get("pressed") : true;
        
        KeyEvent event = new KeyEvent(
            client.getCanvas(),
            pressed ? KeyEvent.KEY_PRESSED : KeyEvent.KEY_RELEASED,
            System.currentTimeMillis(),
            0,
            keyCode,
            KeyEvent.CHAR_UNDEFINED
        );
        
        client.getCanvas().dispatchEvent(event);
        
        if (pressed) {
            // Also send typed event for text input
            KeyEvent typedEvent = new KeyEvent(
                client.getCanvas(),
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                (char) keyCode
            );
            client.getCanvas().dispatchEvent(typedEvent);
        }
    }

    private void handleInteract(Object data) {
        Map<String, Object> interactData = (Map<String, Object>) data;
        String target = (String) interactData.get("target");
        String action = (String) interactData.get("action");
        
        if (target == null || action == null) {
            return;
        }

        // If canvas coordinates are provided, click there first
        Double x = (Double) interactData.get("x");
        Double y = (Double) interactData.get("y");
        if (x != null && y != null) {
            Point clickPoint = new Point(x.intValue(), y.intValue());
            MouseEvent pressed = createMouseEvent(clickPoint, MouseEvent.BUTTON1, MouseEvent.MOUSE_PRESSED);
            MouseEvent released = createMouseEvent(clickPoint, MouseEvent.BUTTON1, MouseEvent.MOUSE_RELEASED);
            MouseEvent clicked = createMouseEvent(clickPoint, MouseEvent.BUTTON1, MouseEvent.MOUSE_CLICKED);
            
            client.getCanvas().dispatchEvent(pressed);
            client.getCanvas().dispatchEvent(released);
            client.getCanvas().dispatchEvent(clicked);
            
            // Wait a tick for menu entries to update
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Get the current menu entries after clicking
        MenuEntry[] menuEntries = client.getMenuEntries();
        for (MenuEntry entry : menuEntries) {
            String entryTarget = Text.removeTags(entry.getTarget().toLowerCase());
            String entryOption = Text.removeTags(entry.getOption().toLowerCase());
            
            // Check if this menu entry matches our target and action
            if (entryTarget.contains(target.toLowerCase()) && 
                entryOption.contains(action.toLowerCase())) {
                
                // For attack actions, use NPC_SECOND_OPTION
                MenuAction menuAction = action.equalsIgnoreCase("attack") ? 
                    MenuAction.NPC_SECOND_OPTION : entry.getType();
                
                // Create a new menu entry with the same parameters but force left click
                client.createMenuEntry(-1)
                    .setOption(entry.getOption())
                    .setTarget(entry.getTarget())
                    .setIdentifier(entry.getIdentifier())
                    .setType(menuAction)
                    .setParam0(entry.getParam0())
                    .setParam1(entry.getParam1())
                    .setForceLeftClick(true);
                
                return;
            }
        }
    }

    private void handleInventory(Object data) {
        Map<String, Object> invData = (Map<String, Object>) data;
        int itemId = ((Number) invData.get("itemId")).intValue();
        String action = (String) invData.get("action");
        
        Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);
        if (inventoryWidget != null) {
            Widget[] items = inventoryWidget.getDynamicChildren();
            for (Widget item : items) {
                if (item.getItemId() == itemId) {
                    client.getMenu().createMenuEntry(-1)
                        .setOption(action)
                        .setTarget("")
                        .setIdentifier(item.getItemId())
                        .setType(MenuAction.ITEM_FIRST_OPTION)
                        .setParam0(item.getIndex())
                        .setParam1(WidgetInfo.INVENTORY.getId());
                    break;
                }
            }
        }
    }

    private void handleScroll(Object data) {
        Map<String, Object> scrollData = (Map<String, Object>) data;
        int x = ((Number) scrollData.get("x")).intValue();
        int y = ((Number) scrollData.get("y")).intValue();
        int scrollAmount = ((Number) scrollData.get("amount")).intValue();
        
        MouseWheelEvent wheelEvent = new MouseWheelEvent(
            client.getCanvas(),
            MouseWheelEvent.WHEEL_UNIT_SCROLL,
            System.currentTimeMillis(),
            0,
            x, y,
            0, false,
            MouseWheelEvent.WHEEL_UNIT_SCROLL,
            1,
            scrollAmount
        );
        
        client.getCanvas().dispatchEvent(wheelEvent);
    }

    private void handleDrawLine(Object data) {
        Map<String, Object> lineData = (Map<String, Object>) data;
        int x1 = ((Number) lineData.get("x1")).intValue();
        int y1 = ((Number) lineData.get("y1")).intValue();
        int x2 = ((Number) lineData.get("x2")).intValue();
        int y2 = ((Number) lineData.get("y2")).intValue();
        String color = (String) lineData.get("color");
        int thickness = ((Number) lineData.get("thickness")).intValue();
        int duration = ((Number) lineData.get("duration")).intValue();
        
        drawLine(x1, y1, x2, y2, color, thickness, duration);
    }

    private void handleDrawCursor(Object data) {
        Map<String, Object> cursorData = (Map<String, Object>) data;
        int x = ((Number) cursorData.get("x")).intValue();
        int y = ((Number) cursorData.get("y")).intValue();
        String color = (String) cursorData.get("color");
        int duration = ((Number) cursorData.get("duration")).intValue();
        
        drawCursor(x, y, color, duration);
    }

    private void drawLine(int x1, int y1, int x2, int y2, String colorName, int thickness, int duration) {
        Color color = parseColor(colorName);
        visualElements.add(new VisualElement(
            x1, y1, x2, y2,
            color,
            thickness,
            Instant.now().plusMillis(duration),
            false
        ));
    }

    private void drawCursor(int x, int y, String colorName, int duration) {
        Color color = parseColor(colorName);
        int size = 20; // cursor size
        visualElements.add(new VisualElement(
            x - size/2, y - size/2,
            x + size/2, y + size/2,
            color,
            2,
            Instant.now().plusMillis(duration),
            true
        ));
    }

    private MouseEvent createMouseEvent(Point p, int button, int id) {
        return new MouseEvent(
            client.getCanvas(),
            id,
            System.currentTimeMillis(),
            0,
            p.x,
            p.y,
            1,
            false,
            button
        );
    }

    private GameStateData getGameState() {
        GameStateData state = new GameStateData();
        
        Player localPlayer = client.getLocalPlayer();
        if (localPlayer != null) {
            // Basic player info
            state.playerLocation = localPlayer.getWorldLocation();
            state.playerAnimation = localPlayer.getAnimation();
            state.playerInteracting = localPlayer.getInteracting();
            state.playerCombatLevel = localPlayer.getCombatLevel();
            state.playerHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
            state.playerMaxHealth = client.getRealSkillLevel(Skill.HITPOINTS);
            state.playerPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
            state.playerMaxPrayer = client.getRealSkillLevel(Skill.PRAYER);
            state.playerRunEnergy = client.getEnergy();
            
            // Camera info
            state.cameraX = client.getCameraX();
            state.cameraY = client.getCameraY();
            state.cameraZ = client.getCameraZ();
            state.cameraPitch = client.getCameraPitch();
            state.cameraYaw = client.getCameraYaw();
            state.cameraZoom = client.getScale();
            
            // Player position info
            LocalPoint localPoint = localPlayer.getLocalLocation();
            if (localPoint != null) {
                state.playerLocalX = localPoint.getX();
                state.playerLocalY = localPoint.getY();
                net.runelite.api.Point canvasPoint = Perspective.localToCanvas(client, localPoint, client.getPlane());
                if (canvasPoint != null) {
                    state.playerCanvasX = canvasPoint.getX();
                    state.playerCanvasY = canvasPoint.getY();
                }
            }
            
            // Mouse info
            net.runelite.api.Point mousePos = client.getMouseCanvasPosition();
            state.mouseCanvasX = mousePos.getX();
            state.mouseCanvasY = mousePos.getY();
        }

        // Get nearby NPCs with enhanced information and debug logging
        List<NpcData> npcs = new ArrayList<>();
        for (NPC npc : client.getNpcs()) {
            if (npc != null) {
                NpcData data = new NpcData();
                data.id = npc.getId();
                data.name = npc.getName() != null ? npc.getName() : "Unknown";
                data.location = npc.getWorldLocation();
                data.animation = npc.getAnimation();
                data.interacting = npc.getInteracting() != null;
                data.health = npc.getHealthRatio() != -1 ? npc.getHealthRatio() : 100;  // Default to 100 if unknown
                data.healthScale = npc.getHealthScale();
                data.combatLevel = npc.getCombatLevel();
                data.orientation = npc.getOrientation();
                
                // Log NPC data for debugging
                log.debug("NPC found - Name: {}, ID: {}, Health: {}, Combat Level: {}, Interacting: {}", 
                    data.name, data.id, data.health, data.combatLevel, data.interacting);
                
                // Get NPC positions
                LocalPoint npcLocal = npc.getLocalLocation();
                if (npcLocal != null) {
                    data.localX = npcLocal.getX();
                    data.localY = npcLocal.getY();
                    net.runelite.api.Point canvasPoint = Perspective.localToCanvas(client, npcLocal, client.getPlane());
                    if (canvasPoint != null) {
                        data.canvasX = canvasPoint.getX();
                        data.canvasY = canvasPoint.getY();
                        
                        // Log position data
                        log.debug("NPC position - Local: ({}, {}), Canvas: ({}, {})", 
                            data.localX, data.localY, data.canvasX, data.canvasY);
                    }
                }
                
                npcs.add(data);
            }
        }
        log.debug("Total NPCs found: {}", npcs.size());
        state.npcs = npcs;

        // Get inventory items with enhanced information
        Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);
        if (inventoryWidget != null) {
            state.inventory = new ArrayList<>();
            for (Widget item : inventoryWidget.getDynamicChildren()) {
                if (item.getItemId() != -1) {
                    ItemData itemData = new ItemData();
                    itemData.id = item.getItemId();
                    itemData.quantity = item.getItemQuantity();
                    ItemComposition itemComp = itemManager.getItemComposition(item.getItemId());
                    itemData.name = itemComp.getName();
                    itemData.widgetId = item.getId();
                    itemData.slot = item.getIndex();
                    itemData.actions = itemComp.getInventoryActions();
                    net.runelite.api.Point canvasLoc = item.getCanvasLocation();
                    if (canvasLoc != null) {
                        itemData.canvasX = canvasLoc.getX();
                        itemData.canvasY = canvasLoc.getY();
                        itemData.width = item.getWidth();
                        itemData.height = item.getHeight();
                    }
                    state.inventory.add(itemData);
                }
            }
        }

        // Get skill levels and experience
        state.skills = new HashMap<>();
        for (Skill skill : Skill.values()) {
            SkillData skillData = new SkillData();
            skillData.level = client.getRealSkillLevel(skill);
            skillData.boostedLevel = client.getBoostedSkillLevel(skill);
            skillData.experience = client.getSkillExperience(skill);
            state.skills.put(skill.getName(), skillData);
        }

        return state;
    }

    private static class GameStateData {
        WorldPoint playerLocation;
        int playerAnimation;
        Object playerInteracting;
        int playerCombatLevel;
        int playerHealth;
        int playerMaxHealth;
        int playerPrayer;
        int playerMaxPrayer;
        int playerRunEnergy;
        int cameraX;
        int cameraY;
        int cameraZ;
        int cameraPitch;
        int cameraYaw;
        int cameraZoom;
        int playerLocalX;
        int playerLocalY;
        int playerCanvasX;
        int playerCanvasY;
        int mouseCanvasX;
        int mouseCanvasY;
        List<NpcData> npcs;
        List<ItemData> inventory;
        Map<String, SkillData> skills;
    }

    private static class NpcData {
        int id;
        String name;
        WorldPoint location;
        int localX;
        int localY;
        int canvasX;
        int canvasY;
        int animation;
        boolean interacting;
        int health;
        int healthScale;
        int combatLevel;
        int orientation;
    }

    private static class ItemData {
        int id;
        String name;
        int quantity;
        int widgetId;
        int slot;
        String[] actions;
        int canvasX;
        int canvasY;
        int width;
        int height;
    }

    private static class SkillData {
        int level;
        int boostedLevel;
        int experience;
    }

    private static class Command {
        String action;
        Object data;
    }

    private Color parseColor(String colorName) {
        switch (colorName.toLowerCase()) {
            case "yellow": return Color.YELLOW;
            case "red": return Color.RED;
            case "green": return Color.GREEN;
            case "blue": return Color.BLUE;
            default: return Color.WHITE;
        }
    }

    private static class VisualElement {
        final int x1, y1, x2, y2;
        final Color color;
        final int thickness;
        final Instant expiry;
        final boolean isCursor;

        VisualElement(int x1, int y1, int x2, int y2, Color color, int thickness, Instant expiry, boolean isCursor) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
            this.thickness = thickness;
            this.expiry = expiry;
            this.isCursor = isCursor;
        }
    }

    private class RLBotOverlay extends net.runelite.client.ui.overlay.Overlay {
        private final RLBotPlugin plugin;

        RLBotOverlay(RLBotPlugin plugin) {
            this.plugin = plugin;
            setPosition(OverlayPosition.DYNAMIC);
            setLayer(OverlayLayer.ABOVE_WIDGETS);
            setPriority(OverlayPriority.HIGH);
        }

        @Override
        public Dimension render(Graphics2D graphics) {
            Instant now = Instant.now();
            
            // Remove expired elements
            plugin.visualElements.removeIf(element -> now.isAfter(element.expiry));
            
            // Draw remaining elements
            for (VisualElement element : plugin.visualElements) {
                graphics.setColor(element.color);
                graphics.setStroke(new BasicStroke(element.thickness));
                
                if (element.isCursor) {
                    // Draw cursor (crosshair style)
                    int size = 20;
                    int centerX = element.x1 + size/2;
                    int centerY = element.y1 + size/2;
                    
                    // Draw circle
                    graphics.drawOval(element.x1, element.y1, size, size);
                    
                    // Draw crosshair lines
                    graphics.drawLine(centerX - size/2, centerY, centerX + size/2, centerY);
                    graphics.drawLine(centerX, centerY - size/2, centerX, centerY + size/2);
                } else {
                    // Draw line
                    graphics.drawLine(element.x1, element.y1, element.x2, element.y2);
                }
            }
            
            return null;
        }
    }
} 