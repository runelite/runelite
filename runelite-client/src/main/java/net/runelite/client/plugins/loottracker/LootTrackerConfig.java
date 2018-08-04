package net.runelite.client.plugins.loottracker;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
@ConfigGroup("lootTracker")
public interface LootTrackerConfig extends Config
{
	@ConfigItem(
			keyName = "highlightValue",
			name = "Highlight > Value",
			description = "Configures the minimum value for loot to be highlighted",
			position = 1
	)
	default int highlightValue()
	{
		return 10000;
	}

	@ConfigItem(
			keyName = "ignoreUnderValue",
			name = "Ignore < Value",
			description = "Configures the minimum value for loot to be added to the panel.",
			position = 2
	)
	default int getIgnoreUnderValue()
	{
		return 0;
	}
}