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
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.Subscribe;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Queue;
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
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.events.SetMessage;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ChatColorConfig;

@Slf4j
@Singleton
public class ChatMessageManager
{
	private final Multimap<ChatMessageType, ChatColor> colorCache = HashMultimap.create();
	private final Provider<Client> clientProvider;
	private final ScheduledExecutorService executor;
	private final ChatColorConfig chatColorConfig;
	private int transparencyVarbit = -1;
	private final Queue<QueuedMessage> queuedMessages = new ConcurrentLinkedQueue<>();

	@Inject
	private ChatMessageManager(Provider<Client> clientProvider, ScheduledExecutorService executor,
		ChatColorConfig chatColorConfig)
	{
		this.clientProvider = clientProvider;
		this.executor = executor;
		this.chatColorConfig = chatColorConfig;
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

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("textrecolor"))
		{
			loadColors();
			refreshAll();
		}
	}

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		final Client client = clientProvider.get();
		MessageNode messageNode = setMessage.getMessageNode();
		ChatMessageType chatMessageType = setMessage.getType();

		boolean isChatboxTransparent = client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1;
		Color usernameColor = null;
		Color senderColor = null;

		switch (chatMessageType)
		{
			case PRIVATE_MESSAGE_RECEIVED_MOD:
			case PRIVATE_MESSAGE_RECEIVED:
			case PRIVATE_MESSAGE_SENT:
				usernameColor = isChatboxTransparent ? chatColorConfig.transparentPrivateUsernames() : chatColorConfig.opaquePrivateUsernames();
				break;

			case TRADE:
			case AUTOCHAT:
			case PUBLIC:
				usernameColor = isChatboxTransparent ? chatColorConfig.transparentUsername() : chatColorConfig.opaqueUsername();
				break;

			case CLANCHAT:
				usernameColor = isChatboxTransparent ? chatColorConfig.transparentClanUsernames() : chatColorConfig.opaqueClanUsernames();
				break;
		}

		senderColor = isChatboxTransparent ? chatColorConfig.transparentClanChannelName() : chatColorConfig.opaqueClanChannelName();

		if (usernameColor != null)
		{
			messageNode.setName(wrapTextWithColour(messageNode.getName(), usernameColor));
		}

		String sender = setMessage.getSender();
		if (senderColor != null && !Strings.isNullOrEmpty(sender))
		{
			messageNode.setSender(wrapTextWithColour(sender, senderColor));
		}

		final Collection<ChatColor> chatColors = colorCache.get(chatMessageType);
		for (ChatColor chatColor : chatColors)
		{
			if (chatColor.isTransparent() != isChatboxTransparent || chatColor.getType() != ChatColorType.NORMAL || chatColor.isDefault())
			{
				continue;
			}

			messageNode.setValue(wrapTextWithColour(messageNode.getValue(), chatColor.getColor()));
			break;
		}
	}

	private static String wrapTextWithColour(String text, Color colour)
	{
		return "<col=" + Integer.toHexString(colour.getRGB() & 0xFFFFFF) + ">" + text + "</col>";
	}

	private static Color getDefaultColor(ChatMessageType type, boolean transparent)
	{
		if (!transparent)
		{
			switch (type)
			{
				case PUBLIC:
					return Color.decode("#0000FF");
				case PRIVATE_MESSAGE_SENT:
				case PRIVATE_MESSAGE_RECEIVED:
					return Color.decode("#00FFFF");
				case CLANCHAT:
					return Color.decode("#7F0000");
				case EXAMINE_ITEM:
				case EXAMINE_OBJECT:
				case EXAMINE_NPC:
					return Color.decode("#000000");
			}
		}
		else
		{
			switch (type)
			{
				case PUBLIC:
					return Color.decode("#9090FF");
				case PRIVATE_MESSAGE_SENT:
				case PRIVATE_MESSAGE_RECEIVED:
					return Color.decode("#00FFFF");
				case CLANCHAT:
					return Color.decode("#7F0000");
				case EXAMINE_ITEM:
				case EXAMINE_OBJECT:
				case EXAMINE_NPC:
					return Color.decode("#FFFFFF");
			}
		}

		return null;
	}

	private void loadColors()
	{
		colorCache.clear();

		// Apply defaults
		for (ChatMessageType chatMessageType : ChatMessageType.values())
		{
			Color defaultTransparent = getDefaultColor(chatMessageType, true);
			if (defaultTransparent != null)
			{
				cacheColor(new ChatColor(ChatColorType.NORMAL, defaultTransparent, true, true), chatMessageType);
			}

			Color defaultOpaque = getDefaultColor(chatMessageType, false);
			if (defaultOpaque != null)
			{
				cacheColor(new ChatColor(ChatColorType.NORMAL, defaultOpaque, false, true), chatMessageType);
			}
		}

		if (chatColorConfig.opaquePublicChat() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePublicChat(), false),
				ChatMessageType.PUBLIC);
		}
		if (chatColorConfig.opaquePublicChatHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePublicChatHighlight(), false),
				ChatMessageType.PUBLIC);
		}
		if (chatColorConfig.opaquePrivateMessageSent() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateMessageSent(), false),
				ChatMessageType.PRIVATE_MESSAGE_SENT);
		}
		if (chatColorConfig.opaquePrivateMessageSentHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePrivateMessageSentHighlight(), false),
				ChatMessageType.PRIVATE_MESSAGE_SENT);
		}
		if (chatColorConfig.opaquePrivateMessageReceived() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateMessageReceived(), false),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED);
		}
		if (chatColorConfig.opaquePrivateMessageReceivedHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePrivateMessageReceivedHighlight(), false),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED);
		}
		if (chatColorConfig.opaqueClanChatInfo() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueClanChatInfo(), false),
				ChatMessageType.CLANCHAT_INFO);
		}
		if (chatColorConfig.opaqueClanChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueClanChatMessage(), false),
				ChatMessageType.CLANCHAT);
		}
		if (chatColorConfig.opaqueClanChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueClanChatMessageHighlight(), false),
				ChatMessageType.CLANCHAT);
		}
		if (chatColorConfig.opaqueAutochatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueAutochatMessage(), false),
				ChatMessageType.AUTOCHAT);
		}
		if (chatColorConfig.opaqueAutochatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueAutochatMessageHighlight(), false),
				ChatMessageType.AUTOCHAT);
		}
		if (chatColorConfig.opaqueTradeChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueTradeChatMessage(), false),
				ChatMessageType.TRADE);
		}
		if (chatColorConfig.opaqueTradeChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueTradeChatMessageHighlight(), false),
				ChatMessageType.TRADE);
		}
		if (chatColorConfig.opaqueServerMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueServerMessage(), false),
				ChatMessageType.SERVER);
		}
		if (chatColorConfig.opaqueServerMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueServerMessageHighlight(), false),
				ChatMessageType.SERVER);
		}
		if (chatColorConfig.opaqueGameMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueGameMessage(), false),
				ChatMessageType.GAME);
		}
		if (chatColorConfig.opaqueGameMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueGameMessageHighlight(), false),
				ChatMessageType.GAME);
		}
		if (chatColorConfig.opaqueExamine() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
				ChatMessageType.EXAMINE_OBJECT);
		}
		if (chatColorConfig.opaqueExamineHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
				ChatMessageType.EXAMINE_OBJECT);
		}
		if (chatColorConfig.opaqueExamine() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
				ChatMessageType.EXAMINE_NPC);
		}
		if (chatColorConfig.opaqueExamineHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
				ChatMessageType.EXAMINE_NPC);
		}
		if (chatColorConfig.opaqueExamine() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
				ChatMessageType.EXAMINE_ITEM);
		}
		if (chatColorConfig.opaqueExamineHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
				ChatMessageType.EXAMINE_ITEM);
		}
		if (chatColorConfig.opaqueFiltered() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueFiltered(), false),
				ChatMessageType.FILTERED);
		}
		if (chatColorConfig.opaqueFilteredHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueFilteredHighlight(), false),
				ChatMessageType.FILTERED);
		}

		//Transparent Chat Colours
		if (chatColorConfig.transparentPublicChat() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPublicChat(), true),
				ChatMessageType.PUBLIC);
		}
		if (chatColorConfig.transparentPublicChatHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPublicChatHighlight(), true),
				ChatMessageType.PUBLIC);
		}
		if (chatColorConfig.transparentPrivateMessageSent() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateMessageSent(), true),
				ChatMessageType.PRIVATE_MESSAGE_SENT);
		}
		if (chatColorConfig.transparentPrivateMessageSentHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPrivateMessageSentHighlight(), true),
				ChatMessageType.PRIVATE_MESSAGE_SENT);
		}
		if (chatColorConfig.transparentPrivateMessageReceived() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateMessageReceived(), true),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED);
		}
		if (chatColorConfig.transparentPrivateMessageReceivedHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPrivateMessageReceivedHighlight(), true),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED);
		}
		if (chatColorConfig.transparentClanChatInfo() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentClanChatInfo(), true),
				ChatMessageType.CLANCHAT_INFO);
		}
		if (chatColorConfig.transparentClanChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentClanChatMessage(), true),
				ChatMessageType.CLANCHAT);
		}
		if (chatColorConfig.transparentClanChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentClanChatMessageHighlight(), true),
				ChatMessageType.CLANCHAT);
		}
		if (chatColorConfig.transparentAutochatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentAutochatMessage(), true),
				ChatMessageType.AUTOCHAT);
		}
		if (chatColorConfig.transparentAutochatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentAutochatMessageHighlight(), true),
				ChatMessageType.AUTOCHAT);
		}
		if (chatColorConfig.transparentTradeChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentTradeChatMessage(), true),
				ChatMessageType.TRADE);
		}
		if (chatColorConfig.transparentTradeChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentTradeChatMessageHighlight(), true),
				ChatMessageType.TRADE);
		}
		if (chatColorConfig.transparentServerMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentServerMessage(), true),
				ChatMessageType.SERVER);
		}
		if (chatColorConfig.transparentServerMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentServerMessageHighlight(), true),
				ChatMessageType.SERVER);
		}
		if (chatColorConfig.transparentGameMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentGameMessage(), true),
				ChatMessageType.GAME);
		}
		if (chatColorConfig.transparentGameMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentGameMessageHighlight(), true),
				ChatMessageType.GAME);
		}
		if (chatColorConfig.transparentExamine() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
				ChatMessageType.EXAMINE_OBJECT);
		}
		if (chatColorConfig.transparentExamineHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
				ChatMessageType.EXAMINE_OBJECT);
		}
		if (chatColorConfig.transparentExamine() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
				ChatMessageType.EXAMINE_NPC);
		}
		if (chatColorConfig.transparentExamineHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
				ChatMessageType.EXAMINE_NPC);
		}
		if (chatColorConfig.transparentExamine() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
				ChatMessageType.EXAMINE_ITEM);
		}
		if (chatColorConfig.transparentExamineHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
				ChatMessageType.EXAMINE_ITEM);
		}
		if (chatColorConfig.transparentFiltered() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentFiltered(), true),
				ChatMessageType.FILTERED);
		}
		if (chatColorConfig.transparentFilteredHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentFilteredHighlight(), true),
				ChatMessageType.FILTERED);
		}
	}

	private ChatMessageManager cacheColor(final ChatColor chatColor, final ChatMessageType... types)
	{
		for (ChatMessageType chatMessageType : types)
		{
			// color is excluded from equals/hashCode on ChatColor
			colorCache.remove(chatMessageType, chatColor);
			colorCache.put(chatMessageType, chatColor);
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
		final Collection<ChatColor> chatColors = colorCache.get(target.getType());

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
		final Collection<ChatColor> chatColors = colorCache.get(messageType);
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
