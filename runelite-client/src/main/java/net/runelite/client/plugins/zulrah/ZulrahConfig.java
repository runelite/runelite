package net.runelite.client.plugins.zulrah;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("zulrah")
public interface ZulrahConfig extends Config {
	@ConfigItem(
		position = 0,
		keyName = "zulrahenable",
		name = "Enable Zulrah Helper",
		description = "Configures whether or not to enable Zulrah Helper."
	)
	default boolean EnableZulrah() { return true; }

	@ConfigItem(
			position = 1,
			keyName = "zulrahprayenable",
			name = "Show Prayer Helper",
			description = "Configures whether or not to show when to pray at Zulrah."
	)
	default boolean EnableZulrahPrayerHelper() { return true; }
}
