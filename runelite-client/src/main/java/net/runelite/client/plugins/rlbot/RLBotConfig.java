package net.runelite.client.plugins.rlbot;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

/**
 * Configuration interface for the RLBot plugin.
 */
@ConfigGroup("rlbot")
public interface RLBotConfig extends Config {
    
    /**
     * Whether to enable the RLBot plugin.
     */
    @ConfigItem(
        keyName = "enableRLBot",
        name = "Enable RLBot",
        description = "Enable the RLBot plugin"
    )
    default boolean enableRLBot() {
        return true;
    }
    
    /**
     * The port to use for the REST server.
     */
    @ConfigItem(
        keyName = "restPort",
        name = "REST API Port",
        description = "The port to use for the REST API server"
    )
    @Range(
        min = 1024,
        max = 65535
    )
    default int websocketPort() {
        return RLBotConstants.DEFAULT_REST_PORT;
    }
    
    /**
     * Whether to save screenshots.
     */
    @ConfigItem(
        keyName = "saveScreenshots",
        name = "Save Screenshots",
        description = "Save screenshots to disk"
    )
    default boolean saveScreenshots() {
        return false;
    }
    
    /**
     * The interval at which to send game state updates.
     */
    @ConfigItem(
        keyName = "updateInterval",
        name = "Update Interval (ms)",
        description = "The interval in milliseconds at which to send game state updates"
    )
    @Range(
        min = 50,
        max = 1000
    )
    default int updateInterval() {
        return 100;
    }
    
    /**
     * Whether to enable debug logging.
     */
    @ConfigItem(
        keyName = "debugLogging",
        name = "Debug Logging",
        description = "Enable debug logging"
    )
    default boolean debugLogging() {
        return true;
    }
    
    /**
     * Whether to show the current action in the overlay.
     */
    @ConfigItem(
        keyName = "showOverlay",
        name = "Show Overlay",
        description = "Show the RLBot overlay"
    )
    default boolean showOverlay() {
        return true;
    }
    
    /**
     * Whether to show the cursor overlay.
     */
    @ConfigItem(
        keyName = "showCursorOverlay",
        name = "Show Cursor Overlay",
        description = "Shows a visual overlay of the cursor position",
        position = 99
    )
    default boolean showCursorOverlay()
    {
        return true;
    }

    @ConfigItem(
        keyName = "enableJavaAgent",
        name = "Enable Java Agent",
        description = "Run the built-in Java agent (disables Python need)"
    )
    default boolean enableJavaAgent() {
        return false;
    }

    @ConfigItem(
        keyName = "agentIntervalMs",
        name = "Agent Interval (ms)",
        description = "How often the Java agent decides and acts"
    )
    @Range(min = 50, max = 2000)
    default int agentIntervalMs() {
        return 250;
    }

    @ConfigItem(
        keyName = "enableRestApi",
        name = "Enable REST API",
        description = "Expose REST endpoints (disable to run Java agent only)"
    )
    default boolean enableRestApi() {
        return true;
    }
} 