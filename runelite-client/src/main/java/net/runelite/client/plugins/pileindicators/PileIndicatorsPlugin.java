/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.pileindicators;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Pile Indicators",
	description = "Highlight and count how many npcs/players are stacked on each other.",
	tags = {"overlay", "pile", "stack", "pvp", "pvm", "pve"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)

@Singleton
@Slf4j
public class PileIndicatorsPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private PileIndicatorsConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PileIndicatorsOverlay overlay;

	@Inject
	private EventBus eventBus;

	private boolean enablePlayers;
	private boolean wildyOnlyPlayer;
	private Color playerPileColor;
	private boolean enableNPCS;
	private Color npcPileColor;
	private Color mixedPileColor;
	private int minimumPileSize;
	@Getter(AccessLevel.PACKAGE)
	private boolean numberOnly;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawPileTile;
	@Getter(AccessLevel.PACKAGE)
	private boolean drawPileHull;

	@Provides
	PileIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PileIndicatorsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();

		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		overlayManager.remove(overlay);
	}

	List<List<Actor>> getStacks()
	{
		List<List<Actor>> outerArrayList = new ArrayList<>();

		List<Actor> pileList = new ArrayList<>();

		if (this.enableNPCS)
		{
			for (NPC npc : client.getNpcs())
			{
				if (npc != null)
				{
					pileList.add(npc);
				}
			}
		}

		if (this.enablePlayers && (client.getVar(Varbits.IN_WILDERNESS) > 0 && this.wildyOnlyPlayer) ^ (!this.wildyOnlyPlayer))
		{
			for (Player player : client.getPlayers())
			{
				if (player != null)
				{
					pileList.add(player);
				}
			}
		}

		if (pileList.size() == 0)
		{
			return null;
		}

		for (Actor actor : pileList)
		{
			ArrayList<Actor> potentialStackArrayList = new ArrayList<>();
			for (Actor actorToCompareTo : pileList)
			{
				if (!potentialStackArrayList.contains(actorToCompareTo) && actor.getWorldLocation().distanceTo(actorToCompareTo.getWorldLocation()) == 0)
				{
					potentialStackArrayList.add(actorToCompareTo);
				}
			}
			if (potentialStackArrayList.size() >= this.minimumPileSize)
			{
				outerArrayList.add(potentialStackArrayList);
			}
		}

		return outerArrayList.size() != 0 ? outerArrayList : null;
	}

	Color getColorByPileType(PileType pileType)
	{
		switch (pileType)
		{
			case PLAYER_PILE:
				return this.playerPileColor;
			case NPC_PILE:
				return this.npcPileColor;
			case MIXED_PILE:
				return this.mixedPileColor;
		}
		return null;
	}

	PileType getPileType(List<Actor> pile)
	{
		PileType pileType = null;

		for (Actor actor : pile)
		{
			if (actor instanceof NPC && pileType == null)
			{
				pileType = PileType.NPC_PILE;
			}
			if (actor instanceof Player && pileType == null)
			{
				pileType = PileType.PLAYER_PILE;
			}
			if (actor instanceof Player && pileType == PileType.NPC_PILE)
			{
				pileType = PileType.MIXED_PILE;
			}
			if (actor instanceof NPC && pileType == PileType.PLAYER_PILE)
			{
				pileType = PileType.MIXED_PILE;
			}
		}
		return pileType;
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("pileindicators"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.enablePlayers = config.enablePlayers();
		this.wildyOnlyPlayer = config.wildyOnlyPlayer();
		this.playerPileColor = config.playerPileColor();
		this.enableNPCS = config.enableNPCS();
		this.npcPileColor = config.npcPileColor();
		this.mixedPileColor = config.mixedPileColor();
		this.minimumPileSize = config.minimumPileSize();
		this.numberOnly = config.numberOnly();
		this.drawPileTile = config.drawPileTile();
		this.drawPileHull = config.drawPileHull();
	}
}
