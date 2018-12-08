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

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.SessionClose;
import net.runelite.api.events.SessionOpen;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.account.SessionManager;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
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
import net.runelite.http.api.loottracker.GameItem;
import net.runelite.http.api.loottracker.LootRecordType;

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

	private static final Splitter COMMA_SPLITTER = Splitter
		.on(",")
		.omitEmptyStrings()
		.trimResults();

	private static final Joiner COMMA_JOINER = Joiner.on(",").skipNulls();

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private LootTrackerConfig config;

	@Inject
	private Client client;

	private LootTrackerPanel panel;
	private NavigationButton navButton;
	private String eventType;

	private CsvWriter csvWriter;
	private LootDatabaseClient databaseClient;

	private List<String> ignoredItems = new ArrayList<>();
	private Multimap<String, LootTrackerRecord> records = ArrayListMultimap.create();

	// stacks and converts ItemStack into GameItem since we don't care about the location
	private static Collection<GameItem> stack(Collection<ItemStack> items)
	{
		final List<GameItem> list = new ArrayList<>();

		for (final ItemStack item : items)
		{
			int quantity = 0;
			for (final GameItem i : list)
			{
				if (i.getId() == item.getId())
				{
					quantity = i.getQty();
					list.remove(i);
					break;
				}
			}
			if (quantity > 0)
			{
				list.add(new GameItem(item.getId(), item.getQuantity() + quantity));
			}
			else
			{
				list.add(new GameItem(item.getId(), item.getQuantity()));
			}
		}

		return list;
	}

	@Provides
	LootTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LootTrackerConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("loottracker"))
		{
			if (event.getKey().equals("ignoredItems"))
			{
				ignoredItems = COMMA_SPLITTER.splitToList(config.getIgnoredItems());
				panel.updateIgnoredRecords();
			}
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		ignoredItems = COMMA_SPLITTER.splitToList(config.getIgnoredItems());
		panel = new LootTrackerPanel(this, itemManager);
		spriteManager.getSpriteAsync(SpriteID.TAB_INVENTORY, 0, panel::loadHeaderIcon);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Loot Tracker")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		// Data persistence helpers
		csvWriter = new CsvWriter(client);
		databaseClient = new LootDatabaseClient(sessionManager);

		// Load all persistent data on client load if enabled
		if (config.getPersistDataToggle())
		{
			clientThread.invokeLater(() ->
			{
				switch (client.getGameState())
				{
					case STARTING:
					case UNKNOWN:
						return false;
				}

				initalizePersistentData();
				SwingUtilities.invokeLater(() -> panel.addRecords(records.values()));
				return true;
			});
		}
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
		final Collection<GameItem> items = stack(npcLootReceived.getItems());
		final String name = npc.getName();
		final int combat = npc.getCombatLevel();
		final LootTrackerItem[] entries = buildEntries(items);
		SwingUtilities.invokeLater(() -> panel.add(name, combat, entries));

		if (config.getPersistDataToggle())
		{
			persistData(new LootTrackerData(name, LootRecordType.EVENT, items));
		}
	}

	@Subscribe
	public void onPlayerLootReceived(final PlayerLootReceived playerLootReceived)
	{
		final Player player = playerLootReceived.getPlayer();
		final Collection<GameItem> items = stack(playerLootReceived.getItems());
		final String name = player.getName();
		final int combat = player.getCombatLevel();
		final LootTrackerItem[] entries = buildEntries(items);
		SwingUtilities.invokeLater(() -> panel.add(name, combat, entries));

		if (config.getPersistDataToggle())
		{
			persistData(new LootTrackerData(name, LootRecordType.PLAYER, items));
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
			final Collection<GameItem> stacked = stack(items);
			final LootTrackerItem[] entries = buildEntries(stacked);
			SwingUtilities.invokeLater(() -> panel.add(eventType, -1, entries));

			if (config.getPersistDataToggle())
			{
				persistData(new LootTrackerData(eventType, LootRecordType.EVENT, stacked));
			}
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

	void toggleItem(String name, boolean ignore)
	{
		final Set<String> ignoredItemSet = new HashSet<>(ignoredItems);

		if (ignore)
		{
			ignoredItemSet.add(name);
		}
		else
		{
			ignoredItemSet.remove(name);
		}

		config.setIgnoredItems(COMMA_JOINER.join(ignoredItemSet));
		panel.updateIgnoredRecords();
	}

	boolean isIgnored(String name)
	{
		return ignoredItems.contains(name);
	}

	private LootTrackerItem[] buildEntries(final Collection<GameItem> itemStacks)
	{
		if (itemStacks == null)
		{
			return new LootTrackerItem[0];
		}

		return itemStacks.stream().map(itemStack ->
		{
			final ItemComposition itemComposition = itemManager.getItemComposition(itemStack.getId());
			final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemStack.getId();
			final long price = (long) itemManager.getItemPrice(realItemId) * (long) itemStack.getQty();
			final boolean ignored = ignoredItems.contains(itemComposition.getName());

			return new LootTrackerItem(
				itemStack.getId(),
				itemComposition.getName(),
				itemStack.getQty(),
				price,
				ignored);
		}).toArray(LootTrackerItem[]::new);
	}

	// Loads all persistent data from config and adds it to the records multimap
	private void initalizePersistentData()
	{
		records.clear();
		Collection<LootTrackerData> storedData = getAllPersistentData();
		log.debug("Loaded Stored Data: {}", storedData);
		records.putAll(consolidate(storedData));
		log.debug("Consolidated Records: {}", records);
	}

	/**
	 * Persists the LootTrackerData via the ConfigManager
	 * @param data data to store
	 */
	private void persistData(LootTrackerData data)
	{
		log.debug("Persisting data: {}", data);

		if (isLoggedIn())
		{
			boolean sent = databaseClient.storeData(data, client.getLocalPlayer().getName());
			log.info("Sent data to api: {}", sent);
		}
		else
		{
			boolean wrote = csvWriter.storeData(data);
			log.info("Data written to CSV file?: {}", wrote);
		}

		records.put(data.getEventId(), createLootTrackerRecord(data));
	}

	private List<LootTrackerData> getAllPersistentData()
	{
		List<LootTrackerData> data = new ArrayList<>();

		if (isLoggedIn())
		{
			Collection<LootTrackerData> d = databaseClient.getData(client.getUsername());
			log.info("Stored data: {}", d);
			if (d != null)
			{
				data.addAll(d);
			}
		}
		else
		{
			Collection<LootTrackerData> d2 = csvWriter.loadAllData();
			log.info("Stored csv data: {}", d2);
			data.addAll(d2);
		}

		return data;
	}

	/**
	 * @param data Collection of LootTrackerData
	 * @return Multimap of LootTrackerData by name
	 */
	private Multimap<String, LootTrackerRecord> consolidate(Collection<LootTrackerData> data)
	{
		Multimap<String, LootTrackerRecord> recs = ArrayListMultimap.create();

		for (LootTrackerData d : data)
		{
			recs.put(d.getEventId(), createLootTrackerRecord(d));
		}

		return recs;
	}

	private LootTrackerRecord createLootTrackerRecord(LootTrackerData d)
	{
		return new LootTrackerRecord(d.getEventId(), "", buildEntries(d.getDrops()), System.currentTimeMillis());
	}

	private boolean isLoggedIn()
	{
		return databaseClient.isLoggedIn();
	}

	@Subscribe
	private void onSessionOpen(SessionOpen e)
	{
		databaseClient.sessionChanged();
	}

	@Subscribe
	private void onSessionClose(SessionClose e)
	{
		databaseClient.sessionChanged();
	}
}
