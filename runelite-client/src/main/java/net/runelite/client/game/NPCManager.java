/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.game;

import com.google.common.collect.ImmutableMap;
import com.google.gson.stream.JsonReader;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class NPCManager
{
	private ImmutableMap<Integer, NPCStats> statsMap;

	@Inject
	private NPCManager()
	{
		Completable.fromAction(this::loadStats)
			.subscribeOn(Schedulers.computation())
			.subscribe(
				() -> log.debug("Loaded {} NPC stats", statsMap.size()),
				ex -> log.warn("Error loading NPC stats", ex)
			);
	}

	private void loadStats() throws IOException
	{
		try (JsonReader reader = new JsonReader(new InputStreamReader(NPCManager.class.getResourceAsStream("/npc_stats.json"), StandardCharsets.UTF_8)))
		{
			ImmutableMap.Builder<Integer, NPCStats> builder = ImmutableMap.builderWithExpectedSize(2821);
			reader.beginObject();

			while (reader.hasNext())
			{
				builder.put(
					Integer.parseInt(reader.nextName()),
					NPCStats.NPC_STATS_TYPE_ADAPTER.read(reader)
				);
			}

			reader.endObject();
			statsMap = builder.build();
		}
	}

	/**
	 * Returns the {@link NPCStats} for target NPC id
	 *
	 * @param npcId NPC id
	 * @return the {@link NPCStats} or null if unknown
	 */
	@Nullable
	public NPCStats getStats(final int npcId)
	{
		return statsMap.get(npcId);
	}

	/**
	 * Returns health for target NPC ID
	 *
	 * @param npcId NPC id
	 * @return health or null if unknown
	 */
	public int getHealth(final int npcId)
	{
		final NPCStats s = statsMap.get(npcId);
		if (s == null || s.getHitpoints() == -1)
		{
			return -1;
		}

		return s.getHitpoints();
	}

	/**
	 * Returns the attack speed for target NPC ID.
	 *
	 * @param npcId NPC id
	 * @return attack speed in game ticks for NPC ID.
	 */
	public int getAttackSpeed(final int npcId)
	{
		final NPCStats s = statsMap.get(npcId);
		if (s == null || s.getAttackSpeed() == -1)
		{
			return -1;
		}

		return s.getAttackSpeed();
	}

	/**
	 * Returns the exp modifier for target NPC ID based on its stats.
	 *
	 * @param npcId NPC id
	 * @return npcs exp modifier. Assumes default xp rate if npc stats are unknown (returns 1)
	 */
	public double getXpModifier(final int npcId)
	{
		final NPCStats s = statsMap.get(npcId);
		if (s == null)
		{
			return 1;
		}

		return s.calculateXpModifier();
	}
}
