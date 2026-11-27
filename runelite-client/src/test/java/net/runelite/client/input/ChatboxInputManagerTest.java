/*
 * Copyright (c) 2026, Endrit
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
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.vars.InputType;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ModifierlessKeybind;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.chatbox.ChatboxInput;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ChatboxInputManagerTest
{
	@Bind
	private final Client client = mock(Client.class);

	@Bind
	private final RuneLiteConfig config = mock(RuneLiteConfig.class);

	@Bind
	private final ClientThread clientThread = mock(ClientThread.class);

	@Bind
	private final EventBus eventBus = new EventBus();

	@Inject
	private KeyManager keyManager;

	@Inject
	private ChatboxInputManager chatboxInputManager;

	private final Widget layer = mock(Widget.class);
	private final Widget input = mock(Widget.class);
	private final KeyListener hotkey = mock(KeyListener.class);
	private final Canvas canvas = new Canvas();

	@Before
	public void before()
	{
		when(layer.getOnKeyListener()).thenReturn(new Object[0]);
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		when(client.getWidget(InterfaceID.Chatbox.UNIVERSE)).thenReturn(layer);
		when(client.getWidget(InterfaceID.Chatbox.MES_LAYER_HIDE)).thenReturn(layer);
		when(client.getWidget(InterfaceID.Chatbox.CHATDISPLAY)).thenReturn(layer);
		when(client.getWidget(InterfaceID.Chatbox.INPUT)).thenReturn(input);
		when(input.getText()).thenReturn("Player: draft*");
		when(client.getVarcStrValue(VarClientID.CHATINPUT)).thenReturn("draft");
		when(config.pressEnterToChat()).thenReturn(true);
		when(config.chatActivationKey()).thenReturn(new ModifierlessKeybind(KeyEvent.VK_ENTER, 0));

		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testModifierAndFunctionKeysReachHotkeysWhileTyping()
	{
		keyManager.registerKeyListener(hotkey);
		openChat();

		press(KeyEvent.VK_A, 'a');
		press(KeyEvent.VK_1, '1');
		press(KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
		verify(hotkey, never()).keyPressed(any());

		press(KeyEvent.VK_ALT, KeyEvent.CHAR_UNDEFINED);
		press(KeyEvent.VK_CONTROL, KeyEvent.CHAR_UNDEFINED);
		press(KeyEvent.VK_SHIFT, KeyEvent.CHAR_UNDEFINED);
		press(KeyEvent.VK_F12, KeyEvent.CHAR_UNDEFINED);
		verify(hotkey, times(4)).keyPressed(any());
	}

	@Test
	public void testOtherTextInputsKeepTypedKeysFromHotkeys()
	{
		// Prompts handle keys through their own widgets rather than the chatbox's.
		when(layer.getOnKeyListener()).thenReturn(null);
		when(client.getVarcIntValue(VarClientID.MESLAYERMODE)).thenReturn(InputType.RUNELITE_CHATBOX_PANEL.getType());
		PanelInput panel = new PanelInput();
		keyManager.registerKeyListener(hotkey);
		keyManager.registerKeyListener(panel);

		press(KeyEvent.VK_A, 'a');
		typed('a');

		verify(hotkey, never()).keyPressed(any());
		verify(hotkey, never()).keyTyped(any());
		assertEquals(1, panel.pressed);
		assertEquals(1, panel.typed);
	}

	@Test
	public void testDisabledLeavesGameStateAlone()
	{
		when(config.pressEnterToChat()).thenReturn(false);
		keyManager.registerKeyListener(hotkey);
		clearInvocations(client);

		press(KeyEvent.VK_A, 'a');
		typed('a');
		release(KeyEvent.VK_A, 'a');
		GameStateChanged loggedIn = new GameStateChanged();
		loggedIn.setGameState(GameState.LOGGED_IN);
		chatboxInputManager.onGameStateChanged(loggedIn);

		verify(client, never()).getWidget(anyInt());
		verify(input, never()).setText(anyString());
		verify(hotkey).keyPressed(any());
		verify(hotkey).keyTyped(any());
		verify(hotkey).keyReleased(any());
	}

	@Test
	public void testReleaseIsDeliveredWithoutChatInput()
	{
		when(config.pressEnterToChat()).thenReturn(false);
		KeyListener consumer = mock(KeyListener.class);
		doAnswer(invocation ->
		{
			((KeyEvent) invocation.getArgument(0)).consume();
			return null;
		}).when(consumer).keyPressed(any());
		keyManager.registerKeyListener(consumer);

		press(KeyEvent.VK_A, 'a');
		keyManager.registerKeyListener(hotkey);
		release(KeyEvent.VK_A, 'a');

		verify(hotkey).keyReleased(any());
	}

	@Test
	public void testReleaseFollowsWithheldPress()
	{
		keyManager.registerKeyListener(hotkey);
		press(KeyEvent.VK_Q, 'q');
		openChat();
		// Q auto-repeats while typing
		press(KeyEvent.VK_Q, 'q');
		press(KeyEvent.VK_W, 'w');
		release(KeyEvent.VK_Q, 'q');
		release(KeyEvent.VK_W, 'w');

		verify(hotkey).keyPressed(argThat(e -> e.getKeyCode() == KeyEvent.VK_Q));
		verify(hotkey).keyReleased(argThat(e -> e.getKeyCode() == KeyEvent.VK_Q));
		verify(hotkey, never()).keyPressed(argThat(e -> e.getKeyCode() == KeyEvent.VK_W));
		verify(hotkey, never()).keyReleased(argThat(e -> e.getKeyCode() == KeyEvent.VK_W));
	}

	@Test
	public void testHeldChatKeyDoesNotLeak()
	{
		when(config.chatActivationKey()).thenReturn(new ModifierlessKeybind(KeyEvent.VK_C, 0));
		keyManager.registerKeyListener(hotkey);

		assertTrue(press(KeyEvent.VK_C, 'c').isConsumed());
		assertTrue(typed('c').isConsumed());
		// auto-repeat
		assertTrue(press(KeyEvent.VK_C, 'c').isConsumed());
		assertTrue(typed('c').isConsumed());
		assertTrue(chatboxInputManager.isTyping());

		release(KeyEvent.VK_C, 'c');
		verify(hotkey, never()).keyReleased(any());
		assertFalse(press(KeyEvent.VK_C, 'c').isConsumed());
		assertFalse(typed('c').isConsumed());
	}

	@Test
	public void testEnterDoesNotSendHiddenDraft()
	{
		when(config.chatActivationKey()).thenReturn(new ModifierlessKeybind(KeyEvent.VK_C, 0));
		when(client.getVarcStrValue(VarClientID.CHATINPUT)).thenReturn("");
		assertFalse(press(KeyEvent.VK_ENTER, '\n').isConsumed());
		release(KeyEvent.VK_ENTER, '\n');

		// A draft left behind, such as after replying to a private message, is not sent while chat is locked.
		when(client.getVarcStrValue(VarClientID.CHATINPUT)).thenReturn("draft");
		assertTrue(press(KeyEvent.VK_ENTER, '\n').isConsumed());
		assertTrue(typed('\n').isConsumed());
		assertFalse(chatboxInputManager.isTyping());
		release(KeyEvent.VK_ENTER, '\n');

		press(KeyEvent.VK_C, 'c');
		assertTrue(chatboxInputManager.isTyping());
	}

	@Test
	public void testHeldEnterDoesNotToggleChat()
	{
		press(KeyEvent.VK_ENTER, '\n');
		press(KeyEvent.VK_ENTER, '\n');
		assertTrue(chatboxInputManager.isTyping());
		release(KeyEvent.VK_ENTER, '\n');

		press(KeyEvent.VK_ENTER, '\n');
		assertFalse(chatboxInputManager.isTyping());
		press(KeyEvent.VK_ENTER, '\n');
		assertFalse(chatboxInputManager.isTyping());
	}

	@Test
	public void testConfirmingInputDoesNotOpenChat()
	{
		when(client.getVarcIntValue(VarClientID.MESLAYERMODE)).thenReturn(InputType.SEARCH.getType());
		assertFalse(press(KeyEvent.VK_ENTER, '\n').isConsumed());

		// The search closes, then Enter auto-repeats.
		when(client.getVarcIntValue(VarClientID.MESLAYERMODE)).thenReturn(InputType.NONE.getType());
		press(KeyEvent.VK_ENTER, '\n');
		assertFalse(chatboxInputManager.isTyping());

		release(KeyEvent.VK_ENTER, '\n');
		press(KeyEvent.VK_ENTER, '\n');
		assertTrue(chatboxInputManager.isTyping());
	}

	@Test
	public void testClosedInputRelocksChat()
	{
		// The chat line is rebuilt while the input is still closing, so it is relocked afterwards.
		chatboxInputManager.onVarClientIntChanged(new VarClientIntChanged(VarClientID.MESLAYERMODE));

		ArgumentCaptor<Runnable> relock = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(relock.capture());
		relock.getValue().run();
		verify(input).setText(contains("to Chat..."));
	}

	private void openChat()
	{
		press(KeyEvent.VK_ENTER, '\n');
		release(KeyEvent.VK_ENTER, '\n');
		assertTrue(chatboxInputManager.isTyping());
	}

	private static class PanelInput extends ChatboxInput implements KeyListener
	{
		private int pressed;
		private int typed;

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
		}
	}

	private KeyEvent press(int keyCode, char keyChar)
	{
		KeyEvent e = event(KeyEvent.KEY_PRESSED, keyCode, keyChar);
		keyManager.processKeyPressed(e);
		return e;
	}

	private KeyEvent typed(char keyChar)
	{
		KeyEvent e = event(KeyEvent.KEY_TYPED, KeyEvent.VK_UNDEFINED, keyChar);
		keyManager.processKeyTyped(e);
		return e;
	}

	private void release(int keyCode, char keyChar)
	{
		keyManager.processKeyReleased(event(KeyEvent.KEY_RELEASED, keyCode, keyChar));
	}

	private KeyEvent event(int id, int keyCode, char keyChar)
	{
		return new KeyEvent(canvas, id, 0, 0, keyCode, keyChar)
		{
			@Override
			public int getExtendedKeyCode()
			{
				return keyCode;
			}
		};
	}
}
