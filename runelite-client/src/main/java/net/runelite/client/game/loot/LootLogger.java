/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.game.loot;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.NpcID;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.Projectile;
import net.runelite.api.ProjectileID;
import net.runelite.api.Tile;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ActorDespawned;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.ItemLayerChanged;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.loot.data.InventoryItem;
import net.runelite.client.game.loot.data.MemorizedActor;
import net.runelite.client.game.loot.data.MemorizedNpc;
import net.runelite.client.game.loot.data.MemorizedNpcAndLocation;
import net.runelite.client.game.loot.data.MemorizedPlayer;
import net.runelite.client.game.loot.events.EventLootReceived;
import net.runelite.client.game.loot.events.ItemDropped;
import net.runelite.client.game.loot.events.ItemPickedUp;
import net.runelite.client.game.loot.events.NpcLootReceived;
import net.runelite.client.game.loot.events.PlayerLootReceived;

@Slf4j
@Singleton
public class LootLogger
{
	private static final int INVENTORY_SPACE = 28;
	/**
	 * Some NPCs decide where to drop the loot at the same time they start performing
	 * their death animation, so their death animation has to be known.
	 * This list may be incomplete, I didn't test every NPC in the game.
	 */
	private static final Map<Integer, Integer> NPC_DEATH_ANIMATIONS = ImmutableMap.of(
		NpcID.CAVE_KRAKEN, AnimationID.CAVE_KRAKEN_DEATH,
		NpcID.AIR_WIZARD, AnimationID.WIZARD_DEATH,
		NpcID.WATER_WIZARD, AnimationID.WIZARD_DEATH,
		NpcID.EARTH_WIZARD, AnimationID.WIZARD_DEATH,
		NpcID.FIRE_WIZARD, AnimationID.WIZARD_DEATH
	);

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	// posting new events
	private final EventBus eventBus;

	private final Map<Actor, MemorizedActor> interactedActors = new HashMap<>();
	private final List<MemorizedActor> deadActorsThisTick = new ArrayList<>();

	private final Map<WorldPoint, Set<InventoryItem>> groundItemsLastTick = new HashMap<>();
	private final Set<Tile> changedItemLayerTiles = new HashSet<>();

	private WorldPoint playerLocationLastTick;
	private WorldPoint cannonLocation;

	private Set<InventoryItem> prevTickInventoryItems;
	/**
	 * An array containing the items in the inventory during the current tick,
	 * or null if they are the same as in the previous tick.
	 */
	private Set<InventoryItem> thisTickInventoryItems;

	private boolean insideChambersOfXeric = false;
	private boolean hasOpenedRaidsRewardChest = false;
	private boolean hasOpenedTheatreOfBloodRewardChest = false;

	@Inject
	private LootLogger(EventBus eventBus)
	{
		this.eventBus = eventBus;
	}

	/*
	 * Wrappers for posting new events
	 */

	/**
	 * Called when loot was received by killing an NPC. Triggers the NpcLootReceived event.
	 *
	 * @param npc      Killed NpcID
	 * @param comp     Killed NPC's NPCComposition
	 * @param location WorldPoint the NPC died at
	 * @param drops    A List of Items dropped
	 */
	private void onNewNpcLogCreated(int npc, NPCComposition comp, WorldPoint location, List<Item> drops)
	{
		eventBus.post(new NpcLootReceived(npc, comp, location, drops));
	}

	/**
	 * Called when loot was received by killing another Player. Triggers the PlayerLootReceived event.
	 *
	 * @param player   Player that was killed
	 * @param location WorldPoint the Player died at
	 * @param drops    A List of Items dropped
	 */
	private void onNewPlayerLogCreated(Player player, WorldPoint location, List<Item> drops)
	{
		eventBus.post(new PlayerLootReceived(player, location, drops));
	}

	/**
	 * Called when loot was received by completing an activity. Triggers the EventLootReceived event.
	 * The types of events are static and available on the LootEventType class
	 *
	 * @param event LootEventType event name
	 * @param drops    A List of Items received
	 */
	private void onNewEventLogCreated(LootEventType event, List<Item> drops)
	{
		eventBus.post(new EventLootReceived(event, drops));
	}

	/**
	 * Called when the local player picks up an item from the ground
	 *
	 * @param id  Item ID
	 * @param qty Item Quantity
	 */
	private void onItemPickedUp(int id, int qty, WorldPoint location)
	{
		log.debug("Picked Up {} of itemId: {} at {}", qty, id, location);
		eventBus.post(new ItemPickedUp(id, qty, location));
	}

	/**
	 * Called when the local player drops up an item from their inventory
	 *
	 * @param id  Item ID
	 * @param qty Item Quantity
	 */
	private void onItemDropped(int id, int qty, WorldPoint location)
	{
		if (!itemManager.getItemComposition(id).isStackable())
		{
			for (int i = 0; i < qty; i++)
			{
				log.debug("Dropped {} of itemId: {} at {}", qty, id, location);
				eventBus.post(new ItemDropped(id, 1, location));
			}
		}
		else
		{
			log.debug("Dropped {} of itemId: {} at {}", qty, id, location);
			eventBus.post(new ItemDropped(id, qty, location));
		}
	}

