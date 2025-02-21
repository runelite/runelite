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
        return 43594;
    }
} 