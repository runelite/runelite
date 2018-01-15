/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.poh;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "poh",
	name = "Poh",
	description = "Configuration for the POH plugin"
)
public interface PohConfig extends Config
{
	@ConfigItem(
		keyName = "showVarrock",
		name = "Show Varrock portal",
		description = "Configures whether or not the Varrock portal is displayed"
	)
	default boolean showVarrock()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFalador",
		name = "Show Falador portal",
		description = "Configures whether or not the Camelot portal is displayed"
	)
	default boolean showFalador()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLumbridge",
		name = "Show Lumbridge portal",
		description = "Configures whether or not the Lumbridge portal is displayed"
	)
	default boolean showLumbridge()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCamelot",
		name = "Show Camelot portal",
		description = "Configures whether or not the Camelot portal is displayed"
	)
	default boolean showCamelot()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showArdougne",
		name = "Show Ardougne portal",
		description = "Configures whether or not the Ardougne portal is displayed"
	)
	default boolean showArdougne()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showYanille",
		name = "Show Yanille portal",
		description = "Configures whether or not the Yanille portal is displayed"
	)
	default boolean showYanille()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLunarIsle",
		name = "Show Lunar isle portal",
		description = "Configures whether or not the Lunar isle portal is displayed"
	)
	default boolean showLunarIsle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWaterBirth",
		name = "Show Waterbirth portal",
		description = "Configures whether or not the Waterbirth portal is displayed"
	)
	default boolean showWaterBirth()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFishingGuild",
		name = "Show Fishing guild portal",
		description = "Configures whether or not the Fishing guild portal is displayed"
	)
	default boolean showFishingGuild()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSenntisten",
		name = "Show Senntisten portal",
		description = "Configures whether or not the Senntisten portal is displayed"
	)
	default boolean showSenntisten()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showKharyll",
		name = "Show Kharyll portal",
		description = "Configures whether or not the Kharyll portal is displayed"
	)
	default boolean showKharyll()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAnnakarl",
		name = "Show Annakarl portal",
		description = "Configures whether or not the Annakarl portal is displayed"
	)
	default boolean showAnnakarl()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showKourend",
		name = "Show Kourend portal",
		description = "Configures whether or not the Kourend portal is displayed"
	)
	default boolean showKourend()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMarim",
		name = "Show Marim portal",
		description = "Configures whether or not the Marim portal is displayed"
	)
	default boolean showMarim()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAltar",
		name = "Show Altar",
		description = "Configures whether or not the altar is displayed"
	)
	default boolean showAltar()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showGlory",
		name = "Show Glory mount",
		description = "Configures whether or not the mounted glory is displayed"
	)
	default boolean showGlory()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPools",
		name = "Show Pools",
		description = "Configures whether or not the pools are displayed"
	)
	default boolean showPools()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRepairStand",
		name = "Show Repair stand",
		description = "Configures whether or not the repair stand is displayed"
	)
	default boolean showRepairStand()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showExitPortal",
		name = "Show Exit portal",
		description = "Configures whether or not the exit portal is displayed"
	)
	default boolean showExitPortal()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBurner",
		name = "Show Unlit/Lit burner",
		description = "Configures whether or not unlit/lit burners are displayed"
	)
	default boolean showBurner()
	{
		return true;
	}
}
