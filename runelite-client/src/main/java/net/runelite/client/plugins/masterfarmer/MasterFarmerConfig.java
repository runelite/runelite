package net.runelite.client.plugins.masterfarmer;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("masterfarmerplugin")
public interface MasterFarmerConfig extends Config
{
	@Alpha
	@ConfigItem(
		keyName = "timerColor",
		name = "Color of timer",
		description = "Configures the color of the timer"
	)
	default Color timerColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "showOverlay",
		name = "Show timer over the master farmer",
		description = "Configures whether or not to have a timer over the master farmer"
	)
	default boolean showOverlay()
	{
		return true;
	}

	@Range(
		max = 300
	)
	@ConfigItem(
		keyName = "maxDisplay",
		name = "Time at which timer appears",
		description = "The maximum time at which the timer is displayed",
		position = 1
	)
	default int maxDisplay()
	{
		return 300;
	}

	@Range(
		max = 300
	)
	@ConfigItem(
		keyName = "timerHeight",
		name = "Height of timer",
		description = "Change the height of the timer above the master farmer",
		position = 1
	)
	default int timerHeight()
	{
		return 25;
	}
}
