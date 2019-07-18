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
package net.runelite.http.api.osbuddy;

import com.google.gson.JsonParseException;
import io.reactivex.Observable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
public class OSBGrandExchangeClient
{
	public Observable<OSBGrandExchangeResult> lookupItem(int itemId)
	{
		final HttpUrl url = RuneLiteAPI.getApiBase().newBuilder()
			.addPathSegment("osb")
			.addPathSegment("ge")
			.addQueryParameter("itemId", Integer.toString(itemId))
			.build();

		log.debug("Built URI: {}", url);

		return Observable.defer(() ->
		{
			Request request = new Request.Builder()
				.url(url)
				.build();

			try (final Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
			{
				if (!response.isSuccessful())
				{
					throw new IOException("Error looking up item id: " + response);
				}

				final InputStream in = response.body().byteStream();
				return Observable.just(RuneLiteAPI.GSON.fromJson(new InputStreamReader(in), OSBGrandExchangeResult.class));
			}
			catch (JsonParseException e)
			{
				return Observable.error(e);
			}
		});
	}
}
