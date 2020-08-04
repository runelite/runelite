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
package net.runelite.http.api.item;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import net.runelite.http.api.AbstractApiClientTest;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import org.junit.Assert;
import org.junit.Test;

public class ItemClientTest extends AbstractApiClientTest
{
	private final static String expectedJsonPrice = "[{\"id\":2,\"name\":\"Cannonball\"," +
		"\"price\":174,\"time\":{\"seconds\":1593993600,\"nanos\":0}}]";

	private final static String expectedJsonStats = "{\"0\":{\"quest\":true,\"weight\":16.0, \"ge_limit\":2000," +
		"\"equipable\":true}}";

	@Test
	public void correctPricesUrlBuilt() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ItemClient itemClient = new ItemClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		itemClient.getPrices();

		HttpUrl builtUrl = captureRequest.getRequest().url();

		Assert.assertTrue(builtUrl.host().contains("api.runelite"));

		List<String> pathSegments = builtUrl.pathSegments();
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("item", pathSegments.get(1));
		Assert.assertEquals("prices.js", pathSegments.get(2));
	}

	@Test
	public void correctStatsUrlBuilt() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ItemClient itemClient = new ItemClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		itemClient.getStats();

		HttpUrl builtUrl = captureRequest.getRequest().url();

		Assert.assertTrue(builtUrl.host().contains("static.runelite"));

		List<String> pathSegments = builtUrl.pathSegments();
		Assert.assertEquals(2, pathSegments.size());
		Assert.assertEquals("item", pathSegments.get(0));
		Assert.assertEquals("stats.ids.min.json", pathSegments.get(1));
	}

	@Test
	public void expectedResponsePrices() throws IOException
	{
		server.enqueue(new MockResponse().setResponseCode(200).setBody(expectedJsonPrice));
		ItemClient client = new ItemClient(testClient.build());

		ItemPrice[] prices = client.getPrices();

		Assert.assertEquals(1, prices.length);
		Assert.assertEquals(2, prices[0].getId());
		Assert.assertEquals("Cannonball", prices[0].getName());
		Assert.assertEquals(174, prices[0].getPrice());
		Assert.assertEquals(1593993600, prices[0].getTime().getEpochSecond());
	}

	@Test
	public void expectedResponseStats() throws IOException
	{
		server.enqueue(new MockResponse().setResponseCode(200).setBody(expectedJsonStats));
		ItemClient client = new ItemClient(testClient.build());

		Map<Integer, ItemStats> stats = client.getStats();

		Assert.assertEquals(1, stats.size());
		Assert.assertTrue(stats.containsKey(0));
		Assert.assertTrue(stats.get(0).isQuest());
		Assert.assertEquals(16.0, stats.get(0).getWeight(), 0.0);
		Assert.assertEquals(2000, stats.get(0).getGeLimit());
		Assert.assertTrue(stats.get(0).isEquipable());
	}
}
