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
import net.runelite.http.api.RuneliteAPI;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.Skill;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import spark.Request;
import spark.Response;

public class HiscoreService
{
	private static final HttpUrl RUNESCAPE_HISCORE_SERVICE = HttpUrl.parse("http://services.runescape.com/m=hiscore_oldschool/index_lite.ws");

	private HttpUrl url = RUNESCAPE_HISCORE_SERVICE;

	public HiscoreResult lookup(Request request, Response response) throws IOException
	{
		String username = request.queryParams("username");

		HttpUrl hiscoreUrl = url.newBuilder()
			.addQueryParameter("player", username)
			.build();

		okhttp3.Request okrequest = new okhttp3.Request.Builder()
			.url(hiscoreUrl)
			.build();

		okhttp3.Response okresponse = RuneliteAPI.CLIENT.newCall(okrequest).execute();
		String responseStr;

		try (ResponseBody body = okresponse.body())
		{
			responseStr = body.string();
		}

		CSVParser parser = CSVParser.parse(responseStr, CSVFormat.DEFAULT);

		HiscoreResultBuilder hiscoreBuilder = new HiscoreResultBuilder();
		hiscoreBuilder.setPlayer(username);

		int count = 0;

		for (CSVRecord record : parser.getRecords())
		{
			if (count++ >= HiscoreResultBuilder.NUM_SKILLS)
			{
				break; // rest is other things?
			}

			// rank, level, experience
			int rank = Integer.parseInt(record.get(0));
			int level = Integer.parseInt(record.get(1));
			long experience = Long.parseLong(record.get(2));

			Skill skill = new Skill(rank, level, experience);
			hiscoreBuilder.setNextSkill(skill);
		}

		response.type("application/json");
		return hiscoreBuilder.build();
	}

	public HttpUrl getUrl()
	{
		return url;
	}

	public void setUrl(HttpUrl url)
	{
		this.url = url;
	}
}
