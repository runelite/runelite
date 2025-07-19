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

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

class SessionClient
{
	private final OkHttpClient client;
	private final HttpUrl sessionUrl;
	private final Gson gson;

	@Inject
	private SessionClient(OkHttpClient client, @Named("runelite.session") HttpUrl sessionUrl, Gson gson)
	{
		this.client = client;
		this.sessionUrl = sessionUrl;
		this.gson = gson;
	}

	UUID open() throws IOException
	{
		HttpUrl url = sessionUrl.newBuilder()
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			ResponseBody body = response.body();

			InputStream in = body.byteStream();
			return gson.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), UUID.class);
		}
		catch (JsonParseException | IllegalArgumentException ex) // UUID.fromString can throw IllegalArgumentException
		{
			throw new IOException(ex);
		}
	}

	void ping(UUID uuid, boolean loggedIn) throws IOException
	{
		HttpUrl url = sessionUrl.newBuilder()
			.addPathSegment("ping")
			.addQueryParameter("session", uuid.toString())
			.addQueryParameter("logged-in", String.valueOf(loggedIn))
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unsuccessful ping");
			}
		}
	}

	void delete(UUID uuid) throws IOException
	{
		HttpUrl url = sessionUrl.newBuilder()
			.addQueryParameter("session", uuid.toString())
			.build();

		Request request = new Request.Builder()
			.delete()
			.url(url)
			.build();

		client.newCall(request).execute().close();
	}
}
