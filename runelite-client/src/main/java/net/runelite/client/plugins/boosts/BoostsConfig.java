/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.boosts;

import com.google.common.collect.ImmutableSet;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.runelite.api.Skill;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Notification;

@ConfigGroup("boosts")
public interface BoostsConfig extends Config
{
	enum DisplayChangeMode
	{
		ALWAYS,
		BOOSTED,
		NEVER
	}

	enum DisplayBoosts
	{
		NONE("None", Collections.EMPTY_SET),
		COMBAT("Combat", DisplayBoostSkills.BOOSTABLE_COMBAT_SKILLS),
		NON_COMBAT("Non Combat", DisplayBoostSkills.BOOSTABLE_NON_COMBAT_SKILLS),
		ALL("All", DisplayBoostSkills.ALL_BOOSTABLE_SKILLS),

		// STR_RANGE_MAGE: Similar to Combat, but without attack & defence. In both PvM & PvP, odds are that you're
		// gonna be using a mixture of super combat potions & saradomin brews, which means that knowing your attack
		// & defence boosts doesn't give you any more info than knowing your Strength boost.
		STR_RANGE_MAGE("Str, Range, Mage", DisplayBoostSkills.STR_RANGE_MAGE);

		String name;
		Set<Skill> skillsToDisplay;

		DisplayBoosts(String name, Set<Skill> skillsToDisplay)
		{
			this.name = name;
			this.skillsToDisplay = skillsToDisplay;
		}

		@Override
		public String toString()
		{
			return this.name;
		}
	}
	// use static class for these constants since we can't put these directly in DisplayBoosts,
	// can't use enum static fields in their own init.
	class DisplayBoostSkills
	{
		public static final Set<Skill> BOOSTABLE_COMBAT_SKILLS = ImmutableSet.of(
			Skill.ATTACK,
			Skill.STRENGTH,
			Skill.DEFENCE,
			Skill.RANGED,
			Skill.MAGIC);
		public static final Set<Skill> BOOSTABLE_NON_COMBAT_SKILLS = ImmutableSet.of(
			Skill.MINING, Skill.AGILITY, Skill.SMITHING, Skill.HERBLORE, Skill.FISHING, Skill.THIEVING,
			Skill.COOKING, Skill.CRAFTING, Skill.FIREMAKING, Skill.FLETCHING, Skill.WOODCUTTING, Skill.RUNECRAFT,
			Skill.SLAYER, Skill.FARMING, Skill.CONSTRUCTION, Skill.HUNTER, Skill.SAILING);

		public static final Set<Skill> ALL_BOOSTABLE_SKILLS = Stream.concat(
			BOOSTABLE_COMBAT_SKILLS.stream(), BOOSTABLE_NON_COMBAT_SKILLS.stream()
		).collect(Collectors.toSet());

		public static final Set<Skill> STR_RANGE_MAGE = ImmutableSet.of(
			Skill.STRENGTH,
			Skill.RANGED,
			Skill.MAGIC);
	}

	@ConfigItem(
		keyName = "displayBoosts",
		name = "Display boosts",
		description = "Configures which skill boosts to display.",
		position = 1
	)
	default DisplayBoosts displayBoosts()
	{
		return DisplayBoosts.COMBAT;
	}

	@ConfigItem(
		keyName = "relativeBoost",
		name = "Show relative boosts",
		description = "Configures whether or not relative boost is used.",
		position = 2
	)
	default boolean useRelativeBoost()
	{
		return false;
	}

	@ConfigItem(
		keyName = "displayIndicators",
		name = "Display infoboxes",
		description = "Configures whether to display boost infoboxes.",
		position = 3
	)
	default boolean displayInfoboxes()
	{
		return true;
	}

	@ConfigItem(
		keyName = "displayPanel",
		name = "Display panel",
		description = "Configures whether to display the boost panel.",
		position = 3
	)
	default boolean displayPanel()
	{
		return false;
	}

	@ConfigItem(
		keyName = "compactDisplay",
		name = "Compact display",
		description = "Displays skill boosts in a more compact panel.",
		position = 4
	)
	default boolean compactDisplay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "displayNextBuffChange",
		name = "Next buff change",
		description = "Configures whether or not to display when the next buffed stat change will be.",
		position = 10
	)
	default DisplayChangeMode displayNextBuffChange()
	{
		return DisplayChangeMode.BOOSTED;
	}

	@ConfigItem(
		keyName = "displayNextDebuffChange",
		name = "Next debuff change",
		description = "Configures whether or not to display when the next debuffed stat change will be.",
		position = 11
	)
	default DisplayChangeMode displayNextDebuffChange()
	{
		return DisplayChangeMode.NEVER;
	}

	@ConfigItem(
		keyName = "boostThreshold",
		name = "Boost threshold",
		description = "Number of levels above your base level at which boosted levels will be displayed in a different color.",
		position = 12
	)
	default int boostThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "notifyOnBoost",
		name = "Notify on boost threshold",
		description = "Configures whether or not a notification will be sent when boosted stats drain to the boost threshold.",
		position = 13
	)
	default Notification notifyOnBoost()
	{
		return Notification.OFF;
	}
}
