/*
 * Copyright (c) 2016-2017, Cameron Moberg <Moberg@tuta.io>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.bosstimer;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.ItemID;
<<<<<<< HEAD
=======
import net.runelite.api.NpcID;
>>>>>>> upstream/master

enum Boss
{
<<<<<<< HEAD
	GENERAL_GRAARDOR("General Graardor", 90, ChronoUnit.SECONDS, ItemID.PET_GENERAL_GRAARDOR),
	KRIL_TSUTSAROTH("K'ril Tsutsaroth", 90, ChronoUnit.SECONDS, ItemID.PET_KRIL_TSUTSAROTH),
	KREEARRA("Kree'arra", 90, ChronoUnit.SECONDS, ItemID.PET_KREEARRA),
	COMMANDER_ZILYANA("Commander Zilyana", 90, ChronoUnit.SECONDS, ItemID.PET_ZILYANA),
	CALLISTO("Callisto", 30, ChronoUnit.SECONDS, ItemID.CALLISTO_CUB),
	CHAOS_ELEMENTAL("Chaos Elemental", 150, ChronoUnit.SECONDS, ItemID.PET_CHAOS_ELEMENTAL),
	CHAOS_FANATIC("Chaos fanatic", 30, ChronoUnit.SECONDS, ItemID.ANCIENT_STAFF),
	CRAZY_ARCHAEOLOGIST("Crazy archaeologist", 30, ChronoUnit.SECONDS, ItemID.FEDORA),
	KING_BLACK_DRAGON("King Black Dragon", 10, ChronoUnit.SECONDS, ItemID.PRINCE_BLACK_DRAGON),
	SCORPIA("Scorpia", 10, ChronoUnit.SECONDS, ItemID.SCORPIAS_OFFSPRING),
	VENENATIS("Venenatis", 30, ChronoUnit.SECONDS, ItemID.VENENATIS_SPIDERLING),
	VETION("Vet'ion", 30, ChronoUnit.SECONDS, ItemID.VETION_JR),
	DAGANNOTH_PRIME("Dagannoth Prime", 90, ChronoUnit.SECONDS, ItemID.PET_DAGANNOTH_PRIME),
	DAGANNOTH_REX("Dagannoth Rex", 90, ChronoUnit.SECONDS, ItemID.PET_DAGANNOTH_REX),
	DAGANNOTH_SUPREME("Dagannoth Supreme", 90, ChronoUnit.SECONDS, ItemID.PET_DAGANNOTH_SUPREME),
	CORPOREAL_BEAST("Corporeal Beast", 30, ChronoUnit.SECONDS, ItemID.PET_DARK_CORE),
	GIANT_MOLE("Giant Mole", 10, ChronoUnit.SECONDS, ItemID.BABY_MOLE),
	DERANGED_ARCHAEOLOGIST("Deranged archaeologist", 30, ChronoUnit.SECONDS, ItemID.UNIDENTIFIED_LARGE_FOSSIL),
	CERBERUS("Cerberus", 10800, ChronoUnit.MILLIS, ItemID.HELLPUPPY),
	THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear smoke devil", 12, ChronoUnit.SECONDS, ItemID.PET_SMOKE_DEVIL),
	KRAKEN("Kraken", 10800, ChronoUnit.MILLIS, ItemID.PET_KRAKEN);

	private static final Map<String, Boss> bosses = new HashMap<>();

	private final String name;
=======
	GENERAL_GRAARDOR(NpcID.GENERAL_GRAARDOR, 90, ChronoUnit.SECONDS, ItemID.PET_GENERAL_GRAARDOR),
	KRIL_TSUTSAROTH(NpcID.KRIL_TSUTSAROTH, 90, ChronoUnit.SECONDS, ItemID.PET_KRIL_TSUTSAROTH),
	KREEARRA(NpcID.KREEARRA, 90, ChronoUnit.SECONDS, ItemID.PET_KREEARRA),
	COMMANDER_ZILYANA(NpcID.COMMANDER_ZILYANA, 90, ChronoUnit.SECONDS, ItemID.PET_ZILYANA),
	CALLISTO(NpcID.CALLISTO_6609, 30, ChronoUnit.SECONDS, ItemID.CALLISTO_CUB),
	CHAOS_ELEMENTAL(NpcID.CHAOS_ELEMENTAL, 150, ChronoUnit.SECONDS, ItemID.PET_CHAOS_ELEMENTAL),
	CHAOS_FANATIC(NpcID.CHAOS_FANATIC, 30, ChronoUnit.SECONDS, ItemID.ANCIENT_STAFF),
	CRAZY_ARCHAEOLOGIST(NpcID.CRAZY_ARCHAEOLOGIST, 30, ChronoUnit.SECONDS, ItemID.FEDORA),
	KING_BLACK_DRAGON(NpcID.KING_BLACK_DRAGON, 9, ChronoUnit.SECONDS, ItemID.PRINCE_BLACK_DRAGON),
	SCORPIA(NpcID.SCORPIA, 10, ChronoUnit.SECONDS, ItemID.SCORPIAS_OFFSPRING),
	VENENATIS(NpcID.VENENATIS_6610, 30, ChronoUnit.SECONDS, ItemID.VENENATIS_SPIDERLING),
	VETION(NpcID.VETION_REBORN, 30, ChronoUnit.SECONDS, ItemID.VETION_JR),
	DAGANNOTH_PRIME(NpcID.DAGANNOTH_PRIME, 90, ChronoUnit.SECONDS, ItemID.PET_DAGANNOTH_PRIME),
	DAGANNOTH_REX(NpcID.DAGANNOTH_REX, 90, ChronoUnit.SECONDS, ItemID.PET_DAGANNOTH_REX),
	DAGANNOTH_SUPREME(NpcID.DAGANNOTH_SUPREME, 90, ChronoUnit.SECONDS, ItemID.PET_DAGANNOTH_SUPREME),
	CORPOREAL_BEAST(NpcID.CORPOREAL_BEAST, 30, ChronoUnit.SECONDS, ItemID.PET_DARK_CORE),
	GIANT_MOLE(NpcID.GIANT_MOLE, 9000, ChronoUnit.MILLIS, ItemID.BABY_MOLE),
	DERANGED_ARCHAEOLOGIST(NpcID.DERANGED_ARCHAEOLOGIST, 29400, ChronoUnit.MILLIS, ItemID.UNIDENTIFIED_LARGE_FOSSIL),
	CERBERUS(NpcID.CERBERUS, 8400, ChronoUnit.MILLIS, ItemID.HELLPUPPY),
	THERMONUCLEAR_SMOKE_DEVIL(NpcID.THERMONUCLEAR_SMOKE_DEVIL, 8400, ChronoUnit.MILLIS, ItemID.PET_SMOKE_DEVIL),
	KRAKEN(NpcID.KRAKEN, 8400, ChronoUnit.MILLIS, ItemID.PET_KRAKEN),
	KALPHITE_QUEEN(NpcID.KALPHITE_QUEEN_965, 30, ChronoUnit.SECONDS, ItemID.KALPHITE_PRINCESS),
	DUSK(NpcID.DUSK_7889, 2, ChronoUnit.MINUTES, ItemID.NOON),
	ALCHEMICAL_HYDRA(NpcID.ALCHEMICAL_HYDRA_8622, 25200, ChronoUnit.MILLIS, ItemID.IKKLE_HYDRA);

	private static final Map<Integer, Boss> bosses = new HashMap<>();

	private final int id;
>>>>>>> upstream/master
	private final Duration spawnTime;
	private final int itemSpriteId;

	static
	{
		for (Boss boss : values())
		{
<<<<<<< HEAD
			bosses.put(boss.getName(), boss);
		}
	}

	private Boss(String name, long period, ChronoUnit unit, int itemSpriteId)
	{
		this.name = name;
=======
			bosses.put(boss.getId(), boss);
		}
	}

	private Boss(int id, long period, ChronoUnit unit, int itemSpriteId)
	{
		this.id = id;
>>>>>>> upstream/master
		this.spawnTime = Duration.of(period, unit);
		this.itemSpriteId = itemSpriteId;
	}

<<<<<<< HEAD
	public String getName()
	{
		return name;
=======
	public int getId()
	{
		return id;
>>>>>>> upstream/master
	}

	public Duration getSpawnTime()
	{
		return spawnTime;
	}

	public int getItemSpriteId()
	{
		return itemSpriteId;
	}

<<<<<<< HEAD
	public static Boss find(String name)
	{
		return bosses.get(name);
=======
	public static Boss find(int id)
	{
		return bosses.get(id);
>>>>>>> upstream/master
	}
}
