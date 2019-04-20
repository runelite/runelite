package net.runelite.client.plugins.tickcounter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("tickcounter")
public interface TickCounterConfig extends Config {
    @ConfigItem(
            keyName = "resetInstance",
            name = "Reset on new instances",
            description = "",
            position = 1
    )
    default boolean instance()
    {
        return true;
    }
    @ConfigItem(
            keyName = "selfColor",
            name = "Your color",
            description = "",
            position = 4
    )
    default Color selfColor()
    {
        return Color.green;
    }
    @ConfigItem(
            keyName = "totalColor",
            name = "Total color",
            description = "",
            position = 6
    )
    default Color totalColor()
    {
        return Color.RED;
    }
    @ConfigItem(
            keyName = "otherColor",
            name = "Other players color",
            description = "",
            position = 5
    )
    default Color otherColor()
    {
        return Color.white;
    }
    @ConfigItem(
            keyName = "bgColor",
            name = "Background color",
            description = "",
            position = 3
    )
    default Color bgColor()
    {
        return new Color(70, 61, 50, 156);
    }
    @ConfigItem(
            keyName = "titleColor",
            name = "Title color",
            description = "",
            position = 2
    )
    default Color titleColor()
    {
        return Color.white;
    }
}
