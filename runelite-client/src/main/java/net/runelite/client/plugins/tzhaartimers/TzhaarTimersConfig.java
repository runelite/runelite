package net.runelite.client.plugins.tzhaartimers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("tzhaartimersconfig")
public interface TzhaarTimersConfig extends Config
{
	@ConfigItem(
		keyName = "fightcaves",
		name = "Fight Caves",
		description = "Time your Fight Caves runs",
		position = 1
	)

	default boolean fightcaves()
	{
		return true;
	}

	@ConfigItem(
		keyName = "inferno",
		name = "Inferno",
		description = "Time your Inferno runs",
		position = 2
	)
	default boolean inferno()
	{
		return true;
	}
}
