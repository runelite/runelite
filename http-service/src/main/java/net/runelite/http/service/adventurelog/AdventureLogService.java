/*
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
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
package net.runelite.http.service.adventurelog;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import static com.mongodb.client.model.Sorts.descending;
import com.mongodb.lang.Nullable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.runelite.http.api.RuneLiteAPI;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdventureLogService
{
	// amount of events per document, this does not guarantee this size but it will be around this
	private static final int BATCH_SIZE = 100;

	// amount of days before deleting a document after it has last been updated
	private static final int DOCUMENT_LIFESPAN = 90;

	private static final int MAX_DEPTH = 8;
	private static final int MAX_VALUE_LENGTH = 256;

	private final MongoCollection<Document> mongoCollection;

	@Autowired
	public AdventureLogService(
		MongoClient mongoClient,
		@Value("${mongo.database}") String databaseName
	)
	{
		MongoDatabase database = mongoClient.getDatabase(databaseName);
		MongoCollection<Document> collection = database.getCollection("adventurelog");
		collection.createIndex(Indexes.descending("expireAt"), new IndexOptions().expireAfter(0L, TimeUnit.SECONDS));
		this.mongoCollection = collection;
	}

	public List<Object> getLogs(int userId, String username)
	{
		List<Object> events = new ArrayList<>();
		MongoCursor<Document> cursor =  mongoCollection
			.find(and(eq("_userId", userId), eq("username", username)))
			.sort(descending("lastModTime")).iterator();

		while (cursor.hasNext())
		{
			Document document = cursor.next();
			List<Object> documentEvents = (List<Object>) document.get("events");
			events.addAll(documentEvents);
		}

		return events;
	}

	public boolean addLog(
		int userId,
		String username,
		@Nullable List<Object> values)
	{
		if (!validateJson(values))
		{
			return false;
		}

		MongoCursor<Document> cursor =  mongoCollection
			.find(and(eq("_userId", userId), eq("username", username)))
			.sort(descending("lastModTime")).limit(1).iterator();

		long time = System.currentTimeMillis() / 1000;
		
		for (Object object : values)
		{
			((LinkedTreeMap<String, Object>) object).put("time", time);
		}

		values = Lists.reverse(values);

		if (cursor.hasNext())
		{
			Document document = cursor.next();
			List<Object> events = (List<Object>) document.get("events");
			int batchSize = events.size();

			if (batchSize < BATCH_SIZE)
			{
				batchSize += values.size();
				values = Lists.newArrayList(Iterables.concat(values, events));
				document.put("lastModTime", time);
				document.put("batchSize", batchSize);
				document.put("expireAt", Date.from(Instant.now().plus(DOCUMENT_LIFESPAN, ChronoUnit.DAYS)));
				document.put("events", values);
				mongoCollection.replaceOne(eq("_id", document.get("_id")), document);
				return true;
			}
		}

		Document document = new Document();
		document.put("_userId", userId);
		document.put("lastModTime", time);
		document.put("batchSize", values.size());
		document.put("username", username);
		document.put("expireAt", Date.from(Instant.now().plus(DOCUMENT_LIFESPAN, ChronoUnit.DAYS)));
		document.put("events", values);
		mongoCollection.insertOne(document);
		return true;

	}

	@VisibleForTesting
	static boolean validateJson(Object value)
	{
		try
		{
			// I couldn't figure out a better way to do this than a second json parse
			JsonElement jsonElement = RuneLiteAPI.GSON.toJsonTree(value);
			return validateObject(jsonElement, 1);
		}
		catch (JsonSyntaxException ex)
		{
			// Should never happen because the json is generated by gson and there is no user inputted strings
			return false;
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

	private void changeExpireTime(int days)
	{
		MongoCursor<Document> cursor =  mongoCollection.find().iterator();

		while (cursor.hasNext())
		{
			Document document = cursor.next();
			long lastModTime = document.getLong("lastModTime");
			Date newExpireDate = Date.from(Instant.ofEpochSecond(lastModTime).plus(days, ChronoUnit.DAYS));
			document.put("expireAt", newExpireDate);
		}
	}
}
