/*
 * Copyright (c) 2018, Mathieu Bernier <https://github.com/Matsyir>
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
package net.runelite.client.plugins.team;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(TeamConfig.GROUP)
public interface TeamConfig extends Config
{
	String GROUP = "teamCapes";

	@ConfigSection(
		name = "Team",
		description = "Configuration for teams.",
		position = 10
	)
	String teamSection = "teamSection";

	@ConfigSection(
		name = "Friends chat",
		description = "Configuration for friends chat.",
		position = 20
	)
	String friendsChatSection = "friendsChatSection";

	@ConfigSection(
		name = "Clan chat",
		description = "Configuration for clan chat.",
		position = 30
	)
	String clanChatSection = "clanChatSection";

	@ConfigItem(
		keyName = "teamCapesOverlay",
		name = "Team cape overlay",
		description = "Configures whether to show the team cape overlay.",
		position = 0,
		section = teamSection
	)
	default boolean teamCapesOverlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "minimumCapeCount",
		name = "Minimum cape count",
		description = "Configures the minimum number of team capes which must be present before being displayed.",
		position = 1,
		section = teamSection
	)
	default int getMinimumCapeCount()
	{
		return 1;
	}

	@ConfigItem(
		keyName = "friendsChatMemberCounter",
		name = "Friends chat members counter",
		description = "Show the amount of friends chat members near you.",
		position = 0,
		section = friendsChatSection
	)
	default boolean friendsChatMemberCounter()
	{
		return false;
	}

	@ConfigItem(
		keyName = "clanChatMemberCounter",
		name = "Clan chat members counter",
		description = "Show the amount of clan chat members near you.",
		position = 0,
		section = clanChatSection
	)
	default boolean clanChatMemberCounter()
	{
		return false;
	}
}