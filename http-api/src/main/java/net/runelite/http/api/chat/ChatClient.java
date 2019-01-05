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
package net.runelite.http.api.chat;

import java.io.IOException;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatClient
{
	private static final Predicate<String> LAYOUT_VALIDATOR = Pattern
		.compile("\\[[A-Z]+]:(\\s*\\w+\\s*(\\([A-Za-z]+\\))?,?)+")
		.asPredicate();

	public boolean submitKc(String username, String boss, int kc) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("kc")
			.addQueryParameter("name", username)
			.addQueryParameter("boss", boss)
			.addQueryParameter("kc", Integer.toString(kc))
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public int getKc(String username, String boss) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("kc")
			.addQueryParameter("name", username)
			.addQueryParameter("boss", boss)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up killcount!");
			}
			return Integer.parseInt(response.body().string());
		}
	}

	public boolean submitQp(String username, int qp) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("qp")
			.addQueryParameter("name", username)
			.addQueryParameter("qp", Integer.toString(qp))
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public int getQp(String username) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("qp")
			.addQueryParameter("name", username)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up quest points!");
			}
			return Integer.parseInt(response.body().string());
		}
	}

	public boolean submitLayout(String username, String layout) throws IOException
	{
		if (!testLayout(layout))
		{
			throw new IOException("Layout " + layout + " is not valid!");
		}

		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("layout")
			.addQueryParameter("name", username)
			.addQueryParameter("layout", layout)
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public String getLayout(String username) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("layout")
			.addQueryParameter("name", username)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up layout!");
			}

			final String layout = response.body().string();

			if (!testLayout(layout))
			{
				throw new IOException("Layout " + layout + " is not valid!");
			}

			return layout;
		}
	}

	public boolean testLayout(String layout)
	{
		return LAYOUT_VALIDATOR.test(layout);
	}
}
