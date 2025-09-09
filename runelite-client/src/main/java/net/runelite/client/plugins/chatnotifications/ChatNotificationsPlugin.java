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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Named;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Notification;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Chat Notifications",
	description = "Highlight and notify you of chat messages",
	tags = {"duel", "messages", "notifications", "trade", "username"},
	enabledByDefault = false
)
public class ChatNotificationsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ChatNotificationsConfig config;

	@Inject
	private Notifier notifier;

	@Inject
	@Named("runelite.title")
	private String runeliteTitle;

	//Custom Highlights
	private Pattern usernameMatcher = null;
	private final List<Pattern> highlightPatterns = new ArrayList<>();

	@Provides
	ChatNotificationsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatNotificationsConfig.class);
	}

	@Override
	public void startUp()
	{
		updateHighlights();
	}

	@Override
	protected void shutDown()
	{
		usernameMatcher = null;
		highlightPatterns.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
			case HOPPING:
				usernameMatcher = null;
				break;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("chatnotification"))
		{
			updateHighlights();
		}
	}

	private void updateHighlights()
	{
		highlightPatterns.clear();

		if (!config.highlightWordsString().trim().equals(""))
		{
			List<String> items = Text.fromCSV(config.highlightWordsString());
			String joined = items.stream()
				.map(Text::escapeJagex) // we compare these strings to the raw Jagex ones
				.map(this::quoteAndIgnoreColor) // regex escape and ignore nested colors in the target message
				.collect(Collectors.joining("|"));
			// To match <word> \b doesn't work due to <> not being in \w,
			// so match \b or \s, as well as \A and \z for beginning and end of input respectively
			highlightPatterns.add(Pattern.compile("(?:\\b|(?<=\\s)|\\A)(?:" + joined + ")(?:\\b|(?=\\s)|\\z)", Pattern.CASE_INSENSITIVE));
		}

		Splitter
			.on("\n")
			.omitEmptyStrings()
			.trimResults()
			.splitToList(config.highlightRegexString()).stream()
			.map(ChatNotificationsPlugin::compilePattern)
			.filter(Objects::nonNull)
			.forEach(highlightPatterns::add);
	}

	private static Pattern compilePattern(String pattern)
	{
		try
		{
			return Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		}
		catch (PatternSyntaxException ex)
		{
			return null;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		MessageNode messageNode = chatMessage.getMessageNode();
		boolean update = false;

		switch (chatMessage.getType())
		{
			case TRADEREQ:
				if (chatMessage.getMessage().contains("wishes to trade with you."))
				{
					notifier.notify(config.notifyOnTrade(), chatMessage.getMessage());
				}
				break;
			case CHALREQ_TRADE:
				if (chatMessage.getMessage().contains("wishes to duel with you."))
				{
					notifier.notify(config.notifyOnDuel(), chatMessage.getMessage());
				}
				break;
			case BROADCAST:
				// Some broadcasts have links attached, notated by `|` followed by a number, while others contain color tags.
				// We don't want to see either in the printed notification.
				String broadcast = chatMessage.getMessage();

				int urlTokenIndex = broadcast.lastIndexOf('|');
				if (urlTokenIndex != -1)
				{
					broadcast = broadcast.substring(0, urlTokenIndex);
				}

				notifier.notify(config.notifyOnBroadcast(), Text.removeFormattingTags(broadcast));
				break;
			case PRIVATECHAT:
			case MODPRIVATECHAT:
				notifier.notify(config.notifyOnPM(), Text.removeTags(chatMessage.getName()) + ": " + chatMessage.getMessage());
				break;
			case PRIVATECHATOUT:
			case DIALOG:
			case MESBOX:
				return;
			case MODCHAT:
			case PUBLICCHAT:
			case FRIENDSCHAT:
			case CLAN_CHAT:
			case CLAN_GUEST_CHAT:
			case CLAN_GIM_CHAT:
			case AUTOTYPER:
			case MODAUTOTYPER:
				if (client.getLocalPlayer() != null && Text.toJagexName(Text.removeTags(chatMessage.getName())).equals(client.getLocalPlayer().getName()))
				{
					return;
				}
				break;
			case CONSOLE:
				// Don't notify for notification messages
				if (chatMessage.getName().equals(runeliteTitle))
				{
					return;
				}
				break;
		}

		if (usernameMatcher == null && client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null)
		{
			String username = client.getLocalPlayer().getName();
			String pattern = Arrays.stream(username.split(" "))
				.map(s -> s.isEmpty() ? "" : Pattern.quote(s))
				.collect(Collectors.joining("[\u00a0\u0020]")); // space or nbsp
			usernameMatcher = Pattern.compile("\\b" + pattern + "\\b", Pattern.CASE_INSENSITIVE);
		}

		if (config.highlightOwnName() && usernameMatcher != null)
		{
			final String message = messageNode.getValue();
			Matcher matcher = usernameMatcher.matcher(message);
			if (matcher.find())
			{
				final String username = client.getLocalPlayer().getName();
				StringBuffer stringBuffer = new StringBuffer();
				do
				{
					final int start = matcher.start(); // start not end, since username won't contain a col tag
					final String closeColor = MoreObjects.firstNonNull(
						getLastColor(message.substring(0, start)),
						"<col" + ChatColorType.NORMAL + '>');
					final String replacement = "<col" + ChatColorType.HIGHLIGHT.name() + "><u>" + username + "</u>" + closeColor;
					matcher.appendReplacement(stringBuffer, replacement);
				}
				while (matcher.find());

				matcher.appendTail(stringBuffer);

				messageNode.setValue(stringBuffer.toString());
				update = true;

				if (chatMessage.getType() == ChatMessageType.PUBLICCHAT
					|| chatMessage.getType() == ChatMessageType.PRIVATECHAT
					|| chatMessage.getType() == ChatMessageType.FRIENDSCHAT
					|| chatMessage.getType() == ChatMessageType.MODCHAT
					|| chatMessage.getType() == ChatMessageType.MODPRIVATECHAT
					|| chatMessage.getType() == ChatMessageType.CLAN_CHAT
					|| chatMessage.getType() == ChatMessageType.CLAN_GUEST_CHAT)
				{
					sendNotification(config.notifyOnOwnName(), chatMessage);
				}
			}
		}

		boolean matchesHighlight = false;
		// Get nodeValue to store and update in between the different pattern passes
		// The messageNode value is only set after all patterns have been processed
		String nodeValue = messageNode.getValue();

		for (Pattern pattern : highlightPatterns)
		{
			Matcher matcher = pattern.matcher(nodeValue);
			if (!matcher.find())
			{
				continue;
			}

			StringBuffer stringBuffer = new StringBuffer();

			do
			{
				final int end = matcher.end();
				// Determine the ending color by finding the last color tag up to and
				// including the match.
				final String closeColor = MoreObjects.firstNonNull(
					getLastColor(nodeValue.substring(0, end)),
					"<col" + ChatColorType.NORMAL + '>');
				// Strip color tags from the highlighted region so that it remains highlighted correctly
				final String value = stripColor(matcher.group());

				matcher.appendReplacement(stringBuffer, "<col" + ChatColorType.HIGHLIGHT + '>' + value + closeColor);

				update = true;
				matchesHighlight = true;
			}
			while (matcher.find());

			// Append stringBuffer with remainder of message and update nodeValue
			matcher.appendTail(stringBuffer);
			nodeValue = stringBuffer.toString();
		}

		if (matchesHighlight)
		{
			messageNode.setValue(nodeValue);
			sendNotification(config.notifyOnHighlight(), chatMessage);
		}

		if (update)
		{
			messageNode.setRuneLiteFormatMessage(messageNode.getValue());
		}
	}

	private void sendNotification(Notification notification, ChatMessage message)
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
		String m = stringBuilder.toString();
		notifier.notify(notification, m);
	}

	private String quoteAndIgnoreColor(String str)
	{
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < str.length(); ++i)
		{
			char c = str.charAt(i);
			stringBuilder.append(Pattern.quote(String.valueOf(c)));
			stringBuilder.append("(?:<col=[^>]*?>)?");
		}

		return stringBuilder.toString();
	}

	/**
	 * Get the last color tag from a string, or null if there was none
	 *
	 * @param str
	 * @return
	 */
	private static String getLastColor(String str)
	{
		int colIdx = str.lastIndexOf("<col=");
		int colEndIdx = str.lastIndexOf("</col>");

		if (colEndIdx > colIdx)
		{
			// ends in a </col> which resets the color to normal
			return "<col" + ChatColorType.NORMAL + ">";
		}

		if (colIdx == -1)
		{
			return null; // no color
		}

		int closeIdx = str.indexOf('>', colIdx);
		if (closeIdx == -1)
		{
			return null; // unclosed col tag
		}

		return str.substring(colIdx, closeIdx + 1); // include the >
	}

	/**
	 * Strip color tags from a string.
	 *
	 * @param str
	 * @return
	 */
	@VisibleForTesting
	static String stripColor(String str)
	{
		return str.replaceAll("(<col=[0-9a-f]+>|</col>)", "");
	}
}
