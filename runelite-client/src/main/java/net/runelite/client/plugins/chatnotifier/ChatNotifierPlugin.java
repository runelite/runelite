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
package net.runelite.client.plugins.chatnotifier;

import com.google.common.base.Splitter;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.WildcardMatcher;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@PluginDescriptor(
		name = "Chat Notifier"
)
public class ChatNotifierPlugin extends Plugin {

	private static final Splitter COMMA_SPLITTER = Splitter.on(Pattern.compile("\\s*,\\s*"));

	private List<String> customMessages = new ArrayList<>();

	@Inject
	private Client client;

	@Inject
	private Notifier notifier;

	@Inject
	private ChatNotifierConfig config;

	@Provides
	ChatNotifierConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatNotifierConfig.class);
	}

	@Subscribe
	private void onConfigChange(ConfigChanged event)
	{
		if (event.getGroup().equals("chatnotifier") && event.getKey().equals("customMessages"))
		{
			splitCustomMessages(event.getNewValue());
		}
	}

	@Subscribe
	private void onChatMessage(ChatMessage event)
	{
		if (config.notifyOnDuel() && event.getType().equals(ChatMessageType.DUEL))
		{
			sendNotification(event.getMessage());
			return;
		}
		else if (config.notifyOnTrade() && event.getType().equals(ChatMessageType.TRADE_RECEIVED))
		{
			sendNotification(event.getMessage());
			return;
		}

		if (config.onlySpecificMessages() && !event.getType().equals(config.onlyTypeMessage()))
		{
			return;
		}

		if (!customMessages.isEmpty())
		{
			for (String message : customMessages)
			{
				if (WildcardMatcher.matches(message, event.getMessage()))
				{
					sendNotification(message);
					break;
				}
			}
		}
	}

	@Override
	protected void startUp() throws  Exception
	{
		splitCustomMessages(config.customMessages());
	}

	private void splitCustomMessages(String customMessage)
	{
		customMessages = COMMA_SPLITTER.splitToList(customMessage);
	}

	private void sendNotification(String message)
	{
		notifier.notify("Message: " + message);
	}
}
