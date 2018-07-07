package net.runelite.client.plugins.feed;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("It's coming home")
public interface FeedConfig extends Config
{
	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 0
	)
	default boolean includeBlogPosts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 1
	)
	default boolean includeTweets()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 2
	)
	default boolean includeOsrsNews()
	{
		return true;
	}
}
