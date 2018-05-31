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
package net.runelite.client.plugins.bosslogger;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;

import java.awt.Color;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.SwingUtilities;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.ItemLayer;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Node;
import net.runelite.api.NpcID;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ActorDespawned;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemLayerChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
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
	name = "Boss Logger"
)

@Slf4j
public class BossLoggerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private BossLoggerConfig bossLoggerConfig;

	@Inject
	private Notifier notifier;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private PluginToolbar pluginToolbar;

	private File playerFolder;	// Where we are storing files
	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");
	private static final Pattern BOSS_NAME_PATTERN = Pattern.compile("Your (.*) kill count is:");
	private static final Pattern PET_RECEIVED_PATTERN = Pattern.compile("You have a funny feeling like ");
	private static final Pattern PET_RECEIVED_INVENTORY_PATTERN = Pattern.compile("You feel something weird sneaking into your backpack.");
	private String messageColor = ""; // in-game chat message color

	private BossLoggerPanel panel;
	private NavigationButton navButton;

	// Mapping Variables
	private Map<String, Boolean> recordingMap = new HashMap<>(); 			// Store config recording value by tab boss name
	private Map<String, ArrayList<LootEntry>> lootMap = new HashMap<>();	// Store loot entries by boss name
	private Map<String, Integer> killcountMap = new HashMap<>(); 			// Store boss kill count by name
	private Map<String, String> filenameMap = new HashMap<>(); 				// Stores filename for each boss name

	// Loot Finding Variables
	private Set<Tile> changedItemLayerTiles = new HashSet<Tile>();				// Stores tiles that have had ItemLayer changes
	private WorldPoint[] deathLocations;										// Stores NPC Death Worldpoints
	private Map<WorldPoint, Map<Integer, Integer>> itemArray = new HashMap<>();	// Stores item map for a specific WorldPoint
	private Map<Actor, Actor> actors = new HashMap<>();							// Stores Actors we've interacted with to check for their deaths

	// Variables for handling NPC death
	private String deathName;				// NPC Name
	private String lastBossKilled;			// NPC Name, saved for potential pet logging issues
	private int deathSize;					// NPC Size
	private int deathID;					// NPC ID
	private WorldPoint deathSpot;			// NPC Death WorldPoint
	private WorldPoint playerLocation;		// Players WorldPoint at time of NPC death animation
	private Boolean gotPet = false;			// Got the pet chat message?

	// Watching flags (actor death/changed item layer)
	private Boolean watching = false;				// Watching for ActorDespawn?
	private Boolean watchingItemLayers = false;		// Watching for ItemLayerChanged?

	@Provides
	BossLoggerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BossLoggerConfig.class);
	}

	@Override
	protected void startUp()
	{
		if (bossLoggerConfig.showLootTotals())
		{
			// Waits 2 seconds, helps ensure itemManager is loaded
			// Client cache loading is async, plugins can be loaded before it is finished
			ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
			scheduler.schedule(() -> SwingUtilities.invokeLater(this::createPanel), 2, TimeUnit.SECONDS);
		}
		init();

		// Ensure Loot Directory has been created
		LOOTS_DIR.mkdir();
	}

	@Override
	protected void shutDown() throws Exception
	{
		removePanel();
	}

	// Check for loot that is rewarded via interfaces
	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		// Barrows Chests
		if (event.getGroupId() == WidgetID.BARROWS_REWARD_GROUP_ID && bossLoggerConfig.recordBarrowsChest())
		{
			ItemContainer rewardContainer = client.getItemContainer(InventoryID.REWARD_CHEST);
			if (rewardContainer == null)
			{
				BossLoggedAlert("Couldn't find Barrows Chest Loot");
				return;
			}
			int kc = killcountMap.get("BARROWS");
			LootEntry entry = createLootEntry(kc, rewardContainer);
			addLootEntry("Barrows", entry);
			BossLoggedAlert("Barrows Chest added to log.");
		}

		// Raids Chest
		if (event.getGroupId() == WidgetID.RAIDS_REWARD_GROUP_ID && bossLoggerConfig.recordRaidsChest())
		{
			ItemContainer rewardContainer = client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST);
			if (rewardContainer == null)
			{
				BossLoggedAlert("Couldn't find Raids Chest Loot");
				return;
			}
			int kc = killcountMap.get("RAIDS");
			LootEntry entry = createLootEntry(kc, rewardContainer);
			addLootEntry("Raids", entry);
			BossLoggedAlert("Raids Chest Loot added to log.");
		}


		// Received unsired loot?
		if (event.getGroupId() == WidgetID.DIALOG_SPRITE_GROUP_ID)
		{
			Widget sprite = client.getWidget(WidgetInfo.DIALOG_SPRITE);
			int itemID = sprite.getItemId();
			switch (itemID)
			{
				case ItemID.BLUDGEON_CLAW:
				case ItemID.BLUDGEON_SPINE:
				case ItemID.BLUDGEON_AXON:
				case ItemID.ABYSSAL_DAGGER:
				case ItemID.ABYSSAL_WHIP:
				case ItemID.ABYSSAL_ORPHAN:
				case ItemID.ABYSSAL_HEAD:
					break;
				default:
					return;
			}

			receivedUnsiredLoot(itemID);
		}
	}

	//
	// Recreate the `onActorDeath` event
	//

	@Subscribe
	public void onGameTick(GameTick event)
	{
		checkInteractingNpcs();
		checkDeadActors();
	}

	// Find the NPC the player is interacting with
	private void checkInteractingNpcs()
	{
		Actor interacting = client.getLocalPlayer().getInteracting();

		if (interacting instanceof NPC)
		{
			// Only add if the NPC is interacting us
			Actor target = interacting.getInteracting();
			if (target != null && target.getName().equals(client.getLocalPlayer().getName()))
			{

				String name = interacting.getName();
				Boolean flag = recordingMap.get(name.toUpperCase());
				// Special Cases
				if (name.equals("Dusk"))
				{
					flag = recordingMap.get("GROTESQUE GUARDIANS");
				}
				if (flag != null && flag)
				{
					actors.putIfAbsent(interacting, interacting);
				}
			}
		}
	}

	// Did any of the NPCs we interacted with die?
	private void checkDeadActors()
	{
		for (Map.Entry<Actor, Actor> entry : actors.entrySet())
		{
			Actor actor = entry.getKey();
			if (actor.getHealthRatio() == 0)
			{
				onActorDeath(actor);
				actors.remove(entry.getKey());
			}
		}
	}

	// Use to be a subscribe event but was removed on 5/27/2018. Recreated above.
	private void onActorDeath(Actor actor)
	{
		// Are kills for this Boss being recorded?
		Boolean flag = recordingMap.get(actor.getName().toUpperCase());
		// Grotesque Guardians Handling
		if (actor.getName().equals("Dusk"))
		{
			flag = recordingMap.get("GROTESQUE GUARDIANS");
		}
		// Can't find NPC in recording map or should not be recording the npc loot
		if (flag == null || !flag)
			return;

		// Yes they are
		NPC npc = (NPC) actor;
		NPCComposition comp = npc.getComposition();
		// Record Death info in global variables
		deathSize = comp.getSize();										// NPC Size
		deathSpot = actor.getWorldLocation();   						// Death Location
		playerLocation = client.getLocalPlayer().getWorldLocation(); 	// Player Location on NPC Death
		deathName = actor.getName();									// NPC Name
		deathID = npc.getId();											// NPC ID
		lastBossKilled = actor.getName();								// NPC Name (stored for pets)

		// Get possible death locations
		deathLocations = getExpectedLootPoints(npc, deathSpot);
		// Loop over each death location and store its current item contents
		for (WorldPoint point : deathLocations)
		{
			if (point != null)
			{
				Tile tile = getLootTile(point);
				Map<Integer, Integer> items = createItemMap(tile.getItemLayer());
				if (items.size() > 0)
					itemArray.put(point, items);
			}
		}

		// Start watching for NPC Despawn
		watching = true;
		if (deathName.equals("Zulrah"))
			watchingItemLayers = true;
	}

	@Subscribe
	public void onActorDespawn(ActorDespawned despawned)
	{
		Actor actor = actors.get(despawned.getActor());
		if (actor != null)
		{
			actors.remove(actor);
		}

		if (watching)
		{
			Actor npc = despawned.getActor();
			if (npc.getName().equals(deathName) && npc.getWorldLocation().equals(deathSpot))
			{
				// Correct Boss Despawned
				watching = false;
				// Find the drops from the correct tile and return them in the correct format
				ArrayList<DropEntry> drops = createDropEntryArray((NPC) npc);
				// Specific use case(s)
				String npcName = npc.getName();
				if (npcName.equals("Dusk"))
					npcName = "Grotesque Guardians";

				if (drops != null)
				{
					// Add LootEntry by Boss Name
					AddBossLootEntry(npcName, drops);
				}
				else
				{
					log.debug("Error creating DropEntry array");
				}

				// Reset Variables
				deathSize = -1;			// NPC Size
				deathSpot = null;		// NPC Death WP
				playerLocation = null;	// Player WP on NPC Death
				deathName = null;		// NPC Name
				deathID = -1;			// NPC ID

				// Clear maps used for creating the DropEntry array
				changedItemLayerTiles.clear();	// Changed Tiles
				deathLocations = null;			// Possible Loot Tiles
				itemArray.clear();				// Items on Possible Loot Tiles
			}
		}
	}

	@Subscribe
	public void onItemLayerChanged(ItemLayerChanged event)
	{
		if (watchingItemLayers)
		{
			changedItemLayerTiles.add(event.getTile());
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		// Only update if our plugin config was changed
		if (!event.getGroup().equals("bosslogger"))
		{
			return;
		}

		handleConfigChanged(event.getKey());
	}

	// Searches chat messages for kill count value or pet drop
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
			killcountMap.put(bossName.toUpperCase(), KC);
		}

		// Pet Drop
		Matcher pet1 = PET_RECEIVED_PATTERN.matcher(Text.removeTags(chatMessage));
		Matcher pet2 = PET_RECEIVED_INVENTORY_PATTERN.matcher(Text.removeTags(chatMessage));
		if (pet1.find() || pet2.find())
		{
			gotPet = true;
		}
	}

	private void resetStoredData()
	{
		for (Tab tab : Tab.values())
		{
			lootMap.put(tab.getBossName().toUpperCase(), new ArrayList<>());
		}
	}

	private void updateTabData()
	{
		// Do nothing is panel isn't enabled
		if (!bossLoggerConfig.showLootTotals())
		{
			return;
		}

		for (Tab tab : Tab.values())
		{
			// Only update tabs if the tabs are being shown.
			if (isBeingRecorded(tab.getName()))
			{
				panel.updateTab(tab.getName());
			}
		}
	}

	private void init()
	{
		// Create maps for easy management of certain features
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
			// Filenames. Removes all spaces, periods, and apostrophes
			String filename = tab.getName().replaceAll("( |'|\\.)", "").toLowerCase() + ".log";
			mapFilename.put(bossName, filename);
		}
		recordingMap = mapRecording;
		lootMap = mapLoot;
		killcountMap = mapKillcount;
		filenameMap = mapFilename;

		// Ensure we are using the requested message coloring for in-game messages
		updateMessageColor();
	}

	//
	// Panel Functions
	//

	// Separated from startUp for toggling panel from settings
	private void createPanel()
	{
		panel = new BossLoggerPanel(itemManager, this);
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
				.tooltip("Boss Logger")
				.icon(icon)
				.panel(panel)
				.priority(10)
				.build();

		pluginToolbar.addNavigation(navButton);
	}

	private void removePanel()
	{
		pluginToolbar.removeNavigation(navButton);
	}


	// Toggles visibility of tab in side panel
	private void ToggleTab(String tabName, Boolean status)
	{
		// Remove panel tab if showing panel
		if (bossLoggerConfig.showLootTotals())
		{
			panel.toggleTab(tabName, status);
		}
		// Update tab map
		String bossName = Tab.getByName(tabName).getBossName().toUpperCase();
		recordingMap.put(bossName, status);
	}



	//
	// General Functionality functions
	//

	// Will use the main loots folder if your ingame username is not available
	private void updatePlayerFolder()
	{
		String old = "";
		if (playerFolder != null)
		{
			old = playerFolder.toString();
		}

		if (client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null)
		{
			playerFolder = new File(LOOTS_DIR, client.getLocalPlayer().getName());
			// Ensure player folder is made
			playerFolder.mkdir();
		}
		else
		{
			playerFolder = LOOTS_DIR;
		}

		// Reset Stored and UI Data on change of data directory
		if (!playerFolder.toString().equals(old))
		{
			resetStoredData();
			updateTabData();
		}
	}

	// All alerts from this plugin should use this function
	private void BossLoggedAlert(String message)
	{
		message = "Boss Logger: " + message;
		if (bossLoggerConfig.showChatMessages())
		{
			final ChatMessageBuilder chatMessage = new ChatMessageBuilder()
					.append("<col=" + messageColor + ">")
					.append(message)
					.append("</col>");

			chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.EXAMINE_ITEM)
					.runeLiteFormattedMessage(chatMessage.build())
					.build());
		}

		if (bossLoggerConfig.showTrayAlerts())
		{
			notifier.notify(message);
		}
	}

	void loadTabData(Tab tab)
	{
		loadLootEntries(tab);
	}

	// Load data for all bosses being recorded
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

	// Returns stored data by tab name
	ArrayList<LootEntry> getData(String type)
	{
		// Loot Entries are stored on lootMap by boss name (upper cased)
		String name = Tab.getByName(type).getBossName().toUpperCase();
		return lootMap.get(name);
	}

	//
	// LootEntry helper functions
	//

	// Adds the data to the correct boss log file
	private void AddBossLootEntry(String bossName, ArrayList<DropEntry> drops)
	{
		int KC = killcountMap.get(bossName.toUpperCase());
		LootEntry newEntry = new LootEntry(KC, drops);
		addLootEntry(bossName, newEntry);
		BossLoggedAlert(bossName + " kill added to log.");
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
			log.warn("Error writing loot data in file.", ioe);
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
		// Grab target directory (username or loots directory if not logged in)
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
			// Update Killcount map with latest value
			if (data.size() > 0)
			{
				int killcount = data.get(data.size() - 1).getKill_count();
				killcountMap.put(tab.getBossName().toUpperCase(), killcount);
			}
		}
		catch (FileNotFoundException e)
		{
			log.debug("File not found: " + fileName);
		}
		catch (IOException e)
		{
			log.warn("Unexpected error", e);
		}
	}

	// Add Loot Entry to the necessary file
	private void addDropToLastLootEntry(String bossName, DropEntry newDrop)
	{
		// Update data inside plugin
		ArrayList<LootEntry> loots = lootMap.get(bossName.toUpperCase());
		LootEntry entry = loots.get(loots.size() - 1);
		entry.drops.add(newDrop);
		// Ensure updates are applied, may not be necessary
		loots.add(loots.size() - 1, entry);
		lootMap.put(bossName.toUpperCase(), loots);

		// Grab file by username or loots directory if not logged in
		updatePlayerFolder();
		String fileName = filenameMap.get(bossName.toUpperCase());

		// Rewrite the log file (to update the last loot entry)
		File lootFile = new File(playerFolder, fileName);
		try
		{
			BufferedWriter file = new BufferedWriter(new FileWriter(String.valueOf(lootFile), false));
			for ( LootEntry lootEntry : loots)
			{
				// Convert entry to JSON
				String dataAsString = RuneLiteAPI.GSON.toJson(lootEntry);
				file.append(dataAsString);
				file.newLine();
			}
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

	//
	// Loot Helping Functions
	//

	// Taken from Wooxs droplogger plugin
	private List<DropEntry> getGroundItems(Tile tile)
	{
		List<Item> items = tile.getGroundItems();
		if (items == null)
		{
			return null;
		}
		return items.stream()
				.map(x -> new DropEntry(x.getId(), x.getQuantity()))
				.collect(Collectors.toList());
	}

	// Taken from Wooxs droplogger plugin, should be added to ItemManager in the future.
	private int getUnnotedItemId(int itemId)
	{
		ItemComposition comp = itemManager.getItemComposition(itemId);
		if (comp.getNote() == -1)
		{
			return itemId;
		}
		return comp.getLinkedNoteId();
	}

	// Upon cleaning an Unsired add the item to the previous LootEntry
	private void receivedUnsiredLoot(int itemID)
	{
		DropEntry drop = new DropEntry(itemID, 1);
		// Update the last drop
		addDropToLastLootEntry("Abyssal Sire", drop);
	}

	// Credit to @WooxSolo (www.github.com/wooxsolo), ripped and modified slightly from `droplogger` plugin
	private WorldPoint[] getExpectedLootPoints(NPC npc, WorldPoint location)
	{
		WorldPoint location2 = null;
		WorldPoint location3 = null;
		// Some bosses drop their loot in specific locations
		switch (deathID)
		{
			// Kraken spawns loot on you
			case NpcID.KRAKEN:
			case NpcID.KRAKEN_6640:
			case NpcID.KRAKEN_6656:
				// Location is determined at start of death animation
				location = playerLocation;
				break;
			case NpcID.DUSK:
			case NpcID.DUSK_7851:
			case NpcID.DUSK_7854:
			case NpcID.DUSK_7855:
			case NpcID.DUSK_7882:
			case NpcID.DUSK_7883:
			case NpcID.DUSK_7886:
			case NpcID.DUSK_7887:
			case NpcID.DUSK_7888:
			case NpcID.DUSK_7889:
				location = new WorldPoint(location.getX() + 3, location.getY() + 3, location.getPlane());
				break;
			case NpcID.ZULRAH:
			case NpcID.ZULRAH_2043:
			case NpcID.ZULRAH_2044:
				// Stop tracking which ItemLayers have been updated.
				watchingItemLayers = false;
				// The drop appears on the tile where zulrah scales appeared
				WorldPoint loc = changedItemLayerTiles.stream()
						.filter(x ->
						{
							List<DropEntry> groundItems = getGroundItems(x);
							if (groundItems != null)
							{
								return groundItems.stream().anyMatch(y -> y.getItem_id() == ItemID.ZULRAHS_SCALES);
							}
							return false;
						})
						.map(Tile::getWorldLocation)
						// If player drops some zulrah scales themselves on the same tick,
						// the ones that appeared further away will be chosen instead.
						.sorted((x, y) -> y.distanceTo(playerLocation) - x.distanceTo(playerLocation))
						.findFirst().orElse(null);
				// Couldn't find loot
				if (loc == null)
				{
					break;
				}
				// Found tile
				location = loc;
				break;
			case NpcID.CORPOREAL_BEAST:
				location = new WorldPoint(location.getX() + 1, location.getY() + 1, location.getPlane());
				break;
			case NpcID.ABYSSAL_SIRE:
			case NpcID.ABYSSAL_SIRE_5887:
			case NpcID.ABYSSAL_SIRE_5888:
			case NpcID.ABYSSAL_SIRE_5889:
			case NpcID.ABYSSAL_SIRE_5890:
			case NpcID.ABYSSAL_SIRE_5891:
			case NpcID.ABYSSAL_SIRE_5908:
				location = new WorldPoint(npc.getWorldLocation().getX() + 2, npc.getWorldLocation().getY() + 2, npc.getWorldLocation().getPlane());
				break;
			case NpcID.VORKATH:
			case NpcID.VORKATH_8058:
			case NpcID.VORKATH_8059:
			case NpcID.VORKATH_8060:
			case NpcID.VORKATH_8061:
				int x = location.getX() + 3;
				int y = location.getY() + 3;
				if (playerLocation.getX() < x)
				{
					x = x - 4;
				}
				else if (playerLocation.getX() > x)
				{
					x = x + 4;
				}
				if (playerLocation.getY() < y)
				{
					y = y - 4;
				}
				else if (playerLocation.getY() > y)
				{
					y = y + 4;
				}
				location = new WorldPoint(x, y, location.getPlane());
				break;
			default:
				if (deathSize >= 3)
				{
					// Large NPCs (mostly bosses) drop their loot in the middle of them rather than on the southwestern spot
					// Set location2 to be checked for loot
					location2 = new WorldPoint(location.getX() + (deathSize - 1) / 2, location.getY() + (deathSize - 1) / 2, location.getPlane());
					// May be completely unnecessary but i think removing 1 from deathSize can mess up certain NPCs
					location3 = new WorldPoint( location.getX() - (deathSize / 2), location.getY() - (deathSize / 2), location.getPlane());
				}
		}
		WorldPoint[] points = new WorldPoint[]{
				location,
				location2,
				location3
		};
		return points;
	}

	// Checks which WorldPoint has had item changes
	private WorldPoint getCorrectWorldPoint(WorldPoint[] points)
	{
		Tile tile;
		for (WorldPoint location : points)
		{
			if (location == null)
			{
				continue;
			}

			tile = getLootTile(location);
			if (tile != null)
			{
				// Loops over layer.getBottom() and stores K,V as ItemID,ItemAmount
				Map<Integer, Integer> itemMap = createItemMap(tile.getItemLayer());
				if (itemMap != null && itemMap.size() > 0)
				{
					Map<Integer, Integer> oldItems = itemArray.get(location);
					if (oldItems != null )
					{
						if (itemMap.equals(oldItems))
						{
							// Didn't Change, try another location
							continue;
						}
					}
					// Tile has items and items have changed, returns this location
					return location;
				}
			}
		}
		return null;
	}

	// Get tile based on WorldPoint. Taken from Wooxs droplogger plugin
	private Tile getLootTile(WorldPoint location)
	{
		int regionX = location.getX() - client.getBaseX();
		int regionY = location.getY() - client.getBaseY();
		if (regionX < 0 || regionX >= Constants.REGION_SIZE || regionY < 0 || regionY >= Constants.REGION_SIZE)
		{
			return null;
		}

		return client.getRegion().getTiles()[location.getPlane()][regionX][regionY];
	}

	// Creates an item map (ID,amount) for the tiles item layer
	private Map<Integer, Integer> createItemMap(ItemLayer layer)
	{
		Map<Integer, Integer> map = new HashMap<>();
		if (layer == null)
			return map;

		Node current = layer.getBottom();
		while (current instanceof Item)
		{
			final Item item = (Item) current;

			Integer ex = map.computeIfPresent(item.getId(), (k, v) -> v + item.getQuantity());
			if (ex == null)
			{
				map.computeIfAbsent(item.getId(), e -> item.getQuantity());
			}
			current = current.getNext();
		}

		return map;
	}


	// Figures out what items the boss dropped
	private ArrayList<DropEntry> createDropEntryArray(NPC npc)
	{
		// Checks all deathLocations for spawned loot
		WorldPoint correctWP = getCorrectWorldPoint(deathLocations);
		if (correctWP == null)
		{
			// May be null for bosses that look for the tile where new items are added
			WorldPoint[] points = getExpectedLootPoints(npc, deathSpot);
			correctWP = getCorrectWorldPoint(points);

			// Still not able to find correct world point
			if (correctWP == null)
			{
				BossLoggedAlert("Unable to find loot for: " + npc.getName());
				log.debug("Unable to find correct location for NPC", npc.getName());
				return null;
			}
		}

		// Grab the tile from this correct WorldPoint
		Tile tile = getLootTile(correctWP);
		if (tile == null)
		{
			BossLoggedAlert("Unable to find loot at expected location for: " + npc.getName());
			log.debug("Unable to find loot tile at expected location for NPC", npc.getName(), correctWP);
			return null;
		}

		// Get item layer from correct tile
		ItemLayer layer = tile.getItemLayer();
		// Grab old items for this world point
		Map<Integer, Integer> oldMap = itemArray.get(correctWP);
		// Create a map of the Current items
		Map<Integer, Integer> newItems = createItemMap(layer);
		// Tile doesn't have items or no new items
		if (layer == null || newItems.equals(oldMap))
		{
			BossLoggedAlert("Unable to create drop entry for: " + npc.getName());
			log.debug("No Layer Items or no NEW Layer Items", layer, newItems, oldMap, tile);
			return null;
		}

		// Loop Through the new items and add them to the drops array list
		ArrayList<DropEntry> drops = new ArrayList<DropEntry>();
		Map<Integer, Integer> finalOldMap = oldMap;
		newItems.forEach((id, amount) ->
				{
					// If some of this item already existed remove the existing amount
					if (finalOldMap != null)
					{
						Integer existing = finalOldMap.get(id);
						if (existing != null)
						{
							amount = amount - existing;
						}
					}
					// If no new item ignore this item ID
					if (amount <= 0)
						return;
					// Add new entry
					int unnotedID = getUnnotedItemId(id);			// Store everything in unnoted form
					drops.add(new DropEntry(unnotedID, amount));
				}

		);

		// Not sure if this works since pets are so rare.
		if (gotPet)
		{
			int petID = getPetIdByNpcName(npc.getName());
			drops.add(new DropEntry(petID, 1));
			gotPet = false;
			BossLoggedAlert("Oh lookie a pet!");
		}

		return drops;
	}


	//
	// Other Helper Functions
	//

	private int getPetIdByNpcName(String name)
	{
		Pet pet = Pet.getByBossName(name);
		if (pet != null)
		{
			return pet.getPetID();
		}
		return -1;
	}

	// Updates in-game alert chat color based on config settings
	private void updateMessageColor()
	{
		Color c = bossLoggerConfig.chatMessageColor();
		messageColor = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
	}

	// Handles if panel should be shown by Tab Name
	Boolean isBeingRecorded(String tabName)
	{
		switch (tabName.toUpperCase())
		{
			case "BARROWS":
				return bossLoggerConfig.recordBarrowsChest();
			case "RAIDS":
				return bossLoggerConfig.recordRaidsChest();
			case "ZULRAH":
				return bossLoggerConfig.recordZulrahKills();
			case "VORKATH":
				return bossLoggerConfig.recordVorkathKills();
			// God Wars Dungeon
			case "ARMADYL":
				return bossLoggerConfig.recordArmadylKills();
			case "BANDOS":
				return bossLoggerConfig.recordBandosKills();
			case "SARADOMIN":
				return bossLoggerConfig.recordSaradominKills();
			case "ZAMMY":
				return bossLoggerConfig.recordZammyKills();
			// Wildy Bosses
			case "VET'ION":
				return bossLoggerConfig.recordVetionKills();
			case "VENENATIS":
				return bossLoggerConfig.recordVenenatisKills();
			case "CALLISTO":
				return bossLoggerConfig.recordCallistoKills();
			case "CHAOS ELEMENTAL":
				return bossLoggerConfig.recordChaosElementalKills();
			case "CHAOS FANATIC":
				return bossLoggerConfig.recordChaosFanaticKills();
			case "CRAZY ARCHAEOLOGIST":
				return bossLoggerConfig.recordCrazyArchaeologistKills();
			case "SCORPIA":
				return bossLoggerConfig.recordScorpiaKills();
			case "KING BLACK DRAGON":
				return bossLoggerConfig.recordKbdKills();
			// Slayer Bosses
			case "SKOTIZO":
				return bossLoggerConfig.recordSkotizoKills();
			case "GROTESQUE GUARDIANS":
				return bossLoggerConfig.recordGrotesqueGuardiansKills();
			case "ABYSSAL SIRE":
				return bossLoggerConfig.recordAbyssalSireKills();
			case "KRAKEN":
				return bossLoggerConfig.recordKrakenKills();
			case "CERBERUS":
				return bossLoggerConfig.recordCerberusKills();
			case "THERMONUCLEAR SMOKE DEVIL":
				return bossLoggerConfig.recordThermonuclearSmokeDevilKills();
			// Other
			case "GIANT MOLE":
				return bossLoggerConfig.recordGiantMoleKills();
			case "KALPHITE QUEEN":
				return bossLoggerConfig.recordKalphiteQueenKills();
			case "CORPOREAL BEAST":
				return bossLoggerConfig.recordCorporealBeastKills();
			case "DAGANNOTH REX":
				return bossLoggerConfig.recordDagannothRexKills();
			case "DAGANNOTH PRIME":
				return bossLoggerConfig.recordDagannothPrimeKills();
			case "DAGANNOTH SUPREME":
				return bossLoggerConfig.recordDagannothSupremeKills();
			default:
				return false;
		}
	}

	// Keep the subscribe a bit cleaner, may be a better way to handle this
	private void handleConfigChanged(String eventKey)
	{
		switch (eventKey)
		{
			case "recordBarrowsChest":
				ToggleTab("Barrows", bossLoggerConfig.recordBarrowsChest());
				return;
			case "recordRaidsChest":
				ToggleTab("Raids", bossLoggerConfig.recordRaidsChest());
				return;
			case "recordZulrahKills":
				ToggleTab("Zulrah", bossLoggerConfig.recordZulrahKills());
				return;
			case "recordVorkathKills":
				ToggleTab("Vorkath", bossLoggerConfig.recordVorkathKills());
				return;
			case "recordArmadylKills":
				ToggleTab("Armadyl", bossLoggerConfig.recordArmadylKills());
				return;
			case "recordBandosKills":
				ToggleTab("Bandos", bossLoggerConfig.recordBandosKills());
				return;
			case "recordSaradominKills":
				ToggleTab("Saradomin", bossLoggerConfig.recordSaradominKills());
				return;
			case "recordZammyKills":
				ToggleTab("Zammy", bossLoggerConfig.recordZammyKills());
				return;
			case "recordVetionKills":
				ToggleTab("Vet'ion", bossLoggerConfig.recordVetionKills());
				return;
			case "recordVenenatisKills":
				ToggleTab("Venenatis", bossLoggerConfig.recordVenenatisKills());
				return;
			case "recordCallistoKills":
				ToggleTab("Callisto", bossLoggerConfig.recordCallistoKills());
				return;
			case "recordChaosElementalKills":
				ToggleTab("Chaos Elemental", bossLoggerConfig.recordChaosElementalKills());
				return;
			case "recordChaosFanaticKills":
				ToggleTab("Chaos Fanatic", bossLoggerConfig.recordChaosFanaticKills());
				return;
			case "recordCrazyArchaeologistKills":
				ToggleTab("Crazy Archaeologist", bossLoggerConfig.recordCrazyArchaeologistKills());
				return;
			case "recordScorpiaKills":
				ToggleTab("Scorpia", bossLoggerConfig.recordScorpiaKills());
				return;
			case "recordKbdKills":
				ToggleTab("King Black Dragon", bossLoggerConfig.recordKbdKills());
				return;
			case "recordSkotizoKills":
				ToggleTab("Skotizo", bossLoggerConfig.recordSkotizoKills());
				return;
			case "recordGrotesqueGuardiansKills":
				ToggleTab("Grotesque Guardians", bossLoggerConfig.recordGrotesqueGuardiansKills());
				return;
			case "recordAbyssalSireKills":
				ToggleTab("Abyssal Sire", bossLoggerConfig.recordAbyssalSireKills());
				return;
			case "recordKrakenKills":
				ToggleTab("Kraken", bossLoggerConfig.recordKrakenKills());
				return;
			case "recordCerberusKills":
				ToggleTab("Cerberus", bossLoggerConfig.recordCerberusKills());
				return;
			case "recordThermonuclearSmokeDevilKills":
				ToggleTab("Thermonuclear Smoke Devil", bossLoggerConfig.recordThermonuclearSmokeDevilKills());
				return;
			case "recordGiantMoleKills":
				ToggleTab("Giant Mole", bossLoggerConfig.recordGiantMoleKills());
				return;
			case "recordKalphiteQueenKills":
				ToggleTab("Kalphite Queen", bossLoggerConfig.recordKalphiteQueenKills());
				return;
			case "recordCorporealBeastKills":
				ToggleTab("Corporeal Beast", bossLoggerConfig.recordCorporealBeastKills());
				return;
			case "recordDagannothRexKills":
				ToggleTab("Dagannoth Rex", bossLoggerConfig.recordDagannothRexKills());
				return;
			case "recordDagannothPrimeKills":
				ToggleTab("Dagannoth Prime", bossLoggerConfig.recordDagannothPrimeKills());
				return;
			case "recordDagannothSupremeKills":
				ToggleTab("Dagannoth Supreme", bossLoggerConfig.recordDagannothSupremeKills());
				return;
			case "showLootTotals":
				loadAllData();
				if (bossLoggerConfig.showLootTotals())
				{
					createPanel();
				}
				else
				{
					removePanel();
				}
				return;
			case "chatMessageColor":
				// Update in-game alert color
				updateMessageColor();
				BossLoggedAlert("Example Message");
				return;
			default:
				break;
		}
	}
}