/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.worldmaphider;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("worldMapHider")
public interface WorldMapHiderConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "hideWorldMapButton",
		name = "Hide World Map Button",
		description = "Hides the world map button. Prevents missclicks that open the world map"
	)
	default boolean hideWorldMapButton()
	{
		return false;
	}
}
