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

import com.google.common.collect.ImmutableMap;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Map;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;
import net.runelite.client.util.RSTimeUnit;

enum Boss
{
	GENERAL_GRAARDOR(NpcID.GENERAL_GRAARDOR, 90, ChronoUnit.SECONDS, ItemID.PET_GENERAL_GRAARDOR),
	KRIL_TSUTSAROTH(NpcID.KRIL_TSUTSAROTH, 90, ChronoUnit.SECONDS, ItemID.PET_KRIL_TSUTSAROTH),
	KREEARRA(NpcID.KREEARRA, 90, ChronoUnit.SECONDS, ItemID.PET_KREEARRA),
	COMMANDER_ZILYANA(NpcID.COMMANDER_ZILYANA, 90, ChronoUnit.SECONDS, ItemID.PET_ZILYANA),
	CALLISTO(NpcID.CALLISTO_6609, 29, RSTimeUnit.GAME_TICKS, ItemID.CALLISTO_CUB),
	ARTIO(NpcID.ARTIO, 29, RSTimeUnit.GAME_TICKS, ItemID.CALLISTO_CUB),
	CHAOS_ELEMENTAL(NpcID.CHAOS_ELEMENTAL, 15, ChronoUnit.SECONDS, ItemID.PET_CHAOS_ELEMENTAL),
	CHAOS_FANATIC(NpcID.CHAOS_FANATIC, 30, ChronoUnit.SECONDS, ItemID.ANCIENT_STAFF),
	CRAZY_ARCHAEOLOGIST(NpcID.CRAZY_ARCHAEOLOGIST, 30, ChronoUnit.SECONDS, ItemID.FEDORA),
	KING_BLACK_DRAGON(NpcID.KING_BLACK_DRAGON, 9, ChronoUnit.SECONDS, ItemID.PRINCE_BLACK_DRAGON),
	SCORPIA(NpcID.SCORPIA, 16, RSTimeUnit.GAME_TICKS, ItemID.SCORPIAS_OFFSPRING),
	SCURRIUS(NpcID.SCURRIUS, 29, RSTimeUnit.GAME_TICKS, ItemID.SCURRY),
	SCURRIUS_PRIVATE(NpcID.SCURRIUS_7222, 29, RSTimeUnit.GAME_TICKS, ItemID.SCURRY),
	VENENATIS(NpcID.VENENATIS_6610, 28, RSTimeUnit.GAME_TICKS, ItemID.VENENATIS_SPIDERLING),
	SPINDEL(NpcID.SPINDEL, 28, RSTimeUnit.GAME_TICKS, ItemID.VENENATIS_SPIDERLING),
	VETION(NpcID.VETION_6612, 33, RSTimeUnit.GAME_TICKS, ItemID.VETION_JR),
	CALVARION(NpcID.CALVARION_11994, 33, RSTimeUnit.GAME_TICKS, ItemID.VETION_JR),
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
	DUSK(NpcID.DUSK_7889, 5, ChronoUnit.MINUTES, ItemID.NOON),
	ALCHEMICAL_HYDRA(NpcID.ALCHEMICAL_HYDRA_8622, 25200, ChronoUnit.MILLIS, ItemID.IKKLE_HYDRA),
	SARACHNIS(NpcID.SARACHNIS, 16, RSTimeUnit.GAME_TICKS, ItemID.SRARACHA),
	ZALCANO(NpcID.ZALCANO_9050, 21600, ChronoUnit.MILLIS, ItemID.SMOLCANO),
	PHANTOM_MUSPAH(NpcID.PHANTOM_MUSPAH_12080, 50, RSTimeUnit.GAME_TICKS, ItemID.MUPHIN),
	THE_LEVIATHAN(NpcID.THE_LEVIATHAN, 30, RSTimeUnit.GAME_TICKS, ItemID.LILVIATHAN),
	;

	private static final Map<Integer, Boss> bosses;

	private final int id;
	private final Duration spawnTime;
	private final int itemSpriteId;

	static
	{
		ImmutableMap.Builder<Integer, Boss> builder = new ImmutableMap.Builder<>();

		for (Boss boss : values())
		{
			builder.put(boss.getId(), boss);
		}

		bosses = builder.build();
	}

	Boss(int id, long period, TemporalUnit unit, int itemSpriteId)
	{
		this.id = id;
		this.spawnTime = Duration.of(period, unit);
		this.itemSpriteId = itemSpriteId;
	}

	public int getId()
	{
		return id;
	}

	public Duration getSpawnTime()
	{
		return spawnTime;
	}

	public int getItemSpriteId()
	{
		return itemSpriteId;
	}

	public static Boss find(int id)
	{
		return bosses.get(id);
	}
}
