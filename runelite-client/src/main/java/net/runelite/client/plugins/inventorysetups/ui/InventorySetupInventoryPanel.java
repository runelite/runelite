package net.runelite.client.plugins.inventorysetups.ui;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.inventorysetups.InventorySetup;
import net.runelite.client.plugins.inventorysetups.InventorySetupItem;
import net.runelite.client.plugins.inventorysetups.InventorySetupPlugin;
import net.runelite.client.ui.ColorScheme;

public class InventorySetupInventoryPanel extends InventorySetupContainerPanel
{
	private static final int ITEMS_PER_ROW = 4;
	private static final int NUM_INVENTORY_ITEMS = 28;

	private ArrayList<InventorySetupSlot> inventorySlots;

	InventorySetupInventoryPanel(final ItemManager itemManager, final InventorySetupPlugin plugin)
	{
		super(itemManager, plugin, "Inventory");
	}


	@Override
	public void setupContainerPanel(final JPanel containerSlotsPanel)
	{
		this.inventorySlots = new ArrayList<>();
		for (int i = 0; i < NUM_INVENTORY_ITEMS; i++)
		{
			inventorySlots.add(new InventorySetupSlot(ColorScheme.DARKER_GRAY_COLOR));
		}

		int numRows = (NUM_INVENTORY_ITEMS + ITEMS_PER_ROW - 1) / ITEMS_PER_ROW;
		containerSlotsPanel.setLayout(new GridLayout(numRows, ITEMS_PER_ROW, 1, 1));
		for (int i = 0; i < NUM_INVENTORY_ITEMS; i++)
		{
			containerSlotsPanel.add(inventorySlots.get(i));
		}
	}

	void setInventorySetupSlots(final InventorySetup setup)
	{
		ArrayList<InventorySetupItem> inventory = setup.getInventory();

		for (int i = 0; i < NUM_INVENTORY_ITEMS; i++)
		{
			super.setContainerSlot(i, inventorySlots.get(i), inventory);
		}

		validate();
		repaint();

	}

	void highlightDifferentSlots(final ArrayList<InventorySetupItem> currInventory, final InventorySetup inventorySetup)
	{

		final ArrayList<InventorySetupItem> inventoryToCheck = inventorySetup.getInventory();

		assert currInventory.size() == inventoryToCheck.size() : "size mismatch";

		for (int i = 0; i < NUM_INVENTORY_ITEMS; i++)
		{
			super.highlightDifferentSlotColor(inventoryToCheck.get(i), currInventory.get(i), inventorySlots.get(i));
		}
	}

	void resetInventorySlotsColor()
	{
		for (InventorySetupSlot inventorySlot : inventorySlots)
		{
			inventorySlot.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		}
	}
}