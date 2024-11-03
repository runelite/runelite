/*
 * Copyright  c) 2024, Macweese
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
 * DAMAGES  INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT  INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.api.worldmap;

import lombok.Getter;

/**
 * These are values the client uses to determine which context the world map should show
 */
@Getter
public final class WorldMapArea
{
	// THIS IS NOT AN OFFICIAL VALUE JAGEX USES
	public static final int ANY = -1;

	public static final int SURFACE = 0;
	public static final int ANCIENT_CAVERN = 1;
	public static final int ARDOUGNE_UNDERGROUND = 2;
	public static final int ASGARNIA_ICE_CAVE = 3;
	public static final int BRAINDEATH_ISLAND = 4;
	public static final int DORGESH_KAAN = 5;
	public static final int DWARVEN_MINES = 6;
	public static final int GOD_WARS_DUNGEON = 7;
	// 8 UNMAPPED
	public static final int KARAMJA_UNDERGROUND = 9;
	public static final int KELDAGRIM = 10;
	public static final int MISCELLANIA_UNDERGROUND = 11;
	public static final int MITHALIN_UNDERGROUND = 12;
	public static final int MOLE_HOLE = 13;
	public static final int MORYTANIA_UNDERGROUND = 14;
	public static final int MOS_LE_HARMLESS_CAVE = 15;
	public static final int OURANIA_ALTAR = 16;
	public static final int FREMENNIK_SLAYER_CAVE = 17;
	public static final int STRONGHOLD_OF_SECURITY = 18;
	public static final int STRONGHOLD_UNDERGROUND = 19;
	public static final int TAVERLY_UNDERGROUND = 20;
	public static final int TOLNAS_RIFT = 21;
	public static final int TROLL_STRONGHOLD = 22;
	public static final int MOR_UL_REK = 23;
	public static final int LAIR_OF_TARN_RAZORLOR = 24;
	public static final int WATERBIRTH_DUNGEON = 25;
	public static final int WILDERNESS_DUNGEONS = 26;
	public static final int YANNILE_UNDERGROUND = 27;
	public static final int ZANARIS = 28;
	public static final int PRIFDDINAS = 29;
	public static final int FOSSIL_ISLAND_UNDERGROUND = 30;
	public static final int FELDIP_HILLS_UNDERGROUND = 31;
	public static final int KOUREND_UNDERGROUND = 32;
	public static final int KEBOS_UNDERGROUND = 33;
	public static final int PRIFDDINAS_UNDERGROUND = 34;
	public static final int PROFDDINAS_GRAND_LIBRARY = 35;
	public static final int LMS_DESERT_ISLAND = 36;
	// 37 UNMAPPED
	public static final int LMS_WILD_VARROCK = 38;
	public static final int RUINS_OF_CAMDOZAAL = 39;
	public static final int THE_ABYSS = 40;
	// 41 UNMAPPED
	public static final int KHARIDIAN_DESERT_UNDERGROUND = 42;
	public static final int VARLAMORE_UNDERGROUND = 43;
	public static final int CAM_TORUM = 44;
	public static final int NEYPOTZLI = 45;
	public static final int CHURCH_OF_AYASTER = 46;
	public static final int AYASTER_CRYPT = 47;
	public static final int EASTER_WORKSOP = 48;
}
