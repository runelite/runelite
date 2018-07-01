package net.runelite.client.plugins.multilines;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;

@ConfigGroup(
        name = "Multi lines",
        keyName = "multilines",
        description = "Configuration for the multi lines plugin"
)
public interface MultiLinesConfig extends Config {
}
