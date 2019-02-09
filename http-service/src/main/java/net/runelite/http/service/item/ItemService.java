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
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.item.ItemType;
import net.runelite.http.service.cache.CacheService;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Service
@Slf4j
public class ItemService
{
	private static final String BASE = "https://services.runescape.com/m=itemdb_oldschool";
	private static final HttpUrl RS_ITEM_URL = HttpUrl.parse(BASE + "/api/catalogue/detail.json");
	private static final HttpUrl RS_PRICE_URL = HttpUrl.parse(BASE + "/api/graph");
	private static final HttpUrl RS_SEARCH_URL = HttpUrl.parse(BASE + "/api/catalogue/items.json?category=1");

	private static final String CREATE_ITEMS = "CREATE TABLE IF NOT EXISTS `items` (\n"
		+ "  `id` int(11) NOT NULL,\n"
		+ "  `name` tinytext NOT NULL,\n"
		+ "  `description` tinytext NOT NULL,\n"
		+ "  `type` enum('DEFAULT') NOT NULL,\n"
		+ "  `icon` blob,\n"
		+ "  `icon_large` blob,\n"
		+ "  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
		+ "  PRIMARY KEY (`id`),\n"
		+ "  FULLTEXT idx_name (name)\n"
		+ ") ENGINE=InnoDB";

	private static final String CREATE_PRICES = "CREATE TABLE IF NOT EXISTS `prices` (\n"
		+ "  `item` int(11) NOT NULL,\n"
		+ "  `price` int(11) NOT NULL,\n"
		+ "  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',\n"
		+ "  `fetched_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',\n"
		+ "  UNIQUE KEY `item_time` (`item`,`time`),\n"
		+ "  KEY `item_fetched_time` (`item`,`fetched_time`)\n"
		+ ") ENGINE=InnoDB";

	private static final int MAX_PENDING = 512;

	private final Sql2o sql2o;
	private final CacheService cacheService;

	private final ConcurrentLinkedQueue<PendingLookup> pendingLookups = new ConcurrentLinkedQueue<PendingLookup>();
	private int[] tradeableItems;
	private final Random random = new Random();

