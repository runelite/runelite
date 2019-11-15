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
package net.runelite.client.plugins.chatnotifications;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.util.Text;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.OpenOSRSConfig;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChatNotificationsPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ChatNotificationsConfig config;

	@Mock
	@Bind
	private ChatMessageManager chatMessageManager;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private OpenOSRSConfig openOSRSConfig;

	@Inject
	private ChatNotificationsPlugin chatNotificationsPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void onChatMessage()
	{
		when(config.highlightWordsString()).thenReturn("Deathbeam, Deathbeam OSRS , test");

		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn("Deathbeam, Deathbeam OSRS");

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("<colHIGHLIGHT>Deathbeam<colNORMAL>, <colHIGHLIGHT>Deathbeam<colNORMAL> OSRS");
	}

	@Test
	public void testLtGt()
	{
		when(config.highlightWordsString()).thenReturn("<test>");

		String message = "test <lt>test<gt> test";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("test <colHIGHLIGHT><lt>test<gt><colNORMAL> test");
	}

	@Test
	public void testFullStop()
	{
		when(config.highlightWordsString()).thenReturn("test");

		String message = "foo test. bar";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("foo <colHIGHLIGHT>test<colNORMAL>. bar");
	}

	@Test
	public void testColor()
	{
		when(config.highlightWordsString()).thenReturn("you. It");

		String message = "Your dodgy necklace protects you. <col=ff0000>It has 1 charge left.</col>";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("Your dodgy necklace protects <colHIGHLIGHT>you. It<col=ff0000> has 1 charge left.</col>");
	}

	@Test
	public void testPreceedingColor()
	{
		when(config.highlightWordsString()).thenReturn("you. It");

		String message = "Your dodgy <col=00ff00>necklace protects you. It has 1 charge left.</col>";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("Your dodgy <col=00ff00>necklace protects <colHIGHLIGHT>you. It<col=00ff00> has 1 charge left.</col>");
	}

	@Test
	public void testEmoji()
	{
		when(config.highlightWordsString()).thenReturn("test");

		String message = "emoji test <img=29>";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("emoji <colHIGHLIGHT>test<colNORMAL> <img=29>");
	}

	@Test
	public void testNonMatchedColors()
	{
		when(config.highlightWordsString()).thenReturn("test");

		String message = "<col=ff0000>color</col> test <img=29>";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("<col=ff0000>color</col> <colHIGHLIGHT>test<colNORMAL> <img=29>");
	}

	@Test
	public void highlightListTest()
	{
		when(config.highlightWordsString()).thenReturn("this,is, a                   , test, ");
		final List<String> higlights = Text.fromCSV(config.highlightWordsString());
		assertEquals(4, higlights.size());

		final Iterator<String> iterator = higlights.iterator();
		assertEquals("this", iterator.next());
		assertEquals("is", iterator.next());
		assertEquals("a", iterator.next());
		assertEquals("test", iterator.next());
	}

	@Test
	public void testStripColor()
	{
		assertEquals("you. It", ChatNotificationsPlugin.stripColor("you. <col=ff0000>It"));
	}
}