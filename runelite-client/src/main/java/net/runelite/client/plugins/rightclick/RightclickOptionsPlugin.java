/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Bryan Keller <b@bk.gg>
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
package net.runelite.client.plugins.rightclick;

import com.google.common.base.Splitter;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.rightclick.config.MenuHighlightMode;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.WildcardMatcher;

import javax.inject.Inject;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static net.runelite.client.plugins.rightclick.config.MenuHighlightMode.*;

@PluginDescriptor(
	name = "Right-Click Menu",
	description = "Changes the appearance of right-click menus",
	tags = {"rightclick", "examine", "hide", "highlight"},
	enabledByDefault = false
)
public class RightclickOptionsPlugin extends Plugin
{
	// Based on grounditems plugin

	private static final Splitter COMMA_SPLITTER = Splitter
		.on(",")
		.omitEmptyStrings()
		.trimResults();

	private List<String> hiddenItemList = new CopyOnWriteArrayList<>();
	private List<String> highlightedItemsList = new CopyOnWriteArrayList<>();

	@Inject
	private Client client;

	@Inject
	private RightclickOptionsConfig config;

	@Getter
	private Color highlightedColor;

	@Provides
	RightclickOptionsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RightclickOptionsConfig.class);
	}

	@Override
	protected void startUp()
	{
		reset();
	}

	@Override
	protected void shutDown() throws Exception
	{
		hiddenItemList = null;
		highlightedItemsList = null;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("rightclick"))
		{
			reset();
		}
	}

	private void reset()
	{
		// gets the hidden items from the text box in the config
		hiddenItemList = COMMA_SPLITTER.splitToList(config.getHiddenItems());

		// gets the highlighted items from the text box in the config
		highlightedItemsList = COMMA_SPLITTER.splitToList(config.getHighlightedRightclickItems());

		highlightedColor = config.highlightedColor();
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		MenuEntry[] menuEntries = client.getMenuEntries();
		MenuEntry lastEntry = menuEntries[menuEntries.length - 1];

		if (matchesPatterns(event.getOption(), event.getTarget(), hiddenItemList))
		{
			if (menuEntries.length > 1)
			{
				MenuEntry[] newEntries = Arrays.copyOfRange(menuEntries, 0, menuEntries.length - 1);
				client.setMenuEntries(newEntries);
			}
			else
			{
				client.setMenuEntries(new MenuEntry[]{});
			}
		}
		else if (highlightedColor != null &&
			matchesPatterns(event.getOption(), event.getTarget(), highlightedItemsList))
		{
			final MenuHighlightMode mode = config.menuHighlightMode();

			if (mode == BOTH || mode == OPTION)
			{
				lastEntry.setOption(ColorUtil.prependColorTag(lastEntry.getOption(), highlightedColor));
			}

			if (mode == BOTH || mode == NAME)
			{
				String target = lastEntry.getTarget().substring(lastEntry.getTarget().indexOf(">") + 1);
				lastEntry.setTarget(ColorUtil.prependColorTag(target, highlightedColor));
			}
			client.setMenuEntries(menuEntries);
		}

	}

	boolean matchesPatterns(String action, String target, List<String> patterns)
	{
		for (String pattern : patterns)
		{
			if (WildcardMatcher.matches(pattern, action) ||
				WildcardMatcher.matches(pattern, target) ||
				WildcardMatcher.matches(pattern, action + " " + target))
			{
				return true;
			}
		}
		return false;
	}

}
