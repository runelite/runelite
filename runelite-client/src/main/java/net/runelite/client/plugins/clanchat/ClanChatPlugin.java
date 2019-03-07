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
package net.runelite.client.plugins.clanchat;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
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
import net.runelite.api.ClanMember;
import net.runelite.api.ClanMemberRank;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.ScriptID;
import net.runelite.api.SpriteID;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ClanChanged;
import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ClanMemberLeft;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ClanManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.ui.JagexColors.CHAT_CLAN_NAME_OPAQUE_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_CLAN_NAME_TRANSPARENT_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_CLAN_TEXT_OPAQUE_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_CLAN_TEXT_TRANSPARENT_BACKGROUND;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Clan Chat",
	description = "Add rank icons to users talking in clan chat",
	tags = {"icons", "rank", "recent"}
)
public class ClanChatPlugin extends Plugin
{
	private static final int MAX_CHATS = 10;
	private static final String CLAN_CHAT_TITLE = "Clan Chat";
	private static final String RECENT_TITLE = "Recent Clan Chats";
	private static final int JOIN_LEAVE_DURATION = 20;
	private static final int MESSAGE_DELAY = 10;

	@Inject
	private Client client;

	@Inject
	private ClanManager clanManager;

	@Inject
	private ClanChatConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private ClientThread clientThread;

	private List<String> chats = new ArrayList<>();
	private List<Player> clanMembers = new ArrayList<>();
	private ClanChatIndicator clanMemberCounter;
	/**
	 * queue of temporary messages added to the client
	 */
	private final Deque<ClanJoinMessage> clanJoinMessages = new ArrayDeque<>();
	private Map<String, ClanMemberActivity> activityBuffer = new HashMap<>();
	private int clanJoinedTick;

