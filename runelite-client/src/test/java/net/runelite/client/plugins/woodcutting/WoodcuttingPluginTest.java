/*
 * Copyright (c) 2019, Jordan Zomerlei <jordan@zomerlei.com>
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
package net.runelite.client.plugins.woodcutting;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.config.OpenOSRSConfig;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WoodcuttingPluginTest
{
	private static final String BIRDS_NEST_MESSAGE = "A bird's nest falls out of the tree.";

	@Inject
	WoodcuttingPlugin woodcuttingPlugin;

	@Mock
	@Bind
	WoodcuttingConfig woodcuttingConfig;

	@Mock
	@Bind
	OpenOSRSConfig openOSRSConfig;

	@Mock
	@Bind
	ScheduledExecutorService scheduledExecutorService;

	@Mock
	@Bind
	Notifier notifier;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	WoodcuttingOverlay woodcuttingOverlay;

	@Mock
	@Bind
	WoodcuttingTreesOverlay woodcuttingTreesOverlay;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testLogs()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You get some logs.", "", 0);
		woodcuttingPlugin.onChatMessage(chatMessage);
		assertNotNull(woodcuttingPlugin.getSession());
	}

	@Test
	public void testOakLogs()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You get some oak logs.", "", 0);
		woodcuttingPlugin.onChatMessage(chatMessage);
		assertNotNull(woodcuttingPlugin.getSession());
	}

	@Test
	public void testArcticLogs()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You get an arctic log.", "", 0);
		woodcuttingPlugin.onChatMessage(chatMessage);
		assertNotNull(woodcuttingPlugin.getSession());
	}

	@Test
	public void testMushrooms()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You get some mushrooms.", "", 0);
		woodcuttingPlugin.onChatMessage(chatMessage);
		assertNotNull(woodcuttingPlugin.getSession());
	}

	@Test
	public void testBirdsNest()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BIRDS_NEST_MESSAGE, "", 0);

		when(woodcuttingConfig.showNestNotification()).thenReturn(true);
		woodcuttingPlugin.onChatMessage(chatMessage);
		verify(notifier).notify("A bird nest has spawned!");

		when(woodcuttingConfig.showNestNotification()).thenReturn(false);
		woodcuttingPlugin.onChatMessage(chatMessage);
		verifyNoMoreInteractions(notifier);
	}
}