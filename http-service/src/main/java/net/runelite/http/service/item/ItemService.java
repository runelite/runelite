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

import com.google.gson.JsonParseException;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.runelite.http.api.RuneliteAPI;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemType;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.Request;
import spark.Response;

public class ItemService
{
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

	private static final HttpUrl RS_ITEM_URL = HttpUrl.parse("http://services.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json");

	private static final String CREATE_ITEMS = "CREATE TABLE IF NOT EXISTS `items` (\n"
		+ "  `id` int(11) NOT NULL,\n"
		+ "  `name` tinytext NOT NULL,\n"
		+ "  `description` tinytext NOT NULL,\n"
		+ "  `type` enum('DEFAULT') NOT NULL,\n"
		+ "  `icon` blob NOT NULL,\n"
		+ "  `icon_large` blob NOT NULL,\n"
		+ "  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
		+ "  PRIMARY KEY (`id`)\n"
		+ ") ENGINE=InnoDB";

	private static final String RUNELITE_ITEM_CACHE = "Runelite-Item-Cache";

	private final Sql2o sql2o;

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
		}
	}

	public Item getItem(Request request, Response response)
	{
		int itemId = Integer.parseInt(request.params("id"));

		ItemEntry item = get(itemId);
		if (item != null)
		{
			response.type("application/json");
			response.header(RUNELITE_ITEM_CACHE, "HIT");
			return item.toItem();
		}

		item = fetch(itemId);
		if (item != null)
		{
			response.type("application/json");
			response.header(RUNELITE_ITEM_CACHE, "MISS");
			return item.toItem();
		}

		return null;
	}

	public byte[] getIcon(Request request, Response response)
	{
		int itemId = Integer.parseInt(request.params("id"));

		ItemEntry item = get(itemId);
		if (item != null)
		{
			response.type("image/gif");
			response.header(RUNELITE_ITEM_CACHE, "HIT");
			return item.getIcon();
		}

		item = fetch(itemId);
		if (item != null)
		{
			response.type("image/gif");
			response.header(RUNELITE_ITEM_CACHE, "MISS");
			return item.getIcon();
		}

		return null;
	}

	public byte[] getIconLarge(Request request, Response response)
	{
		int itemId = Integer.parseInt(request.params("id"));

		ItemEntry item = get(itemId);
		if (item != null)
		{
			response.type("image/gif");
			response.header(RUNELITE_ITEM_CACHE, "HIT");
			return item.getIcon_large();
		}

		item = fetch(itemId);
		if (item != null)
		{
			response.type("image/gif");
			response.header(RUNELITE_ITEM_CACHE, "MISS");
			return item.getIcon_large();
		}

		return null;
	}

	private ItemEntry get(int itemId)
	{
		try (Connection con = sql2o.open())
		{
			ItemEntry item = con.createQuery("select id, name, description, type, icon, icon_large from items where id = :id")
				.addParameter("id", itemId)
				.executeAndFetchFirst(ItemEntry.class);

			return item;
		}
	}

	private ItemEntry fetch(int itemId)
	{
		try
		{
			RSItem rsItem = fetchItem(itemId);
			byte[] icon = fetchImage(rsItem.getIcon());
			byte[] iconLarge = fetchImage(rsItem.getIcon_large());

			try (Connection con = sql2o.open())
			{
				con.createQuery("insert into items (id, name, description, type, icon, icon_large) values (:id,"
					+ " :name, :description, :type, :icon, :icon_large)")
					.addParameter("id", itemId)
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

			try
			{
				item.setType(ItemType.valueOf(rsItem.getType().toUpperCase()));
			}
			catch (IllegalArgumentException ex)
			{
				logger.warn(null, ex);
			}

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

	private RSItem fetchItem(int itemId) throws IOException
	{
		HttpUrl itemUrl = RS_ITEM_URL
			.newBuilder()
			.addQueryParameter("item", "" + itemId)
			.build();

		okhttp3.Request request = new okhttp3.Request.Builder()
			.url(itemUrl)
			.build();

		okhttp3.Response response = RuneliteAPI.CLIENT.newCall(request).execute();

		try (ResponseBody body = response.body())
		{
			InputStream in = body.byteStream();
			RSItemResponse itemResponse = RuneliteAPI.GSON.fromJson(new InputStreamReader(in), RSItemResponse.class);
			return itemResponse.getItem();
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

		try (ResponseBody body = response.body())
		{
			return body.bytes();
		}
	}
}
