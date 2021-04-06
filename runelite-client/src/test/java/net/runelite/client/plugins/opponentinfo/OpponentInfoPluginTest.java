/*
 * Copyright (c) 2021, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.plugins.opponentinfo;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OpponentInfoPluginTest
{
	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	OpponentInfoConfig config;

	@Mock
	@Bind
	OpponentInfoOverlay opponentInfoOverlay;

	@Mock
	@Bind
	PlayerComparisonOverlay playerComparisonOverlay;

	@Inject
	OpponentInfoPlugin plugin;

	private final Player localPlayer = mock(Player.class);

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getLocalPlayer()).thenReturn(localPlayer);
	}

	@Test
	public void testNpcInteractions()
	{
		final NPC npc = mock(NPC.class);

		interactingChanged(npc, localPlayer);

		assertNull(plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(npc, null);

		assertNull(plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(localPlayer, npc);

		assertSame(npc, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(npc, localPlayer);

		assertSame(npc, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(localPlayer, null);

		// last opponent is remembered for 5 seconds
		assertSame(npc, plugin.getLastOpponent());
		assertNotNull(plugin.getLastTime());
	}

	@Test
	public void testOtherPlayerInteractions()
	{
		final Player otherPlayer = mock(Player.class);

		interactingChanged(otherPlayer, localPlayer);

		assertNull(plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(otherPlayer, null);

		assertNull(plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(localPlayer, otherPlayer);

		assertSame(otherPlayer, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(otherPlayer, localPlayer);

		assertSame(otherPlayer, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(localPlayer, null);

		// last opponent is remembered for 5 seconds
		assertSame(otherPlayer, plugin.getLastOpponent());
		assertNotNull(plugin.getLastTime());
	}

	@Test
	public void testNonLocalPlayerInteractions()
	{
		final Player otherPlayer = mock(Player.class);
		final NPC npc = mock(NPC.class);

		interactingChanged(otherPlayer, npc);

		assertNull(plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(npc, otherPlayer);

		assertNull(plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(otherPlayer, null);

		assertNull(plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(npc, null);

		assertNull(plugin.getLastOpponent());
		assertNull(plugin.getLastTime());
	}

	private void interactingChanged(final Actor source, final Actor target)
	{
		when(source.getInteracting()).thenReturn(target);
		plugin.onInteractingChanged(new InteractingChanged(source, target));
	}
}
