package net.runelite.client.plugins.runecraftingtracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("RunecraftingTracker")
public interface RunecraftingTrackerConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "statTimeout",
		name = "Hide stats (minutes)",
		description = "Configures the time until indicator is hidden."
	)
	default int statTimeout()
	{
		return 5;
	}


	@ConfigItem(
		position = 3,
		keyName = "showRunecraftingStats",
		name = "Show session stats",
		description = "Configures whether to display runecrafting session stats"
	)
	default boolean showRunecraftingStats()
	{
		return true;
	}
}