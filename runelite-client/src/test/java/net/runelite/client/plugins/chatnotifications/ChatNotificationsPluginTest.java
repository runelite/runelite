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

import com.google.common.base.Splitter;
import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.SetMessage;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatMessageManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

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

	@Inject
	private ChatNotificationsPlugin chatNotificationsPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void onSetMessage()
	{
		when(config.highlightWordsString()).thenReturn("Deathbeam, Deathbeam OSRS , test");

		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn("Deathbeam, Deathbeam OSRS");

		SetMessage setMessage = new SetMessage();
		setMessage.setType(ChatMessageType.PUBLIC);
		setMessage.setMessageNode(messageNode);

		chatNotificationsPlugin.startUp(); // load highlight config
		chatNotificationsPlugin.onSetMessage(setMessage);

		verify(messageNode).setValue("<colHIGHLIGHT>Deathbeam<colNORMAL>, <colHIGHLIGHT>Deathbeam<colNORMAL> OSRS");
	}

	@Test
	public void highlightListTest()
	{
		when(config.highlightWordsString()).thenReturn("this,is, a                   , test, ");
		final Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();
		final List<String> higlights = splitter.splitToList(config.highlightWordsString());
		assertEquals(4, higlights.size());

		final Iterator<String> iterator = higlights.iterator();
		assertEquals("this", iterator.next());
		assertEquals("is", iterator.next());
		assertEquals("a", iterator.next());
		assertEquals("test", iterator.next());
	}
}