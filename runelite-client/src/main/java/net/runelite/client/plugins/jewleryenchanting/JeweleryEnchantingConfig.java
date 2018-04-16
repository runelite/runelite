/*
 * Copyright (c) 2018 Nicholas I
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

package net.runelite.client.plugins.jewleryenchanting;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup (
		keyName = "jeweleryEchanting",
		name = "Jewelery Enchanting",
		description = "Configuration for the Jewelery Enchanting plugin"
)
public interface JeweleryEnchantingConfig extends Config
{
	@ConfigItem (
			keyName = "unEnchantedColor",
			name = "Un-Enchanted Jewelery Color",
			description = "The color for any un-enchanted jewelery",
			position = 1
	)
	default Color unEnchantedColor ()
	{
		return new Color (255, 0, 0);
	}
	
	@ConfigItem (
			keyName = "enchantedColor",
			name = "Enchanted Jewelery Color",
			description = "The color for any enchanted jewelery",
			position = 2
	)
	default Color enchantedColor ()
	{
		return new Color (0, 255, 0);
	}
	
	@ConfigItem (
			keyName = "showLvlOneEnchants",
			name = "Show Sapphire/Opal Enchants",
			description = "Whether or not to show enchanting for sapphires/opals",
			position = 3
	)
	default boolean showLvlOneEnchants ()
	{
		return true;
	}
	
	@ConfigItem (
			keyName = "showLvlTwoEnchants",
			name = "Show Emerald/Jade Enchants",
			description = "Whether or not to show enchanting for emeralds/jades",
			position = 4
	)
	default boolean showLvlTwoEnchants ()
	{
		return true;
	}
	
	@ConfigItem (
			keyName = "showLvlThreeEnchants",
			name = "Show Ruby/Topaz Enchants",
			description = "Whether or not to show enchanting for ruby/topaz",
			position = 5
	)
	default boolean showLvlThreeEnchants ()
	{
		return true;
	}
	
	@ConfigItem (
			keyName = "showLvlFourEnchants",
			name = "Show Diamond Enchants",
			description = "Whether or not to show enchanting for diamond",
			position = 6
	)
	default boolean showLvlFourEnchants ()
	{
		return true;
	}
	
	@ConfigItem (
			keyName = "showLvlFiveEnchants",
			name = "Show Dragonstone Enchants",
			description = "Whether or not to show enchanting for dragonstone",
			position = 7
	)
	default boolean showLvlFiveEnchants ()
	{
		return true;
	}
	
	@ConfigItem (
			keyName = "showLvlSixEnchants",
			name = "Show Onyx Enchants",
			description = "Whether or not to show enchanting for onyx",
			position = 8
	)
	default boolean showLvlSixEnchants ()
	{
		return true;
	}
	
	@ConfigItem (
			keyName = "showLvlSevenEnchants",
			name = "Show Zenyte Enchants",
			description = "Whether or not to show enchanting for zenyte",
			position = 9
	)
	default boolean showLvlSevenEnchants ()
	{
		return true;
	}
	
}
