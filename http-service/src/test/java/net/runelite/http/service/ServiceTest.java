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
package net.runelite.http.service;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import javax.sql.DataSource;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.service.hiscore.HiscoreService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import spark.Spark;

public class ServiceTest
{
	private static final String URL_BASE = "http://localhost:4567";

	private static Service service;

	@BeforeClass
	public static void before() throws SQLException
	{
		DataSource dataSource = mock(DataSource.class, RETURNS_DEEP_STUBS);

		service = new Service();
		service.setDataSource(dataSource);
		service.init();

		Spark.awaitInitialization();
	}

	@AfterClass
	public static void after()
	{
		Spark.stop();
	}

	@Test
	public void testInit() throws Exception
	{
		HiscoreService hiscoreService = mock(HiscoreService.class);
		service.setHiscores(hiscoreService);

		HiscoreResult result = new HiscoreResult();
		result.setAttack(new Skill(1, 99, 42));

		when(hiscoreService.lookup("zezima")).thenReturn(result);

		URL url = new URL(URL_BASE + "/hiscore?username=zezima");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		Gson gson = new Gson();
		HiscoreResult res = gson.fromJson(new InputStreamReader(connection.getInputStream()), HiscoreResult.class);

		Assert.assertEquals(result, res);

		Spark.stop();
	}

}
