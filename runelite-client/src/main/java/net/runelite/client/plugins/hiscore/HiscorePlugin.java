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
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.util.Text;
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
	private static final ImmutableList<String> BEFORE_OPTIONS = ImmutableList.of("Add friend", "Remove friend", KICK_OPTION);
	private static final ImmutableList<String> AFTER_OPTIONS = ImmutableList.of("Message");

	@Inject
	@Nullable
	private Client client;

	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private MenuManager menuManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private HiscoreConfig config;

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
		hiscorePanel = injector.getInstance(HiscorePanel.class);

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("normal.png"));
		}

		navButton = NavigationButton.builder()
			.tooltip("Hiscore")
			.icon(icon)
			.priority(5)
			.panel(hiscorePanel)
			.build();

		pluginToolbar.addNavigation(navButton);

		if (config.playerOption())
		{
			menuManager.addPlayerMenuItem(LOOKUP);
		}
		if (config.autocomplete())
		{
			hiscorePanel.addInputKeyListener(autocompleter);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		hiscorePanel.removeInputKeyListener(autocompleter);
		pluginToolbar.removeNavigation(navButton);
		menuManager.removePlayerMenuItem(LOOKUP);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("hiscore"))
		{
			menuManager.removePlayerMenuItem(LOOKUP);

			if (config.playerOption())
			{
				menuManager.addPlayerMenuItem(LOOKUP);
			}

			if (event.getKey().equals("autocomplete"))
			{
				if (config.autocomplete())
				{
					hiscorePanel.addInputKeyListener(autocompleter);
				}
				else
				{
					hiscorePanel.removeInputKeyListener(autocompleter);
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

		if (groupId == WidgetInfo.FRIENDS_LIST.getGroupId() || groupId == WidgetInfo.CLAN_CHAT.getGroupId() ||
				groupId == WidgetInfo.CHATBOX.getGroupId() && !KICK_OPTION.equals(option) || //prevent from adding for Kick option (interferes with the raiding party one)
				groupId == WidgetInfo.RAIDING_PARTY.getGroupId() || groupId == WidgetInfo.PRIVATE_CHAT_MESSAGE.getGroupId())
		{
			boolean after;

			if (AFTER_OPTIONS.contains(option))
			{
				after = true;
			}
			else if (BEFORE_OPTIONS.contains(option))
			{
				after = false;
			}
			else
			{
				return;
			}

			final MenuEntry lookup = new MenuEntry();
			lookup.setOption(LOOKUP);
			lookup.setTarget(event.getTarget());
			lookup.setType(MenuAction.RUNELITE.getId());
			lookup.setParam0(event.getActionParam0());
			lookup.setParam1(event.getActionParam1());

			insertMenuEntry(lookup, client.getMenuEntries(), after);
		}
	}

	private void insertMenuEntry(MenuEntry newEntry, MenuEntry[] entries, boolean after)
	{
		MenuEntry[] newMenu = ObjectArrays.concat(entries, newEntry);

		if (after)
		{
			int menuEntryCount = newMenu.length;
			ArrayUtils.swap(newMenu, menuEntryCount - 1, menuEntryCount - 2);
		}

		client.setMenuEntries(newMenu);
	}

	@Subscribe
	public void onLookupMenuClicked(PlayerMenuOptionClicked event)
	{
		if (event.getMenuOption().equals(LOOKUP))
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

				hiscorePanel.lookup(Text.removeTags(event.getMenuTarget()));
			});
		}
	}
}
