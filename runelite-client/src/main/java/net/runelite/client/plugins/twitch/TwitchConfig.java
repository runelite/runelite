package net.runelite.client.plugins.twitch;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
        keyName = "twitch",
        name = "Twitch",
        description = "Used to see Twitch chat in game"
)

public interface TwitchConfig extends Config {
    @ConfigItem( //Stream chat user wants to see goes here
            keyName = "channel",
            name = "Channel",
            description = "Enter the channel you wish to view the chat of",
            position = 0
    )
    default String nickName ()
    {
        return "";
    }

    @ConfigItem( //User's OAuth Token goes here
            keyName = "oauth",
            name = "OAuth Token",
            description = "Enter your OAuth token here. This can be found at http://www.twitchapps.com/tmi/",
            position = 1
    )
    default String oauthToken()
    {
        return "";
    }

    @ConfigItem( //User's twitch username goes here
            keyName = "nick",
            name = "Twitch Username",
            description = "Your twitch username",
            position = 2
    )
    default String channelName()
    {
        return "";
    }

    @ConfigItem( //Stream transparent chat color
            keyName = "chattcolor",
            name = "Transparent chat color",
            description = "The color of chat in game",
            position = 3
    )
    default Color chatTColor()
    {
        return Color.decode("#350059");
    }

    @ConfigItem( //Stream opaque chat color
            keyName = "chatocolor",
            name = "Opaque chat color",
            description = "The color of chat in game",
            position = 4
    )
    default Color chatOColor()
    {
        return Color.decode("#350059");
    }

    @ConfigItem( //Subscriber notifications
            keyName = "subnotifications",
            name = "Sub notifications",
            description = "Toggles sub notifications",
            position = 5
    )
    default boolean subNotifs()
    {
        return true;
    }

    @ConfigItem( //Subscriber opaque notification color
            keyName = "subocolor",
            name = "Subscriber notification opaque color",
            description = "Color of the sub notifications in chat when using opaque chat",
            position = 6
    )
    default Color subsOColor()
    {
        return Color.decode("#000000");
    }

    @ConfigItem( //Subscriber transparent notification color
            keyName = "subtcolor",
            name = "Subscriber notification transparent color",
            description = "Color of the sub notifications in chat when using transparent chat",
            position = 7
    )
    default Color subsTColor()
    {
        return Color.decode("#FFFFFF");
    }
}
