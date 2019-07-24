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
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.io.InputStreamReader;
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

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
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

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up task!");
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), Task.class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public boolean submitPb(String username, String boss, int pb) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("pb")
			.addQueryParameter("name", username)
			.addQueryParameter("boss", boss)
			.addQueryParameter("pb", Integer.toString(pb))
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

	public int getPb(String username, String boss) throws IOException
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

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up personal best!");
			}
			return Integer.parseInt(response.body().string());
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

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
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

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up gamble count!");
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

		HttpUrl url = RuneLiteAPI.getPlusApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("layout")
			.addQueryParameter("name", username)
			.addQueryParameter("layout", layout)
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.RLP_CLIENT.newCall(request).execute())
		{
			return response.isSuccessful();
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

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public String getLayout(String username) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getPlusApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("layout")
			.addQueryParameter("name", username)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.RLP_CLIENT.newCall(request).execute())
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

	public House[] getHosts(int world, String location) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getPlusApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("hosts")
			.addQueryParameter("world", Integer.toString(world))
			.addQueryParameter("location", location)
			.build();

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.RLP_CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up hosts!");
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), House[].class);

		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
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

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Unable to look up duels!");
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), Duels.class);
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	public boolean submitHost(int world, String location, House house) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getPlusApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("hosts")
			.addQueryParameter("world", Integer.toString(world))
			.addQueryParameter("location", location)
			.addQueryParameter("owner", house.getOwner())
			.addQueryParameter("guildedAltar", Boolean.toString(house.isGuildedAltarPresent()))
			.addQueryParameter("occultAltar", Boolean.toString(house.isOccultAltarPresent()))
			.addQueryParameter("spiritTree", Boolean.toString(house.isSpiritTreePresent()))
			.addQueryParameter("fairyRing", Boolean.toString(house.isFairyRingPresent()))
			.addQueryParameter("wildernessObelisk", Boolean.toString(house.isWildernessObeliskPresent()))
			.addQueryParameter("repairStand", Boolean.toString(house.isRepairStandPresent()))
			.addQueryParameter("combatDummy", Boolean.toString(house.isCombatDummyPresent()))
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.RLP_CLIENT.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}

	public boolean removeHost(int world, String location, House house) throws IOException
	{
		HttpUrl url = RuneLiteAPI.getPlusApiBase().newBuilder()
			.addPathSegment("chat")
			.addPathSegment("hosts")
			.addQueryParameter("world", Integer.toString(world))
			.addQueryParameter("location", location)
			.addQueryParameter("owner", house.getOwner())
			.addQueryParameter("guildedAltar", Boolean.toString(house.isGuildedAltarPresent()))
			.addQueryParameter("occultAltar", Boolean.toString(house.isOccultAltarPresent()))
			.addQueryParameter("spiritTree", Boolean.toString(house.isSpiritTreePresent()))
			.addQueryParameter("fairyRing", Boolean.toString(house.isFairyRingPresent()))
			.addQueryParameter("wildernessObelisk", Boolean.toString(house.isWildernessObeliskPresent()))
			.addQueryParameter("repairStand", Boolean.toString(house.isRepairStandPresent()))
			.addQueryParameter("combatDummy", Boolean.toString(house.isCombatDummyPresent()))
			.addQueryParameter("remove", Boolean.toString(true))
			.build();

		Request request = new Request.Builder()
			.post(RequestBody.create(null, new byte[0]))
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.RLP_CLIENT.newCall(request).execute())
		{
			return response.isSuccessful();
		}
	}
}