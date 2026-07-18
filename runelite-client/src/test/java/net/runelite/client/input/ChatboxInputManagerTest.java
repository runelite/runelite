/*
 * Copyright (c) 2026, Endriti
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
package net.runelite.client.input;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.Canvas;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ModifierlessKeybind;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChatboxInputManagerTest
{
	@Inject
	private ChatboxInputManager chatboxInputManager;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ClientThread clientThread;

	@Mock
	@Bind
	private RuneLiteConfig config;

	@Mock
	@Bind
	private EventBus eventBus;

	@Mock
	private Widget chatboxParent;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(client.getWidget(InterfaceID.Chatbox.UNIVERSE)).thenReturn(chatboxParent);
		when(chatboxParent.getOnKeyListener()).thenReturn(new Object[0]);
		when(config.pressEnterToChat()).thenReturn(true);
		when(config.chatActivationKey()).thenReturn(new ModifierlessKeybind(KeyEvent.VK_T, 0));
		doAnswer(invocation ->
		{
			Runnable runnable = invocation.getArgument(0);
			runnable.run();
			return null;
		}).when(clientThread).invoke(any(Runnable.class));
	}

	@Test
	public void testCustomActivationKeyIsNotTypedIntoChat()
	{
		KeyEvent pressed = new ExtendedKeyEvent(new Canvas(), KeyEvent.KEY_PRESSED, KeyEvent.VK_T, 't');

		chatboxInputManager.processKeyPressed(pressed);

		assertTrue(chatboxInputManager.isTyping());
		assertTrue(pressed.isConsumed());

		KeyEvent typed = new KeyEvent(new Canvas(), KeyEvent.KEY_TYPED, 0, 0, KeyEvent.VK_UNDEFINED, 't');
		chatboxInputManager.processKeyTyped(typed);

		assertTrue(typed.isConsumed());

		KeyEvent secondTyped = new KeyEvent(new Canvas(), KeyEvent.KEY_TYPED, 0, 0, KeyEvent.VK_UNDEFINED, 't');
		chatboxInputManager.processKeyTyped(secondTyped);

		assertFalse(secondTyped.isConsumed());
	}

	@Test
	public void testShiftSemicolonActivatesColonChatShortcut()
	{
		KeyEvent pressed = new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED, 0,
			KeyEvent.SHIFT_DOWN_MASK, KeyEvent.VK_SEMICOLON, ';');

		chatboxInputManager.processKeyPressed(pressed);

		assertTrue(chatboxInputManager.isTyping());
		assertFalse(pressed.isConsumed());
	}

	@Test
	public void testKeyRemappingDoesNotResetEnabledGlobalChat()
	{
		chatboxInputManager.setKeyRemappingPluginEnabled(true);
		chatboxInputManager.setKeyRemappingPluginEnabled(false);

		verify(clientThread, never()).invoke(any(Runnable.class));
	}

	@Test
	public void testKeyRemappingUpdatesDisabledGlobalChat()
	{
		when(config.pressEnterToChat()).thenReturn(false);

		chatboxInputManager.setKeyRemappingPluginEnabled(true);

		verify(clientThread, times(1)).invoke(any(Runnable.class));
	}

	private static class ExtendedKeyEvent extends KeyEvent
	{
		private final int extendedKeyCode;

		private ExtendedKeyEvent(Canvas source, int id, int keyCode, char keyChar)
		{
			super(source, id, 0, 0, keyCode, keyChar);
			extendedKeyCode = keyCode;
		}

		@Override
		public int getExtendedKeyCode()
		{
			return extendedKeyCode;
		}
	}
}
