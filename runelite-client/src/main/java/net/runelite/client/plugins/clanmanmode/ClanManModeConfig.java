package net.runelite.client.plugins.clanmanmode;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("clanmanmode")
public interface ClanManModeConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "highlightattackable",
		name = "Highlight attackable targets",
		description = "Highlights targets attackable by all clan members"
	)
	default boolean highlightAttackable()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "attackablecolor",
		name = "Attackable target c olor",
		description = "Color of targets all clan members can target"
	)
	default Color getAttackableColor()
	{
		return new Color(0, 184, 212);
	}

	@ConfigItem(
		position = 2,
		keyName = "highlightattacked",
		name = "Highlight clan targets",
		description = "Highlights people being attacked by your clan"
	)
	default boolean highlightAttacked()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "attackedcolor",
		name = "Clan target color",
		description = "Color of players being attacked by clan"
	)
	default Color getClanAttackableColor()
	{
		return new Color(0, 184, 212);
	}

	@ConfigItem(
		position = 4,
		keyName = "drawPlayerTiles",
		name = "Draw tiles under players",
		description = "Configures whether or not tiles under highlighted players should be drawn"
	)
	default boolean drawTiles()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "drawOverheadPlayerNames",
		name = "Draw names above players",
		description = "Configures whether or not player names should be drawn above players"
	)
	default boolean drawOverheadPlayerNames()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "drawMinimapNames",
		name = "Draw names on minimap",
		description = "Configures whether or not minimap names for players with rendered names should be drawn"
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "showtargets",
		name = "Highlight My Attackers",
		description = "Shows players interacting with you"
	)
	default boolean showAttackers()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "attackcolor",
		name = "Attacker Color",
		description = "Color of attackers"
	)
	default Color getAttackerColor()
	{
		return new Color(255, 0, 0);
	}

	@ConfigItem(
		position = 9,
		keyName = "showbold",
		name = "Bold names of clan targets",
		description = "Turns names of clan targets bold"
	)
	default boolean ShowBold()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "hideafter",
		name = "Hide attackable targets after login",
		description = "Automatically disables attackable player highlighting after login"
	)
	default boolean hideAttackable()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "hidetime",
		name = "Ticks to hide",
		description = "How many ticks after you are logged in that attackbles are hidden (1 tick = 0.6 seconds)"
	)
	@Units(Units.TICKS)
	default int hideTime()
	{
		return 5;
	}

	@ConfigItem(
		position = 12,
		keyName = "mycblvl",
		name = "Calc targets on my own combat level",
		description = "Calculates potential targets based off your own combat lvl instead of clans"
	)
	default boolean CalcSelfCB()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "showclanmembers",
		name = "Persistent Clan Members",
		description = "Will highlight clan members even when not in clan chat"
	)
	default boolean PersistentClan()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "clancolor",
		name = "Clan Member Color",
		description = "Color of clan members"
	)
	default Color getClanMemberColor()
	{
		return new Color(255, 0, 0);
	}
}
