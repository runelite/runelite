package net.runelite.client.plugins.fightcave;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
        keyName = "fightcaves",
        name = "Fight Caves",
        description = "Configuration for the Fight Caves plugin"
)
public interface FightCaveConfig extends Config
{
    @ConfigItem(
            keyName = "showNextWave",
            name = "Show next wave",
            description = "Shows monsters that will be spawning on the wave after your current one."
    )
    default boolean showNextWave()
    {
        return true;
    }
}