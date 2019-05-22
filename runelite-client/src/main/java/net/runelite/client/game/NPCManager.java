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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class NPCManager
{
	private final ImmutableMap<Integer, NPCStats> statsMap;

	@Inject
	private NPCManager()
	{
		final Gson gson = new Gson();

		final Type typeToken = new TypeToken<Map<Integer, NPCStats>>()
		{
		}.getType();

		final InputStream statsFile = getClass().getResourceAsStream("/npc_stats.json");
		final Map<Integer, NPCStats> stats = gson.fromJson(new InputStreamReader(statsFile), typeToken);
		statsMap = ImmutableMap.copyOf(stats);
	}

	/**
	 * Returns the {@link NPCStats} for target NPC id
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
	 * @param npcId NPC id
	 * @return health or null if unknown
	 */
	@Nullable
	public Integer getHealth(final int npcId)
	{
		final NPCStats s = statsMap.get(npcId);
		if (s == null || s.getHitpoints() == -1)
		{
			return null;
		}

		return s.getHitpoints();
	}

	/**
	 * Returns the exp modifier for target NPC ID based on its stats.
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
