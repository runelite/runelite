/*
 * Copyright (c) 2018, PandahRS <https://github.com/PandahRS>
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
package net.runelite.client.plugins.chatpreviousworld;

import com.google.common.collect.EvictingQueue;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.SetMessage;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(name = "World History in chat")
public class PreviousWorldChatPlugin extends Plugin
{
	private static final String WORLD_TEXT = "You've previously logged in within the following worlds:";
	private static final String WELCOME_MESSAGE = "Welcome to RuneScape.";

	@Inject
	private Client client;

	@Inject
	private PreviousWorldChatConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	private SetMessage lastMessage;
	private Queue<QueuedMessage> messageQueue;

	@Provides
	PreviousWorldChatConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PreviousWorldChatConfig.class);
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
		}

		// If the messsage contains our world message, we want to update it to reflect new(er) worlds.
		if (message.getValue().contains(WORLD_TEXT))
		{
			editWorldMessage(message);
		}
		else
		{
			sendWorldMessage(message);
		}
	}

	@Override
	protected void startUp()
	{
		messageQueue = EvictingQueue.create(100);
	}

	@Override
	protected void shutDown()
	{
		saveLatestWorld();
		messageQueue.clear();
		messageQueue = null;
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case CONNECTION_LOST:
				saveLatestWorld();
		}
	}

	/**
	 * Edits the current message which contains the WORLD_TEXT property.
	 * @param setMessage
	 */
	private void editWorldMessage(SetMessage setMessage)
	{
		final String worldMessage = getWorldMessage();
		final MessageNode messageNode = setMessage.getMessageNode();
		messageNode.setValue(worldMessage);
		messageNode.setRuneLiteFormatMessage(worldMessage);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	/**
	 * Sends a new message containing the WORLD_TEXT property to the chatbox.
	 * @param setMessage
	 */
	private void sendWorldMessage(SetMessage setMessage)
	{
		final String worldMessage = getWorldMessage();
		final QueuedMessage queuedMessage = QueuedMessage.builder()
			.type(setMessage.getType())
			.name(setMessage.getName())
			.sender(setMessage.getSender())
			.value(worldMessage)
			.runeLiteFormattedMessage(worldMessage)
			.build();

		chatMessageManager.queue(queuedMessage);
	}

	/**
	 * Saves the latest world to the config, while removing any worlds that become out of bounds.
	 */
	private void saveLatestWorld()
	{
		if (config == null)
		{
			return;
		}

		final String latestWorld = String.valueOf(client.getWorld());
		final ArrayList<String> worlds = getWorlds();

		String lastSavedWorld = "";

		if (worlds.size() > 0)
		{
			lastSavedWorld = worlds.get(0);
		}

		// Only save the latest worlds as actual 'latest'
		if (latestWorld != lastSavedWorld)
		{
			worlds.add(0, String.valueOf(latestWorld));

			if (worlds.size() > config.getMaxWorldCount())
			{
				worlds.subList(config.getMaxWorldCount(), worlds.size()).clear();
			}

			config.pastWorldList(String.join(",", worlds));
		}

	}

	/**
	 * Retrieves and converts the worlds from the configuration.
	 * @return returns an ArrayList of worlds (as strings).
	 */
	private ArrayList<String> getWorlds()
	{
		if (config != null)
		{
			final String worldListText = config.pastWorldList();
			return new ArrayList<>(Arrays.asList(worldListText.split(",")));
		}

		return new ArrayList<>();
	}

	private String getWorldMessage()
	{
		return new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append(WORLD_TEXT)
			.append(ChatColorType.HIGHLIGHT)
			.append(String.join(", ", getWorlds()))
			.build();
	}

}
