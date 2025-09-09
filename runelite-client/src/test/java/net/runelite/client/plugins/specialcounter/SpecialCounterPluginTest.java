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
import com.google.inject.name.Named;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.image.BufferedImage;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Hitsplat;
import net.runelite.api.HitsplatID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.annotations.HitsplatType;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.Notification;
import net.runelite.client.game.ItemManager;
import net.runelite.client.party.PartyService;
import net.runelite.client.party.WSClient;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.AsyncBufferedImage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
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
	private ClientThread clientThread;

	@Bind
	@Named("developerMode")
	boolean developerMode;

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
	private WSClient wsClient;

	@Mock
	@Bind
	private SpecialCounterConfig specialCounterConfig;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private PlayerInfoDropOverlay playerInfoDropOverlay;

	@Inject
	private SpecialCounterPlugin specialCounterPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(specialCounterConfig.infobox()).thenReturn(true);

		// Set up spec weapon
		ItemContainer equipment = mock(ItemContainer.class);
		when(equipment.getItem(EquipmentInventorySlot.WEAPON.getSlotIdx())).thenReturn(new Item(ItemID.BGS, 1));
		when(client.getItemContainer(InventoryID.WORN)).thenReturn(equipment);

		// Set up special attack energy
		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarpId(VarPlayerID.SA_ENERGY);
		varbitChanged.setValue(100);
		specialCounterPlugin.onVarbitChanged(varbitChanged);

		// Set up item image for spec info drop
		when(itemManager.getImage(anyInt())).thenReturn(new AsyncBufferedImage(clientThread, 24, 24, BufferedImage.TYPE_INT_ARGB));
	}

	private static HitsplatApplied hitsplat(Actor target, @HitsplatType int type)
	{
		Hitsplat hitsplat = new Hitsplat(type, type == HitsplatID.DAMAGE_ME ? 1 : 0, 42);
		HitsplatApplied hitsplatApplied = new HitsplatApplied();
		hitsplatApplied.setActor(target);
		hitsplatApplied.setHitsplat(hitsplat);
		return hitsplatApplied;
	}

	@Test
	public void testSpecDamage()
	{
		Player player = mock(Player.class);
		NPC target = mock(NPC.class);

		when(client.getLocalPlayer()).thenReturn(player);
		when(player.getInteracting()).thenReturn(target);

		when(client.getTickCount()).thenReturn(0);

		// spec npc
		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarpId(VarPlayerID.SA_ENERGY);
		varbitChanged.setValue(50);
		specialCounterPlugin.onVarbitChanged(varbitChanged);

		when(client.getTickCount()).thenReturn(1);

		// clientthread callback
		ArgumentCaptor<Runnable> captor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(captor.capture());
		captor.getValue().run();

		// hit 1
		specialCounterPlugin.onHitsplatApplied(hitsplat(target, HitsplatID.DAMAGE_ME));

		specialCounterPlugin.onGameTick(new GameTick());

		verify(infoBoxManager).addInfoBox(any(SpecialCounter.class));
	}

	@Test
	public void testNotification()
	{
		// Create an enemy
		NPC target = mock(NPC.class);

		// Create player
		Player player = mock(Player.class);
		when(player.getInteracting()).thenReturn(target);

		when(client.getLocalPlayer()).thenReturn(player);
		when(specialCounterConfig.bandosGodswordThreshold()).thenReturn(2);
		when(specialCounterConfig.thresholdNotification()).thenReturn(Notification.ON);

		when(client.getTickCount()).thenReturn(0);

		// First special attack
		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarpId(VarPlayerID.SA_ENERGY);
		varbitChanged.setValue(50);
		specialCounterPlugin.onVarbitChanged(varbitChanged);

		when(client.getTickCount()).thenReturn(1);

		// clientthread callback
		ArgumentCaptor<Runnable> captor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(captor.capture());
		captor.getValue().run();

		specialCounterPlugin.onHitsplatApplied(hitsplat(target, HitsplatID.DAMAGE_ME));

		specialCounterPlugin.onGameTick(new GameTick());

		when(client.getTickCount()).thenReturn(2);

		// Set up spec weapon as BGS(OR)
		ItemContainer equipment = mock(ItemContainer.class);
		when(equipment.getItem(EquipmentInventorySlot.WEAPON.getSlotIdx())).thenReturn(new Item(ItemID.BGSG, 1));
		when(client.getItemContainer(InventoryID.WORN)).thenReturn(equipment);

		// Second special attack
		reset(clientThread);
		varbitChanged = new VarbitChanged();
		varbitChanged.setVarpId(VarPlayerID.SA_ENERGY);
		varbitChanged.setValue(0);
		specialCounterPlugin.onVarbitChanged(varbitChanged);

		when(client.getTickCount()).thenReturn(3);

		// clientthread callback
		captor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(captor.capture());
		captor.getValue().run();

		specialCounterPlugin.onHitsplatApplied(hitsplat(target, HitsplatID.DAMAGE_ME));

		specialCounterPlugin.onGameTick(new GameTick());

		verify(notifier).notify(Notification.ON, "Bandos Godsword special attack threshold reached!");
	}

	@Test
	public void testNotificationNotThreshold()
	{
		// Create player
		Player player = mock(Player.class);
		NPC target = mock(NPC.class);

		when(client.getLocalPlayer()).thenReturn(player);
		when(player.getInteracting()).thenReturn(target);
		when(specialCounterConfig.bandosGodswordThreshold()).thenReturn(3);
		lenient().when(specialCounterConfig.thresholdNotification()).thenReturn(Notification.ON);

		when(client.getTickCount()).thenReturn(0);

		// First special attack
		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarpId(VarPlayerID.SA_ENERGY);
		varbitChanged.setValue(50);
		specialCounterPlugin.onVarbitChanged(varbitChanged);

		when(client.getTickCount()).thenReturn(1);

		// clientthread callback
		ArgumentCaptor<Runnable> captor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(captor.capture());
		captor.getValue().run();

		specialCounterPlugin.onHitsplatApplied(hitsplat(target, HitsplatID.DAMAGE_ME));

		specialCounterPlugin.onGameTick(new GameTick());

		when(client.getTickCount()).thenReturn(2);

		reset(clientThread);
		// Second special attack
		varbitChanged = new VarbitChanged();
		varbitChanged.setVarpId(VarPlayerID.SA_ENERGY);
		varbitChanged.setValue(0);
		specialCounterPlugin.onVarbitChanged(varbitChanged);

		when(client.getTickCount()).thenReturn(3);

		// clientthread callback
		captor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(captor.capture());
		captor.getValue().run();

		specialCounterPlugin.onHitsplatApplied(hitsplat(target, HitsplatID.DAMAGE_ME));

		specialCounterPlugin.onGameTick(new GameTick());

		verify(notifier, never()).notify(any());
	}
}
