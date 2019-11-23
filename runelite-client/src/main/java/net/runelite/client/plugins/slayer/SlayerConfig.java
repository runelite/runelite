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
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("slayer")
public interface SlayerConfig extends Config
{

	@ConfigItem(
		position = 1,
		keyName = "infobox",
		name = "Task InfoBox",
		description = "Display task information in an InfoBox"
	)
	default boolean showInfobox()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "itemoverlay",
		name = "Count on Items",
		description = "Display task count remaining on slayer items"
	)
	default boolean showItemOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "superiornotification",
		name = "Superior foe notification",
		description = "Toggles notifications on superior foe encounters"
	)
	default boolean showSuperiorNotification()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "statTimeout",
		name = "InfoBox Expiry (minutes)",
		description = "Set the time until the InfoBox expires"
	)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		position = 5,
		keyName = "highlightTargets",
		name = "Highlight Targets",
		description = "Highlight monsters you can kill for your current slayer assignment"
	)
	default boolean highlightTargets()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "highlightStyle",
		name = "Highlight Style",
		description = "Highlight setting"
	)
	default RenderStyle renderStyle()
	{
		return RenderStyle.THIN_OUTLINE;
	}

	@ConfigItem(
		position = 7,
		keyName = "targetColor",
		name = "Target Color",
		description = "Color of the highlighted targets"
	)
	default Color getTargetColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 8,
		keyName = "superiorColor",
		name = "Superior Color",
		description = "Color of the highlighted superior slayer creatures"
	)
	default Color getSuperiorColor()
	{
		return Color.MAGENTA;
	}

	@ConfigItem(
		position = 9,
		keyName = "drawNames",
		name = "Draw names above NPC",
		description = "Configures whether or not NPC names should be drawn above the NPC"
	)
	default boolean drawNames()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "drawMinimapNames",
		name = "Draw names on minimap",
		description = "Configures whether or not NPC names should be drawn on the minimap"
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "weaknessPrompt",
		name = "Show Monster Weakness",
		description = "Show an overlay on a monster when it is weak enough to finish off (Only Lizards, Gargoyles & Rockslugs)"
	)
	default boolean weaknessPrompt()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "taskCommand",
		name = "Task Command",
		description = "Configures whether the slayer task command is enabled<br> !task"
	)
	default boolean taskCommand()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "pointsCommand",
		name = "Points Command",
		description = "Configures whether the slayer points command is enabled<br> !points"
	)
	default boolean pointsCommand()
	{
		return true;
	}

	// Stored data
	@ConfigItem(
		keyName = "taskName",
		name = "",
		description = "",
		hidden = true
	)
	default String taskName()
	{
		return "";
	}

	@ConfigItem(
		keyName = "taskName",
		name = "",
		description = ""
	)
	void taskName(String key);

	@ConfigItem(
		keyName = "amount",
		name = "",
		description = "",
		hidden = true
	)
	default int amount()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "amount",
		name = "",
		description = ""
	)
	void amount(int amt);

	@ConfigItem(
		keyName = "initialAmount",
		name = "",
		description = "",
		hidden = true
	)
	default int initialAmount()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "initialAmount",
		name = "",
		description = ""
	)
	void initialAmount(int initialAmount);

	@ConfigItem(
		keyName = "taskLocation",
		name = "",
		description = "",
		hidden = true
	)
	default String taskLocation()
	{
		return "";
	}

	@ConfigItem(
		keyName = "taskLocation",
		name = "",
		description = ""
	)
	void taskLocation(String key);

	@ConfigItem(
		keyName = "lastCertainAmount",
		name = "",
		description = "",
		hidden = true
	)
	default int lastCertainAmount()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "lastCertainAmount",
		name = "",
		description = ""
	)
	void lastCertainAmount(int lastCertainAmount);

	@ConfigItem(
		keyName = "streak",
		name = "",
		description = "",
		hidden = true
	)
	default int streak()
	{
		return -1;
	}

	@ConfigItem(
		keyName = "streak",
		name = "",
		description = ""
	)
	void streak(int streak);
}
