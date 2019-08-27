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

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.util.Text;
import org.apache.commons.lang3.StringUtils;

@PluginDescriptor(
	name = "Chat Filter",
	description = "Censor user configurable words or patterns from chat",
	enabledByDefault = false
)
@Singleton
public class ChatFilterPlugin extends Plugin
{
	private static final Splitter NEWLINE_SPLITTER = Splitter
		.on("\n")
		.omitEmptyStrings()
		.trimResults();

	private static final String CENSOR_MESSAGE = "Hey, everyone, I just tried to say something very silly!";

	private final CharMatcher jagexPrintableCharMatcher = Text.JAGEX_PRINTABLE_CHAR_MATCHER;
	private final List<Pattern> filteredPatterns = new ArrayList<>();

	@Inject
	private Client client;

	@Inject
	private ChatFilterConfig config;

	@Inject
	private EventBus eventBus;

	@Setter(AccessLevel.PACKAGE)
	private ChatFilterType filterType;
	@Setter(AccessLevel.PACKAGE)
	private String filteredWords;
	@Setter(AccessLevel.PACKAGE)
	private String filteredRegex;
	@Setter(AccessLevel.PACKAGE)
	private boolean filterFriends;
	@Setter(AccessLevel.PACKAGE)
	private boolean filterClan;

	@Provides
	ChatFilterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatFilterConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		updateFilteredPatterns();
		client.refreshChat();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		filteredPatterns.clear();
		client.refreshChat();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
		eventBus.subscribe(OverheadTextChanged.class, this, this::onOverheadTextChanged);
	}

	private void onScriptCallbackEvent(ScriptCallbackEvent event)
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

		// Only filter public chat and private messages
		switch (chatMessageType)
		{
			case PUBLICCHAT:
			case MODCHAT:
			case AUTOTYPER:
			case PRIVATECHAT:
			case MODPRIVATECHAT:
			case FRIENDSCHAT:
			case GAMEMESSAGE:
				break;
			case LOGINLOGOUTNOTIFICATION:
				if (config.filterLogin())
				{
					// Block the message
					intStack[intStackSize - 3] = 0;
				}
				return;
			default:
				return;
		}

		MessageNode messageNode = (MessageNode) client.getMessages().get(messageId);

		if (client.getLocalPlayer().getName().equals(messageNode.getName()) ||
			!this.filterFriends && messageNode.isFromFriend() ||
			!this.filterClan && messageNode.isFromClanMate())
		{
			return;
		}

		String[] stringStack = client.getStringStack();
		int stringStackSize = client.getStringStackSize();

		String message = stringStack[stringStackSize - 1];
		String censoredMessage = censorMessage(message);

		if (censoredMessage == null)
		{
			// Block the message
			intStack[intStackSize - 3] = 0;
		}
		else
		{
			// Replace the message
			stringStack[stringStackSize - 1] = censoredMessage;
		}
	}

	private void onOverheadTextChanged(OverheadTextChanged event)
	{
		if (!(event.getActor() instanceof Player) || event.getActor().getName() == null || !shouldFilterPlayerMessage(event.getActor().getName()))
		{
			return;
		}

		String message = censorMessage(event.getOverheadText());

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
			(this.filterFriends || !client.isFriended(playerName, false)) &&
			(this.filterClan || !client.isClanMember(playerName));
	}

	String censorMessage(final String message)
	{
		String strippedMessage = jagexPrintableCharMatcher.retainFrom(message)
			.replace('\u00A0', ' ');
		boolean filtered = false;
		for (Pattern pattern : filteredPatterns)
		{
			Matcher m = pattern.matcher(strippedMessage);

			StringBuffer sb = new StringBuffer();

			while (m.find())
			{
				switch (this.filterType)
				{
					case CENSOR_WORDS:
						m.appendReplacement(sb, StringUtils.repeat("*", m.group(0).length()));
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

		Text.fromCSV(this.filteredWords).stream()
			.map(s -> Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE))
			.forEach(filteredPatterns::add);

		NEWLINE_SPLITTER.splitToList(this.filteredRegex).stream()
			.map(s ->
			{
				try
				{
					return Pattern.compile(s, Pattern.CASE_INSENSITIVE);
				}
				catch (PatternSyntaxException ex)
				{
					return null;
				}
			})
			.filter(Objects::nonNull)
			.forEach(filteredPatterns::add);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!"chatfilter".equals(event.getGroup()))
		{
			return;
		}

		updateConfig();
		updateFilteredPatterns();

		//Refresh chat after config change to reflect current rules
		client.refreshChat();
	}

	private void updateConfig()
	{
		this.filterType = config.filterType();
		this.filteredWords = config.filteredWords();
		this.filteredRegex = config.filteredRegex();
		this.filterFriends = config.filterFriends();
		this.filterClan = config.filterClan();
	}
}
