package net.runelite.client.plugins.duplicatechat;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("duplicatechat")
public interface DuplicateChatConfig extends Config {

    @ConfigItem(
            keyName = "defaultColor",
            name = "Default count color",
            description = "Configures the color for the count of game messages",
            position = 0
    )
    default Color getChatCountColor()
    {
        return new Color(0xA00080);
    }

    @ConfigItem(
            keyName = "consolidatePlayerChat",
            name = "Consolidate Player Chat",
            description = "Configures consolidation of player chat",
            position = 1
    )
    default boolean consolidatePlayerChat()
    {
        return false;
    }

    @ConfigItem(
            keyName = "getMaxRepeatedPublicChats",
            name = "Max repeated public chats",
            description = "Blocks messages if repeated this many times. 0 is off",
            position = 2
    )
    default int getMaxRepeatedPublicChats()
    {
        return 5;
    }

    @ConfigItem(
            keyName = "maxTrackedChats",
            name = "Max Tracked Chats",
            description = "Configures the maximum number of chats that are tracked. Suggested 500",
            position = 3
    )
    default int getMaxTrackedChats()
    {
        return 500;
    }

}
