/*
 * Copyright (c) 2018, Connor <contact@connor-parks.email>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.friendlist;

import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ChatPlayer;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.Ignore;
import net.runelite.api.MenuAction;
import net.runelite.api.MessageNode;
import net.runelite.api.NameableContainer;
import net.runelite.api.PendingLogin;
import net.runelite.api.ScriptID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Friend List",
	description = "Add extra information to the friend and ignore lists"
)
@Slf4j
public class FriendListPlugin extends Plugin
{
	private static final int MAX_FRIENDS_P2P = 400;
	private static final int MAX_FRIENDS_F2P = 200;

	private static final int MAX_IGNORES_P2P = 400;
	private static final int MAX_IGNORES_F2P = 100;

	private static final String HIDE_NOTIFICATIONS = "Hide notifications";
	private static final String SHOW_NOTIFICATIONS = "Show notifications";

	@Inject
	private Client client;

	@Inject
	private FriendListConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Provides
	FriendListConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FriendListConfig.class);
	}

	@Override
	protected void shutDown()
	{
		final int world = client.getWorld();
		setFriendsListTitle("Friends List - World " + world);
		setIgnoreListTitle("Ignore List - World " + world);
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.FRIENDS_UPDATE)
		{
			final int world = client.getWorld();
			final boolean isMember = client.getVarpValue(VarPlayerID.ACCOUNT_CREDIT) > 0;
			final NameableContainer<Friend> friendContainer = client.getFriendContainer();
			final int friendCount = friendContainer.getCount();
			if (friendCount >= 0)
			{
				final int limit = isMember ? MAX_FRIENDS_P2P : MAX_FRIENDS_F2P;

				final String title = "Friends - W" +
					world +
					" (" +
					friendCount +
					"/" +
					limit +
					")";

				setFriendsListTitle(title);
			}
		}
		else if (event.getScriptId() == ScriptID.IGNORE_UPDATE)
		{
			final int world = client.getWorld();
			final boolean isMember = client.getVarpValue(VarPlayerID.ACCOUNT_CREDIT) > 0;
			final NameableContainer<Ignore> ignoreContainer = client.getIgnoreContainer();
			final int ignoreCount = ignoreContainer.getCount();
			if (ignoreCount >= 0)
			{
				final int limit = isMember ? MAX_IGNORES_P2P : MAX_IGNORES_F2P;

				final String title = "Ignores - W" +
					world +
					" (" +
					ignoreCount +
					"/" +
					limit +
					")";

				setIgnoreListTitle(title);
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage message)
	{
		if (message.getType() == ChatMessageType.LOGINLOGOUTNOTIFICATION && config.showWorldOnLogin())
		{
			MessageNode messageNode = message.getMessageNode();
			// get the player name out of the notification
			String name = messageNode.getValue()
				.substring(0, messageNode.getValue().indexOf(" "));
			ChatPlayer player = findFriend(name);

			if (player != null && player.getWorld() > 0)
			{
				messageNode
					.setValue(messageNode.getValue() + String.format(" (World %d)", player.getWorld()));
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		final int groupId = WidgetUtil.componentToInterface(event.getActionParam1());

		// Look for "Message" on friends list
		if (groupId == InterfaceID.FRIENDS && event.getOption().equals("Message"))
		{
			String friend = Text.toJagexName(Text.removeTags(event.getTarget()));

			client.createMenuEntry(-1)
				.setOption(isHideNotification(friend) ? SHOW_NOTIFICATIONS : HIDE_NOTIFICATIONS)
				.setType(MenuAction.RUNELITE)
				.setTarget(event.getTarget()) //Preserve color codes here
				.onClick(e ->
				{
					boolean hidden = isHideNotification(friend);
					setHideNotifications(friend, !hidden);
					chatMessageManager.queue(QueuedMessage.builder()
						.type(ChatMessageType.CONSOLE)
						.value("Login notifications for " + friend + " are now " + (hidden ? "shown." : "hidden."))
						.build());
				});
		}
	}

	@Schedule(period = 5, unit = ChronoUnit.SECONDS)
	public void setHideNotifications()
	{
		for (Iterator<PendingLogin> it = client.getFriendContainer().getPendingLogins().iterator(); it.hasNext(); )
		{
			PendingLogin pendingLogin = it.next();
			if (isHideNotification(Text.toJagexName(pendingLogin.getName())))
			{
				log.debug("Removing login notification for {}", pendingLogin.getName());
				it.remove();
			}
		}
	}

	private void setFriendsListTitle(final String title)
	{
		Widget friendListTitleWidget = client.getWidget(InterfaceID.Friends.HEADER);
		if (friendListTitleWidget != null)
		{
			friendListTitleWidget.setText(title);
		}
	}

	private void setIgnoreListTitle(final String title)
	{
		Widget ignoreTitleWidget = client.getWidget(InterfaceID.Ignore.HEADER);
		if (ignoreTitleWidget != null)
		{
			ignoreTitleWidget.setText(title);
		}
	}

	private ChatPlayer findFriend(String name)
	{
		NameableContainer<Friend> friendContainer = client.getFriendContainer();
		if (friendContainer != null)
		{
			String cleanName = Text.removeTags(name);
			return friendContainer.findByName(cleanName);
		}

		return null;
	}

	private void setHideNotifications(String friend, boolean hide)
	{
		if (hide)
		{
			configManager.setConfiguration(FriendListConfig.GROUP, "hidenotification_" + friend, true);
		}
		else
		{
			configManager.unsetConfiguration(FriendListConfig.GROUP, "hidenotification_" + friend);
		}
	}

	private boolean isHideNotification(String friend)
	{
		return configManager.getConfiguration(FriendListConfig.GROUP, "hidenotification_" + friend, Boolean.class) == Boolean.TRUE;
	}
}
