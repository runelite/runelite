/*
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
package net.runelite.http.api.npc;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import net.runelite.http.api.AbstractApiClientTest;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import org.junit.Assert;
import org.junit.Test;

public class NpcInfoClientTest extends AbstractApiClientTest
{
	private static final String expectedJson =
		"{\"1\":{\"hitpoints\":52},\"2\":{\"hitpoints\":90},\"3\":{\"hitpoints\":90}}";

	@Test
	public void expectedResponse() throws IOException
	{
		server.enqueue(new MockResponse().setBody(expectedJson).setResponseCode(200));
		NpcInfoClient client = new NpcInfoClient(testClient.build());

		Map<Integer, NpcInfo> result = client.getNpcs();

		Assert.assertEquals(3, result.size());
		Assert.assertEquals(52, result.get(1).getHitpoints());
		Assert.assertEquals(90, result.get(2).getHitpoints());
		Assert.assertEquals(90, result.get(3).getHitpoints());
	}

	@Test
	public void correctUrlBuilt() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		NpcInfoClient npcInfoClient = new NpcInfoClient(new OkHttpClient.Builder()
			.addInterceptor(captureRequest).build());

		npcInfoClient.getNpcs();

		HttpUrl builtUrl = captureRequest.getRequest().url();

		Assert.assertTrue(builtUrl.host().contains("static.runelite"));

		List<String> pathSegments = builtUrl.pathSegments();
		Assert.assertEquals(2, pathSegments.size());
		Assert.assertEquals("npcs", pathSegments.get(0));
		Assert.assertEquals("npcs.min.json", pathSegments.get(1));
	}
}
