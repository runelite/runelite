/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Sean Dewar <https://github.com/seandewar>
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
package net.runelite.client.plugins.statusorbs;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("statusorbs")
public interface StatusOrbsConfig extends Config
{
	@ConfigTitleSection(
		keyName = "hp",
		name = "Hitpoints",
		description = "",
		position = 0
	)
	default Title hp()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "dynamicHpHeart",
		name = "Dynamic hitpoints heart",
		description = "Changes the HP heart color to match players current affliction",
		titleSection = "hp",
		position = 1
	)
	default boolean dynamicHpHeart()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showHitpoints",
		name = "Show hitpoints regen",
		description = "Show a ring around the hitpoints orb",
		titleSection = "hp",
		position = 2
	)
	default boolean showHitpoints()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWhenNoChange",
		name = "Show hitpoints regen at full hitpoints",
		description = "Always show the hitpoints regen orb, even if there will be no stat change",
		titleSection = "hp",
		position = 3
	)
	default boolean showWhenNoChange()
	{
		return false;
	}

	@ConfigItem(
		keyName = "notifyBeforeHpRegenDuration",
		name = "Hitpoint Regen Notification (seconds)",
		description = "Notify approximately when your next hitpoint is about to regen. A value of 0 will disable notification.",
		titleSection = "hp",
		position = 4
	)
	default int getNotifyBeforeHpRegenSeconds()
	{
		return 0;
	}

	@ConfigTitleSection(
		keyName = "spec",
		name = "Special attack",
		description = "",
		position = 5
	)
	default Title spec()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "showSpecial",
		name = "Show Spec. Attack regen",
		description = "Show a ring around the Special Attack orb",
		titleSection = "spec",
		position = 6
	)
	default boolean showSpecial()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "run",
		name = "Run energy",
		description = "",
		position = 7
	)
	default Title run()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "showRun",
		name = "Show run energy regen",
		description = "Show a ring around the run regen orb",
		position = 8,
		titleSection = "run"
	)
	default boolean showRun()
	{
		return true;
	}

	@ConfigItem(
		keyName = "replaceOrbText",
		name = "Replace run orb text with run time left",
		description = "Show the remaining run time (in seconds) next in the energy orb",
		position = 9,
		titleSection = "run"
	)
	default boolean replaceOrbText()
	{
		return false;
	}
}