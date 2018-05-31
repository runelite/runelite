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

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Rectangle;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.ItemLayer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Node;
import net.runelite.api.Player;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemLayerChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.grounditems.config.ItemHighlightMode.OVERLAY;
import net.runelite.client.plugins.grounditems.config.MenuHighlightMode;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.BOTH;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.NAME;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.OPTION;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.http.api.item.ItemPrice;

@PluginDescriptor(
	name = "Ground Items"
)
@Slf4j
public class GroundItemsPlugin extends Plugin
{
	//Size of one region
	private static final int REGION_SIZE = 104;
	// The max distance in tiles between the player and the item.
	private static final int MAX_RANGE = 18;
	// Used when getting High Alchemy value - multiplied by general store price.
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	// ItemID for coins
	private static final int COINS = ItemID.COINS_995;

	@Getter(AccessLevel.PACKAGE)
	private final Map<Rectangle, String> hiddenBoxes = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final Map<Rectangle, String> highlightBoxes = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed;

	private List<String> hiddenItemList = new ArrayList<>();
	private List<String> highlightedItemsList = new ArrayList<>();
	private boolean dirty;

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
	private GroundItemsConfig config;

	@Inject
	private GroundItemsOverlay overlay;

	@Getter
	private final Map<GroundItem.GroundItemKey, GroundItem> collectedGroundItems = new LinkedHashMap<>();
	private final List<GroundItem> groundItems = new ArrayList<>();
	private LoadingCache<String, Boolean> highlightedItems;
	private LoadingCache<String, Boolean> hiddenItems;

	// Collects similar ground items
	private final Collector<GroundItem, ?, Map<GroundItem.GroundItemKey, GroundItem>> groundItemMapCollector = Collectors
		.toMap
			((item) -> new GroundItem.GroundItemKey(item.getItemId(), item.getLocation()), Function.identity(), (a, b) ->
				{
					b.setHaPrice(a.getHaPrice() + b.getHaPrice());
					b.setGePrice(a.getGePrice() + b.getGePrice());
					b.setQuantity(a.getQuantity() + b.getQuantity());
					return b;
				},
				() -> collectedGroundItems);

