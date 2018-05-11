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
import com.google.common.eventbus.Subscribe;

import java.util.Queue;
import java.util.Set;
import javax.inject.Inject;

import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.SetMessage;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.chat.QueuedMessage.QueuedMessageBuilder;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(name = "Chat History")
public class ChatHistoryPlugin extends Plugin
{
	private static final String WELCOME_MESSAGE = "Welcome to RuneScape.";

	private Set<ChatMessageType> ALLOWED_HISTORY;

	private Queue<QueuedMessage> messageQueue;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ChatHistoryConfig config;

	@Provides
	ChatHistoryConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatHistoryConfig.class);
	}

	@Override
	protected void startUp()
	{
		populateAllowedMessages();
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
			final QueuedMessageBuilder queuedMessageBuilder = QueuedMessage.builder()
				.type(message.getType())
				.name(message.getName())
				.sender(message.getSender())
				.value(nbsp(message.getValue()));

			// Check to see if this is a formatted message from RuneLite - such the GE/HA value on examine
			if (message.getValue().contains("<col"))
				queuedMessageBuilder.runeLiteFormattedMessage(nbsp(message.getValue()));

			QueuedMessage queuedMessage = queuedMessageBuilder.build();

			// Removed check for message in the queue - this was filtering out messages that may
			// be appearing more than once on purpose (eating two pieces of food, chopping logs, etc)
			messageQueue.offer(queuedMessage);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuOption().contains("Clear history"))
		{
			messageQueue.removeIf(e -> e.getType() == ChatMessageType.PRIVATE_MESSAGE_RECEIVED ||
				e.getType() == ChatMessageType.PRIVATE_MESSAGE_SENT || e.getType() == ChatMessageType.PRIVATE_MESSAGE_RECEIVED_MOD);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("chathistory"))
		{
			populateAllowedMessages();

			// If the event's new value is false, it means we need to check the message queue
			// for any unwanted message types and remove them before the next hop or login
			if (event.getNewValue().equals("false"))
				purgeUnwantedMessages(event.getKey());
		}
	}

	/**
	 * Removes messages of unwanted types from the queue based on the event keyName
	 */
	private void purgeUnwantedMessages(String keyName)
	{
		switch (keyName)
		{
			case "savePublicChat":
				messageQueue.removeIf(message -> message.getType() == ChatMessageType.PUBLIC);
				break;
			case "savePrivateChat":
				messageQueue.removeIf(message -> message.getType() == ChatMessageType.PRIVATE_MESSAGE_SENT
					|| message.getType() == ChatMessageType.PRIVATE_MESSAGE_RECEIVED
					|| message.getType() == ChatMessageType.PRIVATE_MESSAGE_RECEIVED_MOD);
				break;
			case "saveClanChat":
				messageQueue.removeIf(message -> message.getType() == ChatMessageType.CLANCHAT);
				break;
			case "saveGameMessages":
				messageQueue.removeIf(message -> message.getType() == ChatMessageType.GAME);
				break;
			case "saveFilteredMessages":
				messageQueue.removeIf(message -> message.getType() == ChatMessageType.FILTERED);
				break;
			case "saveExamineMessages":
				messageQueue.removeIf(message -> message.getType() == ChatMessageType.EXAMINE_ITEM
					|| message.getType() == ChatMessageType.EXAMINE_NPC
					|| message.getType() == ChatMessageType.EXAMINE_OBJECT);
				break;
			case "saveTradeMessages":
				messageQueue.removeIf(message -> message.getType() == ChatMessageType.TRADE
					|| message.getType() == ChatMessageType.TRADE_RECEIVED
					|| message.getType() == ChatMessageType.TRADE_SENT);
				break;
			case "saveDuelMessages":
				messageQueue.removeIf(message -> message.getType() == ChatMessageType.DUEL);
				break;
			default:
				break;
		}
	}

	/**
	 * Populates the set of message types allowed to be saved to the history
	 */
	private void populateAllowedMessages()
	{

		ALLOWED_HISTORY = Sets.newHashSet();

		if (config.savePublicChat())
			ALLOWED_HISTORY.add(ChatMessageType.PUBLIC);

		if (config.savePrivateChat())
		{
			ALLOWED_HISTORY.add(ChatMessageType.PRIVATE_MESSAGE_RECEIVED);
			ALLOWED_HISTORY.add(ChatMessageType.PRIVATE_MESSAGE_SENT);
			ALLOWED_HISTORY.add(ChatMessageType.PRIVATE_MESSAGE_RECEIVED_MOD);
		}

		if (config.saveClanChat())
			ALLOWED_HISTORY.add(ChatMessageType.CLANCHAT);

		if (config.saveGameMessages())
			ALLOWED_HISTORY.add(ChatMessageType.GAME);

		if (config.saveFilteredMessages())
			ALLOWED_HISTORY.add(ChatMessageType.FILTERED);

		if (config.saveExamineMessages())
		{
			ALLOWED_HISTORY.add(ChatMessageType.EXAMINE_ITEM);
			ALLOWED_HISTORY.add(ChatMessageType.EXAMINE_NPC);
			ALLOWED_HISTORY.add(ChatMessageType.EXAMINE_OBJECT);
		}

		if (config.saveTradeMessages())
		{
			ALLOWED_HISTORY.add(ChatMessageType.TRADE);
			ALLOWED_HISTORY.add(ChatMessageType.TRADE_RECEIVED);
			ALLOWED_HISTORY.add(ChatMessageType.TRADE_SENT);
		}

		if (config.saveDuelMessages())
			ALLOWED_HISTORY.add(ChatMessageType.DUEL);
	}

	/**
	 * Small hack to prevent plugins checking for specific messages to match
	 *
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
