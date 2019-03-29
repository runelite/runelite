package net.runelite.client.plugins.blackjack;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("blackjack")
public interface BlackjackConfig extends Config
{
    @ConfigItem(
            keyName = "menuSwapActive",
            name = "Dynamic Menu Swap",
            description = "Configures whether or not blackjack targets have their menu entries dynamically swapped",
            position = 0
    )
    default boolean menuSwapActive()
    {
        return true;
    }
}