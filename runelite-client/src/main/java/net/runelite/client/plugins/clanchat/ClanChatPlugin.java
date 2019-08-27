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
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;
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
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ClanManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.ui.JagexColors.CHAT_CLAN_NAME_OPAQUE_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_CLAN_NAME_TRANSPARENT_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_CLAN_TEXT_OPAQUE_BACKGROUND;
import static net.runelite.client.ui.JagexColors.CHAT_CLAN_TEXT_TRANSPARENT_BACKGROUND;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.api.util.Text;

@PluginDescriptor(
	name = "Clan Chat",
	description = "Add rank icons to users talking in clan chat",
	tags = {"icons", "rank", "recent"}
)
@Singleton
public class ClanChatPlugin extends Plugin
{
	private static final int MAX_CHATS = 20;
	private static final String CLAN_CHAT_TITLE = "CC";
	private static final String RECENT_TITLE = "Recent CCs";
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

	@Inject
	private EventBus eventBus;

	private List<String> chats = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public static CopyOnWriteArrayList<Player> getClanMembers()
	{
		return (CopyOnWriteArrayList<Player>) clanMembers.clone();
	}

	private static final CopyOnWriteArrayList<Player> clanMembers = new CopyOnWriteArrayList<>();
	private ClanChatIndicator clanMemberCounter;
	/**
	 * queue of temporary messages added to the client
	 */
	private final Deque<ClanJoinMessage> clanJoinMessages = new ArrayDeque<>();
	private final Map<String, ClanMemberActivity> activityBuffer = new HashMap<>();
	private int clanJoinedTick;

	private boolean clanChatIcons;
	private boolean recentChats;
	private boolean showClanCounter;
	private String chatsData;
	private boolean showJoinLeave;
	private ClanMemberRank joinLeaveRank;
	private boolean privateMessageIcons;
	private boolean publicChatIcons;
	private boolean clanTabChat;
	private String clanname;

