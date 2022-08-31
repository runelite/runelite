package net.runelite.client.plugins.zulrah;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.FontType;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;

@ConfigGroup("ZulrahConfig")
public interface ZulrahConfig extends Config
{
	@ConfigSection(
			name = "Zulrah",
			description = "",
			position = 0,
			closedByDefault = true
	)
	String zulrahSection = "zulrahSection";

	@ConfigSection(
			name = "Fight Helper",
			description = "",
			position = 1,
			closedByDefault = true
	)
	String fightHelperSection = "fightHelperSection";

	@ConfigSection(
			name = "Phase Helper",
			description = "",
			position = 2,
			closedByDefault = true
	)
	String phaseHelperSection = "phaseHelperSection";
	@ConfigSection(
			name = "Miscellaneous",
			description = "",
			position = 3,
			closedByDefault = true
	)
	String miscellaneousSection = "miscellaneousSection";

	@ConfigItem(
			name = "Font Type",
			keyName = "fontType",
			description = "Configure the font for the plugin overlays to use",
			position = 4
	)
	default FontType fontType() 
	{
		return FontType.SMALL;
	}

	@ConfigItem(
			name = "Text Outline",
			keyName = "textOutline",
			description = "Use an outline around text instead of a text shadow",
			position = 5
	)
	default boolean textOutline() 
	{
		return false;
	}

	@ConfigItem(
			name = "Outline Width",
			keyName = "outlineWidth",
			description = "Configures the stroke for the plugin polygons",
			position = 6
	)
	@Range(
			max = 3,
			min = 1
	)
	@Units("px")
	default int outlineWidth() 
	{
		return 2;
	}

	@ConfigItem(
			name = "Fill Alpha",
			keyName = "fillAlpha",
			description = "Configures the fill intesity for the plugin polygons",
			position = 7
	)
	@Range(
			max = 255,
			min = 1
	)
	@Units("%")
	default int fillAlpha() 
	{
		return 15;
	}

	@ConfigItem(
			name = "Phase Tick Counter",
			keyName = "phaseTickCounter",
			description = "Displays a tick counter on Zulrah showing how long until the next phase",
			position = 0,
			section = zulrahSection
	)
	default boolean phaseTickCounter() 
	{
		return false;
	}

	@ConfigItem(
			name = "Attack Tick Counter",
			keyName = "attackTickCounter",
			description = "Displays a attack tick counter on Zulrah showing how long until the next auto attack",
			position = 1,
			section = zulrahSection
	)
	default boolean attackTickCounter() 
	{
		return false;
	}

	@ConfigItem(
			name = "Tick Counter Colors",
			keyName = "tickCounterColors",
			description = "Configure the color for the Zulrah tick counters",
			position = 2,
			section = zulrahSection
	)
	@Alpha
	default Color tickCounterColors() 
	{
		return Color.WHITE;
	}

	@ConfigItem(
			name = "Total Tick Counter (InfoBox)",
			keyName = "totalTickCounter",
			description = "Displays a total tick counter infobox showing how long Zulrah has been alive for in ticks",
			position = 3,
			section = zulrahSection
	)
	default boolean totalTickCounter() 
	{
		return false;
	}

	@ConfigItem(
			name = "Display Zulrah's Tile",
			keyName = "displayZulrahTile",
			description = "Highlights Zulrah's current tile in a 5x5",
			position = 4,
			section = zulrahSection
	)
	default boolean displayZulrahTile() 
	{
		return false;
	}

	@ConfigItem(
			name = "Zulrah's Tile Color",
			keyName = "zulrahTileColor",
			description = "Configures the color for Zulrah's tile highlight",
			position = 5,
			section = zulrahSection
	)
	@Alpha
	default Color zulrahTileColor() 
	{
		return Color.LIGHT_GRAY;
	}

