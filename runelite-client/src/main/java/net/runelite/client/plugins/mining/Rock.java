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

enum Rock
{
	TIN(Duration.ofMillis(2400), 0, ROCKS_11360, ROCKS_11361),
	COPPER(Duration.ofMillis(2400), 0, ROCKS_10943, ROCKS_11161),
	IRON(Duration.ofMillis(5400), 0, ROCKS_11364, ROCKS_11365)
		{
			@Override
			Duration getRespawnTime(boolean inMiningGuild)
			{
				return inMiningGuild ? Duration.ofMillis(2400) : super.respawnTime;
			}
		},
	COAL(Duration.ofMillis(29400), 0, ROCKS_11366, ROCKS_11367)
		{
			@Override
			Duration getRespawnTime(boolean inMiningGuild)
			{
				return inMiningGuild ? Duration.ofMillis(14400) : super.respawnTime;
			}
		},
	SILVER(Duration.ofMinutes(1), 0, ROCKS_11368, ROCKS_11369),
	SANDSTONE(Duration.ofMillis(5400), 0, ROCKS_11386),
	GOLD(Duration.ofMinutes(1), 0, ROCKS_11370, ROCKS_11371),
	GRANITE(Duration.ofMillis(5400), 0, ROCKS_11387),
	MITHRIL(Duration.ofMinutes(2), 0, ROCKS_11372, ROCKS_11373)
		{
			@Override
			Duration getRespawnTime(boolean inMiningGuild)
			{
				return inMiningGuild ? Duration.ofMinutes(1) : super.respawnTime;
			}
		},
	ADAMANTITE(Duration.ofMinutes(4), 0, ROCKS_11374, ROCKS_11375)
		{
			@Override
			Duration getRespawnTime(boolean inMiningGuild)
			{
				return inMiningGuild ? Duration.ofMinutes(2) : super.respawnTime;
			}
		},
	RUNITE(Duration.ofMinutes(12), 0, ROCKS_11376, ROCKS_11377)
		{
			@Override
			Duration getRespawnTime(boolean inMiningGuild)
			{
				return inMiningGuild ? Duration.ofMinutes(6) : super.respawnTime;
			}
		},
	ORE_VEIN(Duration.ofSeconds(MiningOverlay.ORE_VEIN_MAX_RESPAWN_TIME), 150),
	AMETHYST(Duration.ofSeconds(75), 120),
	ASH_VEIN(Duration.ofSeconds(30), 0, ASH_PILE),
	GEM_ROCK(Duration.ofMinutes(1), 0, ROCKS_11380, ROCKS_11381);

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

	Duration getRespawnTime(boolean inMiningGuild)
	{
		return respawnTime;
	}

	static Rock getRock(int id)
	{
		return ROCKS.get(id);
	}
}
