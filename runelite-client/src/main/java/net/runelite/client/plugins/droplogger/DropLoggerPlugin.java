/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.droplogger;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
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
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.ItemLayerChanged;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.droplogger.data.GroundItem;
import net.runelite.client.plugins.droplogger.data.ItemStack;
import net.runelite.client.plugins.droplogger.data.MemorizedActor;
import net.runelite.client.plugins.droplogger.data.MemorizedNpc;
import net.runelite.client.plugins.droplogger.data.MemorizedNpcAndLocation;
import net.runelite.client.plugins.droplogger.data.MemorizedPlayer;
import net.runelite.client.plugins.droplogger.data.PendingItem;
import net.runelite.client.plugins.droplogger.data.SessionEventLog;
import net.runelite.client.plugins.droplogger.data.SessionLog;
import net.runelite.client.plugins.droplogger.data.SessionLogData;
import net.runelite.client.plugins.droplogger.data.SessionNpcLog;
import net.runelite.client.plugins.droplogger.data.SessionPlayerLog;
import net.runelite.client.plugins.droplogger.ui.DropLoggerPanel;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;

@PluginDescriptor(
	name = "Drop Logger"
)
@Slf4j
public class DropLoggerPlugin extends Plugin
{
	private static final int WIDGET_BARROWS_REWARD = 155;
	private static final int WIDGET_CLUE_SCROLL_REWARD = 73;
	private static final int WIDGET_CHAMBERS_OF_XERIC_REWARD = 539;

	private static final int INVENTORY_SPACE = 28;

	// Time as in amount of game ticks
	private static final int NPC_DROP_DISAPPEAR_TIME = 199; // 2 minutes if item was dropped by an NPC
	private static final int PLAYER_DROP_DISAPPEAR_TIME = 299; // 3 minutes if player drops an item
	private static final int INSTANCE_DROP_DISAPPEAR_TIME = 2999; // 30 minutes for various instances

	private static final Map<Integer, Integer> NPC_DEATH_ANIMATIONS;

	static
	{
		// Some NPCs decide where to drop the loot at the same time they
		// start performing their death animation, so their death animation
		// has to be known.
		// This list may be incomplete, I didn't test every NPC in the game.
		NPC_DEATH_ANIMATIONS = new HashMap<>();
		NPC_DEATH_ANIMATIONS.put(NpcID.CAVE_KRAKEN, AnimationID.CAVE_KRAKEN_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.AIR_WIZARD, AnimationID.AIR_WIZARD_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.WATER_WIZARD, AnimationID.WATER_WIZARD_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.EARTH_WIZARD, AnimationID.EARTH_WIZARD_DEATH);
		NPC_DEATH_ANIMATIONS.put(NpcID.FIRE_WIZARD, AnimationID.FIRE_WIZARD_DEATH);
	}

	@Inject
	private Client client;

	@Inject
	private DropLoggerConfig config;

	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private ItemManager itemManager;

	private Map<Actor, MemorizedActor> interactedActors;
	private List<MemorizedActor> deadActorsThisTick;

	private Map<WorldPoint, List<ItemStack>> groundItemsLastTick;
	private Set<Tile> changedItemLayerTiles;

	private WorldPoint playerLocationLastTick;
	private WorldPoint cannonLocation;

	private SessionLogData sessionLogData;

	private ItemStack[] prevTickInventoryItems;
	/**
	 * An array containing the items in the inventory during the current tick,
	 * or null if they are the same as in the previous tick.
	 */
	private ItemStack[] thisTickInventoryItems;
	private ItemStack[] thisTickRewardItems;
	private ItemStack[] chambersOfXericItems;

	private boolean openedClueScrollThisTick = false;
	private boolean openedBarrowsChestThisTick = false;
	private boolean completedChambersOfXericThisTick = false;
	private boolean hasOpenedRaidsRewardChest = false;

	private Multimap<WorldPoint, GroundItem> myItems;
	private Multimap<Integer, GroundItem> itemDisappearMap;
	private Multimap<Integer, SessionLog> responsibleLogs;
	private List<PendingItem> pendingItems; // Items that are in the rewards interface for clues/barrows

