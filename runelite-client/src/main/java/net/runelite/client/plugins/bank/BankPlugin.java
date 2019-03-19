/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
 * Copyright (c) 2019, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.bank;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuShouldLeftClick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.banktags.tabs.BankSearch;
import net.runelite.client.util.StackFormatter;

@PluginDescriptor(
	name = "Bank",
	description = "Modifications to the banking interface",
	tags = {"grand", "exchange", "high", "alchemy", "prices", "deposit"}
)
public class BankPlugin extends Plugin
{
	private static final String DEPOSIT_WORN = "Deposit worn items";
	private static final String DEPOSIT_INVENTORY = "Deposit inventory";
	private static final String DEPOSIT_LOOT = "Deposit loot";

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private BankCalculation bankCalculation;

	@Inject
	private BankConfig config;

	@Inject
	private BankSearch bankSearch;

	private boolean forceRightClickFlag;

	@Provides
	BankConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankConfig.class);
	}

	@Override
	protected void shutDown()
	{
		clientThread.invokeLater(() -> bankSearch.reset(false));
		forceRightClickFlag = false;
	}

	@Subscribe
	public void onMenuShouldLeftClick(MenuShouldLeftClick event)
	{
		if (!forceRightClickFlag)
		{
			return;
		}

		forceRightClickFlag = false;
		MenuEntry[] menuEntries = client.getMenuEntries();
		for (MenuEntry entry : menuEntries)
		{
			if ((entry.getOption().equals(DEPOSIT_WORN) && config.rightClickBankEquip())
				|| (entry.getOption().equals(DEPOSIT_INVENTORY) && config.rightClickBankInventory())
				|| (entry.getOption().equals(DEPOSIT_LOOT) && config.rightClickBankLoot()))
			{
				event.setForceRightClick(true);
				return;
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if ((event.getOption().equals(DEPOSIT_WORN) && config.rightClickBankEquip())
			|| (event.getOption().equals(DEPOSIT_INVENTORY) && config.rightClickBankInventory())
			|| (event.getOption().equals(DEPOSIT_LOOT) && config.rightClickBankLoot()))
		{
			forceRightClickFlag = true;
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (!event.getEventName().equals("setBankTitle"))
		{
			return;
		}

		String strCurrentTab = "";
		bankCalculation.calculate();
		long gePrice = bankCalculation.getGePrice();
		long haPrice = bankCalculation.getHaPrice();

		if (config.showGE() && gePrice != 0)
		{
			strCurrentTab += " (";

			if (config.showHA())
			{
				strCurrentTab += "EX: ";
			}

			if (config.showExact())
			{
				strCurrentTab += StackFormatter.formatNumber(gePrice) + ")";
			}
			else
			{
				strCurrentTab += StackFormatter.quantityToStackSize(gePrice) + ")";
			}
		}

		if (config.showHA() && haPrice != 0)
		{
			strCurrentTab += " (";

			if (config.showGE())
			{
				strCurrentTab += "HA: ";
			}

			if (config.showExact())
			{
				strCurrentTab += StackFormatter.formatNumber(haPrice) + ")";
			}
			else
			{
				strCurrentTab += StackFormatter.quantityToStackSize(haPrice) + ")";
			}
		}

		String[] stringStack = client.getStringStack();
		int stringStackSize = client.getStringStackSize();

		stringStack[stringStackSize - 1] += strCurrentTab;
	}
}
