/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
 * Copyright (c) 2018, Shaun Dreclin <https://github.com/ShaunDreclin>
 *
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
package net.runelite.client.plugins.dailytaskindicators;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("dailytaskindicators")
public interface DailyTasksConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "showHerbBoxes",
		name = "Show herb boxes",
		description = "Show a message when you can collect your daily herb boxes at NMZ."
	)
	default boolean showHerbBoxes()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "showStaves",
		name = "Show claimable staves",
		description = "Show a message when you can collect your daily battlestaves from Zaff."
	)
	default boolean showStaves()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "showEssence",
		name = "Show claimable essence",
		description = "Show a message when you can collect your daily pure essence from Wizard Cromperty."
	)
	default boolean showEssence()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "showRunes",
		name = "Show claimable random runes",
		description = "Show a message when you can collect your daily random runes from Lundail."
	)
	default boolean showRunes()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "showSand",
		name = "Show claimable sand",
		description = "Show a message when you can collect your daily sand from Bert."
	)
	default boolean showSand()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "showFlax",
		name = "Show claimable bow strings",
		description = "Show a message when you can convert noted flax to bow strings with the Flax keeper."
	)
	default boolean showFlax()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "showBonemeal",
		name = "Show claimable bonemeal & slime",
		description = "Show a message when you can collect bonemeal & slime from Robin."
	)
	default boolean showBonemeal()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "showDynamite",
		name = "Show claimable dynamite",
		description = "Show a message when you can collect dynamite from Thirus."
	)
	default boolean showDynamite()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "showArrows",
		name = "Show claimable ogre arrows",
		description = "Show a message when you can collect ogre arrows from Rantz."
	)
	default boolean showArrows()
	{
		return false;
	}
}
