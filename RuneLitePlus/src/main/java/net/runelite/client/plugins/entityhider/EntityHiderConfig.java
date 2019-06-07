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

@ConfigGroup("entityhider")
public interface EntityHiderConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "hidePlayers",
		name = "Hide Players",
		description = "Configures whether or not players are hidden"
	)
	default boolean hidePlayers()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "hidePlayers2D",
		name = "Hide Players 2D",
		description = "Configures whether or not players 2D elements are hidden"
	)
	default boolean hidePlayers2D()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "hideFriends",
		name = "Hide Friends",
		description = "Configures whether or not friends are hidden"
	)
	default boolean hideFriends()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "hideClanMates",
		name = "Hide Clan Mates",
		description = "Configures whether or not clan mates are hidden"
	)
	default boolean hideClanMates()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "hideLocalPlayer",
		name = "Hide Local Player",
		description = "Configures whether or not the local player is hidden"
	)
	default boolean hideLocalPlayer()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "hideLocalPlayer2D",
		name = "Hide Local Player 2D",
		description = "Configures whether or not the local player's 2D elements are hidden"
	)
	default boolean hideLocalPlayer2D()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "hideNPCs",
		name = "Hide NPCs",
		description = "Configures whether or not NPCs are hidden"
	)
	default boolean hideNPCs()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "hideNPCs2D",
		name = "Hide NPCs 2D",
		description = "Configures whether or not NPCs 2D elements are hidden"
	)
	default boolean hideNPCs2D()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "hideAttackers",
		name = "Hide Attackers",
		description = "Configures whether or not NPCs/players attacking you are hidden"
	)
	default boolean hideAttackers()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "hideProjectiles",
		name = "Hide Projectiles",
		description = "Configures whether or not projectiles are hidden"
	)
	default boolean hideProjectiles()
	{
		return false;
	}
}
