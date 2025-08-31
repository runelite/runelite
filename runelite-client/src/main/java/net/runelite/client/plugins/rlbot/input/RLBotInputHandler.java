package net.runelite.client.plugins.rlbot.input;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import java.util.Random;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.rlbot.RLBotLogger;

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
     * Key manager for RuneLite key events.
     */
    private final KeyManager keyManager;
    
    /**
     * Mouse manager for RuneLite mouse events.
     */
    private final MouseManager mouseManager;
    
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
        
        // Test if we can access the canvas
        Canvas canvas = getCanvas();
        if (canvas != null) {
            try {
                Point location = canvas.getLocationOnScreen();
                logger.info("Canvas found at location: " + location.x + "," + location.y);
            } catch (Exception e) {
                logger.error("Error getting canvas location: " + e.getMessage() + ": " + e.toString());
            }
        } else {
            logger.error("Canvas not found. Input handling may not work correctly.");
        }
        
        logger.info("RLBot input handler initialization complete");
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
     * Move the mouse to the specified point on the game canvas and dispatch appropriate events.
     *
     * @param canvasPoint The point on the game canvas to move to
     */
    public void smoothMouseMove(Point canvasPoint) {
        logger.info("[RLBOT_INPUT] BEGIN smoothMouseMove to canvas point: " + canvasPoint.x + "," + canvasPoint.y);
        
        // Get the canvas and dispatch events on the client thread
        clientThread.invoke(() -> {
            Canvas canvas = getCanvas();
            logger.info("[RLBOT_INPUT] Canvas retrieved: " + (canvas != null ? "success" : "null"));
            
            if (canvas == null) {
                logger.error("[RLBOT_INPUT] Canvas is null, cannot move mouse");
                return;
            }
            
            logger.info("[RLBOT_INPUT] Canvas size: " + canvas.getWidth() + "x" + canvas.getHeight());
            
            try {
                logger.info("[RLBOT_INPUT] About to dispatch mouse move event to: " + canvasPoint.x + "," + canvasPoint.y);
                dispatchMouseMoveEvent(canvas, canvasPoint);
                logger.info("[RLBOT_INPUT] Mouse move event dispatched successfully to: " + canvasPoint.x + "," + canvasPoint.y);
            } catch (Exception e) {
                logger.error("[RLBOT_INPUT] Exception during mouse move: " + e.getMessage() + ": " + e.toString());
            }
        });
        
        logger.info("[RLBOT_INPUT] END smoothMouseMove (clientThread invoked)");
    }
    
    /**
     * Dispatches a mouse move event to the component.
     *
     * @param component The component to dispatch the event to
     * @param point The point on the component
     */
    private void dispatchMouseMoveEvent(Component component, Point point) {
        logger.info("[RLBOT_INPUT] BEGIN dispatchMouseMoveEvent to: " + point.x + "," + point.y);
        
        long when = System.currentTimeMillis();
        int modifiers = 0;
        int clickCount = 0;
        boolean popupTrigger = false;
        
        // Check if point is within canvas bounds
        boolean isInBounds = point.x >= 0 && point.y >= 0 && 
                           point.x < component.getWidth() && 
                           point.y < component.getHeight();
        
        // If moving out of bounds, dispatch a mouse exit event
        if (!isInBounds) {
            MouseEvent exitEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_EXITED,
                when,
                modifiers,
                point.x,
                point.y,
                clickCount,
                popupTrigger
            );
            component.dispatchEvent(exitEvent);
            return;
        }
        
        // If we were previously out of bounds, dispatch a mouse enter event
        MouseEvent enterEvent = new MouseEvent(
            component,
            MouseEvent.MOUSE_ENTERED,
            when,
            modifiers,
            point.x,
            point.y,
            clickCount,
            popupTrigger
        );
        component.dispatchEvent(enterEvent);
        
        logger.info("[RLBOT_INPUT] Creating MouseEvent with params: id=MOUSE_MOVED, when=" + when + 
                    ", modifiers=" + modifiers + ", point=(" + point.x + "," + point.y + 
                    "), clickCount=" + clickCount + ", popupTrigger=" + popupTrigger);
        
        MouseEvent event = new MouseEvent(
            component,
            MouseEvent.MOUSE_MOVED,
            when,
            modifiers,
            point.x,
            point.y,
            clickCount,
            popupTrigger
        );
        
        // First make sure component has focus
        logger.info("[RLBOT_INPUT] Requesting focus on component: " + component.getClass().getName());
        component.requestFocus();
        
        // Use SwingUtilities.invokeAndWait to ensure event is fully processed
        try {
            logger.info("[RLBOT_INPUT] About to dispatch mouse move event via SwingUtilities.invokeAndWait");
            SwingUtilities.invokeAndWait(() -> {
                logger.info("[RLBOT_INPUT] Inside invokeAndWait, about to dispatch event to component");
                component.dispatchEvent(event);
                logger.info("[RLBOT_INPUT] Event dispatched to component");
            });
            
            logger.info("[RLBOT_INPUT] SwingUtilities.invokeAndWait completed successfully");
            
            // Add a small delay to allow the event to be processed
            try {
                logger.info("[RLBOT_INPUT] Sleeping for 50ms to allow event processing");
                Thread.sleep(50);
                logger.info("[RLBOT_INPUT] Sleep completed");
            } catch (InterruptedException e) {
                logger.error("[RLBOT_INPUT] Sleep interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        } catch (Exception e) {
            logger.error("[RLBOT_INPUT] Error dispatching mouse move event: " + e.getMessage() + ": " + e.toString());
        }
        
        logger.info("[RLBOT_INPUT] END dispatchMouseMoveEvent");
    }
    
    /**
     * Click at the current mouse position.
     */
    public void click() {
        logger.info("[RLBOT_INPUT] BEGIN click at current mouse position");
        
        clientThread.invoke(() -> {
            Canvas canvas = getCanvas();
            logger.info("[RLBOT_INPUT] Canvas retrieved: " + (canvas != null ? "success" : "null"));
            
            if (canvas == null) {
                logger.error("[RLBOT_INPUT] Canvas is null, cannot click");
                return;
            }
            
            // Get the current mouse position relative to the canvas
            Point canvasPosition;
            try {
                Point mousePos = canvas.getMousePosition();
                logger.info("[RLBOT_INPUT] Canvas.getMousePosition returned: " + (mousePos != null ? mousePos.x + "," + mousePos.y : "null"));
                
                if (mousePos == null) {
                    logger.warn("[RLBOT_INPUT] Mouse position is null, using canvas center");
                    canvasPosition = new Point(canvas.getWidth() / 2, canvas.getHeight() / 2);
                    logger.info("[RLBOT_INPUT] Using canvas center: " + canvasPosition.x + "," + canvasPosition.y);
                } else {
                    canvasPosition = mousePos;
                    logger.info("[RLBOT_INPUT] Using mouse position: " + canvasPosition.x + "," + canvasPosition.y);
                }
            } catch (Exception e) {
                logger.error("[RLBOT_INPUT] Error getting mouse position: " + e.getMessage() + ": " + e.toString());
                canvasPosition = new Point(canvas.getWidth() / 2, canvas.getHeight() / 2);
                logger.info("[RLBOT_INPUT] Using canvas center as fallback: " + canvasPosition.x + "," + canvasPosition.y);
            }
            
            try {
                logger.info("[RLBOT_INPUT] About to dispatch click event at: " + canvasPosition.x + "," + canvasPosition.y);
                dispatchMouseClickEvent(canvas, canvasPosition);
                logger.info("[RLBOT_INPUT] Click event dispatched successfully at: " + canvasPosition.x + "," + canvasPosition.y);
            } catch (Exception e) {
                logger.error("[RLBOT_INPUT] Exception during click: " + e.getMessage() + ": " + e.toString());
            }
        });
        
        logger.info("[RLBOT_INPUT] END click (clientThread invoked)");
    }
    
    /**
     * Dispatches mouse press, release, and click events to simulate a click.
     *
     * @param component The component to dispatch the events to
     * @param point The point on the component
     */
    private void dispatchMouseClickEvent(Component component, Point point) {
        logger.info("[RLBOT_INPUT] BEGIN dispatchMouseClickEvent at: " + point.x + "," + point.y);
        
        long when = System.currentTimeMillis();
        int modifiers = InputEvent.BUTTON1_DOWN_MASK;
        int clickCount = 1;
        boolean popupTrigger = false;
        
        // First make sure component has focus
        logger.info("[RLBOT_INPUT] Requesting focus on component: " + component.getClass().getName());
        component.requestFocus();
        
        try {
            // Create mouse events
            logger.info("[RLBOT_INPUT] Creating press event with params: id=MOUSE_PRESSED, when=" + when + 
                        ", modifiers=" + modifiers + ", point=(" + point.x + "," + point.y + 
                        "), clickCount=" + clickCount + ", popupTrigger=" + popupTrigger + 
                        ", button=BUTTON1");
            
            MouseEvent pressEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_PRESSED,
                when,
                modifiers,
                point.x,
                point.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON1
            );
            
            logger.info("[RLBOT_INPUT] Creating release event with params: id=MOUSE_RELEASED, when=" + (when + 50));
            MouseEvent releaseEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_RELEASED,
                when + 50,
                modifiers,
                point.x,
                point.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON1
            );
            
            logger.info("[RLBOT_INPUT] Creating click event with params: id=MOUSE_CLICKED, when=" + (when + 51));
            MouseEvent clickEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_CLICKED,
                when + 51,
                modifiers,
                point.x,
                point.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON1
            );
            
            // Dispatch events with proper timing
            logger.info("[RLBOT_INPUT] About to dispatch press event via SwingUtilities.invokeAndWait");
            SwingUtilities.invokeAndWait(() -> {
                logger.info("[RLBOT_INPUT] Inside invokeAndWait, about to dispatch press event");
                component.dispatchEvent(pressEvent);
                logger.info("[RLBOT_INPUT] Press event dispatched");
            });
            
            // Small delay between press and release
            logger.info("[RLBOT_INPUT] Sleeping for 50ms between press and release");
            try {
                Thread.sleep(50);
                logger.info("[RLBOT_INPUT] Sleep completed");
            } catch (InterruptedException e) {
                logger.error("[RLBOT_INPUT] Sleep interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            
            logger.info("[RLBOT_INPUT] About to dispatch release and click events via SwingUtilities.invokeAndWait");
            SwingUtilities.invokeAndWait(() -> {
                logger.info("[RLBOT_INPUT] Inside invokeAndWait, about to dispatch release event");
                component.dispatchEvent(releaseEvent);
                logger.info("[RLBOT_INPUT] Release event dispatched");
                
                logger.info("[RLBOT_INPUT] About to dispatch click event");
                component.dispatchEvent(clickEvent);
                logger.info("[RLBOT_INPUT] Click event dispatched");
            });
            
            // Allow time for the events to be processed
            logger.info("[RLBOT_INPUT] Sleeping for 50ms after click events");
            try {
                Thread.sleep(50);
                logger.info("[RLBOT_INPUT] Final sleep completed");
            } catch (InterruptedException e) {
                logger.error("[RLBOT_INPUT] Sleep interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            
        } catch (Exception e) {
            logger.error("[RLBOT_INPUT] Error dispatching mouse click events: " + e.getMessage() + ": " + e.toString());
        }
        
        logger.info("[RLBOT_INPUT] END dispatchMouseClickEvent");
    }
    
    /**
     * Right-click at the current mouse position.
     */
    public void rightClick() {
        logger.info("Right-clicking at current mouse position");
        
        clientThread.invoke(() -> {
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
            
            // Dispatch mouse events
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
        long when = System.currentTimeMillis();
        int modifiers = InputEvent.BUTTON3_DOWN_MASK;
        int clickCount = 1;
        boolean popupTrigger = true;
        
        // First make sure component has focus
        component.requestFocus();
        
        try {
            // Create mouse events
            MouseEvent pressEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_PRESSED,
                when,
                modifiers,
                point.x,
                point.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON3
            );
            
            MouseEvent releaseEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_RELEASED,
                when + 50,
                modifiers,
                point.x,
                point.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON3
            );
            
            MouseEvent clickEvent = new MouseEvent(
                component,
                MouseEvent.MOUSE_CLICKED,
                when + 51,
                modifiers,
                point.x,
                point.y,
                clickCount,
                popupTrigger,
                MouseEvent.BUTTON3
            );
            
            // Dispatch events with proper timing
            SwingUtilities.invokeAndWait(() -> {
                component.dispatchEvent(pressEvent);
            });
            
            // Small delay between press and release
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            SwingUtilities.invokeAndWait(() -> {
                component.dispatchEvent(releaseEvent);
                component.dispatchEvent(clickEvent);
            });
            
            // Allow time for the events to be processed
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
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
        
        // First make sure component has focus
        logger.info("[RLBOT_INPUT] Requesting focus on component: " + component.getClass().getName());
        component.requestFocus();
        
        try {
            // Create key events
            logger.info("[RLBOT_INPUT] Creating press event with params: id=KEY_PRESSED, when=" + when + 
                        ", modifiers=" + modifiers + ", keyCode=" + keyCode);
            
            KeyEvent pressEvent = new KeyEvent(
                component,
                KeyEvent.KEY_PRESSED,
                when,
                modifiers,
                keyCode,
                KeyEvent.CHAR_UNDEFINED
            );
            
            // Determine if we need to send a KEY_TYPED event
            char keyChar = KeyEvent.CHAR_UNDEFINED;
            boolean sendTyped = false;
            
            if (keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9) {
                keyChar = (char)('0' + (keyCode - KeyEvent.VK_0));
                sendTyped = true;
                logger.info("[RLBOT_INPUT] Will send KEY_TYPED event for number character: " + keyChar);
            } else if (keyCode >= KeyEvent.VK_A && keyCode <= KeyEvent.VK_Z) {
                keyChar = (char)('a' + (keyCode - KeyEvent.VK_A));
                sendTyped = true;
                logger.info("[RLBOT_INPUT] Will send KEY_TYPED event for letter character: " + keyChar);
            } else if (keyCode == KeyEvent.VK_SPACE) {
                keyChar = ' ';
                sendTyped = true;
                logger.info("[RLBOT_INPUT] Will send KEY_TYPED event for space character");
            } else {
                logger.info("[RLBOT_INPUT] No KEY_TYPED event needed for key: " + KeyEvent.getKeyText(keyCode));
            }
            
            KeyEvent typedEvent = null;
            if (sendTyped) {
                logger.info("[RLBOT_INPUT] Creating typed event with params: id=KEY_TYPED, when=" + (when + 10) + 
                            ", keyChar=" + keyChar);
                
                typedEvent = new KeyEvent(
                    component,
                    KeyEvent.KEY_TYPED,
                    when + 10,
                    modifiers,
                    KeyEvent.VK_UNDEFINED,
                    keyChar
                );
            }
            
            logger.info("[RLBOT_INPUT] Creating release event with params: id=KEY_RELEASED, when=" + (when + 50));
            KeyEvent releaseEvent = new KeyEvent(
                component,
                KeyEvent.KEY_RELEASED,
                when + 50,
                modifiers,
                keyCode,
                KeyEvent.CHAR_UNDEFINED
            );
            
            // Dispatch events with proper timing
            final KeyEvent finalTypedEvent = typedEvent;
            
            logger.info("[RLBOT_INPUT] About to dispatch press and potentially typed events via SwingUtilities.invokeAndWait");
            SwingUtilities.invokeAndWait(() -> {
                logger.info("[RLBOT_INPUT] Inside invokeAndWait, about to dispatch press event");
                component.dispatchEvent(pressEvent);
                logger.info("[RLBOT_INPUT] Press event dispatched");
                
                if (finalTypedEvent != null) {
                    logger.info("[RLBOT_INPUT] About to dispatch typed event");
                    component.dispatchEvent(finalTypedEvent);
                    logger.info("[RLBOT_INPUT] Typed event dispatched");
                }
            });
            
            // Small delay between press and release
            logger.info("[RLBOT_INPUT] Sleeping for 50ms between press and release");
            try {
                Thread.sleep(50);
                logger.info("[RLBOT_INPUT] Sleep completed");
            } catch (InterruptedException e) {
                logger.error("[RLBOT_INPUT] Sleep interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            
            logger.info("[RLBOT_INPUT] About to dispatch release event via SwingUtilities.invokeAndWait");
            SwingUtilities.invokeAndWait(() -> {
                logger.info("[RLBOT_INPUT] Inside invokeAndWait, about to dispatch release event");
                component.dispatchEvent(releaseEvent);
                logger.info("[RLBOT_INPUT] Release event dispatched");
            });
            
            // Allow time for the events to be processed
            logger.info("[RLBOT_INPUT] Sleeping for 50ms after key events");
            try {
                Thread.sleep(50);
                logger.info("[RLBOT_INPUT] Final sleep completed");
            } catch (InterruptedException e) {
                logger.error("[RLBOT_INPUT] Sleep interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            
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
                    // Press shift first
                    dispatchModifierKeyEvent(canvas, KeyEvent.VK_SHIFT, true);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                
                // Type the character
                dispatchCharKeyEvent(canvas, keyCode, c);
                
                if (isUpperCase) {
                    // Release shift
                    dispatchModifierKeyEvent(canvas, KeyEvent.VK_SHIFT, false);
                }
                
                // Add a small delay between characters
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            
            logger.info("Text typing completed: " + text);
        });
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
            // Create key events
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
            
            // Dispatch events with proper timing
            SwingUtilities.invokeAndWait(() -> {
                component.dispatchEvent(pressEvent);
                component.dispatchEvent(typedEvent);
            });
            
            // Small delay between press and release
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            SwingUtilities.invokeAndWait(() -> {
                component.dispatchEvent(releaseEvent);
            });
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
            // Create key event
            KeyEvent event = new KeyEvent(
                component,
                press ? KeyEvent.KEY_PRESSED : KeyEvent.KEY_RELEASED,
                when,
                press ? modifiers : 0, // Only include modifiers for press event
                keyCode,
                KeyEvent.CHAR_UNDEFINED
            );
            
            // Dispatch event
            SwingUtilities.invokeAndWait(() -> {
                component.dispatchEvent(event);
            });
        } catch (Exception e) {
            logger.error("Error dispatching modifier key event: " + e.getMessage() + ": " + e.toString());
        }
    }
} 