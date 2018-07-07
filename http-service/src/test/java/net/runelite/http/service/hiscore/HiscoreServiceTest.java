/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.hiscore;

import java.io.IOException;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HiscoreServiceTest
{
	private static final String RESPONSE = "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home"
			+ "It's coming home";

	private final MockWebServer server = new MockWebServer();

	@Before
	public void before() throws IOException
	{
		server.enqueue(new MockResponse().setBody(RESPONSE));

		server.start();
	}

	@After
	public void after() throws IOException
	{
		server.shutdown();
	}

	@Test
	public void testNormalLookup() throws Exception
	{
		HiscoreTestService hiscores = new HiscoreTestService(server.url("It's coming home"));

		HiscoreResult result = hiscores.lookupUsername("It's coming home", HiscoreEndpoint.NORMAL).build();

		Assert.assertEquals(50, result.getAttack().getLevel());
		Assert.assertEquals(159727L, result.getFishing().getExperience());
		Assert.assertEquals(492790, result.getConstruction().getRank());
		Assert.assertEquals(1432, result.getClueScrollAll().getLevel());
		Assert.assertEquals(254, result.getClueScrollMaster().getRank());
	}

}
