/*
 * Copyright (c) 2018, Kamiel
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.raids;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("raids")
public interface RaidsConfig extends Config
{
	@ConfigTitleSection(
		keyName = "scouterConfig",
		name = "Scouter Config",
		description = "",
		position = 0
	)
	default Title scouterConfig()
	{
		return new Title();
	}


	@ConfigItem(
		position = 1,
		titleSection = "scouterConfig",
		keyName = "enhanceScouterTitle",
		name = "Enhance scouter title",
		description = "Adds #combat and good puzzles to scouter title"
	)
	default boolean enhanceScouterTitle()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		titleSection = "scouterConfig",
		keyName = "hideBackground",
		name = "Hide Scouter Background",
		description = "Removes the scouter background, and makes it transparent."
	)
	default boolean hideBackground()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		titleSection = "scouterConfig",
		keyName = "raidsTimer",
		name = "Display elapsed raid time",
		description = "Display elapsed raid time"
	)
	default boolean raidsTimer()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		titleSection = "scouterConfig",
		keyName = "pointsMessage",
		name = "Display points in chatbox after raid",
		description = "Display a message with total points, individual points and percentage at the end of a raid"
	)
	default boolean pointsMessage()
	{
		return true;
	}


	@ConfigItem(
		position = 4,
		titleSection = "scouterConfig",
		keyName = "ptsHr",
		name = "Enable points per hour message",
		description = "Enable the message"
	)
	default boolean ptsHr()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		titleSection = "scouterConfig",
		keyName = "scoutOverlay",
		name = "Show scout overlay",
		description = "Display an overlay that shows the current raid layout (when entering lobby)"
	)
	default boolean scoutOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		titleSection = "scouterConfig",
		keyName = "scoutOverlayAtBank",
		name = "Show scout overlay outside lobby",
		description = "Keep the overlay active while at the raids area"
	)
	default boolean scoutOverlayAtBank()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		titleSection = "scouterConfig",
		keyName = "scoutOverlayInRaid",
		name = "Show scout overlay inside raid",
		description = "Keep the overlay active while inside raid"
	)
	default boolean scoutOverlayInRaid()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		titleSection = "scouterConfig",
		keyName = "displayFloorBreak",
		name = "Layout floor break",
		description = "Displays floor break in layout"
	)
	default boolean displayFloorBreak()
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		titleSection = "scouterConfig",
		keyName = "showRecommendedItems",
		name = "Show recommended items",
		description = "Adds overlay with recommended items to scouter"
	)
	default boolean showRecommendedItems()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		titleSection = "scouterConfig",
		keyName = "recommendedItems",
		name = "Recommended items",
		hidden = true,
		unhide = "showRecommendedItems",
		description = "User-set recommended items in the form: [muttadiles,ice barrage,zamorak godsword],[tekton,elder maul], ..."
	)
	default String recommendedItems()
	{
		return "[muttadiles,zamorak godsword],[Vasa,ghrazi rapier],[Guardians,Dragon pickaxe],[Mystics,Salve amulet(ei)],[Shamans,Antidote++],[Vespula,Super restore(4)]";
	}

	@ConfigItem(
		position = 11,
		titleSection = "scouterConfig",
		keyName = "alwaysShowWorldAndCC",
		name = "Always show CC and World",
		description = "The CC and World are not removed from being in the in-game scouter"
	)
	default boolean alwaysShowWorldAndCC()
	{
		return true;
	}

	@ConfigItem(
		position = 12,
		titleSection = "scouterConfig",
		keyName = "displayLayoutMessage",
		name = "Send raid layout message when entering raid",
		description = "Sends game message with raid layout on entering new raid"
	)
	default boolean displayLayoutMessage()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "roomConfig",
		name = "Room Config",
		description = "",
		position = 13
	)
	default Title roomConfig()
	{
		return new Title();
	}

	@ConfigItem(
		position = 14,
		titleSection = "roomConfig",
		keyName = "colorTightrope",
		name = "Color tightrope",
		description = "Colors tightrope a separate color"
	)
	default boolean colorTightrope()
	{
		return true;
	}

	@ConfigItem(
		position = 15,
		titleSection = "roomConfig",
		keyName = "tightropeColor",
		name = "Tightrope color",
		description = "The color of tightropes",
		hidden = true,
		unhide = "colorTightrope"
	)
	default Color tightropeColor()
	{
		return Color.MAGENTA;
	}

	@ConfigItem(
		position = 16,
		titleSection = "roomConfig",
		keyName = "crabHandler",
		name = "Color crabs",
		description = "If your crabs are good, it will color them to your set color." +
			"<br> If they are bad crabs, it will be set to RED"
	)
	default boolean crabHandler()
	{
		return false;
	}

	@ConfigItem(
		position = 17,
		titleSection = "roomConfig",
		keyName = "goodCrabColor",
		name = "Good Crab color",
		description = "The color of good crabs",
		hidden = true,
		unhide = "crabHandler"
	)
	default Color goodCrabColor()
	{
		return new Color(255, 155, 245);
	}

	@ConfigItem(
		position = 17,
		titleSection = "roomConfig",
		keyName = "rareCrabColor",
		name = "Rare Crab color",
		description = "The color of rare crabs",
		hidden = true,
		unhide = "crabHandler"
	)
	default Color rareCrabColor()
	{
		return new Color(255, 200, 0);
	}

	@ConfigItem(
		position = 18,
		titleSection = "roomConfig",
		keyName = "enableRotationWhitelist",
		name = "Enable rotation whitelist",
		description = "Enable the rotation whitelist"
	)
	default boolean enableRotationWhitelist()
	{
		return false;
	}

	@ConfigItem(
		position = 19,
		titleSection = "roomConfig",
		keyName = "whitelistedRotations",
		name = "Whitelisted rotations",
		hidden = true,
		unhide = "enableRotationWhitelist",
		description = "Warn when boss rotation doesn't match a whitelisted one. Add rotations like [tekton, muttadile, guardians]"
	)
	default String whitelistedRotations()
	{
		return "";
	}

	@ConfigItem(
		position = 20,
		titleSection = "roomConfig",
		keyName = "enableLayoutWhitelist",
		name = "Enable layout whitelist",
		description = "Enable the layout whitelist"
	)
	default boolean enableLayoutWhitelist()
	{
		return false;
	}

	@ConfigItem(
		position = 21,
		titleSection = "roomConfig",
		keyName = "whitelistedLayouts",
		name = "Whitelisted layouts",
		hidden = true,
		unhide = "enableLayoutWhitelist",
		description = "Warn when layout doesn't match a whitelisted one. Add layouts like CFSCPPCSCF separated with comma"
	)
	default String whitelistedLayouts()
	{
		return "";
	}

	@ConfigItem(
		position = 22,
		titleSection = "roomConfig",
		keyName = "showScavsFarms",
		name = "Show scavengers and farming",
		description = "Adds scavengers and farming to the room breakdown"
	)
	default boolean showScavsFarms()
	{
		return false;
	}

	@ConfigItem(
		position = 23,
		titleSection = "roomConfig",
		keyName = "scavsBeforeIce",
		name = "Show last scavs for Ice Demon",
		description = "Highlights final scavengers before Ice Demon"
	)
	default boolean scavsBeforeIce()
	{
		return false;
	}

	@ConfigItem(
		position = 24,
		titleSection = "roomConfig",
		keyName = "scavsBeforeOlm",
		name = "Show last scavs for Olm",
		description = "Highlights final scavengers before Olm"
	)
	default boolean scavsBeforeOlm()
	{
		return true;
	}

	@ConfigItem(
		position = 25,
		titleSection = "roomConfig",
		keyName = "scavPrepColor",
		name = "Last scavs color",
		description = "The color of the final scavs before Ice Demon/Olm"
	)
	default Color scavPrepColor()
	{
		return new Color(130, 222, 255); //light blue
	}

	@ConfigItem(
		position = 26,
		titleSection = "roomConfig",
		keyName = "whitelistedRooms",
		name = "Whitelisted rooms",
		description = "Display whitelisted rooms in green on the overlay. Separate with comma (full name)",
		parse = true,
		clazz = Parse.class,
		method = "parse"
	)
	default String whitelistedRooms()
	{
		return "";
	}

	@ConfigItem(
		position = 27,
		titleSection = "roomConfig",
		keyName = "blacklistedRooms",
		name = "Blacklisted rooms",
		description = "Display blacklisted rooms in red on the overlay. Separate with comma (full name)",
		parse = true,
		clazz = Parse.class,
		method = "parse"
	)
	default String blacklistedRooms()
	{
		return "";
	}

	@ConfigTitleSection(
		keyName = "hideRooms",
		name = "Hide Rooms",
		description = "",
		position = 28
	)
	default Title hideRooms()
	{
		return new Title();
	}

	@ConfigItem(
		position = 29,
		titleSection = "hideRooms",
		keyName = "hideRopeless",
		name = "Hide no Tightrope raids",
		description = "Completely hides raids with no tightrope"
	)
	default boolean hideRopeless()
	{
		return false;
	}

	@ConfigItem(
		position = 30,
		titleSection = "hideRooms",
		keyName = "hideVanguards",
		name = "Hide Vanguard raids",
		description = "Completely hides raids with Vanguards"
	)
	default boolean hideVanguards()
	{
		return false;
	}

	@ConfigItem(
		position = 31,
		titleSection = "hideRooms",
		keyName = "hideUnknownCombat",
		name = "Hide Unknown combat raids",
		description = "Completely hides raids with Unknown combat"
	)
	default boolean hideUnknownCombat()
	{
		return false;
	}

	@ConfigItem(
		position = 32,
		keyName = "partyDisplay",
		name = "Party Info Display",
		description = "Display an overlay that shows information about the current party"
	)
	default boolean partyDisplay()
	{
		return false;
	}
}
