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
package net.runelite.http.api.chat;

import java.io.IOException;
import java.util.List;
import net.runelite.http.api.AbstractApiClientTest;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.Assert;
import org.junit.Test;

public class ChatClientTest extends AbstractApiClientTest
{
	@Test
	public void submitKcCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		chatClient.submitKc("Zezima", "Goblin", 64);
		Request request = captureRequest.getRequest();
		Assert.assertEquals("POST", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("kc", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
		Assert.assertEquals("Goblin", url.queryParameter("boss"));
		Assert.assertEquals("64", url.queryParameter("kc"));
	}

	@Test
	public void getKcCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		exception.expect(NumberFormatException.class);
		chatClient.getKc("Zezima", "myBoss");
		Request request = captureRequest.getRequest();
		Assert.assertEquals("GET", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("kc", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
		Assert.assertEquals("myBoss", url.queryParameter("boss"));
	}

	@Test
	public void submitQpCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		chatClient.submitQp("Zezima", 64);
		Request request = captureRequest.getRequest();
		Assert.assertEquals("POST", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("qp", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
		Assert.assertEquals("64", url.queryParameter("qp"));
	}

	@Test
	public void getQpCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		exception.expect(NumberFormatException.class);
		chatClient.getQp("Zezima");
		Request request = captureRequest.getRequest();
		Assert.assertEquals("GET", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("qp", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
	}

	@Test
	public void submitTaskCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		chatClient.submitTask("Zezima", "myTask", 64, 128, "myLocation");
		Request request = captureRequest.getRequest();
		Assert.assertEquals("POST", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("task", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
		Assert.assertEquals("myTask", url.queryParameter("task"));
		Assert.assertEquals("64", url.queryParameter("amount"));
		Assert.assertEquals("128", url.queryParameter("initialAmount"));
		Assert.assertEquals("myLocation", url.queryParameter("location"));
	}

	@Test
	public void getTaskCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		chatClient.getTask("Zezima");
		Request request = captureRequest.getRequest();
		Assert.assertEquals("GET", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("task", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
	}

	@Test
	public void submitPbCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		chatClient.submitPb("Zezima", "myBoss", 64);
		Request request = captureRequest.getRequest();
		Assert.assertEquals("POST", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("pb", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
		Assert.assertEquals("myBoss", url.queryParameter("boss"));
		Assert.assertEquals("64", url.queryParameter("pb"));
	}

	@Test
	public void getPbCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		exception.expect(NumberFormatException.class);
		chatClient.getPb("Zezima", "myBoss");
		Request request = captureRequest.getRequest();
		Assert.assertEquals("GET", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("pb", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
		Assert.assertEquals("myBoss", url.queryParameter("boss"));
	}

	@Test
	public void submitGcCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		chatClient.submitGc("Zezima", 64);
		Request request = captureRequest.getRequest();
		Assert.assertEquals("POST", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("gc", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
		Assert.assertEquals("64", url.queryParameter("gc"));
	}

	@Test
	public void getGcCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		exception.expect(NumberFormatException.class);
		chatClient.getGc("Zezima");
		Request request = captureRequest.getRequest();
		Assert.assertEquals("GET", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("gc", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
	}

	@Test
	public void submitDuelsCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		chatClient.submitDuels("Zezima", 64, 128, 256, 512);
		Request request = captureRequest.getRequest();
		Assert.assertEquals("POST", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("duels", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
		Assert.assertEquals("64", url.queryParameter("wins"));
		Assert.assertEquals("128", url.queryParameter("losses"));
		Assert.assertEquals("256", url.queryParameter("winningStreak"));
		Assert.assertEquals("512", url.queryParameter("losingStreak"));
	}

	@Test
	public void getDuelsCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		chatClient.getDuels("Zezima");
		Request request = captureRequest.getRequest();
		Assert.assertEquals("GET", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("duels", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
	}

	@Test
	public void submitLayoutCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		chatClient.submitLayout("Zezima", new LayoutRoom[0]);
		Request request = captureRequest.getRequest();
		Assert.assertEquals("POST", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("layout", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
	}

	@Test
	public void getLayoutCorrectUrl() throws IOException
	{
		CaptureRequestInterceptor captureRequest = new CaptureRequestInterceptor();
		ChatClient chatClient = new ChatClient(new OkHttpClient.Builder().addInterceptor(captureRequest).build());

		chatClient.getLayout("Zezima");
		Request request = captureRequest.getRequest();
		Assert.assertEquals("GET", request.method());

		HttpUrl url = request.url();
		List<String> pathSegments = url.pathSegments();

		Assert.assertTrue(url.host().contains("api.runelite"));
		Assert.assertEquals(3, pathSegments.size());
		Assert.assertTrue(pathSegments.get(0).contains("runelite"));
		Assert.assertEquals("chat", pathSegments.get(1));
		Assert.assertEquals("layout", pathSegments.get(2));

		Assert.assertEquals("Zezima", url.queryParameter("name"));
	}
}