	/*
	 * Functions that help with Item management
	 */


	/**
	 * Converts a List of Items to a Set of InventoryItems
	 * @param groundItems List of Items
	 * @return Set of InventoryItems
	 */
	private Set<InventoryItem> itemListToInventoryItemSet(List<Item> groundItems)
	{
		Set<InventoryItem> currItems = new HashSet<>();
		if (groundItems == null)
		{
			return currItems;
		}

		for (int index = 0; index < groundItems.size(); index++)
		{
			Item i = groundItems.get(index);
			currItems.add(new InventoryItem(i.getId(), i.getQuantity(), index));
		}
		return currItems;
	}


	/**
	 * Grab the InventoryItem from set if ID and Slot match.
	 *
	 * @param set Set to search through
	 * @param id item id to check for
	 * @param slot inventory slot to check for.
	 * @return InventoryItem from set if found, null if not
	 */
	private InventoryItem getInventoryItemByIdAndSlot(Set<InventoryItem> set, int id, int slot)
	{

		for (InventoryItem item : set)
		{
			if (item.getId() == id && item.getSlot() == slot)
			{
				return item;
			}
		}
		return null;
	}

	/**
	 * Calculates the total items added/removed from the players inventory by any method.
	 * @return A Set of InventoryItems with the qty set as the amount changed this tick
	 */
	private Set<InventoryItem> calculateTrueInventoryDifferences()
	{
		Set<InventoryItem> results = new HashSet<>();
		Set<InventoryItem> inventoryChanges = Sets.symmetricDifference(prevTickInventoryItems, thisTickInventoryItems);

		// Inventory Slots we've calculated difference for
		Set<Integer> handledSlots = new HashSet<>();
		for (InventoryItem item : inventoryChanges)
		{
			// We've already handled changes for this inventory slot
			if (handledSlots.contains(item.getSlot()))
			{
				continue;
			}

			int quantity = item.getQuantity();

			// Item Existed Before, could have been dropped or quantity updated.
			if (prevTickInventoryItems.contains(item))
			{
				// If we still have this item the quantity must have changed from last tick.
				InventoryItem oldItem = getInventoryItemByIdAndSlot(thisTickInventoryItems, item.getId(), item.getSlot());
				if (oldItem != null)
				{
					// New Quantity - Old Quantity = New Quantity
					quantity = oldItem.getQuantity() - item.getQuantity();
				}
				else
				{
					// Item no longer exists in inventory, should be a negative quantity.
					quantity = -(quantity);
				}
			}
			else
			{
				// If we had this item before that means we either added or removed items from this stack
				InventoryItem oldItem = getInventoryItemByIdAndSlot(prevTickInventoryItems, item.getId(), item.getSlot());
				if (oldItem != null)
				{
					// New Quantity - Old Quantity = New Quantity
					quantity -= oldItem.getQuantity();
				}
			}

			results.add(new InventoryItem(item.getId(), quantity, item.getSlot()));
			handledSlots.add(item.getSlot());
		}

		return results;
	}

	/**
	 * Calculates which items were dropped/picked up by the player this tick.
	 *
	 * @param prevTileItems Ground items last tick
	 * @param currTileItems Ground items this tick
	 * @return Set of Items that were dropped or picked up (indicated by negative/positive qty)
	 */
	private Set<Item> calculateInventoryPickedDroppedItems(Set<InventoryItem> prevTileItems, Set<InventoryItem> currTileItems)
	{
		// If there's nothing in both sets then there's no need to check what changed in the inventory.
		if ((currTileItems == null || currTileItems.size() == 0) && (prevTileItems == null || prevTileItems.size() == 0))
		{
			return new HashSet<>();
		}

		Set<InventoryItem> inventoryChanges = calculateTrueInventoryDifferences();

		Set<Item> results = new HashSet<>();
		for (InventoryItem item : inventoryChanges)
		{
			// Now that we have the correct quantity of item changes for each slot we are going to
			// Determine if the player dropped or picked up the item from the floor.
			// Certain niche cases can cause this to function incorrectly.

			// Item was added to the inventory
			if (item.getQuantity() > 0)
			{
				// Can't pick up an item if there was nothing to pickup from.
				if (prevTileItems == null || prevTileItems.size() == 0)
				{
					continue;
				}

				InventoryItem oldItem = containsItemId(prevTileItems, item.getId(), item.getQuantity());
				InventoryItem currItem = containsItemId(currTileItems, item.getId(), item.getQuantity());
				// If the item wasn't on the ground last tick then it wasn't picked up.
				if (oldItem == null)
				{
					continue;
				}

				// Doesn't exist on the floor anymore, we must have picked it up?
				if (currItem == null)
				{
					results.add(client.createItem(item.getId(), item.getQuantity()));
				}
				else
				{
					int prevCount = getSetCombinedQuantityForItemId(prevTileItems, item.getId());
					int currCount = getSetCombinedQuantityForItemId(currTileItems, item.getId());

					if (currCount < prevCount)
					{
						// Greater than supports people dropping the same item at the same time as you.
						if (prevCount - currCount >= item.getQuantity())
						{
							results.add(client.createItem(item.getId(), item.getQuantity()));
						}
					}
				}

			}
			// Item was removed from the inventory
			else if (item.getQuantity() < 0)
			{
				// Nothing on floor, didn't drop anything.
				if (currTileItems == null || currTileItems.size() == 0)
				{
					continue;
				}

				InventoryItem oldItem = containsItemId(prevTileItems, item.getId(), item.getQuantity());
				InventoryItem currItem = containsItemId(currTileItems, item.getId(), item.getQuantity());

				// Item is not on the ground now, wasn't dropped.
				if (currItem == null)
				{
					continue;
				}

				// Item exists on floor now but didn't before.
				if (oldItem == null)
				{
					results.add(client.createItem(item.getId(), item.getQuantity()));
				}
				// Item ID existed on ground before and after, lets check entire ground item set for total quantity diff
				else
				{
					int prevCount = getSetCombinedQuantityForItemId(prevTileItems, item.getId());
					int currCount = getSetCombinedQuantityForItemId(currTileItems, item.getId());

					// More items exist now
					if (currCount > prevCount)
					{
						// Greater than supports people dropping the same item at the same time as you.
						if (currCount - prevCount >= -(item.getQuantity()))
						{
							results.add(client.createItem(item.getId(), item.getQuantity()));
						}
					}
				}
			}
		}

		return results;
	}

