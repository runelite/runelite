package net.runelite.client.plugins.damagecounter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("damage")
public interface DamageCounterConfig extends Config
{
    @ConfigItem(
            keyName = "leftClickCore",
            name = "Left click walk on core",
            description = "Prioritizes Walk here over Attack on the Dark energy core",
            position = 1
    )
    default boolean leftClickCore()
    {
        return true;
    }

    @ConfigItem(
            keyName = "showDamage",
            name = "Show damage overlay",
            description = "Show total damage overlay",
            position = 2
    )
    default boolean showDamage()
    {
        return true;
    }
}