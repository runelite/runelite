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
package net.runelite.http.api.loottracker;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteApiClient;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
public class LootTrackerClient extends RuneLiteApiClient
{
	private final static String ENDPOINT = "loottracker";
	private static final Type typeToken;

	static
	{
		typeToken = new TypeToken<List<LootAggregate>>()
		{
		}.getType();
	}

	public LootTrackerClient(OkHttpClient client, UUID uuid)
	{
		super(client.newBuilder().addInterceptor(new LootTrackerClientInterceptor(uuid)), ENDPOINT);
	}

	public CompletableFuture<Void> submit(Collection<LootRecord> lootRecords)
	{
		return postAsync_(RequestBody.create(MEDIA_TYPE_JSON, objectToJson(lootRecords)))
			.thenCompose(response -> bodyToObjectFuture(response, Void.class));
	}

	public Collection<LootAggregate> get() throws IOException
	{
		return bodyToObject(get_(), typeToken);
	}

	public CompletableFuture<Void> delete(String eventId)
	{
		return deleteAsync_(url ->
		{
			if (eventId != null)
			{
				return url.newBuilder().addQueryParameter("eventId", eventId).build();
			}
			return url;
		}).thenCompose(response -> bodyToObjectFuture(response, Void.class));
	}

	@RequiredArgsConstructor
	private static class LootTrackerClientInterceptor implements Interceptor
	{
		private final UUID uuid;

		@Override
		public Response intercept(Chain chain) throws IOException
		{
			Request request = chain.request()
				.newBuilder()
				.header(AUTH_HEADER, uuid.toString())
				.build();

			return chain.proceed(request);
		}
	}
}