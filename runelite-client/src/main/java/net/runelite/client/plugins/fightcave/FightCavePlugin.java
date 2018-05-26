/*
 * Copyright (c) 2018, DrizzyBot <https://github.com/drizzybot>
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
package net.runelite.client.plugins.fightcave;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import javax.inject.Inject;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;

@PluginDescriptor(
	name = "Fight Cave"
)

@Slf4j
public class FightCavePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private FightCaveOverlay overlay;

	@Inject
	private JadOverlay jadOverlay;

	private JadAttack attack;

	private int currentWave = 0;

	private static final int[] FIGHT_CAVE_REGION = { 9551 };

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, jadOverlay);
	}

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)

	@Provides
	FightCaveConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FightCaveConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
	}

	private boolean isInFightCaveInstance()
	{
		return Arrays.equals(client.getMapRegions(), FIGHT_CAVE_REGION);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER)
		{
			return;
		}
		String message = event.getMessage();
		if (event.getMessage().contains("Wave:"))
		{
			message = message.substring(message.indexOf(": ") + 2);
			message = message.substring(0, message.indexOf("<"));
			currentWave = Integer.parseInt(message);
			overlay.newWave(currentWave);
		}
	}

	@Subscribe
	public void onActorDeath(ActorDeath event)
	{
		Actor actor = event.getActor();
		if (currentWave == 0)
		{
			return;
		}
		if (actor.getName().equals("Tz-Kek"))
		{
			switch (actor.getCombatLevel())
			{
				case 22:
					overlay.killedMonster(221);
				break;
				case 45:
					overlay.killedMonster(45);
					overlay.addKek();
				break;
			}
		}
		else
		{
			overlay.killedMonster(actor.getCombatLevel());
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!isInFightCaveInstance())
		{
			currentWave = 0;
			return;
		}
	}

	public void update()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		NPC jad = findJad();
		if (jad != null)
		{
			if (jad.getAnimation() == JadAttack.MAGIC.getAnimation())
			{
				attack = JadAttack.MAGIC;
			}
			else if (jad.getAnimation() == JadAttack.RANGE.getAnimation())
			{
				attack = JadAttack.RANGE;
			}
		}
		else
		{
			attack = null;
		}
	}

	private NPC findJad()
	{
		Query query = new NPCQuery().nameContains("TzTok-Jad");
		NPC[] result = queryRunner.runQuery(query);
		return result.length >= 1 ? result[0] : null;
	}

	JadAttack getAttack()
	{
		return attack;
	}

	int getCurrentWave()
	{
		return currentWave;
	}
}
