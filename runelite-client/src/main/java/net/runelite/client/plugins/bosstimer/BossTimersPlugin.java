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

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@PluginDescriptor(
	name = "Boss Timers",
	description = "Show boss spawn timer overlays",
	tags = {"combat", "pve", "overlay", "spawn"}
)
@Slf4j
public class BossTimersPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private RespawnTimersSession session;

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(t -> t instanceof RespawnTimer);
		session = null;
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();

		if (!npc.isDead())
		{
			return;
		}

		int npcId = npc.getId();

		Boss boss = Boss.find(npcId);

		if (boss == null)
		{
			return;
		}

		log.debug("Creating spawn timer for {} ({} seconds)", npc.getName(), boss.getSpawnTime());

		RespawnTimer timer = new RespawnTimer(boss, this.getCurrentWorld(), npc.getName(), itemManager.getImage(boss.getItemSpriteId()), this);

		if (session == null)
		{
			session = new RespawnTimersSession();
		}

		session.addBossTimer(timer);
		updateInfoBoxes();
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (session == null)
		{
			return;
		}

		session.cull();

		if (session.isEmpty())
		{
			session = null;
		}

		updateInfoBoxes();
	}


	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGED_IN:
				updateInfoBoxes();
				break;
		}
	}

	private void updateInfoBoxes()
	{
		if (session == null)
		{
			return;
		}

		infoBoxManager.removeIf(t -> t instanceof RespawnTimer);
		Map<String, ArrayList<RespawnTimer>> timersMap = session.getTimersMap();

		for (HashMap.Entry<String, ArrayList<RespawnTimer>> entry : timersMap.entrySet())
		{
			Iterator<RespawnTimer> valueIterator = entry.getValue().iterator();

			Instant longest = Instant.now();
			RespawnTimer longestTimer = null;
			RespawnTimer worldTimer = null;

			StringBuilder sb = new StringBuilder();
			sb.append(entry.getKey());

			while (valueIterator.hasNext())
			{
				final RespawnTimer respawnTimer = valueIterator.next();

				if (respawnTimer.getWorld() != getCurrentWorld())
				{
					sb.append("</br>World ").append(respawnTimer.getWorld());
				}
				else
				{
					worldTimer = respawnTimer;
				}

				if (respawnTimer.getEndTime().compareTo(longest) > 0)
				{
					longest = respawnTimer.getEndTime();
					longestTimer = respawnTimer;
				}
			}

			if (worldTimer != null)
			{
				worldTimer.setTooltip(sb.toString());
				worldTimer.setShowTimer(true);
				infoBoxManager.addInfoBox(worldTimer);
			}
			else if (longestTimer != null)
			{
				longestTimer.setTooltip(sb.toString());
				longestTimer.setShowTimer(false);
				infoBoxManager.addInfoBox(longestTimer);
			}
		}
	}

	private int getCurrentWorld()
	{
		return client.getWorld();
	}
}
