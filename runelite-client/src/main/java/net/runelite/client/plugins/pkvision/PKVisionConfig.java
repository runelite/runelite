package net.runelite.client.plugins.pkvision;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("pkvision")
public interface PKVisionConfig extends Config
{
    @ConfigItem(position = 0, keyName = "drawOwnName", name = "Highlight own player", description = "Configures whether or not your own player should be highlighted")
    default boolean highlightOwnPlayer()
    {
        return false;
    }

    @ConfigItem(position = 1, keyName = "ownNameColor", name = "Own player color", description = "Color of your own player")
    default Color getOwnPlayerColor()
    {
        return new Color(0, 184, 212);
    }

    @ConfigItem(position = 2, keyName = "drawFriendNames", name = "Highlight friends", description = "Configures whether or not friends should be highlighted")
    default boolean highlightFriends()
    {
        return true;
    }

    @ConfigItem(position = 3, keyName = "friendNameColor", name = "Friend color", description = "Color of friend names" )
    default Color getFriendColor()
    {
        return new Color(0, 200, 80);
    }

    @ConfigItem(position = 4, keyName = "drawPlayerTiles", name = "Draw tiles under players", description = "Configures whether or not tiles under highlighted players should be drawn")
    default boolean drawTiles()
    {
        return false;
    }

    @ConfigItem(position = 5, keyName = "drawPlayerNames", name = "Draw names above players", description = "Configures whether or not player names should be drawn above players")
    default boolean drawPlayerNames() { return true; }

    @ConfigItem(position = 6, keyName = "drawPlayerLevels", name = "Draw levels above players", description = "Configures whether or not player levels should be drawn above players")
    default boolean drawPlayerLevels()
    {
        return true;
    }

    //@ConfigItem(position = 7, keyName = "drawPlayerHealth", name = "Draw health above players", description = "Configures whether or not player levels should be drawn above players")
    //default boolean drawPlayerHealth()
    //{
    //    return true;
    //}
}
