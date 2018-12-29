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
		name = "Show fairy ring codes in tooltip",
		description = "Display the code for fairy rings in the icon tooltip",
		position = 1
	)
	default boolean fairyRingTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_FAIRY_RING_ICON,
		name = "Show fairy ring travel icon",
		description = "Override the travel icon for fairy rings",
		position = 2
	)
	default boolean fairyRingIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_AGILITY_SHORTCUT_TOOLTIPS,
		name = "Show agility level requirement",
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
		keyName = WorldMapPlugin.CONFIG_KEY_NORMAL_TELEPORT_ICON,
		name = "Show Standard Spellbook destinations",
		description = "Show icons at the destinations for teleports in the Standard Spellbook",
		position = 5
	)
	default boolean normalTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_MINIGAME_TOOLTIP,
		name = "Show minigame name in tooltip",
		description = "Display the name of the minigame in the icon tooltip",
		position = 6
	)
	default boolean minigameTooltip()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_ANCIENT_TELEPORT_ICON,
		name = "Show Ancient Magicks destinations",
		description = "Show icons at the destinations for teleports in the Ancient Spellbook",
		position = 7
	)
	default boolean ancientTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_LUNAR_TELEPORT_ICON,
		name = "Show Lunar Spellbook destinations",
		description = "Show icons at the destinations for teleports in the Lunar Spellbook",
		position = 8
	)
	default boolean lunarTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_ARCEUUS_TELEPORT_ICON,
		name = "Show Arceuus Spellbook destinations",
		description = "Show icons at the destinations for teleports in the Arceuus Spellbook",
		position = 9
	)
	default boolean arceuusTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_JEWELLERY_TELEPORT_ICON,
		name = "Show jewellery teleport locations",
		description = "Show icons at the destinations for teleports from jewellery",
		position = 10
	)
	default boolean jewelleryTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_SCROLL_TELEPORT_ICON,
		name = "Show teleport scroll locations",
		description = "Show icons at the destinations for teleports from scrolls",
		position = 11
	)
	default boolean scrollTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_MISC_TELEPORT_ICON,
		name = "Show misc teleport locations",
		description = "Show icons at the destinations for miscellaneous teleport items",
		position = 12
	)
	default boolean miscellaneousTeleportIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_QUEST_START_TOOLTIPS,
		name = "Show quest names",
		description = "Indicates the names of quests and highlights incomplete ones",
		position = 13
	)
	default boolean questStartTooltips()
	{
		return true;
	}

	@ConfigItem(
		keyName = WorldMapPlugin.CONFIG_KEY_FARMING_PATCH_TOOLTIPS,
		name = "Show farming patch type",
		description = "Display the type of farming patches in the icon tooltip",
		position = 14
	)
	default boolean farmingPatchTooltips()
	{
		return true;
	}
}