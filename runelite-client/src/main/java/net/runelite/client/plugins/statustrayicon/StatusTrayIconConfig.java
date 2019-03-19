package net.runelite.client.plugins.statustrayicon;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("statustrayicon")
public interface StatusTrayIconConfig extends Config
{
	@ConfigItem(
		keyName = "showHitpoints",
		name = "Show hitpoints",
		description = "Shows current hitpoints on the system tray"
	)
	default boolean showHitpoints()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPrayer",
		name = "Show prayer",
		description = "Shows current prayer on the system tray"
	)
	default boolean showPrayer()
	{
		return false;
	}

	@ConfigItem(
		keyName = "numberToDisplay",
		name = "Number to display",
		description = "Shows the selected number on the system tray"
	)
	default StatusNumberMode numberToDisplay()
	{
		return StatusNumberMode.HITPOINTS;
	}
}
