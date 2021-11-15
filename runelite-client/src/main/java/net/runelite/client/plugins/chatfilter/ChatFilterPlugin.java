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
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import static net.runelite.api.ChatMessageType.ENGINE;
import static net.runelite.api.ChatMessageType.GAMEMESSAGE;
import static net.runelite.api.ChatMessageType.ITEM_EXAMINE;
import static net.runelite.api.ChatMessageType.MODCHAT;
import static net.runelite.api.ChatMessageType.NPC_EXAMINE;
import static net.runelite.api.ChatMessageType.OBJECT_EXAMINE;
import static net.runelite.api.ChatMessageType.PUBLICCHAT;
import static net.runelite.api.ChatMessageType.SPAM;
import net.runelite.api.Client;
import net.runelite.api.FriendsChatManager;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.clan.ClanChannel;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.StringUtils;

@PluginDescriptor(
	name = "Chat Filter",
	description = "Censor user configurable words or patterns from chat",
	enabledByDefault = false
)
public class ChatFilterPlugin extends Plugin
{
	private static final Splitter NEWLINE_SPLITTER = Splitter
		.on("\n")
		.omitEmptyStrings()
		.trimResults();

	@VisibleForTesting
	static final String CENSOR_MESSAGE = "Hey, everyone, I just tried to say something very silly!";

	private static final Set<ChatMessageType> COLLAPSIBLE_MESSAGETYPES = ImmutableSet.of(
		ENGINE,
		GAMEMESSAGE,
		ITEM_EXAMINE,
		NPC_EXAMINE,
		OBJECT_EXAMINE,
		SPAM,
		PUBLICCHAT,
		MODCHAT
	);

	private final CharMatcher jagexPrintableCharMatcher = Text.JAGEX_PRINTABLE_CHAR_MATCHER;
	private final List<Pattern> filteredPatterns = new ArrayList<>();
	private final List<Pattern> filteredNamePatterns = new ArrayList<>();

	private static class Duplicate
	{
		int messageId;
		int count;
	}

	private final LinkedHashMap<String, Duplicate> duplicateChatCache = new LinkedHashMap<String, Duplicate>()
	{
		private static final int MAX_ENTRIES = 100;

		@Override
		protected boolean removeEldestEntry(Map.Entry<String, Duplicate> eldest)
		{
			return size() > MAX_ENTRIES;
		}
	};

	@Inject
	private Client client;

	@Inject
	private ChatFilterConfig config;

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
		duplicateChatCache.clear();
		client.refreshChat();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		switch (gameStateChanged.getGameState())
		{
			// Login drops references to all messages and also resets the global message id counter.
			// Invalidate the message id so it doesn't collide later when rebuilding the chatfilter.
			case HOPPING:
			case LOGGING_IN:
				duplicateChatCache.values().forEach(d -> d.messageId = -1);
		}
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
		String[] stringStack = client.getStringStack();
		int stringStackSize = client.getStringStackSize();

		final int messageType = intStack[intStackSize - 2];
		final int messageId = intStack[intStackSize - 1];
		String message = stringStack[stringStackSize - 1];

		ChatMessageType chatMessageType = ChatMessageType.of(messageType);
		final MessageNode messageNode = client.getMessages().get(messageId);
		final String name = messageNode.getName();
		int duplicateCount = 0;
		boolean blockMessage = false;

		// Only filter public chat and private messages
		switch (chatMessageType)
		{
			case PUBLICCHAT:
			case MODCHAT:
			case AUTOTYPER:
			case PRIVATECHAT:
			case MODPRIVATECHAT:
			case FRIENDSCHAT:
			case CLAN_CHAT:
			case CLAN_GUEST_CHAT:
				if (shouldFilterPlayerMessage(Text.removeTags(name)))
				{
					message = censorMessage(name, message);
					blockMessage = message == null;
				}
				break;
			case GAMEMESSAGE:
			case ENGINE:
			case ITEM_EXAMINE:
			case NPC_EXAMINE:
			case OBJECT_EXAMINE:
			case SPAM:
				if (config.filterGameChat())
				{
					message = censorMessage(null, message);
					blockMessage = message == null;
				}
				break;
		}