	@Provides
	GroundItemsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroundItemsConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Override
	protected void startUp()
	{
		reset();
		mouseManager.registerMouseListener(inputListener);
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		mouseManager.unregisterMouseListener(inputListener);
		keyManager.unregisterKeyListener(inputListener);
		groundItems.clear();
		collectedGroundItems.clear();
		highlightedItems.invalidateAll();
		highlightedItems = null;
		hiddenItems.invalidateAll();
		hiddenItems = null;
		hiddenItemList = null;
		highlightedItemsList = null;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("grounditems"))
		{
			reset();
		}
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			dirty = true;
		}
	}

	@Subscribe
	public void onItemLayerChanged(ItemLayerChanged event)
	{
		dirty = true;
	}

	void checkItems()
	{
		final Player player = client.getLocalPlayer();

		if (!dirty || player == null || client.getViewportWidget() == null)
		{
			return;
		}

		dirty = false;

		final Region region = client.getRegion();
		final Tile[][][] tiles = region.getTiles();
		final int z = client.getPlane();
		final LocalPoint from = player.getLocalLocation();

		final int lowerX = Math.max(0, from.getRegionX() - MAX_RANGE);
		final int lowerY = Math.max(0, from.getRegionY() - MAX_RANGE);

		final int upperX = Math.min(from.getRegionX() + MAX_RANGE, REGION_SIZE - 1);
		final int upperY = Math.min(from.getRegionY() + MAX_RANGE, REGION_SIZE - 1);

		groundItems.clear();

		for (int x = lowerX; x <= upperX; ++x)
		{
			for (int y = lowerY; y <= upperY; ++y)
			{
				Tile tile = tiles[z][x][y];
				if (tile == null)
				{
					continue;
				}

				ItemLayer itemLayer = tile.getItemLayer();
				if (itemLayer == null)
				{
					continue;
				}

				Node current = itemLayer.getBottom();

				// adds the items on the ground to the ArrayList to be drawn
				while (current instanceof Item)
				{
					final Item item = (Item) current;

					// Continue iteration
					current = current.getNext();

					// Build ground item
					final GroundItem groundItem = buildGroundItem(tile, item);

					if (groundItem != null)
					{
						groundItem.setHeight(itemLayer.getHeight());
						groundItems.add(groundItem);
					}
				}
			}
		}

		// Group ground items together and sort them properly
		collectedGroundItems.clear();
		Lists.reverse(groundItems).stream().collect(groundItemMapCollector);
	}

	@Nullable
	private GroundItem buildGroundItem(final Tile tile, final Item item)
	{
		// Collect the data for the item
		final int itemId = item.getId();
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemId;
		final int alchPrice = Math.round(itemComposition.getPrice() * HIGH_ALCHEMY_CONSTANT);

		final GroundItem groundItem = GroundItem.builder()
			.id(itemId)
			.location(tile.getWorldLocation())
			.itemId(realItemId)
			.quantity(item.getQuantity())
			.name(itemComposition.getName())
			.haPrice(alchPrice * item.getQuantity())
			.build();


		// Update item price in case it is coins
		if (realItemId == COINS)
		{
			groundItem.setHaPrice(groundItem.getQuantity());
			groundItem.setGePrice(groundItem.getQuantity());
		}

		return groundItem;
	}

	private void reset()
	{
		Splitter COMMA_SPLITTER = Splitter.on(Pattern.compile("\\s*,\\s*"));

		// gets the hidden items from the text box in the config
		hiddenItemList = COMMA_SPLITTER.splitToList(config.getHiddenItems().trim());

		// gets the highlighted items from the text box in the config
		highlightedItemsList = COMMA_SPLITTER.splitToList(config.getHighlightItems().trim());

		highlightedItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(highlightedItemsList));

		hiddenItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(hiddenItemList));

		dirty = true;
	}

	private ItemPrice getItemPrice(ItemComposition itemComposition)
	{
		if (itemComposition.getNote() != -1)
		{
			return itemManager.getItemPriceAsync(itemComposition.getLinkedNoteId());
		}
		else
		{
			return itemManager.getItemPriceAsync(itemComposition.getId());
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (config.itemHighlightMode() != OVERLAY
			&& event.getOption().equals("Take")
			&& event.getType() == MenuAction.GROUND_ITEM_THIRD_OPTION.getId())
		{
			int itemId = event.getIdentifier();
			ItemComposition itemComposition = client.getItemDefinition(itemId);

			if (isHidden(itemComposition.getName()))
			{
				return;
			}

			Region region = client.getRegion();
			Tile tile = region.getTiles()[client.getPlane()][event.getActionParam0()][event.getActionParam1()];
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

			ItemPrice itemPrice = getItemPrice(itemComposition);
			int price = itemPrice == null ? (int)Math.floor(itemComposition.getPrice() * HIGH_ALCHEMY_CONSTANT) : itemPrice.getPrice();
			int cost = quantity * price;
			Color color = overlay.getCostColor(cost, isHighlighted(itemComposition.getName()),
				isHidden(itemComposition.getName()));

			if (!color.equals(config.defaultColor()))
			{
				String hexColor = Integer.toHexString(color.getRGB() & 0xFFFFFF);
				String colTag = "<col=" + hexColor + ">";
				final MenuHighlightMode mode = config.menuHighlightMode();

				if (mode == BOTH || mode == OPTION)
				{
					lastEntry.setOption(colTag + "Take");
				}

				if (mode == BOTH || mode == NAME)
				{
					String target = lastEntry.getTarget().substring(lastEntry.getTarget().indexOf(">") + 1);
					lastEntry.setTarget(colTag + target);
				}
			}

			if (config.showMenuItemQuantities() && itemComposition.isStackable() && quantity > 1)
			{
				lastEntry.setTarget(lastEntry.getTarget() + " (" + quantity + ")");
			}

			client.setMenuEntries(menuEntries);
		}
	}

	void updateList(String item, boolean hiddenList)
	{
		List<String> items = new ArrayList<>((hiddenList) ? hiddenItemList : highlightedItemsList);

		items.removeIf(s -> s.isEmpty());
		if (!items.removeIf(s -> s.equalsIgnoreCase(item)))
		{
			items.add(item);
		}

		String newList = Joiner.on(", ").join(items);
		// This triggers the config update which updates the list
		if (hiddenList)
		{
			config.setHiddenItems(newList);
		}
		else
		{
			config.setHighlightedItem(newList);
		}
	}

	public boolean isHighlighted(String item)
	{
		return TRUE.equals(highlightedItems.getUnchecked(item));
	}

	public boolean isHidden(String item)
	{
		return TRUE.equals(hiddenItems.getUnchecked(item));
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			setHotKeyPressed(false);
		}
	}
}
