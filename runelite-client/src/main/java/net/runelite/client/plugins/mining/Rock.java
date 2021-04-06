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
	TIN(Duration.of(4, GAME_TICKS), 0, ROCKS_11360, ROCKS_11361),
	COPPER(Duration.of(4, GAME_TICKS), 0, ROCKS_10943, ROCKS_11161),
	IRON(Duration.of(9, GAME_TICKS), 0, ROCKS_11364, ROCKS_11365, ROCKS_36203)
		{
			@Override
			Duration getRespawnTime(int region)
			{
				return region == MINING_GUILD ? Duration.of(4, GAME_TICKS) : super.respawnTime;
			}
		},
	COAL(Duration.of(49, GAME_TICKS), 0, ROCKS_11366, ROCKS_11367, ROCKS_36204)
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
	SILVER(Duration.of(100, GAME_TICKS), 0, ROCKS_11368, ROCKS_11369, ROCKS_36205),
	SANDSTONE(Duration.of(9, GAME_TICKS), 0, ROCKS_11386),
	GOLD(Duration.of(100, GAME_TICKS), 0, ROCKS_11370, ROCKS_11371, ROCKS_36206),
	GRANITE(Duration.of(9, GAME_TICKS), 0, ROCKS_11387),
	MITHRIL(Duration.of(200, GAME_TICKS), 0, ROCKS_11372, ROCKS_11373, ROCKS_36207)
		{
			@Override
			Duration getRespawnTime(int region)
			{
				return region == MINING_GUILD ? Duration.of(100, GAME_TICKS) : super.respawnTime;
			}
		},
	LOVAKITE(Duration.of(MiningRocksOverlay.LOVAKITE_ORE_MAX_RESPAWN_TIME, GAME_TICKS), 0, ROCKS_28596, ROCKS_28597),
	ADAMANTITE(Duration.of(400, GAME_TICKS), 0, ROCKS_11374, ROCKS_11375, ROCKS_36208)
		{
			@Override
			Duration getRespawnTime(int region)
			{
				return region == MINING_GUILD || region == WILDERNESS_RESOURCE_AREA ? Duration.of(200, GAME_TICKS) : super.respawnTime;
			}
		},
	RUNITE(Duration.of(1200, GAME_TICKS), 0, ROCKS_11376, ROCKS_11377, ROCKS_36209)
		{
			@Override
			Duration getRespawnTime(int region)
			{
				return region == MINING_GUILD ? Duration.of(600, GAME_TICKS) : super.respawnTime;
			}
		},
	ORE_VEIN(Duration.of(MiningRocksOverlay.ORE_VEIN_MAX_RESPAWN_TIME, GAME_TICKS), 150),
	AMETHYST(Duration.of(125, GAME_TICKS), 120),
	ASH_VEIN(Duration.of(50, GAME_TICKS), 0, ASH_PILE),
	GEM_ROCK(Duration.of(99, GAME_TICKS), 0, ROCKS_11380, ROCKS_11381),
	URT_SALT(Duration.of(9, GAME_TICKS), 0, ROCKS_33254),
	EFH_SALT(Duration.of(9, GAME_TICKS), 0, ROCKS_33255),
	TE_SALT(Duration.of(9, GAME_TICKS), 0, ROCKS_33256),
	BASALT(Duration.of(9, GAME_TICKS), 0, ROCKS_33257),
	DAEYALT_ESSENCE(Duration.of(MiningRocksOverlay.DAEYALT_MAX_RESPAWN_TIME, GAME_TICKS), 0, DAEYALT_ESSENCE_39095);

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
