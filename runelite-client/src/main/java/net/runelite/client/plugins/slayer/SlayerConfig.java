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
import net.runelite.client.config.Notification;
import net.runelite.client.config.Units;

@ConfigGroup(SlayerConfig.GROUP_NAME)
public interface SlayerConfig extends Config
{
	String GROUP_NAME = "slayer";

	// Key names for stored task values
	String TASK_NAME_KEY = "taskName";
	String AMOUNT_KEY = "amount";
	String INIT_AMOUNT_KEY = "initialAmount";
	String TASK_LOC_KEY = "taskLocation";
	String STREAK_KEY = "streak";
	String POINTS_KEY = "points";

	@ConfigItem(
		position = 1,
		keyName = "infobox",
		name = "Task infobox",
		description = "Display task information in an infobox."
	)
	default boolean showInfobox()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "itemoverlay",
		name = "Count on items",
		description = "Display task count remaining on slayer items."
	)
	default boolean showItemOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "superiornotification",
		name = "Superior foe notification",
		description = "Toggles notifications on superior foe encounters."
	)
	default Notification showSuperiorNotification()
	{
		return Notification.ON;
	}

	@ConfigItem(
		position = 4,
		keyName = "statTimeout",
		name = "Infobox expiry",
		description = "Set the time until the infobox expires."
	)
	@Units(Units.MINUTES)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		position = 5,
		keyName = "highlightHull",
		name = "Highlight hull",
		description = "Configures whether the NPC hull should be highlighted."
	)
	default boolean highlightHull()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "highlightTile",
		name = "Highlight tile",
		description = "Configures whether the NPC tile should be highlighted."
	)
	default boolean highlightTile()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "highlightTrueTile",
		name = "Highlight true tile",
		description = "Configures whether or not the NPC true tile should be highlighted."
	)
	default boolean highlightTrueTile()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "highlightSwTile",
		name = "Highlight south west tile",
		description = "Configures whether or not the NPC south western tile should be highlighted."
	)
	default boolean highlightSwTile()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "highlightSwTrueTile",
		name = "Highlight south west true tile",
		description = "Configures whether or not the NPC south western true tile should be highlighted."
	)
	default boolean highlightSwTrueTile()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "highlightOutline",
		name = "Highlight outline",
		description = "Configures whether or not the NPC outline should be highlighted."
	)
	default boolean highlightOutline()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "showRespawnTimer",
		name = "Show respawn timer",
		description = "Configures whether the NPC respawn timer should be shown."
	)
	default boolean showRespawnTimer()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 12,
		keyName = "targetColor",
		name = "Target color",
		description = "Color of the highlighted targets."
	)
	default Color getTargetColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 13,
		keyName = "weaknessPrompt",
		name = "Show monster weakness",
		description = "Show an overlay on a monster when it is weak enough to finish off (only lizards, gargoyles, rockslugs & zygomites)."
	)
	default boolean weaknessPrompt()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "taskCommand",
		name = "Task command",
		description = "Configures whether the slayer task command is enabled: !task"
	)
	default boolean taskCommand()
	{
		return true;
	}

}
