/*
 * Copyright (c) 2019, Alexsuperfly <github.com/Alexsuperfly>
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
package net.runelite.client.plugins.raids;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageCapture;
import net.runelite.client.ws.PartyService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RaidsPluginTest
{
	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ScheduledExecutorService executor;

	@Mock
	@Bind
	ChatColorConfig chatColorConfig;

	@Mock
	@Bind
	RuneLiteConfig runeliteConfig;

	@Mock
	@Bind
	ItemManager itemManager;

	@Mock
	@Bind
	ChatMessageManager chatMessageManager;

	@Mock
	@Bind
	ImageCapture imageCapture;

	@Mock
	@Bind
	Notifier notifier;

	@Mock
	@Bind
	RaidsConfig raidsConfig;

	@Inject
	RaidsPlugin raidsPlugin;

	@Mock
	@Bind
	private PartyService partyService;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(raidsConfig.whitelistedRooms()).thenReturn("");
		when(raidsConfig.blacklistedRooms()).thenReturn("");
		when(raidsConfig.whitelistedRotations()).thenReturn("");
		when(raidsConfig.whitelistedLayouts()).thenReturn("");
	}

	@Test
	public void testRotationWhitelist()
	{
		when(raidsConfig.whitelistedRotations()).thenReturn("Muttadiles, Tekton, Mystics");
		raidsPlugin.updateLists();

		final RaidRoom[] raidRooms = new RaidRoom[]{RaidRoom.MUTTADILES, RaidRoom.TEKTON, RaidRoom.MYSTICS};
		Raid raid = mock(Raid.class);
		when(raid.getCombatRooms()).thenReturn(raidRooms);
		raidsPlugin.setRaid(raid);

		assertTrue(raidsPlugin.getRotationMatches());
	}

	@Test
	public void testRotationWhitelistMultiple()
	{
		when(raidsConfig.whitelistedRotations()).thenReturn("Vanguards, Vespula, Vasa \nMuttadiles, Tekton, Mystics");
		raidsPlugin.updateLists();

		final RaidRoom[] raidRooms = new RaidRoom[]{RaidRoom.MUTTADILES, RaidRoom.TEKTON, RaidRoom.MYSTICS};
		Raid raid = mock(Raid.class);
		when(raid.getCombatRooms()).thenReturn(raidRooms);
		raidsPlugin.setRaid(raid);

		assertTrue(raidsPlugin.getRotationMatches());
	}

	@Test
	public void testRotationWhitelistBackwards()
	{
		when(raidsConfig.whitelistedRotations()).thenReturn("muttadiles, tekton, mystics");
		raidsPlugin.updateLists();

		final RaidRoom[] raidRooms = new RaidRoom[]{RaidRoom.MYSTICS, RaidRoom.TEKTON, RaidRoom.MUTTADILES};
		Raid raid = mock(Raid.class);
		when(raid.getCombatRooms()).thenReturn(raidRooms);
		raidsPlugin.setRaid(raid);

		assertFalse(raidsPlugin.getRotationMatches());
	}

	@Test
	public void testLootValue()
	{
		when(raidsConfig.showLootValue()).thenReturn(true);

		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.TWISTED_BOW, 1),
			new Item(ItemID.PURE_ESSENCE, 42)
		});
		when(client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST)).thenReturn(itemContainer);

		when(itemManager.getItemPrice(ItemID.TWISTED_BOW)).thenReturn(1_100_000_000);
		when(itemManager.getItemPrice(ItemID.PURE_ESSENCE)).thenReturn(6);

		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(WidgetID.CHAMBERS_OF_XERIC_REWARD_GROUP_ID);
		raidsPlugin.onWidgetLoaded(widgetLoaded);

		ArgumentCaptor<QueuedMessage> captor = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(captor.capture());

		QueuedMessage queuedMessage = captor.getValue();
		assertEquals("<colNORMAL>Your loot is worth around <colHIGHLIGHT>1,100,000,252<colNORMAL> coins.", queuedMessage.getRuneLiteFormattedMessage());
	}
}
