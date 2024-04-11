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

import com.google.common.base.MoreObjects;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.EvictingQueue;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import com.google.inject.Provides;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Rectangle;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.KeyCode;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemQuantityChanged;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.ComponentID;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.grounditems.config.HighlightTier;
import net.runelite.client.plugins.grounditems.config.ItemHighlightMode;
import net.runelite.client.plugins.grounditems.config.MenuHighlightMode;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.BOTH;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.NAME;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.OPTION;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.util.RSTimeUnit;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Ground Items",
	description = "Highlight ground items and/or show price information",
	tags = {"grand", "exchange", "high", "alchemy", "prices", "highlight", "overlay", "lootbeam"}
)
public class GroundItemsPlugin extends Plugin
{
	private static final String HIGHLIGHT_COLOR_PREFIX = "highlight_";

	@Value
	static class PriceHighlight
	{
		private final int price;
		private final Color color;
	}

	// ItemID for coins
	private static final int COINS = ItemID.COINS_995;

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
	private GroundItemHotkeyListener hotkeyListener;

	@Inject
	private GroundItemMouseAdapter mouseAdapter;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

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
	private ScheduledExecutorService executor;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ColorPickerManager colorPickerManager;

	@Getter
	private final Table<WorldPoint, Integer, GroundItem> collectedGroundItems = HashBasedTable.create();
	private List<PriceHighlight> priceChecks = ImmutableList.of();
	private LoadingCache<NamedQuantity, Boolean> highlightedItems;
	private LoadingCache<NamedQuantity, Boolean> hiddenItems;
	private final Queue<Integer> droppedItemQueue = EvictingQueue.create(16); // recently dropped items
	private int lastUsedItem;
	private final Map<WorldPoint, Lootbeam> lootbeams = new HashMap<>();