	@Autowired
	public ItemService(@Qualifier("Runelite SQL2O") Sql2o sql2o,
		CacheService cacheService)
	{
		this.sql2o = sql2o;
		this.cacheService = cacheService;

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
			ItemEntry item = con.createQuery("select id, name, description, type, icon, icon_large from items where id = :id")
				.addParameter("id", itemId)
				.executeAndFetchFirst(ItemEntry.class);

			return item;
		}
	}

	private PriceEntry getPrice(Connection con, int itemId, Instant time)
	{
		if (time != null)
		{
			return con.createQuery("select item, name, price, time, fetched_time from prices t1 join items t2 on t1.item=t2.id where item = :item and time <= :time order by time desc limit 1")
				.addParameter("item", itemId)
				.addParameter("time", time.toString())
				.executeAndFetchFirst(PriceEntry.class);
		}
		else
		{
			return con.createQuery("select item, name, price, time, fetched_time from prices t1 join items t2 on t1.item=t2.id where item = :item order by time desc limit 1")
				.addParameter("item", itemId)
				.executeAndFetchFirst(PriceEntry.class);
		}
	}

	public PriceEntry getPrice(int itemId, Instant time)
	{
		try (Connection con = sql2o.open())
		{
			return getPrice(con, itemId, time);
		}
	}

	public List<PriceEntry> getPrices(int... itemIds)
	{
		try (Connection con = sql2o.open())
		{
			Set<Integer> seen = new HashSet<>();
			List<PriceEntry> priceEntries = new ArrayList<>(itemIds.length);

			for (int itemId : itemIds)
			{
				if (seen.contains(itemId))
				{
					continue;
				}
				seen.add(itemId);

				PriceEntry priceEntry = getPrice(con, itemId, null);

				if (priceEntry == null)
				{
					continue;
				}

				priceEntries.add(priceEntry);
			}

			return priceEntries;
		}
	}

	public List<ItemEntry> search(String search)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("select id, name, description, type, match (name) against (:search) as score from items "
				+ "where match (name) against (:search) order by score desc limit 10")
				.throwOnMappingFailure(false) // otherwise it tries to map 'score'
				.addParameter("search", search)
				.executeAndFetch(ItemEntry.class);
		}
	}

	public ItemEntry fetchItem(int itemId)
	{
		try
		{
			RSItem rsItem = fetchRSItem(itemId);
			byte[] icon = null, iconLarge = null;

			try
			{
				icon = fetchImage(rsItem.getIcon());
			}
			catch (IOException ex)
			{
				log.warn("error fetching image", ex);
			}

			try
			{
				iconLarge = fetchImage(rsItem.getIcon_large());
			}
			catch (IOException ex)
			{
				log.warn("error fetching image", ex);
			}

			try (Connection con = sql2o.open())
			{
				con.createQuery("insert into items (id, name, description, type, icon, icon_large) values (:id,"
					+ " :name, :description, :type, :icon, :icon_large) ON DUPLICATE KEY UPDATE name = :name,"
					+ " description = :description, type = :type, icon = :icon, icon_large = :icon_large")
					.addParameter("id", rsItem.getId())
					.addParameter("name", rsItem.getName())
					.addParameter("description", rsItem.getDescription())
					.addParameter("type", rsItem.getType())
					.addParameter("icon", icon)
					.addParameter("icon_large", iconLarge)
					.executeUpdate();
			}

			ItemEntry item = new ItemEntry();
			item.setId(itemId);
			item.setName(rsItem.getName());
			item.setDescription(rsItem.getDescription());
			item.setType(ItemType.of(rsItem.getType()));
			item.setIcon(icon);
			item.setIcon_large(iconLarge);
			return item;
		}
		catch (IOException ex)
		{
			log.warn("unable to fetch item {}", itemId, ex);
			return null;
		}
	}

	public List<PriceEntry> fetchPrice(int itemId)
	{
		RSPrices rsprice;
		try
		{
			rsprice = fetchRSPrices(itemId);
		}
		catch (IOException ex)
		{
			log.warn("unable to fetch price for item {}", itemId, ex);
			return null;
		}

		try (Connection con = sql2o.beginTransaction())
		{
			List<PriceEntry> entries = new ArrayList<>();
			Instant now = Instant.now();

			Query query = con.createQuery("insert into prices (item, price, time, fetched_time) values (:item, :price, :time, :fetched_time) "
				+ "ON DUPLICATE KEY UPDATE price = VALUES(price), fetched_time = VALUES(fetched_time)");

			for (Map.Entry<Long, Integer> entry : rsprice.getDaily().entrySet())
			{
				long ts = entry.getKey(); // ms since epoch
				int price = entry.getValue(); // gp

				Instant time = Instant.ofEpochMilli(ts);

				PriceEntry priceEntry = new PriceEntry();
				priceEntry.setItem(itemId);
				priceEntry.setPrice(price);
				priceEntry.setTime(time);
				priceEntry.setFetched_time(now);
				entries.add(priceEntry);

				query
					.addParameter("item", itemId)
					.addParameter("price", price)
					.addParameter("time", time)
					.addParameter("fetched_time", now)
					.addToBatch();
			}

			query.executeBatch();
			con.commit(false);

			return entries;
		}
	}

	public List<PriceEntry> fetchPrices()
	{
		try (Connection con = sql2o.beginTransaction())
		{
			Query query = con.createQuery("select t2.item, t3.name, t2.time, prices.price, prices.fetched_time from (select t1.item as item, max(t1.time) as time from prices t1 group by item) t2 " +
					" join prices on t2.item=prices.item and t2.time=prices.time" +
					" join items t3 on t2.item=t3.id");
			return query.executeAndFetch(PriceEntry.class);
		}
	}

	private RSItem fetchRSItem(int itemId) throws IOException
	{
		HttpUrl itemUrl = RS_ITEM_URL
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
		HttpUrl priceUrl = RS_PRICE_URL
			.newBuilder()
			.addPathSegment(itemId + ".json")
			.build();

		Request request = new Request.Builder()
			.url(priceUrl)
			.build();

		return fetchJson(request, RSPrices.class);
	}

	public RSSearch fetchRSSearch(String query) throws IOException
	{
		// rs api seems to require lowercase
		query = query.toLowerCase();

		HttpUrl searchUrl = RS_SEARCH_URL
			.newBuilder()
			.addQueryParameter("alpha", query)
			.build();

		Request request = new Request.Builder()
			.url(searchUrl)
			.build();

		return fetchJson(request, RSSearch.class);
	}

	private void batchInsertItems(RSSearch search)
	{
		try (Connection con = sql2o.beginTransaction())
		{
			Query q = con.createQuery("insert into items (id, name, description, type) values (:id,"
				+ " :name, :description, :type) ON DUPLICATE KEY UPDATE name = :name,"
				+ " description = :description, type = :type");

			for (RSItem rsItem : search.getItems())
			{
				q.addParameter("id", rsItem.getId())
					.addParameter("name", rsItem.getName())
					.addParameter("description", rsItem.getDescription())
					.addParameter("type", rsItem.getType())
					.addToBatch();
			}

			q.executeBatch();
			con.commit(false);
		}
	}

	private <T> T fetchJson(Request request, Class<T> clazz) throws IOException
	{
		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unsuccessful http response: " + response.message());
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), clazz);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	private byte[] fetchImage(String url) throws IOException
	{
		HttpUrl httpUrl = HttpUrl.parse(url);

		Request request = new Request.Builder()
			.url(httpUrl)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unsuccessful http response: " + response.message());
			}

			return response.body().bytes();
		}
	}

	public void queueSearch(String search)
	{
		if (pendingLookups.size() < MAX_PENDING)
		{
			pendingLookups.add(new PendingLookup(search, PendingLookup.Type.SEARCH));
		}
		else
		{
			log.debug("Dropping pending search for {}", search);
		}
	}

	public void queueItem(int itemId)
	{
		if (pendingLookups.size() < MAX_PENDING)
		{
			pendingLookups.add(new PendingLookup(itemId, PendingLookup.Type.ITEM));
		}
		else
		{
			log.debug("Dropping pending item lookup for {}", itemId);
		}
	}

	@Scheduled(fixedDelay = 5000)
	public void check()
	{
		PendingLookup pendingLookup = pendingLookups.poll();
		if (pendingLookup == null)
		{
			return;
		}

		switch (pendingLookup.getType())
		{
			case SEARCH:
				try
				{
					RSSearch reSearch = fetchRSSearch(pendingLookup.getSearch());

					batchInsertItems(reSearch);
				}
				catch (IOException ex)
				{
					log.warn("error while searching items", ex);
				}
				break;
			case ITEM:
				fetchItem(pendingLookup.getItemId());
				break;
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

		if (getItem(id) == null)
		{
			// This is a new item..
			log.debug("Fetching new item {}", id);
			queueItem(id);
			return;
		}

		log.debug("Fetching price for {}", id);

		fetchPrice(id);
	}

	@Scheduled(fixedDelay = 1_8000_000) // 30 minutes
	public void reloadItems() throws IOException
	{
		List<ItemDefinition> items = cacheService.getItems();
		tradeableItems = items.stream()
			.filter(item -> item.isTradeable)
			.mapToInt(item -> item.id)
			.toArray();
		log.debug("Loaded {} tradeable items", tradeableItems.length);
	}

}
