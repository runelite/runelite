package net.runelite.client.plugins.rlbot.input;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.rlbot.RLBotConstants;
import net.runelite.client.plugins.rlbot.RLBotLogger;

/**
 * Handles mouse and keyboard input for the RLBot plugin.
 */
@RequiredArgsConstructor
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
     * Robot instance for native input events.
     */
    private Robot robot;
    
    /**
     * Initialize the input handler.
     */
    public void initialize() {
        if (robot == null) {
            try {
                robot = new Robot();
                robot.setAutoDelay(5);
                robot.setAutoWaitForIdle(true);
                logger.info("Input handler initialized");
            } catch (AWTException e) {
                logger.error("Failed to initialize input handler: " + e.getMessage());
            }
        }
    }
    
    /**
     * Move the mouse to the specified point with smooth movement.
     *
     * @param targetPoint The target point to move to
     */
    public void smoothMouseMove(Point targetPoint) {
        if (robot == null) {
            logger.error("Robot not initialized for mouse move");
            return;
        }
        
        Point startPoint = MouseInfo.getPointerInfo().getLocation();
        double distance = startPoint.distance(targetPoint);
        
        // Determine number of steps based on distance
        int steps = Math.min(RLBotConstants.MOUSE_LERP_STEPS, (int)(distance / 10) + 1);
        
        // Perform the movement in steps
        for (int i = 1; i <= steps; i++) {
            double fraction = (double) i / steps;
            int x = (int) (startPoint.x + (targetPoint.x - startPoint.x) * fraction);
            int y = (int) (startPoint.y + (targetPoint.y - startPoint.y) * fraction);
            
            // Add slight randomization for more natural movement
            x += random.nextInt(3) - 1;
            y += random.nextInt(3) - 1;
            
            robot.mouseMove(x, y);
            
            // Small delay between moves
            try {
                long delay = RLBotConstants.MIN_MOVE_DELAY + 
                    (long) (random.nextDouble() * 
                    (RLBotConstants.MAX_MOVE_DELAY - RLBotConstants.MIN_MOVE_DELAY));
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Mouse move interrupted: " + e.getMessage());
                break;
            }
        }
        
        // Final move to exact target
        robot.mouseMove(targetPoint.x, targetPoint.y);
    }
    
    /**
     * Click at the current mouse position.
     */
    public void click() {
        if (robot == null) {
            logger.error("Robot not initialized for click");
            return;
        }
        
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        try {
            Thread.sleep(random.nextInt(50) + 50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    
    /**
     * Right-click at the current mouse position.
     */
    public void rightClick() {
        if (robot == null) {
            logger.error("Robot not initialized for right click");
            return;
        }
        
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        try {
            Thread.sleep(random.nextInt(50) + 50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }
    
    /**
     * Press and release a key.
     *
     * @param keyCode The key code to press
     */
    public void pressKey(int keyCode) {
        if (robot == null) {
            logger.error("Robot not initialized for key press");
            return;
        }
        
        robot.keyPress(keyCode);
        try {
            Thread.sleep(random.nextInt(50) + 50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        robot.keyRelease(keyCode);
    }
    
    /**
     * Type a string of characters.
     *
     * @param text The text to type
     */
    public void typeText(String text) {
        if (robot == null) {
            logger.error("Robot not initialized for typing");
            return;
        }
        
        for (char c : text.toCharArray()) {
            type(c);
            try {
                Thread.sleep(random.nextInt(50) + 50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    
    /**
     * Type a single character.
     *
     * @param c The character to type
     */
    private void type(char c) {
        try {
            if (Character.isUpperCase(c)) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }
            
            // Convert the character to a key code
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (keyCode != KeyEvent.VK_UNDEFINED) {
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
            }
            
            if (Character.isUpperCase(c)) {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
        } catch (Exception e) {
            logger.error("Error typing character: " + e.getMessage());
        }
    }
} 