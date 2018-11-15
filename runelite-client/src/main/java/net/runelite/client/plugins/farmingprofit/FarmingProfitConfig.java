package net.runelite.client.plugins.farmingprofit;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("farmingProfit")
public interface FarmingProfitConfig extends Config
{
	@ConfigItem(
		keyName = "trackAllotments",
		name = "Track allotment patches",
		description = "Track profit made of allotment patches",
		position = 0
	)
	default boolean trackAllotments()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trackHerbs",
		name = "Track herb patches",
		description = "Track profit made of herb patches",
		position = 0
	)
	default boolean trackHerbs()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trackHops",
		name = "Track hops patches",
		description = "Track profit made of hops patches",
		position = 0
	)
	default boolean trackHops()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trackBushes",
		name = "Track bush patches",
		description = "Track profit made of bush patches",
		position = 0
	)
	default boolean trackBushes()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trackSpecial",
		name = "Track special patches",
		description = "Track profit made of the special patches, cactus and seaweed",
		position = 0
	)
	default boolean trackSpecial()
	{
		return true;
	}
}
