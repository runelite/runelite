package net.runelite.client.plugins.rlbot.input;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.ObjectComposition;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.rlbot.RLBotLogger;
import net.runelite.client.plugins.rlbot.RLBotPlugin;

/**
 * Handles mouse and keyboard input for the RLBot plugin.
 * Uses direct event dispatching to the game canvas for reliable input handling.
 */
public class RLBotInputHandler {
    
    /**
     * The logger instance.
     */
    private final RLBotLogger logger;
    
    /**
     * Random number generator for humanization.
     */
    private final Random random = new SecureRandom();
    
    /**
     * RuneLite client instance.
     */
    private final Client client;
    
    /**
     * Client thread for RuneLite operations.
     */
    private final ClientThread clientThread;
    
    /**
     * Plugin instance for updating overlay position.
     */
    private RLBotPlugin plugin;
    
    /**
     * Key manager for RuneLite key events.
     */
    private final KeyManager keyManager;
    
    /**
     * Mouse manager for RuneLite mouse events.
     */
    private final MouseManager mouseManager;
    
    /**
     * Reference to the RL agent for applying penalties.
     */
    private net.runelite.client.plugins.rlbot.RLBotAgent rlAgent;
    
    /**
     * Handles chatbox collision detection and resolution.
     */
    private ChatboxCollisionHandler chatboxCollisionHandler;

    // Track the last canvas point we moved to, to allow precise clicking
    private volatile Point lastCanvasMovePoint = null;
    // Guard to avoid camera drags interfering with active click positioning
    private final AtomicBoolean clickInProgress = new AtomicBoolean(false);
    
    /**
     * Creates a new RLBotInputHandler with dependency injection.
     * 
     * @param logger The logger
     * @param client The RuneLite client
     * @param clientThread The client thread
     * @param keyManager The key manager
     * @param mouseManager The mouse manager
     */
    @Inject
    public RLBotInputHandler(
        RLBotLogger logger,
        Client client,
        ClientThread clientThread,
        KeyManager keyManager,
        MouseManager mouseManager
    ) {
        this.logger = logger;
        this.client = client;
        this.clientThread = clientThread;
        this.keyManager = keyManager;
        this.mouseManager = mouseManager;
    }
    
    /**
     * Initialize the input handler.
     */
    public void initialize() {
        logger.info("Initializing RLBot input handler");
        
        // Test if we can access the canvas (non-blocking)
        Canvas canvas = getCanvas();
        if (canvas != null) {
            try {
                // Only check location if canvas is showing to avoid IllegalComponentStateException
                if (canvas.isShowing()) {
                    Point location = canvas.getLocationOnScreen();
                    logger.info("Canvas found at location: " + location.x + "," + location.y);
                } else {
                    logger.info("Canvas exists but not yet showing - will be available later");
                }
            } catch (Exception e) {
                logger.error("Error getting canvas location: " + e.getMessage() + ": " + e.toString());
            }
        } else {
            logger.warn("Canvas not yet available - will be initialized when needed");
        }
        
        logger.info("RLBot input handler initialization complete");
    }
    
    /**
     * Set the plugin instance for overlay synchronization.
     *
     * @param plugin The plugin instance
     */
    public void setPlugin(RLBotPlugin plugin) {
        this.plugin = plugin;
    }
    
    /**
     * Get the game canvas
     * 
     * @return The Canvas object or null if not available
     */
    private Canvas getCanvas() {
        if (client == null) {
            logger.error("Client is null, cannot get canvas");
            return null;
        }
        
        return client.getCanvas();
    }
    
    /**
     * Set the RL agent reference for applying penalties.
     */
    public void setRLAgent(net.runelite.client.plugins.rlbot.RLBotAgent agent) {
        this.rlAgent = agent;
        // Initialize the chatbox collision handler with the agent reference
        this.chatboxCollisionHandler = new ChatboxCollisionHandler(client, this, logger, agent);
    }
    

