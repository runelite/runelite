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
import net.runelite.client.config.ConfigSection;

@ConfigGroup(EntityHiderConfig.GROUP)
public interface EntityHiderConfig extends Config
{
	String GROUP = "entityhider";

	@ConfigSection(
		name = "3D",
		position = 1,
		description = "Options to hide rendering of 3D scene elements (player models, NPC models)."
	)
	String draw3D = "draw3D";

	@ConfigSection(
		name = "2D",
		position = 2,
		description = "Options to hide rendering of 2D elements (overhead text, prayers, etc.)."
	)
	String draw2D = "draw2D";

	@ConfigItem(
		position = 1,
		keyName = "hidePlayers",
		name = "Hide others",
		description = "Configures whether or not other players are hidden.",
		section = draw3D
	)
	default boolean hideOthers()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "hidePlayers2D",
		name = "Hide others 2D",
		description = "Configures whether or not other players 2D elements are hidden.",
		section = draw2D
	)
	default boolean hideOthers2D()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "hidePartyMembers",
		name = "Hide party members",
		description = "Configures whether or not party members are hidden.",
		section = draw3D
	)
	default boolean hidePartyMembers()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "hidePartyMembers2D",
		name = "Hide party members 2D",
		description = "Configures whether or not party members' 2D elements are hidden.",
		section = draw2D
	)
	default boolean hidePartyMembers2D()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "hideFriends",
		name = "Hide friends",
		description = "Configures whether or not friends are hidden.",
		section = draw3D
	)
	default boolean hideFriends()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "hideFriends2D",
		name = "Hide friends 2D",
		description = "Configures whether or not friends' 2D elements are hidden.",
		section = draw2D
	)
	default boolean hideFriends2D()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "hideClanMates", // is actually friends chat
		name = "Hide friends chat members",
		description = "Configures whether or not friends chat members are hidden.",
		section = draw3D
	)
	default boolean hideFriendsChatMembers()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "hideClanMates2D", // is actually friends chat
		name = "Hide friends chat members 2D",
		description = "Configures whether or not friends chat members' 2D elements are hidden.",
		section = draw2D
	)
	default boolean hideFriendsChatMembers2D()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "hideClanChatMembers",
		name = "Hide clan chat members",
		description = "Configures whether or not clan chat members are hidden.",
		section = draw3D
	)
	default boolean hideClanChatMembers()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "hideClanChatMembers2D",
		name = "Hide clan chat members 2D",
		description = "Configures whether or not clan chat members' 2D elements are hidden.",
		section = draw2D
	)
	default boolean hideClanChatMembers2D()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "hideIgnores",
		name = "Hide ignores",
		description = "Configures whether or not ignored players are hidden.",
		section = draw3D
	)
	default boolean hideIgnores()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "hideIgnores2D",
		name = "Hide ignores 2D",
		description = "Configures whether or not ignored players' 2D elements are hidden.",
		section = draw2D
	)
	default boolean hideIgnores2D()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "hideLocalPlayer",
		name = "Hide local player",
		description = "Configures whether or not the local player is hidden.",
		section = draw3D
	)
	default boolean hideLocalPlayer()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "hideLocalPlayer2D",
		name = "Hide local player 2D",
		description = "Configures whether or not the local player's 2D elements are hidden.",
		section = draw2D
	)
	default boolean hideLocalPlayer2D()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "hideNPCs",
		name = "Hide NPCs",
		description = "Configures whether or not NPCs are hidden.",
		section = draw3D
	)
	default boolean hideNPCs()
	{
		return false;
	}

	@ConfigItem(
		position = 16,
		keyName = "hideNPCs2D",
		name = "Hide NPCs 2D",
		description = "Configures whether or not NPCs 2D elements are hidden.",
		section = draw2D
	)
	default boolean hideNPCs2D()
	{
		return false;
	}

	@ConfigItem(
		position = 17,
		keyName = "hidePets",
		name = "Hide other players' pets",
		description = "Configures whether or not other player pets are hidden.",
		section = draw3D
	)
	default boolean hidePets()
	{
		return false;
	}

	@ConfigItem(
		position = 18,
		keyName = "hideAttackers",
		name = "Hide attackers",
		description = "Configures whether or not NPCs/players attacking you are hidden.",
		section = draw3D
	)
	default boolean hideAttackers()
	{
		return false;
	}

	@ConfigItem(
		position = 19,
		keyName = "hideAttackers2D",
		name = "Hide attackers 2D",
		description = "Configures whether or not 2D elements of NPCs/players attacking you are hidden.",
		section = draw2D
	)
	default boolean hideAttackers2D()
	{
		return false;
	}

	@ConfigItem(
		position = 20,
		keyName = "hideProjectiles",
		name = "Hide projectiles",
		description = "Configures whether or not projectiles are hidden.",
		section = draw3D
	)
	default boolean hideProjectiles()
	{
		return false;
	}

	@ConfigItem(
		position = 21,
		keyName = "hideDeadNpcs",
		name = "Hide dead NPCs",
		description = "Hides NPCs when their health reaches 0.",
		section = draw3D
	)
	default boolean hideDeadNpcs()
	{
		return false;
	}

	@ConfigItem(
		position = 22,
		keyName = "hideThralls",
		name = "Hide thralls",
		description = "Configures whether or not thralls are hidden.",
		section = draw3D
	)
	default boolean hideThralls()
	{
		return false;
	}

	@ConfigItem(
		position = 23,
		keyName = "hideRandomEvents",
		name = "Hide random events",
		description = "Configures whether or not random events are hidden.",
		section = draw3D
	)
	default boolean hideRandomEvents()
	{
		return false;
	}
}
