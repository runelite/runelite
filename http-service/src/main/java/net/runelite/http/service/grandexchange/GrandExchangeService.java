package net.runelite.http.service.grandexchange;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.service.grandexchange.osbuddy.GuidePriceResponse;
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
	private static final String CREATE_GRAND_EXCHANGE_PRICES = "CREATE TABLE IF NOT EXISTS `ge_prices` (\n"
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
			con.createQuery("INSERT INTO ge_prices (item_id, overall, buying, buying_quantity, selling, "
				+ "selling_quantity, last_update) values (:itemId, :overall, :buying, :buyingQ, :selling, "
				+ ":sellingQ, :lastUpdate)")
				.addParameter("itemId", itemId)
				.addParameter("overall", guidePrice.getOverall())
				.addParameter("buying", guidePrice.getBuying())
				.addParameter("buyingQ", guidePrice.getBuyingQuantity())
				.addParameter("selling", guidePrice.getSelling())
				.addParameter("sellingQ", guidePrice.getSellingQuantity())
				.addParameter("lastUpdate", Timestamp.from(insertTime))
				.addColumnMapping("item_id", "itemId")
				.addColumnMapping("buying_quantity", "buyingQuantity")
				.addColumnMapping("selling_quantity", "sellingQuantity")
				.addColumnMapping("last_update", "lastUpdate")
				.executeUpdate();
		}

		return new GrandExchangeEntry(itemId, guidePrice, insertTime);
	}

	public GrandExchangeEntry update(int itemId, GuidePriceResponse guidePrice)
	{
		Instant updateTime = Instant.now();

		try (Connection con = sql2o.open())
		{
			con.createQuery("UPDATE ge_prices SET overall = :overall, buying = :buying, buying_quantity = :buyingQ, "
				+ "selling = :selling, selling_quantity = :sellingQ, last_update = :lastUpdate WHERE item_id = :itemId")
				.addParameter("itemId", itemId)
				.addParameter("overall", guidePrice.getOverall())
				.addParameter("buying", guidePrice.getBuying())
				.addParameter("buyingQ", guidePrice.getBuyingQuantity())
				.addParameter("selling", guidePrice.getSelling())
				.addParameter("sellingQ", guidePrice.getSellingQuantity())
				.addParameter("lastUpdate", Timestamp.from(updateTime))
				.addColumnMapping("item_id", "itemId")
				.addColumnMapping("buying_quantity", "buyingQuantity")
				.addColumnMapping("selling_quantity", "sellingQuantity")
				.addColumnMapping("last_update", "lastUpdate")
				.executeUpdate();
		}

		return new GrandExchangeEntry(itemId, guidePrice, updateTime);
	}

	public GrandExchangeEntry get(int itemId)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("SELECT item_id, overall, buying, buying_quantity, selling, selling_quantity, "
				+ "last_update FROM ge_prices WHERE ge_prices.item_id = :itemId")
				.addParameter("itemId", itemId)
				.addColumnMapping("item_id", "itemId")
				.addColumnMapping("buying_quantity", "buyingQuantity")
				.addColumnMapping("selling_quantity", "sellingQuantity")
				.addColumnMapping("last_update", "lastUpdate")
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
