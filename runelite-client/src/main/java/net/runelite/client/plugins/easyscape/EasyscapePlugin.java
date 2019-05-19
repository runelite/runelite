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

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.MENU_ACTION_DEPRIORITIZE_OFFSET;
import static net.runelite.api.MenuAction.WALK;
import net.runelite.api.MenuEntry;
import static net.runelite.api.ObjectID.PORTAL_4525;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
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
	private boolean inHouse = false;

	@Inject
	private Client client;

	@Inject
	private EasyscapeConfig config;

	@Provides
	EasyscapeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(EasyscapeConfig.class);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget loginScreenOne = client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN);
		Widget loginScreenTwo = client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN_MESSAGE_OF_THE_DAY);

		if (loginScreenOne != null || loginScreenTwo != null)
		{
			return;
		}

		final String option = Text.removeTags(event.getOption()).toLowerCase();
		final String target = Text.removeTags(event.getTarget()).toLowerCase();

		entries = client.getMenuEntries();

		Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);

			if (config.getWithdrawOne())
			{
				for (String item : config.getWithdrawOneItems().split(","))
				{
					item = item.trim();
					if (target.equalsIgnoreCase(item))
					{
						swap(client, "Withdraw-1", option, target);
						swap(client, "Deposit-1", option, target);
					}
				}
			}

			if (config.getWithdrawFive())
			{
				for (String item : config.getWithdrawFiveItems().split(","))
				{
					item = item.trim();
					if (target.equalsIgnoreCase(item))
					{
						swap(client, "Withdraw-5", option, target);
						swap(client, "Deposit-5", option, target);
					}
				}
			}

			if (config.getWithdrawTen())
			{
				for (String item : config.getWithdrawTenItems().split(","))
				{
					item = item.trim();
					if (target.equalsIgnoreCase(item))
					{
						swap(client, "Withdraw-10", option, target);
						swap(client, "Deposit-10", option, target);
					}
				}
			}

			if (config.getWithdrawX())
			{
				for (String item : config.getWithdrawXItems().split(","))
				{
					item = item.trim();
					if (target.equalsIgnoreCase(item))
					{
						swap(client, "Withdraw-" + config.getWithdrawXAmount(), option, target);
						swap(client, "Deposit-" + config.getWithdrawXAmount(), option, target);
					}
				}
			}

			if (config.getWithdrawAll())
			{
				for (String item : config.getWithdrawAllItems().split(","))
				{
					item = item.trim();
					if (target.equalsIgnoreCase(item))
					{
						swap(client, "Withdraw-All", option, target);
						swap(client, "Deposit-All", option, target);
					}
				}
			}

		if (config.getSwapBuyOne() && !config.getBuyOneItems().equals(""))
		{
			for (String item : config.getBuyOneItems().split(","))
			{
				if (target.equalsIgnoreCase(item.trim()))
				{
					swap(client, "Buy 1", option, target);
				}
			}
		}

		if (config.getSwapBuyFive() && !config.getBuyFiveItems().equals(""))
		{
			for (String item : config.getBuyFiveItems().split(","))
			{
				if (target.equalsIgnoreCase(item.trim()))
				{
					swap(client, "Buy 5", option, target);
				}
			}
		}

		if (config.getSwapBuyTen() && !config.getBuyTenItems().equals(""))
		{
			for (String item : config.getBuyTenItems().split(","))
			{
				if (target.equalsIgnoreCase(item.trim()))
				{
					swap(client, "Buy 10", option, target);
				}
			}
		}

		if (config.getSwapBuyFifty() && !config.getBuyFiftyItems().equals(""))
		{
			for (String item : config.getBuyFiftyItems().split(","))
			{
				if (target.equalsIgnoreCase(item.trim()))
				{
					swap(client, "Buy 50", option, target);
				}
			}
		}

		if (config.getSwapSellOne() && !config.getSellOneItems().equals(""))
		{
			for (String item : config.getSellOneItems().split(","))
			{
				if (target.equalsIgnoreCase(item.trim()))
				{
					swap(client, "Sell 1", option, target);
				}
			}
		}

		if (config.getSwapSellFive() && !config.getSellFiveItems().equals(""))
		{
			for (String item : config.getSellFiveItems().split(","))
			{
				if (target.equalsIgnoreCase(item.trim()))
				{
					swap(client, "Sell 5", option, target);
				}
			}
		}

		if (config.getSwapSellTen() && !config.getSellTenItems().equals(""))
		{
			for (String item : config.getSellTenItems().split(","))
			{
				if (target.equalsIgnoreCase(item.trim()))
				{
					swap(client, "Sell 10", option, target);
				}
			}
		}

		if (config.getSwapSellFifty() && !config.getSellFiftyItems().equals(""))
		{
			for (String item : config.getSellFiftyItems().split(","))
			{
				if (target.equalsIgnoreCase(item.trim()))
				{
					swap(client, "Sell 50", option, target);
				}
			}
		}

		if (config.getRemoveObjects() && !config.getRemovedObjects().equals(""))
		{
			for (String removed : config.getRemovedObjects().split(","))
			{
				removed = removed.trim();
				if (target.contains("(") && target.split(" \\(")[0].equalsIgnoreCase(removed))
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

		if (config.getEasyConstruction() && !config.getConstructionItems().equals("") && inHouse)
		{
			if (event.getType() == WALK.getId())
			{
				MenuEntry menuEntry = entries[entries.length - 1];
				menuEntry.setType(MenuAction.WALK.getId() + MENU_ACTION_DEPRIORITIZE_OFFSET);
			}

			swap(client, "Build", option, target);

			for (int i = entries.length - 1; i >= 0; i--)
			{
				for (String item : config.getConstructionItems().split(","))
				{
					if (item.trim().equalsIgnoreCase(Text.removeTags(entries[i].getTarget())))
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

		if (config.getSwapSmithing())
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

		if (config.getSwapTanning() && option.equalsIgnoreCase("Tan 1"))
		{
			swap(client, "Tan All", option, target);
		}

		if (config.getSwapSawmill() && target.equalsIgnoreCase("Sawmill operator"))
		{
			swap(client, "Buy-plank", option, target);
		}

		if (config.getSwapSawmillPlanks() && option.equalsIgnoreCase("Buy 1"))
		{
			swap(client, "Buy All", option, target);
		}

		if (option.equalsIgnoreCase("Clear-All") && target.equalsIgnoreCase("bank Filler"))
		{
			swap(client, "Clear", option, target);
		}

		if (target.toLowerCase().contains("ardougne cloak") && config.getSwapArdougneCape())
		{
			swap(client, "Kandarin Monastery", option, target);
			swap(client, "Monastery Teleport", option, target);
		}
		
		if (target.toLowerCase().contains("crafting cape") && config.getSwapCraftingCape())
		{
			swap(client, "Teleport", option, target);
		}

		if (target.toLowerCase().contains("construct. cape") && config.getSwapConstructionCape())
		{
			swap(client, "Tele to poh", option, target);
		}

		if (target.toLowerCase().contains("magic cape") && config.getSwapMagicCape())
		{
			swap(client, "Spellbook", option, target);
		}

		if (target.toLowerCase().contains("explorer's ring") && config.getSwapExplorersRing())
		{
			swap(client, "Teleport", option, target);
		}

		if (config.getGamesNecklace())
		{
			if (target.toLowerCase().contains("games necklace"))
			{
				swap(client, config.getGamesNecklaceMode().toString(), option, target);
			}
		}

		if (config.getDuelingRing())
		{
			if (target.toLowerCase().contains("ring of dueling"))
			{
				swap(client, config.getDuelingRingMode().toString(), option, target);
			}
		}

		if (config.getGlory())
		{
			if (target.toLowerCase().contains("amulet of glory") || target.toLowerCase().contains("amulet of eternal glory"))
			{
				swap(client, config.getGloryMode().toString(), option, target);
			}
		}

		if (config.getSkillsNecklace())
		{
			if (target.toLowerCase().contains("skills necklace"))
			{
				swap(client, config.getSkillsNecklaceMode().toString(), option, target);
			}
		}
		
		if (config.getNecklaceofPassage())
		{
			if (target.toLowerCase().contains("necklace of passage"))
			{
				swap(client, config.getNecklaceofPassageMode().toString(), option, target);
			}
		}

		if (config.getDigsitePendant())
		{
			if (target.toLowerCase().contains("digsite pendant"))
			{
				swap(client, config.getDigsitePendantMode().toString(), option, target);
			}
		}	

		if (config.getCombatBracelet())
		{
			if (target.toLowerCase().contains("combat bracelet"))
			{
				swap(client, config.getCombatBraceletMode().toString(), option, target);
			}
		}

		if (config.getSlayerRing())
		{
			if (target.toLowerCase().contains("slayer ring"))
			{
				swap(client, config.getSlayerRingMode().toString(), option, target);
			}
		}	

		if (config.getBurningAmulet())
		{
			if (target.toLowerCase().contains("burning amulet"))
			{
				swap(client, config.getBurningAmuletMode().toString(), option, target);
			}
		}	

		if (config.getXericsTalisman())
		{
			if (target.toLowerCase().contains("xeric's talisman"))
			{
				swap(client, config.getXericsTalismanMode().toString(), option, target);
			}
		}	

		if (config.getRingofWealth())
		{
			if (target.toLowerCase().contains("ring of wealth"))
			{
				swap(client, config.getRingofWealthMode().toString(), option, target);
			}
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

	private boolean isEssencePouch(String target)
	{
		return (target.equalsIgnoreCase("Small Pouch") ||
			target.equalsIgnoreCase("Medium Pouch") ||
			target.equalsIgnoreCase("Large Pouch") ||
			target.equalsIgnoreCase("Giant Pouch"));
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		final GameObject gameObject = event.getGameObject();
		if (PORTAL_4525 == gameObject.getId())
		{
			this.inHouse = true;
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		final GameObject gameObject = event.getGameObject();
		if (PORTAL_4525 == gameObject.getId())
		{
			this.inHouse = false;
		}
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