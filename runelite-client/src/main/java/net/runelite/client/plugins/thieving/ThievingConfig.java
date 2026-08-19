package net.runelite.client.plugins.thieving;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("thievingplugin")
public interface ThievingConfig extends Config
{

	@ConfigItem(
		position = 1,
		keyName = "chestReadyIcon",
		name = "Ready Indicator",
		description = "What indication should display for a chest that is ready to loot"
	)
	default ChestOverlay.ChestReadyIndicator getChestReadyIndicator()
	{
		return ChestOverlay.ChestReadyIndicator.NONE;
	}

	@Alpha
	@ConfigItem(
		position = 2,
		keyName = "hexColorFullChest",
		name = "Full chest",
		description = "Color of full chest timer"
	)
	default Color getFullChestColor()
	{
		return Color.GREEN;
	}

	@Alpha
	@ConfigItem(
		position = 3,
		keyName = "hexColorPlunderedChest",
		name = "Plundered chest",
		description = "Color of plundered chest timer"
	)
	default Color getPlunderedChestColor()
	{
		return Color.RED;
	}

	@Alpha
	@ConfigItem(
		position = 4,
		keyName = "hexColorTransTrap",
		name = "Transitioning chest",
		description = "Color of transitioning chest timer"
	)
	default Color getTransChestColor()
	{
		return Color.ORANGE;
	}
}