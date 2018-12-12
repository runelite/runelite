package net.runelite.http.api.loottracker;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.UUID;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class LootTrackerClient
{
	private static final MediaType JSON = MediaType.parse("application/json");
	private static final Gson GSON = RuneLiteAPI.GSON;

	private final UUID uuid;

	public void submit(LootRecord lootRecord)
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("loottracker")
			.build();

		Request request = new Request.Builder()
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.post(RequestBody.create(JSON, GSON.toJson(lootRecord)))
			.url(url)
			.build();

		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("unable to submit loot", e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				log.debug("Submitted loot");
			}
		});
	}
}
