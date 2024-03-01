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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.api.coords.WorldPoint;

public class WorldPointToWorldMapPoint
{
	static Map<Integer, List<PlaneMapping>> realChunkToMapChunk = new HashMap<>();

	static
	{
		/* Ancient Cavern */
		addMapping(6995, new PlaneMapping(WorldMapArea.ANCIENT_CAVERN, 1, 7252));
		addMapping(6994, new PlaneMapping(WorldMapArea.ANCIENT_CAVERN, 1, 7251));
		// DS2 version of Ancient Cavern
		// ISSUE: This should mirror, so that it won't
		addMapping(6483, new PlaneMapping(WorldMapArea.ANCIENT_CAVERN, 0, 6995, true));
		addMapping(6483, new PlaneMapping(WorldMapArea.ANCIENT_CAVERN, 1, 6995, true));

		/* Asgarnia Ice Dungeon */
		addMapping(12181, new PlaneMapping(WorldMapArea.ASGARNIA_ICE_CAVE, 1, 12437));
		addMapping(12437, new PlaneMapping(WorldMapArea.ASGARNIA_ICE_CAVE, 1, 12693));

		/* Dorgesh-Kaan */
		addMapping(10834, new PlaneMapping(WorldMapArea.DORGESH_KAAN, 1, 11091));
		addMapping(10835, new PlaneMapping(WorldMapArea.DORGESH_KAAN, 1, 11092));
		addMapping(10834, new PlaneMapping(WorldMapArea.DORGESH_KAAN, 2, 11348));
		addMapping(10835, new PlaneMapping(WorldMapArea.DORGESH_KAAN, 2, 11349));

		/* Dwarven Mines */
		// OVERLAPS with Draynor Sewers
		addMapping(14936, new PlaneMapping(WorldMapArea.DWARVEN_MINES, 0, 12439));
		addMapping(14936, new PlaneMapping(WorldMapArea.DWARVEN_MINES, 1, 12951, -32, 0));

		/* Feldip Hills Underground */
		addMapping(10130, new PlaneMapping(WorldMapArea.FELDIP_HILLS_UNDERGROUND, 0, 8077, 24, 16));

		/* Fossil Island */
		addMapping(15263, new PlaneMapping(WorldMapArea.FOSSIL_ISLAND_UNDERGROUND, 3, 15519, 32, 32));
		addMapping(15262, new PlaneMapping(WorldMapArea.FOSSIL_ISLAND_UNDERGROUND, 3, 15518, 32, 32));

		/* Fremennik Slayer Cave */
		PlaneMapping fremSlayerCaveEntrance = new PlaneMapping(WorldMapArea.FREMENNIK_SLAYER_CAVE, 0, 10908, 0, -32);
		fremSlayerCaveEntrance.setXMin(14);
		fremSlayerCaveEntrance.setXMax(20);
		fremSlayerCaveEntrance.setYMax(6);
		addMapping(10908, fremSlayerCaveEntrance);
		addMapping(10907, new PlaneMapping(WorldMapArea.FREMENNIK_SLAYER_CAVE, 0, 10907, 0, -32));

		/* Ghorrock Prison */
		// All correct

		/* God Wars Dungeon */
		PlaneMapping godwarsSaraEncampment = new PlaneMapping(WorldMapArea.GOD_WARS_DUNGEON, 1, 11858, -32, -8);
		godwarsSaraEncampment.setXMin(32);
		godwarsSaraEncampment.setYMin(25);
		addMapping(11602, godwarsSaraEncampment);

		PlaneMapping godwarsZilyanaRoom = new PlaneMapping(WorldMapArea.GOD_WARS_DUNGEON, 0, 11601, 8, 40);
		godwarsZilyanaRoom.setYMax(24);
		addMapping(11602, godwarsZilyanaRoom);
		// Zaros area is speculative that it's moves down a region and shifted up rather than just shifted down
		addMapping(11345, new PlaneMapping(WorldMapArea.GOD_WARS_DUNGEON, 0, 11344, 0, 32));
		addMapping(11601, new PlaneMapping(WorldMapArea.GOD_WARS_DUNGEON, 0, 11600, 0, 32));

		/* Karamja Underground */
		addMapping(11412, new PlaneMapping(WorldMapArea.KARAMJA_UNDERGROUND, 1, 11667));

		/* Kebos Underground */

		// Karuulm dungeon
		addMapping(5023, new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 1, 4510, -24, 24));

