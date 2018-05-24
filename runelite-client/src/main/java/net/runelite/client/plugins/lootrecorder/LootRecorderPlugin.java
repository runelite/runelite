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
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.ItemLayer;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Node;
import net.runelite.api.NpcID;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.ActorDespawned;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ItemLayerChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
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


		if (event.getGroupId() == WidgetID.DIALOG_SPRITE_GROUP_ID)
		{
			Widget sprite = client.getWidget(WidgetInfo.DIALOG_SPRITE);
			int itemID = sprite.getItemId();
			switch (itemID)
			{
				case ItemID.BLUDGEON_CLAW:
					break;
				case ItemID.BLUDGEON_SPINE:
					break;
				case ItemID.BLUDGEON_AXON:
					break;
				case ItemID.ABYSSAL_DAGGER:
					break;
				case ItemID.ABYSSAL_WHIP:
					break;
				case ItemID.ABYSSAL_ORPHAN:
					break;
				case ItemID.JAR_OF_MIASMA:
					break;
				case ItemID.ABYSSAL_HEAD:
					break;
				default:
					return;
			}
			receivedUnsiredLoot(itemID);
		}
	}

	// Variables for getting items from NPC death
	private String deathName;
	private String lastBossKilled;
	private int deathSize;
	private int deathID;
	private WorldPoint playerLocation;
	private WorldPoint deathSpot;
	private WorldPoint deathSpot2;
	private Map<Integer, Integer> items;
	private Map<Integer, Integer> items2;
	private Boolean watching = false;
	private Boolean watchingItemLayers = false;

	// For checking grotesque guardian death
	private Boolean duskDead = false;
	private Boolean dawnDead = false;

	@Subscribe
	public void onActorDeath(ActorDeath death)
	{
		Actor actor = death.getActor();
		if (actor.getInteracting() == null)
			return;
		if (actor.getInteracting().getName().equals(client.getLocalPlayer().getName()))
		{
			// Grotesqu Guardians Handling
			if (actor.getName().equals("Dusk"))
				duskDead = true;
			if (actor.getName().equals("Dawn"))
				dawnDead = true;
			// Are kills for this Boss being recorded?
			Boolean flag = recordingMap.get(actor.getName().toUpperCase());
			if (duskDead && dawnDead)
				flag = true;
			if (!flag)
				return;

			// Yes they are
			NPC npc = (NPC) actor;
			NPCComposition comp = npc.getComposition();
			deathSize = comp.getSize();
			deathSpot = actor.getWorldLocation();
			playerLocation = client.getLocalPlayer().getWorldLocation();
			deathName = actor.getName();
			deathID = npc.getId();

			Tile tile = getLootTile(client.getRegion(), actor.getLocalLocation(), deathSize, client.getPlane());
			ItemLayer layer = tile.getItemLayer();
			items = createItemMap(layer);
			watching = true;
			// Reset Grotesque Guardians flags
			duskDead = false;
			dawnDead = false;
			// Used for checking for pets in the future
			lastBossKilled = actor.getName();
			if (lastBossKilled.equals("Zulrah"))
				watchingItemLayers = true;
			if (deathSize >= 3)
			{
				// Large NPCs (mostly bosses) drop their loot in the middle of them rather than on the southwestern spot
				// Lets check both spots. Could be updated to maps but meh.
				deathSpot2 =  new WorldPoint(deathSpot.getX() + ((deathSize - 1) / 2), deathSpot.getY() + ((deathSize - 1) / 2), deathSpot.getPlane());
				Tile tile2 = client.getRegion().getTiles()[deathSpot2.getPlane()][deathSpot2.getX()][deathSpot2.getY()];
				ItemLayer layer2 = tile2.getItemLayer();
				items2 = createItemMap(layer);
			}
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
				watchingItemLayers = false;
				ArrayList<DropEntry> drops = createDropEntryArray((NPC) npc);
				String npcName = npc.getName();
				if (npcName.equals("Dusk") || npcName.equals("Dawn"))
					npcName = "Grotesque Guardians";
				AddBossLootEntry(npcName, drops);
				deathName = null;
				deathSpot = null;
				deathSpot2 = null;
				playerLocation = null;
				deathSize = -1;
				deathID = -1;
				items = null;
				items2 = null;
				changedItemLayerTiles.clear();
			}
		}
	}

	// Store changed tiles (for zulrah)
	private Set<Tile> changedItemLayerTiles;
	@Subscribe
	public void onItemLayerChanged(ItemLayerChanged event)
	{
		if (watchingItemLayers)
		{
			changedItemLayerTiles.add(event.getTile());
		}
	}

	void AddBossLootEntry(String bossName, ArrayList<DropEntry> drops)
	{
		int KC = killcountMap.get(bossName.toUpperCase());
		LootEntry newEntry = new LootEntry(KC, drops);
		addLootEntry(bossName, newEntry);
		lootRecordedAlert(bossName + " kill added to log.");
	}

	// Based off Wooxs drop logger
	private Tile WooxLootTile(NPC npc, WorldPoint location)
	{
		WorldPoint location2 = null;
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
			//case NpcID.DAWN:
			//case NpcID.DAWN_7852:
			//case NpcID.DAWN_7853:
			//case NpcID.DAWN_7884:
			//case NpcID.DAWN_7885:
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
					lootRecordedAlert("Unable to find Zulrah loot title.");
					break;
				}
				// Found tile
				location = new WorldPoint(loc.getX(), loc.getY(), loc.getPlane());
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
					location2 = new WorldPoint(location.getX() + ((deathSize - 1) / 2), location.getY() + ((deathSize - 1) / 2), location.getPlane());
				}
		}
		log.info(String.valueOf(location));
		log.info(String.valueOf(location2));
		return getWooxLootTile(location, location2);
	}

	private Tile getWooxLootTile(WorldPoint location, WorldPoint location2)
	{
		int regionX = location.getX() - client.getBaseX();
		int regionY = location.getY() - client.getBaseY();
		if (regionX < 0 || regionX >= Constants.REGION_SIZE || regionY < 0 || regionY >= Constants.REGION_SIZE)
		{
			log.warn("Error calculating region x and y coordinates");
			System.out.println(location);
			System.out.println(location2);
			System.out.println(regionX);
			System.out.println(regionY);
			return null;
		}
		Tile tile = client.getRegion().getTiles()[location.getPlane()][regionX][regionY];
		return tile;
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

	ArrayList<DropEntry> createDropEntryArray(NPC npc)
	{
		//Tile tile = getLootTile(client.getRegion(), local, deathSize, client.getPlane());
		// Get the correct loot tile
		Tile tile = WooxLootTile(npc, deathSpot);
		ItemLayer layer = tile.getItemLayer();
		Map<Integer, Integer> oldMap = items;
		// For bigger npcs
		if (layer == null || layer.equals(items))
		{
			if (deathSpot2 == null)
			{
				layer = null;
			}
			else
			{
				tile = WooxLootTile(npc, deathSpot2);
				layer = tile.getItemLayer();
				oldMap = items2;
			}
		}

		// Create a map of the Current items
		Map<Integer, Integer> newItems = createItemMap(layer);

		if (layer == null || newItems.equals(oldMap))
		{
			lootRecordedAlert("Unabled to create drop entry for: " + npc.getName());
			return null;
		}


		// Loop Through the new items and add them to the drops array list
		ArrayList<DropEntry> drops = new ArrayList<DropEntry>();
		Map<Integer, Integer> finalOldMap = oldMap;
		newItems.forEach((id, amount) ->
				{
					// If some of this item already existed remove the existing amount
					Integer existing = finalOldMap.get(id);
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
			case "recordVetionKills":
				ToggleTab("Vet'ion", lootRecorderConfig.recordVetionKills());
				return;
			case "recordVenenatisKills":
				ToggleTab("Venenatis", lootRecorderConfig.recordVenenatisKills());
				return;
			case "recordCallistoKills":
				ToggleTab("Callisto", lootRecorderConfig.recordCallistoKills());
				return;
			case "recordChaosElementalKills":
				ToggleTab("Chaos Elemental", lootRecorderConfig.recordChaosElementalKills());
				return;
			case "recordChaosFanaticKills":
				ToggleTab("Chaos Fanatic", lootRecorderConfig.recordChaosFanaticKills());
				return;
			case "recordCrazedArchaeologistKills":
				ToggleTab("Crazed Archaeologist", lootRecorderConfig.recordCrazedArchaeologistKills());
				return;
			case "recordScorpiaKills":
				ToggleTab("Scorpia", lootRecorderConfig.recordScorpiaKills());
				return;
			case "recordKbdKills":
				ToggleTab("King Black Dragon", lootRecorderConfig.recordKbdKills());
				return;
			case "recordSkotizoKills":
				ToggleTab("Skotizo", lootRecorderConfig.recordSkotizoKills());
				return;
			case "recordGrotesqueGuardiansKills":
				ToggleTab("Grotesque Guardians", lootRecorderConfig.recordGrotesqueGuardiansKills());
				return;
			case "recordAbyssalSireKills":
				ToggleTab("Abyssal Sire", lootRecorderConfig.recordAbyssalSireKills());
				return;
			case "recordKrakenKills":
				ToggleTab("Kraken", lootRecorderConfig.recordKrakenKills());
				return;
			case "recordCerberusKills":
				ToggleTab("Cerberus", lootRecorderConfig.recordCerberusKills());
				return;
			case "recordThermonuclearSmokeDevilKills":
				ToggleTab("Thermonuclear Smoke Devil", lootRecorderConfig.recordThermonuclearSmokeDevilKills());
				return;
			case "recordGiantMoleKills":
				ToggleTab("Giant Mole", lootRecorderConfig.recordGiantMoleKills());
				return;
			case "recordKalphiteQueenKills":
				ToggleTab("Kalphite Queen", lootRecorderConfig.recordKalphiteQueenKills());
				return;
			case "recordCorporealBeastKills":
				ToggleTab("Corporeal Beast", lootRecorderConfig.recordCorporealBeastKills());
				return;
			case "recordDagannothRexKills":
				ToggleTab("Dagannoth Rex", lootRecorderConfig.recordDagannothRexKills());
				return;
			case "recordDagannothPrimeKills":
				ToggleTab("Dagannoth Prime", lootRecorderConfig.recordDagannothPrimeKills());
				return;
			case "recordDagannothSupremeKills":
				ToggleTab("Dagannoth Supreme", lootRecorderConfig.recordDagannothSupremeKills());
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
			case "VET'ION":
				return lootRecorderConfig.recordVetionKills();
			case "VENENATIS":
				return lootRecorderConfig.recordVenenatisKills();
			case "CALLISTO":
				return lootRecorderConfig.recordCallistoKills();
			case "CHAOS ELEMENTAL":
				return lootRecorderConfig.recordChaosElementalKills();
			case "CHAOS FANATIC":
				return lootRecorderConfig.recordChaosFanaticKills();
			case "CRAZED ARCHAEOLOGIST":
				return lootRecorderConfig.recordCrazedArchaeologistKills();
			case "SCORPIA":
				return lootRecorderConfig.recordScorpiaKills();
			case "KING BLACK DRAGON":
				return lootRecorderConfig.recordKbdKills();
			case "SKOTIZO":
				return lootRecorderConfig.recordSkotizoKills();
			case "GROTESQUE GUARDIANS":
				return lootRecorderConfig.recordGrotesqueGuardiansKills();
			case "ABYSSAL SIRE":
				return lootRecorderConfig.recordAbyssalSireKills();
			case "KRAKEN":
				return lootRecorderConfig.recordKrakenKills();
			case "CERBERUS":
				return lootRecorderConfig.recordCerberusKills();
			case "THERMONUCLEAR SMOKE DEVIL":
				return lootRecorderConfig.recordThermonuclearSmokeDevilKills();
			case "GIANT MOLE":
				return lootRecorderConfig.recordGiantMoleKills();
			case "KALPHITE QUEEN":
				return lootRecorderConfig.recordKalphiteQueenKills();
			case "CORPOREAL BEAST":
				return lootRecorderConfig.recordCorporealBeastKills();
			case "DAGANNOTH REX":
				return lootRecorderConfig.recordDagannothRexKills();
			case "DAGANNOTH PRIME":
				return lootRecorderConfig.recordDagannothPrimeKills();
			case "DAGANNOTH SUPREME":
				return lootRecorderConfig.recordDagannothSupremeKills();
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
			String filename = tab.getName().replaceAll("( |'|\\.)", "").toLowerCase() + ".log";
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

	void receivedUnsiredLoot(int itemID)
	{
		DropEntry drop = new DropEntry(itemID, 1);
		// Update the last drop
		addDropToLastLootEntry("Abyssal Sire", drop);
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
}