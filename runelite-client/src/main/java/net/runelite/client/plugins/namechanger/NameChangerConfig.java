package net.runelite.client.plugins.namechanger;

import net.runelite.api.IconID;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(NameChangerPlugin.CONFIG_GROUP)
public interface NameChangerConfig extends Config
{
    @ConfigItem(
            keyName = "icon",
            name = "icon",
            description = "icon",
            position = 1
    )
    default IconID icon()
    {
        return IconID.PLAYER_MODERATOR;
    }

    @ConfigItem(
            keyName = "nameChange",
            name = "nameChange",
            description = "nameChange",
            position = 2
    )
    default String nameChange()
    {
        return "";
    }
}