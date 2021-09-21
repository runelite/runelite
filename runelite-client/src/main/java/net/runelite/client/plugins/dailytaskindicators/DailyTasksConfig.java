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
import net.runelite.client.config.ConfigSection;

@ConfigGroup("dailytaskindicators")
public interface DailyTasksConfig extends Config
{
	@ConfigSection(
		position = 1,
		name = "Tasks",
		description = "List of daily tasks"
	)
	String tasks = "tasks";

	@ConfigItem(
		position = 1,
		keyName = "showHerbBoxes",
		name = "Show Herb Boxes",
		description = "Show a message when you can collect your daily herb boxes at NMZ.",
		section = tasks
	)
	default boolean showHerbBoxes()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "showStaves",
		name = "Show Claimable Staves",
		description = "Show a message when you can collect your daily battlestaves from Zaff.",
		section = tasks
	)
	default boolean showStaves()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "showEssence",
		name = "Show Claimable Essence",
		description = "Show a message when you can collect your daily pure essence from Wizard Cromperty.",
		section = tasks
	)
	default boolean showEssence()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "showRunes",
		name = "Show Claimable Random Runes",
		description = "Show a message when you can collect your daily random runes from Lundail.",
		section = tasks
	)
	default boolean showRunes()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "showSand",
		name = "Show Claimable Sand",
		description = "Show a message when you can collect your daily sand from Bert.",
		section = tasks
	)
	default boolean showSand()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "showFlax",
		name = "Show Claimable Bow Strings",
		description = "Show a message when you can convert noted flax to bow strings with the Flax keeper.",
		section = tasks
	)
	default boolean showFlax()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "showBonemeal",
		name = "Show Claimable Bonemeal & Slime",
		description = "Show a message when you can collect bonemeal & slime from Robin.",
		section = tasks
	)
	default boolean showBonemeal()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "showDynamite",
		name = "Show Claimable Dynamite",
		description = "Show a message when you can collect Dynamite from Thirus.",
		section = tasks
	)
	default boolean showDynamite()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "showArrows",
		name = "Show Claimable Ogre Arrows",
		description = "Show a message when you can collect ogre arrows from Rantz.",
		section = tasks
	)
	default boolean showArrows()
	{
		return false;
	}

	@ConfigSection(
		position = 2,
		name = "Infoboxes",
		description = "Infoboxes settings"
	)
	String infoboxes = "infoboxes";

	@ConfigItem(
		position = 1,
		keyName = "showInfoBoxes",
		name = "Show Daily Tasks as Infoboxes",
		description = "Hide daily tasks messages from the chat and show daily tasks as infoboxes.",
		section = infoboxes
	)
	default boolean showInfoBoxes()
	{
		return false;
	}
}
