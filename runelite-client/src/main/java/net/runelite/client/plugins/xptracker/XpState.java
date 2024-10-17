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

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.NonNull;
import net.runelite.api.NPC;
import net.runelite.api.Skill;

/**
 * Internal state for the XpTrackerPlugin
 * <p>
 * Note: This class's operations are not currently synchronized.
 * It is intended to be called by the XpTrackerPlugin on the client thread.
 */
class XpState
{
	private static final double DEFAULT_XP_MODIFIER = 4.0;
	private static final double SHARED_XP_MODIFIER = DEFAULT_XP_MODIFIER / 3.0;
	private final Map<Skill, XpStateSingle> xpSkills = new EnumMap<>(Skill.class);
	private XpStateSingle overall = new XpStateSingle(-1);
	private NPC interactedNPC;

	@Inject
	private XpTrackerConfig xpTrackerConfig;

	/**
	 * Destroys all internal state, however any XpSnapshotSingle or XpSnapshotTotal remain unaffected.
	 */
	void reset()
	{
		xpSkills.clear();
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

	private double getCombatXPModifier(Skill skill)
	{
		if (skill == Skill.HITPOINTS)
		{
			return SHARED_XP_MODIFIER;
		}

		return DEFAULT_XP_MODIFIER;
	}

	/**
	 * Updates skill with average actions based on currently interacted NPC.
	 *
	 * @param skill     experience gained skill
	 * @param npc       currently interacted NPC
	 * @param npcHealth health of currently interacted NPC
	 */
	void updateNpcExperience(Skill skill, NPC npc, Integer npcHealth, int xpModifier)
	{
		if (npc == null || npc.getCombatLevel() <= 0 || npcHealth == null)
		{
			return;
		}

		final XpStateSingle state = getSkill(skill);
		final int actionExp = (int) (npcHealth * getCombatXPModifier(skill) * xpModifier);
		final XpAction action = state.getXpAction(XpActionType.ACTOR_HEALTH);

		if (action.isActionsHistoryInitialized())
		{
			action.getActionExps()[action.getActionExpIndex()] = actionExp;

			if (interactedNPC != npc)
			{
				action.setActionExpIndex((action.getActionExpIndex() + 1) % action.getActionExps().length);
			}
		}
		else
		{
			// So we have a decent average off the bat, lets populate all values with what we see.
			Arrays.fill(action.getActionExps(), actionExp);

			action.setActionsHistoryInitialized(true);
		}

		interactedNPC = npc;
		state.setActionType(XpActionType.ACTOR_HEALTH);
	}

	/**
	 * Update number of actions performed for skill if last interacted NPC died.
	 * (eg. amount of kills in this case)
	 *
	 * @param skill     skill to update actions for
	 * @param npc       npc that just died
	 * @param npcHealth max health of npc that just died
	 * @return UPDATED in case new kill was successfully added
	 */
	XpUpdateResult updateNpcKills(Skill skill, NPC npc, Integer npcHealth)
	{
		XpStateSingle state = getSkill(skill);

		if (state.getXpGainedSinceReset() <= 0 || npcHealth == null || npc != interactedNPC)
		{
			return XpUpdateResult.NO_CHANGE;
		}

		final XpAction xpAction = state.getXpAction(XpActionType.ACTOR_HEALTH);
		xpAction.setActionsSinceReset(xpAction.getActionsSinceReset() + 1);
		return xpAction.isActionsHistoryInitialized() ? XpUpdateResult.UPDATED : XpUpdateResult.NO_CHANGE;
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
}