	/**
	 * Grabs loot for specific WorldPoint and filters items from other sources. Returns new items (Loot)
	 *
	 * @param location WorldPoint to check for new items
	 * @return Item id and quantity Map (Integer,Integer) for new items
	 */
	private List<Item> getItemDifferencesAt(WorldPoint location)
	{
		int regionX = location.getX() - client.getBaseX();
		int regionY = location.getY() - client.getBaseY();
		if (regionX < 0 || regionX >= Constants.REGION_SIZE ||
				regionY < 0 || regionY >= Constants.REGION_SIZE)
		{
			return null;
		}
		Tile tile = client.getRegion().getTiles()[location.getPlane()][regionX][regionY];
		if (!changedItemLayerTiles.contains(tile))
		{
			// No items on the tile changed
			return null;
		}

		// The tile might previously have contained items that weren't dropped
		// by the actor, so we need to check what new items appeared
		Set<InventoryItem> prevItems = groundItemsLastTick.get(location) != null ? groundItemsLastTick.get(location) : new HashSet<>();
		List<Item> currItemList = tile.getGroundItems();
		Set<InventoryItem> currItems = itemListToInventoryItemSet(currItemList);

		// Adjusts groundItemDiff to ignore any changes made by the player in current groundItems
		// Must be standing on loot tile and have dropped/picked up an item to do anything
		if (this.thisTickInventoryItems != null && location.distanceTo(playerLocationLastTick) == 0)
		{
			// Grab inventory item differences.
			Set<Item> pickDropped = calculateInventoryPickedDroppedItems(prevItems, currItems);

			// Adjust Ground Item Diff to account for inventory changes
			for (Item item : pickDropped)
			{
				// Item was picked up, add back to ground for proper comparison
				if (item.getQuantity() > 0)
				{
					currItems.add(new InventoryItem(item.getId(), item.getQuantity(), currItems.size()));
				}
				// Item was dropped, remove from curItems
				else if (item.getQuantity() < 0)
				{
					InventoryItem listItem = containsItemId(currItems, item.getId(), item.getQuantity());
					if (listItem != null)
					{
						currItems.remove(listItem);
						log.info("Removed List Item: {}", listItem);
						// Re-add correct amount if the item already existed and our item stacked with it.
						if (listItem.getQuantity() > -item.getQuantity())
						{
							currItems.add(new InventoryItem(listItem.getId(), listItem.getQuantity() + item.getQuantity(), listItem.getSlot()));
						}
					}
				}
			}
		}

		Set<InventoryItem> diff = Sets.difference(currItems, prevItems);

		// Convert the Set to a List of Items
		List<Item> items = new ArrayList<>();
		for (InventoryItem i : diff)
		{
			items.add(client.createItem(i.getId(), i.getQuantity()));
		}

		return items;
	}

	/**
	 * Does this Set contain this item ID?
	 *
	 * @param set Set of InventoryItem to search through
	 * @param id  Item ID to check for
	 * @param qty Item quantity must be equal to this value.
	 * @return Found status
	 */
	private static InventoryItem containsItemId(Set<InventoryItem> set, int id, int qty)
	{
		if (qty < 0)
		{
			qty = -qty;
		}

		for (InventoryItem item : set)
		{
			if (item.getId() == id)
			{
				// Greater than supports dropping items on stackable items
				if (item.getQuantity() >= qty)
				{
					return item;
				}
			}
		}
		return null;
	}


