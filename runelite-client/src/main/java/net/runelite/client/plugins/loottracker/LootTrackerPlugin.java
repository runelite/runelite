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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonStreamParser;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemDefinition;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.RuneLite;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.StackFormatter;
import net.runelite.client.util.Text;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.loottracker.GameItem;
import net.runelite.http.api.loottracker.LootRecord;
import net.runelite.http.api.loottracker.LootRecordType;
import net.runelite.http.api.loottracker.LootTrackerClient;

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

	// Herbiboar loot handling
	private static final String HERBIBOAR_LOOTED_MESSAGE = "You harvest herbs from the herbiboar, whereupon it escapes.";
	private static final String HERBIBOR_EVENT = "Herbiboar";

	// Chest loot handling
	private static final String CHEST_LOOTED_MESSAGE = "You find some treasure in the chest!";
	private static final Map<Integer, String> CHEST_EVENT_TYPES = ImmutableMap.of(
		5179, "Brimstone Chest",
		11573, "Crystal Chest"
	);

	// Player deaths
	public static HashSet<String> usernameSet = new HashSet<String>(Arrays.stream(new String[]{"All Records"}).collect(Collectors.toList()));

	private static final File LOOT_RECORDS_FILE = new File(RuneLite.RUNELITE_DIR, "lootRecords.json");
	private static final Set<Integer> RESPAWN_REGIONS = ImmutableSet.of(
		12850, // Lumbridge
		11828, // Falador
		12342, // Edgeville
		11062 // Camelot
	);
	private boolean pvpDeath = false;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private LootTrackerConfig config;

	@Inject
	public Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private ScheduledExecutorService executor;

	private LootTrackerPanel panel;
	private NavigationButton navButton;
	private String eventType;

	private List<String> ignoredItems = new ArrayList<>();

	private Multiset<Integer> inventorySnapshot;

	@Getter(AccessLevel.PACKAGE)
	private LootTrackerClient lootTrackerClient;
	private BufferedReader bufferedReader;
	private JsonStreamParser jsonStreamParser;
	@VisibleForTesting
	public Collection<LootRecord> lootRecords = new ArrayList<>();

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
				list.add(new ItemStack(item.getId(), item.getQuantity() + quantity, item.getLocation()));
			}
			else
			{
				list.add(item);
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
	public void onSessionOpen(SessionOpen sessionOpen)
	{
		AccountSession accountSession = sessionManager.getAccountSession();
		if (accountSession.getUuid() != null)
		{
			lootTrackerClient = new LootTrackerClient(accountSession.getUuid());
		}
		else
		{
			lootTrackerClient = null;
		}
	}

	@Subscribe
	public void onSessionClose(SessionClose sessionClose)
	{
		lootTrackerClient = null;
	}

	@Subscribe
	public void onLocalPlayerDeath(LocalPlayerDeath event)
	{
		if (client.getVar(Varbits.IN_WILDERNESS) == 1 || WorldType.isPvpWorld(client.getWorldType()))
		{
			deathInventorySnapshot();
			pvpDeath = true;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("loottracker"))
		{
			if (event.getKey().equals("ignoredItems"))
			{
				ignoredItems = Text.fromCSV(config.getIgnoredItems());
				SwingUtilities.invokeLater(panel::updateIgnoredRecords);
			}
			if (event.getKey().equals("sortType"))
			{
				panel.setLootRecordSortType(config.sortType());
				SwingUtilities.invokeLater(panel::rebuild);
			}
		}

	}

	@Override
	protected void startUp() throws Exception
	{
		ignoredItems = Text.fromCSV(config.getIgnoredItems());
		panel = new LootTrackerPanel(this, itemManager, config);
		spriteManager.getSpriteAsync(SpriteID.TAB_INVENTORY, 0, panel::loadHeaderIcon);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Loot Tracker")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		AccountSession accountSession = sessionManager.getAccountSession();
		LOOT_RECORDS_FILE.createNewFile();
		bufferedReader = Files.newBufferedReader(LOOT_RECORDS_FILE.toPath());
		if (accountSession != null || config.localPersistence())
		{

			clientThread.invokeLater(() ->
			{
				switch (client.getGameState())
				{
					case STARTING:
					case UNKNOWN:
						return false;
				}

				executor.submit(() ->
				{

					if (config.syncPanel() && lootTrackerClient != null)
					{
						lootTrackerClient = new LootTrackerClient(accountSession.getUuid());
						try
						{
							lootRecords = lootTrackerClient.get();
						}
						catch (IOException e)
						{
							log.debug("Unable to look up loot", e);
							return;
						}
						log.debug("Loaded {} remote data entries", lootRecords.size());
					}

					if (config.localPersistence() )
					{
						try
						{
							lootRecords.addAll(RuneLiteAPI.GSON.fromJson(new FileReader(LOOT_RECORDS_FILE),
								new TypeToken<ArrayList<LootRecord>>()
								{ }.getType()));
						}
						catch (IOException | NullPointerException e)
						{
							log.info("Couldn't load any locally stored loots.");
						}
						if (lootRecords.size() > 0)
						{
							log.info("Loaded {} locally stored loot records", lootRecords.size());
						}
					}

					Collection<LootRecord> finalLootRecords = lootRecords;
					clientThread.invokeLater(() ->
					{
						Collection<LootTrackerRecord> records = convertToLootTrackerRecord(finalLootRecords);
						SwingUtilities.invokeLater(() -> panel.addRecords(records));
					});
				});
				return true;
			});
		}
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
		lootTrackerClient = null;
		lootRecords = new ArrayList<LootRecord>();
	}

	@Subscribe
	public void onNpcLootReceived(final NpcLootReceived npcLootReceived)
	{
		final NPC npc = npcLootReceived.getNpc();
		final Collection<ItemStack> items = npcLootReceived.getItems();
		final String name = npc.getName();
		final int combat = npc.getCombatLevel();
		final LootTrackerItem[] entries = buildEntries(stack(items));
		String localUsername = client.getLocalPlayer().getName();
		SwingUtilities.invokeLater(() -> panel.add(name, localUsername, combat, entries));
		LootRecord lootRecord = new LootRecord( name, localUsername, LootRecordType.NPC,
			toGameItems(items), Instant.now());

		if (lootTrackerClient != null && config.saveLoot())
		{
			lootTrackerClient.submit(lootRecord);
		}
		if (config.localPersistence())
		{
			saveLocalLootRecord(lootRecord);
		}
	}


	@Subscribe
	public void onPlayerSpawned(PlayerSpawned event)
	{
		if (event.getPlayer().equals(client.getLocalPlayer()))
		{
			SwingUtilities.invokeLater(() -> panel.rebuild());
		}
	}

	@Subscribe
	public void onPlayerLootReceived(final PlayerLootReceived playerLootReceived)
	{
		final Player player = playerLootReceived.getPlayer();
		final Collection<ItemStack> items = playerLootReceived.getItems();
		final String name = player.getName();
		final int combat = player.getCombatLevel();
		final LootTrackerItem[] entries = buildEntries(stack(items));
		String localUsername = client.getLocalPlayer().getName();
		SwingUtilities.invokeLater(() -> panel.add(name, localUsername, combat, entries));
		LootRecord lootRecord = new LootRecord( name, localUsername, LootRecordType.PLAYER,
			toGameItems(items), Instant.now());
		if (lootTrackerClient != null && config.saveLoot())
		{
			lootTrackerClient.submit(lootRecord);
		}
		if (config.localPersistence() && lootTrackerClient == null)
		{
			saveLocalLootRecord(lootRecord);
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
			case (WidgetID.THEATRE_OF_BLOOD_REWARD_GROUP_ID):
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

		if (!(event.getGroupId() == WidgetID.CLUE_SCROLL_REWARD_GROUP_ID) && config.chestLootChat())
		{
			Item[] items = container.getItems();
			long chestPrice = 0;
			for (Item item : items)
			{
				long itemStack = (long) itemManager.getItemPrice(item.getId()) * (long) item.getQuantity();
				chestPrice += itemStack;
			}

			final ChatMessageBuilder message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("Your loot is worth around ")
				.append(StackFormatter.formatNumber(chestPrice))
				.append(" coins.")
				.append(ChatColorType.NORMAL);

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.ITEM_EXAMINE)
				.runeLiteFormattedMessage(message.build())
				.build());
		}

		if (event.getGroupId() == WidgetID.CHATBOX_GROUP_ID)
		{
			panel.rebuild();
		}

		// Convert container items to array of ItemStack
		final Collection<ItemStack> items = Arrays.stream(container.getItems())
			.filter(item -> item.getId() > 0)
			.map(item -> new ItemStack(item.getId(), item.getQuantity(), client.getLocalPlayer().getLocalLocation()))
			.collect(Collectors.toList());

		if (items.isEmpty())
		{
			log.debug("No items to find for Event: {} | Container: {}", eventType, container);
			return;
		}

		final LootTrackerItem[] entries = buildEntries(stack(items));
		SwingUtilities.invokeLater(() -> panel.add(eventType, client.getLocalPlayer().getName(), -1, entries));

		if (lootTrackerClient != null && config.saveLoot())
		{
			LootRecord lootRecord = new LootRecord(eventType, client.getLocalPlayer().getName(), LootRecordType.EVENT,
				toGameItems(items), Instant.now());
			lootTrackerClient.submit(lootRecord);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		final String message = event.getMessage();

		if (message.equals(CHEST_LOOTED_MESSAGE))
		{
			final int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();
			if (!CHEST_EVENT_TYPES.containsKey(regionID))
			{
				return;
			}

			eventType = CHEST_EVENT_TYPES.get(regionID);
			takeInventorySnapshot();

			return;
		}

		if (message.equals(HERBIBOAR_LOOTED_MESSAGE))
		{
			eventType = HERBIBOR_EVENT;
			takeInventorySnapshot();

			return;
		}

		// Check if message is for a clue scroll reward
		final Matcher m = CLUE_SCROLL_PATTERN.matcher(Text.removeTags(message));
		if (m.find())
		{
			final String type = m.group(1).toLowerCase();
			switch (type)
			{
				case "beginner":
					eventType = "Clue Scroll (Beginner)";
					break;
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

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		final ItemContainer itemContainer = event.getItemContainer();

		if (pvpDeath && RESPAWN_REGIONS.contains(client.getLocalPlayer().getWorldLocation().getRegionID()))
		{
			Multiset snapshot = HashMultiset.create();
			snapshot = inventorySnapshot;
			deathInventorySnapshot();
			if (inventorySnapshot != snapshot)
			{
				inventorySnapshot = snapshot;
				ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
				if (inventorySnapshot != null)
				{
					Multiset<Integer> currentInventory = HashMultiset.create();
					if (inventory != null)
					{
						Arrays.stream(client.getItemContainer(InventoryID.INVENTORY).getItems())
							.forEach(item -> currentInventory.add(item.getId(), item.getQuantity()));
					}

					final Multiset<Integer> diff = Multisets.difference(inventorySnapshot, currentInventory);

					List<ItemStack> itemsLost = diff.entrySet().stream()
						.map(e -> new ItemStack(e.getElement(), (-1 * e.getCount()), client.getLocalPlayer().getLocalLocation()))
						.collect(Collectors.toList());

					final LootTrackerItem[] entries = buildEntries(stack(itemsLost));
					String name = "Death: " + client.getLocalPlayer().getName();
					SwingUtilities.invokeLater(() -> panel.add(name, client.getLocalPlayer().getName(),
						client.getLocalPlayer().getCombatLevel(), entries));
					LootRecord lootRecord = new LootRecord(name, client.getLocalPlayer().getName(), LootRecordType.DEATH,
						toGameItems(itemsLost),	Instant.now());
					if (lootTrackerClient != null && config.saveLoot())
					{
						lootTrackerClient.submit(lootRecord);
					}
					if (config.localPersistence() && lootTrackerClient == null)
					{
						saveLocalLootRecord(lootRecord);
					}

					pvpDeath = false;
					inventorySnapshot = null;
				}
			}

		}
		if (eventType != null && (CHEST_EVENT_TYPES.containsValue(eventType) || HERBIBOR_EVENT.equals(eventType)))
		{
			if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
			{
				return;
			}

			processChestLoot(eventType, event.getItemContainer());
			eventType = null;
		}
	}

	private void saveLocalLootRecord(LootRecord lootRecord)
	{
		lootRecords.add(lootRecord);
		try
		{
			BufferedWriter bufferedWriter = Files.newBufferedWriter(LOOT_RECORDS_FILE.toPath());

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();
			Gson gson = gsonBuilder.create();
			bufferedWriter.append(gson.toJson(lootRecords));
			bufferedWriter.close();
		}
		catch (IOException e)
		{
			if (e instanceof FileNotFoundException)
			{
				try
				{
					LOOT_RECORDS_FILE.createNewFile();
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}

	/**
	 * Takes a snapshot of the local player's inventory and equipment right before respawn.
	 */
	private void deathInventorySnapshot()
	{
		final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
		inventorySnapshot = HashMultiset.create();
		if (inventory != null)
		{

			Arrays.stream(inventory.getItems())
				.forEach(item -> inventorySnapshot.add(item.getId(), item.getQuantity()));
		}

			if (equipment != null)
			{
				Arrays.stream(equipment.getItems())
					.forEach(item -> inventorySnapshot.add(item.getId(), item.getQuantity()));
		}
	}

	private void takeInventorySnapshot()
	{
		final ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);
		if (itemContainer != null)
		{
			inventorySnapshot = HashMultiset.create();
			Arrays.stream(itemContainer.getItems())
				.forEach(item -> inventorySnapshot.add(item.getId(), item.getQuantity()));
		}
	}

	private void processChestLoot(String chestType, ItemContainer inventoryContainer)
	{
		if (inventorySnapshot != null)
		{
			Multiset<Integer> currentInventory = HashMultiset.create();
			Arrays.stream(inventoryContainer.getItems())
				.forEach(item -> currentInventory.add(item.getId(), item.getQuantity()));

			final Multiset<Integer> diff = Multisets.difference(currentInventory, inventorySnapshot);

			List<ItemStack> items = diff.entrySet().stream()
				.map(e -> new ItemStack(e.getElement(), e.getCount(), client.getLocalPlayer().getLocalLocation()))
				.collect(Collectors.toList());

			final LootTrackerItem[] entries = buildEntries(stack(items));
			SwingUtilities.invokeLater(() -> panel.add(chestType, client.getLocalPlayer().getName(), -1, entries));

			if (lootTrackerClient != null && config.saveLoot())
			{
				LootRecord lootRecord = new LootRecord(chestType, client.getLocalPlayer().getName(),
					LootRecordType.EVENT, toGameItems(items), Instant.now());
				lootTrackerClient.submit(lootRecord);
			}

			inventorySnapshot = null;
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

		config.setIgnoredItems(Text.toCSV(ignoredItemSet));
		panel.updateIgnoredRecords();
	}

	boolean isIgnored(String name)
	{
		return ignoredItems.contains(name);
	}

	@VisibleForTesting
	private LootTrackerItem buildLootTrackerItem(int itemId, int quantity)
	{
		final ItemDefinition itemDefinition = itemManager.getItemDefinition(itemId);
		final int realItemId = itemDefinition.getNote() != -1 ? itemDefinition.getLinkedNoteId() : itemId;
		final long price;
		// If it's a death we want to get a coin value for untradeables lost
		if (!itemDefinition.isTradeable() && quantity < 0)
		{
			price = (long) itemDefinition.getPrice() * (long) quantity;
		}
		else
		{
			price = (long) itemManager.getItemPrice(realItemId) * (long) quantity;
		}
		final boolean ignored = ignoredItems.contains(itemDefinition.getName());

		return new LootTrackerItem(
			itemId,
			itemDefinition.getName(),
			quantity,
			price,
			ignored);
	}

	private LootTrackerItem[] buildEntries(final Collection<ItemStack> itemStacks)
	{
		return itemStacks.stream()
			.map(itemStack -> buildLootTrackerItem(itemStack.getId(), itemStack.getQuantity()))
			.toArray(LootTrackerItem[]::new);
	}

	private static Collection<GameItem> toGameItems(Collection<ItemStack> items)
	{
		return items.stream()
			.map(item -> new GameItem(item.getId(), item.getQuantity()))
			.collect(Collectors.toList());
	}

	public Collection<LootTrackerRecord> convertToLootTrackerRecord(final Collection<LootRecord> records)
	{
		Collection<LootTrackerRecord> trackerRecords = new ArrayList<>();
		for (LootRecord record : records)
		{
			LootTrackerItem[] drops = record.getDrops().stream().map(itemStack ->
				buildLootTrackerItem(itemStack.getId(), itemStack.getQty())
			).toArray(LootTrackerItem[]::new);

			trackerRecords.add(new LootTrackerRecord(record.getEventId(), record.getUsername(),
				"", drops, -1));
		}

		return trackerRecords;
	}
}
