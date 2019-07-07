package net.runelite.client.plugins.barrowsprayer;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("barrowsprayer")
public interface BarrowsPrayerConfig extends Config
{
    @Alpha
    @ConfigItem(
            keyName = "highlightTileColor",
            name = "Color of tile highlighting",
            description = "Configures the highlight color of the tile"
    )
    default Color highlightTileColor()
    {
        return Color.GRAY;
    }

}
