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
package net.runelite.http.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.Builder;
import lombok.Value;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RuneLiteApiClientTest
{

	public final MockWebServer server = new MockWebServer();
	private OkHttpClient.Builder testClient;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void before() throws IOException
	{
		server.start();
		testClient = new OkHttpClient.Builder()
			.addInterceptor(chain -> {
				Request request = chain.request()
					.newBuilder()
					.url(server.url("/"))
					.build();

				return chain.proceed(request);
			});
	}

	@After
	public void after() throws IOException
	{
		server.shutdown();
	}

	@Test
	public void gsonParseLombok() throws IOException
	{
		// Create a json response
		String json = "{\"a\": 2, \"b\": \"hello\"}";
		Response response = new Response.Builder()
			.protocol(Protocol.HTTP_2)
			.code(200)
			.request(new Request.Builder().url(server.url("/")).build())
			.body(ResponseBody.create(MediaType.parse("application/json"), json))
			.build();

		TestLombokClass t = RuneLiteApiClient.bodyToObject(response, TestLombokClass.class);
		Assert.assertEquals(2, t.getA());
		Assert.assertEquals("hello", t.getB());
	}

	@Test
	public void gsonParseVoid() throws IOException
	{
		// Create a json response
		String json = "";
		Response response = new Response.Builder()
			.protocol(Protocol.HTTP_2)
			.code(200)
			.request(new Request.Builder().url(server.url("/")).build())
			.body(ResponseBody.create(MediaType.parse("application/json"), json))
			.build();

		Void v = RuneLiteApiClient.bodyToObject(response, Void.class);
	}

	@Test
	public void noResponseAsync()
	{
		RuneLiteApiClient client = new RuneLiteApiClient(testClient, "/");
		CompletableFuture<Response> response = client.getAsync_();

		Assert.assertEquals(0, server.getRequestCount());
		Assert.assertFalse(response.isDone());
	}

	@Test
	public void expected200() throws IOException
	{
		server.enqueue(new MockResponse().setBody("Hello world!").setResponseCode(200));
		RuneLiteApiClient client = new RuneLiteApiClient(testClient, "/");
		Response response = client.get_();

		Assert.assertEquals(200, response.code());
		Assert.assertEquals("Hello world!", response.body().string());
	}

	@Test
	public void badResponseThrowsIOException() throws IOException
	{
		server.enqueue(new MockResponse().setResponseCode(500));

		RuneLiteApiClient client = new RuneLiteApiClient(testClient, "/");
		exception.expect(IOException.class);
		exception.expectMessage("500");
		client.get_();
	}

	@Test
	public void malformedJsonThrowsIOException() throws IOException
	{
		server.enqueue(new MockResponse().setResponseCode(200).setBody("{\"a: 2, \"b\": \"hello\"}"));

		RuneLiteApiClient client = new RuneLiteApiClient(testClient, "/");

		exception.expect(IOException.class);
		RuneLiteApiClient.bodyToObject(client.get_(), TestLombokClass.class);
	}

	@Test
	public void malformedJsonCompletesExceptionally() throws ExecutionException, InterruptedException
	{
		server.enqueue(new MockResponse().setResponseCode(200).setBody("{\"a: 2, \"b\": \"hello\"}"));

		RuneLiteApiClient client = new RuneLiteApiClient(testClient, "/");

		exception.expect(ExecutionException.class);
		client.getAsync_()
			.thenCompose(resp -> RuneLiteApiClient.bodyToObjectFuture(resp, TestLombokClass.class))
			.get();
	}

	@Value
	@Builder
	private static class TestLombokClass
	{
		int a;
		String b;
	}
}
