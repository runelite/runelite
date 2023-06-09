/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.game;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.NpcID;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemQuantityChanged;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.events.PlayerLootReceived;

@Singleton
@Slf4j
public class LootManager
{
	private static final Map<Integer, Integer> NPC_DEATH_ANIMATIONS = ImmutableMap.of(
		NpcID.CAVE_KRAKEN, AnimationID.CAVE_KRAKEN_DEATH
	);

	private final EventBus eventBus;
	private final Client client;
	private final NpcUtil npcUtil;
	private final ListMultimap<Integer, ItemStack> itemSpawns = ArrayListMultimap.create();
	private final Set<WorldPoint> killPoints = new HashSet<>();
	private WorldPoint playerLocationLastTick;
	private WorldPoint krakenPlayerLocation;

	private NPC delayedLootNpc;
	private int delayedLootTickLimit;

	@Inject
	private LootManager(EventBus eventBus, Client client, NpcUtil npcUtil)
	{
		this.eventBus = eventBus;
		this.client = client;
		this.npcUtil = npcUtil;
		eventBus.register(this);
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		final NPC npc = npcDespawned.getNpc();

		if (npc == delayedLootNpc)
		{
			delayedLootNpc = null;
			delayedLootTickLimit = 0;
		}

		if (!npcUtil.isDying(npc))
		{
			int id = npc.getId();
			switch (id)
			{
				case NpcID.GARGOYLE:
				case NpcID.GARGOYLE_413:
				case NpcID.GARGOYLE_1543:
				case NpcID.MARBLE_GARGOYLE:
				case NpcID.MARBLE_GARGOYLE_7408:
				case NpcID.DUSK_7888:
				case NpcID.DUSK_7889:

				case NpcID.ROCKSLUG:
				case NpcID.ROCKSLUG_422:
				case NpcID.GIANT_ROCKSLUG:

				case NpcID.SMALL_LIZARD:
				case NpcID.SMALL_LIZARD_463:
				case NpcID.DESERT_LIZARD:
				case NpcID.DESERT_LIZARD_460:
				case NpcID.DESERT_LIZARD_461:
				case NpcID.LIZARD:

				case NpcID.ZYGOMITE:
				case NpcID.ZYGOMITE_1024:
				case NpcID.ANCIENT_ZYGOMITE:

					// these monsters die with >0 hp, so we just look for coincident
					// item spawn with despawn
					break;
				default:
					return;
			}
		}

		processNpcLoot(npc);
	}

	@Subscribe
	public void onPlayerDespawned(PlayerDespawned playerDespawned)
	{
		final Player player = playerDespawned.getPlayer();
		// Only care about dead Players
		if (player.getHealthRatio() != 0)
		{
			return;
		}

		final WorldPoint worldPoint = player.getWorldLocation();
		final LocalPoint location = LocalPoint.fromWorld(client, worldPoint);
		if (location == null || killPoints.contains(worldPoint))
		{
			return;
		}

		final int x = location.getSceneX();
		final int y = location.getSceneY();
		final int packed = x << 8 | y;
		final Collection<ItemStack> items = itemSpawns.get(packed);

		if (items.isEmpty())
		{
			return;
		}

		killPoints.add(worldPoint);
		eventBus.post(new PlayerLootReceived(player, items));
	}

	@Subscribe
	public void onItemSpawned(ItemSpawned itemSpawned)
	{
		final TileItem item = itemSpawned.getItem();
		final Tile tile = itemSpawned.getTile();
		final LocalPoint location = tile.getLocalLocation();
		final int packed = location.getSceneX() << 8 | location.getSceneY();
		itemSpawns.put(packed, new ItemStack(item.getId(), item.getQuantity(), location));
		log.debug("Item spawn {} ({}) location {}", item.getId(), item.getQuantity(), location);
	}

	@Subscribe
	public void onItemDespawned(ItemDespawned itemDespawned)
	{
		final TileItem item = itemDespawned.getItem();
		final LocalPoint location = itemDespawned.getTile().getLocalLocation();
		log.debug("Item despawn {} ({}) location {}", item.getId(), item.getQuantity(), location);
	}

