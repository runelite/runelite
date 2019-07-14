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
package net.runelite.client.plugins.stonedloottracker;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.stonedloottracker.data.LootRecordCustom;
import net.runelite.client.plugins.stonedloottracker.data.LootRecordWriter;
import net.runelite.client.plugins.stonedloottracker.data.LootTrackerItemEntry;
import net.runelite.client.plugins.stonedloottracker.data.Pet;
import net.runelite.client.plugins.stonedloottracker.data.UniqueItem;
import net.runelite.client.plugins.stonedloottracker.data.UniqueItemPrepared;
import net.runelite.client.plugins.stonedloottracker.data.events.LootTrackerNameChange;
import net.runelite.client.plugins.stonedloottracker.data.events.LootTrackerRecordStored;
import net.runelite.client.plugins.stonedloottracker.ui.LootTrackerPanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Stoned Loot Tracker",
	description = "Tracks loot from monsters and minigames",
	tags = {"drops"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
@Slf4j
public class StonedLootTrackerPlugin extends Plugin
{
	// Activity/Event loot handling
	private static final Pattern CLUE_SCROLL_PATTERN = Pattern.compile("You have completed ([0-9]+) ([a-z]+) Treasure Trails.");
	private static final Pattern BOSS_NAME_NUMBER_PATTERN = Pattern.compile("Your (.*) kill count is: ([0-9]*).");
	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");
	private static final ImmutableList<String> PET_MESSAGES = ImmutableList.of("You have a funny feeling like you're being followed",
		"You feel something weird sneaking into your backpack",
		"You have a funny feeling like you would have been followed");
	private static final int THEATRE_OF_BLOOD_REGION = 12867;

	// Herbiboar loot handling
	private static final String HERBIBOAR_LOOTED_MESSAGE = "Your herbiboar harvest count is";
	private static final String HERBIBOR_EVENT = "Herbiboar";

	// Chest loot handling
	private static final String CHEST_LOOTED_MESSAGE = "You find some treasure in the chest!";
	private static final Map<Integer, String> CHEST_EVENT_TYPES = ImmutableMap.of(
		5179, "Brimstone Chest",
		11573, "Crystal Chest"
	);

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private Client client;

	@Inject
	public StonedLootTrackerConfig config;

	@Inject
	private ClientThread clientThread;

	@Inject
	private LootRecordWriter writer;

	@Inject
	private EventBus eventBus;

	private Multiset<Integer> inventorySnapshot;

	@Provides
	StonedLootTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StonedLootTrackerConfig.class);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("stonedloottracker"))
		{
			panel.refreshUI();
		}
	}

	private LootTrackerPanel panel;
	private NavigationButton navButton;
	private String eventType;

	private final Multimap<String, LootRecordCustom> lootRecordMultimap = ArrayListMultimap.create();
	private final Multimap<String, UniqueItemPrepared> uniques = ArrayListMultimap.create();
	private final Map<String, Integer> killCountMap = new HashMap<>();

	// key = name, value=current killCount
	private boolean loaded = false;
	private boolean gotPet = false;

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		panel = new LootTrackerPanel(itemManager, this);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Stoned Loot Tracker")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		if (!loaded)
		{
			clientThread.invokeLater(() ->
			{
				switch (client.getGameState())
				{
					case UNKNOWN:
					case STARTING:
						return false;
				}

				prepareUniqueItems();
				return true;
			});
		}
	}

	private void prepareUniqueItems()
	{
		loaded = true;
		for (UniqueItem i : UniqueItem.values())
		{
			ItemDefinition c = itemManager.getItemDefinition(i.getItemID());
			for (String s : i.getActivities())
			{
				uniques.put(s.toUpperCase(), new UniqueItemPrepared(c.getLinkedNoteId(), itemManager.getItemPrice(i.getItemID()), i));
			}
		}
	}

	public Collection<UniqueItemPrepared> getUniques(String name)
	{
		return uniques.get(name.toUpperCase());
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		clientToolbar.removeNavigation(navButton);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(LootTrackerRecordStored.class, this, this::onLootTrackerRecordStored);
		eventBus.subscribe(LootTrackerNameChange.class, this, this::onLootTrackerNameChange);
		eventBus.subscribe(NpcLootReceived.class, this, this::onNpcLootReceived);
		eventBus.subscribe(PlayerLootReceived.class, this, this::onPlayerLootReceived);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
	}

	private void onLootTrackerRecordStored(LootTrackerRecordStored s)
	{
		SwingUtilities.invokeLater(() -> panel.addLog(s.getRecord()));
	}


	private void onLootTrackerNameChange(LootTrackerNameChange c)
	{
		refreshData();
		SwingUtilities.invokeLater(() -> panel.updateNames());
	}

	private void onNpcLootReceived(final NpcLootReceived npcLootReceived)
	{
		final NPC npc = npcLootReceived.getNpc();
		final Collection<ItemStack> items = npcLootReceived.getItems();
		final String name = npc.getName().toLowerCase().contains("vet'ion reborn") ? "Vet'ion" : npc.getName();
		final int combat = npc.getCombatLevel();
		final int killCount = killCountMap.getOrDefault(name.toUpperCase(), -1);
		final LootTrackerItemEntry[] entries = buildEntries(items);

		if (gotPet)
		{
			ItemStack pet = handlePet(name);
			if (pet == null)
			{
				log.warn("Error finding pet for npc name: {}", name);
			}
			else
			{
				items.add(pet);
			}
		}

		LootRecordCustom rec = new LootRecordCustom(npc.getId(), name, combat, killCount, Arrays.asList(entries));
		addLog(name, rec);
	}

	private void onPlayerLootReceived(final PlayerLootReceived playerLootReceived)
	{
		final Player player = playerLootReceived.getPlayer();
		final Collection<ItemStack> items = playerLootReceived.getItems();
		final String name = player.getName();
		final int combat = player.getCombatLevel();
		final int killCount = killCountMap.getOrDefault(name.toUpperCase(), -1);
		final LootTrackerItemEntry[] entries = buildEntries(items);
		LootRecordCustom rec = new LootRecordCustom(-1, name, combat, killCount, Arrays.asList(entries));
		addLog(name, rec);
	}

	private void onWidgetLoaded(WidgetLoaded event)
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
				// Unsired redemption tracking
			case (WidgetID.DIALOG_SPRITE_GROUP_ID):
				Widget text = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
				if ("you place the unsired into the font of consumption...".equals(text.getText().toLowerCase()))
				{
					checkUnsiredWidget();
				}
				return;
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

		if (items.isEmpty())
		{
			log.debug("No items to find for Event: {} | Container: {}", eventType, container);
			return;
		}

		final LootTrackerItemEntry[] entries = buildEntries(items);
		final int killCount = killCountMap.getOrDefault(eventType.toUpperCase(), -1);
		LootRecordCustom rec = new LootRecordCustom(-1, eventType, -1, killCount, Arrays.asList(entries));
		addLog(eventType, rec);
	}

	private void addLog(String name, LootRecordCustom record)
	{
		lootRecordMultimap.put(name, record);
		writer.addLootTrackerRecord(record);
	}

	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String chatMessage = Text.removeTags(event.getMessage());

		// Check if message is for a clue scroll reward
		final Matcher m = CLUE_SCROLL_PATTERN.matcher(chatMessage);
		if (m.find())
		{
			final String type = m.group(2).toLowerCase();
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


			int killCount = Integer.valueOf(m.group(1));
			killCountMap.put(eventType.toUpperCase(), killCount);
			return;
		}
		// TODO: Figure out better way to handle Barrows and Raids/Raids 2
		// Barrows KC
		if (chatMessage.startsWith("Your Barrows chest count is"))
		{
			Matcher n = NUMBER_PATTERN.matcher(chatMessage);
			if (n.find())
			{
				killCountMap.put("BARROWS", Integer.valueOf(n.group()));
				return;
			}
		}

		// Raids KC
		if (chatMessage.startsWith("Your completed Chambers of Xeric count is"))
		{
			Matcher n = NUMBER_PATTERN.matcher(chatMessage);
			if (n.find())
			{
				killCountMap.put("RAIDS", Integer.valueOf(n.group()));
				return;
			}
		}
		// Raids KC
		if (chatMessage.startsWith("Your completed Theatre of Blood count is"))
		{
			Matcher n = NUMBER_PATTERN.matcher(chatMessage);
			if (n.find())
			{
				killCountMap.put("THEATRE OF BLOOD", Integer.valueOf(n.group()));
				return;
			}
		}
		// Handle all other boss
		Matcher boss = BOSS_NAME_NUMBER_PATTERN.matcher(chatMessage);
		if (boss.find())
		{
			String bossName = boss.group(1);
			int killCount = Integer.valueOf(boss.group(2));
			killCountMap.put(bossName.toUpperCase(), killCount);
		}

		if (PET_MESSAGES.stream().anyMatch(chatMessage::contains))
		{
			gotPet = true;
		}

		if (chatMessage.equals(CHEST_LOOTED_MESSAGE))
		{
			final int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();
			if (!CHEST_EVENT_TYPES.containsKey(regionID))
			{
				return;
			}

			eventType = CHEST_EVENT_TYPES.get(regionID);

			takeInventorySnapshot();

			Matcher n = NUMBER_PATTERN.matcher(chatMessage);
			if (n.find())
			{
				killCountMap.put(eventType, Integer.valueOf(n.group()));
			}
		}

		if (chatMessage.startsWith(HERBIBOAR_LOOTED_MESSAGE))
		{
			eventType = HERBIBOR_EVENT;
			takeInventorySnapshot();

			Matcher n = NUMBER_PATTERN.matcher(chatMessage);

			if (n.find())
			{
				killCountMap.put(HERBIBOR_EVENT, Integer.valueOf(n.group()));
			}
		}
	}

	private void onItemContainerChanged(ItemContainerChanged event)
	{
		if (eventType != null && (CHEST_EVENT_TYPES.containsValue(eventType) || HERBIBOR_EVENT.equals(eventType)))
		{
			if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
			{
				return;
			}

			processInventoryLoot(eventType, event.getItemContainer());
			eventType = null;
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

	private void processInventoryLoot(String eventType, ItemContainer inventoryContainer)
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

			final LootTrackerItemEntry[] entries = buildEntries(items);

			LootRecordCustom rec = new LootRecordCustom(-1, eventType, -1, killCountMap.getOrDefault(eventType, -1), Arrays.asList(entries));
			addLog(eventType, rec);

			inventorySnapshot = null;
		}
	}

	private LootTrackerItemEntry[] buildEntries(final Collection<ItemStack> itemStacks)
	{
		return itemStacks.stream().map(itemStack ->
		{
			final ItemDefinition itemComposition = itemManager.getItemDefinition(itemStack.getId());
			final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemStack.getId();
			final long price = itemManager.getItemPrice(realItemId);
			final long haPrice = itemManager.getAlchValue(realItemId);

			return new LootTrackerItemEntry(
				itemComposition.getName(),
				itemStack.getId(),
				itemStack.getQuantity(),
				price,
				haPrice,
				itemComposition.isStackable());
		}).toArray(LootTrackerItemEntry[]::new);
	}

	public Collection<LootRecordCustom> getData()
	{
		return lootRecordMultimap.values();
	}

	public Collection<LootRecordCustom> getDataByName(String name)
	{
		return lootRecordMultimap.get(name);
	}

	private void refreshData()
	{
		// Pull data from files
		lootRecordMultimap.clear();
		Collection<LootRecordCustom> recs = writer.loadAllLootTrackerRecords();
		for (LootRecordCustom r : recs)
		{
			lootRecordMultimap.put(r.getName(), r);
		}
	}

	public void refreshDataByName(String name)
	{
		lootRecordMultimap.removeAll(name);
		Collection<LootRecordCustom> recs = writer.loadLootTrackerRecords(name);
		lootRecordMultimap.putAll(name, recs);
	}

	public void clearStoredDataByName(String name)
	{
		lootRecordMultimap.removeAll(name);
		writer.deleteLootTrackerRecords(name);
	}

	public Set<String> getNames()
	{
		return new TreeSet<>(lootRecordMultimap.keySet());
	}

	// Pet Handling
	private ItemStack handlePet(String name)
	{
		gotPet = false;

		int petID = getPetId(name);
		if (petID == -1)
		{
			return null;
		}

		return new ItemStack(petID, 1, client.getLocalPlayer().getLocalLocation());
	}

	private int getPetId(String name)
	{
		Pet pet = Pet.getByBossName(name);
		if (pet != null)
		{
			return pet.getPetID();
		}
		return -1;
	}

	// Handles adding the unsired loot to the tracker
	private void receivedUnsiredLoot(int itemID)
	{
		clientThread.invokeLater(() ->
		{
			Collection<LootRecordCustom> data = getDataByName("Abyssal sire");
			ItemDefinition c = itemManager.getItemDefinition(itemID);
			LootTrackerItemEntry itemEntry = new LootTrackerItemEntry(c.getName(), itemID, 1, 0, 0, false);

			log.debug("Received Unsired item: {}", c.getName());

			// Don't have data for sire, create a new record with just this data.
			if (data == null)
			{
				log.debug("No previous Abyssal sire loot, creating new loot record");
				LootRecordCustom r = new LootRecordCustom(NpcID.ABYSSAL_SIRE, "Abyssal sire", 350, -1, Collections.singletonList(itemEntry));
				writer.addLootTrackerRecord(r);
				return;
			}

			log.debug("Adding drop to last abyssal sire loot record");
			// Add data to last kill count
			List<LootRecordCustom> items = new ArrayList<>(data);
			LootRecordCustom r = items.get(items.size() - 1);
			r.addDropEntry(itemEntry);
			writer.writeLootTrackerFile("Abyssal sire", items);
		});
	}

	private boolean unsiredThreadRunning = false;
	private int unsiredThreadTries = 0;

	// Handles checking for unsired loot reclamation
	private void checkUnsiredWidget()
	{
		if (unsiredThreadRunning)
		{
			return;
		}
		unsiredThreadRunning = true;
		unsiredThreadTries = 0;

		clientThread.invokeLater(() ->
		{
			log.debug("Checking for text widget change...");
			Widget text = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
			if ("the font consumes the unsired and returns you a reward.".equals(text.getText().toLowerCase()))
			{
				Widget sprite = client.getWidget(WidgetInfo.DIALOG_SPRITE);
				log.debug("Sprite: {}", sprite);
				log.debug("Sprite Item ID: {}", sprite.getItemId());
				log.debug("Sprite Model ID: {}", sprite.getModelId());
				receivedUnsiredLoot(sprite.getItemId());
				unsiredThreadRunning = false;
				return true;
			}
			else
			{
				if (unsiredThreadTries >= 10)
				{
					log.debug("Tried 10 times, canceling...");
					return true;
				}
				unsiredThreadTries++;
				return false;
			}
		});
	}

	private void onGameStateChanged(GameStateChanged c)
	{
		if (c.getGameState().equals(GameState.LOGGED_IN))
		{
			clientThread.invokeLater(() ->
			{
				switch (client.getGameState())
				{
					case LOGGED_IN:
						break;
					case LOGGING_IN:
					case LOADING:
						return false;
					default:
						// Quit running if any other state
						return true;
				}

				String name = client.getLocalPlayer().getName();
				if (name != null)
				{
					writer.setPlayerUsername(name);
					return true;
				}
				else
				{
					return false;
				}
			});
		}
	}
}