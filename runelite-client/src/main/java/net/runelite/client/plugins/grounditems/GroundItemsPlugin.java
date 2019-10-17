/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.grounditems;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.EvictingQueue;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Rectangle;
import static java.lang.Boolean.TRUE;
import static java.lang.Math.floor;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import static net.runelite.api.ItemID.*;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import net.runelite.api.Node;
import net.runelite.api.Player;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.TileItemPile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemQuantityChanged;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.util.Text;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.grounditems.config.ItemHighlightMode;
import static net.runelite.client.plugins.grounditems.config.ItemHighlightMode.OVERLAY;
import net.runelite.client.plugins.grounditems.config.MenuHighlightMode;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.BOTH;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.NAME;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.OPTION;
import net.runelite.client.plugins.grounditems.config.PriceDisplayMode;
import net.runelite.client.plugins.grounditems.config.TimerDisplayMode;
import net.runelite.client.plugins.grounditems.config.ValueCalculationMode;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.QuantityFormatter;

@PluginDescriptor(
	name = "Ground Items",
	description = "Highlight ground items and/or show price information",
	tags = {"grand", "exchange", "high", "alchemy", "prices", "highlight", "overlay"}
)
@Singleton
public class GroundItemsPlugin extends Plugin
{
	@Getter(AccessLevel.PUBLIC)
	public static final Map<GroundItem.GroundItemKey, GroundItem> collectedGroundItems = new LinkedHashMap<>();
	// ItemID for coins
	private static final int COINS = ItemID.COINS_995;
	// items stay on the ground for 30 mins in an instance
	private static final int INSTANCE_DURATION_MILLIS = 45 * 60 * 1000;
	private static final int INSTANCE_DURATION_TICKS = (int) floor(30 * 60 / 0.6);
	//untradeables stay on the ground for 150 seconds (http://oldschoolrunescape.wikia.com/wiki/Item#Dropping_and_Destroying)
	private static final int UNTRADEABLE_DURATION_MILLIS = 150 * 1000;
	private static final int UNTRADEABLE_DURATION_TICKS = (int) floor(150 / 0.6);
	//items stay on the ground for 1 hour after death
	private static final int DEATH_DURATION_MILLIS = 60 * 60 * 1000;
	private static final int DEATH_DURATION_TICKS = (int) floor(60 * 60 / 0.6);
	private static final int NORMAL_DURATION_MILLIS = 60 * 1000;
	private static final int NORMAL_DURATION_TICKS = (int) floor(60 / 0.6);
	// Ground item menu options
	private static final int FIRST_OPTION = MenuOpcode.GROUND_ITEM_FIRST_OPTION.getId();
	private static final int SECOND_OPTION = MenuOpcode.GROUND_ITEM_SECOND_OPTION.getId();
	private static final int THIRD_OPTION = MenuOpcode.GROUND_ITEM_THIRD_OPTION.getId(); // this is Take
	private static final int FOURTH_OPTION = MenuOpcode.GROUND_ITEM_FOURTH_OPTION.getId();
	private static final int FIFTH_OPTION = MenuOpcode.GROUND_ITEM_FIFTH_OPTION.getId();
	private static final int EXAMINE_ITEM = MenuOpcode.EXAMINE_ITEM_GROUND.getId();
	private static final int WALK = MenuOpcode.WALK.getId();
	private static final int CAST_ON_ITEM = MenuOpcode.SPELL_CAST_ON_GROUND_ITEM.getId();
	private static final String TELEGRAB_TEXT = ColorUtil.wrapWithColorTag("Telekinetic Grab", Color.GREEN) + ColorUtil.prependColorTag(" -> ", Color.WHITE);
	private final Map<Integer, Color> priceChecks = new LinkedHashMap<>();
	private final Queue<Integer> droppedItemQueue = EvictingQueue.create(16); // recently dropped items
	boolean highlightHerblore;
	boolean highlightPrayer;
	LoadingCache<String, Boolean> hiddenItems;
	static final ImmutableSet<Integer> herbloreItems = ImmutableSet.of
		(
			//Grimy Herbs
			GRIMY_GUAM_LEAF,
			GRIMY_GUAM_LEAF + 1,
			GRIMY_MARRENTILL,
			GRIMY_MARRENTILL + 1,
			GRIMY_TARROMIN,
			GRIMY_TARROMIN + 1,
			GRIMY_HARRALANDER,
			GRIMY_HARRALANDER + 1,
			GRIMY_RANARR_WEED,
			GRIMY_RANARR_WEED + 1,
			GRIMY_TOADFLAX,
			GRIMY_TOADFLAX + 1,
			GRIMY_IRIT_LEAF,
			GRIMY_IRIT_LEAF + 1,
			GRIMY_AVANTOE,
			GRIMY_AVANTOE + 1,
			GRIMY_KWUARM,
			GRIMY_KWUARM + 1,
			GRIMY_SNAPDRAGON,
			GRIMY_SNAPDRAGON + 1,
			GRIMY_CADANTINE,
			GRIMY_CADANTINE + 1,
			GRIMY_LANTADYME,
			GRIMY_LANTADYME + 1,
			GRIMY_DWARF_WEED,
			GRIMY_DWARF_WEED + 1,
			GRIMY_TORSTOL,
			GRIMY_TORSTOL + 1,

			//Clean Herbs
			GUAM_LEAF,
			GUAM_LEAF + 1,
			MARRENTILL,
			MARRENTILL + 1,
			TARROMIN,
			TARROMIN + 1,
			HARRALANDER,
			HARRALANDER + 1,
			RANARR_WEED,
			RANARR_WEED + 1,
			TOADFLAX,
			TOADFLAX + 1,
			IRIT_LEAF,
			IRIT_LEAF + 1,
			AVANTOE,
			AVANTOE + 1,
			KWUARM,
			KWUARM + 1,
			SNAPDRAGON,
			SNAPDRAGON + 1,
			CADANTINE,
			CADANTINE + 1,
			LANTADYME,
			LANTADYME + 1,
			DWARF_WEED,
			DWARF_WEED + 1,
			TORSTOL,
			TORSTOL + 1,

			//Secondary ingredients
			EYE_OF_NEWT,
			EYE_OF_NEWT + 1,
			UNICORN_HORN,
			UNICORN_HORN + 1,
			UNICORN_HORN_DUST,
			UNICORN_HORN_DUST + 1,
			LIMPWURT_ROOT,
			LIMPWURT_ROOT + 1,
			RED_SPIDERS_EGGS,
			RED_SPIDERS_EGGS + 1,
			CHOCOLATE_BAR,
			CHOCOLATE_BAR + 1,
			CHOCOLATE_DUST,
			CHOCOLATE_DUST + 1,
			TOADS_LEGS,
			TOADS_LEGS + 1,
			GOAT_HORN_DUST,
			GOAT_HORN_DUST + 1,
			DESERT_GOAT_HORN,
			DESERT_GOAT_HORN + 1,
			SNAPE_GRASS,
			SNAPE_GRASS + 1,
			MORT_MYRE_FUNGUS,
			MORT_MYRE_FUNGUS + 1,
			WHITE_BERRIES,
			WHITE_BERRIES + 1,
			BLUE_DRAGON_SCALE,
			BLUE_DRAGON_SCALE + 1,
			DRAGON_SCALE_DUST,
			DRAGON_SCALE_DUST + 1,
			WINE_OF_ZAMORAK,
			WINE_OF_ZAMORAK + 1,
			POTATO_CACTUS,
			POTATO_CACTUS + 1,
			BIRD_NEST,
			BIRD_NEST + 1,
			BIRD_NEST_5071,
			BIRD_NEST_5072,
			BIRD_NEST_5073,
			BIRD_NEST_5074,
			BIRD_NEST_5075,
			BIRD_NEST_7413,
			BIRD_NEST_13653,
			BIRD_NEST_22798,
			BIRD_NEST_22800,
			LAVA_SCALE,
			LAVA_SCALE + 1,
			LAVA_SCALE_SHARD,
			LAVA_SCALE_SHARD + 1,
			TORSTOL,
			TORSTOL + 1,
			SUPERIOR_DRAGON_BONES,
			SUPERIOR_DRAGON_BONES + 1,
			CRUSHED_SUPERIOR_DRAGON_BONES,
			CRUSHED_SUPERIOR_DRAGON_BONES + 1,
			AMYLASE_CRYSTAL,
			GARLIC,
			GARLIC + 1,

			//Jungle Potion herbs
			GRIMY_ARDRIGAL,
			GRIMY_ROGUES_PURSE,
			GRIMY_SITO_FOIL,
			GRIMY_SNAKE_WEED,
			GRIMY_VOLENCIA_MOSS,

			//Herb seeds
			GUAM_SEED,
			MARRENTILL_SEED,
			TARROMIN_SEED,
			HARRALANDER_SEED,
			GOUT_TUBER,
			RANARR_SEED,
			TOADFLAX_SEED,
			IRIT_SEED,
			AVANTOE_SEED,
			KWUARM_SEED,
			SNAPDRAGON_SEED,
			CADANTINE_SEED,
			LANTADYME_SEED,
			DWARF_WEED_SEED,
			TORSTOL_SEED,

			//Secondary seeds
			LIMPWURT_SEED,
			SNAPE_GRASS_SEED,
			POTATO_CACTUS_SEED,
			JANGERBERRY_SEED,
			POISON_IVY_SEED,
			BELLADONNA_SEED
		);
	static final ImmutableSet<Integer> prayerItems = ImmutableSet.of
		(
			//Bones
			BONES,
			BONES + 1,
			WOLF_BONES,
			WOLF_BONES + 1,
			BURNT_BONES,
			BURNT_BONES + 1,
			MONKEY_BONES,
			MONKEY_BONES + 1,
			BAT_BONES,
			BAT_BONES + 1,
			BIG_BONES,
			BIG_BONES + 1,
			JOGRE_BONES,
			JOGRE_BONES + 1,
			ZOGRE_BONES,
			ZOGRE_BONES + 1,
			SHAIKAHAN_BONES,
			SHAIKAHAN_BONES + 1,
			BABYDRAGON_BONES,
			BABYDRAGON_BONES + 1,
			WYRM_BONES,
			WYRM_BONES + 1,
			WYVERN_BONES,
			WYVERN_BONES + 1,
			DRAGON_BONES,
			DRAGON_BONES + 1,
			DRAKE_BONES,
			DRAKE_BONES + 1,
			FAYRG_BONES,
			FAYRG_BONES + 1,
			LAVA_DRAGON_BONES,
			LAVA_DRAGON_BONES + 1,
			RAURG_BONES,
			RAURG_BONES + 1,
			HYDRA_BONES,
			HYDRA_BONES + 1,
			DAGANNOTH_BONES,
			DAGANNOTH_BONES + 1,
			OURG_BONES,
			OURG_BONES + 1,
			SUPERIOR_DRAGON_BONES,
			SUPERIOR_DRAGON_BONES + 1,

			//Ensouled heads
			ENSOULED_ABYSSAL_HEAD_13508,
			ENSOULED_ABYSSAL_HEAD_13508 + 1,
			ENSOULED_AVIANSIE_HEAD_13505,
			ENSOULED_AVIANSIE_HEAD_13505 + 1,
			ENSOULED_BEAR_HEAD_13463,
			ENSOULED_BEAR_HEAD_13463 + 1,
			ENSOULED_BLOODVELD_HEAD_13496,
			ENSOULED_BLOODVELD_HEAD_13496 + 1,
			ENSOULED_CHAOS_DRUID_HEAD_13472,
			ENSOULED_CHAOS_DRUID_HEAD_13472 + 1,
			ENSOULED_DAGANNOTH_HEAD_13493,
			ENSOULED_DAGANNOTH_HEAD_13493 + 1,
			ENSOULED_DEMON_HEAD_13502,
			ENSOULED_DEMON_HEAD_13502 + 1,
			ENSOULED_DOG_HEAD_13469,
			ENSOULED_DOG_HEAD_13469 + 1,
			ENSOULED_DRAGON_HEAD_13511,
			ENSOULED_DRAGON_HEAD_13511 + 1,
			ENSOULED_ELF_HEAD_13481,
			ENSOULED_ELF_HEAD_13481 + 1,
			ENSOULED_GIANT_HEAD_13475,
			ENSOULED_GIANT_HEAD_13475 + 1,
			ENSOULED_GOBLIN_HEAD_13448,
			ENSOULED_GOBLIN_HEAD_13448 + 1,
			ENSOULED_HORROR_HEAD_13487,
			ENSOULED_HORROR_HEAD_13487 + 1,
			ENSOULED_IMP_HEAD_13454,
			ENSOULED_IMP_HEAD_13454 + 1,
			ENSOULED_KALPHITE_HEAD_13490,
			ENSOULED_KALPHITE_HEAD_13490 + 1,
			ENSOULED_MINOTAUR_HEAD_13457,
			ENSOULED_MINOTAUR_HEAD_13457 + 1,
			ENSOULED_MONKEY_HEAD_13451,
			ENSOULED_MONKEY_HEAD_13451 + 1,
			ENSOULED_OGRE_HEAD_13478,
			ENSOULED_OGRE_HEAD_13478 + 1,
			ENSOULED_SCORPION_HEAD_13460,
			ENSOULED_SCORPION_HEAD_13460 + 1,
			ENSOULED_TROLL_HEAD_13484,
			ENSOULED_TROLL_HEAD_13484 + 1,
			ENSOULED_TZHAAR_HEAD_13499,
			ENSOULED_TZHAAR_HEAD_13499 + 1,
			ENSOULED_UNICORN_HEAD_13466,
			ENSOULED_UNICORN_HEAD_13466 + 1
		);
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Map.Entry<Rectangle, GroundItem> textBoxBounds;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Map.Entry<Rectangle, GroundItem> hiddenBoxBounds;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Map.Entry<Rectangle, GroundItem> highlightBoxBounds;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hideAll;
	private List<String> hiddenItemList = new CopyOnWriteArrayList<>();
	private List<String> highlightedItemsList = new CopyOnWriteArrayList<>();
	@Inject
	private GroundItemInputListener inputListener;
	@Inject
	private MouseManager mouseManager;
	@Inject
	private KeyManager keyManager;
	@Inject
	private Client client;
	@Inject
	private ItemManager itemManager;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private GroundItemsConfig config;
	@Inject
	private GroundItemsOverlay overlay;
	@Inject
	private Notifier notifier;
	@Inject
	private EventBus eventBus;
	private LoadingCache<String, Boolean> highlightedItems;
	private Color defaultColor;
	private Color highlightedColor;
	private Color hiddenColor;
	private String getHighlightItems;
	@Getter(AccessLevel.PACKAGE)
	private boolean showHighlightedOnly;
	private ValueCalculationMode valueCalculationMode;
	private int getHighlightOverValue;
	private boolean notifyHighlightedDrops;
	private boolean dontHideUntradeables;
	private String getHiddenItems;
	private boolean recolorMenuHiddenItems;
	private int getHideUnderValue;
	private boolean removeIgnored;
	private boolean rightClickHidden;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightTiles;
	@Getter(AccessLevel.PACKAGE)
	private ItemHighlightMode itemHighlightMode;
	private MenuHighlightMode menuHighlightMode;
	private Color lowValueColor;
	private int lowValuePrice;
	private boolean notifyLowValueDrops;
	private Color mediumValueColor;
	private int mediumValuePrice;
	private boolean notifyMediumValueDrops;
	private Color highValueColor;
	private int highValuePrice;
	private boolean notifyHighValueDrops;
	private Color insaneValueColor;
	private int insaneValuePrice;
	private boolean notifyInsaneValueDrops;
	@Getter(AccessLevel.PACKAGE)
	private PriceDisplayMode priceDisplayMode;
	@Getter(AccessLevel.PACKAGE)
	private boolean sortByGEPrice;
	private boolean showMenuItemQuantities;
	private boolean collapseEntries;
	@Getter(AccessLevel.PACKAGE)
	private boolean onlyShowLoot;
	@Getter(AccessLevel.PACKAGE)
	private TimerDisplayMode showGroundItemDuration;
	@Getter(AccessLevel.PACKAGE)
	private int doubleTapDelay;
	@Getter(AccessLevel.PACKAGE)
	private boolean toggleOutline;
	@Getter(AccessLevel.PACKAGE)
	private boolean showTimer;
	@Getter(AccessLevel.PACKAGE)
	private Color bordercolor;
	private Color herbloreColor;
	private Color prayerColor;

