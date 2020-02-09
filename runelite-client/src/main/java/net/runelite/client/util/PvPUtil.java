/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */
package net.runelite.client.util;

import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemDefinition;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.geometry.Cuboid;
import net.runelite.client.game.ItemManager;
import org.apache.commons.lang3.ArrayUtils;
import java.awt.Polygon;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

/**
 *
 */
public class PvPUtil
{
	private static final Polygon NOT_WILDERNESS_BLACK_KNIGHTS = new Polygon( // this is black knights castle
		new int[]{2994, 2995, 2996, 2996, 2994, 2994, 2997, 2998, 2998, 2999, 3000, 3001, 3002, 3003, 3004, 3005, 3005,
			3005, 3019, 3020, 3022, 3023, 3024, 3025, 3026, 3026, 3027, 3027, 3028, 3028, 3029, 3029, 3030, 3030, 3031,
			3031, 3032, 3033, 3034, 3035, 3036, 3037, 3037},
		new int[]{3525, 3526, 3527, 3529, 3529, 3534, 3534, 3535, 3536, 3537, 3538, 3539, 3540, 3541, 3542, 3543, 3544,
			3545, 3545, 3546, 3546, 3545, 3544, 3543, 3543, 3542, 3541, 3540, 3539, 3537, 3536, 3535, 3534, 3533, 3532,
			3531, 3530, 3529, 3528, 3527, 3526, 3526, 3525},
		43
	);
	private static final Cuboid MAIN_WILDERNESS_CUBOID = new Cuboid(2944, 3525, 0, 3391, 4351, 3);
	private static final Cuboid GOD_WARS_WILDERNESS_CUBOID = new Cuboid(3008, 10112, 0, 3071, 10175, 3);
	private static final Cuboid WILDERNESS_UNDERGROUND_CUBOID = new Cuboid(2944, 9920, 0, 3391, 10879, 3);

	/**
	 * Gets the wilderness level based on a world point
	 * Java reimplementation of clientscript 384 [proc,wilderness_level]
	 *
	 * @param point the point in the world to get the wilderness level for
	 * @return the int representing the wilderness level
	 */
	public static int getWildernessLevelFrom(WorldPoint point)
	{
		if (MAIN_WILDERNESS_CUBOID.contains(point))
		{
			if (NOT_WILDERNESS_BLACK_KNIGHTS.contains(point.getX(), point.getY()))
			{
				return 0;
			}

			return ((point.getY() - 3520) / 8) + 1; // calc(((coordz(coord) - (55 * 64)) / 8) + 1)
		}
		else if (GOD_WARS_WILDERNESS_CUBOID.contains(point))
		{
			return ((point.getY() - 9920) / 8) - 1; // calc(((coordz(coord) - (155 * 64)) / 8) - 1)
		}
		else if (WILDERNESS_UNDERGROUND_CUBOID.contains(point))
		{
			return ((point.getY() - 9920) / 8) + 1; // calc(((coordz(coord) - (155 * 64)) / 8) + 1)
		}
		return 0;
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
		
		if (!(client.getVar(Varbits.IN_WILDERNESS) == 1
			|| WorldType.isPvpWorld(client.getWorldType())
			|| WorldType.isDeadmanWorld(client.getWorldType())))
		{
			return false;
		}
		
		if (WorldType.isDeadmanWorld(client.getWorldType()))
		{
			return true;
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
		return Integer.parseInt(QuantityFormatter.quantityToRSDecimalStack(priceMap.keySet().stream().mapToInt(Integer::intValue).sum()));

	}
}
