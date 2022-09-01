/*
 * BSD 2-Clause License
 *
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
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
package net.runelite.client.plugins.dagannothkings;

import com.google.inject.Provides;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.dagannothkings.entity.DagannothKing;
import net.runelite.client.plugins.dagannothkings.overlay.InfoboxOverlay;
import net.runelite.client.plugins.dagannothkings.overlay.PrayerOverlay;
import net.runelite.client.plugins.dagannothkings.overlay.SceneOverlay;
import net.runelite.client.ui.overlay.OverlayManager;

@Singleton
@PluginDescriptor(
	name = "Dagannoth Kings",
	enabledByDefault = false,
	description = "A plugin for the Dagannoth Kings.",
	tags = {"dagannoth", "kings", "dks", "daggs"}
)
public class DagannothKingsPlugin extends Plugin
{
	public static final int DAG_REX = 2853;
	public static final int DAG_PRIME = 2854;
	public static final int DAG_SUPREME = 2855;

	private static final int WATERBITH_REGION = 11589;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PrayerOverlay prayerOverlay;

	@Inject
	private SceneOverlay sceneOverlay;

	@Inject
	private InfoboxOverlay infoboxOverlay;

	@Getter
	private final Set<DagannothKing> dagannothKings = new HashSet<>();

	private boolean atDks;

	@Getter
	private long lastTickTime;

	@Provides
	DagannothKingsConfig getConfig(final ConfigManager configManager)
	{
		return configManager.getConfig(DagannothKingsConfig.class);
	}

	@Override
	public void startUp()
	{
		if (client.getGameState() != GameState.LOGGED_IN || !atDks())
		{
			return;
		}

		init();
	}

	private void init()
	{
		atDks = true;

		addOverlays();

		for (final NPC npc : client.getNpcs())
		{
			addNpc(npc);
		}
	}

	@Override
	public void shutDown()
	{
		atDks = false;

		removeOverlays();

		dagannothKings.clear();
	}

	@Subscribe
	private void onGameStateChanged(final GameStateChanged event)
	{
		final GameState gameState = event.getGameState();

		switch (gameState)
		{
			case LOGGED_IN:
				if (atDks())
				{
					if (!atDks)
					{
						init();
					}
				}
				else
				{
					if (atDks)
					{
						shutDown();
					}
				}
				break;
			case LOGIN_SCREEN:
			case HOPPING:
				shutDown();
				break;
		}
	}

	@Subscribe
	private void onGameTick(final GameTick Event)
	{
		lastTickTime = System.currentTimeMillis();

		if (dagannothKings.isEmpty())
		{
			return;
		}

		for (final DagannothKing dagannothKing : dagannothKings)
		{
			dagannothKing.updateTicksUntilNextAnimation();
		}
	}

	@Subscribe
	private void onNpcSpawned(final NpcSpawned event)
	{
		addNpc(event.getNpc());
	}

	@Subscribe
	private void onNpcDespawned(final NpcDespawned event)
	{
		removeNpc(event.getNpc());
	}

	private void addNpc(final NPC npc)
	{
		switch (npc.getId())
		{
			case NpcID.DAGANNOTH_REX:
			case NpcID.DAGANNOTH_SUPREME:
			case NpcID.DAGANNOTH_PRIME:
				dagannothKings.add(new DagannothKing(npc));
				break;
			default:
				break;
		}
	}

	private void removeNpc(final NPC npc)
	{
		switch (npc.getId())
		{
			case NpcID.DAGANNOTH_REX:
			case NpcID.DAGANNOTH_SUPREME:
			case NpcID.DAGANNOTH_PRIME:
				dagannothKings.removeIf(dk -> dk.getNpc() == npc);
				break;
			default:
				break;
		}
	}

	private void addOverlays()
	{
		overlayManager.add(sceneOverlay);
		overlayManager.add(prayerOverlay);
		overlayManager.add(infoboxOverlay);
	}

	private void removeOverlays()
	{
		overlayManager.remove(sceneOverlay);
		overlayManager.remove(prayerOverlay);
		overlayManager.remove(infoboxOverlay);
	}

	private boolean atDks()
	{
		return Arrays.stream(client.getMapRegions()).anyMatch(x -> x == WATERBITH_REGION);
	}
}