	@ConfigItem(
			name = "Prayer Helper",
			keyName = "prayerHelper",
			description = "Displays an overlay showing the correct prayer to use for the entirity of the Zulrah fight<br>Changes color dependent on whether or not you're praying correctly or not",
			position = 0,
			section = fightHelperSection
	)
	default boolean prayerHelper() 
	{
		return true;
	}

	@ConfigItem(
			name = "Prayer Marker",
			keyName = "prayerMarker",
			description = "Marks the correct prayer to use in the prayer book to use for the entirity of the Zulrah fight<br>Changes color dependent on whether or not you're praying correctly or not",
			position = 1,
			section = fightHelperSection
	)
	default boolean prayerMarker() 
	{
		return true;
	}

	@ConfigItem(
			name = "Prayer Conservation",
			keyName = "prayerConservation",
			description = "Displays text over your head showing when it's safe to turn off your overheads<br>Overlay gets displayed when Zulrah is not actively targeting you and your overheads are on",
			position = 2,
			section = fightHelperSection
	)
	default boolean prayerConservation() 
	{
		return false;
	}

	@ConfigItem(
			name = "Stand Locations",
			keyName = "standLocations",
			description = "Highlights the tiles to stand on for the current and next Zulrah phase",
			position = 7,
			section = fightHelperSection
	)
	default boolean standLocations() 
	{
		return true;
	}

	@ConfigItem(
			name = "Stand/Next Tile Color",
			keyName = "standAndNextColor",
			description = "Configure the color for the stand/next GROUPED tile and text",
			position = 8,
			section = fightHelperSection
	)
	@Alpha
	default Color standAndNextTileColor() 
	{
		return Color.GRAY;
	}

	@ConfigItem(
			name = "Stand Tile Color",
			keyName = "standTileColor",
			description = "Configure the color for the current stand tile and text",
			position = 9,
			section = fightHelperSection
	)
	@Alpha
	default Color standTileColor() 
	{
		return Color.CYAN;
	}

	@ConfigItem(
			name = "Next Tile Color",
			keyName = "nextStandTileColor",
			description = "Configure the color for the next stand tile and text",
			position = 10,
			section = fightHelperSection
	)
	@Alpha
	default Color nextTileColor() 
	{
		return Color.GREEN;
	}

	@ConfigItem(
			name = "Stall Locations",
			keyName = "stallLocations",
			description = "Highlights the tile to pillar stall a Zulrah phase if it supports it",
			position = 11,
			section = fightHelperSection
	)
	default boolean stallLocations() 
	{
		return false;
	}

	@ConfigItem(
			name = "Stall Tile Color",
			keyName = "stallTileColor",
			description = "Configures the color for the stall tile and text",
			position = 12,
			section = fightHelperSection
	)
	@Alpha
	default Color stallTileColor() 
	{
		return Color.PINK;
	}

	@ConfigItem(
			name = "Display Type",
			keyName = "phaseDisplayType",
			description = "Overlay: Displays Zulrah's phases details on an overlay<br>Tile: Displays Zulrah's phases details on tiles",
			position = 0,
			section = phaseHelperSection
	)
	default DisplayType phaseDisplayType() 
	{
		return DisplayType.BOTH;
	}

	@ConfigItem(
			name = "Display Mode",
			keyName = "phaseDisplayMode",
			description = "Current: Only displays the current Zulrah phase<br>Next: Only displays the next Zulrah phase<br>",
			position = 1,
			section = phaseHelperSection
	)
	default DisplayMode phaseDisplayMode() 
	{
		return DisplayMode.BOTH;
	}

	@ConfigItem(
			name = "Rotation Name",
			keyName = "phaseRotationName",
			description = "Requires: Display Type ('Overlay' or 'Both')<br>Displays text above InfoBox overlay showing the rotation name or unidentified",
			position = 2,
			section = phaseHelperSection
	)
	default boolean phaseRotationName() 
	{
		return false;
	}

