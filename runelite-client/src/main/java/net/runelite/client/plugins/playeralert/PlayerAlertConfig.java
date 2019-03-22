package net.runelite.client.plugins.playeralert;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("skullalert")
public interface PlayerAlertConfig extends Config
{
    @ConfigItem(
            position = 1,
            keyName = "alertFriends",
            name = "Alert Friends",
            description = "Configures whether or not friends trigger an alert"
    )
    default boolean alertFriends()
    {
        return false;
    }

    @ConfigItem(
            position = 2,
            keyName = "alertClan",
            name = "Alert Clan",
            description = "Configures whether or not clan members trigger an alert"
    )
    default boolean alertClan()
    {
        return false;
    }


    @ConfigItem(
            position = 3,
            keyName = "doBeep",
            name = "Beep on person",
            description = "Do a beep or not"
    )
    default boolean doBeep()
    {
        return false;
    }

    @ConfigItem(
            position = 4,
            keyName = "doArrow",
            name = "Draw arrow",
            description = "Draws an arrow on new people"
    )
    default boolean doArrow()
    {
        return false;
    }
}