	@Provides
	GroundItemsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroundItemsConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		mouseManager.registerMouseListener(mouseAdapter);
		keyManager.registerKeyListener(hotkeyListener);
		executor.execute(this::reset);
		lastUsedItem = -1;
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		mouseManager.unregisterMouseListener(mouseAdapter);
		keyManager.unregisterKeyListener(hotkeyListener);
		highlightedItems.invalidateAll();
		highlightedItems = null;
		hiddenItems.invalidateAll();
		hiddenItems = null;
		hiddenItemList = null;
		highlightedItemsList = null;
		collectedGroundItems.clear();
		clientThread.invokeLater(this::removeAllLootbeams);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(GroundItemsConfig.GROUP))
		{
			executor.execute(this::reset);
		}
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			collectedGroundItems.clear();
			lootbeams.clear();
		}
	}

	@Subscribe
	public void onItemSpawned(ItemSpawned itemSpawned)
	{
		TileItem item = itemSpawned.getItem();
		Tile tile = itemSpawned.getTile();

		GroundItem groundItem = buildGroundItem(tile, item);
		GroundItem existing = collectedGroundItems.get(tile.getWorldLocation(), item.getId());
		if (existing != null)
		{
			existing.setQuantity(existing.getQuantity() + groundItem.getQuantity());
			// The spawn time remains set at the oldest spawn
			existing.reset();
		}
		else
		{
			collectedGroundItems.put(tile.getWorldLocation(), item.getId(), groundItem);
		}

		if (!config.onlyShowLoot())
		{
			notifyHighlightedItem(groundItem);
		}

		handleLootbeam(tile.getWorldLocation());
	}

	void updateItemColor(GroundItem item)
	{
		if (item.color != null)
		{
			return;
		}

		final Color highlighted = getHighlighted(item);
		final Color hidden = getHidden(item);

		item.highlighted = highlighted != null;
		item.hidden = hidden != null;
		item.color = getItemColor(highlighted, hidden);
	}

	@Subscribe
	public void onItemDespawned(ItemDespawned itemDespawned)
	{
		TileItem item = itemDespawned.getItem();
		Tile tile = itemDespawned.getTile();

		GroundItem groundItem = collectedGroundItems.get(tile.getWorldLocation(), item.getId());
		if (groundItem == null)
		{
			return;
		}

		if (groundItem.getQuantity() <= item.getQuantity())
		{
			collectedGroundItems.remove(tile.getWorldLocation(), item.getId());
		}
		else
		{
			groundItem.setQuantity(groundItem.getQuantity() - item.getQuantity());
			// When picking up an item when multiple stacks appear on the ground,
			// it is not known which item is picked up, so we invalidate the spawn
			// time
			groundItem.setSpawnTime(null);
			groundItem.reset();
		}

		handleLootbeam(tile.getWorldLocation());
	}

	@Subscribe
	public void onItemQuantityChanged(ItemQuantityChanged itemQuantityChanged)
	{
		TileItem item = itemQuantityChanged.getItem();
		Tile tile = itemQuantityChanged.getTile();
		int oldQuantity = itemQuantityChanged.getOldQuantity();
		int newQuantity = itemQuantityChanged.getNewQuantity();

		int diff = newQuantity - oldQuantity;
		GroundItem groundItem = collectedGroundItems.get(tile.getWorldLocation(), item.getId());
		if (groundItem != null)
		{
			groundItem.setQuantity(groundItem.getQuantity() + diff);
			groundItem.reset();
		}

		handleLootbeam(tile.getWorldLocation());
	}

	@Subscribe
	public void onNpcLootReceived(NpcLootReceived npcLootReceived)
	{
		Collection<ItemStack> items = npcLootReceived.getItems();
		lootReceived(items, LootType.PVM);
	}

	@Subscribe
	public void onPlayerLootReceived(PlayerLootReceived playerLootReceived)
	{
		Collection<ItemStack> items = playerLootReceived.getItems();
		lootReceived(items, LootType.PVP);
	}

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		if (!config.collapseEntries())
		{
			return;
		}

		final MenuEntry[] menuEntries = client.getMenuEntries();
		final List<MenuEntryWithCount> newEntries = new ArrayList<>(menuEntries.length);

		outer:
		for (int i = menuEntries.length - 1; i >= 0; i--)
		{
			MenuEntry menuEntry = menuEntries[i];

			MenuAction menuType = menuEntry.getType();
			if (menuType == MenuAction.GROUND_ITEM_FIRST_OPTION || menuType == MenuAction.GROUND_ITEM_SECOND_OPTION
				|| menuType == MenuAction.GROUND_ITEM_THIRD_OPTION || menuType == MenuAction.GROUND_ITEM_FOURTH_OPTION
				|| menuType == MenuAction.GROUND_ITEM_FIFTH_OPTION || menuType == MenuAction.EXAMINE_ITEM_GROUND)
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

			newEntries.add(new MenuEntryWithCount(menuEntry));
		}

		Collections.reverse(newEntries);

		client.setMenuEntries(newEntries.stream().map(e ->
		{
			final MenuEntry entry = e.getEntry();
			final int count = e.getCount();
			if (count > 1)
			{
				entry.setTarget(entry.getTarget() + " x " + count);
			}

			return entry;
		}).toArray(MenuEntry[]::new));
	}

	private void lootReceived(Collection<ItemStack> items, LootType lootType)
	{
		for (ItemStack itemStack : items)
		{
			WorldPoint location = WorldPoint.fromLocal(client, itemStack.getLocation());
			GroundItem groundItem = collectedGroundItems.get(location, itemStack.getId());
			if (groundItem != null)
			{
				groundItem.setLootType(lootType);

				if (config.onlyShowLoot())
				{
					notifyHighlightedItem(groundItem);
				}
			}
		}

		// Since the loot can potentially be over multiple tiles, make sure to process lootbeams on all those tiles
		items.stream()
			.map(ItemStack::getLocation)
			.map(l -> WorldPoint.fromLocal(client, l))
			.distinct()
			.forEach(this::handleLootbeam);
	}

	private GroundItem buildGroundItem(final Tile tile, final TileItem item)
	{
		// Collect the data for the item
		final int itemId = item.getId();
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemId;
		final int alchPrice = itemComposition.getHaPrice();
		final boolean dropped = tile.getWorldLocation().equals(client.getLocalPlayer().getWorldLocation()) && droppedItemQueue.remove(itemId);
		final boolean table = itemId == lastUsedItem && tile.getItemLayer().getHeight() > 0;

		final GroundItem groundItem = GroundItem.builder()
			.id(itemId)
			.location(tile.getWorldLocation())
			.itemId(realItemId)
			.quantity(item.getQuantity())
			.name(itemComposition.getName())
			.haPrice(alchPrice)
			.height(tile.getItemLayer().getHeight())
			.tradeable(itemComposition.isTradeable())
			.lootType(dropped ? LootType.DROPPED : (table ? LootType.TABLE : LootType.UNKNOWN))
			.spawnTime(Instant.now())
			.stackable(itemComposition.isStackable())
			.despawnTime(Duration.of(item.getDespawnTime(), RSTimeUnit.GAME_TICKS))
			.visibleTime(Duration.of(item.getVisibleTime(), RSTimeUnit.GAME_TICKS))
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
		hiddenItemList = Text.fromCSV(config.getHiddenItems());

		// gets the highlighted items from the text box in the config
		highlightedItemsList = Text.fromCSV(config.getHighlightItems());

		highlightedItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(highlightedItemsList));

		hiddenItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(hiddenItemList));

		// Cache colors
		ImmutableList.Builder<PriceHighlight> priceCheckBuilder = ImmutableList.builder();

		if (config.insaneValuePrice() > 0)
		{
			priceCheckBuilder.add(new PriceHighlight(config.insaneValuePrice(), config.insaneValueColor()));
		}

		if (config.highValuePrice() > 0)
		{
			priceCheckBuilder.add(new PriceHighlight(config.highValuePrice(), config.highValueColor()));
		}

		if (config.mediumValuePrice() > 0)
		{
			priceCheckBuilder.add(new PriceHighlight(config.mediumValuePrice(), config.mediumValueColor()));
		}

		if (config.lowValuePrice() > 0)
		{
			priceCheckBuilder.add(new PriceHighlight(config.lowValuePrice(), config.lowValueColor()));
		}

		priceChecks = priceCheckBuilder.build();

		clientThread.invokeLater(() -> collectedGroundItems.values().forEach(GroundItem::reset));
		clientThread.invokeLater(this::handleLootbeams);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		MenuAction type = MenuAction.of(event.getType());
		final boolean hotKeyPressed = client.isKeyPressed(KeyCode.KC_SHIFT);
		if (type == MenuAction.GROUND_ITEM_FIRST_OPTION || type == MenuAction.GROUND_ITEM_SECOND_OPTION ||
			type == MenuAction.GROUND_ITEM_THIRD_OPTION || type == MenuAction.GROUND_ITEM_FOURTH_OPTION ||
			type == MenuAction.GROUND_ITEM_FIFTH_OPTION || type == MenuAction.WIDGET_TARGET_ON_GROUND_ITEM)
		{
			final int itemId = event.getIdentifier();
			final int sceneX = event.getActionParam0();
			final int sceneY = event.getActionParam1();

			MenuEntry[] menuEntries = client.getMenuEntries();
			MenuEntry lastEntry = menuEntries[menuEntries.length - 1];

			final WorldPoint worldPoint = WorldPoint.fromScene(client, sceneX, sceneY, client.getPlane());
			GroundItem groundItem = collectedGroundItems.get(worldPoint, itemId);

			updateItemColor(groundItem);

			int quantity = groundItem.getQuantity();
			final boolean canBeRecolored = groundItem.highlighted || (groundItem.hidden && config.recolorMenuHiddenItems());

			if ((config.itemHighlightMode() == ItemHighlightMode.MENU || config.itemHighlightMode() == ItemHighlightMode.BOTH) &&
				(canBeRecolored && !groundItem.color.equals(config.defaultColor())))
			{
				final MenuHighlightMode mode = config.menuHighlightMode();

				if (mode == BOTH || mode == OPTION)
				{
					lastEntry.setOption(ColorUtil.prependColorTag(lastEntry.getOption(), groundItem.color));
				}

				if (mode == BOTH || mode == NAME)
				{
					// <col=ff9040>Logs
					// <col=00ff00>Telekinetic Grab</col><col=ffffff> -> <col=ff9040>Logs
					String target = lastEntry.getTarget();

					int i = target.lastIndexOf('>');
					lastEntry.setTarget(target.substring(0, i - 11) + ColorUtil.colorTag(groundItem.color) + target.substring(i + 1));
				}
			}

			if (config.showMenuItemQuantities() && groundItem.isStackable() && quantity > 1)
			{
				lastEntry.setTarget(lastEntry.getTarget() + " (" + quantity + ")");
			}

			if (groundItem.hidden && !groundItem.highlighted && config.deprioritizeHiddenItems())
			{
				lastEntry.setDeprioritized(true);
			}
		}
		else if (hotKeyPressed && type == MenuAction.EXAMINE_ITEM_GROUND)
		{
			MenuEntry parent = client.createMenuEntry(-1)
				.setOption("Color")
				.setTarget(event.getTarget())
				.setType(MenuAction.RUNELITE_SUBMENU);
			final int itemId = event.getIdentifier();
			Color color = getItemColor(itemId);

			if (color != null)
			{
				client.createMenuEntry(-1)
					.setOption("Reset")
					.setType(MenuAction.RUNELITE)
					.setParent(parent)
					.onClick(e -> unsetItemColor(itemId));
			}

			client.createMenuEntry(-1)
				.setOption("Pick")
				.setType(MenuAction.RUNELITE)
				.setParent(parent)
				.onClick(e ->
					SwingUtilities.invokeLater(() ->
					{
						RuneliteColorPicker colorPicker = colorPickerManager.create(SwingUtilities.windowForComponent((Applet) client),
							color != null ? color : Color.decode("#FFFFFF"), "Item color", true);
						colorPicker.setOnClose(c -> setItemColor(itemId, c));
						colorPicker.setVisible(true);
					}));

			var colors = Stream.concat(
					collectedGroundItems.values().stream()
						.map(GroundItem::getColor)
						.filter(Objects::nonNull),
					// add some default colors
					Stream.of(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA)
				)
				.distinct()
				.limit(5)
				.collect(Collectors.toList());

			colors.stream()
				.filter(c -> !c.equals(color))
				.forEach(c -> client.createMenuEntry(-1)
					.setOption(ColorUtil.prependColorTag("Color", c))
					.setType(MenuAction.RUNELITE)
					.setParent(parent)
					.onClick(e -> setItemColor(itemId, c)));
		}
	}

	void updateList(String item, boolean hiddenList)
	{
		final List<String> hiddenItemSet = new ArrayList<>(hiddenItemList);
		final List<String> highlightedItemSet = new ArrayList<>(highlightedItemsList);

		if (hiddenList)
		{
			highlightedItemSet.removeIf(item::equalsIgnoreCase);
		}
		else
		{
			hiddenItemSet.removeIf(item::equalsIgnoreCase);
		}

		final List<String> items = hiddenList ? hiddenItemSet : highlightedItemSet;

		if (!items.removeIf(item::equalsIgnoreCase))
		{
			items.add(item);
		}

		config.setHiddenItems(Text.toCSV(hiddenItemSet));
		config.setHighlightedItem(Text.toCSV(highlightedItemSet));
	}

	private Color getHighlighted(GroundItem groundItem)
	{
		Color itemColor = getItemColor(groundItem.getItemId());
		var item = new NamedQuantity(groundItem);
		if (TRUE.equals(highlightedItems.getUnchecked(item)))
		{
			return itemColor != null ? itemColor : config.highlightedColor();
		}

		// Explicit hide takes priority over implicit highlight
		if (TRUE.equals(hiddenItems.getUnchecked(item)))
		{
			return null;
		}

		// item highlight colors takes priority over price thresholds
		if (itemColor != null)
		{
			return itemColor;
		}

		final int price = getValueByMode(groundItem.getGePrice(), groundItem.getHaPrice());
		for (PriceHighlight highlight : priceChecks)
		{
			if (price > highlight.getPrice())
			{
				return highlight.getColor();
			}
		}

		return null;
	}

	private Color getHidden(GroundItem groundItem)
	{
		var item = new NamedQuantity(groundItem);
		final boolean isExplicitHidden = TRUE.equals(hiddenItems.getUnchecked(item));
		final boolean isExplicitHighlight = TRUE.equals(highlightedItems.getUnchecked(item));
		final boolean canBeHidden = groundItem.getGePrice() > 0 || groundItem.isTradeable() || !config.dontHideUntradeables();
		final boolean underGe = groundItem.getGePrice() < config.getHideUnderValue();
		final boolean underHa = groundItem.getHaPrice() < config.getHideUnderValue();

		// Explicit highlight takes priority over implicit hide
		return isExplicitHidden || (!isExplicitHighlight && canBeHidden && underGe && underHa)
			? config.hiddenColor()
			: null;
	}

	private Color getItemColor(Color highlighted, Color hidden)
	{
		if (highlighted != null)
		{
			return highlighted;
		}

		if (hidden != null)
		{
			return hidden;
		}

		return config.defaultColor();
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			setHotKeyPressed(false);
		}
	}

	private void notifyHighlightedItem(GroundItem item)
	{
		final boolean shouldNotifyHighlighted = config.notifyHighlightedDrops() &&
			TRUE.equals(highlightedItems.getUnchecked(new NamedQuantity(item)));

		final boolean shouldNotifyTier = config.notifyTier() != HighlightTier.OFF &&
			getValueByMode(item.getGePrice(), item.getHaPrice()) > config.notifyTier().getValueFromTier(config) &&
			FALSE.equals(hiddenItems.getUnchecked(new NamedQuantity(item)));

		final String dropType;
		if (shouldNotifyHighlighted)
		{
			dropType = "highlighted";
		}
		else if (shouldNotifyTier)
		{
			dropType = "valuable";
		}
		else
		{
			return;
		}

		final StringBuilder notificationStringBuilder = new StringBuilder()
			.append("You received a ")
			.append(dropType)
			.append(" drop: ")
			.append(item.getName());

		if (item.getQuantity() > 1)
		{
			notificationStringBuilder.append(" (")
				.append(QuantityFormatter.quantityToStackSize(item.getQuantity()))
				.append(')');
		}

		notifier.notify(notificationStringBuilder.toString());
	}

	private int getValueByMode(int gePrice, int haPrice)
	{
		switch (config.valueCalculationMode())
		{
			case GE:
				return gePrice;
			case HA:
				return haPrice;
			default: // Highest
				return Math.max(gePrice, haPrice);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		if (menuOptionClicked.isItemOp() && menuOptionClicked.getMenuOption().equals("Drop"))
		{
			int itemId = menuOptionClicked.getItemId();
			// Keep a queue of recently dropped items to better detect
			// item spawns that are drops
			droppedItemQueue.add(itemId);
		}
		else if (menuOptionClicked.getMenuAction() == MenuAction.WIDGET_TARGET_ON_GAME_OBJECT
			&& client.getSelectedWidget() != null
			&& client.getSelectedWidget().getId() == ComponentID.INVENTORY_CONTAINER)
		{
			lastUsedItem = client.getSelectedWidget().getItemId();
		}
	}

	private void handleLootbeam(WorldPoint worldPoint)
	{
		/*
		 * Return and remove the lootbeam from this location if lootbeam are disabled
		 * Lootbeam can be at this location if the config was just changed
		 */
		if (!(config.showLootbeamForHighlighted() || config.showLootbeamTier() != HighlightTier.OFF))
		{
			removeLootbeam(worldPoint);
			return;
		}

		int highestPrice = -1;
		GroundItem highestItem = null;
		Collection<GroundItem> groundItems = collectedGroundItems.row(worldPoint).values();
		for (GroundItem groundItem : groundItems)
		{
			if ((config.onlyShowLoot() && !groundItem.isMine()))
			{
				continue;
			}

			/*
			 * highlighted items have the highest priority so if an item is highlighted at this location
			 * we can early return
			 */
			NamedQuantity item = new NamedQuantity(groundItem);
			if (config.showLootbeamForHighlighted()
				&& TRUE.equals(highlightedItems.getUnchecked(item)))
			{
				addLootbeam(worldPoint,
					MoreObjects.firstNonNull(getItemColor(groundItem.getItemId()), config.highlightedColor()));
				return;
			}

			// Explicit hide takes priority over implicit highlight
			if (TRUE.equals(hiddenItems.getUnchecked(item)))
			{
				continue;
			}

			int itemPrice = getValueByMode(groundItem.getGePrice(), groundItem.getHaPrice());
			if (itemPrice > highestPrice)
			{
				highestPrice = itemPrice;
				highestItem = groundItem;
			}
		}

		if (highestItem != null && config.showLootbeamTier() != HighlightTier.OFF)
		{
			for (PriceHighlight highlight : priceChecks)
			{
				if (highestPrice > highlight.getPrice() && highestPrice > config.showLootbeamTier().getValueFromTier(config))
				{
					// use color from the most expensive item
					addLootbeam(worldPoint,
						MoreObjects.firstNonNull(getItemColor(highestItem.getItemId()), highlight.color));
					return;
				}
			}
		}

		removeLootbeam(worldPoint);
	}

	private void handleLootbeams()
	{
		for (WorldPoint worldPoint : collectedGroundItems.rowKeySet())
		{
			handleLootbeam(worldPoint);
		}
	}

	private void removeAllLootbeams()
	{
		for (Lootbeam lootbeam : lootbeams.values())
		{
			lootbeam.remove();
		}

		lootbeams.clear();
	}

	private void addLootbeam(WorldPoint worldPoint, Color color)
	{
		Lootbeam lootbeam = lootbeams.get(worldPoint);
		if (lootbeam == null)
		{
			lootbeam = new Lootbeam(client, clientThread, worldPoint, color, config.lootbeamStyle());
			lootbeams.put(worldPoint, lootbeam);
		}
		else
		{
			lootbeam.setColor(color);
			lootbeam.setStyle(config.lootbeamStyle());
		}
	}

	private void removeLootbeam(WorldPoint worldPoint)
	{
		Lootbeam lootbeam = lootbeams.remove(worldPoint);
		if (lootbeam != null)
		{
			lootbeam.remove();
		}
	}

	Color getItemColor(int itemId)
	{
		return configManager.getConfiguration(GroundItemsConfig.GROUP, HIGHLIGHT_COLOR_PREFIX + itemId, Color.class);
	}

	void setItemColor(int itemId, Color color)
	{
		configManager.setConfiguration(GroundItemsConfig.GROUP, HIGHLIGHT_COLOR_PREFIX + itemId, color);
	}

	void unsetItemColor(int itemId)
	{
		configManager.unsetConfiguration(GroundItemsConfig.GROUP, HIGHLIGHT_COLOR_PREFIX + itemId);
	}
}
