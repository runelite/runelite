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

import java.util.concurrent.ExecutionException;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreSkill;
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.service.util.HiscoreEndpointEditor;
import net.runelite.http.service.xp.XpTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hiscore")
public class HiscoreController
{
	@Autowired
	private HiscoreService hiscoreService;

	@Autowired
	private XpTrackerService xpTrackerService;

	@RequestMapping("/{endpoint}")
	public HiscoreResult lookup(@PathVariable HiscoreEndpoint endpoint, @RequestParam String username) throws ExecutionException
	{
		HiscoreResult result = hiscoreService.lookupUsername(username, endpoint);

		// Submit to xp tracker?
		switch (endpoint)
		{
			case NORMAL:
			case IRONMAN:
			case ULTIMATE_IRONMAN:
			case HARDCORE_IRONMAN:
				xpTrackerService.update(username, result);
		}

		return result;
	}

	@RequestMapping("/{endpoint}/{skillName}")
	public SingleHiscoreSkillResult singleSkillLookup(@PathVariable HiscoreEndpoint endpoint, @PathVariable String skillName, @RequestParam String username) throws ExecutionException
	{
		HiscoreSkill skill = HiscoreSkill.valueOf(skillName.toUpperCase());

		// RS api only supports looking up all stats
		HiscoreResult result = hiscoreService.lookupUsername(username, endpoint);

		// Find the skill to return
		Skill requested = result.getSkill(skill);

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
