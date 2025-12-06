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
import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.MessageNode;
import net.runelite.api.NPCComposition;
import net.runelite.api.Player;
import net.runelite.api.ScriptID;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.PostClientTick;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.ObjectID;
import net.runelite.api.gameval.SpriteID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.ConfigSync;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.events.RuneScapeProfileChanged;
import net.runelite.client.events.ServerNpcLoot;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.game.LootManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.util.Text;
import net.runelite.http.api.loottracker.GameItem;
import net.runelite.http.api.loottracker.LootRecord;
import net.runelite.http.api.loottracker.LootRecordType;
import org.apache.commons.text.WordUtils;

@PluginDescriptor(
	name = "Loot Tracker",
	description = "Tracks loot from monsters and minigames",
	tags = {"drops"}
)
@Slf4j
public class LootTrackerPlugin extends Plugin
{
	private static final int MAX_DROPS = 1024;
	private static final Duration MAX_AGE = Duration.ofDays(365L);
	private static final int INVCHANGE_TIMEOUT = 10; // server ticks

	// Activity/Event loot handling
	private static final Pattern CLUE_SCROLL_PATTERN = Pattern.compile("You have completed [0-9]+ ([a-z]+) Treasure Trails?\\.");
	private static final int THEATRE_OF_BLOOD_REGION = 12867;
	private static final int THEATRE_OF_BLOOD_LOBBY = 14642;
	private static final int BA_LOBBY_REGION = 10039;
	// PvP loot keys (Wilderness/Deadman) reuse the Deadman loot containers, one per tab
	private static final List<Integer> PVP_LOOT_KEY_CONTAINERS = List.of(
		InventoryID.DEADMAN_LOOT_INV0,
		InventoryID.DEADMAN_LOOT_INV1,
		InventoryID.DEADMAN_LOOT_INV2,
		InventoryID.DEADMAN_LOOT_INV3,
		InventoryID.DEADMAN_LOOT_INV4
	);
	private static final List<Integer> PVP_LOOT_KEYS = List.of(
		ItemID.WILDY_LOOT_KEY0,
		ItemID.WILDY_LOOT_KEY1,
		ItemID.WILDY_LOOT_KEY2,
		ItemID.WILDY_LOOT_KEY3,
		ItemID.WILDY_LOOT_KEY4
	);

	// Herbiboar loot handling
	@VisibleForTesting
	static final String HERBIBOAR_LOOTED_MESSAGE = "You harvest herbs from the herbiboar, whereupon it escapes.";
	private static final String HERBIBOAR_EVENT = "Herbiboar";
	private static final Pattern HERBIBOAR_HERB_SACK_PATTERN = Pattern.compile(".+(Grimy .+?) herb.+");

	// Zombie Pirate Locker loot handling
	static final String ZOMBIE_PIRATE_LOCKER_EVENT = "Zombie Pirate's Locker";
	private static final Pattern ZOMBIE_PIRATE_LOCKER_PATTERN = Pattern.compile("You loot the locker and receive <col=[\\da-f]{6}>(?<qty>[\\d,]+) x (?<item>.+)</col>\\.");

	// Shipwreck salvaging
	private static final Pattern SALVAGE_PATTERN = Pattern.compile("You sort through the\\s+(?<tier>\\S+)\\s+salvage.*");

	// Seed Pack loot handling
	private static final String SEEDPACK_EVENT = "Seed pack";

	// Chest loot handling
	private static final String CHEST_LOOTED_MESSAGE = "You find some treasure in the chest!";
	private static final Pattern ROGUES_CHEST_PATTERN = Pattern.compile("You find (a|some)([a-z\\s]*) inside.");
	private static final Pattern LARRAN_LOOTED_PATTERN = Pattern.compile("You have opened Larran's (big|small) chest .*");
	private static final String ALCHEMIST_SIGNET_CHEST_MESSAGE = "You take some loot from inside.";
	// Used by Stone Chest, Isle of Souls chest, Dark Chest
	private static final String OTHER_CHEST_LOOTED_MESSAGE = "You steal some loot from the chest.";
	private static final String DORGESH_KAAN_CHEST_LOOTED_MESSAGE = "You find treasure inside!";
	private static final Pattern GRUBBY_CHEST_LOOTED_MESSAGE = Pattern.compile("You find treasure(?: and supplies|, supplies, and a weirdly coloured egg sac) within the chest.");
	private static final String ANCIENT_CHEST_LOOTED_MESSAGE = "You open the chest and find";
	private static final Pattern HAM_CHEST_LOOTED_PATTERN = Pattern.compile("Your (?<key>[a-z]+) key breaks in the lock.*");
	private static final int HAM_STOREROOM_REGION = 10321;
	private static final int LAVA_MAZE_NORTH_EAST_REGION = 12348;
	private static final Map<Integer, String> CHEST_EVENT_TYPES = new ImmutableMap.Builder<Integer, String>().
		put(5179, "Brimstone Chest").
		put(11573, "Crystal Chest").
		put(12093, "Larran's big chest").
		put(13113, "Larran's small chest").
		put(13151, "Elven Crystal Chest").
		put(5277, "Stone chest").
		put(10835, "Dorgesh-Kaan Chest").
		put(10834, "Dorgesh-Kaan Chest").
		put(7323, "Grubby Chest").
		put(8593, "Isle of Souls Chest").
		put(7827, "Dark Chest").
		put(13117, "Rogues' Chest").
		put(13156, "Chest (Ancient Vault)").
		put(LAVA_MAZE_NORTH_EAST_REGION, "Muddy Chest").
		put(5422, "Chest (Aldarin Villas)").
		put(6550, "Chest (Moon key)").
		put(5521, "Chest (Alchemist's signet)").
		put(12073, "Rusty chest").
		put(7470, "Rusty chest").
		put(6187, "Tarnished chest").
		put(6953, "Tarnished chest").
		put(7743, "Reinforced chest").
		put(8758, "Reinforced chest").
		build();

	// Chests opened with keys from slayer tasks
	private static final Set<String> SLAYER_CHEST_EVENT_TYPES = ImmutableSet.of(
		"Brimstone Chest",
		"Larran's big chest",
		"Larran's small chest"
	);

