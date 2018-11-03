/*
 * Copyright (c) 2018, Magic fTail
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
package net.runelite.client.plugins.profanityfilter;

import com.google.common.base.Splitter;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.events.SetMessage;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.apache.commons.lang3.StringUtils;

@PluginDescriptor(
	name = "Profanity Filter",
	description = "Censor user configurable words from chat"
)
public class ProfanityFilterPlugin extends Plugin
{
	private static final Splitter COMMA_SPLITTER = Splitter
		.on(",")
		.omitEmptyStrings()
		.trimResults();

	private List<String> bannedWords = new ArrayList<>();

	@Inject
	private Client client;

	@Inject
	private ProfanityFilterConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Provides
	ProfanityFilterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ProfanityFilterConfig.class);
	}

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (setMessage.getType() == ChatMessageType.SERVER)
		{
			return;
		}

		String message = censorMessage(setMessage.getValue());
		MessageNode messageNode = setMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(message);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	@Subscribe
	public void onOverheadTextChanged(OverheadTextChanged event)
	{
		String message = censorMessage(event.getOverheadText());

		event.getActor().setOverheadText(message);
	}

	private String censorMessage(String message)
	{
		for (String bannedWord : bannedWords)
		{
			if (config.removeMessage() && message.toLowerCase().contains(bannedWord))
			{
				message = "Hey, everyone, I just tried to say something very silly!";
				break;
			}
			else
			{
				message = message.replaceAll("(?i)" + bannedWord, StringUtils.repeat("*", bannedWord.length()));
			}
		}

		return message;
	}

	private void updateBannedWords()
	{
		final String configBannedWords = config.bannedWords().toLowerCase();

		if (configBannedWords.isEmpty())
		{
			bannedWords = Collections.emptyList();
			return;
		}

		bannedWords = COMMA_SPLITTER.splitToList(configBannedWords);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateBannedWords();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!"profanityfilter".equals(event.getGroup()))
		{
			return;
		}

		updateBannedWords();
	}
}
