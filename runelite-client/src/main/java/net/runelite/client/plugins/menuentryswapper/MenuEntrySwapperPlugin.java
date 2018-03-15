/*
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
package net.runelite.client.plugins.menuentryswapper;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Menu Entry Swapper",
	enabledByDefault = false
)
public class MenuEntrySwapperPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private MenuEntrySwapperConfig config;

	@Provides
	MenuEntrySwapperConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MenuEntrySwapperConfig.class);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		String option = event.getOption().toLowerCase();
		String target = event.getTarget();

		if (option.equals("talk-to"))
		{
			if (config.swapPickpocket())
			{
				swap("pickpocket", option, target, true);
			}

			if (config.swapBank())
			{
				swap("bank", option, target, true);
			}

			if (config.swapExchange())
			{
				swap("exchange", option, target, true);
			}

			if (config.swapTrade())
			{
				swap("trade", option, target, true);
			}

			if (config.swapTravel())
			{
				swap("travel", option, target, true);
				swap("pay-fare", option, target, true);
				swap("charter", option, target, true);
				swap("take-boat", option, target, true);
			}

			if (config.swapPay())
			{
				swap("pay", option, target, true);
			}
		}
		else if (config.swapHarpoon() && option.equals("cage"))
		{
			swap("harpoon", option, target, true);
		}
		else if (config.swapHarpoon() && option.equals("big net"))
		{
			swap("harpoon", option, target, true);
		}
		else if (config.swapHome() && option.equals("enter"))
		{
			swap("home", option, target, true);
		}
		else if (config.swapLastDestination() && option.equals("zanaris"))
		{
			swap("last-destination (", option, target, false);
		}
		else if (config.swapBoxTrap() && option.equals("check"))
		{
			swap("reset", option, target, true);
		}
		else if (config.swapCatacombEntrance() && option.equals("read"))
		{
			swap("investigate", option, target, true);
		}
		else if (config.swapTeleportItem() && option.equals("wear"))
		{
			swap("rub", option, target, true);
			swap("teleport", option, target, true);
		}
		else if (config.swapTeleportItem() && option.equals("wield"))
		{
			swap("teleport", option, target, true);
		}
	}

	private int searchIndex(MenuEntry[] entries, String option, String target, boolean strict)
	{
		for (int i = entries.length - 1; i >= 0; i--)
		{
			MenuEntry entry = entries[i];
			if (strict)
			{
				if (entry.getOption().toLowerCase().equals(option) && entry.getTarget().equals(target))
				{
					return i;
				}
			}
			else
			{
				if (entry.getOption().toLowerCase().contains(option) && entry.getTarget().equals(target))
				{
					return i;
				}
			}
		}
		return -1;
	}

	private void swap(String optionA, String optionB, String target, boolean strict)
	{
		MenuEntry[] entries = client.getMenuEntries();

		int idxA = searchIndex(entries, optionA, target, strict);
		int idxB = searchIndex(entries, optionB, target, strict);

		if (idxA >= 0 && idxB >= 0)
		{
			MenuEntry entry = entries[idxA];
			entries[idxA] = entries[idxB];
			entries[idxB] = entry;

			client.setMenuEntries(entries);
		}
	}
}
