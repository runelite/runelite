/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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
package net.runelite.client.plugins.chompyhunting;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import lombok.Getter;
import net.runelite.api.NPCComposition;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@PluginDescriptor(name = "Chompy Hunting")
public class ChompyHuntingPlugin extends Plugin
{
	private static final Pattern CHOMPY_KILL_PATTERN = Pattern.compile("You've killed a total of <col=7f0000>(\\d+)</col> chompy bird.*");
	private final ChompyHuntingSession session = new ChompyHuntingSession();

	@Getter
	private final Map<NPC, Boolean> chompies = new HashMap<>();

	@Getter
	private final Map<NPC, Integer> toads = new HashMap<>();

	@Inject
	private Client client;

	@Inject
	private ChompyHuntingOverlay overlay;

	@Inject
	private ChompyHuntingKillsOverlay killsOverlay;

	@Inject
	private ChompyHuntingToadOverlay toadOverlay;

	@Inject
	private ChompyHuntingInventoryOverlay inventoryOverlay;

	@Inject
	private ChompyHuntingMinimapOverlay minimapOverlay;

	@Inject
	private ChompyHuntingConfig config;

	@Provides
	ChompyHuntingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChompyHuntingConfig.class);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, killsOverlay, toadOverlay, inventoryOverlay, minimapOverlay);
	}

	public ChompyHuntingSession getSession()
	{
		return session;
	}

	@Override
	protected void shutDown() throws Exception
	{
		chompies.clear();
		toads.clear();
	}

	@Subscribe
	public void onNpcSpawned(final NpcSpawned event)
	{
		NPC npc = event.getNpc();
		if (isNpcChompy(npc.getId()))
		{
			chompies.put(npc, false);
		}
		if (isNpcBloatedToad(npc.getId()))
		{
			toads.put(npc, 100);
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		Widget textw = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
		if (textw != null)
		{
			String text = textw.getText();
			Matcher m = CHOMPY_KILL_PATTERN.matcher(text);
			if (m.find())
			{
				int lifetimeKills = Integer.parseInt(m.group(1));
				session.setLifetimeKilled(lifetimeKills);
			}
		}
		for (NPC chompy : chompies.keySet())
		{
			if (isChompyDead(chompy))
			{
				continue;
			}
			NPCComposition composition = chompy.getComposition();
			if (Arrays.asList(composition.getActions()).contains("Pluck"))
			{
				onKill(chompy);
			}
		}
		for (NPC toad : toads.keySet())
		{
			toads.put(toad, toads.get(toad) - 1);
		}

		Instant lastChompyKilled = session.getLastChompyKilled();
		if (lastChompyKilled == null)
		{
			return;
		}

		// reset recentChompyKilled if you haven't killed any recently
		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceKilled = Duration.between(lastChompyKilled, Instant.now());

		if (sinceKilled.compareTo(statTimeout) >= 0)
		{
			session.resetRecent();
		}
	}

	private void onKill(NPC npc)
	{
		chompies.put(npc, true);
		session.incrementChompyKilled();
	}

	@Subscribe
	public void onNpcDespawned(final NpcDespawned event)
	{
		NPC npc = event.getNpc();
		if (chompies.get(npc) != null)
		{
			chompies.remove(npc);
		}
		if (toads.get(npc) != null)
		{
			toads.remove(npc);
		}
	}

	private boolean isNpcChompy(int npcId)
	{
		return npcId == NpcID.CHOMPY_BIRD;
	}

	private boolean isNpcBloatedToad(int npcId)
	{
		return npcId == NpcID.BLOATED_TOAD;
	}

	public boolean isChompyDead(NPC npc)
	{
		return chompies.get(npc);
	}

	public int numLiveChompies()
	{
		int numLiveChompies = 0;
		for (NPC chompy : chompies.keySet())
		{
			if (!isChompyDead(chompy))
			{
				numLiveChompies++;
			}
		}
		return numLiveChompies;
	}
}
