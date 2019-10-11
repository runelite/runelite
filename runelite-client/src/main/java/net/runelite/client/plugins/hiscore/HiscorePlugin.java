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
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuOpcode;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.api.util.Text;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "HiScore",
	description = "Enable the HiScore panel and an optional Lookup option on players",
	tags = {"panel", "players"},
	loadWhenOutdated = true
)
@Singleton
public class HiscorePlugin extends Plugin
{
	private static final String LOOKUP = "Lookup";
	private static final String KICK_OPTION = "Kick";
	private static final ImmutableList<String> AFTER_OPTIONS = ImmutableList.of("Message", "Add ignore", "Remove friend", KICK_OPTION);
	private static final Pattern BOUNTY_PATTERN = Pattern.compile("<col=ff0000>You've been assigned a target: (.*)</col>");

	// config
	private boolean playerOption;
	private boolean menuOption;
	@Getter(AccessLevel.PACKAGE)
	private boolean virtualLevels;
	private boolean autocomplete;
	private boolean bountyLookup;

	@Inject
	@Nullable
	private Client client;

	@Inject
	private Provider<MenuManager> menuManager;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private HiscoreConfig config;

	@Inject
	private EventBus eventBus;

	private NavigationButton navButton;
	private HiscorePanel hiscorePanel;

	@Inject
	private NameAutocompleter autocompleter;

	@Provides
	HiscoreConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HiscoreConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();
		updateConfig();

		hiscorePanel = injector.getInstance(HiscorePanel.class);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "normal.png");

		navButton = NavigationButton.builder()
			.tooltip("Hiscore")
			.icon(icon)
			.priority(5)
			.panel(hiscorePanel)
			.build();

		clientToolbar.addNavigation(navButton);

		if (this.playerOption && client != null)
		{
			menuManager.get().addPlayerMenuItem(LOOKUP);
		}
		if (this.autocomplete)
		{
			hiscorePanel.addInputKeyListener(autocompleter);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		hiscorePanel.removeInputKeyListener(autocompleter);
		clientToolbar.removeNavigation(navButton);

		if (client != null)
		{
			menuManager.get().removePlayerMenuItem(LOOKUP);
		}
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(PlayerMenuOptionClicked.class, this, this::onPlayerMenuOptionClicked);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
	}

	private void onConfigChanged(ConfigChanged event)
	{

		if (!event.getGroup().equals("hiscore"))
		{
			return;
		}
		updateConfig();
			if (client != null)
			{
				menuManager.get().removePlayerMenuItem(LOOKUP);

				if (this.playerOption)
				{
					menuManager.get().addPlayerMenuItem(LOOKUP);
				}
			}

			if (event.getKey().equals("autocomplete"))
			{
				if (this.autocomplete)
				{
					hiscorePanel.addInputKeyListener(autocompleter);
				}
				else
				{
					hiscorePanel.removeInputKeyListener(autocompleter);
				}
			}
		}


	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!this.menuOption)
		{
			return;
		}

		int groupId = WidgetInfo.TO_GROUP(event.getParam1());
		String option = event.getOption();

		if (groupId == WidgetInfo.FRIENDS_LIST.getGroupId() || groupId == WidgetInfo.CLAN_CHAT.getGroupId() ||
			groupId == WidgetInfo.CHATBOX.getGroupId() && !KICK_OPTION.equals(option) || //prevent from adding for Kick option (interferes with the raiding party one)
			groupId == WidgetInfo.RAIDING_PARTY.getGroupId() || groupId == WidgetInfo.PRIVATE_CHAT_MESSAGE.getGroupId())
		{
			if (!AFTER_OPTIONS.contains(option))
			{
				return;
			}

			final MenuEntry lookup = new MenuEntry();
			lookup.setOption(LOOKUP);
			lookup.setTarget(event.getTarget());
			lookup.setOpcode(MenuOpcode.RUNELITE.getId());
			lookup.setParam0(event.getParam0());
			lookup.setParam1(event.getParam1());
			lookup.setIdentifier(event.getIdentifier());

			if (client != null)
			{
				insertMenuEntry(lookup, client.getMenuEntries());
			}
		}
	}

	private void onPlayerMenuOptionClicked(PlayerMenuOptionClicked event)
	{
		if (event.getMenuOption().equals(LOOKUP))
		{
			lookupPlayer(Text.removeTags(event.getMenuTarget()));
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (!this.bountyLookup || !event.getType().equals(ChatMessageType.GAMEMESSAGE))
		{
			return;
		}

		String message = event.getMessage();
		Matcher m = BOUNTY_PATTERN.matcher(message);
		if (m.matches())
		{
			lookupPlayer(m.group(1));
		}
	}

	private void updateConfig()
	{
		this.playerOption = config.playerOption();
		this.menuOption = config.menuOption();
		this.virtualLevels = config.virtualLevels();
		this.autocomplete = config.autocomplete();
		this.bountyLookup = config.bountyLookup();
	}

	private void insertMenuEntry(MenuEntry newEntry, MenuEntry[] entries)
	{
		MenuEntry[] newMenu = ObjectArrays.concat(entries, newEntry);
		int menuEntryCount = newMenu.length;
		ArrayUtils.swap(newMenu, menuEntryCount - 1, menuEntryCount - 2);
		if (client != null)
		{
			client.setMenuEntries(newMenu);
		}
	}

	private void lookupPlayer(String playerName)
	{
		executor.execute(() ->
		{
			try
			{
				SwingUtilities.invokeAndWait(() ->
				{
					if (!navButton.isSelected())
					{
						navButton.getOnSelect().run();
					}
				});
			}
			catch (InterruptedException | InvocationTargetException e)
			{
				throw new RuntimeException(e);
			}

			hiscorePanel.lookup(playerName);
		});
	}
}
