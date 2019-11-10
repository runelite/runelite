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
package net.runelite.client.plugins.examine;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.MenuOpcode;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.OpenOSRSConfig;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.examine.ExamineClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExaminePluginTest
{
	@Inject
	ExaminePlugin examinePlugin;

	@Mock
	@Bind
	ExamineClient examineClient;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ChatMessageManager chatMessageManager;

	@Mock
	@Bind
	ItemManager itemManager;

	@Mock
	@Bind
	ScheduledExecutorService scheduledExecutorService;

	@Mock
	@Bind
	private OpenOSRSConfig openOSRSConfig;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testItem()
	{
		when(client.getWidget(anyInt(), anyInt())).thenReturn(mock(Widget.class));

		MenuOptionClicked menuOptionClicked = new MenuOptionClicked(
			"Examine",
			"Something",
			ItemID.ABYSSAL_WHIP,
			MenuOpcode.EXAMINE_ITEM.getId(),
			123,
			456,
			false
		);
		examinePlugin.onMenuOptionClicked(menuOptionClicked);

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.ITEM_EXAMINE, "", "A weapon from the abyss.", "", 0);
		examinePlugin.onChatMessage(chatMessage);

		// This passes due to not mocking the ItemDefinition for the whip
		verify(examineClient).submitItem(anyInt(), anyString());
	}

	@Test
	public void testLargeStacks()
	{
		when(client.getWidget(anyInt(), anyInt())).thenReturn(mock(Widget.class));

		MenuOptionClicked menuOptionClicked = new MenuOptionClicked(
			"Examine",
			"Something",
			ItemID.ABYSSAL_WHIP,
			MenuOpcode.EXAMINE_ITEM.getId(),
			123,
			456,
			false
		);

		examinePlugin.onMenuOptionClicked(menuOptionClicked);

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.ITEM_EXAMINE, "", "100000 x Abyssal whip", "", 0);
		examinePlugin.onChatMessage(chatMessage);

		verify(examineClient, never()).submitItem(anyInt(), anyString());
	}
}
