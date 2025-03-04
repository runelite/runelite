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
        name = "Show Cursor Trail",
        description = "Show the cursor trail overlay",
        position = 12
    )
    default boolean showOverlay() {
        return true;
    }

    @ConfigItem(
        keyName = "port",
        name = "WebSocket Port",
        description = "The port to use for the WebSocket server",
        position = 3
    )
    default int getPort() {
        return 43595;
    }

    @ConfigItem(
        keyName = "saveScreenshots",
        name = "Save Screenshots",
        description = "Save screenshots to disk",
        position = 4
    )
    default boolean saveScreenshots() {
        return false;
    }
} 