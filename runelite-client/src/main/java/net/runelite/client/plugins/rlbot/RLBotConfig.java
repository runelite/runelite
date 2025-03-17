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
     * The port to use for the WebSocket server.
     */
    @ConfigItem(
        keyName = "websocketPort",
        name = "WebSocket Port",
        description = "The port to use for the WebSocket server"
    )
    @Range(
        min = 1024,
        max = 65535
    )
    default int websocketPort() {
        return RLBotConstants.DEFAULT_WEBSOCKET_PORT;
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
} 