/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Query;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.QueryRunner;

@PluginDescriptor(
	name = "Fight Cave"
)
public class FightCavePlugin extends Plugin
{
	private static final int[] FIGHT_CAVE_REGION = { 9551 };

	private static final Pattern WAVE_MESSAGE = Pattern.compile("([0-9]+)");

	@Getter
	private Waves wave;

	private JadAttack attack;

	private FightCaveTimer fightCaveTimer;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private Client client;

	@Inject
	private FightCaveConfig config;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private FightCaveOverlay overlay;

	@Inject
	private FightCaveWaveOverlay fightCaveWaveOverlay;

	@Provides
	FightCaveConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FightCaveConfig.class);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, fightCaveWaveOverlay);
	}

	@Override
	protected void shutDown()
	{
		removeFightCaveTimer();
	}

	@Subscribe
	public void onConfigChange(ConfigChanged event)
	{
		if (event.getGroup().equals("fightcave") )
		{
			if (!config.showTimer())
			{
				removeFightCaveTimer();
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER)
		{
			return;
		}

		String message = event.getMessage();

		if (message.startsWith("Your TzTok-Jad kill count is"))
		{
			fightCaveTimer.setStopped(true);
			return;
		}

		if (message.contains("Wave: "))
		{
			if (isInFightCaveInstance())
			{
				Matcher m = WAVE_MESSAGE.matcher(message.replaceAll("<[^>]*>", ""));
				if (m.find())
				{
					int waveNum = Integer.parseInt(m.group());

					//add fight cave timer
					if (config.showTimer() && waveNum == 1)
					{
						fightCaveTimer = new FightCaveTimer(itemManager.getImage(ItemID.FIRE_CAPE), Instant.now());
						infoBoxManager.addInfoBox(fightCaveTimer);
					}

					wave = Waves.values()[waveNum];
					return;
				}
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (wave != null && !isInFightCaveInstance())
		{
			wave = null;
			removeFightCaveTimer();
			return;
		}
	}

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)
	public void update()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (config.showJad())
		{
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

	public boolean isInFightCaveInstance()
	{
		return Arrays.equals(client.getMapRegions(), FIGHT_CAVE_REGION);
	}

	private void removeFightCaveTimer()
	{
		infoBoxManager.removeInfoBox(fightCaveTimer);
	}
}
