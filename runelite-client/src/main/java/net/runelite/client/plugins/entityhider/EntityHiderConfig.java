/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.entityhider;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("entityhider")
public interface EntityHiderConfig extends Config
{
	@ConfigTitleSection(
		keyName = "playersTitle",
		name = "Other players",
		description = "",
		position = 1
	)
	default Title playersTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 2,
		keyName = "hidePlayers",
		name = "Hide Players",
		description = "Configures whether or not players are hidden",
		titleSection = "playersTitle"
	)
	default boolean hidePlayers()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "hidePlayers2D",
		name = "Hide Players 2D",
		description = "Configures whether or not players 2D elements are hidden",
		titleSection = "playersTitle"
	)
	default boolean hidePlayers2D()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "hideSpecificPlayers",
		name = "Hide Specific Players",
		description = "Hides players you never wish to see.",
		titleSection = "playersTitle"
	)
	default String hideSpecificPlayers()
	{
		return "";
	}

	@ConfigItem(
		position = 5,
		keyName = "hideAttackers",
		name = "Hide Attackers",
		description = "Configures whether or not NPCs/players attacking you are hidden",
		titleSection = "playersTitle"
	)
	default boolean hideAttackers()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "localPlayerTitle",
		name = "Local player",
		description = "",
		position = 6
	)
	default Title localPlayerTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 7,
		keyName = "hideLocalPlayer",
		name = "Hide Local Player",
		description = "Configures whether or not the local player is hidden",
		titleSection = "localPlayerTitle"
	)
	default boolean hideLocalPlayer()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "hideLocalPlayer2D",
		name = "Hide Local Player 2D",
		description = "Configures whether or not the local player's 2D elements are hidden",
		titleSection = "localPlayerTitle"
	)
	default boolean hideLocalPlayer2D()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "friendsTitle",
		name = "Friends / clan",
		description = "",
		position = 9
	)
	default Title friendsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 10,
		keyName = "hideFriends",
		name = "Hide Friends",
		description = "Configures whether or not friends are hidden",
		titleSection = "friendsTitle"
	)
	default boolean hideFriends()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "hideClanMates",
		name = "Hide Clan Mates",
		description = "Configures whether or not clan mates are hidden",
		titleSection = "friendsTitle"
	)
	default boolean hideClanMates()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "npcsTitle",
		name = "NPCs",
		description = "",
		position = 12
	)
	default Title npcsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 13,
		keyName = "hideNPCs",
		name = "Hide NPCs",
		description = "Configures whether or not NPCs are hidden",
		titleSection = "npcsTitle"
	)
	default boolean hideNPCs()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "hideNPCs2D",
		name = "Hide NPCs 2D",
		description = "Configures whether or not NPCs 2D elements are hidden",
		titleSection = "npcsTitle"
	)
	default boolean hideNPCs2D()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "hideNPCsNames",
		name = "Hide NPCs Names",
		description = "Configures which NPCs to hide",
		titleSection = "npcsTitle"
	)
	default String hideNPCsNames()
	{
		return "";
	}

	@ConfigItem(
		position = 16,
		keyName = "hideDeadNPCs",
		name = "Hide Dead NPCs",
		description = "Configures whether or not NPCs that just died are hidden",
		titleSection = "npcsTitle"
	)
	default boolean hideDeadNPCs()
	{
		return false;
	}

	@ConfigItem(
		position = 17,
		keyName = "hideNPCsOnDeath",
		name = "Hide NPCs On Death",
		description = "Configures which NPCs to hide when they die",
		titleSection = "npcsTitle"
	)
	default String hideNPCsOnDeath()
	{
		return "";
	}

	@ConfigTitleSection(
		keyName = "miscTitle",
		name = "Miscellaneous",
		description = "",
		position = 18
	)
	default Title miscTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 19,
		keyName = "hideProjectiles",
		name = "Hide Projectiles",
		description = "Configures whether or not projectiles are hidden",
		titleSection = "miscTitle"
	)
	default boolean hideProjectiles()
	{
		return false;
	}
}
