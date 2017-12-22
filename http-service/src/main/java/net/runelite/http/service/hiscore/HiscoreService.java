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
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreSkill;
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.service.util.HiscoreEndpointEditor;
import net.runelite.http.service.util.exception.InternalServerErrorException;
import net.runelite.http.service.util.exception.NotFoundException;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hiscore")
public class HiscoreService
{
	private static final Logger logger = LoggerFactory.getLogger(HiscoreService.class);

	HiscoreResultBuilder lookupUsername(String username, HiscoreEndpoint endpoint) throws IOException
	{
		return lookupUsername(username, endpoint.getHiscoreURL());
	}

	HiscoreResultBuilder lookupUsername(String username, HttpUrl hiscoreUrl) throws IOException
	{
		HttpUrl url = hiscoreUrl.newBuilder()
				.addQueryParameter("player", username)
				.build();

		logger.info("Built URL {}", url);

		Request okrequest = new Request.Builder()
				.url(url)
				.build();

		String responseStr;

		try (Response okresponse = RuneliteAPI.CLIENT.newCall(okrequest).execute())
		{
			if (!okresponse.isSuccessful())
			{
				switch (HttpStatus.valueOf(okresponse.code()))
				{
					case NOT_FOUND:
						throw new NotFoundException();
					default:
						throw new InternalServerErrorException("Error retrieving data from Jagex Hiscores: " + okresponse.message());
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
				logger.warn("Jagex Hiscore API returned unexpected data");
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

	@RequestMapping("/{endpoint}")
	public HiscoreResult lookup(@PathVariable HiscoreEndpoint endpoint, @RequestParam String username) throws IOException
	{
		HiscoreResultBuilder result = lookupUsername(username, endpoint);
		return result.build();
	}

	@RequestMapping("/{endpoint}/{skillName}")
	public SingleHiscoreSkillResult singleSkillLookup(@PathVariable HiscoreEndpoint endpoint, @PathVariable String skillName, @RequestParam String username) throws IOException
	{
		HiscoreSkill skill = HiscoreSkill.valueOf(skillName.toUpperCase());

		// RS api only supports looking up all stats
		HiscoreResultBuilder result = lookupUsername(username, endpoint);

		// Find the skill to return
		Skill requested = result.getSkill(skill.ordinal());

		SingleHiscoreSkillResult skillResult = new SingleHiscoreSkillResult();
		skillResult.setPlayer(username);
		skillResult.setSkillName(skillName);
		skillResult.setSkill(requested);

		return skillResult;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(HiscoreEndpoint.class, new HiscoreEndpointEditor());
	}
}