	// Shade chest loot handling
	private static final Pattern SHADE_CHEST_NO_KEY_PATTERN = Pattern.compile("You need a [a-z]+ key with a [a-z]+ trim to open this chest .*");
	private static final Map<Integer, String> SHADE_CHEST_OBJECTS = new ImmutableMap.Builder<Integer, String>().
		put(ObjectID.SHADECHEST_BRONZE_BLOODRED, "Bronze key red").
		put(ObjectID.SHADECHEST_BRONZE_BROWN, "Bronze key brown").
		put(ObjectID.SHADECHEST_BRONZE_CRIMSON, "Bronze key crimson").
		put(ObjectID.SHADECHEST_BRONZE_BLACK, "Bronze key black").
		put(ObjectID.SHADECHEST_BRONZE_PURPLE, "Bronze key purple").
		put(ObjectID.SHADECHEST_STEEL_BLOODRED, "Steel key red").
		put(ObjectID.SHADECHEST_STEEL_BROWN, "Steel key brown").
		put(ObjectID.SHADECHEST_STEEL_CRIMSON, "Steel key crimson").
		put(ObjectID.SHADECHEST_STEEL_BLACK, "Steel key black").
		put(ObjectID.SHADECHEST_STEEL_PURPLE, "Steel key purple").
		put(ObjectID.SHADECHEST_BLACK_BLOODRED, "Black key red").
		put(ObjectID.SHADECHEST_BLACK_BROWN, "Black key brown").
		put(ObjectID.SHADECHEST_BLACK_CRIMSON, "Black key crimson").
		put(ObjectID.SHADECHEST_BLACK_BLACK, "Black key black").
		put(ObjectID.SHADECHEST_BLACK_PURPLE, "Black key purple").
		put(ObjectID.SHADECHEST_SILVER_BLOODRED, "Silver key red").
		put(ObjectID.SHADECHEST_SILVER_BROWN, "Silver key brown").
		put(ObjectID.SHADECHEST_SILVER_CRIMSON, "Silver key crimson").
		put(ObjectID.SHADECHEST_SILVER_BLACK, "Silver key black").
		put(ObjectID.SHADECHEST_SILVER_PURPLE, "Silver key purple").
		put(ObjectID.SHADECHEST_GOLD_BLOODRED, "Gold key red").
		put(ObjectID.SHADECHEST_GOLD_BROWN, "Gold key brown").
		put(ObjectID.SHADECHEST_GOLD_CRIMSON, "Gold key crimson").
		put(ObjectID.SHADECHEST_GOLD_BLACK, "Gold key black").
		put(ObjectID.SHADECHEST_GOLD_PURPLE, "Gold key purple").
		build();

	private static final String HALLOWED_SACK_EVENT = "Hallowed Sack";

	// Last man standing map regions
	private static final Set<Integer> LAST_MAN_STANDING_REGIONS = ImmutableSet.of(13658, 13659, 13660, 13914, 13915, 13916, 13918, 13919, 13920, 14174, 14175, 14176, 14430, 14431, 14432);

	private static final Pattern PICKPOCKET_REGEX = Pattern.compile("You pick (the )?(?<target>.+)'s? pocket.*");

	private static final String BIRDNEST_EVENT = "Bird nest";
	private static final Set<Integer> BIRDNEST_IDS = ImmutableSet.of(ItemID.BIRD_NEST_EGG_RED, ItemID.BIRD_NEST_EGG_GREEN, ItemID.BIRD_NEST_EGG_BLUE, ItemID.BIRD_NEST_SEEDS, ItemID.BIRD_NEST_RING, ItemID.BIRD_NEST_CHEAPSEEDS, ItemID.BIRD_NEST_DECENTSEEDS, ItemID.BIRD_NEST_SEEDS_JAN2019, ItemID.BIRD_NEST_DECENTSEEDS_JAN2019);

	// Birdhouses
	private static final Pattern BIRDHOUSE_PATTERN = Pattern.compile("You dismantle and discard the trap, retrieving (?:(?:a|\\d{1,2}) nests?, )?10 dead birds, \\d{1,3} feathers and (\\d,?\\d{1,3}) Hunter XP\\.");
	private static final Map<Integer, String> BIRDHOUSE_XP_TO_TYPE = new ImmutableMap.Builder<Integer, String>().
		put(280, "Regular Bird House").
		put(420, "Oak Bird House").
		put(560, "Willow Bird House").
		put(700, "Teak Bird House").
		put(820, "Maple Bird House").
		put(960, "Mahogany Bird House").
		put(1020, "Yew Bird House").
		put(1140, "Magic Bird House").
		put(1200, "Redwood Bird House").
		build();

	/*
	 * This map is used when a pickpocket target has a different name in the chat message than their in-game name.
	 * Note that if the two NPCs can be found in the same place, there is a chance of race conditions
	 * occurring when changing targets mid-pickpocket, in which case a different solution may need to be considered.
	 */
	private static final Multimap<String, String> PICKPOCKET_DISAMBIGUATION_MAP = ImmutableMultimap.of(
		"H.A.M. Member", "Man",
		"H.A.M. Member", "Woman"
	);

	private static final String CASKET_EVENT = "Casket";

	private static final String ORE_PACK_VM_EVENT = "Ore Pack (Volcanic Mine)";

	private static final String WINTERTODT_SUPPLY_CRATE_EVENT = "Supply crate (Wintertodt)";
	private static final String WINTERTODT_REWARD_CART_EVENT = "Reward cart (Wintertodt)";
	private static final String WINTERTODT_LOOT_STRING = "You found some loot: ";
	private static final int WINTERTODT_REGION = 6461;

	private static final String BAG_FULL_OF_GEMS_PERCY_EVENT = "Bag full of gems (Percy)";
	private static final String BAG_FULL_OF_GEMS_BELONA_EVENT = "Bag full of gems (Belona)";
	private static final String BAG_FULL_OF_GEMS_DUSURI_EVENT = "Bag full of gems (Dusuri)";

	// Soul Wars
	private static final String SPOILS_OF_WAR_EVENT = "Spoils of war";
	private static final Set<Integer> SOUL_WARS_REGIONS = ImmutableSet.of(8493, 8749, 9005);

	// Tempoross
	private static final String TEMPOROSS_EVENT = "Reward pool (Tempoross)";
	private static final String TEMPOROSS_CASKET_EVENT = "Casket (Tempoross)";
	private static final String TEMPOROSS_LOOT_STRING = "You found some loot: ";
	private static final int TEMPOROSS_REGION = 12588;

	// Guardians of the Rift
	private static final String GUARDIANS_OF_THE_RIFT_EVENT = "Guardians of the Rift";
	private static final String GUARDIANS_OF_THE_RIFT_LOOT_STRING = "You found some loot: ";
	private static final int GUARDIANS_OF_THE_RIFT_REGION = 14484;

	// Mahogany Homes
	private static final String MAHOGANY_CRATE_EVENT = "Supply crate (Mahogany Homes)";

	// Raids
	private static final String CHAMBERS_OF_XERIC = "Chambers of Xeric";
	private static final String THEATRE_OF_BLOOD = "Theatre of Blood";
	private static final String TOMBS_OF_AMASCUT = "Tombs of Amascut";

	private static final int FONT_OF_CONSUMPTION_REGION = 12106;
	private static final String FONT_OF_CONSUMPTION_USE_MESSAGE = "You place the Unsired into the Font of Consumption...";

	private static final String BA_HIGH_GAMBLE = "Barbarian Assault high gamble";

	private static final String DOM = "Doom of Mokhaiotl";

	private static final Set<Character> VOWELS = ImmutableSet.of('a', 'e', 'i', 'o', 'u');

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private LootTrackerConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private EventBus eventBus;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private LootManager lootManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private Gson gson;

