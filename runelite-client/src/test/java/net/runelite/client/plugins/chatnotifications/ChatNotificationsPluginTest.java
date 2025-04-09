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
import javax.inject.Named;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.util.Text;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
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
	private Notifier notifier;

	@Bind
	@Named("runelite.title")
	private String runeliteTitle = "RuneLite";

	@Inject
	private ChatNotificationsPlugin chatNotificationsPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(config.highlightRegexString()).thenReturn("");
		when(config.highlightWordsString()).thenReturn("");
	}

	@Test
	public void onChatMessage()
	{
		when(config.highlightWordsString()).thenReturn("Deathbeam, Deathbeam OSRS , test");

		var message = "Deathbeam, Deathbeam OSRS";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);
		chatMessage.setMessage(message);
		chatMessage.setName("");

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("<colHIGHLIGHT>Deathbeam<colNORMAL>, <colHIGHLIGHT>Deathbeam<colNORMAL> OSRS");
	}

	@Test
	public void testRegexMultiplePatternsMessage()
	{
		when(config.highlightRegexString()).thenReturn("brandie+\ntest");

		var message = "brandieeee testing";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);
		chatMessage.setMessage(message);
		chatMessage.setName("");

		chatNotificationsPlugin.startUp();
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("<colHIGHLIGHT>brandieeee<colNORMAL> <colHIGHLIGHT>test<colNORMAL>ing");
	}

	@Test
	public void testRegexMultiplePatternsWithOnlyOneMatch()
	{
		when(config.highlightRegexString()).thenReturn("brandie+\nwillNotMatch");

		var message = "brandieeee testing";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);
		chatMessage.setMessage(message);
		chatMessage.setName("");

		chatNotificationsPlugin.startUp();
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("<colHIGHLIGHT>brandieeee<colNORMAL> testing");
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
		chatMessage.setMessage(message);
		chatMessage.setName("");

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("test <colHIGHLIGHT><lt>test<gt><colNORMAL> test");
	}

	@Test
	public void testMatchEntireMessage()
	{
		when(config.highlightWordsString()).thenReturn(".Your divine potion effect is about to expire.");

		String message = ".Your divine potion effect is about to expire.";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);
		chatMessage.setMessage(message);
		chatMessage.setName("");

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("<colHIGHLIGHT>.Your divine potion effect is about to expire.<colNORMAL>");
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
		chatMessage.setMessage(message);
		chatMessage.setName("");

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
		chatMessage.setMessage(message);
		chatMessage.setName("");

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("Your dodgy necklace protects <colHIGHLIGHT>you. It<col=ff0000> has 1 charge left.</col>");
	}

	@Test
	public void testPrecedingColor()
	{
		when(config.highlightWordsString()).thenReturn("you. It");

		String message = "Your dodgy <col=00ff00>necklace protects you. It has 1 charge left.</col>";
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn(message);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setMessageNode(messageNode);
		chatMessage.setMessage(message);
		chatMessage.setName("");

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
		chatMessage.setMessage(message);
		chatMessage.setName("");

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
		chatMessage.setName("");
		chatMessage.setMessage(message);

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("<col=ff0000>color</col> <colHIGHLIGHT>test<colNORMAL> <img=29>");
	}

	@Test
	public void highlightListTest()
	{
		when(config.highlightWordsString()).thenReturn("this,is, a                   , test, ");
		final List<String> highlights = Text.fromCSV(config.highlightWordsString());
		assertEquals(4, highlights.size());

		final Iterator<String> iterator = highlights.iterator();
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

	@Test
	public void testHighlightOwnName()
	{
		Player player = mock(Player.class);
		when(player.getName()).thenReturn("Logic Knot");
		when(client.getLocalPlayer()).thenReturn(player);

		when(config.highlightOwnName()).thenReturn(true);

		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn("Logic Knot received a drop: Adamant longsword");
		ChatMessage chatMessage = new ChatMessage(messageNode, ChatMessageType.GAMEMESSAGE, "", "", "", 0);
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("<colHIGHLIGHT><u>Logic Knot</u><colNORMAL> received a drop: Adamant longsword");
	}

	@Test
	public void testHighlightOwnNameNbsp()
	{
		Player player = mock(Player.class);
		when(player.getName()).thenReturn("Logic Knot");
		when(client.getLocalPlayer()).thenReturn(player);

		when(config.highlightOwnName()).thenReturn(true);

		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn("<col=005f00>Logic\u00a0Knot received a drop: Adamant longsword</col>");
		ChatMessage chatMessage = new ChatMessage(messageNode, ChatMessageType.GAMEMESSAGE, "", "", "", 0);
		chatNotificationsPlugin.onChatMessage(chatMessage);

		// set value uses our player name, which has nbsp replaced
		verify(messageNode).setValue("<col=005f00><colHIGHLIGHT><u>Logic Knot</u><col=005f00> received a drop: Adamant longsword</col>");
	}

	@Test
	public void testLocalPlayerSelfMention()
	{
		final String localPlayerName = "Broo klyn";

		MessageNode messageNode = mock(MessageNode.class);

		Player localPlayer = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(localPlayer.getName()).thenReturn(localPlayerName);

		lenient().when(config.highlightOwnName()).thenReturn(true);
		lenient().when(messageNode.getValue()).thenReturn("Spread love it's the Broo klyn way");

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setName("Broo\u00a0klyn");
		chatMessage.setMessageNode(messageNode);

		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode, times(0)).setValue(any());
	}

	@Test
	public void testPrivateChatOutReturn()
	{
		MessageNode messageNode = mock(MessageNode.class);

		lenient().when(config.highlightWordsString()).thenReturn("Brooklyn");
		lenient().when(messageNode.getValue()).thenReturn("Spread love it's the Brooklyn way");

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PRIVATECHATOUT);
		chatMessage.setMessageNode(messageNode);

		chatNotificationsPlugin.startUp();
		chatNotificationsPlugin.onChatMessage(chatMessage);

		verify(messageNode, times(0)).setValue(any());
	}
}
