/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.http.api.ge;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.Setter;
import net.runelite.http.api.RuneLiteApiClient;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GrandExchangeClient extends RuneLiteApiClient
{
	private final static String ENDPOINT = "ge";
	private final GrandExchangeClientInterceptor interceptor;

	public GrandExchangeClient(OkHttpClient client)
	{
		this(client, new GrandExchangeClientInterceptor());
	}

	private GrandExchangeClient(OkHttpClient client, GrandExchangeClientInterceptor interceptor)
	{
		super(client.newBuilder().addInterceptor(interceptor), ENDPOINT);
		this.interceptor = interceptor;
	}

	public CompletableFuture<Void> submit(GrandExchangeTrade grandExchangeTrade)
	{
		return postAsync_(RequestBody.create(MEDIA_TYPE_JSON, objectToJson(grandExchangeTrade)))
			.thenCompose(response -> bodyToObjectFuture(response, Void.class));
	}

	// TODO: can these be final/constructor-initialized?
	public void setUuid(UUID uuid)
	{
		interceptor.setUuid(uuid);
	}

	public void setMachineId(String machineId)
	{
		interceptor.setMachineId(machineId);
	}

	private static class GrandExchangeClientInterceptor implements Interceptor
	{

		@Setter
		private UUID uuid;
		@Setter
		private String machineId;

		@Override
		public Response intercept(Chain chain) throws IOException
		{
			Request.Builder builder = chain.request().newBuilder();

			if (uuid != null)
			{
				builder.header(AUTH_HEADER, uuid.toString());
			}
			if (machineId != null)
			{
				builder.header(MACHINEID_HEADER, machineId);
			}

			return chain.proceed(builder.build());
		}
	}
}
