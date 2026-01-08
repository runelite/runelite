/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, trimbe <github.com/trimbe>
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
package net.runelite.client.plugins.chatchannel;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Runnables;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.inject.Inject;
import net.runelite.api.ChatLineBuffer;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ChatPlayer;
import net.runelite.api.Client;
import net.runelite.api.FriendsChatManager;
import net.runelite.api.FriendsChatMember;
import net.runelite.api.FriendsChatRank;
import net.runelite.api.GameState;
import net.runelite.api.Ignore;
import net.runelite.api.MessageNode;
import net.runelite.api.NameableContainer;
import net.runelite.api.ScriptID;
import net.runelite.api.clan.ClanChannel;
import net.runelite.api.clan.ClanChannelMember;
import net.runelite.api.clan.ClanRank;
import net.runelite.api.clan.ClanSettings;
import net.runelite.api.clan.ClanTitle;
import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ClanMemberLeft;
import net.runelite.api.events.FriendsChatChanged;
import net.runelite.api.events.FriendsChatMemberJoined;
import net.runelite.api.events.FriendsChatMemberLeft;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ChatIconManager;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.ui.JagexColors.CHAT_FC_NAME_OPAQUE_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_FC_NAME_TRANSPARENT_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_FC_TEXT_OPAQUE_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_FC_TEXT_TRANSPARENT_BACKGROUND;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Chat Channels",
	description = "Improvements for friends chat and clan chat.",
	tags = {"icons", "rank", "recent", "clan", "friend", "channel"}
)
public class ChatChannelPlugin extends Plugin
{
	private static final int MAX_CHATS = 10;
	private static final String RECENT_TITLE = "Recent FCs";
	@VisibleForTesting
	static final int MESSAGE_DELAY = 10;

	@Inject
	private Client client;

	@Inject
	private ChatIconManager chatIconManager;

	@Inject
	private ChatChannelConfig config;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ChatColorConfig chatColorConfig;

	private List<String> chats;
	/**
	 * queue of temporary messages added to the client
	 */
	private final Deque<MemberJoinMessage> joinMessages = new ArrayDeque<>();
	private final List<MemberActivity> activityBuffer = new LinkedList<>();
	private int joinedTick;

	private boolean kickConfirmed = false;

