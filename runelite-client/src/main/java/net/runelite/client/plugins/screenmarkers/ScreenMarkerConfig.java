package net.runelite.client.plugins.screenmarkers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("screenmarkers")
public interface ScreenMarkerConfig extends Config
{
	@ConfigItem(
		keyName = "hotkey",
		name = "Screen Marker Hotkey",
		description = "Press to create and finish drawing a screen marker",
		position = 0
	)
	default Keybind hotkey()
	{
		return Keybind.NOT_SET;
	}
}
