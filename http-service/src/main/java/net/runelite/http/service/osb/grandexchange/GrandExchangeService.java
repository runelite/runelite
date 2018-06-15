/*
 * Copyright (c) 2018, AeonLucid <https://github.com/AeonLucid>
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
package net.runelite.http.service.osb.grandexchange;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.service.osb.grandexchange.osbuddy.GuidePriceResponse;
import net.runelite.http.service.util.exception.InternalServerErrorException;
import net.runelite.http.service.util.exception.NotFoundException;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Service
@Slf4j
public class GrandExchangeService
{
	private static final String CREATE_GRAND_EXCHANGE_PRICES = "CREATE TABLE IF NOT EXISTS `osb_ge` (\n"
		+ "  `item_id` int(11) NOT NULL,\n"
		+ "  `overall` int(11) NOT NULL,\n"
		+ "  `buying` int(11) NOT NULL,\n"
		+ "  `buying_quantity` int(11) NOT NULL,\n"
		+ "  `selling` int(11) NOT NULL,\n"
		+ "  `selling_quantity` int(11) NOT NULL,\n"
		+ "  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n"
		+ "  PRIMARY KEY (`item_id`)\n"
		+ ") ENGINE=InnoDB";

	private final Sql2o sql2o;

	@Autowired
	public GrandExchangeService(@Qualifier("Runelite SQL2O") Sql2o sql2o)
	{
		this.sql2o = sql2o;

		try (Connection con = sql2o.open())
		{
			con.createQuery(CREATE_GRAND_EXCHANGE_PRICES).executeUpdate();
		}
	}

	public GrandExchangeEntry insert(int itemId, GuidePriceResponse guidePrice)
	{
		Instant insertTime = Instant.now();

		try (Connection con = sql2o.open())
		{
			con.createQuery("INSERT INTO osb_ge (item_id, overall, buying, buying_quantity, selling, "
				+ "selling_quantity, last_update) values (:itemId, :overall, :buying, :buyingQ, :selling, "
				+ ":sellingQ, :lastUpdate)")
				.addParameter("itemId", itemId)
				.addParameter("overall", guidePrice.getOverall())
				.addParameter("buying", guidePrice.getBuying())
				.addParameter("buyingQ", guidePrice.getBuyingQuantity())
				.addParameter("selling", guidePrice.getSelling())
				.addParameter("sellingQ", guidePrice.getSellingQuantity())
				.addParameter("lastUpdate", Timestamp.from(insertTime))
				.executeUpdate();
		}

		return new GrandExchangeEntry(itemId, guidePrice, insertTime);
	}

	public GrandExchangeEntry update(int itemId, GuidePriceResponse guidePrice)
	{
		Instant updateTime = Instant.now();

		try (Connection con = sql2o.open())
		{
			con.createQuery("UPDATE osb_ge SET overall = :overall, buying = :buying, buying_quantity = :buyingQ, "
				+ "selling = :selling, selling_quantity = :sellingQ, last_update = :lastUpdate WHERE item_id = :itemId")
				.addParameter("itemId", itemId)
				.addParameter("overall", guidePrice.getOverall())
				.addParameter("buying", guidePrice.getBuying())
				.addParameter("buyingQ", guidePrice.getBuyingQuantity())
				.addParameter("selling", guidePrice.getSelling())
				.addParameter("sellingQ", guidePrice.getSellingQuantity())
				.addParameter("lastUpdate", Timestamp.from(updateTime))
				.executeUpdate();
		}

		return new GrandExchangeEntry(itemId, guidePrice, updateTime);
	}

	public GrandExchangeEntry get(int itemId)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("SELECT item_id, overall, buying, buying_quantity, selling, selling_quantity, "
				+ "last_update FROM osb_ge WHERE item_id = :itemId")
				.addParameter("itemId", itemId)
				.executeAndFetchFirst(GrandExchangeEntry.class);
		}
	}

	public GuidePriceResponse lookupItem(int itemId) throws IOException
	{
		HttpUrl httpUrl = new HttpUrl.Builder()
			.scheme("https")
			.host("api.rsbuddy.com")
			.addPathSegment("grandExchange")
			.addQueryParameter("a", "guidePrice")
			.addQueryParameter("i", String.valueOf(itemId))
			.build();

		Request request = new Request.Builder()
			.url(httpUrl)
			.build();

		try (Response responseOk = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!responseOk.isSuccessful())
			{
				switch (HttpStatus.valueOf(responseOk.code()))
				{
					case NOT_FOUND:
						throw new NotFoundException();
					default:
						throw new InternalServerErrorException("Error retrieving data from RsBuddy: " + responseOk.message());
				}
			}

			return RuneLiteAPI.GSON.fromJson(responseOk.body().string(), GuidePriceResponse.class);
		}
	}
}
