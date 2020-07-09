/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.http.api.chat;

import java.io.IOException;
import net.runelite.http.api.RuneLiteApiClient;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatClient extends RuneLiteApiClient
{
	private final static String ENDPOINT = "chat";
	private final static RequestBody EMPTY_BODY = RequestBody.create(null, new byte[0]);

	public ChatClient(OkHttpClient client)
	{
		super(client.newBuilder(), ENDPOINT);
	}

	public boolean submitKc(String username, String boss, int kc) throws IOException
	{
		Response response = post_(EMPTY_BODY, url -> url.newBuilder()
			.addPathSegment("kc")
			.addQueryParameter("name", username)
			.addQueryParameter("boss", boss)
			.addQueryParameter("kc", Integer.toString(kc))
			.build()
		);

		response.close();
		return response.isSuccessful();
	}

	public int getKc(String username, String boss) throws IOException
	{
		Response response = get_(url -> url.newBuilder()
			.addPathSegment("kc")
			.addQueryParameter("name", username)
			.addQueryParameter("boss", boss)
			.build()
		);

		return Integer.parseInt(response.body().string());
	}

	public boolean submitQp(String username, int qp) throws IOException
	{
		Response response = post_(EMPTY_BODY, url -> url.newBuilder()
			.addPathSegment("qp")
			.addQueryParameter("name", username)
			.addQueryParameter("qp", Integer.toString(qp))
			.build()
		);

		response.close();
		return response.isSuccessful();
	}

	public int getQp(String username) throws IOException
	{
		Response response = get_(url -> url.newBuilder()
			.addPathSegment("qp")
			.addQueryParameter("name", username)
			.build()
		);

		return Integer.parseInt(response.body().string());
	}

	public boolean submitTask(String username, String task, int amount, int initialAmount, String location) throws IOException
	{
		Response response = post_(EMPTY_BODY, url -> url.newBuilder()
			.addPathSegment("task")
			.addQueryParameter("name", username)
			.addQueryParameter("task", task)
			.addQueryParameter("amount", Integer.toString(amount))
			.addQueryParameter("initialAmount", Integer.toString(initialAmount))
			.addQueryParameter("location", location)
			.build()
		);

		response.close();
		return response.isSuccessful();
	}

	public Task getTask(String username) throws IOException
	{
		Response response = get_(url -> url.newBuilder()
			.addPathSegment("task")
			.addQueryParameter("name", username)
			.build()
		);

		return bodyToObject(response, Task.class);
	}

	public boolean submitPb(String username, String boss, int pb) throws IOException
	{
		Response response = post_(EMPTY_BODY, url -> url.newBuilder()
			.addPathSegment("pb")
			.addQueryParameter("name", username)
			.addQueryParameter("boss", boss)
			.addQueryParameter("pb", Integer.toString(pb))
			.build()
		);

		response.close();
		return response.isSuccessful();
	}

	public int getPb(String username, String boss) throws IOException
	{
		Response response = get_(url -> url.newBuilder()
			.addPathSegment("pb")
			.addQueryParameter("name", username)
			.addQueryParameter("boss", boss)
			.build()
		);

		return Integer.parseInt(response.body().string());
	}

	public boolean submitGc(String username, int gc) throws IOException
	{
		Response response = post_(EMPTY_BODY, url -> url.newBuilder()
			.addPathSegment("gc")
			.addQueryParameter("name", username)
			.addQueryParameter("gc", Integer.toString(gc))
			.build()
		);

		response.close();
		return response.isSuccessful();
	}

	public int getGc(String username) throws IOException
	{
		Response response = get_(url -> url.newBuilder()
			.addPathSegment("gc")
			.addQueryParameter("name", username)
			.build()
		);

		return Integer.parseInt(response.body().string());
	}

	public boolean submitDuels(String username, int wins, int losses, int winningStreak, int losingStreak) throws IOException
	{
		Response response = post_(EMPTY_BODY, url -> url.newBuilder()
			.addPathSegment("duels")
			.addQueryParameter("name", username)
			.addQueryParameter("wins", Integer.toString(wins))
			.addQueryParameter("losses", Integer.toString(losses))
			.addQueryParameter("winningStreak", Integer.toString(winningStreak))
			.addQueryParameter("losingStreak", Integer.toString(losingStreak))
			.build()
		);

		response.close();
		return response.isSuccessful();
	}

	public Duels getDuels(String username) throws IOException
	{
		Response response = get_(url -> url.newBuilder()
			.addPathSegment("duels")
			.addQueryParameter("name", username)
			.build()
		);

		return bodyToObject(response, Duels.class);
	}

	public boolean submitLayout(String username, LayoutRoom[] rooms) throws IOException
	{
		RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, objectToJson(rooms));
		Response response = post_(body, url -> url.newBuilder()
			.addPathSegment("layout")
			.addQueryParameter("name", username)
			.build()
		);

		response.close();
		return response.isSuccessful();
	}

	public LayoutRoom[] getLayout(String username) throws IOException
	{
		Response response = get_(url -> url.newBuilder()
			.addPathSegment("layout")
			.addQueryParameter("name", username)
			.build()
		);

		return bodyToObject(response, LayoutRoom[].class);
	}
}
