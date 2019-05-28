package net.runelite.client.plugins.banlist;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("banlist")

public interface BanListConfig extends Config
{

	@ConfigItem(
			keyName = "bannedPlayers",
			name = "Manual Scammer List",
			description = "Players you add to this list will be shown when you join a clan.",
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
			name = "Enable WDR Scammer List",
			description = "Incorporate WDR Scammer list"
	)
	default boolean enableWDR()
	{
		return true;
	}

	@ConfigItem(
			position = 2,
			keyName = "enableRuneWatch",
			name = "Enable RuneWatch Scammer List",
			description = "Incorporate RuneWatch Scammer list"
	)
	default boolean enableRuneWatch()
	{
		return true;
	}

}
