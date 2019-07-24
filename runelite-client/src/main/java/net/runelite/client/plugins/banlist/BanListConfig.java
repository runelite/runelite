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
		description = "Manually add players seperated by commas that you wish to be warned about while in a clan/cox/tob party",
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
		keyName = "enableWDRScam",
		name = "Enable WDR Scammer List",
		description = "Incorporate WDR Scammer list"
	)
	default boolean enableWDRScam()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "enableWDRToxic",
		name = "Enable WDR Toxic List",
		description = "Incorporate WDR Toxic list"
	)
	default boolean enableWDRToxic()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "enableRuneWatch",
		name = "Enable RuneWatch List",
		description = "Incorporate RuneWatch potential scammer list"
	)
	default boolean enableRuneWatch()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "highlightInClan",
		name = "Highlight red in Clan Chat",
		description = "Highlights Scammer\'s name in your current clan chat."
	)
	default boolean highlightInClan()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "highlightInTrade",
		name = "Highlight red in trade screen",
		description = "Highlights Scammer\'s name in your trade window"
	)
	default boolean highlightInTrade()
	{
		return true;
	}
}