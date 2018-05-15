/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.cml;

import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.cml.CmlResult;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class CmlService
{
	private static final String BASE = "https://crystalmathlabs.com/tracker/api.php";
	private final OkHttpClient CLIENT = new OkHttpClient();

	public CmlResult lookup(String username) throws IOException
	{
		HttpUrl url = HttpUrl.parse(BASE + "?type=trackehp&player=" + username);

		Request request = new Request.Builder()
				.url(url)
				.build();

		try (Response response = CLIENT.newCall(request).execute())
		{

			String body = response.body().string();
			if (body.equals("-1") || body.equals("-2") || body.equals("-3") || body.equals("-4"))
			{
				return null;
			}

			String[] overallLine = body.split("\n");
			if (overallLine.length == 0)
			{
				return null;
			}

			String[] sections = overallLine[overallLine.length - 1].split(",");
			if (sections.length == 0)
			{
				return null;
			}

			try
			{
				return new CmlResult(Double.parseDouble(sections[2]),
						-Integer.parseInt(sections[1]),
						Double.parseDouble(sections[0]));
			}
			catch (NumberFormatException ex)
			{
				log.warn("Failed to parse CML data, must have an invalid format: " + body);
				return null;
			}
		}
	}
}
