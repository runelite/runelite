/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.worldmap;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(WorldMapPlugin.CONFIG_KEY)
public interface WorldMapConfig extends Config
{
	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_FAIRY_RING_TOOLTIPS,
		name = "Fairy ring code tooltip",
		description = "Display the code for fairy rings in the icon tooltip",
		position = 1
	)
	default boolean fairyRingTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_FAIRY_RING_ICON,
		name = "Fairy ring travel icon",
		description = "Override the travel icon for fairy rings",
		position = 2
	)
	default boolean fairyRingIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_AGILITY_SHORTCUT_TOOLTIPS,
		name = "Agility level requirement",
		description = "Display the required Agility level in the icon tooltip",
		position = 3
	)
	default boolean agilityShortcutTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_AGILITY_SHORTCUT_LEVEL_ICON,
		name = "Indicate inaccessible shortcuts",
		description = "Indicate shortcuts you do not have the level to use on the icon",
		position = 4
	)
	default boolean agilityShortcutLevelIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_AGILITY_COURSE_TOOLTIPS,
		name = "Agility course tooltip",
		description = "Displays the name of the agility course in the tooltip",
		position = 5
	)
	default boolean agilityCourseTooltip()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_AGILITY_COURSE_ROOFTOP_ICON,
		name = "Indicate rooftop courses",
		description = "Replace the agility icon with a mark of grace for rooftop courses",
		position = 6
	)
	default boolean agilityCourseRooftop()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_NORMAL_TELEPORT_ICON,
		name = "Standard Spellbook destinations",
		description = "Show icons at the destinations for teleports in the Standard Spellbook",
		position = 7
	)
	default boolean normalTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_MINIGAME_TOOLTIP,
		name = "Minigame names",
		description = "Display the name of the minigame in the icon tooltip",
		position = 8
	)
	default boolean minigameTooltip()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_ANCIENT_TELEPORT_ICON,
		name = "Ancient Magicks destinations",
		description = "Show icons at the destinations for teleports in the Ancient Spellbook",
		position = 9
	)
	default boolean ancientTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_LUNAR_TELEPORT_ICON,
		name = "Lunar Spellbook destinations",
		description = "Show icons at the destinations for teleports in the Lunar Spellbook",
		position = 10
	)
	default boolean lunarTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_ARCEUUS_TELEPORT_ICON,
		name = "Arceuus Spellbook destinations",
		description = "Show icons at the destinations for teleports in the Arceuus Spellbook",
		position = 11
	)
	default boolean arceuusTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_JEWELLERY_TELEPORT_ICON,
		name = "Jewellery teleport destinations",
		description = "Show icons at the destinations for teleports from jewellery",
		position = 12
	)
	default boolean jewelleryTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_SCROLL_TELEPORT_ICON,
		name = "Teleport scroll destinations",
		description = "Show icons at the destinations for teleports from scrolls",
		position = 13
	)
	default boolean scrollTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_MISC_TELEPORT_ICON,
		name = "Misc teleport destinations",
		description = "Show icons at the destinations for miscellaneous teleport items",
		position = 14
	)
	default boolean miscellaneousTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_QUEST_START_TOOLTIPS,
		name = "Quest names and status",
		description = "Indicates the names of quests and shows completion status",
		position = 15
	)
	default boolean questStartTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_FARMING_PATCH_TOOLTIPS,
		name = "Farming patch type",
		description = "Display the type of farming patches in the icon tooltip",
		position = 16
	)
	default boolean farmingPatchTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_RARE_TREE_TOOLTIPS,
		name = "Rare tree type",
		description = "Display the type of rare tree in the icon tooltip",
		position = 17
	)
	default boolean rareTreeTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_RARE_TREE_LEVEL_ICON,
		name = "Indicate unavailable trees",
		description = "Indicate rare trees you do not have the level to cut on the icon",
		position = 18
	)
	default boolean rareTreeLevelIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_TRANSPORTATION_TELEPORT_TOOLTIPS,
		name = "Transportation tooltips",
		description = "Indicates types and destinations of Transportation",
		position = 19
	)
	default boolean transportationTeleportTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_RUNECRAFTING_ALTAR_ICON,
		name = "Runecrafting altar locations",
		description = "Show the icons of runecrafting altars",
		position = 20
	)
	default boolean runecraftingAltarIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_MINING_SITE_TOOLTIPS,
		name = "Mining site tooltips",
		description = "Indicates the ore available at mining sites",
		position = 21
	)
	default boolean miningSiteTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_DUNGEON_TOOLTIPS,
		name = "Dungeon tooltips",
		description = "Indicates the names of dungeons",
		position = 22
	)
	default boolean dungeonTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_HUNTER_AREA_TOOLTIPS,
		name = "Hunter area tooltips",
		description = "Indicates the creatures inside a hunting area",
		position = 23
	)
	default boolean hunterAreaTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_FISHING_SPOT_TOOLTIPS,
		name = "Fishing spot tooltips",
		description = "Indicates the type of fish fishable at the fishing spot",
		position = 24
	)
	default boolean fishingSpotTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_KOUREND_TASK_TOOLTIPS,
		name = "Kourend task tooltips",
		description = "Indicates the task or unlock for Kourend Favour locations",
		position = 25
	)
	default boolean kourendTaskTooltips()
	{
		return true;
	}
}
