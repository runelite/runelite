package net.runelite.client.plugins.rechargeableitems;

import net.runelite.client.plugins.rechargeableitems.items.Arclight;
import net.runelite.client.plugins.rechargeableitems.items.RechargeableItem;
import net.runelite.client.plugins.rechargeableitems.items.TridentOfTheSeas;
import net.runelite.client.plugins.rechargeableitems.items.TridentOfTheSwamp;

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
			case TRIDENT_OF_THE_SEAS:
				rechargeableItem = new TridentOfTheSeas(2500);
			case TRIDENT_OF_THE_SEAS_E:
			case TRIDENT_OF_THE_SEAS_FULL:
				rechargeableItem = new TridentOfTheSeas(20000);
				break;
			case TRIDENT_OF_THE_SWAMP:
				rechargeableItem = new TridentOfTheSwamp(2500);
			case TRIDENT_OF_THE_SWAMP_E:
				rechargeableItem = new TridentOfTheSwamp(20000);
				break;
		}
		return rechargeableItem;
	}
}
