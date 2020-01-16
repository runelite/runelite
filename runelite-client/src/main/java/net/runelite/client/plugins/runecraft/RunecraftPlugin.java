/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.runecraft;

import static java.lang.Math.min;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.menus.BaseComparableEntry;
import static net.runelite.client.menus.ComparableEntries.newBaseComparableEntry;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.menuentryswapper.comparables.BankComparableEntry;
import net.runelite.client.plugins.menuentryswapper.comparables.EquipmentComparableEntry;
import static net.runelite.client.plugins.runecraft.AbyssRifts.*;
import net.runelite.client.ui.overlay.OverlayManager;


@PluginDescriptor(
	name = "Runecraft",
	description = "Show minimap icons and clickboxes for abyssal rifts",
	tags = {"abyssal", "minimap", "overlay", "rifts", "rc", "runecrafting"},
	type = PluginType.SKILLING
)
@Singleton
@Getter(AccessLevel.PACKAGE)
@Slf4j
public class RunecraftPlugin extends Plugin
{
	private static final int MEDIUM_DEGRADE = 46;
	private static final int LARGE_DEGRADE = 30;
	private static final int GIANT_DEGRADE = 11;
	private static final Object POUCH_TICK = new Object();
	private static final BankComparableEntry POUCH = new BankComparableEntry("fill", "pouch", false);
	private static final BaseComparableEntry EMPTY_SMALL = newBaseComparableEntry("empty", "small pouch");
	private static final BaseComparableEntry EMPTY_MEDIUM = newBaseComparableEntry("empty", "medium pouch");
	private static final BaseComparableEntry EMPTY_LARGE = newBaseComparableEntry("empty", "large pouch");
	private static final BaseComparableEntry EMPTY_GIANT = newBaseComparableEntry("empty", "giant pouch");
	private static final EquipmentComparableEntry CASTLE_WARS = new EquipmentComparableEntry("castle wars", "ring of dueling");
	private static final EquipmentComparableEntry DUEL_ARENA = new EquipmentComparableEntry("duel arena", "ring of dueling");
	private static final String POUCH_DECAYED_MESSAGE = "Your pouch has decayed through use.";
	private static final String POUCH_DECAYED_NOTIFICATION_MESSAGE = "Your rune pouch has decayed.";
	private static final int FIRE_ALTAR = 10315;
	private static final Set<Integer> DEGRADED_POUCHES = ImmutableSet.of(
		ItemID.MEDIUM_POUCH_5511,
		ItemID.LARGE_POUCH_5513,
		ItemID.GIANT_POUCH_5515
	);
	private static final int INVENTORY_SIZE = 28;
	private static final Pattern POUCH_CHECK_MESSAGE = Pattern.compile("^There (?:is|are) ([a-z]+)(?: pure)? essences? in this pouch\\.$");
	private static final ImmutableMap<String, Integer> TEXT_TO_NUMBER = ImmutableMap.<String, Integer>builder()
		.put("no", 0)
		.put("one", 1)
		.put("two", 2)
		.put("three", 3)
		.put("four", 4)
		.put("five", 5)
		.put("six", 6)
		.put("seven", 7)
		.put("eight", 8)
		.put("nine", 9)
		.put("ten", 10)
		.put("eleven", 11)
		.put("twelve", 12)
		.build();

	private final Deque<ClickOperation> clickedItems = new ArrayDeque<>();
	private final Deque<ClickOperation> checkedPouches = new ArrayDeque<>();
	private final Set<AbyssRifts> rifts = new HashSet<>();
	private final Set<DecorativeObject> abyssObjects = new HashSet<>();
	private int lastEssence;
	private int lastSpace;
	@Inject
	private Client client;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private AbyssOverlay abyssOverlay;
	@Inject
	private AbyssMinimapOverlay abyssMinimapOverlay;
	@Inject
	private RunecraftOverlay runecraftOverlay;
	@Inject
	private EssencePouchOverlay essencePouchOverlay;
	@Inject
	private PouchOverlay pouchOverlay;
	@Inject
	private RunecraftConfig config;
	@Inject
	private Notifier notifier;
	@Inject
	private MenuManager menuManager;
	@Inject
	private EventBus eventBus;
	private boolean degradedPouchInInventory;
	private boolean degradingNotification;
	private boolean essPouch;
	private boolean hightlightDarkMage;
	private boolean lavas;
	private boolean showClickBox;
	private boolean showRifts;
	private boolean degradeOverlay;
	private boolean essenceOverlay;
	private boolean medDegrade;
	private boolean largeDegrade;
	private boolean giantDegrade;
	private int mediumCharges = MEDIUM_DEGRADE;
	private int largeCharges = LARGE_DEGRADE;
	private int giantCharges = GIANT_DEGRADE;
	private int pouchVar = 0;
	private NPC darkMage;

