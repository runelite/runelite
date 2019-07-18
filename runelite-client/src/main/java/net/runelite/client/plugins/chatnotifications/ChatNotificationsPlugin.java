/*
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.chatnotifications;

import com.google.common.base.Strings;
import com.google.inject.Provides;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.quote;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.Notifier;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Chat Notifications",
	description = "Highlight and notify you of chat messages",
	tags = {"duel", "messages", "notifications", "trade", "username"},
	enabledByDefault = false
)
@Singleton
public class ChatNotificationsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ChatNotificationsConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private Notifier notifier;

	@Inject
	private RuneLiteProperties runeLiteProperties;

	@Inject
	private EventBus eventBus;

	//Custom Highlights
	private Pattern usernameMatcher = null;
	private String usernameReplacer = "";
	private Pattern highlightMatcher = null;

	// Private message cache used to avoid duplicate notifications from ChatHistory.
	private final Set<Integer> privateMessageHashes = new HashSet<>();

	private boolean highlightOwnName;
	private String highlightWordsString;
	private boolean notifyOnOwnName;
	private boolean notifyOnHighlight;
	private boolean notifyOnTrade;
	private boolean notifyOnDuel;
	private boolean notifyOnPm;

	@Provides
	ChatNotificationsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatNotificationsConfig.class);
	}

	@Override
	public void startUp()
	{
		updateConfig();
		addSubscriptions();

		updateHighlights();
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);

		this.privateMessageHashes.clear();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
			case HOPPING:
				usernameMatcher = null;
				break;
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("chatnotification"))
		{
			updateConfig();
			updateHighlights();
		}
	}

	private void updateHighlights()
	{
		highlightMatcher = null;

		if (!this.highlightWordsString.trim().equals(""))
		{
			List<String> items = Text.fromCSV(this.highlightWordsString);
			String joined = items.stream()
				.map(Text::escapeJagex) // we compare these strings to the raw Jagex ones
				.map(Pattern::quote)
				.collect(Collectors.joining("|"));
			// To match <word> \b doesn't work due to <> not being in \w,
			// so match \b or \s
			highlightMatcher = Pattern.compile("(?:\\b|(?<=\\s))(" + joined + ")(?:\\b|(?=\\s))", Pattern.CASE_INSENSITIVE);
		}
	}

	void onChatMessage(ChatMessage chatMessage)
	{
		MessageNode messageNode = chatMessage.getMessageNode();
		boolean update = false;

		switch (chatMessage.getType())
		{
			case TRADEREQ:
				if (chatMessage.getMessage().contains("wishes to trade with you.") && this.notifyOnTrade)
				{
					notifier.notify(chatMessage.getMessage());
				}
				break;
			case CHALREQ_TRADE:
				if (chatMessage.getMessage().contains("wishes to duel with you.") && this.notifyOnDuel)
				{
					notifier.notify(chatMessage.getMessage());
				}
				break;
			case CONSOLE:
				// Don't notify for notification messages
				if (chatMessage.getName().equals(runeLiteProperties.getTitle()))
				{
					return;
				}
				break;
			case PRIVATECHAT:
			case MODPRIVATECHAT:
				if (this.notifyOnPm)
				{
					int messageHash = this.buildMessageHash(chatMessage);
					if (this.privateMessageHashes.contains(messageHash))
					{
						return;
					}
					this.privateMessageHashes.add(messageHash);
					notifier.notify("Private message received from " + chatMessage.getName());
				}
				break;
		}

		if (usernameMatcher == null && client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null)
		{
			String username = client.getLocalPlayer().getName();
			usernameMatcher = Pattern.compile("\\b(" + quote(username) + ")\\b", Pattern.CASE_INSENSITIVE);
			usernameReplacer = "<col" + ChatColorType.HIGHLIGHT.name() + "><u>" + username + "</u><col" + ChatColorType.NORMAL.name() + ">";
		}

		if (this.highlightOwnName && usernameMatcher != null)
		{
			Matcher matcher = usernameMatcher.matcher(messageNode.getValue());
			if (matcher.find())
			{
				messageNode.setValue(matcher.replaceAll(usernameReplacer));
				update = true;

				if (this.notifyOnOwnName)
				{
					sendNotification(chatMessage);
				}
			}
		}

		if (highlightMatcher != null)
		{
			String nodeValue = messageNode.getValue();
			Matcher matcher = highlightMatcher.matcher(nodeValue);
			boolean found = false;
			StringBuffer stringBuffer = new StringBuffer();

			while (matcher.find())
			{
				String value = matcher.group();
				matcher.appendReplacement(stringBuffer, "<col" + ChatColorType.HIGHLIGHT + ">" + value + "<col" + ChatColorType.NORMAL + ">");
				update = true;
				found = true;
			}

			if (found)
			{
				matcher.appendTail(stringBuffer);
				messageNode.setValue(stringBuffer.toString());

				if (this.notifyOnHighlight)
				{
					sendNotification(chatMessage);
				}
			}
		}

		if (update)
		{
			messageNode.setRuneLiteFormatMessage(messageNode.getValue());
			chatMessageManager.update(messageNode);
		}
	}

	private int buildMessageHash(ChatMessage message)
	{
		return (message.getName() + message.getMessage()).hashCode();
	}

	private void sendNotification(ChatMessage message)
	{
		String name = Text.removeTags(message.getName());
		String sender = message.getSender();
		StringBuilder stringBuilder = new StringBuilder();

		if (!Strings.isNullOrEmpty(sender))
		{
			stringBuilder.append('[').append(sender).append("] ");
		}

		if (!Strings.isNullOrEmpty(name))
		{
			stringBuilder.append(name).append(": ");
		}

		stringBuilder.append(Text.removeTags(message.getMessage()));
		String notification = stringBuilder.toString();
		notifier.notify(notification);
	}

	private void updateConfig()
	{
		this.highlightOwnName = config.highlightOwnName();
		this.highlightWordsString = config.highlightWordsString();
		this.notifyOnOwnName = config.notifyOnOwnName();
		this.notifyOnHighlight = config.notifyOnHighlight();
		this.notifyOnTrade = config.notifyOnTrade();
		this.notifyOnDuel = config.notifyOnDuel();
		this.notifyOnPm = config.notifyOnPm();
	}
}
