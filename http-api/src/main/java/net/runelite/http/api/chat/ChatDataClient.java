/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatDataClient
{
	public boolean submit(final String username, final String type, final String subtype, final String data) throws IOException
	{
		final HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addQueryParameter("name", username)
			.addQueryParameter("type", type)
			.addQueryParameter("subtype", subtype)
			.addQueryParameter("data", data)
			.build();

		final Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (final Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public String get(final String username, final String type, final String subtype) throws IOException
	{
		final HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addQueryParameter("name", username)
			.addQueryParameter("type", type)
			.addQueryParameter("subtype", subtype)
			.build();

		final Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up chat data!");
			}

			return response.body().string();
		}
	}
}
