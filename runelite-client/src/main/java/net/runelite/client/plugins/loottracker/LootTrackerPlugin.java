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
import java.util.Objects;
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
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.Tile;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.PostClientTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
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
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.events.RuneScapeProfileChanged;
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

	// Activity/Event loot handling
	private static final Pattern CLUE_SCROLL_PATTERN = Pattern.compile("You have completed [0-9]+ ([a-z]+) Treasure Trails?\\.");
	private static final int THEATRE_OF_BLOOD_REGION = 12867;
	private static final int THEATRE_OF_BLOOD_LOBBY = 14642;

	// Herbiboar loot handling
	@VisibleForTesting
	static final String HERBIBOAR_LOOTED_MESSAGE = "You harvest herbs from the herbiboar, whereupon it escapes.";
	private static final String HERBIBOAR_EVENT = "Herbiboar";
	private static final Pattern HERBIBOAR_HERB_SACK_PATTERN = Pattern.compile(".+(Grimy .+?) herb.+");

	// Seed Pack loot handling
	private static final String SEEDPACK_EVENT = "Seed pack";

	// Hespori loot handling
	private static final String HESPORI_LOOTED_MESSAGE = "You have successfully cleared this patch for new crops.";
	private static final String HESPORI_EVENT = "Hespori";
	private static final int HESPORI_REGION = 5021;

	// Chest loot handling
	private static final String CHEST_LOOTED_MESSAGE = "You find some treasure in the chest!";
	private static final Pattern ROGUES_CHEST_PATTERN = Pattern.compile("You find (a|some)([a-z\\s]*) inside.");
	private static final Pattern LARRAN_LOOTED_PATTERN = Pattern.compile("You have opened Larran's (big|small) chest .*");
	// Used by Stone Chest, Isle of Souls chest, Dark Chest
	private static final String OTHER_CHEST_LOOTED_MESSAGE = "You steal some loot from the chest.";
	private static final String DORGESH_KAAN_CHEST_LOOTED_MESSAGE = "You find treasure inside!";
	private static final String GRUBBY_CHEST_LOOTED_MESSAGE = "You have opened the Grubby Chest";
	private static final String ANCIENT_CHEST_LOOTED_MESSAGE = "You open the chest and find";
	private static final Pattern HAM_CHEST_LOOTED_PATTERN = Pattern.compile("Your (?<key>[a-z]+) key breaks in the lock.*");
	private static final int HAM_STOREROOM_REGION = 10321;
	private static final Map<Integer, String> CHEST_EVENT_TYPES = new ImmutableMap.Builder<Integer, String>().
		put(5179, "Brimstone Chest").
		put(11573, "Crystal Chest").
		put(12093, "Larran's big chest").
		put(12127, "The Gauntlet").
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
		put(ObjectID.BRONZE_CHEST, "Bronze key red").
		put(ObjectID.BRONZE_CHEST_4112, "Bronze key brown").
		put(ObjectID.BRONZE_CHEST_4113, "Bronze key crimson").
		put(ObjectID.BRONZE_CHEST_4114, "Bronze key black").
		put(ObjectID.BRONZE_CHEST_4115, "Bronze key purple").
		put(ObjectID.STEEL_CHEST, "Steel key red").
		put(ObjectID.STEEL_CHEST_4117, "Steel key brown").
		put(ObjectID.STEEL_CHEST_4118, "Steel key crimson").
		put(ObjectID.STEEL_CHEST_4119, "Steel key black").
		put(ObjectID.STEEL_CHEST_4120, "Steel key purple").
		put(ObjectID.BLACK_CHEST, "Black key red").
		put(ObjectID.BLACK_CHEST_4122, "Black key brown").
		put(ObjectID.BLACK_CHEST_4123, "Black key crimson").
		put(ObjectID.BLACK_CHEST_4124, "Black key black").
		put(ObjectID.BLACK_CHEST_4125, "Black key purple").
		put(ObjectID.SILVER_CHEST, "Silver key red").
		put(ObjectID.SILVER_CHEST_4127, "Silver key brown").
		put(ObjectID.SILVER_CHEST_4128, "Silver key crimson").
		put(ObjectID.SILVER_CHEST_4129, "Silver key black").
		put(ObjectID.SILVER_CHEST_4130, "Silver key purple").
		put(ObjectID.GOLD_CHEST, "Gold key red").
		put(ObjectID.GOLD_CHEST_41213, "Gold key brown").
		put(ObjectID.GOLD_CHEST_41214, "Gold key crimson").
		put(ObjectID.GOLD_CHEST_41215, "Gold key black").
		put(ObjectID.GOLD_CHEST_41216, "Gold key purple").
		build();

	// Hallow Sepulchre Coffin handling
	private static final String COFFIN_LOOTED_MESSAGE = "You push the coffin lid aside.";
	private static final String HALLOWED_SEPULCHRE_COFFIN_EVENT = "Coffin (Hallowed Sepulchre)";
	private static final Set<Integer> HALLOWED_SEPULCHRE_MAP_REGIONS = ImmutableSet.of(8797, 10077, 9308, 10074, 9050); // one map region per floor

	private static final String HALLOWED_SACK_EVENT = "Hallowed Sack";

	// Last man standing map regions
	private static final Set<Integer> LAST_MAN_STANDING_REGIONS = ImmutableSet.of(13658, 13659, 13660, 13914, 13915, 13916, 13918, 13919, 13920, 14174, 14175, 14176, 14430, 14431, 14432);

	private static final Pattern PICKPOCKET_REGEX = Pattern.compile("You pick (the )?(?<target>.+)'s? pocket.*");

	private static final String BIRDNEST_EVENT = "Bird nest";
	private static final Set<Integer> BIRDNEST_IDS = ImmutableSet.of(ItemID.BIRD_NEST, ItemID.BIRD_NEST_5071, ItemID.BIRD_NEST_5072, ItemID.BIRD_NEST_5073, ItemID.BIRD_NEST_5074, ItemID.BIRD_NEST_7413, ItemID.BIRD_NEST_13653, ItemID.BIRD_NEST_22798, ItemID.BIRD_NEST_22800);

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

	// Implings
	private static final Set<Integer> IMPLING_JARS = ImmutableSet.of(
		ItemID.BABY_IMPLING_JAR,
		ItemID.YOUNG_IMPLING_JAR,
		ItemID.GOURMET_IMPLING_JAR,
		ItemID.EARTH_IMPLING_JAR,
		ItemID.ESSENCE_IMPLING_JAR,
		ItemID.ECLECTIC_IMPLING_JAR,
		ItemID.NATURE_IMPLING_JAR,
		ItemID.MAGPIE_IMPLING_JAR,
		ItemID.NINJA_IMPLING_JAR,
		ItemID.CRYSTAL_IMPLING_JAR,
		ItemID.DRAGON_IMPLING_JAR,
		ItemID.LUCKY_IMPLING_JAR
	);
	private static final String IMPLING_CATCH_MESSAGE = "You manage to catch the impling and acquire some loot.";

	// Raids
	private static final String CHAMBERS_OF_XERIC = "Chambers of Xeric";
	private static final String THEATRE_OF_BLOOD = "Theatre of Blood";
	private static final String TOMBS_OF_AMASCUT = "Tombs of Amascut";

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
	private boolean lastLoadingIntoInstance;
	private String lastPickpocketTarget;

	private List<String> ignoredItems = new ArrayList<>();
	private List<String> ignoredEvents = new ArrayList<>();

	private InventoryID inventoryId;
	private Multiset<Integer> inventorySnapshot;
	private InvChangeCallback inventorySnapshotCb;

	private String groundSnapshotName;
	private int groundSnapshotCombatLevel;
	private int groundSnapshotCycleDelay;
	private Multiset<Integer> groundSnapshot;
	private int groundSnapshotRegion;

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

			if (!config.syncPanel())
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
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		profileKey = null;
		ignoredItems = Text.fromCSV(config.getIgnoredItems());
		ignoredEvents = Text.fromCSV(config.getIgnoredEvents());
		panel = new LootTrackerPanel(this, itemManager, config);
		spriteManager.getSpriteAsync(SpriteID.TAB_INVENTORY, 0, panel::loadHeaderIcon);

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

	void addLoot(@NonNull String name, int combatLevel, LootRecordType type, Object metadata, Collection<ItemStack> items)
	{
		addLoot(name, combatLevel, type, metadata, items, 1);
	}

	void addLoot(@NonNull String name, int combatLevel, LootRecordType type, Object metadata, Collection<ItemStack> items, int amount)
	{
		final LootTrackerItem[] entries = buildEntries(stack(items));
		SwingUtilities.invokeLater(() -> panel.add(name, type, combatLevel, entries, amount));

		LootRecord lootRecord = new LootRecord(name, type, metadata, toGameItems(items), Instant.now(), getLootWorldId());
		synchronized (queuedLoots)
		{
			queuedLoots.add(lootRecord);
		}

		eventBus.post(new LootReceived(name, combatLevel, type, items, amount));
	}

	private Integer getLootWorldId()
	{
		// For the wiki to determine drop rates based on dmm brackets / identify leagues drops
		var worldType = client.getWorldType();
		return worldType.contains(WorldType.SEASONAL) || worldType.contains(WorldType.TOURNAMENT_WORLD) ? client.getWorld() : null;
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		var npc = npcDespawned.getNpc();
		if (npc.getId() == NpcID.THE_WHISPERER || npc.getId() == NpcID.THE_WHISPERER_12206)
		{
			// Whisperer death:
			//   loot spawn at z=0, which you can't see since you are in the shadow realm on z=3
			//   npc despawn on z=3
			//   player teleport from z=3 to z=0
			//   server sends zone clear packet
			//   server spawns in the loot, along with any other items already on the ground
			//
			// We take advantage of that the items left on z=0 when you move into the shadow realm are not
			// cleared until the zoneclear packet. So if you record them at the time the whisperer despawns,
			// you can subtract it from the spawned items at the end of the tick.

			// collect all items on z=0
			Multiset<Integer> ground = HashMultiset.create();
			var scene = client.getScene();
			Tile[][] p0 = scene.getTiles()[0];
			Arrays.stream(p0)
				.flatMap(Arrays::stream)
				.filter(Objects::nonNull)
				.map(Tile::getGroundItems)
				.filter(Objects::nonNull)
				.flatMap(Collection::stream)
				.forEach(item -> ground.add(item.getId(), item.getQuantity()));

			groundSnapshotName = npc.getName();
			groundSnapshotCombatLevel = npc.getCombatLevel();
			// the entire arena is in an instance, which appears to be never region aligned,
			// however the template is, so use the region id from it.
			// the player location can't be used because on death the player might have already been teleported.
			groundSnapshotRegion = WorldPoint.fromLocalInstance(client, npc.getLocalLocation()).getRegionID();
			groundSnapshot = ground;
			// the loot spawns next tick, which is typically in 30 cycles, but
			// network latency can cause it to happen a little later instead.
			// use 59 to be safe.
			groundSnapshotCycleDelay = 59;

			log.debug("Ground snapshot: Recorded ground items {} on cycle {} region {}", ground, client.getGameCycle(), groundSnapshotRegion);
		}
	}

	@Subscribe
	public void onPostClientTick(PostClientTick postClientTick)
	{
		if (groundSnapshotCycleDelay > 0)
		{
			groundSnapshotCycleDelay--;

			if (groundSnapshotCycleDelay == 0)
			{
				log.debug("Ground snapshot: Loot timeout");
				groundSnapshotName = null;
				groundSnapshotCombatLevel = 0;
				groundSnapshot = null;
				return;
			}

			var region = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
			if (region != groundSnapshotRegion)
			{
				log.debug("Ground snapshot: In wrong region {} != {}", region, groundSnapshotRegion);
				return;
			}

			Multiset<Integer> ground = HashMultiset.create();
			var scene = client.getScene();
			Tile[][] p0 = scene.getTiles()[0];
			Arrays.stream(p0)
				.flatMap(Arrays::stream)
				.filter(Objects::nonNull)
				.map(Tile::getGroundItems)
				.filter(Objects::nonNull)
				.flatMap(Collection::stream)
				.forEach(item -> ground.add(item.getId(), item.getQuantity()));

			var diff = Multisets.difference(ground, groundSnapshot);
			if (diff.isEmpty())
			{
				// loot is not spawned yet
				log.debug("Ground snapshot: No loot yet");
				return;
			}

			log.debug("Ground snapshot: Loot received {} on cycle {}", diff, client.getGameCycle());

			// convert to item stack
			var items = diff.entrySet().stream()
				.map(e -> new ItemStack(e.getElement(), e.getCount(), client.getLocalPlayer().getLocalLocation())) // made up location
				.collect(Collectors.toList());
			addLoot(groundSnapshotName, groundSnapshotCombatLevel, LootRecordType.NPC, null, items);

			groundSnapshotName = null;
			groundSnapshotCombatLevel = 0;
			groundSnapshot = null;
			groundSnapshotCycleDelay = 0;
		}
	}

	@Subscribe
	public void onNpcLootReceived(final NpcLootReceived npcLootReceived)
	{
		final NPC npc = npcLootReceived.getNpc();
		final Collection<ItemStack> items = npcLootReceived.getItems();
		final String name = npc.getName();
		final int combat = npc.getCombatLevel();

		addLoot(name, combat, LootRecordType.NPC, npc.getId(), items);

		if (config.npcKillChatMessage())
		{
			final String prefix = VOWELS.contains(Character.toLowerCase(name.charAt(0)))
				? "an"
				: "a";

			lootReceivedChatMessage(items, prefix + ' ' + name);
		}
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
			case (WidgetID.BARROWS_REWARD_GROUP_ID):
				event = "Barrows";
				container = client.getItemContainer(InventoryID.BARROWS_REWARD);
				break;
			case (WidgetID.CHAMBERS_OF_XERIC_REWARD_GROUP_ID):
				if (chestLooted)
				{
					return;
				}
				event = CHAMBERS_OF_XERIC;
				container = client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST);
				chestLooted = true;
				break;
			case (WidgetID.THEATRE_OF_BLOOD_GROUP_ID):
				if (chestLooted || !inTobChestRegion())
				{
					return;
				}
				event = THEATRE_OF_BLOOD;
				container = client.getItemContainer(InventoryID.THEATRE_OF_BLOOD_CHEST);
				chestLooted = true;
				break;
			case WidgetID.TOA_REWARD_GROUP_ID:
				if (chestLooted)
				{
					return;
				}

				int raidLevel = client.getVarbitValue(Varbits.TOA_RAID_LEVEL);
				int teamSize =
					Math.min(client.getVarbitValue(Varbits.TOA_MEMBER_0_HEALTH), 1) +
					Math.min(client.getVarbitValue(Varbits.TOA_MEMBER_1_HEALTH), 1) +
					Math.min(client.getVarbitValue(Varbits.TOA_MEMBER_2_HEALTH), 1) +
					Math.min(client.getVarbitValue(Varbits.TOA_MEMBER_3_HEALTH), 1) +
					Math.min(client.getVarbitValue(Varbits.TOA_MEMBER_4_HEALTH), 1) +
					Math.min(client.getVarbitValue(Varbits.TOA_MEMBER_5_HEALTH), 1) +
					Math.min(client.getVarbitValue(Varbits.TOA_MEMBER_6_HEALTH), 1) +
					Math.min(client.getVarbitValue(Varbits.TOA_MEMBER_7_HEALTH), 1);
				int raidDamage = client.getVarbitValue(Varbits.TOA_RAID_DAMAGE);
				event = TOMBS_OF_AMASCUT;
				container = client.getItemContainer(InventoryID.TOA_REWARD_CHEST);
				metadata = new int[]{ raidLevel, teamSize, raidDamage };
				chestLooted = true;
				break;
			case (WidgetID.KINGDOM_GROUP_ID):
				event = "Kingdom of Miscellania";
				container = client.getItemContainer(InventoryID.KINGDOM_OF_MISCELLANIA);
				break;
			case (WidgetID.FISHING_TRAWLER_REWARD_GROUP_ID):
				event = "Fishing Trawler";
				metadata = client.getBoostedSkillLevel(Skill.FISHING);
				container = client.getItemContainer(InventoryID.FISHING_TRAWLER_REWARD);
				break;
			case (WidgetID.DRIFT_NET_FISHING_REWARD_GROUP_ID):
				event = "Drift Net";
				metadata = client.getBoostedSkillLevel(Skill.FISHING);
				container = client.getItemContainer(InventoryID.DRIFT_NET_FISHING_REWARD);
				break;
			case WidgetID.WILDERNESS_LOOT_CHEST:
				if (chestLooted)
				{
					return;
				}
				event = "Loot Chest";
				container = client.getItemContainer(InventoryID.WILDERNESS_LOOT_CHEST);
				chestLooted = true;
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
			|| message.equals(DORGESH_KAAN_CHEST_LOOTED_MESSAGE) || message.startsWith(GRUBBY_CHEST_LOOTED_MESSAGE)
			|| message.startsWith(ANCIENT_CHEST_LOOTED_MESSAGE)
			|| LARRAN_LOOTED_PATTERN.matcher(message).matches() || ROGUES_CHEST_PATTERN.matcher(message).matches())
		{
			final int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();

			log.debug("Chest loot matched '{}' region {}", message, regionID);
			if (!CHEST_EVENT_TYPES.containsKey(regionID))
			{
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

		if (message.equals(COFFIN_LOOTED_MESSAGE) &&
			isPlayerWithinMapRegion(HALLOWED_SEPULCHRE_MAP_REGIONS))
		{
			onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, HALLOWED_SEPULCHRE_COFFIN_EVENT));
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
		if (HESPORI_REGION == regionID && message.equals(HESPORI_LOOTED_MESSAGE))
		{
			onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, HESPORI_EVENT));
			return;
		}

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
			onInvChange(InventoryID.BARROWS_REWARD, collectInvItems(LootRecordType.EVENT, eventType));

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

		if (message.equals(IMPLING_CATCH_MESSAGE))
		{
			onInvChange(collectInvItems(LootRecordType.EVENT, client.getLocalPlayer().getInteracting().getName()));
			return;
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		// when the wilderness chest empties, clear chest loot flag for the next key
		if (event.getContainerId() == InventoryID.WILDERNESS_LOOT_CHEST.getId()
			&& Arrays.stream(event.getItemContainer().getItems()).noneMatch(i -> i.getId() > -1))
		{
			log.debug("Resetting chest loot flag");
			chestLooted = false;
		}

		if (inventoryId == null || event.getContainerId() != inventoryId.getId())
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
			.map(e -> new ItemStack(e.getElement(), e.getCount(), client.getLocalPlayer().getLocalLocation()))
			.collect(Collectors.toList());

		log.debug("Inv change: {} Ground items: {}", items, groundItems);

		if (inventorySnapshotCb != null)
		{
			inventorySnapshotCb.accept(items, groundItems, diffr);
		}

		inventoryId = null;
		inventorySnapshot = null;
		inventorySnapshotCb = null;
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		// There are some pickpocket targets who show up in the chat box with a different name (e.g. H.A.M. members -> man/woman)
		// We use the value selected from the right-click menu as a fallback for the event lookup in those cases.
		if (isNPCOp(event.getMenuAction()) && event.getMenuOption().equals("Pickpocket"))
		{
			lastPickpocketTarget = Text.removeTags(event.getMenuTarget());
		}
		else if (isObjectOp(event.getMenuAction()) && event.getMenuOption().equals("Open") && SHADE_CHEST_OBJECTS.containsKey(event.getId()))
		{
			onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, SHADE_CHEST_OBJECTS.get(event.getId())));
		}
		else if (event.isItemOp())
		{
			if (event.getItemId() == ItemID.SEED_PACK && (event.getMenuOption().equals("Take") || event.getMenuOption().equals("Take-all")))
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
					case ItemID.SUPPLY_CRATE:
					case ItemID.EXTRA_SUPPLY_CRATE:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, WINTERTODT_SUPPLY_CRATE_EVENT));
						break;
					case ItemID.SPOILS_OF_WAR:
						onInvChange(collectInvItems(LootRecordType.EVENT, SPOILS_OF_WAR_EVENT));
						break;
					case ItemID.CASKET_25590:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, TEMPOROSS_CASKET_EVENT));
						break;
					case ItemID.SIMPLE_LOCKBOX_25647:
					case ItemID.ELABORATE_LOCKBOX_25649:
					case ItemID.ORNATE_LOCKBOX_25651:
					case ItemID.CACHE_OF_RUNES:
					case ItemID.INTRICATE_POUCH:
					case ItemID.FROZEN_CACHE:
					case ItemID.BOUNTY_CRATE_TIER_1:
					case ItemID.BOUNTY_CRATE_TIER_2:
					case ItemID.BOUNTY_CRATE_TIER_3:
					case ItemID.BOUNTY_CRATE_TIER_4:
					case ItemID.BOUNTY_CRATE_TIER_5:
					case ItemID.BOUNTY_CRATE_TIER_6:
					case ItemID.BOUNTY_CRATE_TIER_7:
					case ItemID.BOUNTY_CRATE_TIER_8:
					case ItemID.BOUNTY_CRATE_TIER_9:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, itemManager.getItemComposition(event.getItemId()).getName()));
						break;
					case ItemID.SUPPLY_CRATE_24884:
						onInvChange(collectInvItems(LootRecordType.EVENT, MAHOGANY_CRATE_EVENT, client.getBoostedSkillLevel(Skill.CONSTRUCTION)));
						break;
					case ItemID.HALLOWED_SACK:
						onInvChange(collectInvAndGroundItems(LootRecordType.EVENT, HALLOWED_SACK_EVENT));
						break;
					case ItemID.ORE_PACK_27693:
						onInvChange(collectInvItems(LootRecordType.EVENT, ORE_PACK_VM_EVENT));
						break;
				}
			}
			else if (event.getMenuOption().equals("Loot") && IMPLING_JARS.contains(event.getItemId()))
			{
				final int itemId = event.getItemId();
				onInvChange(((invItems, groundItems, removedItems) ->
				{
					int cnt = removedItems.count(itemId);
					if (cnt > 0)
					{
						String name = itemManager.getItemComposition(itemId).getMembersName();
						addLoot(name, -1, LootRecordType.EVENT, null, invItems, cnt);
					}
				}));
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
			loot.kills++;
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
		inventoryId = null;
		inventorySnapshot = null;
		inventorySnapshotCb = null;
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
		onInvChange(InventoryID.INVENTORY, cb);
	}

	private void onInvChange(InventoryID inv, InvChangeCallback cb)
	{
		inventoryId = inv;
		inventorySnapshot = HashMultiset.create();
		inventorySnapshotCb = cb;

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
				herbs.add(new ItemStack(itemManager.search(matcher.group(1)).get(0).getId(), 1, client.getLocalPlayer().getLocalLocation()));
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
