package net.runelite.client.plugins.rlbot.action;

import com.google.gson.JsonObject;
import java.awt.Point;
import java.awt.Canvas;
import java.awt.event.KeyEvent;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.TileItem;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.rlbot.RLBotConstants;
import net.runelite.client.plugins.rlbot.RLBotLogger;
import net.runelite.client.plugins.rlbot.input.RLBotInputHandler;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.inject.Inject;

/**
 * Handles processing of actions from the WebSocket for the RLBot plugin.
 */
public class RLBotActionHandler {
    
    /**
     * The RuneLite client.
     */
    private final Client client;
    
    /**
     * The logger instance.
     */
    private final RLBotLogger logger;
    
    /**
     * The input handler for mouse and keyboard inputs.
     */
    private final RLBotInputHandler inputHandler;
    
    private final KeyManager keyManager;
    private final MouseManager mouseManager;
    private final Component canvas;

    @Inject
    public RLBotActionHandler(
            Client client,
            RLBotLogger logger,
            RLBotInputHandler inputHandler,
            KeyManager keyManager,
            MouseManager mouseManager) {
        this.client = client;
        this.logger = logger;
        this.inputHandler = inputHandler;
        this.keyManager = keyManager;
        this.mouseManager = mouseManager;
        this.canvas = client.getCanvas();
    }
    
