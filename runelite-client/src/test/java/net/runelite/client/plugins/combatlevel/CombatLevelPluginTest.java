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
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.client.config.ConfigManager;
import static net.runelite.client.plugins.combatlevel.CombatLevelPlugin.COMBAT_SKILLS;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CombatLevelPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private CombatLevelConfig config;

	@Mock
	@Bind
	private ConfigManager configManager;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	private Player player;

	@Inject
	private CombatLevelPlugin plugin;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getLocalPlayer()).thenReturn(player);
	}

	private void postExperienceChangedEvents()
	{
		for (final Skill skill : COMBAT_SKILLS)
		{
			final int skillLevel = client.getRealSkillLevel(skill);
			when(client.getSkillExperience(skill)).thenReturn(Experience.getXpForLevel(skillLevel));

			final ExperienceChanged event = new ExperienceChanged();
			event.setSkill(skill);
			plugin.onExperienceChanged(event);
		}
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

		postExperienceChangedEvents();

		// test attack/strength
		assertEquals(2, plugin.levelsToCombat(Skill.ATTACK));
		assertEquals(2, plugin.levelsToCombat(Skill.STRENGTH));

		// test defence/hitpoints
		assertEquals(3, plugin.levelsToCombat(Skill.DEFENCE));
		assertEquals(3, plugin.levelsToCombat(Skill.HITPOINTS));

		// test prayer
		assertEquals(5, plugin.levelsToCombat(Skill.PRAYER));

		// test ranged
		assertEquals(2, plugin.levelsToCombat(Skill.RANGED));

		// test magic
		assertEquals(2, plugin.levelsToCombat(Skill.MAGIC));
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

		postExperienceChangedEvents();

		// test attack/strength
		assertEquals(1, plugin.levelsToCombat(Skill.ATTACK));
		assertEquals(1, plugin.levelsToCombat(Skill.STRENGTH));

		// test defence/hitpoints
		assertEquals(1, plugin.levelsToCombat(Skill.DEFENCE));
		assertEquals(1, plugin.levelsToCombat(Skill.HITPOINTS));

		// test prayer
		assertEquals(2, plugin.levelsToCombat(Skill.PRAYER));

		// test ranged
		assertEquals(4, plugin.levelsToCombat(Skill.RANGED));

		// test magic
		assertEquals(4, plugin.levelsToCombat(Skill.MAGIC));
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

		postExperienceChangedEvents();

		// test attack/strength
		assertEquals(2, plugin.levelsToCombat(Skill.ATTACK));
		assertEquals(2, plugin.levelsToCombat(Skill.STRENGTH));

		// test defence/hitpoints
		assertEquals(2, plugin.levelsToCombat(Skill.DEFENCE));
		assertEquals(2, plugin.levelsToCombat(Skill.HITPOINTS));

		// test prayer
		assertEquals(4, plugin.levelsToCombat(Skill.PRAYER));

		// test ranged
		assertEquals(17, plugin.levelsToCombat(Skill.RANGED));

		// test magic
		assertEquals(19, plugin.levelsToCombat(Skill.MAGIC));
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

		postExperienceChangedEvents();

		// test attack/strength
		assertEquals(18, plugin.levelsToCombat(Skill.ATTACK));
		assertEquals(18, plugin.levelsToCombat(Skill.STRENGTH));

		// test defence/hitpoints
		assertEquals(2, plugin.levelsToCombat(Skill.DEFENCE));
		assertEquals(2, plugin.levelsToCombat(Skill.HITPOINTS));

		// test prayer
		assertEquals(3, plugin.levelsToCombat(Skill.PRAYER));

		// test ranged
		assertEquals(14, plugin.levelsToCombat(Skill.RANGED));

		// test magic
		assertEquals(1, plugin.levelsToCombat(Skill.MAGIC));
	}

	@Test
	public void testPlayerZezima()
	{
		// snapshot of current stats 2018-10-3
		when(player.getCombatLevel()).thenReturn(90);
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(74);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(74);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(72);
		when(client.getRealSkillLevel(Skill.PRAYER)).thenReturn(52);
		when(client.getRealSkillLevel(Skill.RANGED)).thenReturn(44);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(60);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(72);

		postExperienceChangedEvents();

		// test attack/strength
		assertEquals(2, plugin.levelsToCombat(Skill.ATTACK));
		assertEquals(2, plugin.levelsToCombat(Skill.STRENGTH));

		// test defence/hitpoints
		assertEquals(2, plugin.levelsToCombat(Skill.DEFENCE));
		assertEquals(2, plugin.levelsToCombat(Skill.HITPOINTS));

		// test prayer
		assertEquals(4, plugin.levelsToCombat(Skill.PRAYER));

		// Zezima cannot earn a combat level from ranged/magic anymore, so it won't show as the result is too high
		final String tooltipText = plugin.getLevelsUntilTooltip().getText();
		assertFalse(tooltipText.contains("Ranged"));
		assertFalse(tooltipText.contains("Magic"));
	}

	@Test
	public void testPrayerLevelsNeeded()
	{
		when(player.getCombatLevel()).thenReturn(124);
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.PRAYER)).thenReturn(89);
		when(client.getRealSkillLevel(Skill.RANGED)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(99);

		postExperienceChangedEvents();

		assertEquals(1, plugin.levelsToCombat(Skill.PRAYER));
	}

	@Test
	public void testEvenPrayerLevelsNeededWhenNearNextCombatLevel()
	{
		when(player.getCombatLevel()).thenReturn(90);
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(74);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(72);
		when(client.getRealSkillLevel(Skill.PRAYER)).thenReturn(52);
		when(client.getRealSkillLevel(Skill.RANGED)).thenReturn(44);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(60);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(72);

		postExperienceChangedEvents();

		assertEquals(2, plugin.levelsToCombat(Skill.PRAYER));
	}

	@Test
	public void testOddPrayerLevelsNeededWhenNearNextCombatLevel()
	{
		when(player.getCombatLevel()).thenReturn(90);
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(74);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(72);
		when(client.getRealSkillLevel(Skill.PRAYER)).thenReturn(53);
		when(client.getRealSkillLevel(Skill.RANGED)).thenReturn(44);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(60);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(72);

		postExperienceChangedEvents();

		assertEquals(1, plugin.levelsToCombat(Skill.PRAYER));
	}
}
