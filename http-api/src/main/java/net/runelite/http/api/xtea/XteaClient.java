/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.api.xtea;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.runelite.http.api.RuneLiteApiClient;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class XteaClient extends RuneLiteApiClient
{
	private static final String ENDPOINT = "xtea";
	private static final Type typeToken;
	private static final Type typeTokenList;

	static
	{
		typeToken = new TypeToken<XteaKey>()
		{
		}.getType();
		typeTokenList = new TypeToken<List<XteaKey>>()
		{
		}.getType();
	}

	public XteaClient(OkHttpClient client)
	{
		super(client.newBuilder(), ENDPOINT);
	}

	public CompletableFuture<Void> submit(XteaRequest xteaRequest)
	{
		RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, objectToJson(xteaRequest));
		return postAsync_(body).thenCompose(response -> bodyToObjectFuture(response, typeTokenList));
	}

	public List<XteaKey> get() throws IOException
	{
		return bodyToObject(get_(), typeTokenList);
	}

	public XteaKey get(int region) throws IOException
	{
		return bodyToObject(get_(url -> url.newBuilder()
			.addPathSegment(Integer.toString(region))
			.build()
		), typeToken);
	}
}
