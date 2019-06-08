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

import com.google.inject.Binder;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.util.ArrayList;

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

	@Provides
	PileIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PileIndicatorsConfig.class);
	}

	@Override
	public void configure(Binder binder)
	{
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	protected ArrayList<ArrayList<Actor>> getStacks()
	{
		ArrayList<ArrayList<Actor>> outerArrayList = new ArrayList<>();

		ArrayList<Actor> pileList = new ArrayList<>();

		if (config.enableNPCS())
		{
			for (NPC npc : client.getNpcs())
			{
				if (npc != null)
				{
					pileList.add(npc);
				}
			}
		}

		if (config.enablePlayers())
		{
			if ((client.getVar(Varbits.IN_WILDERNESS) > 0 && config.wildyOnlyPlayer()) ^ (!config.wildyOnlyPlayer()))
			{
				for (Player player : client.getPlayers())
				{
					if (player != null)
					{
						pileList.add(player);
					}
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
				if (!potentialStackArrayList.contains(actorToCompareTo))
				{
					if (actor.getWorldLocation().distanceTo(actorToCompareTo.getWorldLocation()) == 0)
					{
						potentialStackArrayList.add(actorToCompareTo);
					}
				}
			}
			if (potentialStackArrayList.size() >= config.minimumPileSize())
			{
				outerArrayList.add(potentialStackArrayList);
			}
		}

		return outerArrayList.size() != 0 ? outerArrayList : null;
	}

	protected Color getColorByPileType(PileType pileType)
	{
		switch (pileType)
		{
			case PLAYER_PILE:
				return config.playerPileColor();
			case NPC_PILE:
				return config.npcPileColor();
			case MIXED_PILE:
				return config.mixedPileColor();
		}
		return null;
	}

	protected PileType getPileType(ArrayList<Actor> pile)
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
}
