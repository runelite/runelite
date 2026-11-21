/*
 * Copyright (c) 2026, Matsyir <https://github.com/matsyir>
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
package net.runelite.client.plugins.boosts;

import java.util.HashMap;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.gameval.VarbitID;

// Essentially a wrapper to replace calls to client.getRealSkillLevel with, in order
// to return LMS' build levels instead if we are in an LMS match.
//
// use CombatLevelsProvider.getRealSkillLevel(client, skill) instead of client.getRealSkillLevel(skill)
public class CombatLevelsProvider
{
	private enum LmsBuildLevels
	{
		// https://oldschool.runescape.wiki/w/Last_Man_Standing#Gameplay
		LMS_MAXMED(0, 99, 99, 85, 99, 99),
		LMS_ZERK(1, 80, 99, 50, 99, 99),
		LMS_1DEF(2, 75, 99, 1, 99, 99);

		final int activeBuildVarbitVal;
		final HashMap<Skill, Integer> levels = new HashMap<>();
		LmsBuildLevels(int activeBuildVarbitVal, int atk, int str, int def, int range, int mage)
		{
			this.activeBuildVarbitVal = activeBuildVarbitVal;
			this.levels.put(Skill.ATTACK, atk);
			this.levels.put(Skill.STRENGTH, str);
			this.levels.put(Skill.DEFENCE, def);
			this.levels.put(Skill.RANGED, range);
			this.levels.put(Skill.MAGIC, mage);
		}

		public int get(Skill skill)
		{
			return this.levels.get(skill);
		}

		public boolean containsKey(Skill skill)
		{
			return this.levels.containsKey(skill);
		}


		static LmsBuildLevels getCurrent(Client client)
		{
			int val = isInLmsMatch(client) ? client.getVarbitValue(VarbitID.BR_ACTIVE_BUILD_PLAYER) : -1;

			return val == LmsBuildLevels.LMS_MAXMED.activeBuildVarbitVal ? LmsBuildLevels.LMS_MAXMED
				: val == LmsBuildLevels.LMS_ZERK.activeBuildVarbitVal ? LmsBuildLevels.LMS_ZERK
				: val == LmsBuildLevels.LMS_1DEF.activeBuildVarbitVal ? LmsBuildLevels.LMS_1DEF
				: null;
		}
	}

	public static int getRealSkillLevel(Client client, Skill skill)
	{
		LmsBuildLevels levels;
		if (isInLmsMatch(client) && (levels = LmsBuildLevels.getCurrent(client)) != null && levels.containsKey(skill))
		{
			return levels.get(skill);
		}

		return client.getRealSkillLevel(skill);
	}


	private static boolean isInLmsMatch(Client client)
	{
		return client.getVarbitValue(VarbitID.BR_INGAME) != 0;
	}

}