	@ConfigItem(
			name = "Hats",
			keyName = "phaseHats",
			description = "Displays Zulrah's skill type as an icon on the tile overlay",
			position = 3,
			section = phaseHelperSection
	)
	default boolean phaseHats() 
	{
		return true;
	}

	@ConfigItem(
			name = "Tags",
			keyName = "phaseTags",
			description = "Tags each Zulrah phase on the tile overlay with:<br>[Current] = Current Zulrah phase<br>[Next] = Definite next Zulrah phase<br>[P. Next] = Potentially Zulrah's next phase",
			position = 4,
			section = phaseHelperSection
	)
	default boolean phaseTags() 
	{
		return true;
	}

	@ConfigItem(
			name = "Instance Timer",
			keyName = "instanceTimer",
			description = "Displays an overlay showing how long Zulrah has been alive in minutes:seconds format<br>Timer resets on Zulrah death and/or leaving of the instance of any fashion",
			position = 0,
			section = miscellaneousSection
	)
	default boolean instanceTimer() 
	{
		return false;
	}

	@ConfigItem(
			name = "Snakeling",
			keyName = "snakelingSetting",
			description = "Remove Att. Op.: Removes the 'Attack' option from all the active Snakelings<br>Entity Hider: Hides all the active Snakelings",
			position = 1,
			section = miscellaneousSection
	)
	default SnakelingSettings snakelingSetting() 
	{
		return SnakelingSettings.OFF;
	}

	@ConfigItem(
			name = "Snakeling Hotkey",
			keyName = "snakelingMesHotkey",
			description = "Override the Snakeling MES to show attack options while hotkey is pressed",
			position = 2,
			section = miscellaneousSection
	)
	default Keybind snakelingMesHotkey() 
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(
			name = "Toxic Clouds",
			keyName = "displayToxicClouds",
			description = "Highlights the Toxic Clouds and displays their time until despawn",
			position = 3,
			section = miscellaneousSection
	)
	default boolean displayToxicClouds() 
	{
		return false;
	}

	@ConfigItem(
			name = "Toxic Clouds Color",
			keyName = "toxicCloudColor",
			description = "Configures the color of the Toxic Cloud highlight",
			position = 4,
			section = miscellaneousSection
	)
	@Alpha
	default Color toxicCloudsColor() 
	{
		return Color.GREEN;
	}

	@ConfigItem(
			name = "Projectiles",
			keyName = "displayProjectiles",
			description = "Displays when and where the Snakeling/Toxic Clouds projectile will approximately land",
			position = 5,
			section = miscellaneousSection
	)
	default boolean displayProjectiles() 
	{
		return false;
	}

	@ConfigItem(
			name = "Projectiles Color",
			keyName = "projectilesColor",
			description = "Configures the color of the Projectiles highlight",
			position = 6,
			section = miscellaneousSection
	)
	@Alpha
	default Color projectilesColor() 
	{
		return Color.LIGHT_GRAY;
	}

	public static enum SnakelingSettings 
	{
		OFF("Off"),
		MES("Remove Att. Op."),
		ENTITY("Entity Hider");

		private final String name;

		public String toString() 
		{
			return this.name;
		}

		private SnakelingSettings(String name) 
		{
			this.name = name;
		}

		public String getName() 
		{
			return this.name;
		}
	}

	public static enum DisplayMode 
	{
		CURRENT("Current"),
		NEXT("Next"),
		BOTH("Both");

		private final String name;

		public String toString() 
	{
			return this.name;
		}

		private DisplayMode(String name) 
		{
			this.name = name;
		}

		public String getName() 
		{
			return this.name;
		}
	}

	public static enum DisplayType 
	{
		OFF("Off"),
		OVERLAY("Overlay"),
		TILE("Tile"),
		BOTH("Both");

		private final String name;

		public String toString() 
		{
			return this.name;
		}

		private DisplayType(String name) 
		{
			this.name = name;
		}

		public String getName() 
		{
			return this.name;
		}
	}
}
