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
package net.runelite.client.plugins.woodcutting;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Units;
import net.runelite.client.plugins.woodcutting.config.ClueNestTier;

@ConfigGroup("woodcutting")
public interface WoodcuttingConfig extends Config
{
	@ConfigSection(
		name = "Forestry",
		description = "Configuration for forestry",
		position = 10
	)
	String forestrySection = "forestry";

	@ConfigItem(
		position = 1,
		keyName = "statTimeout",
		name = "Reset stats",
		description = "Configures the time until statistic is reset. Also configures when tree indicator is hidden"
	)
	@Units(Units.MINUTES)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		position = 2,
		keyName = "showNestNotification",
		name = "Bird nest notification",
		description = "Configures whether to notify you of a bird nest spawn"
	)
	default boolean showNestNotification()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "clueNestNotifyTier",
		name = "Clue nest notification",
		description = "Configures the clue tier from which to start notifying of a clue nest spawn"
	)
	default ClueNestTier clueNestNotifyTier()
	{
		return ClueNestTier.BEGINNER;
	}

	@ConfigItem(
		position = 4,
		keyName = "showWoodcuttingStats",
		name = "Show session stats",
		description = "Configures whether to display woodcutting session stats"
	)
	default boolean showWoodcuttingStats()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "showRedwoods",
		name = "Show Redwood trees",
		description = "Configures whether to show a indicator for redwood trees"
	)
	default boolean showRedwoodTrees()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "showRespawnTimers",
		name = "Show respawn timers",
		description = "Configures whether to display the respawn timer overlay"
	)
	default boolean showRespawnTimers()
	{
		return true;
	}

	@ConfigItem(
		position = 10,
		keyName = "forestryLeprechaunNotification",
		name = "Leprechaun notification",
		description = "Configures whether to notify you of a Leprechaun event",
		section = forestrySection
	)
	default boolean forestryLeprechaunNotification()
	{
		return true;
	}

	@ConfigItem(
		position = 11,
		keyName = "forestryRisingRootsNotification",
		name = "Rising Roots notification",
		description = "Configures whether to notify you of a Rising Roots event",
		section = forestrySection
	)
	default boolean forestryRisingRootsNotification()
	{
		return true;
	}

	@ConfigItem(
		position = 12,
		keyName = "forestryStrugglingSaplingNotification",
		name = "Struggling Sapling notification",
		description = "Configures whether to notify you of a Struggling Sapling event",
		section = forestrySection
	)
	default boolean forestryStrugglingSaplingNotification()
	{
		return true;
	}

	@ConfigItem(
		position = 13,
		keyName = "forestryFloweringTreeNotification",
		name = "Flowering Tree notification",
		description = "Configures whether to notify you of a Flowering Tree event",
		section = forestrySection
	)
	default boolean forestryFloweringTreeNotification()
	{
		return true;
	}

	@ConfigItem(
		position = 20,
		keyName = "highlightGlowingRoots",
		name = "Highlight glowing roots",
		description = "Highlights glowing roots during Rising Roots events",
		section = forestrySection
	)
	default boolean highlightGlowingRoots()
	{
		return true;
	}

	@ConfigItem(
		position = 21,
		keyName = "highlightMulch",
		name = "Highlight mulch ingredients",
		description = "Highlights mulch ingredients during Struggling Sapling events",
		section = forestrySection
	)
	default boolean highlightMulch()
	{
		return true;
	}

	@ConfigItem(
		position = 22,
		keyName = "highlightFlowers",
		name = "Highlight flowers",
		description = "Highlights flowers during Flowering Tree events",
		section = forestrySection
	)
	default boolean highlightFlowers()
	{
		return true;
	}
}