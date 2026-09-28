/*
 * Copyright (c) 2026, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.party.data;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.party.PartyService;
import net.runelite.client.party.WSClient;
import net.runelite.client.party.data.events.PartyDataChange;
import net.runelite.client.party.data.events.PartyDataEvent;
import net.runelite.client.party.data.prayers.PrayerService;
import net.runelite.client.plugins.Plugin;

@Slf4j
@Singleton
public class PartyDataService
{
	private final Multimap<PartyDataType, String> DATA_MAP = HashMultimap.create();

	public void register(Plugin plugin, PartyDataType partyDataType)
	{
		DATA_MAP.put(partyDataType, plugin.getName());
	}

	public void unregister(Plugin plugin, PartyDataType partyDataType)
	{
		DATA_MAP.remove(partyDataType, plugin.getName());
	}

	public void unregisterAll(Plugin plugin)
	{
		DATA_MAP.values().removeIf(p -> p.equals(plugin.getName()));
	}

	private final Client client;
	private final PartyService partyService;
	private final EventBus eventBus;
	private final PrayerService prayerService;

	private PlayerPartyData playerData;
	private PartyDataChange currentChange = new PartyDataChange();

	private long lastSeenAccountHash = -1;

	@Inject
	private PartyDataService(
			Client client,
			EventBus eventBus,
			WSClient wsClient,
			PartyService partyService
	)
	{
		this.client = client;
		this.partyService = partyService;
		this.eventBus = eventBus;
		this.prayerService = new PrayerService(client);

		eventBus.register(this);
		wsClient.registerMessage(PartyDataChange.class);
	}

	@Subscribe
	public void onPartyDataChange(PartyDataChange event)
	{
		Collection<PartyDataEvent> events = event.processEvent(playerData);
		events.forEach(eventBus::post);
	}

	@Subscribe
	public void onPartyChanged(final PartyChanged ignored)
	{
		playerData = null;

		if (inParty())
		{
			currentChange = new PartyDataChange();
			playerData = new PlayerPartyData(client);
		}
	}

	@Subscribe(priority = 1)
	public void onGameStateChanged(final GameStateChanged e)
	{
		if (!inParty())
		{
			return;
		}

		if (e.getGameState() == GameState.LOGGED_IN)
		{
			long accountHash = client.getAccountHash();
			if (accountHash != lastSeenAccountHash)
			{
				// Reset for new accounts
				currentChange = new PartyDataChange();
				prayerService.updatePrayerBook();
				playerData = new PlayerPartyData(client);
				playerData.setPrayerBookID(prayerService.getPrayerBookID());

				lastSeenAccountHash = accountHash;
			}
		}
	}

	@Subscribe(priority = 1)
	public void onVarbitChanged(final VarbitChanged e)
	{
		if (e.getVarbitId() == VarbitID.PRAYERBOOK)
		{
			prayerService.updatePrayerBook();
			playerData.setPrayerBookID(prayerService.getPrayerBookID());
			// Next game tick will check the player's prayers and send the update including a prayer book ID update
		}
	}

	@Subscribe(priority = 1)
	public void onItemContainerChanged(final ItemContainerChanged c)
	{
		if (!inParty())
		{
			return;
		}

		if (c.getContainerId() == InventoryID.WORN && !DATA_MAP.get(PartyDataType.EQUIPMENT).isEmpty())
		{
			int[] items = PartySerializationUtils.convertItemContainerToIntArray(c.getItemContainer());
			currentChange.setEquipment(items);

			// TODO: Add Quiver logic since that data is from getVarpValues
			return;
		}

		if (c.getContainerId() == InventoryID.INV && !DATA_MAP.get(PartyDataType.INVENTORY).isEmpty())
		{
			int[] items = PartySerializationUtils.convertItemContainerToIntArray(c.getItemContainer());
			currentChange.setInventory(items);

			// TODO: Add RunePouch logic since that data is from getVarpValues
		}
	}

	// Run before plugins so
	@Subscribe(priority = 1)
	public void onGameTick(final GameTick ignored)
	{
		if (!inParty())
		{
			return;
		}

		// Reduce how often we send updates for larger parties
		if (client.getTickCount() % messageFreq(partyService.getMembers().size()) != 0)
		{
			return;
		}

		if (!DATA_MAP.get(PartyDataType.PRAYERS).isEmpty())
		{
			byte[][] prayerDeltas = prayerService.handlePrayerCheck(playerData);
			currentChange.setAvailablePrayers(prayerDeltas[0]);
			currentChange.setEnabledPrayers(prayerDeltas[1]);
			currentChange.setUnlockedPrayers(prayerDeltas[2]);
		}

		if (currentChange.isValid())
		{
			currentChange.setMemberId(partyService.getLocalMember().getMemberId());
			partyService.send(currentChange);

			currentChange = new PartyDataChange();
		}
	}

	private boolean inParty()
	{
		return partyService.isInParty();
	}

	private static int messageFreq(int partySize)
	{
		// introduce a tick delay for each member >6
		return Math.max(1, partySize - 6);
	}
}
