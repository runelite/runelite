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
	private static final Map<Integer, String> CHEST_EVENT_TYPES = new ImmutableMap.Builder<Integer, String>().
		put(5179, "Brimstone Chest").
		put(11573, "Crystal Chest").
		put(12093, "Larran's big chest").
		put(12127, "The Gauntlet").
		put(13113, "Larran's small chest").
		put(13151, "Elven Crystal Chest").
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
		build();

	// Hallow Sepulchre Coffin handling
	private static final String COFFIN_LOOTED_MESSAGE = "You push the coffin lid aside.";
	private static final String HALLOWED_SEPULCHRE_COFFIN_EVENT = "Coffin (Hallowed Sepulchre)";
	private static final Set<Integer> HALLOWED_SEPULCHRE_MAP_REGIONS = ImmutableSet.of(8797, 10077, 9308, 10074, 9050); // one map region per floor

	// Last man standing map regions
	private static final Set<Integer> LAST_MAN_STANDING_REGIONS = ImmutableSet.of(13658, 13659, 13914, 13915, 13916);

	private static final Pattern PICKPOCKET_REGEX = Pattern.compile("You pick (the )?(?<target>.+)'s? pocket.*");

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
	private OkHttpClient okHttpClient;

	private LootTrackerPanel panel;
	private NavigationButton navButton;
	@VisibleForTesting
	String eventType;
	@VisibleForTesting
	LootRecordType lootRecordType;
	private boolean chestLooted;
	private String lastPickpocketTarget;

	private List<String> ignoredItems = new ArrayList<>();
	private List<String> ignoredEvents = new ArrayList<>();

	private Multiset<Integer> inventorySnapshot;

	@Getter(AccessLevel.PACKAGE)
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
			lootTrackerClient = new LootTrackerClient(okHttpClient, accountSession.getUuid());
		}
		else
		{
			lootTrackerClient = null;
		}
	}

	@Subscribe
	public void onSessionClose(SessionClose sessionClose)
	{
		submitLoot();
		lootTrackerClient = null;
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

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel_icon.png");

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
			lootTrackerClient = new LootTrackerClient(okHttpClient, accountSession.getUuid());

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
		lootTrackerClient = null;
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

	void addLoot(@NonNull String name, int combatLevel, LootRecordType type, Collection<ItemStack> items)
	{
		final LootTrackerItem[] entries = buildEntries(stack(items));
		SwingUtilities.invokeLater(() -> panel.add(name, type, combatLevel, entries));

		if (config.saveLoot())
		{
			LootRecord lootRecord = new LootRecord(name, type, toGameItems(items), Instant.now());
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

		addLoot(name, combat, LootRecordType.NPC, items);

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
		// Ignore Last Man Standing player loots
		if (isPlayerWithinMapRegion(LAST_MAN_STANDING_REGIONS))
		{
			return;
		}

		final Player player = playerLootReceived.getPlayer();
		final Collection<ItemStack> items = playerLootReceived.getItems();
		final String name = player.getName();
		final int combat = player.getCombatLevel();

		addLoot(name, combat, LootRecordType.PLAYER, items);

		if (config.pvpKillChatMessage())
		{
			lootReceivedChatMessage(items, name);
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		final String event;
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
				event = "Chambers of Xeric";
				container = client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST);
				chestLooted = true;
				break;
			case (WidgetID.THEATRE_OF_BLOOD_GROUP_ID):
				if (chestLooted)
				{
					return;
				}
				int region = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
				if (region != THEATRE_OF_BLOOD_REGION)
				{
					return;
				}
				event = "Theatre of Blood";
				container = client.getItemContainer(InventoryID.THEATRE_OF_BLOOD_CHEST);
				chestLooted = true;
				break;
			case (WidgetID.CLUE_SCROLL_REWARD_GROUP_ID):
				// event type should be set via ChatMessage for clue scrolls.
				// Clue Scrolls use same InventoryID as Barrows
				event = eventType;
				container = client.getItemContainer(InventoryID.BARROWS_REWARD);

				if (event == null)
				{
					log.debug("Clue scroll reward interface with no event!");
					return;
				}
				break;
			case (WidgetID.KINGDOM_GROUP_ID):
				event = "Kingdom of Miscellania";
				container = client.getItemContainer(InventoryID.KINGDOM_OF_MISCELLANIA);
				break;
			case (WidgetID.FISHING_TRAWLER_REWARD_GROUP_ID):
				event = "Fishing Trawler";
				container = client.getItemContainer(InventoryID.FISHING_TRAWLER_REWARD);
				break;
			case (WidgetID.DRIFT_NET_FISHING_REWARD_GROUP_ID):
				event = "Drift Net";
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

		if (config.showRaidsLootValue() && (event.equals("Theatre of Blood") || event.equals("Chambers of Xeric")))
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
			log.debug("No items to find for Event: {} | Container: {}", event, container);
			return;
		}

		addLoot(event, -1, LootRecordType.EVENT, items);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		final String message = event.getMessage();

		if (message.equals(CHEST_LOOTED_MESSAGE) || LARRAN_LOOTED_PATTERN.matcher(message).matches())
		{
			final int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();
			if (!CHEST_EVENT_TYPES.containsKey(regionID))
			{
				return;
			}

			eventType = CHEST_EVENT_TYPES.get(regionID);
			lootRecordType = LootRecordType.EVENT;
			takeInventorySnapshot();

			return;
		}

		if (message.equals(COFFIN_LOOTED_MESSAGE) &&
			isPlayerWithinMapRegion(HALLOWED_SEPULCHRE_MAP_REGIONS))
		{
			eventType = HALLOWED_SEPULCHRE_COFFIN_EVENT;
			lootRecordType = LootRecordType.EVENT;
			takeInventorySnapshot();
			return;
		}

		if (message.equals(HERBIBOAR_LOOTED_MESSAGE))
		{
			if (processHerbiboarHerbSackLoot(event.getTimestamp()))
			{
				return;
			}

			eventType = HERBIBOAR_EVENT;
			lootRecordType = LootRecordType.EVENT;
			takeInventorySnapshot();
			return;
		}

		final int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();
		if (HESPORI_REGION == regionID && message.equals(HESPORI_LOOTED_MESSAGE))
		{
			eventType = HESPORI_EVENT;
			lootRecordType = LootRecordType.EVENT;
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
				eventType = lastPickpocketTarget;
				lootRecordType = LootRecordType.PICKPOCKET;
			}
			else
			{
				eventType = pickpocketTarget;
				lootRecordType = LootRecordType.PICKPOCKET;
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
					eventType = "Clue Scroll (Beginner)";
					lootRecordType = LootRecordType.EVENT;
					return;
				case "easy":
					eventType = "Clue Scroll (Easy)";
					lootRecordType = LootRecordType.EVENT;
					return;
				case "medium":
					eventType = "Clue Scroll (Medium)";
					lootRecordType = LootRecordType.EVENT;
					return;
				case "hard":
					eventType = "Clue Scroll (Hard)";
					lootRecordType = LootRecordType.EVENT;
					return;
				case "elite":
					eventType = "Clue Scroll (Elite)";
					lootRecordType = LootRecordType.EVENT;
					return;
				case "master":
					eventType = "Clue Scroll (Master)";
					lootRecordType = LootRecordType.EVENT;
					return;
			}
		}

		if (SHADE_CHEST_NO_KEY_PATTERN.matcher(message).matches())
		{
			// Player didn't have the key they needed.
			eventType = null;
			lootRecordType = null;
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getContainerId() != InventoryID.INVENTORY.getId())
		{
			return;
		}

		if (CHEST_EVENT_TYPES.containsValue(eventType)
			|| SHADE_CHEST_OBJECTS.containsValue(eventType)
			|| HALLOWED_SEPULCHRE_COFFIN_EVENT.equals(eventType)
			|| HERBIBOAR_EVENT.equals(eventType)
			|| HESPORI_EVENT.equals(eventType)
			|| SEEDPACK_EVENT.equals(eventType)
			|| CASKET_EVENT.equals(eventType)
			|| lootRecordType == LootRecordType.PICKPOCKET)
		{
			WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
			Collection<ItemStack> groundItems = lootManager.getItemSpawns(playerLocation);

			processInventoryLoot(eventType, lootRecordType, event.getItemContainer(), groundItems);
			eventType = null;
			lootRecordType = null;
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
			eventType = SEEDPACK_EVENT;
			lootRecordType = LootRecordType.EVENT;
			takeInventorySnapshot();
		}

		if (event.getMenuOption().equals("Open") && SHADE_CHEST_OBJECTS.containsKey(event.getId()))
		{
			eventType = SHADE_CHEST_OBJECTS.get(event.getId());
			lootRecordType = LootRecordType.EVENT;
			takeInventorySnapshot();
		}

		if (event.getMenuOption().equals("Open") && event.getId() == ItemID.CASKET)
		{
			eventType = CASKET_EVENT;
			lootRecordType = LootRecordType.EVENT;
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

		if (lootTrackerClient == null || !config.saveLoot())
		{
			return null;
		}

		log.debug("Submitting {} loot records", copy.size());

		CompletableFuture<Void> future = lootTrackerClient.submit(copy);
		return future;
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

	private void processInventoryLoot(String event, LootRecordType lootRecordType, ItemContainer inventoryContainer, Collection<ItemStack> groundItems)
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

			addLoot(event, -1, lootRecordType, items);

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

		addLoot(HERBIBOAR_EVENT, -1, LootRecordType.EVENT, herbs);
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
