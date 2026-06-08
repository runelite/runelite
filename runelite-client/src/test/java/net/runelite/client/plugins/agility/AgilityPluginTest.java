/*
 * Copyright (c) 2026, Jordan Atwood <nightfirecat@nightfirec.at>
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
package net.runelite.client.plugins.agility;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Player;
import static net.runelite.api.Skill.AGILITY;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.StatChanged;
import net.runelite.client.Notifier;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AgilityPluginTest
{
	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	AgilityConfig config;

	@Mock
	@Bind
	XpTrackerService xpTrackerService;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	Notifier notifier;

	@Mock
	@Bind
	ItemManager itemManager;

	@Inject
	AgilityPlugin plugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testLevelUpMidCourse()
	{
		when(config.showLapCount()).thenReturn(true);
		final Player localPlayer = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(localPlayer);

		final WorldPoint gnomeCourseNonEndpoint = WorldPoint.fromRegion(Courses.GNOME.getRegionId(), 0, 0, 0);
		final Map<Integer, WorldPoint> xpWorldPoints = new LinkedHashMap<>();
		xpWorldPoints.put(208, gnomeCourseNonEndpoint);                      // 1 lap complete, just before final obstacle of second lap--starting at level 3
		xpWorldPoints.put(266, Courses.GNOME.getCourseEndWorldPoints()[0]);  // 2 laps complete
		xpWorldPoints.put(276, gnomeCourseNonEndpoint);                      // 2 laps and one obstacle complete--just enough for level 4

		for (Map.Entry<Integer, WorldPoint> xpWorldPoint : xpWorldPoints.entrySet())
		{
			final int xp = xpWorldPoint.getKey();
			final WorldPoint worldPoint = xpWorldPoint.getValue();
			final int level = Experience.getLevelForXp(xp);
			final StatChanged statChanged = new StatChanged(AGILITY, xp, level, level);
			when(client.getSkillExperience(AGILITY)).thenReturn(xp);
			when(localPlayer.getWorldLocation()).thenReturn(worldPoint);
			when(xpTrackerService.getEndGoalXp(AGILITY)).thenReturn(Experience.getXpForLevel(level + 1));
			plugin.onStatChanged(statChanged);
		}

		assertEquals(2, plugin.getSession().getLapsTillGoal());
	}
}