	private DropLoggerPanel panel;

	private int tickCounter;

	@Provides
	DropLoggerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DropLoggerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		this.tickCounter = 0;
		this.interactedActors = new HashMap<>();
		this.deadActorsThisTick = new ArrayList<>();
		this.sessionLogData = new SessionLogData();
		this.groundItemsLastTick = new HashMap<>();
		this.changedItemLayerTiles = new HashSet<>();
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			this.prevTickInventoryItems = getItemContainerItems(
				client.getItemContainer(InventoryID.INVENTORY));
		}
		this.myItems = ArrayListMultimap.create();
		this.itemDisappearMap = Multimaps.newListMultimap(Maps.newTreeMap(), Lists::newArrayList);
		this.responsibleLogs = Multimaps.newSetMultimap(Maps.newHashMap(), Sets::newHashSet);
		this.pendingItems = new ArrayList<>();

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(DropLoggerPlugin.class.getResourceAsStream("panel_icon.png"));
		}
		panel = injector.getInstance(DropLoggerPanel.class);
		panel.init(sessionLogData);

		NavigationButton navButton = NavigationButton.builder()
			.tooltip("Drop Logger")
			.priority(3)
			.icon(icon)
			.panel(panel)
			.build();
		this.pluginToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		this.deadActorsThisTick = null;
		this.sessionLogData = null;
		this.groundItemsLastTick = null;
		this.changedItemLayerTiles = null;
		this.prevTickInventoryItems = null;
		this.myItems = null;
		this.itemDisappearMap = null;
		this.responsibleLogs = null;
		this.pendingItems = null;
	}

	private void debug(String message)
	{
		// Useful stuff for debugging, uncomment if you're developing something
		//message = tickCounter + ": " + message;
		//client.addChatMessage(ChatMessageType.SERVER, "", message, null);
	}

	private void debugItems(String message, int itemId, int amount)
	{
		// Useful stuff for debugging, uncomment if you're developing something
		//ItemComposition composition = itemManager.getItemComposition(itemId);
		//message = tickCounter + ": [" + amount + " x " + composition.getName() + "] " + message;
		//client.addChatMessage(ChatMessageType.SERVER, "", message, null);
	}

	public void clearSessionDrops()
	{
		debug("Reset session drops");
		myItems.clear();
		itemDisappearMap.clear();
		responsibleLogs.clear();
		sessionLogData.reset();
		pendingItems.clear();
		panel.onLogUpdated();
	}

	private ItemStack[] getItemContainerItems(ItemContainer itemContainer)
	{
		Item[] items = itemContainer.getItems();
		ItemStack[] result = new ItemStack[items.length];
		for (int i = 0; i < items.length; i++)
		{
			result[i] = new ItemStack(items[i].getId(), items[i].getQuantity());
		}
		return result;
	}

	private List<ItemStack> getGroundItems(Tile tile)
	{
		List<Item> items = tile.getGroundItems();
		if (items == null)
		{
			return null;
		}
		return items.stream()
			.map(x -> new ItemStack(x.getId(), x.getQuantity()))
			.collect(Collectors.toList());
	}

	private Map<Integer, Integer> getItemDifferencesAt(WorldPoint location)
	{
		Map<Integer, Integer> newItems = new HashMap<>();
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
		List<ItemStack> prevItems = groundItemsLastTick.get(location);
		List<ItemStack> currItems = getGroundItems(tile);
		if (currItems != null)
		{
			for (ItemStack item : currItems)
			{
				Integer count = newItems.getOrDefault(item.getItemId(), 0);
				newItems.put(item.getItemId(), count + item.getQuantity());
			}
		}
		if (prevItems != null)
		{
			for (ItemStack item : prevItems)
			{
				Integer count = newItems.get(item.getItemId());
				if (count == null)
				{
					continue;
				}
				count -= item.getQuantity();
				if (count <= 0)
				{
					newItems.remove(item.getItemId());
				}
				else
				{
					newItems.put(item.getItemId(), count);
				}
			}
		}

		// If the player was standing on the location, we don't want to log
		// any drops that the player may have dropped themselves
		if (this.thisTickInventoryItems != null &&
			location.distanceTo(playerLocationLastTick) == 0)
		{
			Map<Integer, Integer> changedItems = new HashMap<>();
			for (int i = 0; i < INVENTORY_SPACE; i++)
			{
				ItemStack prevStack = null;
				ItemStack currStack = null;
				if (i < this.prevTickInventoryItems.length)
				{
					prevStack = this.prevTickInventoryItems[i];
				}
				if (i < this.thisTickInventoryItems.length)
				{
					currStack = this.thisTickInventoryItems[i];
				}

				// If items were dropped, the inventory slot would be become empty (i.e. null)
				if (prevStack != null && (currStack == null || currStack.getItemId() == -1))
				{
					changedItems.put(prevStack.getItemId(), 0);
				}
			}

			// The user may have moved items in their inventory, so we want to make sure
			// that they have less items now than they did earlier
			for (ItemStack stack : this.prevTickInventoryItems)
			{
				Integer count = changedItems.get(stack.getItemId());
				if (count != null)
				{
					changedItems.put(stack.getItemId(), count + stack.getQuantity());
				}
			}
			for (ItemStack stack : this.thisTickInventoryItems)
			{
				Integer count = changedItems.get(stack.getItemId());
				if (count != null)
				{
					changedItems.put(stack.getItemId(), count - stack.getQuantity());
				}
			}

			for (Map.Entry<Integer, Integer> entry : changedItems.entrySet())
			{
				if (entry.getValue() > 0)
				{
					int count = newItems.getOrDefault(entry.getKey(), 0);
					if (count - entry.getValue() <= 0)
					{
						newItems.remove(entry.getKey());
					}
					else
					{
						newItems.put(entry.getKey(), count - entry.getValue());
					}
				}
			}
		}

		return newItems;
	}

	private void onNewNpcLogCreated(SessionNpcLog detailedLog)
	{
		detailedLog.getAllItems().keySet().forEach(x ->
		{
			// Streamline the process of retrieving the respective SessionLog
			// when a player drops or picks up an item
			responsibleLogs.put(x, detailedLog);
		});

		sessionLogData.getSessionLogs().add(detailedLog);

		debug("New NPC kill! Logged " + detailedLog.getAllItems().size() +
			" different items");
		detailedLog.getAllItems().forEach((key, value) ->
		{
			ItemComposition composition = itemManager.getItemComposition(key);
			debug("Logged item: " + composition.getName() + " x " + value);
		});
		panel.onLogItemsAdded(detailedLog);
	}

	private void onNewPlayerLogCreated(SessionPlayerLog detailedLog)
	{
		detailedLog.getAllItems().keySet().forEach(x ->
		{
			// Streamline the process of retrieving the respective SessionLog
			// when a player drops or picks up an item
			responsibleLogs.put(x, detailedLog);
		});

		sessionLogData.getSessionLogs().add(detailedLog);

		debug("Nice PK! Logged " + detailedLog.getAllItems().size() +
			" different items");
		panel.onLogItemsAdded(detailedLog);
	}

	private void onNewEventLogCreated(SessionEventLog detailedLog)
	{
		detailedLog.getAllItems().keySet().forEach(x ->
		{
			// Streamline the process of retrieving the respective SessionLog
			// when a player drops or picks up an item
			responsibleLogs.put(x, detailedLog);
		});

		sessionLogData.getSessionLogs().add(detailedLog);

		debug("New event log! Logged " + detailedLog.getAllItems().size() +
			" different items");
		panel.onLogItemsAdded(detailedLog);
	}

	private Map<Integer, Integer> getItemDifferences(
		Iterable<ItemStack> prevItems, Iterable<ItemStack> currItems)
	{
		Map<Integer, Integer> diff = new HashMap<>();
		if (prevItems != null)
		{
			for (ItemStack item : prevItems)
			{
				int count = diff.getOrDefault(item.getItemId(), 0);
				diff.put(item.getItemId(), count - item.getQuantity());
			}
		}
		if (currItems != null)
		{
			for (ItemStack item : currItems)
			{
				int count = diff.getOrDefault(item.getItemId(), 0);
				diff.put(item.getItemId(), count + item.getQuantity());
			}
		}
		diff.entrySet().removeIf(x -> x.getValue() == 0);
		return diff;
	}

	private void onItemsPickedUp(int itemId, int quantity, WorldPoint location)
	{
		boolean foundAny = false;
		int quantityLeft = quantity;
		Iterator<GroundItem> it = myItems.get(location).iterator();
		while (quantityLeft > 0 && it.hasNext())
		{
			GroundItem groundItem = it.next();
			if (groundItem.getItemId() != itemId)
			{
				continue;
			}

			foundAny = true;

			int pickedUp = groundItem.getResponsibleLog().pickUpItemStack(itemId, quantityLeft);
			groundItem.setQuantity(groundItem.getQuantity() - pickedUp);
			quantityLeft -= pickedUp;
			if (groundItem.getQuantity() == 0)
			{
				it.remove();
				itemDisappearMap.get(groundItem.getDisappearsOnTick()).remove(groundItem);
			}
		}

		if (foundAny)
		{
			debugItems("Picked up items", itemId, quantity - quantityLeft);
			panel.onLogUpdated();
		}
	}

	private void onItemsDropped(int itemId, int quantity, WorldPoint location, SessionLog responsibleLog)
	{
		int itemDuration = (client.isInInstancedRegion() ? INSTANCE_DROP_DISAPPEAR_TIME : PLAYER_DROP_DISAPPEAR_TIME);
		boolean foundAny = false;
		int quantityLeft = quantity;
		if (responsibleLog == null)
		{
			Iterator<SessionLog> it = responsibleLogs.get(itemId).iterator();
			while (quantityLeft > 0 && it.hasNext())
			{
				SessionLog log = it.next();
				int dropped = log.dropItemStack(itemId, quantityLeft);
				quantityLeft -= dropped;

				if (dropped > 0)
				{
					foundAny = true;

					int disappearsOnTick = tickCounter + itemDuration;
					GroundItem groundItem = new GroundItem(itemId, dropped, location,
						disappearsOnTick, log);
					myItems.put(location, groundItem);
					itemDisappearMap.put(disappearsOnTick, groundItem);
				}
			}
		}
		else
		{
			int disappearsOnTick = tickCounter + itemDuration;
			GroundItem groundItem = new GroundItem(itemId, quantity, location,
				disappearsOnTick, responsibleLog);
			myItems.put(location, groundItem);
			itemDisappearMap.put(disappearsOnTick, groundItem);
			foundAny = true;
			quantityLeft = 0;
		}

		if (foundAny)
		{
			debugItems("Dropped items", itemId, quantity - quantityLeft);
			panel.onLogUpdated();
		}
	}

	private void onItemsFinalized(int itemId, int quantity)
	{
		int quantityLeft = quantity;
		Iterator<SessionLog> it = responsibleLogs.get(itemId).iterator();
		while (quantityLeft > 0 && it.hasNext())
		{
			SessionLog log = it.next();
			int finalized = log.finalizeItemStack(itemId, quantityLeft);
			if (finalized == quantityLeft && log.isEverythingFinalized())
			{
				// All drops in the log are finalized so we don't need to keep
				// track of them any more
				it.remove();
			}
			quantityLeft -= finalized;
		}

		if (quantity - quantityLeft > 0)
		{
			debugItems("Finalized items 1", itemId, quantity - quantityLeft);
		}
	}

	private void pickupRewardItems()
	{
		List<Integer> inventoryItems = Arrays.stream(
			thisTickInventoryItems == null ?
				prevTickInventoryItems :
				thisTickInventoryItems)
			.map(ItemStack::getItemId)
			.collect(Collectors.toList());
		int invSpace = INVENTORY_SPACE - (int)inventoryItems.stream()
			.filter(x -> x != null && x != -1).count();

		Iterator<PendingItem> it = pendingItems.iterator();
		while (it.hasNext())
		{
			PendingItem item = it.next();
			item.getEventLog().pickUpItemStack(item.getItemId(), item.getQuantity());
			debugItems("Picked up event items", item.getItemId(), item.getQuantity());
			if (!inventoryItems.contains(item.getItemId()))
			{
				invSpace--;
				if (invSpace < 0)
				{
					continue;
				}
			}
			it.remove();
		}
	}

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
				animation == AnimationID.CAST_BARRAGE) // Burst is same animation as barrage
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

	private void checkOpenedRewards()
	{
		// Check if barrows or clue scroll reward just appeared on the screen
		if (thisTickRewardItems != null)
		{
			if (openedBarrowsChestThisTick)
			{
				Map<Integer, Integer> barrowsReward = Arrays.stream(thisTickRewardItems)
					.collect(Collectors.toMap(ItemStack::getItemId, ItemStack::getQuantity));
				SessionEventLog eventLog = new SessionEventLog(barrowsReward, "Barrows");
				onNewEventLogCreated(eventLog);
				pendingItems.addAll(Arrays.stream(thisTickRewardItems)
					.map(x -> new PendingItem(x.getItemId(), x.getQuantity(), eventLog))
					.collect(Collectors.toList()));
				pickupRewardItems();
			}
			else if (openedClueScrollThisTick)
			{
				Map<Integer, Integer> clueScrollReward = Arrays.stream(thisTickRewardItems)
					.collect(Collectors.toMap(ItemStack::getItemId, ItemStack::getQuantity));
				Map<Integer, Integer> itemDiff = getItemDifferences(
					Arrays.asList(prevTickInventoryItems),
					Arrays.asList(thisTickInventoryItems));
				String clueScrollType = "unknown";
				for (Map.Entry<Integer, Integer> entry : itemDiff.entrySet())
				{
					if (entry.getValue() >= 0)
					{
						continue;
					}
					switch (entry.getKey())
					{
						case ItemID.REWARD_CASKET_EASY:
							clueScrollType = "easy";
							break;
						case ItemID.REWARD_CASKET_MEDIUM:
							clueScrollType = "medium";
							break;
						case ItemID.REWARD_CASKET_HARD:
							clueScrollType = "hard";
							break;
						case ItemID.REWARD_CASKET_ELITE:
							clueScrollType = "elite";
							break;
						case ItemID.REWARD_CASKET_MASTER:
							clueScrollType = "master";
							break;
						default:
							continue;
					}
					break;
				}
				SessionEventLog eventLog = new SessionEventLog(clueScrollReward,
					"Clue scroll (" + clueScrollType + ")");
				onNewEventLogCreated(eventLog);
				pendingItems.addAll(Arrays.stream(thisTickRewardItems)
					.map(x -> new PendingItem(x.getItemId(), x.getQuantity(), eventLog))
					.collect(Collectors.toList()));
				pickupRewardItems();
			}
		}
		if (completedChambersOfXericThisTick)
		{
			Map<Integer, Integer> reward = Arrays.stream(chambersOfXericItems)
				.collect(Collectors.toMap(ItemStack::getItemId, ItemStack::getQuantity));
			SessionEventLog eventLog = new SessionEventLog(reward, "Chambers of Xeric");
			onNewEventLogCreated(eventLog);
			pendingItems.addAll(Arrays.stream(chambersOfXericItems)
				.map(x -> new PendingItem(x.getItemId(), x.getQuantity(), eventLog))
				.collect(Collectors.toList()));
			pickupRewardItems();

			completedChambersOfXericThisTick = false;
		}

		if (!pendingItems.isEmpty())
		{
			debug("Pending " + pendingItems.size() + " stacks of items");

			// Wait for the reward items to appear on the floor,
			// and then start timing them.
			Map<Integer, Integer> itemDiff = getItemDifferencesAt(playerLocationLastTick);
			if (itemDiff != null)
			{
				Iterator<PendingItem> it = pendingItems.iterator();
				while (it.hasNext())
				{
					PendingItem pendingItem = it.next();
					if (itemDiff.getOrDefault(pendingItem.getItemId(), 0) ==
						pendingItem.getQuantity())
					{
						onItemsDropped(pendingItem.getItemId(), pendingItem.getQuantity(),
							playerLocationLastTick, pendingItem.getEventLog());
						it.remove();
					}
				}
			}
		}
	}

	private void checkGroundItemsDisappeared()
	{
		Iterator<Map.Entry<Integer, GroundItem>> it = itemDisappearMap.entries().iterator();
		while (it.hasNext())
		{
			Map.Entry<Integer, GroundItem> entry = it.next();
			if (entry.getKey() > tickCounter)
			{
				break;
			}

			GroundItem groundItem = entry.getValue();
			myItems.get(groundItem.getLocation()).remove(groundItem);
			groundItem.getResponsibleLog().disappearItems(
				groundItem.getItemId(), groundItem.getQuantity());
			if (groundItem.getResponsibleLog().isEverythingFinalized())
			{
				// Items in the log can no longer be dropped or picked up,
				// so we don't need to keep track of them any more
				responsibleLogs.get(groundItem.getItemId())
					.remove(groundItem.getResponsibleLog());
				debugItems("Finalized items 2", groundItem.getItemId(),
					groundItem.getQuantity());
			}
			it.remove();
		}
	}

	private void checkInventoryItemsChanged()
	{
		if (this.thisTickInventoryItems == null ||
			this.prevTickInventoryItems == null)
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
			debug("Error: Tile not found");
			return;
		}

		// Calculate which items were dropped and which were picked up
		WorldPoint wp = tile.getWorldLocation();
		List<ItemStack> prevItems = this.groundItemsLastTick.get(wp);
		List<ItemStack> currItems = getGroundItems(tile);
		Map<Integer, Integer> groundItemDiff = getItemDifferences(prevItems, currItems);
		Map<Integer, Integer> iventoryItemDiff = getItemDifferences(
			Arrays.asList(this.prevTickInventoryItems),
			Arrays.asList(this.thisTickInventoryItems));
		iventoryItemDiff.forEach((key, value) ->
		{
			int groundItemCount = groundItemDiff.getOrDefault(key, 0);
			if (groundItemCount < 0 && value > 0)
			{
				// Items were picked up
				int amount = Math.min(value, -groundItemCount);
				onItemsPickedUp(key, amount, playerLocationLastTick);
			}
			else if (groundItemCount > 0 && value < 0)
			{
				// Items were dropped
				int amount = Math.min(-value, groundItemCount);
				onItemsDropped(key, amount, playerLocationLastTick, null);
			}
			else if (value < 0)
			{
				// Items disappeared from the inventory in some
				// other way, such as banking them
				onItemsFinalized(key, -value);
			}
		});
	}

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
							List<ItemStack> groundItems = getGroundItems(x);
							if (groundItems != null)
							{
								return groundItems.stream().anyMatch(y -> y.getItemId() == ItemID.ZULRAHS_SCALES);
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

				case NpcID.PENANCE_FIGHTER:
				case NpcID.PENANCE_FIGHTER_5739:
				case NpcID.PENANCE_FIGHTER_5740:
				case NpcID.PENANCE_FIGHTER_5741:
				case NpcID.PENANCE_FIGHTER_5742:
				case NpcID.PENANCE_FIGHTER_5743:
				case NpcID.PENANCE_FIGHTER_5744:
				case NpcID.PENANCE_FIGHTER_5745:
				case NpcID.PENANCE_FIGHTER_5746:
				case NpcID.PENANCE_FIGHTER_5747:
				case NpcID.PENANCE_RANGER:
				case NpcID.PENANCE_RANGER_5757:
				case NpcID.PENANCE_RANGER_5758:
				case NpcID.PENANCE_RANGER_5759:
				case NpcID.PENANCE_RANGER_5760:
				case NpcID.PENANCE_RANGER_5761:
				case NpcID.PENANCE_RANGER_5762:
				case NpcID.PENANCE_RANGER_5763:
				case NpcID.PENANCE_RANGER_5764:
				case NpcID.PENANCE_RANGER_5765:
				case NpcID.PENANCE_HEALER:
				case NpcID.PENANCE_HEALER_5766:
				case NpcID.PENANCE_HEALER_5767:
				case NpcID.PENANCE_HEALER_5768:
				case NpcID.PENANCE_HEALER_5769:
				case NpcID.PENANCE_HEALER_5770:
				case NpcID.PENANCE_HEALER_5771:
				case NpcID.PENANCE_HEALER_5772:
				case NpcID.PENANCE_HEALER_5773:
				case NpcID.PENANCE_HEALER_5774:
				case NpcID.PENANCE_RUNNER:
				case NpcID.PENANCE_RUNNER_5748:
				case NpcID.PENANCE_RUNNER_5749:
				case NpcID.PENANCE_RUNNER_5750:
				case NpcID.PENANCE_RUNNER_5751:
				case NpcID.PENANCE_RUNNER_5752:
				case NpcID.PENANCE_RUNNER_5753:
				case NpcID.PENANCE_RUNNER_5754:
				case NpcID.PENANCE_RUNNER_5755:
				case NpcID.PENANCE_RUNNER_5756:
				{
					WorldPoint wp = pad.getActor().getWorldLocation();
					WorldPoint[] dropLocations = new WorldPoint[9];
					int pos = 0;
					for (int dx = -1; dx <= 1; dx++)
					{
						for (int dy = -1; dy <= 1; dy++)
						{
							dropLocations[pos++] = new WorldPoint(
								wp.getX() + dx, wp.getY() + dy, wp.getPlane());
						}
					}
					return dropLocations;
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

	private void checkActorDeaths()
	{
		for (MemorizedActor pad : deadActorsThisTick)
		{
			// Pvp kills can happen in Chambers of Xeric when someone
			// dies and their raid potions drop, but we don't want to
			// log those.
			if (pad instanceof MemorizedPlayer && client.getVar(Varbits.IN_RAID) == 1)
			{
				continue;
			}

			boolean foundIndex = false;
			int index = 0;
			int killsAtWP = 0;
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

			WorldPoint[] locations = getExpectedDropLocations(pad);
			Multimap<WorldPoint, ItemStack> worldDrops = ArrayListMultimap.create();
			for (WorldPoint location : locations)
			{
				Map<Integer, Integer> drops = getItemDifferencesAt(location);
				if (drops == null || drops.size() == 0)
				{
					continue;
				}

				worldDrops.putAll(location, drops.entrySet().stream().map(x ->
					new ItemStack(x.getKey(), x.getValue())).collect(Collectors.toList()));
			}

			if (worldDrops.size() == 0)
			{
				continue;
			}

			Map<Integer, Integer> drops = new HashMap<>();
			for (Map.Entry<WorldPoint, ItemStack> entry : worldDrops.entries())
			{
				// The way we handle multiple kills on the same WorldPoint in the same tick
				// is by splitting up all the drops equally, i.e. if 2 kills happened at the
				// same time and they dropped 3 items of the same type, 1 item would be
				// accounted for the first kill and 2 for the second.
				int nextCount = (entry.getValue().getQuantity() * index / killsAtWP) -
					(entry.getValue().getQuantity() * (index - 1) / killsAtWP);
				if (nextCount == 0)
				{
					continue;
				}
				int count = drops.getOrDefault(entry.getValue().getItemId(), 0);
				drops.put(entry.getValue().getItemId(), nextCount + count);
			}

			SessionLog detailedLog;
			if (pad instanceof MemorizedNpc)
			{
				detailedLog = new SessionNpcLog(drops, ((MemorizedNpc) pad).getNpcComposition());
				onNewNpcLogCreated((SessionNpcLog)detailedLog);
			}
			else if (pad instanceof MemorizedPlayer)
			{
				detailedLog = new SessionPlayerLog(drops, ((MemorizedPlayer) pad).getName(),
					pad.getActor().getCombatLevel());
				onNewPlayerLogCreated((SessionPlayerLog)detailedLog);
			}
			else
			{
				log.error("Unrecognized actor death");
				debug("Error: Unrecognized actor death");
				continue;
			}

			for (Map.Entry<WorldPoint, ItemStack> entry : worldDrops.entries())
			{
				int nextCount = (entry.getValue().getQuantity() * index / killsAtWP) -
					(entry.getValue().getQuantity() * (index - 1) / killsAtWP);
				if (nextCount == 0)
				{
					continue;
				}

				// In some instances, items dropped last for 30 minutes rather than 2,
				// so we memorize the items for 30 minutes if the player is in an instance.
				int itemDuration = (client.isInInstancedRegion() ? INSTANCE_DROP_DISAPPEAR_TIME : NPC_DROP_DISAPPEAR_TIME);
				int disappearsOnTick = tickCounter + itemDuration;
				GroundItem groundItem = new GroundItem(entry.getValue().getItemId(),
					nextCount, entry.getKey(), disappearsOnTick, detailedLog);

				// Memorize which items on the ground were dropped by the users
				// kills and when we can forget them
				myItems.put(groundItem.getLocation(), groundItem);
				itemDisappearMap.put(disappearsOnTick, groundItem);
			}
		}
		deadActorsThisTick.clear();
	}

	private void updateGroundItemLayers()
	{
		for (Tile tile : this.changedItemLayerTiles)
		{
			WorldPoint wp = tile.getWorldLocation();
			List<ItemStack> groundItems = getGroundItems(tile);
			if (groundItems == null)
			{
				groundItemsLastTick.remove(wp);
			}
			else
			{
				groundItemsLastTick.put(wp, groundItems);
			}
		}
		this.changedItemLayerTiles.clear();
	}

	private void updateInventoryItems()
	{
		if (this.thisTickInventoryItems != null)
		{
			this.prevTickInventoryItems = this.thisTickInventoryItems;
			this.thisTickInventoryItems = null;
		}
		this.thisTickRewardItems = null;
		this.openedClueScrollThisTick = false;
		this.openedBarrowsChestThisTick = false;
		this.completedChambersOfXericThisTick = false;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (this.chambersOfXericItems != null && client.getVar(Varbits.IN_RAID) == 0)
		{
			this.hasOpenedRaidsRewardChest = false;
			this.chambersOfXericItems = null;
		}
	}

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

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();

		if (cannonLocation != null && (
			projectile.getId() == ProjectileID.CANNONBALL ||
				projectile.getId() == ProjectileID.GRANITE_CANNONBALL))
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

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WIDGET_BARROWS_REWARD)
		{
			openedBarrowsChestThisTick = true;
		}
		else if (event.getGroupId() == WIDGET_CLUE_SCROLL_REWARD)
		{
			openedClueScrollThisTick = true;
		}
		else if (event.getGroupId() == WIDGET_CHAMBERS_OF_XERIC_REWARD &&
			!hasOpenedRaidsRewardChest)
		{
			completedChambersOfXericThisTick = true;
			hasOpenedRaidsRewardChest = true;
		}
	}

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

	@Subscribe
	public void onActorDespawned(ActorDespawned event)
	{
		MemorizedActor ma = interactedActors.get(event.getActor());
		if (ma != null)
		{
			interactedActors.remove(event.getActor());

			// This event runs before the ItemLayerChanged event,
			// so we have to wait until the end of the game tick
			// before we know what items were dropped
			deadActorsThisTick.add(ma);
		}
	}

	@Subscribe
	public void onItemLayerChanged(ItemLayerChanged event)
	{
		// Note: This event runs 10816 (104*104) times after
		// a new loading screen. Perhaps there is a way to
		// reduce the amount of times it runs?

		this.changedItemLayerTiles.add(event.getTile());
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			this.thisTickInventoryItems = getItemContainerItems(event.getItemContainer());
		}
		else if (event.getItemContainer() == client.getItemContainer(InventoryID.REWARD_CHEST))
		{
			this.thisTickRewardItems = getItemContainerItems(event.getItemContainer());
		}
		else if (event.getItemContainer() == client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST))
		{
			this.chambersOfXericItems = getItemContainerItems(event.getItemContainer());
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN ||
			event.getGameState() == GameState.HOPPING ||
			event.getGameState() == GameState.CONNECTION_LOST)
		{
			pendingItems.clear();
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		checkInteracting();
		checkOpenedRewards();
		checkGroundItemsDisappeared();
		checkInventoryItemsChanged();
		checkActorDeaths();
		updateGroundItemLayers();
		updateInventoryItems();
		playerLocationLastTick = client.getLocalPlayer().getWorldLocation();

		tickCounter++;
	}
}