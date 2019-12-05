/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.prayagainstplayer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("prayagainstplayer")
public interface PrayAgainstPlayerConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "ignoreFriends",
		name = "Ignore Friends",
		description = "This lets you decide whether you want friends to be highlighted by this plugin."
	)
	default boolean ignoreFriends()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "ignoreClanMates",
		name = "Ignore Clan Mates",
		description = "This lets you decide whether you want clan mates to be highlighted by this plugin."
	)
	default boolean ignoreClanMates()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "drawTargetPrayAgainstPrayerTab",
		name = "Draw what to pray from prayer tab",
		description = "Tells you what to pray from what weapon the attacker is holding from the prayer tab"
	)
	default boolean drawTargetPrayAgainstPrayerTab()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "highlightAttackers",
		name = "Highlight Attackers",
		description = "This will highlight attackers."
	)
	default boolean highlightAttackers()
	{
		return false;
	}

	@Range(
		min = 1,
		max = 10
	)
	@ConfigItem(
		position = 5,
		keyName = "highlightWidth",
		name = "Highlight Width",
		description = "This will set the highlight attackers outline width.",
		hidden = true,
		unhide = "highlightAttackers"
	)
	default int highlightWidth()
	{
		return 4;
	}
}
