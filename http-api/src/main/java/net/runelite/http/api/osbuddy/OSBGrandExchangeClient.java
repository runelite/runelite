/*
 * Copyright (c) 2018, AeonLucid <https://github.com/AeonLucid>
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
package net.runelite.http.api.osbuddy;

import java.io.IOException;
import net.runelite.http.api.RuneLiteApiClient;
import okhttp3.OkHttpClient;

public class OSBGrandExchangeClient extends RuneLiteApiClient
{
	private static final String ENDPOINT = "osb/ge";

	public OSBGrandExchangeClient(OkHttpClient client)
	{
		super(client.newBuilder(), ENDPOINT);
	}

	public OSBGrandExchangeResult lookupItem(int itemId) throws IOException
	{
		return bodyToObject(get_(url -> url.newBuilder()
			.addQueryParameter("itemId", Integer.toString(itemId))
			.build()), OSBGrandExchangeResult.class);
	}
}
