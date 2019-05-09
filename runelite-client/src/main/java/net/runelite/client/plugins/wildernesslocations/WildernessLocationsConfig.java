/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */
 
package net.runelite.client.plugins.wildernesslocations;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("wildernesslocations")
public interface WildernessLocationsConfig extends Config
{
	
	@ConfigItem(
		keyName = "drawOverlay",
		name = "Draw Overlay",
		description = "Configure drawing wilderness locations overlay",
		position = 1
	)
	default boolean drawOverlay()
	{
		return true;
	}
	
	@ConfigItem(
		keyName = "keybind",
		name = "Send to CC",
		description = "Configure button to send current location to CC",
		position = 2
	)
	default Keybind keybind()
	{
		return Keybind.NOT_SET;
	}
	
}
