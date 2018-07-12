/*
 * Copyright (c) 2018, Kamiel
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.events.ChatboxInput;

@Slf4j
@Singleton
public class CommandManager
{
	private static final String RUNELITE_COMMAND = "runeliteCommand";
	private static final String CHATBOX_INPUT = "chatboxInput";

	private final Provider<Client> clientProvider;
	private final EventBus eventBus;
	private final Provider<ClientThread> clientThreadProvider;
	private boolean sending;

	private final List<ChatboxInputListener> chatboxInputListenerList = new ArrayList<>();

	@Inject
	public CommandManager(Provider<Client> clientProvider, EventBus eventBus, Provider<ClientThread> clientThreadProvider)
	{
		this.clientProvider = clientProvider;
		this.eventBus = eventBus;
		this.clientThreadProvider = clientThreadProvider;
	}

	public void register(ChatboxInputListener chatboxInputListener)
	{
		chatboxInputListenerList.add(chatboxInputListener);
	}

	public void unregister(ChatboxInputListener chatboxInputListener)
	{
		chatboxInputListenerList.remove(chatboxInputListener);
	}

	@Subscribe
	private void scriptEvent(ScriptCallbackEvent event)
	{
		if (sending)
		{
			return;
		}

		switch (event.getEventName())
		{
			case RUNELITE_COMMAND:
				runCommand();
				break;
			case CHATBOX_INPUT:
				handleInput(event);
				break;
		}
	}

	private void runCommand()
	{
		Client client = clientProvider.get();
		String typedText = client.getVar(VarClientStr.CHATBOX_TYPED_TEXT).substring(2); // strip ::

		log.debug("Command: {}", typedText);

		String[] split = typedText.split(" ");

		// Fixes ArrayIndexOutOfBounds when typing ":: "
		if (split.length == 0)
		{
			return;
		}

		String command = split[0];
		String[] args = Arrays.copyOfRange(split, 1, split.length);

		CommandExecuted commandExecuted = new CommandExecuted(command, args);
		eventBus.post(commandExecuted);
	}

	private void handleInput(ScriptCallbackEvent event)
	{
		Client client = clientProvider.get();
		final String[] stringStack = client.getStringStack();
		final int[] intStack = client.getIntStack();
		int stringStackCount = client.getStringStackSize();
		int intStackCount = client.getIntStackSize();

		final String typedText = stringStack[stringStackCount - 1];
		final int chatType = intStack[intStackCount - 1];

		ChatboxInput chatboxInput = new ChatboxInput(typedText, chatType)
		{
			private boolean resumed;

			@Override
			public void resume()
			{
				if (resumed)
				{
					return;
				}
				resumed = true;

				ClientThread clientThread = clientThreadProvider.get();
				clientThread.invokeLater(() -> sendChatboxInput(chatType, typedText));
			}
		};
		boolean stop = false;
		for (ChatboxInputListener chatboxInputListener : chatboxInputListenerList)
		{
			stop |= chatboxInputListener.onChatboxInput(chatboxInput);
		}

		if (stop)
		{
			// input was blocked.
			stringStack[stringStackCount - 1] = ""; // prevent script from sending
		}
	}

	private void sendChatboxInput(int chatType, String input)
	{
		Client client = clientProvider.get();
		sending = true;
		try
		{
			client.runScript(ScriptID.CHATBOX_INPUT, chatType, input);
		}
		finally
		{
			sending = false;
		}
	}
}
