/*
 * Copyright (c) 2018, RuneLite Contributors
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

package net.runelite.client.plugins.barbarianassault;

import java.awt.Color;
import javax.inject.Inject;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.isA;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BarbarianAssaultPluginTest
{
	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ConfigManager configManager;

	@Mock
	@Bind
	ChatMessageManager chatMessageManager;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	BarbarianAssaultConfig barbarianAssaultConfig;

	@Inject
	private BarbarianAssaultPlugin barbarianAssaultPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testEggColorChange_BaseCase()
	{
		final String option = "Take";
		final String targetName = "Red Egg";
		final String target = "<col=FFFFFF>" + targetName;
		final int itemId = ItemID.RED_EGG;

		when(barbarianAssaultConfig.colorEggOptions()).thenReturn(true);
		when(client.getVar(Varbits.IN_GAME_BA)).thenReturn(1);

		MenuEntry redEggMenuEntry = mock(MenuEntry.class);

		when(redEggMenuEntry.getTarget()).thenReturn(target);

		MenuEntry[] menuEntries = new MenuEntry[] { redEggMenuEntry };
		when(client.getMenuEntries()).thenReturn(menuEntries);

		MenuEntryAdded event = mock(MenuEntryAdded.class);
		when(event.getIdentifier()).thenReturn(itemId);
		when(event.getOption()).thenReturn(option);

		barbarianAssaultPlugin.onMenuEntryAdded(event);

		verify(redEggMenuEntry, times(1))
				.setTarget(ColorUtil.prependColorTag(targetName, Color.RED));
		verify(client, times(1))
				.setMenuEntries(menuEntries);
	}

	@Test
	public void testEggColorChangeConfigOffExpectNoChange()
	{
		when(barbarianAssaultConfig.colorEggOptions()).thenReturn(false);

		MenuEntryAdded event = mock(MenuEntryAdded.class);

		barbarianAssaultPlugin.onMenuEntryAdded(event);

		verify(client, times(0))
				.setMenuEntries(isA(MenuEntry[].class));
	}

	@Test
	public void testEggColorChangeConfigOnNotInGameExpectNoChange()
	{
		when(barbarianAssaultConfig.colorEggOptions()).thenReturn(false);
		when(client.getVar(Varbits.IN_GAME_BA)).thenReturn(0);

		MenuEntryAdded event = mock(MenuEntryAdded.class);

		barbarianAssaultPlugin.onMenuEntryAdded(event);

		verify(client, never())
				.setMenuEntries(isA(MenuEntry[].class));
	}

	@Test
	public void testEggColorChange_NotMatchingMenuEntry_WrongOption_ExpectNotAdded()
	{
		final String option = "Examine";
		final int itemId = ItemID.RED_EGG;

		when(barbarianAssaultConfig.colorEggOptions()).thenReturn(true);
		when(client.getVar(Varbits.IN_GAME_BA)).thenReturn(1);

		MenuEntryAdded event = mock(MenuEntryAdded.class);
		when(event.getIdentifier()).thenReturn(itemId);
		when(event.getOption()).thenReturn(option);

		barbarianAssaultPlugin.onMenuEntryAdded(event);

		verify(client, never())
				.setMenuEntries(isA(MenuEntry[].class));
	}

	@Test
	public void testEggColorChange_NotMatchingMenuEntry_WrongIdentifier_ExpectNotAdded()
	{
		final String option = "Take";
		final int itemId = ItemID.EGG;

		when(barbarianAssaultConfig.colorEggOptions()).thenReturn(true);
		when(client.getVar(Varbits.IN_GAME_BA)).thenReturn(1);

		MenuEntryAdded event = mock(MenuEntryAdded.class);
		when(event.getIdentifier()).thenReturn(itemId);
		when(event.getOption()).thenReturn(option);

		barbarianAssaultPlugin.onMenuEntryAdded(event);

		verify(client, never())
				.setMenuEntries(isA(MenuEntry[].class));
	}

	@Test
	public void testWaveTimerSetup_NotInGame_ExpectNotStarted()
	{
		when(client.getVar(Varbits.IN_GAME_BA)).thenReturn(0);

		ChatMessage event = mock(ChatMessage.class);

		barbarianAssaultPlugin.onChatMessage(event);

		assertNull(barbarianAssaultPlugin.getGameTime());
	}

	@Test
	public void testWaveTimerSetup_NotServerMessage_ExpectNotStarted()
	{
		when(client.getVar(Varbits.IN_GAME_BA)).thenReturn(1);

		ChatMessage event = mock(ChatMessage.class);
		when(event.getType()).thenReturn(ChatMessageType.TRADE_SENT);

		barbarianAssaultPlugin.onChatMessage(event);

		assertNull(barbarianAssaultPlugin.getGameTime());

		verify(event, times(1)).getType();
	}

	@Test
	public void testWaveTimerSetup_BaseCase_ExpectTimerCreated()
	{
		when(client.getVar(Varbits.IN_GAME_BA)).thenReturn(1);

		ChatMessage event = mock(ChatMessage.class);
		when(event.getType()).thenReturn(ChatMessageType.SERVER);
		when(event.getMessage()).thenReturn("---- Wave: 1");

		barbarianAssaultPlugin.onChatMessage(event);

		assertEquals(1, barbarianAssaultPlugin.getCurrentWave());
		assertNotNull(barbarianAssaultPlugin.getGameTime());
	}
}
