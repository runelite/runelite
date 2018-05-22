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
import net.runelite.api.ItemID;
import net.runelite.api.coords.WorldPoint;

@Getter
enum JewelleryTeleportLocationData
{
	BARBARIAN_ASSAULT(ItemID.GAMES_NECKLACE8, "Barbarian Assault", new WorldPoint(2520, 3571, 0), "games_necklace_teleport_icon.png"),
	BURTHORPE_GAMES_ROOM(ItemID.GAMES_NECKLACE8, "Burthorpe Games Room", new WorldPoint(2898, 3554, 0), "games_necklace_teleport_icon.png"),
	TEARS_OF_GUTHIX(ItemID.GAMES_NECKLACE8, "Tears of Guthix", new WorldPoint(3245, 9500, 0), "games_necklace_teleport_icon.png"),
	CORPOREAL_BEAST(ItemID.GAMES_NECKLACE8, "Corporeal Beast", new WorldPoint(2967, 4384, 0), "games_necklace_teleport_icon.png"),
	WINTERTODT_CAMP(ItemID.GAMES_NECKLACE8, "Wintertodt Camp", new WorldPoint(1624, 3938, 0), "games_necklace_teleport_icon.png"),
	DUEL_ARENA(ItemID.RING_OF_DUELING8, "Duel Arena", new WorldPoint(3315, 3235, 0), "ring_of_dueling_teleport_icon.png"),
	CLAN_WARS(ItemID.RING_OF_DUELING8, "Clan Wars", new WorldPoint(3387, 3158, 0), "ring_of_dueling_teleport_icon.png"),
	CASTLE_WARS(ItemID.RING_OF_DUELING8, "Castle Wars", new WorldPoint(2441, 3091, 0), "ring_of_dueling_teleport_icon.png"),
	WARRIORS_GUILD(ItemID.COMBAT_BRACELET6, "Warriors' Guild", new WorldPoint(2883, 3549, 0), "combat_bracelet_teleport_icon.png"),
	CHAMPIONS_GUILD(ItemID.COMBAT_BRACELET6, "Champions' Guild", new WorldPoint(3189, 3368, 0), "combat_bracelet_teleport_icon.png"),
	EDGEVILLE_MONASTERY(ItemID.COMBAT_BRACELET6, "Edgeville Monastery", new WorldPoint(3053, 3487, 0), "combat_bracelet_teleport_icon.png"),
	RANGING_GUILD(ItemID.COMBAT_BRACELET6, "Ranging Guild", new WorldPoint(2654, 3441, 0), "combat_bracelet_teleport_icon.png"),
	FISHING_GUILD(ItemID.SKILLS_NECKLACE6, "Fishing Guild", new WorldPoint(2613, 3390, 0), "skills_necklace_teleport_icon.png"),
	MINING_GUILD(ItemID.SKILLS_NECKLACE6, "Mining Guild", new WorldPoint(3049, 9762, 0), "skills_necklace_teleport_icon.png"),
	CRAFTING_GUILD(ItemID.SKILLS_NECKLACE6, "Crafting Guild", new WorldPoint(2934, 3294, 0), "skills_necklace_teleport_icon.png"),
	COOKING_GUILD(ItemID.SKILLS_NECKLACE6, "Cooking Guild", new WorldPoint(3145, 3438, 0), "skills_necklace_teleport_icon.png"),
	WOODCUTTING_GUILD(ItemID.SKILLS_NECKLACE6, "Woodcutting Guild", new WorldPoint(1662, 3505, 0), "skills_necklace_teleport_icon.png"),
	EDGEVILLE(ItemID.AMULET_OF_GLORY, "Edgeville", new WorldPoint(3087, 3496, 0), "amulet_of_glory_teleport_icon.png"),
	KARAMJA(ItemID.AMULET_OF_GLORY, "Karamja", new WorldPoint(2918, 3176, 0), "amulet_of_glory_teleport_icon.png"),
	DRAYNOR_VILLAGE(ItemID.AMULET_OF_GLORY, "Draynor Village", new WorldPoint(3105, 3251, 0), "amulet_of_glory_teleport_icon.png"),
	AL_KHARID(ItemID.AMULET_OF_GLORY, "Al-Kharid", new WorldPoint(3293, 3163, 0), "amulet_of_glory_teleport_icon.png"),
	MISCELLANIA(ItemID.AMULET_OF_GLORY, "Miscellania", new WorldPoint(2535, 3862, 0), "ring_of_wealth_teleport_icon.png"),
	GRAND_EXCHANGE(ItemID.RING_OF_WEALTH, "Grand Exchange", new WorldPoint(3162, 3480, 0), "ring_of_wealth_teleport_icon.png"),
	FALADOR_PARK(ItemID.RING_OF_WEALTH, "Falador Park", new WorldPoint(2995, 3375, 0), "ring_of_wealth_teleport_icon.png"),
	DONDAKAN(ItemID.RING_OF_WEALTH, "Dondakan", new WorldPoint(2831, 10165, 0), "ring_of_wealth_teleport_icon.png"),
	SLAYER_TOWER(ItemID.SLAYER_RING_8, "Slayer Tower", new WorldPoint(3429, 3531, 0), "slayer_ring_teleport_icon.png"),
	FREMENNIK_SLAYER_DUNGEON(ItemID.SLAYER_RING_8, "Fremennik Slayer Dungeon", new WorldPoint(2800, 9998, 0), "slayer_ring_teleport_icon.png"),
	TARNS_LAIR(ItemID.SLAYER_RING_8, "Tarn's Lair", new WorldPoint(3187, 4601, 0), "slayer_ring_teleport_icon.png"),
	STRONGHOLD_SLAYER_CAVE(ItemID.SLAYER_RING_8, "Stronghold Slayer Cave", new WorldPoint(2433, 3421, 0), "slayer_ring_teleport_icon.png"),
	DARK_BEASTS(ItemID.SLAYER_RING_8, "Dark Beasts", new WorldPoint(2028, 4638, 0), "slayer_ring_teleport_icon.png"),
	DIGSITE(ItemID.DIGSITE_PENDANT_5, "Digsite", new WorldPoint(3339, 3445, 0), "digsite_pendant_teleport_icon.png"),
	HOUSE_ON_THE_HILL(ItemID.DIGSITE_PENDANT_5, "House on the Hill", new WorldPoint(3763, 3869, 0), "digsite_pendant_teleport_icon.png"),
	LITHKREN(ItemID.DIGSITE_PENDANT_5, "Lithkren", new WorldPoint(3547, 10456, 0), "digsite_pendant_teleport_icon.png"),
	WIZARDS_TOWER(ItemID.NECKLACE_OF_PASSAGE5, "Wizards' Tower", new WorldPoint(3114, 3181, 0), "necklace_of_passage_teleport_icon.png"),
	JORRALS_OUTPOST(ItemID.NECKLACE_OF_PASSAGE5, "Jorral's Outpost", new WorldPoint(2431, 3348, 0), "necklace_of_passage_teleport_icon.png"),
	DESERT_EAGLE_STATION(ItemID.NECKLACE_OF_PASSAGE5, "Desert eagle station of the eagle transport system", new WorldPoint(3406, 3157, 0), "necklace_of_passage_teleport_icon.png"),
	CHAOS_TEMPLE(ItemID.BURNING_AMULET5, "Chaos Temple (lvl 15)", new WorldPoint(3234, 3637, 0), "burning_amulet_teleport_icon.png"),
	BANDIT_CAMP(ItemID.BURNING_AMULET5, "Bandit Camp (lvl 17)", new WorldPoint(3038, 3651, 0), "burning_amulet_teleport_icon.png"),
	LAVA_MAZE(ItemID.BURNING_AMULET5, "Lava Maze (lvl 41)", new WorldPoint(3028, 3840, 0), "burning_amulet_teleport_icon.png");

	private final int itemID;
	private final String destionation;
	private final WorldPoint location;
	private final String iconPath;

	JewelleryTeleportLocationData(int itemID, String destination, WorldPoint location, String iconPath)
	{
		this.itemID = itemID;
		this.destionation = destination;
		this.location = location;
		this.iconPath = iconPath;
	}
}
