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
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("itemstat")
public interface ItemStatConfig extends Config
{
	@ConfigItem(
		keyName = "consumableStats",
		name = "Enable consumable stats",
		description = "Enables tooltips for consumable items (food, boosts)"
	)
	default boolean consumableStats()
	{
		return true;
	}

	@ConfigItem(
		keyName = "equipmentStats",
		name = "Enable equipment stats",
		description = "Enables tooltips for equipment items (combat bonuses, weight, prayer bonuses)"
	)
	default boolean equipmentStats()
	{
		return true;
	}

	@ConfigItem(
		keyName = "geStats",
		name = "Enable GE item information",
		description = "Shows an item information panel when buying items in the GE"
	)
	default boolean geStats()
	{
		return true;
	}

	@ConfigItem(
		keyName = "relative",
		name = "Show Relative",
		description = "Show relative stat change in tooltip"
	)
	default boolean relative()
	{
		return true;
	}

	@ConfigItem(
		keyName = "absolute",
		name = "Show Absolute",
		description = "Show absolute stat change in tooltip"
	)
	default boolean absolute()
	{
		return true;
	}

	@ConfigItem(
		keyName = "theoretical",
		name = "Show Theoretical",
		description = "Show theoretical stat change in tooltip"
	)
	default boolean theoretical()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showWeight",
		name = "Show Weight",
		description = "Show weight in tooltip"
	)
	default boolean showWeight()
	{
		return true;
	}

	@ConfigItem(
		keyName = "colorBetterUncapped",
		name = "Better (Uncapped)",
		description = "Color to show when the stat change is fully consumed",
		position = 10
	)
	default Color colorBetterUncapped()
	{
		return new Color(0x33EE33);
	}

	@ConfigItem(
		keyName = "colorBetterSomecapped",
		name = "Better (Some capped)",
		description = "Color to show when some stat changes are capped, but some ar not",
		position = 11
	)
	default Color colorBetterSomeCapped()
	{
		return new Color(0x9CEE33);
	}


	@ConfigItem(
		keyName = "colorBetterCapped",
		name = "Better (Capped)",
		description = "Color to show when the stat change is positive, but not fully consumed",
		position = 12
	)
	default Color colorBetterCapped()
	{
		return new Color(0xEEEE33);
	}

	@ConfigItem(
		keyName = "colorNoChange",
		name = "No change",
		description = "Color to show when there is no change",
		position = 13
	)
	default Color colorNoChange()
	{
		return new Color(0xEEEEEE);
	}

	@ConfigItem(
		keyName = "colorWorse",
		name = "Worse",
		description = "Color to show when the stat goes down",
		position = 14
	)
	default Color colorWorse()
	{
		return new Color(0xEE3333);
	}
}
