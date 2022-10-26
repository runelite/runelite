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
package net.runelite.client.hiscore;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuntimeConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
@Singleton
public class HiscoreClient
{
	private static final Splitter NEWLINE_SPLITTER = Splitter.on(CharMatcher.anyOf("\r\n")).omitEmptyStrings();
	private static final Splitter COMMA_SPLITTER = Splitter.on(',').trimResults();

	private final OkHttpClient client;
	private final Map<HiscoreEndpoint, List<HiscoreSkill>> mappings;

	@Inject
	private HiscoreClient(OkHttpClient client, Gson gson, @Nullable RuntimeConfig runtimeConfig)
	{
		this.client = client;

		Map<String, List<String>> strMapping = loadDiskMappings(gson);

		if (runtimeConfig != null && runtimeConfig.getHiscoreMapping() != null)
		{
			strMapping.putAll(runtimeConfig.getHiscoreMapping());
		}

		mappings = convertMappings(strMapping, false);
	}

	@VisibleForTesting
	static Map<String, List<String>> loadDiskMappings(Gson gson)
	{
		try (InputStream is = HiscoreClient.class.getResourceAsStream("mappings.json"))
		{
			return gson.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8),
				new TypeToken<Map<String, List<String>>>()
				{
				}.getType());
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@VisibleForTesting
	static Map<HiscoreEndpoint, List<HiscoreSkill>> convertMappings(Map<String, List<String>> strMapping, boolean strict)
	{
		Map<String, List<HiscoreSkill>> entries = new HashMap<>();
		for (Map.Entry<String, List<String>> e : strMapping.entrySet())
		{
			entries.put(e.getKey(), Collections.unmodifiableList(e.getValue().stream()
				.map(name ->
				{
					try
					{
						return HiscoreSkill.valueOf(name);
					}
					catch (IllegalArgumentException ex)
					{
						log.warn("invalid skill {}", name, ex);
						if (strict)
						{
							throw ex;
						}
						return null;
					}
				}).collect(Collectors.toList())));
		}

		Map<HiscoreEndpoint, List<HiscoreSkill>> out = Arrays.stream(HiscoreEndpoint.values())
			.collect(ImmutableMap.toImmutableMap(
				Function.identity(),
				endpoint ->
				{
					List<HiscoreSkill> map = entries.remove(endpoint.name());
					if (map == null)
					{
						map = entries.get("default");
					}
					return map;
				}));

		entries.remove("default");
		if (strict && !entries.isEmpty())
		{
			log.warn("invalid endpoint {}", entries.keySet());
			throw new IllegalArgumentException("invalid entrypoints");
		}

		return out;
	}

	public HiscoreResult lookup(String username) throws IOException
	{
		return lookup(username, HiscoreEndpoint.NORMAL);
	}

	public HiscoreResult lookup(String username, HiscoreEndpoint endpoint) throws IOException
	{
		return lookup(username, endpoint, endpoint.getHiscoreURL());
	}

	@VisibleForTesting
	HiscoreResult lookup(String username, HiscoreEndpoint endpoint, HttpUrl url) throws IOException
	{
		try (Response response = client.newCall(buildRequest(username, url)).execute())
		{
			return processResponse(username, endpoint, response);
		}
	}

	public CompletableFuture<HiscoreResult> lookupAsync(String username, HiscoreEndpoint endpoint)
	{
		CompletableFuture<HiscoreResult> future = new CompletableFuture<>();

		client.newCall(buildRequest(username, endpoint.getHiscoreURL())).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				future.completeExceptionally(e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				try // NOPMD: UseTryWithResources
				{
					future.complete(processResponse(username, endpoint, response));
				}
				finally
				{
					response.close();
				}
			}
		});

		return future;
	}

	private static Request buildRequest(String username, HttpUrl hiscoreUrl)
	{
		HttpUrl url = hiscoreUrl.newBuilder()
			.addQueryParameter("player", username)
			.build();

		log.debug("Built URL {}", url);

		return new Request.Builder()
			.url(url)
			.build();
	}

	private HiscoreResult processResponse(String username, HiscoreEndpoint endpoint, Response response) throws IOException
	{
		if (!response.isSuccessful())
		{
			if (response.code() == 404)
			{
				return null;
			}

			throw new IOException("Error retrieving data from Jagex Hiscores: " + response);
		}

		String responseStr = response.body().string();

		ImmutableMap.Builder<HiscoreSkill, Skill> skills = ImmutableMap.builder();
		Iterator<HiscoreSkill> map = mappings.get(endpoint).iterator();
		for (String line : NEWLINE_SPLITTER.split(responseStr))
		{
			if (!map.hasNext())
			{
				log.warn("{} returned extra data", endpoint);
				break;
			}

			HiscoreSkill skill = map.next();
			if (skill == null)
			{
				continue;
			}

			List<String> record = COMMA_SPLITTER.splitToList(line);
			try
			{
				int rank = Integer.parseInt(record.get(0));
				int level = Integer.parseInt(record.get(1));
				long experience = -1;
				if (record.size() == 3)
				{
					experience = Long.parseLong(record.get(2));
				}

				skills.put(skill, new Skill(rank, level, experience));
			}
			catch (Exception e)
			{
				log.warn("invalid hiscore line \"{}\"", line, e);
			}
		}

		if (map.hasNext())
		{
			log.warn("{} returned less data than expected ({} expected next)", endpoint, map.next());
		}

		return new HiscoreResult(username, skills.build());
	}
}
