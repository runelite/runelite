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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import java.awt.Color;
import java.util.Collection;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.annotations.Varp;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

@Singleton
public class ChatMessageManager
{
	private static final Set<Integer> TUTORIAL_ISLAND_REGIONS = ImmutableSet.of(12336, 12335, 12592, 12080, 12079, 12436);

	private final Multimap<ChatMessageType, ChatColor> colorCache = HashMultimap.create();
	private final Client client;
	private final ChatColorConfig chatColorConfig;
	private final ClientThread clientThread;
	private final Queue<QueuedMessage> queuedMessages = new ConcurrentLinkedQueue<>();

	@Inject
	private ChatMessageManager(
		Client client,
		ChatColorConfig chatColorConfig,
		ClientThread clientThread,
		EventBus eventBus)
	{
		this.client = client;
		this.chatColorConfig = chatColorConfig;
		this.clientThread = clientThread;
		eventBus.register(this);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("textrecolor"))
		{
			loadColors();
			clientThread.invokeLater(client::refreshChat);
		}
	}

	@Subscribe
	public void onProfileChanged(ProfileChanged profileChanged)
	{
		loadColors();
		clientThread.invokeLater(client::refreshChat);
	}

	@VisibleForTesting
	void colorChatMessage()
	{
		final int[] intStack = client.getIntStack();
		final String[] stringStack = client.getStringStack();
		final int size = client.getStringStackSize();
		final int isize = client.getIntStackSize();
		final int uid = intStack[isize - 1];
		final boolean splitpmbox = intStack[isize - 2] == 1;

		final MessageNode messageNode = client.getMessages().get(uid);
		assert messageNode != null : "chat message build for unknown message";

		String message = stringStack[size - 2];
		final String username = stringStack[size - 3];
		final String channel = stringStack[size - 4];
		final ChatMessageType chatMessageType = messageNode.getType();

		final boolean isChatboxTransparent = client.isResized() && client.getVarbitValue(VarbitID.CHATBOX_TRANSPARENCY) == 1;
		Color usernameColor = null;
		Color channelColor = null;

		switch (chatMessageType)
		{
			// username recoloring for MODPRIVATECHAT, PRIVATECHAT and PRIVATECHATOUT
			// ChatMessageTypes is handled in the script callback event
			case TRADEREQ:
			case AUTOTYPER:
			case PUBLICCHAT:
			case MODCHAT:
			{
				String sanitizedUsername = Text.removeTags(username).replace('\u00A0', ' ');

				if (client.getLocalPlayer().getName().equals(sanitizedUsername))
				{
					usernameColor = isChatboxTransparent ? chatColorConfig.transparentPlayerUsername() : chatColorConfig.opaquePlayerUsername();
				}
				else if (client.isFriended(sanitizedUsername, true))
				{
					usernameColor = isChatboxTransparent ? chatColorConfig.transparentPublicFriendUsernames() : chatColorConfig.opaquePublicFriendUsernames();
				}
				else
				{
					usernameColor = isChatboxTransparent ? chatColorConfig.transparentUsername() : chatColorConfig.opaqueUsername();
				}
				break;
			}
			case FRIENDSCHAT:
			case FRIENDSCHATNOTIFICATION:
				usernameColor = isChatboxTransparent ? chatColorConfig.transparentFriendsChatUsernames() : chatColorConfig.opaqueFriendsChatUsernames();
				channelColor = isChatboxTransparent ? chatColorConfig.transparentFriendsChatChannelName() : chatColorConfig.opaqueFriendsChatChannelName();
				break;
			case CLAN_CHAT:
			case CLAN_MESSAGE:
			case CLAN_GIM_CHAT:
			case CLAN_GIM_MESSAGE:
				usernameColor = isChatboxTransparent ? chatColorConfig.transparentClanChatUsernames() : chatColorConfig.opaqueClanChatUsernames();
				channelColor = isChatboxTransparent ? chatColorConfig.transparentClanChannelName() : chatColorConfig.opaqueClanChannelName();
				break;
			case CLAN_GUEST_CHAT:
			case CLAN_GUEST_MESSAGE:
				usernameColor = isChatboxTransparent ? chatColorConfig.transparentClanChatGuestUsernames() : chatColorConfig.opaqueClanChatGuestUsernames();
				channelColor = isChatboxTransparent ? chatColorConfig.transparentClanChannelGuestName() : chatColorConfig.opaqueClanGuestChatChannelName();
				break;
		}

		if (usernameColor != null)
		{
			stringStack[size - 3] = ColorUtil.wrapWithColorTag(username, usernameColor);
		}

		if (channelColor != null && !Strings.isNullOrEmpty(channel))
		{
			stringStack[size - 4] = ColorUtil.wrapWithColorTag(channel, channelColor);
		}

		String prefix = "";
		if (chatMessageType == ChatMessageType.CLAN_GIM_CHAT || chatMessageType == ChatMessageType.CLAN_GIM_MESSAGE)
		{
			message = message.substring(1); // remove |
			prefix = "|";
		}

		if (messageNode.getRuneLiteFormatMessage() != null)
		{
			message = formatRuneLiteMessage(messageNode.getRuneLiteFormatMessage(),
				chatMessageType, splitpmbox);
		}

		final Collection<ChatColor> chatColors = colorCache.get(chatMessageType);
		for (ChatColor chatColor : chatColors)
		{
			if (chatColor.isTransparent() != isChatboxTransparent || chatColor.getType() != ChatColorType.NORMAL || chatColor.isDefault())
			{
				continue;
			}

			// Replace </col> tags in the message with the new color so embedded </col> won't reset the color
			final Color color = chatColor.getColor();
			message = ColorUtil.wrapWithColorTag(
				message.replace(ColorUtil.CLOSING_COLOR_TAG, ColorUtil.colorTag(color)),
				color);
			break;
		}

		stringStack[size - 2] = prefix + message;
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		final String eventName = scriptCallbackEvent.getEventName();

		boolean wrap;
		switch (eventName)
		{
			case "splitPrivChatUsernameColor":
				wrap = false;
				break;
			case "privChatUsername":
				wrap = true;
				break;
			case "chatMessageBuilding":
				colorChatMessage();
				return;
			default:
				return;
		}

		boolean isChatboxTransparent = client.isResized() && client.getVarbitValue(VarbitID.CHATBOX_TRANSPARENCY) == 1;
		Color usernameColor = isChatboxTransparent ? chatColorConfig.transparentPrivateUsernames() : chatColorConfig.opaquePrivateUsernames();
		if (usernameColor == null)
		{
			return;
		}

		final String[] stringStack = client.getStringStack();
		final int stringStackSize = client.getStringStackSize();

		String fromToUsername = stringStack[stringStackSize - 1];
		if (wrap)
		{
			fromToUsername = ColorUtil.wrapWithColorTag(fromToUsername, usernameColor);
		}
		else
		{
			fromToUsername = ColorUtil.colorTag(usernameColor);
		}
		stringStack[stringStackSize - 1] = fromToUsername;
	}

	private static Color getDefaultColor(ChatMessageType type, boolean transparent)
	{
		if (!transparent)
		{
			switch (type)
			{
				case PUBLICCHAT:
				case MODCHAT:
					return JagexColors.CHAT_PUBLIC_TEXT_OPAQUE_BACKGROUND;
				case PRIVATECHATOUT:
				case MODPRIVATECHAT:
				case PRIVATECHAT:
					return JagexColors.CHAT_PRIVATE_MESSAGE_TEXT_OPAQUE_BACKGROUND;
				case FRIENDSCHAT:
				case CLAN_CHAT:
				case CLAN_GUEST_CHAT:
				case CLAN_GIM_CHAT:
					return JagexColors.CHAT_FC_TEXT_OPAQUE_BACKGROUND;
				case ITEM_EXAMINE:
				case OBJECT_EXAMINE:
				case NPC_EXAMINE:
				case CONSOLE:
				case FRIENDSCHATNOTIFICATION:
				case CLAN_MESSAGE:
				case CLAN_GUEST_MESSAGE:
				case CLAN_GIM_MESSAGE:
					return JagexColors.CHAT_GAME_EXAMINE_TEXT_OPAQUE_BACKGROUND;
			}
		}
		else
		{
			switch (type)
			{
				case PUBLICCHAT:
				case MODCHAT:
					return JagexColors.CHAT_PUBLIC_TEXT_TRANSPARENT_BACKGROUND;
				case PRIVATECHATOUT:
				case MODPRIVATECHAT:
				case PRIVATECHAT:
					return JagexColors.CHAT_PRIVATE_MESSAGE_TEXT_TRANSPARENT_BACKGROUND;
				case FRIENDSCHAT:
				case CLAN_CHAT:
				case CLAN_GUEST_CHAT:
				case CLAN_GIM_CHAT:
					return JagexColors.CHAT_FC_TEXT_TRANSPARENT_BACKGROUND;
				case ITEM_EXAMINE:
				case OBJECT_EXAMINE:
				case NPC_EXAMINE:
				case CONSOLE:
				case FRIENDSCHATNOTIFICATION:
				case CLAN_MESSAGE:
				case CLAN_GUEST_MESSAGE:
				case CLAN_GIM_MESSAGE:
					return JagexColors.CHAT_GAME_EXAMINE_TEXT_TRANSPARENT_BACKGROUND;
			}
		}

		return null;
	}

	// get the variable holding the chat color from the settings, from script4484
	private static @Varp int getSettingsColor(ChatMessageType type, boolean transparent)
	{
		if (transparent)
		{
			switch (type)
			{
				case PUBLICCHAT:
				case MODCHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_PUBLIC_TRANSPARENT;
				case PRIVATECHATOUT:
				case MODPRIVATECHAT:
				case PRIVATECHAT:
				case LOGINLOGOUTNOTIFICATION:
					return VarPlayerID.OPTION_CHAT_COLOUR_PRIVATE_TRANSPARENT;
				case AUTOTYPER:
				case MODAUTOTYPER:
					return VarPlayerID.OPTION_CHAT_COLOUR_AUTOCHAT_TRANSPARENT;
				case BROADCAST:
					return VarPlayerID.OPTION_CHAT_COLOUR_BROADCAST_TRANSPARENT;
				case FRIENDSCHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_FRIENDSCHAT_TRANSPARENT;
				case CLAN_CHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_CLANCHAT_TRANSPARENT;
				case TRADEREQ:
					return VarPlayerID.OPTION_CHAT_COLOUR_TRADEREQ_TRANSPARENT;
				case CHALREQ_TRADE:
				case CHALREQ_FRIENDSCHAT:
				case CHALREQ_CLANCHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_CHALLENGEREQ_TRANSPARENT;
				case CLAN_GUEST_CHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_GUESTCLAN_TRANSPARENT;
				case CLAN_GIM_CHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_GIMCHAT_TRANSPARENT;
				case CLAN_MESSAGE:
					return VarPlayerID.OPTION_CHAT_COLOUR_CLANBROADCAST_TRANSPARENT;
				case CLAN_GIM_MESSAGE:
					return VarPlayerID.OPTION_CHAT_COLOUR_GIMBROADCAST_TRANSPARENT;
			}
		}
		else
		{
			switch (type)
			{
				case PUBLICCHAT:
				case MODCHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_PUBLIC_OPAQUE;
				case PRIVATECHATOUT:
				case MODPRIVATECHAT:
				case PRIVATECHAT:
				case LOGINLOGOUTNOTIFICATION:
					return VarPlayerID.OPTION_CHAT_COLOUR_PRIVATE_OPAQUE;
				case AUTOTYPER:
				case MODAUTOTYPER:
					return VarPlayerID.OPTION_CHAT_COLOUR_AUTOCHAT_OPAQUE;
				case BROADCAST:
					return VarPlayerID.OPTION_CHAT_COLOUR_BROADCAST_OPAQUE;
				case FRIENDSCHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_FRIENDSCHAT_OPAQUE;
				case CLAN_CHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_CLANCHAT_OPAQUE;
				case TRADEREQ:
					return VarPlayerID.OPTION_CHAT_COLOUR_TRADEREQ_OPAQUE;
				case CHALREQ_TRADE:
				case CHALREQ_FRIENDSCHAT:
				case CHALREQ_CLANCHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_CHALLENGEREQ_OPAQUE;
				case CLAN_GUEST_CHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_GUESTCLAN_OPAQUE;
				case CLAN_GIM_CHAT:
					return VarPlayerID.OPTION_CHAT_COLOUR_GIMCHAT_OPAQUE;
				case CLAN_MESSAGE:
					return VarPlayerID.OPTION_CHAT_COLOUR_CLANBROADCAST_OPAQUE;
				case CLAN_GIM_MESSAGE:
					return VarPlayerID.OPTION_CHAT_COLOUR_GIMBROADCAST_OPAQUE;
			}
		}
		return -1;
	}

	/**
	 * Load all configured colors
	 */
	private void loadColors()
	{
		colorCache.clear();

		// Apply defaults
		for (ChatMessageType chatMessageType : ChatMessageType.values())
		{
			Color defaultTransparent = getDefaultColor(chatMessageType, true);
			if (defaultTransparent != null)
			{
				cacheColor(new ChatColor(ChatColorType.NORMAL, defaultTransparent, true, true, getSettingsColor(chatMessageType, true)), chatMessageType);
			}

			Color defaultOpaque = getDefaultColor(chatMessageType, false);
			if (defaultOpaque != null)
			{
				cacheColor(new ChatColor(ChatColorType.NORMAL, defaultOpaque, false, true, getSettingsColor(chatMessageType, false)), chatMessageType);
			}
		}

		if (chatColorConfig.opaquePublicChat() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePublicChat(), false),
				ChatMessageType.PUBLICCHAT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePublicChat(), false),
				ChatMessageType.MODCHAT);
		}
		if (chatColorConfig.opaquePublicChatHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePublicChatHighlight(), false),
				ChatMessageType.PUBLICCHAT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePublicChatHighlight(), false),
				ChatMessageType.MODCHAT);
		}
		if (chatColorConfig.opaquePrivateMessageSent() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateMessageSent(), false),
				ChatMessageType.PRIVATECHATOUT);
		}
		if (chatColorConfig.opaquePrivateMessageSentHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePrivateMessageSentHighlight(), false),
				ChatMessageType.PRIVATECHATOUT);
		}
		if (chatColorConfig.opaquePrivateMessageReceived() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateMessageReceived(), false),
				ChatMessageType.PRIVATECHAT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateMessageReceived(), false),
				ChatMessageType.MODPRIVATECHAT);
		}
		if (chatColorConfig.opaquePrivateMessageReceivedHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePrivateMessageReceivedHighlight(), false),
				ChatMessageType.PRIVATECHAT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaquePrivateMessageReceivedHighlight(), false),
				ChatMessageType.MODPRIVATECHAT);
		}
		if (chatColorConfig.opaqueFriendsChatInfo() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueFriendsChatInfo(), false),
				ChatMessageType.FRIENDSCHATNOTIFICATION);
		}
		if (chatColorConfig.opaqueFriendsChatInfoHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueFriendsChatInfoHighlight(), false),
				ChatMessageType.FRIENDSCHATNOTIFICATION);
		}
		if (chatColorConfig.opaqueFriendsChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueFriendsChatMessage(), false),
				ChatMessageType.FRIENDSCHAT);
		}
		if (chatColorConfig.opaqueFriendsChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueFriendsChatMessageHighlight(), false),
				ChatMessageType.FRIENDSCHAT);
		}
		//region opaque clanchat
		if (chatColorConfig.opaqueClanChatInfo() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueClanChatInfo(), false),
				ChatMessageType.CLAN_MESSAGE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueClanChatInfo(), false),
				ChatMessageType.CLAN_GIM_MESSAGE);
		}
		if (chatColorConfig.opaqueClanChatInfoHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueClanChatInfoHighlight(), false),
				ChatMessageType.CLAN_MESSAGE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueClanChatInfoHighlight(), false),
				ChatMessageType.CLAN_GIM_MESSAGE);
		}
		if (chatColorConfig.opaqueClanChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueClanChatMessage(), false),
				ChatMessageType.CLAN_CHAT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueClanChatMessage(), false),
				ChatMessageType.CLAN_GIM_CHAT);
		}
		if (chatColorConfig.opaqueClanChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueClanChatMessageHighlight(), false),
				ChatMessageType.CLAN_CHAT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueClanChatMessageHighlight(), false),
				ChatMessageType.CLAN_GIM_CHAT);
		}

		if (chatColorConfig.opaqueClanChatGuestInfo() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueClanChatGuestInfo(), false),
				ChatMessageType.CLAN_GUEST_MESSAGE);
		}
		if (chatColorConfig.opaqueClanChatGuestInfoHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueClanChatGuestInfoHighlight(), false),
				ChatMessageType.CLAN_GUEST_MESSAGE);
		}
		if (chatColorConfig.opaqueClanChatGuestMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueClanChatGuestMessage(), false),
				ChatMessageType.CLAN_GUEST_CHAT);
		}
		if (chatColorConfig.opaqueClanChatGuestMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueClanChatGuestMessageHighlight(), false),
				ChatMessageType.CLAN_GUEST_CHAT);
		}
		//endregion
		if (chatColorConfig.opaqueAutochatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueAutochatMessage(), false),
				ChatMessageType.AUTOTYPER);
		}
		if (chatColorConfig.opaqueAutochatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueAutochatMessageHighlight(), false),
				ChatMessageType.AUTOTYPER);
		}
		if (chatColorConfig.opaqueTradeChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueTradeChatMessage(), false),
				ChatMessageType.TRADEREQ);
		}
		if (chatColorConfig.opaqueTradeChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueTradeChatMessageHighlight(), false),
				ChatMessageType.TRADEREQ);
		}
		if (chatColorConfig.opaqueServerMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueServerMessage(), false),
				ChatMessageType.GAMEMESSAGE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueServerMessage(), false),
				ChatMessageType.ENGINE);
		}
		if (chatColorConfig.opaqueServerMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueServerMessageHighlight(), false),
				ChatMessageType.GAMEMESSAGE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueServerMessageHighlight(), false),
				ChatMessageType.ENGINE);
		}
		if (chatColorConfig.opaqueGameMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueGameMessage(), false),
				ChatMessageType.CONSOLE);
		}
		if (chatColorConfig.opaqueGameMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueGameMessageHighlight(), false),
				ChatMessageType.CONSOLE);
		}
		if (chatColorConfig.opaqueExamine() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
				ChatMessageType.OBJECT_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
				ChatMessageType.NPC_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueExamine(), false),
				ChatMessageType.ITEM_EXAMINE);
		}
		if (chatColorConfig.opaqueExamineHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
				ChatMessageType.OBJECT_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
				ChatMessageType.NPC_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueExamineHighlight(), false),
				ChatMessageType.ITEM_EXAMINE);
		}
		if (chatColorConfig.opaqueFiltered() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaqueFiltered(), false),
				ChatMessageType.SPAM);
		}
		if (chatColorConfig.opaqueFilteredHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.opaqueFilteredHighlight(), false),
				ChatMessageType.SPAM);
		}
		if (chatColorConfig.opaquePrivateUsernames() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.opaquePrivateUsernames(), false),
				ChatMessageType.LOGINLOGOUTNOTIFICATION);
		}

		//Transparent Chat Colours
		if (chatColorConfig.transparentPublicChat() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPublicChat(), true),
				ChatMessageType.PUBLICCHAT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPublicChat(), true),
				ChatMessageType.MODCHAT);
		}
		if (chatColorConfig.transparentPublicChatHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPublicChatHighlight(), true),
				ChatMessageType.PUBLICCHAT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPublicChatHighlight(), true),
				ChatMessageType.MODCHAT);
		}
		if (chatColorConfig.transparentPrivateMessageSent() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateMessageSent(), true),
				ChatMessageType.PRIVATECHATOUT);
		}
		if (chatColorConfig.transparentPrivateMessageSentHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPrivateMessageSentHighlight(), true),
				ChatMessageType.PRIVATECHATOUT);
		}
		if (chatColorConfig.transparentPrivateMessageReceived() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateMessageReceived(), true),
				ChatMessageType.PRIVATECHAT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateMessageReceived(), true),
				ChatMessageType.MODPRIVATECHAT);
		}
		if (chatColorConfig.transparentPrivateMessageReceivedHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPrivateMessageReceivedHighlight(), true),
				ChatMessageType.PRIVATECHAT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentPrivateMessageReceivedHighlight(), true),
				ChatMessageType.MODPRIVATECHAT);
		}
		//region transpaprent friends chat
		if (chatColorConfig.transparentFriendsChatInfo() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentFriendsChatInfo(), true),
				ChatMessageType.FRIENDSCHATNOTIFICATION);
		}
		if (chatColorConfig.transparentFriendsChatInfoHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentFriendsChatInfoHighlight(), true),
				ChatMessageType.FRIENDSCHATNOTIFICATION);
		}
		if (chatColorConfig.transparentFriendsChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentFriendsChatMessage(), true),
				ChatMessageType.FRIENDSCHAT);
		}
		if (chatColorConfig.transparentFriendsChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentFriendsChatMessageHighlight(), true),
				ChatMessageType.FRIENDSCHAT);
		}
		//endregion
		//region transparent clanchat
		if (chatColorConfig.transparentClanChatInfo() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentClanChatInfo(), true),
				ChatMessageType.CLAN_MESSAGE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentClanChatInfo(), true),
				ChatMessageType.CLAN_GIM_MESSAGE);
		}
		if (chatColorConfig.transparentClanChatInfoHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentClanChatInfoHighlight(), true),
				ChatMessageType.CLAN_MESSAGE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentClanChatInfoHighlight(), true),
				ChatMessageType.CLAN_GIM_MESSAGE);
		}
		if (chatColorConfig.transparentClanChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentClanChatMessage(), true),
				ChatMessageType.CLAN_CHAT);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentClanChatMessage(), true),
				ChatMessageType.CLAN_GIM_CHAT);
		}
		if (chatColorConfig.transparentClanChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentClanChatMessageHighlight(), true),
				ChatMessageType.CLAN_CHAT);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentClanChatMessageHighlight(), true),
				ChatMessageType.CLAN_GIM_CHAT);
		}

		if (chatColorConfig.transparentClanChatGuestInfo() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentClanChatGuestInfo(), true),
				ChatMessageType.CLAN_GUEST_MESSAGE);
		}
		if (chatColorConfig.transparentClanChatGuestInfoHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentClanChatGuestInfoHighlight(), true),
				ChatMessageType.CLAN_GUEST_MESSAGE);
		}
		if (chatColorConfig.transparentClanChatGuestMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentClanChatGuestMessage(), true),
				ChatMessageType.CLAN_GUEST_CHAT);
		}
		if (chatColorConfig.transparentClanChatGuestMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentClanChatGuestMessageHighlight(), true),
				ChatMessageType.CLAN_GUEST_CHAT);
		}
		//endregion
		if (chatColorConfig.transparentAutochatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentAutochatMessage(), true),
				ChatMessageType.AUTOTYPER);
		}
		if (chatColorConfig.transparentAutochatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentAutochatMessageHighlight(), true),
				ChatMessageType.AUTOTYPER);
		}
		if (chatColorConfig.transparentTradeChatMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentTradeChatMessage(), true),
				ChatMessageType.TRADEREQ);
		}
		if (chatColorConfig.transparentTradeChatMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentTradeChatMessageHighlight(), true),
				ChatMessageType.TRADEREQ);
		}
		if (chatColorConfig.transparentServerMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentServerMessage(), true),
				ChatMessageType.GAMEMESSAGE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentServerMessage(), true),
				ChatMessageType.ENGINE);
		}
		if (chatColorConfig.transparentServerMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentServerMessageHighlight(), true),
				ChatMessageType.GAMEMESSAGE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentServerMessageHighlight(), true),
				ChatMessageType.ENGINE);
		}
		if (chatColorConfig.transparentGameMessage() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentGameMessage(), true),
				ChatMessageType.CONSOLE);
		}
		if (chatColorConfig.transparentGameMessageHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentGameMessageHighlight(), true),
				ChatMessageType.CONSOLE);
		}
		if (chatColorConfig.transparentExamine() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
				ChatMessageType.OBJECT_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
				ChatMessageType.NPC_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentExamine(), true),
				ChatMessageType.ITEM_EXAMINE);
		}
		if (chatColorConfig.transparentExamineHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
				ChatMessageType.OBJECT_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
				ChatMessageType.NPC_EXAMINE);
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentExamineHighlight(), true),
				ChatMessageType.ITEM_EXAMINE);
		}
		if (chatColorConfig.transparentFiltered() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentFiltered(), true),
				ChatMessageType.SPAM);
		}
		if (chatColorConfig.transparentFilteredHighlight() != null)
		{
			cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, chatColorConfig.transparentFilteredHighlight(), true),
				ChatMessageType.SPAM);
		}
		if (chatColorConfig.transparentPrivateUsernames() != null)
		{
			cacheColor(new ChatColor(ChatColorType.NORMAL, chatColorConfig.transparentPrivateUsernames(), true),
				ChatMessageType.LOGINLOGOUTNOTIFICATION);
		}
	}

	private void cacheColor(final ChatColor chatColor, final ChatMessageType... types)
	{
		for (ChatMessageType chatMessageType : types)
		{
			// color is excluded from equals/hashCode on ChatColor
			colorCache.remove(chatMessageType, chatColor);
			colorCache.put(chatMessageType, chatColor);
		}
	}

	public void queue(QueuedMessage message)
	{
		queuedMessages.add(message);
	}

	public void process()
	{
		for (QueuedMessage msg; (msg = queuedMessages.poll()) != null; )
		{
			add(msg);
		}
	}

	private void add(QueuedMessage message)
	{
		// Do not send message if the player is on tutorial island
		final Player player = client.getLocalPlayer();
		if (player != null && TUTORIAL_ISLAND_REGIONS.contains(player.getWorldLocation().getRegionID()))
		{
			return;
		}

		// this updates chat cycle
		final MessageNode line = client.addChatMessage(
			message.getType(),
			MoreObjects.firstNonNull(message.getName(), ""),
			MoreObjects.firstNonNull(message.getRuneLiteFormattedMessage(), message.getValue()),
			message.getSender());

		// Update the message with RuneLite additions
		line.setRuneLiteFormatMessage(message.getRuneLiteFormattedMessage());

		if (message.getTimestamp() != 0)
		{
			line.setTimestamp(message.getTimestamp());
		}
	}

	/**
	 * Rebuild the message node message from the RuneLite format message.
	 * DEPRECATED: no longer needs to be called.
	 *
	 * @param messageNode message node
	 */
	@Deprecated
	public void update(final MessageNode messageNode)
	{
	}

	@VisibleForTesting
	String formatRuneLiteMessage(String runeLiteFormatMessage, ChatMessageType type, boolean pmbox)
	{
		final boolean transparentChatbox = client.getVarbitValue(VarbitID.CHATBOX_TRANSPARENCY) != 0;
		final boolean transparent = client.isResized() && transparentChatbox;
		final Collection<ChatColor> chatColors = colorCache.get(type);
		for (ChatColor chatColor : chatColors)
		{
			if (chatColor.isTransparent() == transparent)
			{
				String colstr;

				if (pmbox && chatColor.getType() == ChatColorType.NORMAL)
				{
					// The default ChatColors for private have the chatbox text color, not the split chat color,
					// and the split chat color is set by widget color, so just use </col>. The in-game
					// private chat color doesn't apply to split chat either so using that here also is incorrect.
					//
					// If we recolor the final message later we replace </col> with the desired color in
					// colorChatMessage()
					colstr = ColorUtil.CLOSING_COLOR_TAG;
				}
				else
				{
					Color color = chatColor.getColor();

					@Varp int varp = chatColor.getSetting();
					if (varp != -1)
					{
						// Apply configured color from game settings, if set
						assert chatColor.isDefault();
						int v = client.getVarpValue(varp);
						if (v != 0)
						{
							color = new Color(v - 1);
						}
					}

					colstr = ColorUtil.colorTag(color);
				}

				// Replace custom formatting with actual colors
				runeLiteFormatMessage = runeLiteFormatMessage.replace(
					"<col" + chatColor.getType().name() + ">",
					colstr);
			}
		}

		return runeLiteFormatMessage;
	}
}