	@Provides
	RunecraftConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunecraftConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		overlayManager.add(abyssOverlay);
		overlayManager.add(abyssMinimapOverlay);
		overlayManager.add(runecraftOverlay);
		overlayManager.add(essencePouchOverlay);
		handleSwaps();

		for (Pouch pouch : Pouch.values())
		{
			pouch.setHolding(0);
			pouch.setUnknown(true);
			pouch.degrade(false);
		}

		lastEssence = lastSpace = -1;
	}

	@Override
	protected void shutDown()
	{
		abyssObjects.clear();
		darkMage = null;
		degradedPouchInInventory = false;
		overlayManager.remove(abyssOverlay);
		overlayManager.remove(abyssMinimapOverlay);
		overlayManager.remove(runecraftOverlay);
		overlayManager.remove(essencePouchOverlay);
		removeSwaps();
	}

	private void onGameTick(GameTick event)
	{
		final int before = pouchVar;
		pouchVar = client.getVar(VarPlayer.POUCH_STATUS);

		if (pouchVar == before)
		{
			return;
		}

		if ((pouchVar & 0x8) > 0 && (before & 0x8) <= 0)
		{
			if (giantCharges > 0)
			{
				giantCharges--;
			}
		}
		if ((pouchVar & 0x4) > 0 && (before & 0x4) <= 0)
		{
			if (largeCharges > 0)
			{
				largeCharges--;
			}
		}
		if ((pouchVar & 0x2) > 0 && (before & 0x2) <= 0)
		{
			if (mediumCharges > 0)
			{
				mediumCharges--;
			}
		}
	}

	@Subscribe
	private void onItemContainerChanged(ItemContainerChanged event)
	{
		final ItemContainer container = event.getItemContainer();

		if (container == client.getItemContainer(InventoryID.INVENTORY))
		{
			degradedPouchInInventory = false;

			for (Item item : container.getItems())
			{
				if (!medDegrade && item.getId() == ItemID.MEDIUM_POUCH_5511)
				{
					medDegrade = true;
					mediumCharges = 0;
					degradedPouchInInventory = true;
				}
				else if (!largeDegrade && item.getId() == ItemID.LARGE_POUCH_5513)
				{
					largeDegrade = true;
					largeCharges = 0;
					degradedPouchInInventory = true;
				}
				else if (!giantDegrade && item.getId() == ItemID.GIANT_POUCH_5515)
				{
					giantDegrade = true;
					giantCharges = 0;
					degradedPouchInInventory = true;
				}
				else if (medDegrade && item.getId() == ItemID.MEDIUM_POUCH)
				{
					medDegrade = false;
					mediumCharges = MEDIUM_DEGRADE;
				}
				else if (largeDegrade && item.getId() == ItemID.LARGE_POUCH)
				{
					largeDegrade = false;
					largeCharges = LARGE_DEGRADE;
				}
				else if (giantDegrade && item.getId() == ItemID.GIANT_POUCH)
				{
					giantDegrade = false;
					giantCharges = GIANT_DEGRADE;
				}
			}
		}

		if (InventoryID.INVENTORY.getId() != event.getContainerId())
		{
			return;
		}

		final Item[] items = event.getItemContainer().getItems();

		int newEss = 0;
		int newSpace = 0;

		// Count ess/space, and change pouch states
		for (Item item : items)
		{
			switch (item.getId())
			{
				case ItemID.PURE_ESSENCE:
					newEss += 1;
					break;
				case -1:
					newSpace += 1;
					break;
				case ItemID.MEDIUM_POUCH:
				case ItemID.LARGE_POUCH:
				case ItemID.GIANT_POUCH:
					Pouch pouch = Pouch.forItem(item.getId());
					pouch.degrade(false);
					break;
				case ItemID.MEDIUM_POUCH_5511:
				case ItemID.LARGE_POUCH_5513:
				case ItemID.GIANT_POUCH_5515:
					pouch = Pouch.forItem(item.getId());
					pouch.degrade(true);
					break;
			}
		}
		if (items.length < INVENTORY_SIZE)
		{
			// Pad newSpace for unallocated inventory slots
			newSpace += INVENTORY_SIZE - items.length;
		}

		if (clickedItems.isEmpty())
		{
			lastSpace = newSpace;
			lastEssence = newEss;
			return;
		}

		if (lastEssence == -1 || lastSpace == -1)
		{
			lastSpace = newSpace;
			lastEssence = newEss;
			clickedItems.clear();
			return;
		}

		final int tick = client.getTickCount();

		int essence = lastEssence;
		int space = lastSpace;


		while (essence != newEss)
		{
			ClickOperation op = clickedItems.poll();
			if (op == null)
			{
				break;
			}

			if (tick > op.tick)
			{
				continue;
			}

			Pouch pouch = op.pouch;

			final boolean fill = op.delta > 0;
			// How much ess can either be deposited or withdrawn
			final int required = fill ? pouch.getRemaining() : pouch.getHolding();
			// Bound to how much ess or free space we actually have, and optionally negate
			final int essenceGot = op.delta * min(required, fill ? essence : space);

			// if we have enough essence or space to fill or empty the entire pouch, it no
			// longer becomes unknown
			if (pouch.isUnknown() && (fill ? essence : space) >= pouch.getHoldAmount())
			{
				pouch.setUnknown(false);
			}


			essence -= essenceGot;
			space += essenceGot;

			pouch.addHolding(essenceGot);
		}

		if (!clickedItems.isEmpty())
		{
			return;
		}

		lastSpace = newSpace;
		lastEssence = newEss;
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		switch (event.getMenuOpcode())
		{
			case ITEM_FIRST_OPTION:
			case ITEM_SECOND_OPTION:
			case ITEM_THIRD_OPTION:
			case ITEM_FOURTH_OPTION:
			case ITEM_FIFTH_OPTION:
			case GROUND_ITEM_THIRD_OPTION: // Take
				break;
			default:
				return;
		}

		final int id = event.getIdentifier();
		final Pouch pouch = Pouch.forItem(id);
		if (pouch == null)
		{
			return;
		}

		final int tick = client.getTickCount() + 3;
		switch (event.getOption())
		{
			case "Fill":
				clickedItems.add(new ClickOperation(pouch, tick, 1));
				break;
			case "Empty":
				clickedItems.add(new ClickOperation(pouch, tick, -1));
				break;
			case "Check":
				checkedPouches.add(new ClickOperation(pouch, tick));
				break;
			case "Take":
				// Dropping pouches clears them, so clear when picked up
				pouch.setHolding(0);
				break;
		}
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("runecraft"))
		{
			return;
		}

		updateConfig();

		if (event.getKey().equals("essPouch") || event.getKey().equals("Lavas"))
		{
			removeSwaps();
			handleSwaps();
		}
	}

	@Subscribe
	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (this.degradingNotification && event.getMessage().contains(POUCH_DECAYED_MESSAGE))
		{
			notifier.notify(POUCH_DECAYED_NOTIFICATION_MESSAGE);
		}

		if (!checkedPouches.isEmpty())
		{
			Matcher matcher = POUCH_CHECK_MESSAGE.matcher(event.getMessage());
			if (matcher.matches())
			{
				final int num = TEXT_TO_NUMBER.get(matcher.group(1));
				// Keep getting operations until we get a valid one
				do
				{
					final ClickOperation op = checkedPouches.pop();
					if (op.tick >= client.getTickCount())
					{
						Pouch pouch = op.pouch;
						pouch.setHolding(num);
						pouch.setUnknown(false);
						break;
					}
				}
				while (!checkedPouches.isEmpty());
			}
		}
	}

	@Subscribe
	private void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		final DecorativeObject decorativeObject = event.getDecorativeObject();
		if (AbyssRifts.getRift(decorativeObject.getId()) != null)
		{
			abyssObjects.add(decorativeObject);
		}
	}

	@Subscribe
	private void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		final DecorativeObject decorativeObject = event.getDecorativeObject();
		abyssObjects.remove(decorativeObject);
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged event)
	{
		final GameState gameState = event.getGameState();

		switch (gameState)
		{
			case LOADING:
				abyssObjects.clear();
				break;
			case CONNECTION_LOST:
			case HOPPING:
			case LOGIN_SCREEN:
				darkMage = null;
				break;
			case LOGGED_IN:
				removeSwaps();
				handleSwaps();
				break;
		}
	}

	@Subscribe
	private void onNpcSpawned(NpcSpawned event)
	{
		final NPC npc = event.getNpc();

		if (npc.getId() == NpcID.DARK_MAGE)
		{
			darkMage = npc;
		}
	}

	@Subscribe
	private void onNpcDespawned(NpcDespawned event)
	{
		final NPC npc = event.getNpc();

		if (npc != null && npc == darkMage)
		{
			darkMage = null;
		}
	}

	private void handleSwaps()
	{
		if (this.essPouch)
		{
			menuManager.addPriorityEntry(POUCH).setPriority(100);
			menuManager.addPriorityEntry(EMPTY_SMALL).setPriority(10);
			menuManager.addPriorityEntry(EMPTY_MEDIUM).setPriority(10);
			menuManager.addPriorityEntry(EMPTY_LARGE).setPriority(10);
			menuManager.addPriorityEntry(EMPTY_GIANT).setPriority(10);
		}
		else
		{
			menuManager.removePriorityEntry(POUCH);
			menuManager.removePriorityEntry(EMPTY_SMALL);
			menuManager.removePriorityEntry(EMPTY_MEDIUM);
			menuManager.removePriorityEntry(EMPTY_LARGE);
			menuManager.removePriorityEntry(EMPTY_GIANT);
		}

		if (client.getLocalPlayer() == null || !this.lavas)
		{
			menuManager.removeHiddenEntry("craft", "altar", false, false);
			menuManager.removeHiddenEntry("use", "pure essence", false, true);
			return;
		}

		if (client.getLocalPlayer().getWorldLocation().getRegionID() != FIRE_ALTAR)
		{
			menuManager.removeHiddenEntry("craft", "altar", false, false);
			menuManager.removeHiddenEntry("use", "Pure essence", false, true);
			menuManager.addPriorityEntry(DUEL_ARENA).setPriority(100);
			menuManager.removePriorityEntry(CASTLE_WARS);
		}
		else if (client.getLocalPlayer().getWorldLocation().getRegionID() == FIRE_ALTAR)
		{
			menuManager.addHiddenEntry("craft", "altar", false, false);
			menuManager.addHiddenEntry("use", "Pure essence", false, true);
			menuManager.addPriorityEntry(CASTLE_WARS).setPriority(100);
			menuManager.removePriorityEntry(DUEL_ARENA);
		}
	}

	private void removeSwaps()
	{
		menuManager.removeHiddenEntry("craft", "altar", false, false);
		menuManager.removeHiddenEntry("use", "Pure essence", false, true);
		menuManager.removePriorityEntry(POUCH);
		menuManager.removePriorityEntry(EMPTY_SMALL);
		menuManager.removePriorityEntry(EMPTY_MEDIUM);
		menuManager.removePriorityEntry(EMPTY_LARGE);
		menuManager.removePriorityEntry(EMPTY_GIANT);
		menuManager.removePriorityEntry(CASTLE_WARS);
		menuManager.removePriorityEntry(DUEL_ARENA);
	}

	private void updateConfig()
	{
		this.lavas = config.lavas();
		this.essPouch = config.essPouch();
		this.hightlightDarkMage = config.hightlightDarkMage();
		this.degradingNotification = config.degradingNotification();
		this.showRifts = config.showRifts();
		this.showClickBox = config.showClickBox();
		this.degradeOverlay = config.degradeOverlay();
		this.essenceOverlay = config.essenceOverlay();

		if (this.essenceOverlay)
		{
			overlayManager.add(essencePouchOverlay);
		}
		else
		{
			overlayManager.remove(essencePouchOverlay);
		}

		if (this.degradeOverlay)
		{
			overlayManager.add(pouchOverlay);
			eventBus.subscribe(GameTick.class, POUCH_TICK, this::onGameTick);
		}
		else
		{
			overlayManager.remove(pouchOverlay);
			eventBus.unregister(POUCH_TICK);
		}

		updateRifts();
	}

	private void updateRifts()
	{
		rifts.clear();
		if (config.showAir())
		{
			rifts.add(AIR_RIFT);
		}
		if (config.showBlood())
		{
			rifts.add(BLOOD_RIFT);
		}
		if (config.showBody())
		{
			rifts.add(BODY_RIFT);
		}
		if (config.showChaos())
		{
			rifts.add(CHAOS_RIFT);
		}
		if (config.showCosmic())
		{
			rifts.add(COSMIC_RIFT);
		}
		if (config.showDeath())
		{
			rifts.add(DEATH_RIFT);
		}
		if (config.showEarth())
		{
			rifts.add(EARTH_RIFT);
		}
		if (config.showFire())
		{
			rifts.add(FIRE_RIFT);
		}
		if (config.showLaw())
		{
			rifts.add(LAW_RIFT);
		}
		if (config.showMind())
		{
			rifts.add(MIND_RIFT);
		}
		if (config.showNature())
		{
			rifts.add(NATURE_RIFT);
		}
		if (config.showSoul())
		{
			rifts.add(SOUL_RIFT);
		}
		if (config.showWater())
		{
			rifts.add(WATER_RIFT);
		}
	}
}