/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;

import java.util.EnumSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public enum FiremakingAction implements NamedSkillAction
{
	MAKING_PYRE_LOGS_2_DOSE("Making pyre logs (2 dose)", 1, 10, ItemID.SACRED_OIL2, FiremakingMethod.SACRED_OIL),
	MAKING_PYRE_LOGS_3_DOSE("Making pyre logs (3 dose)", 1, 12, ItemID.SACRED_OIL3, FiremakingMethod.SACRED_OIL),
	MAKING_PYRE_LOGS_4_DOSE("Making pyre logs (3 dose)", 1, 16,ItemID.SACRED_OIL4, FiremakingMethod.SACRED_OIL),
	ACHEY_TREE_LOGS("Achey tree logs", 1, 40, ItemID.ACHEY_TREE_LOGS, FiremakingMethod.NORMAL_LOGS),
	LOGS("Logs", 1, 40, ItemID.LOGS, FiremakingMethod.NORMAL_LOGS),
	PYRE_LOGS("Pyre logs", 5, 50, ItemID.PYRE_LOGS, FiremakingMethod.PYRE_LOGS),
	OAK_LOGS("Oak logs", 15, 60, ItemID.OAK_LOGS, FiremakingMethod.NORMAL_LOGS),
	OAK_PYRE_LOGS("Oak pyre logs", 20, 70, ItemID.OAK_PYRE_LOGS, FiremakingMethod.PYRE_LOGS),
	WILLOW_LOGS("Willow logs", 30, 90, ItemID.WILLOW_LOGS, FiremakingMethod.NORMAL_LOGS),
	WILLOW_PYRE_LOGS("Willow pyre logs", 35, 100, ItemID.WILLOW_PYRE_LOGS, FiremakingMethod.PYRE_LOGS),
	TEAK_LOGS("Teak logs", 35, 105, ItemID.TEAK_LOGS, FiremakingMethod.NORMAL_LOGS),
	TEAK_PYRE_LOGS("Teak pyre logs", 40, 120, ItemID.TEAK_PYRE_LOGS, FiremakingMethod.PYRE_LOGS),
	ARCTIC_PINE_LOGS("Arctic pine logs", 42, 125, ItemID.ARCTIC_PINE_LOGS, FiremakingMethod.NORMAL_LOGS),
	MAPLE_LOGS("Maple logs", 45, 135, ItemID.MAPLE_LOGS, FiremakingMethod.NORMAL_LOGS),
	ARCTIC_PYRE_LOGS("Arctic pyre logs", 47, 158, ItemID.ARCTIC_PYRE_LOGS, FiremakingMethod.PYRE_LOGS),
	MAHOGANY_LOGS("Mahogany logs", 50, 157.5f, ItemID.MAHOGANY_LOGS, FiremakingMethod.NORMAL_LOGS),
	MAPLE_PYRE_LOGS("Maple pyre logs", 50, 175, ItemID.MAPLE_PYRE_LOGS, FiremakingMethod.PYRE_LOGS),
	MAHOGANY_PYRE_LOGS("Mahogany pyre logs", 55, 210, ItemID.MAHOGANY_PYRE_LOGS, FiremakingMethod.PYRE_LOGS),
	YEW_LOGS("Yew logs", 60, 202.5f, ItemID.YEW_LOGS, FiremakingMethod.NORMAL_LOGS),
	BLISTERWOOD_LOGS("Blisterwood logs", 62, 96, ItemID.BLISTERWOOD_LOGS, FiremakingMethod.NORMAL_LOGS),
	YEW_PYRE_LOGS("Yew pyre logs", 65, 255, ItemID.YEW_PYRE_LOGS, FiremakingMethod.PYRE_LOGS),
	MAGIC_LOGS("Magic logs", 75, 303.8f, ItemID.MAGIC_LOGS, FiremakingMethod.NORMAL_LOGS),
	MAGIC_PYRE_LOGS("Magic pyre logs", 80, 404.5f, ItemID.MAGIC_PYRE_LOGS, FiremakingMethod.PYRE_LOGS),
	REDWOOD_LOGS("Redwood logs", 90, 350, ItemID.REDWOOD_LOGS, FiremakingMethod.NORMAL_LOGS),
	REDWOOD_PYRE_LOGS("Redwood pyre logs", 95, 500, ItemID.REDWOOD_LOGS, FiremakingMethod.PYRE_LOGS),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
	private final FiremakingMethod firemakingMethod;

	@Override
	public boolean isMembers(final ItemManager itemManager)
	{
		return true;
	}

	private enum FiremakingMethod
	{
		NORMAL_LOGS,
		PYRE_LOGS,
		SACRED_OIL
	}

	@Override
	public Set<FiremakingBonus> getExcludedSkillBonuses()
	{
		switch (getFiremakingMethod())
		{
			case NORMAL_LOGS:
				return EnumSet.of(FiremakingBonus.MORYTANIA_ELITE_DIARY);
			case PYRE_LOGS:
				return EnumSet.of(FiremakingBonus.PYROMANCER_OUTFIT, FiremakingBonus.FORESTERS_CAMPFIRE);
			default:
				return EnumSet.allOf(FiremakingBonus.class);
		}
	}
}
