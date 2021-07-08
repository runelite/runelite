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

import com.google.inject.Provides;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.NPC;
import net.runelite.api.events.NpcDespawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Boss Timers",
	description = "Show boss spawn timer overlays",
	tags = {"combat", "pve", "overlay", "spawn", "notifications"}
)
@Slf4j
public class BossTimersPlugin extends Plugin
{
	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private BossTimersConfig config;

	@Inject
	private Notifier notifier;

	private final Timer notificationTimer = new Timer();

	@Provides
	BossTimersConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BossTimersConfig.class);
	}

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(t -> t instanceof RespawnTimer);
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

		// remove existing timer
		infoBoxManager.removeIf(t -> t instanceof RespawnTimer && ((RespawnTimer) t).getBoss() == boss);

		final String name = npc.getName();

		log.debug("Creating spawn timer for {} ({} seconds)", name, boss.getSpawnTime());

		RespawnTimer timer = new RespawnTimer(boss, itemManager.getImage(boss.getItemSpriteId()), this);
		timer.setTooltip(name);
		infoBoxManager.addInfoBox(timer);

		final int delay = config.respawnDelay();
		// -1 disabled, 0 for instant, greater than 0 to notify before respawn, and don't notify if the delay is longer
		// than it takes for the boss to respawn.
		if (delay >= 0 && delay < boss.getSpawnTime().getSeconds())
		{
			notificationTimer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					if (delay == 0)
					{
						notifier.notify(name + " has respawned");
					}
					else
					{
						notifier.notify(name + " will respawn in " + delay + " second(s)");
					}
				}
			}, (boss.getSpawnTime().getSeconds() - delay) * 1_000);
		}
	}
}
