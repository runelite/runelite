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
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
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
	private ChatMessageManager chatMessageManager;

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
				if (chatMessage.getMessage().contains("wishes to trade with you.") && config.notifyOnTrade())
				{
					notifier.notify(chatMessage.getMessage());
				}
				break;
			case CHALREQ_TRADE:
				if (chatMessage.getMessage().contains("wishes to duel with you.") && config.notifyOnDuel())
				{
					notifier.notify(chatMessage.getMessage());
				}
				break;
			case BROADCAST:
				if (config.notifyOnBroadcast())
				{
					// Some broadcasts have links attached, notated by `|` followed by a number, while others contain color tags.
					// We don't want to see either in the printed notification.
					String broadcast = chatMessage.getMessage();

					int urlTokenIndex = broadcast.lastIndexOf('|');
					if (urlTokenIndex != -1)
					{
						broadcast = broadcast.substring(0, urlTokenIndex);
					}

					notifier.notify(Text.removeFormattingTags(broadcast));
				}
				break;
			case PRIVATECHAT:
			case MODPRIVATECHAT:
				if (config.notifyOnPM())
				{
					notifier.notify(Text.removeTags(chatMessage.getName()) + ": " + chatMessage.getMessage());
				}
				break;
			case PRIVATECHATOUT:
				return;
			case MODCHAT:
			case PUBLICCHAT:
			case FRIENDSCHAT:
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
				final int start = matcher.start();
				final String username = client.getLocalPlayer().getName();
				final String closeColor = MoreObjects.firstNonNull(getLastColor(message.substring(0, start)), "</col>");
				final String replacement = "<col" + ChatColorType.HIGHLIGHT.name() + "><u>" + username + "</u>" + closeColor;
				messageNode.setValue(matcher.replaceAll(replacement));
				update = true;
				if (config.notifyOnOwnName() && (chatMessage.getType() == ChatMessageType.PUBLICCHAT
					|| chatMessage.getType() == ChatMessageType.PRIVATECHAT
					|| chatMessage.getType() == ChatMessageType.FRIENDSCHAT
					|| chatMessage.getType() == ChatMessageType.MODCHAT
					|| chatMessage.getType() == ChatMessageType.MODPRIVATECHAT))
				{
					sendNotification(chatMessage);
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
				String value = matcher.group();

				// Determine the ending color by:
				// 1) use the color from value if it has one
				// 2) use the last color from stringBuffer + <content between last match and current match>
				// To do #2 we just search for the last col tag after calling appendReplacement
				String endColor = getLastColor(value);

				// Strip color tags from the highlighted region so that it remains highlighted correctly
				value = stripColor(value);

				matcher.appendReplacement(stringBuffer, "<col" + ChatColorType.HIGHLIGHT + '>' + value);

				if (endColor == null)
				{
					endColor = getLastColor(stringBuffer.toString());
				}

				// Append end color
				stringBuffer.append(endColor == null ? "<col" + ChatColorType.NORMAL + ">" : endColor);

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
			if (config.notifyOnHighlight())
			{
				sendNotification(chatMessage);
			}
		}

		if (update)
		{
			messageNode.setRuneLiteFormatMessage(messageNode.getValue());
			chatMessageManager.update(messageNode);
		}
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
