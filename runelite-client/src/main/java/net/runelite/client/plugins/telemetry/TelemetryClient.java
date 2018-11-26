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
package net.runelite.client.plugins.telemetry;

import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.telemetry.data.TelemetryData;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
public class TelemetryClient
{
	private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public void submit(List<TelemetryData> data)
	{
		log.info("Submitting Queue: {}", data);
		log.info("Data as JSON: {}", RuneLiteAPI.GSON.toJson(data));
		Request r = new Request.Builder()
			.url(RuneLiteAPI.getTelemetryBase())
			.post(RequestBody.create(JSON, RuneLiteAPI.GSON.toJson(data)))
			.build();

		log.info("Submitting Request: {}", r.toString());
		try (Response response = RuneLiteAPI.CLIENT.newCall(r).execute())
		{
			if (response.isSuccessful())
			{
				log.info("Successfully sent telemetry data");
			}
			else
			{
				log.debug("Error sending telemetry data to URI: {}", RuneLiteAPI.getTelemetryBase());
				log.debug(response.body().toString());
			}
		}
		catch (IOException e)
		{
			log.debug("IOException: {}", e.getMessage());
		}
	}
}
