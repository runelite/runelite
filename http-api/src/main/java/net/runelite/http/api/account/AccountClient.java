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
package net.runelite.http.api.account;

import com.google.gson.JsonParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountClient
{
	private static final Logger logger = LoggerFactory.getLogger(AccountClient.class);

	private UUID uuid;

	public AccountClient()
	{
	}

	public AccountClient(UUID uuid)
	{
		this.uuid = uuid;
	}

	public OAuthResponse login() throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("account")
			.addPathSegment("login")
			.addQueryParameter("uuid", uuid.toString())
			.build();

		logger.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), OAuthResponse.class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public void logout() throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("account")
			.addPathSegment("logout")
			.build();

		logger.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			logger.debug("Sent logout request");
		}
	}

	public boolean sesssionCheck()
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("account")
			.addPathSegment("session-check")
			.build();

		logger.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			return response.isSuccessful();
		}
		catch (IOException ex)
		{
			logger.debug("Unable to verify session", ex);
			return true; // assume it is still valid if the server is unreachable
		}
	}
}
