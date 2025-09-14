package net.runelite.client.plugins.playerhighlight;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("playerhighlight")
public interface PlayerHighlightConfig extends Config {
    @ConfigItem(
            keyName = "playerHighlightColor",
            name = "Player Highlight Color",
            description = "Color to highlight players with."
    )
    default Color playerHighLightColor()
    {
        return Color.RED;
    }
}
