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
package net.runelite.http.api.osbuddy;

import java.io.IOException;
import java.util.List;
import net.runelite.http.api.AbstractApiClientTest;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import org.junit.Assert;
import org.junit.Test;

public class OSBGrandExchangeClientTest extends AbstractApiClientTest
{
	private static final String expectedJson =
		"{\"item_id\":1434,\"buy_average\":29552,\"sell_average\":29491,\"overall_average\":29501,\"last_update\":" +
			"{\"seconds\":1594056267,\"nanos\":0}}";

	@Test
	public void expectedResponse() throws IOException
	{
		server.enqueue(new MockResponse().setBody(expectedJson).setResponseCode(200));
		OSBGrandExchangeClient client = new OSBGrandExchangeClient(testClient.build());
		OSBGrandExchangeResult result = client.lookupItem(0);

		Assert.assertEquals(1434, result.getItem_id());
		Assert.assertEquals(29552, result.getBuy_average());
		Assert.assertEquals(29491, result.getSell_average());
		Assert.assertEquals(29501, result.getOverall_average());
		Assert.assertEquals(1594056267, result.getLast_update().getEpochSecond());
	}

	@Test
	public void correctUrlBuilt() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		OSBGrandExchangeClient osbClient = new OSBGrandExchangeClient(new OkHttpClient.Builder()
			.addInterceptor(captureRequest).build());

		osbClient.lookupItem(1024);

		HttpUrl builtUrl = captureRequest.getRequest().url();
		List<String> pathSegments = builtUrl.pathSegments();

		Assert.assertEquals(3, pathSegments.size());
		Assert.assertEquals("osb", pathSegments.get(1));
		Assert.assertEquals("ge", pathSegments.get(2));

		Assert.assertEquals("1024", builtUrl.queryParameter("itemId"));
	}
}
