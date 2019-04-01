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
package net.runelite.client.plugins.chattranslate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.common.collect.EvictingQueue;
import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@PluginDescriptor(
		name = "Chat Translation",
		description = "Automatic translation of messages",
		tags = {"translate", "messages", "notifications", "private", "chat"},
		enabledByDefault = false
)
@Slf4j
public class ChatTranslatePlugin extends Plugin
{
	private static final Pattern fromUserMatcherDotAll = Pattern.compile(".", Pattern.DOTALL);
	private final ExecutorService executorService = Executors.newScheduledThreadPool(100);
	private Queue<QueuedMessage> messageQueue;
	private static Pattern fromUserMatcher = null;
	private String jsonPath = "";

	@Inject
	private Client client;

	@Inject
	private ChatTranslateConfig config;

	@Provides
	ChatTranslateConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatTranslateConfig.class);
	}

	@Override
	public void startUp()
	{
		updateTranslateFromUsers();
		messageQueue = EvictingQueue.create(100);
	}

	@Override
	public void shutDown()
	{
		messageQueue.clear();
		messageQueue = null;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
			case HOPPING:
				break;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("chattranslate"))
		{
			updateTranslateFromUsers();
		}
	}

	@Subscribe
	public void onSetMessage(ChatMessage message)
	{
		executorService.submit(() ->
		{
			switch (message.getType())
			{
				case MODPRIVATECHAT:
				case PRIVATECHAT:
					if (config.translatePrivateMessages())
					{
						translatePrivateMessage(message);
					}
					break;
				case PRIVATECHATOUT:
					break;
				case GAMEMESSAGE:
				case ENGINE:
					if (config.translateGameMessages())
					{
						messageHandler(message);
					}
					break;
				case MODCHAT:
				case PUBLICCHAT:
					if (config.translatePublicMessages())
					{
						messageHandler(message);
					}
					break;
				case FRIENDSCHATNOTIFICATION:
				case FRIENDSCHAT:
					if (config.translateClanMessages())
					{
						messageHandler(message);
					}
					break;
				case ITEM_EXAMINE:
				case OBJECT_EXAMINE:
				case NPC_EXAMINE:
					if (config.translateExamineMessages())
					{
						messageHandler(message);
					}
				default:
			}

		});
	}


	// TODO: Rewrite messageHandler to do this function
	private void translatePrivateMessage(ChatMessage message)
	{
		MessageNode messageNode = message.getMessageNode();
		if (fromUserMatcher != null)
		{
			String msg = "";
			String sentFromUser = messageNode.getName();
			String messageValue = messageNode.getValue();
			log.debug(sentFromUser + ": " + messageValue);
			Matcher matcher = fromUserMatcher.matcher(sentFromUser);
			boolean foundMatch = false;
			if (matcher.find() && !(client.getLocalPlayer().getName().equalsIgnoreCase(messageNode.getName())))
			{
				// outgoing value to translate
				msg = doTranslation(messageValue);
				//update = true;
				foundMatch = true;
			}
			log.debug(foundMatch + " in private message from specified user");
			if (foundMatch)
			{
				messageNode.setValue(msg);
			}
		}
		messageQueueManager(message);
	}

	/**
	 * Sets up the regex matching for private message username whitelisting
	 */
	private void updateTranslateFromUsers()
	{
		fromUserMatcher = null;
		if (config.translateFromUsers().trim().equals("*") && config.translatePrivateMessages())
		{
			fromUserMatcher = fromUserMatcherDotAll;
		}
		else if (!config.translateFromUsers().trim().equals("") && config.translatePrivateMessages())
		{
			//ClanMember[] clanMembers = client.getClanMembers();
			String[] names = config.translateFromUsers().trim().split(", ");
			String joined = Arrays.stream(names)
					.map(Pattern::quote)
					.collect(Collectors.joining("|"));
			fromUserMatcher = Pattern.compile("\\b(" + joined + ")\\b", Pattern.CASE_INSENSITIVE);
		}
		this.jsonPath = config.translateJSONFile();
	}

	/**
	 * Takes message from most given scenarios and passes to translate then queueManager
	 * added to remove redundant code
	 *
	 * @param message
	 */
	private void messageHandler(ChatMessage message)
	{
		MessageNode messageNode = message.getMessageNode();
		String msg = "";
		String sentFromUser = messageNode.getName();
		String messageValue = messageNode.getValue();
		log.debug(sentFromUser + ": " + messageValue);
		boolean foundMatch = false;

		if (!(client.getLocalPlayer().getName().equalsIgnoreCase(messageNode.getName())))
		{
			// outgoing value to translate
			msg = doTranslation(messageValue);
			//update = true;
			foundMatch = true;
		}
		if (foundMatch)
		{
			messageNode.setValue(msg);
		}

		messageQueueManager(message);
	}

	/**
	 * Completing the translation of a given message
	 *
	 * @param valueToTranslate
	 * @return translated message
	 */
	private String doTranslation(String valueToTranslate)
	{
		//Translate translate = TranslateOptions.getDefaultInstance().getService();
		GoogleCredentials credentials;
		try
		{
			credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath)).createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
			Translate translate = TranslateOptions.newBuilder().setCredentials(credentials).build().getService();

			// doing the actual translation
			Translation translation =
					translate.translate(
							valueToTranslate,
							TranslateOption.sourceLanguage(config.translateFromLang().toString()),
							TranslateOption.targetLanguage(config.translateToLang().toString()));
			return translation.getTranslatedText();
		}
		catch (IOException e)
		{
			log.error(e.getMessage());
			return valueToTranslate;
		}

	}

	/**
	 * Updating the final translated value to chat.
	 *
	 * @param message
	 */
	private void messageQueueManager(ChatMessage message)
	{
		final QueuedMessage queuedMessage = QueuedMessage.builder()
				.type(message.getType())
				.name(message.getName())
				.sender(message.getSender())
				.value(nbsp(message.getMessage()))
				.runeLiteFormattedMessage(nbsp(message.getMessageNode().getRuneLiteFormatMessage()))
				.build();

		if (!messageQueue.contains(queuedMessage))
		{
			messageQueue.offer(queuedMessage);
		}
	}

	/**
	 * Small hack to prevent plugins checking for specific messages to match
	 *
	 * @param message message
	 * @return message with nbsp
	 */
	private static String nbsp(final String message)
	{
		if (message != null)
		{
			return message.replace(' ', '\u00A0');
		}

		return null;
	}
}
