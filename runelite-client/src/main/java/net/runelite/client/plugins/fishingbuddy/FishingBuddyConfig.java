package net.runelite.client.plugins.fishingbuddy;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("fishingbuddy")
public interface FishingBuddyConfig extends Config
{
    @ConfigItem(
            position = 0,
            keyName = "enabled",
            name = "Enable FishingBuddy",
            description = "Automatically switch minnow fishing spots"
    )
    default boolean enabled()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "spotSwitchLimit",
            name = "Spot switch limit",
            description = "Number of spot switches before stopping"
    )
    default int spotSwitchLimit()
    {
        return 15;
    }

    @Range(min = 0, max = 600)
    @ConfigItem(
            position = 2,
            keyName = "reactionDelayMin",
            name = "Min reaction delay (ms)",
            description = "Minimum delay before clicking new fishing spot"
    )
    default int reactionDelayMin()
    {
        return 100;
    }

    @Range(min = 0, max = 600)
    @ConfigItem(
            position = 3,
            keyName = "reactionDelayMax",
            name = "Max reaction delay (ms)",
            description = "Maximum delay before clicking new fishing spot"
    )
    default int reactionDelayMax()
    {
        return 300;
    }

    @ConfigItem(
            position = 4,
            keyName = "showOverlay",
            name = "Show overlay",
            description = "Show fishing status overlay on screen"
    )
    default boolean showOverlay()
    {
        return true;
    }
}