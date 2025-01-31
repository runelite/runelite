/*
 * Copyright (c) 2022, Jordan Atwood <nightfirecat@nightfirec.at>
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
package net.runelite.client.plugins.hunter;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import static net.runelite.api.NullNpcID.NULL_8740;
import static net.runelite.api.ObjectID.BOX_TRAP_9380;
import static net.runelite.api.ObjectID.BOX_TRAP_9381;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.Notifier;
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
public class HunterPluginTest
{
	@Mock
	@Bind
	Client client;

	@Inject
	HunterPlugin plugin;

	@Mock
	@Bind
	HunterConfig config;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	Notifier notifier;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void deadTrap()
	{
		final NPC chin = mock(NPC.class);

		final HunterTrap box1 = layBoxTrap(new WorldPoint(1, 0, 0));
		final HunterTrap box2 = layBoxTrap(new WorldPoint(2, 0, 0));

		// TICK 1
		// Box 1 targets chin
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin));

		// TICK 2
		// Chin targets box 1, box 1 untargets chin, box 2 targets chin
		plugin.onInteractingChanged(new InteractingChanged(chin, box1.getNpc()));
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), null));
		plugin.onInteractingChanged(new InteractingChanged(box2.getNpc(), chin));

		// TICK 3
		// Chin despawns, box 1 object transitions to shaking box, box 2 untargets chin
		plugin.onInteractingChanged(new InteractingChanged(box2.getNpc(), null));
		plugin.onNpcDespawned(new NpcDespawned(chin));
		spawnShakingBox(box1.getWorldLocation());

		assertEquals(HunterTrap.State.TRANSITION, box1.getState());
		assertEquals(HunterTrap.State.DEAD, box2.getState());
	}

	@Test
	public void blockedNonDeadTrap()
	{
		final NPC chin = mock(NPC.class);

		// Box is visible, but has pathing blocked to chin--it will target the chin which will fail to path to it
		final HunterTrap box = layBoxTrap(new WorldPoint(0, 0, 0));

		// TICK 1
		// Box targets chin
		plugin.onInteractingChanged(new InteractingChanged(box.getNpc(), chin));

		// TICK 2
		// Chin targets box (which is still targeting chin)
		plugin.onInteractingChanged(new InteractingChanged(chin, box.getNpc()));

		// TICK ~3-9
		// Chin is stuck trying to path to box. It is behind a bush, or around the corner of a tree and is inaccessible
		// to the chin.

		// TICK 10
		// Chin untargets box
		plugin.onInteractingChanged(new InteractingChanged(chin, null));

		assertEquals(HunterTrap.State.OPEN, box.getState());
	}

	@Test
	public void blockedNonDeadTrap2()
	{
		final NPC chin = mock(NPC.class);

		// Box 1 is visible, but has pathing blocked to chin--it will target the chin which will fail to path to it.
		// After failing to path to it, it will target box 2 and be caught in that box instead. Box 1 is not dead, as it
		// can still lure and catch other chins.
		final HunterTrap box1 = layBoxTrap(new WorldPoint(1, 0, 0));
		final HunterTrap box2 = layBoxTrap(new WorldPoint(2, 0, 0));

		// TICK 1
		// Boxes 1 and 2 target chin
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin));
		plugin.onInteractingChanged(new InteractingChanged(box2.getNpc(), chin));

		// TICK 2
		// Chin targets box 1 (which is still targeting chin)
		plugin.onInteractingChanged(new InteractingChanged(chin, box1.getNpc()));

		// TICK ~3-9
		// Chin is stuck trying to path to box 1. It is behind a bush, or around the corner of a tree and is
		// inaccessible to the chin. During this time, the box fires InteractingChanged once per tick to the chin.
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin));
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin));

		// TICK 10
		// Chin untargets box 1
		plugin.onInteractingChanged(new InteractingChanged(chin, null));

		// TICK 11
		// Chin targets box 2, box 2 untargets chin
		plugin.onInteractingChanged(new InteractingChanged(chin, box2.getNpc()));
		plugin.onInteractingChanged(new InteractingChanged(box2.getNpc(), null));

		// TICK 12
		// Chin despawns, box 2 object transitions to shaking box, box 1 untargets chin
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), null));
		plugin.onNpcDespawned(new NpcDespawned(chin));
		spawnShakingBox(box2.getWorldLocation());

		assertEquals(HunterTrap.State.OPEN, box1.getState());
		assertEquals(HunterTrap.State.TRANSITION, box2.getState());
	}

	@Test
	public void blockedNonDeadTrap3()
	{
		final NPC chin1 = mock(NPC.class);
		final NPC chin2 = mock(NPC.class);

		// Box 1 is visible, but has pathing blocked to chin--it will target the chin which will fail to path to it.
		// While failing to path to it, box 2 will target the chin and later catch it. Box 1 is not dead and will later
		// target and catch a second chin.
		final HunterTrap box1 = layBoxTrap(new WorldPoint(1, 0, 0));
		final HunterTrap box2 = layBoxTrap(new WorldPoint(2, 0, 0));

		// TICK 1
		// Box 1 targets chin
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin1));

		// TICK 2
		// Chin targets box 1 (which is still targeting chin)
		plugin.onInteractingChanged(new InteractingChanged(chin1, box1.getNpc()));

		// TICK 3-5
		// Chin is stuck trying to path to box 1. It is behind a bush, or around the corner of a tree and is
		// inaccessible to the chin. During this time, box 1 fires InteractingChanged once per tick to the chin.
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin1));
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin1));

		// TICK 6
		// Box 2 targets chin, which is still stuck trying to reach box 1. Box 1 is still firing InteractingChanged once
		// per tick.
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin1));
		plugin.onInteractingChanged(new InteractingChanged(box2.getNpc(), chin1));

		// TICK 7-9
		// Chin is still stuck. During this time, box 1 continues firing InteractingChanged once per tick to the chin.
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin1));
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin1));

		// TICK 10
		// Chin untargets box 1
		plugin.onInteractingChanged(new InteractingChanged(chin1, null));

		// TICK 11
		// Chin targets box 2, box 2 untargets chin
		plugin.onInteractingChanged(new InteractingChanged(chin1, box2.getNpc()));
		plugin.onInteractingChanged(new InteractingChanged(box2.getNpc(), null));

		// TICK 12
		// Chin despawns, box 2 object transitions to shaking box, box 1 untargets chin
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), null));
		plugin.onNpcDespawned(new NpcDespawned(chin1));
		spawnShakingBox(box2.getWorldLocation());

		assertEquals(HunterTrap.State.OPEN, box1.getState());
		assertEquals(HunterTrap.State.TRANSITION, box2.getState());

		// TICK 13
		// Box 1 targets chin 2
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), chin2));

		// TICK 14
		// Chin 2 targets box 1, box 1 untargets chin
		plugin.onInteractingChanged(new InteractingChanged(chin1, box1.getNpc()));
		plugin.onInteractingChanged(new InteractingChanged(box1.getNpc(), null));

		// TICK 15
		// Chin 2 despawns, box 1 object transitions to shaking box
		plugin.onNpcDespawned(new NpcDespawned(chin2));
		spawnShakingBox(box1.getWorldLocation());

		assertEquals(HunterTrap.State.TRANSITION, box1.getState());
	}

	/**
	 * Spawn a box trap object and NPC at the given point.
	 *
	 * @param location The {@link WorldPoint} to spawn the box trap at.
	 * @return The {@link HunterTrap} representing the resulting spawned trap.
	 */
	private HunterTrap layBoxTrap(final WorldPoint location)
	{
		final Player localPlayer = mock(Player.class);
		when(localPlayer.getName()).thenReturn("Logic Knot");
		when(client.getLocalPlayer()).thenReturn(localPlayer);

		final GameObject boxObject = mock(GameObject.class);
		when(boxObject.getId()).thenReturn(BOX_TRAP_9380);
		when(boxObject.getWorldLocation()).thenReturn(location);
		final GameObjectSpawned trapObjectSpawned = new GameObjectSpawned();
		trapObjectSpawned.setGameObject(boxObject);

		final NPCComposition boxComp = mock(NPCComposition.class);
		when(boxComp.getId()).thenReturn(NULL_8740);
		final NPC boxNpc = mock(NPC.class);
		when(boxNpc.getComposition()).thenReturn(boxComp);
		when(boxNpc.getWorldLocation()).thenReturn(location);

		plugin.setLastTickLocalPlayerLocation(location);
		plugin.onGameObjectSpawned(trapObjectSpawned);
		plugin.onNpcSpawned(new NpcSpawned(boxNpc));

		return plugin.getTraps().get(location);
	}

	/**
	 * Spawn a shaking (full) box trap object at the given point.
	 *
	 * @param location The {@link WorldPoint} to spawn the shaking box trap at.
	 */
	private void spawnShakingBox(final WorldPoint location)
	{
		final GameObject shakingBoxObject = mock(GameObject.class);
		when(shakingBoxObject.getId()).thenReturn(BOX_TRAP_9381);
		when(shakingBoxObject.getWorldLocation()).thenReturn(location);
		final GameObjectSpawned shakingBoxObjectSpawned = new GameObjectSpawned();
		shakingBoxObjectSpawned.setGameObject(shakingBoxObject);

		plugin.onGameObjectSpawned(shakingBoxObjectSpawned);
	}
}
