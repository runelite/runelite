/*
 * Copyright (c) 2018, Tanner <https://github.com/Reasel>
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
package net.runelite.client.plugins.walkhere;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

import javax.inject.Inject;

@PluginDescriptor(
	name = "Walk Here Default"
)
public class WalkHerePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private WalkHereConfig config;

	@Inject
	private WalkHereInput inputListener;

	@Inject
	private KeyManager keyManager;

	public boolean shouldClear = false;
	public int curHotkey;

	@Provides
	WalkHereConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WalkHereConfig.class);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !shouldClear)
		{
			return;
		}

		String option = Text.removeTags(event.getOption()).toLowerCase();
		String target = Text.removeTags(event.getTarget()).toLowerCase();

		if (!option.contains("walk"))
		{
			onlyWalkHere();
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		curHotkey = config.hotkey().getHotkey();
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(inputListener);
	}

	private void setDefaultOption(String option)
	{
		MenuEntry[] entries = client.getMenuEntries();
		int index = searchIndex(entries, option);
		if (index != -1)
		{
			MenuEntry newDefault = entries[index];
			entries[index] = entries[entries.length - 1];
			entries[entries.length - 1] = newDefault;
		}
	}

	private int searchIndex(MenuEntry[] entries, String option)
	{
		for (int i = 0; i < entries.length - 1; i++)
		{
			String entryOption = Text.removeTags(entries[i].getOption()).toLowerCase();

			if (entryOption.equals(option))
			{
				return i;
			}
		}
		return -1;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		curHotkey = config.hotkey().getHotkey();
	}

	private void onlyWalkHere()
	{
		MenuEntry[] entries = client.getMenuEntries();
		int idx = searchIndex(entries, "walk here");
		if (idx != -1)
		{
			client.setMenuEntries(new MenuEntry[]{entries[idx]});
		}
	}
}
