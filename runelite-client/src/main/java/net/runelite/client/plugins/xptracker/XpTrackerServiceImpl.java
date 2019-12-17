/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.xptracker;

import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Skill;

@Singleton
class XpTrackerServiceImpl implements XpTrackerService
{
	private final XpTrackerPlugin plugin;

	@Inject
	XpTrackerServiceImpl(XpTrackerPlugin plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public int getActions(Skill skill)
	{
		return plugin.getSkillSnapshot(skill).getActionsInSession();
	}

	@Override
	public int getActionsHr(Skill skill)
	{
		return plugin.getSkillSnapshot(skill).getActionsPerHour();
	}

	@Override
	public int getActionsLeft(Skill skill)
	{
		return plugin.getSkillSnapshot(skill).getActionsRemainingToGoal();
	}

	@Override
	public XpActionType getActionType(Skill skill)
	{
		return plugin.getSkillSnapshot(skill).getActionType();
	}

	@Override
	public int getXpHr(Skill skill)
	{
		return plugin.getSkillSnapshot(skill).getXpPerHour();
	}

	@Override
	public int getStartGoalXp(Skill skill)
	{
		return plugin.getSkillSnapshot(skill).getStartGoalXp();
	}

	@Override
	public int getEndGoalXp(Skill skill)
	{
		return plugin.getSkillSnapshot(skill).getEndGoalXp();
	}
}
