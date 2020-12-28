package net.runelite.client.plugins.sorceressgarden;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("SorceressGarden")

public interface SorceressGardenConfig extends Config
{
    @ConfigItem(
            keyName = "showGardenStats",
            name = "Show Garden Stats",
            description = "Shows the player's garden stats",
            position = 0
    )
    default boolean showGardenStats()
    {
        return true;
    }

    @ConfigItem(
            keyName = "showSqirksStats",
            name = "Show Sqi'rks Stats",
            description = "Show the amount of sqi'rks the player has collected",
            position = 1
    )
    default boolean showSqirksStats()
    {
        return true;
    }

    @ConfigItem(
            keyName = "showSafeTiles",
            name = "Show Safe Tiles",
            description = "Show the safe tiles within each garden",
            position = 2
    )
    default boolean showSafeTiles()
    {
        return false;
    }

    @ConfigItem(
            keyName = "highlightElementals",
            name = "Highlight Elementals",
            description = "Highlights the garden elementals",
            position = 3
    )
    default boolean highlightElementals()
    {
        return true;
    }

    @ConfigItem(
            keyName = "showOneClickSync",
            name = "Show One-Click Syncing",
            description = "Show one-clicking indicators for the gardens",
            position = 4
    )
    default boolean showOneClickSync()
    {
        return true;
    }

    @ConfigItem(
            keyName = "showWinterOneClick",
            name = "Show Winter One-Click",
            description = "Show the elemental sync for Winter Garden one-clicking",
            hidden = false,
            position = 5
    )
    default boolean showWinterOneClick()
    {
        return false;
    }

    @ConfigItem(
            keyName = "showSummerOneClick",
            name = "Show Summer One-Click",
            description = "Show the elemental sync for Summer Garden one-clicking",
            hidden = false,
            position = 6
    )
    default boolean showSummerOneClick()
    {
        return false;
    }

    @ConfigItem(
            name = "Enable mirror mode",
            description = "Toggle mirror mode compatibility.",
            position = 7,
            keyName = "mirrorMode"
    )
    default boolean mirrorMode()
    {
        return false;
    }
}