package net.runelite.client.plugins.banlist;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("banlist")

public interface BanListConfig extends Config
{
	@ConfigTitleSection(
		keyName = "listsTitle",
		name = "Lists",
		description = "",
		position = 0
	)
	default Title listsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "bannedPlayers",
		name = "Manual Scammer List",
		description = "Manually add players seperated by commas that you wish to be warned about while in a clan/cox/tob party",
		position = 1,
		titleSection = "listsTitle"
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
		position = 2,
		keyName = "enableWDRScam",
		name = "Enable WDR Scammer List",
		description = "Incorporate WDR Scammer list",
		titleSection = "listsTitle"
	)
	default boolean enableWDRScam()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "enableWDRToxic",
		name = "Enable WDR Toxic List",
		description = "Incorporate WDR Toxic list",
		titleSection = "listsTitle"
	)
	default boolean enableWDRToxic()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "enableRuneWatch",
		name = "Enable RuneWatch List",
		description = "Incorporate RuneWatch potential scammer list",
		titleSection = "listsTitle"
	)
	default boolean enableRuneWatch()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "highlightTitle",
		name = "Highlight",
		description = "",
		position = 5
	)
	default Title highlightTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 6,
		keyName = "highlightInClan",
		name = "Highlight red in Clan Chat",
		description = "Highlights Scammer\'s name in your current clan chat.",
		titleSection = "highlightTitle"
	)
	default boolean highlightInClan()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "highlightInTrade",
		name = "Highlight red in trade screen",
		description = "Highlights Scammer\'s name in your trade window",
		titleSection = "highlightTitle"
	)
	default boolean highlightInTrade()
	{
		return true;
	}
}