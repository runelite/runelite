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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.SwingUtilities;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
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
import net.runelite.client.game.loot.LootEventType;
import net.runelite.client.game.loot.events.EventLootReceived;
import net.runelite.client.game.loot.events.NpcLootReceived;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.bosslogger.data.DropEntry;
import net.runelite.client.plugins.bosslogger.data.LootEntry;
import net.runelite.client.plugins.bosslogger.ui.BossLoggerPanel;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Boss Logger",
	description = "Log loot from PvM bosses",
	tags = {"boss", "loot", "logger", "recorder"}
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

	// File Reading/Writing
	private BossLoggerWriter writer;

	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");
	private static final Pattern BOSS_NAME_PATTERN = Pattern.compile("Your (.*) kill count is:");
	private static final Pattern PET_RECEIVED_PATTERN = Pattern.compile("You have a funny feeling like ");
	private static final Pattern PET_RECEIVED_INVENTORY_PATTERN = Pattern.compile("You feel something weird sneaking into your backpack.");
	private static final Pattern CLUE_SCROLL_PATTERN = Pattern.compile("You have completed (\\d*) (\\w*) Treasure Trails.");
	private String messageColor = ""; // in-game chat message color

	private BossLoggerPanel panel;
	private NavigationButton navButton;

	// Mapping Variables
	private Map<Tab, Boolean> recordingMap = new HashMap<>(); 				// Store config recording value for each Tab
	private Map<Tab, ArrayList<LootEntry>> lootMap = new HashMap<>();		// Store loot entries for each Tab
	private Map<Tab, String> filenameMap = new HashMap<>(); 				// Stores filename for each Tab
	private Map<String, Integer> killcountMap = new HashMap<>(); 			// Store boss kill count by boss name

	private boolean gotPet = false;			// Got the pet chat message?

	@Provides
	BossLoggerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BossLoggerConfig.class);
	}

	@Override
	protected void startUp()
	{
		init();

		if (bossLoggerConfig.showLootTotals())
		{
			SwingUtilities.invokeLater(this::createPanel);
		}

		writer = new BossLoggerWriter(client, filenameMap);
	}

	@Override
	protected void shutDown() throws Exception
	{
		removePanel();
	}

	@Subscribe
	protected void onEventLootReceived(EventLootReceived e)
	{
		int kc = -1;
		String eventName = e.getEvent().name().replaceAll("_", " ");
		switch (e.getEvent())
		{
			case THEATRE_OF_BLOOD:
				kc = killcountMap.get("RAIDS 2");
				break;
			case BARROWS:
			case RAIDS:
			case CLUE_SCROLL_EASY:
			case CLUE_SCROLL_MEDIUM:
			case CLUE_SCROLL_HARD:
			case CLUE_SCROLL_ELITE:
			case CLUE_SCROLL_MASTER:
				kc = killcountMap.get(eventName);
				break;
			case UNKNOWN_EVENT:
				log.debug("Unknown Event: {}", e);
				break;
			default:
				log.debug("Unhandled Event: {}", e.getEvent());
		}
		if (kc == -1)
			return;

		// Create loot entry and store it to file
		LootEntry entry = new LootEntry(kc, e.getItems());
		// Got a pet?
		if (gotPet)
			entry.addDrop(handlePet(eventName));
		addLootEntry(eventName, entry);

		BossLoggedAlert("Loot from " + eventName.toLowerCase() + " added to log.");
	}

	// Only check for Boss NPCs
	@Subscribe
	protected void onNpcLootReceived(NpcLootReceived e)
	{
		// Only care about certain NPCs
		WatchNpcs watchList = WatchNpcs.getByNpcId(e.getNpcId());
		if (watchList == null)
			return;

		// Find tab that cares about this NPC
		Tab tab = Tab.getByBossName(watchList.getName());
		if (tab == null)
		{
			log.warn("Couldn't find a tab for WatchNpcs: ", watchList);
			return;
		}

		// User wants us to record this tab?
		Boolean recordingFlag = recordingMap.get(tab);
		if (recordingFlag == null || !recordingFlag)
			return;

		// Add the loot to the file
		AddBossLootEntry(tab.getBossName(), e.getItems());
	}

	// Check for Unsired loot reclaiming
	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		// Received unsired loot?
		if (event.getGroupId() == WidgetID.DIALOG_SPRITE_GROUP_ID)
		{
			Widget text = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
			if ("The Font consumes the Unsired and returns you a reward.".equals(text.getText()))
			{
				Widget sprite = client.getWidget(WidgetInfo.DIALOG_SPRITE);
				receivedUnsiredLoot(sprite.getItemId());
			}
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

	// Chat Message parsing kill count value and/or pet drop
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
		if (chatMessage.startsWith("Your completed Chambers of Xeric count is"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				killcountMap.put("RAIDS", Integer.valueOf(m.group()));
				return;
			}
		}

		// Raids KC
		if (chatMessage.startsWith("Your completed Theatre of Blood count is"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				killcountMap.put("RAIDS 2", Integer.valueOf(m.group()));
				return;
			}
		}

		Matcher clueScroll = CLUE_SCROLL_PATTERN.matcher(chatMessage);
		if (clueScroll.find())
		{
			LootEventType type = null;
			switch (clueScroll.group(2).toUpperCase())
			{
				case "EASY":
					type = LootEventType.CLUE_SCROLL_EASY;
					break;
				case "MEDIUM":
					type = LootEventType.CLUE_SCROLL_MEDIUM;
					break;
				case "HARD":
					type = LootEventType.CLUE_SCROLL_HARD;
					break;
				case "ELITE":
					type = LootEventType.CLUE_SCROLL_ELITE;
					break;
				case "MASTER":
					type = LootEventType.CLUE_SCROLL_MASTER;
					break;
			}

			if (type == null)
				return;
			String name = type.name().replaceAll("_", " ");

			killcountMap.put(name, Integer.valueOf(clueScroll.group(1)));
			return;
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
			lootMap.put(tab, new ArrayList<>());
		}
	}

	private void init()
	{
		// Create maps for easy management of certain features
		Map<Tab, Boolean> mapRecording = new HashMap<>();
		Map<Tab, ArrayList<LootEntry>> mapLoot = new HashMap<>();
		Map<Tab, String> mapFilename = new HashMap<>();
		Map<String, Integer> mapKillcount = new HashMap<>();
		for (Tab tab : Tab.values())
		{
			// Is Boss being recorded?
			mapRecording.put(tab, isBeingRecorded(tab.getName()));
			// Loot Entries by Tab Name
			ArrayList<LootEntry> array = new ArrayList<LootEntry>();
			mapLoot.put(tab, array);
			// Filenames. Removes all spaces, periods, and apostrophes
			String filename = tab.getName().replaceAll("( |'|\\.)", "").toLowerCase() + ".log";
			mapFilename.put(tab, filename);
			// Kill Count
			int killcount = 0;
			mapKillcount.put(tab.getBossName().toUpperCase(), killcount);
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
	private void toggleTabRecordingStatus(Tab tab, boolean status)
	{
		// Update tab map
		recordingMap.put(tab, status);

		// Remove panel tab if showing panel
		if (bossLoggerConfig.showLootTotals())
		{
			panel.toggleTab(tab);
		}
	}

	//
	// General Functionality functions
	//

	// Wrapper for changing local writing directory
	private void updatePlayerFolder()
	{
		boolean changed = writer.updatePlayerFolder();
		if (changed)
		{
			resetStoredData();
			if (bossLoggerConfig.showLootTotals())
				panel.refreshCurrentTab();
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

	public void loadTabData(Tab tab)
	{
		loadLootEntries(tab);
	}

	// Load data for all bosses being recorded
	private void loadAllData()
	{
		for (Tab tab : Tab.values())
		{
			if (isBeingRecorded(tab.getName()))
			{
				loadLootEntries(tab);
			}
		}
	}

	// Returns stored data by tab
	public ArrayList<LootEntry> getData(Tab tab)
	{
		// Loot Entries are stored on lootMap by boss name (upper cased)
		return lootMap.get(tab);
	}

	//
	// LootEntry helper functions
	//

	// Adds the data to the correct boss log file
	private void AddBossLootEntry(String bossName, List<Item> drops)
	{
		int KC = killcountMap.get(bossName.toUpperCase());
		LootEntry newEntry = new LootEntry(KC, drops);
		if (gotPet)
			newEntry.addDrop(handlePet(bossName));
		addLootEntry(bossName, newEntry);
		BossLoggedAlert(bossName + " kill added to log.");
	}

	// Wrapper for writer.addLootEntry
	private void addLootEntry(String bossName, LootEntry entry)
	{
		updatePlayerFolder();

		Tab tab = Tab.getByBossName(bossName);
		if (tab == null)
		{
			log.debug("Cant find tab for boss: {}", bossName);
			return;
		}

		// Update data inside plugin
		ArrayList<LootEntry> loots = lootMap.get(tab);
		loots.add(entry);
		lootMap.put(tab, loots);

		boolean success = writer.addLootEntry(tab, entry);

		if (!success)
		{
			log.debug("Couldn't add entry to tab. (tab: {} | entry: {})", tab, entry);
			return;
		}

		// Update tab if being displayed;
		if (isBeingRecorded(tab.getName()))
		{
			panel.updateTab(tab);
		}
	}

	// Receive Loot from the necessary file
	private synchronized void loadLootEntries(Tab tab)
	{
		updatePlayerFolder();

		ArrayList<LootEntry> data = writer.loadLootEntries(tab);

		if (data == null)
		{
			log.debug("Couldn't find local data for tab: {}", tab);
			lootMap.put(tab, new ArrayList<>());
			return;
		}

		// Update Loot Map with new data
		lootMap.put(tab, data);

		// Update Killcount map with latest value
		if (data.size() > 0)
		{
			int killcount = data.get(data.size() - 1).getKillCount();
			killcountMap.put(tab.getBossName().toUpperCase(), killcount);
		}
	}

	// Add Loot Entry to the necessary file
	private void addDropToLastLootEntry(Tab tab, DropEntry newDrop)
	{
		// Update data inside plugin
		ArrayList<LootEntry> loots = lootMap.get(tab);
		LootEntry entry = loots.get(loots.size() - 1);
		entry.addDrop(newDrop);
		// Ensure updates are applied, may not be necessary
		loots.add(loots.size() - 1, entry);
		lootMap.put(tab, loots);

		updatePlayerFolder();

		rewriteLootFile(tab, loots);
	}

	// Wrapper for writer.rewriteLootFile
	private void rewriteLootFile(Tab tab, ArrayList<LootEntry> loots)
	{
		boolean success = writer.rewriteLootFile(tab, loots);
		if (!success)
		{
			log.debug("Couldn't add drop to last loot entry");
			return;
		}

		// Update tab if being displayed;
		if (isBeingRecorded(tab.getName()))
		{
			panel.updateTab(tab);
		}
	}

	// Upon cleaning an Unsired add the item to the previous LootEntry
	private void receivedUnsiredLoot(int itemID)
	{
		DropEntry drop = new DropEntry(itemID, 1);
		// Update the last drop
		addDropToLastLootEntry(Tab.ABYSSAL_SIRE, drop);
	}

	//
	// Other Helper Functions
	//

	private DropEntry handlePet(String name)
	{
		gotPet = false;
		int petID = getPetId(name);
		BossLoggedAlert("Oh lookie a pet! Don't forget to insure it!");
		return new DropEntry(petID, 1);
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

	public void clearData(Tab tab)
	{
		log.debug("Clearing data for tab: " + tab.getName());
		writer.clearLootFile(tab);
	}

	// Updates in-game alert chat color based on config settings
	private void updateMessageColor()
	{
		Color c = bossLoggerConfig.chatMessageColor();
		messageColor = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
	}

	//
	// Config Helper Switch Statements
	//

	// Handles if panel should be shown by Tab Name
	public boolean isBeingRecorded(String tabName)
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
			case "RAIDS 2":
				return bossLoggerConfig.recordTobChest();
			// Clue Scrolls
			case "CLUE SCROLL EASY":
				return bossLoggerConfig.recordEasyClues();
			case "CLUE SCROLL MEDIUM":
				return bossLoggerConfig.recordMediumClues();
			case "CLUE SCROLL HARD":
				return bossLoggerConfig.recordHardClues();
			case "CLUE SCROLL ELITE":
				return bossLoggerConfig.recordEliteClues();
			case "CLUE SCROLL MASTER":
				return bossLoggerConfig.recordMasterClues();
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
				toggleTabRecordingStatus(Tab.BARROWS, bossLoggerConfig.recordBarrowsChest());
				return;
			case "recordRaidsChest":
				toggleTabRecordingStatus(Tab.RAIDS, bossLoggerConfig.recordRaidsChest());
				return;
			case "recordZulrahKills":
				toggleTabRecordingStatus(Tab.ZULRAH, bossLoggerConfig.recordZulrahKills());
				return;
			case "recordVorkathKills":
				toggleTabRecordingStatus(Tab.VORKATH, bossLoggerConfig.recordVorkathKills());
				return;
			case "recordArmadylKills":
				toggleTabRecordingStatus(Tab.ARMADYL, bossLoggerConfig.recordArmadylKills());
				return;
			case "recordBandosKills":
				toggleTabRecordingStatus(Tab.BANDOS, bossLoggerConfig.recordBandosKills());
				return;
			case "recordSaradominKills":
				toggleTabRecordingStatus(Tab.SARADOMIN, bossLoggerConfig.recordSaradominKills());
				return;
			case "recordZammyKills":
				toggleTabRecordingStatus(Tab.ZAMMY, bossLoggerConfig.recordZammyKills());
				return;
			case "recordVetionKills":
				toggleTabRecordingStatus(Tab.VETION, bossLoggerConfig.recordVetionKills());
				return;
			case "recordVenenatisKills":
				toggleTabRecordingStatus(Tab.VENENATIS, bossLoggerConfig.recordVenenatisKills());
				return;
			case "recordCallistoKills":
				toggleTabRecordingStatus(Tab.CALLISTO, bossLoggerConfig.recordCallistoKills());
				return;
			case "recordChaosElementalKills":
				toggleTabRecordingStatus(Tab.CHAOS_ELEMENTAL, bossLoggerConfig.recordChaosElementalKills());
				return;
			case "recordChaosFanaticKills":
				toggleTabRecordingStatus(Tab.CHAOS_FANATIC, bossLoggerConfig.recordChaosFanaticKills());
				return;
			case "recordCrazyArchaeologistKills":
				toggleTabRecordingStatus(Tab.CRAZY_ARCHAEOLOGIST, bossLoggerConfig.recordCrazyArchaeologistKills());
				return;
			case "recordScorpiaKills":
				toggleTabRecordingStatus(Tab.SCORPIA, bossLoggerConfig.recordScorpiaKills());
				return;
			case "recordKbdKills":
				toggleTabRecordingStatus(Tab.KING_BLACK_DRAGON, bossLoggerConfig.recordKbdKills());
				return;
			case "recordSkotizoKills":
				toggleTabRecordingStatus(Tab.SKOTIZO, bossLoggerConfig.recordSkotizoKills());
				return;
			case "recordGrotesqueGuardiansKills":
				toggleTabRecordingStatus(Tab.GROTESQUE_GUARDIANS, bossLoggerConfig.recordGrotesqueGuardiansKills());
				return;
			case "recordAbyssalSireKills":
				toggleTabRecordingStatus(Tab.ABYSSAL_SIRE, bossLoggerConfig.recordAbyssalSireKills());
				return;
			case "recordKrakenKills":
				toggleTabRecordingStatus(Tab.KRAKEN, bossLoggerConfig.recordKrakenKills());
				return;
			case "recordCerberusKills":
				toggleTabRecordingStatus(Tab.CERBERUS, bossLoggerConfig.recordCerberusKills());
				return;
			case "recordThermonuclearSmokeDevilKills":
				toggleTabRecordingStatus(Tab.THERMONUCLEAR_SMOKE_DEVIL, bossLoggerConfig.recordThermonuclearSmokeDevilKills());
				return;
			case "recordGiantMoleKills":
				toggleTabRecordingStatus(Tab.GIANT_MOLE, bossLoggerConfig.recordGiantMoleKills());
				return;
			case "recordKalphiteQueenKills":
				toggleTabRecordingStatus(Tab.KALPHITE_QUEEN, bossLoggerConfig.recordKalphiteQueenKills());
				return;
			case "recordCorporealBeastKills":
				toggleTabRecordingStatus(Tab.CORPOREAL_BEAST, bossLoggerConfig.recordCorporealBeastKills());
				return;
			case "recordDagannothRexKills":
				toggleTabRecordingStatus(Tab.DAGANNOTH_REX, bossLoggerConfig.recordDagannothRexKills());
				return;
			case "recordDagannothPrimeKills":
				toggleTabRecordingStatus(Tab.DAGANNOTH_PRIME, bossLoggerConfig.recordDagannothPrimeKills());
				return;
			case "recordDagannothSupremeKills":
				toggleTabRecordingStatus(Tab.DAGANNOTH_SUPREME, bossLoggerConfig.recordDagannothSupremeKills());
				return;
			case "recordTobChest":
				toggleTabRecordingStatus(Tab.RAIDS_2, bossLoggerConfig.recordTobChest());
				return;
			case "CLUE SCROLL EASY":
				toggleTabRecordingStatus(Tab.CLUE_SCROLL_EASY, bossLoggerConfig.recordEasyClues());
				return;
			case "CLUE SCROLL MEDIUM":
				toggleTabRecordingStatus(Tab.CLUE_SCROLL_MEDIUM, bossLoggerConfig.recordMediumClues());
				return;
			case "CLUE SCROLL HARD":
				toggleTabRecordingStatus(Tab.CLUE_SCROLL_HARD, bossLoggerConfig.recordHardClues());
				return;
			case "CLUE SCROLL ELITE":
				toggleTabRecordingStatus(Tab.CLUE_SCROLL_ELITE, bossLoggerConfig.recordEliteClues());
				return;
			case "CLUE SCROLL MASTER":
				toggleTabRecordingStatus(Tab.CLUE_SCROLL_MASTER, bossLoggerConfig.recordMasterClues());
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