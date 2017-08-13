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
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.api.hiscore.HiscoreSkill;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hiscore")
public class HiscoreService
{
	private static final Logger logger = LoggerFactory.getLogger(HiscoreService.class);

	private static final HttpUrl RUNESCAPE_HISCORE_SERVICE = HttpUrl.parse("http://services.runescape.com/m=hiscore_oldschool/index_lite.ws");

	private HttpUrl url = RUNESCAPE_HISCORE_SERVICE;

	private HiscoreResultBuilder lookupUsername(String username) throws IOException
	{
		HttpUrl hiscoreUrl = url.newBuilder()
			.addQueryParameter("player", username)
			.build();

		logger.info("Built URL {}", hiscoreUrl);

		Request okrequest = new Request.Builder()
			.url(hiscoreUrl)
			.build();

		Response okresponse = RuneliteAPI.CLIENT.newCall(okrequest).execute();
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
			if (count++ >= HiscoreSkill.values().length)
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

		return hiscoreBuilder;
	}

	@RequestMapping
	public HiscoreResult lookup(@RequestParam String username) throws IOException
	{
		HiscoreResultBuilder result = lookupUsername(username);
		return result.build();
	}

	@RequestMapping("/{skillName}")
	public SingleHiscoreSkillResult singleSkillLookup(@PathVariable String skillName, @RequestParam String username) throws IOException
	{
		HiscoreSkill skill = HiscoreSkill.valueOf(skillName.toUpperCase());

		// RS api only supports looking up all stats
		HiscoreResultBuilder result = lookupUsername(username);

		// Find the skill to return
		Skill requested = result.getSkill(skill.ordinal());

		SingleHiscoreSkillResult skillResult = new SingleHiscoreSkillResult();
		skillResult.setPlayer(username);
		skillResult.setSkillName(skillName);
		skillResult.setSkill(requested);

		return skillResult;
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