	@Provides
	ClanChatConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClanChatConfig.class);
	}

	@Override
	public void startUp()
	{
		chats = new ArrayList<>(Text.fromCSV(config.chatsData()));
	}

	@Override
	public void shutDown()
	{
		clanMembers.clear();
		removeClanCounter();
		resetClanChats();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals("clanchat"))
		{
			if (!config.recentChats())
			{
				resetClanChats();
			}

			if (config.showClanCounter())
			{
				clientThread.invoke(this::addClanCounter);
			}
			else
			{
				removeClanCounter();
			}
		}
	}

	@Subscribe
	public void onClanMemberJoined(ClanMemberJoined event)
	{
		final ClanMember member = event.getMember();

		if (member.getWorld() == client.getWorld())
		{
			final String memberName = Text.toJagexName(member.getUsername());

			for (final Player player : client.getPlayers())
			{
				if (player != null && memberName.equals(Text.toJagexName(player.getName())))
				{
					clanMembers.add(player);
					addClanCounter();
					break;
				}
			}
		}

		// clan members getting initialized isn't relevant
		if (clanJoinedTick == client.getTickCount())
		{
			return;
		}

		if (!config.showJoinLeave() ||
			member.getRank().getValue() < config.joinLeaveRank().getValue())
		{
			return;
		}

		// attempt to filter out world hopping joins
		if (!activityBuffer.containsKey(member.getUsername()))
		{
			ClanMemberActivity joinActivity = new ClanMemberActivity(ClanActivityType.JOINED,
				member, client.getTickCount());
			activityBuffer.put(member.getUsername(), joinActivity);
		}
		else
		{
			activityBuffer.remove(member.getUsername());
		}
	}

	@Subscribe
	public void onClanMemberLeft(ClanMemberLeft event)
	{
		final ClanMember member = event.getMember();

		if (member.getWorld() == client.getWorld())
		{
			final String memberName = Text.toJagexName(member.getUsername());
			final Iterator<Player> each = clanMembers.iterator();

			while (each.hasNext())
			{
				if (memberName.equals(Text.toJagexName(each.next().getName())))
				{
					each.remove();

					if (clanMembers.isEmpty())
					{
						removeClanCounter();
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

		if (!activityBuffer.containsKey(member.getUsername()))
		{
			ClanMemberActivity leaveActivity = new ClanMemberActivity(ClanActivityType.LEFT,
				member, client.getTickCount());
			activityBuffer.put(member.getUsername(), leaveActivity);
		}
		else
		{
			activityBuffer.remove(member.getUsername());
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget clanChatTitleWidget = client.getWidget(WidgetInfo.CLAN_CHAT_TITLE);
		if (clanChatTitleWidget != null)
		{
			Widget clanChatList = client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
			Widget owner = client.getWidget(WidgetInfo.CLAN_CHAT_OWNER);
			if (client.getClanChatCount() > 0)
			{
				clanChatTitleWidget.setText(CLAN_CHAT_TITLE + " (" + client.getClanChatCount() + "/100)");
			}
			else if (config.recentChats() && clanChatList.getChildren() == null && !Strings.isNullOrEmpty(owner.getText()))
			{
				clanChatTitleWidget.setText(RECENT_TITLE);

				loadClanChats();
			}
		}

		if (!config.showJoinLeave())
		{
			return;
		}

		timeoutClanMessages();

		addClanActivityMessages();
	}

	private void timeoutClanMessages()
	{
		if (clanJoinMessages.isEmpty())
		{
			return;
		}

		boolean removed = false;

		for (Iterator<ClanJoinMessage> it = clanJoinMessages.iterator(); it.hasNext(); )
		{
			ClanJoinMessage clanJoinMessage = it.next();
			MessageNode messageNode = clanJoinMessage.getMessageNode();
			final int createdTick = clanJoinMessage.getTick();

			if (client.getTickCount() > createdTick + JOIN_LEAVE_DURATION)
			{
				it.remove();

				// If this message has been reused since, it will get a different id
				if (clanJoinMessage.getGetMessageId() == messageNode.getId())
				{
					ChatLineBuffer ccInfoBuffer = client.getChatLineMap().get(ChatMessageType.CLANCHAT_INFO.getType());
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

	private void addClanActivityMessages()
	{
		Iterator<ClanMemberActivity> activityIt = activityBuffer.values().iterator();

		while (activityIt.hasNext())
		{
			ClanMemberActivity activity = activityIt.next();

			if (activity.getTick() < client.getTickCount() - MESSAGE_DELAY)
			{
				activityIt.remove();
				addActivityMessage(activity.getMember(), activity.getActivityType());
			}
		}
	}

	private void addActivityMessage(ClanMember member, ClanActivityType activityType)
	{
		final String activityMessage = activityType == ClanActivityType.JOINED ? " has joined." : " has left.";
		final ClanMemberRank rank = member.getRank();
		String rankTag = "";
		Color textColor = CHAT_CLAN_TEXT_OPAQUE_BACKGROUND;
		Color channelColor = CHAT_CLAN_NAME_OPAQUE_BACKGROUND;

		if (client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1)
		{
			textColor = CHAT_CLAN_TEXT_TRANSPARENT_BACKGROUND;
			channelColor = CHAT_CLAN_NAME_TRANSPARENT_BACKGROUND;
		}

		if (config.clanChatIcons() && rank != null && rank != ClanMemberRank.UNRANKED)
		{
			int iconNumber = clanManager.getIconNumber(rank);
			rankTag = " <img=" + iconNumber + ">";
		}

		ChatMessageBuilder message = new ChatMessageBuilder();
		String messageString = message
			.append("[")
			.append(ColorUtil.wrapWithColorTag(client.getClanChatName(), channelColor) + rankTag)
			.append("] ")
			.append(ColorUtil.wrapWithColorTag(member.getUsername() + activityMessage, textColor))
			.build();

		client.addChatMessage(ChatMessageType.CLANCHAT_INFO, "", messageString, "");

		final ChatLineBuffer chatLineBuffer = client.getChatLineMap().get(ChatMessageType.CLANCHAT_INFO.getType());
		final MessageNode[] lines = chatLineBuffer.getLines();
		final MessageNode line = lines[0];

		ClanJoinMessage clanJoinMessage = new ClanJoinMessage(line, line.getId(), client.getTickCount());
		clanJoinMessages.addLast(clanJoinMessage);
	}

	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged strChanged)
	{
		if (strChanged.getIndex() == VarClientStr.RECENT_CLAN_CHAT.getIndex() && config.recentChats())
		{
			updateRecentChat(client.getVar(VarClientStr.RECENT_CLAN_CHAT));
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (client.getClanChatCount() <= 0)
		{
			return;
		}

		switch (chatMessage.getType())
		{
			case PRIVATE_MESSAGE_RECEIVED:
			case PRIVATE_MESSAGE_RECEIVED_MOD:
				if (!config.privateMessageIcons())
				{
					return;
				}
				break;
			case PUBLIC:
			case PUBLIC_MOD:
				if (!config.publicChatIcons())
				{
					return;
				}
				break;
			case CLANCHAT:
				if (!config.clanChatIcons())
				{
					return;
				}
				break;
			default:
				return;
		}

		insertClanRankIcon(chatMessage);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged state)
	{
		GameState gameState = state.getGameState();

		if (gameState == GameState.LOGIN_SCREEN || gameState == GameState.CONNECTION_LOST || gameState == GameState.HOPPING)
		{
			clanMembers.clear();
			removeClanCounter();

			clanJoinMessages.clear();
		}
	}

	@Subscribe
	public void onPlayerSpawned(PlayerSpawned event)
	{
		if (event.getPlayer().isClanMember())
		{
			clanMembers.add(event.getPlayer());
			addClanCounter();
		}
	}

	@Subscribe
	public void onPlayerDespawned(PlayerDespawned event)
	{
		if (clanMembers.remove(event.getPlayer()) && clanMembers.isEmpty())
		{
			removeClanCounter();
		}
	}

	@Subscribe
	public void onClanChanged(ClanChanged event)
	{
		if (event.isJoined())
		{
			clanJoinedTick = client.getTickCount();
		}
		else
		{
			clanMembers.clear();
			removeClanCounter();
		}

		activityBuffer.clear();
	}

	int getClanAmount()
	{
		return clanMembers.size();
	}

	private void insertClanRankIcon(final ChatMessage message)
	{
		final ClanMemberRank rank = clanManager.getRank(message.getName());

		if (rank != null && rank != ClanMemberRank.UNRANKED)
		{
			int iconNumber = clanManager.getIconNumber(rank);
			final String img = "<img=" + iconNumber + ">";
			if (message.getType() == ChatMessageType.CLANCHAT)
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

	private void resetClanChats()
	{
		Widget clanChatList = client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
		Widget clanChatTitleWidget = client.getWidget(WidgetInfo.CLAN_CHAT_TITLE);

		if (clanChatList == null)
		{
			return;
		}

		if (client.getClanChatCount() == 0)
		{
			clanChatList.setChildren(null);
		}

		clanChatTitleWidget.setText(CLAN_CHAT_TITLE);
	}

	private void loadClanChats()
	{
		Widget clanChatList = client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
		if (clanChatList == null)
		{
			return;
		}

		int y = 2;
		clanChatList.setChildren(null);
		for (String chat : Lists.reverse(chats))
		{
			Widget widget = clanChatList.createChild(-1, WidgetType.TEXT);
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

	private void removeClanCounter()
	{
		infoBoxManager.removeInfoBox(clanMemberCounter);
		clanMemberCounter = null;
	}

	private void addClanCounter()
	{
		if (!config.showClanCounter() || clanMemberCounter != null || clanMembers.isEmpty())
		{
			return;
		}

		final BufferedImage image = spriteManager.getSprite(SpriteID.TAB_CLAN_CHAT, 0);
		clanMemberCounter = new ClanChatIndicator(image, this);
		infoBoxManager.addInfoBox(clanMemberCounter);
	}
}
