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
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.SetMultimap;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.game.ItemVariationMapping;
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
	private static final int[] RUNEPOUCH_AMOUNT_VARBITS = {
			VarbitID.RUNE_POUCH_QUANTITY_1, VarbitID.RUNE_POUCH_QUANTITY_2, VarbitID.RUNE_POUCH_QUANTITY_3,
			VarbitID.RUNE_POUCH_QUANTITY_4, VarbitID.RUNE_POUCH_QUANTITY_5, VarbitID.RUNE_POUCH_QUANTITY_6,
	};
	private static final int[] RUNEPOUCH_RUNE_VARBITS = {

			VarbitID.RUNE_POUCH_TYPE_1, VarbitID.RUNE_POUCH_TYPE_2, VarbitID.RUNE_POUCH_TYPE_3,
			VarbitID.RUNE_POUCH_TYPE_4, VarbitID.RUNE_POUCH_TYPE_5, VarbitID.RUNE_POUCH_TYPE_6,
	};
	public static final int[] RUNEPOUCH_ITEM_IDS = {
			ItemID.BH_RUNE_POUCH, ItemID.BH_RUNE_POUCH_TROUVER, ItemID.DIVINE_RUNE_POUCH, ItemID.DIVINE_RUNE_POUCH_TROUVER,
	};

	private static final ImmutableSet<Integer> RUNEPOUCH_VARBITS = ImmutableSet.<Integer>builder()
			.addAll(Ints.asList(RUNEPOUCH_AMOUNT_VARBITS))
			.addAll(Ints.asList(RUNEPOUCH_RUNE_VARBITS))
			.build();

	public static final ImmutableSet<Integer> DIZANAS_QUIVER_IDS = ImmutableSet.<Integer>builder()
			.addAll(ItemVariationMapping.getVariations(ItemVariationMapping.map(ItemID.DIZANAS_QUIVER_CHARGED)))
			.addAll(ItemVariationMapping.getVariations(ItemVariationMapping.map(ItemID.DIZANAS_QUIVER_INFINITE)))
			.addAll(ItemVariationMapping.getVariations(ItemVariationMapping.map(ItemID.SKILLCAPE_MAX_DIZANAS)))
			.build();

	private final SetMultimap<PartyDataType, String> DATA_MAP = HashMultimap.create();

	private boolean isTypeEnabled(PartyDataType partyDataType)
	{
		return !DATA_MAP.get(partyDataType).isEmpty();
	}

	public synchronized void register(Plugin plugin, PartyDataType partyDataType)
	{
		boolean wasDisabled = !isTypeEnabled(partyDataType);

		if (DATA_MAP.put(partyDataType, plugin.getName()) && wasDisabled)
		{
			clientThread.invoke(() -> handleDataTypeFirstEnabled(partyDataType));
		}
	}

	public synchronized void unregister(Plugin plugin, PartyDataType partyDataType)
	{
		if (DATA_MAP.remove(partyDataType, plugin.getName()) && !isTypeEnabled(partyDataType))
		{
			handleDataTypeFullyDisabled(partyDataType);
		}
	}

	public void unregisterAll(Plugin plugin)
	{
		for (PartyDataType dataType : PartyDataType.values())
		{
			this.unregister(plugin, dataType);
		}
	}

	private final Client client;
	private final PartyService partyService;
	private final EventBus eventBus;
	private final ClientThread clientThread;

	private final PrayerService prayerService;
	private PlayerPartyData playerData;
	private PartyDataChange currentChange = new PartyDataChange();

	private long lastSeenAccountHash = -1;

	@Inject
	private PartyDataService(
			Client client,
			EventBus eventBus,
			WSClient wsClient,
			PartyService partyService,
			ClientThread clientThread
	)
	{
		this.client = client;
		this.partyService = partyService;
		this.eventBus = eventBus;
		this.clientThread = clientThread;
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
		if (e.getVarbitId() == VarbitID.PRAYERBOOK && !DATA_MAP.get(PartyDataType.PRAYERS).isEmpty())
		{
			prayerService.updatePrayerBook();
			playerData.setPrayerBookID(prayerService.getPrayerBookID());
			// Next game tick will check the player's prayers and send the update including a prayer book ID update
		}

		if (RUNEPOUCH_VARBITS.contains(e.getVarbitId()) && !DATA_MAP.get(PartyDataType.RUNE_POUCH).isEmpty())
		{
			handleRunePouchChange();
		}
	}

	@Subscribe(priority = 1)
	public void onItemContainerChanged(final ItemContainerChanged c)
	{
		if (!inParty())
		{
			return;
		}

		final ItemContainer container = c.getItemContainer();
		if (c.getContainerId() == InventoryID.WORN)
		{
			if (isTypeEnabled(PartyDataType.EQUIPMENT))
			{
				handleEquipmentChange(container);
			}

			if (isTypeEnabled(PartyDataType.QUIVER))
			{
				final Item wornCape = container.getItem(EquipmentInventorySlot.CAPE.getSlotIdx());
				if (wornCape != null && DIZANAS_QUIVER_IDS.contains(wornCape.getId()))
				{
					handleQuiverChange();
				}
			}

			return;
		}

		if (c.getContainerId() == InventoryID.INV)
		{
			if (isTypeEnabled(PartyDataType.INVENTORY))
			{
				handleInventoryChange(container);
			}

			if (isTypeEnabled(PartyDataType.RUNE_POUCH) && itemContainerHasRunePouch(container))
			{
				handleRunePouchChange();
			}

			// A quiver in the inventory causes the quiver's worn equipment slot to start displaying
			if (isTypeEnabled(PartyDataType.QUIVER) && DIZANAS_QUIVER_IDS.stream().anyMatch(container::contains))
			{
				handleQuiverChange();
			}
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

		if (isTypeEnabled(PartyDataType.PRAYERS))
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

	private void handleDataTypeFullyDisabled(PartyDataType partyDataType)
	{
		if (partyDataType == PartyDataType.PRAYERS)
		{
			playerData.resetPrayers();
		}

		// Inventory and Equipment are not persisted so nothing to do
	}

	private void handleDataTypeFirstEnabled(PartyDataType partyDataType)
	{
		if (partyDataType == PartyDataType.PRAYERS)
		{
			playerData.resetPrayers();
		}

		// Thr rest of the events only matter if they enabled this while the user is actively logged in
		if (client.getLocalPlayer() == null)
		{
			return;
		}

		if (partyDataType == PartyDataType.INVENTORY)
		{
			ItemContainer c = client.getItemContainer(InventoryID.INV);
			if (c != null)
			{
				handleInventoryChange(c);
			}
		}

		if (partyDataType == PartyDataType.EQUIPMENT)
		{
			ItemContainer c = client.getItemContainer(InventoryID.WORN);
			if (c != null)
			{
				handleEquipmentChange(c);
			}
		}
	}

	private void handleEquipmentChange(ItemContainer container)
	{
		int[] items = PartySerializationUtils.convertItemContainerToIntArray(container);
		currentChange.setEquipment(items);
	}

	private void handleInventoryChange(ItemContainer container)
	{
		int[] items = PartySerializationUtils.convertItemContainerToIntArray(container);
		currentChange.setInventory(items);
	}

	private void handleRunePouchChange()
	{
		final Item[] runesInPouch = getRunePouchContents(client);
		if (Arrays.equals(playerData.getRunePouchContents(), runesInPouch))
		{
			return;
		}

		playerData.setRunePouchContents(runesInPouch);

		final int[] rp = PartySerializationUtils.convertItemsToIntArray(runesInPouch);
		currentChange.setRunesInPouch(rp);
	}

	private void handleQuiverChange()
	{
		final Item quiverAmmo = getQuiverAmmo();
		if (Objects.equals(playerData.getQuiverAmmo(), quiverAmmo))
		{
			return;
		}

		playerData.setQuiverAmmo(quiverAmmo);

		if (quiverAmmo == null)
		{
			// We need to transmit that their quiver is empty
			currentChange.setQuiverAmmo(new int[0]);
		}
		else
		{
			currentChange.setQuiverAmmo(new int[]{ quiverAmmo.getId(), quiverAmmo.getQuantity() });
		}
	}

	private Item getQuiverAmmo()
	{
		final int quiverAmmoId = client.getVarpValue(VarPlayerID.DIZANAS_QUIVER_TEMP_AMMO);
		final int quiverAmmoCount = client.getVarpValue(VarPlayerID.DIZANAS_QUIVER_TEMP_AMMO_AMOUNT);
		if (quiverAmmoId == -1 || quiverAmmoCount == 0)
		{
			return null;
		}

		return new Item(quiverAmmoId, quiverAmmoCount);
	}

	private static boolean itemContainerHasRunePouch(ItemContainer inventory)
	{
		for (final int id : RUNEPOUCH_ITEM_IDS)
		{
			if (inventory.contains(id))
			{
				return true;
			}
		}
		return false;
	}

	public static Item[] getRunePouchContents(Client client)
	{
		final EnumComposition runePouchEnum = client.getEnum(EnumID.RUNEPOUCH_RUNE);
		final List<Item> items = new ArrayList<>();
		for (int i = 0; i < RUNEPOUCH_AMOUNT_VARBITS.length; i++)
		{
			int amount = client.getVarbitValue(RUNEPOUCH_AMOUNT_VARBITS[i]);
			if (amount <= 0)
			{
				continue;
			}

			int runeId = client.getVarbitValue(RUNEPOUCH_RUNE_VARBITS[i]);
			if (runeId == 0)
			{
				continue;
			}

			final int itemId = runePouchEnum.getIntValue(runeId);
			items.add(new Item(itemId, amount));
		}

		return items.toArray(new Item[0]);
	}
}
