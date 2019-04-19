package net.runelite.client.plugins.clanchat.discord;

import com.google.gson.Gson;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
public class DiscordClient
{
	private static final MediaType JSON = MediaType.parse("application/json");
	private static final Gson GSON = RuneLiteAPI.GSON;
	private int rateLimit = 1;
	private Instant rateReset = Instant.EPOCH;

	public void submit(DiscordMessage message, String path)
	{
		if (rateLimit < 1 && Instant.now().isBefore(rateReset))
		{
			return;
		}

		final HttpUrl url = new HttpUrl.Builder()
			.scheme("https")
			.host("discordapp.com")
			.addPathSegments("api/webhooks")
			.addPathSegments(path)
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(JSON, GSON.toJson(message)))
			.url(url)
			.build();

		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.debug("discord message failed", e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				rateLimit = parseInt(response.header("X-RateLimit-Remaining"));
				rateReset = Instant.ofEpochSecond((parseInt(response.header("X-RateLimit-Reset"))));
				log.debug("Submitted discord message, limit: {}, reset: {}", rateLimit, rateReset);
				response.close();
			}
		});
	}
}

