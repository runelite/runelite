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
package net.runelite.http.api.xtea;

import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XteaClient
{
	private static final MediaType JSON = MediaType.parse("application/json");

	private static final Logger logger = LoggerFactory.getLogger(XteaClient.class);

	public void submit(XteaRequest xteaRequest)
	{
		String json = RuneLiteAPI.GSON.toJson(xteaRequest);

		HttpUrl url = RuneLiteAPI.getOpenOSRSApiBase().newBuilder()
			.addPathSegment("xtea")
			.build();

		logger.debug("Built URI: {}", url);

		RequestBody body = RequestBody.Companion.create(json, JSON);
		Request request = new Request.Builder()
			.post(body)
			.url(url)
			.build();

		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				logger.warn("unable to submit xtea keys", e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				try
				{
					if (!response.isSuccessful())
					{
						logger.debug("unsuccessful xtea response");
					}
				}
				finally
				{
					response.close();
				}
			}
		});
	}

	public List<XteaKey> get() throws IOException
	{
		HttpUrl url = RuneLiteAPI.getOpenOSRSApiBase().newBuilder()
			.addPathSegment("xtea")
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			InputStream in = response.body().byteStream();
			// CHECKSTYLE:OFF
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), new TypeToken<List<XteaKey>>()
			{
			}.getType());
			// CHECKSTYLE:ON
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public XteaKey get(int region) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getOpenOSRSApiBase().newBuilder()
			.addPathSegment("xtea")
			.addPathSegment(Integer.toString(region))
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), XteaKey.class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}
}
