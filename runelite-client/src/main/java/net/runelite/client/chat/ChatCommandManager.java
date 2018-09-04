/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.eventbus.Subscribe;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MessageNode;
import net.runelite.api.events.SetMessage;
import net.runelite.api.vars.AccountType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.events.ChatboxInput;
import net.runelite.client.events.PrivateMessageInput;
import net.runelite.client.util.Text;

@Singleton
@Slf4j
public class ChatCommandManager implements ChatboxInputListener
{
	private static final Splitter SPLITTER = Splitter.on(" ").trimResults().omitEmptyStrings();

	@Getter
	private final Map<String, Command> commands = new HashMap<>();

	private final Client client;
	private final ScheduledExecutorService executorService;
	private final ChatMessageManager chatManager;
	private final ClientThread clientThread;

	@Inject
	private ChatCommandManager(
		final Client client,
		final ScheduledExecutorService executorService,
		final ChatMessageManager chatManager,
		final ClientThread clientThread)
	{
		this.client = client;
		this.executorService = executorService;
		this.chatManager = chatManager;
		this.clientThread = clientThread;
	}

	public Command add(final Command command)
	{
		return commands.put(command.getCommand(), command);
	}

	public Command remove(final String command)
	{
		return commands.remove(command);
	}

	public Command remove(final Command command)
	{
		return remove(command.getCommand());
	}

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		switch (setMessage.getType())
		{
			case PUBLIC:
			case PUBLIC_MOD:
			case CLANCHAT:
			case PRIVATE_MESSAGE_RECEIVED:
			case PRIVATE_MESSAGE_SENT:
				break;
			default:
				return;
		}

		final String search = setMessage.getValue().toLowerCase();
		final Command command = findCommand(search);
		if (command == null || command.print == null)
		{
			return;
		}

		final List<String> args = buildArgs(command, search);
		final String playerName;
		final AccountType accountType;
		if (setMessage.getType().equals(ChatMessageType.PRIVATE_MESSAGE_SENT))
		{
			playerName = client.getLocalPlayer().getName();
			accountType = client.getAccountType();
		}
		else
		{
			final String unsanitizedName = setMessage.getName();
			playerName = Text.sanitize(unsanitizedName);
			if (unsanitizedName.contains("<img=2>"))
			{
				accountType = AccountType.IRONMAN;
			}
			else if (unsanitizedName.contains("<img=3>"))
			{
				accountType = AccountType.ULTIMATE_IRONMAN;
			}
			else if (unsanitizedName.contains("<img=10>"))
			{
				accountType = AccountType.HARDCORE_IRONMAN;
			}
			else
			{
				accountType = AccountType.NORMAL;
			}
		}

		log.debug("Running command {} for player {} with args {} for search {}",
			command.getCommand(), playerName, args, search);

		executorService.submit(() ->
		{
			command.print.accept(new CommandData(playerName, accountType, setMessage.getMessageNode()), args);

			if (!Strings.isNullOrEmpty(setMessage.getMessageNode().getRuneLiteFormatMessage()))
			{
				chatManager.update(setMessage.getMessageNode());
				clientThread.invokeLater(client::refreshChat);
			}
		});
	}

	@Override
	public boolean onChatboxInput(ChatboxInput chatboxInput)
	{
		String search = chatboxInput.getValue().toLowerCase();
		if (search.startsWith("/"))
		{
			search.substring(1); // If typing command to CC
		}

		final Command command = findCommand(search);
		if (command == null || command.block == null)
		{
			return false;
		}

		final List<String> args = buildArgs(command, search);
		final String playerName = client.getLocalPlayer().getName();
		log.debug("Running chat block {} for player {} with args {} for search {}",
			command.getCommand(), playerName, args, search);

		executorService.submit(() ->
		{
			command.block.accept(playerName, args);
			chatboxInput.resume();
		});

		return true;
	}

	@Override
	public boolean onPrivateMessageInput(PrivateMessageInput privateMessageInput)
	{
		final String search = privateMessageInput.getMessage().toLowerCase();
		final Command command = findCommand(search);
		if (command == null || command.block == null)
		{
			return false;
		}

		final List<String> args = buildArgs(command, search);
		final String playerName = client.getLocalPlayer().getName();

		log.debug("Running PM block {} for player {} with args {} for search {}",
			command.getCommand(), playerName, args, search);

		executorService.submit(() ->
		{
			command.block.accept(playerName, args);
			privateMessageInput.resume();
		});

		return true;
	}

	private List<String> buildArgs(final Command command, final String search)
	{
		final int commandLen = command.getCommand().length();
		if (commandLen < search.length())
		{
			return SPLITTER.splitToList(search.substring(commandLen + 1));
		}

		return Collections.emptyList();
	}

	private Command findCommand(final String search)
	{
		for (final Map.Entry<String, Command> entry : commands.entrySet())
		{
			if (search.startsWith(entry.getKey()))
			{
				return entry.getValue();
			}
		}

		return null;
	}

	@Value
	public static class CommandData
	{
		private final String name;
		private final AccountType accountType;
		private final MessageNode message;
	}

	@Value
	@Builder
	public static class Command
	{
		private String command;
		private BiConsumer<String, List<String>> block;
		private BiConsumer<CommandData, List<String>> print;
	}
}
