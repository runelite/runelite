/*
 * Copyright (c) 2021, Maciej <https://github.com/mlewicki12>
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
package net.runelite.client.plugins.friendlist;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.MessageNode;
import net.runelite.api.NameableContainer;
import net.runelite.api.events.ChatMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FriendListPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private FriendListConfig config;

	@Inject
	private FriendListPlugin friendListPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void onChatMessage()
	{
		when(config.showWorldOnLogin()).thenReturn(true);

		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getValue()).thenReturn("test\u00a0rsn has logged in.");

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.LOGINLOGOUTNOTIFICATION);
		chatMessage.setMessageNode(messageNode);

		Friend friend = mock(Friend.class);
		when(friend.getWorld()).thenReturn(311);

		NameableContainer<Friend> friendContainer = mock(NameableContainer.class);
		when(friendContainer.findByName("test\u00a0rsn")).thenReturn(friend);
		when(client.getFriendContainer()).thenReturn(friendContainer);

		friendListPlugin.onChatMessage(chatMessage);

		verify(messageNode).setValue("test\u00a0rsn has logged in. (World 311)");
	}
}
