package net.runelite.client.plugins.rlbot;

import java.time.format.DateTimeFormatter;
import java.io.File;
import net.runelite.client.RuneLite;

/**
 * Constants used by the RLBot plugin.
 */
public final class RLBotConstants {
    /**
     * Path to the log file for plugin logging.
     */
    public static final String LOG_FILE = new File(new File(RuneLite.RUNELITE_DIR, "rlbot/logs"), "rlbot-plugin.log").getAbsolutePath();
        
    /**
     * Date format for logging.
     */
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    
    /**
     * Date format for file names.
     */
    public static final DateTimeFormatter DATE_FORMAT_FILE = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    
    /**
     * Directory for storing screenshots.
     */
    public static final String SCREENSHOTS_DIR = new File(RuneLite.RUNELITE_DIR, "rlbot/screenshots").getAbsolutePath();
    
    /**
     * Default REST API port.
     */
    public static final int DEFAULT_REST_PORT = 43595;
    
    /**
     * Size of each exploration chunk.
     */
    public static final int EXPLORATION_CHUNK_SIZE = 8;
    
    /**
     * Camera rotation amount in degrees.
     */
    public static final int CAMERA_ROTATE_AMOUNT = 45;
    
    /**
     * Camera zoom amount.
     */
    public static final float CAMERA_ZOOM_AMOUNT = 25f;
    
    /**
     * Mouse movement constants.
     */
    public static final int MOUSE_LERP_STEPS = 3;
    public static final long MOUSE_MOVE_TIME = 50;
    public static final long MIN_MOVE_DELAY = 25;
    public static final long MAX_MOVE_DELAY = 75;
    
    /**
     * Screenshot related constants.
     */
    public static final long SCREENSHOT_COOLDOWN = 100;
    public static final int SCREENSHOT_WIDTH = 160;
    public static final int SCREENSHOT_HEIGHT = 120;
    public static final float SCREENSHOT_COMPRESSION = 0.3f;
    
    /**
     * REST API endpoints.
     */
    public static final String ENDPOINT_STATE = "/state";
    public static final String ENDPOINT_COMMAND = "/command";
    
    /**
     * Action types.
     */
    public static final String ACTION_MOVE_AND_CLICK = "moveAndClick";
    public static final String ACTION_CAMERA_ROTATE = "cameraRotate";
    public static final String ACTION_CAMERA_ZOOM = "cameraZoom";
    public static final String ACTION_PRESS_KEY = "pressKey";
    public static final String ACTION_INTERFACE_ACTION = "interfaceAction";
    
    /**
     * Target types.
     */
    public static final String TARGET_NPC = "npc";
    public static final String TARGET_COORDINATES = "coordinates";
    public static final String TARGET_OBJECT = "object";
    public static final String TARGET_GROUND_ITEM = "ground_item";
    
    /**
     * Private constructor to prevent instantiation.
     */
    private RLBotConstants() {
        // This class should not be instantiated
    }
} 