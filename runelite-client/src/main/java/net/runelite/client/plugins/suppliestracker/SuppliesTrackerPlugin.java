/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Dylan White <Whitedylan7@gmail.com>
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
import net.runelite.api.events.AnimationChanged;
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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
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
	private static SuppliesTrackerPlugin suppliesTrackerPlugin_instance = null;
	private static HashMap<Integer, Integer> suppliesUsed = new HashMap<>();
	private static HashMap<Integer, SuppliesTrackerItemEntry> suppliesEntry = new HashMap<>();
	private ItemContainer old;
	private Deque<Integer> itemStack = new ArrayDeque<>();
	private Deque<Integer> slotStack = new ArrayDeque<>();
	private Deque<String> typeStack = new ArrayDeque<>();
	private Deque<net.runelite.api.Item[]> oldInventStack = new ArrayDeque<>();
	private int ammoId = 0;
	private int ammoAmount = 0;
	private int thrownId = 0;
	private int thrownAmount = 0;
	private int[] throwingIds = new int[]{806, 807, 808, 3093, 809, 810, 811, 11230, 864, 863, 865, 869, 866, 867, 868, 800, 801, 802, 803, 804, 805, 20849, 10033, 10034, 11959};
	private boolean ammoLoaded = false;
	private boolean throwingAmmoLoaded = false;
	private boolean mainHandThrowing = false;
	private int dartShots = 0;
	private int mainHand = 0;
	private SuppliesTrackerPanel panel;
	private NavigationButton navButton;
	private String[] RAIDS_CONSUMABLES = new String[]{"xeric's", "elder", "twisted", "revitalisation", "overload", "prayer enhance", "pysk", "suphi", "leckish", "brawk", "mycil", "roqed", "kyren", "guanic", "prael", "giral", "phluxia", "kryket", "murng", "psykk"};
	ExecutorService executor = Executors.newSingleThreadExecutor();

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private Client client;

	
	@Override
	protected void startUp() throws Exception
	{

		panel = new SuppliesTrackerPanel(itemManager);
		suppliesTrackerPlugin_instance = this;
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
	public void onAnimationChanged(AnimationChanged animationChanged) throws ExecutionException
	{

		if (animationChanged.getActor() == client.getLocalPlayer())
		{
			//estimate for scale usage on blowpipe inaccurate because bp might be on different darts til next scale used
			/* Turned off for now too inaccurate
			if (animationChanged.getActor().getAnimation() == 5061)
			{
				dartShots++;
				if (dartShots == 2)
				{
					buildEntries(12934);
				}
				if (dartShots == 3)
				{
					buildEntries(12934);
					dartShots = 0;
				}
			}*/
			//Trident of the seas
			if (animationChanged.getActor().getAnimation() == 1167)
			{
				if (mainHand == 11907 || mainHand == 2228 || mainHand == 11905 )
				{
					buildEntries(560);
					buildEntries(562);
					buildEntries(554);
					buildEntries(554);
					buildEntries(554);
					buildEntries(554);
					buildEntries(554);
					buildEntries(995);
					buildEntries(995);
					buildEntries(995);
					buildEntries(995);
					buildEntries(995);
					buildEntries(995);
					buildEntries(995);
					buildEntries(995);
					buildEntries(995);
					buildEntries(995);
				}
				//Trident of the swamp
				if (mainHand == 12899 || mainHand == 22292)
				{
					buildEntries(560);
					buildEntries(562);
					buildEntries(554);
					buildEntries(554);
					buildEntries(554);
					buildEntries(554);
					buildEntries(554);
					buildEntries(12934);
				}
				//Sang Staff
				if (mainHand == 22323 || mainHand == 22481)
				{
					buildEntries(565);
					buildEntries(565);
					buildEntries(565);

				}
			}
		}

	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged itemContainerChanged) throws ExecutionException
	{

		ItemContainer itemContainer = itemContainerChanged.getItemContainer();

		if (itemContainer == client.getItemContainer(InventoryID.INVENTORY) && old != null && !typeStack.isEmpty())
		{
			while (!typeStack.isEmpty())
			{
				String getType = typeStack.pop();

				//Consumable
				if (getType.contains("consumable"))
				{
					for (int i = 0; i < slotStack.size(); i++)
					{
						int nextItem = itemStack.pop();
						int nextSlot = slotStack.pop();
						net.runelite.api.Item[] oldInv = oldInventStack.pop();
						if (itemContainer.getItems()[nextSlot].getId() != oldInv[nextSlot].getId())
						{
							buildEntries(nextItem);
						}
					}
				}

				//Teleports
				if (getType.contains("teleport"))
				{
					int slot = slotStack.pop();
					int teleid = itemStack.pop();
					net.runelite.api.Item[] oldInv = oldInventStack.pop();
					if (itemContainer.getItems()[slot].getId() != oldInv[slot].getId() || itemContainer.getItems()[slot].getQuantity() != oldInv[slot].getQuantity())
					{
						buildEntries(teleid);
					}
				}
			}
		}


		if (itemContainer == client.getItemContainer(InventoryID.EQUIPMENT))
		{
			//set mainhand for trident tracking
			if (itemContainer.getItems().length > 3)
			{
				mainHand = itemContainer.getItems()[3].getId();
				net.runelite.api.Item mainHandItem = itemContainer.getItems()[3];
				for (int throwingIDs: throwingIds)
				{
					if (mainHand == throwingIDs)
					{
						mainHandThrowing = true;
						break;
					}
					else
					{
						mainHandThrowing = false;
					}
				}
				if (mainHandThrowing)
				{
					if (throwingAmmoLoaded)
					{
						if (thrownId == mainHandItem.getId())
						{
							if (thrownAmount - 1 == mainHandItem.getQuantity())
							{
								buildEntries(mainHandItem.getId());
								thrownAmount = mainHandItem.getQuantity();
							}
							else
							{
								thrownAmount = mainHandItem.getQuantity();
							}
						}
						else
						{
							thrownId = mainHandItem.getId();
							thrownAmount = mainHandItem.getQuantity();
						}
					}
					else
					{
						thrownId = mainHandItem.getId();
						thrownAmount = mainHandItem.getQuantity();
						throwingAmmoLoaded = true;
					}
				}
			}

			//Ammo tracking
			if (itemContainer.getItems().length > 13)
			{
				net.runelite.api.Item ammoSlot = itemContainer.getItems()[13];
				if (ammoSlot != null)
				{
					if (ammoLoaded)
					{
						if (ammoId == ammoSlot.getId())
						{
							if (ammoAmount - 1 == ammoSlot.getQuantity())
							{
								buildEntries(ammoSlot.getId());
								ammoAmount = ammoSlot.getQuantity();
							}
							else
							{
								ammoAmount = ammoSlot.getQuantity();
							}
						}
						else
						{
							ammoId = ammoSlot.getId();
							ammoAmount = ammoSlot.getQuantity();
						}
					}
					else
					{
						ammoId = ammoSlot.getId();
						ammoAmount = ammoSlot.getQuantity();
						ammoLoaded = true;
					}
				}
			}

		}
			}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		//Uses stacks to push/pop for tick eating
		//Create pattern to find eat/drink at beginning

		Pattern r = Pattern.compile("^eat");
		Pattern r2 = Pattern.compile("^drink");

		if (r.matcher(event.getMenuTarget().toLowerCase()).find() || r2.matcher(event.getMenuTarget().toLowerCase()).find())
		{
			if (!itemStack.contains(event.getId()))
			{
				old = client.getItemContainer(InventoryID.INVENTORY);
				oldInventStack.push(old.getItems());
				int slot = event.getActionParam();
				if (old.getItems() != null)
				{
					int pushItem = old.getItems()[event.getActionParam()].getId();
					typeStack.push("consumable");
					itemStack.push(pushItem);
					slotStack.push(slot);
				}
			}
		}

		// Change pattern for teleport

		r = Pattern.compile("^teleport");
		int teleid;
		if (r.matcher(event.getMenuTarget().toLowerCase()).find())
		{
			old = client.getItemContainer(InventoryID.INVENTORY);

			//Makes stack only contains one teleport type to stop from adding multiple of one teleport
			if (old.getItems() != null && !typeStack.contains("teleport"))
			{
				teleid = event.getId();
				oldInventStack.push(old.getItems());
				slotStack.push(event.getActionParam());
				typeStack.push("teleport");
				itemStack.push(teleid);
			}
		}

		//Change pattern for teleport tablets
		r = Pattern.compile("^break");

		if (r.matcher(event.getMenuTarget().toLowerCase()).find())
		{
			old = client.getItemContainer(InventoryID.INVENTORY);

			if (old.getItems() != null && !typeStack.contains("teleport"))
			{
				teleid = event.getId();
				oldInventStack.push(old.getItems());
				slotStack.push(event.getActionParam());
				typeStack.push("teleport");
				itemStack.push(teleid);
			}
		}
	}

	void buildEntries(int itemId) throws ExecutionException
	{
			final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
			String name = itemComposition.getName();
			long price;
			boolean potion = false;
			boolean pizzapie = false;


			for (String raidsConsumables: RAIDS_CONSUMABLES)
			{
				if (name.contains(raidsConsumables)) return;
			}

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
			int temp;
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

	// Used for reset all
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

	//Used for reset item row
	void setAmount(int itemId, int amount)
	{
		long price;
		price = (long)itemManager.getItemPrice(itemId) * (long)amount;
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		String name = itemComposition.getName();

		suppliesEntry.put(itemId, new SuppliesTrackerItemEntry(itemId, name, amount, price));
		suppliesUsed.put(itemId, amount);

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

	private int getNewName(String name) throws ExecutionException
	{
		int itemId = 0;

		if (name.equals("Extended antifire(4)")) return 11951;

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

	public synchronized static SuppliesTrackerPlugin getInstance()
	{
		if (suppliesTrackerPlugin_instance == null)
		{
			suppliesTrackerPlugin_instance = new SuppliesTrackerPlugin();
		}
		return suppliesTrackerPlugin_instance;
	}

}
