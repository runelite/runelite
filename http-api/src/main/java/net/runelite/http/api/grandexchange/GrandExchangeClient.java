package net.runelite.http.api.grandexchange;

import com.google.gson.JsonParseException;
import java.io.IOException;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.worlds.WorldClient;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrandExchangeClient
{
	private static final Logger logger = LoggerFactory.getLogger(WorldClient.class);

	public GrandExchangeResult lookupItem(int itemId) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("grand-exchange")
			.addQueryParameter("itemId", String.valueOf(itemId))
			.build();

		logger.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response responseOk = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!responseOk.isSuccessful())
			{
				logger.debug("Error looking up item id: {}", responseOk.message());
				return null;
			}

			return RuneLiteAPI.GSON.fromJson(responseOk.body().string(), GrandExchangeResult.class);
		}
		catch (JsonParseException exception)
		{
			throw new IOException(exception);
		}
	}
}
