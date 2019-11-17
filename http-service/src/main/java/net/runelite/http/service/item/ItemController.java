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

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController
{
	private static final String RUNELITE_CACHE = "RuneLite-Cache";
	private static final int MAX_BATCH_LOOKUP = 1024;

	private static class MemoizedPrices
	{
		final ItemPrice[] prices;
		final String hash;

		MemoizedPrices(ItemPrice[] prices)
		{
			this.prices = prices;

			Hasher hasher = Hashing.sha256().newHasher();
			for (ItemPrice itemPrice : prices)
			{
				hasher.putInt(itemPrice.getId()).putInt(itemPrice.getPrice());
			}
			HashCode code = hasher.hash();
			hash = code.toString();
		}
	}

	private final Cache<Integer, Integer> cachedEmpty = CacheBuilder.newBuilder()
		.maximumSize(1024L)
		.build();

	private final ItemService itemService;

	private final Supplier<MemoizedPrices> memoizedPrices;

	@Autowired
	public ItemController(ItemService itemService)
	{
		this.itemService = itemService;

		memoizedPrices = Suppliers.memoizeWithExpiration(() -> new MemoizedPrices(itemService.fetchPrices().stream()
			.map(priceEntry ->
			{
				ItemPrice itemPrice = new ItemPrice();
				itemPrice.setId(priceEntry.getItem());
				itemPrice.setName(priceEntry.getName());
				itemPrice.setPrice(priceEntry.getPrice());
				itemPrice.setTime(priceEntry.getTime());
				return itemPrice;
			})
			.toArray(ItemPrice[]::new)), 30, TimeUnit.MINUTES);
	}

	@GetMapping("/{itemId}")
	public Item getItem(HttpServletResponse response, @PathVariable int itemId)
	{
		ItemEntry item = itemService.getItem(itemId);
		if (item != null)
		{
			return item.toItem();
		}

		itemService.queueItem(itemId);
		return null;
	}

	@GetMapping(path = "/{itemId}/icon", produces = "image/gif")
	public ResponseEntity<byte[]> getIcon(@PathVariable int itemId)
	{
		ItemEntry item = itemService.getItem(itemId);
		if (item != null && item.getIcon() != null)
		{
			return ResponseEntity.ok(item.getIcon());
		}

		itemService.queueItem(itemId);
		return ResponseEntity.notFound().build();
	}

	@GetMapping(path = "/{itemId}/icon/large", produces = "image/gif")
	public ResponseEntity<byte[]> getIconLarge(HttpServletResponse response, @PathVariable int itemId)
	{
		ItemEntry item = itemService.getItem(itemId);
		if (item != null && item.getIcon_large() != null)
		{
			return ResponseEntity.ok(item.getIcon_large());
		}

		itemService.queueItem(itemId);
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{itemId}/price")
	public ResponseEntity<ItemPrice> itemPrice(
		@PathVariable int itemId,
		@RequestParam(required = false) Instant time
	)
	{
		if (cachedEmpty.getIfPresent(itemId) != null)
		{
			return ResponseEntity.notFound()
				.header(RUNELITE_CACHE, "HIT")
				.build();
		}

		Instant now = Instant.now();

		if (time != null && time.isAfter(now))
		{
			time = now;
		}

		ItemEntry item = itemService.getItem(itemId);
		if (item == null)
		{
			itemService.queueItem(itemId); // queue lookup
			cachedEmpty.put(itemId, itemId); // cache empty
			return ResponseEntity.notFound()
				.header(RUNELITE_CACHE, "MISS")
				.build();
		}

		PriceEntry priceEntry = itemService.getPrice(itemId, time);

		if (time != null)
		{
			if (priceEntry == null)
			{
				// we maybe can't backfill this
				return ResponseEntity.notFound()
					.header(RUNELITE_CACHE, "MISS")
					.build();
			}
		}
		else if (priceEntry == null)
		{
			// Price is unknown
			cachedEmpty.put(itemId, itemId);
			return ResponseEntity.notFound()
				.header(RUNELITE_CACHE, "MISS")
				.build();
		}

		ItemPrice itemPrice = new ItemPrice();
		itemPrice.setId(item.getId());
		itemPrice.setName(item.getName());
		itemPrice.setPrice(priceEntry.getPrice());
		itemPrice.setTime(priceEntry.getTime());

		return ResponseEntity.ok()
			.cacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES).cachePublic())
			.body(itemPrice);
	}

	@GetMapping("/search")
	public SearchResult search(@RequestParam String query)
	{
		List<ItemEntry> result = itemService.search(query);

		itemService.queueSearch(query);

		SearchResult searchResult = new SearchResult();
		searchResult.setItems(result.stream()
			.map(ItemEntry::toItem)
			.collect(Collectors.toList()));
		return searchResult;
	}

	@GetMapping("/price")
	public ItemPrice[] prices(@RequestParam("id") int[] itemIds)
	{
		if (itemIds.length > MAX_BATCH_LOOKUP)
		{
			itemIds = Arrays.copyOf(itemIds, MAX_BATCH_LOOKUP);
		}

		List<PriceEntry> prices = itemService.getPrices(itemIds);

		return prices.stream()
			.map(priceEntry ->
			{
				ItemPrice itemPrice = new ItemPrice();
				itemPrice.setId(priceEntry.getItem());
				itemPrice.setName(priceEntry.getName());
				itemPrice.setPrice(priceEntry.getPrice());
				itemPrice.setTime(priceEntry.getTime());
				return itemPrice;
			})
			.toArray(ItemPrice[]::new);
	}

	@GetMapping("/prices")
	public ResponseEntity<ItemPrice[]> prices()
	{
		MemoizedPrices memorizedPrices = this.memoizedPrices.get();
		return ResponseEntity.ok()
			.eTag(memorizedPrices.hash)
			.cacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES).cachePublic())
			.body(memorizedPrices.prices);
	}
}
