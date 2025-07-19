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

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
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
	private final OkHttpClient client;
	private final Gson gson;

	@Inject
	private HiscoreClient(OkHttpClient client, Gson gson)
	{
		this.client = client;
		this.gson = gson;
	}

	public HiscoreResult lookup(String username) throws IOException
	{
		return lookup(username, HiscoreEndpoint.NORMAL);
	}

	public HiscoreResult lookup(String username, HiscoreEndpoint endpoint) throws IOException
	{
		return lookup(username, endpoint.getHiscoreURL());
	}

	private HiscoreResult lookup(String username, HttpUrl url) throws IOException
	{
		try (Response response = client.newCall(buildRequest(username, url)).execute())
		{
			return processResponse(username, response);
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
				try (response)
				{
					future.complete(processResponse(username, response));
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

	private HiscoreResult processResponse(String username, Response response) throws IOException
	{
		if (!response.isSuccessful())
		{
			if (response.code() == 404)
			{
				return null;
			}

			throw new IOException("Error retrieving data from hiscores: " + response);
		}

		HiscoreResponse hiscoreResponse;
		try
		{
			hiscoreResponse = gson.fromJson(response.body().charStream(), HiscoreResponse.class);
		}
		catch (JsonSyntaxException ex)
		{
			throw new IOException("Error deserializing hiscore response", ex);
		}

		if (hiscoreResponse == null)
		{
			throw new IOException("Error retrieving data from hiscores: " + response);
		}

		Map<String, HiscoreSkill> skillMap = Arrays.stream(HiscoreSkill.values())
			.collect(Collectors.toMap(HiscoreSkill::getName, Function.identity()));

		ImmutableMap.Builder<HiscoreSkill, Skill> skills = ImmutableMap.builder();
		for (HiscoreResponse.Skill skill : hiscoreResponse.skills)
		{
			HiscoreSkill s = skillMap.get(skill.name);
			if (s == null)
			{
				log.debug("unknown skill in hiscore: {}", skill.name);
				continue;
			}

			skills.put(s, new Skill(skill.rank, skill.level, skill.xp));
		}
		for (HiscoreResponse.Activity activity : hiscoreResponse.activities)
		{
			HiscoreSkill s = skillMap.get(activity.name);
			if (s == null)
			{
				log.debug("unknown activity in hiscore: {}", activity.name);
				continue;
			}

			skills.put(s, new Skill(activity.rank, (int) activity.score, -1L));
		}

		return new HiscoreResult(username, skills.build());
	}
}
