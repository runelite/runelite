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
import java.time.Duration;
import java.util.EnumSet;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.WorldType;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TimersPluginTest
{
	private static final String DMM_HALF_TELEBLOCK_MESSAGE = "<col=4f006f>A Tele Block spell has been cast on you by Runelite. It will expire in 1 minute, 15 seconds.</col>";
	private static final String FULL_TELEBLOCK_MESSAGE = "<col=4f006f>A Tele Block spell has been cast on you by Runelite. It will expire in 5 minutes.</col>";
	private static final String HALF_TELEBLOCK_MESSAGE = "<col=4f006f>A Tele Block spell has been cast on you by Runelite. It will expire in 2 minutes, 30 seconds.</col>";
	private static final String TRANSPARENT_CHATBOX_FULL_TELEBLOCK_MESSAGE = "<col=c356ef>A Tele Block spell has been cast on you by Alexsuperfly. It will expire in 5 minutes.</col>";
	private static final String TRANSPARENT_CHATBOX_TELEBLOCK_REMOVED_MESSAGE = "<col=c356ef>Your Tele Block has been removed because you killed Alexsuperfly.</col>";

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
		when(timersConfig.showTeleblock()).thenReturn(true);
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
		when(timersConfig.showTeleblock()).thenReturn(true);
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
		when(timersConfig.showTeleblock()).thenReturn(true);
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
		when(timersConfig.showTeleblock()).thenReturn(true);
		when(client.getWorldType()).thenReturn(EnumSet.of(WorldType.DEADMAN));
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", HALF_TELEBLOCK_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.DMM_FULLTB, infoBox.getTimer());
	}

	@Test
	public void testDivineBastion()
	{
		when(timersConfig.showDivine()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You drink some of your divine bastion potion.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.DIVINE_BASTION, infoBox.getTimer());
	}

	@Test
	public void testDivineBattlemage()
	{
		when(timersConfig.showDivine()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You drink some of your divine battlemage potion.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.DIVINE_BATTLEMAGE, infoBox.getTimer());
	}

	@Test
	public void testTransparentChatboxTb()
	{
		when(timersConfig.showTeleblock()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", TRANSPARENT_CHATBOX_FULL_TELEBLOCK_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.FULLTB, infoBox.getTimer());
	}

	@Test
	public void testTransparentChatboxTbRemoved()
	{
		when(timersConfig.showTeleblock()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", TRANSPARENT_CHATBOX_TELEBLOCK_REMOVED_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);

		verify(infoBoxManager, atLeastOnce()).removeIf(any());
	}

	@Test
	public void testStamina()
	{
		when(timersConfig.showStamina()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You drink some of your stamina potion.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.STAMINA, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(2), infoBox.getDuration());
	}

	@Test
	public void testEndurance()
	{
		when(timersConfig.showStamina()).thenReturn(true);

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "Your Ring of endurance doubles the duration of your stamina potion's effect.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You drink some of your stamina potion.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.STAMINA, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(4), infoBox.getDuration());

		// unwield ring
		timersPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), mock(ItemContainer.class)));
		// some time has elapsed in the test; this should be just under 2 mins
		int mins = (int) infoBox.getDuration().toMinutes();
		assertTrue(mins == 1 || mins == 2);
	}
}