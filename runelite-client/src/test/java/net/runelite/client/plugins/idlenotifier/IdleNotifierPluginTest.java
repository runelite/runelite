/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.idlenotifier;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Hitsplat;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Player;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.Notifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IdleNotifierPluginTest
{
	private static final String PLAYER_NAME = "Deathbeam";

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private IdleNotifierConfig config;

	@Mock
	@Bind
	private Notifier notifier;

	@Inject
	private IdleNotifierPlugin plugin;

	@Mock
	private NPC monster;

	@Mock
	private NPC randomEvent;

	@Mock
	private Player player;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		// Mock monster
		final String[] monsterActions = new String[] { "Attack", "Examine" };
		final NPCComposition monsterComp = mock(NPCComposition.class);
		when(monsterComp.getActions()).thenReturn(monsterActions);
		when(monster.getComposition()).thenReturn(monsterComp);

		// Mock random event
		final String[] randomEventActions = new String[] { "Talk-to", "Dismiss", "Examine" };
		final NPCComposition randomEventComp = mock(NPCComposition.class);
		when(randomEventComp.getActions()).thenReturn(randomEventActions);
		when(randomEvent.getComposition()).thenReturn(randomEventComp);

		// Mock player
		when(player.getName()).thenReturn(PLAYER_NAME);
		when(player.getAnimation()).thenReturn(AnimationID.IDLE);
		when(client.getLocalPlayer()).thenReturn(player);

		// Mock config
		when(config.logoutIdle()).thenReturn(true);
		when(config.animationIdle()).thenReturn(true);
		when(config.interactionIdle()).thenReturn(true);
		when(config.getIdleNotificationDelay()).thenReturn(0);
		when(config.getHitpointsThreshold()).thenReturn(42);
		when(config.getPrayerThreshold()).thenReturn(42);

		// Mock client
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		when(client.getKeyboardIdleTicks()).thenReturn(42);
		when(client.getMouseLastPressedMillis()).thenReturn(System.currentTimeMillis() - 100_000L);
	}

	@Test
	public void checkAnimationIdle() throws InterruptedException
	{
		when(player.getAnimation()).thenReturn(AnimationID.WOODCUTTING_BRONZE);
		AnimationChanged animationChanged = new AnimationChanged();
		animationChanged.setActor(player);
		plugin.onAnimationChanged(animationChanged);
		gameTick();
		when(player.getAnimation()).thenReturn(AnimationID.IDLE);
		plugin.onAnimationChanged(animationChanged);
		gameTick();
		verify(notifier).notify("[" + PLAYER_NAME + "] is now idle!");
	}

	@Test
	public void checkAnimationReset() throws InterruptedException
	{
		when(player.getAnimation()).thenReturn(AnimationID.WOODCUTTING_BRONZE);
		AnimationChanged animationChanged = new AnimationChanged();
		animationChanged.setActor(player);
		plugin.onAnimationChanged(animationChanged);
		gameTick();
		when(player.getAnimation()).thenReturn(AnimationID.LOOKING_INTO);
		plugin.onAnimationChanged(animationChanged);
		gameTick();
		when(player.getAnimation()).thenReturn(AnimationID.IDLE);
		plugin.onAnimationChanged(animationChanged);
		gameTick();
		verify(notifier, times(0)).notify(any());
	}

	@Test
	public void checkAnimationLogout() throws InterruptedException
	{
		when(player.getAnimation()).thenReturn(AnimationID.WOODCUTTING_BRONZE);
		AnimationChanged animationChanged = new AnimationChanged();
		animationChanged.setActor(player);
		plugin.onAnimationChanged(animationChanged);
		gameTick();

		// Logout
		when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);
		GameStateChanged gameStateChanged = new GameStateChanged();
		gameStateChanged.setGameState(GameState.LOGIN_SCREEN);
		plugin.onGameStateChanged(gameStateChanged);

		// Log back in
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		gameStateChanged.setGameState(GameState.LOGGED_IN);
		plugin.onGameStateChanged(gameStateChanged);

		// Tick
		when(player.getAnimation()).thenReturn(AnimationID.IDLE);
		plugin.onAnimationChanged(animationChanged);
		gameTick();
		verify(notifier, times(0)).notify(any());
	}

	@Test
	public void checkCombatIdle() throws InterruptedException
	{
		when(player.getInteracting()).thenReturn(monster);
		plugin.onInteractingChanged(new InteractingChanged(player, monster));
		gameTick();
		when(player.getInteracting()).thenReturn(null);
		plugin.onInteractingChanged(new InteractingChanged(player, null));
		gameTick();
		verify(notifier).notify("[" + PLAYER_NAME + "] is now out of combat!");
	}

	@Test
	public void checkCombatReset() throws InterruptedException
	{
		when(player.getInteracting()).thenReturn(monster);
		plugin.onInteractingChanged(new InteractingChanged(player, monster));
		gameTick();
		when(player.getInteracting()).thenReturn(randomEvent);
		plugin.onInteractingChanged(new InteractingChanged(player, randomEvent));
		gameTick();
		when(player.getInteracting()).thenReturn(null);
		plugin.onInteractingChanged(new InteractingChanged(player, null));
		gameTick();
		verify(notifier, times(0)).notify(any());
	}

	@Test
	public void checkCombatLogout() throws InterruptedException
	{
		plugin.onInteractingChanged(new InteractingChanged(player, monster));
		when(player.getInteracting()).thenReturn(monster);
		gameTick();

		// Logout
		when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);
		GameStateChanged gameStateChanged = new GameStateChanged();
		gameStateChanged.setGameState(GameState.LOGIN_SCREEN);
		plugin.onGameStateChanged(gameStateChanged);

		// Log back in
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		gameStateChanged.setGameState(GameState.LOGGED_IN);
		plugin.onGameStateChanged(gameStateChanged);

		// Tick
		when(player.getInteracting()).thenReturn(null);
		plugin.onInteractingChanged(new InteractingChanged(player, null));
		gameTick();
		verify(notifier, times(0)).notify(any());
	}

	@Test
	public void checkCombatLogoutIdle() throws InterruptedException
	{
		// Player is idle
		when(client.getMouseIdleTicks()).thenReturn(80_000);

		// But player is being damaged (is in combat)
		final HitsplatApplied hitsplatApplied = new HitsplatApplied();
		hitsplatApplied.setActor(player);
		hitsplatApplied.setHitsplat(new Hitsplat(Hitsplat.HitsplatType.DAMAGE, 0, 0));
		plugin.onHitsplatApplied(hitsplatApplied);
		gameTick();
		verify(notifier, times(0)).notify(any());
	}

	@Test
	public void doubleNotifyOnMouseReset() throws InterruptedException
	{
		// Player is idle, but in combat so the idle packet is getting set repeatedly
		// make sure we are not notifying

		when(client.getKeyboardIdleTicks()).thenReturn(80_000);
		when(client.getMouseIdleTicks()).thenReturn(14_500);

		gameTick();
		gameTick();
		verify(notifier, times(1)).notify(any());
	}

	@Test
	public void testSpecRegen() throws InterruptedException
	{
		when(config.getSpecEnergyThreshold()).thenReturn(50);

		when(client.getVar(Matchers.eq(VarPlayer.SPECIAL_ATTACK_PERCENT))).thenReturn(400); // 40%
		gameTick(); // once to set lastSpecEnergy to 400
		verify(notifier, never()).notify(any());

		when(client.getVar(Matchers.eq(VarPlayer.SPECIAL_ATTACK_PERCENT))).thenReturn(500); // 50%
		gameTick();
		verify(notifier).notify(Matchers.eq("[" + PLAYER_NAME + "] has restored spec energy!"));
	}

	private void gameTick() throws InterruptedException
	{
		Thread.sleep(600);
		plugin.onGameTick(new GameTick());
	}
}