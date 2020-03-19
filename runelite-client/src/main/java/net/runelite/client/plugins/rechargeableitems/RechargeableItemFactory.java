package net.runelite.client.plugins.rechargeableitems;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.rechargeableitems.items.Arclight;
import net.runelite.client.plugins.rechargeableitems.items.BarrowsEquipment;
import net.runelite.client.plugins.rechargeableitems.items.CrystalEquipment;
import net.runelite.client.plugins.rechargeableitems.items.RechargeableItem;
import net.runelite.client.plugins.rechargeableitems.items.SanguinestiStaff;
import net.runelite.client.plugins.rechargeableitems.items.ScytheOfVitur;
import net.runelite.client.plugins.rechargeableitems.items.TridentOfTheSeas;
import net.runelite.client.plugins.rechargeableitems.items.TridentOfTheSwamp;

public class RechargeableItemFactory
{
	public static RechargeableItem createRechargeableItem(RechargeableItemEnum itemEnum, Client client)
	{
		RechargeableItem rechargeableItem = handleBarrows(itemEnum, client);

		if (rechargeableItem != null)
		{
			return rechargeableItem;
		}

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

	private static RechargeableItem handleBarrows(RechargeableItemEnum itemEnum, Client client)
	{
		RechargeableItem result = null;

		switch (itemEnum)
		{
			// Helms
			case BARROWS_AHRIMS_HOOD_0:
			case BARROWS_KARILS_COIF_0:
			case BARROWS_TORAGS_HELM_0:
			case BARROWS_VERACS_HELM_0:
			case BARROWS_DHAROKS_HELM_0:
			case BARROWS_GUTHANS_HELM_0:
				result = new BarrowsEquipment(BarrowsEquipment.Type.HELM, 4, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_HOOD_25:
			case BARROWS_KARILS_COIF_25:
			case BARROWS_TORAGS_HELM_25:
			case BARROWS_VERACS_HELM_25:
			case BARROWS_DHAROKS_HELM_25:
			case BARROWS_GUTHANS_HELM_25:
				result = new BarrowsEquipment(BarrowsEquipment.Type.HELM, 3, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_HOOD_50:
			case BARROWS_KARILS_COIF_50:
			case BARROWS_TORAGS_HELM_50:
			case BARROWS_VERACS_HELM_50:
			case BARROWS_DHAROKS_HELM_50:
			case BARROWS_GUTHANS_HELM_50:
				result = new BarrowsEquipment(BarrowsEquipment.Type.HELM, 2, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_HOOD_75:
			case BARROWS_KARILS_COIF_75:
			case BARROWS_TORAGS_HELM_75:
			case BARROWS_VERACS_HELM_75:
			case BARROWS_DHAROKS_HELM_75:
			case BARROWS_GUTHANS_HELM_75:
				result = new BarrowsEquipment(BarrowsEquipment.Type.HELM, 1, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_HOOD_100:
			case BARROWS_KARILS_COIF_100:
			case BARROWS_TORAGS_HELM_100:
			case BARROWS_VERACS_HELM_100:
			case BARROWS_DHAROKS_HELM_100:
			case BARROWS_GUTHANS_HELM_100:
				result = new BarrowsEquipment(BarrowsEquipment.Type.HELM, 0, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			// Body
			case BARROWS_AHRIMS_ROBETOP_0:
			case BARROWS_VERACS_BRASSARD_0:
			case BARROWS_TORAGS_PLATEBODY_0:
			case BARROWS_DHAROKS_PLATEBODY_0:
			case BARROWS_GUTHANS_PLATEBODY_0:
			case BARROWS_KARILS_LEATHERTOP_0:
				result = new BarrowsEquipment(BarrowsEquipment.Type.BODY, 4, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_ROBETOP_25:
			case BARROWS_VERACS_BRASSARD_25:
			case BARROWS_TORAGS_PLATEBODY_25:
			case BARROWS_DHAROKS_PLATEBODY_25:
			case BARROWS_GUTHANS_PLATEBODY_25:
			case BARROWS_KARILS_LEATHERTOP_25:
				result = new BarrowsEquipment(BarrowsEquipment.Type.BODY, 3, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_ROBETOP_50:
			case BARROWS_VERACS_BRASSARD_50:
			case BARROWS_TORAGS_PLATEBODY_50:
			case BARROWS_DHAROKS_PLATEBODY_50:
			case BARROWS_GUTHANS_PLATEBODY_50:
			case BARROWS_KARILS_LEATHERTOP_50:
				result = new BarrowsEquipment(BarrowsEquipment.Type.BODY, 2, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_ROBETOP_75:
			case BARROWS_VERACS_BRASSARD_75:
			case BARROWS_TORAGS_PLATEBODY_75:
			case BARROWS_DHAROKS_PLATEBODY_75:
			case BARROWS_GUTHANS_PLATEBODY_75:
			case BARROWS_KARILS_LEATHERTOP_75:
				result = new BarrowsEquipment(BarrowsEquipment.Type.BODY, 1, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_ROBETOP_100:
			case BARROWS_VERACS_BRASSARD_100:
			case BARROWS_TORAGS_PLATEBODY_100:
			case BARROWS_DHAROKS_PLATEBODY_100:
			case BARROWS_GUTHANS_PLATEBODY_100:
			case BARROWS_KARILS_LEATHERTOP_100:
				result = new BarrowsEquipment(BarrowsEquipment.Type.BODY, 0, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			// Legs
			case BARROWS_AHRIMS_ROBESKIRT_0:
			case BARROWS_VERACS_PLATESKIRT_0:
			case BARROWS_TORAGS_PLATELEGS_0:
			case BARROWS_DHAROKS_PLATELEGS_0:
			case BARROWS_GUTHANS_CHAINSKIRT_0:
			case BARROWS_KARILS_LEATHERSKIRT_0:
				result = new BarrowsEquipment(BarrowsEquipment.Type.LEGS, 4, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_ROBESKIRT_25:
			case BARROWS_VERACS_PLATESKIRT_25:
			case BARROWS_TORAGS_PLATELEGS_25:
			case BARROWS_DHAROKS_PLATELEGS_25:
			case BARROWS_GUTHANS_CHAINSKIRT_25:
			case BARROWS_KARILS_LEATHERSKIRT_25:
				result = new BarrowsEquipment(BarrowsEquipment.Type.LEGS, 3, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_ROBESKIRT_50:
			case BARROWS_TORAGS_PLATELEGS_50:
			case BARROWS_GUTHANS_CHAINSKIRT_50:
			case BARROWS_KARILS_LEATHERSKIRT_50:
			case BARROWS_VERACS_PLATESKIRT_50:
			case BARROWS_DHAROKS_PLATELEGS_50:
				result = new BarrowsEquipment(BarrowsEquipment.Type.LEGS, 2, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_KARILS_LEATHERSKIRT_75:
			case BARROWS_GUTHANS_CHAINSKIRT_75:
			case BARROWS_VERACS_PLATESKIRT_75:
			case BARROWS_DHAROKS_PLATELEGS_75:
			case BARROWS_AHRIMS_ROBESKIRT_75:
			case BARROWS_TORAGS_PLATELEGS_75:
				result = new BarrowsEquipment(BarrowsEquipment.Type.LEGS, 1, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_KARILS_LEATHERSKIRT_100:
			case BARROWS_GUTHANS_CHAINSKIRT_100:
			case BARROWS_VERACS_PLATESKIRT_100:
			case BARROWS_DHAROKS_PLATELEGS_100:
			case BARROWS_TORAGS_PLATELEGS_100:
			case BARROWS_AHRIMS_ROBESKIRT_100:
				result = new BarrowsEquipment(BarrowsEquipment.Type.LEGS, 0, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			// Weapons
			case BARROWS_AHRIMS_STAFF_0:
			case BARROWS_VERACS_FLAIL_0:
			case BARROWS_TORAGS_HAMMERS_0:
			case BARROWS_KARILS_CROSSBOW_0:
			case BARROWS_GUTHANS_WARSPEAR_0:
			case BARROWS_DHAROKS_GREATEAXE_0:
				result = new BarrowsEquipment(BarrowsEquipment.Type.WEAPON, 4, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_STAFF_25:
			case BARROWS_VERACS_FLAIL_25:
			case BARROWS_TORAGS_HAMMERS_25:
			case BARROWS_KARILS_CROSSBOW_25:
			case BARROWS_GUTHANS_WARSPEAR_25:
			case BARROWS_DHAROKS_GREATEAXE_25:
				result = new BarrowsEquipment(BarrowsEquipment.Type.WEAPON, 3, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_STAFF_50:
			case BARROWS_VERACS_FLAIL_50:
			case BARROWS_TORAGS_HAMMERS_50:
			case BARROWS_KARILS_CROSSBOW_50:
			case BARROWS_GUTHANS_WARSPEAR_50:
			case BARROWS_DHAROKS_GREATEAXE_50:
				result = new BarrowsEquipment(BarrowsEquipment.Type.WEAPON, 2, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_DHAROKS_GREATEAXE_75:
			case BARROWS_AHRIMS_STAFF_75:
			case BARROWS_VERACS_FLAIL_75:
			case BARROWS_TORAGS_HAMMERS_75:
			case BARROWS_KARILS_CROSSBOW_75:
			case BARROWS_GUTHANS_WARSPEAR_75:
				result = new BarrowsEquipment(BarrowsEquipment.Type.WEAPON, 1, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
			case BARROWS_AHRIMS_STAFF_100:
			case BARROWS_VERACS_FLAIL_100:
			case BARROWS_TORAGS_HAMMERS_100:
			case BARROWS_KARILS_CROSSBOW_100:
			case BARROWS_GUTHANS_WARSPEAR_100:
			case BARROWS_DHAROKS_GREATEAXE_100:
				result = new BarrowsEquipment(BarrowsEquipment.Type.WEAPON, 0, client.getBoostedSkillLevel(Skill.SMITHING));
				break;
		}

		return result;
	}
}