	@Getter(AccessLevel.PACKAGE)
	@Inject
	private LootTrackerClient lootTrackerClient;

	private LootTrackerPanel panel;
	private NavigationButton navButton;

	private boolean chestLooted;
	private boolean pvpKeysLooted;
	private boolean lastLoadingIntoInstance;
	private String lastPickpocketTarget;
	private int ignorePickpocketLoot;

	private List<String> ignoredItems = new ArrayList<>();
	private List<String> ignoredEvents = new ArrayList<>();

	private int inventoryId = -1;
	private Multiset<Integer> inventorySnapshot;
	private InvChangeCallback inventorySnapshotCb;
	private int inventoryTimeout;

	private final List<LootRecord> queuedLoots = new ArrayList<>();
	private String profileKey;

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
			lootTrackerClient.setUuid(accountSession.getUuid());
		}
		else
		{
			lootTrackerClient.setUuid(null);
		}
	}

	@Subscribe
	public void onSessionClose(SessionClose sessionClose)
	{
		// session close is fired after the config has been synced and the
		// session has been invalidated, so it is too late to submit loot
		// if there is any.
		lootTrackerClient.setUuid(null);
	}

	@Subscribe
	public void onConfigSync(ConfigSync configSync)
	{
		submitLoot();
	}

	@Subscribe
	public void onRuneScapeProfileChanged(RuneScapeProfileChanged e)
	{
		final String profileKey = configManager.getRSProfileKey();
		if (profileKey == null)
		{
			return;
		}

		if (profileKey.equals(this.profileKey))
		{
			return;
		}

		switchProfile(profileKey);
	}

	private void switchProfile(String profileKey)
	{
		executor.execute(() ->
		{
			// Current queued loot is for the previous profile, so save it first with the current profile key
			submitLoot();

			this.profileKey = profileKey;

			log.debug("Switched to profile {}", profileKey);

			if (!config.rememberLoot())
			{
				return;
			}

			int drops = 0;
			List<ConfigLoot> loots = new ArrayList<>();
			Instant old = Instant.now().minus(MAX_AGE);
			for (String key : configManager.getRSProfileConfigurationKeys(LootTrackerConfig.GROUP, profileKey, "drops_"))
			{
				String json = configManager.getConfiguration(LootTrackerConfig.GROUP, profileKey, key);
				ConfigLoot configLoot;

				try
				{
					configLoot = gson.fromJson(json, ConfigLoot.class);
				}
				catch (JsonSyntaxException ex)
				{
					log.warn("Removing loot with malformed json: {}", json, ex);
					configManager.unsetConfiguration(LootTrackerConfig.GROUP, profileKey, key);
					continue;
				}

				if (configLoot.last.isBefore(old))
				{
					log.debug("Removing old loot for {} {}", configLoot.type, configLoot.name);
					configManager.unsetConfiguration(LootTrackerConfig.GROUP, profileKey, key);
					continue;
				}

				if (drops >= MAX_DROPS && !loots.isEmpty() && loots.get(0).last.isAfter(configLoot.last))
				{
					// fast drop
					continue;
				}

				sortedInsert(loots, configLoot, Comparator.comparing(ConfigLoot::getLast));
				drops += configLoot.numDrops();

				if (drops >= MAX_DROPS)
				{
					ConfigLoot top = loots.remove(0);
					drops -= top.numDrops();
				}
			}

			log.debug("Loaded {} records", loots.size());

			clientThread.invokeLater(() ->
			{
				// convertToLootTrackerRecord requires item compositions to be available to get the item name,
				// so it can't be run while the client is starting
				if (client.getGameState().getState() < GameState.LOGIN_SCREEN.getState())
				{
					return false;
				}

				// convertToLootTrackerRecord must be called on client thread
				List<LootTrackerRecord> records = loots.stream()
					.map(this::convertToLootTrackerRecord)
					.collect(Collectors.toList());
				SwingUtilities.invokeLater(() ->
				{
					panel.clearRecords();
					panel.addRecords(records);
				});

				return true;
			});
		});
	}

	private static <T> void sortedInsert(List<T> list, T value, Comparator<? super T> c)
	{
		int idx = Collections.binarySearch(list, value, c);
		list.add(idx < 0 ? -idx - 1 : idx, value);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(LootTrackerConfig.GROUP))
		{
			if ("ignoredItems".equals(event.getKey()) || "ignoredEvents".equals(event.getKey()))
			{
				ignoredItems = Text.fromCSV(config.getIgnoredItems());
				ignoredEvents = Text.fromCSV(config.getIgnoredEvents());
				SwingUtilities.invokeLater(panel::updateIgnoredRecords);
			}
			else if ("priceType".equals(event.getKey()) || "showPriceType".equals(event.getKey()))
			{
				SwingUtilities.invokeLater(panel::rebuild);
			}
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		profileKey = null;
		ignoredItems = Text.fromCSV(config.getIgnoredItems());
		ignoredEvents = Text.fromCSV(config.getIgnoredEvents());
		panel = new LootTrackerPanel(this, itemManager, config);
		spriteManager.getSpriteAsync(SpriteID.SideIcons.INVENTORY, 0, panel::loadHeaderIcon);

		final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Loot Tracker")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		AccountSession accountSession = sessionManager.getAccountSession();
		if (accountSession != null)
		{
			lootTrackerClient.setUuid(accountSession.getUuid());
		}

		String profileKey = configManager.getRSProfileKey();
		if (profileKey != null)
		{
			switchProfile(profileKey);
		}
	}

	@Override
	protected void shutDown()
	{
		submitLoot();
		clientToolbar.removeNavigation(navButton);
		lootTrackerClient.setUuid(null);
		chestLooted = false;
	}

	@Subscribe
	public void onClientShutdown(ClientShutdown event)
	{
		Future<Void> future = submitLoot();
		if (future != null)
		{
			event.waitFor(future);
		}
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		final boolean inInstancedRegion = client.isInInstancedRegion();
		if (event.getGameState() == GameState.LOADING && inInstancedRegion != lastLoadingIntoInstance)
		{
			lastLoadingIntoInstance = inInstancedRegion;
			chestLooted = false;
		}
	}

	// if there is unloaded loot for a type+name, load it in
	private void initLoot(LootRecordType type, String name)
	{
		if (panel.hasRecord(type, name) || !config.rememberLoot())
		{
			return;
		}

		ConfigLoot loot = getLootConfig(type, name);
		if (loot == null)
		{
			return;
		}

		log.debug("Loaded {} records for {} {}", loot.numDrops(), type, name);

		LootTrackerRecord record = convertToLootTrackerRecord(loot);
		SwingUtilities.invokeLater(() -> panel.addRecords(Collections.singleton(record)));
	}

	void addLoot(@NonNull String name, int combatLevel, LootRecordType type, Object metadata, Collection<ItemStack> items)
	{
		addLoot(name, combatLevel, type, metadata, items, 1);
	}

	void addLoot(@NonNull String name, int combatLevel, LootRecordType type, Object metadata, Collection<ItemStack> items, int amount)
	{
		initLoot(type, name);

		final LootTrackerItem[] entries = buildEntries(stack(items));
		SwingUtilities.invokeLater(() -> panel.add(name, type, combatLevel, entries, amount));

		LootRecord lootRecord = new LootRecord(name, type, metadata, toGameItems(items), Instant.now(), getLootWorldId(), amount, null);
		synchronized (queuedLoots)
		{
			queuedLoots.add(lootRecord);
		}

		eventBus.post(new LootReceived(name, combatLevel, type, items, amount, metadata));
	}

	private Integer getLootWorldId()
	{
		// For the wiki to determine drop rates based on dmm brackets / identify leagues drops
		var worldType = client.getWorldType();
		return worldType.contains(WorldType.SEASONAL)
			|| worldType.contains(WorldType.TOURNAMENT_WORLD)
			|| worldType.contains(WorldType.BETA_WORLD) ? client.getWorld() : null;
	}

	@Subscribe
	public void onPostClientTick(PostClientTick postClientTick)
	{
		if (inventoryTimeout > 0)
		{
			if (--inventoryTimeout == 0)
			{
				log.debug("Inventory snapshot: Loot timeout");
				resetEvent();
			}
		}
	}

	private Object buildNpcMetadata(NPCComposition npc)
	{
		if (client.getWorldType().contains(WorldType.SEASONAL))
		{
			var md = new NpcMetadata();
			md.setId(npc.getId());
			md.setR1(client.getVarbitValue(VarbitID.LEAGUE_RELIC_SELECTION_0));
			md.setR2(client.getVarbitValue(VarbitID.LEAGUE_RELIC_SELECTION_1));
			md.setR3(client.getVarbitValue(VarbitID.LEAGUE_RELIC_SELECTION_2));
			md.setR4(client.getVarbitValue(VarbitID.LEAGUE_RELIC_SELECTION_3));
			md.setR5(client.getVarbitValue(VarbitID.LEAGUE_RELIC_SELECTION_4));
			md.setR6(client.getVarbitValue(VarbitID.LEAGUE_RELIC_SELECTION_5));
			md.setR7(client.getVarbitValue(VarbitID.LEAGUE_RELIC_SELECTION_6));
			md.setR8(client.getVarbitValue(VarbitID.LEAGUE_RELIC_SELECTION_7));
			return md;
		}
		else if (npc.getName() != null && npc.getName().equals("Cave horror"))
		{
			WorldPoint location = client.getLocalPlayer().getWorldLocation();
			return Map.of(
				"id", npc.getId(),
				"x", location.getX(),
				"y", location.getY(),
				"plane", location.getPlane(),
				"world", client.getWorld()
			);
		}
		else
		{
			return npc.getId();
		}
	}

	@Subscribe
	public void onServerNpcLoot(final ServerNpcLoot event)
	{
		final NPCComposition npc = event.getComposition();
		final Collection<ItemStack> items = event.getItems();
		final String name = Text.removeTags(npc.getName());
		final int combat = npc.getCombatLevel();

		if (ignorePickpocketLoot == client.getTickCount())
		{
			// server sends npc loot for pickpockets, ignore it
			return;
		}

		addLoot(name, combat, LootRecordType.NPC, buildNpcMetadata(npc), items);

		if (config.npcKillChatMessage())
		{
			final String prefix = VOWELS.contains(Character.toLowerCase(name.charAt(0)))
				? "an"
				: "a";

			lootReceivedChatMessage(items, prefix + ' ' + name);
		}
	}

	@Subscribe
	public void onPluginLootReceived(PluginLootReceived event)
	{
		log.debug("Plugin loot received from {}: {}", event.getSource().getName(), event.getItems());
		addLoot(event.getName(), event.getCombatLevel(), event.getType(), event.getItems(), event.getItems());
	}

	@Subscribe
	public void onPlayerLootReceived(final PlayerLootReceived playerLootReceived)
	{
		// Ignore Last Man Standing and Soul Wars player loots
		if (isPlayerWithinMapRegion(LAST_MAN_STANDING_REGIONS) || isPlayerWithinMapRegion(SOUL_WARS_REGIONS))
		{
			return;
		}

		final Player player = playerLootReceived.getPlayer();
		final Collection<ItemStack> items = playerLootReceived.getItems();
		final String name = player.getName();
		final int combat = player.getCombatLevel();

		addLoot(name, combat, LootRecordType.PLAYER, null, items);

		if (config.pvpKillChatMessage())
		{
			lootReceivedChatMessage(items, name);
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		String event;
		Object metadata = null;
		final ItemContainer container;

		switch (widgetLoaded.getGroupId())
		{
			case InterfaceID.BARROWS_REWARD:
				event = "Barrows";
				container = client.getItemContainer(InventoryID.TRAIL_REWARDINV);
				break;
			case InterfaceID.RAIDS_REWARDS:
				if (chestLooted)
				{
					return;
				}
				event = CHAMBERS_OF_XERIC;
				container = client.getItemContainer(InventoryID.RAIDS_REWARDS);
				chestLooted = true;
				break;
			case InterfaceID.TOB_CHESTS:
				if (chestLooted || !inTobChestRegion())
				{
					return;
				}
				event = THEATRE_OF_BLOOD;
				container = client.getItemContainer(InventoryID.TOB_CHESTS);
				chestLooted = true;
				break;
			case InterfaceID.TOA_CHESTS:
				if (chestLooted)
				{
					return;
				}

				int raidLevel = client.getVarbitValue(VarbitID.TOA_CLIENT_RAID_LEVEL);
				int teamSize =
					Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P0), 1) +
					Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P1), 1) +
					Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P2), 1) +
					Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P3), 1) +
					Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P4), 1) +
					Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P5), 1) +
					Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P6), 1) +
					Math.min(client.getVarbitValue(VarbitID.TOA_CLIENT_P7), 1);
				int raidDamage = client.getVarbitValue(VarbitID.TOA_DAMAGE_DONE);
				event = TOMBS_OF_AMASCUT;
				container = client.getItemContainer(InventoryID.TOA_CHESTS);
				metadata = new int[]{ raidLevel, teamSize, raidDamage };
				chestLooted = true;
				break;
			case InterfaceID.MISC_COLLECTION:
				event = "Kingdom of Miscellania";
				container = client.getItemContainer(InventoryID.MISC_RESOURCES_COLLECTED);
				break;
			case InterfaceID.TRAWLER_REWARD:
				event = "Fishing Trawler";
				metadata = client.getBoostedSkillLevel(Skill.FISHING);
				container = client.getItemContainer(InventoryID.TRAWLER_REWARDINV);
				break;
			case InterfaceID.FOSSIL_DRIFTNET:
				event = "Drift Net";
				metadata = client.getBoostedSkillLevel(Skill.FISHING);
				container = client.getItemContainer(InventoryID.MACRO_CERTER);
				break;
			case InterfaceID.WILDY_LOOT_CHEST:
				if (pvpKeysLooted)
				{
					return;
				}
				pvpKeysLooted = addPvpChestLoot();
				return;
			case InterfaceID.PMOON_REWARD:
				event = "Lunar Chest";
				container = client.getItemContainer(InventoryID.PMOON_REWARDINV);
				break;
			case InterfaceID.COLOSSEUM_REWARD_CHEST_2:
				if (chestLooted)
				{
					return;
				}
				event = "Fortis Colosseum";
				container = client.getItemContainer(InventoryID.COLOSSEUM_REWARDS);
				chestLooted = true;
				break;
			default:
				return;
		}

		if (container == null)
		{
			return;
		}

		final Collection<ItemStack> items = toItemStacks(container);

		if (config.showRaidsLootValue() && (event.equals(THEATRE_OF_BLOOD) || event.equals(CHAMBERS_OF_XERIC) || event.equals(TOMBS_OF_AMASCUT)))
		{
			long totalValue = items.stream()
				.filter(item -> item.getId() > -1)
				.mapToLong(item -> config.priceType() == LootTrackerPriceType.GRAND_EXCHANGE ?
					(long) itemManager.getItemPrice(item.getId()) * item.getQuantity() :
					(long) itemManager.getItemComposition(item.getId()).getHaPrice() * item.getQuantity())
				.sum();

			String chatMessage = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Your loot is worth around ")
				.append(ChatColorType.HIGHLIGHT)
				.append(QuantityFormatter.formatNumber(totalValue))
				.append(ChatColorType.NORMAL)
				.append(" coins.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
				.runeLiteFormattedMessage(chatMessage)
				.build());
		}

		if (items.isEmpty())
		{
			log.debug("No items to find for Event: {} | Container: {}", event, container);
			return;
		}

		addLoot(event, -1, LootRecordType.EVENT, metadata, items);
	}

	/**
	 * Creates loot chest entries for each loot key's tab in the PVP loot chest interface.
	 *
	 * @return {@code true} if loot was added, {@code false} otherwise.
	 */
	private boolean addPvpChestLoot()
	{
		boolean recordedLoot = false;

		for (int containerId : PVP_LOOT_KEY_CONTAINERS)
		{
			final Collection<ItemStack> items = toItemStacks(client.getItemContainer(containerId));
			if (items.isEmpty())
			{
				continue;
			}

			addLoot("Loot Chest", -1, LootRecordType.EVENT, null, items);
			recordedLoot = true;
		}

		return recordedLoot;
	}

	private static Collection<ItemStack> toItemStacks(@Nullable ItemContainer container)
	{
		if (container == null)
		{
			return Collections.emptyList();
		}

		return Arrays.stream(container.getItems())
			.filter(item -> item.getId() > -1)
			.map(item -> new ItemStack(item.getId(), item.getQuantity()))
			.collect(Collectors.toList());
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired event)
	{
		if (event.getScriptId() == ScriptID.DOM_LOOT_CLAIM)
		{
			// this is called after the loot has been claimed
			final Collection<ItemStack> items = toItemStacks(client.getItemContainer(InventoryID.DOM_LOOTPILE));

			String title = client.getWidget(InterfaceID.DomEndLevelUi.FRAME).getChild(1).getText(); // Level 2 Complete!
			int level = Integer.parseInt(title.split(" ")[1]);

			addLoot(DOM, -1, LootRecordType.EVENT, level, items);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		var chatType = event.getType();
		if (chatType != ChatMessageType.GAMEMESSAGE && chatType != ChatMessageType.SPAM
			&& chatType != ChatMessageType.MESBOX)
		{
			return;
		}

		final String message = event.getMessage();

		if (message.equals(CHEST_LOOTED_MESSAGE) || message.equals(OTHER_CHEST_LOOTED_MESSAGE)
			|| message.equals(DORGESH_KAAN_CHEST_LOOTED_MESSAGE) || message.equals(ALCHEMIST_SIGNET_CHEST_MESSAGE)
			|| GRUBBY_CHEST_LOOTED_MESSAGE.matcher(message).matches() || message.startsWith(ANCIENT_CHEST_LOOTED_MESSAGE)
			|| LARRAN_LOOTED_PATTERN.matcher(message).matches() || ROGUES_CHEST_PATTERN.matcher(message).matches())
		{
			final int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();

			log.debug("Chest loot matched '{}' region {}", message, regionID);
			if (!CHEST_EVENT_TYPES.containsKey(regionID))
			{
				return;
			}

			if (regionID == LAVA_MAZE_NORTH_EAST_REGION) // Muddy Chest crowdsourcing needs F2P/P2P world
			{
				onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, CHEST_EVENT_TYPES.get(regionID),
					client.getWorld()));
				return;
			}

			if (SLAYER_CHEST_EVENT_TYPES.contains(CHEST_EVENT_TYPES.get(regionID)))
			{
				onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, CHEST_EVENT_TYPES.get(regionID),
					client.getBoostedSkillLevel(Skill.FISHING)));
				return;
			}

			onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, CHEST_EVENT_TYPES.get(regionID)));
			return;
		}

		final Matcher zombiePirateLockerMatcher = ZOMBIE_PIRATE_LOCKER_PATTERN.matcher(message);
		if (zombiePirateLockerMatcher.matches())
		{
			processZombiePirateLockerLoot(zombiePirateLockerMatcher);
		}

		final Matcher shipwreckSalvagingMatcher = SALVAGE_PATTERN.matcher(message);
		if (shipwreckSalvagingMatcher.matches())
		{
			String tier = shipwreckSalvagingMatcher.group("tier");
			String eventName = WordUtils.capitalizeFully(tier) + " salvage";
			onInvChange(collectInvItems(LootRecordType.EVENT, eventName));
			return;
		}

		if (message.equals(HERBIBOAR_LOOTED_MESSAGE))
		{
			if (processHerbiboarHerbSackLoot(event.getTimestamp()))
			{
				return;
			}

			onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, HERBIBOAR_EVENT, client.getBoostedSkillLevel(Skill.HERBLORE)));
			return;
		}

		final int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();

		final Matcher hamStoreroomMatcher = HAM_CHEST_LOOTED_PATTERN.matcher(message);
		if (hamStoreroomMatcher.matches() && regionID == HAM_STOREROOM_REGION)
		{
			String keyType = hamStoreroomMatcher.group("key");
			onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, String.format("H.A.M. chest (%s)", keyType)));
			return;
		}

		final Matcher pickpocketMatcher = PICKPOCKET_REGEX.matcher(message);
		if (pickpocketMatcher.matches())
		{
			// Get the target's name as listed in the chat box
			String pickpocketTarget = WordUtils.capitalize(pickpocketMatcher.group("target"));

			// Occasional edge case where the pickpocket message doesn't list the correct name of the NPC (e.g. H.A.M. Members)
			if (PICKPOCKET_DISAMBIGUATION_MAP.get(lastPickpocketTarget).contains(pickpocketTarget))
			{
				pickpocketTarget = lastPickpocketTarget;
			}

			ignorePickpocketLoot = client.getTickCount();
			onInvChange(collectInvAndGroundItems(LootRecordType.PICKPOCKET, pickpocketTarget));
			return;
		}

		// Check if message is for a clue scroll reward
		final Matcher m = CLUE_SCROLL_PATTERN.matcher(Text.removeTags(message));
		if (m.find())
		{
			final String type = m.group(1).toLowerCase();
			String eventType;
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
				default:
					log.debug("Unrecognized clue type: {}", type);
					return;
			}

			// Clue Scrolls use same InventoryID as Barrows
			onInvChange(InventoryID.TRAIL_REWARDINV, collectInvItems(LootRecordType.EVENT, eventType));

			return;
		}

		if (SHADE_CHEST_NO_KEY_PATTERN.matcher(message).matches())
		{
			// Player didn't have the key they needed.
			resetEvent();
			return;
		}

		// Check if message is a birdhouse type
		final Matcher matcher = BIRDHOUSE_PATTERN.matcher(message);
		if (matcher.matches())
		{
			final int xp = Integer.parseInt(matcher.group(1));
			final String type = BIRDHOUSE_XP_TO_TYPE.get(xp);
			if (type == null)
			{
				log.debug("Unknown bird house type {}", xp);
				return;
			}

			onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, type, client.getBoostedSkillLevel(Skill.HUNTER)));
			return;
		}

		if (regionID == TEMPOROSS_REGION && message.startsWith(TEMPOROSS_LOOT_STRING))
		{
			onInvChange(collectInvItems(LootRecordType.EVENT, TEMPOROSS_EVENT, client.getBoostedSkillLevel(Skill.FISHING)));
			return;
		}

		if (regionID == GUARDIANS_OF_THE_RIFT_REGION && message.startsWith(GUARDIANS_OF_THE_RIFT_LOOT_STRING))
		{
			onInvChange(collectInvItems(LootRecordType.EVENT, GUARDIANS_OF_THE_RIFT_EVENT, client.getBoostedSkillLevel(Skill.RUNECRAFT)));
			return;
		}

		if (regionID == WINTERTODT_REGION && message.contains(WINTERTODT_LOOT_STRING))
		{
			onInvChange(collectInvItems(LootRecordType.EVENT, WINTERTODT_REWARD_CART_EVENT, client.getBoostedSkillLevel(Skill.FIREMAKING)));
			return;
		}

		if (regionID == FONT_OF_CONSUMPTION_REGION && message.equals(FONT_OF_CONSUMPTION_USE_MESSAGE))
		{
			onInvChange(collectInvItems(LootRecordType.EVENT, "Unsired"));
		}

		if (regionID == BA_LOBBY_REGION && chatType == ChatMessageType.MESBOX)
		{
			if (message.contains("High level gamble count:"))
			{
				onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, BA_HIGH_GAMBLE));
			}
		}

		if (message.startsWith("You rummage through the offerings"))
		{
			countChangedItems(ItemID.ENT_TOTEMS_LOOT, client.getBoostedSkillLevel(Skill.FLETCHING));
		}
		else if (message.equals("You clean a batch of arrowtips."))
		{
			countChangedItems(ItemID.DIRTY_ARROWTIPS, client.getBoostedSkillLevel(Skill.FLETCHING));
		}
	}

	private void countChangedItems(int itemId, Object metadata)
	{
		onInvChange((((invItems, groundItems, removedItems) ->
		{
			int cnt = removedItems.count(itemId);
			if (cnt > 0)
			{
				String name = itemManager.getItemComposition(itemId).getMembersName();
				List<ItemStack> combined = new ArrayList<>();
				combined.addAll(invItems);
				combined.addAll(groundItems);
				addLoot(name, -1, LootRecordType.EVENT, metadata, combined, cnt);
			}
		})));
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (pvpKeysLooted && event.getContainerId() == InventoryID.INV)
		{
			final ItemContainer inventory = client.getItemContainer(InventoryID.INV);
			pvpKeysLooted = PVP_LOOT_KEYS.stream().anyMatch((lootKeyId) -> inventory.contains(lootKeyId));
		}

		if (inventoryId == -1 || event.getContainerId() != inventoryId)
		{
			return;
		}

		final ItemContainer inventoryContainer = event.getItemContainer();
		Multiset<Integer> currentInventory = HashMultiset.create();
		Arrays.stream(inventoryContainer.getItems())
			.forEach(item -> currentInventory.add(item.getId(), item.getQuantity()));

		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
		final Collection<ItemStack> groundItems = lootManager.getItemSpawns(playerLocation);

		final Multiset<Integer> diff = Multisets.difference(currentInventory, inventorySnapshot);
		final Multiset<Integer> diffr = Multisets.difference(inventorySnapshot, currentInventory);

		final List<ItemStack> items = diff.entrySet().stream()
			.map(e -> new ItemStack(e.getElement(), e.getCount()))
			.collect(Collectors.toList());

		log.debug("Inv change: {} Ground items: {}", items, groundItems);

		if (inventorySnapshotCb != null)
		{
			inventorySnapshotCb.accept(items, groundItems, diffr);
		}

		resetEvent();
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (isNPCOp(event.getMenuAction()))
		{
			// There are some pickpocket targets who show up in the chat box with a different name (e.g. H.A.M. members -> man/woman)
			// We use the value selected from the right-click menu as a fallback for the event lookup in those cases.
			if (event.getMenuOption().equals("Pickpocket"))
			{
				lastPickpocketTarget = Text.removeTags(event.getMenuTarget());
			}
		}
		else if (isObjectOp(event.getMenuAction()) && event.getMenuOption().equals("Open") && SHADE_CHEST_OBJECTS.containsKey(event.getId()))
		{
			onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, SHADE_CHEST_OBJECTS.get(event.getId())));
		}
		else if (event.isItemOp())
		{
			if (event.getItemId() == ItemID.SEEDBOX && (event.getMenuOption().equals("Take") || event.getMenuOption().equals("Take-all")))
			{
				onInvChange(collectInvItems(LootRecordType.EVENT, SEEDPACK_EVENT));
			}
			else if (event.getMenuOption().equals("Search") && BIRDNEST_IDS.contains(event.getItemId()))
			{
				onInvChange(collectInvItems(LootRecordType.EVENT, BIRDNEST_EVENT));
			}
			else if (event.getMenuOption().equals("Open"))
			{
				switch (event.getItemId())
				{
					case ItemID.CASKET:
						onInvChange(collectInvItems(LootRecordType.EVENT, CASKET_EVENT));
						break;
					case ItemID.REWARD_GEM_BAG:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, BAG_FULL_OF_GEMS_PERCY_EVENT));
						break;
					case ItemID.REWARD_GEM_BAG_GUILD:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, BAG_FULL_OF_GEMS_BELONA_EVENT));
						break;
					case ItemID.STAR_REWARD_GEM_BAG:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, BAG_FULL_OF_GEMS_DUSURI_EVENT));
						break;
					case ItemID.WINT_REWARD_BOX:
					case ItemID.WINT_REROLL_BOX:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, WINTERTODT_SUPPLY_CRATE_EVENT));
						break;
					case ItemID.SOUL_WARS_SPOILS:
						onInvChange(collectInvItems(LootRecordType.EVENT, SPOILS_OF_WAR_EVENT));
						break;
					case ItemID.TEMPOROSS_REWARD_CASKET:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, TEMPOROSS_CASKET_EVENT));
						break;
					case ItemID.CAMDOZAAL_VAULT_CHEST_LOW:
					case ItemID.CAMDOZAAL_VAULT_CHEST_MID:
					case ItemID.CAMDOZAAL_VAULT_CHEST_HIGH:
					case ItemID.TOA_RUNE_CACHE:
					case ItemID.GOTR_INTRICATE_POUCH:
					case ItemID.FROZEN_CACHE:
					case ItemID.BH_EP_CRATE_2:
					case ItemID.BH_EP_CRATE_3:
					case ItemID.BH_EP_CRATE_4:
					case ItemID.BH_EP_CRATE_5:
					case ItemID.BH_EP_CRATE_6:
					case ItemID.BH_EP_CRATE_7:
					case ItemID.BH_EP_CRATE_8:
					case ItemID.BH_EP_CRATE_9:
					case ItemID.BH_EP_CRATE_10:
					case ItemID.MM_POTION_PACK_LOW:
					case ItemID.MM_POTION_PACK_MED:
					case ItemID.MM_POTION_PACK_HIGH:
					case ItemID.CASTLEWARS_CRATE:
					case ItemID.FORGOTTEN_LOCKBOX:
					case ItemID.YAMA_DOSSIER:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, itemManager.getItemComposition(event.getItemId()).getName()));
						break;
					case ItemID.CONSTRUCTION_SUPPLY_CRATE:
						onInvChange(collectInvItems(LootRecordType.EVENT, MAHOGANY_CRATE_EVENT, client.getBoostedSkillLevel(Skill.CONSTRUCTION)));
						break;
					case ItemID.HALLOWED_SACK:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, HALLOWED_SACK_EVENT));
						break;
					case ItemID.WBR_VM_OREPACK:
						onInvChange(collectInvItems(LootRecordType.EVENT, ORE_PACK_VM_EVENT));
						break;
					//Hunters loot sacks are stackable and multiple can be opened in one tick.
					//This provides an accurate count of how many were opened for each event
					case ItemID.HG_LOOTSACK_DROPTRACKING:
					case ItemID.HG_LOOTSACK_T0:
					case ItemID.HG_LOOTSACK_T1:
					case ItemID.HG_LOOTSACK_T2:
					case ItemID.HG_LOOTSACK_T3:
						final int itemId = event.getItemId();
						final Map<String, Integer> levels = new ImmutableMap.Builder<String, Integer>().
							put("WOODCUTTING", client.getBoostedSkillLevel(Skill.WOODCUTTING)).
							put("HERBLORE", client.getBoostedSkillLevel(Skill.HERBLORE)).
							put("HUNTER", client.getBoostedSkillLevel(Skill.HUNTER)).
							build();
						onInvChange((((invItems, groundItems, removedItems) ->
						{
							int cnt = removedItems.count(itemId);
							if (cnt > 0)
							{
								String name = itemManager.getItemComposition(itemId).getMembersName();
								addLoot(name, -1, LootRecordType.EVENT, levels, invItems, cnt);
							}
						})));
						break;
				}
			}
		}
	}

	private static boolean isNPCOp(MenuAction menuAction)
	{
		final int id = menuAction.getId();
		return id >= MenuAction.NPC_FIRST_OPTION.getId() && id <= MenuAction.NPC_FIFTH_OPTION.getId();
	}

	private static boolean isObjectOp(MenuAction menuAction)
	{
		final int id = menuAction.getId();
		return (id >= MenuAction.GAME_OBJECT_FIRST_OPTION.getId() && id <= MenuAction.GAME_OBJECT_FOURTH_OPTION.getId())
			|| id == MenuAction.GAME_OBJECT_FIFTH_OPTION.getId();
	}

	@Nullable
	private CompletableFuture<Void> submitLoot()
	{
		List<LootRecord> copy;
		synchronized (queuedLoots)
		{
			if (queuedLoots.isEmpty())
			{
				return null;
			}

			copy = new ArrayList<>(queuedLoots);
			queuedLoots.clear();
		}

		saveLoot(copy);

		if (client.getEnvironment() != 0)
		{
			return null;
		}

		log.debug("Submitting {} loot records", copy.size());

		return lootTrackerClient.submit(copy);
	}

	private Collection<ConfigLoot> combine(List<LootRecord> records)
	{
		Map<ConfigLoot, ConfigLoot> map = new HashMap<>();
		for (LootRecord record : records)
		{
			ConfigLoot key = new ConfigLoot(record.getType(), record.getEventId());
			ConfigLoot loot = map.computeIfAbsent(key, k -> key);
			loot.kills += record.getAmount();
			for (GameItem item : record.getDrops())
			{
				loot.add(item.getId(), item.getQty());
			}
		}
		return map.values();
	}

	private void saveLoot(List<LootRecord> records)
	{
		Instant now = Instant.now();
		Collection<ConfigLoot> combinedRecords = combine(records);
		for (ConfigLoot record : combinedRecords)
		{
			ConfigLoot lootConfig = getLootConfig(record.type, record.name);
			if (lootConfig == null)
			{
				lootConfig = record;
			}
			else
			{
				lootConfig.kills += record.kills;
				for (int i = 0; i < record.drops.length; i += 2)
				{
					lootConfig.add(record.drops[i], record.drops[i + 1]);
				}
			}
			lootConfig.last = now;
			setLootConfig(lootConfig.type, lootConfig.name, lootConfig);
		}
	}

	private void resetEvent()
	{
		inventoryId = -1;
		inventorySnapshot = null;
		inventorySnapshotCb = null;
		inventoryTimeout = 0;
	}

	@FunctionalInterface
	interface InvChangeCallback
	{
		void accept(Collection<ItemStack> invItems, Collection<ItemStack> groundItems, Multiset<Integer> removedItems);
	}

	private InvChangeCallback collectInvItems(LootRecordType type, String event)
	{
		return collectInvItems(type, event, null);
	}

	private InvChangeCallback collectInvItems(LootRecordType type, String event, Object metadata)
	{
		return (invItems, groundItems, removedItems) ->
			addLoot(event, -1, type, metadata, invItems);
	}

	private InvChangeCallback collectInvAndGroundItems(LootRecordType type, String event)
	{
		return collectInvAndGroundItems(type, event, null);
	}

	private InvChangeCallback collectInvAndGroundItems(LootRecordType type, String event, Object metadata)
	{
		return (invItems, groundItems, removedItems) ->
		{
			List<ItemStack> combined = new ArrayList<>();
			combined.addAll(invItems);
			combined.addAll(groundItems);
			addLoot(event, -1, type, metadata, combined);
		};
	}

	private void onInvChange(InvChangeCallback cb)
	{
		onInvChange(InventoryID.INV, cb);
	}

	private void onInvChange(int inv, InvChangeCallback cb)
	{
		onInvChange(inv, cb, INVCHANGE_TIMEOUT);
	}

	private void onInvChange(int inv, InvChangeCallback cb, int timeout)
	{
		inventoryId = inv;
		inventorySnapshot = HashMultiset.create();
		inventorySnapshotCb = cb;
		inventoryTimeout = timeout * Constants.GAME_TICK_LENGTH / Constants.CLIENT_TICK_LENGTH;

		final ItemContainer itemContainer = client.getItemContainer(inv);
		if (itemContainer != null)
		{
			Arrays.stream(itemContainer.getItems())
				.forEach(item -> inventorySnapshot.add(item.getId(), item.getQuantity()));
		}
	}

	private boolean processHerbiboarHerbSackLoot(int timestamp)
	{
		List<ItemStack> herbs = new ArrayList<>();

		for (MessageNode messageNode : client.getMessages())
		{
			if (messageNode.getTimestamp() != timestamp
				|| messageNode.getType() != ChatMessageType.SPAM)
			{
				continue;
			}

			Matcher matcher = HERBIBOAR_HERB_SACK_PATTERN.matcher(messageNode.getValue());
			if (matcher.matches())
			{
				herbs.add(new ItemStack(itemManager.search(matcher.group(1)).get(0).getId(), 1));
			}
		}

		if (herbs.isEmpty())
		{
			return false;
		}

		int herbloreLevel = client.getBoostedSkillLevel(Skill.HERBLORE);
		addLoot(HERBIBOAR_EVENT, -1, LootRecordType.EVENT, herbloreLevel, herbs);
		return true;
	}

	private void processZombiePirateLockerLoot(Matcher matcher)
	{
		final int quantity = Integer.parseInt(matcher.group("qty").replaceAll(",", ""));
		final String itemName = matcher.group("item");
		final int itemId = "Coins".equals(itemName) ? ItemID.COINS : itemManager.search(itemName).get(0).getId();
		addLoot(ZOMBIE_PIRATE_LOCKER_EVENT, -1, LootRecordType.EVENT, null, List.of(new ItemStack(itemId, quantity)));
	}

	@VisibleForTesting
	boolean inTobChestRegion()
	{
		int region = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
		return region == THEATRE_OF_BLOOD_REGION || region == THEATRE_OF_BLOOD_LOBBY;
	}

	void toggleItem(String name, boolean ignore)
	{
		final Set<String> ignoredItemSet = new LinkedHashSet<>(ignoredItems);

		if (ignore)
		{
			ignoredItemSet.add(name);
		}
		else
		{
			ignoredItemSet.remove(name);
		}

		config.setIgnoredItems(Text.toCSV(ignoredItemSet));
		// the config changed will update the panel
	}

	boolean isIgnored(String name)
	{
		return ignoredItems.contains(name);
	}

	void toggleEvent(String name, boolean ignore)
	{
		final Set<String> ignoredSet = new LinkedHashSet<>(ignoredEvents);

		if (ignore)
		{
			ignoredSet.add(name);
		}
		else
		{
			ignoredSet.remove(name);
		}

		config.setIgnoredEvents(Text.toCSV(ignoredSet));
		// the config changed will update the panel
	}

	boolean isEventIgnored(String name)
	{
		return ignoredEvents.contains(name);
	}

	private LootTrackerItem buildLootTrackerItem(int itemId, int quantity)
	{
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		final int gePrice = itemManager.getItemPrice(itemId);
		final int haPrice = itemComposition.getHaPrice();
		final boolean ignored = ignoredItems.contains(itemComposition.getMembersName());

		return new LootTrackerItem(
			itemId,
			itemComposition.getMembersName(),
			quantity,
			gePrice,
			haPrice,
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

	private LootTrackerRecord convertToLootTrackerRecord(final ConfigLoot configLoot)
	{
		LootTrackerItem[] items = new LootTrackerItem[configLoot.drops.length / 2];
		for (int i = 0; i < configLoot.drops.length; i += 2)
		{
			int id = configLoot.drops[i];
			int qty = configLoot.drops[i + 1];
			items[i >> 1] = buildLootTrackerItem(id, qty);
		}
		return new LootTrackerRecord(configLoot.name, "", configLoot.type, items, configLoot.kills);
	}

	/**
	 * Is player currently within the provided map regions
	 */
	private boolean isPlayerWithinMapRegion(Set<Integer> definedMapRegions)
	{
		final int[] mapRegions = client.getMapRegions();

		for (int region : mapRegions)
		{
			if (definedMapRegions.contains(region))
			{
				return true;
			}
		}

		return false;
	}

	private void lootReceivedChatMessage(final Collection<ItemStack> items, final String name)
	{
		long totalPrice = items.stream()
			.mapToLong(item -> config.priceType() == LootTrackerPriceType.GRAND_EXCHANGE ?
				(long) itemManager.getItemPrice(item.getId()) * item.getQuantity() :
				(long) itemManager.getItemComposition(item.getId()).getHaPrice() * item.getQuantity())
			.sum();

		final String message = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("You've killed ")
			.append(name)
			.append(" for ")
			.append(QuantityFormatter.quantityToStackSize(totalPrice))
			.append(" loot.")
			.build();

		chatMessageManager.queue(
			QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());
	}

	ConfigLoot getLootConfig(LootRecordType type, String name)
	{
		String profile = profileKey;
		if (Strings.isNullOrEmpty(profile))
		{
			log.debug("Trying to get loot with no profile!");
			return null;
		}

		String json = configManager.getConfiguration(LootTrackerConfig.GROUP, profile, "drops_" + type + "_" + name);
		if (json == null)
		{
			return null;
		}

		return gson.fromJson(json, ConfigLoot.class);
	}

	void setLootConfig(LootRecordType type, String name, ConfigLoot loot)
	{
		String profile = profileKey;
		if (Strings.isNullOrEmpty(profile))
		{
			log.debug("Trying to set loot with no profile!");
			return;
		}

		String json = gson.toJson(loot);
		configManager.setConfiguration(LootTrackerConfig.GROUP, profile, "drops_" + type + "_" + name, json);
	}

	void removeLootConfig(LootRecordType type, String name)
	{
		String profile = profileKey;
		if (Strings.isNullOrEmpty(profile))
		{
			log.debug("Trying to remove loot with no profile!");
			return;
		}

		configManager.unsetConfiguration(LootTrackerConfig.GROUP, profile, "drops_" + type + "_" + name);
	}

	void removeAllLoot()
	{
		String profile = profileKey;
		if (Strings.isNullOrEmpty(profile))
		{
			log.debug("Trying to clear loot with no profile!");
			return;
		}

		for (String key : configManager.getRSProfileConfigurationKeys(LootTrackerConfig.GROUP, profile, "drops_"))
		{
			configManager.unsetConfiguration(LootTrackerConfig.GROUP, profile, key);
		}
	}
}
