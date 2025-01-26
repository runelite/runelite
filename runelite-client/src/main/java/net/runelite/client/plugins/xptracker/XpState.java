/*
 * Copyright (c) 2018, Levi <me@levischuck.com>
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

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.NonNull;
import net.runelite.api.Skill;

/**
 * Internal state for the XpTrackerPlugin
 */
class XpState
{
	private final Map<Skill, XpStateSingle> xpSkills = new EnumMap<>(Skill.class);
	// this is keeping a copy of the panel skill order so that serialization keeps the order
	private final List<Skill> order = new ArrayList<>(Skill.values().length);
	private XpStateSingle overall = new XpStateSingle(-1);

	@Inject
	private XpTrackerConfig xpTrackerConfig;

	/**
	 * Destroys all internal state, however any XpSnapshotSingle or XpSnapshotTotal remain unaffected.
	 */
	void reset()
	{
		xpSkills.clear();
		order.clear();
		overall = new XpStateSingle(-1);
	}

	/**
	 * Resets the per hour rates of a single skill
	 *
	 * @param skill Skill to reset per hour rates
	 */
	void resetSkillPerHour(Skill skill)
	{
		xpSkills.get(skill).resetPerHour();
	}

	void resetOverallPerHour()
	{
		overall.resetPerHour();
	}

	/**
	 * Updates a skill with the current known XP.
	 * When the result of this operation is XpUpdateResult.UPDATED, the UI should be updated accordingly.
	 * This is to distinguish events that reload all the skill's current values (such as world hopping)
	 * and also first-login when the skills are not initialized (the start XP will be -1 in this case).
	 *
	 * @param skill       Skill to update
	 * @param currentXp   Current known XP for this skill
	 * @param goalStartXp Possible XP start goal
	 * @param goalEndXp   Possible XP end goal
	 * @return Whether or not the skill has been initialized, there was no change, or it has been updated
	 */
	XpUpdateResult updateSkill(Skill skill, long currentXp, int goalStartXp, int goalEndXp)
	{
		XpStateSingle state = xpSkills.get(skill);

		if (state == null || state.getStartXp() == -1)
		{
			assert currentXp >= 0;
			initializeSkill(skill, currentXp);
			return XpUpdateResult.INITIALIZED;
		}
		else
		{
			long startXp = state.getStartXp();
			int gainedXp = state.getTotalXpGained();

			if (startXp + gainedXp > currentXp)
			{
				// Reinitialize with lesser currentXp, this can happen with negative xp lamps
				initializeSkill(skill, currentXp);
				return XpUpdateResult.INITIALIZED;
			}
			else
			{
				if (!state.update(currentXp))
				{
					return XpUpdateResult.NO_CHANGE;
				}

				state.updateGoals(currentXp, goalStartXp, goalEndXp);
				updateOrder(skill);
				return XpUpdateResult.UPDATED;
			}
		}
	}

	void updateOverall(long currentXp)
	{
		if (overall == null || overall.getStartXp() + overall.getTotalXpGained() > currentXp)
		{
			overall = new XpStateSingle(currentXp);
		}
		else
		{
			overall.update(currentXp);
		}
	}

	void tick(Skill skill, long delta)
	{
		final XpStateSingle state = getSkill(skill);
		tick(state, delta);
	}

	void tickOverall(long delta)
	{
		tick(overall, delta);
	}

	private void tick(XpStateSingle state, long delta)
	{
		state.tick(delta);

		int resetAfterMinutes = xpTrackerConfig.resetSkillRateAfter();
		if (resetAfterMinutes > 0)
		{
			final long now = System.currentTimeMillis();
			final int resetAfterMillis = resetAfterMinutes * 60 * 1000;
			final long lastChangeMillis = state.getLastChangeMillis();
			// When pauseSkillAfter is 0, it is effectively disabled
			if (lastChangeMillis != 0 && (now - lastChangeMillis) >= resetAfterMillis)
			{
				state.resetPerHour();
			}
		}
	}

	/**
	 * Forcefully initialize a skill with a known start XP from the current XP.
	 * This is used in resetAndInitState by the plugin. It should not result in showing the XP in the UI.
	 *
	 * @param skill     Skill to initialize
	 * @param currentXp Current known XP for the skill
	 */
	void initializeSkill(Skill skill, long currentXp)
	{
		xpSkills.put(skill, new XpStateSingle(currentXp));
	}

	void initializeOverall(long currentXp)
	{
		overall = new XpStateSingle(currentXp);
	}

	boolean isInitialized(Skill skill)
	{
		XpStateSingle xpStateSingle = xpSkills.get(skill);
		return xpStateSingle != null && xpStateSingle.getStartXp() != -1;
	}

	boolean isOverallInitialized()
	{
		return overall.getStartXp() != -1;
	}

	@NonNull
	XpStateSingle getSkill(Skill skill)
	{
		return xpSkills.computeIfAbsent(skill, (s) -> new XpStateSingle(-1));
	}

	/**
	 * Obtain an immutable snapshot of the provided skill
	 * intended for use with the UI which operates on another thread
	 *
	 * @param skill Skill to obtain the snapshot for
	 * @return An immutable snapshot of the specified skill for this session since first login or last reset
	 */
	@NonNull
	XpSnapshotSingle getSkillSnapshot(Skill skill)
	{
		return getSkill(skill).snapshot();
	}

	/**
	 * Obtain an immutable snapshot of the provided skill
	 * intended for use with the UI which operates on another thread
	 *
	 * @return An immutable snapshot of total information for this session since first login or last reset
	 */
	@NonNull
	XpSnapshotSingle getTotalSnapshot()
	{
		return overall.snapshot();
	}

	private void updateOrder(Skill skill)
	{
		if (xpTrackerConfig.prioritizeRecentXpSkills())
		{
			int idx = order.indexOf(skill);
			if (idx != 0)
			{
				order.remove(skill);
				order.add(0, skill);
			}
		}
		else
		{
			if (!order.contains(skill))
			{
				order.add(skill);
			}
		}
	}

	XpSave save()
	{
		if (overall.getStartXp() == -1)
		{
			return null;
		}

		XpSave save = new XpSave();
		for (Skill skill : order)
		{
			XpStateSingle state = xpSkills.get(skill);
			if (state.getTotalXpGained() > 0)
			{
				save.skills.put(skill, state.save());
			}
		}
		save.overall = overall.save();
		return save;
	}

	void restore(XpSave save)
	{
		reset();

		for (Map.Entry<Skill, XpSaveSingle> entry : save.skills.entrySet())
		{
			Skill skill = entry.getKey();
			XpSaveSingle s = entry.getValue();
			XpStateSingle state = new XpStateSingle(s.startXp);
			state.restore(s);
			xpSkills.put(skill, state);
			order.add(skill);
		}
		overall.restore(save.overall);
	}
}
