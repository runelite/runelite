/*
 * Copyright (c) 2018 Ben Dol <dolb90@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.http.api.osrsbox;

import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.item.ItemInfo;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Ben Dol
 */
public class OSRSBoxClient
{
	private static final Logger logger = LoggerFactory.getLogger(OSRSBoxClient.class);

	private static final String ROOT_URL = "https://www.osrsbox.com/osrsbox-db/items-json";

	public static ItemInfo getItem(long id) throws ItemNotFoundException
	{
		HttpUrl url = getApiBase().newBuilder()
			.addPathSegment(id + ".json")
			.build();

		logger.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				logger.debug("Error looking up item {}: {}", id, response.message());
				throw new ItemNotFoundException(id);
			}

			InputStream in = response.body().byteStream();
			return RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), ItemInfo.class);
		}
		catch (Exception ex)
		{
			throw new ItemNotFoundException(id, ex);
		}
	}

	public static String getJson(long id) throws ItemNotFoundException
	{
		HttpUrl url = getApiBase().newBuilder()
			.addPathSegment(id + ".json")
			.build();

		logger.debug("Built URI: {}", url);

		Request request = new Request.Builder()
			.url(url)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				logger.debug("Error looking up item {}: {}", id, response.message());
				throw new ItemNotFoundException(id);
			}

			return response.body().string();
		}
		catch (Exception ex)
		{
			throw new ItemNotFoundException(id, ex);
		}
	}

	public static HttpUrl getApiBase()
	{
		return HttpUrl.parse(ROOT_URL);
	}
}
