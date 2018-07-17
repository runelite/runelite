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
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.NpcID;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ActorDespawned;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.ItemQuantityChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.loot.data.MemorizedActor;
import net.runelite.client.game.loot.data.MemorizedNpc;
import net.runelite.client.game.loot.data.MemorizedPlayer;
import net.runelite.client.game.loot.events.EventLootReceived;
import net.runelite.client.game.loot.events.NpcLootReceived;
import net.runelite.client.game.loot.events.PlayerLootReceived;

@Slf4j
@Singleton
public class LootLogger
{
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

	private final List<MemorizedActor> deadActorsThisTick = new ArrayList<>();
	private final Map<Tile, List<Item>> newItemsThisTick = new HashMap<>();

	// Based on varbit, used to ignore PvP kills in Raids 1
	private boolean insideChambersOfXeric = false;
	// Only grab loot on initial open of chests
	private boolean hasOpenedRaidsRewardChest = false;
	private boolean hasOpenedTheatreOfBloodRewardChest = false;

	private WorldPoint playerLocationLastTick = null;

	@Inject
	private LootLogger(EventBus eventBus)
	{
		this.eventBus = eventBus;
	}

	/**
	 * Clear data on region change, World Change and Logout.
	 */
	@Subscribe
	public void onGameStateChanged(GameStateChanged e)
	{
		switch (e.getGameState())
		{
			case LOGGED_IN:
			case LOGIN_SCREEN:
			case HOPPING:
				newItemsThisTick.clear();
				deadActorsThisTick.clear();
				break;
			// We don't care about any other cases.
		}
	}

