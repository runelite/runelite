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
package net.runelite.http.api.feed;

import java.io.IOException;
import java.util.List;
import net.runelite.http.api.AbstractApiClientTest;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import org.junit.Assert;
import org.junit.Test;

public class FeedClientTest extends AbstractApiClientTest
{
	private final static String expectedJson = "{\n" +
		"  \"items\": [\n" +
		"    {\n" +
		"      \"type\": \"BLOG_POST\",\n" +
		"      \"title\": \"1.6.21 Release\",\n" +
		"      \"content\": \"Pyramid Plunder plugin, Ground Items text outlines, NPC Indicator highlight style toggles\",\n" +
		"      \"url\": \"https://runelite.net/blog/show/2020-06-25-1.6.21-Release\",\n" +
		"      \"timestamp\": 1593079200000\n" +
		"    }\n" +
		"  ]\n" +
		"}";

	@Test
	public void correctUrlBuilt() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		FeedClient feedClient = new FeedClient(new OkHttpClient.Builder()
			.addInterceptor(captureRequest)
			.build());

		feedClient.lookupFeed();

		HttpUrl builtUrl = captureRequest.getRequest().url();

		Assert.assertTrue(builtUrl.host().contains("api.runelite"));

		List<String> pathSegments = builtUrl.pathSegments();
		Assert.assertEquals(2, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("feed.js", pathSegments.get(1));
	}

	@Test
	public void expectedResponse() throws IOException
	{
		server.enqueue(new MockResponse().setResponseCode(200).setBody(expectedJson));
		FeedClient feedClient = new FeedClient(testClient.build());

		FeedResult result = feedClient.lookupFeed();
		Assert.assertEquals(1, result.getItems().size());

		FeedItem item = result.getItems().get(0);
		Assert.assertEquals(FeedItemType.BLOG_POST, item.getType());
		Assert.assertEquals("1.6.21 Release", item.getTitle());
		Assert.assertTrue(item.getContent().startsWith("Pyramid Plunder"));
		Assert.assertTrue(item.getUrl().startsWith("https://runelite.net/blog"));
		Assert.assertEquals(1593079200000L, item.getTimestamp());
	}
}
