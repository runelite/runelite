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
import java.util.EnumSet;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Hitsplat;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.Player;
import net.runelite.api.VarPlayer;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.Notifier;
import net.runelite.client.game.SoundManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

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
	private SoundManager soundManager;

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
		final NPCDefinition monsterComp = mock(NPCDefinition.class);
		when(monsterComp.getActions()).thenReturn(monsterActions);
		when(monster.getDefinition()).thenReturn(monsterComp);

		// Mock random event
		final String[] randomEventActions = new String[] { "Talk-to", "Dismiss", "Examine" };
		final NPCDefinition randomEventComp = mock(NPCDefinition.class);
		when(randomEventComp.getActions()).thenReturn(randomEventActions);
		when(randomEvent.getDefinition()).thenReturn(randomEventComp);

		// Mock player
		when(player.getName()).thenReturn(PLAYER_NAME);
		when(player.getAnimation()).thenReturn(AnimationID.IDLE);
		when(client.getLocalPlayer()).thenReturn(player);

		// Mock config
		plugin.setLogoutIdle(true);
		plugin.setAnimationIdle(true);
		plugin.setInteractionIdle(true);
		plugin.setGetIdleNotificationDelay(0);
		plugin.setGetHitpointsThreshold(42);
		plugin.setGetPrayerThreshold(42);

		// Mock client
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		when(client.getKeyboardIdleTicks()).thenReturn(42);
		when(client.getMouseLastPressedMillis()).thenReturn(System.currentTimeMillis() - 100_000L);
		when(client.getWorldType()).thenReturn(EnumSet.of(WorldType.DEADMAN));
	}

	@Test
	public void checkAnimationIdle()
	{
		when(player.getAnimation()).thenReturn(AnimationID.WOODCUTTING_BRONZE);
		AnimationChanged animationChanged = new AnimationChanged();
		animationChanged.setActor(player);
		plugin.onAnimationChanged(animationChanged);
		plugin.onGameTick(GameTick.INSTANCE);
		when(player.getAnimation()).thenReturn(AnimationID.IDLE);
		plugin.onAnimationChanged(animationChanged);
		plugin.onGameTick(GameTick.INSTANCE);
		verify(notifier).notify("[" + PLAYER_NAME + "] is now idle!");
	}

	@Test
	public void checkAnimationReset()
	{
		when(player.getAnimation()).thenReturn(AnimationID.WOODCUTTING_BRONZE);
		AnimationChanged animationChanged = new AnimationChanged();
		animationChanged.setActor(player);
		plugin.onAnimationChanged(animationChanged);
		plugin.onGameTick(GameTick.INSTANCE);
		when(player.getAnimation()).thenReturn(AnimationID.LOOKING_INTO);
		plugin.onAnimationChanged(animationChanged);
		plugin.onGameTick(GameTick.INSTANCE);
		when(player.getAnimation()).thenReturn(AnimationID.IDLE);
		plugin.onAnimationChanged(animationChanged);
		plugin.onGameTick(GameTick.INSTANCE);
		verify(notifier, times(0)).notify(any());
	}

	@Test
	public void checkAnimationLogout()
	{
		when(player.getAnimation()).thenReturn(AnimationID.WOODCUTTING_BRONZE);
		AnimationChanged animationChanged = new AnimationChanged();
		animationChanged.setActor(player);
		plugin.onAnimationChanged(animationChanged);
		plugin.onGameTick(GameTick.INSTANCE);

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
		plugin.onGameTick(GameTick.INSTANCE);
		verify(notifier, times(0)).notify(any());
	}

	@Test
	public void checkCombatIdle()
	{
		when(player.getInteracting()).thenReturn(monster);
		plugin.onInteractingChanged(new InteractingChanged(player, monster));
		plugin.onGameTick(GameTick.INSTANCE);
		when(player.getInteracting()).thenReturn(null);
		plugin.onInteractingChanged(new InteractingChanged(player, null));
		plugin.onGameTick(GameTick.INSTANCE);
		verify(notifier).notify("[" + PLAYER_NAME + "] is now out of combat!");
	}

	@Test
	public void checkCombatReset()
	{
		when(player.getInteracting()).thenReturn(monster);
		plugin.onInteractingChanged(new InteractingChanged(player, monster));
		plugin.onGameTick(GameTick.INSTANCE);
		plugin.onInteractingChanged(new InteractingChanged(player, randomEvent));
		plugin.onGameTick(GameTick.INSTANCE);
		plugin.onInteractingChanged(new InteractingChanged(player, null));
		plugin.onGameTick(GameTick.INSTANCE);
		verify(notifier, times(0)).notify(any());
	}

	@Test
	public void checkCombatLogout()
	{
		plugin.onInteractingChanged(new InteractingChanged(player, monster));
		when(player.getInteracting()).thenReturn(monster);
		plugin.onGameTick(GameTick.INSTANCE);

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
		plugin.onInteractingChanged(new InteractingChanged(player, null));
		plugin.onGameTick(GameTick.INSTANCE);
		verify(notifier, times(0)).notify(any());
	}

	@Test
	public void checkCombatLogoutIdle()
	{
		// Player is idle
		when(client.getMouseIdleTicks()).thenReturn(80_000);

		// But player is being damaged (is in combat)
		final HitsplatApplied hitsplatApplied = new HitsplatApplied();
		hitsplatApplied.setActor(player);
		hitsplatApplied.setHitsplat(new Hitsplat(Hitsplat.HitsplatType.DAMAGE, 0, 0));
		plugin.onHitsplatApplied(hitsplatApplied);
		plugin.onGameTick(GameTick.INSTANCE);
		verify(notifier, times(0)).notify(any());
	}

	@Test
	public void doubleNotifyOnMouseReset()
	{
		// Player is idle, but in combat so the idle packet is getting set repeatedly
		// make sure we are not notifying

		when(client.getKeyboardIdleTicks()).thenReturn(80_000);
		when(client.getMouseIdleTicks()).thenReturn(14_500);

		plugin.onGameTick(GameTick.INSTANCE);
		plugin.onGameTick(GameTick.INSTANCE);
		verify(notifier, times(1)).notify(any());
	}

	@Test
	public void testSpecRegen()
	{
		plugin.setGetSpecEnergyThreshold(50);

		when(client.getVar(eq(VarPlayer.SPECIAL_ATTACK_PERCENT))).thenReturn(400); // 40%
		plugin.onGameTick(GameTick.INSTANCE); // once to set lastSpecEnergy to 400
		verify(notifier, never()).notify(any());

		when(client.getVar(eq(VarPlayer.SPECIAL_ATTACK_PERCENT))).thenReturn(500); // 50%
		plugin.onGameTick(GameTick.INSTANCE);
		verify(notifier).notify(eq("[" + PLAYER_NAME + "] has restored spec energy!"));
	}

	@Test
	public void testMovementIdle()
	{
		plugin.setMovementIdle(true);

		when(player.getWorldLocation()).thenReturn(new WorldPoint(0, 0, 0));
		plugin.onGameTick(GameTick.INSTANCE);
		when(player.getWorldLocation()).thenReturn(new WorldPoint(1, 0, 0));
		plugin.onGameTick(GameTick.INSTANCE);
		// No movement here
		plugin.onGameTick(GameTick.INSTANCE);

		verify(notifier).notify(eq("[" + PLAYER_NAME + "] has stopped moving!"));
	}
}