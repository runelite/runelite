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
package net.runelite.client.plugins.friendschat;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Runnables;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.ChatLineBuffer;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.FriendsChatManager;
import net.runelite.api.FriendsChatMember;
import net.runelite.api.FriendsChatRank;
import net.runelite.api.GameState;
import net.runelite.api.Ignore;
import net.runelite.api.MessageNode;
import net.runelite.api.NameableContainer;
import net.runelite.api.Player;
import net.runelite.api.ScriptID;
import net.runelite.api.SpriteID;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.FriendsChatChanged;
import net.runelite.api.events.FriendsChatMemberJoined;
import net.runelite.api.events.FriendsChatMemberLeft;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.FriendChatManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.ui.JagexColors.CHAT_FC_NAME_OPAQUE_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_FC_NAME_TRANSPARENT_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_FC_TEXT_OPAQUE_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_FC_TEXT_TRANSPARENT_BACKGROUND;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Friends Chat",
	description = "Add rank icons to users talking in friends chat",
	tags = {"icons", "rank", "recent", "clan"}
)
public class FriendsChatPlugin extends Plugin
{
	private static final int MAX_CHATS = 10;
	private static final String TITLE = "FC";
	private static final String RECENT_TITLE = "Recent FCs";
	private static final int MESSAGE_DELAY = 10;

	@Inject
	private Client client;

	@Inject
	private FriendChatManager friendChatManager;

	@Inject
	private FriendsChatConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ChatColorConfig chatColorConfig;

	private List<String> chats = new ArrayList<>();
	private final List<Player> members = new ArrayList<>();
	private MembersIndicator membersIndicator;
	/**
	 * queue of temporary messages added to the client
	 */
	private final Deque<MemberJoinMessage> joinMessages = new ArrayDeque<>();
	private final Map<String, MemberActivity> activityBuffer = new HashMap<>();
	private int joinedTick;

	private boolean kickConfirmed = false;

