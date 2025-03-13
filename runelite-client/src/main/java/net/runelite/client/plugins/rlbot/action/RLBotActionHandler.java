package net.runelite.client.plugins.rlbot.action;

import com.google.gson.JsonObject;
import java.awt.Point;
import java.awt.event.KeyEvent;
import lombok.RequiredArgsConstructor;
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

/**
 * Handles processing of actions from the WebSocket for the RLBot plugin.
 */
@RequiredArgsConstructor
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
        } catch (Exception e) {
            logger.error("Error processing action: " + e.getMessage());
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
        
        WorldPoint worldPoint = new WorldPoint(x, y, client.getPlane());
        LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);
        
        if (localPoint != null) {
            net.runelite.api.Point canvasPointApi = Perspective.localToCanvas(client, localPoint, client.getPlane());
            if (canvasPointApi != null) {
                Point canvasPoint = new Point(canvasPointApi.getX(), canvasPointApi.getY());
                logger.debug("Moving to coordinates: " + x + ", " + y);
                inputHandler.smoothMouseMove(canvasPoint);
                inputHandler.click();
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
        int direction = data.get("direction").getAsInt();
        int amount = data.has("amount") ? data.get("amount").getAsInt() : RLBotConstants.CAMERA_ROTATE_AMOUNT;
        
        int keyCode = direction > 0 ? KeyEvent.VK_RIGHT : KeyEvent.VK_LEFT;
        
        logger.debug("Rotating camera: " + direction);
        
        for (int i = 0; i < Math.abs(direction); i++) {
            inputHandler.pressKey(keyCode);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    
    /**
     * Handle the camera zoom action.
     *
     * @param data The action data
     */
    private void handleCameraZoom(JsonObject data) {
        int direction = data.get("direction").getAsInt();
        float amount = data.has("amount") ? data.get("amount").getAsFloat() : RLBotConstants.CAMERA_ZOOM_AMOUNT;
        
        int keyCode = direction > 0 ? KeyEvent.VK_PAGE_UP : KeyEvent.VK_PAGE_DOWN;
        
        logger.debug("Zooming camera: " + direction);
        
        for (int i = 0; i < Math.abs(direction); i++) {
            inputHandler.pressKey(keyCode);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    
    /**
     * Handle the press key action.
     *
     * @param data The action data
     */
    private void handlePressKey(JsonObject data) {
        int keyCode = data.get("keyCode").getAsInt();
        
        logger.debug("Pressing key: " + keyCode);
        inputHandler.pressKey(keyCode);
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
} 