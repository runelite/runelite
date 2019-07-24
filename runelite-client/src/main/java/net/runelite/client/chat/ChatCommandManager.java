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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ChatInput;
import net.runelite.client.events.ChatboxInput;
import net.runelite.client.events.PrivateMessageInput;

@Singleton
public class ChatCommandManager implements ChatboxInputListener
{
	private final Map<String, ChatCommand> commands = new HashMap<>();

	private final Client client;
	private final ScheduledExecutorService scheduledExecutorService;

	@Inject
	private ChatCommandManager(EventBus eventBus, CommandManager commandManager, Client client, ScheduledExecutorService scheduledExecutorService)
	{
		this.client = client;
		this.scheduledExecutorService = scheduledExecutorService;
		// eventBus.register(this);
		commandManager.register(this);

		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
	}

	public void registerCommand(String command, BiConsumer<ChatMessage, String> execute)
	{
		registerCommand(command, execute, null);
	}

	public void registerCommand(String command, BiConsumer<ChatMessage, String> execute, BiPredicate<ChatInput, String> input)
	{
		commands.put(command.toLowerCase(), new ChatCommand(command, false, execute, input));
	}

	public void registerCommandAsync(String command, BiConsumer<ChatMessage, String> execute)
	{
		registerCommandAsync(command, execute, null);
	}

	public void registerCommandAsync(String command, BiConsumer<ChatMessage, String> execute, BiPredicate<ChatInput, String> input)
	{
		commands.put(command.toLowerCase(), new ChatCommand(command, true, execute, input));
	}

	public void unregisterCommand(String command)
	{
		commands.remove(command.toLowerCase());
	}

	private void onChatMessage(ChatMessage chatMessage)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		switch (chatMessage.getType())
		{
			case PUBLICCHAT:
			case MODCHAT:
			case FRIENDSCHAT:
			case PRIVATECHAT:
			case MODPRIVATECHAT:
			case PRIVATECHATOUT:
				break;
			default:
				return;
		}

		String message = chatMessage.getMessage();

		String command = extractCommand(message);
		if (command == null)
		{
			return;
		}

		ChatCommand chatCommand = commands.get(command.toLowerCase());
		if (chatCommand == null)
		{
			return;
		}

		if (chatCommand.isAsync())
		{
			scheduledExecutorService.execute(() -> chatCommand.getExecute().accept(chatMessage, message));
		}
		else
		{
			chatCommand.getExecute().accept(chatMessage, message);
		}
	}

	@Override
	public boolean onChatboxInput(ChatboxInput chatboxInput)
	{
		String message = chatboxInput.getValue();
		if (message.startsWith("/"))
		{
			message = message.substring(1); // clan chat input
		}

		String command = extractCommand(message);
		if (command == null)
		{
			return false;
		}

		ChatCommand chatCommand = commands.get(command.toLowerCase());
		if (chatCommand == null)
		{
			return false;
		}

		BiPredicate<ChatInput, String> input = chatCommand.getInput();
		if (input == null)
		{
			return false;
		}

		return input.test(chatboxInput, message);
	}

	@Override
	public boolean onPrivateMessageInput(PrivateMessageInput privateMessageInput)
	{
		final String message = privateMessageInput.getMessage();

		String command = extractCommand(message);
		if (command == null)
		{
			return false;
		}

		ChatCommand chatCommand = commands.get(command.toLowerCase());
		if (chatCommand == null)
		{
			return false;
		}

		BiPredicate<ChatInput, String> input = chatCommand.getInput();
		if (input == null)
		{
			return false;
		}

		return input.test(privateMessageInput, message);
	}

	private static String extractCommand(String message)
	{
		int idx = message.indexOf(' ');
		if (idx == -1)
		{
			return message;
		}

		return message.substring(0, idx);
	}
}