	/**
	 * How many times does this Set contain this item ID?
	 *
	 * @param set Set of Items to search through
	 * @param id  Item ID to check for
	 * @return Found status
	 */
	private static int getSetCombinedQuantityForItemId(Set<InventoryItem> set, int id)
	{
		int count = 0;
		for (InventoryItem item : set)
		{
			if (item.getId() == id)
			{
				count += item.getQuantity();
			}
		}
		return count;
	}

	/**
	 * Returns the difference between two lists of Item's
	 *
	 * @param prevItems Items from previous Tick
	 * @param currItems Items from this Tick
	 * @return Item id and quantity Map (Integer,Integer) for new items (currItems removing all of prevItems)
	 */
	private Map<Integer, Integer> getItemDifferences(Iterable<Item> prevItems, Iterable<Item> currItems)
	{
		Map<Integer, Integer> diff = new HashMap<>();
		if (prevItems != null)
		{
			for (Item item : prevItems)
			{
				int count = diff.getOrDefault(item.getId(), 0);
				diff.put(item.getId(), count - item.getQuantity());
			}
		}
		if (currItems != null)
		{
			for (Item item : currItems)
			{
				int count = diff.getOrDefault(item.getId(), 0);
				diff.put(item.getId(), count + item.getQuantity());
			}
		}
		diff.entrySet().removeIf(x -> x.getValue() == 0);
		return diff;
	}

	/**
	 * Memorizes any NPCs the local player is interacting with (Including AOE/Cannon)
	 */
	private void checkInteracting()
	{
		// We should memorize which actors the player has interacted with
		// since other players around might be killing some other monsters
		// and old loot can in some rare cases appear on the same tick as
		// the monster dies. This also fixes various random issues like
		// people dropping their junk at the GE and another player logs out
		// or teleports on the same location on the same tick as the drop
		// appears.

		Player player = client.getLocalPlayer();
		Actor interacting = player.getInteracting();
		if (interacting != null)
		{
			// When attacking with chins or barrage, we need to consider
			// all targets in the 3x3 area
			int animation = player.getAnimation();
			if (animation == AnimationID.THROW_CHINCHOMPA ||
					animation == AnimationID.CAST_BURST_BARRAGE) // Burst is same animation as barrage
			{
				WorldPoint targetLocation = interacting.getWorldLocation();

				// Area damage can't target Players when used on an NPC
				// and vice versa
				if (interacting instanceof NPC)
				{
					client.getNpcs().stream().filter(x ->
					{
						final WorldPoint wp = x.getWorldLocation();
						return
								wp.getX() >= targetLocation.getX() - 1 &&
										wp.getX() <= targetLocation.getX() + 1 &&
										wp.getY() >= targetLocation.getY() - 1 &&
										wp.getY() <= targetLocation.getY() + 1;
					}).forEach(x -> interactedActors.put(x, new MemorizedNpc(x)));
				}
				else if (interacting instanceof Player)
				{
					client.getPlayers().stream().filter(x ->
					{
						final WorldPoint wp = x.getWorldLocation();
						return
								wp.getX() >= targetLocation.getX() - 1 &&
										wp.getX() <= targetLocation.getX() + 1 &&
										wp.getY() >= targetLocation.getY() - 1 &&
										wp.getY() <= targetLocation.getY() + 1;
					}).forEach(x -> interactedActors.put(x, new MemorizedPlayer(x)));
				}
			}
			else
			{
				if (interacting instanceof NPC)
				{
					interactedActors.put(interacting, new MemorizedNpc((NPC)interacting));
				}
				else if (interacting instanceof Player)
				{
					interactedActors.put(interacting, new MemorizedPlayer((Player)interacting));
				}
			}
		}
	}

	/**
	 * Converts a List of Items into a Set of InventoryItems.
	 * For use purely by the Inventory to account for blank inventory slots.
	 *
	 * @param items List of Items
	 * @return Set of InventoryItems
	 */
	private Set<InventoryItem> createInventoryItemSet(List<Item> items)
	{
		Set<InventoryItem> set = new HashSet<>();

		for (int i = 0; i < INVENTORY_SPACE; i++)
		{
			if (i < items.size())
			{
				Item item = items.get(i);
				if (item.getId() != -1)
				{
					set.add(new InventoryItem(item.getId(), item.getQuantity(), i));
				}
			}
		}

		return set;
	}

