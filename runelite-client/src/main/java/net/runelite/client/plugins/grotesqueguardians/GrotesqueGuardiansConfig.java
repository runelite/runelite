package net.runelite.client.plugins.grotesqueguardians;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("grotesqueguardians")
public interface GrotesqueGuardiansConfig extends Config
{
	@ConfigItem(
		keyName = "displayTileIndiciators",
		name = "Display Tile Indicators",
		description = "Configures the display of tile indicators",
		position = 1
	)
	default boolean displayTileIndicators()
	{
		return true;
	}

	@ConfigItem(
		keyName = "displayTextOverlays",
		name = "Display Text Overlays",
		description = "Configures the display of text overlays",
		position = 2
	)
	default boolean displayTextOverlays()
	{
		return true;
	}

	@ConfigItem(
		keyName = "displayLightning",
		name = "Display Lightning Tiles",
		description = "Configures the display of lightning special attack tiles",
		position = 3
	)
	default boolean displayLightning()
	{
		return true;
	}

	@ConfigItem(
		keyName = "lightningColor",
		name = "Lightning Tile Color",
		description = "Configures the color of the lightning special attack tiles",
		position = 4
	)
	default Color lightningColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		keyName = "displayStoneOrb",
		name = "Display Stone Orb Tile",
		description = "Configures the display of stone orb projectile tiles",
		position = 5
	)
	default boolean displayStoneOrb()
	{
		return true;
	}

	@ConfigItem(
		keyName = "stoneOrbColor",
		name = "Stone Orb Tile Color",
		description = "Configures the color of the stone orb projectile tiles",
		position = 6
	)
	default Color stoneOrbColor()
	{
		return Color.GRAY;
	}

	@ConfigItem(
		keyName = "displayFallingRocks",
		name = "Display Falling Rock Tiles",
		description = "Configures the display of falling rock tiles",
		position = 7
	)
	default boolean displayFallingRocks()
	{
		return true;
	}

	@ConfigItem(
		keyName = "fallingRocksColor",
		name = "Falling Rocks Tile Color",
		description = "Configures the color of the falling rock tiles",
		position = 8
	)
	default Color fallingRocksColor()
	{
		return Color.YELLOW;
	}
}
