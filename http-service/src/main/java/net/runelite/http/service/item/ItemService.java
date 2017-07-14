/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
import com.google.gson.JsonParseException;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import net.runelite.http.api.RuneliteAPI;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.ItemType;
import net.runelite.http.api.item.SearchResult;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import spark.Request;
import spark.Response;

public class ItemService
{
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

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
		+ "  PRIMARY KEY (`id`)\n"
		+ ") ENGINE=InnoDB";

	private static final String CREATE_PRICES = "CREATE TABLE IF NOT EXISTS `prices` (\n"
		+ "  `item` int(11) NOT NULL,\n"
		+ "  `price` int(11) NOT NULL,\n"
		+ "  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n"
		+ "  KEY `item` (`item`)\n"
		+ ") ENGINE=InnoDB";

	private static final String CREATE_PRICES_FK = "ALTER TABLE `prices`\n"
		+ "  ADD CONSTRAINT `item` FOREIGN KEY (`item`) REFERENCES `items` (`id`);";

	private static final String CREATE_PRICES_IDX = "ALTER TABLE `prices`\n"
		+ "  ADD UNIQUE KEY `item` (`item`,`time`);";

	private static final String RUNELITE_CACHE = "Runelite-Cache";

	private final Sql2o sql2o;
	private final Cache<String, SearchResult> cachedSearches = CacheBuilder.newBuilder()
		.maximumSize(1024L)
		.build();

