/*
 * Copyright (c) 2021, Jordan Atwood <jordan.atwood423@gmail.com>
 * Copyright (c) 2021, Andre Araya <araya.andre7@gmail.com>
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

		assertSame(npc, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(npc, null);

		// last opponent is remembered for 5 seconds
		assertSame(npc, plugin.getLastOpponent());
		assertNotNull(plugin.getLastTime());

		interactingChanged(localPlayer, npc);

		assertSame(npc, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(npc, localPlayer);

		assertSame(npc, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(localPlayer, null);

		// last opponent is remembered as it is still attacking the player
		assertSame(npc, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());
	}

	@Test
	public void testOtherPlayerInteractions()
	{
		final Player otherPlayer = mock(Player.class);

		interactingChanged(otherPlayer, localPlayer);

		assertSame(otherPlayer, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(otherPlayer, null);

		// last opponent is remembered for 5 seconds
		assertSame(otherPlayer, plugin.getLastOpponent());
		assertNotNull(plugin.getLastTime());

		interactingChanged(localPlayer, otherPlayer);

		assertSame(otherPlayer, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(otherPlayer, localPlayer);

		assertSame(otherPlayer, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());

		interactingChanged(localPlayer, null);

		// last opponent is remembered as it is still attacking the player
		assertSame(otherPlayer, plugin.getLastOpponent());
		assertNull(plugin.getLastTime());
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

	/*
	 * Verify that the current opponent in multi is always the npc that the player is attacking
	 */
	@Test
	public void testAttackingEnemyInMulti()
	{
		final Player otherPlayer = mock(Player.class);
		final NPC aggro = mock(NPC.class), attacked = mock(NPC.class);

		interactingChanged(localPlayer, null);

		// verify that there is currently no opponent
		assertNull(plugin.getLastOpponent());

		// some npc attacks the player
		interactingChanged(aggro, localPlayer);

		// verify that the current opponent is the aggressive npc
		assertSame(aggro, plugin.getLastOpponent());

		// the player attacks a different npc
		interactingChanged(localPlayer, attacked);

		// verify the attacked npc is now considered the current opponent
		assertSame(attacked, plugin.getLastOpponent());

		// the npc attacks them back
		interactingChanged(attacked, localPlayer);

		// verify that the current opponent is still the attacked npc
		assertSame(attacked, plugin.getLastOpponent());

		// the player is attacked by an aggressive npc while attacking a different npc
		interactingChanged(aggro, localPlayer);

		// verify that the current opponent is still the npc the player is attacking
		assertSame(attacked, plugin.getLastOpponent());

		// the npc attacking the player that is not the current opponent attacks a different player
		interactingChanged(aggro, otherPlayer);

		// verify that the current opponent is still the npc the player is attacking
		assertSame(attacked, plugin.getLastOpponent());

		// the npc the player is attacking, the current opponent, attacks a different player
		interactingChanged(attacked, otherPlayer);

		// verify that the current opponent is still the npc the player is attacking
		assertSame(attacked, plugin.getLastOpponent());
	}

	/*
	 * Verify that the current opponent is the expected npc while the player is not attacking anything
	 */
	@Test
	public void testIdleInMulti()
	{
		final Player otherPlayer = mock(Player.class);
		final NPC aggroFirst = mock(NPC.class), aggroRecent = mock(NPC.class);

		interactingChanged(localPlayer, null);

		// verify that there is currently no opponent
		assertNull(plugin.getLastOpponent());

		// some npc attacks the player
		interactingChanged(aggroFirst, localPlayer);

		// verify that the current opponent is the aggressive npc
		assertSame(aggroFirst, plugin.getLastOpponent());

		// the player is attacked by a different npc
		interactingChanged(aggroRecent, localPlayer);

		// verify that the current opponent is the most recent aggressor
		assertSame(aggroRecent, plugin.getLastOpponent());

		// an npc that is not the current opponent targets another player
		interactingChanged(aggroFirst, otherPlayer);

		// verify that the current opponent is still the most recent aggressor
		assertSame(aggroRecent, plugin.getLastOpponent());

		// the current opponent switches targets to another player
		interactingChanged(aggroRecent, otherPlayer);

		// verify that there is no longer an opponent
		// (if lastTime is not null, then the lastOpponent will become null after OpponentInfoPlugin.WAIT time)
		assertNotNull(plugin.getLastTime());
	}

	/*
	 * Verify that the current opponent is the expected npc in singles
	 */
	@Test
	public void testSingles()
	{
		final Player otherPlayer = mock(Player.class);
		final NPC npc = mock(NPC.class);

		interactingChanged(localPlayer, null);

		// verify that there is currently no opponent
		assertNull(plugin.getLastOpponent());

		// some npc attacks the player
		interactingChanged(npc, localPlayer);

		// verify that the attacking npc is the current opponent
		assertSame(npc, plugin.getLastOpponent());

		// the npc stops attacking the player
		interactingChanged(npc, null);

		// verify that there is no longer an opponent
		// (if lastTime is not null, then the lastOpponent will become null after OpponentInfoPlugin.WAIT time)
		assertNotNull(plugin.getLastTime());

		// the player attacks the npc
		interactingChanged(localPlayer, npc);

		// verify that the attacked npc is the current opponent
		assertSame(npc, plugin.getLastOpponent());
		// verify that the hp bar will no longer be hidden
		assertNull(plugin.getLastTime());

		// the npc attacks them back
		interactingChanged(npc, localPlayer);

		// verify that the attacked npc is still the current opponent
		assertSame(npc, plugin.getLastOpponent());

		// the player stops attacking the npc
		interactingChanged(localPlayer, null);

		// verify that the npc attacking the player is still the current opponent
		assertSame(npc, plugin.getLastOpponent());
		// verify that the hp bar will not be hidden (because the npc is still attacking the player)
		assertNull(plugin.getLastTime());

		// the player attacks the npc again
		interactingChanged(localPlayer, npc);

		// verify the npc is still the opponent
		assertSame(npc, plugin.getLastOpponent());

		// the npc stops attacking the player
		interactingChanged(npc, null);

		// verify that the attacked npc is still the current opponent
		assertSame(npc, plugin.getLastOpponent());

		// the player stops attacking the npc while the npc is not attacking the player
		interactingChanged(localPlayer, null);

		// verify that there is no longer an opponent
		// (if lastTime is not null, then the lastOpponent will become null after OpponentInfoPlugin.WAIT time)
		assertNotNull(plugin.getLastTime());

		// the npc attacks a different player
		interactingChanged(npc, otherPlayer);

		// verify there is still no opponent
		// (if lastTime is not null, then the lastOpponent will become null after OpponentInfoPlugin.WAIT time)
		assertNotNull(plugin.getLastTime());

		// the npc stops attacking the other player
		interactingChanged(npc, null);

		// verify there is still no opponent
		// (if lastTime is not null, then the lastOpponent will become null after OpponentInfoPlugin.WAIT time)
		assertNotNull(plugin.getLastTime());
	}

	private void interactingChanged(final Actor source, final Actor target)
	{
		when(source.getInteracting()).thenReturn(target);
		plugin.onInteractingChanged(new InteractingChanged(source, target));
	}
}
