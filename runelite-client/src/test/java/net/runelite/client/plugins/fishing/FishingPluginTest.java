/*
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.fishing;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FishingPluginTest
{
	@Inject
	private FishingPlugin fishingPlugin;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private FishingConfig config;

	@Mock
	@Bind
	private FishingOverlay overlay;

	@Mock
	@Bind
	private FishingSpotOverlay spotOverlay;

	@Mock
	@Bind
	private FishingSpotMinimapOverlay fishingSpotMinimapOverlay;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testLobster()
	{
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.SPAM);
		chatMessage.setMessage("You catch a Lobster.");

		fishingPlugin.onChatMessage(chatMessage);

		assertNotNull(fishingPlugin.getSession().getLastFishCaught());
	}

	@Test
	public void testAnglerfish()
	{
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.SPAM);
		chatMessage.setMessage("You catch an Anglerfish.");

		fishingPlugin.onChatMessage(chatMessage);

		assertNotNull(fishingPlugin.getSession().getLastFishCaught());
	}

	@Test
	public void testCormorant()
	{
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.SPAM);
		chatMessage.setMessage("Your cormorant returns with its catch.");

		fishingPlugin.onChatMessage(chatMessage);

		assertNotNull(fishingPlugin.getSession().getLastFishCaught());
	}

	@Test
	public void testKarambwanji()
	{
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.SPAM);
		chatMessage.setMessage("You catch 15 Karambwanji.");

		fishingPlugin.onChatMessage(chatMessage);

		assertNotNull(fishingPlugin.getSession().getLastFishCaught());
	}
}