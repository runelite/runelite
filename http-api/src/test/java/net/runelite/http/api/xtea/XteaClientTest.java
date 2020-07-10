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
package net.runelite.http.api.xtea;

import java.io.IOException;
import java.util.List;
import net.runelite.http.api.AbstractApiClientTest;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.Assert;
import org.junit.Test;

public class XteaClientTest extends AbstractApiClientTest
{
	@Test
	public void submitCorrectUrl()
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		XteaClient xteaClient = new XteaClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());
		xteaClient.submit(new XteaRequest()).join();

		Request request = captureRequest.getRequest();
		Assert.assertEquals("POST", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(2, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("xtea", pathSegments.get(1));
	}

	@Test
	public void getCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		XteaClient xteaClient = new XteaClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());
		xteaClient.get(5);

		Request request = captureRequest.getRequest();
		Assert.assertEquals("GET", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("xtea", pathSegments.get(1));
		Assert.assertEquals("5", pathSegments.get(2));
	}
}
