package net.runelite.client.plugins.vorkath;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("vorkath")
public interface VorkathConfig extends Config
{
    @ConfigItem(
            name = "Mirror Mode Compatibility?",
            keyName = "mirrorMode",
            description = "Should we show the overlay on Mirror Mode?",
            position = 0
    )
    default boolean mirrorMode()
    {
        return false;
    }

    @ConfigSection(
            position = 1,
            name = "Acid",
            description = ""
    )
    String acidsection = "Acid";

    @ConfigItem(
            keyName = "indicateAcidPools",
            name = "Acid Pools",
            description = "Indicate the acid pools",
            position = 2,
            section = acidsection
    )
    default boolean indicateAcidPools()
    {
        return false;
    }

    @ConfigItem(
            keyName = "indicateAcidFreePath",
            name = "Acid Free Path",
            description = "Indicate the most efficient acid free path",
            position = 3,
            section = acidsection
    )
    default boolean indicateAcidFreePath()
    {
        return true;
    }

    @ConfigItem(
            keyName = "acidFreePathMinLength",
            name = "Minimum Length Acid Free Path",
            description = "The minimum length of an acid free path",
            position = 4,
            hidden = false,
            section = "acidTitle"
    )
    default int acidFreePathLength()
    {
        return 5;
    }

    @ConfigSection (
            position = 5,
            name = "Woox walk",
            description = ""
    )
    String wooxTitle = "wooxTitle";

    @ConfigItem(
            keyName = "indicateWooxWalkPath",
            name = "WooxWalk Path",
            description = "Indicate the closest WooxWalk path",
            position = 6,
            section = "wooxTitle"
    )
    default boolean indicateWooxWalkPath()
    {
        return true;
    }

    @ConfigItem(
            keyName = "indicateWooxWalkTick",
            name = "WooxWalk Tick",
            description = "Indicate on which tile to click during each game tick",
            position = 7,
            section = wooxTitle
    )
    default boolean indicateWooxWalkTick()
    {
        return true;
    }
}