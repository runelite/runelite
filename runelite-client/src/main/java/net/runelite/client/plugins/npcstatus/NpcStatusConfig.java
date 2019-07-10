/*
 * Copyright (c) 2019, GeChallengeM <https://github.com/GeChallengeM>
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
package net.runelite.client.plugins.npcstatus;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("npcstatus")
public interface NpcStatusConfig extends Config
{
	@Range(
		min = 1
	)
	@ConfigItem(
		keyName = "AttackRange",
		name = "NPC attack range",
		description = "The attack range of the NPC.",
		position = 1
	)
	default int getRange()
	{
		return 1;
	}

	@ConfigItem(
		keyName = "CustomAttSpeedEnabled",
		name = "Custom attack speed",
		description = "Use this if the timer is wrong.",
		position = 2
	)
	default boolean isCustomAttSpeed()
	{
		return false;
	}

	@Range(
		min = 1
	)
	@ConfigItem(
		keyName = "CustomAttSpeed",
		name = "Custom NPC att speed",
		description = "The attack speed of the NPC (amount of ticks between their attacks).",
		position = 3,
		hidden = true,
		unhide = "CustomAttSpeedEnabled"
	)
	default int getCustomAttSpeed()
	{
		return 4;
	}
}
