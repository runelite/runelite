/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.http.service.wiki;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
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
public class WikiPriceService
{
	private static final String CREATE = "CREATE TABLE IF NOT EXISTS `wiki_prices` (\n" +
		"  `item_id` int(11) NOT NULL,\n" +
		"  `high` int(11) NOT NULL,\n" +
		"  `highTime` int(11) NOT NULL,\n" +
		"  `low` int(11) NOT NULL,\n" +
		"  `lowTime` int(11) NOT NULL,\n" +
		"  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
		"  PRIMARY KEY (`item_id`)\n" +
		") ENGINE=InnoDB;";

	private final Sql2o sql2o;

	@Value("${runelite.wiki.url}")
	private String url;

	@Autowired
	public WikiPriceService(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;

		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE).executeUpdate();
		}
	}

	@Scheduled(initialDelay = 1000 * 5, fixedDelayString = "${runelite.wiki.poll.ms}")
	private void updateDatabase()
	{
		try
		{
			Map<Integer, ItemPrice> summary = getPrices();

			try (Connection con = sql2o.beginTransaction())
			{
				Query query = con.createQuery("INSERT INTO wiki_prices (item_id, high, highTime, low, lowTime)"
					+ "  VALUES (:itemId, :high, :highTime, :low, :lowTime)"
					+ " ON DUPLICATE KEY UPDATE high = VALUES(high), highTime = VALUES(highTime),"
					+ " low = VALUES(low), lowTime = VALUES(lowTime)");

				for (Map.Entry<Integer, ItemPrice> entry : summary.entrySet())
				{
					Integer itemId = entry.getKey();
					ItemPrice item = entry.getValue();

					query
						.addParameter("itemId", itemId)
						.addParameter("high", item.getHigh())
						.addParameter("highTime", item.getHighTime())
						.addParameter("low", item.getLow())
						.addParameter("lowTime", item.getLowTime())
						.addToBatch();
				}

				query.executeBatch();
				con.commit(false);
			}
		}
		catch (IOException e)
		{
			log.warn("Error while updating wiki prices", e);
		}
	}

	private Map<Integer, ItemPrice> getPrices() throws IOException
	{
		HttpUrl httpUrl = HttpUrl.parse(url);
		Request request = new Request.Builder()
			.url(httpUrl)
			.header("User-Agent", "RuneLite")
			.build();

		try (Response responseOk = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!responseOk.isSuccessful())
			{
				throw new IOException("Error retrieving prices: " + responseOk.message());
			}

			Type type = new TypeToken<Map<Integer, ItemPrice>>()
			{
			}.getType();

			return RuneLiteAPI.GSON.fromJson(responseOk.body().string(), type);
		}
		catch (JsonSyntaxException ex)
		{
			throw new IOException(ex);
		}
	}
}