	@Provides
	FriendsChatConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FriendsChatConfig.class);
	}

	@Override
	public void startUp()
	{
		chats = new ArrayList<>(Text.fromCSV(config.chatsData()));

		if (config.showIgnores())
		{
			clientThread.invoke(() -> colorIgnoredPlayers(config.showIgnoresColor()));
		}
	}

	@Override
	public void shutDown()
	{
		clientThread.invoke(() -> colorIgnoredPlayers(Color.WHITE));
		members.clear();
		resetCounter();
		resetChats();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals("clanchat"))
		{
			if (!config.recentChats())
			{
				resetChats();
			}

			if (config.showCounter())
			{
				clientThread.invoke(this::addCounter);
			}
			else
			{
				resetCounter();
			}

			Color ignoreColor = config.showIgnores() ? config.showIgnoresColor() : Color.WHITE;
			clientThread.invoke(() -> colorIgnoredPlayers(ignoreColor));
		}
	}

	@Subscribe
	public void onFriendsChatMemberJoined(FriendsChatMemberJoined event)
	{
		final FriendsChatMember member = event.getMember();

		if (member.getWorld() == client.getWorld())
		{
			final Player local = client.getLocalPlayer();
			final String memberName = Text.toJagexName(member.getName());

			for (final Player player : client.getPlayers())
			{
				if (player != null && player != local && memberName.equals(Text.toJagexName(player.getName())))
				{
					members.add(player);
					addCounter();
					break;
				}
			}
		}

		// members getting initialized isn't relevant
		if (joinedTick == client.getTickCount())
		{
			return;
		}

		if (!config.showJoinLeave() ||
			member.getRank().getValue() < config.joinLeaveRank().getValue())
		{
			return;
		}

		// attempt to filter out world hopping joins
		if (!activityBuffer.containsKey(member.getName()))
		{
			MemberActivity joinActivity = new MemberActivity(ActivityType.JOINED,
				member, client.getTickCount());
			activityBuffer.put(member.getName(), joinActivity);
		}
		else
		{
			activityBuffer.remove(member.getName());
		}
	}

	@Subscribe
	public void onFriendsChatMemberLeft(FriendsChatMemberLeft event)
	{
		final FriendsChatMember member = event.getMember();

		if (member.getWorld() == client.getWorld())
		{
			final String memberName = Text.toJagexName(member.getName());
			final Iterator<Player> each = members.iterator();

			while (each.hasNext())
			{
				if (memberName.equals(Text.toJagexName(each.next().getName())))
				{
					each.remove();

					if (members.isEmpty())
					{
						resetCounter();
					}

					break;
				}
			}
		}

		if (!config.showJoinLeave() ||
			member.getRank().getValue() < config.joinLeaveRank().getValue())
		{
			return;
		}

		if (!activityBuffer.containsKey(member.getName()))
		{
			MemberActivity leaveActivity = new MemberActivity(ActivityType.LEFT,
				member, client.getTickCount());
			activityBuffer.put(member.getName(), leaveActivity);
		}
		else
		{
			activityBuffer.remove(member.getName());
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget chatTitleWidget = client.getWidget(WidgetInfo.FRIENDS_CHAT_TITLE);
		if (chatTitleWidget != null)
		{
			Widget chatList = client.getWidget(WidgetInfo.FRIENDS_CHAT_LIST);
			Widget owner = client.getWidget(WidgetInfo.FRIENDS_CHAT_OWNER);
			FriendsChatManager friendsChatManager = client.getFriendsChatManager();
			if (friendsChatManager != null && friendsChatManager.getCount() > 0)
			{
				chatTitleWidget.setText(TITLE + " (" + friendsChatManager.getCount() + "/100)");
			}
			else if (chatList.getChildren() == null && !Strings.isNullOrEmpty(owner.getText()))
			{
				if (config.recentChats())
				{
					chatTitleWidget.setText(RECENT_TITLE);
					loadFriendsChats();
				}
				else
				{
					chatTitleWidget.setText(TITLE);
				}
			}
		}

		if (!config.showJoinLeave())
		{
			return;
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
					ChatLineBuffer ccInfoBuffer = client.getChatLineMap().get(ChatMessageType.FRIENDSCHATNOTIFICATION.getType());
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

	private void addActivityMessages()
	{
		FriendsChatManager friendsChatManager = client.getFriendsChatManager();
		if (friendsChatManager == null || activityBuffer.isEmpty())
		{
			return;
		}

		Iterator<MemberActivity> activityIt = activityBuffer.values().iterator();

		while (activityIt.hasNext())
		{
			MemberActivity activity = activityIt.next();

			if (activity.getTick() < client.getTickCount() - MESSAGE_DELAY)
			{
				activityIt.remove();
				addActivityMessage(friendsChatManager, activity.getMember(), activity.getActivityType());
			}
		}
	}

	private void addActivityMessage(FriendsChatManager friendsChatManager, FriendsChatMember member, ActivityType activityType)
	{
		final String activityMessage = activityType == ActivityType.JOINED ? " has joined." : " has left.";
		final FriendsChatRank rank = member.getRank();
		final Color textColor, channelColor;
		int rankIcon = -1;

		// Use configured friends chat info colors if set, otherwise default to the jagex text and fc name colors
		if (client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1)
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
			rankIcon = friendChatManager.getIconNumber(rank);
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

	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged strChanged)
	{
		if (strChanged.getIndex() == VarClientStr.RECENT_FRIENDS_CHAT.getIndex() && config.recentChats())
		{
			updateRecentChat(client.getVar(VarClientStr.RECENT_FRIENDS_CHAT));
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		FriendsChatManager friendsChatManager = client.getFriendsChatManager();
		if (friendsChatManager == null || friendsChatManager.getCount() == 0)
		{
			return;
		}

		switch (chatMessage.getType())
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

		insertRankIcon(chatMessage);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged state)
	{
		GameState gameState = state.getGameState();

		if (gameState == GameState.LOGIN_SCREEN || gameState == GameState.CONNECTION_LOST || gameState == GameState.HOPPING)
		{
			members.clear();
			resetCounter();

			joinMessages.clear();
		}
	}

	@Subscribe
	public void onPlayerSpawned(PlayerSpawned event)
	{
		final Player local = client.getLocalPlayer();
		final Player player = event.getPlayer();

		if (player != local && player.isFriendsChatMember())
		{
			members.add(player);
			addCounter();
		}
	}

	@Subscribe
	public void onPlayerDespawned(PlayerDespawned event)
	{
		if (members.remove(event.getPlayer()) && members.isEmpty())
		{
			resetCounter();
		}
	}

	@Subscribe
	public void onFriendsChatChanged(FriendsChatChanged event)
	{
		if (event.isJoined())
		{
			joinedTick = client.getTickCount();
		}
		else
		{
			members.clear();
			resetCounter();
		}

		activityBuffer.clear();
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		switch (scriptCallbackEvent.getEventName())
		{
			case "friendsChatInput":
			{
				final int[] intStack = client.getIntStack();
				final int size = client.getIntStackSize();
				// If the user accidentally adds a / when the config and the friends chat chat tab is active, handle it like a normal message
				boolean alterDispatch = config.friendsChatTabChat() && !client.getVar(VarClientStr.CHATBOX_TYPED_TEXT).startsWith("/");
				intStack[size - 1] = alterDispatch ? 1 : 0;
				break;
			}
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
				final String[] stringStack = client.getStringStack();
				final int stringSize = client.getStringStackSize();
				final String kickPlayerName = stringStack[stringSize - 1];

				// Show a chatbox panel confirming the kick
				clientThread.invokeLater(() -> confirmKickPlayer(kickPlayerName));
				break;
			}
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.FRIENDS_CHAT_CHANNEL_REBUILD && config.showIgnores())
		{
			colorIgnoredPlayers(config.showIgnoresColor());
		}
	}

	int getMembersSize()
	{
		return members.size();
	}

	private void insertRankIcon(final ChatMessage message)
	{
		final FriendsChatRank rank = friendChatManager.getRank(message.getName());

		if (rank != null && rank != FriendsChatRank.UNRANKED)
		{
			int iconNumber = friendChatManager.getIconNumber(rank);
			final String img = "<img=" + iconNumber + ">";
			if (message.getType() == ChatMessageType.FRIENDSCHAT)
			{
				message.getMessageNode()
					.setSender(message.getMessageNode().getSender() + " " + img);
			}
			else
			{
				message.getMessageNode()
					.setName(img + message.getMessageNode().getName());
			}
			client.refreshChat();
		}
	}

	private void resetChats()
	{
		Widget chatList = client.getWidget(WidgetInfo.FRIENDS_CHAT_LIST);
		Widget chatTitleWidget = client.getWidget(WidgetInfo.FRIENDS_CHAT_TITLE);

		if (chatList == null)
		{
			return;
		}

		FriendsChatManager friendsChatManager = client.getFriendsChatManager();
		if (friendsChatManager == null || friendsChatManager.getCount() == 0)
		{
			chatList.setChildren(null);
		}

		chatTitleWidget.setText(TITLE);
	}

	private void loadFriendsChats()
	{
		Widget chatList = client.getWidget(WidgetInfo.FRIENDS_CHAT_LIST);
		if (chatList == null)
		{
			return;
		}

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

	private void resetCounter()
	{
		infoBoxManager.removeInfoBox(membersIndicator);
		membersIndicator = null;
	}

	private void addCounter()
	{
		if (!config.showCounter() || membersIndicator != null || members.isEmpty())
		{
			return;
		}

		final BufferedImage image = spriteManager.getSprite(SpriteID.TAB_FRIENDS_CHAT, 0);
		membersIndicator = new MembersIndicator(image, this);
		infoBoxManager.addInfoBox(membersIndicator);
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
			.option("2. Cancel", Runnables::doNothing)
			.build();
	}

	private void colorIgnoredPlayers(Color ignoreColor)
	{
		Widget chatList = client.getWidget(WidgetInfo.FRIENDS_CHAT_LIST);
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
}
