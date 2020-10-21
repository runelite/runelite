/*
 * Copyright (c) 2020, Danno <https://github.com/rralyks>
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
import net.runelite.api.Skill;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CombatLevelOverlayTest
{

	@Inject
	CombatLevelOverlay overlay;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	CombatLevelConfig config;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testNoMaxedStats()
	{
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(75);

		String tooltip = overlay.getLevelsUntilTooltip();

		assertTrue(tooltip.contains("Attack"));
		assertTrue(tooltip.contains("Strength"));
		assertTrue(tooltip.contains("Defence"));
		assertTrue(tooltip.contains("Hitpoints"));
	}

	@Test
	public void testAllMaxedStats()
	{
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(99);

		String tooltip = overlay.getLevelsUntilTooltip();

		assertFalse(tooltip.contains("Attack"));
		assertFalse(tooltip.contains("Strength"));
		assertFalse(tooltip.contains("Defence"));
		assertFalse(tooltip.contains("Hitpoints"));
	}

	@Test
	public void testMaxedAttackStat()
	{
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(75);

		String tooltip = overlay.getLevelsUntilTooltip();

		assertFalse(tooltip.contains("Attack"));
		assertTrue(tooltip.contains("Strength"));
		assertTrue(tooltip.contains("Defence"));
		assertTrue(tooltip.contains("Hitpoints"));
	}

	@Test
	public void testMaxedStrengthStat()
	{
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(75);

		String tooltip = overlay.getLevelsUntilTooltip();

		assertTrue(tooltip.contains("Attack"));
		assertFalse(tooltip.contains("Strength"));
		assertTrue(tooltip.contains("Defence"));
		assertTrue(tooltip.contains("Hitpoints"));
	}

	@Test
	public void testMaxedDefenceStat()
	{
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(99);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(75);

		String tooltip = overlay.getLevelsUntilTooltip();

		assertTrue(tooltip.contains("Attack"));
		assertTrue(tooltip.contains("Strength"));
		assertFalse(tooltip.contains("Defence"));
		assertTrue(tooltip.contains("Hitpoints"));
	}

	@Test
	public void testMaxedHitpointsStat()
	{
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.DEFENCE)).thenReturn(75);
		when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(99);

		String tooltip = overlay.getLevelsUntilTooltip();

		assertTrue(tooltip.contains("Attack"));
		assertTrue(tooltip.contains("Strength"));
		assertTrue(tooltip.contains("Defence"));
		assertFalse(tooltip.contains("Hitpoints"));
	}

}
