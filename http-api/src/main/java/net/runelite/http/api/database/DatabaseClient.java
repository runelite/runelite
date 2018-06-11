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
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DatabaseClient
{
	private static final Logger logger = LoggerFactory.getLogger(DatabaseClient.class);

	private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	// Wrapper for looking up by boss ID (API can find records by name or id)
	public ArrayList<LootRecord> lookupBoss(String username, int id) throws IOException
	{
		return lookupBoss(username, String.valueOf(id));
	}

	// Returns all LootRecords by
	public ArrayList<LootRecord> lookupBoss(String username, String boss) throws IOException
	{
		DatabaseEndpoint bossEndpoint = DatabaseEndpoint.BOSS;
		HttpUrl.Builder builder = bossEndpoint.getDatabaseURL().newBuilder()
				.addQueryParameter("username", username)
				.addQueryParameter("boss", boss);

		HttpUrl url = builder.build();

		logger.debug("Built Database URI: {}", url);

		Request request = new Request.Builder()
				.url(url)
				.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (response.isSuccessful())
			{
				String result = response.body().string();
				LootRecord[] records = RuneLiteAPI.GSON.fromJson(result, LootRecord[].class);
				return unpackLootRecords(records);
			}
			else
			{
				logger.debug("Error Executing Database URI request: {}", url);
				logger.debug(response.body().toString());
				return new ArrayList<LootRecord>();
			}
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}

	// Converts LootRecord[] to ArrayList format
	public static ArrayList<LootRecord> unpackLootRecords(LootRecord[] r)
	{
		ArrayList<LootRecord> result = new ArrayList<LootRecord>();
		Collections.addAll(result, r);
		return result;
	}

	// Stores the Loot Record via a post request to the API and returns a success boolean
	public boolean storeLootRecord(LootRecord record, String username) throws IOException
	{
		DatabaseEndpoint bossEndpoint = DatabaseEndpoint.BOSS;
		HttpUrl.Builder builder = bossEndpoint.getDatabaseURL().newBuilder()
				.addQueryParameter("username", username);

		HttpUrl url = builder.build();

		logger.debug("Built Database URI: {}", url);

		Request request = new Request.Builder()
				.url(url)
				.post(RequestBody.create(JSON, RuneLiteAPI.GSON.toJson(record)))
				.build();

		logger.debug("JSON Data to store: " + request.body().toString());

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			logger.debug("Data Storage: " + (response.message().equals("OK") ? "SUCCESS" : "FAIL"));
			return response.message().equals("OK");
		}
		catch (JsonParseException ex)
		{
			throw new IOException(ex);
		}
	}
}