		boolean shouldCollapse = chatMessageType == PUBLICCHAT || chatMessageType == MODCHAT
			? config.collapsePlayerChat()
			: COLLAPSIBLE_MESSAGETYPES.contains(chatMessageType) && config.collapseGameChat();
		if (!blockMessage && shouldCollapse)
		{
			Duplicate duplicateCacheEntry = duplicateChatCache.get(name + ":" + message);
			// If messageId is -1 then this is a replayed message, which we can't easily collapse since we don't know
			// the most recent message. This is only for public chat since it is the only thing both replayed and also
			// collapsed. Just allow uncollapsed playback.
			if (duplicateCacheEntry != null && duplicateCacheEntry.messageId != -1)
			{
				blockMessage = duplicateCacheEntry.messageId != messageId ||
					((chatMessageType == PUBLICCHAT || chatMessageType == MODCHAT) &&
						config.maxRepeatedPublicChats() > 0 && duplicateCacheEntry.count > config.maxRepeatedPublicChats());
				duplicateCount = duplicateCacheEntry.count;
			}
		}

		if (blockMessage)
		{
			// Block the message
			intStack[intStackSize - 3] = 0;
		}
		else
		{
			// Replace the message
			if (duplicateCount > 1)
			{
				message += " (" + duplicateCount + ")";
			}

			stringStack[stringStackSize - 1] = message;
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

	@Subscribe(priority = -2) // run after ChatMessageManager
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (COLLAPSIBLE_MESSAGETYPES.contains(chatMessage.getType()))
		{
			final MessageNode messageNode = chatMessage.getMessageNode();
			// remove and re-insert into map to move to end of list
			final String key = messageNode.getName() + ":" + messageNode.getValue();
			Duplicate duplicate = duplicateChatCache.remove(key);
			if (duplicate == null)
			{
				duplicate = new Duplicate();
			}

			duplicate.count++;
			duplicate.messageId = messageNode.getId();
			duplicateChatCache.put(key, duplicate);
		}
	}

	boolean shouldFilterPlayerMessage(String playerName)
	{
		boolean isMessageFromSelf = playerName.equals(client.getLocalPlayer().getName());
		return !isMessageFromSelf &&
			(config.filterFriends() || !client.isFriended(playerName, false)) &&
			(config.filterFriendsChat() || !isFriendsChatMember(playerName)) &&
			(config.filterClanChat() || !isClanChatMember(playerName));
	}

	private boolean isFriendsChatMember(String name)
	{
		FriendsChatManager friendsChatManager = client.getFriendsChatManager();
		return friendsChatManager != null && friendsChatManager.findByName(name) != null;
	}

	private boolean isClanChatMember(String name)
	{
		ClanChannel clanChannel = client.getClanChannel();
		if (clanChannel != null && clanChannel.findMember(name) != null)
		{
			return true;
		}

		clanChannel = client.getGuestClanChannel();
		if (clanChannel != null && clanChannel.findMember(name) != null)
		{
			return true;
		}

		return false;
	}

	String censorMessage(final String username, final String message)
	{
		String strippedMessage = jagexPrintableCharMatcher.retainFrom(message)
			.replace('\u00A0', ' ');
		String strippedAccents = StringUtils.stripAccents(strippedMessage);
		assert strippedMessage.length() == strippedAccents.length();

		if (username != null && shouldFilterByName(username))
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
			Matcher m = pattern.matcher(strippedAccents);

			StringBuilder sb = new StringBuilder();
			int idx = 0;

			while (m.find())
			{
				switch (config.filterType())
				{
					case CENSOR_WORDS:
						MatchResult matchResult = m.toMatchResult();
						sb.append(strippedMessage, idx, matchResult.start())
							.append(StringUtils.repeat('*', matchResult.group().length()));
						idx = m.end();
						filtered = true;
						break;
					case CENSOR_MESSAGE:
						return CENSOR_MESSAGE;
					case REMOVE_MESSAGE:
						return null;
				}
			}
			sb.append(strippedMessage.substring(idx));

			strippedMessage = sb.toString();
			assert strippedMessage.length() == strippedAccents.length();
		}

		return filtered ? strippedMessage : message;
	}

	void updateFilteredPatterns()
	{
		filteredPatterns.clear();
		filteredNamePatterns.clear();

		Text.fromCSV(config.filteredWords()).stream()
			.map(StringUtils::stripAccents)
			.map(s -> Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE))
			.forEach(filteredPatterns::add);

		NEWLINE_SPLITTER.splitToList(config.filteredRegex()).stream()
			.map(StringUtils::stripAccents)
			.map(ChatFilterPlugin::compilePattern)
			.filter(Objects::nonNull)
			.forEach(filteredPatterns::add);

		NEWLINE_SPLITTER.splitToList(config.filteredNames()).stream()
			.map(StringUtils::stripAccents)
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
}
