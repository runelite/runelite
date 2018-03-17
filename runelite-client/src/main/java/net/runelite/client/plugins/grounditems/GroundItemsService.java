/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import com.google.common.base.Splitter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.Node;
import net.runelite.client.game.ItemManager;

@Singleton
public class GroundItemsService implements AutoCloseable
{
	// Splitting the items in the config on commas
	private static final Splitter COMMA_SPLITTER = Splitter.on(Pattern.compile("\\s*,\\s*"));
	// Threshold for highlighting items as blue.
	private static final int LOW_VALUE = 20_000;
	// Threshold for highlighting items as green.
	private static final int MEDIUM_VALUE = 100_000;
	// Threshold for highlighting items as amber.
	private static final int HIGH_VALUE = 1_000_000;
	// Threshold for highlighting items as pink.
	private static final int INSANE_VALUE = 10_000_000;
	// Collects ground items by unique ID and reduces them to compute HA price, GE price and quantity
	private static final Collector<GroundItem, ?, Map<String, GroundItem>> GROUND_ITEM_MAP_COLLECTOR = Collectors
		.toMap
			(GroundItem::getName, Function.identity(), ((a, b) ->
				GroundItem.builder()
					.name(a.getName())
					.haPrice(a.getHaPrice() + b.getHaPrice())
					.gePrice(a.getGePrice() + b.getGePrice())
					.quantity(a.getQuantity() + b.getQuantity())
					.build()));

	private final GroundItemsConfig config;
	private final ItemManager itemManager;
	private LoadingCache<GroundItemCacheKey, GroundItem> groundItems;
	private List<String> hiddenItems;
	private List<String> highlightedItems;
	private LoadingCache<String, Boolean> highlightedItemAssociations;
	private LoadingCache<String, Boolean> hiddenItemAssociations;

	@Inject
	private GroundItemsService(
		final GroundItemsConfig config,
		final ItemManager itemManager,
		final ScheduledExecutorService executorService)
	{
		this.config = config;
		this.itemManager = itemManager;

		groundItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(1, TimeUnit.HOURS)
			.build(new GroundItemLoader(itemManager, executorService));

		reset();
	}

	void reset()
	{
		// gets the hidden items from the text box in the config
		hiddenItems = ImmutableList.copyOf(COMMA_SPLITTER
			.splitToList(config.getHiddenItems().toLowerCase().trim()));

		// gets the highlighted items from the text box in the config
		highlightedItems = ImmutableList.copyOf(COMMA_SPLITTER
			.splitToList(config.getHighlightItems().toLowerCase().trim()));

		// cleanup previous association caches
		if (hiddenItemAssociations != null)
		{
			hiddenItemAssociations.cleanUp();
		}

		if (highlightedItemAssociations != null)
		{
			highlightedItemAssociations.cleanUp();
		}

		// create new association caches
		hiddenItemAssociations = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(1, TimeUnit.MINUTES)
			.build(new WildcardNameAssociationLoader(hiddenItems));

		highlightedItemAssociations = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(1, TimeUnit.MINUTES)
			.build(new WildcardNameAssociationLoader(highlightedItems));
	}

	@Override
	public void close()
	{
		hiddenItems = null;
		highlightedItems = null;
		groundItems.cleanUp();
		hiddenItemAssociations.cleanUp();
		hiddenItemAssociations = null;
		highlightedItemAssociations.cleanUp();
		highlightedItemAssociations = null;
	}

	/**
	 * Filters ground items based on plugin configuration.
	 * Removes hidden items, highlights highlighted items and applies price filters.
	 *
	 * @param start root node to look for items
	 * @return list of filtered ground items
	 */
	Map<String, GroundItem> filterAndCollect(Node start)
	{
		final List<GroundItem> items = new ArrayList<>();
		Node current = start;

		while (current instanceof Item)
		{
			final Item item = (Item) current;
			current = current.getNext();

			final GroundItem groundItem = findGroundItem(item);

			if (config.showHighlightedOnly() && !wildcardMatch(groundItem.getName(), false))
			{
				continue;
			}

			if (wildcardMatch(groundItem.getName(), true))
			{
				continue;
			}

			items.add(groundItem);
		}

		// The bottom item is drawn first
		Collections.reverse(items);

		return items.stream().collect(GROUND_ITEM_MAP_COLLECTOR);
	}

	/**
	 * Tries to find match in collection of items with wildcards
	 *
	 * @param groundItem ground item
	 * @param hidden     if true search for hidden items, otherwise search for highlighted items
	 * @return true if match was made
	 */
	boolean wildcardMatch(final String groundItem, boolean hidden)
	{
		if (hidden)
		{
			final Boolean isHidden = hiddenItemAssociations.getUnchecked(groundItem);
			return isHidden != null ? isHidden : false;
		}

		final Boolean isHighlighted = highlightedItemAssociations.getUnchecked(groundItem);
		return isHighlighted != null ? isHighlighted : false;
	}

	/**
	 * Get color based on cost and name
	 *
	 * @param name the name
	 * @param cost the cost
	 * @return color
	 */
	Color getCostColor(String name, int cost)
	{
		if (wildcardMatch(name, false))
		{
			return config.highlightedColor();
		}

		// set the color according to rarity, if possible
		if (cost >= INSANE_VALUE) // 10,000,000 gp
		{
			return config.insaneValueColor();
		}
		else if (cost >= HIGH_VALUE) // 1,000,000 gp
		{
			return config.highValueColor();
		}
		else if (cost >= MEDIUM_VALUE) // 100,000 gp
		{
			return config.mediumValueColor();
		}
		else if (cost >= LOW_VALUE) // 20,000 gp
		{
			return config.lowValueColor();
		}
		else
		{
			return config.defaultColor();
		}
	}

	/**
	 * Tries to find GroundItem in ground item cache, and if none was found, reload it asynchronously
	 *
	 * @param item node item
	 * @return ground item
	 */
	private GroundItem findGroundItem(Item item)
	{
		final ItemComposition itemComposition = itemManager.getItemComposition(item.getId());
		final GroundItemCacheKey key = new GroundItemCacheKey(itemComposition, item.getQuantity());

		GroundItem groundItem = groundItems.getIfPresent(key);

		if (groundItem == GroundItemLoader.EMPTY)
		{
			groundItem = null;
		}

		if (groundItem == null)
		{
			groundItems.refresh(key);
		}

		return groundItem != null
			? groundItem
			: GroundItem.builder().name(itemComposition.getName()).build();
	}
}
