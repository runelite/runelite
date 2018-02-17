/*
 * Copyright (c) 2017-2018, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.item;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController
{
	private static final Duration CACHE_DUATION = Duration.ofMinutes(30);
	private static final String RUNELITE_CACHE = "RuneLite-Cache";

	private final Cache<String, SearchResult> cachedSearches = CacheBuilder.newBuilder()
		.maximumSize(1024L)
		.build();

	private final ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService)
	{
		this.itemService = itemService;
	}

	@RequestMapping("/{itemId}")
	public Item getItem(HttpServletResponse response, @PathVariable int itemId)
	{
		ItemEntry item = itemService.getItem(itemId);
		if (item != null)
		{
			response.setHeader(RUNELITE_CACHE, "HIT");
			return item.toItem();
		}

		item = itemService.fetchItem(itemId);
		if (item != null)
		{
			response.setHeader(RUNELITE_CACHE, "MISS");
			return item.toItem();
		}

		return null;
	}

	@RequestMapping(path = "/{itemId}/icon", produces = "image/gif")
	public byte[] getIcon(HttpServletResponse response, @PathVariable int itemId)
	{
		ItemEntry item = itemService.getItem(itemId);
		if (item != null && item.getIcon() != null)
		{
			response.setHeader(RUNELITE_CACHE, "HIT");
			return item.getIcon();
		}

		item = itemService.fetchItem(itemId);
		if (item != null)
		{
			response.setHeader(RUNELITE_CACHE, "MISS");
			return item.getIcon();
		}

		return null;
	}

	@RequestMapping(path = "/{itemId}/icon/large", produces = "image/gif")
	public byte[] getIconLarge(HttpServletResponse response, @PathVariable int itemId)
	{
		ItemEntry item = itemService.getItem(itemId);
		if (item != null && item.getIcon_large() != null)
		{
			response.setHeader(RUNELITE_CACHE, "HIT");
			return item.getIcon_large();
		}

		item = itemService.fetchItem(itemId);
		if (item != null)
		{
			response.setHeader(RUNELITE_CACHE, "MISS");
			return item.getIcon_large();
		}

		return null;
	}

	@RequestMapping("/{itemId}/price")
	public ResponseEntity<ItemPrice> itemPrice(
		@PathVariable int itemId,
		@RequestParam(required = false) Instant time
	)
	{
		Instant now = Instant.now();
		boolean hit = true;

		if (time != null && time.isAfter(now))
		{
			time = now;
		}

		ItemEntry item = itemService.getItem(itemId);
		if (item == null)
		{
			item = itemService.fetchItem(itemId);
			hit = false;

			if (item == null)
			{
				return ResponseEntity.notFound().build();
			}
		}

		PriceEntry priceEntry = itemService.getPrice(itemId, time);

		if (time != null)
		{
			if (priceEntry == null)
			{
				// we maybe can't backfill this
				return ResponseEntity.notFound().build();
			}
		}
		else
		{
			Instant cacheTime = now.minus(CACHE_DUATION);
			if (priceEntry == null || priceEntry.getFetched_time().isBefore(cacheTime))
			{
				// Price is unknown, or was fetched too long ago
				List<PriceEntry> prices = itemService.fetchPrice(itemId);

				if (prices == null || prices.isEmpty())
				{
					return ResponseEntity.notFound().build();
				}

				// Get the most recent price
				priceEntry = prices.get(prices.size() - 1);
				hit = false;
			}
		}

		ItemPrice itemPrice = new ItemPrice();
		itemPrice.setItem(item.toItem());
		itemPrice.setPrice(priceEntry.getPrice());
		itemPrice.setTime(priceEntry.getTime());

		return ResponseEntity.ok()
			.header(RUNELITE_CACHE, hit ? "HIT" : "MISS")
			.cacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES).cachePublic())
			.body(itemPrice);
	}

	@RequestMapping("/search")
	public SearchResult search(HttpServletResponse response, @RequestParam String query)
	{
		// rs api seems to require lowercase
		query = query.toLowerCase();

		SearchResult searchResult = cachedSearches.getIfPresent(query);
		if (searchResult != null)
		{
			response.setHeader(RUNELITE_CACHE, "HIT");
			return searchResult;
		}

		try
		{
			RSSearch search = itemService.fetchRSSearch(query);

			searchResult = new SearchResult();
			List<Item> items = search.getItems().stream()
				.map(rsi -> rsi.toItem())
				.collect(Collectors.toList());
			searchResult.setItems(items);

			cachedSearches.put(query, searchResult);

			itemService.batchInsertItems(search);

			response.setHeader(RUNELITE_CACHE, "MISS");
			return searchResult;
		}
		catch (IOException ex)
		{
			log.warn("error while searching items", ex);
			return null;
		}
	}
}
