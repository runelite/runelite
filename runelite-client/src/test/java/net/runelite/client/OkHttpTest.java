/*
 * Copyright (c) 2020 Abex
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
package net.runelite.client;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class OkHttpTest
{
	@Rule
	public TemporaryFolder cacheFolder = new TemporaryFolder();
	
	@Rule
	public MockWebServer server = new MockWebServer();

	private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.US)
		.withZone(ZoneId.of("GMT"));

	private static final String BODY_404 = "<html>404 not found";
	private static final String BODY_200 = "{success:true}";

	/**
	 * The specific thing we are trying to catch here is when a 404
	 * response is served by cloudflare after the upstream has gotten
	 * an updated document. CF serves the 404 response with a Date header,
	 * but no ETag or Last-Modified. OkHttp then uses the Date header, which
	 * is from after the upstream was edited, in a If-Modified-Since request,
	 * which does hit the upstream, returning 304 Not Modified. Since there
	 * is no body OkHttp serves the cached 404 as up-to-date. Better yet, since
	 * there is now an ETag in the 304 response it requests subsequent updates
	 * with the ETag, which will always 304 Not Modified, causing clients in
	 * this state to get incorrect 404s until the ETag changes.
	 */
	@Test
	public void testCacheSanity() throws IOException, InterruptedException
	{
		OkHttpClient client = RuneLite.buildHttpClient(false);

		Instant lastModified = Instant.now().minusSeconds(20);

		server.enqueue(new MockResponse()
			.setResponseCode(404)
			.setHeader("Content-Type", "text/html")
			.setHeader("Date", TIME_FMT.format(Instant.now().minusSeconds(10)))
			.setBody(BODY_404));
		try (Response res = client.newCall(new Request.Builder()
			.url(server.url("/manifest"))
			.build()).execute())
		{
			Assert.assertEquals(404, res.code());
		}
		RecordedRequest req = server.takeRequest(1, TimeUnit.SECONDS);
		Assert.assertNotNull("cache did not make a initial request", req);

		server.enqueue(new MockResponse()
			.setResponseCode(200)
			.setHeader("Content-Type", "text/html")
			.setHeader("Date", TIME_FMT.format(Instant.now().minusSeconds(5)))
			.setHeader("Last-Modified", TIME_FMT.format(lastModified))
			.setBody(BODY_200));
		try (Response res = client.newCall(new Request.Builder()
			.url(server.url("/manifest"))
			.build()).execute())
		{
			Assert.assertEquals(200, res.code());
		}
		req = server.takeRequest(1, TimeUnit.SECONDS);
		Assert.assertNotNull("cache did not make a request", req);
		Assert.assertNull(req.getHeader("If-Modified-Since"));

		server.enqueue(new MockResponse()
			.setResponseCode(304)
			.setHeader("Content-Type", "text/html")
			.setHeader("Date", TIME_FMT.format(Instant.now()))
			.setHeader("Last-Modified", TIME_FMT.format(lastModified)));
		try (Response res = client.newCall(new Request.Builder()
			.url(server.url("/manifest"))
			.build()).execute())
		{
			Assert.assertEquals(200, res.code());
		}
		req = server.takeRequest(1, TimeUnit.SECONDS);
		Assert.assertNotNull("cache did not make a conditional request", req);
		Assert.assertNotNull(req.getHeader("If-Modified-Since"));
	}

	@Test
	public void testUserAgent() throws IOException, InterruptedException
	{
		server.enqueue(new MockResponse().setBody("OK"));

		Request request = new Request.Builder()
			.url(server.url("/"))
			.build();
		RuneLite.buildHttpClient(false)
			.newCall(request).execute().close();

		// rest of UA depends on if git is found
		assertTrue(server.takeRequest().getHeader("User-Agent").startsWith("RuneLite/" + RuneLiteProperties.getVersion()));
	}
}
