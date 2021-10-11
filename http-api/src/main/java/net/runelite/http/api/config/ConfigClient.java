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
package net.runelite.http.api.config;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@AllArgsConstructor
@Slf4j
public class ConfigClient
{
	private static final MediaType TEXT_PLAIN = MediaType.parse("text/plain");
	private static final Gson GSON = RuneLiteAPI.GSON;

	private final OkHttpClient client;
	private final UUID uuid;

	public Configuration get() throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("config")
			.build();

		log.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), Configuration.class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public CompletableFuture<Void> set(String key, String value)
	{
		CompletableFuture<Void> future = new CompletableFuture<>();

		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("config")
			.addPathSegment(key)
			.build();

		log.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.put(RequestBody.create(TEXT_PLAIN, value))
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.url(url)
			.build();

		client.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("Unable to synchronize configuration item", e);
				future.completeExceptionally(e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				response.close();
				log.debug("Synchronized configuration value '{}' to '{}'", key, value);
				future.complete(null);
			}
		});

		return future;
	}

	public CompletableFuture<Void> patch(Configuration configuration)
	{
		CompletableFuture<Void> future = new CompletableFuture<>();

		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("config")
			.build();

		log.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.patch(RequestBody.create(RuneLiteAPI.JSON, GSON.toJson(configuration)))
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.url(url)
			.build();

		client.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("Unable to synchronize configuration item", e);
				future.completeExceptionally(e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				if (response.code() != 200)
				{
					String body = "bad response";
					try
					{
						body = response.body().string();
					}
					catch (IOException ignored)
					{
					}

					log.warn("failed to synchronize some of {} configuration values: {}", configuration.getConfig().size(), body);
				}
				else
				{
					log.debug("Synchronized {} configuration values", configuration.getConfig().size());
				}
				response.close();
				future.complete(null);
			}
		});

		return future;
	}

	public CompletableFuture<Void> unset(String key)
	{
		CompletableFuture<Void> future = new CompletableFuture<>();

		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("config")
			.addPathSegment(key)
			.build();

		log.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.delete()
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.url(url)
			.build();

		client.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("Unable to unset configuration item", e);
				future.completeExceptionally(e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				response.close();
				log.debug("Unset configuration value '{}'", key);
				future.complete(null);
			}
		});

		return future;
	}
}
