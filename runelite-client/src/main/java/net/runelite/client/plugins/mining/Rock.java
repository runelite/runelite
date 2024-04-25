/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.mining;

import com.google.common.collect.ImmutableMap;
import java.time.Duration;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import static net.runelite.api.ObjectID.*;
import static net.runelite.client.util.RSTimeUnit.*;

enum Rock
{
	TIN(Duration.of(4, GAME_TICKS), 0, TIN_ROCKS_11360, TIN_ROCKS_11361),
	COPPER(Duration.of(4, GAME_TICKS), 0, COPPER_ROCKS_10943, COPPER_ROCKS_11161),
	IRON(Duration.of(9, GAME_TICKS), 0, IRON_ROCKS, IRON_ROCKS_11365, IRON_ROCKS_36203)
		{
			@Override
			Duration getRespawnTime(int region)
			{
				return region == MINING_GUILD ? Duration.of(4, GAME_TICKS) : super.respawnTime;
			}
		},
	COAL(Duration.of(49, GAME_TICKS), 0, COAL_ROCKS_11366, COAL_ROCKS_11367, COAL_ROCKS_36204)
		{
			@Override
			Duration getRespawnTime(int region)
			{
				switch (region)
				{
					case MINING_GUILD:
						return Duration.of(24, GAME_TICKS);
					case MISCELLANIA:
						return Duration.of(11, GAME_TICKS);
					default:
						return super.respawnTime;
				}
			}
		},
	SILVER(Duration.of(100, GAME_TICKS), 0, SILVER_ROCKS, SILVER_ROCKS_11369, SILVER_ROCKS_36205),
	SANDSTONE(Duration.of(9, GAME_TICKS), 0, SANDSTONE_ROCKS),
	GOLD(Duration.of(100, GAME_TICKS), 0, GOLD_ROCKS, GOLD_ROCKS_11371, GOLD_ROCKS_36206),
	GRANITE(Duration.of(9, GAME_TICKS), 0, GRANITE_ROCKS),
	MITHRIL(Duration.of(200, GAME_TICKS), 0, MITHRIL_ROCKS, MITHRIL_ROCKS_11373, MITHRIL_ROCKS_36207)
		{
			@Override
			Duration getRespawnTime(int region)
			{
				return region == MINING_GUILD ? Duration.of(100, GAME_TICKS) : super.respawnTime;
			}
		},
	LOVAKITE(Duration.of(MiningRocksOverlay.LOVAKITE_ORE_MAX_RESPAWN_TIME, GAME_TICKS), 0, LOVAKITE_ROCKS, LOVAKITE_ROCKS_28597),
	ADAMANTITE(Duration.of(400, GAME_TICKS), 0, ADAMANTITE_ROCKS, ADAMANTITE_ROCKS_11375, ADAMANTITE_ROCKS_36208)
		{
			@Override
			Duration getRespawnTime(int region)
			{
				return region == MINING_GUILD || region == WILDERNESS_RESOURCE_AREA ? Duration.of(200, GAME_TICKS) : super.respawnTime;
			}
		},
	RUNITE(Duration.of(1200, GAME_TICKS), 0, RUNITE_ROCKS, RUNITE_ROCKS_11377, RUNITE_ROCKS_36209)
		{
			@Override
			Duration getRespawnTime(int region)
			{
				return region == MINING_GUILD ? Duration.of(600, GAME_TICKS) : super.respawnTime;
			}
		},
	ORE_VEIN(Duration.ZERO /* unknown */, 150),
	AMETHYST(Duration.of(125, GAME_TICKS), 120),
	ASH_VEIN(Duration.of(50, GAME_TICKS), 0, ASH_PILE),
	GEM_ROCK(Duration.of(99, GAME_TICKS), 0, GEM_ROCKS, GEM_ROCKS_11381),
	URT_SALT(Duration.of(9, GAME_TICKS), 0, URT_SALT_ROCKS),
	EFH_SALT(Duration.of(9, GAME_TICKS), 0, EFH_SALT_ROCKS),
	TE_SALT(Duration.of(9, GAME_TICKS), 0, TE_SALT_ROCKS),
	BASALT(Duration.of(9, GAME_TICKS), 0, BASALT_ROCKS),
	DAEYALT_ESSENCE(Duration.of(MiningRocksOverlay.DAEYALT_MAX_RESPAWN_TIME, GAME_TICKS), 0, DAEYALT_ESSENCE_39095),
	BARRONITE(Duration.of(89, GAME_TICKS), 140),
	MINERAL_VEIN(Duration.of(100, GAME_TICKS), 150),
	CALCIFIED_ROCK(Duration.of(60, GAME_TICKS), 150, CALCIFIED_ROCKS, CALCIFIED_ROCKS_51487, CALCIFIED_ROCKS_51489, CALCIFIED_ROCKS_51491);

	private static final int WILDERNESS_RESOURCE_AREA = 12605;
	private static final int MISCELLANIA = 10044;
	private static final int MINING_GUILD = 12183;
	private static final Map<Integer, Rock> ROCKS;

	static
	{
		ImmutableMap.Builder<Integer, Rock> builder = new ImmutableMap.Builder<>();
		for (Rock rock : values())
		{
			for (int id : rock.ids)
			{
				builder.put(id, rock);
			}
		}
		ROCKS = builder.build();
	}

	private final Duration respawnTime;
	@Getter(AccessLevel.PACKAGE)
	private final int zOffset;
	private final int[] ids;

	Rock(Duration respawnTime, int zOffset, int... ids)
	{
		this.respawnTime = respawnTime;
		this.zOffset = zOffset;
		this.ids = ids;
	}

	Duration getRespawnTime(int region)
	{
		return respawnTime;
	}

	static Rock getRock(int id)
	{
		return ROCKS.get(id);
	}
}
