/*
 * Copyright (c) 2024, Zoinkwiz <https://github.com/Zoinkwiz>
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
package net.runelite.client.ui.overlay.worldmap;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum WorldMapArea
{
	ANY(0, "Any"),
	GIELINOR_SURFACE(1, "Gielinor Surface"),
	ANCIENT_CAVERN(2, "Ancient Cavern"),
	ARDOUGNE_UNDERGROUND(3, "Ardougne Underground"),
	ASGARNIA_ICE_CAVE(4, "Asgarnia Ice Cave"),
	BRAINDEATH_ISLAND(5, "Braindeath Island"),
	DORGESH_KAAN(6, "Dorgesh-Kaan"),
	DWARVEN_MINES(7, "Dwarven Mines"),
	GOD_WARS_DUNGEON(8, "God Wars Dungeon"),
	KARAMJA_UNDERGROUND(9, "Karamja Underground"),
	KELDAGRIM(10, "Keldagrim"),
	LMS_WILD_VARROCK(11, "LMS Wild Varrock"),
	LMS_DESERT_ISLAND(12, "LMS Desert Island"),
	MISCELLANIA_UNDERGROUND(13, "Miscellania Underground"),
	MISTHALIN_UNDERGROUND(14, "Misthalin Underground"),
	MOLE_HOLE(15, "Mole Hole"),
	MORYTANIA_UNDERGROUND(16, "Morytania Underground"),
	MOS_LEHARMLESS_CAVE(17, "Mos Le'Harmless Cave"),
	OURANIA_ALTAR(18, "Ourania Altar"),
	RUINS_OF_CAMDOZAAL(19, "Ruins of Camdozaal"),
	FREMENNIK_SLAYER_CAVE(20, "Fremennik Slayer Cave"),
	STRONGHOLD_OF_SECURITY(21, "Stronghold of Security"),
	TAVERLEY_UNDERGROUND(22, "Taverley Underground"),
	TOLNAS_RIFT(23, "Tolna's Rift"),
	TROLL_STRONGHOLD(24, "Troll Stronghold"),
	MOR_UL_REK(25, "Mor Ul Rek"),
	LAIR_OF_TARN_RAZORLOR(26, "Lair of Tarn Razorlor"),
	WATERBIRTH_DUNGEON(27, "Waterbirth Dungeon"),
	WILDERNESS_DUNGEONS(28, "Wilderness Dungeons"),
	YANILLE_UNDERGROUND(29, "Yanille Underground"),
	ZANARIS(30, "Zanaris"),
	STRONGHOLD_UNDERGROUND(31, "Stronghold Underground"),
	KOUREND_UNDERGROUND(32, "Kourend Underground"),
	FOSSIL_ISLAND_UNDERGROUND(33, "Fossil Island Underground"),
	FELDIP_HILLS_UNDERGROUND(34, "Feldip Hills Underground"),
	KEBOS_UNDERGROUND(35, "Kebos Underground"),
	PRIFFDDINAS(36, "Prifddinas"),
	PRIFFDDINAS_UNDERGROUND(37, "Prifddinas Underground"),
	PRIFDDINAS_GRAND_LIBRARY(38, "Prifddinas Grand Library"),
	THE_ABYSS(39, "The Abyss"),
	KHARIDIAN_DESERT_UNDERGROUND(40, "Kharidian Desert Underground"),
	GHORROCK_PRISON(41, "Ghorrock Prison"),
	LASSAR_UNDERCITY(42, "Lassar Undercity");

	private final int id;

	private final String name;

	public static WorldMapArea fromId(int id)
	{
		for (WorldMapArea area : values())
		{
			if (area.getId() == id)
			{
				return area;
			}
		}

		return ANY;
	}

	public static WorldMapArea fromName(String name)
	{
		for (WorldMapArea area : values())
		{
			if (area.getName().equals(name))
			{
				return area;
			}
		}

		return ANY;
	}
}
