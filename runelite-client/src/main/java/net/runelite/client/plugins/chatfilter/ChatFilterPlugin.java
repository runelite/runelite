/*
 * Copyright (c) 2018, Magic fTail
 * Copyright (c) 2019, osrs-music-map <osrs-music-map@users.noreply.github.com>
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
package net.runelite.client.plugins.chatfilter;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.inject.Provides;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.events.ConfigChanged;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ClanManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.StringUtils;

@PluginDescriptor(
	name = "Chat Filter",
	description = "Censor user configurable words or patterns from chat",
	enabledByDefault = false
)
@Slf4j
public class ChatFilterPlugin extends Plugin
{
	private static final String COUNT_FORMAT = " (%d)";
	private static final Splitter NEWLINE_SPLITTER = Splitter
		.on("\n")
		.omitEmptyStrings()
		.trimResults();

	@VisibleForTesting
	static final String CENSOR_MESSAGE = "Hey, everyone, I just tried to say something very silly!";

	private final CharMatcher jagexPrintableCharMatcher = Text.JAGEX_PRINTABLE_CHAR_MATCHER;
	private final List<Pattern> filteredPatterns = new ArrayList<>();
	private final List<Pattern> filteredNamePatterns = new ArrayList<>();
	private Multiset<String> chatCounts = HashMultiset.create();
	private Map<String, Integer> chatIndex = new HashMap<>();

	@Inject
	private Client client;

	@Inject
	private ChatFilterConfig config;

	@Inject
	private ClanManager clanManager;

	@Provides
	ChatFilterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatFilterConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateFilteredPatterns();
		client.refreshChat();
	}

	@Override
	protected void shutDown() throws Exception
	{
		filteredPatterns.clear();
		chatCounts.clear();
		chatIndex.clear();
		client.refreshChat();
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (!"chatFilterCheck".equals(event.getEventName()))
		{
			return;
		}

		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();
		int messageType = intStack[intStackSize - 2];
		int messageId = intStack[intStackSize - 1];
		ChatMessageType chatMessageType = ChatMessageType.of(messageType);
		MessageNode messageNode = client.getMessages().get(messageId);
		String name = messageNode.getName();
		String[] stringStack = client.getStringStack();
		int stringStackSize = client.getStringStackSize();
		String message = stringStack[stringStackSize - 1];
		String fullMessage = messageNode.getName() + message;

		boolean shouldBlockMessage = false;

		if (shouldCollapseMessageType(chatMessageType))
		{
			shouldBlockMessage = chatIndex.containsKey(fullMessage) &&
					chatIndex.get(fullMessage) != messageId ||
					shouldBlockDuplicatePlayerChat(fullMessage, chatMessageType);
		}

		String censoredMessage = null;

		// Only filter public chat and private messages
		if (shouldFilterMessageType(chatMessageType) && shouldFilterPlayerMessage(name))
		{
			censoredMessage = censorMessage(name, message);
			shouldBlockMessage |= censoredMessage == null;
		}
		else if(chatMessageType == ChatMessageType.LOGINLOGOUTNOTIFICATION && config.filterLogin())
		{
			shouldBlockMessage = true;
		}

		if (shouldBlockMessage)
		{
			// Block the message
			intStack[intStackSize - 3] = 0;
		}
		else
		{
			// Replace the message
			stringStack[stringStackSize - 1] = addCountToGameMessage(censoredMessage, chatCounts.count(fullMessage));
		}
	}

	@Subscribe
	public void onOverheadTextChanged(OverheadTextChanged event)
	{
		if (!(event.getActor() instanceof Player) || !shouldFilterPlayerMessage(event.getActor().getName()))
		{
			return;
		}

		String message = censorMessage(event.getActor().getName(), event.getOverheadText());

		if (message == null)
		{
			message = " ";
		}

		event.getActor().setOverheadText(message);
	}

	boolean shouldFilterPlayerMessage(String playerName)
	{
		boolean isMessageFromSelf = playerName.equals(client.getLocalPlayer().getName());
		return !isMessageFromSelf &&
			(config.filterFriends() || !client.isFriended(playerName, false)) &&
			(config.filterClan() || !clanManager.isClanMember(playerName));
	}

	String censorMessage(final String username, final String message)
	{
		String strippedMessage = jagexPrintableCharMatcher.retainFrom(message)
			.replace('\u00A0', ' ');
		if (shouldFilterByName(username))
		{
			switch (config.filterType())
			{
				case CENSOR_WORDS:
					return StringUtils.repeat('*', strippedMessage.length());
				case CENSOR_MESSAGE:
					return CENSOR_MESSAGE;
				case REMOVE_MESSAGE:
					return null;
			}
		}

		boolean filtered = false;
		for (Pattern pattern : filteredPatterns)
		{
			Matcher m = pattern.matcher(strippedMessage);

			StringBuffer sb = new StringBuffer();

			while (m.find())
			{
				switch (config.filterType())
				{
					case CENSOR_WORDS:
						m.appendReplacement(sb, StringUtils.repeat('*', m.group(0).length()));
						filtered = true;
						break;
					case CENSOR_MESSAGE:
						return CENSOR_MESSAGE;
					case REMOVE_MESSAGE:
						return null;
				}
			}
			m.appendTail(sb);

			strippedMessage = sb.toString();
		}

		return filtered ? strippedMessage : message;
	}

	void updateFilteredPatterns()
	{
		filteredPatterns.clear();
		filteredNamePatterns.clear();

		Text.fromCSV(config.filteredWords()).stream()
			.map(s -> Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE))
			.forEach(filteredPatterns::add);

		NEWLINE_SPLITTER.splitToList(config.filteredRegex()).stream()
			.map(ChatFilterPlugin::compilePattern)
			.filter(Objects::nonNull)
			.forEach(filteredPatterns::add);

		NEWLINE_SPLITTER.splitToList(config.filteredNames()).stream()
			.map(ChatFilterPlugin::compilePattern)
			.filter(Objects::nonNull)
			.forEach(filteredNamePatterns::add);
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
	public void onConfigChanged(ConfigChanged event)
	{
		if (!"chatfilter".equals(event.getGroup()))
		{
			return;
		}

		updateFilteredPatterns();

		//Refresh chat after config change to reflect current rules
		client.refreshChat();
	}

	@VisibleForTesting
	boolean shouldFilterByName(final String playerName)
	{
		String sanitizedName = Text.standardize(playerName);
		for (Pattern pattern : filteredNamePatterns)
		{
			Matcher m = pattern.matcher(sanitizedName);
			if (m.find())
			{
				return true;
			}
		}
		return false;
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatCounts.elementSet().size() > config.maxTrackedChats())
		{
			cleanupChatTrackers();
		}
		if (shouldCollapseMessageType(chatMessage.getType()))
		{
			chatCounts.add(chatMessage.getName() + chatMessage.getMessage());
		}
		refreshChatIndex();
	}

	private void cleanupChatTrackers()
	{
		log.info("Cleaning up chat counts. Current size: {}", chatCounts.elementSet().size());
		chatCounts.removeIf(message -> chatCounts.count(message) <= 1);
		log.info("After clearing messages with count == 1: {}", chatCounts.elementSet().size());
		if (chatCounts.elementSet().size() > config.maxTrackedChats())
		{
			chatCounts.clear();
		}
		chatIndex.clear();
	}

	private void refreshChatIndex()
	{
		client.getMessages().forEach(messageNode ->
		{
			String fullMessage = messageNode.getName() + messageNode.getValue();
			Integer currentSetIndex = chatIndex.get(fullMessage);
			if (currentSetIndex == null ||
					currentSetIndex < messageNode.getId())
			{
				chatIndex.put(fullMessage, messageNode.getId());
			}
		});
	}

	private boolean shouldFilterMessageType(ChatMessageType chatMessageType) {
		switch (chatMessageType) {
			case PUBLICCHAT:
			case MODCHAT:
			case AUTOTYPER:
			case PRIVATECHAT:
			case MODPRIVATECHAT:
			case FRIENDSCHAT:
			case LOGINLOGOUTNOTIFICATION:
				return true;
			default:
				return false;
		}
	}

	private boolean shouldCollapseMessageType(ChatMessageType chatMessageType)
	{
		switch (chatMessageType)
		{
			case ENGINE:
			case GAMEMESSAGE:
			case NPC_EXAMINE:
			case OBJECT_EXAMINE:
			case SPAM:
				return true;
			case PUBLICCHAT:
				return config.consolidatePlayerChat();
			default:
				return false;
		}
	}

	private boolean shouldBlockDuplicatePlayerChat(String fullMessage, ChatMessageType chatMessageType)
	{
		return chatMessageType == ChatMessageType.PUBLICCHAT &&
				config.maxRepeatedPublicChats() > 1 &&
				chatCounts.count(fullMessage) > config.maxRepeatedPublicChats();
	}

	private String addCountToGameMessage(String gameMessage, int count)
	{
		if (count > 1)
		{
			return gameMessage +
					ColorUtil.wrapWithColorTag(String.format(COUNT_FORMAT, count), config.chatCountColor());
		}
		else
		{
			return gameMessage;
		}
	}
}
