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

import com.google.common.eventbus.Subscribe;
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

	public void queue(ChatMessageType type, String message)
	{
		queuedMessages.add(new QueuedMessage(type, message));
	}

	public void process()
	{
		for (Iterator<QueuedMessage> it = queuedMessages.iterator(); it.hasNext();)
		{
			QueuedMessage message = it.next();
			add(message.getType(), message.getMessage());
			it.remove();
		}
	}

	public void add(final ChatMessageType type, final String mesage)
	{
		final Client client = clientProvider.get();
		client.sendGameMessage(type, mesage); // this updates chat cycle
		final ChatLineBuffer chatLineBuffer = client.getChatLineMap().get(type.getType());
		final MessageNode[] lines = chatLineBuffer.getLines();
		final MessageNode line = lines[0];
		update(line.getType(), mesage, line);
	}

	public void update(final ChatMessageType type, final String message, final MessageNode target)
	{
		final Client client = clientProvider.get();
		final Set<ChatColor> chatColors = colorCache.get(type);

		// If we do not have any colors cached or recoloring is disabled, simply set message
		if (!config.chatCommandsRecolorEnabled() || chatColors == null || chatColors.isEmpty())
		{
			target.setRuneLiteFormatMessage(message);
			target.setValue(message);
			return;
		}

		final AtomicReference<String> resultMessage = new AtomicReference<>(message);

		// Replace custom formatting with actual colors
		chatColors.stream()
			.filter(chatColor -> chatColor.isTransparent() ==
				(client.isResized() && client.getSetting(Varbits.TRANSPARANT_CHATBOX) != 0))
			.forEach(chatColor ->
				resultMessage.getAndUpdate(oldMessage -> oldMessage.replaceAll(
					"<col" + chatColor.getType().name() + ">",
					"<col=" + Integer.toHexString(chatColor.getColor().getRGB() & 0xFFFFFF) + ">")));

		target.setRuneLiteFormatMessage(message);
		target.setValue(resultMessage.get());
	}

	public void refreshAll()
	{
		if (!config.chatCommandsRecolorEnabled())
		{
			return;
		}

		final Client client = clientProvider.get();

		executor.submit(() ->
		{
			final Set<MessageNode> chatLines = client.getChatLineMap().values().stream()
				.filter(Objects::nonNull)
				.flatMap(clb -> Arrays.stream(clb.getLines()))
				.filter(Objects::nonNull)
				.filter(mn -> mn.getRuneLiteFormatMessage() != null)
				.collect(Collectors.toSet());

			chatLines.forEach(chatLine -> update(chatLine.getType(), chatLine.getRuneLiteFormatMessage(), chatLine));

			if (!chatLines.isEmpty())
			{
				client.refreshChat();
			}
		});
	}
}
