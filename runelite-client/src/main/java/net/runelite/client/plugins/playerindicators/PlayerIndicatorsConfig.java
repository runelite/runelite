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

@ConfigGroup("It's coming home")
public interface PlayerIndicatorsConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean highlightOwnPlayer()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getOwnPlayerColor()
	{
		return new Color(0, 184, 212);
	}

	@ConfigItem(
		position = 2,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean highlightFriends()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getFriendColor()
	{
		return new Color(0, 200, 83);
	}

	@ConfigItem(
		position = 4,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean drawClanMemberNames()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getClanMemberColor()
	{
		return new Color(170, 0, 255);
	}

	@ConfigItem(
		position = 6,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean highlightTeamMembers()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getTeamMemberColor()
	{
		return new Color(19, 110, 247);
	}

	@ConfigItem(
		position = 8,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean highlightNonClanMembers()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getNonClanMemberColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 10,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean drawTiles()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean drawOverheadPlayerNames()
	{
		return true;
	}

	@ConfigItem(
		position = 12,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean colorPlayerMenu()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showClanRanks()
	{
		return true;
	}
}
