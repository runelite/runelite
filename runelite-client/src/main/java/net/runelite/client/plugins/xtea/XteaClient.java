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
package net.runelite.client.plugins.xtea;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.http.api.RuneLiteAPI.JSON;
import net.runelite.http.api.xtea.XteaKey;
import net.runelite.http.api.xtea.XteaRequest;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
public class XteaClient
{
	private final OkHttpClient client;
	private final HttpUrl apiBase;
	private final Gson gson;

	@Inject
	private XteaClient(OkHttpClient client, @Named("runelite.api.base") HttpUrl apiBase, Gson gson)
	{
		this.client = client;
		this.apiBase = apiBase;
		this.gson = gson;
	}

	public void submit(XteaRequest xteaRequest)
	{
		HttpUrl url = apiBase.newBuilder()
			.addPathSegment("xtea")
			.build();

		log.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.post(RequestBody.create(JSON, gson.toJson(xteaRequest)))
			.url(url)
			.build();

		client.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("unable to submit xtea keys", e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				try (response)
				{
					if (!response.isSuccessful())
					{
						log.debug("unsuccessful xtea response");
					}
				}
			}
		});
	}

	public List<XteaKey> get() throws IOException
	{
		HttpUrl url = apiBase.newBuilder()
			.addPathSegment("xtea")
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			InputStream in = response.body().byteStream();
			// CHECKSTYLE:OFF
			return gson.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), new TypeToken<List<XteaKey>>() { }.getType());
			// CHECKSTYLE:ON
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public XteaKey get(int region) throws IOException
	{
		HttpUrl url = apiBase.newBuilder()
			.addPathSegment("xtea")
			.addPathSegment(Integer.toString(region))
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			InputStream in = response.body().byteStream();
			return gson.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), XteaKey.class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}
}
