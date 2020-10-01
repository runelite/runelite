/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.http.api.loottracker;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import static net.runelite.http.api.RuneLiteAPI.JSON;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@RequiredArgsConstructor
public class LootTrackerClient
{
	private static final Gson GSON = RuneLiteAPI.GSON;

	private final OkHttpClient client;
	@Getter
	@Setter
	private UUID uuid;

	public CompletableFuture<Void> submit(Collection<LootRecord> lootRecords)
	{
		CompletableFuture<Void> future = new CompletableFuture<>();

		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("loottracker")
			.build();

		Request.Builder requestBuilder = new Request.Builder();
		if (uuid != null)
		{
			requestBuilder.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString());
		}
		requestBuilder.post(RequestBody.create(JSON, GSON.toJson(lootRecords)))
			.url(url)
			.build();

		client.newCall(requestBuilder.build()).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("unable to submit loot", e);
				future.completeExceptionally(e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				if (response.isSuccessful())
				{
					log.debug("Submitted loot");
				}
				else
				{
					log.warn("Error submitting loot: {} - {}", response.code(), response.message());
				}
				response.close();
				future.complete(null);
			}
		});

		return future;
	}

	public Collection<LootAggregate> get() throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("loottracker")
			.build();

		Request request = new Request.Builder()
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				log.debug("Error looking up loot: {}", response);
				return null;
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), new TypeToken<List<LootAggregate>>()
			{
			}.getType());
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public void delete(String eventId)
	{
		HttpUrl.Builder builder = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("loottracker");

		if (eventId != null)
		{
			builder.addQueryParameter("eventId", eventId);
		}

		Request request = new Request.Builder()
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.delete()
			.url(builder.build())
			.build();

		client.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("unable to delete loot", e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				log.debug("Deleted loot");
				response.close();
			}
		});
	}
}