	@Provides
	ChatChannelConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatChannelConfig.class);
	}

	@Override
	public void startUp()
	{
		chats = new ArrayList<>(Text.fromCSV(config.chatsData()));

		if (config.showIgnores())
		{
			clientThread.invoke(() -> colorIgnoredPlayers(config.showIgnoresColor()));
		}

		rebuildClanTitle();
	}

	@Override
	public void shutDown()
	{
		chats = null;
		clientThread.invoke(() -> colorIgnoredPlayers(Color.WHITE));
		rebuildFriendsChat();
		rebuildClanTitle();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals(ChatChannelConfig.GROUP))
		{
			if (!config.recentChats())
			{
				rebuildFriendsChat();
			}

			Color ignoreColor = config.showIgnores() ? config.showIgnoresColor() : Color.WHITE;
			clientThread.invoke(() -> colorIgnoredPlayers(ignoreColor));

			rebuildClanTitle();
		}
	}

	@Subscribe
	public void onFriendsChatMemberJoined(FriendsChatMemberJoined event)
	{
		final FriendsChatMember member = event.getMember();

		// members getting initialized isn't relevant
		if (joinedTick == client.getTickCount())
		{
			return;
		}

		if (!config.showFriendsChatJoinLeave() ||
			member.getRank().getValue() < config.joinLeaveRank().getValue())
		{
			return;
		}

		// attempt to filter out world hopping joins
		queueJoin(member, MemberActivity.ChatType.FRIENDS_CHAT);
	}

	@Subscribe
	public void onFriendsChatMemberLeft(FriendsChatMemberLeft event)
	{
		final FriendsChatMember member = event.getMember();

		if (!config.showFriendsChatJoinLeave() ||
			member.getRank().getValue() < config.joinLeaveRank().getValue())
		{
			return;
		}

		queueLeave(member, MemberActivity.ChatType.FRIENDS_CHAT);
	}

	@Subscribe
	public void onClanMemberJoined(ClanMemberJoined clanMemberJoined)
	{
		MemberActivity.ChatType chatType = clanChannelToChatType(clanMemberJoined.getClanChannel());
		if (chatType != null && clanChannelJoinLeaveEnabled(chatType))
		{
			queueJoin(clanMemberJoined.getClanMember(), chatType);
		}
	}

	@Subscribe
	public void onClanMemberLeft(ClanMemberLeft clanMemberLeft)
	{
		MemberActivity.ChatType chatType = clanChannelToChatType(clanMemberLeft.getClanChannel());
		if (chatType != null && clanChannelJoinLeaveEnabled(chatType))
		{
			queueLeave(clanMemberLeft.getClanMember(), chatType);
		}
	}

	private MemberActivity.ChatType clanChannelToChatType(ClanChannel clanChannel)
	{
		return clanChannel == client.getClanChannel() ? MemberActivity.ChatType.CLAN_CHAT :
			clanChannel == client.getGuestClanChannel() ? MemberActivity.ChatType.GUEST_CHAT :
			null;
	}

	private boolean clanChannelJoinLeaveEnabled(MemberActivity.ChatType chatType)
	{
		switch (chatType)
		{
			case CLAN_CHAT:
				return config.clanChatShowJoinLeave();
			case GUEST_CHAT:
				return config.guestClanChatShowJoinLeave();
			default:
				return false;
		}
	}

	private void queueJoin(ChatPlayer member, MemberActivity.ChatType chatType)
	{
		for (ListIterator<MemberActivity> iter = activityBuffer.listIterator(); iter.hasNext(); )
		{
			MemberActivity activity = iter.next();

			if (activity.getChatType() == chatType && activity.getMember().compareTo(member) == 0)
			{
				iter.remove();
				return;
			}
		}

		MemberActivity activity = new MemberActivity(ActivityType.JOINED, chatType,
			member, client.getTickCount());
		activityBuffer.add(activity);
	}

	private void queueLeave(ChatPlayer member, MemberActivity.ChatType chatType)
	{
		for (ListIterator<MemberActivity> iter = activityBuffer.listIterator(); iter.hasNext(); )
		{
			MemberActivity activity = iter.next();

			if (activity.getChatType() == chatType && activity.getMember().compareTo(member) == 0)
			{
				iter.remove();
				return;
			}
		}

		MemberActivity activity = new MemberActivity(ActivityType.LEFT, chatType,
			member, client.getTickCount());
		activityBuffer.add(activity);
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget chatList = client.getWidget(InterfaceID.ChatchannelCurrent.LIST);
		if (chatList != null)
		{
			Widget owner = client.getWidget(InterfaceID.ChatchannelCurrent.CHANNELOWNER);
			FriendsChatManager friendsChatManager = client.getFriendsChatManager();
			if ((friendsChatManager == null || friendsChatManager.getCount() <= 0)
				&& chatList.getChildren() == null && !Strings.isNullOrEmpty(owner.getText())
				&& config.recentChats())
			{
				loadFriendsChats();
			}
		}

		timeoutMessages();

		addActivityMessages();
	}

	private void timeoutMessages()
	{
		if (joinMessages.isEmpty())
		{
			return;
		}

		final int joinLeaveTimeout = config.joinLeaveTimeout();
		if (joinLeaveTimeout == 0)
		{
			return;
		}

		boolean removed = false;

		for (Iterator<MemberJoinMessage> it = joinMessages.iterator(); it.hasNext(); )
		{
			MemberJoinMessage joinMessage = it.next();
			MessageNode messageNode = joinMessage.getMessageNode();
			final int createdTick = joinMessage.getTick();

			if (client.getTickCount() > createdTick + joinLeaveTimeout)
			{
				it.remove();

				// If this message has been reused since, it will get a different id
				if (joinMessage.getGetMessageId() == messageNode.getId())
				{
					ChatLineBuffer ccInfoBuffer = client.getChatLineMap().get(messageNode.getType().getType());
					if (ccInfoBuffer != null)
					{
						ccInfoBuffer.removeMessageNode(messageNode);
						removed = true;
					}
				}
			}
			else
			{
				// Everything else in the deque is newer
				break;
			}
		}

		if (removed)
		{
			clientThread.invoke(() -> client.runScript(ScriptID.BUILD_CHATBOX));
		}
	}

	@VisibleForTesting
	void addActivityMessages()
	{
		if (activityBuffer.isEmpty())
		{
			return;
		}

		for (ListIterator<MemberActivity> iter = activityBuffer.listIterator(); iter.hasNext(); )
		{
			MemberActivity activity = iter.next();
			if (activity.getTick() >= client.getTickCount() - MESSAGE_DELAY)
			{
				// everything after this is older
				return;
			}

			iter.remove();
			switch (activity.getChatType())
			{
				case FRIENDS_CHAT:
					addActivityMessage((FriendsChatMember) activity.getMember(), activity.getActivityType());
					break;
				case CLAN_CHAT:
				case GUEST_CHAT:
					addClanActivityMessage((ClanChannelMember) activity.getMember(), activity.getActivityType(), activity.getChatType());
					break;
			}
		}
	}

	private void addActivityMessage(FriendsChatMember member, ActivityType activityType)
	{
		final FriendsChatManager friendsChatManager = client.getFriendsChatManager();
		if (friendsChatManager == null)
		{
			return;
		}

		final String activityMessage = activityType == ActivityType.JOINED ? " has joined." : " has left.";
		final FriendsChatRank rank = member.getRank();
		final Color textColor, channelColor;
		int rankIcon = -1;

		// Use configured friends chat info colors if set, otherwise default to the jagex text and fc name colors
		if (client.isResized() && client.getVarbitValue(VarbitID.CHATBOX_TRANSPARENCY) == 1)
		{
			textColor = MoreObjects.firstNonNull(chatColorConfig.transparentFriendsChatInfo(), CHAT_FC_TEXT_TRANSPARENT_BACKGROUND);
			channelColor = MoreObjects.firstNonNull(chatColorConfig.transparentFriendsChatChannelName(), CHAT_FC_NAME_TRANSPARENT_BACKGROUND);
		}
		else
		{
			textColor = MoreObjects.firstNonNull(chatColorConfig.opaqueFriendsChatInfo(), CHAT_FC_TEXT_OPAQUE_BACKGROUND);
			channelColor = MoreObjects.firstNonNull(chatColorConfig.opaqueFriendsChatChannelName(), CHAT_FC_NAME_OPAQUE_BACKGROUND);
		}

		if (config.chatIcons() && rank != null && rank != FriendsChatRank.UNRANKED)
		{
			rankIcon = chatIconManager.getIconNumber(rank);
		}

		ChatMessageBuilder message = new ChatMessageBuilder()
			.append("[")
			.append(channelColor, friendsChatManager.getName());
		if (rankIcon > -1)
		{
			message
				.append(" ")
				.img(rankIcon);
		}
		message
			.append("] ")
			.append(textColor, member.getName() + activityMessage);

		final String messageString = message.build();
		final MessageNode line = client.addChatMessage(ChatMessageType.FRIENDSCHATNOTIFICATION, "", messageString, "");

		MemberJoinMessage joinMessage = new MemberJoinMessage(line, line.getId(), client.getTickCount());
		joinMessages.addLast(joinMessage);
	}

	private void addClanActivityMessage(ClanChannelMember member, ActivityType activityType, MemberActivity.ChatType chatType)
	{
		ClanSettings clanSettings = chatType == MemberActivity.ChatType.CLAN_CHAT ? client.getClanSettings() : client.getGuestClanSettings();
		ClanRank rank = member.getRank();

		if (rank == null || clanSettings == null)
		{
			return;
		}

		ClanTitle clanTitle = clanSettings.titleForRank(rank);
		int rankIcon = -1;
		if (clanTitle != null)
		{
			// Clan ranks are always included in chat messages, so we'll just always include it in join messages.
			rankIcon = chatIconManager.getIconNumber(clanTitle);
		}

		final Color textColor;
		// Use configured clan chat info colors if set, otherwise default to the jagex text and fc name colors
		if (client.isResized() && client.getVarbitValue(VarbitID.CHATBOX_TRANSPARENCY) == 1)
		{
			textColor = MoreObjects.firstNonNull(
				chatType == MemberActivity.ChatType.CLAN_CHAT ? chatColorConfig.transparentClanChatInfo() : chatColorConfig.transparentClanChatGuestInfo(),
				CHAT_FC_TEXT_TRANSPARENT_BACKGROUND);
		}
		else
		{
			textColor = MoreObjects.firstNonNull(
				chatType == MemberActivity.ChatType.CLAN_CHAT ? chatColorConfig.opaqueClanChatInfo() : chatColorConfig.opaqueClanChatGuestInfo(),
				CHAT_FC_TEXT_OPAQUE_BACKGROUND);
		}

		ChatMessageBuilder message = new ChatMessageBuilder();
		if (rankIcon > -1)
		{
			message.img(rankIcon);
		}
		message.append(textColor, member.getName() + (activityType == ActivityType.JOINED ? " has joined." : " has left."));

		final String messageString = message.build();
		final MessageNode line = client.addChatMessage(
			chatType == MemberActivity.ChatType.CLAN_CHAT ? ChatMessageType.CLAN_MESSAGE : ChatMessageType.CLAN_GUEST_MESSAGE,
			"", messageString, "");

		MemberJoinMessage joinMessage = new MemberJoinMessage(line, line.getId(), client.getTickCount());
		joinMessages.addLast(joinMessage);
	}

	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged strChanged)
	{
		if (strChanged.getIndex() == VarClientID.LAST_FRIENDSCHATJOIN && config.recentChats())
		{
			updateRecentChat(client.getVarcStrValue(VarClientID.LAST_FRIENDSCHATJOIN));
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged state)
	{
		GameState gameState = state.getGameState();

		if (gameState == GameState.LOGIN_SCREEN || gameState == GameState.CONNECTION_LOST || gameState == GameState.HOPPING)
		{
			joinMessages.clear();
		}
	}

	@Subscribe
	public void onFriendsChatChanged(FriendsChatChanged event)
	{
		if (event.isJoined())
		{
			joinedTick = client.getTickCount();
		}

		activityBuffer.clear();
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		switch (scriptCallbackEvent.getEventName())
		{
			case "confirmFriendsChatKick":
			{
				if (!config.confirmKicks() || kickConfirmed)
				{
					break;
				}

				// Set a flag so the script doesn't instantly kick them
				final int[] intStack = client.getIntStack();
				final int size = client.getIntStackSize();
				intStack[size - 1] = 1;

				// Get name of player we are trying to kick
				final Object[] objectStack = client.getObjectStack();
				final int objectStackSize = client.getObjectStackSize();
				final String kickPlayerName = (String) objectStack[objectStackSize - 1];

				// Show a chatbox panel confirming the kick
				clientThread.invokeLater(() -> confirmKickPlayer(kickPlayerName));
				break;
			}
			case "chatMessageBuilding":
			{
				int uid = client.getIntStack()[client.getIntStackSize() - 1];
				final MessageNode messageNode = client.getMessages().get(uid);
				assert messageNode != null : "chat message build for unknown message";
				final ChatMessageType messageType = messageNode.getType();

				switch (messageType)
				{
					case PRIVATECHAT:
					case MODPRIVATECHAT:
						if (!config.privateMessageIcons())
						{
							return;
						}
						break;
					case PUBLICCHAT:
					case MODCHAT:
						if (!config.publicChatIcons())
						{
							return;
						}
						break;
					case FRIENDSCHAT:
						if (!config.chatIcons())
						{
							return;
						}
						break;
					default:
						return;
				}

				final Object[] objectStack = client.getObjectStack();
				final int objectStackSize = client.getObjectStackSize();
				final String name = (String) objectStack[objectStackSize - 3];
				final FriendsChatRank rank = getRank(Text.removeTags(name));
				if (rank != null && rank != FriendsChatRank.UNRANKED)
				{
					int iconNumber = chatIconManager.getIconNumber(rank);
					if (iconNumber > -1)
					{
						final String img = "<img=" + iconNumber + ">";
						objectStack[objectStackSize - 3] = img + name;
					}
				}
			}
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.FRIENDS_CHAT_CHANNEL_REBUILD)
		{
			if (config.showIgnores())
			{
				colorIgnoredPlayers(config.showIgnoresColor());
			}

			FriendsChatManager friendsChatManager = client.getFriendsChatManager();
			Widget chatTitle = client.getWidget(InterfaceID.ChatchannelCurrent.CHANNELNAME);
			if (friendsChatManager != null && friendsChatManager.getCount() > 0 && chatTitle != null)
			{
				chatTitle.setText(chatTitle.getText() + " (" + friendsChatManager.getCount() + "/" + friendsChatManager.getSize() + ")");
			}
		}
		else if (event.getScriptId() == ScriptID.CLAN_SIDEPANEL_DRAW)
		{
			if (config.clanChatShowOnlineMemberCount())
			{
				updateClanTitle(InterfaceID.ClansSidepanel.HEADER, client.getClanChannel());
			}

			if (config.guestClanChatShowOnlineMemberCount())
			{
				updateClanTitle(InterfaceID.ClansGuestSidepanel.HEADER, client.getGuestClanChannel());
			}
		}
	}

	private FriendsChatRank getRank(String playerName)
	{
		final FriendsChatManager friendsChatManager = client.getFriendsChatManager();
		if (friendsChatManager == null)
		{
			return FriendsChatRank.UNRANKED;
		}

		FriendsChatMember friendsChatMember = friendsChatManager.findByName(playerName);
		return friendsChatMember != null ? friendsChatMember.getRank() : FriendsChatRank.UNRANKED;
	}

	private void rebuildFriendsChat()
	{
		Widget chat = client.getWidget(InterfaceID.ChatchannelCurrent.UNIVERSE);
		if (chat == null)
		{
			return;
		}

		Object[] args = chat.getOnVarTransmitListener();
		clientThread.invokeLater(() -> client.runScript(args));
	}

	private void loadFriendsChats()
	{
		Widget chatOwner = client.getWidget(InterfaceID.ChatchannelCurrent.CHANNELOWNER);
		Widget chatList = client.getWidget(InterfaceID.ChatchannelCurrent.LIST);
		if (chatList == null || chatOwner == null)
		{
			return;
		}

		chatOwner.setText(RECENT_TITLE);

		int y = 2;
		chatList.setChildren(null);
		for (String chat : Lists.reverse(chats))
		{
			Widget widget = chatList.createChild(-1, WidgetType.TEXT);
			widget.setFontId(494);
			widget.setTextColor(0xffffff);
			widget.setText(chat);
			widget.setOriginalHeight(14);
			widget.setOriginalWidth(142);
			widget.setOriginalY(y);
			widget.setOriginalX(20);
			widget.revalidate();

			y += 14;
		}
	}

	private void updateRecentChat(String s)
	{
		if (Strings.isNullOrEmpty(s))
		{
			return;
		}

		s = Text.toJagexName(s);

		chats.removeIf(s::equalsIgnoreCase);
		chats.add(s);

		while (chats.size() > MAX_CHATS)
		{
			chats.remove(0);
		}

		config.chatsData(Text.toCSV(chats));
	}

	private void confirmKickPlayer(final String kickPlayerName)
	{
		chatboxPanelManager.openTextMenuInput("Attempting to kick: " + kickPlayerName)
			.option("1. Confirm kick", () ->
				clientThread.invoke(() ->
				{
					kickConfirmed = true;
					client.runScript(ScriptID.FRIENDS_CHAT_SEND_KICK, kickPlayerName);
					kickConfirmed = false;
				})
			)
			.option("2. Cancel", Runnables.doNothing())
			.build();
	}

	private void colorIgnoredPlayers(Color ignoreColor)
	{
		Widget chatList = client.getWidget(InterfaceID.ChatchannelCurrent.LIST);
		if (chatList == null || chatList.getChildren() == null)
		{
			return;
		}

		NameableContainer<Ignore> ignoreContainer = client.getIgnoreContainer();
		// Iterate every 3 widgets, since the order of widgets is name, world, icon
		for (int i = 0; i < chatList.getChildren().length; i += 3)
		{
			Widget listWidget = chatList.getChild(i);
			String memberName = listWidget.getText();
			if (memberName.isEmpty() || ignoreContainer.findByName(memberName) == null)
			{
				continue;
			}

			listWidget.setTextColor(ignoreColor.getRGB());
		}
	}

	private void rebuildClanTitle()
	{
		clientThread.invokeLater(() ->
		{
			Widget w = client.getWidget(InterfaceID.ClansSidepanel.UNIVERSE);
			if (w != null)
			{
				client.runScript(w.getOnVarTransmitListener());
			}
		});

		clientThread.invokeLater(() ->
		{
			Widget w = client.getWidget(InterfaceID.ClansGuestSidepanel.UNIVERSE);
			if (w != null)
			{
				client.runScript(w.getOnVarTransmitListener());
			}
		});
	}

	private void updateClanTitle(int widget, ClanChannel channel)
	{
		Widget header = client.getWidget(widget);
		if (header != null && channel != null)
		{
			Widget title = header.getChild(0);
			title.setText(title.getText() + " (" + channel.getMembers().size() + ")");
		}
	}
}
