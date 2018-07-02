package net.runelite.client.plugins.multilines;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup(
        name = "Multi lines",
        keyName = "multilines",
        description = "Configuration for the multi lines plugin"
)
public interface MultiLinesConfig extends Config {

    @ConfigItem(
            keyName = "singleColor",
            name = "Single color",
            description = "Color of single combat side of border")
    default Color singleColor() {
        return Color.GREEN;
    }

    @ConfigItem(
            keyName = "multiColor",
            name = "Multi color",
            description = "Color of multi combat side of border")
    default Color multiColor() {
        return Color.RED;
    }

}
