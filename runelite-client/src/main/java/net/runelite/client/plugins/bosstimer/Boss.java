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
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemID;

@Slf4j
enum Boss
{
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
	VETION("Vet'ion Reborn", 30, ChronoUnit.SECONDS, ItemID.VETION_JR),
	DAGANNOTH_PRIME("Dagannoth Prime", 90, ChronoUnit.SECONDS, ItemID.PET_DAGANNOTH_PRIME),
	DAGANNOTH_REX("Dagannoth Rex", 90, ChronoUnit.SECONDS, ItemID.PET_DAGANNOTH_REX),
	DAGANNOTH_SUPREME("Dagannoth Supreme", 90, ChronoUnit.SECONDS, ItemID.PET_DAGANNOTH_SUPREME),
	CORPOREAL_BEAST("Corporeal Beast", 30, ChronoUnit.SECONDS, ItemID.PET_DARK_CORE),
	GIANT_MOLE("Giant Mole", 10, ChronoUnit.SECONDS, ItemID.BABY_MOLE),
	DERANGED_ARCHAEOLOGIST("Deranged archaeologist", 30, ChronoUnit.SECONDS, ItemID.UNIDENTIFIED_LARGE_FOSSIL),
	CERBERUS("Cerberus", 10800, ChronoUnit.MILLIS, ItemID.HELLPUPPY),
	THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear smoke devil", 12, ChronoUnit.SECONDS, ItemID.PET_SMOKE_DEVIL),
	KRAKEN("Kraken", 10800, ChronoUnit.MILLIS, ItemID.PET_KRAKEN),
	KALPHITE_QUEEN("Kalphite Queen", 30, ChronoUnit.SECONDS, ItemID.KALPHITE_PRINCESS);

	private static final Map<String, Boss> bosses = new HashMap<>();

	private final String name;
	private final Duration spawnTime;
	private final int itemSpriteId;

	static
	{
		for (Boss boss : values())
		{
			bosses.put(boss.getName(), boss);
		}
	}

	private Boss(String name, long period, ChronoUnit unit, int itemSpriteId)
	{
		this.name = name;
		this.spawnTime = Duration.of(period, unit);
		this.itemSpriteId = itemSpriteId;
	}

	public String getName()
	{
		return name;
	}

	public Duration getSpawnTime()
	{
		return spawnTime;
	}

	public int getItemSpriteId()
	{
		return itemSpriteId;
	}

	public static Boss find(String name)
	{
		return bosses.get(name);
	}
}
