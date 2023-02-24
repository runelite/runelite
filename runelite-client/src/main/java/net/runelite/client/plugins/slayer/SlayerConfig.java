/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.client.plugins.slayer;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Units;

@ConfigGroup(SlayerConfig.GROUP_NAME)
public interface SlayerConfig extends Config
{
	String GROUP_NAME = "slayer";

	// Key names for stored task values
	String INIT_AMOUNT_KEY = "initialAmount";
	String WILDERNESS_STREAK_KEY = "wildernessStreak";

	@ConfigSection(
		name = "General",
		description = "",
		position = 0
	)
	String generalSection = "generalSection";

	@ConfigSection(
		name = "Highlight options",
		description = "The highlight options for slayer task NPCs",
		position = 1
	)
	String renderStyleSection = "renderStyleSection";

	@ConfigItem(
		position = 1,
		keyName = "infobox",
		name = "Task InfoBox",
		description = "Display task information in an InfoBox",
		section = generalSection
	)
	default boolean showInfobox()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "itemoverlay",
		name = "Count on Items",
		description = "Display task count remaining on slayer items",
		section = generalSection
	)
	default boolean showItemOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "superiornotification",
		name = "Superior foe notification",
		description = "Toggles notifications on superior foe encounters",
		section = generalSection
	)
	default boolean showSuperiorNotification()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "statTimeout",
		name = "InfoBox Expiry",
		description = "Set the time until the InfoBox expires",
		section = generalSection
	)
	@Units(Units.MINUTES)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		position = 9,
		keyName = "weaknessPrompt",
		name = "Show Monster Weakness",
		description = "Show an overlay on a monster when it is weak enough to finish off (Only Lizards, Gargoyles & Rockslugs)",
		section = generalSection
	)
	default boolean weaknessPrompt()
	{
		return true;
	}

	@ConfigItem(
		position = 10,
		keyName = "taskCommand",
		name = "Task Command",
		description = "Configures whether the slayer task command is enabled<br> !task",
		section = generalSection
	)
	default boolean taskCommand()
	{
		return true;
	}

	@ConfigItem(
		position = 0,
		keyName = "highlightTaskNpcs",
		name = "Highlight Task NPCs",
		description = "Configures whether or not task NPCs should be highlighted",
		section = renderStyleSection
	)
	default boolean highlightTaskNPCs()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "highlightDead",
		name = "Ignore dead NPCs",
		description = "Configures whether or not dead NPCs should continue to be highlighted",
		section = renderStyleSection
	)
	default boolean ignoreDead()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 2,
		keyName = "npcColor",
		name = "Highlight color",
		description = "Color of the NPC highlight border, menu, and text",
		section = renderStyleSection
	)
	default Color getTargetColor()
	{
		return Color.RED;
	}

	@Alpha
	@ConfigItem(
		position = 3,
		keyName = "fillColor",
		name = "Fill color",
		description = "Color of the NPC highlight fill",
		section = renderStyleSection
	)
	default Color getFillColor()
	{
		return new Color(255, 0, 0, 50);
	}

	@ConfigItem(
		position = 10,
		keyName = "taskCommand",
		name = "Task Command",
		description = "Configures whether the slayer task command is enabled<br> !task"
	)
	{
		return true;
	}
}
