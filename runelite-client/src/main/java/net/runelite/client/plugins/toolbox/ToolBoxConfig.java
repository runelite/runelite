package net.runelite.client.plugins.toolbox;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("toolbox")
public interface ToolBoxConfig extends Config{
    @ConfigSection(
            name = "General",
            description = "General",
            position = 0
    )
    String generalSection = "general";
}
