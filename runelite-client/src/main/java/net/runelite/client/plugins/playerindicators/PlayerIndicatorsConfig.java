/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.playerindicators;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(PlayerIndicatorsConfig.GROUP)
public interface PlayerIndicatorsConfig extends Config
{
	String GROUP = "playerindicators";

	@ConfigSection(
		name = "Highlight options",
		description = "Toggle highlighted players by type (self, friends, etc.) and choose their highlight colors.",
		position = 99
	)
	String highlightSection = "section";

	enum HighlightSetting
	{
		DISABLED,
		ENABLED,
		PVP;
	}

	@ConfigItem(
		position = 0,
		keyName = "highlightSelf",
		name = "Highlight own player",
		description = "Configures whether your own player should be highlighted.",
		section = highlightSection
	)
	default HighlightSetting highlightOwnPlayer()
	{
		return HighlightSetting.DISABLED;
	}

	@ConfigItem(
		position = 1,
		keyName = "ownNameColor",
		name = "Own player",
		description = "Color of your own player.",
		section = highlightSection
	)
	default Color getOwnPlayerColor()
	{
		return new Color(0, 184, 212);
	}

	@ConfigItem(
		position = 2,
		keyName = "highlightPartyMembers",
		name = "Highlight party members",
		description = "Configures whether party members should be highlighted.",
		section = highlightSection
	)
	default HighlightSetting highlightPartyMembers()
	{
		return HighlightSetting.ENABLED;
	}

	@ConfigItem(
		position = 3,
		keyName = "partyMemberNameColor",
		name = "Party member",
		description = "Color of party member names.",
		section = highlightSection
	)
	default Color getPartyMemberColor()
	{
		return new Color(234, 123, 91);
	}

	@ConfigItem(
		position = 4,
		keyName = "highlightFriends",
		name = "Highlight friends",
		description = "Configures whether friends should be highlighted.",
		section = highlightSection
	)
	default HighlightSetting highlightFriends()
	{
		return HighlightSetting.ENABLED;
	}

	@ConfigItem(
		position = 5,
		keyName = "friendNameColor",
		name = "Friend",
		description = "Color of friend names.",
		section = highlightSection
	)
	default Color getFriendColor()
	{
		return new Color(0, 200, 83);
	}

	@ConfigItem(
		position = 6,
		keyName = "highlightFriendsChat",
		name = "Highlight friends chat members",
		description = "Configures whether friends chat members should be highlighted.",
		section = highlightSection
	)
	default HighlightSetting highlightFriendsChat()
	{
		return HighlightSetting.ENABLED;
	}

	@ConfigItem(
		position = 7,
		keyName = "clanMemberColor",
		name = "Friends chat",
		description = "Color of friends chat members.",
		section = highlightSection
	)
	default Color getFriendsChatMemberColor()
	{
		return new Color(170, 0, 255);
	}

	@ConfigItem(
		position = 8,
		keyName = "highlightTeamMembers",
		name = "Highlight team members",
		description = "Configures whether team members should be highlighted.",
		section = highlightSection
	)
	default HighlightSetting highlightTeamMembers()
	{
		return HighlightSetting.ENABLED;
	}

	@ConfigItem(
		position = 9,
		keyName = "teamMemberColor",
		name = "Team member",
		description = "Color of team members.",
		section = highlightSection
	)
	default Color getTeamMemberColor()
	{
		return new Color(19, 110, 247);
	}

	@ConfigItem(
		position = 10,
		keyName = "highlightClanMembers",
		name = "Highlight clan members",
		description = "Configures whether clan members should be highlighted.",
		section = highlightSection
	)
	default HighlightSetting highlightClanMembers()
	{
		return HighlightSetting.ENABLED;
	}

	@ConfigItem(
		position = 11,
		keyName = "clanChatMemberColor",
		name = "Clan member",
		description = "Color of clan members.",
		section = highlightSection
	)
	default Color getClanMemberColor()
	{
		return new Color(36, 15, 171);
	}

	@ConfigItem(
		position = 12,
		keyName = "highlightOthers",
		name = "Highlight others",
		description = "Configures whether other players should be highlighted.",
		section = highlightSection
	)
	default HighlightSetting highlightOthers()
	{
		return HighlightSetting.DISABLED;
	}

	@ConfigItem(
		position = 13,
		keyName = "nonClanMemberColor",
		name = "Others",
		description = "Color of other players names.",
		section = highlightSection
	)
	default Color getOthersColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 10,
		keyName = "drawPlayerTiles",
		name = "Draw tiles under players",
		description = "Configures whether or not tiles under highlighted players should be drawn."
	)
	default boolean drawTiles()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "playerNamePosition",
		name = "Name position",
		description = "Configures the position of drawn player names, or if they should be disabled."
	)
	default PlayerNameLocation playerNamePosition()
	{
		return PlayerNameLocation.ABOVE_HEAD;
	}

	@ConfigItem(
		position = 12,
		keyName = "drawMinimapNames",
		name = "Draw names on minimap",
		description = "Configures whether or not minimap names for players with rendered names should be drawn."
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "colorPlayerMenu",
		name = "Colorize player menu",
		description = "Color right-click menu for players."
	)
	default boolean colorPlayerMenu()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "clanMenuIcons",
		name = "Show friends chat ranks",
		description = "Add friends chat rank to right-click menu and next to player names."
	)
	default boolean showFriendsChatRanks()
	{
		return true;
	}

	@ConfigItem(
		position = 15,
		keyName = "clanchatMenuIcons",
		name = "Show clan chat ranks",
		description = "Add clan chat rank to right-click menu and next to player names."
	)
	default boolean showClanChatRanks()
	{
		return true;
	}
}
