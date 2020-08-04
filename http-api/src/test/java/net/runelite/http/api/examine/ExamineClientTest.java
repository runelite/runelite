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
package net.runelite.http.api.examine;

import net.runelite.http.api.AbstractApiClientTest;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ExamineClientTest extends AbstractApiClientTest
{
	@Test
	public void correctObjectUrlBuilt()
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ExamineClient examineClient = new ExamineClient(new OkHttpClient.Builder()
			.addInterceptor(captureRequest)
			.build());

		examineClient.submitObject(512, "").join();

		HttpUrl builtUrl = captureRequest.getRequest().url();
		Assert.assertTrue(builtUrl.host().contains("api.runelite"));

		List<String> pathSegments = builtUrl.pathSegments();
		Assert.assertEquals(4, pathSegments.size());

		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("examine", pathSegments.get(1));
		Assert.assertEquals("object", pathSegments.get(2));
		Assert.assertEquals("512", pathSegments.get(3));
	}

	@Test
	public void correctNpcUrlBuilt()
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ExamineClient examineClient = new ExamineClient(new OkHttpClient.Builder()
			.addInterceptor(captureRequest)
			.build());

		examineClient.submitNpc(256, "").join();

		HttpUrl builtUrl = captureRequest.getRequest().url();
		Assert.assertTrue(builtUrl.host().contains("api.runelite"));

		List<String> pathSegments = builtUrl.pathSegments();
		Assert.assertEquals(4, pathSegments.size());

		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("examine", pathSegments.get(1));
		Assert.assertEquals("npc", pathSegments.get(2));
		Assert.assertEquals("256", pathSegments.get(3));
	}

	@Test
	public void correctItemUrlBuilt()
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ExamineClient examineClient = new ExamineClient(new OkHttpClient.Builder()
			.addInterceptor(captureRequest)
			.build());

		examineClient.submitItem(128, "").join();

		HttpUrl builtUrl = captureRequest.getRequest().url();
		Assert.assertTrue(builtUrl.host().contains("api.runelite"));

		List<String> pathSegments = builtUrl.pathSegments();
		Assert.assertEquals(4, pathSegments.size());

		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("examine", pathSegments.get(1));
		Assert.assertEquals("item", pathSegments.get(2));
		Assert.assertEquals("128", pathSegments.get(3));
	}

	@Test
	public void correctPostBody() throws InterruptedException
	{
		server.enqueue(new MockResponse().setResponseCode(200));

		ExamineClient examineClient = new ExamineClient(testClient.build());
		examineClient.submitItem(13, "Hello world!").join();

		RecordedRequest request = server.takeRequest();
		Assert.assertTrue(request.getHeader("Content-Type").contains("text/plain"));
		Assert.assertEquals("Hello world!", request.getBody().readUtf8());
	}
}
