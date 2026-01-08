/*
 * Copyright (c) 2021, Wright <eqomatic@gmail.com>
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
package net.runelite.client.plugins.xpglobes;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.api.events.StatChanged;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class XpGlobesPluginTest
{
	private static final int VIRTUAL_LEVEL_TOTAL_XP = Experience.getXpForLevel(Experience.MAX_REAL_LEVEL + 1);

	@Inject
	private XpGlobesPlugin xpGlobesPlugin;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private XpGlobesOverlay xpGlobesOverlay;

	@Mock
	@Bind
	private XpTrackerService xpTrackerService;

	@Mock
	@Bind
	private XpGlobesConfig xpGlobesConfig;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		statChanged(VIRTUAL_LEVEL_TOTAL_XP, Skill.AGILITY);
		assertTrue(xpGlobesPlugin.getXpGlobes().isEmpty());
	}

	@Test
	public void testVirtualLevelInGlobeIsNotShownByDefault()
	{
		when(xpGlobesConfig.showVirtualLevel()).thenReturn(false);

		statChanged(VIRTUAL_LEVEL_TOTAL_XP + 1, Skill.AGILITY);

		assertEquals(Experience.MAX_REAL_LEVEL, xpGlobesPlugin.getXpGlobes().get(0).getCurrentLevel());
	}

	@Test
	public void testVirtualLevelInGlobeIsShownWhenConfigured()
	{
		when(xpGlobesConfig.showVirtualLevel()).thenReturn(true);

		statChanged(VIRTUAL_LEVEL_TOTAL_XP + 1, Skill.AGILITY);

		assertEquals(Experience.getLevelForXp(VIRTUAL_LEVEL_TOTAL_XP + 1), xpGlobesPlugin.getXpGlobes().get(0).getCurrentLevel());
	}

	@Test
	public void testGlobeIsNotShownWhenHideMaxAndShowVirtualLevelConfigured()
	{
		when(xpGlobesConfig.hideMaxed()).thenReturn(true);
		lenient().when(xpGlobesConfig.showVirtualLevel()).thenReturn(true);

		statChanged(VIRTUAL_LEVEL_TOTAL_XP + 1, Skill.AGILITY);

		assertTrue(xpGlobesPlugin.getXpGlobes().isEmpty());
	}

	@Test
	public void testGlobeIsNotShownWhenHideMaxConfigured()
	{
		when(xpGlobesConfig.hideMaxed()).thenReturn(true);

		statChanged(VIRTUAL_LEVEL_TOTAL_XP + 1, Skill.AGILITY);

		assertTrue(xpGlobesPlugin.getXpGlobes().isEmpty());
	}

	@Test
	public void testGlobeIsShownOnXpGainBelowMaxWhenHideMaxConfigured()
	{
		lenient().when(xpGlobesConfig.hideMaxed()).thenReturn(true);

		int totalXp = 1;
		statChanged(totalXp, Skill.FARMING);
		assertTrue(xpGlobesPlugin.getXpGlobes().isEmpty());

		statChanged(totalXp + 150, Skill.FARMING);

		assertEquals(Experience.getLevelForXp(totalXp + 150), xpGlobesPlugin.getXpGlobes().get(0).getCurrentLevel());
	}

	@Test
	public void testStatChangesFromBoostDoNotAffectXpGlobes()
	{
		statChanged(VIRTUAL_LEVEL_TOTAL_XP, Skill.AGILITY, 5);

		assertTrue(xpGlobesPlugin.getXpGlobes().isEmpty());
	}

	private void statChanged(int totalXp, Skill skill)
	{
		statChanged(totalXp, skill, 0);
	}

	private void statChanged(int totalXp, Skill skill, int boostedLevel)
	{
		// A statChanged event uses the max real level
		int statChangedLevel = Math.min(Experience.getLevelForXp(totalXp), Experience.MAX_REAL_LEVEL);

		StatChanged firstStatChangedEvent = new StatChanged(
			skill,
			totalXp,
			statChangedLevel,
			boostedLevel
		);

		// The first xp change is cached
		xpGlobesPlugin.onStatChanged(firstStatChangedEvent);
	}
}