    /**
     * Process an action from the WebSocket.
     *
     * @param action The action JSON object
     */
    public void processAction(JsonObject action) {
        if (action == null) {
            logger.error("Received null action");
            return;
        }
        
        try {
            String type = action.get("type").getAsString();
            JsonObject data = action.getAsJsonObject("data");
            
            logger.info("Processing action: " + type + " with data: " + data);
            
            switch (type) {
                case RLBotConstants.ACTION_MOVE_AND_CLICK:
                    handleMoveAndClick(data);
                    break;
                case RLBotConstants.ACTION_CAMERA_ROTATE:
                    handleCameraRotate(data);
                    break;
                case RLBotConstants.ACTION_CAMERA_ZOOM:
                    handleCameraZoom(data);
                    break;
                case RLBotConstants.ACTION_PRESS_KEY:
                    handlePressKey(data);
                    break;
                case RLBotConstants.ACTION_INTERFACE_ACTION:
                    handleInterfaceAction(data);
                    break;
                default:
                    logger.warn("Unknown action type: " + type);
                    break;
            }
            
            logger.info("Action processed: " + type);
        } catch (Exception e) {
            logger.error("Error processing action: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Handle the move and click action.
     *
     * @param data The action data
     */
    private void handleMoveAndClick(JsonObject data) {
        String target = data.get("target").getAsString();
        
        switch (target) {
            case RLBotConstants.TARGET_NPC:
                handleNpcTarget(data);
                break;
            case RLBotConstants.TARGET_COORDINATES:
                handleCoordinatesTarget(data);
                break;
            case RLBotConstants.TARGET_OBJECT:
                handleObjectTarget(data);
                break;
            case RLBotConstants.TARGET_GROUND_ITEM:
                handleGroundItemTarget(data);
                break;
            default:
                logger.warn("Unknown target type: " + target);
                break;
        }
    }
    
    /**
     * Handle a target NPC.
     *
     * @param data The action data
     */
    private void handleNpcTarget(JsonObject data) {
        String npcName = data.get("name").getAsString();
        
        for (NPC npc : client.getNpcs()) {
            if (npc.getName() != null && npc.getName().equalsIgnoreCase(npcName)) {
                net.runelite.api.Point modelPoint = Perspective.localToCanvas(client, npc.getLocalLocation(), client.getPlane(), npc.getLogicalHeight());
                if (modelPoint != null) {
                    Point canvasPoint = new Point(modelPoint.getX(), modelPoint.getY());
                    logger.debug("Moving to NPC: " + npcName);
                    inputHandler.smoothMouseMove(canvasPoint);
                    inputHandler.click();
                    return;
                }
            }
        }
        
        logger.warn("Could not find NPC: " + npcName);
    }
    
    /**
     * Handle a target coordinates.
     *
     * @param data The action data
     */
    private void handleCoordinatesTarget(JsonObject data) {
        int x = data.get("x").getAsInt();
        int y = data.get("y").getAsInt();
        
        logger.info("Processing click at world coordinates: " + x + ", " + y);
        
        // Convert world coordinates to canvas point
        WorldPoint worldPoint = new WorldPoint(x, y, client.getPlane());
        LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);
        
        if (localPoint != null) {
            net.runelite.api.Point canvasPointApi = Perspective.localToCanvas(client, localPoint, client.getPlane());
            if (canvasPointApi != null) {
                Point canvasPoint = new Point(canvasPointApi.getX(), canvasPointApi.getY());
                logger.info("Moving to coordinates: " + x + ", " + y + " (canvas: " + canvasPoint.x + "," + canvasPoint.y + ")");
                
                // Simply move the mouse and click - no delays
                inputHandler.smoothMouseMove(canvasPoint);
                inputHandler.click();
                
                logger.info("Click action at world coordinates complete: " + x + ", " + y);
                return;
            }
        }
        
        logger.warn("Could not convert world point to canvas point: " + x + ", " + y);
    }
    
    /**
     * Handle a target object.
     *
     * @param data The action data
     */
    private void handleObjectTarget(JsonObject data) {
        int objectId = data.get("objectId").getAsInt();
        int x = data.get("x").getAsInt();
        int y = data.get("y").getAsInt();
        
        WorldPoint worldPoint = new WorldPoint(x, y, client.getPlane());
        GameObject gameObject = findGameObject(worldPoint, objectId);
        
        if (gameObject != null) {
            net.runelite.api.Point canvasPointApi = gameObject.getCanvasLocation();
            if (canvasPointApi != null) {
                Point canvasPoint = new Point(canvasPointApi.getX(), canvasPointApi.getY());
                logger.debug("Moving to object: " + objectId);
                inputHandler.smoothMouseMove(canvasPoint);
                inputHandler.click();
                return;
            }
        }
        
        logger.warn("Could not find object: " + objectId);
    }
    
    /**
     * Find a game object at the specified world point with the specified ID.
     *
     * @param worldPoint The world point
     * @param objectId The object ID
     * @return The game object, or null if not found
     */
    private GameObject findGameObject(WorldPoint worldPoint, int objectId) {
        LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);
        if (localPoint == null) {
            return null;
        }
        
        // Game object finder logic would go here
        // This is a simplified example
        return null;
    }
    
    /**
     * Handle a target ground item.
     *
     * @param data The action data
     */
    private void handleGroundItemTarget(JsonObject data) {
        String itemName = data.get("name").getAsString();
        int x = data.get("x").getAsInt();
        int y = data.get("y").getAsInt();
        
        WorldPoint worldPoint = new WorldPoint(x, y, client.getPlane());
        TileItem groundItem = findGroundItem(worldPoint, itemName);
        
        if (groundItem != null) {
            LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);
            if (localPoint != null) {
                net.runelite.api.Point canvasPointApi = Perspective.localToCanvas(client, localPoint, client.getPlane());
                if (canvasPointApi != null) {
                    Point canvasPoint = new Point(canvasPointApi.getX(), canvasPointApi.getY());
                    logger.debug("Moving to ground item: " + itemName);
                    inputHandler.smoothMouseMove(canvasPoint);
                    inputHandler.click();
                    return;
                }
            }
        }
        
        logger.warn("Could not find ground item: " + itemName);
    }
    
    /**
     * Find a ground item at the specified world point with the specified name.
     *
     * @param worldPoint The world point
     * @param itemName The item name
     * @return The ground item, or null if not found
     */
    private TileItem findGroundItem(WorldPoint worldPoint, String itemName) {
        // Ground item finder logic would go here
        // This is a simplified example
        return null;
    }
    
