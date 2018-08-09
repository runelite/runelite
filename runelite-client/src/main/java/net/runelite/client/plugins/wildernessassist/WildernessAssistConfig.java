/*
 * Copyright (c) 2018, Connor <contact@connor-parks.email>
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

package net.runelite.client.plugins.wildernessassist;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("wildernessassist")
public interface WildernessAssistConfig extends Config
{
	@ConfigItem(
			keyName = "tileBrightness",
			name = "Tile Brightness",
			description = "How bright the tile under a player should be",
			position = 1
	)
	default TileBrightness getTileBrightness()
	{
		return TileBrightness.NORMAL;
	}

	@ConfigItem(
			keyName = "ignoreFriends",
			name = "Ignore Friends",
			description = "Don't mark friends",
			position = 2
	)
	default boolean shouldIgnoreFriends()
	{
		return false;
	}

	@ConfigItem(
			keyName = "ignoreTeamMembers",
			name = "Ignore Team Members",
			description = "Don't mark people wearing the same team cape",
			position = 3
	)
	default boolean shouldIgnoreTeamMembers()
	{
		return false;
	}

	@ConfigItem(
			keyName = "ignoreClanMembers",
			name = "Ignore Clan Members",
			description = "Don't mark clan members",
			position = 4
	)
	default boolean shouldIgnoreClanMembers()
	{
		return false;
	}

	@ConfigItem(
			keyName = "ignoreSafeZones",
			name = "Ignore Safe Zones",
			description = "In PvP range areas (such as PvP worlds), continue to show overlays in safe zones",
			position = 5
	)
	default boolean shouldIgnoreSafeZones()
	{
		return true;
	}
}
