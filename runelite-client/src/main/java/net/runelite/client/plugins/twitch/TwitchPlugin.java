/*
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
package net.runelite.client.plugins.twitch;

import com.google.common.base.Strings;
import com.google.inject.Provides;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.ChatboxInputListener;
import net.runelite.client.chat.CommandManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatboxInput;
import net.runelite.client.events.PrivateMessageInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.twitch.irc.TwitchIRCClient;
import net.runelite.client.plugins.twitch.irc.TwitchListener;
import net.runelite.client.task.Schedule;

@PluginDescriptor(
	name = "Twitch",
	description = "Integrates Twitch chat",
	enabledByDefault = false
)
@Slf4j
public class TwitchPlugin extends Plugin implements TwitchListener, ChatboxInputListener
{
	@Inject
	private TwitchConfig twitchConfig;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private CommandManager commandManager;

	private TwitchIRCClient twitchIRCClient;

	@Override
	protected void startUp()
	{
		connect();
		commandManager.register(this);
	}

	@Override
	protected void shutDown()
	{
		if (twitchIRCClient != null)
		{
			twitchIRCClient.close();
			twitchIRCClient = null;
		}

		commandManager.unregister(this);
	}

	@Provides
	TwitchConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TwitchConfig.class);
	}

	private synchronized void connect()
	{
		if (twitchIRCClient != null)
		{
			log.debug("Terminating Twitch client {}", twitchIRCClient);
			twitchIRCClient.close();
			twitchIRCClient = null;
		}

		if (!Strings.isNullOrEmpty(twitchConfig.username())
			&& !Strings.isNullOrEmpty(twitchConfig.oauthToken())
			&& !Strings.isNullOrEmpty(twitchConfig.channel()))
		{
			String channel = twitchConfig.channel().toLowerCase();
			if (!channel.startsWith("#"))
			{
				channel = "#" + channel;
			}

			log.debug("Connecting to Twitch as {}", twitchConfig.username());

			twitchIRCClient = new TwitchIRCClient(
				this,
				twitchConfig.username(),
				twitchConfig.oauthToken(),
				channel
			);
			twitchIRCClient.start();
		}
	}

	@Schedule(period = 30, unit = ChronoUnit.SECONDS, asynchronous = true)
	public void checkClient()
	{
		if (twitchIRCClient != null)
		{
			if (twitchIRCClient.isConnected())
			{
				twitchIRCClient.pingCheck();
			}

			if (!twitchIRCClient.isConnected())
			{
				log.debug("Reconnecting...");

				connect();
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (!configChanged.getGroup().equals("twitch"))
		{
			return;
		}

		connect();
	}

	private void addChatMessage(String sender, String message)
	{
		String chatMessage = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append(message)
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.FRIENDSCHAT)
			.sender("Twitch")
			.name(sender)
			.runeLiteFormattedMessage(chatMessage)
			.timestamp((int) (System.currentTimeMillis() / 1000))
			.build());
	}

	@Override
	public void privmsg(Map<String, String> tags, String message)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		String displayName = tags.get("display-name");
		addChatMessage(displayName, message);
	}

	@Override
	public void roomstate(Map<String, String> tags)
	{
		log.debug("Room state: {}", tags);
	}

	@Override
	public void usernotice(Map<String, String> tags, String message)
	{
		log.debug("Usernotice tags: {} message: {}", tags, message);

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		String sysmsg = tags.get("system-msg");
		addChatMessage("[System]", sysmsg);
	}

	@Override
	public boolean onChatboxInput(ChatboxInput chatboxInput)
	{
		String message = chatboxInput.getValue();
		if (message.startsWith("//"))
		{
			message = message.substring(2);
			if (message.isEmpty() || twitchIRCClient == null)
			{
				return true;
			}

			try
			{
				twitchIRCClient.privmsg(message);
				addChatMessage(twitchConfig.username(), message);
			}
			catch (IOException e)
			{
				log.warn("failed to send message", e);
			}

			return true;
		}
		return false;
	}

	@Override
	public boolean onPrivateMessageInput(PrivateMessageInput privateMessageInput)
	{
		return false;
	}
}
