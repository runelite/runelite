package net.runelite.client.plugins.massdigger;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("massDigger")
public interface MassDiggerConfig extends Config
{
	@ConfigItem(
		keyName = "showDigLocations",
		name = "Show dig locations",
		description = "Highlights the tiles where you should dig",
		position = 1
	)
	default boolean showDigLocations()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDugAreas",
		name = "Show dug areas (slow)",
		description = "Highlights the dug areas. Note: This functionality uses a lot of processing power when the dug area has a lot of verticies.",
		position = 2
	)
	default boolean showDugAreas()
	{
		return false;
	}

	@ConfigItem(
		keyName = "colorAlpha",
		name = "Alpha",
		description = "Alpha of colors in range 0-255.",
		position = 3
	)
	default int alpha()
	{
		return 255;
	}
}
