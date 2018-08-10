/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.suppliestracker;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.item.Item;

import javax.inject.Inject;
import javax.swing.SwingUtilities;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

@PluginDescriptor(
	name = "Supplies Used Tracker",
	description = "Tracks supplies used during the session",
	tags = {"cost"},
	enabledByDefault = false
)
@Slf4j
public class SuppliesTrackerPlugin extends Plugin
{
	//Hold Supply Data
	private static HashMap<Integer, Integer> suppliesUsed = new HashMap<>();
	private static HashMap<Integer, SuppliesTrackerItemEntry> suppliesEntry = new HashMap<>();
	int actionParam = 0;
	ItemContainer old;
	net.runelite.api.Item oldItems[] = new net.runelite.api.Item[]{};
	Deque<Integer> stack = new ArrayDeque<Integer>();
	Deque<Integer> slotstack = new ArrayDeque<Integer>();
	int lastMenuEntryID = 0;


	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private Client client;

	private SuppliesTrackerPanel panel;
	private NavigationButton navButton;

	
	@Override
	protected void startUp() throws Exception
	{
		panel = new SuppliesTrackerPanel(itemManager);
		final BufferedImage header = ImageUtil.getResourceStreamFromClass(getClass(), "sarabrew.png");
		panel.loadHeaderIcon(header);
		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Supplies Tracker")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
	}


	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged itemContainerChanged) throws ExecutionException {
		ItemContainer itemContainer = itemContainerChanged.getItemContainer();
		if (itemContainer == client.getItemContainer(InventoryID.INVENTORY) && old != null)
		{
			while (!slotstack.isEmpty())
			{
				int slot = slotstack.pop();
				if (itemContainer.getItems()[slot] != old.getItems()[slot])
				{
					while (!stack.isEmpty())
					{
						int next = stack.pop();
						if (next != 229 && next != 7510)
						{
							buildEntries(next);
						}
					}
				}
			}
		}
			}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event) throws ExecutionException
	{
		if (event.getMenuTarget().toLowerCase().contains("drink") || (event.getMenuTarget().toLowerCase().contains("eat") && event.getId() != 7510))
		{
			if (!stack.contains(event.getId()))
			{
				lastMenuEntryID = event.getId();
				old = client.getItemContainer(InventoryID.INVENTORY);
				net.runelite.api.Item oldItems[] = old.getItems();
				if (old.getItems() != null)
				{
					actionParam = event.getActionParam();
					int pushItem = oldItems[event.getActionParam()].getId();
					stack.push(pushItem);
					slotstack.push(actionParam);
				}
			}
		}
	}

	private void buildEntries(int itemId) throws ExecutionException
	{
			final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
			String name = itemComposition.getName();
			long price;
			boolean potion = false;
			boolean pizzapie = false;

			//Check if item is potion, pie, or pizza
			if (name.contains("(4)") || name.contains("(3)") || name.contains("(2)") || name.contains("(1)"))
			{
				String pattern = "[(]\\d[)]";
				name = name.replaceAll(pattern, "(4)");
				itemId = getNewName(name);
				potion = true;
			}
			if (name.toLowerCase().contains("pizza") || name.toLowerCase().contains(" pie"))
			{
				itemId = getFull(itemId);
				name = itemManager.getItemComposition(itemId).getName();
				pizzapie = true;
			}
			else if (name.toLowerCase().contains("cake") || itemId == 1901)
			{
				itemId = getFull(itemId);
				name = itemManager.getItemComposition(itemId).getName();
			}

			//build supplies used hashmap
			int temp = 0;
			if (suppliesUsed.containsKey(itemId))
			{
				temp = suppliesUsed.get(itemId) + 1;
				suppliesUsed.put(itemId, temp);
			}
			else
			{
				suppliesUsed.put(itemId, 1);
			}
			int quantity = suppliesUsed.get(itemId);

			//get price
			price = (long)itemManager.getItemPrice(itemId) * (long)quantity;

			//Divide price if true
			if (potion)
			{
				price = price / 4;
			}
			if (pizzapie)
			{
				price = price / 2;
			}

			//Correct price for cake
			if (itemId == 1891 || itemId == 1897)
			{
				price = price / 3;
			}

			//Check for duplicates
			if (!suppliesEntry.containsKey(itemId))
			{
				suppliesEntry.put(itemId, new SuppliesTrackerItemEntry(
					itemId,
					name,
					quantity,
					price));
			}
			else
				{
					suppliesEntry.remove(itemId);
					suppliesEntry.put(itemId, new SuppliesTrackerItemEntry(
						itemId,
						name,
						quantity,
						price));
				}
			SwingUtilities.invokeLater(() ->
			{
				try
				{
					panel.addRow(suppliesEntry);
				}
				catch (ExecutionException e)
				{
					e.printStackTrace();
				}
			});
	}

	/* Used for reset all */
	void clearSupplies()
	{
		suppliesEntry.clear();
		suppliesUsed.clear();
	}


	//Used for reset item row
	void clearItem(int itemId)
	{
		suppliesUsed.remove(itemId);
		suppliesEntry.remove(itemId);
	}

	private int getNewName(String name) throws ExecutionException
	{
		int itemId = 0;
		List<Item> items = itemManager.searchForItem(name).getItems();
		for (net.runelite.http.api.item.Item item: items)
		{
			if (item.getName().contains(name))
			{
				itemId = item.getId();
			}
		}
		return itemId;
	}

	private int getFull(int itemId)
	{
		switch (itemId)
		{
			case 2299:
				itemId = 2297;
				break;
			case 2295:
				itemId = 2293;
				break;
			case 2303:
				itemId = 2301;
				break;
			case 2291:
				itemId = 2289;
				break;
			case 2333:
				itemId = 2325;
				break;
			case 7180:
				itemId = 7178;
				break;
			case 7220:
				itemId = 7218;
				break;
			case 7190:
				itemId = 7188;
				break;
			case 19659:
				itemId = 19662;
				break;
			case 21687:
				itemId = 21690;
				break;
			case 7200:
				itemId = 7198;
				break;
			case 7210:
				itemId = 7208;
				break;
			case 2335:
				itemId = 2323;
				break;
			case 2331:
				itemId = 2327;
				break;
			case 1893:
				itemId = 1891;
				break;
			case 1895:
				itemId = 1891;
				break;
			case 1899:
				itemId = 1897;
				break;
			case 1901:
				itemId = 1897;
				break;
		}
		return itemId;
	}
}
