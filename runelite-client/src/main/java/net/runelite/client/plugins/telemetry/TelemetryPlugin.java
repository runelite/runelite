/*
 * Copyright (c) 2018, Forsco <https://github.com/forsco>
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

package net.runelite.client.plugins.telemetry;

import com.google.common.collect.Sets;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.game.ItemStack;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.barrows.BarrowsBrothers;
import net.runelite.client.plugins.telemetry.data.BarrowsLootTelemetry;
import net.runelite.client.plugins.telemetry.data.CoXLootTelemetry;
import net.runelite.client.plugins.telemetry.data.EventLootTelemetry;
import net.runelite.client.plugins.telemetry.data.InventoryItem;
import net.runelite.client.plugins.telemetry.data.MotherlodeMineTelemetry;
import net.runelite.client.plugins.telemetry.data.NpcLootTelemetry;
import net.runelite.client.plugins.telemetry.data.NpcSpawnedTelemetry;
import net.runelite.client.plugins.telemetry.data.ToBLootTelemetry;
import net.runelite.client.task.Schedule;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Telemetry Plugin",
	description = "Collects Game Telemetry data for use on OSRS Wiki"
)
@Slf4j
public class TelemetryPlugin extends Plugin
{
	private static final int THEATRE_OF_BLOOD_REGION = 12867;
	private static final int PEST_CONTROL_REGION = 10536;
	private static final int MAX_SPAWN_TILE_RANGE = 10;
	// 5 Minute in Milliseconds
	private static final int TIME_EXPIRE_PERIOD = 5 * 60 * 1000;

	private static final int INVENTORY_SIZE = 28;

	private static final Pattern CLUE_SCROLL_PATTERN = Pattern.compile("You have completed [0-9]+ ([a-z]+) Treasure Trails.");
	private static final Pattern PERSONAL_DEATH_TEXT = Pattern.compile("You have died. Death count: \\d*");
	private static final Pattern TEAMMATE_DEATH_TEXT = Pattern.compile(".* has died. Death count: \\d*");

	private String eventType;
	private WorldPoint posLastTick;
	private Set<InventoryItem> playerInventory;
	private Set<InventoryItem> oldPlayerInventory;

	// Motherlode Mine
	private int sackOre;
	private boolean lootedMlmSack = false;

	// Theatre of Blood deaths
	private int personalDeaths = 0;
	private int teamDeaths = 0;
	private int tobVarbit = 0;

	@Inject
	private Client client;

	private final TelemetryManager telemetryManager = new TelemetryManager();

	@Override
	protected void shutDown() throws Exception
	{
		telemetryManager.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
				telemetryManager.flush();
				posLastTick = null;
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		posLastTick = client.getLocalPlayer().getWorldLocation();
	}

	@Subscribe
	public void onVarbitChange(VarbitChanged c)
	{
		int oldOre = sackOre;
		sackOre = client.getVar(Varbits.SACK_NUMBER);
		if (oldOre == -1)
		{
			return;
		}

		if (oldOre != sackOre)
		{
			int removed = oldOre - sackOre;
			if (removed > 0)
			{
				lootedMlmSack = true;
			}
		}

		// Theatre of Blood Varbit
		int oldTobVarbit = tobVarbit;
		tobVarbit = client.getVar(Varbits.THEATRE_OF_BLOOD);
		if (oldTobVarbit != tobVarbit)
		{
			// Was in a party and now is inside, reset the values.
			if (oldTobVarbit == 1 && tobVarbit == 2)
			{
				personalDeaths = 0;
				teamDeaths = 0;
			}
		}
	}

	@Subscribe
	public void onNpcLootReceived(final NpcLootReceived e)
	{
		telemetryManager.submit(new NpcLootTelemetry(e.getNpc().getId(), e.getItems()));
	}

	@Subscribe
	public void onNpcSpawned(final NpcSpawned npcSpawned)
	{
		NPC n = npcSpawned.getNpc();
		if (n.getId() == -1)
		{
			return;
		}

		// If either of these two are null the player must have just logged in
		if (client.getLocalPlayer() == null || posLastTick == null)
		{
			return;
		}

		// We want to ignore certain areas, such as mini-games (Pest Control/Barb Assault) and activities (Raids/ToB)
		if (isInIgnoredArea())
		{
			return;
		}

		// If the player moved planes or more than 10 tiles ignore any NPC spawned events
		if (client.getLocalPlayer().getWorldLocation().distanceTo(posLastTick) >= MAX_SPAWN_TILE_RANGE)
		{
			return;
		}

		// Only catch NPC spawns withing a certain range to prevent false triggers by NPCs loading in while running around
		if (client.getLocalPlayer().getWorldLocation().distanceTo(n.getWorldLocation()) <= MAX_SPAWN_TILE_RANGE)
		{
			telemetryManager.submit(new NpcSpawnedTelemetry(n.getId(), n.getWorldLocation()));
		}

	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		final ItemContainer container;
		switch (event.getGroupId())
		{
			case (WidgetID.BARROWS_REWARD_GROUP_ID):
				eventType = "Barrows";
				container = client.getItemContainer(InventoryID.BARROWS_REWARD);
				break;
			case (WidgetID.CHAMBERS_OF_XERIC_REWARD_GROUP_ID):
				eventType = "Chambers of Xeric";
				container = client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST);
				break;
			case (WidgetID.THEATRE_OF_BLOOD_GROUP_ID):
				int region = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
				if (region != THEATRE_OF_BLOOD_REGION)
				{
					return;
				}
				eventType = "Theatre of Blood";
				container = client.getItemContainer(InventoryID.THEATRE_OF_BLOOD_CHEST);
				break;
			case (WidgetID.CLUE_SCROLL_REWARD_GROUP_ID):
				// event type should be set via ChatMessage for clue scrolls.
				// Clue Scrolls use same InventoryID as Barrows
				container = client.getItemContainer(InventoryID.BARROWS_REWARD);
				break;
			default:
				return;
		}

		if (container == null)
		{
			return;
		}

		// Convert container items to array of ItemStack
		final Collection<ItemStack> items = Arrays.stream(container.getItems())
			.filter(item -> item.getId() > 0)
			.map(item -> new ItemStack(item.getId(), item.getQuantity()))
			.collect(Collectors.toList());

		if (!items.isEmpty())
		{
			EventLootTelemetry data = new EventLootTelemetry(eventType, items);
			if (eventType.equals("Barrows"))
			{
				int slain = getSlainBrothers();
				int reward = (slain * 2) + client.getVar(Varbits.BARROWS_REWARD_POTENTIAL);
				data = new BarrowsLootTelemetry(eventType, items, reward, slain);
			}
			if (eventType.equals("Chambers of Xeric"))
			{
				int personalPoints = client.getVar(Varbits.PERSONAL_POINTS);
				int totalPoints = client.getVar(Varbits.TOTAL_POINTS);
				int partySize = client.getVar(Varbits.RAID_PARTY_SIZE);
				data = new CoXLootTelemetry(eventType, items, personalPoints, totalPoints, partySize);
			}
			if (eventType.equals("Theatre of Blood"))
			{
				data = new ToBLootTelemetry(eventType, items, personalDeaths, teamDeaths);
			}
			telemetryManager.submit(data);
		}
		else
		{
			log.debug("No items to find for Event: {} | Container: {}", eventType, container);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String message = Text.removeTags(event.getMessage());

		// Check if message is for a clue scroll reward
		final Matcher m = CLUE_SCROLL_PATTERN.matcher(message);
		if (m.find())
		{
			final String type = m.group(1).toLowerCase();
			switch (type)
			{
				case "easy":
					eventType = "Clue Scroll (Easy)";
					break;
				case "medium":
					eventType = "Clue Scroll (Medium)";
					break;
				case "hard":
					eventType = "Clue Scroll (Hard)";
					break;
				case "elite":
					eventType = "Clue Scroll (Elite)";
					break;
				case "master":
					eventType = "Clue Scroll (Master)";
					break;
			}
		}

		if (tobVarbit > 1)
		{
			Matcher match = PERSONAL_DEATH_TEXT.matcher(message);
			if (match.matches())
			{
				personalDeaths++;
				teamDeaths++;
			}

			Matcher match2 = TEAMMATE_DEATH_TEXT.matcher(message);
			if (match2.matches())
			{
				teamDeaths++;
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged c)
	{
		if (c.getItemContainer().equals(client.getItemContainer(InventoryID.INVENTORY)))
		{
			oldPlayerInventory = playerInventory;
			playerInventory = getAsInventoryItemSet(c.getItemContainer().getItems());

			if (lootedMlmSack)
			{
				lootedMlmSack = false;
				Set<InventoryItem> addedItems = getInventoryChanges(false);
				telemetryManager.submit(new MotherlodeMineTelemetry(getAsItemStackList(addedItems), client.getRealSkillLevel(Skill.MINING)));
			}
		}
	}

	@Schedule(
		unit = ChronoUnit.MINUTES,
		period = 1
	)
	public void checkFlush()
	{
		Date expires = telemetryManager.getLastSubmitDate();
		if (expires == null)
		{
			return;
		}

		long expireTime = expires.getTime() + TIME_EXPIRE_PERIOD;
		if (new Date().getTime() >= expireTime)
		{
			telemetryManager.flush();
		}
	}

	private boolean isInIgnoredArea()
	{
		// We will most likely have a ton of checks in the future so i figured making
		List<Boolean> checks = new ArrayList<>();

		// Check if they are inside an activity by their varbit
		checks.add(client.getVar(Varbits.IN_GAME_BA) > 0);
		checks.add(client.getVar(Varbits.IN_RAID) > 0);
		checks.add(client.getVar(Varbits.THEATRE_OF_BLOOD) > 1);

		// For Activities that don't have a VarBit or it's not accurate enough check if player is inside region IDs
		// Grabs region ID accounting for instances
		int playerRegion = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
		switch (playerRegion)
		{
			case PEST_CONTROL_REGION:
				checks.add(true);
				break;
			default:
				checks.add(false);
		}

		return checks.contains(true);
	}

	/**
	 * Returns the changes in the inventory
	 * @param removed Show items removed instead of items added
	 * @return
	 */
	private Set<InventoryItem> getInventoryChanges(boolean removed)
	{
		Set<InventoryItem> changed = removed ? Sets.difference(oldPlayerInventory, playerInventory) : Sets.difference(playerInventory, oldPlayerInventory);
		log.info("The following items have been " + (removed ? "removed from" : "added to") + " your inventory: {}", changed);

		return changed;
	}

	// Converts an Item[] into a Set of Inventory Items for easier comparisons
	private Set<InventoryItem> getAsInventoryItemSet(Item[] items)
	{
		Set<InventoryItem> set = new HashSet<>();
		if (items == null)
		{
			return set;
		}

		for (int i = 0; i < INVENTORY_SIZE; i++)
		{
			if (i < items.length)
			{
				Item item = items[i];
				if (item.getId() != -1)
				{
					set.add(new InventoryItem(item.getId(), item.getQuantity(), i));
				}
			}
		}

		return set;
	}

	// Converts a Set<InventoryItem> into a list of ItemStacks
	private Collection<ItemStack> getAsItemStackList(Set<InventoryItem> items)
	{
		Map<Integer, ItemStack> l = new HashMap<>();
		for (InventoryItem i : items)
		{
			int quantity = i.getQuantity();
			if (l.containsKey(i.getId()))
			{
				quantity += l.get(i.getId()).getQuantity();
			}
			l.put(i.getId(), new ItemStack(i.getId(), quantity));
		}

		return l.values();
	}

	private int getSlainBrothers()
	{
		int slain = 0;
		for (BarrowsBrothers brother : BarrowsBrothers.values())
		{
			if (client.getVar(brother.getKilledVarbit()) > 0)
			{
				slain++;
			}
		}
		return slain;
	}
}
