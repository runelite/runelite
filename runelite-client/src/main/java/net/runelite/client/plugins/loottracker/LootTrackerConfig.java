package net.runelite.client.plugins.loottracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("loottracker")
public interface LootTrackerConfig extends Config
{
    @ConfigItem(
            position = 1,
            keyName = "lootPrice",
            name = "Discord message price cut-off:",
            description = "Decides what price of drops to send to discord."
    )
    default int lootPrice()
    {
        return 25000;
    }
}