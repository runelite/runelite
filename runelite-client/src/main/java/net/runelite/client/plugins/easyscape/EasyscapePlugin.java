/*
 * Copyright (c) 2018, Alan Baumgartner <https://github.com/alanbaumgartner>
 * Copyright (c) 2018, https://runelitepl.us
 * Copyright (c) 2018, Kyle <https://github.com/kyleeld>
 * Copyright (c) 2018, Owain van Brakel <https://github.com/Owain94>
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
package net.runelite.client.plugins.easyscape;

import com.google.common.base.Strings;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
import static net.runelite.api.MenuAction.WALK;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import static net.runelite.api.Varbits.BUILDING_MODE;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import static net.runelite.client.util.MenuUtil.swap;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;


@PluginDescriptor(
	name = "Easyscape",
	type = PluginType.UTILITY
)
public class EasyscapePlugin extends Plugin
{
	private static final int PURO_PURO_REGION_ID = 10307;

	private MenuEntry[] entries;

	@Inject
	private Client client;

	@Inject
	private EasyscapeConfig config;

	@Provides
	EasyscapeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(EasyscapeConfig.class);
	}

	@Override
	public void startUp()
	{
	}

	@Override
	public void shutDown()
	{
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final String option = Text.standardize(event.getOption());
		final String target = Text.standardize(event.getTarget());

		entries = client.getMenuEntries();

		if (option.contains("withdraw") || option.contains("deposit"))
		{
			if (config.getWithdrawOne())
			{
				for (String item : Text.fromCSV(config.getWithdrawOneItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Withdraw-1", option, target);
						swap(client, "Deposit-1", option, target);
					}
				}
			}

			if (config.getWithdrawFive())
			{
				for (String item : Text.fromCSV(config.getWithdrawFiveItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Withdraw-5", option, target);
						swap(client, "Deposit-5", option, target);
					}
				}
			}

			if (config.getWithdrawTen())
			{
				for (String item : Text.fromCSV(config.getWithdrawTenItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Withdraw-10", option, target);
						swap(client, "Deposit-10", option, target);
					}
				}
			}

			if (config.getWithdrawX())
			{
				for (String item : Text.fromCSV(config.getWithdrawXItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Withdraw-" + config.getWithdrawXAmount(), option, target);
						swap(client, "Deposit-" + config.getWithdrawXAmount(), option, target);
					}
				}
			}

			if (config.getWithdrawAll())
			{
				for (String item : Text.fromCSV(config.getWithdrawAllItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Withdraw-All", option, target);
						swap(client, "Deposit-All", option, target);
					}
				}
			}
		}

		if (option.contains("buy"))
		{
			if (config.getSwapBuyOne() && !config.getBuyOneItems().equals(""))
			{
				for (String item : Text.fromCSV(config.getBuyOneItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Buy 1", option, target);
					}
				}
			}

			if (config.getSwapBuyFive() && !config.getBuyFiveItems().equals(""))
			{
				for (String item : Text.fromCSV(config.getBuyFiveItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Buy 5", option, target);
					}
				}
			}

			if (config.getSwapBuyTen() && !config.getBuyTenItems().equals(""))
			{
				for (String item : Text.fromCSV(config.getBuyTenItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Buy 10", option, target);
					}
				}
			}

			if (config.getSwapBuyFifty() && !config.getBuyFiftyItems().equals(""))
			{
				for (String item : Text.fromCSV(config.getBuyFiftyItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Buy 50", option, target);
					}
				}
			}
		}
		else if (option.contains("sell"))
		{
			if (config.getSwapSellOne() && !config.getSellOneItems().equals(""))
			{
				for (String item : Text.fromCSV(config.getSellOneItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Sell 1", option, target);
					}
				}
			}

			if (config.getSwapSellFive() && !Strings.isNullOrEmpty(config.getSellFiveItems()))
			{
				for (String item : Text.fromCSV(config.getSellFiveItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Sell 5", option, target);
					}
				}
			}

			if (config.getSwapSellTen() && !Strings.isNullOrEmpty(config.getSellTenItems()))
			{
				for (String item : Text.fromCSV(config.getSellTenItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Sell 10", option, target);
					}
				}
			}

			if (config.getSwapSellFifty() && !Strings.isNullOrEmpty(config.getSellFiftyItems()))
			{
				for (String item : Text.fromCSV(config.getSellFiftyItems()))
				{
					if (target.equals(Text.standardize(item)))
					{
						swap(client, "Sell 50", option, target);
					}
				}
			}
		}

		if (config.getRemoveObjects() && !config.getRemovedObjects().equals(""))
		{
			for (String removed : Text.fromCSV(config.getRemovedObjects()))
			{
				removed = Text.standardize(removed);
				if (target.contains("(") && target.split(" \\(")[0].equals(removed))
				{
					delete(event.getIdentifier());
				}
				else if (target.contains("->"))
				{
					String trimmed = target.split("->")[1].trim();
					if (trimmed.length() >= removed.length() && trimmed.substring(0, removed.length()).equalsIgnoreCase(removed))
					{
						delete(event.getIdentifier());
						break;
					}
				}
				else if (target.length() >= removed.length() && target.substring(0, removed.length()).equalsIgnoreCase(removed))
				{
					delete(event.getIdentifier());
					break;
				}
			}
		}

		if (config.getSwapPuro() && isPuroPuro())
		{
			if (event.getType() == WALK.getId())
			{
				MenuEntry menuEntry = entries[entries.length - 1];
				menuEntry.setType(MenuAction.WALK.getId() + MENU_ACTION_DEPRIORITIZE_OFFSET);
			}
			else if (option.equalsIgnoreCase("examine"))
			{
				swap(client, "push-through", option, target);
			}
			else if (option.equalsIgnoreCase("use"))
			{
				swap(client, "escape", option, target);
			}
		}

		if (config.getEasyConstruction() && client.getVar(BUILDING_MODE) == 1 && !Strings.isNullOrEmpty(config.getConstructionItems()))
		{
			if (event.getType() == WALK.getId())
			{
				MenuEntry menuEntry = entries[entries.length - 1];
				menuEntry.setType(MenuAction.WALK.getId() + MENU_ACTION_DEPRIORITIZE_OFFSET);
			}

			swap(client, "Build", option, target);

			for (int i = entries.length - 1; i >= 0; i--)
			{
				for (String item : Text.fromCSV(config.getConstructionItems()))
				{
					if (item.equalsIgnoreCase(Text.removeTags(entries[i].getTarget())))
					{
						if (!entries[i].getOption().equalsIgnoreCase("remove"))
						{
							entries = ArrayUtils.remove(entries, i);
							i--;
						}
					}
				}
			}

			client.setMenuEntries(entries);
		}

		if (config.getSwapSmithing() && option.contains("smith"))
		{
			if (option.equalsIgnoreCase("Smith 1"))
			{
				swap(client, "Smith All", option, target);
			}
			else if (option.equalsIgnoreCase("Smith 1 Set"))
			{
				swap(client, "Smith All Sets", option, target);
			}
		}

		else if (config.getSwapTanning() && option.equalsIgnoreCase("Tan 1"))
		{
			swap(client, "Tan All", option, target);
		}

		else if (config.getSwapSawmill() && target.equalsIgnoreCase("Sawmill operator"))
		{
			swap(client, "Buy-plank", option, target);
		}

		else if (config.getSwapSawmillPlanks() && option.equalsIgnoreCase("Buy 1"))
		{
			swap(client, "Buy All", option, target);
		}

		else if (option.equalsIgnoreCase("Clear-All") && target.equalsIgnoreCase("Bank Filler"))
		{
			swap(client, "Clear", option, target);
		}

		else if (target.contains("ardougne cloak") && config.getSwapArdougneCape())
		{
			swap(client, "Kandarin Monastery", option, target);
			swap(client, "Monastery Teleport", option, target);
		}
		
		if (target.contains("crafting cape") && config.getSwapCraftingCape())
		{
			swap(client, "Teleport", option, target);
		}

		if (target.contains("construct. cape") && config.getSwapConstructionCape())
		{
			swap(client, "Tele to poh", option, target);
		}

		if (target.contains("magic cape") && config.getSwapMagicCape())
		{
			swap(client, "Spellbook", option, target);
		}

		if (target.contains("explorer's ring") && config.getSwapExplorersRing())
		{
			swap(client, "Teleport", option, target);
    }
    
		if (config.getGamesNecklace() && target.contains("games necklace"))
		{
			swap(client, config.getGamesNecklaceMode().toString(), option, target);
		}

		if (config.getDuelingRing() && target.contains("ring of dueling"))
		{
			swap(client, config.getDuelingRingMode().toString(), option, target);
		}

		if (config.getGlory() && target.contains("amulet of glory") || target.contains("amulet of eternal glory"))
		{
			swap(client, config.getGloryMode().toString(), option, target);
		}
    
		if (config.getSkillsNecklace() && target.contains("skills necklace"))
			{
				swap(client, config.getSkillsNecklaceMode().toString(), option, target);
			}
		
		if (config.getNecklaceofPassage() && target.contains("necklace of passage"))
			{
				swap(client, config.getNecklaceofPassageMode().toString(), option, target);
			}
      
		if (config.getDigsitePendant() && target.contains("digsite pendant"))
			{
				swap(client, config.getDigsitePendantMode().toString(), option, target);
			}
      
		if (config.getCombatBracelet() && target.contains("combat bracelet"))
			{
				swap(client, config.getCombatBraceletMode().toString(), option, target);
			}

		if (config.getSlayerRing() && target.contains("slayer ring"))
			{
				swap(client, config.getSlayerRingMode().toString(), option, target);
			}

		if (config.getBurningAmulet() && target.contains("burning amulet"))
			{
				swap(client, config.getBurningAmuletMode().toString(), option, target);
			}

		if (config.getXericsTalisman() && target.contains("xeric's talisman"))
			{
				swap(client, config.getXericsTalismanMode().toString(), option, target);
			}

		if (config.getRingofWealth() && target.contains("ring of wealth"))
			{
				swap(client, config.getRingofWealthMode().toString(), option, target);
			}
	}

	private void delete(int target)
	{
		for (int i = entries.length - 1; i >= 0; i--)
		{
			if (entries[i].getIdentifier() == target)
			{
				entries = ArrayUtils.remove(entries, i);
				i--;
			}
		}
		client.setMenuEntries(entries);
	}

	private boolean isPuroPuro()
	{
		Player player = client.getLocalPlayer();

		if (player == null)
		{
			return false;
		}
		else
		{
			WorldPoint location = player.getWorldLocation();
			return location.getRegionID() == PURO_PURO_REGION_ID;
		}
	}
}
