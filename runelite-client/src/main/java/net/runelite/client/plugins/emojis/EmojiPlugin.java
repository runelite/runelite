/*
 * Copyright (c) 2019, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.emojis;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import joptsimple.internal.Strings;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.IndexedSprite;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Emojis",
	description = "Replaces common emoticons such as :) with their corresponding emoji in the chat",
	enabledByDefault = false
)
@Slf4j
@Singleton
public class EmojiPlugin extends Plugin
{
	private static final Pattern TAG_REGEXP = Pattern.compile("<[^>]*>");
	private static final Pattern WHITESPACE_REGEXP = Pattern.compile("[\\s\\u00A0]");

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private EventBus eventBus;

	private int modIconsStart = -1;

	@Override
	protected void startUp()
	{
		loadEmojiIcons();
		addSubscriptions();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(OverheadTextChanged.class, this, this::onOverheadTextChanged);
	}

	void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			loadEmojiIcons();
		}
	}

	private void loadEmojiIcons()
	{
		final IndexedSprite[] modIcons = client.getModIcons();
		if (modIconsStart != -1 || modIcons == null)
		{
			return;
		}

		final Emoji[] emojis = Emoji.values();
		final IndexedSprite[] newModIcons = Arrays.copyOf(modIcons, modIcons.length + emojis.length);
		modIconsStart = modIcons.length;

		for (int i = 0; i < emojis.length; i++)
		{
			final Emoji emoji = emojis[i];

			try
			{
				final BufferedImage image = emoji.loadImage();
				final IndexedSprite sprite = ImageUtil.getImageIndexedSprite(image, client);
				newModIcons[modIconsStart + i] = sprite;
			}
			catch (Exception ex)
			{
				log.warn("Failed to load the sprite for emoji " + emoji, ex);
			}
		}

		log.debug("Adding emoji icons");
		client.setModIcons(newModIcons);
	}

	void onChatMessage(ChatMessage chatMessage)
	{
		if (client.getGameState() != GameState.LOGGED_IN || modIconsStart == -1)
		{
			return;
		}

		switch (chatMessage.getType())
		{
			case PUBLICCHAT:
			case MODCHAT:
			case FRIENDSCHAT:
			case PRIVATECHAT:
			case PRIVATECHATOUT:
			case MODPRIVATECHAT:
				break;
			default:
				return;
		}

		final MessageNode messageNode = chatMessage.getMessageNode();
		final String message = messageNode.getValue();
		final String updatedMessage = updateMessage(message);

		if (updatedMessage == null)
		{
			return;
		}

		messageNode.setRuneLiteFormatMessage(updatedMessage);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private void onOverheadTextChanged(final OverheadTextChanged event)
	{
		if (!(event.getActor() instanceof Player))
		{
			return;
		}

		final String message = event.getOverheadText();
		final String updatedMessage = updateMessage(message);

		if (updatedMessage == null)
		{
			return;
		}

		event.getActor().setOverheadText(updatedMessage);
	}

	@Nullable
	String updateMessage(final String message)
	{
		final String[] messageWords = WHITESPACE_REGEXP.split(message);

		boolean editedMessage = false;
		for (int i = 0; i < messageWords.length; i++)
		{
			// Remove tags except for <lt> and <gt>
			final String trigger = removeTags(messageWords[i]);
			final Emoji emoji = Emoji.getEmoji(trigger);

			if (emoji == null)
			{
				continue;
			}

			final int emojiId = modIconsStart + emoji.ordinal();

			messageWords[i] = messageWords[i].replace(trigger, "<img=" + emojiId + ">");
			editedMessage = true;
		}

		// If we haven't edited the message any, don't update it.
		if (!editedMessage)
		{
			return null;
		}

		return Strings.join(messageWords, " ");
	}

	/**
	 * Remove tags, except for &lt;lt&gt; and &lt;gt&gt;
	 *
	 * @return
	 */
	private static String removeTags(String str)
	{
		StringBuffer stringBuffer = new StringBuffer();
		Matcher matcher = TAG_REGEXP.matcher(str);
		while (matcher.find())
		{
			matcher.appendReplacement(stringBuffer, "");
			String match = matcher.group(0);
			switch (match)
			{
				case "<lt>":
				case "<gt>":
					stringBuffer.append(match);
					break;
			}
		}
		matcher.appendTail(stringBuffer);
		return stringBuffer.toString();
	}
}
