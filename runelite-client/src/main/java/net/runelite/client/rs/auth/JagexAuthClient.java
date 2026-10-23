/*
 * Copyright (c) 2021 Abex
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
package net.runelite.client.rs.auth;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@Singleton
public class JagexAuthClient
{
	private final OkHttpClient client;
	private final Gson gson;

	@Inject
	public JagexAuthClient(OkHttpClient client, Gson gson)
	{
		this.client = client;
		this.gson = gson;
	}

	public String getSessionId(String idToken) throws IOException
	{
		Map<String, String> bodym = new HashMap<>();
		bodym.put("idToken", idToken);

		try (Response res = client.newCall(new Request.Builder()
				.url("https://auth.jagex.com/game-session/v1/sessions")
				.post(RequestBody.create(MediaType.get("application/json"), gson.toJson(bodym)))
				.build())
			.execute())
		{
			if (!res.isSuccessful())
			{
				throw new IOException("unable to get session: " + res.message());
			}
			InputStream in = res.body().byteStream();
			Map resm = gson.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), Map.class);
			return (String) resm.get("sessionId");
		}
	}

	public Account[] getAccounts(String sessionId) throws IOException
	{
		try (Response res = client.newCall(new Request.Builder()
				.url("https://auth.jagex.com/game-session/v1/accounts")
				.header("Authorization", "Bearer " + sessionId)
				.header("Accept", "application/json")
				.get()
				.build())
			.execute())
		{
			if (!res.isSuccessful())
			{
				throw new IOException("unable to get accounts: " + res.message());
			}
			InputStream in = res.body().byteStream();
			return gson.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), Account[].class);
		}
	}
}