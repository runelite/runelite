package net.runelite.client.plugins.rechargeableitems;

import net.runelite.client.plugins.rechargeableitems.items.Arclight;
import net.runelite.client.plugins.rechargeableitems.items.CrystalEquipment;
import net.runelite.client.plugins.rechargeableitems.items.RechargeableItem;
import net.runelite.client.plugins.rechargeableitems.items.SanguinestiStaff;
import net.runelite.client.plugins.rechargeableitems.items.ScytheOfVitur;
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
			case CRYSTAL_SHIELD:
			case CRYSTAL_BOW:
				rechargeableItem = new CrystalEquipment();
				break;
			case SANGUINESTI_STAFF:
			case SANGUINESTI_STAFF_UNCHARGED:
				rechargeableItem = new SanguinestiStaff();
				break;
			case SCYTHE_OF_VITUR:
			case SCYTHE_OF_VITUR_22664:
			case SCYTHE_OF_VITUR_UNCHARGED:
				rechargeableItem = new ScytheOfVitur();
				break;
			case TRIDENT_OF_THE_SEAS:
			case TRIDENT_OF_THE_SEAS_FULL:
				rechargeableItem = new TridentOfTheSeas(2500);
				break;
			case TRIDENT_OF_THE_SEAS_E:
				rechargeableItem = new TridentOfTheSeas(20000);
				break;
			case TRIDENT_OF_THE_SWAMP:
				rechargeableItem = new TridentOfTheSwamp(2500);
				break;
			case TRIDENT_OF_THE_SWAMP_E:
				rechargeableItem = new TridentOfTheSwamp(20000);
				break;
		}
		return rechargeableItem;
	}
}
