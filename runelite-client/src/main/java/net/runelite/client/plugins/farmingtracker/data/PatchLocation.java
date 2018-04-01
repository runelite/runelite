/*
 * Copyright (c) 2018, NotFoxtrot <https://github.com/NotFoxtrot>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.farmingtracker.data;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import static net.runelite.api.ObjectID.NULL_12605;
import static net.runelite.api.ObjectID.NULL_12606;
import static net.runelite.api.ObjectID.NULL_12607;
import static net.runelite.api.ObjectID.NULL_12608;
import static net.runelite.api.ObjectID.NULL_13422;
import static net.runelite.api.ObjectID.NULL_13423;
import static net.runelite.api.ObjectID.NULL_13424;
import static net.runelite.api.ObjectID.NULL_13425;
import static net.runelite.api.ObjectID.NULL_13426;
import static net.runelite.api.ObjectID.NULL_13427;
import static net.runelite.api.ObjectID.NULL_13428;
import static net.runelite.api.ObjectID.NULL_13429;
import static net.runelite.api.ObjectID.NULL_18816;
import static net.runelite.api.ObjectID.NULL_19147;
import static net.runelite.api.ObjectID.NULL_21950;
import static net.runelite.api.ObjectID.NULL_26579;
import static net.runelite.api.ObjectID.NULL_27111;
import static net.runelite.api.ObjectID.NULL_27113;
import static net.runelite.api.ObjectID.NULL_27114;
import static net.runelite.api.ObjectID.NULL_27115;
import static net.runelite.api.ObjectID.NULL_27116;
import static net.runelite.api.ObjectID.NULL_30480;
import static net.runelite.api.ObjectID.NULL_30481;
import static net.runelite.api.ObjectID.NULL_30482;
import static net.runelite.api.ObjectID.NULL_30500;
import static net.runelite.api.ObjectID.NULL_30501;
import static net.runelite.api.ObjectID.NULL_7572;
import static net.runelite.api.ObjectID.NULL_7577;
import static net.runelite.api.ObjectID.NULL_7578;
import static net.runelite.api.ObjectID.NULL_7579;
import static net.runelite.api.ObjectID.NULL_7580;
import static net.runelite.api.ObjectID.NULL_7771;
import static net.runelite.api.ObjectID.NULL_7807;
import static net.runelite.api.ObjectID.NULL_7847;
import static net.runelite.api.ObjectID.NULL_7848;
import static net.runelite.api.ObjectID.NULL_7849;
import static net.runelite.api.ObjectID.NULL_7850;
import static net.runelite.api.ObjectID.NULL_7962;
import static net.runelite.api.ObjectID.NULL_7963;
import static net.runelite.api.ObjectID.NULL_7964;
import static net.runelite.api.ObjectID.NULL_7965;
import static net.runelite.api.ObjectID.NULL_8150;
import static net.runelite.api.ObjectID.NULL_8151;
import static net.runelite.api.ObjectID.NULL_8152;
import static net.runelite.api.ObjectID.NULL_8153;
import static net.runelite.api.ObjectID.NULL_8173;
import static net.runelite.api.ObjectID.NULL_8174;
import static net.runelite.api.ObjectID.NULL_8175;
import static net.runelite.api.ObjectID.NULL_8176;
import static net.runelite.api.ObjectID.NULL_8337;
import static net.runelite.api.ObjectID.NULL_8338;
import static net.runelite.api.ObjectID.NULL_8382;
import static net.runelite.api.ObjectID.NULL_8383;
import static net.runelite.api.ObjectID.NULL_8388;
import static net.runelite.api.ObjectID.NULL_8389;
import static net.runelite.api.ObjectID.NULL_8390;
import static net.runelite.api.ObjectID.NULL_8391;
import static net.runelite.api.ObjectID.NULL_8550;
import static net.runelite.api.ObjectID.NULL_8551;
import static net.runelite.api.ObjectID.NULL_8552;
import static net.runelite.api.ObjectID.NULL_8553;
import static net.runelite.api.ObjectID.NULL_8554;
import static net.runelite.api.ObjectID.NULL_8555;
import static net.runelite.api.ObjectID.NULL_8556;
import static net.runelite.api.ObjectID.NULL_8557;
import static net.runelite.api.ObjectID.NULL_9372;
import net.runelite.api.Query;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.queries.GameObjectQuery;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_10;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_160;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_20;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_320;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_40;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_5;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_8;
import static net.runelite.client.plugins.farmingtracker.data.FarmingTick.TICK_80;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.ALLOTMENT;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.BUSH;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.FLOWER;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.FRUIT_TREE;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.HERB;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.HOP;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.SPECIAL;
import static net.runelite.client.plugins.farmingtracker.data.PatchType.TREE;
import net.runelite.client.util.QueryRunner;

@Getter
@AllArgsConstructor
public enum PatchLocation
{
	/**
	 * Al Kharid
	 */
	AL_KHARID_CACTUS("Al Kharid", SPECIAL, NULL_7771, TICK_80),

	/**
	 * Ardougne
	 */
	ARDOUGNE_ALLOTMENT_N("North of Ardougne(North)", ALLOTMENT, NULL_8554, TICK_10),
	ARDOUGNE_ALLOTMENT_S("North of Ardougne(South)", ALLOTMENT, NULL_8555, TICK_10),
	ARDOUGNE_FLOWER("North of Ardougne", FLOWER, NULL_7849, TICK_5),
	ARDOUGNE_HERB("North of Ardougne", HERB, NULL_8152, TICK_20),
	ARDOUGNE_BUSH("South of Ardounge", BUSH, NULL_7580, TICK_20),

	/**
	 * Brimhaven
	 */
	BRIMHAVEN_FRUIT_TREE("Brimhaven", FRUIT_TREE, NULL_7964, TICK_160),
	BRIMHAVEN_SPIRIT_TREE("Brimhaven", SPECIAL, NULL_8383, TICK_320),

	/**
	 * Catherby
	 */
	CATHERBY_ALLOTMENT_N("Catherby(North)", ALLOTMENT, NULL_8552, TICK_10),
	CATHERBY_ALLOTMENT_S("Catherby(South)", ALLOTMENT, NULL_8553, TICK_10),
	CATHERBY_FLOWER("Catherby", FLOWER, NULL_7848, TICK_5),
	CATHERBY_HERB("Catherby", HERB, NULL_8151, TICK_20),
	CATHERBY_FRUIT_TREE("Catherby", FRUIT_TREE, NULL_7965, TICK_160),

	/**
	 * Champions' Guild
	 */
	CHAMPIONS_GUILD_BUSH("Champions' Guild", BUSH, NULL_7577, TICK_20),

	/**
	 * Draynor Manor
	 */
	DRAYNOR_MANOR_BELLADONNA("Draynor Manor", SPECIAL, NULL_7572, TICK_80),

	/**
	 * Etceteria
	 */
	ETCETERIA_SPIRIT_TREE("Etceteria", SPECIAL, NULL_8382, TICK_320),
	ETCETERIA_BUSH("Etceteria", BUSH, NULL_7579, TICK_20),

	/**
	 * Entrana
	 */
	ENTRANA_HOP("Entrana", HOP, NULL_8174, TICK_10),

	/**
	 * Falador
	 */
	FALADOR_ALLOTMENT_NW("Falador(North West)", ALLOTMENT, NULL_8550, TICK_10),
	FALADOR_ALLOTMENT_SE("Falador(South East)", ALLOTMENT, NULL_8551, TICK_10),
	FALADOR_FLOWER("Falador", FLOWER, NULL_7847, TICK_5),
	FALADOR_HERB("Falador", HERB, NULL_8150, TICK_20),
	FALADOR_TREE("Falador", TREE, NULL_8389, TICK_40),

	/**
	 * Fossil Island
	 */
	FOSSIL_ISLAND_TREE_HARDWOOD_EAST("Fossil Island(East)", SPECIAL, NULL_30482, TICK_320),
	FOSSIL_ISLAND_TREE_HARDWOOD_MIDDLE("Fossil Island(Middle)", SPECIAL, NULL_30480, TICK_320),
	FOSSIL_ISLAND_TREE_HARDWOOD_WEST("Fossil Island(West)", SPECIAL, NULL_30481, TICK_320),
	FOSSIL_ISLAND_GIANT_SEAWEED_N("Fossil Island(North)", SPECIAL, NULL_30500, TICK_10),
	FOSSIL_ISLAND_GIANT_SEAWEED_S("Fossil Island(South)", SPECIAL, NULL_30501, TICK_10),

	/**
	 * Gnome Stronghold
	 */
	GNOME_STRONGHOLD_TREE("Gnome Stronghold", TREE, NULL_19147, TICK_40),
	GNOME_STRONGHOLD_FRUIT_TREE("Gnome Stronghold", FRUIT_TREE, NULL_7962, TICK_160),

	/**
	 * Harmony Island
	 */
	HARMONY_ISLAND_ALLOTMENT("Harmony Island", ALLOTMENT, NULL_21950, TICK_10),
	HARMONY_ISLAND_HERB("Harmony Island", HERB, NULL_9372, TICK_20),

	/**
	 * Kourend
	 */
	KOUREND_ALLOTMENT_NE("Kourend(North East)", ALLOTMENT, NULL_27113, TICK_10),
	KOUREND_ALLOTMENT_SW("Kourend(South West)", ALLOTMENT, NULL_27114, TICK_10),
	KOUREND_FLOWER("Kourend", FLOWER, NULL_27111, TICK_5),
	KOUREND_HERB("Kourend", HERB, NULL_27115, TICK_20),
	KOUREND_SPIRIT_TREE("Kourend", SPECIAL, NULL_27116, TICK_320),
	KOUREND_GRAPES_1("Kourend(West 1)", SPECIAL, NULL_12605, TICK_8),
	KOUREND_GRAPES_2("Kourend(West 2)", SPECIAL, NULL_12606, TICK_8),
	KOUREND_GRAPES_3("Kourend(West 3)", SPECIAL, NULL_12607, TICK_8),
	KOUREND_GRAPES_4("Kourend(West 4)", SPECIAL, NULL_12608, TICK_8),
	KOUREND_GRAPES_5("Kourend(West 5)", SPECIAL, NULL_13422, TICK_8),
	KOUREND_GRAPES_6("Kourend(West 6)", SPECIAL, NULL_13423, TICK_8),
	KOUREND_GRAPES_7("Kourend(East 1)", SPECIAL, NULL_13424, TICK_8),
	KOUREND_GRAPES_8("Kourend(East 2)", SPECIAL, NULL_13425, TICK_8),
	KOUREND_GRAPES_9("Kourend(East 3)", SPECIAL, NULL_13426, TICK_8),
	KOUREND_GRAPES_10("Kourend(East 4)", SPECIAL, NULL_13427, TICK_8),
	KOUREND_GRAPES_11("Kourend(East 5)", SPECIAL, NULL_13428, TICK_8),
	KOUREND_GRAPES_12("Kourend(East 6)", SPECIAL, NULL_13429, TICK_8),

	/**
	 * Lletya
	 */
	LLETYA_FRUIT_TREE("Lletya", FRUIT_TREE, NULL_26579, TICK_160),

	/**
	 * Lumbridge
	 */
	LUMBRIDGE_HOP("Lumbridge", HOP, NULL_8175, TICK_10),
	LUMBRIDGE_TREE("Lumbridge", TREE, NULL_8391, TICK_40),

	/**
	 * Morytania
	 */
	MORYTANIA_ALLOTMENT_NW("Morytania(North West)", ALLOTMENT, NULL_8556, TICK_10),
	MORYTANIA_ALLOTMENT_SE("Morytania(South East)", ALLOTMENT, NULL_8557, TICK_10),
	MORYTANIA_FLOWER("Morytania", FLOWER, NULL_7850, TICK_5),
	MORYTANIA_HERB("Morytania", HERB, NULL_8153, TICK_20),
	MORYTANIA_MUSHROOM("Morytania", SPECIAL, NULL_8337, TICK_80),

	/**
	 * Port Sarim
	 */
	PORT_SARIM_SPIRIT_TREE("Port Sarim", SPECIAL, NULL_8338, TICK_320),

	/**
	 * Rimmington
	 */
	RIMMINGTON_BUSH("Rimmington", BUSH, NULL_7578, TICK_20),

	/**
	 * Seers' Village
	 */
	SEERS_VILLAGE_HOP("Seers' Village", HOP, NULL_8176, TICK_10),

	/**
	 * Tai Bwo Wannai
	 */
	TAI_BWO_WANNI_CALQUAT("Tai Bwo Wannai", SPECIAL, NULL_7807, TICK_160),

	/**
	 * Taverley
	 */
	TAVERLEY_TREE("Taverley", TREE, NULL_8388, TICK_40),

	/**
	 * Tree Gnome Village
	 */
	TREE_GNOME_VILLAGE_FRUIT_TREE("Tree Gnome Village", FRUIT_TREE, NULL_7963, TICK_160),

	/**
	 * Troll Stronghold
	 */
	TROLL_STRONGHOLD_HERB("Troll Stronghold", HERB, NULL_18816, TICK_20),

	/**
	 * Varrock
	 */
	VARROCK_TREE("Varrock", TREE, NULL_8390, TICK_40),

	/**
	 * Yanille
	 */
	YANILLE_HOP("Yanille", HOP, NULL_8173, TICK_10);

	private final String location;
	private final PatchType patchType;
	private final int patchObjectId;
	private final FarmingTick farmingTick;

	public static Set<PatchLocation> findByPatchType(PatchType patchType)
	{
		Set<PatchLocation> patchLocations = new HashSet<>();

		for (PatchLocation patchLocation : PatchLocation.values())
		{
			if (patchLocation.getPatchType().equals(patchType))
			{
				patchLocations.add(patchLocation);
			}
		}

		return patchLocations;
	}

	public static PatchLocation findByPatchObjectId(int objectId)
	{
		for (PatchLocation patchLocation : PatchLocation.values())
		{
			if (patchLocation.getPatchObjectId() == objectId)
			{
				return patchLocation;
			}
		}

		return null;
	}

	public static PatchLocation findByWorldLocation(Client client, QueryRunner queryRunner, int x, int y)
	{
		PatchLocation patchLocation = queryOnWorldLocation(client, queryRunner, x, y);

		if (patchLocation == null)
		{
			patchLocation = queryOnWorldLocation(client, queryRunner, x + 1, y + 1);
		}

		return patchLocation;
	}

	private static PatchLocation queryOnWorldLocation(Client client, QueryRunner queryRunner, int x, int y)
	{
		WorldPoint worldPoint = WorldPoint.fromRegion(client, x, y, client.getPlane());

		Query gameObjectQuery = new GameObjectQuery().atWorldLocation(worldPoint);
		GameObject[] gameObjects = queryRunner.runQuery(gameObjectQuery);

		if (gameObjects.length != 0)
		{
			return findByPatchObjectId(gameObjects[0].getId());
		}

		return null;
	}
}