    /**
     * Handle the camera rotate action.
     *
     * @param data The action data
     */
    private void handleCameraRotate(JsonObject data) {
        System.out.println("\n\n===== CAMERA ROTATION HANDLER STARTED =====");
        
        try {
            // Debug the entire JSON object
            System.out.println("Full camera rotation data: " + data.toString());
            
            // Safely extract direction with null check
            String directionStr = null;
            if (data.has("direction") && !data.get("direction").isJsonNull()) {
                directionStr = data.get("direction").getAsString();
                System.out.println("Direction: " + directionStr);
            } else {
                System.out.println("ERROR: No valid direction specified in camera rotation command");
                logger.error("No valid direction specified in camera rotation command. Data: " + data);
                return;
            }
            
            // Safely extract amount with default
            int amount = RLBotConstants.CAMERA_ROTATE_AMOUNT;
            if (data.has("amount") && !data.get("amount").isJsonNull()) {
                amount = data.get("amount").getAsInt();
            }
            System.out.println("Amount: " + amount);
            
            // Convert string direction to keycode
            int keyCode;
            if ("left".equalsIgnoreCase(directionStr)) {
                keyCode = KeyEvent.VK_LEFT;
            } else if ("right".equalsIgnoreCase(directionStr)) {
                keyCode = KeyEvent.VK_RIGHT;
            } else if ("up".equalsIgnoreCase(directionStr)) {
                keyCode = KeyEvent.VK_UP;
            } else if ("down".equalsIgnoreCase(directionStr)) {
                keyCode = KeyEvent.VK_DOWN;
            } else {
                logger.error("Invalid camera rotation direction: " + directionStr);
                System.out.println("ERROR: Invalid camera rotation direction: " + directionStr);
                return;
            }
            
            System.out.println("Using key code: " + keyCode + " (" + KeyEvent.getKeyText(keyCode) + ")");
            
            // Calculate number of key presses
            int numPresses = Math.max(3, Math.min(10, amount / 15));
            System.out.println("Will press key " + numPresses + " times");
            
            // Get the canvas directly from the client
            Canvas canvas = client.getCanvas();
            if (canvas == null) {
                System.out.println("ERROR: Canvas is null, cannot rotate camera");
                logger.error("Canvas is null, cannot rotate camera");
                return;
            }
            
            System.out.println("Canvas obtained: " + canvas);
            
            // DIRECT KEY PRESS APPROACH
            System.out.println("Starting direct key press sequence");
            for (int i = 0; i < numPresses; i++) {
                try {
                    System.out.println("Press #" + (i+1) + " of " + numPresses);
                    
                    // KEY PRESSED event
                    long when = System.currentTimeMillis();
                    KeyEvent pressEvent = new KeyEvent(
                        canvas,
                        KeyEvent.KEY_PRESSED, 
                        when, 
                        0, // no modifiers
                        keyCode,
                        KeyEvent.CHAR_UNDEFINED
                    );
                    
                    System.out.println("Dispatching KEY_PRESSED");
                    canvas.dispatchEvent(pressEvent);
                    System.out.println("KEY_PRESSED dispatched");
                    
                    // Small delay
                    Thread.sleep(30);
                    
                    // KEY RELEASED event
                    KeyEvent releaseEvent = new KeyEvent(
                        canvas,
                        KeyEvent.KEY_RELEASED, 
                        when + 30, 
                        0, // no modifiers
                        keyCode,
                        KeyEvent.CHAR_UNDEFINED
                    );
                    
                    System.out.println("Dispatching KEY_RELEASED");
                    canvas.dispatchEvent(releaseEvent);
                    System.out.println("KEY_RELEASED dispatched");
                    
                    // Delay between presses
                    Thread.sleep(30);
                } catch (Exception e) {
                    System.out.println("ERROR during key press " + (i+1) + ": " + e.getMessage());
                    e.printStackTrace();
                    logger.error("Error during key press " + (i+1) + ": " + e.getMessage());
                }
            }
            
            System.out.println("Camera rotation completed: " + directionStr + " with " + numPresses + " presses");
            logger.info("Camera rotation completed: " + directionStr + " with " + numPresses + " presses");
        } catch (Exception e) {
            System.out.println("EXCEPTION in handleCameraRotate: " + e.getMessage());
            e.printStackTrace();
            logger.error("Error rotating camera: " + e.getMessage());
        }
        
        System.out.println("===== CAMERA ROTATION HANDLER FINISHED =====\n\n");
    }
    