	/**
	 * Check if the local player picked up/dropped any items
	 */
	private void checkInventoryItemsChanged()
	{
		if (this.thisTickInventoryItems == null || this.prevTickInventoryItems == null)
		{
			// Nothing in inventory changed
			return;
		}

		int plane = client.getPlane();
		if (playerLocationLastTick == null || plane != playerLocationLastTick.getPlane())
		{
			// Player climbed up/down a ladder, or teleported
			// to a different level
			return;
		}

		int regionX = playerLocationLastTick.getX() - client.getBaseX();
		int regionY = playerLocationLastTick.getY() - client.getBaseY();
		if (regionX < 0 || regionX >= Constants.REGION_SIZE || regionY < 0 || regionY >= Constants.REGION_SIZE)
		{
			// Player teleported
			return;
		}

		Tile tile = client.getRegion().getTiles()[plane][regionX][regionY];
		if (tile == null)
		{
			// Not sure when this would happen, but just in case
			log.debug("Error: Tile not found");
			return;
		}

		WorldPoint wp = tile.getWorldLocation();
		Set<InventoryItem> prevItems = groundItemsLastTick.get(wp) != null ? groundItemsLastTick.get(wp) : new HashSet<>();
		List<Item> groundItems = tile.getGroundItems();
		Set<InventoryItem> currItems = itemListToInventoryItemSet(groundItems);

		// Nothing was or is on the tile under the player, couldn't have dropped/picked up an item.
		if (prevItems.size() == 0 && currItems.size() == 0)
		{
			return;
		}

		// Calculate which items were dropped/picked up and then trigger the necessary events.
		Set<Item> itemChanges = calculateInventoryPickedDroppedItems(prevItems, currItems);
		for (Item item : itemChanges)
		{
			// Item Picked Up
			if (item.getQuantity() > 0)
			{
				onItemPickedUp(item.getId(), item.getQuantity(), playerLocationLastTick);
			}
			else if (item.getQuantity() < 0)
			{
				// Item Dropped (convert negative qty to positive)
				onItemDropped(item.getId(), -item.getQuantity(), playerLocationLastTick);
			}
		}
	}

	/**
	 * Determine where the NPCs loot will spawn
	 *
	 * @param pad The MemorizedActor that we are checking
	 * @return A List of WorldPoint's where the NPC might spawn loot
	 */
	private WorldPoint[] getExpectedDropLocations(MemorizedActor pad)
	{
		WorldPoint defaultLocation = pad.getActor().getWorldLocation();
		if (pad instanceof MemorizedNpc)
		{
			// Some bosses drop their loot in specific locations
			switch (((MemorizedNpc) pad).getNpcComposition().getId())
			{
				case NpcID.KRAKEN:
				case NpcID.KRAKEN_6640:
				case NpcID.KRAKEN_6656:
					return new WorldPoint[]
							{
									playerLocationLastTick
							};

				case NpcID.CAVE_KRAKEN:
					if (pad instanceof MemorizedNpcAndLocation)
					{
						return new WorldPoint[]
								{
										((MemorizedNpcAndLocation) pad).getExpectedDropLocation()
								};
					}
					break;

				case NpcID.DUSK:
				case NpcID.DUSK_7851:
				case NpcID.DUSK_7854:
				case NpcID.DUSK_7855:
				case NpcID.DUSK_7882:
				case NpcID.DUSK_7883:
				case NpcID.DUSK_7886:
				case NpcID.DUSK_7887:
				case NpcID.DUSK_7888:
				case NpcID.DUSK_7889:
				{
					return new WorldPoint[]
							{
									new WorldPoint(
											defaultLocation.getX() + 3,
											defaultLocation.getY() + 3,
											defaultLocation.getPlane())
							};
				}

				case NpcID.ZULRAH: // Green
				case NpcID.ZULRAH_2043: // Red
				case NpcID.ZULRAH_2044: // Blue
				{
					// The drop appears on whatever tile where zulrah scales appeared
					WorldPoint location = changedItemLayerTiles.stream()
							.filter(x ->
							{
								List<Item> groundItems = x.getGroundItems();
								if (groundItems != null)
								{
									return groundItems.stream().anyMatch(y -> y.getId() == ItemID.ZULRAHS_SCALES);
								}
								return false;
							})
							.map(Tile::getWorldLocation)
							// If player drops some zulrah scales themselves on the same tick,
							// the ones that appeared further away will be chosen instead.
							.sorted((x, y) -> y.distanceTo(playerLocationLastTick) - x.distanceTo(playerLocationLastTick))
							.findFirst().orElse(null);
					if (location == null)
					{
						return new WorldPoint[] {};
					}
					return new WorldPoint[] { location };
				}

				case NpcID.VORKATH:
				case NpcID.VORKATH_8058:
				case NpcID.VORKATH_8059:
				case NpcID.VORKATH_8060:
				case NpcID.VORKATH_8061:
				{
					int x = defaultLocation.getX() + 3;
					int y = defaultLocation.getY() + 3;
					if (playerLocationLastTick.getX() < x)
					{
						x = x - 4;
					}
					else if (playerLocationLastTick.getX() > x)
					{
						x = x + 4;
					}
					if (playerLocationLastTick.getY() < y)
					{
						y = y - 4;
					}
					else if (playerLocationLastTick.getY() > y)
					{
						y = y + 4;
					}
					return new WorldPoint[]
							{
									new WorldPoint(x, y, defaultLocation.getPlane())
							};
				}

				case NpcID.CORPOREAL_BEAST:
				{
					return new WorldPoint[]
							{
									new WorldPoint(
											defaultLocation.getX() + 1,
											defaultLocation.getY() + 1,
											defaultLocation.getPlane())
							};
				}

				case NpcID.ABYSSAL_SIRE:
				case NpcID.ABYSSAL_SIRE_5887:
				case NpcID.ABYSSAL_SIRE_5888:
				case NpcID.ABYSSAL_SIRE_5889:
				case NpcID.ABYSSAL_SIRE_5890:
				case NpcID.ABYSSAL_SIRE_5891:
				case NpcID.ABYSSAL_SIRE_5908:
				{
					return new WorldPoint[]
							{
									new WorldPoint(
											pad.getActor().getWorldLocation().getX() + 2,
											pad.getActor().getWorldLocation().getY() + 2,
											pad.getActor().getWorldLocation().getPlane())
							};
				}
			}

			int size = ((MemorizedNpc) pad).getNpcComposition().getSize();
			if (size >= 3)
			{
				// Some large NPCs (mostly bosses) drop their loot in the middle
				// of them rather than on the southwestern spot, so
				// we want to check both of them.
				return new WorldPoint[]
						{
								defaultLocation,
								new WorldPoint(
										defaultLocation.getX() + (size - 1) / 2,
										defaultLocation.getY() + (size - 1) / 2,
										defaultLocation.getPlane())
						};
			}
		}

		return new WorldPoint[] { defaultLocation };
	}

