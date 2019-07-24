/*
 * Copyright (c) 2018, Forsco <https://github.com/forsco>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
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

package net.runelite.http.api.discord;

import com.google.gson.Gson;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
public class DiscordClient
{
	public static final Gson gson = new Gson();
	private static final MediaType JSON = MediaType.parse("application/json");

	public void message(HttpUrl url, DiscordMessage discordMessage)
	{
		log.info("Message being sent");
		message(url, discordMessage, 0, 5);
	}

	private void message(HttpUrl url, DiscordMessage discordMessage, int retryAttempt, int maxAttempts)
	{
		Request request = new Request.Builder()
			.post(RequestBody.create(JSON, gson.toJson(discordMessage)))
			.url(url)
			.build();

		log.info("Attempting to message with {}", discordMessage);

		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{

			@Override
			public void onFailure(Call call, IOException e)
			{
				log.warn("Unable to submit discord post.", e);
				if (retryAttempt < maxAttempts)
				{
					message(url, discordMessage, retryAttempt + 1, maxAttempts);
				}
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				try
				{
					if (response.body() == null)
					{
						log.error("API Call - Reponse was null.");
						return;
					}
					if (response.body().string().contains("You are being rate limited") && retryAttempt < maxAttempts)
					{
						log.error("You are being rate limited, retrying...");
						message(url, discordMessage, retryAttempt + 1, maxAttempts);
					}
				}
				finally
				{
					response.close();
					log.debug("Submitted discord log record");
				}
			}
		});
	}
}
