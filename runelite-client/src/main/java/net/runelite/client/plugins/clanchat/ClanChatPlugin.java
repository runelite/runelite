package net.runelite.client.plugins.clanchat;

import net.runelite.client.plugins.*;
import net.runelite.client.game.*;
import net.runelite.client.callback.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import net.runelite.client.config.*;
import com.google.inject.*;
import net.runelite.client.util.*;
import net.runelite.client.eventbus.*;
import com.google.common.base.*;
import net.runelite.api.widgets.*;
import net.runelite.client.ui.*;
import net.runelite.client.chat.*;
import java.awt.*;
import net.runelite.api.*;
import net.runelite.api.events.*;
import com.google.common.collect.*;
import java.util.*;
import java.util.function.*;
import net.runelite.client.ui.overlay.infobox.*;
import java.awt.image.*;

@PluginDescriptor(name = "Clan Chat", description = "Add rank icons to users talking in clan chat", tags = { "icons", "rank", "recent" })
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
	private List<String> chats;
	private static CopyOnWriteArrayList<Player> clanMembers;
	private ClanChatIndicator clanMemberCounter;
	private final Deque<ClanJoinMessage> clanJoinMessages;
	private Map<String, ClanMemberActivity> activityBuffer;
	private int clanJoinedTick;

	public ClanChatPlugin() {
		this.chats = new ArrayList<String>();
		this.clanJoinMessages = new ArrayDeque<ClanJoinMessage>();
		this.activityBuffer = new HashMap<String, ClanMemberActivity>();
	}

	public static CopyOnWriteArrayList<Player> getClanMembers() {
		return (CopyOnWriteArrayList<Player>)ClanChatPlugin.clanMembers.clone();
	}

	@Provides
	ClanChatConfig getConfig(final ConfigManager configManager) {
		return configManager.getConfig(ClanChatConfig.class);
	}

	public void startUp() {
		this.chats = new ArrayList<String>(Text.fromCSV(this.config.chatsData()));
	}

	public void shutDown() {
		ClanChatPlugin.clanMembers.clear();
		this.removeClanCounter();
		this.resetClanChats();
	}

	@Subscribe
	public void onConfigChanged(final ConfigChanged configChanged) {
		if (configChanged.getGroup().equals("clanchat")) {
			if (!this.config.recentChats()) {
				this.resetClanChats();
			}
			if (this.config.showClanCounter()) {
				this.clientThread.invoke(this::addClanCounter);
			}
			else {
				this.removeClanCounter();
			}
		}
	}

    @Subscribe
    public void onClanMemberJoined(ClanMemberJoined event)
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

		if (this.clanJoinedTick == this.client.getTickCount()) {
			return;
		}
		if (!this.config.showJoinLeave() || member.getRank().getValue() < this.config.joinLeaveRank().getValue()) {
			return;
		}
		if (!this.activityBuffer.containsKey(member.getUsername())) {
			final ClanMemberActivity joinActivity = new ClanMemberActivity(ClanActivityType.JOINED, member, this.client.getTickCount());
			this.activityBuffer.put(member.getUsername(), joinActivity);
		}
		else {
			this.activityBuffer.remove(member.getUsername());
		}
	}

	@Subscribe
	public void onClanMemberLeft(final ClanMemberLeft event) {
		final ClanMember member = event.getMember();
		if (member.getWorld() == this.client.getWorld()) {
			final String memberName = Text.toJagexName(member.getUsername());
			final Iterator<Player> each = ClanChatPlugin.clanMembers.iterator();
			while (each.hasNext()) {
				if (memberName.equals(Text.toJagexName(each.next().getName()))) {
					each.remove();
					if (ClanChatPlugin.clanMembers.isEmpty()) {
						this.removeClanCounter();
						break;
					}
					break;
				}
			}
		}
		if (!this.config.showJoinLeave() || member.getRank().getValue() < this.config.joinLeaveRank().getValue()) {
			return;
		}
		if (!this.activityBuffer.containsKey(member.getUsername())) {
			final ClanMemberActivity leaveActivity = new ClanMemberActivity(ClanActivityType.LEFT, member, this.client.getTickCount());
			this.activityBuffer.put(member.getUsername(), leaveActivity);
		}
		else {
			this.activityBuffer.remove(member.getUsername());
		}
	}

	@Subscribe
	public void onGameTick(final GameTick gameTick) {
		if (this.client.getGameState() != GameState.LOGGED_IN) {
			return;
		}
		final Widget clanChatTitleWidget = this.client.getWidget(WidgetInfo.CLAN_CHAT_TITLE);
		if (clanChatTitleWidget != null) {
			final Widget clanChatList = this.client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
			final Widget owner = this.client.getWidget(WidgetInfo.CLAN_CHAT_OWNER);
			if (this.client.getClanChatCount() > 0) {
				clanChatTitleWidget.setText("Clan Chat (" + this.client.getClanChatCount() + "/100)");
			}
			else if (this.config.recentChats() && clanChatList.getChildren() == null && !Strings.isNullOrEmpty(owner.getText())) {
				clanChatTitleWidget.setText("Recent Clan Chats");
				this.loadClanChats();
			}
		}
		if (!this.config.showJoinLeave()) {
			return;
		}
		this.timeoutClanMessages();
		this.addClanActivityMessages();
	}

	private void timeoutClanMessages() {
		if (this.clanJoinMessages.isEmpty()) {
			return;
		}
		boolean removed = false;
		final Iterator<ClanJoinMessage> it = this.clanJoinMessages.iterator();
		while (it.hasNext()) {
			final ClanJoinMessage clanJoinMessage = it.next();
			final MessageNode messageNode = clanJoinMessage.getMessageNode();
			final int createdTick = clanJoinMessage.getTick();
			if (this.client.getTickCount() <= createdTick + 20) {
				break;
			}
			it.remove();
			if (clanJoinMessage.getGetMessageId() != messageNode.getId()) {
				continue;
			}
			final ChatLineBuffer ccInfoBuffer = this.client.getChatLineMap().get(ChatMessageType.FRIENDSCHATNOTIFICATION.getType());
			if (ccInfoBuffer == null) {
				continue;
			}
			ccInfoBuffer.removeMessageNode(messageNode);
			removed = true;
		}
		if (removed) {
			this.clientThread.invoke(() -> this.client.runScript(216, new Object[0]));
		}
	}

	private void addClanActivityMessages() {
		final Iterator<ClanMemberActivity> activityIt = this.activityBuffer.values().iterator();
		while (activityIt.hasNext()) {
			final ClanMemberActivity activity = activityIt.next();
			if (activity.getTick() < this.client.getTickCount() - 10) {
				activityIt.remove();
				this.addActivityMessage(activity.getMember(), activity.getActivityType());
			}
		}
	}

	private void addActivityMessage(final ClanMember member, final ClanActivityType activityType) {
		final String activityMessage = (activityType == ClanActivityType.JOINED) ? " has joined." : " has left.";
		final ClanMemberRank rank = member.getRank();
		Color textColor = JagexColors.CHAT_CLAN_TEXT_OPAQUE_BACKGROUND;
		Color channelColor = JagexColors.CHAT_CLAN_NAME_OPAQUE_BACKGROUND;
		int rankIcon = -1;
		if (this.client.isResized() && this.client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1) {
			textColor = JagexColors.CHAT_CLAN_TEXT_TRANSPARENT_BACKGROUND;
			channelColor = JagexColors.CHAT_CLAN_NAME_TRANSPARENT_BACKGROUND;
		}
		if (this.config.clanChatIcons() && rank != null && rank != ClanMemberRank.UNRANKED) {
			rankIcon = this.clanManager.getIconNumber(rank);
		}
		final ChatMessageBuilder message = new ChatMessageBuilder().append("[").append(channelColor, this.client.getClanChatName());
		if (rankIcon > -1) {
			message.append(" ").img(rankIcon);
		}
		message.append("] ").append(textColor, member.getUsername() + activityMessage);
		final String messageString = message.build();
		this.client.addChatMessage(ChatMessageType.FRIENDSCHATNOTIFICATION, "", messageString, "");
		final ChatLineBuffer chatLineBuffer = this.client.getChatLineMap().get(ChatMessageType.FRIENDSCHATNOTIFICATION.getType());
		final MessageNode[] lines = chatLineBuffer.getLines();
		final MessageNode line = lines[0];
		final ClanJoinMessage clanJoinMessage = new ClanJoinMessage(line, line.getId(), this.client.getTickCount());
		this.clanJoinMessages.addLast(clanJoinMessage);
	}

	@Subscribe
	public void onVarClientStrChanged(final VarClientStrChanged strChanged) {
		if (strChanged.getIndex() == VarClientStr.RECENT_CLAN_CHAT.getIndex() && this.config.recentChats()) {
			this.updateRecentChat(this.client.getVar(VarClientStr.RECENT_CLAN_CHAT));
		}
	}

	@Subscribe
	public void onChatMessage(final ChatMessage chatMessage) {
		if (this.client.getGameState() != GameState.LOADING && this.client.getGameState() != GameState.LOGGED_IN) {
			return;
		}
		if (this.client.getClanChatCount() <= 0) {
			return;
		}
		switch (chatMessage.getType()) {
			case PRIVATECHAT:
			case MODPRIVATECHAT: {
				if (!this.config.privateMessageIcons()) {
					return;
				}
				break;
			}
			case PUBLICCHAT:
			case MODCHAT: {
				if (!this.config.publicChatIcons()) {
					return;
				}
				break;
			}
			case FRIENDSCHAT: {
				if (!this.config.clanChatIcons()) {
					return;
				}
				break;
			}
			default: {
				return;
			}
		}
		this.insertClanRankIcon(chatMessage);
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged state) {
		final GameState gameState = state.getGameState();
		if (gameState == GameState.LOGIN_SCREEN || gameState == GameState.CONNECTION_LOST || gameState == GameState.HOPPING) {
			ClanChatPlugin.clanMembers.clear();
			this.removeClanCounter();
			this.clanJoinMessages.clear();
		}
	}

    @Subscribe
    public void onPlayerSpawned(PlayerSpawned event)
    {
        final Player local = client.getLocalPlayer();
        final Player player = event.getPlayer();

        if (player != local && player.isClanMember())
        {
            clanMembers.add(player);
            addClanCounter();
        }
    }

	@Subscribe
	public void onPlayerDespawned(final PlayerDespawned event) {
		if (ClanChatPlugin.clanMembers.remove(event.getPlayer()) && ClanChatPlugin.clanMembers.isEmpty()) {
			this.removeClanCounter();
		}
	}

	@Subscribe
	public void onClanChanged(final ClanChanged event) {
		if (event.isJoined()) {
			this.clanJoinedTick = this.client.getTickCount();
		}
		else {
			ClanChatPlugin.clanMembers.clear();
			this.removeClanCounter();
		}
		this.activityBuffer.clear();
	}

	int getClanAmount() {
		return ClanChatPlugin.clanMembers.size();
	}

	private void insertClanRankIcon(final ChatMessage message) {
		final ClanMemberRank rank = this.clanManager.getRank(message.getName());
		if (rank != null && rank != ClanMemberRank.UNRANKED) {
			final int iconNumber = this.clanManager.getIconNumber(rank);
			final String img = "<img=" + iconNumber + ">";
			if (message.getType() == ChatMessageType.FRIENDSCHAT) {
				message.getMessageNode().setSender(message.getMessageNode().getSender() + " " + img);
			}
			else {
				message.getMessageNode().setName(img + message.getMessageNode().getName());
			}
			this.client.refreshChat();
		}
	}

	private void resetClanChats() {
		final Widget clanChatList = this.client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
		final Widget clanChatTitleWidget = this.client.getWidget(WidgetInfo.CLAN_CHAT_TITLE);
		if (clanChatList == null) {
			return;
		}
		if (this.client.getClanChatCount() == 0) {
			clanChatList.setChildren(null);
		}
		clanChatTitleWidget.setText("Clan Chat");
	}

	private void loadClanChats() {
		final Widget clanChatList = this.client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
		if (clanChatList == null) {
			return;
		}
		int y = 2;
		clanChatList.setChildren(null);
		for (final String chat : Lists.reverse(this.chats)) {
			final Widget widget = clanChatList.createChild(-1, 4);
			widget.setFontId(494);
			widget.setTextColor(16777215);
			widget.setText(chat);
			widget.setOriginalHeight(14);
			widget.setOriginalWidth(142);
			widget.setOriginalY(y);
			widget.setOriginalX(20);
			widget.revalidate();
			y += 14;
		}
	}

	private void updateRecentChat(String s) {
		if (Strings.isNullOrEmpty(s)) {
			return;
		}
		s = Text.toJagexName(s);
		final List<String> chats = this.chats;
		final String s2 = s;
		Objects.requireNonNull(s2);
		chats.removeIf(s2::equalsIgnoreCase);
		this.chats.add(s);
		while (this.chats.size() > 10) {
			this.chats.remove(0);
		}
		this.config.chatsData(Text.toCSV(this.chats));
	}

	private void removeClanCounter() {
		this.infoBoxManager.removeInfoBox(this.clanMemberCounter);
		this.clanMemberCounter = null;
	}

	private void addClanCounter() {
		if (!this.config.showClanCounter() || this.clanMemberCounter != null || ClanChatPlugin.clanMembers.isEmpty()) {
			return;
		}
		final BufferedImage image = this.spriteManager.getSprite(904, 0);
		this.clanMemberCounter = new ClanChatIndicator(image, this);
		this.infoBoxManager.addInfoBox(this.clanMemberCounter);
	}

	static {
		ClanChatPlugin.clanMembers = new CopyOnWriteArrayList<Player>();
	}
}
