package net.runelite.client.plugins.rlbot;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("rlbot")
public interface RLBotConfig extends Config {
    @ConfigItem(
        keyName = "port",
        name = "WebSocket Port",
        description = "The port to run the WebSocket server on",
        position = 1
    )
    default int getPort() {
        return 8080;
    }

    @ConfigItem(
        keyName = "showOverlay",
        name = "Show Overlay",
        description = "Show the RLBot overlay with stats and rewards",
        position = 2
    )
    default boolean showOverlay() {
        return true;
    }

    @ConfigItem(
        keyName = "showCursor",
        name = "Show Cursor Trail",
        description = "Show the cursor trail when the bot moves the mouse",
        position = 3
    )
    default boolean showCursor() {
        return true;
    }
} 