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

/**
 * Enum of the index and text of each map area of the world map as it appears in the world map area selection dropdown.
 */
@RequiredArgsConstructor
@Getter
public enum WorldMapArea
{
	ANY("Any"),
	GIELINOR_SURFACE("Gielinor Surface"),
	ANCIENT_CAVERN("Ancient Cavern"),
	ARDOUGNE_UNDERGROUND("Ardougne Underground"),
	ASGARNIA_ICE_CAVE("Asgarnia Ice Cave"),
	BRAINDEATH_ISLAND("Braindeath Island"),
	DORGESH_KAAN("Dorgesh-Kaan"),
	DWARVEN_MINES("Dwarven Mines"),
	GOD_WARS_DUNGEON("God Wars Dungeon"),
	KARAMJA_UNDERGROUND("Karamja Underground"),
	KELDAGRIM("Keldagrim"),
	LMS_WILD_VARROCK("LMS Wild Varrock"),
	LMS_DESERT_ISLAND("LMS Desert Island"),
	MISCELLANIA_UNDERGROUND("Miscellania Underground"),
	MISTHALIN_UNDERGROUND("Misthalin Underground"),
	MOLE_HOLE("Mole Hole"),
	MORYTANIA_UNDERGROUND("Morytania Underground"),
	MOS_LEHARMLESS_CAVE("Mos Le'Harmless Cave"),
	OURANIA_ALTAR("Ourania Altar"),
	RUINS_OF_CAMDOZAAL("Ruins of Camdozaal"),
	FREMENNIK_SLAYER_CAVE("Fremennik Slayer Cave"),
	STRONGHOLD_OF_SECURITY("Stronghold of Security"),
	TAVERLEY_UNDERGROUND("Taverley Underground"),
	TOLNAS_RIFT("Tolna's Rift"),
	TROLL_STRONGHOLD("Troll Stronghold"),
	MOR_UL_REK("Mor Ul Rek"),
	LAIR_OF_TARN_RAZORLOR("Lair of Tarn Razorlor"),
	WATERBIRTH_DUNGEON("Waterbirth Dungeon"),
	WILDERNESS_DUNGEONS("Wilderness Dungeons"),
	YANILLE_UNDERGROUND("Yanille Underground"),
	ZANARIS("Zanaris"),
	STRONGHOLD_UNDERGROUND("Stronghold Underground"),
	KOUREND_UNDERGROUND("Kourend Underground"),
	FOSSIL_ISLAND_UNDERGROUND("Fossil Island Underground"),
	FELDIP_HILLS_UNDERGROUND("Feldip Hills Underground"),
	KEBOS_UNDERGROUND("Kebos Underground"),
	PRIFFDDINAS("Prifddinas"),
	PRIFFDDINAS_UNDERGROUND("Prifddinas Underground"),
	PRIFDDINAS_GRAND_LIBRARY("Prifddinas Grand Library"),
	THE_ABYSS("The Abyss"),
	KHARIDIAN_DESERT_UNDERGROUND("Kharidian Desert Underground"),
	GHORROCK_PRISON("Ghorrock Prison"),
	LASSAR_UNDERCITY("Lassar Undercity");

	private static final WorldMapArea[] AREAS = values();

	private final String name;

	public static WorldMapArea fromId(int areaId)
	{
		if (areaId < 0 || areaId >= AREAS.length) return ANY;
		return AREAS[areaId];
	}

	public static WorldMapArea fromName(String name)
	{
		for (WorldMapArea area : AREAS)
		{
			if (area.getName().equals(name))
			{
				return area;
			}
		}

		return ANY;
	}
}