	/**
	 * Loops over deadActorsThisTick and determines what loot the Actor(s) dropped
	 */
	private void checkActorDeaths()
	{
		for (MemorizedActor pad : deadActorsThisTick)
		{
			// Pvp kills can happen in Chambers of Xeric when someone
			// dies and their raid potions drop, but we don't want to
			// log those.
			if (pad instanceof MemorizedPlayer && insideChambersOfXeric)
			{
				continue;
			}

			// Stores new items for each new world point. Some NPCs can drop loot on multiple tiles.
			WorldPoint[] locations = getExpectedDropLocations(pad);
			Multimap<WorldPoint, Item> worldDrops = ArrayListMultimap.create();
			for (WorldPoint location : locations)
			{
				List<Item> drops = getItemDifferencesAt(location);
				if (drops == null || drops.size() == 0)
				{
					continue;
				}

				worldDrops.putAll(location, drops);
			}

			// Didn't find any loot for this Actor
			if (worldDrops.size() == 0)
			{
				log.debug("No Loot found for Actor: {}", pad);
				log.debug("Locations: {}", Arrays.asList(locations));
				continue;
			}

			List<Item> dropList;

			// If multiple interacted NPCs died on the same tick we need to calculate
			// how many npcs died on the same tile to evenly split the loot
			if (deadActorsThisTick.size() > 1)
			{
				boolean foundIndex = false;
				int index = 0;
				int killsAtWP = 0;
				// Support for multiple NPCs dying on the same tick at the same time
				for (MemorizedActor pad2 : deadActorsThisTick)
				{
					if (pad2.getActor().getWorldLocation().distanceTo(pad.getActor().getWorldLocation()) == 0)
					{
						killsAtWP++;
						if (!foundIndex)
						{
							index++;
							if (pad == pad2)
							{
								foundIndex = true;
							}
						}
					}
				}

				Map<Integer, Integer> drops = new HashMap<>();
				for (Map.Entry<WorldPoint, Item> entry : worldDrops.entries())
				{
					// The way we handle multiple kills on the same WorldPoint in the same tick
					// is by splitting up all the drops equally, i.e. if 2 kills happened at the
					// same time and they dropped 3 items of the same type, 1 item would be
					// accounted for the first kill and 2 for the second.
					Item i = entry.getValue();
					int nextCount = (i.getQuantity() * index / killsAtWP) -
							(i.getQuantity() * (index - 1) / killsAtWP);
					if (nextCount == 0)
					{
						continue;
					}
					int count = drops.getOrDefault(i.getId(), 0);
					drops.put(i.getId(), nextCount + count);
				}

				// Convert Map to List of Items to return
				dropList = new ArrayList<>();
				for (Map.Entry<Integer, Integer> e : drops.entrySet())
				{
					dropList.add(client.createItem(e.getKey(), e.getValue()));
				}
			}
			else
			{
				// Creating a map in case the quantity needs to be updated for certain items
				Map<Integer, Integer> drops = new HashMap<>();
				for (Map.Entry<WorldPoint, Item> entry : worldDrops.entries())
				{
					Item i = entry.getValue();
					int count = drops.getOrDefault(i.getId(), 0);
					drops.put(i.getId(), i.getQuantity() + count);
				}

				// Convert Map to List of Items to return
				dropList = new ArrayList<>();
				for (Map.Entry<Integer, Integer> e : drops.entrySet())
				{
					dropList.add(client.createItem(e.getKey(), e.getValue()));
				}
			}

			// Actor type, Calls the wrapper for triggering the proper LootReceived event
			if (pad instanceof MemorizedNpc)
			{
				NPCComposition c = ((MemorizedNpc) pad).getNpcComposition();
				onNewNpcLogCreated(c.getId(), c, pad.getActor().getWorldLocation(), dropList);
			}
			else if (pad instanceof MemorizedPlayer)
			{
				Player p = (Player) pad.getActor();
				onNewPlayerLogCreated(p, p.getWorldLocation(), dropList);
			}
			else
			{
				log.error("Unrecognized actor death");
				log.debug("Error: Unrecognized actor death");
			}
		}
		deadActorsThisTick.clear();
	}

