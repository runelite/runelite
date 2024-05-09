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

@AllArgsConstructor
@Getter
public enum FiremakingAction implements ItemSkillAction
{
	ACHEY_TREE_LOGS(ItemID.ACHEY_TREE_LOGS, 1, 40),
	LOGS(ItemID.LOGS, 1, 40),
	OAK_LOGS(ItemID.OAK_LOGS, 15, 60),
	WILLOW_LOGS(ItemID.WILLOW_LOGS, 30, 90),
	TEAK_LOGS(ItemID.TEAK_LOGS, 35, 105),
	ARCTIC_PINE_LOGS(ItemID.ARCTIC_PINE_LOGS, 42, 125),
	MAPLE_LOGS(ItemID.MAPLE_LOGS, 45, 135),
	MAHOGANY_LOGS(ItemID.MAHOGANY_LOGS, 50, 157.5f),
	YEW_LOGS(ItemID.YEW_LOGS, 60, 202.5f),
	BLISTERWOOD_LOGS(ItemID.BLISTERWOOD_LOGS, 62, 96),
	MAGIC_LOGS(ItemID.MAGIC_LOGS, 75, 303.8f),
	REDWOOD_LOGS(ItemID.REDWOOD_LOGS, 90, 350),
	;

	private final int itemId;
	private final int level;
	private final float xp;
}