    /**
     * Handle the camera zoom action.
     *
     * @param data The action data
     */
    private void handleCameraZoom(JsonObject data) {
        logger.info("[RLBOT_ACTION] BEGIN handleCameraZoom: " + data.toString());
        
        try {
            String directionStr = data.get("direction").getAsString();
            logger.info("[RLBOT_ACTION] Camera zoom direction: " + directionStr);
            
            float amount = data.has("amount") ? data.get("amount").getAsFloat() : RLBotConstants.CAMERA_ZOOM_AMOUNT;
            logger.info("[RLBOT_ACTION] Camera zoom amount: " + amount);
            
            // Convert string direction to keycode
            int keyCode;
            if ("in".equalsIgnoreCase(directionStr)) {
                keyCode = KeyEvent.VK_PAGE_UP;
                logger.info("[RLBOT_ACTION] Direction 'in' maps to keyCode: " + keyCode + " (" + KeyEvent.getKeyText(keyCode) + ")");
            } else if ("out".equalsIgnoreCase(directionStr)) {
                keyCode = KeyEvent.VK_PAGE_DOWN;
                logger.info("[RLBOT_ACTION] Direction 'out' maps to keyCode: " + keyCode + " (" + KeyEvent.getKeyText(keyCode) + ")");
            } else {
                logger.error("[RLBOT_ACTION] Invalid camera zoom direction: " + directionStr);
                return;
            }
            
            logger.info("[RLBOT_ACTION] Zooming camera direction: " + directionStr + ", amount: " + amount);
            
            // Default to a minimum number of key presses to ensure noticeable movement
            int numPresses = Math.max(5, (int)Math.ceil(amount / 10));
            logger.info("[RLBOT_ACTION] Calculated " + numPresses + " key presses needed for zoom");
            
            // Perform multiple key presses to achieve desired zoom amount
            for (int i = 0; i < numPresses; i++) {
                logger.info("[RLBOT_ACTION] Executing key press " + (i+1) + " of " + numPresses + " for key: " + KeyEvent.getKeyText(keyCode));
                inputHandler.pressKey(keyCode);
                
                try {
                    logger.info("[RLBOT_ACTION] Sleeping for 100ms between zoom key presses");
                    Thread.sleep(100); // Longer delay between key presses for camera zoom
                    logger.info("[RLBOT_ACTION] Sleep completed");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.error("[RLBOT_ACTION] Camera zoom interrupted: " + e.getMessage() + ": " + e.toString());
                    break;
                }
                
                // Log progress every few presses
                if (i > 0 && i % 3 == 0) {
                    logger.info("[RLBOT_ACTION] Completed " + (i+1) + " of " + numPresses + " key presses");
                }
            }
            
            logger.info("[RLBOT_ACTION] Camera zoom completed: " + directionStr + " with " + numPresses + " key presses");
        } catch (Exception e) {
            logger.error("[RLBOT_ACTION] Error zooming camera: " + e.getMessage() + ": " + e.toString());
        }
        
        logger.info("[RLBOT_ACTION] END handleCameraZoom");
    }
    
