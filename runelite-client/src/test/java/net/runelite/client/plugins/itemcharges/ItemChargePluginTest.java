/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.itemcharges;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.ui.overlay.OverlayManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemChargePluginTest
{
	private static final String CHECK = "Your dodgy necklace has 10 charges left.";
	private static final String PROTECT = "Your dodgy necklace protects you. It has 9 charges left.";
	private static final String PROTECT_1 = "Your dodgy necklace protects you. <col=ff0000>It has 1 charge left.</col>";
	private static final String BREAK = "Your dodgy necklace protects you. <col=ff0000>It then crumbles to dust.</col>";

	private static final String CHECK_RING_OF_FORGING_FULL = "You can smelt 140 more pieces of iron ore before a ring melts.";
	private static final String CHECK_RING_OF_FORGING_ONE = "You can smelt one more piece of iron ore before a ring melts.";
	private static final String USED_RING_OF_FORGING = "You retrieve a bar of iron.";
	private static final String BREAK_RING_OF_FORGING = "<col=7f007f>Your Ring of Forging has melted.</col>";

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ScheduledExecutorService scheduledExecutorService;

	@Mock
	@Bind
	private RuneLiteConfig runeLiteConfig;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private ItemChargeConfig config;

	@Inject
	private ItemChargePlugin itemChargePlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testOnChatMessage()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).dodgyNecklace(eq(10));
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", PROTECT, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).dodgyNecklace(eq(9));
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", PROTECT_1, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).dodgyNecklace(eq(1));
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).dodgyNecklace(eq(10));
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_RING_OF_FORGING_ONE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).ringOfForging(eq(1));
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_RING_OF_FORGING_FULL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).ringOfForging(eq(140));
		reset(config);

		// Create equipment inventory with ring of forging
		ItemContainer equipmentItemContainer = mock(ItemContainer.class);
		when(client.getItemContainer(eq(InventoryID.EQUIPMENT))).thenReturn(equipmentItemContainer);
		Item[] items = new Item[EquipmentInventorySlot.RING.getSlotIdx() + 1];
		when(equipmentItemContainer.getItems()).thenReturn(items);
		Item ring = new Item(ItemID.RING_OF_FORGING, 1);
		items[EquipmentInventorySlot.RING.getSlotIdx()] = ring;
		// Run message
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_RING_OF_FORGING, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).ringOfForging(eq(139));
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_RING_OF_FORGING, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).ringOfForging(eq(140));
		reset(config);
	}
}