	@Subscribe
	public void onItemQuantityChanged(ItemQuantityChanged itemQuantityChanged)
	{
		final TileItem item = itemQuantityChanged.getItem();
		final Tile tile = itemQuantityChanged.getTile();
		final LocalPoint location = tile.getLocalLocation();
		final int packed = location.getSceneX() << 8 | location.getSceneY();
		final int diff = itemQuantityChanged.getNewQuantity() - itemQuantityChanged.getOldQuantity();

		if (diff <= 0)
		{
			return;
		}

		itemSpawns.put(packed, new ItemStack(item.getId(), diff, location));
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged e)
	{
		if (!(e.getActor() instanceof NPC))
		{
			return;
		}

		final NPC npc = (NPC) e.getActor();
		int id = npc.getId();

		// We only care about certain NPCs
		final Integer deathAnim = NPC_DEATH_ANIMATIONS.get(id);

		// Current animation is death animation?
		if (deathAnim != null && deathAnim == npc.getAnimation())
		{
			if (id == NpcID.CAVE_KRAKEN)
			{
				// Big Kraken drops loot wherever player is standing when animation starts.
				krakenPlayerLocation = client.getLocalPlayer().getWorldLocation();
			}
			else
			{
				// These NPCs drop loot on death animation, which is right now.
				processNpcLoot(npc);
			}
		}
	}

