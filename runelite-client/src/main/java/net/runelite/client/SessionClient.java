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
package net.runelite.client;

import com.google.gson.JsonParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

class SessionClient
{
	private final ClientSessionManager manager;

	SessionClient(ClientSessionManager manager)
	{
		this.manager = manager;
	}

	void open()
	{
		HttpUrl url = RuneLiteAPI.getopenosrsSessionBase().newBuilder()
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(@NotNull Call call, @NotNull IOException e)
			{
				manager.error(e);
			}

			@Override
			public void onResponse(@NotNull Call call, @NotNull Response response)
			{
				try
				{
					ResponseBody body = response.body();

					InputStream in = body.byteStream();

					manager.setUuid(RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), UUID.class));
				}
				catch (JsonParseException | IllegalArgumentException ex) // UUID.fromString can throw IllegalArgumentException
				{
					manager.error(new IOException(ex));
				}
			}
		});
	}

	void ping(UUID uuid)
	{
		HttpUrl url = RuneLiteAPI.getopenosrsSessionBase().newBuilder()
			.addPathSegment("ping")
			.addQueryParameter("session", uuid.toString())
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(@NotNull Call call, @NotNull IOException e)
			{
				manager.error(e);
			}

			@Override
			public void onResponse(@NotNull Call call, @NotNull Response response)
			{
				if (!response.isSuccessful())
				{
					manager.error(new IOException("Failed ping"));
				}
			}
		});
	}

	void delete(UUID uuid) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getopenosrsSessionBase().newBuilder()
			.addQueryParameter("session", uuid.toString())
			.build();

		Request request = new Request.Builder()
			.delete()
			.url(url)
			.build();

		RuneLiteAPI.CLIENT.newCall(request).execute().close();
	}
}
