/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.timers;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.EnumSet;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.WorldType;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TimersPluginTest
{
	private static final String DMM_HALF_TELEBLOCK_MESSAGE = "<col=4f006f>A Tele Block spell has been cast on you by Runelite. It will expire in 1 minute, 15 seconds.</col>";
	private static final String FULL_TELEBLOCK_MESSAGE = "<col=4f006f>A Tele Block spell has been cast on you by Runelite. It will expire in 5 minutes, 0 seconds.</col>";
	private static final String HALF_TELEBLOCK_MESSAGE = "<col=4f006f>A Tele Block spell has been cast on you by Runelite. It will expire in 2 minutes, 30 seconds.</col>";

	@Inject
	private TimersPlugin timersPlugin;

	@Mock
	@Bind
	private TimersConfig timersConfig;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private SpriteManager spriteManager;

	@Mock
	@Bind
	private InfoBoxManager infoBoxManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testHalfTeleblock()
	{
		timersPlugin.setShowTeleblock(true);
		when(client.getWorldType()).thenReturn(EnumSet.of(WorldType.MEMBERS));
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", HALF_TELEBLOCK_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.HALFTB, infoBox.getTimer());
	}

	@Test
	public void testFullTeleblock()
	{
		timersPlugin.setShowTeleblock(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", FULL_TELEBLOCK_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.FULLTB, infoBox.getTimer());
	}

	@Test
	public void testDmmHalfTb()
	{
		timersPlugin.setShowTeleblock(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", DMM_HALF_TELEBLOCK_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.DMM_HALFTB, infoBox.getTimer());
	}

	@Test
	public void testDmmFullTb()
	{
		timersPlugin.setShowTeleblock(true);
		when(client.getWorldType()).thenReturn(EnumSet.of(WorldType.DEADMAN));
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", HALF_TELEBLOCK_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.DMM_FULLTB, infoBox.getTimer());
	}
}