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
package net.runelite.client.plugins.world;

import com.google.common.collect.EvictingQueue;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Queue;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MessageNode;
import net.runelite.api.WorldType;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.SessionOpen;
import net.runelite.api.events.SetMessage;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.http.api.worlds.WorldResult;

@PluginDescriptor(name = "World")
@Slf4j
public class WorldPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private WorldConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	private Queue<QueuedMessage> messageQueue;

	private final int previousWorldLimit = 3;
	private static final String WORLD_TEXT = "You've previously logged in to the following worlds: ";
	private static final String WELCOME_MESSAGE = "Welcome to RuneScape.";

	private final WorldClient worldClient = new WorldClient();
	private int worldCache;
	private boolean worldChangeRequired;

	@Override
	protected void startUp() throws Exception
	{
		messageQueue = EvictingQueue.create(previousWorldLimit);
		worldChangeRequired = true;
		applyWorld();
	}

	@Override
	protected void shutDown() throws Exception
	{
		messageQueue = null;
		worldChangeRequired = true;
		changeWorld(worldCache);
	}

	@Provides
	WorldConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WorldConfig.class);
	}

	@Subscribe
	public void onSessionOpen(SessionOpen event)
	{
		worldChangeRequired = true;
		applyWorld();
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		applyWorld();
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

			// Display the last worlds if the option has been enabled.
			if (config.displayLastWorlds())
			{
				// If the message is already within the chat, edit it.
				// Otherwise, add it.
				if (message.getValue().contains(WORLD_TEXT))
				{
					editWorldMessage(message);
				}
				else
				{
					sendWorldMessage(message);
				}
			}

			return;
		}
	}


	private void changeWorld(int newWorld)
	{
		if (!worldChangeRequired || client.getGameState() != GameState.LOGIN_SCREEN)
		{
			if (client.getGameState() == GameState.HOPPING || client.getGameState() == GameState.CONNECTION_LOST)
			{
				saveWorld(client.getWorld());
			}
			return;
		}

		worldChangeRequired = false;
		int correctedWorld = newWorld < 300 ? newWorld + 300 : newWorld;

		// Old School RuneScape worlds start on 301 so don't even bother trying to find lower id ones
		// and also do not try to set world if we are already on it
		if (correctedWorld <= 300 || client.getWorld() == correctedWorld)
		{
			return;
		}

		try
		{
			final WorldResult worldResult = worldClient.lookupWorlds();
			final World world = worldResult.findWorld(correctedWorld);

			if (world != null)
			{
				final net.runelite.api.World rsWorld = client.createWorld();
				rsWorld.setActivity(world.getActivity());
				rsWorld.setAddress(world.getAddress());
				rsWorld.setId(world.getId());
				rsWorld.setPlayerCount(world.getPlayers());
				rsWorld.setLocation(world.getLocation());
				rsWorld.setTypes(toWorldTypes(world.getTypes()));


				client.changeWorld(rsWorld);
				log.debug("Applied new world {}", correctedWorld);
			}
			else
			{
				log.warn("World {} not found.", correctedWorld);
			}
		}
		catch (IOException e)
		{
			log.warn("Error looking up world {}. Error: {}", correctedWorld, e);
		}
	}

	private static EnumSet<WorldType> toWorldTypes(final EnumSet<net.runelite.http.api.worlds.WorldType> apiTypes)
	{
		final EnumSet<WorldType> types = EnumSet.noneOf(WorldType.class);

		for (net.runelite.http.api.worlds.WorldType apiType : apiTypes)
		{
			types.add(WorldType.valueOf(apiType.name()));
		}

		return types;
	}

	private void applyWorld()
	{
		if (worldCache == 0)
		{
			worldCache = client.getWorld();
			log.debug("Stored old world {}", worldCache);
		}

		final int newWorld = config.getWorld();
		changeWorld(newWorld);
	}

	/**
	 * Saves the given world to the configuration as a previous world.
	 * @param world world to save.
	 */
	private void saveWorld(final int world)
	{
		//Do not save worlds if the user doesn't want it.
		if (!config.displayLastWorlds())
		{
			return;
		}

		final String latestWorld = String.valueOf(world);
		final ArrayList<String> worlds = getWorlds();

		String lastSavedWorld = "";
		if (worlds.size() > 0)
		{
			lastSavedWorld = worlds.get(0);
		}

		// Only save the latest worlds as actual 'latest'
		if (!latestWorld.equals(lastSavedWorld))
		{
			worlds.add(0, String.valueOf(latestWorld));

			if (worlds.size() > previousWorldLimit)
			{
				worlds.subList(previousWorldLimit, worlds.size()).clear();
			}

			config.pastWorldList(String.join(",", worlds));
		}
	}

	/**
	 * Edits the current message which contains the WORLD_TEXT property.
	 * @param setMessage Initial message to edit.
	 */
	private void editWorldMessage(final SetMessage setMessage)
	{
		final String worldMessage = formatPreviousWorldMessage();
		final MessageNode messageNode = setMessage.getMessageNode();

		messageNode.setRuneLiteFormatMessage(worldMessage);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	/**
	 * Sends a new message containing the WORLD_TEXT property to the chatbox.
	 * @param setMessage Initial message used to set up the queued message.
	 */
	private void sendWorldMessage(final SetMessage setMessage)
	{
		if (getWorlds().size() ==  0)
		{
			return;
		}

		final String worldMessage = formatPreviousWorldMessage();
		final QueuedMessage queuedMessage = QueuedMessage.builder()
			.type(setMessage.getType())
			.runeLiteFormattedMessage(worldMessage)
			.build();

		chatMessageManager.queue(queuedMessage);
	}

	/**
	 * Formats the previous world message.
	 * @return returns a String set up by the ChatMessageBuilder.
	 */
	private String formatPreviousWorldMessage()
	{
		return new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(WORLD_TEXT)
			.append(ChatColorType.HIGHLIGHT)
			.append(String.join(", ", getWorlds()))
			.build();
	}

	/**
	 * Retrieves and converts the worlds from the configuration.
	 * @return returns an ArrayList of worlds (as strings).
	 */
	private ArrayList<String> getWorlds()
	{
		if (config == null)
		{
			return new ArrayList<>();
		}

		return new ArrayList<>(Arrays.asList(config.pastWorldList().split(",")));
	}
}