	/**
	 * Reset Variables based on location varbits
	 */
	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		insideChambersOfXeric = (client.getVar(Varbits.IN_RAID) != 0);
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
		log.debug("NPC Loot Received. ID {} | Name: {} | Location: {}", npc, comp.getName(), location);
		log.debug("Drops: {}", tostring(drops));
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
		log.debug("Player Loot Received. Player {} | Name: {} | Location: {}", player, player.getName(), location);
		log.debug("Drops: {}", tostring(drops));
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
		log.debug("Event Loot Received. Event Name {}", event);
		log.debug("Drops: {}", tostring(drops));
	}

	/**
	 * Used to convert a List of Items to String representation.
	 * @param drops List of Item
	 * @return String representation
	 */
	private String tostring(List<Item> drops)
	{
		StringBuilder s = new StringBuilder("Item[");
		int count = 0;
		for (Item i : drops)
		{
			count++;
			s.append("Item(id=").append(i.getId()).append(",quantity=").append(i.getQuantity()).append(")");
			if (count < drops.size())
				s.append(",");
		}
		s.append("]");
		return s.toString();
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

		Actor a = event.getActor();
		NPC npc = (NPC) a;
		int npcId = npc.getId();
		if (!NPC_DEATH_ANIMATIONS.containsKey(npcId))
		{
			return;
		}

		if (NPC_DEATH_ANIMATIONS.get(npcId) == npc.getAnimation())
		{
			if (npcId == NpcID.CAVE_KRAKEN)
			{
				// Cave kraken decides where to drop the loot right when they
				// start the death animation, but it doesn't appear until
				// the death animation has finished
				// TODO: Figure out how to wait until the NPCs death animation has finished
				// TODO: Once animation has finished add to deadActorsThisTick
				log.debug("Killed Kraken, loot should spawn at: {}", playerLocationLastTick);
			}
			else
			{
				deadActorsThisTick.add(new MemorizedNpc(npc));
			}
		}
	}

	/**
	 * Remember dead actors until end of game tick
	 */
	@Subscribe
	public void onActorDespawned(ActorDespawned event)
	{
		// This event runs before the ItemLayerChanged event,
		// so we have to wait until the end of the game tick
		// before we know what items were dropped
		MemorizedActor mem;
		Actor deadActor = event.getActor();

		if (deadActor instanceof NPC)
		{
			NPC n = (NPC) deadActor;
			mem = new MemorizedNpc(n);

			// Some NPCS can die with health bars remaining.
			Double ratio = NpcHpDeath.npcDeathHealthPercent(n.getId());
			double deathHealth = 0;
			if (ratio > 0.00)
			{
				deathHealth = Math.ceil(ratio * deadActor.getHealth());
			}

			// Ensure NPC is dead
			if (deadActor.getHealthRatio() <= deathHealth)
			{
				deadActorsThisTick.add(mem);
			}
		}
		else if (deadActor instanceof Player)
		{
			// Ensure player is dead
			if (deadActor.getHealthRatio() == 0)
			{
				mem = new MemorizedPlayer((Player) deadActor);
				deadActorsThisTick.add(mem);
			}
		}
	}

	/**
	 * Store new items for each tile
	 */
	@Subscribe
	public void onItemSpawned(ItemSpawned event)
	{
		newItemsThisTick.computeIfAbsent(event.getTile(), k -> new ArrayList<Item>()).add(event.getItem());
	}

	/**
	 * Create a new item if the quantity was increased based on the increase amount
	 */
	@Subscribe
	public void onItemQuantityChanged(ItemQuantityChanged event)
	{
		Item i = event.getItem();
		int quantity = event.getNewQuantity() - event.getOldQuantity();
		if (quantity > 0)
		{
			newItemsThisTick.computeIfAbsent(event.getTile(), k -> new ArrayList<Item>()).add(client.createItem(i.getId(), quantity));
		}
	}

	/**
	 * Every game tick we Loop over all dead actor and determine what loot they dropped
	 * We must do this on game tick to ensure the Actor Despawn and Item Spawned events finish firing
	 */
	@Subscribe
	public void onGameTick(GameTick event)
	{
		checkActorDeaths();
		newItemsThisTick.clear();
		playerLocationLastTick = client.getLocalPlayer().getWorldLocation();
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
			// trigger events for these.
			if (pad instanceof MemorizedPlayer && insideChambersOfXeric)
			{
				continue;
			}

			// Stores new items for each new world point. Some NPCs can drop loot on multiple tiles.
			WorldPoint[] locations = getExpectedDropLocations(pad);
			Multimap<WorldPoint, Item> worldDrops = ArrayListMultimap.create();
			for (WorldPoint location : locations)
			{
				int regionX = location.getX() - client.getBaseX();
				int regionY = location.getY() - client.getBaseY();
				if (regionX < 0 || regionX >= Constants.SCENE_SIZE ||
						regionY < 0 || regionY >= Constants.SCENE_SIZE)
				{
					continue;
				}

				Tile tile = client.getScene().getTiles()[location.getPlane()][regionX][regionY];

				// Grab new items for this tile.
				List<Item> drops = this.newItemsThisTick.get(tile);
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
				log.debug("Locations Checked: {}", Arrays.asList(locations));
				continue;
			}

			List<Item> dropList = new ArrayList<>();

			// If we only killed 1 NPC we don't have to worry about splitting loot.
			if (deadActorsThisTick.size() == 1)
			{
				// Add drops for all tiles since NPCs can drop to multiple tiles.
				for (Map.Entry<WorldPoint, Item> entry : worldDrops.entries())
				{
					Item i = entry.getValue();
					dropList.add(i);
				}
			}
			// If multiple interacted NPCs died on the same tick we need to calculate
			// how many npcs died on the same tile to evenly split the loot
			else
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

				if (killsAtWP == 1)
				{
					// Add drops for all tiles since NPCs can drop to multiple tiles.
					for (Map.Entry<WorldPoint, Item> entry : worldDrops.entries())
					{
						Item i = entry.getValue();
						dropList.add(i);
					}
				}
				else
				{
					// Multiple NPCs died on the same WorldPoint in the same tick
					// We handle this by splitting all the drops equally.
					// i.e. if 2 kills dropped 3 items of the same type, 1 item would be
					// accounted for the first kill and 2 for the second.
					Map<Integer, Integer> drops = new HashMap<>();
					for (Map.Entry<WorldPoint, Item> entry : worldDrops.entries())
					{
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
					for (Map.Entry<Integer, Integer> e : drops.entrySet())
					{
						dropList.add(client.createItem(e.getKey(), e.getValue()));
					}
				}
			}

			// Actor type, Calls the wrapper for triggering the proper LootReceived event
			if (pad instanceof NPC)
			{
				MemorizedNpc n = (MemorizedNpc) pad;
				NPCComposition c = n.getNpcComposition();
				onNewNpcLogCreated(c.getId(), c, n.getActor().getWorldLocation(), dropList);
			}
			else if (pad instanceof Player)
			{
				Player p = (Player) pad;
				onNewPlayerLogCreated(p, p.getWorldLocation(), dropList);
			}
			else
			{
				log.error("Unrecognized actor death");
			}
		}

		deadActorsThisTick.clear();
	}


	/**
	 * Determine where the Actors loot will spawn
	 *
	 * @param pad The MemorizedActor that we are checking
	 * @return A List of WorldPoint's where the NPC might spawn loot
	 */
	private WorldPoint[] getExpectedDropLocations(MemorizedActor pad)
	{
		Actor a = pad.getActor();
		WorldPoint defaultLocation = a.getWorldLocation();
		if (pad instanceof MemorizedNpc)
		{
			MemorizedNpc npc = (MemorizedNpc) pad;
			NPCComposition comp = npc.getNpcComposition();

			// Some bosses drop their loot in specific locations
			switch (comp.getId())
			{
				case NpcID.KRAKEN:
				case NpcID.KRAKEN_6640:
				case NpcID.KRAKEN_6656:
					return new WorldPoint[]
							{
									playerLocationLastTick
							};

				case NpcID.CAVE_KRAKEN:
					// TODO: Figure out how grab location of player when Kraken death animation started.
					log.debug("Tried finding loot location for CAVE_KRAKEN, defaulting to players last location");
					return new WorldPoint[]
						{
								playerLocationLastTick
						};

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
					Map.Entry<Tile, List<Item>> entry = newItemsThisTick.entrySet().stream()
							// Filter new items for tile with zulrah scales
							.filter(x ->
							{
								List<Item> groundItems = x.getValue();
								if (groundItems != null)
								{
									return groundItems.stream().anyMatch(y -> y.getId() == ItemID.ZULRAHS_SCALES);
								}
								return false;
							})
							// If player drops some zulrah scales themselves on the same tick,
							// the ones that appeared further away will be chosen instead.
							.sorted((x, y) ->
							{
								WorldPoint xTile = x.getKey().getWorldLocation();
								WorldPoint yTile = y.getKey().getWorldLocation();
								return yTile.distanceTo(playerLocationLastTick) - xTile.distanceTo(playerLocationLastTick);
							})
							.findFirst().orElse(null);
					// Couldn't find any zulrah scales?
					if (entry == null)
					{
						return new WorldPoint[] {};
					}
					// Found zulrah scales for this tile
					WorldPoint location = entry.getKey().getWorldLocation();
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
											a.getWorldLocation().getX() + 2,
											a.getWorldLocation().getY() + 2,
											a.getWorldLocation().getPlane())
							};
				}
			}

			int size = comp.getSize();
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
		else if (event.getGroupId() == WidgetID.CHAMBERS_OF_XERIC_REWARD_GROUP_ID && !hasOpenedRaidsRewardChest)
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
			// TODO: Figure out how to determine clue scroll type
			LootEventType clueType = LootEventType.UNKNOWN_EVENT;

			// Clue Scrolls use same InventoryID as Barrows
			ItemContainer container = client.getItemContainer(InventoryID.BARROWS_REWARD);
			if (container != null)
			{
				List<Item> items = Arrays.asList(container.getItems());
				onNewEventLogCreated(clueType, items);
			}
			else
			{
				log.debug("Error finding clue scroll Item Container");
			}
		}
	}
}