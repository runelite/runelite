package net.runelite.client.plugins.rechargeableitems;

import net.runelite.client.plugins.rechargeableitems.items.Arclight;
import net.runelite.client.plugins.rechargeableitems.items.RechargeableItem;

public class RechargeableItemFactory
{
	public static RechargeableItem createRechargeableItem(RechargeableItemEnum itemEnum)
	{
		RechargeableItem rechargeableItem = null;
		switch (itemEnum)
		{
			case ARCLIGHT:
				rechargeableItem = new Arclight();
				break;
		}
		return rechargeableItem;
	}
}
