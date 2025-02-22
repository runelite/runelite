package net.runelite.client.plugins.rlbot;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("rlbot")
public interface RLBotConfig extends Config {
    @ConfigItem(
        keyName = "showCursor",
        name = "Show Cursor",
        description = "Show the bot's cursor position",
        position = 1
    )
    default boolean showCursor() {
        return true;
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
        keyName = "port",
        name = "WebSocket Port",
        description = "The port to run the WebSocket server on",
        position = 3
    )
    default int getPort() {
        return 43595;
    }
} 