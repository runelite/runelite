/*
 * Copyright (c) 2018, TheStonedTurtle <http://github.com/TheStonedTurtle>
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
package net.runelite.http.api.database;

import com.google.gson.JsonParseException;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
public class DatabaseClient
{
	private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	private UUID uuid;

	// Requires Session UUID for verification
	public DatabaseClient(UUID uuid)
	{
		this.uuid = uuid;
		log.debug("Created Database Client with UUID: {}", this.uuid);
	}

	/**
	 * Calls the requested API URI and returns the requested data
	 * @param url HttpUrl to make a get request for
	 * @return List of LootRecords
	 */
	private List<LootRecord> makeGetRequest(HttpUrl url)
	{
		// Don't make a request if the user isn't logged in
		if (uuid == null)
		{
			log.debug("Attempted to get LootRecord data with null uuid, url: {}", url);
			return null;
		}

		Request request = new Request.Builder()
				.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
				.url(url)
				.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (response.isSuccessful())
			{
				String result = response.body().string();
				LootRecord[] records = RuneLiteAPI.GSON.fromJson(result, LootRecord[].class);
				return Arrays.asList(records);
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

	/**
	 * Wrapper for looking up LootRecords by eventId
	 *
	 * @param username in-game username as String
	 * @param id eventID to filter for
	 * @return List of requested LootRecords or null if an error querying database.
	 */
	public List<LootRecord> getLootRecordsByEventId(String username, int id)
	{
		DatabaseEndpoint endpoint = DatabaseEndpoint.LOOT_RECORDS_BY_ID;
		HttpUrl.Builder builder = endpoint.getDatabaseURL().newBuilder()
				.addQueryParameter("username", username)
				.addQueryParameter("id", String.valueOf(id));

		HttpUrl url = builder.build();
		log.debug("Built Database URI: {}", url);

		return makeGetRequest(url);
	}

	/**
	 * Wrapper for looking up LootRecords by eventType
	 *
	 * @param username in-game username as String
	 * @param type eventType to filter for
	 * @return List of requested LootRecords or null if an error querying database.
	 */
	public List<LootRecord> getLootRecordsByEventType(String username, String type)
	{
		DatabaseEndpoint endpoint = DatabaseEndpoint.LOOT_RECORDS_BY_TYPE;
		HttpUrl.Builder builder = endpoint.getDatabaseURL().newBuilder()
				.addQueryParameter("username", username)
				.addQueryParameter("id", type);

		HttpUrl url = builder.build();
		log.debug("Built Database URI: {}", url);

		return makeGetRequest(url);
	}

	/**
	 * Returns a List of LootRecords for this username filtered by eventType or eventId.
	 *
	 * @param username in-game username as String
	 * @param id eventType or eventId to search for
	 * @return List of LootRecords from RuneLite Database
	 */
	public List<LootRecord> getLootRecordsByEventIdOrType(String username, String id)
	{
		if (uuid == null)
		{
			return null;
		}

		DatabaseEndpoint endpoint = DatabaseEndpoint.LOOT_RECORDS_BY_EITHER;
		HttpUrl.Builder builder = endpoint.getDatabaseURL().newBuilder()
				.addQueryParameter("username", username)
				.addQueryParameter("id", id);

		HttpUrl url = builder.build();
		log.debug("Built Database URI: {}", url);

		return makeGetRequest(url);
	}

	/**
	 * Returns a List of LootRecords for this username
	 *
	 * @param username in-game username as String
	 * @return List of LootRecords from RuneLite Database
	 */
	public List<LootRecord> getLootRecords(String username)
	{
		if (uuid == null)
		{
			return null;
		}

		DatabaseEndpoint endpoint = DatabaseEndpoint.LOOT_RECORDS;
		HttpUrl.Builder builder = endpoint.getDatabaseURL().newBuilder()
				.addQueryParameter("username", username);

		HttpUrl url = builder.build();
		log.debug("Built Database URI: {}", url);

		return makeGetRequest(url);
	}

	/**
	 * Stores the Loot Record via a post request to the API and returns a success boolean
	 *
	 * @param record Loot Record to Store
	 * @param username in-game username as String
	 * @return Success Flag
	 */
	public boolean storeLootRecord(LootRecord record, String username)
	{
		if (uuid == null)
		{
			log.debug("Attempted to store LootRecord with null uuid, record: {}", record);
			return false;
		}

		DatabaseEndpoint bossEndpoint = DatabaseEndpoint.LOOT_RECORDS;
		HttpUrl.Builder builder = bossEndpoint.getDatabaseURL().newBuilder()
				.addQueryParameter("username", username);

		HttpUrl url = builder.build();

		log.debug("Built Database URI: {}", url);

		Request request = new Request.Builder()
				.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString())
				.url(url)
				.post(RequestBody.create(JSON, RuneLiteAPI.GSON.toJson(record)))
				.build();

		log.debug("JSON Data to store: " + RuneLiteAPI.GSON.toJson(record));

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
}
