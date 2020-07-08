/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, Ugnius <https://github.com/UgiR>
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
package net.runelite.http.api.item;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteApiClient;
import okhttp3.OkHttpClient;

@Slf4j
public class ItemClient extends RuneLiteApiClient
{
	private final static String ENDPOINT = "item/prices.js";

	private final ItemStaticApiClient staticClient;

	public ItemClient(OkHttpClient client)
	{
		super(client.newBuilder(), ENDPOINT);
		staticClient = new ItemStaticApiClient(client.newBuilder());
	}

	public ItemPrice[] getPrices() throws IOException
	{
		return bodyToObject(get_(), ItemPrice[].class);
	}

	public Map<Integer, ItemStats> getStats() throws IOException
	{
		return staticClient.getStats();
	}

	private static class ItemStaticApiClient extends RuneLiteApiClient
	{

		private static final String ENDPOINT = "item/stats.ids.min.json";
		private static final Type typeToken;

		static
		{
			typeToken = new TypeToken<Map<Integer, ItemStats>>()
			{
			}.getType();
		}

		public ItemStaticApiClient(OkHttpClient.Builder clientBuilder)
		{
			super(clientBuilder, STATIC_BASE_URL, ENDPOINT);
		}

		public Map<Integer, ItemStats> getStats() throws IOException
		{
			return bodyToObject(get_(), typeToken);
		}
	}
}
