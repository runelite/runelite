package net.runelite.client.plugins.customdevtool;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("customdevtool")
public interface CustomDevToolConfig extends Config
{
    @ConfigItem(
            position = 1,
            keyName = "startGrabInfo",
            name = "Start grabbing game info",
            description = "Displays IDs of items, players, npcs, animations, etc."
    )
    default boolean startGrabInfo() { return false;}

}
