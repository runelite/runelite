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
package net.runelite.client.chat;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.Color;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.events.ConfigChanged;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChatMessageManagerTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ChatColorConfig chatColorConfig;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testMessageRecoloring()
	{
		when(chatColorConfig.opaqueServerMessage()).thenReturn(Color.decode("#b20000"));

		// rebuild color cache
		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup("textrecolor");
		chatMessageManager.onConfigChanged(configChanged);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.GAMEMESSAGE);

		MessageNode messageNode = mock(MessageNode.class);
		chatMessage.setMessageNode(messageNode);

		when(messageNode.getValue()).thenReturn("Your dodgy necklace protects you. It has <col=ff0000>1</col> charge left.");
		chatMessageManager.onChatMessage(chatMessage);

		verify(messageNode).setValue("<col=b20000>Your dodgy necklace protects you. It has <col=ff0000>1<col=b20000> charge left.</col>");
	}

	@Test
	public void testPublicFriendUsernameRecolouring()
	{
		final String localPlayerName = "RuneLite";
		final String friendName = "Zezima";

		when(chatColorConfig.opaquePublicFriendUsernames()).thenReturn(Color.decode("#b20000"));

		// Setup message
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setName(friendName);

		MessageNode messageNode = mock(MessageNode.class);
		chatMessage.setMessageNode(messageNode);
		when(messageNode.getName()).thenReturn(friendName);

		// Setup friend checking
		Player localPlayer = mock(Player.class);

		when(client.isFriended(friendName, true)).thenReturn(true);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(localPlayer.getName()).thenReturn(localPlayerName);

		chatMessageManager.onChatMessage(chatMessage);

		verify(messageNode).setName("<col=b20000>" + friendName + "</col>");
	}

	@Test
	public void testPublicIronmanFriendUsernameRecolouring()
	{
		final String localPlayerName = "RuneLite";
		final String friendName = "<img=3>BuddhaPuck";
		final String sanitizedFriendName = "BuddhaPuck";

		when(chatColorConfig.opaquePublicFriendUsernames()).thenReturn(Color.decode("#b20000"));

		// Setup message
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setName(friendName);

		MessageNode messageNode = mock(MessageNode.class);
		chatMessage.setMessageNode(messageNode);
		when(messageNode.getName()).thenReturn(friendName);

		// Setup friend checking
		Player localPlayer = mock(Player.class);

		when(client.isFriended(sanitizedFriendName, true)).thenReturn(true);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(localPlayer.getName()).thenReturn(localPlayerName);

		chatMessageManager.onChatMessage(chatMessage);

		verify(messageNode).setName("<col=b20000>" + friendName + "</col>");
	}

	@Test
	public void testDefaultFriendsChatInfoColors()
	{
		// no color is configured for opaqueFriendsChatInfo
		when(chatColorConfig.opaqueFriendsChatInfoHighlight()).thenReturn(Color.RED);

		// rebuild color cache
		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup("textrecolor");
		chatMessageManager.onConfigChanged(configChanged);

		String chatMessage = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Total points: ")
			.append(ChatColorType.HIGHLIGHT)
			.append("42")
			.append(ChatColorType.NORMAL)
			.append(", Personal points: ")
			.append(ChatColorType.HIGHLIGHT)
			.append("43")
			.append(ChatColorType.NORMAL)
			.append(" (")
			.append(ChatColorType.HIGHLIGHT)
			.append("44")
			.append(ChatColorType.NORMAL)
			.append("%)")
			.build();

		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getType()).thenReturn(ChatMessageType.FRIENDSCHATNOTIFICATION);
		when(messageNode.getRuneLiteFormatMessage()).thenReturn(chatMessage);

		chatMessageManager.update(messageNode);

		verify(messageNode).setValue("<col=000000>Total points: <col=ff0000>42<col=000000>, Personal points: <col=ff0000>43<col=000000> (<col=ff0000>44<col=000000>%)");
	}
}