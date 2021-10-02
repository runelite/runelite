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
public enum WoodcuttingAction implements NamedSkillAction
{
	LOGS("Logs", 1, 25, ItemID.LOGS),
	ACHEY_TREE_LOGS("Achey tree logs", 1, 25, ItemID.ACHEY_TREE_LOGS),
	OAK_LOGS("Oak logs", 15, 37.5f, ItemID.OAK_LOGS),
	WILLOW_LOGS("Willow logs", 30, 67.5f, ItemID.WILLOW_LOGS),
	TEAK_LOGS("Teak logs", 35, 85, ItemID.TEAK_LOGS),
	BARK("Bark", 45, 82.5f, ItemID.BARK),
	MAPLE_LOGS("Maple logs", 45, 100, ItemID.MAPLE_LOGS),
	MAHOGANY_LOGS("Mahogany logs", 50, 125, ItemID.MAHOGANY_LOGS),
	ARCTIC_PINE_LOGS("Arctic pine logs", 54, 40, ItemID.ARCTIC_PINE_LOGS),
	YEW_LOGS("Yew logs", 60, 175, ItemID.YEW_LOGS),
	BLISTERWOOD_LOGS("Blisterwood logs", 62, 76, ItemID.BLISTERWOOD_LOGS),
	SULLIUSCEPS("Sulliusceps", 65, 127, ItemID.SULLIUSCEP_CAP),
	MAGIC_LOGS("Magic logs", 75, 250, ItemID.MAGIC_LOGS),
	REDWOOD_LOGS("Redwood logs", 90, 380, ItemID.REDWOOD_LOGS),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
}
