package net.runelite.client.plugins.banlist;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("banlist")

public interface BanListConfig extends Config
{

	@ConfigItem(
			keyName = "bannedPlayers",
			name = "Banned Players List",
			description = "manual entry ",
			position = 0

	)
	default String getBannedPlayers()
	{
		return "";
	}

	@ConfigItem(
			keyName = "bannedPlayers",
			name = "",
			description = ""
	)
	void setBannedPlayers(String key);

	@ConfigItem(
			position = 1,
			keyName = "enableWDR",
			name = "use WDR list",
			description = "Incorporate WDR ban list"
	)
	default boolean enableWDR()
	{
		return true;
	}

	@ConfigItem(
			position = 2,
			keyName = "enableRuneWatch",
			name = "use RuneWatch list",
			description = "Incorporate RuneWatch Ban list"
	)
	default boolean enableRuneWatch()
	{
		return true;
	}

}