	@Subscribe
	public void onNpcChanged(NpcChanged npcChanged)
	{
		final NPC npc = npcChanged.getNpc();
		if (npc.getId() == NpcID.THE_NIGHTMARE_9433 || npc.getId() == NpcID.PHOSANIS_NIGHTMARE_9424)
		{
			delayedLootNpc = npc;
			delayedLootTickLimit = 15;
		}
		else if (npc.getId() == NpcID.HOLE_IN_THE_WALL)
		{
			delayedLootNpc = npc;
			delayedLootTickLimit = 2;
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (delayedLootNpc != null && delayedLootTickLimit-- > 0)
		{
			processDelayedLoot();
		}

		playerLocationLastTick = client.getLocalPlayer().getWorldLocation();

		itemSpawns.clear();
		killPoints.clear();
	}

	private void processDelayedLoot()
	{
		final WorldPoint adjacentLootTile = getAdjacentSquareLootTile(delayedLootNpc);
		final LocalPoint localPoint = LocalPoint.fromWorld(client, adjacentLootTile);

		if (localPoint == null)
		{
			log.debug("Scene changed away from delayed loot location");
			delayedLootNpc = null;
			delayedLootTickLimit = 0;
			return;
		}

		final int sceneX = localPoint.getSceneX();
		final int sceneY = localPoint.getSceneY();
		final int packed = sceneX << 8 | sceneY;
		final List<ItemStack> itemStacks = itemSpawns.get(packed);
		if (itemStacks.isEmpty())
		{
			// no loot yet
			return;
		}

		log.debug("Got delayed loot stack from {}: {}", delayedLootNpc.getName(), itemStacks);
		eventBus.post(new NpcLootReceived(delayedLootNpc, itemStacks));

		delayedLootNpc = null;
		delayedLootTickLimit = 0;
	}

	private void processNpcLoot(NPC npc)
	{
		final List<ItemStack> allItems = new ArrayList<>();
		for (final WorldArea dropLocation : getDropLocations(npc))
		{
			final WorldPoint worldPoint = dropLocation.toWorldPoint();
			final LocalPoint location = LocalPoint.fromWorld(client, worldPoint);
			if (location == null)
			{
				continue;
			}

			final int x = location.getSceneX();
			final int y = location.getSceneY();

			for (int i = 0; i < dropLocation.getWidth(); ++i)
			{
				for (int j = 0; j < dropLocation.getHeight(); ++j)
				{
					WorldPoint dropPoint = new WorldPoint(worldPoint.getX() + i, worldPoint.getY() + j, worldPoint.getPlane());
					if (!killPoints.add(dropPoint))
					{
						continue;
					}

					final int packed = (x + i) << 8 | (y + j);
					final Collection<ItemStack> items = itemSpawns.get(packed);
					allItems.addAll(items);
				}
			}
		}

		if (!allItems.isEmpty())
		{
			eventBus.post(new NpcLootReceived(npc, allItems));
		}
	}

	private List<WorldArea> getDropLocations(NPC npc)
	{
		switch (npc.getId())
		{
			case NpcID.KRAKEN:
			case NpcID.KRAKEN_6640:
			case NpcID.KRAKEN_6656:
				return Collections.singletonList(playerLocationLastTick.toWorldArea());
			case NpcID.CAVE_KRAKEN:
				return Collections.singletonList(krakenPlayerLocation.toWorldArea());
			case NpcID.ZULRAH:      // Green
			case NpcID.ZULRAH_2043: // Red
			case NpcID.ZULRAH_2044: // Blue
				for (Map.Entry<Integer, ItemStack> entry : itemSpawns.entries())
				{
					if (entry.getValue().getId() == ItemID.ZULRAHS_SCALES)
					{
						int packed = entry.getKey();
						int unpackedX = packed >> 8;
						int unpackedY = packed & 0xFF;
						final WorldPoint lootPoint = WorldPoint.fromScene(client, unpackedX, unpackedY, npc.getWorldLocation().getPlane());
						return Collections.singletonList(lootPoint.toWorldArea());
					}
				}
				break;
			case NpcID.VORKATH:
			case NpcID.VORKATH_8058:
			case NpcID.VORKATH_8059:
			case NpcID.VORKATH_8060:
			case NpcID.VORKATH_8061:
			{
				final WorldPoint bossLocation = npc.getWorldLocation();
				int x = bossLocation.getX() + 3;
				int y = bossLocation.getY() + 3;
				if (playerLocationLastTick.getX() < x)
				{
					x -= 4;
				}
				else if (playerLocationLastTick.getX() > x)
				{
					x += 4;
				}
				if (playerLocationLastTick.getY() < y)
				{
					y -= 4;
				}
				else if (playerLocationLastTick.getY() > y)
				{
					y += 4;
				}
				return Collections.singletonList(new WorldArea(x, y, 1, 1, bossLocation.getPlane()));
			}
			case NpcID.NEX:
			case NpcID.NEX_11279:
			case NpcID.NEX_11280:
			case NpcID.NEX_11281:
			case NpcID.NEX_11282:
			{
				// Nex loot is under the player, or under nex
				LocalPoint localPoint = LocalPoint.fromWorld(client, playerLocationLastTick);
				if (localPoint != null)
				{
					int x = localPoint.getSceneX();
					int y = localPoint.getSceneY();
					final int packed = x << 8 | y;
					if (itemSpawns.containsKey(packed))
					{
						return Collections.singletonList(playerLocationLastTick.toWorldArea());
					}
				}
				break;
			}
			case NpcID.VETION_6612:
			case NpcID.CALLISTO:
			case NpcID.CALLISTO_6609:
			case NpcID.VENENATIS:
			case NpcID.VENENATIS_6610:
			case NpcID.CALVARION_11994:
			case NpcID.ARTIO:
			case NpcID.SPINDEL:
				// Bones are dropped under the center of the boss and loot is dropped under the player
				return ImmutableList.of(npc.getWorldArea(), playerLocationLastTick.toWorldArea());
		}

		return Collections.singletonList(npc.getWorldArea());
	}

	private WorldPoint getAdjacentSquareLootTile(NPC npc)
	{
		final NPCComposition composition = npc.getComposition();
		final WorldPoint worldLocation = npc.getWorldLocation();
		int x = worldLocation.getX();
		int y = worldLocation.getY();

		if (playerLocationLastTick.getX() < x)
		{
			x -= 1;
		}
		else
		{
			x += Math.min(playerLocationLastTick.getX() - x, composition.getSize());
		}

		if (playerLocationLastTick.getY() < y)
		{
			y -= 1;
		}
		else
		{
			y += Math.min(playerLocationLastTick.getY() - y, composition.getSize());
		}

		return new WorldPoint(x, y, worldLocation.getPlane());
	}

	/**
	 * Get the list of items present at the provided WorldPoint that spawned this tick.
	 *
	 * @param worldPoint the location in question
	 * @return the list of item stacks
	 */
	public Collection<ItemStack> getItemSpawns(WorldPoint worldPoint)
	{
		LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);
		if (localPoint == null)
		{
			return Collections.emptyList();
		}

		final int sceneX = localPoint.getSceneX();
		final int sceneY = localPoint.getSceneY();
		final int packed = sceneX << 8 | sceneY;
		final List<ItemStack> itemStacks = itemSpawns.get(packed);
		return Collections.unmodifiableList(itemStacks);
	}
}