	/*
	 * Helper Functions for moving to next tick (clear old data, copy new data to compare against)
	 */

	/**
	 * Stores all Items still on the floor to the previous tick variable
	 */
	private void updateGroundItemLayers()
	{
		for (Tile tile : this.changedItemLayerTiles)
		{
			WorldPoint wp = tile.getWorldLocation();
			List<Item> groundItems = tile.getGroundItems();
			if (groundItems == null)
			{
				groundItemsLastTick.remove(wp);
			}
			else
			{
				groundItemsLastTick.put(wp, itemListToInventoryItemSet(groundItems));
			}
		}
		this.changedItemLayerTiles.clear();
	}

	/**
	 * Resets all flags and move Inventory Items to prev tick variable
	 */
	private void updateInventoryItems()
	{
		if (this.thisTickInventoryItems != null)
		{
			this.prevTickInventoryItems = this.thisTickInventoryItems;
			this.thisTickInventoryItems = null;
		}
	}

	/*
	 * Subscribe events which do some basics checks and information updating
	 */

	/**
	 * Clear ground items map on region change
	 */
	@Subscribe
	public void onGameStateChanged(GameStateChanged e)
	{
		if (e.getGameState() == GameState.LOGGED_IN)
		{
			groundItemsLastTick.clear();
		}
	}

	/**
	 * Location Checks
	 */
	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		insideChambersOfXeric = !(client.getVar(Varbits.IN_RAID) == 0);
		if (!insideChambersOfXeric)
		{
			this.hasOpenedRaidsRewardChest = false;
		}

