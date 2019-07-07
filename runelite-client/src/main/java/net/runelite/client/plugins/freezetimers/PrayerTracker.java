/*
 * Copyright (c) 2019, pklite <https://github.com/pklite/pklite>
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
package net.runelite.client.plugins.freezetimers;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;

@Slf4j
@Singleton
class PrayerTracker
{

	@Inject
	private Client client;

	private final Map<Actor, HashMap<String, Integer>> lastTick = new HashMap<>();
	private final Map<Actor, HashMap<String, Integer>> newTick = new HashMap<>();

	public void gameTick()
	{
		lastTick.clear();
		lastTick.putAll(newTick);
		newTick.clear();
		for (Player p : client.getPlayers())
		{
			processActor(p);
		}
		for (NPC npc : client.getNpcs())
		{
			processActor(npc);
		}
	}

	private void processActor(Actor actor)
	{
		if (!newTick.containsKey(actor))
		{
			newTick.put(actor, new HashMap<>());
		}
		if (actor instanceof Player)
		{
			newTick.get(actor).put("PrayerIcon", ((Player) actor).getOverheadIcon() == null ? -1 : ((Player) actor).getOverheadIcon().ordinal());
		}
		newTick.get(actor).put("SpotAnim", actor.getSpotAnimation());
	}

	int getPrayerIconLastTick(Actor p)
	{
		return lastTick.getOrDefault(p, new HashMap<>()).getOrDefault("PrayerIcon", -1337);
	}

	int getSpotanimLastTick(Actor p)
	{
		return lastTick.getOrDefault(p, new HashMap<>()).getOrDefault("SpotAnim", -1337);
	}

}
