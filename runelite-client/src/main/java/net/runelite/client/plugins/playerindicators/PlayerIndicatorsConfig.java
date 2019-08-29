/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.playerindicators;

import java.awt.Color;
import java.util.EnumSet;
import net.runelite.api.ClanMemberRank;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Stub;

@ConfigGroup("playerindicators")
public interface PlayerIndicatorsConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "drawOwnName",
		name = "Highlight own player",
		description = "Configures whether or not your own player should be highlighted",
		group = "Yourself"
	)
	default boolean highlightOwnPlayer()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "ownNameColor",
		name = "Own player color",
		description = "Color of your own player",
		group = "Yourself"
	)
	default Color getOwnPlayerColor()
	{
		return new Color(0, 184, 212);
	}

	@ConfigItem(
		position = 2,
		keyName = "selfIndicatorModes",
		name = "Indicator Mode",
		description = "Location(s) of the overlay",
		group = "Yourself",
		enumClass = PlayerIndicationLocation.class
	)
	default EnumSet<PlayerIndicationLocation> selfIndicatorModes()
	{
		return EnumSet.allOf(PlayerIndicationLocation.class);
	}

	@ConfigItem(
		position = 3,
		keyName = "drawFriendNames",
		name = "Highlight friends",
		description = "Configures whether or not friends should be highlighted",
		group = "Friends"
	)
	default boolean highlightFriends()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "friendNameColor",
		name = "Friend color",
		description = "Color of friend names",
		group = "Friends"
	)
	default Color getFriendColor()
	{
		return new Color(0, 200, 83);
	}

	@ConfigItem(
		position = 5,
		keyName = "friendIndicatorMode",
		name = "Indicator Mode",
		description = "Location(s) of the overlay",
		group = "Friends",
		enumClass = PlayerIndicationLocation.class

	)
	default EnumSet<PlayerIndicationLocation> friendIndicatorMode()
	{
		return EnumSet.allOf(PlayerIndicationLocation.class);
	}

	@ConfigItem(
		position = 6,
		keyName = "highlightClan",
		name = "Highlight clan members",
		description = "Configures whether or clan members should be highlighted",
		group = "Clan"
	)
	default boolean highlightClan()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "clanMemberColor",
		name = "Clan member color",
		description = "Color of clan members",
		group = "Clan"
	)
	default Color getClanColor()
	{
		return new Color(170, 0, 255);
	}

	@ConfigItem(
		position = 8,
		keyName = "clanIndicatorModes",
		name = "Indicator Mode",
		description = "Location(s) of the overlay",
		group = "Clan",
		enumClass = PlayerIndicationLocation.class

	)
	default EnumSet<PlayerIndicationLocation> clanIndicatorModes()
	{
		return EnumSet.allOf(PlayerIndicationLocation.class);
	}

	@ConfigItem(
		position = 9,
		keyName = "clanMenuIcons",
		name = "Show clan ranks",
		description = "Add clan rank to right click menu and next to player names",
		group = "Clan"
	)
	default boolean showClanRanks()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "drawTeamMemberNames",
		name = "Highlight team members",
		description = "Configures whether or not team members should be highlighted",
		group = "Team"
	)
	default boolean highlightTeamMembers()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "teamMemberColor",
		name = "Team member color",
		description = "Color of team members",
		group = "Team"
	)
	default Color getTeamcolor()
	{
		return new Color(19, 110, 247);
	}

	@ConfigItem(
		position = 12,
		keyName = "teamIndicatorModes",
		name = "Indicator Mode",
		description = "Location(s) of the overlay",
		group = "Team",
		enumClass = PlayerIndicationLocation.class

	)
	default EnumSet<PlayerIndicationLocation> teamIndicatorModes()
	{
		return EnumSet.allOf(PlayerIndicationLocation.class);
	}

	@ConfigItem(
		position = 13,
		keyName = "drawTargetsNames",
		name = "Highlight attackable targets",
		description = "Configures whether or not attackable targets should be highlighted",
		group = "Target"
	)
	default boolean highlightTargets()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "targetColor",
		name = "Target member color",
		description = "Color of attackable targets",
		group = "Target"
	)
	default Color getTargetsColor()
	{
		return new Color(19, 110, 247);
	}

	@ConfigItem(
		position = 15,
		keyName = "targetsIndicatorModes",
		name = "Indicator Mode",
		description = "Location(s) of the overlay",
		group = "Target",
		enumClass = PlayerIndicationLocation.class

	)
	default EnumSet<PlayerIndicationLocation> targetsIndicatorModes()
	{
		return EnumSet.allOf(PlayerIndicationLocation.class);
	}

	@ConfigItem(
		position = 16,
		keyName = "showAgility",
		name = "Show Agility Levels",
		description = "Show the agility level of attackable players next to their name while in the wilderness.",
		group = "Target"
	)
	default boolean showAgilityLevel()
	{
		return false;
	}

	@ConfigItem(
		position = 17,
		keyName = "agilityFormat",
		name = "Format",
		description = "Whether to show the agility level as text, or as icons (1 skull >= 1st threshold, 2 skulls >= 2nd threshold).",
		group = "Target"
	)
	default PlayerIndicatorsPlugin.AgilityFormats agilityFormat()
	{
		return PlayerIndicatorsPlugin.AgilityFormats.TEXT;
	}

	@ConfigItem(
		position = 18,
		keyName = "agilityFirstThreshold",
		name = "First Threshold",
		description = "When showing agility as icons, show one icon for agility >= this level.",
		group = "Target"
	)
	default int agilityFirstThreshold()
	{
		return 70;
	}

	@ConfigItem(
		position = 19,
		keyName = "agilitySecondThreshold",
		name = "Second Threshold",
		description = "When showing agility as icons, show two icons for agility >= this level.",
		group = "Target"
	)
	default int agilitySecondThreshold()
	{
		return 84;
	}

	@ConfigItem(
		position = 20,
		keyName = "playerSkull",
		name = "Show Skull Information",
		description = "shows",
		group = "Target"
	)
	default boolean playerSkull()
	{
		return false;
	}

	@ConfigItem(
		position = 21,
		keyName = "minimapSkullLocation",
		name = "Skull Icon Location",
		description = "The location of the skull icon for skulled players",
		group = "Target"
	)
	default PlayerIndicatorsPlugin.MinimapSkullLocations skullLocation()
	{
		return PlayerIndicatorsPlugin.MinimapSkullLocations.AFTER_NAME;
	}

	@ConfigItem(
		position = 22,
		keyName = "targetRisk",
		name = "Indicate Target Risk",
		description = "Indicates the risk (in K GP) of the target",
		group = "Target"
	)
	default boolean targetRisk()
	{
		return false;
	}

	@ConfigItem(
		position = 23,
		keyName = "showCombat",
		name = "Show Combat Levels",
		description = "Show the combat level of attackable players next to their name.",
		group = "Target"
	)
	default boolean showCombatLevel()
	{
		return false;
	}

	@ConfigItem(
		position = 24,
		keyName = "drawOtherPlayerNames",
		name = "Highlight other players",
		description = "Configures whether or not other players should be highlighted",
		group = "Other"
	)
	default boolean highlightOtherPlayers()
	{
		return false;
	}

	@ConfigItem(
		position = 25,
		keyName = "otherPlayerColor",
		name = "Other player color",
		description = "Color of other players' names",
		group = "Other"
	)
	default Color getOtherColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 26,
		keyName = "otherIndicatorModes",
		name = "Indicator Mode",
		description = "Location(s) of the overlay",
		group = "Other",
		enumClass = PlayerIndicationLocation.class

	)
	default EnumSet<PlayerIndicationLocation> otherIndicatorModes()
	{
		return EnumSet.allOf(PlayerIndicationLocation.class);
	}


	@ConfigItem(
		position = 11,
		keyName = "playerNamePosition",
		name = "Name position",
		description = "Configures the position of drawn player names, or if they should be disabled",
		parent = "Other Settings"
	)
	default PlayerNameLocation playerNamePosition()
	{
		return PlayerNameLocation.ABOVE_HEAD;
	}

	@ConfigItem(
		position = 5,
		keyName = "callerConfiguration",
		name = "Caller Configuration",
		description = "",
		group = "Callers"
	)
	default Stub callerConfiguration()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 30,
		keyName = "highlightCallers",
		name = "Highlight Callers",
		description = "Highlights Callers Onscreen",
		group = "Callers",
		parent = "callerConfiguration"
	)
	default boolean highlightCallers()
	{
		return false;
	}

	@ConfigItem(
		position = 31,
		keyName = "useClanchatRanks",
		name = "Use Ranks as Callers",
		description = "Uses clanchat ranks as the list of callers",
		group = "Callers",
		parent = "callerConfiguration"
	)
	default boolean useClanchatRanks()
	{
		return false;
	}

	@ConfigItem(
		position = 32,
		keyName = "callerRank",
		name = "Minimum rank for Clan Caller",
		description = "Chooses the minimum rank to use as clanchat callers.",
		group = "Callers",
		parent = "callerConfiguration"
	)
	default ClanMemberRank callerRank()
	{
		return ClanMemberRank.CAPTAIN;
	}

	@ConfigItem(
		position = 33,
		keyName = "callers",
		name = "List of callers to highlight",
		description = "Highlights callers, only highlights one at a time. Separate each entry with a comma and enter" +
			" in the order you want them highlighted.",
		group = "Callers",
		parent = "callerConfiguration"
	)
	default String callers()
	{
		return " ";
	}

	@ConfigItem(
		position = 5,
		keyName = "callerIndicators",
		name = "Caller Indicators",
		description = "",
		group = "Callers"
	)
	default Stub callerIndicators()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 31,
		keyName = "callerColor",
		name = "Caller Color",
		description = "Color of Indicated Callers",
		group = "Callers",
		parent = "callerIndicators"
	)
	default Color callerColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		position = 32,
		keyName = "callerHighlightOptions",
		name = "Caller indication methods",
		description = "Location(s) of the overlay",
		group = "Callers",
		parent = "callerIndicators",
		enumClass = PlayerIndicationLocation.class
	)
	default EnumSet<PlayerIndicationLocation> callerHighlightOptions()
	{
		return EnumSet.allOf(PlayerIndicationLocation.class);
	}

	@ConfigItem(
		position = 5,
		keyName = "callerTargetIndicators",
		name = "Caller Target Indicators",
		description = "",
		group = "Callers"
	)
	default Stub callerTargetIndicators()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 33,
		keyName = "callersTargets",
		name = "Calllers' targets",
		description = "Highlights the targets of callers",
		group = "Callers",
		parent = "callerTargetIndicators"
	)
	default boolean callersTargets()
	{
		return true;
	}

	@ConfigItem(
		position = 34,
		keyName = "callerTargetColor",
		name = "Callers' targets color",
		description = "Color of the the targets of callers",
		group = "Callers",
		parent = "callerTargetIndicators"
	)
	default Color callerTargetColor()
	{
		return Color.WHITE.darker();
	}

	@ConfigItem(
		position = 35,
		keyName = "callerTargetHighlightOptions",
		name = "Pile indication methods",
		description = "How to highlight the callers' target",
		group = "Callers",
		parent = "callerTargetIndicators",
		enumClass = PlayerIndicationLocation.class
	)
	default EnumSet<PlayerIndicationLocation> callerTargetHighlightOptions()
	{
		return EnumSet.allOf(PlayerIndicationLocation.class);
	}


	@ConfigItem(
		position = 36,
		keyName = "unchargedGlory",
		name = "Uncharged Glory Indication",
		description = "Indicates if players have an uncharged glory",
		parent = "Other Settings"
	)
	default boolean unchargedGlory()
	{
		return false;
	}

}
