/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.loottracker;

import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.account.AccountSession;
import net.runelite.client.account.SessionManager;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.loottracker.LootRecord;
import net.runelite.http.api.loottracker.LootRecordType;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
public class LootDatabaseClient
{
	private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	private UUID uuid;

	private final SessionManager sessionManager;

	// Requires Session UUID for verification
	public LootDatabaseClient(SessionManager sessionManager)
	{
		this.sessionManager = sessionManager;
		sessionChanged();
	}

	public void sessionChanged()
	{
		AccountSession s = sessionManager.getAccountSession();
		if (s == null)
		{
			this.uuid = null;
		}
		else
		{
			this.uuid = s.getUuid();
		}
		log.info("session changed, new UUID: {}", this.uuid);
	}

	/**
	 * Stores the Loot Record via a post request to the API and returns a success boolean
	 *
	 * @param record Loot Record to Store
	 * @param username in-game username as String
	 * @return Success Flag
	 */
	public boolean storeData(LootRecord record, String username)
	{
		if (uuid == null)
		{
			log.debug("Attempted to store data with null uuid, record: {}", record);
			return false;
		}

		HttpUrl.Builder builder = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("loottracker")
			.addQueryParameter("username", username);
		HttpUrl url = builder.build();
		log.debug("Built Database URI: {}", url);

		Request request = new Request.Builder()
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.url(url)
			.post(RequestBody.create(JSON, record.asJson()))
			.build();
		log.debug("JSON Data to store: " + record.asJson());
		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			log.debug("Response message: " + response.message());
			return response.message().equals("OK");
		}
		catch (IOException e)
		{
			log.debug("IOException: {}", e.getMessage());
			return false;
		}
		catch (JsonParseException e)
		{
			log.debug("JsonParseException: {}", e.getMessage());
			return false;
		}
	}

	/**
	 * Returns a List of LootRecords for this username
	 *
	 * @param ingameUsername in-game username as String
	 * @return List of LootRecords from RuneLite Database
	 */
	public Collection<LootTrackerData> getData(String ingameUsername)
	{
		if (uuid == null)
		{
			log.debug("Attempted to get data with null uuid");
			return null;
		}

		HttpUrl.Builder builder = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("loottracker")
			.addQueryParameter("username", ingameUsername);

		HttpUrl url = builder.build();
		log.debug("Built Database URI: {}", url);

		return makeGetRequest(url);
	}

	/**
	 * Returns a List of LootRecords for this username
	 *
	 * @param ingameUsername in-game username as String
	 * @param type LootRecordType
	 * @return List of LootRecords from RuneLite Database
	 */
	public Collection<LootTrackerData> getDataByType(String ingameUsername, LootRecordType type)
	{
		if (uuid == null)
		{
			log.debug("Attempted to get data with null uuid: {}", type);
			return null;
		}

		HttpUrl.Builder builder = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("loottracker")
			.addPathSegment("type")
			.addPathSegment(String.valueOf(type))
			.addQueryParameter("username", ingameUsername);

		HttpUrl url = builder.build();
		log.debug("Built Database URI: {}", url);

		return makeGetRequest(url);
	}

	/**
	 * Returns a List of LootRecords for this username
	 *
	 * @param ingameUsername in-game username as String
	 * @param eventId npcID, event name, or any other id
	 * @return List of LootRecords from RuneLite Database
	 */
	public Collection<LootTrackerData> getDataByEventId(String ingameUsername, String eventId)
	{
		if (uuid == null)
		{
			log.debug("Attempted to get data with null uuid: {}", eventId);
			return null;
		}

		HttpUrl.Builder builder = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("loottracker")
			.addPathSegment(eventId)
			.addQueryParameter("username", ingameUsername);

		HttpUrl url = builder.build();
		log.debug("Built Database URI: {}", url);

		return makeGetRequest(url);
	}

	private Collection<LootTrackerData> makeGetRequest(HttpUrl url)
	{
		Request request = new Request.Builder()
			.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (response.isSuccessful())
			{
				String result = response.body().string();
				Type listType = new TypeToken<Collection<LootRecord>>()
				{
				}.getType();
				Collection<LootRecord> records = RuneLiteAPI.GSON.fromJson(result, listType);
				return LootTrackerData.convertLootRecords(records);
			}
			else
			{
				log.debug("Error Executing Database URI request: {}", url);
				log.debug(response.body().toString());
				return null;
			}
		}
		catch (IOException e)
		{
			log.debug("IOException: {}", e.getMessage());
			return null;
		}
		catch (JsonParseException e)
		{
			log.debug("JsonParseException: {}", e.getMessage());
			return null;
		}
	}

	boolean isLoggedIn()
	{
		return this.uuid != null;
	}
}
