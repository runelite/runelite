/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, osrs-music-map <osrs-music-map@users.noreply.github.com>
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
package net.runelite.client.plugins.chatfilter;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.FriendsChatManager;
import net.runelite.api.FriendsChatMember;
import net.runelite.api.IterableHashTable;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ScriptCallbackEvent;
import static net.runelite.client.plugins.chatfilter.ChatFilterPlugin.CENSOR_MESSAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChatFilterPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	private FriendsChatManager friendsChatManager;

	@Mock
	@Bind
	private ChatFilterConfig chatFilterConfig;

	@Mock
	private Player localPlayer;

	@Inject
	private ChatFilterPlugin chatFilterPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.CENSOR_WORDS);
		when(chatFilterConfig.filteredWords()).thenReturn("");
		when(chatFilterConfig.filteredRegex()).thenReturn("");
		when(chatFilterConfig.filteredNames()).thenReturn("");

		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(client.getFriendsChatManager()).thenReturn(friendsChatManager);
	}

	private ScriptCallbackEvent createCallbackEvent(final String sender, final String chatMessage, final ChatMessageType messageType)
	{
		ScriptCallbackEvent event = new ScriptCallbackEvent();
		event.setScript(null);
		event.setEventName("chatFilterCheck");
		int[] simulatedIntStack =
			new int[]{1, messageType.getType(), 1}; // is msg allowed to show, ChatMessageType.PUBLICCHAT, message id
		String[] simulatedStringStack = new String[]{chatMessage};
		IterableHashTable<MessageNode> messageTable = mock(IterableHashTable.class);
		MessageNode mockedMsgNode = mockMessageNode(sender);
		when(client.getIntStack()).thenReturn(simulatedIntStack);
		when(client.getIntStackSize()).thenReturn(simulatedIntStack.length);
		when(client.getObjectStack()).thenReturn(simulatedStringStack);
		when(client.getObjectStackSize()).thenReturn(simulatedStringStack.length);
		when(client.getMessages()).thenReturn(messageTable);
		when(messageTable.get(1)).thenReturn(mockedMsgNode);
		return event;
	}

	private MessageNode mockMessageNode(String sender)
	{
		MessageNode node = mock(MessageNode.class);
		when(node.getName()).thenReturn(sender);
		return node;
	}

	private MessageNode mockMessageNode(int id)
	{
		MessageNode node = mock(MessageNode.class);
		when(node.getId()).thenReturn(id);
		return node;
	}

	private MessageNode mockMessageNode(int id, String sender, String value)
	{
		MessageNode node = mock(MessageNode.class);
		when(node.getId()).thenReturn(id);
		when(node.getName()).thenReturn(sender);
		when(node.getValue()).thenReturn(value);
		return node;
	}

	@Test
	public void testCensorWords()
	{
		when(chatFilterConfig.filteredWords()).thenReturn("hat");

		chatFilterPlugin.updateFilteredPatterns();
		assertEquals("w***s up", chatFilterPlugin.censorMessage("Blue", "whats up"));
	}

	@Test
	public void testCensorRegex()
	{
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.REMOVE_MESSAGE);
		when(chatFilterConfig.filteredRegex()).thenReturn("5[0-9]x2\n(");

		chatFilterPlugin.updateFilteredPatterns();
		assertNull(chatFilterPlugin.censorMessage("Blue", "55X2 Dicing | Trusted Ranks | Huge Pay Outs!"));
	}

	@Test
	public void testBrokenRegex()
	{
		when(chatFilterConfig.filteredRegex()).thenReturn("Test\n)\n73");

		chatFilterPlugin.updateFilteredPatterns();
		assertEquals("** isn't funny", chatFilterPlugin.censorMessage("Blue", "73 isn't funny"));
	}

	@Test
	public void testCaseSensitivity()
	{
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.CENSOR_MESSAGE);
		when(chatFilterConfig.filteredWords()).thenReturn("ReGeX!!!");

		chatFilterPlugin.updateFilteredPatterns();
		assertEquals(CENSOR_MESSAGE, chatFilterPlugin.censorMessage("Blue", "I love regex!!!!!!!!"));
	}

	@Test
	public void testNonPrintableCharacters()
	{
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.REMOVE_MESSAGE);
		when(chatFilterConfig.filteredWords()).thenReturn("test");

		chatFilterPlugin.updateFilteredPatterns();
		assertNull(chatFilterPlugin.censorMessage("Blue", "te\u008Cst"));
	}

	@Test
	public void testReplayedMessage()
	{
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.REMOVE_MESSAGE);
		when(chatFilterConfig.filteredWords()).thenReturn("hello osrs");

		chatFilterPlugin.updateFilteredPatterns();
		assertNull(chatFilterPlugin.censorMessage("Blue", "hello\u00A0osrs"));
	}

	@Test
	public void testFilterUnicode()
	{
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.CENSOR_WORDS);
		when(chatFilterConfig.filteredWords()).thenReturn("filterme");
		when(chatFilterConfig.stripAccents()).thenReturn(true);

		chatFilterPlugin.updateFilteredPatterns();
		assertEquals("plëäsë ******** plügïn", chatFilterPlugin.censorMessage("Blue", "plëäsë fïltërmë plügïn"));
	}

	@Test
	public void testUnicodeFiltersUnicode()
	{
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.CENSOR_WORDS);
		when(chatFilterConfig.filteredWords()).thenReturn("plëäsë");

		chatFilterPlugin.updateFilteredPatterns();
		assertEquals("****** fïltërmë plügïn", chatFilterPlugin.censorMessage("Blue", "plëäsë fïltërmë plügïn"));
	}

	@Test
	public void testMixedUnicodeFiltersUnicode()
	{
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.CENSOR_WORDS);
		when(chatFilterConfig.filteredWords()).thenReturn("plëäsë, filterme");
		when(chatFilterConfig.stripAccents()).thenReturn(true);

		chatFilterPlugin.updateFilteredPatterns();
		assertEquals("****** ******** plügïn", chatFilterPlugin.censorMessage("Blue", "plëäsë fïltërmë plügïn"));
	}

	@Test
	public void testMessageFromFriendIsFiltered()
	{
		when(chatFilterConfig.filterFriends()).thenReturn(true);
		assertTrue(chatFilterPlugin.canFilterPlayer("Iron Mammal"));
	}

	@Test
	public void testMessageFromFriendIsNotFiltered()
	{
		when(client.isFriended("Iron Mammal", false)).thenReturn(true);
		when(chatFilterConfig.filterFriends()).thenReturn(false);
		assertFalse(chatFilterPlugin.canFilterPlayer("Iron Mammal"));
	}

	@Test
	public void testMessageFromFriendsChatIsFiltered()
	{
		when(client.isFriended("B0aty", false)).thenReturn(false);
		when(chatFilterConfig.filterFriendsChat()).thenReturn(true);
		assertTrue(chatFilterPlugin.canFilterPlayer("B0aty"));
	}

	@Test
	public void testMessageFromFriendsChatIsNotFiltered()
	{
		when(friendsChatManager.findByName("B0aty")).thenReturn(mock(FriendsChatMember.class));
		when(chatFilterConfig.filterFriendsChat()).thenReturn(false);
		assertFalse(chatFilterPlugin.canFilterPlayer("B0aty"));
	}

	@Test
	public void testMessageFromSelfIsNotFiltered()
	{
		when(localPlayer.getName()).thenReturn("Swampletics");
		assertFalse(chatFilterPlugin.canFilterPlayer("Swampletics"));
	}

	@Test
	public void testMessageFromNonFriendNonFCIsFiltered()
	{
		when(client.isFriended("Woox", false)).thenReturn(false);
		assertTrue(chatFilterPlugin.canFilterPlayer("Woox"));
	}

	@Test
	public void testShouldFilterByName()
	{
		when(chatFilterConfig.filteredNames()).thenReturn("Gamble [0-9]*");

		chatFilterPlugin.updateFilteredPatterns();
		assertTrue(chatFilterPlugin.isNameFiltered("Gamble 1234"));
		assertFalse(chatFilterPlugin.isNameFiltered("Adam"));
	}

	@Test
	public void testCensorWordsByName()
	{
		when(chatFilterConfig.filteredNames()).thenReturn("Blue");
		chatFilterPlugin.updateFilteredPatterns();
		assertEquals("************", chatFilterPlugin.censorMessage("Blue", "Gamble today"));
	}

	@Test
	public void textCensorMessageByName()
	{
		when(chatFilterConfig.filteredNames()).thenReturn("Blue");
		chatFilterPlugin.updateFilteredPatterns();
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.CENSOR_MESSAGE);
		assertEquals(CENSOR_MESSAGE,
			chatFilterPlugin.censorMessage("Blue", "Meet swampletics, my morytania locked ultimate ironman"));
	}

	@Test
	public void testRemoveMessageByName()
	{
		when(chatFilterConfig.filteredNames()).thenReturn("Blue");
		chatFilterPlugin.updateFilteredPatterns();
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.REMOVE_MESSAGE);
		assertNull(
			chatFilterPlugin.censorMessage("Blue", "What about now it's time to rock with the biggity buck bumble"));
	}

	@Test
	public void testEventRemoveByName()
	{
		when(chatFilterConfig.filteredNames()).thenReturn("Gamble [0-9]*");
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.REMOVE_MESSAGE);

		chatFilterPlugin.updateFilteredPatterns();
		ScriptCallbackEvent event = createCallbackEvent("Gamble 1234", "filterme", ChatMessageType.PUBLICCHAT);
		chatFilterPlugin.onScriptCallbackEvent(event);
		assertEquals(0, client.getIntStack()[client.getIntStackSize() - 3]);
	}

	@Test
	public void testEventRemoveByText()
	{
		when(chatFilterConfig.filteredWords()).thenReturn("filterme");
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.REMOVE_MESSAGE);

		chatFilterPlugin.updateFilteredPatterns();
		ScriptCallbackEvent event = createCallbackEvent("Adam", "please filterme plugin", ChatMessageType.PUBLICCHAT);
		chatFilterPlugin.onScriptCallbackEvent(event);
		assertEquals(0, client.getIntStack()[client.getIntStackSize() - 3]);
	}

	@Test
	public void testEventCensorWordsByName()
	{
		when(chatFilterConfig.filteredNames()).thenReturn("Gamble [0-9]*");
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.CENSOR_WORDS);

		chatFilterPlugin.updateFilteredPatterns();
		ScriptCallbackEvent event = createCallbackEvent("Gamble 1234", "filterme", ChatMessageType.PUBLICCHAT);
		chatFilterPlugin.onScriptCallbackEvent(event);
		assertEquals("********", client.getObjectStack()[client.getObjectStackSize() - 1]);
	}

	@Test
	public void testEventCensorWordsByText()
	{
		when(chatFilterConfig.filteredWords()).thenReturn("filterme");
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.CENSOR_WORDS);

		chatFilterPlugin.updateFilteredPatterns();
		ScriptCallbackEvent event = createCallbackEvent("Adam", "please filterme plugin", ChatMessageType.PUBLICCHAT);
		chatFilterPlugin.onScriptCallbackEvent(event);
		assertEquals("please ******** plugin", client.getObjectStack()[client.getObjectStackSize() - 1]);
	}

	@Test
	public void testEventCensorMessageByName()
	{
		when(chatFilterConfig.filteredNames()).thenReturn("Gamble [0-9]*");
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.CENSOR_MESSAGE);

		chatFilterPlugin.updateFilteredPatterns();
		ScriptCallbackEvent event = createCallbackEvent("Gamble 1234", "filterme", ChatMessageType.PUBLICCHAT);
		chatFilterPlugin.onScriptCallbackEvent(event);
		assertEquals(CENSOR_MESSAGE, client.getObjectStack()[client.getObjectStackSize() - 1]);
	}

	@Test
	public void testEventCensorMessageByText()
	{
		when(chatFilterConfig.filteredWords()).thenReturn("filterme");
		when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.CENSOR_MESSAGE);

		chatFilterPlugin.updateFilteredPatterns();
		ScriptCallbackEvent event = createCallbackEvent("Adam", "please filterme plugin", ChatMessageType.PUBLICCHAT);
		chatFilterPlugin.onScriptCallbackEvent(event);
		assertEquals(CENSOR_MESSAGE, client.getObjectStack()[client.getObjectStackSize() - 1]);
	}

	@Test
	public void testDuplicateChatFiltered()
	{
		when(chatFilterConfig.collapseGameChat()).thenReturn(true);
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(0, null, "testMessage"), ChatMessageType.GAMEMESSAGE, null, null, null, 0));
		ScriptCallbackEvent event = createCallbackEvent(null, "testMessage", ChatMessageType.GAMEMESSAGE);
		chatFilterPlugin.onScriptCallbackEvent(event);

		assertEquals(0, client.getIntStack()[client.getIntStackSize() - 3]);
	}

	@Test
	public void testNoDuplicate()
	{
		when(chatFilterConfig.collapseGameChat()).thenReturn(true);
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(1), ChatMessageType.GAMEMESSAGE, null, "testMessage", null, 0));
		ScriptCallbackEvent event = createCallbackEvent(null, "testMessage", ChatMessageType.GAMEMESSAGE);
		chatFilterPlugin.onScriptCallbackEvent(event);

		assertEquals(1, client.getIntStack()[client.getIntStackSize() - 3]);
		assertEquals("testMessage", client.getObjectStack()[client.getObjectStackSize() - 1]);
	}

	@Test
	public void testDuplicateChatCount()
	{
		when(chatFilterConfig.collapseGameChat()).thenReturn(true);
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(4, null, "testMessage"), ChatMessageType.GAMEMESSAGE, null, null, null, 0));
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(3, null, "testMessage"), ChatMessageType.GAMEMESSAGE, null, null, null, 0));
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(2, null, "testMessage"), ChatMessageType.GAMEMESSAGE, null, null, null, 0));
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(1, null, "testMessage"), ChatMessageType.GAMEMESSAGE, null, null, null, 0));
		ScriptCallbackEvent event = createCallbackEvent(null, "testMessage", ChatMessageType.GAMEMESSAGE);
		chatFilterPlugin.onScriptCallbackEvent(event);

		assertEquals(1, client.getIntStack()[client.getIntStackSize() - 3]);
		assertEquals("testMessage (4)", client.getObjectStack()[client.getObjectStackSize() - 1]);
	}

	@Test
	public void publicChatFilteredOnDuplicate()
	{
		when(chatFilterConfig.collapsePlayerChat()).thenReturn(true);
		when(chatFilterConfig.maxRepeatedPublicChats()).thenReturn(2);
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(1, "testName", "testMessage"), ChatMessageType.PUBLICCHAT, null, null, null, 0));
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(1, "testName", "testMessage"), ChatMessageType.PUBLICCHAT, null, null, null, 0));
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(1, "testName", "testMessage"), ChatMessageType.PUBLICCHAT, null, null, null, 0));
		ScriptCallbackEvent event = createCallbackEvent("testName", "testMessage", ChatMessageType.PUBLICCHAT);
		chatFilterPlugin.onScriptCallbackEvent(event);

		assertEquals(0, client.getIntStack()[client.getIntStackSize() - 3]);
	}

	@Test
	public void testDuplicateChatFilterIgnoresFormatting()
	{
		when(chatFilterConfig.collapseGameChat()).thenReturn(true);
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(4, null, "<col=000000>testMessage</col>"), ChatMessageType.GAMEMESSAGE, null, null, null, 0));
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(3, null, "<col=000000>testMessage</col>"), ChatMessageType.GAMEMESSAGE, null, null, null, 0));
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(2, null, "<col=000000>testMessage</col>"), ChatMessageType.GAMEMESSAGE, null, null, null, 0));
		chatFilterPlugin.onChatMessage(new ChatMessage(mockMessageNode(1, null, "<col=000000>testMessage</col>"), ChatMessageType.GAMEMESSAGE, null, null, null, 0));
		ScriptCallbackEvent event = createCallbackEvent(null, "<col=000000>testMessage</col>", ChatMessageType.GAMEMESSAGE);
		chatFilterPlugin.onScriptCallbackEvent(event);

		assertEquals(1, client.getIntStack()[client.getIntStackSize() - 3]);
		assertEquals("<col=000000>testMessage</col> (4)", client.getObjectStack()[client.getObjectStackSize() - 1]);
	}

	@Test
	public void testChatIcons()
	{
		when(chatFilterConfig.filteredWords()).thenReturn("test");
		// if this test is broken, this stubbing is required to trip the assert
		lenient().when(chatFilterConfig.filterType()).thenReturn(ChatFilterType.REMOVE_MESSAGE);
		when(friendsChatManager.findByName("Lazark")).thenReturn(mock(FriendsChatMember.class));

		chatFilterPlugin.updateFilteredPatterns();
		ScriptCallbackEvent event = createCallbackEvent("<img=22>Lazark", "test", ChatMessageType.PUBLICCHAT);
		chatFilterPlugin.onScriptCallbackEvent(event);
		assertEquals(1, client.getIntStack()[client.getIntStackSize() - 3]); // not filtered
	}

	@Test
	public void testLtGt()
	{
		when(chatFilterConfig.filteredWords()).thenReturn("f<ilte>r");

		chatFilterPlugin.updateFilteredPatterns();

		String message = chatFilterPlugin.censorMessage("Adam", "start f<lt>ilte<gt>r end");
		assertEquals("start ******** end", message);
	}
}