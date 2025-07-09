package net.runelite.client.plugins.mobslocator;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import java.awt.Color;

@ConfigGroup("mobslocator")
public interface MobsLocatorConfig extends Config
{
    @ConfigSection(
        name = "Search",
        description = "Mob search settings",
        position = 0
    )
    String searchSection = "search";

    @ConfigSection(
        name = "Display",
        description = "Display settings",
        position = 1
    )
    String displaySection = "display";

    @ConfigSection(
        name = "Filtering",
        description = "Mob filtering settings",
        position = 2
    )
    String filteringSection = "filtering";

    @ConfigItem(
        keyName = "searchedMob",
        name = "Search for Mob",
        description = "Enter the name of the mob you want to locate",
        section = searchSection
    )
    default String searchedMob()
    {
        return "";
    }

    @ConfigItem(
        keyName = "showSearchResults",
        name = "Show Search Results",
        description = "Display search results in overlay",
        section = searchSection
    )
    default boolean showSearchResults()
    {
        return true;
    }

    @ConfigItem(
        keyName = "showMinimapDots",
        name = "Show Minimap Dots",
        description = "Show mob locations on minimap",
        section = displaySection
    )
    default boolean showMinimapDots()
    {
        return true;
    }

    @ConfigItem(
        keyName = "minimapDotColor",
        name = "Minimap Dot Color",
        description = "Color of minimap location dots",
        section = displaySection
    )
    default Color minimapDotColor()
    {
        return Color.RED;
    }

    @ConfigItem(
        keyName = "showAllMobs",
        name = "Show All Mobs",
        description = "Show all combat NPCs",
        section = filteringSection
    )
    default boolean showAllMobs()
    {
        return false;
    }

    @ConfigItem(
        keyName = "showHighLevel",
        name = "Show High Level Only",
        description = "Only show mobs above minimum combat level",
        section = filteringSection
    )
    default boolean showHighLevel()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minCombatLevel",
        name = "Minimum Combat Level",
        description = "Minimum combat level to display",
        section = filteringSection
    )
    default int minCombatLevel()
    {
        return 50;
    }

    @ConfigItem(
        keyName = "showDistance",
        name = "Show Distance",
        description = "Show distance to mobs",
        section = displaySection
    )
    default boolean showDistance()
    {
        return true;
    }

    @ConfigItem(
        keyName = "showCombatLevel",
        name = "Show Combat Level",
        description = "Show mob combat levels",
        section = displaySection
    )
    default boolean showCombatLevel()
    {
        return true;
    }

    @ConfigItem(
        keyName = "textColor",
        name = "Text Color",
        description = "Color of the overlay text",
        section = displaySection
    )
    default Color textColor()
    {
        return Color.WHITE;
    }

    @ConfigItem(
        keyName = "backgroundColor",
        name = "Background Color",
        description = "Background color of the overlay",
        section = displaySection
    )
    default Color backgroundColor()
    {
        return new Color(0, 0, 0, 100);
    }
}