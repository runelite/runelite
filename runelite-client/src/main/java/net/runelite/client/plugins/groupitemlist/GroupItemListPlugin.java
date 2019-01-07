/*
 * Copyright (c) 2019, Ricky <https://github.com/RickyLoader>
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
package net.runelite.client.plugins.groupitemlist;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@PluginDescriptor(
	name = "Group Item List",
	description = "Group the right click menu of a pile of items.",
	tags = {"ground", "compress", "pile", "group"},
	enabledByDefault = false
)

/**
 * Main class of plugin - Groups duplicate right click menu options to singular entries with a quantity.
 */
public class GroupItemListPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private GroupItemListConfig config;

	@Provides
	GroupItemListConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroupItemListConfig.class);
	}

	/**
	 * Fired on a right click menu opening. Count all menu entries and build a new list of entries
	 * displaying item quantities.
	 *
	 * @param menu Right click menu opened
	 */
	@Subscribe
	public void onMenuOpened(MenuOpened menu)
	{
		LinkedHashMap<MenuEntry, GroupedItem> entryCount = new LinkedHashMap<>();
		ArrayList<MenuEntry> temp = new ArrayList<>();
		MenuEntry[] updatedMenuEntries;

		// Iterate over menu entries
		for (MenuEntry e : menu.getMenuEntries())
		{

			// Increment the count if entry has been seen before and refers to an item
			if (entryCount.containsKey(e) && isItem(e))
			{
				entryCount.get(e).incrementCount();
			}

			// Store in map if entry has not been seen before
			else
			{
				entryCount.put(e,
					new GroupedItem(e, config.getPositionConfig(), config.getStyleConfig(), config.includeX())
				);
			}
		}

		// Create a list of updated menu entries from the map of GroupedItem
		for (MenuEntry e : entryCount.keySet())
		{
			MenuEntry entry = entryCount.get(e).getEntry();
			temp.add(entry);
		}

		// Parse to an array and set the new menu entries
		updatedMenuEntries = temp.toArray(new MenuEntry[0]);
		client.setMenuEntries(updatedMenuEntries);
	}

	/**
	 * Tests whether a menu entry refers to an item.
	 *
	 * @param e MenuEntry to be tested
	 * @return boolean result
	 */
	private boolean isItem(MenuEntry e)
	{
		String option = e.getOption();
		return option.equals("Take") || option.equals("Examine");
	}
}
