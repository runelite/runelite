/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.itemstats;

import java.awt.Color;

import net.runelite.client.config.*;

@ConfigGroup("itemstat")
public interface ItemStatConfig extends Config
{
	@ConfigSection(name = "General",         description = "General settings",             position = 0)
	String sectionGeneral = "general";

	@ConfigSection(name = "Colors",           description = "Color settings",         position = 1)
	String sectionColors = "colors";

	@ConfigSection(name = "Keybind", description = "Keybind settings",       position = 2)
	String sectionKeybind = "keybind";

	@ConfigItem(
		keyName = "consumableStats",
		name = "Enable consumable stats",
		description = "Enables tooltips for consumable items (food, boosts).",
		section = sectionGeneral
	)
	default boolean consumableStats()
	{
		return true;
	}

	@ConfigItem(
		keyName = "equipmentStats",
		name = "Enable equipment stats",
		description = "Enables tooltips for equipment items (combat bonuses, weight, prayer bonuses).",
		section = sectionGeneral
	)
	default boolean equipmentStats()
	{
		return true;
	}

	@ConfigItem(
		keyName = "geStats",
		name = "Enable GE item information",
		description = "Shows an item information panel when buying items in the GE.",
		section = sectionGeneral
	)
	default boolean geStats()
	{
		return true;
	}

	@ConfigItem(
		keyName = "relative",
		name = "Show relative",
		description = "Show relative stat change in tooltip.",
		section = sectionGeneral
	)
	default boolean relative()
	{
		return true;
	}

	@ConfigItem(
		keyName = "absolute",
		name = "Show absolute",
		description = "Show absolute stat change in tooltip.",
		section = sectionGeneral
	)
	default boolean absolute()
	{
		return true;
	}

	@ConfigItem(
		keyName = "theoretical",
		name = "Show theoretical",
		description = "Show theoretical stat change in tooltip.",
		section = sectionGeneral
	)
	default boolean theoretical()
	{
		return false;
	}

	@ConfigItem(
		keyName = "enableWeight",
		name = "Enable weight",
		description = "Enable weight in tooltip.",
		section = sectionGeneral
	)
	default boolean showWeight()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showStatsInBank",
		name = "Show stats in bank",
		description = "Show item stats on bank items tooltip.",
		section = sectionGeneral
	)
	default boolean showStatsInBank()
	{
		return true;
	}

	@ConfigItem(
		keyName = "alwaysShowBaseStats",
		name = "Always show base stats",
		description = "Always include the base items stats in the tooltip.",
		section = sectionGeneral
	)
	default boolean alwaysShowBaseStats()
	{
		return false;
	}

	@ConfigItem(
		keyName = "colorBetterUncapped",
		name = "Better (uncapped)",
		description = "Color to show when the stat change is fully consumed.",
			section = sectionColors,
		position = 0
	)
	default Color colorBetterUncapped()
	{
		return new Color(0x33EE33);
	}

	@ConfigItem(
		keyName = "colorBetterSomecapped",
		name = "Better (some capped)",
		description = "Color to show when some stat changes are capped, but some are not.",
		section = sectionColors,
		position = 1
	)
	default Color colorBetterSomeCapped()
	{
		return new Color(0x9CEE33);
	}

	@ConfigItem(
		keyName = "colorBetterCapped",
		name = "Better (capped)",
		description = "Color to show when the stat change is positive, but not fully consumed.",
		section = sectionColors,
		position = 2
	)
	default Color colorBetterCapped()
	{
		return new Color(0xEEEE33);
	}

	@ConfigItem(
		keyName = "colorNoChange",
		name = "No change",
		description = "Color to show when there is no change.",
		section = sectionColors,
		position = 3
	)
	default Color colorNoChange()
	{
		return new Color(0xEEEEEE);
	}

	@ConfigItem(
		keyName = "colorWorse",
		name = "Worse",
		description = "Color to show when the stat goes down.",
		section = sectionColors,
		position = 4
	)
	default Color colorWorse()
	{
		return new Color(0xEE3333);
	}

	@ConfigItem(
		keyName = "requireModifier",
		name = "Require modifier key",
		description = "Require a modifier key to show Item Stats.",
		section = sectionKeybind,
		position = 0
	)
	default boolean requireModifier()
	{
		return false;
	}

	@ConfigItem(
		keyName = "requireModifierForConsumables",
		name = "Require for consumables",
		description = "Require the key for consumable stats.",
		section = sectionKeybind,
		position = 1
	)
	default boolean requireModifierForConsumables()
	{
		return false;
	}

	@ConfigItem(
		keyName = "requireModifierForEquipment",
		name = "Require for equipment",
		description = "Require the key for equipment stats.",
		section = sectionKeybind,
		position = 2
	)
	default boolean requireModifierForEquipment()
	{
		return true;
	}

	@ConfigItem(
		keyName = "modifierKey",
		name = "Modifier key",
		description = "Modifier key for the above option.",
		section = sectionKeybind,
		position = 3
	)
	default Keybind modifierKey() 
	{
		return Keybind.NOT_SET;
	}
}
