/*
 * Copyright (c) 2023, fox091 <https://github.com/fox091>
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

package net.runelite.client.plugins.crowdsourcing.dialogue;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.plugins.crowdsourcing.CrowdsourcingManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CrowdsourcingDialogueTest
{
	private static final String USERNAME_TOKEN = "%USERNAME%";

	private static final String NON_BREAKING_SPACE = " ";

	@Inject
	CrowdsourcingDialogue crowdsourcingDialogue;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private CrowdsourcingManager manager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testOnChatMessageUnsupportedChatMessage()
	{
		String chatMessageText = "Howdy!";
		ChatMessageType chatMessageType = ChatMessageType.WELCOME;
		ChatMessage chatMessage = new ChatMessage(null, chatMessageType, "", chatMessageText, "", 0);
		crowdsourcingDialogue.onChatMessage(chatMessage);

		verifyNoInteractions(client);
		verifyNoInteractions(manager);
	}

	@Test
	public void testOnChatMessageSupportedChatMessages()
	{
		Player localPlayer = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(localPlayer.getName()).thenReturn("Playername!");

		String dialogChatMessageText = "I am a dialogue message!";
		ChatMessageType dialogChatMessageType = ChatMessageType.DIALOG;
		ChatMessage dialogChatMessage = new ChatMessage(null, dialogChatMessageType, "", dialogChatMessageText, "", 0);
		crowdsourcingDialogue.onChatMessage(dialogChatMessage);

		String mesBoxChatMessageText = "I am a mesbox message!";
		ChatMessageType mesBoxChatMessageType = ChatMessageType.MESBOX;
		ChatMessage mesBoxChatMessage = new ChatMessage(null, mesBoxChatMessageType, "", mesBoxChatMessageText, "", 0);
		crowdsourcingDialogue.onChatMessage(mesBoxChatMessage);

		verify(client, times(2)).getLocalPlayer();
		verify(localPlayer, times(2)).getName();
		verify(manager).storeEvent(new ChatMessageData(dialogChatMessageText, dialogChatMessageType));
		verify(manager).storeEvent(new ChatMessageData(mesBoxChatMessageText, mesBoxChatMessageType));
	}

	@Test
	public void testOnChatMessageReplacesNBSPAndUsername()
	{
		Player localPlayer = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		String playerName = "MyCoolPlayerName";
		when(localPlayer.getName()).thenReturn(playerName);

		String baseChatMessageText = ": My non-breaking-spaces should be replaced with regular spaces!";
		String goodChatMessageText = USERNAME_TOKEN + baseChatMessageText;
		String badChatMessageText = goodChatMessageText.replaceAll(" ", NON_BREAKING_SPACE);
		ChatMessageType chatMessageType = ChatMessageType.DIALOG;
		ChatMessage chatMessage = new ChatMessage(null, chatMessageType, "", badChatMessageText, "", 0);
		crowdsourcingDialogue.onChatMessage(chatMessage);

		verify(client).getLocalPlayer();
		verify(localPlayer).getName();
		verify(manager).storeEvent(new ChatMessageData(goodChatMessageText, chatMessageType));
	}

	@Test
	public void testOnChatMessageNullPlayerName()
	{
		Player localPlayer = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(localPlayer.getName()).thenReturn(null);

		String chatMessageText = "My player name is null!";
		ChatMessageType chatMessageType = ChatMessageType.DIALOG;
		ChatMessage chatMessage = new ChatMessage(null, chatMessageType, "", chatMessageText, "", 0);
		crowdsourcingDialogue.onChatMessage(chatMessage);

		verify(client).getLocalPlayer();
		verify(localPlayer).getName();
		verifyNoInteractions(manager);
	}
}
