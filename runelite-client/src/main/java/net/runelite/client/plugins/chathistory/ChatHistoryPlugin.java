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
package net.runelite.client.plugins.chathistory;

import com.google.common.collect.EvictingQueue;
import com.google.common.collect.Sets;
import java.util.Queue;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.SetMessage;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Chat History",
	description = "Retain your chat history when logging in/out or world hopping"
)
public class ChatHistoryPlugin extends Plugin
{
	private static final String WELCOME_MESSAGE = "Welcome to Old School RuneScape.";
	private static final String CLEAR_HISTORY = "Clear history";
	private static final String CLEAR_PRIVATE = "<col=ffff00>Private:";
	private static final Set<ChatMessageType> ALLOWED_HISTORY = Sets.newHashSet(
		ChatMessageType.PUBLIC,
		ChatMessageType.PUBLIC_MOD,
		ChatMessageType.CLANCHAT,
		ChatMessageType.PRIVATE_MESSAGE_RECEIVED,
		ChatMessageType.PRIVATE_MESSAGE_SENT,
		ChatMessageType.PRIVATE_MESSAGE_RECEIVED_MOD,
		ChatMessageType.GAME
	);

	private Queue<QueuedMessage> messageQueue;

	@Inject
	private ChatMessageManager chatMessageManager;
	
	@Override
	protected void startUp()
	{
		messageQueue = EvictingQueue.create(100);
	}

	@Override
	protected void shutDown()
	{
		messageQueue.clear();
		messageQueue = null;
	}

	@Subscribe
	public void onSetMessage(SetMessage message)
	{
		// Start sending old messages right after the welcome message, as that is most reliable source
		// of information that chat history was reset
		if (message.getValue().equals(WELCOME_MESSAGE))
		{
			QueuedMessage queuedMessage;

			while ((queuedMessage = messageQueue.poll()) != null)
			{
				chatMessageManager.queue(queuedMessage);
			}

			return;
		}

		if (ALLOWED_HISTORY.contains(message.getType()))
		{
			final QueuedMessage queuedMessage = QueuedMessage.builder()
				.type(message.getType())
				.name(message.getName())
				.sender(message.getSender())
				.value(nbsp(message.getValue()))
				.runeLiteFormattedMessage(nbsp(message.getMessageNode().getRuneLiteFormatMessage()))
				.timestamp(message.getTimestamp())
				.build();

			if (!messageQueue.contains(queuedMessage))
			{
				messageQueue.offer(queuedMessage);
			}
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		String menuOption = event.getMenuOption();

		if (menuOption.contains(CLEAR_HISTORY))
		{
			if (menuOption.startsWith(CLEAR_PRIVATE))
			{
				messageQueue.removeIf(e -> e.getType() == ChatMessageType.PRIVATE_MESSAGE_RECEIVED ||
					e.getType() == ChatMessageType.PRIVATE_MESSAGE_SENT || e.getType() == ChatMessageType.PRIVATE_MESSAGE_RECEIVED_MOD);
			}
			else
			{
				messageQueue.removeIf(e -> e.getType() == ChatMessageType.PUBLIC || e.getType() == ChatMessageType.PUBLIC_MOD);
			}
		}
	}

	/**
	 * Small hack to prevent plugins checking for specific messages to match
	 * @param message message
	 * @return message with nbsp
	 */
	private static String nbsp(final String message)
	{
		if (message != null)
		{
			return message.replace(' ', '\u00A0');
		}

		return null;
	}
}
