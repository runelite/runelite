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

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
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
import net.runelite.api.Actor;
import static net.runelite.api.AnimationID.*;
import static net.runelite.api.AnimationID.COOKING_RANGE;
import static net.runelite.api.AnimationID.COOKING_WINE;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Player;
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
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.game.ItemStack;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.telemetry.data.BarrowsLootTelemetry;
import net.runelite.client.plugins.telemetry.data.CoXLootTelemetry;
import net.runelite.client.plugins.telemetry.data.EventLootTelemetry;
import net.runelite.client.plugins.telemetry.data.FishingSpots;
import net.runelite.client.plugins.telemetry.data.GameItem;
import net.runelite.client.plugins.telemetry.data.InventoryItem;
import net.runelite.client.plugins.telemetry.data.MotherlodeMineTelemetry;
import net.runelite.client.plugins.telemetry.data.NpcLootTelemetry;
import net.runelite.client.plugins.telemetry.data.NpcSpawnedTelemetry;
import net.runelite.client.plugins.telemetry.data.SkillingData;
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
	private class InventoryType
	{
		public static final String REMOVED = "removed";
		public static final String ADDED = "added";
	}
	private static final int THEATRE_OF_BLOOD_REGION = 12867;
	private static final int PEST_CONTROL_REGION = 10536;
	private static final int MAX_SPAWN_TILE_RANGE = 10;
	// 5 Minute in Milliseconds
	private static final int TIME_EXPIRE_PERIOD = 5 * 60 * 1000;

	private static final int INVENTORY_SIZE = 28;

	private static final Pattern CLUE_SCROLL_PATTERN = Pattern.compile("You have completed [0-9]+ ([a-z]+) Treasure Trails.");
	private static final Pattern PERSONAL_DEATH_TEXT = Pattern.compile("You have died. Death count: \\d*");
	private static final Pattern TEAMMATE_DEATH_TEXT = Pattern.compile(".* has died. Death count: \\d*");

	private static final String FISHING_SPOT = "Fishing spot";

	private String eventType;
	private WorldPoint posLastTick;
	private Set<InventoryItem> playerInventory;
	private Set<InventoryItem> oldPlayerInventory;

	private List<GameItem> itemsCollectedWhileSkilling = new ArrayList<>();
	private boolean isSkilling = false;
	private Skill currentSkill;
	private int tickStarted;
	private int elapsedTicks;
	private int interactingID = -1;
	private int skillAnimation = -1;
	private int lastSkillAnimation = -1;

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

		// Store current values as they will change when checking `isSkilling()`
		boolean oldSkilling = isSkilling;
		Skill skill = currentSkill;
		lastSkillAnimation = skillAnimation;
		elapsedTicks = client.getTickCount() - tickStarted;

		isSkilling = isSkilling();

		// State changed or doing a new skill
		if (oldSkilling != isSkilling || skill != currentSkill || lastSkillAnimation != skillAnimation)
		{
			tickStarted = isSkilling ? client.getTickCount() : tickStarted;
			skillStateChanged(skill, isSkilling);
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged c)
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
			if (!isIgnoredNpc(n.getId()))
			{
				telemetryManager.submit(new NpcSpawnedTelemetry(n.getId(), n.getWorldLocation()));
			}
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
			.map(item -> new ItemStack(item.getId(), item.getQuantity(), client.getLocalPlayer().getLocalLocation()))
			.collect(Collectors.toList());

		if (!items.isEmpty())
		{
			EventLootTelemetry data = new EventLootTelemetry(eventType, items);
			if (eventType.equals("Barrows"))
			{
				data = new BarrowsLootTelemetry(items, client);
			}
			if (eventType.equals("Chambers of Xeric"))
			{
				int personalPoints = client.getVar(Varbits.PERSONAL_POINTS);
				int totalPoints = client.getVar(Varbits.TOTAL_POINTS);
				int partySize = client.getVar(Varbits.RAID_PARTY_SIZE);
				data = new CoXLootTelemetry(items, personalPoints, totalPoints, partySize);
			}
			if (eventType.equals("Theatre of Blood"))
			{
				data = new ToBLootTelemetry(items, personalDeaths, teamDeaths);
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
				Collection<GameItem> addedItems = getInventoryChanges().get(InventoryType.ADDED);
				telemetryManager.submit(new MotherlodeMineTelemetry(stackGameItems(addedItems), client.getRealSkillLevel(Skill.MINING)));
			}
			else if (isSkilling)
			{
				Collection<GameItem> addedItems = getInventoryChanges().get(InventoryType.ADDED);
				itemsCollectedWhileSkilling.addAll(stackGameItems(addedItems));
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

	private Multimap<String, GameItem> getInventoryChanges()
	{
		Map<Integer, Integer> inventory = new HashMap<>();
		for (InventoryItem item : oldPlayerInventory)
		{
			int qty = item.getQuantity() * -1;
			if (inventory.containsKey(item.getId()))
			{
				qty += inventory.get(item.getId());
			}
			inventory.put(item.getId(), qty);
		}
		for (InventoryItem item : playerInventory)
		{
			int qty = item.getQuantity();
			if (inventory.containsKey(item.getId()))
			{
				qty += inventory.get(item.getId());
			}
			inventory.put(item.getId(), qty);
		}

		Multimap<String, GameItem> items = ArrayListMultimap.create();
		for (Map.Entry<Integer, Integer> e : inventory.entrySet())
		{
			GameItem item = new GameItem(e.getKey(), e.getValue());
			int qty = item.getQuantity();
			if (qty == 0)
			{
				continue;
			}
			String type = qty < 0 ? InventoryType.REMOVED : InventoryType.ADDED;
			items.put(type, item);
		}

		log.info("The following inventory changes have occurred: {}", items);
		return items;
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

	private boolean isSkilling()
	{
		currentSkill = null;
		Player p = client.getLocalPlayer();
		int anim = p.getAnimation();
		skillAnimation = anim;

		Actor a = client.getLocalPlayer().getInteracting();
		if (a instanceof NPC)
		{
			NPC n = (NPC) a;
			if (n.getName().contains(FISHING_SPOT))
			{
				currentSkill = Skill.FISHING;
				interactingID = n.getId();
				return true;
			}
		}

		switch (anim)
		{
			/* Woodcutting */
			case WOODCUTTING_BRONZE:
			case WOODCUTTING_IRON:
			case WOODCUTTING_STEEL:
			case WOODCUTTING_BLACK:
			case WOODCUTTING_MITHRIL:
			case WOODCUTTING_ADAMANT:
			case WOODCUTTING_RUNE:
			case WOODCUTTING_DRAGON:
			case WOODCUTTING_INFERNAL:
			case WOODCUTTING_3A_AXE:
				currentSkill = Skill.WOODCUTTING;
				return true;
			/* Cooking(Fire, Range) */
			case COOKING_FIRE:
			case COOKING_RANGE:
			case COOKING_WINE:
				currentSkill = Skill.COOKING;
				return true;
			/* Mining(Normal) */
			case MINING_BRONZE_PICKAXE:
			case MINING_IRON_PICKAXE:
			case MINING_STEEL_PICKAXE:
			case MINING_BLACK_PICKAXE:
			case MINING_MITHRIL_PICKAXE:
			case MINING_ADAMANT_PICKAXE:
			case MINING_RUNE_PICKAXE:
			case MINING_DRAGON_PICKAXE:
			case MINING_DRAGON_PICKAXE_ORN:
			case MINING_INFERNAL_PICKAXE:
			case MINING_3A_PICKAXE:
				/* Mining(Motherlode) */
			case MINING_MOTHERLODE_BRONZE:
			case MINING_MOTHERLODE_IRON:
			case MINING_MOTHERLODE_STEEL:
			case MINING_MOTHERLODE_BLACK:
			case MINING_MOTHERLODE_MITHRIL:
			case MINING_MOTHERLODE_ADAMANT:
			case MINING_MOTHERLODE_RUNE:
			case MINING_MOTHERLODE_DRAGON:
			case MINING_MOTHERLODE_DRAGON_ORN:
			case MINING_MOTHERLODE_INFERNAL:
			case MINING_MOTHERLODE_3A:
				currentSkill = Skill.MINING;
				return true;
			default:
				skillAnimation = -1;
		}

		return false;
	}

	private void skillStateChanged(Skill skill, boolean newState)
	{
		if (skill == null)
		{
			if (newState)
			{
				// Just started skilling, Ensure the list of items gathered is empty
				itemsCollectedWhileSkilling.clear();

				// Some skills, such as cooking, have an inventory change at the same time they start skilling
				Collection<GameItem> addedItems = getInventoryChanges().get(InventoryType.ADDED);
				itemsCollectedWhileSkilling.addAll(stackGameItems(addedItems));
			}
			else
			{
				log.warn("Stopped skilling but skill is null?");
			}
			return;
		}

		// If they stopped skilling or started a new skill submit the current data
		submitSkillData(skill);
	}

	private void submitSkillData(Skill skill)
	{
		if (elapsedTicks < 5)
		{
			log.debug("Skilled for less than 5 ticks, most likely tick manipulating");
			return;
		}
		
		telemetryManager.submit(new SkillingData(skill, client.getRealSkillLevel(skill), stackGameItems(itemsCollectedWhileSkilling), getToolId(skill), elapsedTicks));
	}

	private Collection<GameItem> stackGameItems(Collection<GameItem> items)
	{
		Map<Integer, GameItem> map = new HashMap<>();
		for (GameItem i : items)
		{
			int id = i.getId();
			int qty = i.getQuantity();
			if (map.containsKey(id))
			{
				qty += map.get(id).getQuantity();
			}
			map.put(id, new GameItem(id, qty));
		}

		return map.values();
	}

	private int getToolId(Skill skill)
	{
		switch (skill)
		{
			case FISHING:
				if (interactingID != -1 && FishingSpots.getSPOTS().containsKey(interactingID))
				{
					// Check for a tool in their inventory
					int[] toolIds = FishingSpots.getSPOTS().get(interactingID).getSkillingTools().getTools();
					for (int i : toolIds)
					{
						if (playerInventoryContainsTool(i, true, true))
						{
							return i;
						}
					}
					return -1;
				}
			case MINING:
			case WOODCUTTING:
				return getToolIdByAnimation(lastSkillAnimation);
			case COOKING:
				boolean wearingCookGaunts = playerInventoryContainsTool(ItemID.COOKING_GAUNTLETS, false, true);
				return wearingCookGaunts ? ItemID.COOKING_GAUNTLETS : -1;
		}
		return -1;
	}

	private boolean playerInventoryContainsTool(int toolID, boolean checkInventory, boolean checkWornItems)
	{
		if (checkInventory)
		{
			for (InventoryItem i : playerInventory)
			{
				if (i.getId() == toolID)
				{
					return true;
				}
			}
		}

		ItemContainer c = client.getItemContainer(InventoryID.EQUIPMENT);
		if (c != null && checkWornItems)
		{
			for (Item i : c.getItems())
			{
				if (i.getId() == toolID)
				{
					return true;
				}
			}
		}

		return false;
	}

	private int getToolIdByAnimation(int animation)
	{
		switch (animation)
		{
			/* Mining */
			case MINING_BRONZE_PICKAXE:
			case MINING_MOTHERLODE_BRONZE:
				return ItemID.BRONZE_PICKAXE;
			case MINING_IRON_PICKAXE:
			case MINING_MOTHERLODE_IRON:
				return ItemID.IRON_PICKAXE;
			case MINING_STEEL_PICKAXE:
			case MINING_MOTHERLODE_STEEL:
				return ItemID.STEEL_PICKAXE;
			case MINING_BLACK_PICKAXE:
			case MINING_MOTHERLODE_BLACK:
				return ItemID.BLACK_PICKAXE;
			case MINING_MITHRIL_PICKAXE:
			case MINING_MOTHERLODE_MITHRIL:
				return ItemID.MITHRIL_PICKAXE;
			case MINING_ADAMANT_PICKAXE:
			case MINING_MOTHERLODE_ADAMANT:
				return ItemID.ADAMANT_PICKAXE;
			case MINING_RUNE_PICKAXE:
			case MINING_MOTHERLODE_RUNE:
				return ItemID.RUNE_PICKAXE;
			case MINING_DRAGON_PICKAXE:
			case MINING_MOTHERLODE_DRAGON:
			case MINING_MOTHERLODE_DRAGON_ORN:
			case MINING_DRAGON_PICKAXE_ORN:
				return ItemID.DRAGON_PICKAXE;
			case MINING_MOTHERLODE_INFERNAL:
			case MINING_INFERNAL_PICKAXE:
				return ItemID.INFERNAL_PICKAXE;
			case MINING_3A_PICKAXE:
			case MINING_MOTHERLODE_3A:
				return ItemID._3RD_AGE_PICKAXE;
			/* Woodcutting */
			case WOODCUTTING_BRONZE:
				return ItemID.BRONZE_AXE;
			case WOODCUTTING_IRON:
				return ItemID.IRON_AXE;
			case WOODCUTTING_STEEL:
				return ItemID.STEEL_AXE;
			case WOODCUTTING_BLACK:
				return ItemID.BLACK_AXE;
			case WOODCUTTING_MITHRIL:
				return ItemID.MITHRIL_AXE;
			case WOODCUTTING_ADAMANT:
				return ItemID.ADAMANT_AXE;
			case WOODCUTTING_RUNE:
				return ItemID.RUNE_AXE;
			case WOODCUTTING_DRAGON:
				return ItemID.DRAGON_AXE;
			case WOODCUTTING_INFERNAL:
				return ItemID.INFERNAL_AXE;
			case WOODCUTTING_3A_AXE:
				return ItemID._3RD_AGE_AXE;
		}

		return -1;
	}

	private boolean isIgnoredNpc(int id)
	{
		switch (id)
		{
			// Random Events
			case NpcID.MYSTERIOUS_OLD_MAN_6753:
			case NpcID.PILLORY_GUARD:
			case NpcID.FREAKY_FORESTER_6748:
			case NpcID.BEE_KEEPER_6747:
			case NpcID.STRANGE_PLANT:
			case NpcID.DRUNKEN_DWARF:
			case NpcID.EVIL_BOB:
			case NpcID.SERGEANT_DAMIEN_6743:
			case NpcID.SANDWICH_LADY:
			case NpcID.MILES:
			// Pets | TODO: Ensure pet IDs are correct for pets with non-unique names. Check if both IDs are needed
			// Slayer
			case NpcID.ABYSSAL_ORPHAN:
			case NpcID.ABYSSAL_ORPHAN_5884:
			case NpcID.NOON:
			case NpcID.NOON_7892:
			case NpcID.KRAKEN_6640:
			case NpcID.KRAKEN_6656:
			case NpcID.SKOTOS:
			case NpcID.SKOTOS_7671:
			case NpcID.HELLPUPPY:
			case NpcID.HELLPUPPY_3099:
			case NpcID.SMOKE_DEVIL_8482:
			case NpcID.SMOKE_DEVIL_8483:
			// GWD
			case NpcID.KREEARRA_JR:
			case NpcID.KREEARRA_JR_6643:
			case NpcID.GENERAL_GRAARDOR_JR:
			case NpcID.GENERAL_GRAARDOR_JR_6644:
			case NpcID.ZILYANA_JR:
			case NpcID.ZILYANA_JR_6646:
			case NpcID.KRIL_TSUTSAROTH_JR:
			case NpcID.KRIL_TSUTSAROTH_JR_6647:
			// Wildy
			case NpcID.CALLISTO_CUB:
			case NpcID.CALLISTO_CUB_5558:
			case NpcID.VENENATIS_SPIDERLING:
			case NpcID.VENENATIS_SPIDERLING_5557:
			case NpcID.VETION_JR:
			case NpcID.VETION_JR_5537:
			case NpcID.VETION_JR_5559:
			case NpcID.VETION_JR_5560:
			case NpcID.SCORPIAS_OFFSPRING_5561:
			case NpcID.SCORPIAS_OFFSPRING_6616:
			case NpcID.CHAOS_ELEMENTAL_JR:
			case NpcID.CHAOS_ELEMENTAL_JR_5907:
			case NpcID.PRINCE_BLACK_DRAGON:
			case NpcID.PRINCE_BLACK_DRAGON_6652:
			// Dagannoth kings
			case NpcID.DAGANNOTH_PRIME_JR:
			case NpcID.DAGANNOTH_PRIME_JR_6629:
			case NpcID.DAGANNOTH_REX_JR:
			case NpcID.DAGANNOTH_REX_JR_6641:
			case NpcID.DAGANNOTH_SUPREME_JR:
			case NpcID.DAGANNOTH_SUPREME_JR_6628:
			// Other PvM
			case NpcID.VORKI:
			case NpcID.VORKI_8029:
			case NpcID.LIL_ZIK:
			case NpcID.LIL_ZIK_8337:
			case NpcID.KALPHITE_PRINCESS:
			case NpcID.KALPHITE_PRINCESS_6638:
			case NpcID.KALPHITE_PRINCESS_6653:
			case NpcID.KALPHITE_PRINCESS_6654:
			case NpcID.PENANCE_PET:
			case NpcID.PENANCE_PET_6674:
			case NpcID.OLMLET:
			case NpcID.OLMLET_7520:
			case NpcID.TZREKJAD:
			case NpcID.TZREKJAD_5893:
			case NpcID.JALNIBREK:
			case NpcID.JALNIBREK_7675:
			case NpcID.TZREKZUK:
			case NpcID.TZREKZUK_8011:
			case NpcID.BABY_MOLE_6635:
			case NpcID.BABY_MOLE_6651:
			case NpcID.SNAKELING_2131:
			case NpcID.SNAKELING_2132:
			case NpcID.DARK_CORE:
			case NpcID.DARK_CORE_388:
			case NpcID.CORPOREAL_CRITTER:
			case NpcID.CORPOREAL_CRITTER_8010:
			// Skilling
			case NpcID.PHOENIX:
			case NpcID.PHOENIX_7370:
			case NpcID.HERON:
			case NpcID.HERON_6722:
			case NpcID.BEAVER:
			case NpcID.BEAVER_6724:
			case NpcID.BABY_CHINCHOMPA:
			case NpcID.BABY_CHINCHOMPA_6719:
			case NpcID.BABY_CHINCHOMPA_6720:
			case NpcID.BABY_CHINCHOMPA_6721:
			case NpcID.BABY_CHINCHOMPA_6756:
			case NpcID.BABY_CHINCHOMPA_6757:
			case NpcID.BABY_CHINCHOMPA_6758:
			case NpcID.BABY_CHINCHOMPA_6759:
			case NpcID.ROCK_GOLEM:
			case NpcID.ROCK_GOLEM_6725:
			case NpcID.ROCK_GOLEM_6726:
			case NpcID.ROCK_GOLEM_6727:
			case NpcID.ROCK_GOLEM_6728:
			case NpcID.ROCK_GOLEM_6729:
			case NpcID.ROCK_GOLEM_6730:
			case NpcID.ROCK_GOLEM_7439:
			case NpcID.ROCK_GOLEM_7440:
			case NpcID.ROCK_GOLEM_7441:
			case NpcID.ROCK_GOLEM_7442:
			case NpcID.ROCK_GOLEM_7443:
			case NpcID.ROCK_GOLEM_7444:
			case NpcID.ROCK_GOLEM_7445:
			case NpcID.ROCK_GOLEM_7446:
			case NpcID.ROCK_GOLEM_7447:
			case NpcID.ROCK_GOLEM_7448:
			case NpcID.ROCK_GOLEM_7449:
			case NpcID.ROCK_GOLEM_7450:
			case NpcID.ROCK_GOLEM_7451:
			case NpcID.ROCK_GOLEM_7452:
			case NpcID.ROCK_GOLEM_7453:
			case NpcID.ROCK_GOLEM_7454:
			case NpcID.ROCK_GOLEM_7455:
			case NpcID.ROCKY:
			case NpcID.ROCKY_7353:
			case NpcID.RIFT_GUARDIAN:
			case NpcID.RIFT_GUARDIAN_7339:
			case NpcID.RIFT_GUARDIAN_7340:
			case NpcID.RIFT_GUARDIAN_7341:
			case NpcID.RIFT_GUARDIAN_7342:
			case NpcID.RIFT_GUARDIAN_7343:
			case NpcID.RIFT_GUARDIAN_7344:
			case NpcID.RIFT_GUARDIAN_7345:
			case NpcID.RIFT_GUARDIAN_7346:
			case NpcID.RIFT_GUARDIAN_7347:
			case NpcID.RIFT_GUARDIAN_7348:
			case NpcID.RIFT_GUARDIAN_7349:
			case NpcID.RIFT_GUARDIAN_7350:
			case NpcID.RIFT_GUARDIAN_7338:
			case NpcID.RIFT_GUARDIAN_8024:
			case NpcID.RIFT_GUARDIAN_8028:
			case NpcID.HERBI:
			case NpcID.HERBI_7760:
			case NpcID.GIANT_SQUIRREL:
			case NpcID.GIANT_SQUIRREL_7351:
			case NpcID.TANGLEROOT:
			case NpcID.TANGLEROOT_7352:
			// Misc
			case NpcID.PET_ROCK:
			case NpcID.PET_ROCK_6657:
			case NpcID.CHOMPY_CHICK:
			case NpcID.CHOMPY_CHICK_4002:
			case NpcID.BLOODHOUND:
			case NpcID.BLOODHOUND_7232:
				return true;
		}

		return false;
	}
}
