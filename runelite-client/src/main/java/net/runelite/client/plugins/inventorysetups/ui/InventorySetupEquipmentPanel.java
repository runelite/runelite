/*
 * Copyright (c) 2018-2019, Ethan <https://github.com/Wea1thRS/>
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.inventorysetups.ui;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import javax.swing.JPanel;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.inventorysetups.InventorySetup;
import net.runelite.client.plugins.inventorysetups.InventorySetupItem;
import net.runelite.client.plugins.inventorysetups.InventorySetupPlugin;
import net.runelite.client.ui.ColorScheme;

@Singleton
public class InventorySetupEquipmentPanel extends InventorySetupContainerPanel
{
	private Map<EquipmentInventorySlot, InventorySetupSlot> equipmentSlots;

	InventorySetupEquipmentPanel(final ItemManager itemManager, final InventorySetupPlugin plugin)
	{
		super(itemManager, plugin, "Equipment");
	}

	@Override
	public void setupContainerPanel(final JPanel containerSlotsPanel)
	{
		this.equipmentSlots = new HashMap<>();
		for (EquipmentInventorySlot slot : EquipmentInventorySlot.values())
		{
			equipmentSlots.put(slot, new InventorySetupSlot(ColorScheme.DARKER_GRAY_COLOR));
		}

		final GridLayout gridLayout = new GridLayout(5, 3, 1, 1);
		containerSlotsPanel.setLayout(gridLayout);

		// add the grid layouts, including invisible ones
		containerSlotsPanel.add(new InventorySetupSlot(ColorScheme.DARK_GRAY_COLOR));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.HEAD));
		containerSlotsPanel.add(new InventorySetupSlot(ColorScheme.DARK_GRAY_COLOR));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.CAPE));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.AMULET));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.AMMO));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.WEAPON));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.BODY));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.SHIELD));
		containerSlotsPanel.add(new InventorySetupSlot(ColorScheme.DARK_GRAY_COLOR));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.LEGS));
		containerSlotsPanel.add(new InventorySetupSlot(ColorScheme.DARK_GRAY_COLOR));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.GLOVES));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.BOOTS));
		containerSlotsPanel.add(equipmentSlots.get(EquipmentInventorySlot.RING));

	}

	void setEquipmentSetupSlots(final InventorySetup setup)
	{
		final List<InventorySetupItem> equipment = setup.getEquipment();

		for (final EquipmentInventorySlot slot : EquipmentInventorySlot.values())
		{
			int i = slot.getSlotIdx();
			super.setContainerSlot(i, equipmentSlots.get(slot), equipment);
		}

		validate();
		repaint();

	}

	void highlightDifferences(final List<InventorySetupItem> currEquipment, final InventorySetup inventorySetup)
	{
		final List<InventorySetupItem> equipToCheck = inventorySetup.getEquipment();

		assert currEquipment.size() == equipToCheck.size() : "size mismatch";

		for (final EquipmentInventorySlot slot : EquipmentInventorySlot.values())
		{

			int slotIdx = slot.getSlotIdx();
			super.highlightDifferentSlotColor(equipToCheck.get(slotIdx), currEquipment.get(slotIdx), equipmentSlots.get(slot));
		}
	}

	void resetEquipmentSlotsColor()
	{
		for (final EquipmentInventorySlot slot : EquipmentInventorySlot.values())
		{
			equipmentSlots.get(slot).setBackground(ColorScheme.DARKER_GRAY_COLOR);
		}
	}
}