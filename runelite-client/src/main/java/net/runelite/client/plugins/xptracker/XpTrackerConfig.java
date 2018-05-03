/*
 * Copyright (c) 2017, Evan Sloan <https://github.com/evansloan082>
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
package net.runelite.client.plugins.xptracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "xptracker",
		name = "XP Tracker",
		description = "Configuration for the XP tracker plugin"
)
public interface XpTrackerConfig extends Config
{
	@ConfigItem(
			keyName = "trackAgility",
			name = "Track Agility",
			description = "Configures whether or not to track agility XP",
			position = 0
	)
	default boolean trackAgility()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackAttack",
			name = "Track Attack",
			description = "Configures whether or not to track Attack XP",
			position = 1
	)
	default boolean trackAttack()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackConstruction",
			name = "Track Agility",
			description = "Configures whether or not to track contruction XP",
			position = 2
	)
	default boolean trackConstruction()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackCooking",
			name = "Track Cooking",
			description = "Configures whether or not to track cooking XP",
			position = 3
	)
	default boolean trackCooking()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackCrafting",
			name = "Track Crafting",
			description = "Configures whether or not to track crafting XP",
			position = 4
	)
	default boolean trackCrafting()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackDefence",
			name = "Track Defence",
			description = "Configures whether or not to track defence XP",
			position = 5
	)
	default boolean trackDefence()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackFarming",
			name = "Track Farming",
			description = "Configures whether or not to track farming XP",
			position = 6
	)
	default boolean trackFarming()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackFiremaking",
			name = "Track Firemanking",
			description = "Configures whether or not to track firemaking XP",
			position = 7
	)
	default boolean trackFiremaking()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackFishing",
			name = "Track Fishing",
			description = "Configures whether or not to track fishing XP",
			position = 8
	)
	default boolean trackFishing()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackFletching",
			name = "Track Fletching",
			description = "Configures whether or not to track fletching XP",
			position = 9
	)
	default boolean trackFletching()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackHerblore",
			name = "Track Herblore",
			description = "Configures whether or not to track herblore XP",
			position = 10
	)
	default boolean trackHerblore()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackHitpoints",
			name = "Track Hitpoints",
			description = "Configures whether or not to track hitpoints XP",
			position = 11
	)
	default boolean trackHitpoints()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackHunter",
			name = "Track Hunter",
			description = "Configures whether or not to track hunter XP",
			position = 12
	)
	default boolean trackHunter()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackMagic",
			name = "Track Magic",
			description = "Configures whether or not to track magic XP",
			position = 13
	)
	default boolean trackMagic()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackMining",
			name = "Track Mining",
			description = "Configures whether or not to track mining XP",
			position = 14
	)
	default boolean trackMining()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackPrayer",
			name = "Track Prayer",
			description = "Configures whether or not to track prayer XP",
			position = 15
	)
	default boolean trackPrayer()
	{
		return true;
	}

	@ConfigItem(
			keyName = "Ranged",
			name = "Track Ranged",
			description = "Configures whether or not to track ranged XP",
			position = 16
	)
	default boolean trackRanged()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackRunecraft",
			name = "Track Runecrafting",
			description = "Configures whether or not to track runecrafting XP",
			position = 17
	)
	default boolean trackRunecraft()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackSlayer",
			name = "Track Slayer",
			description = "Configures whether or not to track slayer XP",
			position = 18
	)
	default boolean trackSlayer()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackSmithing",
			name = "Track Smithing",
			description = "Configures whether or not to track smithing XP",
			position = 19
	)
	default boolean trackSmithing()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackStrength",
			name = "Track Strength",
			description = "Configures whether or not to track strength XP",
			position = 20
	)
	default boolean trackStrength()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackThieving",
			name = "Track Thieving",
			description = "Configures whether or not to track thieving XP",
			position = 21
	)
	default boolean trackThieving()
	{
		return true;
	}

	@ConfigItem(
			keyName = "trackWoodcutting",
			name = "Track Woodcutting",
			description = "Configures whether or not to track woodcutting XP",
			position = 22
	)
	default boolean trackWoodcutting()
	{
		return true;
	}
}
