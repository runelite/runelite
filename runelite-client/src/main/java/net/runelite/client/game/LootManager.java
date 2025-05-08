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
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Player;
import net.runelite.api.ScriptEvent;
import net.runelite.api.ScriptID;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.gameval.AnimationID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ServerNpcLoot;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.events.PlayerLootReceived;

@Singleton
@Slf4j
public class LootManager
{
	private static final Map<Integer, Integer> NPC_DEATH_ANIMATIONS = ImmutableMap.of(
		NpcID.SLAYER_KRAKEN, AnimationID.SWAN_QUEEN_DEATH,
		NpcID.HUEY_HEAD_DEFEATED, AnimationID.HUEY_KNOCKOUT
	);

	private final EventBus eventBus;
	private final Client client;
	private final NpcUtil npcUtil;
	private final ListMultimap<Integer, TileItem> itemSpawns = ArrayListMultimap.create();
	private final Set<WorldPoint> killPoints = new HashSet<>();
	private WorldPoint playerLocationLastTick;
	private WorldPoint krakenPlayerLocation;

	private NPC delayedLootNpc;
	private int delayedLootTick;
	private List<WorldArea> delayedLootAreas;

	private NPCComposition scriptNpc;
	private int scriptEventId;
	private final List<ItemStack> scriptItems = new ArrayList<>(4);

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
			clearDelayedLootNpc();
		}

		if (!npcUtil.isDying(npc))
		{
			int id = npc.getId();
			switch (id)
			{
				case NpcID.SLAYER_GARGOYLE_1:
				case NpcID.SLAYER_GARGOYLE_DEAD:
				case NpcID.SLAYER_CAVE_GARGOYLE:
				case NpcID.SUPERIOR_GARGOYLE:
				case NpcID.SUPERIOR_GARGOYLE_DEAD:
				case NpcID.GARGBOSS_DUSK_PHASE4:
				case NpcID.GARGBOSS_DUSK_DEATH:

				case NpcID.SLAYER_ROCKSLUG:
				case NpcID.SLAYER_ROCKSLUG_BABY:
				case NpcID.SUPERIOR_ROCKSLUG:

				case NpcID.SLAYER_LIZARD_SMALL1_GREEN:
				case NpcID.SLAYER_LIZARD_SMALL2_SANDY:
				case NpcID.SLAYER_LIZARD_LARGE1_GREEN:
				case NpcID.SLAYER_LIZARD_LARGE2_SANDY:
				case NpcID.SLAYER_LIZARD_LARGE3_SANDY:
				case NpcID.SLAYER_LIZARD_MASSIVE:

				case NpcID.SLAYER_MUTATED_ZYGOMITE_ADOLESCENT:
				case NpcID.SLAYER_MUTATED_ZYGOMITE_ADULT:
				case NpcID.FOSSIL_ZYGOMITE:

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
		final Collection<ItemStack> items = itemSpawns.get(packed).stream()
			.map(i -> new ItemStack(i.getId(), i.getQuantity()))
			.collect(Collectors.toList());

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
		itemSpawns.put(packed, item);
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
			if (id == NpcID.SLAYER_KRAKEN)
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
		if (npc.getId() == NpcID.NIGHTMARE_DYING || npc.getId() == NpcID.NIGHTMARE_CHALLENGE_DYING)
		{
			delayedLootNpc = npc;
			delayedLootTick = 10;
			// it is too early to call getAdjacentSquareLootTile() because the player might move before the
			// loot location is calculated by the server.
		}
		else if (npc.getId() == NpcID.SWAMP_WALLBEAST)
		{
			delayedLootNpc = npc;
			delayedLootTick = 1;
			delayedLootAreas = getDropLocations(npc);
		}
		else if (npc.getId() == NpcID.DUKE_SUCELLUS_DEAD || npc.getId() == NpcID.DUKE_SUCELLUS_DEAD_QUEST)
		{
			delayedLootNpc = npc;
			delayedLootTick = 5;
			delayedLootAreas = getDropLocations(npc);
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (delayedLootNpc != null && --delayedLootTick == 0)
		{
			processDelayedLoot();
			clearDelayedLootNpc();
		}

		playerLocationLastTick = client.getLocalPlayer().getWorldLocation();

		itemSpawns.clear();
		killPoints.clear();

		processScriptLoot();
	}

	@Subscribe
	private void onScriptPreFired(ScriptPreFired event)
	{
		if (event.getScriptId() == ScriptID.LOOTTRACKER_ADD_LOOT)
		{
			ScriptEvent scriptEvent = event.getScriptEvent();
			int npcId = (int) scriptEvent.getArguments()[1];
			int eventId = (int) scriptEvent.getArguments()[2];
			int itemId = (int) scriptEvent.getArguments()[3];
			int qty = (int) scriptEvent.getArguments()[4];

			log.debug("loottracker_add_loot npc={} event={} item={} qty={}", npcId, eventId, itemId, qty);

			NPCComposition npcComposition = client.getNpcDefinition(npcId);

			if (scriptEventId != eventId)
			{
				processScriptLoot();
			}

			scriptNpc = npcComposition;
			scriptEventId = eventId;
			scriptItems.add(new ItemStack(itemId, qty));
		}
	}

	private void processScriptLoot()
	{
		if (scriptNpc != null && !scriptItems.isEmpty())
		{
			eventBus.post(new ServerNpcLoot(scriptNpc, scriptItems));
		}
		scriptNpc = null;
		scriptItems.clear();
	}

	private void processDelayedLoot()
	{
		if (delayedLootAreas == null)
		{
			// This is only for nightmare
			delayedLootAreas = List.of(getAdjacentSquareLootTile(delayedLootNpc).toWorldArea());
		}

		final List<ItemStack> itemStacks = getItemStacksFromAreas(delayedLootAreas);
		if (!itemStacks.isEmpty())
		{
			log.debug("Got delayed loot stack from {}: {}", delayedLootNpc.getName(), itemStacks);
			eventBus.post(new NpcLootReceived(delayedLootNpc, itemStacks));
		}
		else
		{
			log.debug("Delayed loot expired with no loot");
		}
	}

	private void processNpcLoot(NPC npc)
	{
		final List<ItemStack> allItems = getItemStacksFromAreas(getDropLocations(npc));

		if (!allItems.isEmpty())
		{
			eventBus.post(new NpcLootReceived(npc, allItems));
		}
	}

	private List<ItemStack> getItemStacksFromAreas(final List<WorldArea> areas)
	{
		final List<ItemStack> allItems = new ArrayList<>();
		for (final WorldArea dropLocation : areas)
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
					final Collection<TileItem> items = itemSpawns.get(packed);
					items.forEach(item -> allItems.add(new ItemStack(item.getId(), item.getQuantity())));
				}
			}
		}

		return allItems;
	}

	private List<WorldArea> getDropLocations(NPC npc)
	{
		switch (npc.getId())
		{
			case NpcID.SLAYER_KRAKEN_BOSS:
			case NpcID.KRAKEN_PET:
			case NpcID.POH_KRAKEN_PET:
				return Collections.singletonList(playerLocationLastTick.toWorldArea());
			case NpcID.SLAYER_KRAKEN:
				return Collections.singletonList(krakenPlayerLocation.toWorldArea());
			case NpcID.SNAKEBOSS_BOSS_RANGED:      // Green
			case NpcID.SNAKEBOSS_BOSS_MELEE: // Red
			case NpcID.SNAKEBOSS_BOSS_MAGIC: // Blue
				for (Map.Entry<Integer, TileItem> entry : itemSpawns.entries())
				{
					if (entry.getValue().getId() == ItemID.SNAKEBOSS_SCALE)
					{
						int packed = entry.getKey();
						int unpackedX = packed >> 8;
						int unpackedY = packed & 0xFF;
						final WorldPoint lootPoint = WorldPoint.fromScene(client, unpackedX, unpackedY, npc.getWorldLocation().getPlane());
						return Collections.singletonList(lootPoint.toWorldArea());
					}
				}
				break;
			case NpcID.POH_MOUNTED_VORKATH:
			case NpcID.VORKATH_SLEEPING_NOOP:
			case NpcID.VORKATH_SLEEPING:
			case NpcID.VORKATH_QUEST:
			case NpcID.VORKATH:
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
			case NpcID.NEX_SPAWNING:
			case NpcID.NEX_SOULSPLIT:
			case NpcID.NEX_DEFLECT:
			case NpcID.NEX_DYING:
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
			case NpcID.VETION_2:
			case NpcID.CLANCUP_CALLISTO:
			case NpcID.CALLISTO:
			case NpcID.CLANCUP_VENENATIS:
			case NpcID.VENENATIS:
			case NpcID.VETION_2_SINGLE:
			case NpcID.CALLISTO_SINGLES:
			case NpcID.VENENATIS_SINGLES:
				// Bones are dropped under the center of the boss and loot is dropped under the player
				return ImmutableList.of(npc.getWorldArea(), playerLocationLastTick.toWorldArea());
			case NpcID.DUKE_SUCELLUS_DEAD:
			case NpcID.DUKE_SUCELLUS_DEAD_QUEST:
			{
				final WorldPoint bossLocation = npc.getWorldLocation();
				final int x = bossLocation.getX() + npc.getComposition().getSize() / 2;
				final int y = bossLocation.getY() - 1;

				return List.of(new WorldPoint(x, y, bossLocation.getPlane()).toWorldArea());
			}
			case NpcID.VARDORVIS:
			case NpcID.VARDORVIS_QUEST:
			{
				final WorldArea bossArea = npc.getWorldArea();
				return List.of(new WorldArea(bossArea.getX() - 2, bossArea.getY() - 2, bossArea.getWidth() + 4, bossArea.getHeight() + 4, bossArea.getPlane()));
			}
			case NpcID.LEVIATHAN:
			case NpcID.LEVIATHAN_QUEST:
			{
				final WorldArea bossArea = npc.getWorldArea();
				final int expand = 8;
				final WorldArea expandedArea = new WorldArea(bossArea.getX() - expand, bossArea.getY() - expand, bossArea.getWidth() + expand * 2, bossArea.getHeight() + expand * 2, bossArea.getPlane());
				return List.of(expandedArea);
			}
			case NpcID.SWAMP_WALLBEAST:
			{
				final WorldArea bossArea = npc.getWorldArea();
				return List.of(new WorldArea(bossArea.getX() - 1, bossArea.getY() - 1, 3, 3, bossArea.getPlane()));
			}
			case NpcID.HUEY_HEAD_DEFEATED:
			{
				final WorldArea bossArea = npc.getWorldArea();
				return List.of(new WorldArea(bossArea.getX() - 2, bossArea.getY() - 10, 10, 10, bossArea.getPlane()));
			}
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
		final List<TileItem> itemStacks = itemSpawns.get(packed);
		return itemStacks.stream()
			.map(ti -> new ItemStack(ti.getId(), ti.getQuantity()))
			.collect(Collectors.toList());
	}

	private void clearDelayedLootNpc()
	{
		delayedLootNpc = null;
		delayedLootTick = 0;
		delayedLootAreas = null;
	}
}
