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
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
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
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.game.LootManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.util.Text;
import net.runelite.http.api.loottracker.GameItem;
import net.runelite.http.api.loottracker.LootAggregate;
import net.runelite.http.api.loottracker.LootRecord;
import net.runelite.http.api.loottracker.LootRecordType;
import net.runelite.http.api.loottracker.LootTrackerClient;
import okhttp3.OkHttpClient;
import org.apache.commons.text.WordUtils;

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
	private static final Pattern LARRAN_LOOTED_PATTERN = Pattern.compile("You have opened Larran's (big|small) chest .*");
	// Used by Stone Chest, Isle of Souls chest, Dark Chest
	private static final String OTHER_CHEST_LOOTED_MESSAGE = "You steal some loot from the chest.";
	private static final String DORGESH_KAAN_CHEST_LOOTED_MESSAGE = "You find treasure inside!";
	private static final String GRUBBY_CHEST_LOOTED_MESSAGE = "You have opened the Grubby Chest";
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
		build();

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

	// Soul Wars
	private static final String SPOILS_OF_WAR_EVENT = "Spoils of war";
	private static final Set<Integer> SOUL_WARS_REGIONS = ImmutableSet.of(8493, 8749, 9005);

	// Tempoross
	private static final String TEMPOROSS_EVENT = "Reward pool (Tempoross)";
	private static final String TEMPOROSS_CASKET_EVENT = "Casket (Tempoross)";
	private static final String TEMPOROSS_LOOT_STRING = "You found some loot: ";
	private static final int TEMPOROSS_REGION = 12588;

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

	private LootTrackerPanel panel;
	private NavigationButton navButton;
	@VisibleForTesting
	String eventType;
	@VisibleForTesting
	LootRecordType lootRecordType;
	private Object metadata;
	private boolean chestLooted;
	private String lastPickpocketTarget;

	private List<String> ignoredItems = new ArrayList<>();
	private List<String> ignoredEvents = new ArrayList<>();

	private Multiset<Integer> inventorySnapshot;

	@Getter(AccessLevel.PACKAGE)
	@Inject
	private LootTrackerClient lootTrackerClient;
	private final List<LootRecord> queuedLoots = new ArrayList<>();

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
	LootTrackerClient provideLootTrackerClient(OkHttpClient okHttpClient)
	{
		return new LootTrackerClient(okHttpClient);
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
		submitLoot();
		lootTrackerClient.setUuid(null);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("loottracker"))
		{
			ignoredItems = Text.fromCSV(config.getIgnoredItems());
			ignoredEvents = Text.fromCSV(config.getIgnoredEvents());
			SwingUtilities.invokeLater(panel::updateIgnoredRecords);
		}
	}

	@Override
	protected void startUp() throws Exception
	{
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
					if (!config.syncPanel())
					{
						return;
					}

					Collection<LootAggregate> lootRecords;
					try
					{
						lootRecords = lootTrackerClient.get();
					}
					catch (IOException e)
					{
						log.debug("Unable to look up loot", e);
						return;
					}

					log.debug("Loaded {} data entries", lootRecords.size());

					clientThread.invokeLater(() ->
					{
						Collection<LootTrackerRecord> records = convertToLootTrackerRecord(lootRecords);
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
		if (event.getGameState() == GameState.LOADING && !client.isInInstancedRegion())
		{
			chestLooted = false;
		}
	}

	void addLoot(@NonNull String name, int combatLevel, LootRecordType type, Object metadata, Collection<ItemStack> items)
	{
		final LootTrackerItem[] entries = buildEntries(stack(items));
		SwingUtilities.invokeLater(() -> panel.add(name, type, combatLevel, entries));

		if (config.saveLoot())
		{
			LootRecord lootRecord = new LootRecord(name, type, metadata, toGameItems(items), Instant.now());
			synchronized (queuedLoots)
			{
				queuedLoots.add(lootRecord);
			}
		}

		eventBus.post(new LootReceived(name, combatLevel, type, items));
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
		final ItemContainer container;

		switch (widgetLoaded.getGroupId())
		{
			case (WidgetID.BARROWS_REWARD_GROUP_ID):
				setEvent(LootRecordType.EVENT, "Barrows");
				container = client.getItemContainer(InventoryID.BARROWS_REWARD);
				break;
			case (WidgetID.CHAMBERS_OF_XERIC_REWARD_GROUP_ID):
				if (chestLooted)
				{
					return;
				}
				setEvent(LootRecordType.EVENT, "Chambers of Xeric");
				container = client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST);
				chestLooted = true;
				break;
			case (WidgetID.THEATRE_OF_BLOOD_GROUP_ID):
				if (chestLooted)
				{
					return;
				}
				int region = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
				if (region != THEATRE_OF_BLOOD_REGION && region != THEATRE_OF_BLOOD_LOBBY)
				{
					return;
				}
				setEvent(LootRecordType.EVENT, "Theatre of Blood");
				container = client.getItemContainer(InventoryID.THEATRE_OF_BLOOD_CHEST);
				chestLooted = true;
				break;
			case (WidgetID.CLUE_SCROLL_REWARD_GROUP_ID):
				// event type should be set via ChatMessage for clue scrolls.
				// Clue Scrolls use same InventoryID as Barrows
				container = client.getItemContainer(InventoryID.BARROWS_REWARD);

				if (eventType == null)
				{
					log.debug("Clue scroll reward interface with no event!");
					return;
				}
				break;
			case (WidgetID.KINGDOM_GROUP_ID):
				setEvent(LootRecordType.EVENT, "Kingdom of Miscellania");
				container = client.getItemContainer(InventoryID.KINGDOM_OF_MISCELLANIA);
				break;
			case (WidgetID.FISHING_TRAWLER_REWARD_GROUP_ID):
				setEvent(LootRecordType.EVENT, "Fishing Trawler", client.getBoostedSkillLevel(Skill.FISHING));
				container = client.getItemContainer(InventoryID.FISHING_TRAWLER_REWARD);
				break;
			case (WidgetID.DRIFT_NET_FISHING_REWARD_GROUP_ID):
				setEvent(LootRecordType.EVENT, "Drift Net", client.getBoostedSkillLevel(Skill.FISHING));
				container = client.getItemContainer(InventoryID.DRIFT_NET_FISHING_REWARD);
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

		if (config.showRaidsLootValue() && (eventType.equals("Theatre of Blood") || eventType.equals("Chambers of Xeric")))
		{
			long totalValue = items.stream()
				.filter(item -> item.getId() > -1)
				.mapToLong(item -> (long) (config.priceType() == LootTrackerPriceType.GRAND_EXCHANGE ?
					itemManager.getItemPrice(item.getId()) * item.getQuantity() :
					itemManager.getItemComposition(item.getId()).getHaPrice() * item.getQuantity()))
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
			log.debug("No items to find for Event: {} | Container: {}", eventType, container);
			return;
		}

		addLoot(eventType, -1, lootRecordType, metadata, items);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		final String message = event.getMessage();

		if (message.equals(CHEST_LOOTED_MESSAGE) || message.equals(OTHER_CHEST_LOOTED_MESSAGE)
			|| message.equals(DORGESH_KAAN_CHEST_LOOTED_MESSAGE) || message.startsWith(GRUBBY_CHEST_LOOTED_MESSAGE)
			|| LARRAN_LOOTED_PATTERN.matcher(message).matches())
		{
			final int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();
			if (!CHEST_EVENT_TYPES.containsKey(regionID))
			{
				return;
			}

			setEvent(LootRecordType.EVENT, CHEST_EVENT_TYPES.get(regionID));
			takeInventorySnapshot();

			return;
		}

		if (message.equals(COFFIN_LOOTED_MESSAGE) &&
			isPlayerWithinMapRegion(HALLOWED_SEPULCHRE_MAP_REGIONS))
		{
			setEvent(LootRecordType.EVENT, HALLOWED_SEPULCHRE_COFFIN_EVENT);
			takeInventorySnapshot();
			return;
		}

		if (message.equals(HERBIBOAR_LOOTED_MESSAGE))
		{
			if (processHerbiboarHerbSackLoot(event.getTimestamp()))
			{
				return;
			}

			setEvent(LootRecordType.EVENT, HERBIBOAR_EVENT, client.getBoostedSkillLevel(Skill.HERBLORE));
			takeInventorySnapshot();
			return;
		}

		final int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();
		if (HESPORI_REGION == regionID && message.equals(HESPORI_LOOTED_MESSAGE))
		{
			setEvent(LootRecordType.EVENT, HESPORI_EVENT);
			takeInventorySnapshot();
			return;
		}

		final Matcher hamStoreroomMatcher = HAM_CHEST_LOOTED_PATTERN.matcher(message);
		if (hamStoreroomMatcher.matches() && regionID == HAM_STOREROOM_REGION)
		{
			String keyType = hamStoreroomMatcher.group("key");
			setEvent(LootRecordType.EVENT, String.format("H.A.M. chest (%s)", keyType));
			takeInventorySnapshot();
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
				setEvent(LootRecordType.PICKPOCKET, lastPickpocketTarget);
			}
			else
			{
				setEvent(LootRecordType.PICKPOCKET, pickpocketTarget);
			}

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
					setEvent(LootRecordType.EVENT, "Clue Scroll (Beginner)");
					return;
				case "easy":
					setEvent(LootRecordType.EVENT, "Clue Scroll (Easy)");
					return;
				case "medium":
					setEvent(LootRecordType.EVENT, "Clue Scroll (Medium)");
					return;
				case "hard":
					setEvent(LootRecordType.EVENT, "Clue Scroll (Hard)");
					return;
				case "elite":
					setEvent(LootRecordType.EVENT, "Clue Scroll (Elite)");
					return;
				case "master":
					setEvent(LootRecordType.EVENT, "Clue Scroll (Master)");
					return;
			}
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

			setEvent(LootRecordType.EVENT, type, client.getBoostedSkillLevel(Skill.HUNTER));
			takeInventorySnapshot();
		}

		if (regionID == TEMPOROSS_REGION && message.startsWith(TEMPOROSS_LOOT_STRING))
		{
			setEvent(LootRecordType.EVENT, TEMPOROSS_EVENT, client.getBoostedSkillLevel(Skill.FISHING));
			takeInventorySnapshot();
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getContainerId() != InventoryID.INVENTORY.getId()
			|| eventType == null)
		{
			return;
		}

		if (CHEST_EVENT_TYPES.containsValue(eventType)
			|| SHADE_CHEST_OBJECTS.containsValue(eventType)
			|| HALLOWED_SEPULCHRE_COFFIN_EVENT.equals(eventType)
			|| HERBIBOAR_EVENT.equals(eventType)
			|| HESPORI_EVENT.equals(eventType)
			|| eventType.endsWith("Bird House")
			|| eventType.startsWith("H.A.M. chest")
			|| lootRecordType == LootRecordType.PICKPOCKET)
		{
			WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
			Collection<ItemStack> groundItems = lootManager.getItemSpawns(playerLocation);

			processInventoryLoot(eventType, lootRecordType, metadata, event.getItemContainer(), groundItems);
			resetEvent();
		}
		// Events that do not produce ground items
		else if (SEEDPACK_EVENT.equals(eventType)
			|| CASKET_EVENT.equals(eventType)
			|| BIRDNEST_EVENT.equals(eventType)
			|| SPOILS_OF_WAR_EVENT.equals(eventType)
			|| TEMPOROSS_EVENT.equals(eventType)
			|| TEMPOROSS_CASKET_EVENT.equals(eventType))
		{
			processInventoryLoot(eventType, lootRecordType, metadata, event.getItemContainer(), Collections.emptyList());
			resetEvent();
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		// There are some pickpocket targets who show up in the chat box with a different name (e.g. H.A.M. members -> man/woman)
		// We use the value selected from the right-click menu as a fallback for the event lookup in those cases.
		if (event.getMenuOption().equals("Pickpocket"))
		{
			lastPickpocketTarget = Text.removeTags(event.getMenuTarget());
		}

		if (event.getMenuOption().equals("Take") && event.getId() == ItemID.SEED_PACK)
		{
			setEvent(LootRecordType.EVENT, SEEDPACK_EVENT);
			takeInventorySnapshot();
		}

		if (event.getMenuOption().equals("Open") && SHADE_CHEST_OBJECTS.containsKey(event.getId()))
		{
			setEvent(LootRecordType.EVENT, SHADE_CHEST_OBJECTS.get(event.getId()));
			takeInventorySnapshot();
		}

		if (event.getMenuOption().equals("Search") && BIRDNEST_IDS.contains(event.getId()))
		{
			setEvent(LootRecordType.EVENT, BIRDNEST_EVENT, event.getId());
			takeInventorySnapshot();
		}

		if (event.getMenuOption().equals("Open") && event.getId() == ItemID.CASKET)
		{
			setEvent(LootRecordType.EVENT, CASKET_EVENT);
			takeInventorySnapshot();
		}

		if (event.getMenuOption().equals("Open") && event.getId() == ItemID.SPOILS_OF_WAR)
		{
			setEvent(LootRecordType.EVENT, SPOILS_OF_WAR_EVENT);
			takeInventorySnapshot();
		}

		if (event.getMenuOption().equals("Open") && event.getId() == ItemID.CASKET_25590)
		{
			setEvent(LootRecordType.EVENT, TEMPOROSS_CASKET_EVENT);
			takeInventorySnapshot();
		}
	}

	@Schedule(
		period = 5,
		unit = ChronoUnit.MINUTES,
		asynchronous = true
	)
	public void submitLootTask()
	{
		submitLoot();
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

		if (!config.saveLoot())
		{
			return null;
		}

		log.debug("Submitting {} loot records", copy.size());

		return lootTrackerClient.submit(copy);
	}

	private void setEvent(LootRecordType lootRecordType, String eventType, Object metadata)
	{
		this.lootRecordType = lootRecordType;
		this.eventType = eventType;
		this.metadata = metadata;
	}

	private void setEvent(LootRecordType lootRecordType, String eventType)
	{
		setEvent(lootRecordType, eventType, null);
	}

	private void resetEvent()
	{
		lootRecordType = null;
		eventType = null;
		metadata = null;
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

	private void processInventoryLoot(String event, LootRecordType lootRecordType, Object metadata, ItemContainer inventoryContainer, Collection<ItemStack> groundItems)
	{
		if (inventorySnapshot != null)
		{
			Multiset<Integer> currentInventory = HashMultiset.create();
			Arrays.stream(inventoryContainer.getItems())
				.forEach(item -> currentInventory.add(item.getId(), item.getQuantity()));

			groundItems.stream()
				.forEach(item -> currentInventory.add(item.getId(), item.getQuantity()));

			final Multiset<Integer> diff = Multisets.difference(currentInventory, inventorySnapshot);

			List<ItemStack> items = diff.entrySet().stream()
				.map(e -> new ItemStack(e.getElement(), e.getCount(), client.getLocalPlayer().getLocalLocation()))
				.collect(Collectors.toList());

			addLoot(event, -1, lootRecordType, metadata, items);

			inventorySnapshot = null;
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
		final boolean ignored = ignoredItems.contains(itemComposition.getName());

		return new LootTrackerItem(
			itemId,
			itemComposition.getName(),
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

	private Collection<LootTrackerRecord> convertToLootTrackerRecord(final Collection<LootAggregate> records)
	{
		return records.stream()
			.sorted(Comparator.comparing(LootAggregate::getLast_time))
			.map(record ->
			{
				LootTrackerItem[] drops = record.getDrops().stream().map(itemStack ->
					buildLootTrackerItem(itemStack.getId(), itemStack.getQty())
				).toArray(LootTrackerItem[]::new);

				return new LootTrackerRecord(record.getEventId(), "", record.getType(), drops, record.getAmount());
			})
			.collect(Collectors.toCollection(ArrayList::new));
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

	private long getTotalPrice(Collection<ItemStack> items)
	{
		long totalPrice = 0;

		for (final ItemStack itemStack : items)
		{
			totalPrice += (long) itemManager.getItemPrice(itemStack.getId()) * itemStack.getQuantity();
		}

		return totalPrice;
	}

	private void lootReceivedChatMessage(final Collection<ItemStack> items, final String name)
	{
		final String message = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("You've killed ")
			.append(name)
			.append(" for ")
			.append(QuantityFormatter.quantityToStackSize(getTotalPrice(items)))
			.append(" loot.")
			.build();

		chatMessageManager.queue(
			QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());
	}
}
