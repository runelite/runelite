package net.runelite.client.plugins.bankcontents;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;;
import net.runelite.client.game.ItemManager;
import net.runelite.api.InventoryID;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import net.runelite.client.Notifier;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.google.common.base.Strings;
import net.runelite.client.util.Text;
import java.util.List;

@Slf4j
class BankContents
{
	private final BankContentsConfig config;
	private final ItemManager itemManager;
	private final Client client;
	private final Notifier notifier;

	@Inject
	BankContents(ItemManager itemManager, BankContentsConfig config, Client client, Notifier notifier)
	{
		this.itemManager = itemManager;
		this.config = config;
		this.client = client;
		this.notifier = notifier;
	}

	void createArray()
	{
		ItemContainer bankInventory = client.getItemContainer(InventoryID.BANK);

		if (bankInventory == null)
		{
			return;
		}

		Item[] items = bankInventory.getItems();
		final List<String> data = new ArrayList<>();

		for (Item item : items)
		{
			final ItemComposition itemComposition = itemManager.getItemComposition(item.getId());

			data.add(String.valueOf(itemComposition.getId()));
			data.add(String.valueOf(itemComposition.getName()));
			data.add(String.valueOf(item.getQuantity()));
			data.add(String.valueOf(itemManager.getItemPrice(itemComposition.getId())));

		}
		
		final StringSelection stringSelection = new StringSelection(Text.toCSV(data));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
		notifier.notify("Bank contents copied to clipboard!");
	}
}
