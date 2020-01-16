package net.runelite.client.plugins.inventorysetups.ui;

import net.runelite.client.plugins.inventorysetups.InventorySetup;
import net.runelite.client.plugins.inventorysetups.InventorySetupItem;
import net.runelite.client.plugins.inventorysetups.InventorySetupSlotID;
import net.runelite.client.plugins.inventorysetups.InventorySetupPlugin;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InventorySetupRunePouchPanel extends InventorySetupContainerPanel
{
	private ArrayList<InventorySetupSlot> runeSlots;

	InventorySetupRunePouchPanel(ItemManager itemManager, InventorySetupPlugin plugin)
	{
		super(itemManager, plugin, "Rune Pouch");
	}

	@Override
	public void setupContainerPanel(JPanel containerSlotsPanel)
	{
		runeSlots = new ArrayList<>();
		for (int i = 0; i < 3; i++)
		{
			runeSlots.add(new InventorySetupSlot(ColorScheme.DARKER_GRAY_COLOR, InventorySetupSlotID.RUNE_POUCH, i));
		}

		final GridLayout gridLayout = new GridLayout(1, 4, 1, 1);
		containerSlotsPanel.setLayout(gridLayout);

		for (final InventorySetupSlot slot : runeSlots)
		{
			containerSlotsPanel.add(slot);
		}
	}

	@Override
	public void highlightSlotDifferences(ArrayList<InventorySetupItem> currContainer, InventorySetup inventorySetup)
	{
		assert inventorySetup.getRune_pouch() != null : "Rune Pouch container is null.";

		assert currContainer.size() == 3 : "Incorrect size";

		isHighlighted = true;

		// Note, we don't care about order or stack size

		final ArrayList<InventorySetupItem> setupRunePouch = inventorySetup.getRune_pouch();

		Map<Integer, Long> currInvMap = currContainer.stream()
			.map(InventorySetupItem::getId)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		for (int i = setupRunePouch.size() - 1; i >= 0; i--)
		{
			int itemID = setupRunePouch.get(i).getId();
			Long currentCount = currInvMap.get(itemID);

			if (currentCount == null)
			{
				runeSlots.get(i).setBackground(inventorySetup.getHighlightColor());
				continue;
			}

			if (currentCount == 1)
			{
				currInvMap.remove(itemID);
			}
			else
			{
				currInvMap.put(itemID, currentCount - 1);
			}

			runeSlots.get(i).setBackground(ColorScheme.DARKER_GRAY_COLOR);
		}
	}

	@Override
	public void setSlots(InventorySetup setup)
	{

		if (setup.getRune_pouch() != null)
		{
			for (int i = 0; i < runeSlots.size(); i++)
			{
				super.setContainerSlot(i, runeSlots.get(i), setup);
			}
		}
		else
		{
			for (final InventorySetupSlot slot : runeSlots)
			{
				slot.setImageLabel(null, null);
			}
		}

		validate();
		repaint();
	}

	@Override
	public void resetSlotColors()
	{
		if (!isHighlighted)
		{
			return;
		}
		for (final InventorySetupSlot slot : runeSlots)
		{
			slot.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		}
		isHighlighted = false;

	}

	public void highlightAllSlots(final InventorySetup setup)
	{
		for (final InventorySetupSlot slot : runeSlots)
		{
			slot.setBackground(setup.getHighlightColor());
		}

	}
}
