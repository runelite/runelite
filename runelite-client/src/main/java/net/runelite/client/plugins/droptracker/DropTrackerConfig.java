/*
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
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
package net.runelite.client.plugins.droptracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "dropTracker",
		name = "Drop Tracker",
		description = "Configuration for the drop tracker plugin"
)
public interface DropTrackerConfig extends Config
{
	@ConfigItem(
			keyName = "takeSettingFromGroundItem",
			name = "Take Setting",
			description = "Configures whether or not to take setting from ground item plugin",
			position = 1
	)
	default boolean takeSettingFromGroundItem()
	{
		return true;
	}

	@ConfigItem(
			keyName = "hideDropWith0Loot",
			name = "Hide Drops",
			description = "Configures whether or not to hide drops with no loot",
			position = 2
	)
	default boolean hideDropWith0Loot()
	{
		return true;
	}

	@ConfigItem(
			keyName = "dropTrackerLimit",
			name = "Drop Tracker Limit",
			description = "Configures how many drops the tracker will track before delete them",
			position = 3
	)
	default int dropTrackerLimit()
	{
		return 50;
	}

	@ConfigItem(
			keyName = "fastRemove",
			name = "Fast Remove Drops",
			description = "Configures the ability to remove drop by clicking on while holding shift key",
			position = 4
	)
	default boolean fastRemove()
	{
		return true;
	}
}
