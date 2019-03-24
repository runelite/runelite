package net.runelite.client.plugins.vanguards;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("vanguards")
public interface VanguardsConfig extends Config {
    @ConfigItem(
            keyName = "showHealth",
            name = "Show Vanguard Health",
            description = "Shows vanguard health percent",
            position = 1
    )
    default boolean showHealth(){return true;}
    @ConfigItem(
            keyName = "showTile",
            name = "Show Vanguard Color",
            description = "Shows vanguard color on floor",
            position = 1
    )
    default boolean showTile(){return true;}
}
