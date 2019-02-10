package net.runelite.client.plugins.regionlocker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup(RegionLockerPlugin.CONFIG_KEY)
public interface RegionLockerConfig extends Config {
    @ConfigItem(
            keyName = "renderLockedRegions",
            name = "Render locked regions",
            description = "Adds graphical change to all regions that are not in the unlocked region list",
            position = 0
    )
    default boolean renderLockedRegions() {
        return true;
    }

    @ConfigItem(
            keyName = "unlockedRegions",
            name = "Unlocked regions",
            description = "List of unlocked regions seperated by a ',' symbol",
            position = 1
    )
    default String unlockedRegions() {
        return "";
    }

    @ConfigItem(
            keyName = "drawMapOverlay",
            name = "Draw regions on map",
            description = "Draw a color overlay for each locked/unlocked region",
            position = 2
    )
    default boolean drawMapOverlay() {
        return true;
    }

    @ConfigItem(
            keyName = "invertMapOverlay",
            name = "Invert map overlay",
            description = "Switches which regions the map will draw the color overlay for (true = locked, false = unlocked)",
            position = 3
    )
    default boolean invertMapOverlay() {
        return true;
    }

    @ConfigItem(
            keyName = "mapOverlayColor",
            name = "Map overlay color",
            description = "The color the map overlay will draw the regions in",
            position = 4
    )
    default Color mapOverlayColor() {
        return new Color(200, 16, 0, 80);
    }

    @ConfigItem(
            keyName = "mapOverlayAlpha",
            name = "Map overlay alpha",
            description = "How transparent the map overlay will be (0-255)",
            position = 5
    )
    default int mapOverlayAlpha() {
        return 80;
    }

    @ConfigItem(
            keyName = "drawMapGrid",
            name = "Draw map grid",
            description = "Draw the grid of regions on the map",
            position = 6
    )
    default boolean drawMapGrid() {
        return true;
    }

    @ConfigItem(
            keyName = "drawRegionId",
            name = "Draw region IDs",
            description = "Draw the region ID for each region on the map",
            position = 6
    )
    default boolean drawRegionId() {
        return true;
    }
}
