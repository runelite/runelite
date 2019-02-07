package net.runelite.client.plugins.templetrek;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("templetrek")
public interface TempleTrekConfig extends Config
{
    @ConfigItem(
            keyName = "bogMapActive",
            name = "Bog Map",
            description = "Marks out a safe route through the bog event",
            position = 0
    )
    default boolean bogMapActive()
    {
        return true;
    }
}
