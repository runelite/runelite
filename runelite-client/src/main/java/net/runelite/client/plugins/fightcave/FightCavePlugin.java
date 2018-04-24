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

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MapRegionChanged;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Fight Cave"
)
public class FightCavePlugin extends Plugin
{
	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");

	@Inject
	private Client client;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private FightCaveOverlay overlay;

	@Inject
	private JadOverlay jadOverlay;

	@Getter
	private JadAttack attack;

	@Getter
	private int currentWave;

	@Getter
	private Instant caveEnterTime;

	@Getter
	private boolean inCave;

	@Provides
	FightcaveConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FightcaveConfig.class);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, jadOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		attack = null;
		currentWave = -1;
		inCave = false;
		caveEnterTime = null;
	}

	@Subscribe
	public void onMapRegionChanged(MapRegionChanged event)
	{
		int idx = event.getIndex();

		if (idx == -1)
		{
			return; // this is the new array being assigned to the field
		}

		int[] regions = client.getMapRegions();
		int region = regions[idx];

		if (region == 9551 && !inCave)
		{
			inCave = true;
			caveEnterTime = Instant.now();
			currentWave = 1;
		}
		else
		{
			inCave = false;
			caveEnterTime = null;
		}
	}

	@Schedule(
			period = 1,
			unit = ChronoUnit.SECONDS
	)
	public void update()
	{
		if (client.getGameState() != GameState.LOGGED_IN || !inCave)
		{
			return;
		}

	}

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)
	public void updateJad()
	{
		if (client.getGameState() != GameState.LOGGED_IN || !inCave)
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

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SERVER)
		{
			String chatMsg = Text.removeTags(event.getMessage()); //remove color and linebreaks
			if (chatMsg.startsWith("Wave"))
			{
				Matcher m = NUMBER_PATTERN.matcher(chatMsg);
				if (m.find())
				{
					currentWave = Integer.valueOf(m.group());
				}
			}
		}

		if (event.getType() != ChatMessageType.FILTERED)
		{
			return;
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
}
