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
import lombok.Getter;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import net.runelite.client.util.RSTimeUnit;

@Getter
enum Boss
{
	GENERAL_GRAARDOR(NpcID.GODWARS_BANDOS_AVATAR, 90, ChronoUnit.SECONDS, ItemID.BANDOSPET),
	KRIL_TSUTSAROTH(NpcID.GODWARS_ZAMORAK_AVATAR, 90, ChronoUnit.SECONDS, ItemID.ZAMORAKPET),
	KREEARRA(NpcID.GODWARS_ARMADYL_AVATAR, 90, ChronoUnit.SECONDS, ItemID.ARMADYLPET),
	COMMANDER_ZILYANA(NpcID.GODWARS_SARADOMIN_AVATAR, 90, ChronoUnit.SECONDS, ItemID.SARADOMINPET),
	CALLISTO(NpcID.CALLISTO, 11, RSTimeUnit.GAME_TICKS, ItemID.CALLISTO_PET),
	ARTIO(NpcID.CALLISTO_SINGLES, 11, RSTimeUnit.GAME_TICKS, ItemID.CALLISTO_PET),
	CHAOS_ELEMENTAL(NpcID.CHAOSELEMENTAL, 14, RSTimeUnit.GAME_TICKS, ItemID.CHAOSELEPET),
	CHAOS_FANATIC(NpcID.CHAOS_FANATIC, 14, RSTimeUnit.GAME_TICKS, ItemID.STAFF_OF_ZAROS),
	CRAZY_ARCHAEOLOGIST(NpcID.CRAZY_ARCHAEOLOGIST, 9, ChronoUnit.SECONDS, ItemID.FEDORA),
	KING_BLACK_DRAGON(NpcID.KING_DRAGON, 9, ChronoUnit.SECONDS, ItemID.KBDPET),
	SCORPIA(NpcID.SCORPIA, 14, RSTimeUnit.GAME_TICKS, ItemID.SCORPIA_PET),
	SCURRIUS(NpcID.RAT_BOSS_NORMAL, 29, RSTimeUnit.GAME_TICKS, ItemID.SCURRIUSPET),
	SCURRIUS_PRIVATE(NpcID.RAT_BOSS_INSTANCE, 29, RSTimeUnit.GAME_TICKS, ItemID.SCURRIUSPET),
	VENENATIS(NpcID.VENENATIS, 10, RSTimeUnit.GAME_TICKS, ItemID.VENENATIS_PET),
	SPINDEL(NpcID.VENENATIS_SINGLES, 9, RSTimeUnit.GAME_TICKS, ItemID.VENENATIS_PET),
	VETION(NpcID.VETION_2, 15, RSTimeUnit.GAME_TICKS, ItemID.VETION_PET),
	CALVARION(NpcID.VETION_2_SINGLE, 14, RSTimeUnit.GAME_TICKS, ItemID.VETION_PET),
	DAGANNOTH_PRIME(NpcID.DAGCAVE_MAGIC_BOSS, 90, ChronoUnit.SECONDS, ItemID.PRIMEPET),
	DAGANNOTH_REX(NpcID.DAGCAVE_MELEE_BOSS, 90, ChronoUnit.SECONDS, ItemID.REXPET),
	DAGANNOTH_SUPREME(NpcID.DAGCAVE_RANGED_BOSS, 90, ChronoUnit.SECONDS, ItemID.SUPREMEPET),
	CORPOREAL_BEAST(NpcID.CORP_BEAST, 30, ChronoUnit.SECONDS, ItemID.COREPET),
	GIANT_MOLE(NpcID.MOLE_GIANT, 9000, ChronoUnit.MILLIS, ItemID.MOLEPET),
	DERANGED_ARCHAEOLOGIST(NpcID.FOSSIL_CRAZY_ARCHAEOLOGIST, 29400, ChronoUnit.MILLIS, ItemID.FOSSIL_LARGE_UNID),
	CERBERUS(NpcID.CERBERUS_ATTACKING, 8400, ChronoUnit.MILLIS, ItemID.HELL_PET),
	THERMONUCLEAR_SMOKE_DEVIL(NpcID.SMOKE_DEVIL_BOSS, 8400, ChronoUnit.MILLIS, ItemID.SMOKEPET),
	KRAKEN(NpcID.SLAYER_KRAKEN_BOSS, 8400, ChronoUnit.MILLIS, ItemID.KRAKENPET),
	KALPHITE_QUEEN(NpcID.KALPHITE_FLYINGQUEEN, 30, ChronoUnit.SECONDS, ItemID.KQPET_WALKING),
	DUSK(NpcID.GARGBOSS_DUSK_DEATH, 5, ChronoUnit.MINUTES, ItemID.DAWNPET),
	ALCHEMICAL_HYDRA(NpcID.HYDRABOSS_FINALDEATH, 25200, ChronoUnit.MILLIS, ItemID.HYDRAPET),
	SARACHNIS(NpcID.SARACHNIS, 16, RSTimeUnit.GAME_TICKS, ItemID.SARACHNISPET),
	ZALCANO(NpcID.ZALCANO_WEAK, 21600, ChronoUnit.MILLIS, ItemID.ZALCANOPET),
	PHANTOM_MUSPAH(NpcID.MUSPAH_FINAL, 50, RSTimeUnit.GAME_TICKS, ItemID.MUSPAHPET),
	THE_LEVIATHAN(NpcID.LEVIATHAN, 30, RSTimeUnit.GAME_TICKS, ItemID.LEVIATHANPET),
	// Harvestable Araxxor is not marked dead so that it is always interactable and visible,
	// but we still want the respawn timer to show when it despawns.
	ARAXXOR(NpcID.ARAXXOR_DEAD, 15, RSTimeUnit.GAME_TICKS, ItemID.ARAXXORPET, true),
	AMOXLIATL(NpcID.AMOXLIATL, 28, RSTimeUnit.GAME_TICKS, ItemID.AMOXLIATLPET),
	HUEYCOATL(NpcID.HUEY_HEAD_DEFEATED, 50, RSTimeUnit.GAME_TICKS, ItemID.HUEYPET),
	;

	private static final Map<Integer, Boss> bosses;

	private final int id;
	private final Duration spawnTime;
	private final int itemSpriteId;
	private final boolean ignoreDead;

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
		this(id, period, unit, itemSpriteId, false);
	}

	Boss(int id, long period, TemporalUnit unit, int itemSpriteId, boolean ignoreDead)
	{
		this.id = id;
		this.spawnTime = Duration.of(period, unit);
		this.itemSpriteId = itemSpriteId;
		this.ignoreDead = ignoreDead;
	}

	static Boss find(int id)
	{
		return bosses.get(id);
	}
}
