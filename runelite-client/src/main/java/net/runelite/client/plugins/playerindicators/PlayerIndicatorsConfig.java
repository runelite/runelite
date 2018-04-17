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

@ConfigGroup(
	keyName = "playerindicators",
	name = "Player Indicators",
	description = "Configuration for the player indicators plugin"
)
public interface PlayerIndicatorsConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "drawOwnName",
		name = "Draw own name",
		description = "Configures whether or not own name should be drawn"
	)
	default boolean drawOwnName()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "ownNameColor",
		name = "Own name color",
		description = "Color of your own name"
	)
	default Color getOwnNameColor()
	{
		return new Color(0, 184, 212);
	}

	@ConfigItem(
		position = 2,
		keyName = "drawFriendNames",
		name = "Draw friend names",
		description = "Configures whether or not names of player friends should be drawn"
	)
	default boolean drawFriendNames()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "friendNameColor",
		name = "Friend name color",
		description = "Color of friend names"
	)
	default Color getFriendNameColor()
	{
		return new Color(0, 200, 83);
	}

	@ConfigItem(
		position = 4,
		keyName = "drawClanMemberNames",
		name = "Draw clan member names",
		description = "Configures whether or not names of player's clan members should be drawn"
	)
	default boolean drawClanMemberNames()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "clanMemberColor",
		name = "Clan member color",
		description = "Color of clan member names"
	)
	default Color getClanMemberColor()
	{
		return new Color(170, 0, 255);
	}

	@ConfigItem(
		position = 6,
		keyName = "drawTeamMemberNames",
		name = "Draw team member names",
		description = "Configures whether or not names of player's team members should be drawn"
	)
	default boolean drawTeamMemberNames()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "teamMemberColor",
		name = "Team member color",
		description = "Color of team member names"
	)
	default Color getTeamMemberColor()
	{
		return new Color(19, 110, 247);
	}

	@ConfigItem(
		position = 8,
		keyName = "drawNonClanMemberNames",
		name = "Draw non-clan member names",
		description = "Configures whether or not names of non-clan members should be drawn"
	)
	default boolean drawNonClanMemberNames()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "nonClanMemberColor",
		name = "Non-clan member color",
		description = "Color of non-clan member names"
	)
	default Color getNonClanMemberColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 10,
		keyName = "drawPlayerTiles",
		name = "Draw tiles",
		description = "Configures whether or not tiles under players with rendered names should be drawn"
	)
	default boolean drawTiles()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "drawMinimapNames",
		name = "Draw names on minimap",
		description = "Configures whether or not minimap names for players with rendered names should be drawn"
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "colorPlayerMenu",
		name = "Color player menu",
		description = "Color right click menu for players"
	)
	default boolean colorPlayerMenu()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "clanMenuIcons",
		name = "Show clan rank in menu",
		description = "Add clan rank to right click menu for players"
	)
	default boolean clanMenuIcons()
	{
		return true;
	}
}
