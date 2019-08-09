/*
 * Copyright (c) 2018, Brett Middle <https://github.com/bmiddle>
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
package net.runelite.client.plugins.combatlevel;

import net.runelite.api.Experience;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CombatLevelPluginTest
{
	@Test
	public void testNewPlayer()
	{
		int attackLevel = 1;
		int strengthLevel = 1;
		int defenceLevel = 1;
		int hitpointsLevel = 10;
		int magicLevel = 1;
		int rangeLevel = 1;
		int prayerLevel = 1;

		int combatLevel = Experience.getCombatLevel(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int meleeNeed = Experience.getNextCombatLevelMelee(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int hpDefNeed = Experience.getNextCombatLevelHpDef(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int rangeNeed = Experience.getNextCombatLevelRange(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int magicNeed = Experience.getNextCombatLevelMagic(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// test combat level
		assertEquals(3, combatLevel);

		// test attack/strength
		assertEquals(2, meleeNeed);

		// test defence/hitpoints
		assertEquals(3, hpDefNeed);

		// test ranged
		assertEquals(2, rangeNeed);

		// test magic
		assertEquals(2, magicNeed);

		// test prayer
		assertEquals(5, prayerNeed);
	}

	@Test
	public void testAll10()
	{
		int attackLevel = 10;
		int strengthLevel = 10;
		int defenceLevel = 10;
		int hitpointsLevel = 10;
		int magicLevel = 10;
		int rangeLevel = 10;
		int prayerLevel = 10;

		int combatLevel = Experience.getCombatLevel(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int meleeNeed = Experience.getNextCombatLevelMelee(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int hpDefNeed = Experience.getNextCombatLevelHpDef(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int rangeNeed = Experience.getNextCombatLevelRange(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int magicNeed = Experience.getNextCombatLevelMagic(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// test combat level
		assertEquals(12, combatLevel);

		// test attack/strength
		assertEquals(1, meleeNeed);

		// test defence/hitpoints
		assertEquals(1, hpDefNeed);

		// test ranged
		assertEquals(4, rangeNeed);

		// test magic
		assertEquals(4, magicNeed);

		// test prayer
		assertEquals(2, prayerNeed);
	}

	@Test
	public void testPlayerBmid()
	{
		// snapshot of current stats 2018-10-2
		int attackLevel = 65;
		int strengthLevel = 70;
		int defenceLevel = 60;
		int hitpointsLevel = 71;
		int magicLevel = 73;
		int rangeLevel = 75;
		int prayerLevel = 56;

		int combatLevel = Experience.getCombatLevel(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int meleeNeed = Experience.getNextCombatLevelMelee(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int hpDefNeed = Experience.getNextCombatLevelHpDef(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int rangeNeed = Experience.getNextCombatLevelRange(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int magicNeed = Experience.getNextCombatLevelMagic(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// test combat level
		assertEquals(83, combatLevel);

		// test attack/strength
		assertEquals(2, meleeNeed);

		// test defence/hitpoints
		assertEquals(2, hpDefNeed);

		// test ranged
		assertEquals(17, rangeNeed);

		// test magic
		assertEquals(19, magicNeed);

		// test prayer
		assertEquals(4, prayerNeed);
	}

	@Test
	public void testPlayerRunelite()
	{
		// snapshot of current stats 2018-10-2
		int attackLevel = 43;
		int strengthLevel = 36;
		int defenceLevel = 1;
		int hitpointsLevel = 42;
		int magicLevel = 64;
		int rangeLevel = 51;
		int prayerLevel = 15;

		int combatLevel = Experience.getCombatLevel(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int meleeNeed = Experience.getNextCombatLevelMelee(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int hpDefNeed = Experience.getNextCombatLevelHpDef(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int rangeNeed = Experience.getNextCombatLevelRange(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int magicNeed = Experience.getNextCombatLevelMagic(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// test combat level
		assertEquals(43, combatLevel);

		// test attack/strength
		assertEquals(18, meleeNeed);

		// test defence/hitpoints
		assertEquals(2, hpDefNeed);

		// test ranged
		assertEquals(14, rangeNeed);

		// test magic
		assertEquals(1, magicNeed);

		// test prayer
		assertEquals(3, prayerNeed);
	}

	@Test
	public void testPlayerZezima()
	{
		// snapshot of current stats 2018-10-3
		// Zezima cannot earn a combat level from ranged/magic anymore, so it won't show as the result is too high
		int attackLevel = 74;
		int strengthLevel = 74;
		int defenceLevel = 72;
		int hitpointsLevel = 72;
		int magicLevel = 60;
		int rangeLevel = 44;
		int prayerLevel = 52;

		int combatLevel = Experience.getCombatLevel(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int meleeNeed = Experience.getNextCombatLevelMelee(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int hpDefNeed = Experience.getNextCombatLevelHpDef(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// test combat level
		assertEquals(90, combatLevel);

		// test attack/strength
		assertEquals(2, meleeNeed);

		// test defence/hitpoints
		assertEquals(2, hpDefNeed);

		// test prayer
		assertEquals(4, prayerNeed);
	}

	@Test
	public void testPrayerLevelsNeeded()
	{
		int attackLevel = 99;
		int strengthLevel = 99;
		int defenceLevel = 99;
		int hitpointsLevel = 99;
		int magicLevel = 99;
		int rangeLevel = 99;
		int prayerLevel = 89;

		int combatLevel = Experience.getCombatLevel(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// test combat level
		assertEquals(124, combatLevel);

		// test prayer
		assertEquals(1, prayerNeed);
	}

	@Test
	public void testEvenPrayerLevelsNeededWhenNearNextCombatLevel()
	{
		int attackLevel = 74;
		int strengthLevel = 75;
		int defenceLevel = 72;
		int hitpointsLevel = 72;
		int magicLevel = 60;
		int rangeLevel = 44;
		int prayerLevel = 52;

		int combatLevel = Experience.getCombatLevel(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// test combat level
		assertEquals(90, combatLevel);

		// test prayer
		assertEquals(2, prayerNeed);
	}

	@Test
	public void testOddPrayerLevelsNeededWhenNearNextCombatLevel()
	{
		int attackLevel = 74;
		int strengthLevel = 75;
		int defenceLevel = 72;
		int hitpointsLevel = 72;
		int magicLevel = 60;
		int rangeLevel = 44;
		int prayerLevel = 53;

		int combatLevel = Experience.getCombatLevel(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// test combat level
		assertEquals(90, combatLevel);

		// test prayer
		assertEquals(1, prayerNeed);
	}

	@Test
	public void testNextMagicLevelBarelyReachesNextCombatLevel()
	{
		int attackLevel = 40;
		int strengthLevel = 44;
		int defenceLevel = 46;
		int hitpointsLevel = 39;
		int magicLevel = 57;
		int rangeLevel = 40;
		int prayerLevel = 29;

		int combatLevel = Experience.getCombatLevel(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int meleeNeed = Experience.getNextCombatLevelMelee(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int hpDefNeed = Experience.getNextCombatLevelHpDef(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int rangeNeed = Experience.getNextCombatLevelRange(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int magicNeed = Experience.getNextCombatLevelMagic(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// test combat level
		assertEquals(52, combatLevel);

		// test attack/strength
		assertEquals(3, meleeNeed);

		// test defence/hitpoints
		assertEquals(3, hpDefNeed);

		// test ranged
		assertEquals(18, rangeNeed);

		// test magic
		assertEquals(1, magicNeed);

		// test prayer
		assertEquals(5, prayerNeed);
	}

	@Test
	public void testRangeMagicLevelsNeeded()
	{
		int attackLevel = 60;
		int strengthLevel = 69;
		int defenceLevel = 1;
		int hitpointsLevel = 78;
		int magicLevel = 85;
		int rangeLevel = 85;
		int prayerLevel = 52;

		int combatLevel = Experience.getCombatLevel(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int meleeNeed = Experience.getNextCombatLevelMelee(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int hpDefNeed = Experience.getNextCombatLevelHpDef(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int rangeNeed = Experience.getNextCombatLevelRange(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int magicNeed = Experience.getNextCombatLevelMagic(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// test combat level
		assertEquals(68, combatLevel);

		// test attack/strength
		assertEquals(3, meleeNeed);

		// test defence/hitpoints
		assertEquals(4, hpDefNeed);

		// test ranged
		assertEquals(3, rangeNeed);

		// test magic
		assertEquals(3, magicNeed);

		// test prayer
		assertEquals(8, prayerNeed);
	}
}
