/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.hiscore;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectArrays;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.EnumSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.SwingUtilities;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.IconID;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.WorldType;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "HiScore",
	description = "Enable the HiScore panel and an optional Lookup option on players",
	tags = {"panel", "players"},
	loadWhenOutdated = true
)
public class HiscorePlugin extends Plugin
{
	private static final String LOOKUP = "Lookup";
	private static final String KICK_OPTION = "Kick";
	private static final ImmutableList<String> AFTER_OPTIONS = ImmutableList.of("Message", "Add ignore", "Remove friend", "Delete", KICK_OPTION);
	private static final Pattern BOUNTY_PATTERN = Pattern.compile("<col=ff0000>You've been assigned a target: (.*)</col>");

	@Inject
	@Nullable
	private Client client;

	@Inject
	private Provider<MenuManager> menuManager;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private HiscoreConfig config;

	private NavigationButton navButton;
	private HiscorePanel hiscorePanel;

	@Getter
	private HiscoreEndpoint localHiscoreEndpoint;

	@Provides
	HiscoreConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HiscoreConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		hiscorePanel = injector.getInstance(HiscorePanel.class);

		final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "normal.png");

		navButton = NavigationButton.builder()
			.tooltip("Hiscore")
			.icon(icon)
			.priority(5)
			.panel(hiscorePanel)
			.build();

		clientToolbar.addNavigation(navButton);

		if (config.playerOption() && client != null)
		{
			menuManager.get().addPlayerMenuItem(LOOKUP);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		hiscorePanel.shutdown();
		clientToolbar.removeNavigation(navButton);

		if (client != null)
		{
			menuManager.get().removePlayerMenuItem(LOOKUP);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("hiscore"))
		{
			if (client != null)
			{
				menuManager.get().removePlayerMenuItem(LOOKUP);

				if (config.playerOption())
				{
					menuManager.get().addPlayerMenuItem(LOOKUP);
				}
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!config.menuOption())
		{
			return;
		}

		int groupId = WidgetInfo.TO_GROUP(event.getActionParam1());
		String option = event.getOption();

		if (groupId == WidgetInfo.FRIENDS_LIST.getGroupId() || groupId == WidgetInfo.FRIENDS_CHAT.getGroupId() ||
				groupId == WidgetInfo.CHATBOX.getGroupId() && !KICK_OPTION.equals(option) || //prevent from adding for Kick option (interferes with the raiding party one)
				groupId == WidgetInfo.RAIDING_PARTY.getGroupId() || groupId == WidgetInfo.PRIVATE_CHAT_MESSAGE.getGroupId() ||
				groupId == WidgetInfo.IGNORE_LIST.getGroupId())
		{
			if (!AFTER_OPTIONS.contains(option) || (option.equals("Delete") && groupId != WidgetInfo.IGNORE_LIST.getGroupId()))
			{
				return;
			}

			final MenuEntry lookup = new MenuEntry();
			lookup.setOption(LOOKUP);
			lookup.setTarget(event.getTarget());
			lookup.setType(MenuAction.RUNELITE.getId());
			lookup.setParam0(event.getActionParam0());
			lookup.setParam1(event.getActionParam1());
			lookup.setIdentifier(event.getIdentifier());

			insertMenuEntry(lookup, client.getMenuEntries());
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if ((event.getMenuAction() == MenuAction.RUNELITE || event.getMenuAction() == MenuAction.RUNELITE_PLAYER)
			&& event.getMenuOption().equals(LOOKUP))
		{
			final String target;
			HiscoreEndpoint endpoint = HiscoreEndpoint.NORMAL;
			if (event.getMenuAction() == MenuAction.RUNELITE_PLAYER)
			{
				// The player id is included in the event, so we can use that to get the player name,
				// which avoids having to parse out the combat level and any icons preceding the name.
				Player player = client.getCachedPlayers()[event.getId()];
				if (player == null)
				{
					return;
				}

				target = player.getName();
			}
			else
			{
				// Determine proper endpoint from player name.
				// TODO: look at target's world and determine if tournament/dmm endpoint should be used instead.
				endpoint = findHiscoreEndpointFromPlayerName(event.getMenuTarget());
				target = Text.removeTags(event.getMenuTarget());
			}

			lookupPlayer(target, endpoint);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (!config.bountylookup() || !event.getType().equals(ChatMessageType.GAMEMESSAGE))
		{
			return;
		}

		String message = event.getMessage();
		Matcher m = BOUNTY_PATTERN.matcher(message);
		if (m.matches())
		{
			lookupPlayer(m.group(1), HiscoreEndpoint.NORMAL);
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		localHiscoreEndpoint = findHiscoreEndpointFromLocalPlayer();
	}

	private void insertMenuEntry(MenuEntry newEntry, MenuEntry[] entries)
	{
		MenuEntry[] newMenu = ObjectArrays.concat(entries, newEntry);
		int menuEntryCount = newMenu.length;
		ArrayUtils.swap(newMenu, menuEntryCount - 1, menuEntryCount - 2);
		client.setMenuEntries(newMenu);
	}

	private void lookupPlayer(String playerName, HiscoreEndpoint endpoint)
	{
		SwingUtilities.invokeLater(() ->
		{
			if (!navButton.isSelected())
			{
				navButton.getOnSelect().run();
			}
			hiscorePanel.lookup(playerName, endpoint);
		});
	}

	HiscoreEndpoint getWorldEndpoint()
	{
		if (client != null)
		{
			EnumSet<WorldType> wTypes = client.getWorldType();

			if (wTypes.contains(WorldType.DEADMAN_TOURNAMENT))
			{
				return HiscoreEndpoint.TOURNAMENT;
			}
			else if (wTypes.contains(WorldType.DEADMAN))
			{
				return HiscoreEndpoint.DEADMAN;
			}
			else if (wTypes.contains(WorldType.LEAGUE))
			{
				return HiscoreEndpoint.LEAGUE;
			}
		}
		return HiscoreEndpoint.NORMAL;
	}

	private HiscoreEndpoint findHiscoreEndpointFromLocalPlayer()
	{
		final HiscoreEndpoint profile = getWorldEndpoint();
		if (profile != HiscoreEndpoint.NORMAL)
		{
			return profile;
		}

		if (client != null)
		{
			switch (client.getAccountType())
			{
				case IRONMAN:
					return HiscoreEndpoint.IRONMAN;
				case ULTIMATE_IRONMAN:
					return HiscoreEndpoint.ULTIMATE_IRONMAN;
				case HARDCORE_IRONMAN:
					return HiscoreEndpoint.HARDCORE_IRONMAN;
			}
		}
		return HiscoreEndpoint.NORMAL;
	}

	private HiscoreEndpoint findHiscoreEndpointFromPlayerName(String name)
	{
		if (name.contains(IconID.IRONMAN.toString()))
		{
			return HiscoreEndpoint.IRONMAN;
		}
		if (name.contains(IconID.ULTIMATE_IRONMAN.toString()))
		{
			return HiscoreEndpoint.ULTIMATE_IRONMAN;
		}
		if (name.contains(IconID.HARDCORE_IRONMAN.toString()))
		{
			return HiscoreEndpoint.HARDCORE_IRONMAN;
		}
		if (name.contains(IconID.LEAGUE.toString()))
		{
			return HiscoreEndpoint.LEAGUE;
		}
		return HiscoreEndpoint.NORMAL;
	}
}
