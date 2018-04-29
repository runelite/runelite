/*
 * Copyright (c) 2018, Desetude <harry@desetude.com>
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
package net.runelite.client.plugins.skillsessions.skillsessions;

import lombok.Getter;
import net.runelite.api.AgilityCourse;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.client.plugins.skillsessions.SkillSession;
import net.runelite.client.plugins.skillsessions.SkillSessionsConfig;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.time.Duration;
import java.time.Instant;

public class AgilitySkillSession extends SkillSession
{
	@Getter
	private final AgilityCourse course;
	private int totalLaps;
	private int lapsTillLevel;

	public AgilitySkillSession(AgilityCourse course)
	{
		super(Skill.AGILITY);
		this.course = course;
	}

	public void incrementLapCount(Client client)
	{
		++totalLaps;

		int currentExp = client.getSkillExperience(Skill.AGILITY);
		int nextLevel = client.getRealSkillLevel(Skill.AGILITY) + 1;
		int remainingXp = nextLevel <= Experience.MAX_VIRT_LEVEL ? Experience.getXpForLevel(nextLevel) - currentExp : 0;

		lapsTillLevel = remainingXp > 0 ? (int) Math.ceil(remainingXp / course.getTotalXp()) : 0;
	}

	@Override
	public boolean shouldDisplay(SkillSessionsConfig config)
	{
		return config.showAgility();
	}

	@Override
	public boolean isInAction(Client client)
	{
		return Duration.between(lastAction, Instant.now()).getSeconds() <= 30;
	}

	@Override
	public String getActionName()
	{
		return "Total laps";
	}

	@Override
	public int getActions()
	{
		return totalLaps;
	}

	@Override
	public void modifyPanel(PanelComponent panelComponent, Client client)
	{
		super.modifyPanel(panelComponent, client);
		if (lapsTillLevel > 0)
		{
			panelComponent.getLines().add(new PanelComponent.Line(
					"Laps till level:",
					Integer.toString(lapsTillLevel)
			));
		}
	}
}
