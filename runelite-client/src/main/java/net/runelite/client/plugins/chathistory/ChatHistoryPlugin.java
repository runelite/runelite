/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2020, Anthony <https://github.com/while-loop>
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
package net.runelite.client.plugins.chathistory;

import com.google.common.collect.EvictingQueue;
import com.google.inject.Provides;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatLineBuffer;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.MessageNode;
import net.runelite.api.ScriptID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.vars.InputType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

@PluginDescriptor(
	name = "Chat History",
	description = "Retain your chat history when logging in/out or world hopping",
	tags = {"chat", "history", "retain", "cycle", "pm"}
)
@Slf4j
public class ChatHistoryPlugin extends Plugin implements KeyListener
{
	private static final String WELCOME_MESSAGE = "Welcome to Old School RuneScape";
	private static final String CLEAR_HISTORY = "Clear history";
	private static final String COPY_TO_CLIPBOARD = "Copy to clipboard";
	private static final String REPORT = "Report";
	private static final int CYCLE_HOTKEY = KeyEvent.VK_TAB;
	private static final int FRIENDS_MAX_SIZE = 5;

	private Queue<MessageNode> messageQueue;
	private Deque<String> friends;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatHistoryConfig config;

	@Inject
	private KeyManager keyManager;

	@Provides
	ChatHistoryConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatHistoryConfig.class);
	}

	@Override
	protected void startUp()
	{
		// The client reuses MessageNodes after 100 chat messages of
		// the same type, so this must be 100 (or maybe a map of
		// size 100 evicting queues)
		messageQueue = EvictingQueue.create(100);
		friends = new ArrayDeque<>(FRIENDS_MAX_SIZE + 1);
		keyManager.registerKeyListener(this);
	}

	@Override
	protected void shutDown()
	{
		messageQueue.clear();
		messageQueue = null;
		friends.clear();
		friends = null;
		keyManager.unregisterKeyListener(this);
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		// Start sending old messages right after the welcome message, as that is most reliable source
		// of information that chat history was reset
		ChatMessageType chatMessageType = chatMessage.getType();
		if (chatMessageType == ChatMessageType.WELCOME && StringUtils.startsWithIgnoreCase(chatMessage.getMessage(), WELCOME_MESSAGE))
		{
			if (!config.retainChatHistory())
			{
				return;
			}

			for (MessageNode queuedMessage : messageQueue)
			{
				final MessageNode node = client.addChatMessage(
					queuedMessage.getType(),
					queuedMessage.getName(),
					queuedMessage.getValue(),
					queuedMessage.getSender(),
					false);
				node.setRuneLiteFormatMessage(queuedMessage.getRuneLiteFormatMessage());
				node.setTimestamp(queuedMessage.getTimestamp());
			}

			return;
		}

		switch (chatMessageType)
		{
			case PRIVATECHATOUT:
			case PRIVATECHAT:
			case MODPRIVATECHAT:
				final String name = Text.removeTags(chatMessage.getName());
				// Remove to ensure uniqueness & its place in history
				if (!friends.remove(name))
				{
					// If the friend didn't previously exist ensure deque capacity doesn't increase by adding them
					if (friends.size() >= FRIENDS_MAX_SIZE)
					{
						friends.remove();
					}
				}
				friends.add(name);
				// intentional fall-through
			case PUBLICCHAT:
			case MODCHAT:
			case FRIENDSCHAT:
			case CLAN_GUEST_CHAT:
			case CLAN_GUEST_MESSAGE:
			case CLAN_CHAT:
			case CLAN_MESSAGE:
			case CLAN_GIM_CHAT:
			case CLAN_GIM_MESSAGE:
			case CONSOLE:
				messageQueue.offer(chatMessage.getMessageNode());
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		final String menuOption = event.getMenuOption();

		// The menu option for clear history is "<col=ffff00>Public:</col> Clear history"
		if (menuOption.endsWith(CLEAR_HISTORY))
		{
			clearChatboxHistory(ChatboxTab.of(event.getParam1()));
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded entry)
	{
		if (entry.getType() != MenuAction.CC_OP.getId() && entry.getType() != MenuAction.CC_OP_LOW_PRIORITY.getId())
		{
			return;
		}

		ChatboxTab tab = ChatboxTab.of(entry.getActionParam1());
		if (tab != null && tab.getAfter() != null && config.clearHistory() && entry.getOption().endsWith(tab.getAfter()))
		{
			final MenuEntry clearEntry = client.createMenuEntry(-2)
					.setType(MenuAction.RUNELITE_HIGH_PRIORITY);
			clearEntry.setParam1(entry.getActionParam1());

			final StringBuilder optionBuilder = new StringBuilder();
			if (tab != ChatboxTab.ALL)
			{
				// Pull tab name from menu since Trade/Group is variable
				String option = entry.getOption();
				int idx = option.indexOf(':');
				if (idx != -1)
				{
					optionBuilder.append(option, 0, idx).append(":</col> ");
				}
			}

			optionBuilder.append(CLEAR_HISTORY);
			clearEntry.setOption(optionBuilder.toString());
			return;
		}

		if (entry.getOption().equals(REPORT) && config.copyToClipboard())
		{
			final int groupId = WidgetUtil.componentToInterface(entry.getActionParam1());
			final int childId = WidgetUtil.componentToId(entry.getActionParam1());

			if (groupId != InterfaceID.CHATBOX)
			{
				return;
			}

			final Widget widget = client.getWidget(groupId, childId);
			final Widget parent = widget.getParent();

			if (InterfaceID.Chatbox.SCROLLAREA != parent.getId())
			{
				return;
			}

			// Get child id of first chat message static child so we can substract this offset to link to dynamic child
			// later
			final int first = WidgetUtil.componentToId(InterfaceID.Chatbox.LINE0);

			// Convert current message static widget id to dynamic widget id of message node with message contents
			// When message is right clicked, we are actually right clicking static widget that contains only sender.
			// The actual message contents are stored in dynamic widgets that follow same order as static widgets.
			// Every first dynamic widget is message sender, every second one is message contents,
			// every third one is clan name and every fourth one is clan rank icon.
			// The last two are hidden when the message is not from a clan chat or guest clan chat.
			final int dynamicChildId = (childId - first) * 4 + 1;

			// Extract and store message contents when menu is opened because dynamic children can change while right click
			// menu is open and dynamicChildId will be outdated
			final Widget messageContents = parent.getChild(dynamicChildId);
			if (messageContents == null)
			{
				return;
			}

			String currentMessage = messageContents.getText();

			client.createMenuEntry(1)
					.setOption(COPY_TO_CLIPBOARD)
					.setTarget(entry.getTarget())
					.setType(MenuAction.RUNELITE)
					.onClick(e ->
					{
						final StringSelection stringSelection = new StringSelection(Text.removeTags(currentMessage));
						Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
					});
		}

	}

	private void clearMessageQueue(ChatboxTab tab)
	{
		if (tab == ChatboxTab.ALL || tab == ChatboxTab.PRIVATE)
		{
			friends.clear();
		}

		messageQueue.removeIf(e -> ArrayUtils.contains(tab.getMessageTypes(), e.getType()));
	}

	private void clearChatboxHistory(ChatboxTab tab)
	{
		if (tab == null)
		{
			return;
		}

		log.debug("Clearing chatbox history for tab {}", tab);

		clearMessageQueue(tab);

		if (tab.getAfter() == null)
		{
			// if the tab has a vanilla Clear option, it isn't necessary to delete the messages ourselves.
			return;
		}

		boolean removed = false;
		for (ChatMessageType msgType : tab.getMessageTypes())
		{
			final ChatLineBuffer lineBuffer = client.getChatLineMap().get(msgType.getType());
			if (lineBuffer == null)
			{
				continue;
			}

			final MessageNode[] lines = lineBuffer.getLines().clone();
			for (final MessageNode line : lines)
			{
				if (line != null)
				{
					lineBuffer.removeMessageNode(line);
					removed = true;
				}
			}
		}

		if (removed)
		{
			// this rebuilds both the chatbox and the pmbox
			clientThread.invoke(() -> client.runScript(ScriptID.SPLITPM_CHANGED));
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() != CYCLE_HOTKEY || !config.pmTargetCycling())
		{
			return;
		}

		if (client.getVarcIntValue(VarClientID.MESLAYERMODE) != InputType.PRIVATE_MESSAGE.getType())
		{
			return;
		}

		clientThread.invoke(() ->
		{
			final String target = findPreviousFriend();
			if (target == null)
			{
				return;
			}

			final String currentMessage = client.getVarcStrValue(VarClientID.MESLAYERINPUT);

			client.runScript(ScriptID.OPEN_PRIVATE_MESSAGE_INTERFACE, target);

			client.setVarcStrValue(VarClientID.MESLAYERINPUT, currentMessage);
			client.runScript(ScriptID.CHAT_TEXT_INPUT_REBUILD, "");
		});
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	private String findPreviousFriend()
	{
		final String currentTarget = client.getVarcStrValue(VarClientID.FRIENDTOMESSAGE);
		if (currentTarget == null || friends.isEmpty())
		{
			return null;
		}

		for (Iterator<String> it = friends.descendingIterator(); it.hasNext(); )
		{
			String friend = it.next();
			if (friend.equals(currentTarget))
			{
				return it.hasNext() ? it.next() : friends.getLast();
			}
		}

		return friends.getLast();
	}
}
