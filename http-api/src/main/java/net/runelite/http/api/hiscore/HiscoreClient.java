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
package net.runelite.http.api.hiscore;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Slf4j
public class HiscoreClient
{
	public HiscoreResult lookup(String username, HiscoreEndpoint endpoint) throws IOException
	{
		return lookup(username, endpoint.getHiscoreURL());
	}

	public HiscoreResult lookup(String username, HttpUrl endpoint) throws IOException
	{
		HiscoreResultBuilder resultBuilder = lookupUsername(username, endpoint);

		if (resultBuilder == null)
		{
			return null;
		}

		return resultBuilder.build();
	}

	public HiscoreResult lookup(String username) throws IOException
	{
		return lookup(username, HiscoreEndpoint.NORMAL);
	}

	public SingleHiscoreSkillResult lookup(String username, HiscoreSkill skill, HiscoreEndpoint endpoint) throws IOException
	{
		HiscoreResultBuilder resultBuilder = lookupUsername(username, endpoint.getHiscoreURL());

		if (resultBuilder == null)
		{
			return null;
		}

		HiscoreResult result = resultBuilder.build();

		Skill requested = result.getSkill(skill);
		SingleHiscoreSkillResult skillResult = new SingleHiscoreSkillResult();
		skillResult.setPlayer(username);
		skillResult.setSkillName(skill.getName());
		skillResult.setSkill(requested);
		return skillResult;
	}

	public SingleHiscoreSkillResult lookup(String username, HiscoreSkill skill) throws IOException
	{
		return lookup(username, skill, HiscoreEndpoint.NORMAL);
	}

	private HiscoreResultBuilder lookupUsername(String username, HttpUrl hiscoreUrl) throws IOException
	{
		HttpUrl url = hiscoreUrl.newBuilder()
			.addQueryParameter("player", username)
			.build();

		log.debug("Built URL {}", url);

		Request okrequest = new Request.Builder()
			.url(url)
			.build();

		String responseStr;

		try (Response okresponse = RuneLiteAPI.CLIENT.newCall(okrequest).execute())
		{
			if (!okresponse.isSuccessful())
			{
				switch (okresponse.code())
				{
					case 404:
						return null;
					default:
						throw new IOException("Error retrieving data from Jagex Hiscores: " + okresponse);
				}
			}

			responseStr = okresponse.body().string();
		}

		CSVParser parser = CSVParser.parse(responseStr, CSVFormat.DEFAULT);

		HiscoreResultBuilder hiscoreBuilder = new HiscoreResultBuilder();
		hiscoreBuilder.setPlayer(username);

		int count = 0;

		for (CSVRecord record : parser.getRecords())
		{
			if (count++ >= HiscoreSkill.values().length)
			{
				log.warn("Jagex Hiscore API returned unexpected data");
				break; // rest is other things?
			}

			// rank, level, experience
			int rank = Integer.parseInt(record.get(0));
			int level = Integer.parseInt(record.get(1));

			// items that are not skills do not have an experience parameter
			long experience = -1;
			if (record.size() == 3)
			{
				experience = Long.parseLong(record.get(2));
			}

			Skill skill = new Skill(rank, level, experience);
			hiscoreBuilder.setNextSkill(skill);
		}

		return hiscoreBuilder;
	}
}
