/*
 * Copyright (c) 2019, honeyhoney <https://github.com/honeyhoney>
 * Copyright (c) 2020, ThePharros <https://github.com/ThePharros>
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
package net.runelite.client.plugins.stealingartefacts;

import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Stealing Artefacts",
	description = "Show the location and status of your Stealing Artefact task.",
	tags = {"thieving", "captain", "khaled", "piscarilius", "zeah"},
	enabledByDefault = false
)

public class StealingArtefactsPlugin extends Plugin
{
	private static final ImmutableSet<Integer> PORT_PISCARILIUS_REGIONS = ImmutableSet.of(6970, 7226);

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private StealingArtefactsOverlay overlay;

	@Getter(AccessLevel.PACKAGE)
	private StealingArtefactState stealingArtefactState;

	@Getter(AccessLevel.PACKAGE)
	private boolean inPortPiscariliusRegion;

	private NPC captainKhaled;
	private int prevPlane = 0;

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(() -> stealingArtefactState = StealingArtefactState.values()[client.getVar(Varbits.STEALING_ARTEFACT_STATE)]);
		}
	}

	@Override
	protected void shutDown()
	{
		client.clearHintArrow();
		stealingArtefactState = null;
		captainKhaled = null;
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		setHintArrow();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (event.getNpc().getId() == NpcID.CAPTAIN_KHALED_6972)
		{
			captainKhaled = event.getNpc();
			if (stealingArtefactState == StealingArtefactState.DELIVER_ARTEFACT)
			{
				client.setHintArrow(captainKhaled);
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (captainKhaled != null && event.getNpc().getId() == captainKhaled.getId())
		{
			captainKhaled = null;
			if (stealingArtefactState == StealingArtefactState.DELIVER_ARTEFACT)
			{
				client.clearHintArrow();
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		Player player = client.getLocalPlayer();

		if (player == null)
		{
			return;
		}

		final boolean newInPortPiscariliusRegion = PORT_PISCARILIUS_REGIONS.contains(player.getWorldLocation().getRegionID());

		if (inPortPiscariliusRegion != newInPortPiscariliusRegion)
		{
			inPortPiscariliusRegion = newInPortPiscariliusRegion;

			if (!inPortPiscariliusRegion)
			{
				client.clearHintArrow();
				return;
			}
		}

		if (client.getPlane() == 1 && prevPlane != 1)
		{
			client.setHintArrow(stealingArtefactState.getWorldPoint());
		}
		else if (client.getPlane() == 0 && prevPlane != 0)
		{
			setHintArrow();
		}
		prevPlane = client.getPlane();
	}

	private void setHintArrow()
	{
		StealingArtefactState state = StealingArtefactState.values()[(client.getVar(Varbits.STEALING_ARTEFACT_STATE))];
		stealingArtefactState = state;

		if (state == StealingArtefactState.DELIVER_ARTEFACT && captainKhaled != null)
		{
			client.setHintArrow(captainKhaled);
		}
		else if (state == StealingArtefactState.NO_TASK || state == StealingArtefactState.FAILURE)
		{
			client.clearHintArrow();
		}
		else
		{
			client.setHintArrow(stealingArtefactState.getLadderPoint());
		}
	}
}
