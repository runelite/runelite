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

import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Set;
import lombok.AllArgsConstructor;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@AllArgsConstructor
public class ChatClient
{
	private final OkHttpClient client;

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

		try (Response response = client.newCall(request).execute())
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

		try (Response response = client.newCall(request).execute())
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

		try (Response response = client.newCall(request).execute())
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

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up quest points!");
			}
			return Integer.parseInt(response.body().string());
		}
	}

	public boolean submitTask(String username, String task, int amount, int initialAmount, String location) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("task")
			.addQueryParameter("name", username)
			.addQueryParameter("task", task)
			.addQueryParameter("amount", Integer.toString(amount))
			.addQueryParameter("initialAmount", Integer.toString(initialAmount))
			.addQueryParameter("location", location)
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public Task getTask(String username) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("task")
			.addQueryParameter("name", username)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up task!");
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), Task.class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public boolean submitPb(String username, String boss, double pb) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("pb")
			.addQueryParameter("name", username)
			.addQueryParameter("boss", boss)
			.addQueryParameter("pb", Double.toString(pb))
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public double getPb(String username, String boss) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("pb")
			.addQueryParameter("name", username)
			.addQueryParameter("boss", boss)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up personal best!");
			}
			return Double.parseDouble(response.body().string());
		}
	}

	public boolean submitGc(String username, int gc) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("gc")
			.addQueryParameter("name", username)
			.addQueryParameter("gc", Integer.toString(gc))
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public int getGc(String username) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("gc")
			.addQueryParameter("name", username)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up gamble count!");
			}
			return Integer.parseInt(response.body().string());
		}
	}

	public boolean submitDuels(String username, int wins, int losses, int winningStreak, int losingStreak) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("duels")
			.addQueryParameter("name", username)
			.addQueryParameter("wins", Integer.toString(wins))
			.addQueryParameter("losses", Integer.toString(losses))
			.addQueryParameter("winningStreak", Integer.toString(winningStreak))
			.addQueryParameter("losingStreak", Integer.toString(losingStreak))
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public Duels getDuels(String username) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("duels")
			.addQueryParameter("name", username)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up duels!");
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), Duels.class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public boolean submitLayout(String username, LayoutRoom[] rooms) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("layout")
			.addQueryParameter("name", username)
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(RuneLiteAPI.JSON, RuneLiteAPI.GSON.toJson(rooms)))
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public LayoutRoom[] getLayout(String username) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("layout")
			.addQueryParameter("name", username)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up layout!");
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), LayoutRoom[].class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public boolean submitPetList(String username, Collection<Integer> petList) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("pets")
			.addQueryParameter("name", username)
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(RuneLiteAPI.JSON, RuneLiteAPI.GSON.toJson(petList)))
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public Set<Integer> getPetList(String username) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("pets")
			.addQueryParameter("name", username)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = client.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up pet list!");
			}

			InputStream in = response.body().byteStream();
			// CHECKSTYLE:OFF
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8),
				new TypeToken<Set<Integer>>(){}.getType());
			// CHECKSTYLE:ON
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}
}
