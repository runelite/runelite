/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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

import com.google.gson.Gson;
import java.io.IOException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import static net.runelite.http.api.RuneLiteAPI.JSON;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@RequiredArgsConstructor
public class GrandExchangeClient
{
	private static final Gson GSON = RuneLiteAPI.GSON;

	private final OkHttpClient client;

	@Setter
	private UUID uuid;
	@Setter
	private String machineId;

	public void submit(GrandExchangeTrade grandExchangeTrade)
	{
		final HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("ge")
			.build();

		Request.Builder builder = new Request.Builder();
		if (uuid != null)
		{
			builder.header(RuneLiteAPI.RUNELITE_AUTH, uuid.toString());
		}
		if (machineId != null)
		{
			builder.header(RuneLiteAPI.RUNELITE_MACHINEID, machineId);
		}

		Request request = builder
			.post(RequestBody.create(JSON, GSON.toJson(grandExchangeTrade)))
			.url(url)
			.build();

		client.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.debug("unable to submit trade", e);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				log.debug("Submitted trade");
				response.close();
			}
		});
	}
}
