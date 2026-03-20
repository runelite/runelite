/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.ammo;

import com.google.common.collect.ImmutableSet;
import java.awt.image.BufferedImage;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Ammo",
	description = "Shows the current ammo the player has equipped",
	tags = {"bolts", "darts", "chinchompa", "equipment"},
	enabledByDefault = false
)
public class AmmoPlugin extends Plugin
{
	private static final Set<Integer> DIZANAS_QUIVER_IDS = ImmutableSet.<Integer>builder()
		.addAll(ItemVariationMapping.getVariations(ItemVariationMapping.map(ItemID.DIZANAS_QUIVER_CHARGED)))
		.addAll(ItemVariationMapping.getVariations(ItemVariationMapping.map(ItemID.DIZANAS_QUIVER_INFINITE)))
		.addAll(ItemVariationMapping.getVariations(ItemVariationMapping.map(ItemID.SKILLCAPE_MAX_DIZANAS)))
		.build();

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	private AmmoCounter counterBox;
	private AmmoCounter quiverBox;

	private boolean isWearingQuiver;

	@Override
	protected void startUp() throws Exception
	{
		clientThread.invokeLater(() ->
		{
			final ItemContainer container = client.getItemContainer(InventoryID.WORN);

			if (container != null)
			{
				checkInventory(container);
			}
		});
	}

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeInfoBox(counterBox);
		counterBox = null;
		removeQuiverInfobox();
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.WORN))
		{
			return;
		}

		checkInventory(event.getItemContainer());
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarpId() == VarPlayerID.DIZANAS_QUIVER_TEMP_AMMO_AMOUNT || event.getVarpId() == VarPlayerID.DIZANAS_QUIVER_TEMP_AMMO)
		{
			checkQuiver();
		}
	}

	private void checkInventory(ItemContainer equipment)
	{
		final Item cape = equipment.getItem(EquipmentInventorySlot.CAPE.getSlotIdx());
		isWearingQuiver = cape != null && DIZANAS_QUIVER_IDS.contains(cape.getId());
		checkQuiver();

		// Check for weapon slot items. This overrides the ammo slot,
		// as the player will use the thrown weapon (eg. chinchompas, knives, darts)
		final Item weapon = equipment.getItem(EquipmentInventorySlot.WEAPON.getSlotIdx());
		if (weapon != null)
		{
			final ItemComposition weaponComp = itemManager.getItemComposition(weapon.getId());
			if (weaponComp.isStackable())
			{
				updateInfobox(weapon, weaponComp);
				return;
			}
		}

		final Item ammo = equipment.getItem(EquipmentInventorySlot.AMMO.getSlotIdx());
		if (ammo == null)
		{
			removeInfobox();
			return;
		}

		final ItemComposition comp = itemManager.getItemComposition(ammo.getId());
		if (!comp.isStackable())
		{
			removeInfobox();
			return;
		}

		updateInfobox(ammo, comp);
	}

	private void updateInfobox(final Item item, final ItemComposition comp)
	{
		if (counterBox != null && counterBox.getItemID() == item.getId())
		{
			counterBox.setCount(item.getQuantity());
			return;
		}

		removeInfobox();
		final BufferedImage image = itemManager.getImage(item.getId(), 5, false);
		counterBox = new AmmoCounter(this, item.getId(), item.getQuantity(), comp.getName(), image);
		infoBoxManager.addInfoBox(counterBox);
	}

	private void removeInfobox()
	{
		infoBoxManager.removeInfoBox(counterBox);
		counterBox = null;
	}

	private void checkQuiver()
	{
		if (!isWearingQuiver)
		{
			removeQuiverInfobox();
			return;
		}

		final int quiverAmmoId = client.getVarpValue(VarPlayerID.DIZANAS_QUIVER_TEMP_AMMO);
		final int quiverAmmoCount = client.getVarpValue(VarPlayerID.DIZANAS_QUIVER_TEMP_AMMO_AMOUNT);
		if (quiverAmmoId == -1 || quiverAmmoCount == 0)
		{
			removeQuiverInfobox();
			return;
		}

		updateQuiverInfobox(quiverAmmoId, quiverAmmoCount);
	}

	private void updateQuiverInfobox(final int itemId, final int count)
	{
		if (quiverBox != null && quiverBox.getItemID() == itemId)
		{
			quiverBox.setCount(count);
			return;
		}

		final ItemComposition comp = itemManager.getItemComposition(itemId);

		removeQuiverInfobox();
		final BufferedImage image = itemManager.getImage(itemId, 5, false);
		quiverBox = new AmmoCounter(this, itemId, count, comp.getName(), image);
		infoBoxManager.addInfoBox(quiverBox);
	}

	private void removeQuiverInfobox()
	{
		infoBoxManager.removeInfoBox(quiverBox);
		quiverBox = null;
	}
}
