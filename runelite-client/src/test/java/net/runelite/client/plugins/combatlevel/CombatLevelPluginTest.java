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

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import static net.runelite.client.plugins.combatlevel.CombatLevelOverlay.calcLevels;
import static net.runelite.client.plugins.combatlevel.CombatLevelOverlay.calcLevelsRM;
import static net.runelite.client.plugins.combatlevel.CombatLevelOverlay.correctPrayer;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.HashMap;

@RunWith(MockitoJUnitRunner.class)
public class CombatLevelPluginTest
{
	private static final double ATT_STR_MULT = 0.325;
	private static final double DEF_HP_MULT = 0.25;
	private static final double PRAY_MULT = 0.125;

	@Mock
	@Bind
	private Client client;

	@Mock
	private Player player;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getLocalPlayer()).thenReturn(player);
	}

	private HashMap<String, Double> getBaseValues() {
		int attackLevel = client.getRealSkillLevel(Skill.ATTACK);
		int strengthLevel = client.getRealSkillLevel(Skill.STRENGTH);
		int defenceLevel = client.getRealSkillLevel(Skill.DEFENCE);
		int hitpointsLevel = client.getRealSkillLevel(Skill.HITPOINTS);
		int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
		int rangedLevel = client.getRealSkillLevel(Skill.RANGED);
		int prayerLevel = client.getRealSkillLevel(Skill.PRAYER);

		double base = 0.25 * (defenceLevel + hitpointsLevel + Math.floor(prayerLevel / 2));
		double melee = 0.325 * (attackLevel + strengthLevel);
		double range = 0.325 * Math.floor(rangedLevel * 1.5);
		double mage = 0.325 * Math.floor(magicLevel * 1.5);
		double max = Math.max(melee, Math.max(range, mage));

		HashMap<String, Double> result = new HashMap<>();
		result.put("base", base);
		result.put("melee", melee);
		result.put("max", max);
		return result;
	}

	@Test
	public void testNewPlayer()
	{
		when(player.getCombatLevel()).thenReturn(3);
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(1);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(1);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(1);
		when(client.getRealSkillLevel(Skill.PRAYER)).thenReturn(1);
		when(client.getRealSkillLevel(Skill.RANGED)).thenReturn(1);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(1);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(10);

		HashMap<String, Double> baseValues = getBaseValues();

		// test attack/strength
		assertEquals(2, calcLevels(baseValues.get("base") + baseValues.get("melee"),
				player.getCombatLevel() + 1, ATT_STR_MULT));

		// test defence/hitpoints
		assertEquals(3, calcLevels(baseValues.get("base") + baseValues.get("max"),
				player.getCombatLevel() + 1, DEF_HP_MULT));

		// test prayer
		int prayNeed = calcLevels(baseValues.get("base") + baseValues.get("max"),
			player.getCombatLevel() + 1, PRAY_MULT);
		assertEquals(5, correctPrayer(client.getRealSkillLevel(Skill.PRAYER), prayNeed));

		// test ranged
		assertEquals(2, calcLevelsRM(client.getRealSkillLevel(Skill.RANGED),
			player.getCombatLevel() + 1, baseValues.get("base")));

		// test magic
		assertEquals(2, calcLevelsRM(client.getRealSkillLevel(Skill.MAGIC),
			player.getCombatLevel() + 1, baseValues.get("base")));
	}

	@Test
	public void testAll10()
	{
		when(player.getCombatLevel()).thenReturn(12);
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(10);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(10);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(10);
		when(client.getRealSkillLevel(Skill.PRAYER)).thenReturn(10);
		when(client.getRealSkillLevel(Skill.RANGED)).thenReturn(10);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(10);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(10);

		HashMap<String, Double> baseValues = getBaseValues();

		// test attack/strength
		assertEquals(1, calcLevels(baseValues.get("base") + baseValues.get("melee"),
			player.getCombatLevel() + 1, ATT_STR_MULT));

		// test defence/hitpoints
		assertEquals(1, calcLevels(baseValues.get("base") + baseValues.get("max"),
			player.getCombatLevel() + 1, DEF_HP_MULT));

		// test prayer
		int prayNeed = calcLevels(baseValues.get("base") + baseValues.get("max"),
			player.getCombatLevel() + 1, PRAY_MULT);
		assertEquals(2, correctPrayer(client.getRealSkillLevel(Skill.PRAYER), prayNeed));

		// test ranged
		assertEquals(4, calcLevelsRM(client.getRealSkillLevel(Skill.RANGED),
			player.getCombatLevel() + 1, baseValues.get("base")));

		// test magic
		assertEquals(4, calcLevelsRM(client.getRealSkillLevel(Skill.MAGIC),
			player.getCombatLevel() + 1, baseValues.get("base")));
	}

	@Test
	public void testPlayerBmid()
	{
		// snapshot of current stats 2018-10-2
		when(player.getCombatLevel()).thenReturn(83);
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(65);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(70);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(60);
		when(client.getRealSkillLevel(Skill.PRAYER)).thenReturn(56);
		when(client.getRealSkillLevel(Skill.RANGED)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(73);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(71);

		HashMap<String, Double> baseValues = getBaseValues();

		// test attack/strength
		assertEquals(2, calcLevels(baseValues.get("base") + baseValues.get("melee"),
			player.getCombatLevel() + 1, ATT_STR_MULT));

		// test defence/hitpoints
		assertEquals(2, calcLevels(baseValues.get("base") + baseValues.get("max"),
			player.getCombatLevel() + 1, DEF_HP_MULT));

		// test prayer
		int prayNeed = calcLevels(baseValues.get("base") + baseValues.get("max"),
			player.getCombatLevel() + 1, PRAY_MULT);
		assertEquals(4, correctPrayer(client.getRealSkillLevel(Skill.PRAYER), prayNeed));

		// test ranged
		assertEquals(17, calcLevelsRM(client.getRealSkillLevel(Skill.RANGED),
			player.getCombatLevel() + 1, baseValues.get("base")));

		// test magic
		assertEquals(19, calcLevelsRM(client.getRealSkillLevel(Skill.MAGIC),
			player.getCombatLevel() + 1, baseValues.get("base")));
	}

	@Test
	public void testPlayerRunelite()
	{
		// snapshot of current stats 2018-10-2
		when(player.getCombatLevel()).thenReturn(43);
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(43);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(36);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(1);
		when(client.getRealSkillLevel(Skill.PRAYER)).thenReturn(15);
		when(client.getRealSkillLevel(Skill.RANGED)).thenReturn(51);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(64);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(42);

		HashMap<String, Double> baseValues = getBaseValues();

		// test attack/strength
		assertEquals(18, calcLevels(baseValues.get("base") + baseValues.get("melee"),
			player.getCombatLevel() + 1, ATT_STR_MULT));

		// test defence/hitpoints
		assertEquals(2, calcLevels(baseValues.get("base") + baseValues.get("max"),
			player.getCombatLevel() + 1, DEF_HP_MULT));

		// test prayer
		int prayNeed = calcLevels(baseValues.get("base") + baseValues.get("max"),
			player.getCombatLevel() + 1, PRAY_MULT);
		assertEquals(3, correctPrayer(client.getRealSkillLevel(Skill.PRAYER), prayNeed));

		// test ranged
		assertEquals(14, calcLevelsRM(client.getRealSkillLevel(Skill.RANGED),
			player.getCombatLevel() + 1, baseValues.get("base")));

		// test magic
		assertEquals(1, calcLevelsRM(client.getRealSkillLevel(Skill.MAGIC),
			player.getCombatLevel() + 1, baseValues.get("base")));
	}

	@Test
	public void testPlayerZezima()
	{
		// snapshot of current stats 2018-10-3
		// Zezima cannot earn a combat level from ranged/magic anymore, so it won't show as the result is too high
		when(player.getCombatLevel()).thenReturn(90);
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(74);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(74);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(72);
		when(client.getRealSkillLevel(Skill.PRAYER)).thenReturn(52);
		when(client.getRealSkillLevel(Skill.RANGED)).thenReturn(44);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(60);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(72);

		HashMap<String, Double> baseValues = getBaseValues();

		// test attack/strength
		assertEquals(2, calcLevels(baseValues.get("base") + baseValues.get("melee"),
			player.getCombatLevel() + 1, ATT_STR_MULT));

		// test defence/hitpoints
		assertEquals(2, calcLevels(baseValues.get("base") + baseValues.get("max"),
			player.getCombatLevel() + 1, DEF_HP_MULT));

		// test prayer
		int prayNeed = calcLevels(baseValues.get("base") + baseValues.get("max"),
			player.getCombatLevel() + 1, PRAY_MULT);
		assertEquals(4, correctPrayer(client.getRealSkillLevel(Skill.PRAYER), prayNeed));
	}
}
