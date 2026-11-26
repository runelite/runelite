/*
 * Copyright (c) 2026, NcollegeB
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
package net.runelite.client.plugins.chatcommands;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import net.runelite.api.Client;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.vars.InputType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.Keybind;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChatKeyboardListenerTest
{
	@Mock
	private Client client;

	@Mock
	private ClientThread clientThread;

	@Mock(answer = Answers.CALLS_REAL_METHODS)
	private ChatCommandsConfig config;

	@InjectMocks
	private ChatKeyboardListener listener;

	@Test
	public void testClearLastWordThenBackspace()
	{
		testClearThenBackspace(InputEvent.CTRL_DOWN_MASK);
	}

	@Test
	public void testClearChatThenBackspace()
	{
		int modifiers = InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK;
		when(config.clearChatBox()).thenReturn(new Keybind(KeyEvent.VK_BACK_SPACE, modifiers));
		testClearThenBackspace(modifiers);
	}

	private void testClearThenBackspace(int modifiers)
	{
		when(client.getVarcStrValue(VarClientID.CHATINPUT)).thenReturn("word", "");
		KeyEvent delete = keyPress(KeyEvent.VK_BACK_SPACE, modifiers);
		listener.keyPressed(delete);
		verify(delete).consume();

		ArgumentCaptor<Runnable> update = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invoke(update.capture());
		update.getValue().run();
		verify(client).setVarcStrValue(VarClientID.CHATINPUT, "");

		KeyEvent repeat = keyPress(KeyEvent.VK_BACK_SPACE, modifiers);
		listener.keyPressed(repeat);
		verify(repeat, never()).consume();
		verifyNoMoreInteractions(clientThread);
	}

	@Test
	public void testEmptyPrivateMessageRetainsBackspace()
	{
		when(client.getVarcIntValue(VarClientID.MESLAYERMODE)).thenReturn(InputType.PRIVATE_MESSAGE.getType());
		when(client.getVarcStrValue(VarClientID.MESLAYERINPUT)).thenReturn("");
		KeyEvent event = keyPress(KeyEvent.VK_BACK_SPACE, InputEvent.CTRL_DOWN_MASK);
		listener.keyPressed(event);
		verify(event).consume();
	}

	@Test
	public void testEmptyChatRetainsOtherClearKeys()
	{
		when(config.clearChatBox()).thenReturn(new Keybind(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		when(client.getVarcStrValue(VarClientID.CHATINPUT)).thenReturn("");
		KeyEvent event = keyPress(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK);
		listener.keyPressed(event);
		verify(event).consume();
	}

	private static KeyEvent keyPress(int key, int modifiers)
	{
		KeyEvent event = mock(KeyEvent.class);
		when(event.getKeyCode()).thenReturn(key);
		when(event.getExtendedKeyCode()).thenReturn(key);
		when(event.getModifiersEx()).thenReturn(modifiers);
		return event;
	}
}
