package net.runelite.client.plugins.clock;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.FontType;
import net.runelite.client.plugins.clock.config.HourFormat;

@ConfigGroup("clock")
public interface ClockConfig extends Config
{
	@ConfigItem(
		keyName = "showMilliseconds",
		name = "Milliseconds",
		description = "Show milliseconds",
		position = 1
	)
	default boolean showMilliseconds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hourFormat",
		name = "Hour Format",
		description = "Display 12-hour vs 24-hour",
		position = 2
	)
	default HourFormat hourFormat()
	{
		return HourFormat.TWELVE;
	}

	@ConfigItem(
		keyName = "font",
		name = "Font",
		description = "Clock font",
		position = 3
	)
	default FontType font()
	{
		return FontType.REGULAR;
	}
}