		int theatreState = client.getVar(Varbits.THEATRE_OF_BLOOD);
		if (theatreState == 0 || theatreState == 1)
		{
			this.hasOpenedTheatreOfBloodRewardChest = false;
		}
	}

	/**
	 * Cannon Placement Support
	 */
	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();
		if (event.getGameObject().getId() == ObjectID.CANNON_BASE)
		{
			Player player = client.getLocalPlayer();
			if (player.getWorldLocation().distanceTo(event.getGameObject().getWorldLocation()) <= 2
					&& player.getAnimation() == AnimationID.BURYING_BONES)
			{
				cannonLocation = gameObject.getWorldLocation();
			}
		}
	}

	/**
	 * Cannon Kill Support
	 */
	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		if (cannonLocation == null)
		{
			return;
		}

		Projectile projectile = event.getProjectile();

		if (projectile.getId() == ProjectileID.CANNONBALL || projectile.getId() == ProjectileID.GRANITE_CANNONBALL)
		{
			WorldPoint projectileLoc = WorldPoint.fromLocal(client, projectile.getX1(), projectile.getY1(), client.getPlane());

			//Check to see if projectile x,y is 0 else it will continuously decrease while ball is flying.
			if (projectile.getX() == 0 && projectile.getY() == 0 &&
					projectileLoc.equals(cannonLocation) && projectile.getInteracting() != null &&
					projectile.getInteracting() instanceof NPC)
			{
				// A cannon can kill creatures without the player interacting with
				// them, so we need to add target as a potential loot dropper.
				interactedActors.put(projectile.getInteracting(),
						new MemorizedNpc((NPC)projectile.getInteracting()));
			}
		}
	}

	/**
	 * Event/Activity loot received management
	 */
	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		// Barrows
		if (event.getGroupId() == WidgetID.BARROWS_REWARD_GROUP_ID)
		{
			ItemContainer container = client.getItemContainer(InventoryID.BARROWS_REWARD);
			if (container != null)
			{
				List<Item> items = Arrays.asList(container.getItems());
				onNewEventLogCreated(LootEventType.BARROWS, items);
			}
			else
			{
				log.debug("Error finding Barrows Item Container");
			}
		}
		// Chambers of Xeric / Raids 1
		else if (event.getGroupId() == WidgetID.RAIDS_REWARD_GROUP_ID && !hasOpenedRaidsRewardChest)
		{
			hasOpenedRaidsRewardChest = true;

			ItemContainer container = client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST);
			if (container != null)
			{
				List<Item> items = Arrays.asList(container.getItems());
				onNewEventLogCreated(LootEventType.RAIDS, items);
			}
			else
			{
				log.debug("Error finding Chamber of Xeric Item Container");
			}
		}
		// Theatre of Blood / Raids 2
		else if (event.getGroupId() == WidgetID.THEATRE_OF_BLOOD_GROUP_ID && !hasOpenedTheatreOfBloodRewardChest)
		{
			hasOpenedTheatreOfBloodRewardChest = true;

			ItemContainer container = client.getItemContainer(InventoryID.THEATRE_OF_BLOOD_CHEST);
			if (container != null)
			{
				List<Item> items = Arrays.asList(container.getItems());
				onNewEventLogCreated(LootEventType.RAIDS, items);
			}
			else
			{
				log.debug("Error finding Theatre of Blood Item Container");
			}
		}
		// Clue Scrolls
		else if (event.getGroupId() == WidgetID.CLUE_SCROLL_REWARD_GROUP_ID)
		{
			// Not 100% sure this will work, needs testing. May need to convert to chat message.
			Set<InventoryItem> itemDiff = Sets.difference(prevTickInventoryItems, thisTickInventoryItems);
			LootEventType clueScrollType = LootEventType.UNKNOWN_EVENT;
			for (InventoryItem item : itemDiff)
			{
				switch (item.getId())
				{
					case ItemID.REWARD_CASKET_EASY:
						clueScrollType = LootEventType.CLUE_SCROLL_EASY;
						break;
					case ItemID.REWARD_CASKET_MEDIUM:
						clueScrollType = LootEventType.CLUE_SCROLL_MEDIUM;
						break;
					case ItemID.REWARD_CASKET_HARD:
						clueScrollType = LootEventType.CLUE_SCROLL_HARD;
						break;
					case ItemID.REWARD_CASKET_ELITE:
						clueScrollType = LootEventType.CLUE_SCROLL_ELITE;
						break;
					case ItemID.REWARD_CASKET_MASTER:
						clueScrollType = LootEventType.CLUE_SCROLL_MASTER;
						break;
					default:
						continue;
				}
				break;
			}

			// Clue Scrolls use same InventoryID as Barrows
			ItemContainer container = client.getItemContainer(InventoryID.BARROWS_REWARD);
			if (container != null)
			{
				List<Item> items = Arrays.asList(container.getItems());
				onNewEventLogCreated(clueScrollType, items);
			}
			else
			{
				log.debug("Error finding clue scroll Item Container");
			}
		}
	}

	/**
	 * Certain NPCs determine loot tile on death animation and not on de-spawn
	 */
	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (!(event.getActor() instanceof NPC))
		{
			return;
		}

		NPC npc = (NPC)event.getActor();
		int npcId = npc.getId();
		if (!NPC_DEATH_ANIMATIONS.containsKey(npcId))
		{
			return;
		}

		if (NPC_DEATH_ANIMATIONS.get(npcId) == npc.getAnimation())
		{
			MemorizedActor memorizedActor = interactedActors.get(npc);
			if (memorizedActor != null)
			{
				if (npcId == NpcID.CAVE_KRAKEN)
				{
					if (memorizedActor instanceof MemorizedNpcAndLocation)
					{
						// Cave kraken decide where to drop the loot right when they
						// start the death animation, but it doesn't appear until
						// the death animation has finished
						((MemorizedNpcAndLocation) memorizedActor).setExpectedDropLocation(playerLocationLastTick);
					}
				}
				else
				{
					deadActorsThisTick.add(memorizedActor);
				}
			}
		}
	}

	/**
	 * Remember dead actors until next tick if we interacted with them
	 */
	@Subscribe
	public void onActorDespawned(ActorDespawned event)
	{
		MemorizedActor ma = interactedActors.get(event.getActor());
		if (ma != null && (event.getActor().getHealthRatio() == 0))
		{
			interactedActors.remove(event.getActor());

			// This event runs before the ItemLayerChanged event,
			// so we have to wait until the end of the game tick
			// before we know what items were dropped
			deadActorsThisTick.add(ma);
		}
	}

	/**
	 * Track tiles where an item layer changed (for each tick)
	 */
	@Subscribe
	public void onItemLayerChanged(ItemLayerChanged event)
	{
		// Note: This event runs 10816 (104*104) times after
		// a new loading screen. Perhaps there is a way to
		// reduce the amount of times it runs?

		this.changedItemLayerTiles.add(event.getTile());
	}

	/**
	 * Inventory Management Support
	 */
	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		Item[] items = event.getItemContainer().getItems();
		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			this.thisTickInventoryItems = null;
			if (items != null)
			{
				this.thisTickInventoryItems = createInventoryItemSet(Arrays.asList(items));
			}
		}
	}

	/**
	 * Every game tick we call all necessary functions to calculate Received Loot
	 *
	 * <p><strong>We must do the following to correctly determine dropped NPC loot</strong></p>
	 * <p>1) Memorize which actors we have interacted with</p>
	 * <p>2) Check for any item changes (Disappearing from floor, Added/Removed from inventory)</p>
	 * <p>3) Loop over all dead actor and determine what loot they dropped</p>
	 * <p><strong>Now that we are done determining loot we need to prepare for the next tick.</strong></p>
	 * <p>1) Move all data to lastTick variables (Ground Items/Inventory Items)</p>
	 * <p>2) Store current player world point</p>
	 */
	@Subscribe
	public void onGameTick(GameTick event)
	{
		checkInteracting();
		checkInventoryItemsChanged();
		checkActorDeaths();
		updateGroundItemLayers();
		updateInventoryItems();
		playerLocationLastTick = client.getLocalPlayer().getWorldLocation();
	}

	/**
	 * Cannon Pickup Support
	 */
	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (cannonLocation == null)
		{
			return;
		}

		if (event.getMessage().contains("You pick up the cannon"))
		{
			cannonLocation = null;
		}
	}
}