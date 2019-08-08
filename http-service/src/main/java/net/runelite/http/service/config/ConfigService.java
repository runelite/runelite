/*
 * Copyright (c) 2017-2019, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.config;

import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.UpdateOptions;
import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Updates.unset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.config.ConfigEntry;
import net.runelite.http.api.config.Configuration;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService
{
	private static final int MAX_DEPTH = 8;
	private static final int MAX_VALUE_LENGTH = 262144;

	private final Gson GSON = RuneLiteAPI.GSON;
	private final UpdateOptions upsertUpdateOptions = new UpdateOptions().upsert(true);

	private final MongoCollection<Document> mongoCollection;

	@Autowired
	public ConfigService(
		MongoClient mongoClient
	)
	{

		MongoDatabase database = mongoClient.getDatabase("config");
		MongoCollection<Document> collection = database.getCollection("config");
		this.mongoCollection = collection;

		// Create unique index on _userId
		IndexOptions indexOptions = new IndexOptions().unique(true);
		collection.createIndex(Indexes.ascending("_userId"), indexOptions);
	}

	private Document getConfig(int userId)
	{
		return mongoCollection.find(eq("_userId", userId)).first();
	}

	public Configuration get(int userId)
	{
		Map<String, Object> configMap = getConfig(userId);

		if (configMap == null || configMap.isEmpty())
		{
			return new Configuration(Collections.emptyList());
		}

		List<ConfigEntry> config = new ArrayList<>();

		for (String group : configMap.keySet())
		{
			// Reserved keys
			if (group.startsWith("_") || group.startsWith("$"))
			{
				continue;
			}

			Map<String, Object> groupMap = (Map) configMap.get(group);

			for (Map.Entry<String, Object> entry : groupMap.entrySet())
			{
				String key = entry.getKey();
				Object value = entry.getValue();

				if (value instanceof Map || value instanceof Collection)
				{
					value = GSON.toJson(entry.getValue());
				}
				else if (value == null)
				{
					continue;
				}

				ConfigEntry configEntry = new ConfigEntry();
				configEntry.setKey(group + "." + key.replace(':', '.'));
				configEntry.setValue(value.toString());
				config.add(configEntry);
			}
		}

		return new Configuration(config);
	}

	public boolean setKey(
		int userId,
		String key,
		@Nullable String value
	)
	{
		if (key.startsWith("$") || key.startsWith("_"))
		{
			return false;
		}

		String[] split = key.split("\\.", 2);
		if (split.length != 2)
		{
			return false;
		}

		if (!validateJson(value))
		{
			return false;
		}

		Object jsonValue = parseJsonString(value);
		mongoCollection.updateOne(eq("_userId", userId),
			set(split[0] + "." + split[1].replace('.', ':'), jsonValue),
			upsertUpdateOptions);
		return true;
	}

	public boolean unsetKey(
		int userId,
		String key
	)
	{
		if (key.startsWith("$") || key.startsWith("_"))
		{
			return false;
		}

		String[] split = key.split("\\.", 2);
		if (split.length != 2)
		{
			return false;
		}

		mongoCollection.updateOne(eq("_userId", userId),
			unset(split[0] + "." + split[1].replace('.', ':')));
		return true;
	}

	@VisibleForTesting
	static Object parseJsonString(String value)
	{
		Object jsonValue;
		try
		{
			jsonValue = RuneLiteAPI.GSON.fromJson(value, Object.class);

			if (jsonValue instanceof Double || jsonValue instanceof Float)
			{
				Number number = (Number) jsonValue;
				if (Math.floor(number.doubleValue()) == number.doubleValue() && !Double.isInfinite(number.doubleValue()))
				{
					// value is an int or long. 'number' might be truncated so parse it from 'value'
					try
					{
						jsonValue = Integer.parseInt(value);
					}
					catch (NumberFormatException ex)
					{
						try
						{
							jsonValue = Long.parseLong(value);
						}
						catch (NumberFormatException ex2)
						{

						}
					}
				}
			}
		}
		catch (JsonSyntaxException ex)
		{
			jsonValue = value;
		}
		return jsonValue;
	}

	@VisibleForTesting
	static boolean validateJson(String value)
	{
		try
		{
			// I couldn't figure out a better way to do this than a second json parse
			JsonElement jsonElement = RuneLiteAPI.GSON.fromJson(value, JsonElement.class);
			return validateObject(jsonElement, 1);
		}
		catch (JsonSyntaxException ex)
		{
			// the client submits the string representation of objects which is not always valid json,
			// eg. a value with a ':' in it. We just ignore it now. We can't json encode the values client
			// side due to them already being strings, which prevents gson from being able to convert them
			// to ints/floats/maps etc.
			return value.length() < MAX_VALUE_LENGTH;
		}
	}

	private static boolean validateObject(JsonElement jsonElement, int depth)
	{
		if (depth >= MAX_DEPTH)
		{
			return false;
		}

		if (jsonElement.isJsonObject())
		{
			JsonObject jsonObject = jsonElement.getAsJsonObject();

			for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet())
			{
				JsonElement element = entry.getValue();

				if (!validateObject(element, depth + 1))
				{
					return false;
				}
			}
		}
		else if (jsonElement.isJsonArray())
		{
			JsonArray jsonArray = jsonElement.getAsJsonArray();

			for (int i = 0; i < jsonArray.size(); ++i)
			{
				JsonElement element = jsonArray.get(i);

				if (!validateObject(element, depth + 1))
				{
					return false;
				}
			}
		}
		else if (jsonElement.isJsonPrimitive())
		{
			JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
			String value = jsonPrimitive.getAsString();
			if (value.length() >= MAX_VALUE_LENGTH)
			{
				return false;
			}
		}

		return true;
	}
}
