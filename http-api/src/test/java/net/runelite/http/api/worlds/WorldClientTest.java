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
package net.runelite.http.api.worlds;

import java.io.IOException;
import net.runelite.http.api.AbstractApiClientTest;
import okhttp3.mockwebserver.MockResponse;
import org.junit.Assert;
import org.junit.Test;

public class WorldClientTest extends AbstractApiClientTest
{


	private static final String expectedJson =
		"{\"worlds\":[{\"id\":385,\"types\":[\"SKILL_TOTAL\"],\"address\":" +
			"\"oldschool85.runescape.com\",\"activity\":\"750 skill total\",\"location\":0,\"players\":95}]}";

	@Test
	public void expectedResponse() throws IOException
	{
		server.enqueue(new MockResponse().setBody(expectedJson).setResponseCode(200));
		WorldClient client = new WorldClient(testClient.build());
		WorldResult result = client.lookupWorlds();

		Assert.assertEquals(1, result.getWorlds().size());

		World world = result.getWorlds().get(0);

		Assert.assertEquals(385, world.getId());
		Assert.assertTrue(world.getTypes().contains(WorldType.SKILL_TOTAL));
		Assert.assertEquals("oldschool85.runescape.com", world.getAddress());
		Assert.assertEquals("750 skill total", world.getActivity());
		Assert.assertEquals(WorldRegion.UNITED_STATES_OF_AMERICA, WorldRegion.valueOf(world.getLocation()));
		Assert.assertEquals(95, world.getPlayers());
	}
}
