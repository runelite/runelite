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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.VarClientID;
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
import org.mockito.Spy;
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
	private TwitchConfig config;

	@Mock
	private ChatMessageManager chatMessageManager;

	@Spy
	private EventBus eventBus = new EventBus();

	@Mock
	private TwitchIRCClient twitchIRCClient;

	@InjectMocks
	private TwitchPlugin plugin;

	@Before
	public void setUp()
	{
		lenient().when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		lenient().when(config.overlayIntegration()).thenCallRealMethod();
		lenient().when(config.showInChatbox()).thenCallRealMethod();
		lenient().when(config.showNotices()).thenCallRealMethod();
		lenient().when(config.ignoredUsernames()).thenCallRealMethod();
	}

	@Test
	public void defaultsPreserveNativeChatWithoutPublishingEvents()
	{
		assertFalse(config.overlayIntegration());
		assertTrue(config.showInChatbox());
		assertTrue(config.showNotices());
		assertEquals("", config.ignoredUsernames());
		plugin.privmsg("alice", Map.of("display-name", "Alice"), "hello");

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

		verify(eventBus).post(any(TwitchMessage.class));
		verifyNoInteractions(chatMessageManager);
	}

	@Test
	public void systemNoticesRemainAvailableWithoutNativeChat()
	{
		when(config.overlayIntegration()).thenReturn(true);
		when(config.showInChatbox()).thenReturn(false);
		plugin.usernotice(Map.of("system-msg", "Alice subscribed"), "");

		ArgumentCaptor<TwitchMessage> event = ArgumentCaptor.forClass(TwitchMessage.class);
		verify(eventBus).post(event.capture());
		assertEquals("[System]", event.getValue().getSender());
		assertEquals("Alice subscribed", event.getValue().getMessage());
		verifyNoInteractions(chatMessageManager);
	}

	@Test
	public void nativeSlashTStillSendsAndEchoesOnlyToTheEventWhenDisabled() throws Exception
	{
		List<Thread> deliveryThreads = new ArrayList<>();
		eventBus.register(TwitchMessage.class, event -> deliveryThreads.add(Thread.currentThread()), 0);
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

		assertEquals(1, stack[0]);
		verify(twitchIRCClient).privmsg("hello");
		ArgumentCaptor<TwitchMessage> event = ArgumentCaptor.forClass(TwitchMessage.class);
		verify(eventBus).post(event.capture());
		assertEquals("alice", event.getValue().getSender());
		assertEquals("hello", event.getValue().getMessage());
		assertEquals(List.of(Thread.currentThread()), deliveryThreads);
		verifyNoInteractions(chatMessageManager);
	}

	@Test
	public void incomingMessagesAndNoticesAreDeliveredOnTheReceivingThread() throws Exception
	{
		when(config.overlayIntegration()).thenReturn(true);
		List<Thread> deliveryThreads = new ArrayList<>();
		eventBus.register(TwitchMessage.class, event -> deliveryThreads.add(Thread.currentThread()), 0);
		FutureTask<Void> receive = new FutureTask<>(() ->
		{
			plugin.privmsg("alice", Map.of(), "hello");
			plugin.usernotice(Map.of("system-msg", "Alice subscribed"), "");
			return null;
		});
		Thread receiver = new Thread(receive, "twitch-test-receiver");
		receiver.start();
		receive.get(5, TimeUnit.SECONDS);
		assertEquals(List.of(receiver, receiver), deliveryThreads);
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
		verifyNoInteractions(eventBus, chatMessageManager);
	}

	@Test
	public void noticesRemainInNativeChatByDefault()
	{
		plugin.usernotice(Map.of("system-msg", "Alice gifted 20 subs"), "");

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

		ArgumentCaptor<TwitchMessage> event = ArgumentCaptor.forClass(TwitchMessage.class);
		verify(eventBus).post(event.capture());
		assertEquals("nightbotfan", event.getValue().getSender());
		ArgumentCaptor<QueuedMessage> queued = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(queued.capture());
		assertEquals("nightbotfan", queued.getValue().getName());
	}

	@Test
	public void ignoredUsernamesAlsoFilterNoticesFromThatUser()
	{
		when(config.ignoredUsernames()).thenReturn("alice");
		plugin.usernotice(Map.of("login", "Alice", "system-msg", "Alice gifted 20 subs"), "");
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

		assertEquals(1, stack[0]);
		verify(twitchIRCClient).privmsg("hello");
		verifyNoInteractions(eventBus, chatMessageManager);
	}

	@Test
	public void loggedOutMessagesAreNotDelivered()
	{
		when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);
		plugin.privmsg("alice", Map.of(), "hello");
		plugin.usernotice(Map.of("system-msg", "Alice subscribed"), "");
		verifyNoInteractions(eventBus, chatMessageManager);
	}
}
