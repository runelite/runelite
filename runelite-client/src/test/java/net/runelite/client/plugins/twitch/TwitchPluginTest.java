/*
 * Copyright (c) 2026, wukuna
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
package net.runelite.client.plugins.twitch;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.VarClientID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.TwitchMessage;
import net.runelite.client.plugins.twitch.irc.TwitchIRCClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TwitchPluginTest
{
	@Mock
	private Client client;

	@Mock
	private ClientThread clientThread;

	@Mock
	private TwitchConfig config;

	@Mock
	private ChatMessageManager chatMessageManager;

	@Mock
	private EventBus eventBus;

	@Mock
	private TwitchIRCClient twitchIRCClient;

	@InjectMocks
	private TwitchPlugin plugin;

	private final Queue<Runnable> callbacks = new ArrayDeque<>();

	@Before
	public void setUp()
	{
		lenient().when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		lenient().when(config.overlayIntegration()).thenCallRealMethod();
		lenient().when(config.showInChatbox()).thenCallRealMethod();
		lenient().when(config.showNotices()).thenCallRealMethod();
		lenient().when(config.ignoredUsernames()).thenCallRealMethod();
		lenient().doAnswer(invocation ->
		{
			callbacks.add(invocation.getArgument(0));
			return null;
		}).when(clientThread).invokeLater(any(Runnable.class));
	}

	private void drain()
	{
		while (!callbacks.isEmpty())
		{
			callbacks.remove().run();
		}
	}

	@Test
	public void defaultsPreserveNativeChatWithoutPublishingEvents()
	{
		assertFalse(config.overlayIntegration());
		assertTrue(config.showInChatbox());
		assertTrue(config.showNotices());
		assertEquals("", config.ignoredUsernames());
		plugin.privmsg("alice", Map.of("display-name", "Alice"), "hello");
		drain();

		verifyNoInteractions(eventBus);
		ArgumentCaptor<QueuedMessage> queued = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(queued.capture());
		assertEquals(ChatMessageType.FRIENDSCHAT, queued.getValue().getType());
		assertEquals("Twitch", queued.getValue().getSender());
		assertEquals("Alice", queued.getValue().getName());
		assertTrue(queued.getValue().getRuneLiteFormattedMessage().contains("hello"));
	}

	@Test
	public void enablingBothOutputsPublishesTheSameMessageAndTimestamp()
	{
		when(config.overlayIntegration()).thenReturn(true);
		plugin.privmsg("alice", Map.of("display-name", "Alice"), "hello");
		verifyNoInteractions(eventBus, chatMessageManager);
		drain();

		ArgumentCaptor<TwitchMessage> event = ArgumentCaptor.forClass(TwitchMessage.class);
		verify(eventBus).post(event.capture());
		ArgumentCaptor<QueuedMessage> queued = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(queued.capture());
		assertEquals("Alice", event.getValue().getSender());
		assertEquals("hello", event.getValue().getMessage());
		assertEquals(ChatMessageType.FRIENDSCHAT, queued.getValue().getType());
		assertEquals("Twitch", queued.getValue().getSender());
		assertEquals("Alice", queued.getValue().getName());
		assertEquals(event.getValue().getTimestamp(), queued.getValue().getTimestamp());
	}

	@Test
	public void disablingNativeChatKeepsIncomingMessagesAvailable()
	{
		when(config.overlayIntegration()).thenReturn(true);
		when(config.showInChatbox()).thenReturn(false);
		plugin.privmsg("alice", Map.of("display-name", "Alice"), "hello");
		drain();

		verify(eventBus).post(any(TwitchMessage.class));
		verifyNoInteractions(chatMessageManager);
	}

	@Test
	public void systemNoticesRemainAvailableWithoutNativeChat()
	{
		when(config.overlayIntegration()).thenReturn(true);
		when(config.showInChatbox()).thenReturn(false);
		plugin.usernotice(Map.of("system-msg", "Alice subscribed"), "");
		drain();

		ArgumentCaptor<TwitchMessage> event = ArgumentCaptor.forClass(TwitchMessage.class);
		verify(eventBus).post(event.capture());
		assertEquals("[System]", event.getValue().getSender());
		assertEquals("Alice subscribed", event.getValue().getMessage());
		verifyNoInteractions(chatMessageManager);
	}

	@Test
	public void nativeSlashTStillSendsAndEchoesOnlyToTheEventWhenDisabled() throws Exception
	{
		when(config.overlayIntegration()).thenReturn(true);
		when(config.showInChatbox()).thenReturn(false);
		when(config.username()).thenReturn("alice");
		when(client.getVarcStrValue(VarClientID.CHATINPUT)).thenReturn("/t hello");
		int[] stack = new int[3];
		when(client.getIntStack()).thenReturn(stack);
		when(client.getIntStackSize()).thenReturn(stack.length);
		ScriptCallbackEvent callback = new ScriptCallbackEvent();
		callback.setEventName("chatDefaultReturn");
		plugin.onScriptCallbackEvent(callback);
		drain();

		assertEquals(1, stack[0]);
		verify(twitchIRCClient).privmsg("hello");
		ArgumentCaptor<TwitchMessage> event = ArgumentCaptor.forClass(TwitchMessage.class);
		verify(eventBus).post(event.capture());
		assertEquals("alice", event.getValue().getSender());
		assertEquals("hello", event.getValue().getMessage());
		verifyNoInteractions(chatMessageManager);
	}

	@Test
	public void changingOutputsOrFiltersDoesNotReconnect()
	{
		ConfigChanged change = new ConfigChanged();
		change.setGroup("twitch");
		change.setKey("overlayIntegration");
		plugin.onConfigChanged(change);
		change.setKey("showInChatbox");
		plugin.onConfigChanged(change);
		change.setKey("showNotices");
		plugin.onConfigChanged(change);
		change.setKey("ignoredUsernames");
		plugin.onConfigChanged(change);
		verifyNoInteractions(twitchIRCClient, config);
	}

	@Test
	public void changingConnectionSettingsStillClosesTheOldConnection()
	{
		ConfigChanged change = new ConfigChanged();
		change.setGroup("twitch");
		change.setKey("channel");
		plugin.onConfigChanged(change);
		verify(twitchIRCClient).close();
	}

	@Test
	public void messagesRespectTheCurrentCheckboxWithoutRestarting()
	{
		when(config.overlayIntegration()).thenReturn(true);
		when(config.showInChatbox()).thenReturn(false, true);
		plugin.privmsg("alice", Map.of(), "first");
		plugin.privmsg("alice", Map.of(), "second");
		drain();

		ArgumentCaptor<TwitchMessage> event = ArgumentCaptor.forClass(TwitchMessage.class);
		verify(eventBus, times(2)).post(event.capture());
		assertEquals("first", event.getAllValues().get(0).getMessage());
		assertEquals("second", event.getAllValues().get(1).getMessage());
		ArgumentCaptor<QueuedMessage> queued = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(queued.capture());
		assertTrue(queued.getValue().getRuneLiteFormattedMessage().contains("second"));
	}

	@Test
	public void overlayIntegrationCanBeDisabledWithoutAffectingNativeChat()
	{
		when(config.overlayIntegration()).thenReturn(true, false);
		plugin.privmsg("alice", Map.of(), "first");
		plugin.privmsg("alice", Map.of(), "second");
		drain();

		ArgumentCaptor<TwitchMessage> event = ArgumentCaptor.forClass(TwitchMessage.class);
		verify(eventBus).post(event.capture());
		assertEquals("first", event.getValue().getMessage());
		verify(chatMessageManager, times(2)).queue(any(QueuedMessage.class));
	}

	@Test
	public void disablingBothOutputsSuppressesMessagesAndNotices()
	{
		when(config.showInChatbox()).thenReturn(false);
		plugin.privmsg("alice", Map.of(), "hello");
		plugin.usernotice(Map.of("system-msg", "Alice subscribed"), "");
		drain();
		verifyNoInteractions(eventBus, chatMessageManager);
	}

	@Test
	public void noticesRemainInNativeChatByDefault()
	{
		plugin.usernotice(Map.of("system-msg", "Alice gifted 20 subs"), "");
		drain();

		ArgumentCaptor<QueuedMessage> queued = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(queued.capture());
		assertEquals("[System]", queued.getValue().getName());
		assertTrue(queued.getValue().getRuneLiteFormattedMessage().contains("Alice gifted 20 subs"));
		verifyNoInteractions(eventBus);
	}

	@Test
	public void disablingNoticesFiltersBothOutputsWithoutBlockingNormalChat()
	{
		when(config.overlayIntegration()).thenReturn(true);
		when(config.showNotices()).thenReturn(false);
		plugin.usernotice(Map.of("system-msg", "Alice gifted 20 subs"), "");
		plugin.privmsg("bob", Map.of(), "hello");
		drain();

		ArgumentCaptor<TwitchMessage> event = ArgumentCaptor.forClass(TwitchMessage.class);
		verify(eventBus).post(event.capture());
		assertEquals("bob", event.getValue().getSender());
		ArgumentCaptor<QueuedMessage> queued = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(queued.capture());
		assertEquals("bob", queued.getValue().getName());
	}

	@Test
	public void ignoredUsernamesMatchExactlyWithoutCaseOrSurroundingWhitespace()
	{
		when(config.overlayIntegration()).thenReturn(true);
		when(config.ignoredUsernames()).thenReturn(" NightBot, streamElements ,,");
		plugin.privmsg("nightbot", Map.of("display-name", "NightBot"), "bot message");
		plugin.privmsg("streamelements", Map.of(), "another bot message");
		plugin.privmsg("nightbotfan", Map.of(), "hello");
		drain();

		ArgumentCaptor<TwitchMessage> event = ArgumentCaptor.forClass(TwitchMessage.class);
		verify(eventBus).post(event.capture());
		assertEquals("nightbotfan", event.getValue().getSender());
		ArgumentCaptor<QueuedMessage> queued = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(queued.capture());
		assertEquals("nightbotfan", queued.getValue().getName());
	}

	@Test
	public void filtersUseCurrentSettingsBeforeDelivery()
	{
		plugin.usernotice(Map.of("system-msg", "Alice gifted 20 subs"), "");
		plugin.privmsg("nightbot", Map.of(), "bot message");
		when(config.showNotices()).thenReturn(false);
		when(config.ignoredUsernames()).thenReturn("nightbot");
		drain();
		verifyNoInteractions(eventBus, chatMessageManager);
	}

	@Test
	public void ignoredUsernamesAlsoFilterNoticesFromThatUser()
	{
		when(config.ignoredUsernames()).thenReturn("alice");
		plugin.usernotice(Map.of("login", "Alice", "system-msg", "Alice gifted 20 subs"), "");
		drain();
		verifyNoInteractions(eventBus, chatMessageManager);
	}

	@Test
	public void nativeSlashTStillSendsWithBothOutputsDisabled() throws Exception
	{
		when(config.showInChatbox()).thenReturn(false);
		when(config.username()).thenReturn("alice");
		when(client.getVarcStrValue(VarClientID.CHATINPUT)).thenReturn("/t hello");
		int[] stack = new int[3];
		when(client.getIntStack()).thenReturn(stack);
		when(client.getIntStackSize()).thenReturn(stack.length);
		ScriptCallbackEvent callback = new ScriptCallbackEvent();
		callback.setEventName("chatDefaultReturn");
		plugin.onScriptCallbackEvent(callback);
		drain();

		assertEquals(1, stack[0]);
		verify(twitchIRCClient).privmsg("hello");
		verifyNoInteractions(eventBus, chatMessageManager);
	}

	@Test
	public void shuttingDownBeforeDeliveryDiscardsQueuedMessages()
	{
		plugin.privmsg("alice", Map.of(), "hello");
		plugin.shutDown();
		drain();
		verify(twitchIRCClient).close();
		verifyNoInteractions(eventBus, chatMessageManager);
	}

	@Test
	public void changingConnectionSettingsDiscardsQueuedMessages()
	{
		plugin.privmsg("alice", Map.of(), "hello");
		ConfigChanged change = new ConfigChanged();
		change.setGroup("twitch");
		change.setKey("channel");
		plugin.onConfigChanged(change);
		drain();
		verify(twitchIRCClient).close();
		verifyNoInteractions(eventBus, chatMessageManager);
	}

	@Test
	public void messagesAfterShutdownAreNotScheduled()
	{
		plugin.shutDown();
		plugin.privmsg("alice", Map.of(), "hello");
		verify(clientThread, never()).invokeLater(any(Runnable.class));
		verifyNoInteractions(eventBus, chatMessageManager);
	}

	@Test
	public void loggingOutBeforeDeliveryDiscardsQueuedMessages()
	{
		plugin.privmsg("alice", Map.of(), "hello");
		when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);
		drain();
		verifyNoInteractions(eventBus, chatMessageManager);
	}

	@Test
	public void loggedOutMessagesAreNotScheduled()
	{
		when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);
		plugin.privmsg("alice", Map.of(), "hello");
		plugin.usernotice(Map.of("system-msg", "Alice subscribed"), "");
		verify(clientThread, never()).invokeLater(any(Runnable.class));
		verifyNoInteractions(eventBus, chatMessageManager);
	}
}
