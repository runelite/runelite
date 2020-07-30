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
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import java.time.Instant;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.isA;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ElapsedTimerTest
{
	private static final int FIGHT_CAVES_REGION_ID = 9551;
	private static final String TZHAAR_WAVE1_MESSAGE = "Wave: 1";
	private static final String TZHAAR_WAVE2_MESSAGE = "Wave: 2";
	private static final String TZHAAR_PAUSED_MESSAGE = "The Inferno has been paused. You may now log out.";
	private static final String TZHAAR_DEFEATED_MESSAGE = "You have been defeated!";

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
	public void testTzhaarTimer()
	{
		when(timersConfig.showTzhaarTimers()).thenReturn(true);
		when(client.getMapRegions()).thenReturn(new int[]{FIGHT_CAVES_REGION_ID});
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", TZHAAR_WAVE1_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);

		// test timer creation: verify the infobox was added and that it is an ElapsedTimer
		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(isA(ElapsedTimer.class));
		verify(infoBoxManager, times(1)).addInfoBox(captor.capture());
		Instant oldTime = ((ElapsedTimer) captor.getValue()).getStartTime();

		// test timer pause: verify the added ElapsedTimer has a non-null lastTime
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", TZHAAR_PAUSED_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);
		verify(infoBoxManager, atLeastOnce()).removeInfoBox(captor.capture());
		captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager, times(2)).addInfoBox(captor.capture());
		ElapsedTimer timer = (ElapsedTimer) captor.getValue();
		assertNotEquals(timer.getLastTime(), null);

		// test timer unpause: verify the start time is not equal to the original start time after being unpaused
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", TZHAAR_WAVE2_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);
		verify(infoBoxManager, atLeastOnce()).removeInfoBox(captor.capture());
		captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager, times(3)).addInfoBox(captor.capture());
		timer = (ElapsedTimer) captor.getValue();
		assertNotEquals(timer.getStartTime(), oldTime);

		// test timer remove: verify the infobox was removed (and no more were added)
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", TZHAAR_DEFEATED_MESSAGE, "", 0);
		timersPlugin.onChatMessage(chatMessage);
		verify(infoBoxManager, atLeastOnce()).removeInfoBox(captor.capture());
		verify(infoBoxManager, times(3)).addInfoBox(captor.capture());
	}
}