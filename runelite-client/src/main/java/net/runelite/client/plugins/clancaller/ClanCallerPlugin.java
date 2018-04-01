/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.clancaller;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;

@PluginDescriptor(
	name = "Clan Caller"
)
public class ClanCallerPlugin extends Plugin
{
	private final static Pattern RUNESCAPE_NAME = Pattern.compile("<col=ffffff>(.+?)<col=");

	private List<String> sniperList = new ArrayList<>();

	private List<String> callerList = new ArrayList<>();

	private List<MenuEntry> menuEntries = new ArrayList<>();

	private List<String> targets = new ArrayList<>();

	@Getter
	private List<Player> callers = new ArrayList<>();

	@Getter
	private List<Player> snipers = new ArrayList<>();

	@Inject
	private Client client;

	@Inject
	private ClanCallerConfig config;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ClanCallerOverlay overlay;

	@Inject
	private SniperOverlay sniperOverlay;

	@Provides
	ClanCallerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClanCallerConfig.class);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, sniperOverlay);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateLists();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getKey().equals("getCallers") || event.getKey().equals("getSnipers"))
		{
			updateLists();
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!config.recolorMenu() || targets.size() == 0)
		{
			return;
		}

		//Only change color on the Attack/Cast option
		if (event.getOption().equals("Follow") || event.getOption().equals("Cast"))
		{
			String entryTarget = event.getTarget().toLowerCase().replaceAll("\\u00a0", " ");

			//the menu target equals <col=00ff00>Water Blast<col=ffffff> -> <col=ffffff>Good Praxis<col=ff00>  (level-4) so we use regex to split it
			if (event.getOption().equals("Cast"))
			{
				entryTarget = entryTarget.split("->")[1];
			}

			Matcher m = RUNESCAPE_NAME.matcher(entryTarget);
			if (m.find())
			{
				entryTarget = m.group(1);
			}

			// Check if the exact RSN matches up.
			if (targets.contains(entryTarget))
			{
				recolorTarget(event.getOption(), event.getTarget());
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		targets.clear();
		callers.clear();
		snipers.clear();

		if (config.getCallers().equals("") && config.getSnipers().equals(""))
		{
			return;
		}

		for (Player player : client.getPlayers())
		{
			if (sniperList.contains(player.getName().toLowerCase()))
			{
				snipers.add(player);
			}

			if (callerList.contains(player.getName().toLowerCase()))
			{
				callers.add(player);

				if (player.getInteracting() != null)
				{
					targets.add(player.getInteracting().getName().toLowerCase());
				}
			}
		}
	}
	private void updateLists()
	{
		sniperList = Arrays.asList(config.getSnipers().toLowerCase().split("\\s*,\\s*"));
		callerList = Arrays.asList(config.getCallers().toLowerCase().split("\\s*,\\s*"));
	}

	private String getColor(Color color)
	{
		return String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
	}

	private int searchIndex(MenuEntry[] entries, String option, String target)
	{
		for (int i = entries.length - 1; i >= 0; i--)
		{
			MenuEntry entry = entries[i];

			if (entry.getOption().equals(option) && entry.getTarget().equals(target))
			{
				return i;
			}
		}
		return -1;
	}

	private void recolorTarget(String menuOption, String menuTarget)
	{
		MenuEntry[] entries = client.getMenuEntries();

		int index = searchIndex(entries, menuOption, menuTarget);

		if (index >= 0)
		{
			MenuEntry entry = entries[index];
			entry.setTarget(entry.getTarget().replaceAll("<col=ffffff>", "<col=" + getColor(config.targetColor()) + ">"));

			client.setMenuEntries(entries);
		}
	}
}
