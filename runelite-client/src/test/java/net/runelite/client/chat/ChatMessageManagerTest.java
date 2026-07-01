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
import net.runelite.api.IterableHashTable;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.events.ConfigChanged;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
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

	private String[] sstack;
	private int[] istack;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	private MessageNode setupVm(ChatMessageType type, String name, String message)
	{
		MessageNode messageNode = mock(MessageNode.class);
		when(messageNode.getType()).thenReturn(type);

		IterableHashTable<MessageNode> tbl = mock(IterableHashTable.class);
		when(tbl.get(anyLong())).thenReturn(messageNode);
		when(client.getMessages()).thenReturn(tbl);

		sstack = new String[]{
			"",
			name,
			message,
			""
		};
		istack = new int[]{
			0, // splitpmbox
			1
		};
		when(client.getObjectStack()).thenReturn(sstack);
		when(client.getObjectStackSize()).thenReturn(sstack.length);
		when(client.getIntStack()).thenReturn(istack);
		when(client.getIntStackSize()).thenReturn(istack.length);

		return messageNode;
	}

	@Test
	public void testMessageRecoloring()
	{
		when(chatColorConfig.opaqueServerMessage()).thenReturn(Color.decode("#b20000"));

		// rebuild color cache
		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup("textrecolor");
		chatMessageManager.onConfigChanged(configChanged);

		setupVm(ChatMessageType.GAMEMESSAGE, "", "Your dodgy necklace protects you. It has <col=ff0000>1</col> charge left.");
		chatMessageManager.colorChatMessage();

		assertEquals("<col=b20000>Your dodgy necklace protects you. It has <col=ff0000>1<col=b20000> charge left.</col>", sstack[2]);
	}

	@Test
	public void testPublicFriendUsernameRecolouring()
	{
		final String localPlayerName = "RuneLite";
		final String friendName = "Zezima";

		when(chatColorConfig.opaquePublicFriendUsernames()).thenReturn(Color.decode("#b20000"));

		setupVm(ChatMessageType.PUBLICCHAT, friendName, "");

		// Setup friend checking
		Player localPlayer = mock(Player.class);

		when(client.isFriended(friendName, true)).thenReturn(true);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(localPlayer.getName()).thenReturn(localPlayerName);

		chatMessageManager.colorChatMessage();

		assertEquals("<col=b20000>" + friendName + "</col>", sstack[1]);
	}

	@Test
	public void testPublicIronmanFriendUsernameRecolouring()
	{
		final String localPlayerName = "RuneLite";
		final String friendName = "<img=3>BuddhaPuck";
		final String sanitizedFriendName = "BuddhaPuck";

		when(chatColorConfig.opaquePublicFriendUsernames()).thenReturn(Color.decode("#b20000"));

		setupVm(ChatMessageType.PUBLICCHAT, friendName, "");

		// Setup friend checking
		Player localPlayer = mock(Player.class);

		when(client.isFriended(sanitizedFriendName, true)).thenReturn(true);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(localPlayer.getName()).thenReturn(localPlayerName);

		chatMessageManager.colorChatMessage();

		assertEquals("<col=b20000>" + friendName + "</col>", sstack[1]);
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

		String formattedMessage = chatMessageManager.formatRuneLiteMessage(chatMessage, ChatMessageType.FRIENDSCHATNOTIFICATION, false);

		assertEquals("<col=000000>Total points: <col=ff0000>42<col=000000>, Personal points: <col=ff0000>43<col=000000> (<col=ff0000>44<col=000000>%)", formattedMessage);
	}

	@Test
	public void testGim()
	{
		when(chatColorConfig.opaqueClanChatInfo()).thenReturn(Color.RED);
		when(chatColorConfig.opaqueClanChatInfoHighlight()).thenReturn(Color.BLUE);

		// rebuild color cache
		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup("textrecolor");
		chatMessageManager.onConfigChanged(configChanged);

		MessageNode messageNode = setupVm(ChatMessageType.CLAN_GIM_MESSAGE, "", "rsn received a drop: 8 x Bronze bolts (16 coins).");
		when(messageNode.getRuneLiteFormatMessage()).thenReturn("<colHIGHLIGHT><u>rsn</u><colNORMAL> received a drop: 8 x Bronze bolts (16 coins).");

		chatMessageManager.colorChatMessage();

		// | <chat color> <highlight color>
		assertEquals("|<col=ff0000><col=0000ff><u>rsn</u><col=ff0000> received a drop: 8 x Bronze bolts (16 coins).</col>", sstack[2]);
	}
}