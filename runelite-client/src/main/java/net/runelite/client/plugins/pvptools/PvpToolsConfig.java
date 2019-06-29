/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.pvptools;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("pvptools")
public interface PvpToolsConfig extends Config
{
	@ConfigItem(
		keyName = "countPlayers",
		name = "Count Players",
		description = "When in PvP zones, counts the attackable players in and not in player's CC",
		position = 0
	)
	default boolean countPlayers()
	{
		return true;
	}

	@ConfigItem(
		keyName = "countOverHeads",
		name = "Count Enemy Overheads",
		description = "Counts the number of each protection prayer attackable targets not in your CC are currently using",
		position = 1
	)
	default boolean countOverHeads()
	{
		return true;
	}

	@ConfigItem(
		keyName = "fallInHelper",
		name = "Fall In Helper",
		description = "Hides all non-friendly player entities other than the one that is attacking you.",
		position = 2
	)
	default boolean fallInHelper()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hotkey",
		name = "Fall In Hotkey",
		description = "Turns the fall in helper on or off when you press this hotkey",
		position = 3
	)
	default Keybind hotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(
		keyName = "renderSelfHotkey",
		name = "Render Self Hotkey",
		description = "Toggles renderself when you press the hotkey",
		position = 4
	)
	default Keybind renderSelf()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(
		keyName = "hideAttack",
		name = "Hide attack",
		description = "Hides the attack option for clanmates, friends, or both",
		position = 5,
		group = "Right-Click Attack Options"
	)
	default boolean hideAttack()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideAttackMode",
		name = "Mode",
		description = "",
		position = 6,
		group = "Right-Click Attack Options",
		hidden = true,
		unhide = "hideAttack"
	)
	default AttackMode hideAttackMode()
	{
		return AttackMode.FRIENDS;
	}

	@ConfigItem(
		keyName = "hideCast",
		name = "Hide cast",
		description = "Hides the cast option for clanmates, friends, or both",
		position = 7,
		group = "Right-Click Attack Options"
	)
	default boolean hideCast()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideCastMode",
		name = "Mode",
		description = "",
		position = 8,
		group = "Right-Click Attack Options",
		hidden = true,
		unhide = "hideCast"
	)
	default AttackMode hideCastMode()
	{
		return AttackMode.FRIENDS;
	}

	@ConfigItem(
		keyName = "hideCastIgnored",
		name = "Ignored spells",
		description = "Spells that should not be hidden from being cast, separated by a comma",
		position = 9,
		group = "Right-Click Attack Options",
		hidden = true,
		unhide = "hideCast"
	)
	default String hideCastIgnored()
	{
		return "cure other, energy transfer, heal other, vengeance other";
	}

	@ConfigItem(
		keyName = "attackOptionsClan",
		name = "Move CC Attack Option",
		description = "Moves the attack option for people in the same CC",
		position = 10,
		group = "Right-Click Attack Options"
	)
	default boolean attackOptionsClan()
	{
		return false;
	}

	@ConfigItem(
		keyName = "attackOptionsFriend",
		name = "Move Friend Attack Options",
		description = "Moves the attack option for people on your friends list",
		position = 11,
		group = "Right-Click Attack Options"
	)
	default boolean attackOptionsFriend()
	{
		return false;
	}

	@ConfigItem(
		keyName = "levelRangeAttackOptions",
		name = "Moves Other Attack Options",
		description = "Moves the attack option for people that are outside your level range",
		position = 12,
		group = "Right-Click Attack Options"
	)
	default boolean levelRangeAttackOptions()
	{
		return false;
	}

	@ConfigItem(
		keyName = "riskCalculator",
		name = "Risk Calculator",
		description = "Enables a panel in the PvP Tools Panel that shows the players current risk",
		position = 13
	)
	default boolean riskCalculatorEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "missingPlayers",
		name = "Missing CC Players",
		description = "Adds a button to the PvP Tools panel that opens a window showing which CC members are not at the current players location",
		position = 14
	)
	default boolean missingPlayersEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "currentPlayers",
		name = "Current CC Players",
		description = "Adds a button to the PvP Tools panel that opens a window showing which CC members currently at the players location",
		position = 15
	)
	default boolean currentPlayersEnabled()
	{
		return true;
	}

}