    /**
     * Handle the press key action.
     *
     * @param data The action data
     */
    private void handlePressKey(JsonObject data) {
        try {
            // Support both numeric keyCode and string key name
            int keyCode;
            if (data.has("keyCode")) {
                keyCode = data.get("keyCode").getAsInt();
            } else if (data.has("key")) {
                // Convert string key name to keycode
                String key = data.get("key").getAsString().toUpperCase();
                
                // Map common key names to keycodes
                switch (key) {
                    case "ESC":
                    case "ESCAPE":
                        keyCode = KeyEvent.VK_ESCAPE;
                        break;
                    case "SPACE":
                        keyCode = KeyEvent.VK_SPACE;
                        break;
                    case "ENTER":
                        keyCode = KeyEvent.VK_ENTER;
                        break;
                    case "F1":
                        keyCode = KeyEvent.VK_F1;
                        break;
                    // Add more key mappings as needed
                    default:
                        // Try to get keycode from first character of key string
                        if (key.length() > 0) {
                            keyCode = KeyEvent.getExtendedKeyCodeForChar(key.charAt(0));
                        } else {
                            logger.error("Invalid key: Empty string");
                            return;
                        }
                }
            } else {
                logger.error("No key or keyCode specified in pressKey action");
                return;
            }
            
            logger.info("Pressing key: " + keyCode);
            inputHandler.pressKey(keyCode);
            logger.info("Key press completed: " + keyCode);
        } catch (Exception e) {
            logger.error("Error pressing key: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Handle the interface action.
     *
     * @param data The action data
     */
    private void handleInterfaceAction(JsonObject data) {
        int parentId = data.get("parentId").getAsInt();
        int childId = data.get("childId").getAsInt();
        int menuIndex = data.has("menuIndex") ? data.get("menuIndex").getAsInt() : 0;
        
        // Interface action logic would go here
        logger.debug("Interface action: " + parentId + ", " + childId + ", " + menuIndex);
    }

    /**
     * Handles mouse movement to a specific point.
     *
     * @param point The point to move the mouse to
     */
    public void handleMouseMove(Point point) {
        try {
            logger.info("Moving mouse to: " + point.x + "," + point.y);
            
            // Create and dispatch mouse movement event
            MouseEvent moveEvent = new MouseEvent(
                canvas,
                MouseEvent.MOUSE_MOVED,
                System.currentTimeMillis(),
                0,
                point.x,
                point.y,
                0,
                false
            );
            
            mouseManager.processMouseMoved(moveEvent);
            logger.info("Mouse move completed");
            
        } catch (Exception e) {
            logger.error("Error moving mouse: " + e.getMessage());
        }
    }

    /**
     * Handles mouse clicks.
     *
     * @param button The mouse button to click ("left" or "right")
     */
    public void handleMouseClick(String button) {
        try {
            logger.info("Clicking mouse button: " + button);
            
            int buttonMask = button.equalsIgnoreCase("right") ? 
                MouseEvent.BUTTON3_DOWN_MASK : MouseEvent.BUTTON1_DOWN_MASK;
            int buttonNum = button.equalsIgnoreCase("right") ? 
                MouseEvent.BUTTON3 : MouseEvent.BUTTON1;
            
            Point mousePos = new Point(client.getMouseCanvasPosition().getX(), 
                                     client.getMouseCanvasPosition().getY());
            long when = System.currentTimeMillis();
            
            // Mouse press
            MouseEvent pressEvent = new MouseEvent(
                canvas,
                MouseEvent.MOUSE_PRESSED,
                when,
                buttonMask,
                mousePos.x,
                mousePos.y,
                1,
                false,
                buttonNum
            );
            mouseManager.processMousePressed(pressEvent);
            
            // Small delay between press and release
            Thread.sleep(50);
            
            // Mouse release
            MouseEvent releaseEvent = new MouseEvent(
                canvas,
                MouseEvent.MOUSE_RELEASED,
                when + 50,
                buttonMask,
                mousePos.x,
                mousePos.y,
                1,
                false,
                buttonNum
            );
            mouseManager.processMouseReleased(releaseEvent);
            
            logger.info("Mouse click completed");
            
        } catch (Exception e) {
            logger.error("Error clicking mouse: " + e.getMessage());
        }
    }

    /**
     * Handles key press events.
     *
     * @param keyChar The key to press
     */
    public void handleKeyPress(String keyChar) {
        try {
            logger.info("Pressing key: " + keyChar);
            
            // Convert string to key code
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(keyChar.charAt(0));
            long when = System.currentTimeMillis();
            
            // Key press
            KeyEvent pressEvent = new KeyEvent(
                canvas,
                KeyEvent.KEY_PRESSED,
                when,
                0,
                keyCode,
                keyChar.charAt(0)
            );
            keyManager.processKeyPressed(pressEvent);
            
            // Small delay between press and release
            Thread.sleep(50);
            
            // Key release
            KeyEvent releaseEvent = new KeyEvent(
                canvas,
                KeyEvent.KEY_RELEASED,
                when + 50,
                0,
                keyCode,
                keyChar.charAt(0)
            );
            keyManager.processKeyReleased(releaseEvent);
            
            logger.info("Key press completed");
            
        } catch (Exception e) {
            logger.error("Error pressing key: " + e.getMessage());
        }
    }

    /**
     * Handles text input by simulating multiple key presses.
     *
     * @param text The text to type
     */
    public void handleTextInput(String text) {
        try {
            logger.info("Typing text: " + text);
            
            for (char c : text.toCharArray()) {
                // Convert char to key code
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                long when = System.currentTimeMillis();
                
                // Key press
                KeyEvent pressEvent = new KeyEvent(
                    canvas,
                    KeyEvent.KEY_PRESSED,
                    when,
                    0,
                    keyCode,
                    c
                );
                keyManager.processKeyPressed(pressEvent);
                
                // Key typed (for character input)
                KeyEvent typedEvent = new KeyEvent(
                    canvas,
                    KeyEvent.KEY_TYPED,
                    when + 10,
                    0,
                    KeyEvent.VK_UNDEFINED,
                    c
                );
                keyManager.processKeyTyped(typedEvent);
                
                // Key release
                KeyEvent releaseEvent = new KeyEvent(
                    canvas,
                    KeyEvent.KEY_RELEASED,
                    when + 20,
                    0,
                    keyCode,
                    c
                );
                keyManager.processKeyReleased(releaseEvent);
                
                // Small delay between characters
                Thread.sleep(50);
            }
            
            logger.info("Text input completed");
            
        } catch (Exception e) {
            logger.error("Error typing text: " + e.getMessage());
        }
    }
} 