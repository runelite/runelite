package net.runelite.client.plugins.worldswitcherfilter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "worldSwitcherFilter",
	name = "World Switcher Filter",
	description = "Configuration for the World Switcher Filter plugin"
)
public interface WorldSwitcherFilterConfig extends Config
{
	@ConfigItem(
		keyName = "hidePvp",
		name = "Hide PvP worlds",
		description = "Hides PvP worlds",
		position = 0
	)
	default boolean hidePvp()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDeadman",
		name = "Hide Deadman worlds",
		description = "Hides Deadman worlds",
		position = 1
	)
	default boolean hideDeadman()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideDeadmanSeasonal",
		name = "Hide Deadman seasonal worlds",
		description = "Hides Deadman seasonal worlds",
		position = 2
	)
	default boolean hideDeadmanSeasonal()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideF2p",
		name = "Hide F2P worlds",
		description = "Hides F2P worlds",
		position = 3
	)
	default boolean hideF2p()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideMembers",
		name = "Hide Member worlds",
		description = "Hides Member worlds",
		position = 4
	)
	default boolean hideMember()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideIneligibleTotal",
		name = "Hide ineligible total worlds",
		description = "Hides total level worlds you're not eligible for",
		position = 5
	)
	default boolean hideIneligibleTotal()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideUk",
		name = "Hide UK worlds",
		description = "Hides UK worlds",
		position = 6
	)
	default boolean hideUk()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideUsa",
		name = "Hide USA worlds",
		description = "Hides USA worlds",
		position = 7
	)
	default boolean hideUsa()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideAus",
		name = "Hide Australia worlds",
		description = "Hides Australia worlds",
		position = 8
	)
	default boolean hideAus()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideGermany",
		name = "Hide Germany worlds",
		description = "Hides Germany worlds",
		position = 9
	)
	default boolean hideGermany()
	{
		return false;
	}
}

