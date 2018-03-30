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

import com.google.common.collect.Sets;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import static net.runelite.api.ItemID.ADAMANT_AXE;
import static net.runelite.api.ItemID.BLACK_AXE;
import static net.runelite.api.ItemID.BRONZE_AXE;
import static net.runelite.api.ItemID.DRAGON_AXE;
import static net.runelite.api.ItemID.INFERNAL_AXE;
import static net.runelite.api.ItemID.IRON_AXE;
import static net.runelite.api.ItemID.MITHRIL_AXE;
import static net.runelite.api.ItemID.RUNE_AXE;
import static net.runelite.api.ItemID.STEEL_AXE;
import static net.runelite.api.ItemID._3RD_AGE_AXE;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Menu Entry Swapper"
)

@Slf4j
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

	private static final Set<String> SLAYER_MASTERS = Sets.newHashSet( "turael", "mazchna", "vannaka", "chaeldar", "nieve", "steve", "duradel", "krystilia");
	private static final Set<Integer> AXES = Sets.newHashSet(BRONZE_AXE, IRON_AXE, STEEL_AXE, BLACK_AXE, MITHRIL_AXE, ADAMANT_AXE, RUNE_AXE, DRAGON_AXE, _3RD_AGE_AXE, INFERNAL_AXE);

	private boolean hasAxe;

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		String option = Text.removeTags(event.getOption().toLowerCase());
		String target = Text.removeTags(event.getTarget().toLowerCase());

		//Swap NPC ops
		if (config.swapSlayerMaster().isSet() && option.equals("talk-to") && SLAYER_MASTERS.contains(target))
		{
			switch (config.swapSlayerMaster())
			{
				case ASSIGNMENT:
					swap("assignment", option, target, true);
					break;
				case TRADE:
					swap("trade", option, target, true);
					break;
				case REWARDS:
					swap("rewards", option, target, true);
					break;
			}
		}
		else if (config.swapSawmillOperator().isSet() && option.equals("talk-to") && target.equals("sawmill operator"))
		{
			switch (config.swapSawmillOperator())
			{
				case BUY_PLANK:
					swap("buy-plank", option, target, true);
					break;
				case TRADE:
					swap("trade", option, target, true);
					break;
			}
		}
		else if (config.swapShantay().isSet() && option.equals("talk-to") && target.equals("shantay"))
		{
			switch (config.swapShantay())
			{
				case TRADE:
					swap("trade", option, target, true);
					break;
				case BUY_PASS:
					swap("buy-pass", option, target, true);
					break;
			}
		}
		else if (option.equals("talk-to"))
		{
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

			if (config.swapPay())
			{
				swap("pay", option, target, true);
			}

			if (config.swapPickpocket())
			{
				swap("pickpocket", option, target, true);
			}

			if (config.swapTravel())
			{
				swap("travel", option, target, true);
				swap("pay-fare", option, target, true);
				swap("take-boat", option, target, true);
				swap("charter", option, target, true);
				swap("tickets", option, target, true);
			}

			if (config.swapKitten())
			{
				swap("kitten", option, target, true);
			}
		}



		//Swap object ops
		else if (config.swapHousePortal().isSet() && option.equals("enter") && target.equals("portal"))
		{
			switch (config.swapHousePortal())
			{
				case HOME:
					swap("home", option, target, true);
					break;
				case BUILD_MODE:
					swap("build mode", option, target, true);
					break;
				case FRIENDS_HOUSE:
					swap("friend's house", option, target, true);
					break;
			}
		}
		else if (config.swapFairyRing().isSet() && option.equals("zanaris") && target.equals("fairy ring"))
		{
			switch (config.swapFairyRing())
			{
				case CONFIGURE:
					swap("configure", option, target, true);
					break;
				case LAST_DESTINATION:
					swap("last-destination", option, target, false);
					break;
			}
		}
		else if (config.swapTravel() && option.equals("inspect") && target.equals("trapdoor"))
		{
			swap("travel", option, target, true);
		}
		else if (config.swapCatacombEntrance() && option.equals("read") && target.equals("statue"))
		{
			swap("investigate", option, target, true);
		}
		else if (config.swapHarpoon() && (option.equals("cage") || option.equals("big net")) && target.equals("fishing spot"))
		{
			swap("harpoon", option, target, true);
		}
		else if (config.swapBoxTrap() && (option.equals("take") || option.equals("check") || option.equals("dismantle")) && target.equals("box trap"))
		{
			swap("lay", option, target, true);
			swap("reset", option, target, true);
			swap("investigate", option, target, true);
		}



		//Swap inventory ops
		else if (config.swapBones() && option.equals("bury"))
		{
			swap("use", option, target, true);
		}



		//Hide ops
		else if (config.hideChopDown() && option.equals("chop down") && !hasAxe)
		{
			remove(option, target, true);
		}
		else if (config.swapKitten() && option.equals("investigate") && target.equals("watchtower"))
		{
			remove(option, target, true);
		}
	}

	@Schedule(period = 600, unit = ChronoUnit.MILLIS)
	public void checkAxe()
	{
		hasAxe = hasAxe();
	}

	private boolean hasAxe()
	{
		if (!config.hideChopDown())
		{
			return true;
		}

		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		if (inventory == null)
		{
			return false;
		}

		for (Item item : inventory.getItems())
		{
			if (AXES.contains(item.getId()))
			{
				return true;
			}
		}

		ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipment == null)
		{
			return false;
		}

		for (Item item : equipment.getItems())
		{
			if (AXES.contains(item.getId()))
			{
				return true;
			}
		}

		return false;
	}

	private int searchIndex(MenuEntry[] entries, String option, String target, boolean strict)
	{
		for (int i = entries.length - 1; i >= 0; i--)
		{
			MenuEntry entry = entries[i];
			if (strict)
			{
				if (Text.removeTags(entry.getOption().toLowerCase()).equals(option) && Text.removeTags(entry.getTarget().toLowerCase()).equals(target))
				{
					return i;
				}
			}
			else
			{
				if (Text.removeTags(entry.getOption().toLowerCase()).contains(option) && Text.removeTags(entry.getTarget().toLowerCase()).contains(target))
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

	private void remove(String option, String target, boolean strict)
	{
		MenuEntry[] oldMenu = client.getMenuEntries();
		List<MenuEntry> newMenu = new ArrayList<>();

		int idx = searchIndex(oldMenu, option, target, strict);

		if (idx >= 0)
		{
			for (int i = 0; i < oldMenu.length; i++)
			{
				if (i != idx)
				{
					newMenu.add(oldMenu[i]);
				}
			}

			client.setMenuEntries(newMenu.toArray(new MenuEntry[newMenu.size()]));
		}
	}
}
