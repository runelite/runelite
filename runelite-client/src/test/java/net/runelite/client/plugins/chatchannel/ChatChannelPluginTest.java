/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.chatchannel;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.clan.ClanChannel;
import net.runelite.api.clan.ClanChannelMember;
import net.runelite.api.clan.ClanRank;
import net.runelite.api.clan.ClanSettings;
import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ClanMemberLeft;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.game.ChatIconManager;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChatChannelPluginTest
{
	@Inject
	private ChatChannelPlugin chatChannelPlugin;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ChatIconManager chatIconManager;

	@Mock
	@Bind
	private ChatChannelConfig config;

	@Mock
	@Bind
	private ClientThread clientThread;

	@Mock
	@Bind
	private ChatboxPanelManager chatboxPanelManager;

	@Mock
	@Bind
	private ChatColorConfig chatColorConfig;

	@Mock
	@Bind
	private ChatMessageManager chatMessageManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testJoinLeave()
	{
		ClanChannel channel = mock(ClanChannel.class);
		ClanSettings settings = mock(ClanSettings.class);

		when(client.getClanChannel()).thenReturn(channel);
		lenient().when(client.getClanSettings()).thenReturn(settings);
		when(config.clanChatShowJoinLeave()).thenReturn(true);
		lenient().when(client.addChatMessage(any(ChatMessageType.class), anyString(), anyString(), anyString())).thenAnswer(a -> mock(MessageNode.class));

		ClanChannelMember member = mock(ClanChannelMember.class);
		lenient().when(member.getRank()).thenReturn(ClanRank.OWNER);
		chatChannelPlugin.onClanMemberLeft(new ClanMemberLeft(channel, member));

		ClanChannelMember member2 = mock(ClanChannelMember.class);
		lenient().when(member2.getRank()).thenReturn(ClanRank.OWNER);
		chatChannelPlugin.onClanMemberJoined(new ClanMemberJoined(channel, member2));

		lenient().when(client.getTickCount()).thenReturn(ChatChannelPlugin.MESSAGE_DELAY + 1);
		chatChannelPlugin.addActivityMessages();

		verify(client, never()).addChatMessage(any(ChatMessageType.class), anyString(), anyString(), anyString());
		verify(member).compareTo(member2);
	}
}