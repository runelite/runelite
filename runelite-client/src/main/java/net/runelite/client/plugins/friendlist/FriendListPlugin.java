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

import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Friend List",
	description = "Add extra information to the friend and ignore lists"
)
@Singleton
public class FriendListPlugin extends Plugin
{
	private static final int MAX_FRIENDS_P2P = 400;
	private static final int MAX_FRIENDS_F2P = 200;

	private static final int MAX_IGNORES_P2P = 400;
	private static final int MAX_IGNORES_F2P = 100;

	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Override
	protected void startUp() throws Exception
	{
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		final int world = client.getWorld();
		setFriendsListTitle("Friends List - World " + world);
		setIgnoreListTitle("Ignore List - World " + world);
	}

	private void onGameTick(GameTick tick)
	{
		final int world = client.getWorld();
		final boolean isMember = client.getVar(VarPlayer.MEMBERSHIP_DAYS) > 0;

		final int friendCount = client.getFriendsCount();
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

		final int ignoreCount = client.getIgnoreCount();
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

	private void setFriendsListTitle(final String title)
	{
		Widget friendListTitleWidget = client.getWidget(WidgetInfo.FRIEND_CHAT_TITLE);
		if (friendListTitleWidget != null)
		{
			friendListTitleWidget.setText(title);
		}
	}

	private void setIgnoreListTitle(final String title)
	{
		Widget ignoreTitleWidget = client.getWidget(WidgetInfo.IGNORE_TITLE);
		if (ignoreTitleWidget != null)
		{
			ignoreTitleWidget.setText(title);
		}
	}
}
