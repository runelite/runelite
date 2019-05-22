/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.game;

import lombok.Value;

@Value
public class NPCStats
{
	private final String name;

	private final int hitpoints;
	private final int combatLevel;
	private final int slayerLevel;

	private final int attackLevel;
	private final int strengthLevel;
	private final int defenceLevel;
	private final int rangeLevel;
	private final int magicLevel;

	private final int stab;
	private final int slash;
	private final int crush;
	private final int range;
	private final int magic;

	private final int stabDef;
	private final int slashDef;
	private final int crushDef;
	private final int rangeDef;
	private final int magicDef;

	private final int bonusAttack;
	private final int bonusStrength;
	private final int bonusRangeStrength;
	private final int bonusMagicDamage;

	private final boolean poisonImmune;
	private final boolean venomImmune;

	private final boolean dragon;
	private final boolean demon;
	private final boolean undead;

	/**
	 * Based off the formula found here: http://services.runescape.com/m=forum/c=PLuJ4cy6gtA/forums.ws?317,318,712,65587452,209,337584542#209
	 * @return bonus XP modifier
	 */
	public double calculateXpModifier()
	{
		final double averageLevel = Math.floor((attackLevel + strengthLevel + defenceLevel + hitpoints) / 4);
		final double averageDefBonus = Math.floor((stabDef + slashDef + crushDef) / 3);

		return (1 + Math.floor(averageLevel * (averageDefBonus + bonusStrength + bonusAttack) / 5120) / 40);
	}
}