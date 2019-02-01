/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.bankvalue;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.banktags.tabs.BankSearch;
import net.runelite.client.util.StackFormatter;

@PluginDescriptor(
	name = "Bank Value",
	description = "Show the value of your bank and/or current tab",
	tags = {"grand", "exchange", "high", "alchemy", "prices"}
)
public class BankValuePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private BankCalculation bankCalculation;

	@Inject
	private BankValueConfig config;

	@Inject
	private BankSearch bankSearch;

	@Provides
	BankValueConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankValueConfig.class);
	}

	@Override
	protected void shutDown()
	{
		clientThread.invokeLater(() -> bankSearch.reset(false));
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
