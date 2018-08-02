package net.runelite.client.plugins.loottracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("lootTracker")
public interface LootTrackerConfig extends Config
{

	@ConfigItem(
		keyName = "ignoreUnderValue",
		name = "Ignore < Value",
		description = "Configures the minimum value for loot to show up, set to 0 to show all loot",
		position = 1
	)
	default int getIgnoreUnderValue()
	{
		return 0;
	}

}
