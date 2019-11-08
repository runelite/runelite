/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.xptracker;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.StatChanged;
import net.runelite.client.config.OpenOSRSConfig;
import net.runelite.client.game.NPCManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class XpTrackerPluginTest
{
	@Inject
	private XpTrackerPlugin xpTrackerPlugin;

	@Mock
	@Bind
	private ClientToolbar clientToolbar;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private SkillIconManager skillIconManager;

	@Mock
	@Bind
	private XpTrackerConfig xpTrackerConfig;

	@Mock
	@Bind
	private NPCManager npcManager;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private OpenOSRSConfig openOSRSConfig;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getLocalPlayer()).thenReturn(mock(Player.class));

		xpTrackerPlugin.setXpPanel(mock(XpPanel.class));
	}

	@Test
	public void testOfflineXp()
	{
		GameStateChanged gameStateChanged = new GameStateChanged();
		gameStateChanged.setGameState(GameState.LOGGING_IN);

		// Flag initialization of tracker
		xpTrackerPlugin.onGameStateChanged(gameStateChanged);
		when(client.getSkillExperience(Skill.ATTACK)).thenReturn(42);
		// Initialize tracker
		xpTrackerPlugin.onGameTick(GameTick.INSTANCE);

		// Gain attack xp
		StatChanged statChanged = new StatChanged(
			Skill.ATTACK,
			100,
			2,
			2
		);
		xpTrackerPlugin.onStatChanged(statChanged);

		// Offline gain
		when(client.getSkillExperience(Skill.ATTACK)).thenReturn(42000);
		// Flag initialization of tracker
		xpTrackerPlugin.onGameStateChanged(gameStateChanged);
		// Initialize tracker
		xpTrackerPlugin.onGameTick(GameTick.INSTANCE);

		// Start at 42 xp, gain of 58 xp, offline gain of 41900 xp - offset start XP: 42 + 41900
		XpStateSingle skillState = xpTrackerPlugin.getSkillState(Skill.ATTACK);
		assertEquals(41942, skillState.getStartXp());
	}
}