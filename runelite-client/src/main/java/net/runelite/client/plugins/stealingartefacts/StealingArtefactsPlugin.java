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
import java.util.Arrays;
import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
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
	tags = {"thieving", "stealing", "artefact", "artefacts", "captain", "khaled"},
	enabledByDefault = false
)

public class StealingArtefactsPlugin extends Plugin
{
	private static final ImmutableSet<Integer> PORT_PISCARILIUS_REGIONS = ImmutableSet.of(6970, 7226);
	private static final ImmutableSet<Integer> ARTEFACT_ITEM_IDS = ImmutableSet.of(ItemID.STOLEN_PENDANT,
		ItemID.STOLEN_GARNET_RING, ItemID.STOLEN_CIRCLET, ItemID.STOLEN_FAMILY_HEIRLOOM, ItemID.STOLEN_JEWELRY_BOX);

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

	@Override
	protected void startUp()
	{

		overlayManager.add(overlay);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(() -> stealingArtefactState = StealingArtefactState.getState(client.getVar(Varbits.STEALING_ARTEFACT_STATE)));
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

	private boolean hasArtefact()
	{
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);

		if (inventory != null)
		{
			final Stream<Item> items = Arrays.stream(inventory.getItems());
			return items.anyMatch(item -> ARTEFACT_ITEM_IDS.contains(item.getId()));
		}
		return false;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		StealingArtefactState state = StealingArtefactState.getState(client.getVar(Varbits.STEALING_ARTEFACT_STATE));

		if (state != StealingArtefactState.DELIVER_ARTEFACT)
		{
			stealingArtefactState = state;
			if (state == StealingArtefactState.NO_TASK || state == StealingArtefactState.FAILURE)
			{
				client.clearHintArrow();
			}
			else
			{
				client.setHintArrow(stealingArtefactState.getWorldPoint());
			}
		}
		else if (captainKhaled != null)
		{
			client.setHintArrow(captainKhaled);
		}
		else
		{
			client.clearHintArrow();
		}
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			if (hasArtefact())
			{
				stealingArtefactState = StealingArtefactState.DELIVER_ARTEFACT;
			}
			else if (stealingArtefactState == StealingArtefactState.DELIVER_ARTEFACT)
			{
				stealingArtefactState = StealingArtefactState.FAILURE;
			}
		}
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
		if (event.getNpc().getId() == NpcID.CAPTAIN_KHALED_6972)
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

		if (player != null)
		{
			inPortPiscariliusRegion = PORT_PISCARILIUS_REGIONS.contains(player.getWorldLocation().getRegionID());
		}
	}
}
