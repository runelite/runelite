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
import net.runelite.api.ClanMemberRank;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("playerindicators")
public interface PlayerIndicatorsConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "drawOwnName",
		name = "Highlight own player",
		description = "Configures whether or not your own player should be highlighted"
	)
	default boolean highlightOwnPlayer()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "ownNameColor",
		name = "Own player color",
		description = "Color of your own player"
	)
	default Color getOwnPlayerColor()
	{
		return new Color(0, 184, 212);
	}

	@ConfigItem(
		position = 2,
		keyName = "drawFriendNames",
		name = "Highlight friends",
		description = "Configures whether or not friends should be highlighted"
	)
	default boolean highlightFriends()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "friendNameColor",
		name = "Friend color",
		description = "Color of friend names"
	)
	default Color getFriendColor()
	{
		return new Color(0, 200, 83);
	}

	@ConfigItem(
		position = 4,
		keyName = "drawClanMemberNames",
		name = "Highlight clan members",
		description = "Configures whether or clan members should be highlighted"
	)
	default boolean drawClanMemberNames()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "clanMemberColor",
		name = "Clan member color",
		description = "Color of clan members"
	)
	default Color getClanMemberColor()
	{
		return new Color(170, 0, 255);
	}

	@ConfigItem(
		position = 6,
		keyName = "drawTeamMemberNames",
		name = "Highlight team members",
		description = "Configures whether or not team members should be highlighted"
	)
	default boolean highlightTeamMembers()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "teamMemberColor",
		name = "Team member color",
		description = "Color of team members"
	)
	default Color getTeamMemberColor()
	{
		return new Color(19, 110, 247);
	}

	@ConfigItem(
		position = 8,
		keyName = "drawNonClanMemberNames",
		name = "Highlight non-clan members",
		description = "Configures whether or not non-clan members should be highlighted"
	)
	default boolean highlightNonClanMembers()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "nonClanMemberColor",
		name = "Non-clan member color",
		description = "Color of non-clan member names"
	)
	default Color getNonClanMemberColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 10,
		keyName = "drawPlayerTiles",
		name = "Draw tiles under players",
		description = "Configures whether or not tiles under highlighted players should be drawn"
	)
	default boolean drawTiles()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "playerNamePosition",
		name = "Name position",
		description = "Configures the position of drawn player names, or if they should be disabled"
	)
	default PlayerNameLocation playerNamePosition()
	{
		return PlayerNameLocation.ABOVE_HEAD;
	}
	
	@ConfigItem(
		position = 12,
		keyName = "drawMinimapNames",
		name = "Draw names on minimap",
		description = "Configures whether or not minimap names for players with rendered names should be drawn",
		group = "Minimap"
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "drawFriendMinimapNames",
		name = "Draw Friendnames on minimap",
		description = "Configures whether or not minimap names for Friends with rendered names should be drawn",
		group = "Minimap",
		hidden = true,
		unhide = "drawMinimapNames"
	)
	default boolean drawFriendMinimapNames()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "drawClanMinimapNames",
		name = "Draw clan Friend names on minimap",
		description = "Configures whether or not minimap names for Clan Members with rendered names should be drawn",
		group = "Minimap",
		hidden = true,
		unhide = "drawMinimapNames"
	)
	default boolean drawClanMinimapNames()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "colorPlayerMenu",
		name = "Colorize player menu",
		description = "Color right click menu for players"
	)
	default boolean colorPlayerMenu()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "clanMenuIcons",
		name = "Show clan ranks",
		description = "Add clan rank to right click menu and next to player names"
	)
	default boolean showClanRanks()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "highlightTargets",
		name = "Highlight attackable players in wilderness on the minimap",
		description = "Highlights players on the minimap that the current player can attack based on combat/wilderness levels",
		group = "Target Indicator"
	)
	default boolean highlightTargets()
	{
		return false;
	}

//	@ConfigItem(
//		position = 16,
//		keyName = "highlightOverheadTargets",
//		name = "Highlights attackable players over their head",
//		description = "Highlights players over their head that the current player can attack based on combat/wilderness levels",
//		group = "Target Indicator"
//	)
//	default boolean highlightOverheadTargets()
//	{
//		return false;
//	}

	@ConfigItem(
		position = 17,
		keyName = "targetColor",
		name = "Target color",
		description = "Color of attackable targets",
		group = "Target Indicator"
	)
	default Color getTargetColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 18,
		keyName = "showCombat",
		name = "Show Combat Levels",
		description = "Show the combat level of attackable players next to their name.",
		group = "Target Indicator"
	)
	default boolean showCombatLevel()
	{
		return false;
	}

	@ConfigItem(
		position = 19,
		keyName = "playerSkull",
		name = "Show Skull Information",
		description = "Indicate of the player is skulled.",
		group = "Target Indicator"
	)
	default boolean playerSkull()
	{
		return false;
	}

	@ConfigItem(
		position = 19,
		keyName = "minimapSkullLocation",
		name = "Skull Icon Location",
		description = "The location of the skull icon for skulled players",
		group = "Target Indicator"
	)
	default PlayerIndicatorsPlugin.MinimapSkullLocations skullLocation()
	{
		return PlayerIndicatorsPlugin.MinimapSkullLocations.AFTER_NAME;
	}

	@ConfigItem(
		position = 19,
		keyName = "skulledTargetsOnly",
		name = "Tag Skulls Only",
		description = "Only indicate skulled targets (which are also attackable)",
		group = "Target Indicator"
	)
	default boolean skulledTargetsOnly()
	{
		return false;
	}

	@ConfigItem(
		position = 19,
		keyName = "targetRisk",
		name = "Indicate Target Risk",
		description = "Indicates the risk (in K GP) of the target",
		group = "Target Indicator"
	)
	default boolean targetRisk()
	{
		return false;
	}
	
/*	@ConfigItem(
			position = 23,
			keyName = "rightClickOverhead",
			name = "Add Overheads to Right Click Menu",
			description = "Feature shows a player's overhead prayer in the right click menu. Useful for DDs, or extremely crowded areas."
	)
	default boolean rightClickOverhead()
	{
		return false;
	}*/

	@ConfigItem(
		keyName = "useClanchatRanks",
		name = "Use Ranks as Callers",
		description = "Uses clanchat ranks as the list of callers",
		group = "Callers",
		position = 24
	)
	default boolean useClanchatRanks()
	{
		return false;
	}

	@ConfigItem(
		keyName = "callerRank",
		name = "Minimum rank for Clan Caller",
		description = "Chooses the minimum rank to use as clanchat callers.",
		group = "Callers",
		position = 25
	)
	default ClanMemberRank callerRank()
	{
		return ClanMemberRank.CAPTAIN;
	}

	@ConfigItem(
		keyName = "callers",
		name = "List of callers to highlight",
		description = "Highlights callers, only highlights one at a time. Separate each entry with a comma and enter" +
			" in the order you want them highlighted.",
		group = "Callers"
	)
	default String callers()
	{
		return " ";
	}

	@ConfigItem(
		keyName = "highlightCallers",
		name = "Highlight Callers",
		description = "Highlights Callers Onscreen",
		group = "Callers"
	)
	default boolean highlightCallers()
	{
		return false;
	}

	@ConfigItem(
		position = 26,
		keyName = "callerColor",
		name = "Caller Color",
		description = "Color of Indicated Callers",
		group = "Callers"
	)
	default Color callerColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		position = 27,
		keyName = "unchargedGlory",
		name = "Uncharged Glory Indication",
		description = "Indicates if players have an uncharged glory"
	)
	default boolean unchargedGlory()
	{
		return false;
	}

}
