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

import java.util.EnumSet;
import java.util.Set;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum FiremakingAction implements ItemSkillAction
{
	SACRED_OIL_2(ItemID.SACRED_OIL2, "Applying Sacred oil(2)", 1, 10, FiremakingMethod.SACRED_OIL),
	SACRED_OIL_3(ItemID.SACRED_OIL3, "Applying Sacred oil(3)", 1, 12, FiremakingMethod.SACRED_OIL),
	SACRED_OIL_4(ItemID.SACRED_OIL4, "Applying Sacred oil(4)", 1, 16, FiremakingMethod.SACRED_OIL),
	ACHEY_TREE_LOGS(ItemID.ACHEY_TREE_LOGS, 1, 40, FiremakingMethod.NORMAL_LOGS),
	LOGS(ItemID.LOGS, 1, 40, FiremakingMethod.NORMAL_LOGS),
	PYRE_LOGS(ItemID.PYRE_LOGS, 5, 50, FiremakingMethod.PYRE_LOGS),
	OAK_LOGS(ItemID.OAK_LOGS, 15, 60, FiremakingMethod.NORMAL_LOGS),
	OAK_PYRE_LOGS(ItemID.OAK_PYRE_LOGS, 20, 70, FiremakingMethod.PYRE_LOGS),
	WILLOW_LOGS(ItemID.WILLOW_LOGS, 30, 90, FiremakingMethod.NORMAL_LOGS),
	WILLOW_PYRE_LOGS(ItemID.WILLOW_PYRE_LOGS, 35, 100, FiremakingMethod.PYRE_LOGS),
	TEAK_LOGS(ItemID.TEAK_LOGS, 35, 105, FiremakingMethod.NORMAL_LOGS),
	TEAK_PYRE_LOGS(ItemID.TEAK_PYRE_LOGS, 40, 120, FiremakingMethod.PYRE_LOGS),
	ARCTIC_PINE_LOGS(ItemID.ARCTIC_PINE_LOGS, 42, 125, FiremakingMethod.NORMAL_LOGS),
	MAPLE_LOGS(ItemID.MAPLE_LOGS, 45, 135, FiremakingMethod.NORMAL_LOGS),
	ARCTIC_PYRE_LOGS(ItemID.ARCTIC_PYRE_LOGS, 47, 158, FiremakingMethod.PYRE_LOGS),
	MAHOGANY_LOGS(ItemID.MAHOGANY_LOGS, 50, 157.5f, FiremakingMethod.NORMAL_LOGS),
	MAPLE_PYRE_LOGS(ItemID.MAPLE_PYRE_LOGS, 50, 175, FiremakingMethod.PYRE_LOGS),
	MAHOGANY_PYRE_LOGS(ItemID.MAHOGANY_PYRE_LOGS, 55, 210, FiremakingMethod.PYRE_LOGS),
	YEW_LOGS(ItemID.YEW_LOGS, 60, 202.5f, FiremakingMethod.NORMAL_LOGS),
	BLISTERWOOD_LOGS(ItemID.BLISTERWOOD_LOGS, 62, 96, FiremakingMethod.NORMAL_LOGS),
	YEW_PYRE_LOGS(ItemID.YEW_PYRE_LOGS, 65, 255, FiremakingMethod.PYRE_LOGS),
	MAGIC_LOGS(ItemID.MAGIC_LOGS, 75, 303.8f, FiremakingMethod.NORMAL_LOGS),
	MAGIC_PYRE_LOGS(ItemID.MAGIC_PYRE_LOGS, 80, 404.5f, FiremakingMethod.PYRE_LOGS),
	REDWOOD_LOGS(ItemID.REDWOOD_LOGS, 90, 350, FiremakingMethod.NORMAL_LOGS),
	REDWOOD_PYRE_LOGS(ItemID.REDWOOD_LOGS, 95, 500, FiremakingMethod.PYRE_LOGS),
	;

	private final int itemId;
	@Nullable
	private final String nameOverride;
	private final int level;
	private final float xp;
	private final FiremakingMethod firemakingMethod;

	FiremakingAction(final int itemId, final int level, final float xp, final FiremakingMethod firemakingMethod)
	{
		this(itemId, null, level, xp, firemakingMethod);
	}

	@Override
	public String getName(final ItemManager itemManager)
	{
		if (nameOverride != null)
		{
			return nameOverride;
		}

		return ItemSkillAction.super.getName(itemManager);
	}

	private enum FiremakingMethod
	{
		NORMAL_LOGS,
		PYRE_LOGS,
		SACRED_OIL,
	}

	@Override
	public Set<FiremakingBonus> getExcludedSkillBonuses()
	{
		switch (getFiremakingMethod())
		{
			case NORMAL_LOGS:
				return EnumSet.of(FiremakingBonus.MORYTANIA_ELITE_DIARY);
			case PYRE_LOGS:
				return EnumSet.complementOf(EnumSet.of(FiremakingBonus.MORYTANIA_ELITE_DIARY));
			default:
				return EnumSet.complementOf(EnumSet.of(FiremakingBonus.PYROMANCER_OUTFIT));
		}
	}
}
