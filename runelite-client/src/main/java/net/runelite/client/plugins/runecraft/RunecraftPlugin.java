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

import com.google.common.collect.ImmutableMap;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Runecraft",
	description = "Show minimap icons and clickboxes for abyssal rifts",
	tags = {"abyssal", "minimap", "overlay", "rifts", "rc", "runecrafting"}
)
public class RunecraftPlugin extends Plugin
{
	private static final String POUCH_DECAYED_NOTIFICATION_MESSAGE = "Your rune pouch has decayed.";
	private static final String POUCH_DECAYED_MESSAGE = "Your pouch has decayed through use.";
	private static final Pattern POUCH_CHECK_MESSAGE = Pattern.compile("^There (?:is|are) ([a-z]+)(?: pure)? essences? in this pouch.$");
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

	private boolean loginFlag = true;
	private final List<ClickOperation> clickedItems = new ArrayList<>();
	private final List<ClickOperation> checkedPouches = new ArrayList<>();
	private int lastEssence = 0;
	private int lastSpace = 0;

	@Getter(AccessLevel.PACKAGE)
	private final ImmutableMap<Integer, Pouch> pouches = ImmutableMap.<Integer, Pouch>builder()
		.put(ItemID.SMALL_POUCH, new Pouch(0, ItemID.SMALL_POUCH, 3))
		.put(ItemID.MEDIUM_POUCH, new Pouch(1, ItemID.MEDIUM_POUCH, 6, ItemID.MEDIUM_POUCH_5511, 3))
		.put(ItemID.LARGE_POUCH, new Pouch(2, ItemID.LARGE_POUCH, 9, ItemID.LARGE_POUCH_5513, 7))
		.put(ItemID.GIANT_POUCH, new Pouch(3, ItemID.GIANT_POUCH, 12, ItemID.GIANT_POUCH_5515, 9))
		.build();

	@Getter(AccessLevel.PACKAGE)
	private final Set<DecorativeObject> abyssObjects = new HashSet<>();

	@Getter(AccessLevel.PACKAGE)
	private boolean degradedPouchInInventory;

	@Getter(AccessLevel.PACKAGE)
	private NPC darkMage;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AbyssOverlay abyssOverlay;

	@Inject
	private EssencePouchOverlay essencePouchOverlay;

	@Inject
	private RunecraftConfig config;

	@Inject
	private Notifier notifier;

