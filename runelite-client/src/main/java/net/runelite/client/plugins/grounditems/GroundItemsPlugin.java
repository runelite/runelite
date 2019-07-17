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
import net.runelite.api.Item;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.api.ItemLayer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Node;
import net.runelite.api.Player;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemQuantityChanged;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.GameTick;
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
import net.runelite.client.util.StackFormatter;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Ground Items",
	description = "Highlight ground items and/or show price information",
	tags = {"grand", "exchange", "high", "alchemy", "prices", "highlight", "overlay"}
)
@Singleton
public class GroundItemsPlugin extends Plugin
{
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
	private static final int FIRST_OPTION = MenuAction.GROUND_ITEM_FIRST_OPTION.getId();
	private static final int SECOND_OPTION = MenuAction.GROUND_ITEM_SECOND_OPTION.getId();
	private static final int THIRD_OPTION = MenuAction.GROUND_ITEM_THIRD_OPTION.getId(); // this is Take
	private static final int FOURTH_OPTION = MenuAction.GROUND_ITEM_FOURTH_OPTION.getId();
	private static final int FIFTH_OPTION = MenuAction.GROUND_ITEM_FIFTH_OPTION.getId();
	private static final int EXAMINE_ITEM = MenuAction.EXAMINE_ITEM_GROUND.getId();
	private static final int WALK = MenuAction.WALK.getId();
	private static final int CAST_ON_ITEM = MenuAction.SPELL_CAST_ON_GROUND_ITEM.getId();

	private static final String TELEGRAB_TEXT = ColorUtil.wrapWithColorTag("Telekinetic Grab", Color.GREEN) + ColorUtil.prependColorTag(" -> ", Color.WHITE);

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

	@Getter(AccessLevel.PUBLIC)
	public static final Map<GroundItem.GroundItemKey, GroundItem> collectedGroundItems = new LinkedHashMap<>();
	private final Map<Integer, Color> priceChecks = new LinkedHashMap<>();
	private LoadingCache<String, Boolean> highlightedItems;
	private LoadingCache<String, Boolean> hiddenItems;

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
		Item item = itemSpawned.getItem();
		Tile tile = itemSpawned.getTile();

		GroundItem groundItem = buildGroundItem(tile, item);

		GroundItem.GroundItemKey groundItemKey = new GroundItem.GroundItemKey(item.getId(), tile.getWorldLocation());
		GroundItem existing = collectedGroundItems.putIfAbsent(groundItemKey, groundItem);
		if (existing != null)
		{
			existing.setQuantity(existing.getQuantity() + groundItem.getQuantity());
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
		Item item = itemDespawned.getItem();
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
		}
	}

	private void onItemQuantityChanged(ItemQuantityChanged itemQuantityChanged)
	{
		Item item = itemQuantityChanged.getItem();
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
		lootReceived(items);
		lootNotifier(items);
	}

	private void onPlayerLootReceived(PlayerLootReceived playerLootReceived)
	{
		Collection<ItemStack> items = playerLootReceived.getItems();
		lootReceived(items);
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

	private  void sendLootNotification(String itemName, String message)
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
				int menuType = menuEntry.getType();
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
			final int aMenuType = a.getEntry().getType();
			if (aMenuType == FIRST_OPTION || aMenuType == SECOND_OPTION || aMenuType == THIRD_OPTION
					|| aMenuType == FOURTH_OPTION || aMenuType == FIFTH_OPTION || aMenuType == EXAMINE_ITEM
					|| aMenuType == WALK)
			{ // only check for item related menu types, so we don't sort other stuff
				final int bMenuType = b.getEntry().getType();
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

	private void lootReceived(Collection<ItemStack> items)
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

	private GroundItem buildGroundItem(final Tile tile, final Item item)
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

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (this.itemHighlightMode != OVERLAY)
		{
			final boolean telegrabEntry = event.getOption().equals("Cast") && event.getTarget().startsWith(TELEGRAB_TEXT) && event.getType() == CAST_ON_ITEM;
			if (!(event.getOption().equals("Take") && event.getType() == THIRD_OPTION) && !telegrabEntry)
			{
				return;
			}

			int itemId = event.getIdentifier();
			Scene scene = client.getScene();
			Tile tile = scene.getTiles()[client.getPlane()][event.getActionParam0()][event.getActionParam1()];
			ItemLayer itemLayer = tile.getItemLayer();

			if (itemLayer == null)
			{
				return;
			}

			MenuEntry[] menuEntries = client.getMenuEntries();
			MenuEntry lastEntry = menuEntries[menuEntries.length - 1];

			int quantity = 1;
			Node current = itemLayer.getBottom();

			while (current instanceof Item)
			{
				Item item = (Item) current;
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
				}
			}

			if (this.showMenuItemQuantities && itemComposition.isStackable() && quantity > 1)
			{
				lastEntry.setTarget(lastEntry.getTarget() + " (" + quantity + ")");
			}

			if (this.removeIgnored && event.getOption().equals("Take") && hiddenItemList.contains(Text.removeTags(event.getTarget())))
			{
				menuEntries = removeOption(event.getOption(), event.getTarget());
			}

			client.setMenuEntries(menuEntries);
		}
	}

	private MenuEntry[] removeOption(String option, String target)
	{
		MenuEntry[] entries = client.getMenuEntries();
		int j = 0;
		if (entries.length > 1)
		{
			MenuEntry[] newEntries = new MenuEntry[entries.length - 1];
			for (MenuEntry entry : entries)
			{
				if (!(entry.getOption().equals(option) && entry.getTarget().equals(target)))
				{
					newEntries[j++] = entry;
				}
			}

			return newEntries;
		}
		else
		{
			return entries;
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
					.append(StackFormatter.quantityToStackSize(item.getQuantity()))
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
	}
}
