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
package net.runelite.client.game;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.item.ItemPrice;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
public class ItemClient
{
	private final OkHttpClient client;
	private final HttpUrl apiBase, staticBase;
	private final Gson gson;

	@Inject
	private ItemClient(OkHttpClient client,
		@Named("runelite.api.base") HttpUrl apiBase,
		@Named("runelite.static.base") HttpUrl staticBase,
		Gson gson
	)
	{
		this.client = client;
		this.apiBase = apiBase;
		this.staticBase = staticBase;
		this.gson = gson;
	}

	public ItemPrice[] getPrices() throws IOException
	{
		HttpUrl.Builder urlBuilder = apiBase.newBuilder()
			.addPathSegment("item")
			.addPathSegment("prices.js");

		HttpUrl url = urlBuilder.build();

		log.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				log.warn("Error looking up prices: {}", response);
				return null;
			}

			InputStream in = response.body().byteStream();
			return gson.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), ItemPrice[].class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public Map<Integer, ItemStats> getStats() throws IOException
	{
		HttpUrl.Builder urlBuilder = staticBase.newBuilder()
			.addPathSegment("item")
			.addPathSegment("stats.ids.min.json");

		HttpUrl url = urlBuilder.build();

		log.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				log.warn("Error looking up item stats: {}", response);
				return null;
			}

			InputStream in = response.body().byteStream();
			final Type typeToken = new TypeToken<Map<Integer, ItemStats>>()
			{
			}.getType();
			return gson.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), typeToken);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}
}
