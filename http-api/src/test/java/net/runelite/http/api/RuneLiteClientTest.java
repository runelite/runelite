package net.runelite.http.api;

import java.io.IOException;
import java.time.Duration;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import reactor.netty.http.client.HttpClient;
import reactor.test.StepVerifier;
import reactor.util.retry.Retry;

public class RuneLiteClientTest
{

	public final MockWebServer server = new MockWebServer();
	private HttpClient httpClient;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void before() throws IOException
	{
		server.start();
		httpClient = HttpClient.create().baseUrl(server.url("/").toString()).port(server.getPort());
	}

	@After
	public void after() throws IOException
	{
		server.shutdown();
	}

	@Test()
	public void retriesExhausted()
	{
		RuneLiteClient client = new RuneLiteClient(httpClient, "/", Retry.backoff(5, Duration.ofMillis(10)));

		// enqueue expected retry responses + 1 (initial request)
		for (long i = 0; i < client.getRetryMaxAttempts() + 1; i++)
		{
			server.enqueue(new MockResponse().setResponseCode(500));
		}

		StepVerifier.create(client.get(String.class).retrieve())
			.expectError(IOException.class)
			.verify();

		Assert.assertEquals(client.getRetryMaxAttempts() + 1, server.getRequestCount());
	}

	@Test()
	public void retryUntil200()
	{
		RuneLiteClient client = new RuneLiteClient(httpClient, "/", Retry.backoff(5, Duration.ofMillis(10)));

		server.enqueue(new MockResponse().setResponseCode(500));
		server.enqueue(new MockResponse().setResponseCode(500));
		server.enqueue(new MockResponse().setResponseCode(200));

		StepVerifier.create(client.get(String.class).retrieve())
			.expectComplete()
			.verify();

		Assert.assertEquals(3, server.getRequestCount());
	}

	@Test
	public void emptyResponseNonNull() throws IOException
	{
		server.enqueue(new MockResponse().setBody("").setResponseCode(200));

	}
}
