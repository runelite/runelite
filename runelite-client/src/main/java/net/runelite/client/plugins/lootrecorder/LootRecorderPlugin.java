/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.lootrecorder;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.SwingUtilities;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemLayer;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Node;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.ActorDespawned;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.util.Text;
import net.runelite.http.api.RuneLiteAPI;

import static net.runelite.client.RuneLite.LOOTS_DIR;

@PluginDescriptor(
	name = "Loot Recorder"
)

@Slf4j
public class LootRecorderPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private LootRecorderConfig lootRecorderConfig;

	@Inject
	private Notifier notifier;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private PluginToolbar pluginToolbar;

	private File playerFolder;
	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");
	private static final Pattern BOSS_NAME_PATTERN = Pattern.compile("Your (.*) kill count is:");

	private LootRecorderPanel panel;
	private NavigationButton navButton;

	// String = NPC Name (uppercase) Boolean = Config Setting value
	private Map<String, Boolean> recordingMap = new HashMap<>();
	// String = Boss Name
	private Map<String, ArrayList<LootEntry>> lootMap = new HashMap<>();
	private Map<String, Integer> killcountMap = new HashMap<>();
	private Map<String, String> filenameMap = new HashMap<>();

	@Provides
	LootRecorderConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LootRecorderConfig.class);
	}

	@Override
	protected void startUp()
	{
		if (lootRecorderConfig.showLootTotals())
		{
			// Waits 2 seconds, helps ensure itemManager is loaded
			// Client cache loading is async, plugins can be loaded before it is finished
			ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
			scheduler.schedule(() -> SwingUtilities.invokeLater(this::createPanel), 2, TimeUnit.SECONDS);
		}
		createMaps();
	}

	// Separated from startUp for toggling panel from settings
	void createPanel()
	{
		panel = new LootRecorderPanel(itemManager, this);
		// Panel Icon (Looting Bag)
		BufferedImage icon = null;
		synchronized (ImageIO.class)
		{
			try
			{
				icon = ImageIO.read(getClass().getResourceAsStream("panel_icon.png"));
			}
			catch (IOException e)
			{
				log.warn("Error getting panel icon:", e);
			}
		}

		navButton = NavigationButton.builder()
			.tooltip("Loot Recorder")
			.icon(icon)
			.panel(panel)
			.priority(10)
			.build();

		pluginToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		removePanel();
	}

	private void removePanel()
	{
		pluginToolbar.removeNavigation(navButton);
	}

	// Checks for loot that is rewarded via interfaces
	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		// Barrows Chests
		if (event.getGroupId() == WidgetID.BARROWS_REWARD_GROUP_ID && lootRecorderConfig.recordBarrowsChest())
		{
			ItemContainer rewardContainer = client.getItemContainer(InventoryID.BARROWS_REWARD);
			int kc = killcountMap.get("BARROWS");
			LootEntry entry = createLootEntry(kc, rewardContainer);
			addLootEntry("Barrows", entry);
			lootRecordedAlert("Barrows Chest added to log.");
		}

		// Raids Chest
		if (event.getGroupId() == WidgetID.RAIDS_REWARD_GROUP_ID && lootRecorderConfig.recordRaidsChest())
		{
			int kc = killcountMap.get("RAIDS");
			ItemContainer rewardContainer = client.getItemContainer(InventoryID.valueOf("RAIDS_REWARD_GROUP_ID")); // TODO: Update to RAIDS REWARD ONCE implemented
			LootEntry entry = createLootEntry(kc, rewardContainer);
			addLootEntry("Raids", entry);
			lootRecordedAlert("Raids Chest Loot added to log.");
		}
	}

	// Variables for getting items from NPC death
	private String deathName;
	private String lastBossKilled;
	private int deathSize;
	private WorldPoint deathSpot;
	private Boolean watching = false;
	private Map<Integer, Integer> items;

	@Subscribe
	public void onActorDeath(ActorDeath death)
	{
		Actor actor = death.getActor();
		if (actor.getInteracting() == null)
			return;
		if (actor.getInteracting().getName().equals(client.getLocalPlayer().getName()))
		{
			// Are kills for this Boss being recorded?
			Boolean flag = recordingMap.get(actor.getName().toUpperCase());
			if (!flag)
				return;

			// Yes they are
			NPC npc = (NPC) actor;
			NPCComposition comp = npc.getComposition();
			deathSize = comp.getSize();
			deathSpot = actor.getWorldLocation();
			deathName = actor.getName();
			Tile tile = getLootTile(client.getRegion(), actor.getLocalLocation(), deathSize, client.getPlane());
			ItemLayer layer = tile.getItemLayer();
			items = createItemMap(layer);
			watching = true;
			// Used for checking for pets in the future
			lastBossKilled = actor.getName();
		}
	}

	@Subscribe
	public void onActorDespawn(ActorDespawned despawned)
	{
		if (watching)
		{
			Actor npc = despawned.getActor();
			if (npc.getName().equals(deathName) && npc.getWorldLocation().equals(deathSpot))
			{
				watching = false;
				ArrayList<DropEntry> drops = createDropEntryArray(npc.getLocalLocation());
				deathName = null;
				deathSpot = null;
				deathSize = -1;
				items = null;
				AddBossLootEntry(npc.getName(), drops);
			}
		}
	}

	void AddBossLootEntry(String bossName, ArrayList<DropEntry> drops)
	{
		int KC = killcountMap.get(bossName.toUpperCase());
		LootEntry newEntry = new LootEntry(KC, drops);
		addLootEntry(bossName, newEntry);
		lootRecordedAlert(bossName + " kill added to log.");
	}

	private Tile getLootTile(Region region, LocalPoint local, int npcSize, int plane)
	{
		Tile[][][] tiles = region.getTiles();
		int x = local.getRegionX();
		int y = local.getRegionY();
		if (npcSize > 1)
		{
			x = x - (npcSize / 2);
			y = y - (npcSize / 2);
		}
		Tile tile = tiles[plane][x][y];

		return tile;
	}

	Map<Integer, Integer> createItemMap(ItemLayer layer)
	{
		Map<Integer, Integer> map = new HashMap<>();
		if (layer == null)
			return map;

		Node current = layer.getBottom();
		while (current instanceof Item)
		{
			final Item item = (Item) current;

			current = current.getNext();
			Integer ex = map.computeIfPresent(item.getId(), (k, v) -> v + item.getQuantity());
			if (ex == null)
			{
				map.computeIfAbsent(item.getId(), e -> item.getQuantity());
			}
		}

		return map;
	}

	ArrayList<DropEntry> createDropEntryArray(LocalPoint local)
	{
		Tile tile = getLootTile(client.getRegion(), local, deathSize, client.getPlane());
		ItemLayer layer = tile.getItemLayer();

		// Create a map of the Current items
		Map<Integer, Integer> newItems = createItemMap(layer);

		// Loop Through the new items and add them to the drops array list
		ArrayList<DropEntry> drops = new ArrayList<DropEntry>();
		newItems.forEach((id, amount) ->
				{
					// If some of this item already existed remove the existing amount
					Integer existing = items.get(id);
					if (existing != null)
					{
						amount = amount - existing;
					}
					if (amount == 0)
						return;
					// Add new entry
					drops.add(new DropEntry(id, amount));
				}

		);
		return drops;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		// Only update if our plugin config was changed
		if (!event.getGroup().equals("lootrecorder"))
		{
			return;
		}

		switch (event.getKey())
		{
			case "recordBarrowsChest":
				ToggleTab("Barrows", lootRecorderConfig.recordBarrowsChest());
				return;
			case "recordRaidsChest":
				ToggleTab("Raids", lootRecorderConfig.recordRaidsChest());
				return;
			case "recordZulrahKills":
				ToggleTab("Zulrah", lootRecorderConfig.recordZulrahKills());
				return;
			case "recordVorkathKills":
				ToggleTab("Vorkath", lootRecorderConfig.recordVorkathKills());
				return;
			case "recordArmadylKills":
				ToggleTab("Armadyl", lootRecorderConfig.recordArmadylKills());
				return;
			case "recordBandosKills":
				ToggleTab("Bandos", lootRecorderConfig.recordBandosKills());
				return;
			case "recordSaradominKills":
				ToggleTab("Saradomin", lootRecorderConfig.recordSaradominKills());
				return;
			case "recordZammyKills":
				ToggleTab("Zammy", lootRecorderConfig.recordZammyKills());
				return;
			case "showLootTotals":
				loadAllData();
				if (lootRecorderConfig.showLootTotals())
				{
					createPanel();
				}
				else
				{
					removePanel();
				}
				return;
			default:
				break;
		}
	}

	private void lootRecordedAlert(String message)
	{
		message = "Loot Recorder: " + message;
		if (lootRecorderConfig.showChatMessages())
		{
			final ChatMessageBuilder chatMessage = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append(message)
					.append(ChatColorType.NORMAL);

			chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.EXAMINE_ITEM)
					.runeLiteFormattedMessage(chatMessage.build())
					.build());
		}

		if (lootRecorderConfig.showTrayAlerts())
		{
			notifier.notify(message);
		}
	}

	private void ToggleTab(String tabName, Boolean status)
	{
		// Remove panel tab if showing panel
		if (lootRecorderConfig.showLootTotals())
		{
			panel.toggleTab(tabName, status);
		}
		// Update tab map
		String bossName = Tab.getByName(tabName).getBossName().toUpperCase();
		recordingMap.put(bossName, status);
	}

	void loadTabData(Tab tab)
	{
		loadLootEntries(tab);
	}

	void loadAllData()
	{
		for (Tab tab : Tab.values())
		{
			if (isBeingRecorded(tab.getName()))
			{
				loadLootEntries(tab);
			}
		}
	}

	// Update KC variable on chat message event
	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String chatMessage = event.getMessage();

		// Barrows KC
		if (chatMessage.startsWith("Your Barrows chest count is"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				killcountMap.put("BARROWS", Integer.valueOf(m.group()));
				return;
			}
		}

		// Raids KC
		if (chatMessage.startsWith("Your completed Chambers of Xeric count is:"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				killcountMap.put("RAIDS", Integer.valueOf(m.group()));
				return;
			}
		}

		// Handle all other boss
		Matcher boss = BOSS_NAME_PATTERN.matcher(Text.removeTags(chatMessage));
		if (boss.find())
		{
			String bossName = boss.group(1);
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (!m.find())
				return;
			int KC = Integer.valueOf(m.group());
			updateBossKillcount(bossName, KC);
		}
	}

	// Create Loot Entry for ItemContainer
	private LootEntry createLootEntry(Integer kill_count, ItemContainer container)
	{
		ArrayList<DropEntry> drops = new ArrayList<>();
		for (Item item : container.getItems())
		{
			int id = item.getId();
			int amount = item.getQuantity();
			drops.add(new DropEntry(id, amount));
		}
		return new LootEntry(kill_count, drops);
	}

	// Add Loot Entry to the necessary file
	private void addLootEntry(String bossName, LootEntry entry)
	{
		// Update data inside plugin
		ArrayList<LootEntry> loots = lootMap.get(bossName.toUpperCase());
		loots.add(entry);
		lootMap.put(bossName.toUpperCase(), loots);
		// Convert entry to JSON
		String dataAsString = RuneLiteAPI.GSON.toJson(entry);
		// Grab file by username or loots directory if not logged in
		updatePlayerFolder();
		String fileName = filenameMap.get(bossName.toUpperCase());
		// Open File and append data
		File lootFile = new File(playerFolder, fileName);
		try
		{
			BufferedWriter file = new BufferedWriter(new FileWriter(String.valueOf(lootFile), true));
			file.append(dataAsString);
			file.newLine();
			file.close();
		}
		catch (IOException ioe)
		{
			log.warn("Error witting loot data in file.", ioe);
		}
		// Update tab if being displayed;
		Tab tab = Tab.getByBossName(bossName);
		if (isBeingRecorded(tab.getName()))
		{
			panel.updateTab(tab.getName());
		}
	}

	// Receive Loot from the necessary file
	private synchronized void loadLootEntries(Tab tab)
	{
		ArrayList<LootEntry> data = new ArrayList<>();
		// Grab file by username or loots directory if not logged in
		updatePlayerFolder();
		String fileName = filenameMap.get(tab.getBossName().toUpperCase());

		// Open File and read line by line
		File file = new File(playerFolder, fileName);
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				// Convert JSON to LootEntry and add to data ArrayList
				if (line.length() > 0)
				{
					LootEntry entry = RuneLiteAPI.GSON.fromJson(line, LootEntry.class);
					data.add(entry);
				}
			}

			// Update Loot Map with new data
			lootMap.put(tab.getBossName().toUpperCase(), data);
			// Update Killcount map with latest killcount value for display purposes
			int killcount = data.get(data.size() - 1).getKill_count();
			killcountMap.put(tab.getBossName().toUpperCase(), killcount);
		}
		catch (FileNotFoundException e)
		{
			log.warn("File not found: " + fileName);
		}
		catch (IOException e)
		{
			log.warn("Unexpected error", e);
		}
	}

	void updateBossKillcount(String bossName, int KC)
	{
		log.info("Boss " + bossName + ", Kill Count: " + KC);
		//Integer currentKC = killcountMap.get(bossName.toUpperCase());
		//currentKC++;
		killcountMap.put(bossName.toUpperCase(), KC);
	}

	// Returns stored data by tab name
	ArrayList<LootEntry> getData(String type)
	{
		// Loot Entries are stored on lootMap by boss name (upper cased)
		String name = Tab.getByName(type).getBossName().toUpperCase();
		return lootMap.get(name);
	}

	// Handles if panel should be shown by Tab Name
	Boolean isBeingRecorded(String tabName)
	{
		switch (tabName.toUpperCase())
		{
			case "BARROWS":
				return lootRecorderConfig.recordBarrowsChest();
			case "RAIDS":
				return lootRecorderConfig.recordRaidsChest();
			case "ZULRAH":
				return lootRecorderConfig.recordZulrahKills();
			case "VORKATH":
				return lootRecorderConfig.recordVorkathKills();
			// God Wars Dungeon
			case "ARMADYL":
				return lootRecorderConfig.recordArmadylKills();
			case "BANDOS":
				return lootRecorderConfig.recordBandosKills();
			case "SARADOMIN":
				return lootRecorderConfig.recordSaradominKills();
			case "ZAMMY":
				return lootRecorderConfig.recordZammyKills();
			default:
				return false;
		}
	}

	void createMaps()
	{
		Map<String, Boolean> mapRecording = new HashMap<>();
		Map<String, ArrayList<LootEntry>> mapLoot = new HashMap<>();
		Map<String, Integer> mapKillcount = new HashMap<>();
		Map<String, String> mapFilename = new HashMap<>();
		for (Tab tab : Tab.values())
		{
			String bossName = tab.getBossName().toUpperCase();
			// Is Boss being recorded?
			mapRecording.put(bossName, isBeingRecorded(tab.getName()));
			// Loot Entries by Tab Name
			ArrayList<LootEntry> array = new ArrayList<LootEntry>();
			mapLoot.put(bossName, array);
			// Kill Count
			Integer killcount = 0;
			mapKillcount.put(bossName, killcount);
			// Filenames
			String filename = tab.getName().replace("( |'|\\.)", "").toLowerCase() + ".log";
			mapFilename.put(bossName, filename);
		}
		recordingMap = mapRecording;
		lootMap = mapLoot;
		killcountMap = mapKillcount;
		filenameMap = mapFilename;
	}

	void updatePlayerFolder()
	{
		if (client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null)
		{
			playerFolder = new File(LOOTS_DIR, client.getLocalPlayer().getName());
		}
		else
		{
			playerFolder = LOOTS_DIR;
		}
	}
}