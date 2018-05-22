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

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
enum JewelleryTeleportLocationData
{
	BARBARIAN_ASSAULT("Games Necklace" , "Barbarian Assault", new WorldPoint(2520, 3571, 0), "games_necklace_teleport_icon.png"),
	BURTHORPE_GAMES_ROOM("Games Necklace" , "Burthorpe Games Room", new WorldPoint(2898, 3554, 0), "games_necklace_teleport_icon.png"),
	TEARS_OF_GUTHIX("Games Necklace" , "Tears of Guthix", new WorldPoint(3245, 9500, 0), "games_necklace_teleport_icon.png"),
	CORPOREAL_BEAST("Games Necklace" , "Corporeal Beast", new WorldPoint(2967, 4384, 0), "games_necklace_teleport_icon.png"),
	WINTERTODT_CAMP("Games Necklace" , "Wintertodt Camp", new WorldPoint(1624, 3938, 0), "games_necklace_teleport_icon.png"),
	DUEL_ARENA("Ring of Dueling" , "Duel Arena", new WorldPoint(3315, 3235, 0), "ring_of_dueling_teleport_icon.png"),
	CLAN_WARS("Ring of Dueling" , "Clan Wars", new WorldPoint(3387, 3158, 0), "ring_of_dueling_teleport_icon.png"),
	CASTLE_WARS("Ring of Dueling" , "Castle Wars", new WorldPoint(2441, 3091, 0), "ring_of_dueling_teleport_icon.png"),
	WARRIORS_GUILD("Combat Bracelet" , "Warriors' Guild", new WorldPoint(2883, 3549, 0), "combat_bracelet_teleport_icon.png"),
	CHAMPIONS_GUILD("Combat Bracelet" , "Champions' Guild", new WorldPoint(3189, 3368, 0), "combat_bracelet_teleport_icon.png"),
	EDGEVILLE_MONASTERY("Combat Bracelet" , "Edgeville Monastery", new WorldPoint(3053, 3487, 0), "combat_bracelet_teleport_icon.png"),
	RANGING_GUILD("Combat Bracelet" , "Ranging Guild", new WorldPoint(2654, 3441, 0), "combat_bracelet_teleport_icon.png"),
	FISHING_GUILD("Skills Necklace" , "Fishing Guild", new WorldPoint(2613, 3390, 0), "skills_necklace_teleport_icon.png"),
	MINING_GUILD("Skills Necklace" , "Mining Guild", new WorldPoint(3049, 9762, 0), "skills_necklace_teleport_icon.png"),
	CRAFTING_GUILD("Skills Necklace" , "Crafting Guild", new WorldPoint(2934, 3294, 0), "skills_necklace_teleport_icon.png"),
	COOKING_GUILD("Skills Necklace" , "Cooking Guild", new WorldPoint(3145, 3438, 0), "skills_necklace_teleport_icon.png"),
	WOODCUTTING_GUILD("Skills Necklace" , "Woodcutting Guild", new WorldPoint(1662, 3505, 0), "skills_necklace_teleport_icon.png"),
	EDGEVILLE("Amulet of Glory" , "Edgeville", new WorldPoint(3087, 3496, 0), "amulet_of_glory_teleport_icon.png"),
	KARAMJA("Amulet of Glory" , "Karamja", new WorldPoint(2918, 3176, 0), "amulet_of_glory_teleport_icon.png"),
	DRAYNOR_VILLAGE("Amulet of Glory" , "Draynor Village", new WorldPoint(3105, 3251, 0), "amulet_of_glory_teleport_icon.png"),
	AL_KHARID("Amulet of Glory" , "Al-Kharid", new WorldPoint(3293, 3163, 0), "amulet_of_glory_teleport_icon.png"),
	MISCELLANIA("Ring of Wealth" , "Miscellania", new WorldPoint(2535, 3862, 0), "ring_of_wealth_teleport_icon.png"),
	GRAND_EXCHANGE("Ring of Wealth" , "Grand Exchange", new WorldPoint(3162, 3480, 0), "ring_of_wealth_teleport_icon.png"),
	FALADOR_PARK("Ring of Wealth" , "Falador Park", new WorldPoint(2995, 3375, 0), "ring_of_wealth_teleport_icon.png"),
	DONDAKAN("Ring of Wealth" , "Dondakan", new WorldPoint(2831, 10165, 0), "ring_of_wealth_teleport_icon.png"),
	SLAYER_TOWER("Slayer Ring" , "Slayer Tower", new WorldPoint(3429, 3531, 0), "slayer_ring_teleport_icon.png"),
	FREMENNIK_SLAYER_DUNGEON("Slayer Ring" , "Fremennik Slayer Dungeon", new WorldPoint(2800, 9998, 0), "slayer_ring_teleport_icon.png"),
	TARNS_LAIR("Slayer Ring" , "Tarn's Lair", new WorldPoint(3187, 4601, 0), "slayer_ring_teleport_icon.png"),
	STRONGHOLD_SLAYER_CAVE("Slayer Ring" , "Stronghold Slayer Cave", new WorldPoint(2433, 3421, 0), "slayer_ring_teleport_icon.png"),
	DARK_BEASTS("Slayer Ring" , "Dark Beasts", new WorldPoint(2028, 4638, 0), "slayer_ring_teleport_icon.png"),
	DIGSITE("Digsite Pendant" , "Digsite", new WorldPoint(3339, 3445, 0), "digsite_pendant_teleport_icon.png"),
	HOUSE_ON_THE_HILL("Digsite Pendant" , "House on the Hill", new WorldPoint(3763, 3869, 0), "digsite_pendant_teleport_icon.png"),
	LITHKREN("Digsite Pendant" , "Lithkren", new WorldPoint(3547, 10456, 0), "digsite_pendant_teleport_icon.png"),
	WIZARDS_TOWER("Necklace of Passage" , "Wizards' Tower", new WorldPoint(3114, 3181, 0), "necklace_of_passage_teleport_icon.png"),
	JORRALS_OUTPOST("Necklace of Passage" , "Jorral's Outpost", new WorldPoint(2431, 3348, 0), "necklace_of_passage_teleport_icon.png"),
	DESERT_EAGLE_STATION("Necklace of Passage" , "Desert eagle station of the eagle transport system", new WorldPoint(3406, 3157, 0), "necklace_of_passage_teleport_icon.png"),
	CHAOS_TEMPLE("Burning Amulet" , "Chaos Temple (lvl 15)", new WorldPoint(3234, 3637, 0), "burning_amulet_teleport_icon.png"),
	BANDIT_CAMP("Burning Amulet" , "Bandit Camp (lvl 17)", new WorldPoint(3038, 3651, 0), "burning_amulet_teleport_icon.png"),
	LAVA_MAZE("Burning Amulet" , "Lava Maze (lvl 41)", new WorldPoint(3028, 3840, 0), "burning_amulet_teleport_icon.png");

	private final String tooltip;
	private final WorldPoint location;
	private final String iconPath;

	JewelleryTeleportLocationData(String item, String destination, WorldPoint location, String iconPath)
	{
		this.tooltip = item + " - " + destination;
		this.location = location;
		this.iconPath = iconPath;
	}
}
