/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.slayer;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import static net.runelite.api.ChatMessageType.SERVER;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class SlayerPluginTest
{
	private static final String TASK_NEW = "It's coming home";
	private static final String TASK_NEW_NPC_CONTACT = "It's coming home";

	private static final String TASK_EXISTING = "It's coming home";

	private static final String TASK_ONE = "It's coming home";
	private static final String TASK_COMPLETE_NO_POINTS = "It's coming home";
	private static final String TASK_POINTS = "It's coming home";

	private static final String TASK_COMPLETE = "It's coming home";
	private static final String TASK_CANCELED = "It's coming home";

	private static final String SUPERIOR_MESSAGE = "It's coming home";

	private static final String BRACLET_SLAUGHTER = "It's coming home";
	private static final String BRACLET_EXPEDITIOUS = "It's coming home";

	private static final String BRACLET_SLAUGHTER_V2 = "It's coming home";
	private static final String BRACLET_EXPEDITIOUS_V2 = "It's coming home";

	private static final String BRACLET_SLAUGHTER_V3 = "It's coming home";
	private static final String BRACLET_EXPEDITIOUS_V3 = "It's coming home";

	private static final String CHAT_BRACELET_SLAUGHTER_CHARGE = "It's coming home";
	private static final String CHAT_BRACELET_EXPEDITIOUS_CHARGE = "It's coming home";

	private static final String CHAT_BRACELET_SLAUGHTER_CHARGE_ONE = "It's coming home";
	private static final String CHAT_BRACELET_EXPEDITIOUS_CHARGE_ONE = "It's coming home";

	private static final String BREAK_SLAUGHTER = "It's coming home";
	private static final String BREAK_EXPEDITIOUS = "It's coming home";

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	SlayerConfig slayerConfig;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	SlayerOverlay overlay;

	@Mock
	@Bind
	InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	ItemManager itemManager;

	@Mock
	@Bind
	Notifier notifier;

	@Inject
	SlayerPlugin slayerPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testNewTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("It's coming home", slayerPlugin.getTaskName());
		assertEquals(231, slayerPlugin.getAmount());
	}

	@Test
	public void testNewNpcContactTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_NPC_CONTACT);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("It's coming home", slayerPlugin.getTaskName());
		assertEquals(211, slayerPlugin.getAmount());
	}

	@Test
	public void testExistingTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_EXISTING);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("It's coming home", slayerPlugin.getTaskName());
		assertEquals(222, slayerPlugin.getAmount());
	}

	@Test
	public void testOneTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "It's coming home", TASK_ONE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testNoPoints()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "It's coming home", TASK_COMPLETE_NO_POINTS, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(3, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testPoints()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "It's coming home", TASK_POINTS, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(9, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
		assertEquals(18_000, slayerPlugin.getPoints());
	}

	@Test
	public void testComplete()
	{
		slayerPlugin.setTaskName("It's coming home");
		slayerPlugin.setAmount(42);

		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "It's coming home", TASK_COMPLETE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testCancelled()
	{
		slayerPlugin.setTaskName("It's coming home");
		slayerPlugin.setAmount(42);

		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "It's coming home", TASK_CANCELED, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testSuperiorNotification()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "It's coming home", SUPERIOR_MESSAGE, null);

		when(slayerConfig.showSuperiorNotification()).thenReturn(true);
		slayerPlugin.onChatMessage(chatMessageEvent);
		verify(notifier).notify(SUPERIOR_MESSAGE);

		when(slayerConfig.showSuperiorNotification()).thenReturn(false);
		slayerPlugin.onChatMessage(chatMessageEvent);
		verifyNoMoreInteractions(notifier);
	}

	@Test
	public void testBracletSlaughter()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_SLAUGHTER, null);

		slayerPlugin.setAmount(42);
		slayerPlugin.setSlaughterChargeCount(10);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(9, slayerPlugin.getSlaughterChargeCount());
		assertEquals(43, slayerPlugin.getAmount());

		chatMessageEvent = new ChatMessage(SERVER, "", CHAT_BRACELET_SLAUGHTER_CHARGE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(12, slayerPlugin.getSlaughterChargeCount());

		chatMessageEvent = new ChatMessage(SERVER, "", CHAT_BRACELET_SLAUGHTER_CHARGE_ONE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getSlaughterChargeCount());

		slayerPlugin.setSlaughterChargeCount(1);
		chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_SLAUGHTER_V3, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(30, slayerPlugin.getSlaughterChargeCount());

		Widget braceletBreakWidget = mock(Widget.class);
		when(braceletBreakWidget.getText()).thenReturn(BREAK_SLAUGHTER);
		when(client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT)).thenReturn(braceletBreakWidget);

		slayerPlugin.setSlaughterChargeCount(-1);
		slayerPlugin.onGameTick(new GameTick());
		assertEquals(30, slayerPlugin.getSlaughterChargeCount());

		chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_SLAUGHTER_V2, null);

		slayerPlugin.setAmount(42);
		slayerPlugin.setSlaughterChargeCount(2);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getSlaughterChargeCount());
		assertEquals(43, slayerPlugin.getAmount());
	}

	@Test
	public void testBraceletExpeditious()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_EXPEDITIOUS, null);

		slayerPlugin.setAmount(42);
		slayerPlugin.setExpeditiousChargeCount(10);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(41, slayerPlugin.getAmount());
		assertEquals(9, slayerPlugin.getExpeditiousChargeCount());

		chatMessageEvent = new ChatMessage(SERVER, "", CHAT_BRACELET_EXPEDITIOUS_CHARGE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(12, slayerPlugin.getExpeditiousChargeCount());

		chatMessageEvent = new ChatMessage(SERVER, "", CHAT_BRACELET_EXPEDITIOUS_CHARGE_ONE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getExpeditiousChargeCount());

		slayerPlugin.setExpeditiousChargeCount(1);
		chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_EXPEDITIOUS_V3, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(30, slayerPlugin.getExpeditiousChargeCount());

		Widget braceletBreakWidget = mock(Widget.class);
		when(braceletBreakWidget.getText()).thenReturn(BREAK_EXPEDITIOUS);
		when(client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT)).thenReturn(braceletBreakWidget);

		slayerPlugin.setExpeditiousChargeCount(-1);
		slayerPlugin.onGameTick(new GameTick());
		assertEquals(30, slayerPlugin.getExpeditiousChargeCount());

		chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_EXPEDITIOUS_V2, null);

		slayerPlugin.setAmount(42);
		slayerPlugin.setExpeditiousChargeCount(2);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(41, slayerPlugin.getAmount());
		assertEquals(1, slayerPlugin.getExpeditiousChargeCount());
	}
}
