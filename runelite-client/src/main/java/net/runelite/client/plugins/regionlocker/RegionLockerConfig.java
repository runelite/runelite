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
            keyName = "unlockableRegions",
            name = "Unlockable regions",
            description = "List of unlockable regions seperated by a ',' symbol",
            position = 2
    )
    default String unlockableRegions() {
        return "";
    }

    @ConfigItem(
            keyName = "blacklistedRegions",
            name = "Blacklisted regions",
            description = "List of blacklisted regions seperated by a ',' symbol",
            position = 3
    )
    default String blacklistedRegions() {
        return "";
    }

    @ConfigItem(
            keyName = "unlockUnderground",
            name = "Unlock underground",
            description = "Unlock all underground areas",
            position = 4
    )
    default boolean unlockUnderground() {
        return true;
    }

    @ConfigItem(
            keyName = "unlockRealms",
            name = "Unlock realms",
            description = "Unlock all realms like Zanaris and the TzHaar area",
            position = 5
    )
    default boolean unlockRealms() {
        return true;
    }

    @ConfigItem(
            keyName = "drawMapOverlay",
            name = "Draw regions on map",
            description = "Draw a color overlay for each locked/unlocked region",
            position = 6
    )
    default boolean drawMapOverlay() {
        return true;
    }

    @ConfigItem(
            keyName = "invertMapOverlay",
            name = "Invert map overlay",
            description = "Switches which regions the map will draw the color overlay for (true = locked, false = unlocked)",
            position = 7
    )
    default boolean invertMapOverlay() {
        return true;
    }

    @ConfigItem(
            keyName = "mapOverlayColor",
            name = "Map overlay color",
            description = "The color the map overlay will draw the regions in",
            position = 8
    )
    default Color mapOverlayColor() {
        return new Color(200, 16, 0, 100);
    }

    @ConfigItem(
            keyName = "mapOverlayAlpha",
            name = "Map overlay alpha",
            description = "How transparent the map overlay will be (0-255)",
            position = 9
    )
    default int mapOverlayAlpha() {
        return 100;
    }

    @ConfigItem(
            keyName = "unlockableOverlayColor",
            name = "Unlockable overlay color",
            description = "The color the map overlay will draw the unlockable regions in",
            position = 10
    )
    default Color unlockableOverlayColor() {
        return new Color(60, 200, 160, 100);
    }

    @ConfigItem(
            keyName = "unlockableOverlayAlpha",
            name = "Map overlay alpha",
            description = "How transparent the map overlay for unlockable regions will be (0-255)",
            position = 11
    )
    default int unlockableOverlayAlpha() {
        return 100;
    }

    @ConfigItem(
            keyName = "blacklistedOverlayColor",
            name = "Blacklisted overlay color",
            description = "The color the map overlay will draw the blacklisted regions in",
            position = 12
    )
    default Color blacklistedOverlayColor() {
        return new Color(0, 0, 0, 200);
    }

    @ConfigItem(
            keyName = "blacklistedOverlayAlpha",
            name = "Blacklisted overlay alpha",
            description = "How transparent the map overlay for blacklisted regions will be (0-255)",
            position = 13
    )
    default int blacklistedOverlayAlpha() {
        return 200;
    }

    @ConfigItem(
            keyName = "drawMapGrid",
            name = "Draw map grid",
            description = "Draw the grid of regions on the map",
            position = 14
    )
    default boolean drawMapGrid() {
        return true;
    }

    @ConfigItem(
            keyName = "drawRegionId",
            name = "Draw region IDs",
            description = "Draw the region ID for each region on the map",
            position = 15
    )
    default boolean drawRegionId() {
        return true;
    }
}
