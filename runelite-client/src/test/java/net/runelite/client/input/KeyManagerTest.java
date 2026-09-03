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
import net.runelite.api.GameState;
import net.runelite.client.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class KeyManagerTest
{
	@Inject
	private KeyManager keyManager;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private EventBus eventBus;

	@Mock
	@Bind
	private ChatboxInputManager chatboxInputManager;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
	}

	@Test
	public void testChatInputSkipsHotkeyListeners()
	{
		when(chatboxInputManager.isChatInputActive()).thenReturn(true);

		RecordingChatListener chatListener = new RecordingChatListener();
		RecordingKeyListener hotkeyListener = new RecordingKeyListener();
		keyManager.registerKeyListener(chatListener);
		keyManager.registerKeyListener(hotkeyListener);

		keyManager.processKeyPressed(keyEvent(KeyEvent.KEY_PRESSED));
		keyManager.processKeyTyped(keyEvent(KeyEvent.KEY_TYPED));
		keyManager.processKeyReleased(keyEvent(KeyEvent.KEY_RELEASED));

		assertEquals(1, chatListener.pressed);
		assertEquals(1, chatListener.typed);
		assertEquals(1, chatListener.released);
		assertEquals(0, hotkeyListener.pressed);
		assertEquals(0, hotkeyListener.typed);
		assertEquals(1, hotkeyListener.released);
	}

	@Test
	public void testConsumedChatActivationDoesNotDispatch()
	{
		doAnswer(invocation ->
		{
			KeyEvent event = invocation.getArgument(0);
			event.consume();
			return null;
		}).when(chatboxInputManager).processKeyPressed(any(KeyEvent.class));

		RecordingKeyListener listener = new RecordingKeyListener();
		keyManager.registerKeyListener(listener);

		keyManager.processKeyPressed(keyEvent(KeyEvent.KEY_PRESSED));

		assertEquals(0, listener.pressed);
	}

	@Test
	public void testClosingChatDoesNotDispatchHotkey()
	{
		when(chatboxInputManager.isChatInputActive()).thenReturn(true, false);

		RecordingKeyListener listener = new RecordingKeyListener();
		keyManager.registerKeyListener(listener);
		keyManager.processKeyPressed(keyEvent(KeyEvent.KEY_PRESSED));

		assertEquals(0, listener.pressed);
	}

	@Test
	public void testUnconsumedChatActivationDoesNotDispatchHotkey()
	{
		when(chatboxInputManager.isChatInputActive()).thenReturn(false, true);

		RecordingKeyListener listener = new RecordingKeyListener();
		keyManager.registerKeyListener(listener);
		keyManager.processKeyPressed(keyEvent(KeyEvent.KEY_PRESSED));

		assertEquals(0, listener.pressed);
	}

	private static KeyEvent keyEvent(int id)
	{
		if (id == KeyEvent.KEY_TYPED)
		{
			return new KeyEvent(new Canvas(), id, 0, 0, KeyEvent.VK_UNDEFINED, 'q');
		}

		return new KeyEvent(new Canvas(), id, 0, 0, KeyEvent.VK_Q, 'q');
	}

	private static class RecordingKeyListener implements KeyListener
	{
		int pressed;
		int typed;
		int released;

		@Override
		public void keyTyped(KeyEvent e)
		{
			typed++;
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			pressed++;
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			released++;
		}
	}

	private static class RecordingChatListener extends RecordingKeyListener
	{
		@Override
		public boolean isEnabledOnChatInput()
		{
			return true;
		}
	}
}
