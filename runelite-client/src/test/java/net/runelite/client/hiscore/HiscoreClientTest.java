/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package net.runelite.client.hiscore;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HiscoreClientTest
{
	private static final String RESPONSE = "654683,705,1304518\n"
		+ "679419,50,107181\n"
		+ "550667,48,85764\n"
		+ "861497,50,101366\n"
		+ "891591,48,87843\n"
		+ "-1,1,4\n"
		+ "840255,27,10073\n"
		+ "1371912,10,1310\n"
		+ "432193,56,199795\n"
		+ "495638,56,198304\n"
		+ "514466,37,27502\n"
		+ "456981,54,159727\n"
		+ "459159,49,93010\n"
		+ "1028855,8,823\n"
		+ "862906,29,12749\n"
		+ "795020,31,16097\n"
		+ "673591,5,495\n"
		+ "352676,51,112259\n"
		+ "428419,40,37235\n"
		+ "461887,43,51971\n"
		+ "598582,1,10\n"
		+ "638177,1,0\n"
		+ "516239,9,1000\n"
		+ "492790,1,0\n"
		+ "2,2460\n" // leagues
		+ "-1,-1\n"
		+ "73,1738\n"
		+ "531,1432\n"
		+ "324,212\n"
		+ "8008,131\n"
		+ "1337,911\n"
		+ "42,14113\n"
		+ "1,777\n"
		+ "254,92\n"
		+ "-1,-1\n" // lms
		+ "-1,-1\n" // pvp arena rank
		+ "1,241\n" // soul wars
		+ "1,2739\n" // gotr
		+ "24870,37\n"
		+ "15020,388\n"
		+ "50463,147\n"
		+ "-1,-1\n"
		+ "92357,1\n"
		+ "22758,637\n"
		+ "22744,107\n"
		+ "-1,-1\n"
		+ "20150,17\n"
		+ "29400,18\n"
		+ "13465,172\n"
		+ "1889,581\n"
		+ "42891,11\n"
		+ "1624,1957\n"
		+ "1243,2465\n"
		+ "1548,2020\n"
		+ "-1,-1\n"
		+ "16781,327\n"
		+ "19004,149\n"
		+ "-1,-1\n"
		+ "72046,5\n"
		+ "5158,374\n"
		+ "20902,279\n"
		+ "702,6495\n"
		+ "10170,184\n"
		+ "8064,202\n"
		+ "6936,2\n" // Mimic
		+ "1,4920\n" // Nex
		+ "2335,9\n" // Nightmare
		+ "2336,10\n" // Phosanis Nightmare
		+ "-1,-1\n"
		+ "-1,-1\n"
		+ "19779,22\n"
		+ "58283,10\n"
		+ "1234,5678\n" // Tempoross
		+ "-1,-1\n"
		+ "-1,-1\n"
		+ "-1,-1\n" // TOB
		+ "42,42\n" // TOB: Hard Mode
		+ "29347,130\n" // Thermy
		+ "1,2000\n" // TOA
		+ "-1,-1\n" // TOA: Expert Mode
		+ "723,4\n" // Zuk
		+ "1264,38\n" // Jad
		+ "44595,4\n" // Venenatis
		+ "24820,4\n" // Vetion
		+ "12116,782\n" // Vorkath
		+ "2299,724\n" // Wintertodt
		+ "19301,62\n" // Zalcano
		+ "1498,5847\n"; // Zulrah

	@Rule
	public final MockWebServer server = new MockWebServer();

	@Bind
	public Gson gson = new Gson();

	@Bind
	public OkHttpClient okHttpClient = new OkHttpClient();

	@Before
	public void before() throws IOException
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Inject
	private HiscoreClient hiscoreClient;

	@Test
	public void testMapping()
	{
		Map<HiscoreEndpoint, List<HiscoreSkill>> mappings = HiscoreClient.convertMappings(
			HiscoreClient.loadDiskMappings(new Gson()),
			true);

		mappings.forEach((k, v) ->
		{
			assertNotEquals(k.name(), v, null);
			assertEquals(k.name() + " is unique", v.size(), new HashSet<>(v).size());
		});
	}

	@Test
	public void testNormalLookup() throws Exception
	{
		server.enqueue(new MockResponse().setBody(RESPONSE));
		HiscoreResult result = hiscoreClient.lookup("zezima", HiscoreEndpoint.NORMAL, server.url("/"));

		assertEquals(50, result.getSkill(HiscoreSkill.ATTACK).getLevel());
		assertEquals(159727L, result.getSkill(HiscoreSkill.FISHING).getExperience());
		assertEquals(492790, result.getSkill(HiscoreSkill.CONSTRUCTION).getRank());
		assertEquals(1432, result.getSkill(HiscoreSkill.CLUE_SCROLL_ALL).getLevel());
		assertEquals(324, result.getSkill(HiscoreSkill.CLUE_SCROLL_BEGINNER).getRank());
		assertEquals(8008, result.getSkill(HiscoreSkill.CLUE_SCROLL_EASY).getRank());
		assertEquals(911, result.getSkill(HiscoreSkill.CLUE_SCROLL_MEDIUM).getLevel());
		assertEquals(42, result.getSkill(HiscoreSkill.CLUE_SCROLL_HARD).getRank());
		assertEquals(777, result.getSkill(HiscoreSkill.CLUE_SCROLL_ELITE).getLevel());
		assertEquals(254, result.getSkill(HiscoreSkill.CLUE_SCROLL_MASTER).getRank());
		assertEquals(-1, result.getSkill(HiscoreSkill.LAST_MAN_STANDING).getLevel());
		assertEquals(241, result.getSkill(HiscoreSkill.SOUL_WARS_ZEAL).getLevel());
		assertEquals(2739, result.getSkill(HiscoreSkill.RIFTS_CLOSED).getLevel());
		assertEquals(2460, result.getSkill(HiscoreSkill.LEAGUE_POINTS).getLevel());
		assertEquals(37, result.getSkill(HiscoreSkill.ABYSSAL_SIRE).getLevel());
		assertEquals(92357, result.getSkill(HiscoreSkill.CALLISTO).getRank());
		assertEquals(4920, result.getSkill(HiscoreSkill.NEX).getLevel());
		assertEquals(2336, result.getSkill(HiscoreSkill.PHOSANIS_NIGHTMARE).getRank());
		assertEquals(5678, result.getSkill(HiscoreSkill.TEMPOROSS).getLevel());
		assertEquals(42, result.getSkill(HiscoreSkill.THEATRE_OF_BLOOD_HARD_MODE).getLevel());
		assertEquals(5847, result.getSkill(HiscoreSkill.ZULRAH).getLevel());
	}
}