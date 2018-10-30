/*
 * Copyright (c) 2018 Ben Dol <dolb90@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.game;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.item.ItemInfo;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemClient;
import net.runelite.http.api.item.SearchResult;
import net.runelite.http.api.osrsbox.ItemNotFoundException;
import net.runelite.http.api.osrsbox.OSRSBoxClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author Ben Dol
 */
@Slf4j
@Singleton
public class ItemInfoManager
{
	static final ItemInfo EMPTY = new ItemInfo();
	static final ItemInfo NONE = new ItemInfo();

	@Getter
	private final LoadingCache<Integer, ItemInfo> itemInfoSearches;
	@Getter
	private final LoadingCache<String, SearchResult> itemSearches;

	private final ItemInfoLoader itemInfoLoader;
	private final ItemSearchLoader itemSearchLoader;

	private List<String> unsuitableTerms = new ArrayList<>();

	@Inject
	public ItemInfoManager(ScheduledExecutorService executor, ItemClient itemClient)
	{
		this.itemInfoLoader = new ItemInfoLoader(executor);
		this.itemInfoSearches = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.build(itemInfoLoader);

		this.itemSearchLoader = new ItemSearchLoader(itemClient, executor);
		this.itemSearches = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.build(itemSearchLoader);
	}

	/**
	 * Synchronously look up an item info.
	 *
	 * @param itemId item id
	 * @return ItemInfo or null
	 */
	public ItemInfo lookup(int itemId) throws ItemNotFoundException
	{
		return OSRSBoxClient.getItem(itemId);
	}

	/**
	 * Asynchronously look up an item info
	 *
	 * @param itemId item id
	 * @return ItemInfo or null
	 */
	public ItemInfo lookupAsync(int itemId)
	{
		ItemInfo itemInfo = itemInfoSearches.getIfPresent(itemId);
		if (itemInfo != null && itemInfo != EMPTY)
		{
			return itemInfo == NONE ? null : itemInfo;
		}

		itemInfoSearches.refresh(itemId);
		return null;
	}

	/**
	 * Asynchronously look up an item info using the item name.
	 *
	 * @param searchTerm item search term
	 * @return ItemInfo or null
	 */
	public ItemInfo lookupAsync(String searchTerm)
	{
		SearchResult searchResult = itemSearches.getIfPresent(searchTerm);
		if (searchResult != null && searchResult != ItemSearchLoader.EMPTY)
		{
			if (searchResult != ItemSearchLoader.NONE)
			{
				List<Item> items = searchResult.getItems();
				if (items != null && !items.isEmpty())
				{
					Item bestMatch = findBestItemMatch(items, searchTerm);
					if (bestMatch != null)
					{
						return lookupAsync(bestMatch.getId());
					}
					else
					{
						unsuitableTerms.add(searchTerm);
						log.debug("No suitable match found for " + searchTerm);
					}
				}
			}
		}

		itemSearches.refresh(searchTerm);
		return null;
	}

	private static Item findBestItemMatch(List<Item> items, String itemName)
	{
		for (Item item : items)
		{
			if (item.getName().equalsIgnoreCase(itemName))
			{
				return item;
			}
		}
		return null;
	}

	public boolean isLoading()
	{
		return itemSearchLoader.isLoading() || itemInfoLoader.isLoading();
	}

	public boolean isUnsuitableSearchTerm(String searchTerm)
	{
		return unsuitableTerms.contains(searchTerm);
	}
}
