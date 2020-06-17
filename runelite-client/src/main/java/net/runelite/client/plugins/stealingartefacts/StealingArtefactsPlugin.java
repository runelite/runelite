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
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static net.runelite.api.ObjectID.DRAWERS_27771;
import static net.runelite.api.ObjectID.DRAWERS_27772;
import static net.runelite.api.ObjectID.DRAWERS_27773;
import static net.runelite.api.ObjectID.DRAWERS_27774;
import static net.runelite.api.ObjectID.DRAWERS_27775;
import static net.runelite.api.ObjectID.DRAWERS_27776;
import static net.runelite.api.ObjectID.LADDER_27634;
import static net.runelite.api.ObjectID.LADDER_27635;

@PluginDescriptor(
	name = "Stealing Artefacts",
	description = "Show the location and status of your Stealing Artefact task.",
	tags = {"thieving", "captain", "khaled", "piscarilius", "zeah"},
	enabledByDefault = false
)

public class StealingArtefactsPlugin extends Plugin
{
	private static final ImmutableSet<Integer> PORT_PISCARILIUS_REGIONS = ImmutableSet.of(6970, 7226);
	private static final Set<Integer> OBJECT_IDS = ImmutableSet.of(
		LADDER_27634,
		LADDER_27635,
		DRAWERS_27771,
		DRAWERS_27772,
		DRAWERS_27773,
		DRAWERS_27774,
		DRAWERS_27775,
		DRAWERS_27776
	);

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private StealingArtefactsOverlay overlay;

	@Inject
	private ClickboxOverlay overlayClickbox;

	@Getter(AccessLevel.PACKAGE)
	private StealingArtefactState stealingArtefactState;

	@Getter(AccessLevel.PACKAGE)
	private boolean inPortPiscariliusRegion;

	@Getter(AccessLevel.PACKAGE)
	private TileObject objectToHighlight;

	private NPC captainKhaled;
	private Map<WorldPoint, TileObject> relevantObjects = new HashMap<>();

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlayManager.add(overlayClickbox);

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
		objectToHighlight = null;
		relevantObjects.clear();
		overlayManager.remove(overlay);
		overlayManager.remove(overlayClickbox);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		setHintArrowAndHighlight();
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		onTileObject(null, event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		onTileObject(event.getGameObject(), null);
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
				objectToHighlight = null;
				relevantObjects.clear();
				client.clearHintArrow();
				return;
			}
		}

		stealingArtefactState = StealingArtefactState.values()[(client.getVar(Varbits.STEALING_ARTEFACT_STATE))];

		if (client.getPlane() == 1)
		{
			client.setHintArrow(stealingArtefactState.getWorldPoint());
			objectToHighlight = relevantObjects.get(stealingArtefactState.getWorldPoint());
		}
		else if (client.getPlane() == 0)
		{
			setHintArrowAndHighlight();
		}
	}

	private void setHintArrowAndHighlight()
	{
		StealingArtefactState state = stealingArtefactState;
		if (state == null)
		{
			return;
		}
		if (state == StealingArtefactState.DELIVER_ARTEFACT && captainKhaled != null)
		{
			client.setHintArrow(captainKhaled);
			objectToHighlight = null;
		}
		else if (state == StealingArtefactState.NO_TASK || state == StealingArtefactState.FAILURE)
		{
			client.clearHintArrow();
			objectToHighlight = null;
		}
		else
		{
			client.setHintArrow(stealingArtefactState.getLadderPoint());
			objectToHighlight = relevantObjects.get(stealingArtefactState.getLadderPoint());
		}
	}

	// Store relevant GameObjects (ladders and drawers)
	private void onTileObject(TileObject oldObject, TileObject newObject)
	{
		if (oldObject != null)
		{
			WorldPoint oldLocation = oldObject.getWorldLocation();
			relevantObjects.remove(oldLocation);
		}

		if (newObject == null)
		{
			return;
		}

		if (OBJECT_IDS.contains(newObject.getId()))
		{
			relevantObjects.put(newObject.getWorldLocation(), newObject);
		}
	}
}
