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

import java.util.EnumMap;
import java.util.Map;
import lombok.NonNull;
import net.runelite.api.Skill;

/**
 * Internal state for the XpTrackerPlugin
 *
 * Note: This class's operations are not currently synchronized.
 * It is intended to be called by the XpTrackerPlugin on the client thread.
 */
class XpState
{
	private final XpStateTotal xpTotal = new XpStateTotal();
	private final Map<Skill, XpStateSingle> xpSkills = new EnumMap<>(Skill.class);

	/**
	 * Destroys all internal state, however any XpSnapshotSingle or XpSnapshotTotal remain unaffected.
	 */
	void reset()
	{
		xpTotal.reset();
		xpSkills.clear();
	}

	/**
	 * Resets a single skill
	 * @param skill Skill to reset
	 * @param currentXp Current XP to set to, if unknown set to -1
	 */
	void resetSkill(Skill skill, int currentXp)
	{
		xpSkills.remove(skill);
		xpSkills.put(skill, new XpStateSingle(skill, currentXp));
		recalculateTotal();
	}

	/**
	 * Calculates the total skill changes observed in this session or since the last reset
	 */
	void recalculateTotal()
	{
		xpTotal.reset();

		for (XpStateSingle state : xpSkills.values())
		{
			xpTotal.addXpGainedInSession(state.getXpGained());
			xpTotal.addXpPerHour(state.getXpHr());
		}
	}

	/**
	 * Updates a skill with the current known XP.
	 * When the result of this operation is XpUpdateResult.UPDATED, the UI should be updated accordingly.
	 * This is to distinguish events that reload all the skill's current values (such as world hopping)
	 * and also first-login when the skills are not initialized (the start XP will be -1 in this case).
	 * @param skill Skill to update
	 * @param currentXp Current known XP for this skill
	 * @return Whether or not the skill has been initialized, there was no change, or it has been updated
	 */
	XpUpdateResult updateSkill(Skill skill, int currentXp)
	{
		XpStateSingle state = getSkill(skill);

		if (state.getStartXp() == -1)
		{
			if (currentXp > 0)
			{
				initializeSkill(skill, currentXp);
				return XpUpdateResult.INITIALIZED;
			}
			else
			{
				return XpUpdateResult.NO_CHANGE;
			}
		}
		else
		{
			int startXp = state.getStartXp();
			int gainedXp = state.getXpGained();

			if (startXp + gainedXp > currentXp)
			{
				// Reinitialize with lesser currentXp, this can happen with negative xp lamps
				initializeSkill(skill, currentXp);
				return XpUpdateResult.INITIALIZED;
			}
			else
			{
				return state.update(currentXp) ? XpUpdateResult.UPDATED : XpUpdateResult.NO_CHANGE;
			}
		}
	}

	/**
	 * Forcefully initialize a skill with a known start XP from the current XP.
	 * This is used in resetAndInitState by the plugin. It should not result in showing the XP in the UI.
	 * @param skill Skill to initialize
	 * @param currentXp Current known XP for the skill
	 */
	void initializeSkill(Skill skill, int currentXp)
	{
		xpSkills.put(skill, new XpStateSingle(skill, currentXp));
	}

	@NonNull
	private XpStateSingle getSkill(Skill skill)
	{
		return xpSkills.computeIfAbsent(skill, (s) -> new XpStateSingle(s, -1));
	}

	/**
	 * Obtain an immutable snapshot of the provided skill
	 * intended for use with the UI which operates on another thread
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
	 * @return An immutable snapshot of total information for this session since first login or last reset
	 */
	@NonNull
	XpSnapshotTotal getTotalSnapshot()
	{
		return xpTotal.snapshot();
	}
}
