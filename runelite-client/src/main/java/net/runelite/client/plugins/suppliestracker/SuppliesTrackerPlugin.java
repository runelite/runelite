/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Daddy Dozer <Whitedylan7@gmail.com>
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


import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.item.ItemPrice;
import static net.runelite.api.ItemID.*;
import java.util.concurrent.ScheduledExecutorService;
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
	private int[] throwingIds = new int[]{BRONZE_DART, IRON_DART, STEEL_DART, BLACK_DART, MITHRIL_DART, ADAMANT_DART, RUNE_DART, DRAGON_DART, BRONZE_KNIFE, IRON_KNIFE, STEEL_KNIFE, BLACK_KNIFE, MITHRIL_KNIFE, ADAMANT_KNIFE, RUNE_KNIFE, BRONZE_THROWNAXE, IRON_THROWNAXE, STEEL_THROWNAXE, MITHRIL_THROWNAXE, ADAMANT_THROWNAXE, RUNE_THROWNAXE, DRAGON_KNIFE, DRAGON_KNIFE_22812, DRAGON_KNIFE_22814, DRAGON_KNIFEP_22808, DRAGON_KNIFEP_22810, DRAGON_KNIFEP , DRAGON_THROWNAXE, CHINCHOMPA_10033, RED_CHINCHOMPA_10034, BLACK_CHINCHOMPA};
	private boolean ammoLoaded = false;
	private boolean throwingAmmoLoaded = false;
	private boolean mainHandThrowing = false;
	private int mainHand = 0;
	private SuppliesTrackerPanel panel;
	private NavigationButton navButton;
	private String[] RAIDS_CONSUMABLES = new String[]{"xeric's", "elder", "twisted", "revitalisation", "overload", "prayer enhance", "pysk", "suphi", "leckish", "brawk", "mycil", "roqed", "kyren", "guanic", "prael", "giral", "phluxia", "kryket", "murng", "psykk"};


	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private Client client;

	@Inject
	private ScheduledExecutorService executorService;

	@Inject
	private ClientThread clientThread;

	
	@Override
	protected void startUp() throws Exception
	{

		panel = new SuppliesTrackerPanel(clientThread, itemManager, executorService);
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
			if (animationChanged.getActor().getAnimation() == 1167)
			{
				//Trident of the seas
				if (mainHand == TRIDENT_OF_THE_SEAS || mainHand == TRIDENT_OF_THE_SEAS_E || mainHand == TRIDENT_OF_THE_SEAS_FULL )
				{
					buildEntries(CHAOS_RUNE);
					buildEntries(DEATH_RUNE);
					buildEntries(FIRE_RUNE);
					buildEntries(FIRE_RUNE);
					buildEntries(FIRE_RUNE);
					buildEntries(FIRE_RUNE);
					buildEntries(FIRE_RUNE);
					buildEntries(COINS_995);
					buildEntries(COINS_995);
					buildEntries(COINS_995);
					buildEntries(COINS_995);
					buildEntries(COINS_995);
					buildEntries(COINS_995);
					buildEntries(COINS_995);
					buildEntries(COINS_995);
					buildEntries(COINS_995);
					buildEntries(COINS_995);
				}
				//Trident of the swamp
				if (mainHand == TRIDENT_OF_THE_SWAMP_E || mainHand == TRIDENT_OF_THE_SWAMP || mainHand == UNCHARGED_TOXIC_TRIDENT_E || mainHand == UNCHARGED_TOXIC_TRIDENT)
				{
					buildEntries(CHAOS_RUNE);
					buildEntries(DEATH_RUNE);
					buildEntries(FIRE_RUNE);
					buildEntries(FIRE_RUNE);
					buildEntries(FIRE_RUNE);
					buildEntries(FIRE_RUNE);
					buildEntries(FIRE_RUNE);
					buildEntries(ZULRAHS_SCALES);
				}
				//Sang Staff
				if (mainHand == SANGUINESTI_STAFF || mainHand == SANGUINESTI_STAFF_UNCHARGED)
				{
					buildEntries(BLOOD_RUNE);
					buildEntries(BLOOD_RUNE);
					buildEntries(BLOOD_RUNE);

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
	public void onMenuOptionClicked(final MenuOptionClicked event)
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
				if (name.toLowerCase().contains(raidsConsumables)) return;
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
			if (itemId == CHOCOLATE_CAKE || itemId == CAKE)
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

	void setAmount(int itemId, int amount)
	{
		long price;
		price = (long)itemManager.getItemPrice(itemId) * (long)amount;
		if (itemManager.getItemComposition(itemId).getName().contains("(4)"))
		{
			price = price / 4;
		}
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

		List<ItemPrice> items = itemManager.search(name);
		for (ItemPrice item: items)
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
			case _12_ANCHOVY_PIZZA:
				itemId = ANCHOVY_PIZZA;
				break;
			case _12_MEAT_PIZZA:
				itemId = MEAT_PIZZA;
				break;
			case _12_PINEAPPLE_PIZZA:
				itemId = PINEAPPLE_PIZZA;
				break;
			case _12_PLAIN_PIZZA:
				itemId = PLAIN_PIZZA;
				break;
			case HALF_A_REDBERRY_PIE:
				itemId = REDBERRY_PIE;
				break;
			case HALF_A_GARDEN_PIE:
				itemId = GARDEN_PIE;
				break;
			case HALF_A_SUMMER_PIE:
				itemId = SUMMER_PIE;
				break;
			case HALF_A_FISH_PIE:
				itemId = FISH_PIE;
				break;
			case HALF_A_BOTANICAL_PIE:
				itemId = BOTANICAL_PIE;
				break;
			case HALF_A_MUSHROOM_PIE:
				itemId = MUSHROOM_PIE;
				break;
			case HALF_AN_ADMIRAL_PIE:
				itemId = ADMIRAL_PIE;
				break;
			case HALF_A_WILD_PIE:
				itemId = WILD_PIE;
				break;
			case HALF_AN_APPLE_PIE:
				itemId = APPLE_PIE;
				break;
			case HALF_A_MEAT_PIE:
				itemId = MEAT_PIE;
				break;
			case _23_CAKE:
				itemId = CAKE;
				break;
			case SLICE_OF_CAKE:
				itemId = CAKE;
				break;
			case _23_CHOCOLATE_CAKE:
				itemId = CHOCOLATE_CAKE;
				break;
			case CHOCOLATE_SLICE:
				itemId = CHOCOLATE_CAKE;
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
