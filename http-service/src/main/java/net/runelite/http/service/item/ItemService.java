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

import com.google.gson.JsonParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.item.ItemType;
import net.runelite.http.service.cache.CacheService;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Service
@Slf4j
public class ItemService
{
	private static final String CREATE_ITEMS = "CREATE TABLE IF NOT EXISTS `items` (\n"
		+ "  `id` int(11) NOT NULL,\n"
		+ "  `name` tinytext NOT NULL,\n"
		+ "  `description` tinytext NOT NULL,\n"
		+ "  `type` enum('DEFAULT') NOT NULL,\n"
		+ "  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
		+ "  PRIMARY KEY (`id`)\n"
		+ ") ENGINE=InnoDB";

	private static final String CREATE_PRICES = "CREATE TABLE IF NOT EXISTS `prices` (\n"
		+ "  `item` int(11) NOT NULL,\n"
		+ "  `price` int(11) NOT NULL,\n"
		+ "  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',\n"
		+ "  `fetched_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',\n"
		+ "  UNIQUE KEY `item_time` (`item`,`time`),\n"
		+ "  KEY `item_fetched_time` (`item`,`fetched_time`)\n"
		+ ") ENGINE=InnoDB";

	private final Sql2o sql2o;
	private final CacheService cacheService;
	private final OkHttpClient okHttpClient;
	private final HttpUrl itemUrl;
	private final HttpUrl priceUrl;

	private int[] tradeableItems;
	private final Random random = new Random();

	@Autowired
	public ItemService(
		@Qualifier("Runelite SQL2O") Sql2o sql2o,
		CacheService cacheService,
		OkHttpClient okHttpClient,
		@Value("${runelite.item.itemUrl}") String itemUrl,
		@Value("${runelite.item.priceUrl}") String priceUrl
	)
	{
		this.sql2o = sql2o;
		this.cacheService = cacheService;
		this.okHttpClient = okHttpClient;
		this.itemUrl = HttpUrl.get(itemUrl);
		this.priceUrl = HttpUrl.get(priceUrl);

		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_ITEMS)
				.executeUpdate();

			con.createQuery(CREATE_PRICES)
				.executeUpdate();
		}
	}

	public ItemEntry getItem(int itemId)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("select id, name, description, type from items where id = :id")
				.addParameter("id", itemId)
				.executeAndFetchFirst(ItemEntry.class);
		}
	}

	public ItemEntry fetchItem(int itemId)
	{
		try
		{
			RSItem rsItem = fetchRSItem(itemId);

			try (Connection con = sql2o.open())
			{
				con.createQuery("insert into items (id, name, description, type) values (:id,"
					+ " :name, :description, :type) ON DUPLICATE KEY UPDATE name = :name,"
					+ " description = :description, type = :type")
					.addParameter("id", rsItem.getId())
					.addParameter("name", rsItem.getName())
					.addParameter("description", rsItem.getDescription())
					.addParameter("type", rsItem.getType())
					.executeUpdate();
			}

			ItemEntry item = new ItemEntry();
			item.setId(itemId);
			item.setName(rsItem.getName());
			item.setDescription(rsItem.getDescription());
			item.setType(ItemType.of(rsItem.getType()));
			return item;
		}
		catch (IOException ex)
		{
			log.warn("unable to fetch item {}", itemId, ex);
			return null;
		}
	}

	private void fetchPrice(int itemId)
	{
		RSPrices rsprice;
		try
		{
			rsprice = fetchRSPrices(itemId);
		}
		catch (IOException ex)
		{
			log.warn("unable to fetch price for item {}", itemId, ex);
			return;
		}

		try (Connection con = sql2o.beginTransaction())
		{
			Instant now = Instant.now();

			Query query = con.createQuery("insert into prices (item, price, time, fetched_time) values (:item, :price, :time, :fetched_time) "
				+ "ON DUPLICATE KEY UPDATE price = VALUES(price), fetched_time = VALUES(fetched_time)");

			for (Map.Entry<Long, Integer> entry : rsprice.getDaily().entrySet())
			{
				long ts = entry.getKey(); // ms since epoch
				int price = entry.getValue(); // gp

				Instant time = Instant.ofEpochMilli(ts);

				query
					.addParameter("item", itemId)
					.addParameter("price", price)
					.addParameter("time", time)
					.addParameter("fetched_time", now)
					.addToBatch();
			}

			query.executeBatch();
			con.commit(false);
		}
	}

	public List<PriceEntry> fetchPrices()
	{
		try (Connection con = sql2o.beginTransaction())
		{
			Query query = con.createQuery("select t2.item, t3.name, t2.time, prices.price, prices.fetched_time, t4.high, t4.low" +
				"  from (select t1.item as item, max(t1.time) as time from prices t1 group by item) t2" +
				"  join prices on t2.item=prices.item and t2.time=prices.time" +
				"  join items t3 on t2.item=t3.id" +
				"  join wiki_prices t4 on t2.item=t4.item_id");
			return query.executeAndFetch(PriceEntry.class);
		}
	}

	private RSItem fetchRSItem(int itemId) throws IOException
	{
		HttpUrl itemUrl = this.itemUrl
			.newBuilder()
			.addQueryParameter("item", "" + itemId)
			.build();

		Request request = new Request.Builder()
			.url(itemUrl)
			.build();

		RSItemResponse itemResponse = fetchJson(request, RSItemResponse.class);
		return itemResponse.getItem();

	}

	private RSPrices fetchRSPrices(int itemId) throws IOException
	{
		HttpUrl priceUrl = this.priceUrl
			.newBuilder()
			.addPathSegment(itemId + ".json")
			.build();

		Request request = new Request.Builder()
			.url(priceUrl)
			.build();

		return fetchJson(request, RSPrices.class);
	}

	private <T> T fetchJson(Request request, Class<T> clazz) throws IOException
	{
		try (Response response = okHttpClient.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unsuccessful http response: " + response);
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), clazz);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	@Scheduled(fixedDelay = 20_000)
	public void crawlPrices()
	{
		if (tradeableItems == null || tradeableItems.length == 0)
		{
			return;
		}

		int idx = random.nextInt(tradeableItems.length);
		int id = tradeableItems[idx];

		log.debug("Fetching price for {}", id);

		// check if the item name or description has changed
		fetchItem(id);
		fetchPrice(id);
	}

	@Scheduled(fixedDelay = 1_800_000) // 30 minutes
	public void reloadItems() throws IOException
	{
		List<ItemDefinition> items = cacheService.getItems();
		if (items.isEmpty())
		{
			log.warn("Failed to load any items from cache, item price updating will be disabled");
		}

		tradeableItems = items.stream()
			.filter(ItemDefinition::isTradeable)
			.mapToInt(ItemDefinition::getId)
			.toArray();

		log.debug("Loaded {} tradeable items", tradeableItems.length);
	}
}
