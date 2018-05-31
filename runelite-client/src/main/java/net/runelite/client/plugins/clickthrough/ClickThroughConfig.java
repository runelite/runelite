package net.runelite.client.plugins.clickthrough;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
        keyName = "clickthrough",
        name = "Click-through",
        description = "Click through objects/NPCs instead of the default left click option"
)
public interface ClickThroughConfig extends Config
{

    @ConfigItem(
            position = 1,
            keyName = "clickthrough",
            name = "Click-through",
            description = "Click-through listed objects/NPCs"
    )
    default boolean swapAttack()
    {
        return true;
    }

    @ConfigItem(
            keyName = "clickthroughList",
            name = "Clickthrough NPCs",
            description = "List objects/NPCs to click-through (separated by commas)",
            position = 12
    )
    default String clickthroughList()
    {
        return "";
    }
}
