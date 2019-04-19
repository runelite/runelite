package net.runelite.client.plugins.easy.pvp;


import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("easypvp")
public interface EasyPvpConfig extends Config {

    @ConfigItem(
            keyName = "showWildernessRange",
            name = "Show Wilderness Range",
            description = "",
            position = 0
    )

    default boolean getShowWildernessRange() {
        return true;
    }

    @ConfigItem(
            keyName = "ShowAttackablePlayers",
            name = "Show Attackable Players",
            description = "",
            position = 1
    )

    default boolean getShowAttackablePlayers() {
        return true;
    }

    @ConfigItem(
            keyName = "warnProtectItemOff",
            name = "Warn Protect Item Off",
            description = "",
            position = 2
    )

    default boolean getWarnProtectItemOff() {
        return true;
    }

    @ConfigItem(
            keyName = "showFreezeTimers",
            name = "Show Freeze Timers",
            description = "",
            position = 3
    )

    default boolean getShowFreezeTimers() {
        return true;
    }


}