	@Inject
	public ItemService(@Named("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;
	}

	public void init()
	{
		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_ITEMS)
				.executeUpdate();

			con.createQuery(CREATE_PRICES)
				.executeUpdate();

			try
			{
				con.createQuery(CREATE_PRICES_FK)
					.executeUpdate();
			}
			catch (Sql2oException ex)
			{
				// Ignore, happens when index already exists
			}

			try
			{
				con.createQuery(CREATE_PRICES_IDX)
					.executeUpdate();
			}
			catch (Sql2oException ex)
			{
				// Ignore
			}
		}
	}

	public Item getItem(Request request, Response response)
	{
		int itemId = Integer.parseInt(request.params("id"));

		ItemEntry item = getItem(itemId);
		if (item != null)
		{
			response.type("application/json");
			response.header(RUNELITE_CACHE, "HIT");
			return item.toItem();
		}

		item = fetchItem(itemId);
		if (item != null)
		{
			response.type("application/json");
			response.header(RUNELITE_CACHE, "MISS");
			return item.toItem();
		}

		return null;
	}

	public byte[] getIcon(Request request, Response response)
	{
		int itemId = Integer.parseInt(request.params("id"));

		ItemEntry item = getItem(itemId);
		if (item != null && item.getIcon() != null)
		{
			response.type("image/gif");
			response.header(RUNELITE_CACHE, "HIT");
			return item.getIcon();
		}

		item = fetchItem(itemId);
		if (item != null)
		{
			response.type("image/gif");
			response.header(RUNELITE_CACHE, "MISS");
			return item.getIcon();
		}

		return null;
	}

	public byte[] getIconLarge(Request request, Response response)
	{
		int itemId = Integer.parseInt(request.params("id"));

		ItemEntry item = getItem(itemId);
		if (item != null && item.getIcon_large() != null)
		{
			response.type("image/gif");
			response.header(RUNELITE_CACHE, "HIT");
			return item.getIcon_large();
		}

		item = fetchItem(itemId);
		if (item != null)
		{
			response.type("image/gif");
			response.header(RUNELITE_CACHE, "MISS");
			return item.getIcon_large();
		}

		return null;
	}

	public ItemPrice getPrice(Request request, Response response)
	{
		int itemId = Integer.parseInt(request.params("id"));
		String ptime = request.params("time");
		Instant time = null;
		Instant now = Instant.now();
		boolean hit = true;

		if (ptime != null)
		{
			time = Instant.ofEpochMilli(Long.parseLong(ptime));

			if (time.isAfter(now))
			{
				time = now;
			}
		}

		ItemEntry item = getItem(itemId);
		if (item == null)
		{
			item = fetchItem(itemId);
			hit = false;

			if (item == null)
			{
				return null;
			}
		}

		PriceEntry priceEntry = getPrice(itemId, time);

		if (time != null)
		{
			if (priceEntry == null)
			{
				// we maybe can't backfill this
				return null;
			}
		}
		else
		{
			Instant yesterday = now.minus(1, ChronoUnit.DAYS);
			if (priceEntry == null || priceEntry.getTime().isBefore(yesterday))
			{
				List<PriceEntry> prices = fetchPrice(itemId);

				if (prices == null || prices.isEmpty())
				{
					return null;
				}

				priceEntry = prices.get(prices.size() - 1);
				hit = false;
			}
		}

		ItemPrice itemPrice = new ItemPrice();
		itemPrice.setItem(item.toItem());
		itemPrice.setPrice(priceEntry.getPrice());
		itemPrice.setTime(priceEntry.getTime());

		response.type("application/json");
		response.header(RUNELITE_CACHE, hit ? "HIT" : "MISS");
		return itemPrice;
	}

	public SearchResult search(Request request, Response response)
	{
		String query = request.queryParams("query");

		// rs api seems to require lowercase
		query = query.toLowerCase();

		SearchResult searchResult = cachedSearches.getIfPresent(query);
		if (searchResult != null)
		{
			response.type("application/json");
			response.header(RUNELITE_CACHE, "HIT");
			return searchResult;
		}

		try
		{
			RSSearch search = fetchRSSearch(query);

			searchResult = new SearchResult();
			List<Item> items = search.getItems().stream()
				.map(rsi -> rsi.toItem())
				.collect(Collectors.toList());
			searchResult.setItems(items);

			cachedSearches.put(query, searchResult);

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
				con.commit();
			}

			response.type("application/json");
			response.header(RUNELITE_CACHE, "MISS");
			return searchResult;
		}
		catch (IOException ex)
		{
			logger.warn("error while searching items", ex);
			return null;
		}
	}

	private ItemEntry getItem(int itemId)
	{
		try (Connection con = sql2o.open())
		{
			ItemEntry item = con.createQuery("select id, name, description, type, icon, icon_large from items where id = :id")
				.addParameter("id", itemId)
				.executeAndFetchFirst(ItemEntry.class);

			return item;
		}
	}

	private PriceEntry getPrice(int itemId, Instant time)
	{
		try (Connection con = sql2o.open())
		{
			if (time != null)
			{
				return con.createQuery("select price, time from prices where item = :item and time <= :time order by time desc limit 1")
					.addParameter("item", itemId)
					.addParameter("time", time.toString())
					.executeAndFetchFirst(PriceEntry.class);
			}
			else
			{
				return con.createQuery("select price, time from prices where item = :item order by time desc limit 1")
					.addParameter("item", itemId)
					.executeAndFetchFirst(PriceEntry.class);
			}
		}
	}

	private ItemEntry fetchItem(int itemId)
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
				logger.warn("error fetching image", ex);
			}

			try
			{
				iconLarge = fetchImage(rsItem.getIcon_large());
			}
			catch (IOException ex)
			{
				logger.warn("error fetching image", ex);
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
			logger.warn("unable to fetch item {}", itemId, ex);
			return null;
		}
	}

	private List<PriceEntry> fetchPrice(int itemId)
	{
		try (Connection con = sql2o.beginTransaction())
		{
			RSPrices rsprice = fetchRSPrices(itemId);
			List<PriceEntry> entries = new ArrayList<>();

			Query query = con.createQuery("insert ignore into prices (item, price, time) values (:item, :price, :time)");

			for (Entry<Long, Integer> entry : rsprice.getDaily().entrySet())
			{
				long ts = entry.getKey(); // ms since epoch
				int price = entry.getValue(); // gp

				Instant time = Instant.ofEpochMilli(ts);

				PriceEntry priceEntry = new PriceEntry();
				priceEntry.setItem(itemId);
				priceEntry.setPrice(price);
				priceEntry.setTime(time);
				entries.add(priceEntry);

				query
					.addParameter("item", itemId)
					.addParameter("price", price)
					.addParameter("time", time)
					.addToBatch();
			}

			query.executeBatch();
			con.commit();

			return entries;
		}
		catch (IOException ex)
		{
			logger.warn("unable to fetch price for item {}", itemId, ex);
			return null;
		}
	}

	private RSItem fetchRSItem(int itemId) throws IOException
	{
		HttpUrl itemUrl = RS_ITEM_URL
			.newBuilder()
			.addQueryParameter("item", "" + itemId)
			.build();

		okhttp3.Request request = new okhttp3.Request.Builder()
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

		okhttp3.Request request = new okhttp3.Request.Builder()
			.url(priceUrl)
			.build();

		return fetchJson(request, RSPrices.class);
	}

	private RSSearch fetchRSSearch(String query) throws IOException
	{
		HttpUrl searchUrl = RS_SEARCH_URL
			.newBuilder()
			.addQueryParameter("alpha", query)
			.build();

		okhttp3.Request request = new okhttp3.Request.Builder()
			.url(searchUrl)
			.build();

		return fetchJson(request, RSSearch.class);
	}

	private <T> T fetchJson(okhttp3.Request request, Class<T> clazz) throws IOException
	{
		okhttp3.Response response = RuneliteAPI.CLIENT.newCall(request).execute();

		if (!response.isSuccessful())
		{
			throw new IOException("Unsuccessful http response: " + response.message());
		}

		try (ResponseBody body = response.body())
		{
			InputStream in = body.byteStream();
			return RuneliteAPI.GSON.fromJson(new InputStreamReader(in), clazz);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	private byte[] fetchImage(String url) throws IOException
	{
		HttpUrl httpUrl = HttpUrl.parse(url);

		okhttp3.Request request = new okhttp3.Request.Builder()
			.url(httpUrl)
			.build();

		okhttp3.Response response = RuneliteAPI.CLIENT.newCall(request).execute();

		if (!response.isSuccessful())
		{
			throw new IOException("Unsuccessful http response: " + response.message());
		}

		try (ResponseBody body = response.body())
		{
			return body.bytes();
		}
	}
}