	@Provides
	ClanChatConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClanChatConfig.class);
	}

	@Override
	public void startUp()
	{
		updateConfig();
		addSubscriptions();

		chats = new ArrayList<>(Text.fromCSV(this.chatsData));
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);

		clanMembers.clear();
		removeClanCounter();
		resetClanChats();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ClanMemberJoined.class, this, this::onClanMemberJoined);
		eventBus.subscribe(ClanMemberLeft.class, this, this::onClanMemberLeft);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(VarClientStrChanged.class, this, this::onVarClientStrChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(PlayerSpawned.class, this, this::onPlayerSpawned);
		eventBus.subscribe(PlayerDespawned.class, this, this::onPlayerDespawned);
		eventBus.subscribe(ClanChanged.class, this, this::onClanChanged);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
	}

	private void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals("clanchat"))
		{
			updateConfig();

			if (!this.recentChats)
			{
				resetClanChats();
			}

			if (this.showClanCounter)
			{
				clientThread.invoke(this::addClanCounter);
			}
			else
			{
				removeClanCounter();
			}
		}
	}

	private void onClanMemberJoined(ClanMemberJoined event)
	{
		final ClanMember member = event.getMember();

		if (member.getWorld() == client.getWorld())
		{
			final Player local = client.getLocalPlayer();
			final String memberName = Text.toJagexName(member.getUsername());

			for (final Player player : client.getPlayers())
			{
				if (player != null && player != local && memberName.equals(Text.toJagexName(player.getName())))
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

		if (!this.showJoinLeave ||
			member.getRank().getValue() < this.joinLeaveRank.getValue())
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

	private void onClanMemberLeft(ClanMemberLeft event)
	{
		final ClanMember member = event.getMember();

		if (member.getWorld() == client.getWorld())
		{
			final String memberName = Text.toJagexName(member.getUsername());

			List<Player> toRemove = new ArrayList<>();
			for (Player each : clanMembers)
			{
				if (memberName.equals(Text.toJagexName(each.getName())))
				{
					toRemove.add(each);
					if (clanMembers.isEmpty())
					{
						removeClanCounter();
					}

					break;
				}
			}
			clanMembers.removeAll(toRemove);
		}

		if (!this.showJoinLeave ||
			member.getRank().getValue() < this.joinLeaveRank.getValue())
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

	private void onGameTick(GameTick gameTick)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		client.setVar(VarClientStr.RECENT_CLAN_CHAT, this.clanname);

		Widget clanChatTitleWidget = client.getWidget(WidgetInfo.CLAN_CHAT_TITLE);
		if (clanChatTitleWidget != null)
		{
			Widget clanChatList = client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
			Widget owner = client.getWidget(WidgetInfo.CLAN_CHAT_OWNER);
			if (client.getClanChatCount() > 0)
			{
				clanChatTitleWidget.setText(CLAN_CHAT_TITLE + " (" + client.getClanChatCount() + "/100)");
			}
			else if (this.recentChats && clanChatList.getChildren() == null && !Strings.isNullOrEmpty(owner.getText()))
			{
				clanChatTitleWidget.setText(RECENT_TITLE);

				loadClanChats();
			}
		}

		if (!this.showJoinLeave)
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
		Color textColor = CHAT_CLAN_TEXT_OPAQUE_BACKGROUND;
		Color channelColor = CHAT_CLAN_NAME_OPAQUE_BACKGROUND;
		int rankIcon = -1;

		if (client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1)
		{
			textColor = CHAT_CLAN_TEXT_TRANSPARENT_BACKGROUND;
			channelColor = CHAT_CLAN_NAME_TRANSPARENT_BACKGROUND;
		}

		if (this.clanChatIcons && rank != null && rank != ClanMemberRank.UNRANKED)
		{
			rankIcon = clanManager.getIconNumber(rank);
		}

		ChatMessageBuilder message = new ChatMessageBuilder()
			.append("[")
			.append(channelColor, client.getClanChatName());
		if (rankIcon > -1)
		{
			message
				.append(" ")
				.img(rankIcon);
		}
		message
			.append("] ")
			.append(textColor, member.getUsername() + activityMessage);

		final String messageString = message.build();
		client.addChatMessage(ChatMessageType.FRIENDSCHATNOTIFICATION, "", messageString, "");

		final ChatLineBuffer chatLineBuffer = client.getChatLineMap().get(ChatMessageType.FRIENDSCHATNOTIFICATION.getType());
		final MessageNode[] lines = chatLineBuffer.getLines();
		final MessageNode line = lines[0];

		ClanJoinMessage clanJoinMessage = new ClanJoinMessage(line, line.getId(), client.getTickCount());
		clanJoinMessages.addLast(clanJoinMessage);
	}

	private void onVarClientStrChanged(VarClientStrChanged strChanged)
	{
		if (strChanged.getIndex() == VarClientStr.RECENT_CLAN_CHAT.getIndex() && this.recentChats)
		{
			updateRecentChat(client.getVar(VarClientStr.RECENT_CLAN_CHAT));
		}
	}

	private void onChatMessage(ChatMessage chatMessage)
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
			case PRIVATECHAT:
			case MODPRIVATECHAT:
				if (!this.privateMessageIcons)
				{
					return;
				}
				break;
			case PUBLICCHAT:
			case MODCHAT:
				if (!this.publicChatIcons)
				{
					return;
				}
				break;
			case FRIENDSCHAT:
				if (!this.clanChatIcons)
				{
					return;
				}
				break;
			default:
				return;
		}

		insertClanRankIcon(chatMessage);
	}

	private void onGameStateChanged(GameStateChanged state)
	{
		GameState gameState = state.getGameState();

		if (gameState == GameState.LOGIN_SCREEN || gameState == GameState.CONNECTION_LOST || gameState == GameState.HOPPING)
		{
			clanMembers.clear();
			removeClanCounter();

			clanJoinMessages.clear();
		}
	}

	private void onPlayerSpawned(PlayerSpawned event)
	{
		final Player local = client.getLocalPlayer();
		final Player player = event.getPlayer();

		if (player != null && !player.equals(local) && player.isClanMember())
		{
			clanMembers.add(player);
			addClanCounter();
		}
	}

	private void onPlayerDespawned(PlayerDespawned event)
	{
		if (clanMembers.remove(event.getPlayer()) && clanMembers.isEmpty())
		{
			removeClanCounter();
		}
	}

	private void onClanChanged(ClanChanged event)
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

	private void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		if (!scriptCallbackEvent.getEventName().equalsIgnoreCase("clanchatInput"))
		{
			return;
		}

		final int[] intStack = client.getIntStack();
		final int size = client.getIntStackSize();
		intStack[size - 1] = this.clanTabChat ? 1 : 0;
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

		clanChatList.setScrollHeight(14 * chats.size());
		clanChatList.revalidateScroll();

		int y = 2;
		clanChatList.setChildren(null);
		for (String chat : Lists.reverse(chats))
		{
			Widget widget = clanChatList.createChild(-1, WidgetType.TEXT);
			widget.setFontId(494);
			widget.setHasListener(true);

			widget.setTextColor(0xffffff);
			widget.setText(chat);
			widget.setTextShadowed(true);
			widget.setBorderType(1);
			widget.setAction(0, String.format("Join %s", chat));
			widget.setOnOpListener(ScriptID.CUSTOM_JOIN_CLAN, widget.getText());
			widget.setOriginalHeight(14);
			widget.setOriginalWidth(142);
			widget.setOriginalY(y);
			widget.setOriginalX(20);
			widget.revalidate();

			y += 14;
		}
		clanChatList.revalidateScroll();
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

		String csvText = Text.toCSV(chats);

		config.chatsData(csvText);
		this.chatsData = csvText;
	}

	private void removeClanCounter()
	{
		infoBoxManager.removeInfoBox(clanMemberCounter);
		clanMemberCounter = null;
	}

	private void addClanCounter()
	{
		if (!this.showClanCounter || clanMemberCounter != null || clanMembers.isEmpty())
		{
			return;
		}

		final BufferedImage image = spriteManager.getSprite(SpriteID.TAB_CLAN_CHAT, 0);
		clanMemberCounter = new ClanChatIndicator(image, this);
		infoBoxManager.addInfoBox(clanMemberCounter);
	}

	private void updateConfig()
	{
		this.clanChatIcons = config.clanChatIcons();
		this.recentChats = config.recentChats();
		this.showClanCounter = config.showClanCounter();
		this.chatsData = config.chatsData();
		this.showJoinLeave = config.showJoinLeave();
		this.joinLeaveRank = config.joinLeaveRank();
		this.privateMessageIcons = config.privateMessageIcons();
		this.publicChatIcons = config.publicChatIcons();
		this.clanTabChat = config.clanTabChat();
		this.clanname = config.clanname();
	}
}
