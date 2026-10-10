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
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Skill;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.StatChanged;
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
import net.runelite.client.party.messages.UserSync;
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
	private PlayerPartyData playerData = new PlayerPartyData();
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
			playerData = new PlayerPartyData();
		}
	}

	@Subscribe(priority = 1)
	public void onUserSync(final UserSync ignored)
	{
		if (!inParty())
		{
			return;
		}

		handleUserSyncRequest();
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
				lastSeenAccountHash = accountHash;

				currentChange = new PartyDataChange();
				playerData = new PlayerPartyData();

				handleUserSyncRequest();
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

		// These update on login even if the player doesn't have the pouch in their inventory.
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

			if (isTypeEnabled(PartyDataType.QUIVER) && isWearingQuiver(container))
			{
				handleQuiverChange();
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

	@Subscribe(priority = 1)
	public void onStatChanged(final StatChanged event)
	{
		if (!inParty() || !isTypeEnabled(PartyDataType.STATS))
		{
			return;
		}

		final Skill s = event.getSkill();
		if (s == Skill.OVERALL)
		{
			return;
		}

		// Always use virtual level so the plugin can decide if it wants to cap the levels at 99
		final int virtualLevel = Experience.getLevelForXp(event.getXp());
		final int boostedLevel = event.getBoostedLevel();

		final SkillData updatedSkillData = new SkillData(s, virtualLevel, boostedLevel);
		final SkillData currentSkillData = playerData.getSkillDataMap().get(s);
		if (updatedSkillData.equals(currentSkillData))
		{
			return;
		}

		playerData.getSkillDataMap().put(s, updatedSkillData);
		currentChange.addSkillChange(updatedSkillData);
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
		if (partyDataType == PartyDataType.INVENTORY)
		{
			playerData.setInventory(new Item[0]);
		}

		if (partyDataType == PartyDataType.EQUIPMENT)
		{
			playerData.setEquipment(new Item[0]);
		}

		if (partyDataType == PartyDataType.PRAYERS)
		{
			playerData.resetPrayers();
		}

		if (partyDataType == PartyDataType.RUNE_POUCH)
		{
			playerData.setRunePouchContents(new Item[0]);
		}

		if (partyDataType == PartyDataType.QUIVER)
		{
			playerData.setQuiverAmmo(null);
		}

		if (partyDataType == PartyDataType.STATS)
		{
			playerData.getSkillDataMap().clear();
		}
	}

	private void handleDataTypeFirstEnabled(PartyDataType partyDataType)
	{
		if (partyDataType == PartyDataType.PRAYERS)
		{
			playerData.resetPrayers();
			prayerService.updatePrayerBook();
			playerData.setPrayerBookID(prayerService.getPrayerBookID());
		}

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		ItemContainer inventory = client.getItemContainer(InventoryID.INV);
		ItemContainer equipment = client.getItemContainer(InventoryID.WORN);
		if (partyDataType == PartyDataType.INVENTORY && inventory != null)
		{
			handleInventoryChange(inventory);
		}

		if (partyDataType == PartyDataType.EQUIPMENT && equipment != null)
		{
			handleEquipmentChange(equipment);
		}

		if (partyDataType == PartyDataType.RUNE_POUCH && itemContainerHasRunePouch(inventory))
		{
			handleRunePouchChange();
		}

		if (partyDataType == PartyDataType.QUIVER)
		{
			if ((equipment != null && isWearingQuiver(equipment))
					|| (inventory != null && DIZANAS_QUIVER_IDS.stream().anyMatch(inventory::contains)))
			{
				handleQuiverChange();
			}
		}

		if (partyDataType == PartyDataType.STATS)
		{
			playerData.seedSkillData(client);

			final Collection<SkillData> updates = playerData.getSkillDataMap().values();
			currentChange.setPendingStatUpdates(updates);
		}
	}

	private void handleEquipmentChange(ItemContainer container)
	{
		int[] items = PartySerializationUtils.convertItemContainerToIntArray(container);
		currentChange.setEquipment(items);
		playerData.setEquipment(container.getItems());
	}

	private void handleInventoryChange(ItemContainer container)
	{
		int[] items = PartySerializationUtils.convertItemContainerToIntArray(container);
		currentChange.setInventory(items);
		playerData.setInventory(container.getItems());
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
		if (inventory == null)
		{
			return false;
		}

		for (final int id : RUNEPOUCH_ITEM_IDS)
		{
			if (inventory.contains(id))
			{
				return true;
			}
		}
		return false;
	}

	private boolean isWearingQuiver(ItemContainer equipment)
	{
		final Item wornCape = equipment.getItem(EquipmentInventorySlot.CAPE.getSlotIdx());
		return wornCape != null && DIZANAS_QUIVER_IDS.contains(wornCape.getId());
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

	// This will send all key value pairs, even when normally there would be empty or blank data.
	// This is to ensure that if a user has switched accounts their inventory/equipment/etc is reset properly
	private void handleUserSyncRequest()
	{
		final PartyDataChange fullSync = new PartyDataChange();

		if (isTypeEnabled(PartyDataType.INVENTORY))
		{
			fullSync.setInventory(PartySerializationUtils.convertItemsToIntArray(playerData.getInventory()));
		}

		if (isTypeEnabled(PartyDataType.EQUIPMENT))
		{
			fullSync.setEquipment(PartySerializationUtils.convertItemsToIntArray(playerData.getEquipment()));
		}

		if (isTypeEnabled(PartyDataType.PRAYERS))
		{
			final byte[][] prayerDeltas = prayerService.getPrayerDeltas(playerData, true, true, true);
			fullSync.setAvailablePrayers(prayerDeltas[0]);
			fullSync.setEnabledPrayers(prayerDeltas[1]);
			fullSync.setUnlockedPrayers(prayerDeltas[2]);
			fullSync.setPrayerBookID(prayerService.getPrayerBookID());
		}

		if (isTypeEnabled(PartyDataType.RUNE_POUCH))
		{
			final Item[] runePouchContents = playerData.getRunePouchContents();
			fullSync.setRunesInPouch(PartySerializationUtils.convertItemsToIntArray(runePouchContents));
		}

		if (isTypeEnabled(PartyDataType.QUIVER))
		{
			if (playerData.getQuiverAmmo() != null)
			{
				fullSync.setQuiverAmmo(new int[]{playerData.getQuiverAmmo().getId(), playerData.getQuiverAmmo().getQuantity()});
			}
			else
			{
				fullSync.setQuiverAmmo(new int[0]);
			}
		}

		if (isTypeEnabled(PartyDataType.STATS))
		{
			fullSync.setPendingStatUpdates(playerData.getSkillDataMap().values());
		}

		fullSync.setMemberId(partyService.getLocalMember().getMemberId());
		partyService.send(fullSync);

		// Pending changes would be sent on next game tick, these can be discarded now
		currentChange = new PartyDataChange();
	}
}
