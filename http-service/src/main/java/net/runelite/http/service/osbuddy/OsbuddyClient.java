/*
 * Copyright (c) 2018, AeonLucid <https://github.com/AeonLucid>
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
package net.runelite.http.service.osbuddy;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.service.osbuddy.beans.OsbuddySummaryItem;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class OsbuddyClient
{
	public Map<Integer, OsbuddySummaryItem> getSummary() throws IOException
	{
		HttpUrl httpUrl = new HttpUrl.Builder()
			.scheme("https")
			.host("storage.googleapis.com")
			.addPathSegment("osb-exchange")
			.addPathSegment("summary.json")
			.build();

		Request request = new Request.Builder()
			.url(httpUrl)
			.header("User-Agent", "RuneLite")
			.build();

		try (Response responseOk = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!responseOk.isSuccessful())
			{
				throw new IOException("Error retrieving summary from OSBuddy: " + responseOk.message());
			}

			Type type = new TypeToken<Map<Integer, OsbuddySummaryItem>>()
			{
			}.getType();

			return RuneLiteAPI.GSON.fromJson(responseOk.body().string(), type);
		}
		catch (JsonSyntaxException ex)
		{
			throw new IOException(ex);
		}
	}
}
