/*******************************************************************************
 * Copyright (c) 2019 openosrs
 * Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 * If there are any questions comments, or feedback about this software, please direct all inquiries directly to the file authors:
 * ST0NEWALL#9112
 * openosrs Discord: https://discord.gg/Q7wFtCe
 * openosrs website: https://openosrs.com
 ******************************************************************************/

package net.runelite.client.plugins.wildernesslocations;

import java.awt.Color;
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
		keyName = "pvpWorld",
		name = "PvP World",
		description = "When enabled, shows location when anywhere in a PvP World",
		position = 2
	)
	default boolean pvpWorld()
	{
		return true;
	}

	@ConfigItem(
		keyName = "keybind",
		name = "Send to CC",
		description = "Configure button to send current location to CC",
		position = 3
	)
	default Keybind keybind()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(
		keyName = "worldMapNames",
		name = "Show Loc Names World Map",
		description = "Toggles whether or not Wilderness Location names are shown on the World Map",
		position = 4
	)
	default boolean worldMapOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "outlineLocations",
		name = "Outline Locations",
		description = "Draws an outline for the area of each location in the wilderness",
		position = 5
	)
	default boolean outlineLocations()
	{
		return false;
	}

	@ConfigItem(
		keyName = "mapOverlayColor",
		name = "World Map Color",
		description = "The color for the names and outlines of the locations on the World Map",
		position = 6
	)
	default Color mapOverlayColor()
	{
		return Color.cyan;
	}


}
