package net.runelite.client.plugins.boosts;

import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
    keyName = "boosts",
    name = "Boost Info",
    description = "Configuration for the Boosts plugin"
)
public interface BoostsConfig
{
    @ConfigItem(
        keyName = "enabled",
        name = "Enabled",
        description = "Configures whether or not boost info is displayed"
    )
    default boolean enabled()
    {
        return true;
    }
}