		addMapping(5278, new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 1, 4765, -24, 24));
		addMapping(5279, new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 1, 4766, -24, 24));
		addMapping(5280, new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 1, 4767, -24, 24));

		PlaneMapping karuulmF1NE = new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 1, 5022, -24, 24);
		karuulmF1NE.setXMax(32);
		addMapping(5535, karuulmF1NE);
		PlaneMapping karuulmF1SE = new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 1, 5023, -24, 24);
		karuulmF1SE.setXMax(32);
		addMapping(5536, karuulmF1SE);
		// 1179, 10279, 0 (FAKE 1st FLOOR)
		// 1323, 10215, 0 (REAL 1st FLOOR)
		addMapping(5023, new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 2, 4512, -16, 0));
		addMapping(5279, new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 2, 4768, -16, 0));
		addMapping(5535, new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 2, 5024, -16, 0));

		// Hespori
		addMapping(5021, new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 0, 4765, 0, -16));

		// Lizardman Temple
		addMapping(5277, new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 0, 5276, 0, 16));

		// Lizardman Caves
		addMapping(5275, new PlaneMapping(WorldMapArea.KEBOS_UNDERGROUND, 0, 5275, 0, -16));

		/* Keldagrim */

		PlaneMapping keldagrim = new PlaneMapping(WorldMapArea.KELDAGRIM, 0, 11421, -8, 16);
		keldagrim.setXMax(56);
		keldagrim.setYMax(56);
		addMapping(11166, keldagrim);

		/* Kharidian */

		// Kalphite Slayer Dungeon
		addMapping(13204, new PlaneMapping(WorldMapArea.KHARIDIAN_DESERT_UNDERGROUND, 0, 13460));
		addMapping(13205, new PlaneMapping(WorldMapArea.KHARIDIAN_DESERT_UNDERGROUND, 0, 13461));
		addMapping(13460, new PlaneMapping(WorldMapArea.KHARIDIAN_DESERT_UNDERGROUND, 0, 13716));

		// Kalphite lair
		addMapping(13972, new PlaneMapping(WorldMapArea.KHARIDIAN_DESERT_UNDERGROUND, 2, 12692, 32, 0));
		addMapping(13972, new PlaneMapping(WorldMapArea.KHARIDIAN_DESERT_UNDERGROUND, 0, 12691, 32, 0));

		// Tombs of Amascut Entrance
		addMapping(13454, new PlaneMapping(WorldMapArea.KHARIDIAN_DESERT_UNDERGROUND, 0, 13456));

		// Giant's Foundry
		addMapping(13491, new PlaneMapping(WorldMapArea.KHARIDIAN_DESERT_UNDERGROUND, 0, 13717, 24, 16));

		/* Kourend Underground */
		addMapping(7070, new PlaneMapping(WorldMapArea.KOUREND_UNDERGROUND, 0, 7326));
		addMapping(7326, new PlaneMapping(WorldMapArea.KOUREND_UNDERGROUND, 0, 7582));

		// Shayzien Crypts
		addMapping(6043, new PlaneMapping(WorldMapArea.KOUREND_UNDERGROUND, 1, 6042, -32, 0));
		addMapping(6043, new PlaneMapping(WorldMapArea.KOUREND_UNDERGROUND, 2, 6043, -32, 32));
		addMapping(6043, new PlaneMapping(WorldMapArea.KOUREND_UNDERGROUND, 3, 6045, -32, 0));

		// Chasm of Fire
		addMapping(5789, new PlaneMapping(WorldMapArea.KOUREND_UNDERGROUND, 3, 5533));
		addMapping(5789, new PlaneMapping(WorldMapArea.KOUREND_UNDERGROUND, 2, 5532, 0, -32));
		addMapping(5789, new PlaneMapping(WorldMapArea.KOUREND_UNDERGROUND, 1, 5530));

		// Giants' Den
		addMapping(5786, new PlaneMapping(WorldMapArea.KOUREND_UNDERGROUND, 0, 5785));

		/* Lair of Tarn Tazorlor */

		// Terror dog room shown is post-quest location. Quest location is -31, +63
		addMapping(12615, new PlaneMapping(WorldMapArea.LAIR_OF_TARN_RAZORLOR, 1, 12871, 32, 0));
		addMapping(12615, new PlaneMapping(WorldMapArea.LAIR_OF_TARN_RAZORLOR, 2, 13383));

		// Lassar Undercity (Shadow version)
		addMapping(9314, new PlaneMapping(WorldMapArea.LASSAR_UNDERCITY, 10338, true));
		addMapping(9315, new PlaneMapping(WorldMapArea.LASSAR_UNDERCITY, 10339, true));
		addMapping(9316, new PlaneMapping(WorldMapArea.LASSAR_UNDERCITY, 10340, true));


		addMapping(9570, new PlaneMapping(WorldMapArea.LASSAR_UNDERCITY, 10594));
		addMapping(9571, new PlaneMapping(WorldMapArea.LASSAR_UNDERCITY, 10595));
		addMapping(9572, new PlaneMapping(WorldMapArea.LASSAR_UNDERCITY, 10596));

		addMapping(9826, new PlaneMapping(WorldMapArea.LASSAR_UNDERCITY, 10850));
		addMapping(9827, new PlaneMapping(WorldMapArea.LASSAR_UNDERCITY, 10851));
		addMapping(9828, new PlaneMapping(WorldMapArea.LASSAR_UNDERCITY, 10852));

		/* Miscellania Underground */
		// All correctly placed

		/* Misthalin Underground */
		// All correctly placed

		/* Mole Hole */
		// All correctly placed

		/* Mor Ul Rek */
		addMapping(9043, new PlaneMapping(WorldMapArea.MOR_UL_REK, 0, 9806, 32, 0));

		/* Morytania Underground */

		// Meiyerditch Laboratories
		addMapping(13977, new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 14233));
		addMapping(14233, new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 14489));
		addMapping(14232, new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 14488));
		addMapping(14488, new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 14744));
		addMapping(14487, new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 14743));

		// Slepe Basement
		PlaneMapping slepeBasement = new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 14999, -16, 24);
		slepeBasement.setYMax(22);
		slepeBasement.setXMin(16);
		slepeBasement.setXMax(28);
		addMapping(14999, slepeBasement);
		// GOAL
		// Shade Catacombs
		addMapping(13975, new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 13975, 0, -24));

		// Myreque Hideout Burgh de Rott
		addMapping(13974, new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 13973, 0, 24));

		// Ectofuntus Basement
		PlaneMapping ectofuntus = new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 14747, -16, -32);
		ectofuntus.setYMin(16);
		ectofuntus.setYMax(48);
		addMapping(14746, ectofuntus);

		// Port Phasmatys Brewery
		PlaneMapping phasBrewing = new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 14746, 0, -8);
		phasBrewing.setYMin(46);
		phasBrewing.setYMin(32);
		addMapping(14747, phasBrewing);

		// Paterdomus Underground
		addMapping(13722, new PlaneMapping(WorldMapArea.MORYTANIA_UNDERGROUND, 0, 13722, -16, -8));

		/* Mos Le'Harmless Cave */
		// All correctly placed

		/* Ourania Altar */
		// All correctly placed

		/* Prifddinas */
		// This is an interesting one for the mirror functionality. Two locations = same location on map

		/* Prifddinas Grand Library */

		// F1
		addMapping(10335, new PlaneMapping(WorldMapArea.PRIFDDINAS_GRAND_LIBRARY, 1, 11103));
		addMapping(10336, new PlaneMapping(WorldMapArea.PRIFDDINAS_GRAND_LIBRARY, 1, 11104));
		addMapping(10591, new PlaneMapping(WorldMapArea.PRIFDDINAS_GRAND_LIBRARY, 1, 11359));
		addMapping(10592, new PlaneMapping(WorldMapArea.PRIFDDINAS_GRAND_LIBRARY, 1, 11360));

		// F2
		addMapping(10335, new PlaneMapping(WorldMapArea.PRIFDDINAS_GRAND_LIBRARY, 2, 11871));
		addMapping(10336, new PlaneMapping(WorldMapArea.PRIFDDINAS_GRAND_LIBRARY, 2, 11872));
		addMapping(10591, new PlaneMapping(WorldMapArea.PRIFDDINAS_GRAND_LIBRARY, 2, 12127));
		addMapping(10592, new PlaneMapping(WorldMapArea.PRIFDDINAS_GRAND_LIBRARY, 2, 12128));

		/* Prifddinas Underground */

		// Trahaearn Mine
		addMapping(13250, new PlaneMapping(WorldMapArea.PRIFFDDINAS_UNDERGROUND, 0, 13249));

		// Zalcano
		addMapping(12126, new PlaneMapping(WorldMapArea.PRIFFDDINAS_UNDERGROUND, 0, 13250));

		// The Gauntlet
		PlaneMapping gauntlet = new PlaneMapping(WorldMapArea.PRIFFDDINAS_UNDERGROUND, 0, 12995, 0, -40);
		gauntlet.setYMin(36);
		addMapping(12127, gauntlet);

		/* Ruins of Camdozaal */
		// All correct

		/* Stronghold of Security */
		addMapping(7505, new PlaneMapping(WorldMapArea.STRONGHOLD_OF_SECURITY, 1, 7504, 32, -32));
		addMapping(7505, new PlaneMapping(WorldMapArea.STRONGHOLD_OF_SECURITY, 2, 7758));
		addMapping(7505, new PlaneMapping(WorldMapArea.STRONGHOLD_OF_SECURITY, 3, 7757, 32, -32));

		/* Stronghold Underground */
		// All correct

		/* Taverley Underground */

		// Taverley Dungeon F1
		addMapping(11161, new PlaneMapping(WorldMapArea.TAVERLEY_UNDERGROUND, 1, 11158));
		addMapping(11417, new PlaneMapping(WorldMapArea.TAVERLEY_UNDERGROUND, 1, 11414));
		addMapping(11673, new PlaneMapping(WorldMapArea.TAVERLEY_UNDERGROUND, 1, 11670));
		addMapping(11929, new PlaneMapping(WorldMapArea.TAVERLEY_UNDERGROUND, 1, 11926));

		// Warriors' Guild Basement
		PlaneMapping warriorsGuildBasementRegion = new PlaneMapping(WorldMapArea.TAVERLEY_UNDERGROUND,
			0, 11420, 0, -32);
		warriorsGuildBasementRegion.setXMin(16);
		warriorsGuildBasementRegion.setYMin(36);
		addMapping(11675, warriorsGuildBasementRegion);

		// Cerberus' Lair
		addMapping(5139, new PlaneMapping(WorldMapArea.TAVERLEY_UNDERGROUND, 0, 10650, 32, -8));

		/* The Abyss */
		// All correct

		/* Tolna's Rift */
		// All correct

		/* Troll Stronghold */
		addMapping(11421, new PlaneMapping(WorldMapArea.TROLL_STRONGHOLD, 1, 11677, 0, 32));
		addMapping(11421, new PlaneMapping(WorldMapArea.TROLL_STRONGHOLD, 2, 11934));

		/* Waterbirth Dungeon */

		// F0
		addMapping(7492, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 0, 10648, -16, 0));
		addMapping(7748, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 0, 10904, -16, 0));

		// F1
		addMapping(7236, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 1, 10393, -16, 32));
		addMapping(7492, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 1, 10649, -16, 32));
		addMapping(7748, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 1, 10905, -16, 32));

		// F2
		addMapping(7236, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 2, 10395, -16, 0));
		addMapping(7492, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 2, 10651, -16, 0));
		addMapping(7748, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 2, 10907, -16, 0));

		// F3
		addMapping(7236, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 3, 10397, -16, -32));
		addMapping(7492, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 3, 10653, -16, -32));
		addMapping(7748, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 3, 10909, -16, -32));

		// Dagg Kings
		addMapping(11589, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 0, 10647, -32, -32));

		// Ironman Dagg Kings
		addMapping(11588, new PlaneMapping(WorldMapArea.WATERBIRTH_DUNGEON, 0, 10903, -32, -32));

		/* Wilderness Dungeons */

		// Corporeal Beast
		addMapping(11844, new PlaneMapping(WorldMapArea.WILDERNESS_DUNGEONS, 2, 13213));

		// KBD Lair
		addMapping(9033, new PlaneMapping(WorldMapArea.WILDERNESS_DUNGEONS, 0, 12448, 8, 0));

		// Mage Arena Bank
		addMapping(10057, new PlaneMapping(WorldMapArea.WILDERNESS_DUNGEONS, 0, 12449, 0, 8));

		// Wilderness GWD
		addMapping(12190, new PlaneMapping(WorldMapArea.WILDERNESS_DUNGEONS, 0, 11933, -16, 24));
		// Wilderness GWD entrance
		addMapping(12190, new PlaneMapping(WorldMapArea.WILDERNESS_DUNGEONS, 3, 12190, -48, -24));

		/* Yanille Underground */

		// Small room
		PlaneMapping smallRoomRegion = new PlaneMapping(WorldMapArea.YANILLE_UNDERGROUND, 0, 10644, -48, -24);
		smallRoomRegion.setXMin(48);
		addMapping(10389, smallRoomRegion);

		// Poison spiders
		PlaneMapping poisonSpiderRoom = new PlaneMapping(WorldMapArea.YANILLE_UNDERGROUND, 0, 10131, 24, 8);
		poisonSpiderRoom.setXMax(47);
		addMapping(10389, poisonSpiderRoom);

		// Preferred implementation:
		// Loop through regionList, take oldX, oldY, oldPlane -> newX, newY
	}

	static void addMapping(Integer chunkID, PlaneMapping planeMapping)
	{
		realChunkToMapChunk.computeIfAbsent(chunkID, k -> new ArrayList<>()).add(planeMapping);
	}

	static public WorldPointWithWorldMapArea getMapWorldPointFromRealWorldPoint(WorldPoint realWorldPoint)
	{
		// TODO: Look into WORLDMAP_GETMAPNAME
//		ChunkWithPlane realChunkWithPlane = new ChunkWithPlane(realWorldPoint.getRegionID(), realWorldPoint.getPlane());
		List<PlaneMapping> mappedPlanes = realChunkToMapChunk.get(realWorldPoint.getRegionID());
		if (mappedPlanes == null)
		{
			return new WorldPointWithWorldMapArea(realWorldPoint, WorldMapArea.ANY);
		}

		for (PlaneMapping mappedPlane : mappedPlanes)
		{
			int requiredPlane = mappedPlane.getPlane();
			if (requiredPlane != -1 && requiredPlane != realWorldPoint.getPlane())
			{
				continue;
			}

			if (realWorldPoint.getRegionX() < mappedPlane.getXMin() || realWorldPoint.getRegionX() >= mappedPlane.getXMax())
			{
				continue;
			}

			if (realWorldPoint.getRegionY() < mappedPlane.getYMin() || realWorldPoint.getRegionY() >= mappedPlane.getYMax())
			{
				continue;
			}

			return new WorldPointWithWorldMapArea(WorldPoint.fromRegion(mappedPlane.targetChunkId,
				realWorldPoint.getRegionX() + mappedPlane.getShiftX(),
				realWorldPoint.getRegionY() + mappedPlane.getShiftY(),
				realWorldPoint.getPlane()), mappedPlane.worldMapArea);
		}

		// If no match is found, return the original realWorldPoint
		return new WorldPointWithWorldMapArea(realWorldPoint, WorldMapArea.ANY);
	}

	static public WorldPointWithWorldMapArea getRealWorldPointFromMapPoint(WorldPoint mapWorldPoint, WorldMapArea worldMapArea)
	{
		for (Map.Entry<Integer, List<PlaneMapping>> entry : realChunkToMapChunk.entrySet())
		{
			if (worldMapArea != WorldMapArea.ANY && entry.getValue().get(0).worldMapArea != worldMapArea)
			{
				continue;
			}

			for (PlaneMapping planeMapping : entry.getValue())
			{
				if (planeMapping.isMirror())
				{
					continue;
				}

				int shiftedWorldX = mapWorldPoint.getX() - planeMapping.getShiftX();
				int shiftedWorldY = mapWorldPoint.getY() - planeMapping.getShiftY();

				WorldPoint shiftedWorldPoint = new WorldPoint(shiftedWorldX, shiftedWorldY, 0);

				// Check if the mapWorldPoint's chunk ID matches any PlaneMapping's targetChunkId
				if (planeMapping.getTargetChunkId() == shiftedWorldPoint.getRegionID())
				{
					// Calculate the real world point based on the offsets
					int realRegionX = shiftedWorldPoint.getRegionX();
					int realRegionY = shiftedWorldPoint.getRegionY();
					int realPlane = planeMapping.getPlane();

					// Check if the calculated realRegionX and realRegionY fall within the bounds of the PlaneMapping
					if ((planeMapping.getXMin() <= realRegionX && realRegionX < planeMapping.getXMax()) ||
						(planeMapping.getXMin() == -1 && planeMapping.getXMax() == -1))
					{ // -1 for no bounds
						if (planeMapping.getXMin() <= realRegionX && realRegionX < planeMapping.getXMax() &&
							planeMapping.getYMin() <= realRegionY && realRegionY < planeMapping.getYMax())
						{
							return new WorldPointWithWorldMapArea(
								WorldPoint.fromRegion(entry.getKey(), realRegionX, realRegionY, realPlane),
								planeMapping.getWorldMapArea());
						}
					}
				}
			}
		}

		// If no matching mapping is found, return the original mapWorldPoint with WorldMapArea.ANY
		return new WorldPointWithWorldMapArea(mapWorldPoint, WorldMapArea.ANY);
	}
}

