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
package net.runelite.client.plugins.emojis;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Named;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.game.ChatIconManager;
import okhttp3.HttpUrl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmojiPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ClientThread clientThread;

	@Mock
	@Bind
	private ChatMessageManager chatMessageManager;

	@Mock
	@Bind
	private ChatIconManager chatIconManager;

	@Mock
	@Bind
	private ScheduledExecutorService scheduledExecutorService;

	@Bind
	@Named("runelite.static.base")
	private HttpUrl staticBase = HttpUrl.get("http://localhost");

	@Inject
	private EmojiPlugin emojiPlugin;

	private int iconId;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(chatIconManager.reserveChatIcon()).thenAnswer(a -> iconId++);
		when(chatIconManager.chatIconIndex(anyInt())).thenAnswer(a -> a.getArgument(0));

		EmojiPlugin.Index index = new EmojiPlugin.Index();
		index.names = Map.of("test", "1");

		emojiPlugin.startUp();
		emojiPlugin.index = index;
	}

	@Test
	public void testOnChatMessage()
	{
		MessageNode messageNode = mock(MessageNode.class);
		// With chat recolor, message may be wrapped in col tags
		when(messageNode.getValue()).thenReturn("<col=ff0000>:) :) :)</col>");

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);

		emojiPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("<col=ff0000><img=0> <img=0> <img=0></col>");
	}

	@Test
	public void testGtLt()
	{
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn("<gt>:D<lt>");

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);

		emojiPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("<img=0>");
	}

	@Test
	public void testEmojiUpdateMessage()
	{
		String PARTY_POPPER = "<img=0>";
		String OPEN_MOUTH = "<img=1>";
		assertNull(emojiPlugin.updateMessage("@@@@@"));
		assertEquals(PARTY_POPPER, emojiPlugin.updateMessage("@@@"));
		assertEquals(PARTY_POPPER + ' ' + PARTY_POPPER, emojiPlugin.updateMessage("@@@ @@@"));
		assertEquals(PARTY_POPPER + '\u00A0' + OPEN_MOUTH, emojiPlugin.updateMessage("@@@\u00A0:O"));
		assertEquals(PARTY_POPPER + '\u00A0' + OPEN_MOUTH + ' ' + PARTY_POPPER, emojiPlugin.updateMessage("@@@\u00A0:O @@@"));
		assertEquals(PARTY_POPPER + "\u00A0Hello World\u00A0" + PARTY_POPPER, emojiPlugin.updateMessage("@@@\u00A0Hello World\u00A0@@@"));
	}

	@Test
	public void testNamed()
	{
		assertEquals("test <img=0>", emojiPlugin.updateMessage("test :test:"));
	}
}