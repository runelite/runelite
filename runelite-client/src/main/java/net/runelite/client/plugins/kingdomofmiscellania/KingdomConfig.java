package net.runelite.client.plugins.kingdomofmiscellania;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "kingdom",
	name = "Kingdom of Miscellania",
	description = "Configuration for Kingdom of Miscellania plugin"
)
public interface KingdomConfig extends Config
{
	@ConfigItem(
		keyName = "showOnlyInKingdom",
		name = "Show Only in Kingdom",
		description = "Configures whether or not to display kingdom information only when in kingdom",
		position = 1
	)
	default boolean showOnlyInKingdom()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWhenLow",
		name = "Show When Low Favor or Coffer",
		description = "Configures whether or not to display kingdom information when favor or coffer is low",
		position = 2
	)
	default boolean showWhenLow()
	{
		return true;
	}

	@ConfigItem(
		keyName = "favorLessThanValue",
		name = "Alert if favor % below",
		description = "Configures display kingdom information when favor less than value",
		position = 3
	)
	default int favorLessThanValue()
	{
		return 95;
	}

	@ConfigItem(
		keyName = "cofferLessThanValue",
		name = "Alert if coffer below",
		description = "Configures display kingdom information when coffer less than value",
		position = 4
	)
	default int cofferLessThanValue()
	{
		return 1000000;
	}
}