	@Provides
	RunecraftConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunecraftConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(abyssOverlay);
		overlayManager.add(essencePouchOverlay);
		abyssOverlay.updateConfig();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(abyssOverlay);
		overlayManager.remove(essencePouchOverlay);
		abyssObjects.clear();
		darkMage = null;
		degradedPouchInInventory = false;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("runecraft"))
		{
			abyssOverlay.updateConfig();
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (config.degradingNotification())
		{
			if (event.getMessage().contains(POUCH_DECAYED_MESSAGE))
			{
				notifier.notify(POUCH_DECAYED_NOTIFICATION_MESSAGE);
			}
		}
		if (checkedPouches.size() > 0)
		{
			Matcher matcher = POUCH_CHECK_MESSAGE.matcher(event.getMessage());
			if (matcher.matches())
			{
				final int num = TEXT_TO_NUMBER.get(matcher.group(1));
				// Keep getting operations until we get a valid one
				while (checkedPouches.size() > 0)
				{
					final ClickOperation op = checkedPouches.remove(0);
					if (op.tick >= client.getTickCount())
					{
						Pouch pouch = pouches.get(op.itemId);
						pouch.setHolding(num);
						updatePouchContents(pouch.getTier(), num);
						break;
					}
				}
			}
		}
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		DecorativeObject decorativeObject = event.getDecorativeObject();
		if (AbyssRifts.getRift(decorativeObject.getId()) != null)
		{
			abyssObjects.add(decorativeObject);
		}
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		DecorativeObject decorativeObject = event.getDecorativeObject();
		abyssObjects.remove(decorativeObject);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		GameState gameState = event.getGameState();
		switch (gameState)
		{
			case LOADING:
				abyssObjects.clear();
				break;
			case CONNECTION_LOST:
			case HOPPING:
			case LOGIN_SCREEN:
				darkMage = null;
				loginFlag = true;
				break;
			case LOGGED_IN:
				if (loginFlag)
				{
					loginFlag = false;
					for (Pouch pouch : pouches.values())
					{
						pouch.setHolding(getPouchContents(pouch.getTier()));
					}
				}
				break;
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
		{
			return;
		}

		final Item[] items = event.getItemContainer().getItems();

		int newEss = 0;
		int newSpace = 0;
		Pouch medium = pouches.get(ItemID.MEDIUM_POUCH);
		Pouch large = pouches.get(ItemID.LARGE_POUCH);
		Pouch giant = pouches.get(ItemID.GIANT_POUCH);

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
				case ItemID.MEDIUM_POUCH_5511:
					medium.shouldDegradeStateChange(item.getId());
					break;
				case ItemID.LARGE_POUCH:
				case ItemID.LARGE_POUCH_5513:
					large.shouldDegradeStateChange(item.getId());
					break;
				case ItemID.GIANT_POUCH:
				case ItemID.GIANT_POUCH_5515:
					giant.shouldDegradeStateChange(item.getId());
					break;
			}
		}
		degradedPouchInInventory = medium.isDegraded() || large.isDegraded() || giant.isDegraded();

		final int tick = client.getTickCount();

		int essence = lastEssence;
		int space = lastSpace;

		for (ClickOperation op : clickedItems)
		{
			if (tick > op.tick)
			{
				continue;
			}
			if (op.getItemId() == -1)
			{
				space -= op.delta;
				space = Math.max(0, space);
				continue;
			}
			if (op.getItemId() == ItemID.PURE_ESSENCE)
			{
				// Ensure that the essence can be added
				space -= op.delta;
				if (space < 0)
				{
					essence += op.delta + space;
					space = 0;
				}
				else
				{
					essence += op.delta;
				}
				continue;
			}

			Pouch pouch = pouches.get(op.getItemId());

			final boolean fill = op.getDelta() > 0;
			final int required = fill ? pouch.getRemaining() : pouch.getHolding();
			final int essenceGot = op.getDelta() * Math.min(required, fill ? essence : space);

			essence -= essenceGot;
			pouch.addHolding(essenceGot);
			space += essenceGot;
			updatePouchContents(pouch.getTier(), pouch.getHolding());
		}
		clickedItems.clear();

		lastSpace = newSpace;
		lastEssence = newEss;
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		final int id = getPouchID(event.getId());
		final Pouch pouch = pouches.get(id);
		final int tick = client.getTickCount() + 3;
		if (pouch == null)
		{
			if (id == ItemID.PURE_ESSENCE)
			{
				if (event.getMenuOption().equals("Drop"))
				{
					clickedItems.add(new ClickOperation(ItemID.PURE_ESSENCE, tick, -1));
				}
				else if (event.getMenuOption().equals("Take"))
				{
					clickedItems.add(new ClickOperation(ItemID.PURE_ESSENCE, tick, 1));
				}
			}
			else if (event.getMenuOption().equals("Drop"))
			{
				clickedItems.add(new ClickOperation(-1, tick, -1));
			}
			else if (event.getMenuOption().equals("Take"))
			{
				clickedItems.add(new ClickOperation(-1, tick, 1));
			}
			return;
		}

		switch (event.getMenuOption())
		{
			case "Fill":
				clickedItems.add(new ClickOperation(id, tick, 1));
				break;
			case "Empty":
				clickedItems.add(new ClickOperation(id, tick, -1));
				break;
			case "Check":
				checkedPouches.add(new ClickOperation(id, tick));
				break;
			case "Take":
				pouch.setHolding(0);
				break;
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		final NPC npc = event.getNpc();
		if (npc.getId() == NpcID.DARK_MAGE)
		{
			darkMage = npc;
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		final NPC npc = event.getNpc();
		if (npc == darkMage)
		{
			darkMage = null;
		}
	}

	/**
	 * Updates a pouch's contents in the config.
	 * Values are bitpacked, since they each fit into 4 bits.
	 * A value of 15 represents unknown
	 * @param tier of the pouch
	 * @param value to update with
	 */
	private void updatePouchContents(int tier, int value)
	{
		int current = config.pouchState();
		final int offset = tier * 4;
		final int mask = ~(15 << offset);
		current = (current & mask) | (value << offset);
		config.pouchState(current);
	}

	/**
	 * Get a pouch's value from the bitpacked config value
	 * See {@link RunecraftPlugin#updatePouchContents(int, int)} for more information
	 * @param tier
	 * @return the pouch's contents
	 */
	private int getPouchContents(int tier)
	{
		final int offset = tier * 4;
		return (config.pouchState() & (15 << offset)) >> offset;
	}

	/**
	 * Convert degraded pouch IDs into their repaired counterparts
	 * @param itemId
	 * @return repaired pouch id if degraded, otherwise itemId
	 */
	static int getPouchID(int itemId)
	{
		switch (itemId)
		{
			case ItemID.MEDIUM_POUCH_5511:
				return ItemID.MEDIUM_POUCH;
			case ItemID.LARGE_POUCH_5513:
				return ItemID.LARGE_POUCH;
			case ItemID.GIANT_POUCH_5515:
				return ItemID.GIANT_POUCH;
			default:
				return itemId;
		}
	}
}
