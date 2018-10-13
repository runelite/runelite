/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.loottracker;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.eventbus.Subscribe;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Loot Tracker",
	description = "Tracks loot from monsters and minigames",
	tags = {"drops"},
	enabledByDefault = false
)
@Slf4j
public class LootTrackerPlugin extends Plugin
{
	// Activity/Event loot handling
	private static final Pattern CLUE_SCROLL_PATTERN = Pattern.compile("You have completed [0-9]+ ([a-z]+) Treasure Trails.");
	private static final int THEATRE_OF_BLOOD_REGION = 12867;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private Client client;

	private LootTrackerPanel panel;
	private NavigationButton navButton;
	private String eventType;
	private long lastNumberOfSupplyCrates;
	private HashMultiset<Integer> inventorySnapshot;
	private static final String WINTERTODT_EVENT_NAME = "Wintertodt";
	private static final Collection SUPPLY_CRATES = ImmutableList.of(ItemID.SUPPLY_CRATE, ItemID.EXTRA_SUPPLY_CRATE);

	private static Collection<ItemStack> stack(Collection<ItemStack> items)
	{
		final List<ItemStack> list = new ArrayList<>();

		for (final ItemStack item : items)
		{
			int quantity = 0;
			for (final ItemStack i : list)
			{
				if (i.getId() == item.getId())
				{
					quantity = i.getQuantity();
					list.remove(i);
					break;
				}
			}
			if (quantity > 0)
			{
				list.add(new ItemStack(item.getId(), item.getQuantity() + quantity));
			}
			else
			{
				list.add(item);
			}
		}

		return list;
	}

	@Override
	protected void startUp() throws Exception
	{
		panel = new LootTrackerPanel(itemManager);
		spriteManager.getSpriteAsync(SpriteID.TAB_INVENTORY, 0, panel::loadHeaderIcon);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Loot Tracker")
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
	public void onNpcLootReceived(final NpcLootReceived npcLootReceived)
	{
		final NPC npc = npcLootReceived.getNpc();
		final Collection<ItemStack> items = npcLootReceived.getItems();
		final String name = npc.getName();
		final int combat = npc.getCombatLevel();
		final LootTrackerItem[] entries = buildEntries(stack(items));
		SwingUtilities.invokeLater(() -> panel.add(name, combat, entries));
	}

	@Subscribe
	public void onPlayerLootReceived(final PlayerLootReceived playerLootReceived)
	{
		final Player player = playerLootReceived.getPlayer();
		final Collection<ItemStack> items = playerLootReceived.getItems();
		final String name = player.getName();
		final int combat = player.getCombatLevel();
		final LootTrackerItem[] entries = buildEntries(stack(items));
		SwingUtilities.invokeLater(() -> panel.add(name, combat, entries));
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
			final LootTrackerItem[] entries = buildEntries(stack(items));
			SwingUtilities.invokeLater(() -> panel.add(eventType, -1, entries));
		}
		else
		{
			log.debug("No items to find for Event: {} | Container: {}", eventType, container);
		}
	}

	@Subscribe
	public void itemContainerChanged(ItemContainerChanged event)
	{
		final ItemContainer container = event.getItemContainer();
		observeForWintertodtLootEntry(container);
	}

	private void observeForWintertodtLootEntry(ItemContainer container)
	{
		if (container != client.getItemContainer(InventoryID.INVENTORY))
		{
			return;
		}

		final Item[] items = container.getItems();

		long numberOfSupplyCrates = countSupplyCrates(items);

		HashMultiset<Integer> currentSnapshot = generateInventorySnapshot(items);

		// We want to make sure that we actually opened the supply crate, not banked it
		if (numberOfSupplyCrates != lastNumberOfSupplyCrates && inventorySnapshot != null)
		{
			log.debug("Number of supply crates in inventory has changed from {} to {}", lastNumberOfSupplyCrates, numberOfSupplyCrates);

			if (numberOfSupplyCrates < lastNumberOfSupplyCrates && !bankWidgetIsOpen() && !depositWidgetIsOpen())
			{
				buildAndAddLootEntries(currentSnapshot);
			}

			lastNumberOfSupplyCrates = numberOfSupplyCrates;
		}

		inventorySnapshot = currentSnapshot;
	}

	private void buildAndAddLootEntries(HashMultiset<Integer> currentSnapshot)
	{
		List<ItemStack> loot = generateSnapshotDelta(currentSnapshot, inventorySnapshot);

		// If a supply crate is used on a deposit box or a player dies with a supply crate we do
		// not want to put in an empty loot entry, so we simply ignore any snapshot deltas with no gained items
		if (loot.size() > 0)
		{
			final LootTrackerItem[] entries = buildEntries(stack(loot));
			SwingUtilities.invokeLater(() -> panel.add(WINTERTODT_EVENT_NAME, -1, entries));
		}
	}

	private int countSupplyCrates(Item[] inventory)
	{
		int count = 0;

		for (Item item : inventory)
		{
			// EXTRA_SUPPLY_CRATE is the reward when you trade in items to Ignisia
			if (SUPPLY_CRATES.contains(item.getId()))
			{
				count = count + 1;
			}
		}

		return count;
	}

	private HashMultiset<Integer> generateInventorySnapshot(Item[] inventory)
	{
		HashMultiset<Integer> snapshot = HashMultiset.create();

		for (Item item : inventory)
		{
			if (WintertodtLoot.isWintertodtLoot(itemManager.canonicalize(item.getId())))
			{
				snapshot.add(item.getId(), item.getQuantity());
			}
		}

		return snapshot;
	}

	private List<ItemStack> generateSnapshotDelta(HashMultiset<Integer> newItems, HashMultiset<Integer> oldItems)
	{
		final Multiset<Integer> difference = Multisets.difference(newItems, oldItems);

		List<ItemStack> itemDelta = new ArrayList<>();
		difference.forEachEntry((entry, count) -> itemDelta.add(new ItemStack(entry, count)));

		return itemDelta;
	}

	private boolean bankWidgetIsOpen()
	{
		Widget bankWidget = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
		return bankWidget != null && !bankWidget.isHidden();
	}

	private boolean depositWidgetIsOpen()
	{
		Widget bankWidget = client.getWidget(WidgetInfo.DEPOSIT_BOX_INVENTORY_ITEMS_CONTAINER);
		return bankWidget != null && !bankWidget.isHidden();
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		// Check if message is for a clue scroll reward
		final Matcher m = CLUE_SCROLL_PATTERN.matcher(Text.removeTags(event.getMessage()));
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
	}

	private LootTrackerItem[] buildEntries(final Collection<ItemStack> itemStacks)
	{
		return itemStacks.stream().map(itemStack ->
		{
			final ItemComposition itemComposition = itemManager.getItemComposition(itemStack.getId());
			final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemStack.getId();
			final long price = (long) itemManager.getItemPrice(realItemId) * (long) itemStack.getQuantity();

			return new LootTrackerItem(
				itemStack.getId(),
				itemComposition.getName(),
				itemStack.getQuantity(),
				price);
		}).toArray(LootTrackerItem[]::new);
	}
}
