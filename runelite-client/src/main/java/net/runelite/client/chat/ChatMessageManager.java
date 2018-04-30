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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
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

@Slf4j
@Singleton
public class ChatMessageManager
{
	private final Map<ChatMessageType, Set<ChatColor>> colorCache = new HashMap<>();
	private final Provider<Client> clientProvider;
	private final ScheduledExecutorService executor;
	private int transparencyVarbit = -1;
	private final Queue<QueuedMessage> queuedMessages = new ConcurrentLinkedQueue<>();

	@Inject
	public ChatMessageManager(Provider<Client> clientProvider, ScheduledExecutorService executor)
	{
		this.clientProvider = clientProvider;
		this.executor = executor;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int setting = clientProvider.get().getVar(Varbits.TRANSPARENT_CHATBOX);

		if (transparencyVarbit != setting)
		{
			transparencyVarbit = setting;
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
		if (!queuedMessages.isEmpty())
		{
			queuedMessages.forEach(this::add);
			queuedMessages.clear();
		}
	}

	private void add(QueuedMessage message)
	{
		final Client client = clientProvider.get();

		// this updates chat cycle
		client.addChatMessage(
				message.getType(),
				MoreObjects.firstNonNull(message.getName(), ""),
				MoreObjects.firstNonNull(message.getValue(), message.getRuneLiteFormattedMessage()),
				message.getSender());

		// Get last message from line buffer (the one we just added)
		final ChatLineBuffer chatLineBuffer = client.getChatLineMap().get(message.getType().getType());
		final MessageNode[] lines = chatLineBuffer.getLines();
		final MessageNode line = lines[0];

		// Update the message with RuneLite additions
		line.setRuneLiteFormatMessage(message.getRuneLiteFormattedMessage());
		update(line);
	}

	public void update(final MessageNode target)
	{
		if (Strings.isNullOrEmpty(target.getRuneLiteFormatMessage()))
		{
			return;
		}

		final Client client = clientProvider.get();
		final boolean transparent = client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) != 0;
		final Set<ChatColor> chatColors = colorCache.get(target.getType());

		// If we do not have any colors cached, simply set clean message
		if (chatColors == null || chatColors.isEmpty())
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
			client.getChatLineMap().values().stream()
				.filter(Objects::nonNull)
				.flatMap(clb -> Arrays.stream(clb.getLines()))
				.filter(Objects::nonNull)
				.forEach(this::update);

			client.refreshChat();
		});
	}
}
