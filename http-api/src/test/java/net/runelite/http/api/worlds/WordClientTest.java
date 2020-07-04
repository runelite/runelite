package net.runelite.http.api.worlds;

import java.io.IOException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import reactor.netty.http.client.HttpClient;

public class WordClientTest
{
	private final MockWebServer server = new MockWebServer();
	private WorldClient client;

	private static final String expected =
		"{\"worlds\":[{\"id\":385,\"types\":[\"SKILL_TOTAL\"],\"address\":\"oldschool85.runescape.com\"," +
			"\"activity\":\"750 skill total\",\"location\":0,\"players\":80}]}";

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void before() throws IOException
	{
		server.start();
		client = WorldClient.create(HttpClient.create().baseUrl(server.url("/").toString()).port(server.getPort()));
	}

	@After
	public void after() throws IOException
	{
		server.shutdown();
	}

	@Test
	public void expectedResponse() throws IOException
	{
		server.enqueue(new MockResponse().setBody(expected).setResponseCode(200));
		WorldResult result = client.lookupWorlds();
		Assert.assertEquals(1, result.getWorlds().size());

		World world = result.getWorlds().get(0);

		Assert.assertEquals(385, world.getId());
		Assert.assertTrue(world.getTypes().contains(WorldType.SKILL_TOTAL));
		Assert.assertEquals("oldschool85.runescape.com", world.getAddress());
		Assert.assertEquals("750 skill total", world.getActivity());
		Assert.assertEquals(0, world.getLocation());
		Assert.assertEquals(80, world.getPlayers());
	}


}
