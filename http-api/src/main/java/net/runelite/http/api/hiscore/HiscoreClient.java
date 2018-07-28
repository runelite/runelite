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
package net.runelite.http.api.hiscore;

import com.google.gson.JsonParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiscoreClient
{
	private static final Logger logger = LoggerFactory.getLogger(HiscoreClient.class);

	public HiscoreResult lookup(String username, HiscoreEndpoint endpoint) throws IOException
	{
		HttpUrl.Builder builder = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("hiscore")
			.addPathSegment(endpoint.name().toLowerCase())
			.addQueryParameter("username", username);

		HttpUrl url = builder.build();

		logger.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				logger.debug("unsuccessful lookup for {}", username);
				return null;
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), HiscoreResult.class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public HiscoreResult lookup(String username) throws IOException
	{
		return lookup(username, HiscoreEndpoint.NORMAL);
	}

	public SingleHiscoreSkillResult lookup(String username, HiscoreSkill skill, HiscoreEndpoint endpoint) throws IOException
	{
		HttpUrl.Builder builder = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("hiscore")
			.addPathSegment(endpoint.name())
			.addPathSegment(skill.toString().toLowerCase())
			.addQueryParameter("username", username);

		HttpUrl url = builder.build();

		logger.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				logger.debug("unsuccessful lookup for {}", username);
				return null;
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), SingleHiscoreSkillResult.class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public SingleHiscoreSkillResult lookup(String username, HiscoreSkill skill) throws IOException
	{
		return lookup(username, skill, HiscoreEndpoint.NORMAL);
	}
}
