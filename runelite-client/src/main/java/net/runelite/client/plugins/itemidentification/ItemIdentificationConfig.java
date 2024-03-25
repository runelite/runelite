/*
 * Copyright (c) 2019, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.itemidentification;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("itemidentification")
public interface ItemIdentificationConfig extends Config
{
	@ConfigSection(
		name = "Categories",
		description = "The categories of items to identify.",
		position = 99
	)
	String identificationSection = "identification";

	@ConfigItem(
		keyName = "identificationType",
		name = "Identification type",
		position = -4,
		description = "How much to show of the item name."
	)
	default ItemIdentificationMode identificationType()
	{
		return ItemIdentificationMode.SHORT;
	}

	@ConfigItem(
		keyName = "textColor",
		name = "Color",
		position = -3,
		description = "The color of the identification text."
	)
	default Color textColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "showHerbSeeds",
		name = "Seeds (herb)",
		description = "Show identification on herb seeds.",
		section = identificationSection
	)
	default boolean showHerbSeeds()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAllotmentSeeds",
		name = "Seeds (allotment)",
		description = "Show identification on allotment seeds.",
		section = identificationSection
	)
	default boolean showAllotmentSeeds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showFlowerSeeds",
		name = "Seeds (flower)",
		description = "Show identification on flower seeds.",
		section = identificationSection
	)
	default boolean showFlowerSeeds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showFruitTreeSeeds",
		name = "Seeds (fruit tree)",
		description = "Show identification on fruit tree seeds.",
		section = identificationSection
	)
	default boolean showFruitTreeSeeds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showTreeSeeds",
		name = "Seeds (tree)",
		description = "Show identification on tree seeds.",
		section = identificationSection
	)
	default boolean showTreeSeeds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showSpecialSeeds",
		name = "Seeds (special)",
		description = "Show identification on special seeds.",
		section = identificationSection
	)
	default boolean showSpecialSeeds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showBerrySeeds",
		name = "Seeds (berry)",
		description = "Show identification on berry seeds.",
		section = identificationSection
	)
	default boolean showBerrySeeds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showHopSeeds",
		name = "Seeds (hops)",
		description = "Show identification on hops seeds.",
		section = identificationSection
	)
	default boolean showHopsSeeds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showSacks",
		name = "Sacks",
		description = "Show identification on sacks.",
		section = identificationSection
	)
	default boolean showSacks()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showHerbs",
		name = "Herbs",
		description = "Show identification on herbs.",
		section = identificationSection
	)
	default boolean showHerbs()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showLogs",
		name = "Logs",
		description = "Show identification on logs.",
		section = identificationSection
	)
	default boolean showLogs()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showPyreLogs",
		name = "Logs (pyre)",
		description = "Show identification on pyre logs.",
		section = identificationSection
	)
	default boolean showPyreLogs()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showPlanks",
		name = "Planks",
		description = "Show identification on planks.",
		section = identificationSection
	)
	default boolean showPlanks()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showSaplings",
		name = "Saplings",
		description = "Show identification on saplings and seedlings.",
		section = identificationSection
	)
	default boolean showSaplings()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showComposts",
		name = "Composts",
		description = "Show identification on composts.",
		section = identificationSection
	)
	default boolean showComposts()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showOres",
		name = "Ores",
		description = "Show identification on ores.",
		section = identificationSection
	)
	default boolean showOres()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showBars",
		name = "Bars",
		description = "Show identification on bars.",
		section = identificationSection
	)
	default boolean showBars()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showGems",
		name = "Gems",
		description = "Show identification on gems.",
		section = identificationSection
	)
	default boolean showGems()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showPotions",
		name = "Potions",
		description = "Show identification on potions.",
		section = identificationSection
	)
	default boolean showPotions()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showButterflyMothJars",
		name = "Butterfly & Moth jars",
		description = "Show identification on Butterfly and Moth jars",
		section = identificationSection
	)
	default boolean showButterflyMothJars()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showImplingJars",
		name = "Impling jars",
		description = "Show identification on impling jars.",
		section = identificationSection
	)
	default boolean showImplingJars()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showTablets",
		name = "Tablets",
		description = "Show identification on tablets.",
		section = identificationSection
	)
	default boolean showTablets()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showTeleportScrolls",
		name = "Teleport scrolls",
		description = "Show identification on teleport scrolls.",
		section = identificationSection
	)
	default boolean showTeleportScrolls()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showJewellery",
		name = "Jewellery (unenchanted)",
		description = "Show identification on unenchanted jewellery.",
		section = identificationSection
	)
	default boolean showJewellery()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showEnchantedJewellery",
		name = "Jewellery (enchanted)",
		description = "Show identification on enchanted jewellery.",
		section = identificationSection
	)
	default boolean showEnchantedJewellery()
	{
		return false;
	}
}