    /**
     * True if the point lies within the current 3D viewport area (excludes UI panels).
     */
    private boolean isPointInViewport(Point canvasPoint) {
        try {
            int vx = client.getViewportXOffset();
            int vy = client.getViewportYOffset();
            int vw = client.getViewportWidth();
            int vh = client.getViewportHeight();
            if (vw <= 0 || vh <= 0) {
                // If viewport not initialized yet, don't block interaction solely on this
                return true;
            }
            return canvasPoint.x >= vx && canvasPoint.x < vx + vw &&
                   canvasPoint.y >= vy && canvasPoint.y < vy + vh;
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * Returns true if the point is likely occluded by UI (chatbox, side panels) and not clickable in 3D.
     */
    private boolean isOccludedByUI(Point canvasPoint) {
        // Outside viewport is UI (minimap/side panels/chat frame areas)
        if (!isPointInViewport(canvasPoint)) {
            return true;
        }
        // Also treat known chat area overlay as occluding
        if (chatboxCollisionHandler != null) {
            try {
                if (chatboxCollisionHandler.isInChatArea(canvasPoint)) {
                    return true;
                }
            } catch (IllegalStateException e) {
                logger.error("[RLBOT_INPUT] Chat widget error: " + e.getMessage());
                // If chat widget is missing, assume no collision to avoid blocking all clicks
                return false;
            }
        }
        return false;
    }

    /**
     * Check what's under the mouse cursor at the specified canvas point.
     * This validates that the target has the expected action before clicking.
     *
     * @param canvasPoint The canvas point to check
     * @param expectedAction The expected action (e.g., "Chop", "Bank", "Use")
     * @return true if the target has the expected action, false otherwise
     */
    public boolean validateTargetAtPoint(Point canvasPoint, String expectedAction) {
        if (client == null) {
            logger.warn("[RLBOT_INPUT] Client is null, cannot validate target");
            return false;
        }

        // Early block if occluded by UI
        if (isOccludedByUI(canvasPoint)) {
            logger.debug("[RLBOT_INPUT] Point " + canvasPoint + " is occluded by UI; skipping target validation");
            return false;
        }

        try {
            final int plane = client.getPlane();
            net.runelite.api.Scene scene = client.getScene();
            if (scene == null) return false;
            net.runelite.api.Tile[][] tiles = scene.getTiles()[plane];
            if (tiles == null) return false;

            // 1) Prefer convex hull containment for game objects at the exact click location
            for (int x = 0; x < tiles.length; x++) {
                net.runelite.api.Tile[] col = tiles[x];
                if (col == null) continue;
                for (int y = 0; y < col.length; y++) {
                    net.runelite.api.Tile tile = col[y];
                    if (tile == null) continue;
                    for (net.runelite.api.GameObject gameObject : tile.getGameObjects()) {
                        if (gameObject == null) continue;
                        java.awt.Shape hull = gameObject.getConvexHull();
                        if (hull == null || !hull.contains(canvasPoint)) continue;
                        net.runelite.api.ObjectComposition composition = client.getObjectDefinition(gameObject.getId());
                        if (composition == null) continue;
                        String[] actions = composition.getActions();
                        if (actions == null) continue;
                        for (String action : actions) {
                            if (action != null && action.toLowerCase().contains(expectedAction.toLowerCase())) {
                                logger.debug("[RLBOT_INPUT] ConvexHull match at " + canvasPoint + ": " + composition.getName() + " with action '" + action + "'");
                                return true;
                            }
                        }
                    }
                }
            }

            // 2) NPC convex/projection check near the click location
            for (net.runelite.api.NPC npc : client.getNpcs()) {
                if (npc == null) continue;
                java.awt.Shape npcHull = npc.getConvexHull();
                if (npcHull != null && npcHull.contains(canvasPoint)) {
                    net.runelite.api.NPCComposition npcComposition = npc.getTransformedComposition();
                    if (npcComposition != null) {
                        String[] actions = npcComposition.getActions();
                        if (actions != null) {
                            for (String action : actions) {
                                if (action != null && action.toLowerCase().contains(expectedAction.toLowerCase())) {
                                    logger.debug("[RLBOT_INPUT] NPC hull match at " + canvasPoint + ": " + npcComposition.getName() + " action '" + action + "'");
                                    return true;
                                }
                            }
                        }
                    }
                } else {
                    // Fallback: proximity to projected point
                    net.runelite.api.Point npcCanvasPoint = net.runelite.api.Perspective.localToCanvas(client, npc.getLocalLocation(), client.getPlane(), npc.getLogicalHeight());
                    if (npcCanvasPoint == null) continue;
                    if (Math.abs(npcCanvasPoint.getX() - canvasPoint.x) <= 10 && Math.abs(npcCanvasPoint.getY() - canvasPoint.y) <= 10) {
                        net.runelite.api.NPCComposition npcComposition = npc.getTransformedComposition();
                        if (npcComposition == null) continue;
                        String[] actions = npcComposition.getActions();
                        if (actions == null) continue;
                        for (String action : actions) {
                            if (action != null && action.toLowerCase().contains(expectedAction.toLowerCase())) {
                                logger.debug("[RLBOT_INPUT] NPC proximity match at " + canvasPoint + ": " + npcComposition.getName() + " action '" + action + "'");
                                return true;
                            }
                        }
                    }
                }
            }

            // 3) Fallback proximity check for game objects using projected center
            for (int x = 0; x < tiles.length; x++) {
                net.runelite.api.Tile[] col = tiles[x];
                if (col == null) continue;
                for (int y = 0; y < col.length; y++) {
                    net.runelite.api.Tile tile = col[y];
                    if (tile == null) continue;
                    for (net.runelite.api.GameObject gameObject : tile.getGameObjects()) {
                        if (gameObject == null) continue;
                        net.runelite.api.coords.LocalPoint lp = gameObject.getLocalLocation();
                        if (lp == null) continue;
                        net.runelite.api.Point proj = net.runelite.api.Perspective.localToCanvas(client, lp, plane);
                        if (proj == null) continue;
                        if (Math.abs(proj.getX() - canvasPoint.x) <= 12 && Math.abs(proj.getY() - canvasPoint.y) <= 12) {
                            net.runelite.api.ObjectComposition composition = client.getObjectDefinition(gameObject.getId());
                            if (composition == null) continue;
                            String[] actions = composition.getActions();
                            if (actions == null) continue;
                            for (String action : actions) {
                                if (action != null && action.toLowerCase().contains(expectedAction.toLowerCase())) {
                                    logger.debug("[RLBOT_INPUT] Proximity match at " + canvasPoint + ": " + composition.getName() + " action '" + action + "'");
                                    return true;
                                }
                            }
                        }
                    }
                }
            }

            logger.debug("[RLBOT_INPUT] No valid target with action '" + expectedAction + "' found at " + canvasPoint);
            return false;
            
        } catch (Exception e) {
            logger.warn("[RLBOT_INPUT] Error validating target at " + canvasPoint + ": " + e.getMessage());
            return false;
        }
    }

    /**
     * Get detailed information about what's under the mouse cursor.
     * This is useful for debugging and understanding what the bot is targeting.
     *
     * @param canvasPoint The canvas point to check
     * @return A string describing what's under the cursor, or null if nothing found
     */
    public String getTargetInfoAtPoint(Point canvasPoint) {
        if (client == null) {
            return "Client is null";
        }

        try {
            final int plane = client.getPlane();
            net.runelite.api.Scene scene = client.getScene();
            if (scene == null) return "No scene";
            net.runelite.api.Tile[][] tiles = scene.getTiles()[plane];
            if (tiles == null) return "No tiles for plane";

            StringBuilder info = new StringBuilder();
            
            // Check game objects near the canvas point
            for (int x = 0; x < tiles.length; x++) {
                net.runelite.api.Tile[] col = tiles[x];
                if (col == null) continue;
                for (int y = 0; y < col.length; y++) {
                    net.runelite.api.Tile tile = col[y];
                    if (tile == null) continue;
                    for (net.runelite.api.GameObject gameObject : tile.getGameObjects()) {
                        if (gameObject == null) continue;
                        net.runelite.api.coords.LocalPoint lp = gameObject.getLocalLocation();
                        if (lp == null) continue;
                        net.runelite.api.Point proj = net.runelite.api.Perspective.localToCanvas(client, lp, plane);
                        if (proj == null) continue;
                        if (Math.abs(proj.getX() - canvasPoint.x) <= 10 && Math.abs(proj.getY() - canvasPoint.y) <= 10) {
                            net.runelite.api.ObjectComposition composition = client.getObjectDefinition(gameObject.getId());
                            if (composition == null) continue;
                            info.append("GameObject: ").append(composition.getName()).append(" (ID: ").append(gameObject.getId()).append(")");
                            String[] actions = composition.getActions();
                            if (actions != null) {
                                info.append(" Actions: [");
                                for (int i = 0; i < actions.length; i++) {
                                    if (actions[i] != null) {
                                        if (i > 0) info.append(", ");
                                        info.append(actions[i]);
                                    }
                                }
                                info.append("]");
                            }
                            info.append("; ");
                        }
                    }
                }
            }

            // Check NPCs
            for (net.runelite.api.NPC npc : client.getNpcs()) {
                if (npc == null) continue;
                
                net.runelite.api.Point npcCanvasPoint = net.runelite.api.Perspective.localToCanvas(client, npc.getLocalLocation(), client.getPlane(), npc.getLogicalHeight());
                if (npcCanvasPoint == null) continue;
                
                if (Math.abs(npcCanvasPoint.getX() - canvasPoint.x) <= 10 && 
                    Math.abs(npcCanvasPoint.getY() - canvasPoint.y) <= 10) {
                    
                    net.runelite.api.NPCComposition npcComposition = npc.getTransformedComposition();
                    if (npcComposition == null) continue;
                    
                    info.append("NPC: ").append(npcComposition.getName()).append(" (ID: ").append(npc.getId()).append(")");
                    String[] actions = npcComposition.getActions();
                    if (actions != null) {
                        info.append(" Actions: [");
                        for (int i = 0; i < actions.length; i++) {
                            if (actions[i] != null) {
                                if (i > 0) info.append(", ");
                                info.append(actions[i]);
                            }
                        }
                        info.append("]");
                    }
                    info.append("; ");
                }
            }

            // Ground item info omitted for compatibility

            return info.length() > 0 ? info.toString() : "Nothing found at this location";
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Move the mouse to the specified point on the game canvas and dispatch appropriate events.
     * This version waits for the movement to complete before returning.
     *
     * @param canvasPoint The point on the game canvas to move to
     */
    public void smoothMouseMove(Point canvasPoint) {
        // Check if the target point is in the chat area and apply penalty for RL learning
        if (chatboxCollisionHandler != null) {
            try {
                if (chatboxCollisionHandler.isInChatArea(canvasPoint)) {
                    logger.warn("[RLBOT_INPUT] Attempting to move mouse to chat area (" + canvasPoint.x + "," + canvasPoint.y + ") - applying penalty");
                    if (rlAgent != null) {
                        rlAgent.addExternalPenalty(0.3f); // Penalty for trying to move mouse to chat area
                    }
                }
            } catch (IllegalStateException e) {
                logger.error("[RLBOT_INPUT] Chat widget error in smoothMouseMove: " + e.getMessage());
            }
        }
        
        logger.debug("[RLBOT_INPUT] BEGIN smoothMouseMove to canvas point: " + canvasPoint.x + "," + canvasPoint.y);
        
        // Run interpolation on a background daemon thread and post events to EDT
        final CountDownLatch finished = new CountDownLatch(1);
        Thread mover = new Thread(() -> {
            Canvas canvas = getCanvas();
            if (canvas == null) {
                logger.error("[RLBOT_INPUT] Canvas is null, cannot move mouse");
                finished.countDown();
                return;
            }
            Point start;
            try {
                Point mp = canvas.getMousePosition();
                start = mp != null ? mp : new Point(canvas.getWidth() / 2, canvas.getHeight() / 2);
            } catch (Exception ex) {
                start = new Point(canvas.getWidth() / 2, canvas.getHeight() / 2);
            }
            
            // Enhanced mouse movement with trailing behavior
            int px = 20;
            try {
                px = ((net.runelite.client.plugins.rlbot.RLBotConfig)net.runelite.client.RuneLite.getInjector().getInstance(net.runelite.client.plugins.rlbot.RLBotConfig.class)).mouseMoveInterpolationPx();
            } catch (Throwable ignore) {}
            
            double dx = canvasPoint.x - start.x;
            double dy = canvasPoint.y - start.y;
            double dist = Math.hypot(dx, dy);
            
            // Calculate steps with more natural movement
            int steps = Math.max(3, (int)Math.ceil(dist / Math.max(3, px)));
            
            // Add some natural variation to the movement
            java.util.Random rand = new java.util.Random();
            
            for (int i = 1; i <= steps; i++) {
                double progress = (double) i / steps;
                
                // Use easing function for more natural movement (ease-out)
                double easedProgress = 1.0 - Math.pow(1.0 - progress, 3);
                
                // Add slight random variation to make movement look more human
                double variationX = (rand.nextDouble() - 0.5) * 2.0; // -1 to 1 pixel variation
                double variationY = (rand.nextDouble() - 0.5) * 2.0;
                
                int x = start.x + (int)Math.round(dx * easedProgress + variationX);
                int y = start.y + (int)Math.round(dy * easedProgress + variationY);
                
                // Ensure we don't go outside canvas bounds
                x = Math.max(0, Math.min(canvas.getWidth() - 1, x));
                y = Math.max(0, Math.min(canvas.getHeight() - 1, y));
                
                Point stepPoint = new Point(x, y);
                
                // Dispatch from this background thread; dispatchMouseMoveEvent will ensure EDT dispatching
                dispatchMouseMoveEvent(canvas, stepPoint);
                
                // Add small delay between steps for more natural movement
                try {
                    Thread.sleep(8 + rand.nextInt(5)); // 8-12ms between steps
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            
            // Ensure we end exactly at the target point
            dispatchMouseMoveEvent(canvas, canvasPoint);
            lastCanvasMovePoint = new Point(canvasPoint);
            finished.countDown();
        }, "rlbot-mouse-move");
        mover.setDaemon(true);
        mover.start();
        
        // Wait for movement to complete so subsequent click uses the correct point
        try {
            finished.await(800, TimeUnit.MILLISECONDS); // Increased timeout for more natural movement
            // Ensure queued move events are processed before returning
            if (!SwingUtilities.isEventDispatchThread()) {
                try {
                    SwingUtilities.invokeAndWait(() -> { /* flush */ });
                } catch (Exception ignored) {}
            }
        } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
        
        logger.debug("[RLBOT_INPUT] END smoothMouseMove (completed)");
    }
    
    /**
     * Get the current mouse position relative to the canvas.
     */
    private Point getCurrentMousePosition() {
        Canvas canvas = getCanvas();
        if (canvas == null) return null;
        try {
            return canvas.getMousePosition();
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Dispatches a mouse move event to the component.
     *
     * @param component The component to dispatch the event to
     * @param point The point on the component
     */
    private void dispatchMouseMoveEvent(Component component, Point point) {
        // Transform coordinates for stretched mode
        Point transformedPoint = transformToStretchedCoordinates(point);
        logger.info("[RLBOT_INPUT] BEGIN dispatchMouseMoveEvent to: " + point.x + "," + point.y + 
                   " (transformed: " + transformedPoint.x + "," + transformedPoint.y + ")");
        
        // Update the plugin's mouse location with canvas coordinates (overlay expects canvas space)
        if (plugin != null) {
            plugin.updateLastMouseLocation(point);
        }
        
        long when = System.currentTimeMillis();
        int modifiers = 0;
        int clickCount = 0;
        boolean popupTrigger = false;
        boolean isInBounds = transformedPoint.x >= 0 && transformedPoint.y >= 0 && transformedPoint.x < component.getWidth() && transformedPoint.y < component.getHeight();
        if (!isInBounds) {
            MouseEvent exitEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_EXITED,
                when,
                modifiers,
                transformedPoint.x,
                transformedPoint.y,
                clickCount,
                popupTrigger
            );
            SwingUtilities.invokeLater(() -> component.dispatchEvent(exitEvent));
            return;
        }
        MouseEvent event = new MouseEvent(
            component,
            MouseEvent.MOUSE_MOVED,
            when,
            modifiers,
            transformedPoint.x,
            transformedPoint.y,
            clickCount,
            popupTrigger
        );
        SwingUtilities.invokeLater(() -> component.dispatchEvent(event));
        logger.info("[RLBOT_INPUT] END dispatchMouseMoveEvent");
    }
    
        /**
     * Move the mouse to the specified point and validate the target before clicking.
     * This is the complete flow: move -> validate -> click.
     *
     * @param canvasPoint The canvas point to move to and click
     * @param expectedAction The expected action (e.g., "Chop", "Bank", "Use")
     * @return true if the target was valid and click was successful, false otherwise
     */
    public boolean moveAndClickWithValidation(Point canvasPoint, String expectedAction) {
        logger.debug("[RLBOT_INPUT] BEGIN moveAndClickWithValidation at " + canvasPoint + " for action: " + expectedAction);
        clickInProgress.set(true);
        try {
        if (isWoodcutting() || isWalking()) return false;
        // First move the mouse to the target (now synchronous)
        smoothMouseMove(canvasPoint);
        
        // Verify mouse reached target before clicking; if not, retry move
        Point currentMousePos = getCurrentMousePosition();
        if (currentMousePos != null) {
            double distance = Math.hypot(currentMousePos.x - canvasPoint.x, currentMousePos.y - canvasPoint.y);
            if (distance > 10) {
                logger.warn("[RLBOT_INPUT] Mouse didn't reach target. Expected: " + canvasPoint + ", Actual: " + currentMousePos + ", Distance: " + String.format("%.1f", distance));
                smoothMouseMove(canvasPoint);
            }
        }

        // Allow hover-settle: repeatedly validate for a short window before clicking
        long hoverStart = System.nanoTime();
        boolean hoverValidated = false;
        for (int i = 0; i < 4; i++) { // ~4 iterations over ~200ms
            if (validateTargetAtPoint(canvasPoint, expectedAction)) { hoverValidated = true; break; }
            try { Thread.sleep(50); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
        }
        long hoverEnd = System.nanoTime();
        logger.perf("[RLBOT_INPUT] Hover-settle validation took " + ((hoverEnd - hoverStart) / 1_000_000) + " ms, validated=" + hoverValidated);
        
        if (isWoodcutting() || isWalking()) return false;
        
        // Find the target object first so we can pass it to collision handler
        net.runelite.api.GameObject targetObj = findObjectAtPointMatchingAction(canvasPoint, expectedAction);
        
        // Try to clear UI occlusion first
        if (isOccludedByUI(canvasPoint)) {
            // Use enhanced collision handler if it's a chatbox collision and we have the target object
            if (chatboxCollisionHandler != null) {
                try {
                    if (chatboxCollisionHandler.isInChatArea(canvasPoint)) {
                        chatboxCollisionHandler.handleChatboxCollision(canvasPoint, targetObj, expectedAction);
                    } else {
                        revealPointByCameraUI(canvasPoint, 6);
                    }
                } catch (IllegalStateException e) {
                    logger.error("[RLBOT_INPUT] Chat widget error in moveAndClickWithValidation: " + e.getMessage());
                    revealPointByCameraUI(canvasPoint, 6);
                }
            } else {
                revealPointByCameraUI(canvasPoint, 6);
            }
        }

        // If multiple meshes overlap at this point, prefer the nearest-to-camera
        if (targetObj != null && isOccludedByGeometry(canvasPoint, targetObj)) {
            revealPointByCameraGeometry(canvasPoint, targetObj, 6);
        }
        if (!validateTargetAtPoint(canvasPoint, expectedAction)) {
            logger.warn("[RLBOT_INPUT] Target validation failed for action '" + expectedAction + "' at " + canvasPoint);
            String targetInfo = getTargetInfoAtPoint(canvasPoint);
            logger.info("[RLBOT_INPUT] Target info: " + targetInfo);
            
            // Apply penalty for clicking on invalid target
            if (rlAgent != null) {
                rlAgent.addExternalPenalty(0.5f);
            }
            return false;
        }
        
        // Target is valid, proceed with click (now synchronous)
        long t0 = System.nanoTime();
        logger.debug("[RLBOT_INPUT] Target validation passed, proceeding with click");
        click();
        long t1 = System.nanoTime();
        logger.perf("Input.moveAndClick validated click took " + ((t1 - t0) / 1_000_000) + " ms");
        return true;
        } finally {
            clickInProgress.set(false);
        }
    }

    /**
     * Click at the current mouse position with validation.
     * This method validates that the target has the expected action before clicking.
     *
     * @param expectedAction The expected action (e.g., "Chop", "Bank", "Use")
     * @return true if the click was successful and target was valid, false otherwise
     */
    public boolean clickWithValidation(String expectedAction) {
        logger.debug("[RLBOT_INPUT] BEGIN clickWithValidation for action: " + expectedAction);
        clickInProgress.set(true);
        try {
        if (isWoodcutting() || isWalking()) return false;
        // Get the current mouse position
        Point clickPoint = lastCanvasMovePoint;
        if (clickPoint == null) {
            logger.warn("[RLBOT_INPUT] No known mouse position for validation");
            return false;
        }
        
        if (isWoodcutting() || isWalking()) return false;
        
        // Find the target object first so we can pass it to collision handler
        net.runelite.api.GameObject targetObj2 = findObjectAtPointMatchingAction(clickPoint, expectedAction);
        
        // Try to clear UI occlusion
        if (isOccludedByUI(clickPoint)) {
            // Use enhanced collision handler if it's a chatbox collision and we have the target object
            if (chatboxCollisionHandler != null) {
                try {
                    if (chatboxCollisionHandler.isInChatArea(clickPoint)) {
                        chatboxCollisionHandler.handleChatboxCollision(clickPoint, targetObj2, expectedAction);
                    } else {
                        revealPointByCameraUI(clickPoint, 6);
                    }
                } catch (IllegalStateException e) {
                    logger.error("[RLBOT_INPUT] Chat widget error in clickWithValidation: " + e.getMessage());
                    revealPointByCameraUI(clickPoint, 6);
                }
            } else {
                revealPointByCameraUI(clickPoint, 6);
            }
        }

        // Check geometry occlusion
        if (targetObj2 != null && isOccludedByGeometry(clickPoint, targetObj2)) {
            revealPointByCameraGeometry(clickPoint, targetObj2, 6);
        }

        // Validate the target before clicking
        if (!validateTargetAtPoint(clickPoint, expectedAction)) {
            logger.warn("[RLBOT_INPUT] Target validation failed for action '" + expectedAction + "' at " + clickPoint);
            String targetInfo = getTargetInfoAtPoint(clickPoint);
            logger.info("[RLBOT_INPUT] Target info: " + targetInfo);
            
            // Apply penalty for clicking on invalid target
            if (rlAgent != null) {
                rlAgent.addExternalPenalty(0.5f);
            }
            return false;
        }
        
        // Target is valid, proceed with click
        long t0 = System.nanoTime();
        logger.debug("[RLBOT_INPUT] Target validation passed, proceeding with click");
        click();
        long t1 = System.nanoTime();
        logger.perf("Input.clickWithValidation took " + ((t1 - t0) / 1_000_000) + " ms");
        return true;
        } finally {
            clickInProgress.set(false);
        }
    }

    /**
     * Click at a specific canvas coordinate with validation.
     * This method validates that the target has the expected action before clicking.
     *
     * @param canvasPoint The canvas point to click at
     * @param expectedAction The expected action (e.g., "Chop", "Bank", "Use")
     * @return true if the click was successful and target was valid, false otherwise
     */
    public boolean clickAtWithValidation(Point canvasPoint, String expectedAction) {
        logger.debug("[RLBOT_INPUT] BEGIN clickAtWithValidation at " + canvasPoint + " for action: " + expectedAction);
        clickInProgress.set(true);
        try {
        if (isWoodcutting() || isWalking()) return false;
        
        // Find the target object first so we can pass it to collision handler
        net.runelite.api.GameObject targetObj3 = findObjectAtPointMatchingAction(canvasPoint, expectedAction);
        
        // Try to clear UI occlusion
        if (isOccludedByUI(canvasPoint)) {
            // Use enhanced collision handler if it's a chatbox collision and we have the target object
            if (chatboxCollisionHandler != null) {
                try {
                    if (chatboxCollisionHandler.isInChatArea(canvasPoint)) {
                        chatboxCollisionHandler.handleChatboxCollision(canvasPoint, targetObj3, expectedAction);
                    } else {
                        revealPointByCameraUI(canvasPoint, 6);
                    }
                } catch (IllegalStateException e) {
                    logger.error("[RLBOT_INPUT] Chat widget error in clickAtWithValidation: " + e.getMessage());
                    revealPointByCameraUI(canvasPoint, 6);
                }
            } else {
                revealPointByCameraUI(canvasPoint, 6);
            }
        }

        // Check geometry occlusion
        if (targetObj3 != null && isOccludedByGeometry(canvasPoint, targetObj3)) {
            revealPointByCameraGeometry(canvasPoint, targetObj3, 6);
        }
        if (!validateTargetAtPoint(canvasPoint, expectedAction)) {
            logger.warn("[RLBOT_INPUT] Target validation failed for action '" + expectedAction + "' at " + canvasPoint);
            String targetInfo = getTargetInfoAtPoint(canvasPoint);
            logger.info("[RLBOT_INPUT] Target info: " + targetInfo);
            
            // Apply penalty for clicking on invalid target
            if (rlAgent != null) {
                rlAgent.addExternalPenalty(0.5f);
            }
            return false;
        }
        
        // Target is valid, proceed with click
        long t0 = System.nanoTime();
        logger.debug("[RLBOT_INPUT] Target validation passed, proceeding with click");
        clickAt(canvasPoint);
        long t1 = System.nanoTime();
        logger.perf("Input.clickAtWithValidation took " + ((t1 - t0) / 1_000_000) + " ms");
        return true;
        } finally {
            clickInProgress.set(false);
        }
    }

        /**
     * Click at the current mouse position.
     */
    public void click() {
        logger.debug("[RLBOT_INPUT] BEGIN click at current mouse position");
        
        // Run click on background thread and post events to EDT
        Thread clicker = new Thread(() -> {
            if (isWoodcutting() || isWalking()) return;
            Canvas canvas = getCanvas();
            if (canvas == null) {
                logger.error("[RLBOT_INPUT] Canvas is null, cannot click");
                return;
            }
            Point clickPoint = lastCanvasMovePoint;
            if (clickPoint == null) {
                try {
                    Point mousePos = canvas.getMousePosition();
                    if (mousePos != null) clickPoint = mousePos;
                } catch (Exception ignored) {}
            }
            if (clickPoint == null) {
                clickPoint = new Point(canvas.getWidth() / 2, canvas.getHeight() / 2);
            }
            // Send a final move to the click point and flush EDT to ensure ordering
            final Point finalClickPoint = clickPoint;
            dispatchMouseMoveEvent(canvas, finalClickPoint);
            if (!SwingUtilities.isEventDispatchThread()) {
                try {
                    SwingUtilities.invokeAndWait(() -> { /* flush */ });
                } catch (Exception ignored) {}
            }
            // Guarantee overlay and physical click match by using the same finalClickPoint
            dispatchMouseClickEvent(canvas, finalClickPoint);
            lastCanvasMovePoint = null;
        }, "rlbot-click");
        clicker.setDaemon(true);
        clicker.start();
        
        logger.debug("[RLBOT_INPUT] END click (completed)");
    }

    /**
     * Click at a specific canvas coordinate.
     */
    public void clickAt(Point canvasPoint) {
        // Use enhanced chatbox collision handler if available
        if (chatboxCollisionHandler != null && chatboxCollisionHandler.handleChatboxCollision(canvasPoint, null, "click")) {
            logger.warn("[RLBOT_INPUT] Chatbox collision detected and handled for click at " + canvasPoint);
            // The collision handler has already applied penalties and attempted resolution
            // Continue with the click anyway in case the resolution was successful
        }
        
        logger.debug("[RLBOT_INPUT] BEGIN clickAt point: " + canvasPoint.x + "," + canvasPoint.y);
        
        Thread clicker = new Thread(() -> {
            if (isWoodcutting() || isWalking()) return;
            Canvas canvas = getCanvas();
            if (canvas == null) {
                logger.error("[RLBOT_INPUT] Canvas is null, cannot clickAt");
                return;
            }
            // Send a final move to the click point and flush EDT to ensure ordering
            dispatchMouseMoveEvent(canvas, canvasPoint);
            if (!SwingUtilities.isEventDispatchThread()) {
                try {
                    SwingUtilities.invokeAndWait(() -> { /* flush */ });
                } catch (Exception ignored) {}
            }
            dispatchMouseClickEvent(canvas, canvasPoint);
            lastCanvasMovePoint = null;
        }, "rlbot-click");
        clicker.setDaemon(true);
        clicker.start();
        
        logger.debug("[RLBOT_INPUT] END clickAt (completed)");
    }
    
    /**
     * Transform real canvas coordinates to stretched coordinates if stretched mode is enabled.
     *
     * @param realPoint The point in real canvas coordinates
     * @return The point in stretched coordinates (or original if stretched mode is disabled)
     */
    private Point transformToStretchedCoordinates(Point realPoint) {
        if (!client.isStretchedEnabled()) {
            return realPoint;
        }
        
        java.awt.Dimension stretchedDimensions = client.getStretchedDimensions();
        java.awt.Dimension realDimensions = client.getRealDimensions();
        
        if (stretchedDimensions == null || realDimensions == null) {
            return realPoint;
        }
        
        double scaleX = (double) stretchedDimensions.width / realDimensions.width;
        double scaleY = (double) stretchedDimensions.height / realDimensions.height;
        
        int stretchedX = (int) Math.round(realPoint.x * scaleX);
        int stretchedY = (int) Math.round(realPoint.y * scaleY);
        
        logger.debug("[RLBOT_INPUT] Transformed coordinates from real (" + realPoint.x + "," + realPoint.y + 
                     ") to stretched (" + stretchedX + "," + stretchedY + ") with scale (" + scaleX + "," + scaleY + ")");
        
        return new Point(stretchedX, stretchedY);
    }

    /**
     * Dispatches mouse press, release, and click events to simulate a click.
     *
     * @param component The component to dispatch the events to
     * @param point The point on the component
     */
    private void dispatchMouseClickEvent(Component component, Point point) {
        // Transform coordinates for stretched mode
        Point transformedPoint = transformToStretchedCoordinates(point);
        logger.info("[RLBOT_INPUT] BEGIN dispatchMouseClickEvent at: " + point.x + "," + point.y + 
                   " (transformed: " + transformedPoint.x + "," + transformedPoint.y + ")");
        
        // Update the plugin's mouse location with canvas coordinates (overlay expects canvas space)
        if (plugin != null) {
            plugin.updateLastMouseLocation(point);
        }
        
        long when = System.currentTimeMillis();
        int modifiers = InputEvent.BUTTON1_DOWN_MASK;
        int clickCount = 1;
        boolean popupTrigger = false;
        try {
            MouseEvent pressEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_PRESSED,
                when,
                modifiers,
                transformedPoint.x,
                transformedPoint.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON1
            );
            MouseEvent releaseEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_RELEASED,
                when + 50,
                modifiers,
                transformedPoint.x,
                transformedPoint.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON1
            );
            MouseEvent clickEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_CLICKED,
                when + 51,
                modifiers,
                transformedPoint.x,
                transformedPoint.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON1
            );
            SwingUtilities.invokeLater(() -> component.dispatchEvent(pressEvent));
            SwingUtilities.invokeLater(() -> component.dispatchEvent(releaseEvent));
            SwingUtilities.invokeLater(() -> component.dispatchEvent(clickEvent));
        } catch (Exception e) {
            logger.error("[RLBOT_INPUT] Error scheduling mouse click events: " + e.getMessage() + ": " + e.toString());
        }
        logger.info("[RLBOT_INPUT] END dispatchMouseClickEvent");
    }
    
    /**
     * Interact with a game object using the proper menu action system.
     * This is the correct way to interact with game objects in RuneLite.
     *
     * @param gameObject The game object to interact with
     * @param action The menu action (e.g., "Use", "Bank", etc.)
     */
    public void interactWithGameObject(net.runelite.api.GameObject gameObject, String action) {
        logger.info("[RLBOT_INPUT] BEGIN interactWithGameObject: " + action + " on object " + gameObject.getId());
        
        clientThread.invoke(() -> {
            try {
                // Get object composition to find the correct action index
                net.runelite.api.ObjectComposition composition = client.getObjectDefinition(gameObject.getId());
                if (composition == null) {
                    logger.error("[RLBOT_INPUT] Could not get object composition for object " + gameObject.getId());
                    return;
                }
                
                String[] actions = composition.getActions();
                if (actions == null) {
                    logger.error("[RLBOT_INPUT] Object has no actions: " + gameObject.getId());
                    return;
                }
                
                // Find the action index (with synonyms fallback for common labels) using case-insensitive contains
                int actionIndex = -1;
                String desired = action == null ? "" : action.trim();
                String[] synonyms;
                if (desired.equalsIgnoreCase("Bank")) {
                    // Support bank chests which often expose "Use" instead of "Bank"
                    synonyms = new String[] {"Bank", "Use", "Open", "Open bank", "Use-quickly"};
                } else if (desired.equalsIgnoreCase("Chop down") || desired.equalsIgnoreCase("Chop")) {
                    synonyms = new String[] {"Chop down", "Chop"};
                } else {
                    synonyms = new String[] {desired};
                }
                for (String candidate : synonyms) {
                    String candLc = candidate == null ? "" : candidate.toLowerCase();
                    for (int i = 0; i < actions.length; i++) {
                        String ai = actions[i];
                        if (ai == null) continue;
                        String aiLc = ai.toLowerCase();
                        if (aiLc.contains(candLc)) {
                            actionIndex = i;
                            desired = ai; // use the concrete label from the object for invocation/logging
                            break;
                        }
                    }
                    if (actionIndex != -1) break;
                }
                
                if (actionIndex == -1) {
                    logger.error("[RLBOT_INPUT] Action '" + action + "' not found for object " + gameObject.getId() + 
                                 ". Available actions: " + java.util.Arrays.toString(actions));
                    return;
                }
                
                // Convert action index to MenuAction (Jagex order uses THIRD_OPTION for index 2)
                net.runelite.api.MenuAction menuAction;
                switch (actionIndex) {
                    case 0: menuAction = net.runelite.api.MenuAction.GAME_OBJECT_FIRST_OPTION; break;
                    case 1: menuAction = net.runelite.api.MenuAction.GAME_OBJECT_SECOND_OPTION; break;
                    case 2: menuAction = net.runelite.api.MenuAction.GAME_OBJECT_THIRD_OPTION; break;
                    case 3: menuAction = net.runelite.api.MenuAction.GAME_OBJECT_FOURTH_OPTION; break;
                    case 4: menuAction = net.runelite.api.MenuAction.GAME_OBJECT_FIFTH_OPTION; break;
                    default:
                        logger.error("[RLBOT_INPUT] Unsupported action index: " + actionIndex);
                        return;
                }
                
                // Use scene coordinates (tile) and the object's id as per client.menuAction signature
                net.runelite.api.coords.LocalPoint lp = net.runelite.api.coords.LocalPoint.fromWorld(client, gameObject.getWorldLocation());
                if (lp == null) {
                    logger.error("[RLBOT_INPUT] LocalPoint null for object " + gameObject.getId());
                    return;
                }
                int sceneX = lp.getSceneX();
                int sceneY = lp.getSceneY();

                logger.info("[RLBOT_INPUT] Invoking menu action: " + menuAction + " on object " + gameObject.getId() +
                           " at scene(" + sceneX + "," + sceneY + ") with action '" + desired + "'");

                // Optionally move mouse near object for human-like behavior (no extra clicks)
                net.runelite.api.Point canvasPoint = net.runelite.api.Perspective.localToCanvas(client, lp, 0);
                if (canvasPoint != null) {
                    java.awt.Point hoverPoint = findBestClickPosition(canvasPoint, gameObject);
                    smoothMouseMove(hoverPoint);
                }

                // Invoke the menu action with scene coords (this is the primary interaction method)
                logger.info("[RLBOT_INPUT] Invoking menu action: sceneX=" + sceneX + ", sceneY=" + sceneY + ", menuAction=" + menuAction + ", objectId=" + gameObject.getId() + ", action='" + desired + "'");
                client.menuAction(sceneX, sceneY, menuAction, gameObject.getId(), -1, desired, "");
                logger.info("[RLBOT_INPUT] Menu action invoked successfully");
                
            } catch (Exception e) {
                logger.error("[RLBOT_INPUT] Error interacting with game object: " + e.getMessage() + ": " + e.toString());
            }
        });
        
        logger.info("[RLBOT_INPUT] END interactWithGameObject");
    }
    
    /**
     * Right-click at the current mouse position.
     */
    public void rightClick() {
        logger.info("Right-clicking at current mouse position");
        
        clientThread.invoke(() -> {
            if (isWoodcutting() || isWalking()) return;
            Canvas canvas = getCanvas();
            if (canvas == null) {
                logger.error("Canvas is null, cannot right-click");
                return;
            }
            
            // Get the current mouse position relative to the canvas
            Point canvasPosition;
            try {
                Point mousePos = canvas.getMousePosition();
                if (mousePos == null) {
                    logger.warn("Mouse position is null, using canvas center");
                    canvasPosition = new Point(canvas.getWidth() / 2, canvas.getHeight() / 2);
                } else {
                    canvasPosition = mousePos;
                }
            } catch (Exception e) {
                logger.error("Error getting mouse position: " + e.getMessage() + ": " + e.toString());
                canvasPosition = new Point(canvas.getWidth() / 2, canvas.getHeight() / 2);
            }
            // Final move and flush before right-click to ensure overlay and client mouse are in sync
            dispatchMouseMoveEvent(canvas, canvasPosition);
            if (!SwingUtilities.isEventDispatchThread()) {
                try {
                    SwingUtilities.invokeAndWait(() -> { /* flush */ });
                } catch (Exception ignored) {}
            }
            dispatchMouseRightClickEvent(canvas, canvasPosition);
            logger.info("Right-click event dispatched at: " + canvasPosition.x + "," + canvasPosition.y);
        });
    }
    
    /**
     * Dispatches mouse events to simulate a right-click.
     *
     * @param component The component to dispatch the events to
     * @param point The point on the component
     */
    private void dispatchMouseRightClickEvent(Component component, Point point) {
        // Transform coordinates for stretched mode
        Point transformedPoint = transformToStretchedCoordinates(point);
        logger.debug("[RLBOT_INPUT] Right-click at: " + point.x + "," + point.y + 
                    " (transformed: " + transformedPoint.x + "," + transformedPoint.y + ")");
        long when = System.currentTimeMillis();
        int modifiers = InputEvent.BUTTON3_DOWN_MASK;
        int clickCount = 1;
        boolean popupTrigger = true;
        try {
            MouseEvent pressEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_PRESSED,
                when,
                modifiers,
                transformedPoint.x,
                transformedPoint.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON3
            );
            MouseEvent releaseEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_RELEASED,
                when + 50,
                modifiers,
                transformedPoint.x,
                transformedPoint.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON3
            );
            MouseEvent clickEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_CLICKED,
                when + 51,
                modifiers,
                transformedPoint.x,
                transformedPoint.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON3
            );
            SwingUtilities.invokeLater(() -> component.dispatchEvent(pressEvent));
            SwingUtilities.invokeLater(() -> component.dispatchEvent(releaseEvent));
            SwingUtilities.invokeLater(() -> component.dispatchEvent(clickEvent));
        } catch (Exception e) {
            logger.error("Error dispatching mouse right-click events: " + e.getMessage() + ": " + e.toString());
        }
    }
    
    /**
     * Press and release a key.
     *
     * @param keyCode The key code to press
     */
    public void pressKey(int keyCode) {
        logger.info("[RLBOT_INPUT] BEGIN pressKey: " + keyCode + " (key name: " + KeyEvent.getKeyText(keyCode) + ")");
        
        clientThread.invoke(() -> {
            Canvas canvas = getCanvas();
            logger.info("[RLBOT_INPUT] Canvas retrieved: " + (canvas != null ? "success" : "null"));
            if (canvas == null) {
                logger.error("[RLBOT_INPUT] Canvas is null, cannot press key");
                return;
            }
            try {
                logger.info("[RLBOT_INPUT] About to dispatch key event for key code: " + keyCode);
                dispatchKeyEvent(canvas, keyCode);
                logger.info("[RLBOT_INPUT] Key event dispatched successfully for key code: " + keyCode);
            } catch (Exception e) {
                logger.error("[RLBOT_INPUT] Exception during key press: " + e.getMessage() + ": " + e.toString());
            }
        });
        
        logger.info("[RLBOT_INPUT] END pressKey (clientThread invoked)");
    }
    
    /**
     * Dispatches key press and release events to the component.
     *
     * @param component The component to dispatch the events to
     * @param keyCode The key code to press
     */
    private void dispatchKeyEvent(Component component, int keyCode) {
        logger.info("[RLBOT_INPUT] BEGIN dispatchKeyEvent for key: " + keyCode + " (key name: " + KeyEvent.getKeyText(keyCode) + ")");
        
        long when = System.currentTimeMillis();
        int modifiers = 0;
        
        try {
            KeyEvent pressEvent = new KeyEvent(
                component,
                KeyEvent.KEY_PRESSED,
                when,
                modifiers,
                keyCode,
                KeyEvent.CHAR_UNDEFINED
            );
            char keyChar = KeyEvent.CHAR_UNDEFINED;
            boolean sendTyped = false;
            if (keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9) {
                keyChar = (char)('0' + (keyCode - KeyEvent.VK_0));
                sendTyped = true;
            } else if (keyCode >= KeyEvent.VK_A && keyCode <= KeyEvent.VK_Z) {
                keyChar = (char)('a' + (keyCode - KeyEvent.VK_A));
                sendTyped = true;
            } else if (keyCode == KeyEvent.VK_SPACE) {
                keyChar = ' ';
                sendTyped = true;
            }
            KeyEvent typedEvent = null;
            if (sendTyped) {
                typedEvent = new KeyEvent(
                    component,
                    KeyEvent.KEY_TYPED,
                    when + 10,
                    modifiers,
                    KeyEvent.VK_UNDEFINED,
                    keyChar
                );
            }
            KeyEvent releaseEvent = new KeyEvent(
                component,
                KeyEvent.KEY_RELEASED,
                when + 50,
                modifiers,
                keyCode,
                KeyEvent.CHAR_UNDEFINED
            );
            keyManager.processKeyPressed(pressEvent);
            if (typedEvent != null) {
                keyManager.processKeyTyped(typedEvent);
            }
            keyManager.processKeyReleased(releaseEvent);
        } catch (Exception e) {
            logger.error("[RLBOT_INPUT] Error dispatching key events: " + e.getMessage() + ": " + e.toString());
        }
        logger.info("[RLBOT_INPUT] END dispatchKeyEvent");
    }
    
    /**
     * Type a string of characters.
     *
     * @param text The text to type
     */
    public void typeText(String text) {
        logger.info("Typing text: " + text);
        
        clientThread.invoke(() -> {
            Canvas canvas = getCanvas();
            if (canvas == null) {
                logger.error("Canvas is null, cannot type text");
                return;
            }
            
            for (char c : text.toCharArray()) {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                boolean isUpperCase = Character.isUpperCase(c);
                if (isUpperCase) {
                    dispatchModifierKeyEvent(canvas, KeyEvent.VK_SHIFT, true);
                }
                dispatchCharKeyEvent(canvas, keyCode, c);
                if (isUpperCase) {
                    dispatchModifierKeyEvent(canvas, KeyEvent.VK_SHIFT, false);
                }
            }
            
            logger.info("Text typing completed: " + text);
        });
    }

    /**
     * Rotate/tilt camera by simulating a middle-mouse drag from viewport center.
     * Positive dx drags to the right (rotate right), positive dy drags downward (tilt down).
     */
    public void rotateCameraDrag(int dx, int dy) {
        logger.info("[RLBOT_INPUT] BEGIN rotateCameraDrag dx=" + dx + " dy=" + dy);
        clientThread.invoke(() -> {
            Canvas canvas = getCanvas();
            if (canvas == null) {
                logger.error("[RLBOT_INPUT] Canvas is null, cannot rotate camera drag");
                return;
            }
            int vx = client.getViewportXOffset();
            int vy = client.getViewportYOffset();
            int vw = client.getViewportWidth();
            int vh = client.getViewportHeight();
            int startX = vx + Math.max(10, vw / 2);
            int startY = vy + Math.max(10, vh / 2);
            Point start = new Point(startX, startY);
            Point end = new Point(startX + dx, startY + dy);
            try {
                dispatchMiddleDrag(canvas, start, end);
            } catch (Exception e) {
                logger.error("[RLBOT_INPUT] rotateCameraDrag error: " + e.getMessage() + ": " + e.toString());
            }
        });
        logger.info("[RLBOT_INPUT] END rotateCameraDrag (clientThread invoked)");
    }

    /**
     * Rotate camera without interfering with active mouse positioning.
     * Uses middle-mouse drag when safe; otherwise falls back to arrow/page keys.
     */
    public void rotateCameraSafe(int dx, int dy) {
        if (clickInProgress.get()) {
            // Key-based rotation doesn't affect mouse position
            int steps = Math.max(1, Math.min(3, Math.abs(dx) / 60));
            for (int i = 0; i < steps; i++) {
                if (dx > 0) rotateCameraRightSmall(); else if (dx < 0) rotateCameraLeftSmall();
            }
            if (dy != 0) {
                int v = Math.max(1, Math.min(2, Math.abs(dy) / 40));
                for (int i = 0; i < v; i++) { if (dy > 0) tiltCameraDownSmall(); else tiltCameraUpSmall(); }
            }
            return;
        }
        rotateCameraDrag(dx, dy);
    }

    private void dispatchMiddleDrag(Component component, Point start, Point end) {
        // Transform coordinates for stretched mode
        Point transformedStart = transformToStretchedCoordinates(start);
        Point transformedEnd = transformToStretchedCoordinates(end);
        
        logger.debug("[RLBOT_INPUT] Middle drag from: " + start.x + "," + start.y + 
                    " (transformed: " + transformedStart.x + "," + transformedStart.y + ") to: " +
                    end.x + "," + end.y + " (transformed: " + transformedEnd.x + "," + transformedEnd.y + ")");
        
        long when = System.currentTimeMillis();
        int button = MouseEvent.BUTTON2;
        int modifiers = InputEvent.getMaskForButton(button);
        component.requestFocus();

        // Move to start
        dispatchMouseMoveEvent(component, start);

        // Press middle mouse
        MouseEvent press = new MouseEvent(
            component,
            MouseEvent.MOUSE_PRESSED,
            when,
            modifiers,
            transformedStart.x,
            transformedStart.y,
            1,
            false,
            button
        );
        mouseManager.processMousePressed(press);
        // sleepQuiet(20);

        // Drag in small steps
        int steps = 6;
        for (int i = 1; i <= steps; i++) {
            int x = transformedStart.x + (transformedEnd.x - transformedStart.x) * i / steps;
            int y = transformedStart.y + (transformedEnd.y - transformedStart.y) * i / steps;
            MouseEvent drag = new MouseEvent(
                component,
                MouseEvent.MOUSE_DRAGGED,
                when + 10L * i,
                modifiers,
                x,
                y,
                1,
                false,
                button
            );
            mouseManager.processMouseDragged(drag);
            // sleepQuiet(10);
        }

        // Release
        MouseEvent release = new MouseEvent(
            component,
            MouseEvent.MOUSE_RELEASED,
            when + 10L * (steps + 2),
            modifiers,
            transformedEnd.x,
            transformedEnd.y,
            1,
            false,
            button
        );
        mouseManager.processMouseReleased(release);
        // sleepQuiet(20);
    }

    private void sleepQuiet(long ms) {
        // Removed global sleeps to avoid lag; kept method for compatibility
        // try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    // Convenience camera controls
    public void rotateCameraLeftSmall() { pressKey(KeyEvent.VK_LEFT); }
    public void rotateCameraRightSmall() { pressKey(KeyEvent.VK_RIGHT); }
    public void tiltCameraUpSmall() { pressKey(KeyEvent.VK_UP); }
    public void tiltCameraDownSmall() { pressKey(KeyEvent.VK_DOWN); }

    /**
     * Zoom using mouse wheel events without moving the cursor.
     */
    public void zoomInSmall() { dispatchWheel(+1); }
    public void zoomOutSmall() { dispatchWheel(-1); }

    private void dispatchWheel(int wheelRotation) {
        clientThread.invoke(() -> {
            Canvas canvas = getCanvas();
            if (canvas == null) return;
            try {
                long when = System.currentTimeMillis();
                java.awt.event.MouseWheelEvent wheel = new java.awt.event.MouseWheelEvent(
                    canvas,
                    java.awt.event.MouseEvent.MOUSE_WHEEL,
                    when,
                    0,
                    Math.max(1, canvas.getWidth() / 2),
                    Math.max(1, canvas.getHeight() / 2),
                    0,
                    false,
                    java.awt.event.MouseWheelEvent.WHEEL_UNIT_SCROLL,
                    1,
                    wheelRotation
                );
                SwingUtilities.invokeLater(() -> canvas.dispatchEvent(wheel));
            } catch (Exception ignored) {}
        });
    }

    /** Expose click-in-progress flag for tasks. */
    public boolean isClickInProgress() { return clickInProgress.get(); }
    
    // ===================== Occlusion helpers =====================
    private boolean revealPointByCameraUI(Point target, int attempts) {
        // Single-step non-blocking UI de-occlusion attempt
        if (!isOccludedByUI(target)) return true;
        
        // Use enhanced chatbox collision handler if available
        if (chatboxCollisionHandler != null) {
            try {
                if (chatboxCollisionHandler.isInChatArea(target)) {
                    logger.debug("[RLBOT_INPUT] Using enhanced chatbox collision handler for UI occlusion");
                    chatboxCollisionHandler.handleChatboxCollision(target, null, "reveal");
                    return !isOccludedByUI(target); // Check if resolved
                }
            } catch (IllegalStateException e) {
                logger.error("[RLBOT_INPUT] Chat widget error in revealPointByCameraUI: " + e.getMessage());
            }
        }
        
        // Fallback to original logic for non-chatbox UI occlusion
        try {
            int vy = client.getViewportYOffset();
            int vh = client.getViewportHeight();
            if (vh > 0 && target.y > vy + vh - 24) {
                zoomOutSmall();
            } else {
                int dx = 140; // strong horizontal sweep
                int dy = (target.y < vy + vh / 2) ? -20 : 20;
                rotateCameraSafe(dx, dy);
            }
        } catch (Exception ignored) {}
        return false;
    }

    private net.runelite.api.GameObject findObjectAtPointMatchingAction(Point canvasPoint, String expectedAction) {
        try {
            final int plane = client.getPlane();
            net.runelite.api.Scene scene = client.getScene();
            if (scene == null) return null;
            net.runelite.api.Tile[][] tiles = scene.getTiles()[plane];
            if (tiles == null) return null;
            net.runelite.api.GameObject best = null;
            double bestDist = Double.MAX_VALUE;
            for (int x = 0; x < tiles.length; x++) {
                net.runelite.api.Tile[] col = tiles[x];
                if (col == null) continue;
                for (int y = 0; y < col.length; y++) {
                    net.runelite.api.Tile tile = col[y];
                    if (tile == null) continue;
                    for (net.runelite.api.GameObject go : tile.getGameObjects()) {
                        if (go == null) continue;
                        java.awt.Shape hull = go.getConvexHull();
                        if (hull == null || !hull.contains(canvasPoint)) continue;
                        net.runelite.api.ObjectComposition comp = client.getObjectDefinition(go.getId());
                        if (comp == null || comp.getActions() == null) continue;
                        boolean match = false;
                        for (String a : comp.getActions()) {
                            if (a != null && a.toLowerCase().contains(expectedAction.toLowerCase())) { match = true; break; }
                        }
                        if (!match) continue;
                        net.runelite.api.coords.LocalPoint lp = go.getLocalLocation();
                        if (lp == null) continue;
                        double dx = lp.getX() - client.getCameraX();
                        double dy = lp.getY() - client.getCameraY();
                        double dist = Math.hypot(dx, dy);
                        if (dist < bestDist) { bestDist = dist; best = go; }
                    }
                }
            }
            return best;
        } catch (Exception ignored) { return null; }
    }

    public boolean isOccludedByGeometry(Point canvasPoint, net.runelite.api.GameObject target) {
        return isOccludedByGeometryWithDiagnostics(canvasPoint, target, false);
    }
    
    /**
     * Check if a target GameObject is occluded by other geometry with optional diagnostics.
     */
    public boolean isOccludedByGeometryWithDiagnostics(Point canvasPoint, net.runelite.api.GameObject target, boolean enableDiagnostics) {
        try {
            if (target == null) return false;
            net.runelite.api.coords.LocalPoint tlp = target.getLocalLocation();
            if (tlp == null) return false;
            double tdx = tlp.getX() - client.getCameraX();
            double tdy = tlp.getY() - client.getCameraY();
            double tdist = Math.hypot(tdx, tdy);

            if (enableDiagnostics) {
                logger.info("[GEOMETRY] Checking occlusion for target at " + target.getWorldLocation());
                logger.info("[GEOMETRY] Target distance from camera: " + String.format("%.1f", tdist));
                logger.info("[GEOMETRY] Click point: " + canvasPoint);
            }

            final int plane = client.getPlane();
            net.runelite.api.Scene scene = client.getScene();
            if (scene == null) return false;
            net.runelite.api.Tile[][] tiles = scene.getTiles()[plane];
            if (tiles == null) return false;
            
            int occludersFound = 0;
            for (int x = 0; x < tiles.length; x++) {
                net.runelite.api.Tile[] col = tiles[x];
                if (col == null) continue;
                for (int y = 0; y < col.length; y++) {
                    net.runelite.api.Tile tile = col[y];
                    if (tile == null) continue;
                    for (net.runelite.api.GameObject go : tile.getGameObjects()) {
                        if (go == null || go == target) continue;
                        java.awt.Shape hull = go.getConvexHull();
                        if (hull == null || !hull.contains(canvasPoint)) continue;
                        
                        net.runelite.api.coords.LocalPoint lp = go.getLocalLocation();
                        if (lp == null) continue;
                        double dx = lp.getX() - client.getCameraX();
                        double dy = lp.getY() - client.getCameraY();
                        double dist = Math.hypot(dx, dy);
                        
                        if (dist + 1.0 < tdist) {
                            if (enableDiagnostics) {
                                try {
                                    net.runelite.api.ObjectComposition comp = client.getObjectDefinition(go.getId());
                                    String occluderName = comp != null && comp.getName() != null ? comp.getName() : "Unknown";
                                    logger.warn("[GEOMETRY] OCCLUDER FOUND: " + occluderName + " (ID: " + go.getId() + 
                                              ") at " + go.getWorldLocation());
                                    logger.info("[GEOMETRY] - Occluder distance: " + String.format("%.1f", dist) + 
                                              " (closer than target: " + String.format("%.1f", tdist) + ")");
                                    logger.info("[GEOMETRY] - Occluder hull contains click point: " + hull.contains(canvasPoint));
                                } catch (Exception e) {
                                    logger.warn("[GEOMETRY] OCCLUDER FOUND: ID " + go.getId() + " at " + go.getWorldLocation() + 
                                              " (distance: " + String.format("%.1f", dist) + ")");
                                }
                            }
                            return true;
                        } else if (enableDiagnostics && hull.contains(canvasPoint)) {
                            occludersFound++;
                            try {
                                net.runelite.api.ObjectComposition comp = client.getObjectDefinition(go.getId());
                                String name = comp != null && comp.getName() != null ? comp.getName() : "Unknown";
                                logger.info("[GEOMETRY] Object at click point but behind target: " + name + 
                                          " (distance: " + String.format("%.1f", dist) + " vs target: " + String.format("%.1f", tdist) + ")");
                            } catch (Exception ignored) {}
                        }
                    }
                }
            }
            
            if (enableDiagnostics) {
                logger.info("[GEOMETRY] No occluders found (checked " + occludersFound + " objects at click point)");
            }
            
            return false;
        } catch (Exception e) { 
            if (enableDiagnostics) {
                logger.error("[GEOMETRY] Error during occlusion check: " + e.getMessage());
            }
            return false; 
        }
    }

    public boolean revealPointByCameraGeometry(Point targetPoint, net.runelite.api.GameObject target, int attempts) {
        // Attempt to reveal target by applying a strategy based on the attempt index.
        // Return true if the point is no longer occluded after adjustment.
        if (!isOccludedByGeometry(targetPoint, target)) {
            return true;
        }
        try {
            int attemptIndex = Math.max(0, attempts);
            int mode = attemptIndex % 6;
            switch (mode) {
                case 0:
                    // Zoom out a bit to reduce overlap
                    zoomOutSmall();
                    zoomOutSmall();
                    break;
                case 1:
                    // Rotate left
                    rotateCameraSafe(-120, 0);
                    break;
                case 2:
                    // Rotate right
                    rotateCameraSafe(120, 0);
                    break;
                case 3:
                    // Tilt up
                    rotateCameraSafe(0, -40);
                    break;
                case 4:
                    // Tilt down
                    rotateCameraSafe(0, 40);
                    break;
                default:
                    // Zoom in slightly to change parallax, then a small rotate
                    zoomInSmall();
                    rotateCameraSafe(90, 0);
                    break;
            }
        } catch (Exception ignored) {}
        return !isOccludedByGeometry(targetPoint, target);
    }
    
    /**
     * Dispatches a key event for a character.
     *
     * @param component The component to dispatch the events to
     * @param keyCode The key code
     * @param keyChar The character to type
     */
    private void dispatchCharKeyEvent(Component component, int keyCode, char keyChar) {
        long when = System.currentTimeMillis();
        int modifiers = Character.isUpperCase(keyChar) ? KeyEvent.SHIFT_DOWN_MASK : 0;
        
        try {
            KeyEvent pressEvent = new KeyEvent(
                component,
                KeyEvent.KEY_PRESSED,
                when,
                modifiers,
                keyCode,
                KeyEvent.CHAR_UNDEFINED
            );
            KeyEvent typedEvent = new KeyEvent(
                component,
                KeyEvent.KEY_TYPED,
                when + 10,
                modifiers,
                KeyEvent.VK_UNDEFINED,
                keyChar
            );
            KeyEvent releaseEvent = new KeyEvent(
                component,
                KeyEvent.KEY_RELEASED,
                when + 50,
                modifiers,
                keyCode,
                KeyEvent.CHAR_UNDEFINED
            );
            keyManager.processKeyPressed(pressEvent);
            keyManager.processKeyTyped(typedEvent);
            keyManager.processKeyReleased(releaseEvent);
        } catch (Exception e) {
            logger.error("Error dispatching character key events: " + e.getMessage() + ": " + e.toString());
        }
    }
    
    /**
     * Dispatches a modifier key event (press or release).
     *
     * @param component The component to dispatch the event to
     * @param keyCode The modifier key code
     * @param press True for press, false for release
     */
    private void dispatchModifierKeyEvent(Component component, int keyCode, boolean press) {
        long when = System.currentTimeMillis();
        int modifiers = 0;
        
        if (keyCode == KeyEvent.VK_SHIFT) {
            modifiers = KeyEvent.SHIFT_DOWN_MASK;
        } else if (keyCode == KeyEvent.VK_CONTROL) {
            modifiers = KeyEvent.CTRL_DOWN_MASK;
        } else if (keyCode == KeyEvent.VK_ALT) {
            modifiers = KeyEvent.ALT_DOWN_MASK;
        }
        
        try {
            KeyEvent event = new KeyEvent(
                component,
                press ? KeyEvent.KEY_PRESSED : KeyEvent.KEY_RELEASED,
                when,
                press ? modifiers : 0, // Only include modifiers for press event
                keyCode,
                KeyEvent.CHAR_UNDEFINED
            );
            if (press) {
                keyManager.processKeyPressed(event);
            } else {
                keyManager.processKeyReleased(event);
            }
        } catch (Exception e) {
            logger.error("Error dispatching modifier key event: " + e.getMessage() + ": " + e.toString());
        }
    }
    
    /**
     * Find the best click position for an object using RuneLite's convex hull.
     * This is much more reliable than guessing with offsets.
     *
     * @param centerPoint The center point of the object (fallback)
     * @param gameObject The game object to click on
     * @return The best click position found
     */
    private java.awt.Point findBestClickPosition(net.runelite.api.Point centerPoint, net.runelite.api.GameObject gameObject) {
        try {
            // Get the convex hull (actual clickable area) of the object
            Shape convexHull = gameObject.getConvexHull();
            if (convexHull != null) {
                // Get the center of the convex hull
                Rectangle bounds = convexHull.getBounds();
                if (bounds != null && bounds.width > 0 && bounds.height > 0) {
                    // Sample a few points inside the convex hull to avoid edges: center and midpoints
                    java.awt.Point[] candidates = new java.awt.Point[] {
                        new java.awt.Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2),
                        new java.awt.Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 3),
                        new java.awt.Point(bounds.x + bounds.width / 3, bounds.y + bounds.height / 2),
                        new java.awt.Point(bounds.x + (2*bounds.width) / 3, bounds.y + bounds.height / 2)
                    };
                    for (java.awt.Point c : candidates) {
                        if (convexHull.contains(c)) {
                            return c;
                        }
                    }
                    // Fallback to geometric center if samples fail
                    return new java.awt.Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
                }
            }
            
            // Fallback to the provided center point if convex hull is not available
            logger.info("[RLBOT_INPUT] Convex hull not available, using fallback center: (" + centerPoint.getX() + "," + centerPoint.getY() + ")");
            return new java.awt.Point(centerPoint.getX(), centerPoint.getY());
            
        } catch (Exception e) {
            logger.warn("[RLBOT_INPUT] Error getting convex hull: " + e.getMessage());
            // Fallback to the provided center point
            return new java.awt.Point(centerPoint.getX(), centerPoint.getY());
        }
    }

    private boolean isWoodcutting() {
        try {
            net.runelite.api.Player lp = client.getLocalPlayer();
            return lp != null && lp.getAnimation() == 877;
        } catch (Exception ignored) { return false; }
    }

    private boolean isWalking() {
        try {
            net.runelite.api.Player lp = client.getLocalPlayer();
            if (lp == null) return false;
            int pose = lp.getPoseAnimation();
            return pose == 819 || pose == 824 || pose == 822 || pose == 820;
        } catch (Exception ignored) { return false; }
    }
}