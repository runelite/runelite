/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.util;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemDefinition;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.util.StackFormatter.quantityToRSDecimalStack;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 */
public class PvPUtil
{

	/**
	 * Gets the wilderness level based on a world point
	 *
	 * @param point the point in the world to get the wilderness level for
	 * @return the int representing the wilderness level
	 */
	public static int getWildernessLevelFrom(WorldPoint point)
	{
		int y = point.getY();

		int underLevel = ((y - 9920) / 8) + 1;
		int upperLevel = ((y - 3520) / 8) + 1;

		return y > 6400 ? underLevel : upperLevel;
	}

	/**
	 * Determines if another player is attackable based off of wilderness level and combat levels
	 *
	 * @param client The client of the local player
	 * @param player the player to determine attackability
	 * @return returns true if the player is attackable, false otherwise
	 */
	public static boolean isAttackable(Client client, Player player)
	{
		int wildernessLevel = 0;
		if (!(client.getVar(Varbits.IN_WILDERNESS) == 1 || WorldType.isPvpWorld(client.getWorldType())))
		{
			return false;
		}
		if (WorldType.isPvpWorld(client.getWorldType()))
		{
			if (client.getVar(Varbits.IN_WILDERNESS) != 1)
			{
				return Math.abs(client.getLocalPlayer().getCombatLevel() - player.getCombatLevel()) <= 15;
			}
			wildernessLevel = 15;
		}
		return Math.abs(client.getLocalPlayer().getCombatLevel() - player.getCombatLevel())
			< (getWildernessLevelFrom(client.getLocalPlayer().getWorldLocation()) + wildernessLevel);
	}

	public static int calculateRisk(Client client, ItemManager itemManager)
	{
		if (client.getItemContainer(InventoryID.EQUIPMENT) == null)
		{
			return 0;
		}
		if (client.getItemContainer(InventoryID.INVENTORY).getItems() == null)
		{
			return 0;
		}
		Item[] items = ArrayUtils.addAll(Objects.requireNonNull(client.getItemContainer(InventoryID.EQUIPMENT)).getItems(),
			Objects.requireNonNull(client.getItemContainer(InventoryID.INVENTORY)).getItems());
		TreeMap<Integer, Item> priceMap = new TreeMap<>(Comparator.comparingInt(Integer::intValue));
		int wealth = 0;
		for (Item i : items)
		{
			int value = (itemManager.getItemPrice(i.getId()) * i.getQuantity());

			final ItemDefinition itemComposition = itemManager.getItemDefinition(i.getId());
			if (!itemComposition.isTradeable() && value == 0)
			{
				value = itemComposition.getPrice() * i.getQuantity();
				priceMap.put(value, i);
			}
			else
			{
				value = itemManager.getItemPrice(i.getId()) * i.getQuantity();
				if (i.getId() > 0 && value > 0)
				{
					priceMap.put(value, i);
				}
			}
			wealth += value;
		}
		return Integer.parseInt(quantityToRSDecimalStack(priceMap.keySet().stream().mapToInt(Integer::intValue).sum()));

	}
}