	@Provides
	GroundItemsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroundItemsConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
		reset();
		mouseManager.registerMouseListener(inputListener);
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		mouseManager.unregisterMouseListener(inputListener);
		keyManager.unregisterKeyListener(inputListener);
		highlightedItems.invalidateAll();
		highlightedItems = null;
		hiddenItems.invalidateAll();
		hiddenItems = null;
		hiddenItemList = null;
		highlightedItemsList = null;
		collectedGroundItems.clear();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ItemSpawned.class, this, this::onItemSpawned);
		eventBus.subscribe(ItemDespawned.class, this, this::onItemDespawned);
		eventBus.subscribe(ItemQuantityChanged.class, this, this::onItemQuantityChanged);
		eventBus.subscribe(NpcLootReceived.class, this, this::onNpcLootReceived);
		eventBus.subscribe(PlayerLootReceived.class, this, this::onPlayerLootReceived);
		eventBus.subscribe(ClientTick.class, this, this::onClientTick);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(FocusChanged.class, this, this::onFocusChanged);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
	}

	private void onGameTick(GameTick event)
	{
		for (GroundItem item : collectedGroundItems.values())
		{
			if (item.getTicks() == -1)
			{
				continue;
			}
			item.setTicks(item.getTicks() - 1);
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("grounditems"))
		{
			updateConfig();
			reset();
		}
	}

	private void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			collectedGroundItems.clear();
		}
	}

	private void onItemSpawned(ItemSpawned itemSpawned)
	{
		TileItem item = itemSpawned.getItem();
		Tile tile = itemSpawned.getTile();

		GroundItem groundItem = buildGroundItem(tile, item);

		GroundItem.GroundItemKey groundItemKey = new GroundItem.GroundItemKey(item.getId(), tile.getWorldLocation());
		GroundItem existing = collectedGroundItems.putIfAbsent(groundItemKey, groundItem);
		if (existing != null)
		{
			existing.setQuantity(existing.getQuantity() + groundItem.getQuantity());
			// The spawn time remains set at the oldest spawn
		}

		boolean shouldNotify = !this.onlyShowLoot && this.highlightedColor.equals(getHighlighted(
			groundItem.getName(),
			groundItem.getGePrice(),
			groundItem.getHaPrice()));

		if (this.notifyHighlightedDrops && shouldNotify)
		{
			notifyHighlightedItem(groundItem);
		}
	}

	private void onItemDespawned(ItemDespawned itemDespawned)
	{
		TileItem item = itemDespawned.getItem();
		Tile tile = itemDespawned.getTile();

		GroundItem.GroundItemKey groundItemKey = new GroundItem.GroundItemKey(item.getId(), tile.getWorldLocation());
		GroundItem groundItem = collectedGroundItems.get(groundItemKey);
		if (groundItem == null)
		{
			return;
		}

		if (groundItem.getQuantity() <= item.getQuantity())
		{
			collectedGroundItems.remove(groundItemKey);
		}
		else
		{
			groundItem.setQuantity(groundItem.getQuantity() - item.getQuantity());
			// When picking up an item when multiple stacks appear on the ground,
			// it is not known which item is picked up, so we invalidate the spawn
			// time
			groundItem.setSpawnTime(null);
		}
	}

	private void onItemQuantityChanged(ItemQuantityChanged itemQuantityChanged)
	{
		TileItem item = itemQuantityChanged.getItem();
		Tile tile = itemQuantityChanged.getTile();
		int oldQuantity = itemQuantityChanged.getOldQuantity();
		int newQuantity = itemQuantityChanged.getNewQuantity();

		int diff = newQuantity - oldQuantity;
		GroundItem.GroundItemKey groundItemKey = new GroundItem.GroundItemKey(item.getId(), tile.getWorldLocation());
		GroundItem groundItem = collectedGroundItems.get(groundItemKey);
		if (groundItem != null)
		{
			groundItem.setQuantity(groundItem.getQuantity() + diff);
		}
	}

	private void onNpcLootReceived(NpcLootReceived npcLootReceived)
	{
		npcLootReceived.getItems().forEach(item ->
			{
				GroundItem.GroundItemKey groundItemKey = new GroundItem.GroundItemKey(item.getId(), npcLootReceived.getNpc().getWorldLocation());
				if (collectedGroundItems.containsKey(groundItemKey))
				{
					collectedGroundItems.get(groundItemKey).setOwnedByPlayer(true);
				}
			}
		);

		Collection<ItemStack> items = npcLootReceived.getItems();
		lootReceived(items, LootType.PVM);
		lootNotifier(items);
	}

	private void onPlayerLootReceived(PlayerLootReceived playerLootReceived)
	{
		Collection<ItemStack> items = playerLootReceived.getItems();
		lootReceived(items, LootType.PVP);
		lootNotifier(items);
	}

	private void lootNotifier(Collection<ItemStack> items)
	{
		ItemDefinition composition;
		for (ItemStack is : items)
		{
			composition = itemManager.getItemDefinition(is.getId());
			Color itemColor = getHighlighted(composition.getName(), itemManager.getItemPrice(is.getId()) * is.getQuantity(), itemManager.getAlchValue(is.getId()) * is.getQuantity());
			if (itemColor != null)
			{
				if (this.notifyHighlightedDrops && itemColor.equals(this.highlightedColor))
				{
					sendLootNotification(composition.getName(), "highlighted");
				}
				else if (this.notifyLowValueDrops && itemColor.equals(this.lowValueColor))
				{
					sendLootNotification(composition.getName(), "low value");
				}
				else if (this.notifyMediumValueDrops && itemColor.equals(this.mediumValueColor))
				{
					sendLootNotification(composition.getName(), "medium value");
				}
				else if (this.notifyHighValueDrops && itemColor.equals(this.highValueColor))
				{
					sendLootNotification(composition.getName(), "high value");
				}
				else if (this.notifyInsaneValueDrops && itemColor.equals(this.insaneValueColor))
				{
					sendLootNotification(composition.getName(), "insane value");
				}
			}
		}
	}

	private void sendLootNotification(String itemName, String message)
	{
		String notification = "[" + client.getLocalPlayer().getName() + "] " +
			"Received a " + message + " item: " + itemName;
		notifier.notify(notification);
	}

	private void onClientTick(ClientTick event)
	{
		final MenuEntry[] menuEntries = client.getMenuEntries();
		final List<MenuEntryWithCount> newEntries = new ArrayList<>(menuEntries.length);

		outer:
		for (int i = menuEntries.length - 1; i >= 0; i--)
		{
			MenuEntry menuEntry = menuEntries[i];

			if (this.collapseEntries)
			{
				int menuType = menuEntry.getOpcode();
				if (menuType == FIRST_OPTION || menuType == SECOND_OPTION || menuType == THIRD_OPTION
					|| menuType == FOURTH_OPTION || menuType == FIFTH_OPTION || menuType == EXAMINE_ITEM)
				{
					for (MenuEntryWithCount entryWCount : newEntries)
					{
						if (entryWCount.getEntry().equals(menuEntry))
						{
							entryWCount.increment();
							continue outer;
						}
					}
				}
			}

			newEntries.add(new MenuEntryWithCount(menuEntry));
		}

		Collections.reverse(newEntries);

		newEntries.sort((a, b) ->
		{
			final int aMenuType = a.getEntry().getOpcode();
			if (aMenuType == FIRST_OPTION || aMenuType == SECOND_OPTION || aMenuType == THIRD_OPTION
				|| aMenuType == FOURTH_OPTION || aMenuType == FIFTH_OPTION || aMenuType == EXAMINE_ITEM
				|| aMenuType == WALK)
			{ // only check for item related menu types, so we don't sort other stuff
				final int bMenuType = b.getEntry().getOpcode();
				if (bMenuType == FIRST_OPTION || bMenuType == SECOND_OPTION || bMenuType == THIRD_OPTION
					|| bMenuType == FOURTH_OPTION || bMenuType == FIFTH_OPTION || bMenuType == EXAMINE_ITEM
					|| bMenuType == WALK)
				{
					final MenuEntry aEntry = a.getEntry();
					final int aId = aEntry.getIdentifier();
					final boolean aHidden = isItemIdHidden(aId);
					final int aQuantity = getCollapsedItemQuantity(aId, aEntry.getTarget());

					final MenuEntry bEntry = b.getEntry();
					final int bId = bEntry.getIdentifier();
					final boolean bHidden = isItemIdHidden(bId);
					final int bQuantity = getCollapsedItemQuantity(bId, bEntry.getTarget());

					// only put items below walk if the config is set for it
					if (this.rightClickHidden)
					{
						if (aHidden && bMenuType == WALK)
						{
							return -1;
						}
						if (bHidden && aMenuType == WALK)
						{
							return 1;
						}
					}

					// sort hidden items below non-hidden items
					if (aHidden && !bHidden && bMenuType != WALK)
					{
						return -1;
					}
					if (bHidden && !aHidden && aMenuType != WALK)
					{
						return 1;
					}


					// RS sorts by alch price by private, so no need to sort if config not set
					if (this.sortByGEPrice)
					{
						return (getGePriceFromItemId(aId) * aQuantity) - (getGePriceFromItemId(bId) * bQuantity);
					}
				}
			}

			return 0;
		});

		client.setMenuEntries(newEntries.stream().map(e ->
		{
			final MenuEntry entry = e.getEntry();

			if (this.collapseEntries)
			{
				final int count = e.getCount();
				if (count > 1)
				{
					entry.setTarget(entry.getTarget() + " x " + count);
				}
			}

			return entry;
		}).toArray(MenuEntry[]::new));
	}

	private void lootReceived(Collection<ItemStack> items, LootType lootType)
	{
		for (ItemStack itemStack : items)
		{
			WorldPoint location = WorldPoint.fromLocal(client, itemStack.getLocation());
			GroundItem.GroundItemKey groundItemKey = new GroundItem.GroundItemKey(itemStack.getId(), location);
			GroundItem groundItem = collectedGroundItems.get(groundItemKey);
			if (groundItem != null)
			{
				groundItem.setMine(true);
				groundItem.setTicks(200);
				groundItem.setLootType(lootType);

				boolean shouldNotify = this.onlyShowLoot && this.highlightedColor.equals(getHighlighted(
					groundItem.getName(),
					groundItem.getGePrice(),
					groundItem.getHaPrice()));

				if (this.notifyHighlightedDrops && shouldNotify)
				{
					notifyHighlightedItem(groundItem);
				}
			}
		}
	}

	private GroundItem buildGroundItem(final Tile tile, final TileItem item)
	{
		// Collect the data for the item
		final int itemId = item.getId();
		final ItemDefinition itemComposition = itemManager.getItemDefinition(itemId);
		final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemId;
		final int alchPrice = itemManager.getAlchValue(realItemId);
		int durationMillis;
		int durationTicks;

		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

		if (client.isInInstancedRegion())
		{
			durationMillis = INSTANCE_DURATION_MILLIS;
			durationTicks = INSTANCE_DURATION_TICKS;
		}
		else if (!itemComposition.isTradeable() && realItemId != COINS)
		{
			durationMillis = UNTRADEABLE_DURATION_MILLIS;
			durationTicks = UNTRADEABLE_DURATION_TICKS;
		}
		else
		{
			durationMillis = NORMAL_DURATION_MILLIS;
			durationTicks = tile.getWorldLocation().equals(playerLocation) ? NORMAL_DURATION_TICKS * 2 : NORMAL_DURATION_TICKS;
		}
		final boolean dropped = tile.getWorldLocation().equals(client.getLocalPlayer().getWorldLocation()) && droppedItemQueue.remove(itemId);

		final GroundItem groundItem = GroundItem.builder()
			.id(itemId)
			.location(tile.getWorldLocation())
			.itemId(realItemId)
			.quantity(item.getQuantity())
			.name(itemComposition.getName())
			.haPrice(alchPrice)
			.height(-1)
			.tradeable(itemComposition.isTradeable())
			.droppedInstant(Instant.now())
			.durationMillis(durationMillis)
			.isAlwaysPrivate(client.isInInstancedRegion() || (!itemComposition.isTradeable() && realItemId != COINS))
			.isOwnedByPlayer(tile.getWorldLocation().equals(playerLocation))
			.ticks(durationTicks)
			.lootType(LootType.UNKNOWN)
			.isDropped(dropped)
			.spawnTime(Instant.now())
			.build();


		// Update item price in case it is coins
		if (realItemId == COINS)
		{
			groundItem.setHaPrice(1);
			groundItem.setGePrice(1);
		}
		else
		{
			groundItem.setGePrice(itemManager.getItemPrice(realItemId));
		}

		return groundItem;
	}

	private void reset()
	{
		// gets the hidden items from the text box in the config
		hiddenItemList = Text.fromCSV(this.getHiddenItems);

		// gets the highlighted items from the text box in the config
		highlightedItemsList = Text.fromCSV(this.getHighlightItems);

		highlightedItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(highlightedItemsList));

		hiddenItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(hiddenItemList));

		// Cache colors
		priceChecks.clear();

		if (this.insaneValuePrice > 0)
		{
			priceChecks.put(this.insaneValuePrice, this.insaneValueColor);
		}

		if (this.highValuePrice > 0)
		{
			priceChecks.put(this.highValuePrice, this.highValueColor);
		}

		if (this.mediumValuePrice > 0)
		{
			priceChecks.put(this.mediumValuePrice, this.mediumValueColor);
		}

		if (this.lowValuePrice > 0)
		{
			priceChecks.put(this.lowValuePrice, this.lowValueColor);
		}

		if (this.getHighlightOverValue > 0)
		{
			priceChecks.put(this.getHighlightOverValue, this.highlightedColor);
		}
	}

	private void onMenuEntryAdded(MenuEntryAdded lastEntry)
	{
		if (this.itemHighlightMode != OVERLAY)
		{
			final boolean telegrabEntry = lastEntry.getOption().equals("Cast") && lastEntry.getTarget().startsWith(TELEGRAB_TEXT) && lastEntry.getOpcode() == CAST_ON_ITEM;
			if (!(lastEntry.getOption().equals("Take") && lastEntry.getOpcode() == THIRD_OPTION) && !telegrabEntry)
			{
				return;
			}

			int itemId = lastEntry.getIdentifier();
			Scene scene = client.getScene();
			Tile tile = scene.getTiles()[client.getPlane()][lastEntry.getParam0()][lastEntry.getParam1()];
			TileItemPile tileItemPile = tile.getItemLayer();

			if (tileItemPile == null)
			{
				return;
			}

			int quantity = 1;
			Node current = tileItemPile.getBottom();

			while (current instanceof TileItem)
			{
				TileItem item = (TileItem) current;
				if (item.getId() == itemId)
				{
					quantity = item.getQuantity();
				}
				current = current.getNext();
			}

			final ItemDefinition itemComposition = itemManager.getItemDefinition(itemId);
			final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemComposition.getId();
			final int itemPrice = itemManager.getItemPrice(realItemId);
			final int price = itemPrice <= 0 ? itemComposition.getPrice() : itemPrice;
			final int haPrice = itemManager.getAlchValue(realItemId);
			final int gePrice = quantity * price;
			final Color hidden = getHidden(itemComposition.getName(), gePrice, haPrice, itemComposition.isTradeable());
			final Color highlighted = getHighlighted(itemComposition.getName(), gePrice, haPrice);
			final Color color = getItemColor(highlighted, hidden);
			final boolean canBeRecolored = highlighted != null || (hidden != null && this.recolorMenuHiddenItems);

			if (color != null && canBeRecolored && !color.equals(this.defaultColor))
			{
				final MenuHighlightMode mode = this.menuHighlightMode;

				if (mode == BOTH || mode == OPTION)
				{
					final String optionText = telegrabEntry ? "Cast" : "Take";
					lastEntry.setOption(ColorUtil.prependColorTag(optionText, color));
					lastEntry.setModified();
				}

				if (mode == BOTH || mode == NAME)
				{
					String target = lastEntry.getTarget();

					if (telegrabEntry)
					{
						target = target.substring(TELEGRAB_TEXT.length());
					}

					target = ColorUtil.prependColorTag(target.substring(target.indexOf('>') + 1), color);

					if (telegrabEntry)
					{
						target = TELEGRAB_TEXT + target;
					}

					lastEntry.setTarget(target);
					lastEntry.setModified();
				}
			}

			if (this.showMenuItemQuantities && itemComposition.isStackable() && quantity > 1)
			{
				lastEntry.setTarget(lastEntry.getTarget() + " (" + quantity + ")");
				lastEntry.setModified();
			}

			if (this.removeIgnored && lastEntry.getOption().equals("Take") && hiddenItemList.contains(Text.removeTags(lastEntry.getTarget())))
			{
				client.setMenuOptionCount(client.getMenuOptionCount() - 1);
			}
		}
	}

	void updateList(String item, boolean hiddenList)
	{
		final Set<String> hiddenItemSet = new HashSet<>(hiddenItemList);
		final Set<String> highlightedItemSet = new HashSet<>(highlightedItemsList);

		if (hiddenList)
		{
			highlightedItemSet.removeIf(item::equalsIgnoreCase);
		}
		else
		{
			hiddenItemSet.removeIf(item::equalsIgnoreCase);
		}

		final Set<String> items = hiddenList ? hiddenItemSet : highlightedItemSet;

		if (!items.removeIf(item::equalsIgnoreCase))
		{
			items.add(item);
		}

		config.setHiddenItems(Text.toCSV(hiddenItemSet));
		this.getHiddenItems = Text.toCSV(hiddenItemSet);
		config.setHighlightedItem(Text.toCSV(highlightedItemSet));
		this.getHighlightItems = Text.toCSV(highlightedItemSet);
	}

	Color getHerbloreColor()
	{
		return herbloreColor;
	}

	Color getPrayerColor()
	{
		return prayerColor;
	}

	Color getDefaultColor()
	{
		return config.defaultColor();
	}

	Color getHighlighted(String item, int gePrice, int haPrice)
	{
		if (TRUE.equals(highlightedItems.getUnchecked(item)))
		{
			return this.highlightedColor;
		}

		// Explicit hide takes priority over implicit highlight
		if (TRUE.equals(hiddenItems.getUnchecked(item)))
		{
			return null;
		}

		ValueCalculationMode mode = this.valueCalculationMode;
		for (Map.Entry<Integer, Color> entry : priceChecks.entrySet())
		{
			switch (mode)
			{
				case GE:
					if (gePrice > entry.getKey())
					{
						return entry.getValue();
					}
					break;
				case HA:
					if (haPrice > entry.getKey())
					{
						return entry.getValue();
					}
					break;
				default: // case HIGHEST
					if (gePrice > entry.getKey() || haPrice > entry.getKey())
					{
						return entry.getValue();
					}
					break;
			}
		}

		return null;
	}

	Color getHidden(String item, int gePrice, int haPrice, boolean isTradeable)
	{
		final boolean isExplicitHidden = TRUE.equals(hiddenItems.getUnchecked(item));
		final boolean isExplicitHighlight = TRUE.equals(highlightedItems.getUnchecked(item));
		final boolean canBeHidden = gePrice > 0 || isTradeable || !this.dontHideUntradeables;
		final boolean underGe = gePrice < this.getHideUnderValue;
		final boolean underHa = haPrice < this.getHideUnderValue;

		// Explicit highlight takes priority over implicit hide
		return isExplicitHidden || (!isExplicitHighlight && canBeHidden && underGe && underHa)
			? this.hiddenColor
			: null;
	}

	private int getGePriceFromItemId(int itemId)
	{
		final ItemDefinition itemComposition = itemManager.getItemDefinition(itemId);
		final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemId;

		return itemManager.getItemPrice(realItemId);
	}

	private boolean isItemIdHidden(int itemId)
	{
		final ItemDefinition itemComposition = itemManager.getItemDefinition(itemId);
		final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemId;
		final int alchPrice = itemManager.getAlchValue(realItemId);
		final int gePrice = itemManager.getItemPrice(realItemId);

		return getHidden(itemComposition.getName(), gePrice, alchPrice, itemComposition.isTradeable()) != null;
	}

	private int getCollapsedItemQuantity(int itemId, String item)
	{
		final ItemDefinition itemComposition = itemManager.getItemDefinition(itemId);
		final boolean itemNameIncludesQuantity = Pattern.compile("\\(\\d+\\)").matcher(itemComposition.getName()).find();

		Matcher matcher = Pattern.compile("\\((\\d+)\\)").matcher(item);
		int matches = 0;
		String lastMatch = "1";
		while (matcher.find())
		{
			// so that "Prayer Potion (4)" returns 1 instead of 4 and "Coins (25)" returns 25 instead of 1
			if (!itemNameIncludesQuantity || matches >= 1)
			{
				lastMatch = matcher.group(1);
			}

			matches++;
		}

		return Integer.parseInt(lastMatch);
	}

	Color getItemColor(Color highlighted, Color hidden)
	{
		if (highlighted != null)
		{
			return highlighted;
		}

		if (hidden != null)
		{
			return hidden;
		}

		return this.defaultColor;
	}

	private void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			setHotKeyPressed(false);
		}
	}

	private void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		if (menuOptionClicked.getMenuOpcode() == MenuOpcode.ITEM_DROP)
		{
			int itemId = menuOptionClicked.getIdentifier();
			// Keep a queue of recently dropped items to better detect
			// item spawns that are drops
			droppedItemQueue.add(itemId);
		}
	}

	private void notifyHighlightedItem(GroundItem item)
	{
		final Player local = client.getLocalPlayer();
		final StringBuilder notificationStringBuilder = new StringBuilder()
			.append("[")
			.append(local.getName())
			.append("] received a highlighted drop: ")
			.append(item.getName());

		if (item.getQuantity() > 1)
		{
			notificationStringBuilder.append(" x ").append(item.getQuantity());


			if (item.getQuantity() > (int) Character.MAX_VALUE)
			{
				notificationStringBuilder.append(" (Lots!)");
			}
			else
			{
				notificationStringBuilder.append(" (")
					.append(QuantityFormatter.quantityToStackSize(item.getQuantity()))
					.append(")");
			}
		}

		notificationStringBuilder.append("!");
		notifier.notify(notificationStringBuilder.toString());
	}

	private void updateConfig()
	{
		this.defaultColor = config.defaultColor();
		this.highlightedColor = config.highlightedColor();
		this.hiddenColor = config.hiddenColor();
		this.getHighlightItems = config.getHighlightItems();
		this.showHighlightedOnly = config.showHighlightedOnly();
		this.valueCalculationMode = config.valueCalculationMode();
		this.getHighlightOverValue = config.getHighlightOverValue();
		this.notifyHighlightedDrops = config.notifyHighlightedDrops();
		this.dontHideUntradeables = config.dontHideUntradeables();
		this.getHiddenItems = config.getHiddenItems();
		this.recolorMenuHiddenItems = config.recolorMenuHiddenItems();
		this.getHideUnderValue = config.getHideUnderValue();
		this.removeIgnored = config.removeIgnored();
		this.rightClickHidden = config.rightClickHidden();
		this.highlightTiles = config.highlightTiles();
		this.itemHighlightMode = config.itemHighlightMode();
		this.menuHighlightMode = config.menuHighlightMode();
		this.lowValueColor = config.lowValueColor();
		this.lowValuePrice = config.lowValuePrice();
		this.notifyLowValueDrops = config.notifyLowValueDrops();
		this.mediumValueColor = config.mediumValueColor();
		this.mediumValuePrice = config.mediumValuePrice();
		this.notifyMediumValueDrops = config.notifyMediumValueDrops();
		this.highValueColor = config.highValueColor();
		this.highValuePrice = config.highValuePrice();
		this.notifyHighValueDrops = config.notifyHighValueDrops();
		this.insaneValueColor = config.insaneValueColor();
		this.insaneValuePrice = config.insaneValuePrice();
		this.notifyInsaneValueDrops = config.notifyInsaneValueDrops();
		this.priceDisplayMode = config.priceDisplayMode();
		this.sortByGEPrice = config.sortByGEPrice();
		this.showMenuItemQuantities = config.showMenuItemQuantities();
		this.collapseEntries = config.collapseEntries();
		this.onlyShowLoot = config.onlyShowLoot();
		this.showGroundItemDuration = config.showGroundItemDuration();
		this.doubleTapDelay = config.doubleTapDelay();
		this.toggleOutline = config.toggleOutline();
		this.showTimer = config.showTimer();
		this.bordercolor = config.bordercolor();
		this.herbloreColor = config.herbloreColor();
		this.prayerColor = config.prayerColor();
		this.highlightHerblore = config.highlightHerblore();
		this.highlightPrayer = config.highlightPrayer();
	}
}
