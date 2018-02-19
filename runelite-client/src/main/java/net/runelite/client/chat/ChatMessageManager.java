/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.chat;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.eventbus.Subscribe;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatLineBuffer;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.Varbits;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.RuneLiteConfig;

@Slf4j
@Singleton
public class ChatMessageManager
{
	private static final Pattern DATE_PATTERN = Pattern.compile("(\\[?)([0-9]+:[0-9]+)(])");
	private final Map<ChatMessageType, Set<ChatColor>> colorCache = new HashMap<>();
	private final Provider<Client> clientProvider;
	private final ScheduledExecutorService executor;
	private final RuneLiteConfig config;
	private int transparancyVarbit = -1;
	private final Queue<QueuedMessage> queuedMessages = new ConcurrentLinkedQueue<>();

	@Inject
	public ChatMessageManager(Provider<Client> clientProvider, ScheduledExecutorService executor, RuneLiteConfig config)
	{
		this.clientProvider = clientProvider;
		this.executor = executor;
		this.config = config;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int setting = clientProvider.get().getSetting(Varbits.TRANSPARANT_CHATBOX);

		if (transparancyVarbit != setting)
		{
			transparancyVarbit = setting;
			refreshAll();
		}
	}

	@Subscribe
	public void onResizableChanged(ResizeableChanged event)
	{
		refreshAll();
	}

	public ChatMessageManager cacheColor(final ChatColor chatColor, final ChatMessageType... types)
	{
		for (ChatMessageType chatMessageType : types)
		{
			colorCache.putIfAbsent(chatMessageType, new HashSet<>());
			final Set<ChatColor> chatColors = colorCache.get(chatMessageType);
			chatColors.remove(chatColor);
			chatColors.add(chatColor);
		}

		return this;
	}

	public void queue(QueuedMessage message)
	{
		queuedMessages.add(message);
	}

	public void process()
	{
		for (Iterator<QueuedMessage> it = queuedMessages.iterator(); it.hasNext();)
		{
			QueuedMessage message = it.next();
			final MessageNode target = message.getTarget();

			if (target != null)
			{
				if (!Strings.isNullOrEmpty(message.getValue()))
				{
					target.setValue(message.getValue());
				}

				if (!Strings.isNullOrEmpty(message.getName()))
				{
					target.setName(message.getName());
				}

				if (!Strings.isNullOrEmpty(message.getSender()))
				{
					target.setSender(message.getSender());
				}

				if (message.getRuneLiteTime() != null)
				{
					target.setRuneLiteTime(message.getRuneLiteTime().toEpochMilli());
				}

				target.setRuneLiteFormatMessage(message.getRuneLiteFormattedMessage());
				update(message.getTarget());
			}
			else
			{
				add(message);
			}

			it.remove();
		}

		clientProvider.get().refreshChat();
	}

	private void add(QueuedMessage message)
	{
		final Client client = clientProvider.get();

		// this updates chat cycle
		client.addChatMessage(message.getType(), MoreObjects.firstNonNull(message.getName(), ""),
			message.getValue(), message.getSender());

		// Get last message from line buffer (the one we just added)
		final ChatLineBuffer chatLineBuffer = client.getChatLineMap().get(message.getType().getType());
		final MessageNode[] lines = chatLineBuffer.getLines();
		final MessageNode line = lines[0];

		// Update the message with RuneLite additions
		if (message.getRuneLiteTime() != null)
		{
			line.setRuneLiteTime(message.getRuneLiteTime().toEpochMilli());
		}

		line.setRuneLiteFormatMessage(message.getRuneLiteFormattedMessage());
		update(line);
	}

	private void update(final MessageNode target)
	{
		final Client client = clientProvider.get();
		final boolean transparent = client.isResized() && client.getSetting(Varbits.TRANSPARANT_CHATBOX) != 0;
		final Set<ChatColor> chatColors = colorCache.get(target.getType());

		if (target.getRuneLiteTime() > 0)
		{
			final ZonedDateTime time = ZonedDateTime
				.ofInstant(Instant.ofEpochMilli(target.getRuneLiteTime()), ZoneId.systemDefault());

			final String dateFormat = time.get(ChronoField.HOUR_OF_DAY) + ":" +
				String.format("%02d", time.get(ChronoField.MINUTE_OF_HOUR));

			if (!Strings.isNullOrEmpty(target.getSender()))
			{
				final String sender = target.getSender();

				if (!DATE_PATTERN.matcher(sender).find())
				{
					final String originalColor = transparent ? "9090FF" : "0000FF";
					final String dateColor = transparent ? "FFFFFF" : "000000";
					final String newSender = "<col=" + dateColor + ">" +
						dateFormat + "] [<col=" + originalColor + ">" + sender;
					target.setSender(newSender);
				}
			}
		}

		if (Strings.isNullOrEmpty(target.getRuneLiteFormatMessage()))
		{
			return;
		}

		// If we do not have any colors cached or recoloring is disabled, simply set clean message
		if (!config.chatCommandsRecolorEnabled() || chatColors == null || chatColors.isEmpty())
		{
			target.setValue(target.getRuneLiteFormatMessage());
			return;
		}

		target.setValue(recolorMessage(transparent, target.getRuneLiteFormatMessage(), target.getType()));
	}

	private String recolorMessage(boolean transparent, String message, ChatMessageType messageType)
	{
		final Set<ChatColor> chatColors = colorCache.get(messageType);
		final AtomicReference<String> resultMessage = new AtomicReference<>(message);

		// Replace custom formatting with actual colors
		chatColors.stream()
			.filter(chatColor -> chatColor.isTransparent() == transparent)
			.forEach(chatColor ->
				resultMessage.getAndUpdate(oldMessage -> oldMessage.replaceAll(
					"<col" + chatColor.getType().name() + ">",
					"<col=" + Integer.toHexString(chatColor.getColor().getRGB() & 0xFFFFFF) + ">")));

		return resultMessage.get();
	}

	public void refreshAll()
	{
		final Client client = clientProvider.get();

		executor.submit(() ->
		{
			final Set<MessageNode> chatLines = client.getChatLineMap().values().stream()
				.filter(Objects::nonNull)
				.flatMap(clb -> Arrays.stream(clb.getLines()))
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());

			for (MessageNode line : chatLines)
			{
				update(line);
			}

			client.refreshChat();
		});
	}
}
