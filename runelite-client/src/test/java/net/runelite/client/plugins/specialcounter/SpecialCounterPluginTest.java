/*
 * Copyright (c) 2020, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.specialcounter;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Hitsplat;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.Notifier;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ws.PartyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SpecialCounterPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	private PartyService partyService;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private SpecialCounterConfig specialCounterConfig;

	@Inject
	private SpecialCounterPlugin specialCounterPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		// Set up spec weapon
		ItemContainer equipment = mock(ItemContainer.class);
		when(equipment.getItem(EquipmentInventorySlot.WEAPON.getSlotIdx())).thenReturn(new Item(ItemID.BANDOS_GODSWORD, 1));
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipment);

		// Set up special attack energy
		when(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT)).thenReturn(100);
		specialCounterPlugin.onVarbitChanged(new VarbitChanged());

	}

	private static HitsplatApplied hitsplat(Actor target, Hitsplat.HitsplatType type)
	{
		Hitsplat hitsplat = new Hitsplat(type, type == Hitsplat.HitsplatType.DAMAGE_ME ? 1 : 0, 42);
		HitsplatApplied hitsplatApplied = new HitsplatApplied();
		hitsplatApplied.setActor(target);
		hitsplatApplied.setHitsplat(hitsplat);
		return hitsplatApplied;
	}

	@Test
	public void testSpecDamage()
	{
		NPC target = mock(NPC.class);

		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);

		// spec npc
		when(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT)).thenReturn(50);
		specialCounterPlugin.onVarbitChanged(new VarbitChanged());
		lenient().when(player.getInteracting()).thenReturn(target);
		specialCounterPlugin.onInteractingChanged(new InteractingChanged(player, target));

		// hit 1
		specialCounterPlugin.onHitsplatApplied(hitsplat(target, Hitsplat.HitsplatType.DAMAGE_ME));

		verify(infoBoxManager).addInfoBox(any(SpecialCounter.class));
	}

	@Test
	public void testSpecBlock()
	{
		NPC target = mock(NPC.class);

		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);

		// spec npc
		when(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT)).thenReturn(50);
		specialCounterPlugin.onVarbitChanged(new VarbitChanged());
		lenient().when(player.getInteracting()).thenReturn(target);
		specialCounterPlugin.onInteractingChanged(new InteractingChanged(player, target));

		// block 0
		specialCounterPlugin.onHitsplatApplied(hitsplat(target, Hitsplat.HitsplatType.BLOCK_ME));

		// hit 1
		specialCounterPlugin.onHitsplatApplied(hitsplat(target, Hitsplat.HitsplatType.DAMAGE_ME));

		verify(infoBoxManager, never()).addInfoBox(any(SpecialCounter.class));
	}

	@Test
	public void testUnaggro()
	{
		NPC target = mock(NPC.class);

		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);

		// tick 1: attack npc
		when(player.getInteracting()).thenReturn(target);
		specialCounterPlugin.onInteractingChanged(new InteractingChanged(player, target));

		// tick 2: spec fires and un-interact npc
		when(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT)).thenReturn(50);
		specialCounterPlugin.onVarbitChanged(new VarbitChanged());
		lenient().when(player.getInteracting()).thenReturn(null);
		specialCounterPlugin.onInteractingChanged(new InteractingChanged(player, null));

		// tick 3: hit 1
		specialCounterPlugin.onHitsplatApplied(hitsplat(target, Hitsplat.HitsplatType.DAMAGE_ME));

		verify(infoBoxManager).addInfoBox(any(SpecialCounter.class));
	}

	@Test
	public void testSameTick()
	{
		NPC targetA = mock(NPC.class);
		NPC targetB = mock(NPC.class);

		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);

		// tick 1: attack npc A
		when(player.getInteracting()).thenReturn(targetA);
		specialCounterPlugin.onInteractingChanged(new InteractingChanged(player, targetA));

		// tick 2: spec npc B
		when(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT)).thenReturn(50);
		specialCounterPlugin.onVarbitChanged(new VarbitChanged());
		lenient().when(player.getInteracting()).thenReturn(targetB);
		specialCounterPlugin.onInteractingChanged(new InteractingChanged(player, targetB));

		// tick 3: hitsplat A, hitsplat B
		specialCounterPlugin.onHitsplatApplied(hitsplat(targetA, Hitsplat.HitsplatType.DAMAGE_ME));
		verify(infoBoxManager, never()).addInfoBox(any(SpecialCounter.class));

		specialCounterPlugin.onHitsplatApplied(hitsplat(targetB, Hitsplat.HitsplatType.DAMAGE_ME));
		verify(infoBoxManager).addInfoBox(any(SpecialCounter.class));
	}

	@Test
	public void testReset()
	{
		NPC targetA = mock(NPC.class);
		NPC targetB = mock(NPC.class);
		when(targetB.getId()).thenReturn(1); // a different npc type

		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);

		// spec npc
		when(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT)).thenReturn(50);
		specialCounterPlugin.onVarbitChanged(new VarbitChanged());
		lenient().when(player.getInteracting()).thenReturn(targetA);
		specialCounterPlugin.onInteractingChanged(new InteractingChanged(player, targetA));

		// hit 1
		specialCounterPlugin.onHitsplatApplied(hitsplat(targetA, Hitsplat.HitsplatType.DAMAGE_ME));

		verify(infoBoxManager).addInfoBox(any(SpecialCounter.class));

		// attack npc 2
		specialCounterPlugin.onInteractingChanged(new InteractingChanged(player, targetB));

		// hit 1
		specialCounterPlugin.onHitsplatApplied(hitsplat(targetB, Hitsplat.HitsplatType.DAMAGE_ME));

		verify(infoBoxManager).removeInfoBox(any(SpecialCounter.class));
	}

	@Test
	public void testNotification()
	{
		// Create an enemy
		NPC target = mock(NPC.class);

		// Create player
		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);
		when(specialCounterConfig.bandosGodswordThreshold()).thenReturn(2);
		when(specialCounterConfig.thresholdNotification()).thenReturn(true);

		// Attack enemy
		when(player.getInteracting()).thenReturn(target);
		specialCounterPlugin.onInteractingChanged(new InteractingChanged(player, target));

		// First special attack
		when(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT)).thenReturn(50);
		specialCounterPlugin.onVarbitChanged(new VarbitChanged());
		specialCounterPlugin.onHitsplatApplied(hitsplat(target, Hitsplat.HitsplatType.DAMAGE_ME));

		// Set up spec weapon as BGS(OR)
		ItemContainer equipment = mock(ItemContainer.class);
		when(equipment.getItem(EquipmentInventorySlot.WEAPON.getSlotIdx())).thenReturn(new Item(ItemID.BANDOS_GODSWORD_OR, 1));
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipment);

		// Second special attack
		when(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT)).thenReturn(0);
		specialCounterPlugin.onVarbitChanged(new VarbitChanged());
		specialCounterPlugin.onHitsplatApplied(hitsplat(target, Hitsplat.HitsplatType.DAMAGE_ME));

		verify(notifier).notify("Bandos Godsword special attack threshold reached!");
	}

	@Test
	public void testNotificationNotThreshold()
	{
		// Create an enemy
		NPC target = mock(NPC.class);

		// Create player
		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);
		when(specialCounterConfig.bandosGodswordThreshold()).thenReturn(3);
		lenient().when(specialCounterConfig.thresholdNotification()).thenReturn(true);

		// Attack enemy
		when(player.getInteracting()).thenReturn(target);
		specialCounterPlugin.onInteractingChanged(new InteractingChanged(player, target));

		// First special attack
		when(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT)).thenReturn(50);
		specialCounterPlugin.onVarbitChanged(new VarbitChanged());
		specialCounterPlugin.onHitsplatApplied(hitsplat(target, Hitsplat.HitsplatType.DAMAGE_ME));

		// Second special attack
		when(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT)).thenReturn(0);
		specialCounterPlugin.onVarbitChanged(new VarbitChanged());
		specialCounterPlugin.onHitsplatApplied(hitsplat(target, Hitsplat.HitsplatType.DAMAGE_ME));

		verify(notifier, never()).notify(any());
	}
}
