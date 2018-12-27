package net.runelite.client.plugins.collapsemenuentries;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup("collapsemenuentries")
public interface CollapseMenuEntriesConfig extends Config {

	@ConfigItem(
			position = 1,
			keyName = "showDuplicate",
			name = "Count duplicates",
			description = "Shows the number of times this option would appear i.e. \"Take Logs (x14)\"."
	)
	default boolean showNumber() { return true; }

	@ConfigItem(
			position = 2,
			keyName = "collapsedColour",
			name = "Duplicates colour",
			description = "The colour of the duplicate count string (if enabled)."
	)
	default Color collapsedColour() { return new Color(255, 255, 255); }
}