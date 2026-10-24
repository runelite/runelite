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
package net.runelite.client.plugins.barrows;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("barrows")
public interface BarrowsConfig extends Config
{
	@ConfigSection(
		name = "Reward Potential",
		description = "Reward potential display settings.",
		position = 7
	)
	String rewardPotentialSection = "rewardPotential";

	@Range(
		min = 1,
		max = 100
	)
	@ConfigItem(
		keyName = "potentialGoal",
		name = "Potential goal",
		description = "Sets the reward potential goal. Defaults to 87 for best rune rewards.",
		position = 1,
		section = rewardPotentialSection
	)
	default int potentialGoal()
	{
		return 87;
	}

	@ConfigItem(
		keyName = "showBrotherLoc",
		name = "Show brothers location",
		description = "Configures whether or not the brothers location is displayed.",
		position = 1
	)
	default boolean showBrotherLoc()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showChestValue",
		name = "Show value of chests",
		description = "Configure whether to show total exchange value of chest when opened.",
		position = 2
	)
	default boolean showChestValue()
	{
		return true;
	}

	@ConfigItem(
		keyName = "brotherLocColor",
		name = "Brother location color",
		description = "Change the color of the name displayed on the minimap.",
		position = 3
	)
	default Color brotherLocColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		keyName = "deadBrotherLocColor",
		name = "Dead brother loc. color",
		description = "Change the color of the name displayed on the minimap for a dead brother.",
		position = 4
	)
	default Color deadBrotherLocColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "showPuzzleAnswer",
		name = "Show puzzle answer",
		description = "Configures if the puzzle answer should be shown.",
		position = 5
	)
	default boolean showPuzzleAnswer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPrayerDrainTimer",
		name = "Show prayer drain timer",
		description = "Configure whether or not a countdown until the next prayer drain is displayed.",
		position = 6
	)
	default boolean showPrayerDrainTimer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPotentialProgressBar",
		name = "Show potential as a bar",
		description = "Displays reward potential as a progress bar up to the potential goal.",
		position = 2,
		section = rewardPotentialSection
	)
	default boolean showPotentialProgressBar()
	{
		return true;
	}

	@Range(
		min = -100,
		max = 100
	)
	@ConfigItem(
		keyName = "enemyPotentialOffset",
		name = "Enemy potential offset",
		description = "Adjusts potential text height relative to the center of the enemy model. 0 places it at the center.",
		position = 3,
		section = rewardPotentialSection
	)
	default int enemyPotentialOffset()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "showBrothersPotential",
		name = "Show brothers potential",
		description = "Shows reward potential above the Barrows Brothers.",
		position = 4,
		section = rewardPotentialSection
	)
	default boolean showBrothersPotential()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showNewPotential",
		name = "Show new potential",
		description = "Shows the reward potential you would have after killing the NPC, without showing your current potential.",
		position = 5,
		section = rewardPotentialSection
	)
	default boolean showNewPotential()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showPotentialKillRecommendations",
		name = "Show potential kills",
		description = "Shows the closest kill combinations in the Barrows crypts after five brothers have been killed.",
		position = 6,
		section = rewardPotentialSection
	)
	default boolean showPotentialKillRecommendations()
	{
		return true;
	}

	@ConfigItem(
		keyName = "preventExceedingGoal",
		name = "Prevent exceeding goal",
		description = "Prevents manual attacks on NPCs that would take you over your reward potential goal (except the Barrows Brothers). Does not prevent attacks initiated by Auto Retaliate.",
		position = 7,
		section = rewardPotentialSection
	)
	default boolean preventExceedingGoal()
	{
		return false;
	}
}
