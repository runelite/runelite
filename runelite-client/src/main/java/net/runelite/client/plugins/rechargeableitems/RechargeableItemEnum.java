package net.runelite.client.plugins.rechargeableitems;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.ItemID;

enum RechargeableItemEnum
{
	ARCLIGHT(ItemID.ARCLIGHT),
	CRYSTAL_BOW(ItemID.CRYSTAL_BOW),
	CRYSTAL_SHIELD(ItemID.CRYSTAL_SHIELD),
	SANGUINESTI_STAFF(ItemID.SANGUINESTI_STAFF),
	SANGUINESTI_STAFF_UNCHARGED(ItemID.SANGUINESTI_STAFF_UNCHARGED),
	SCYTHE_OF_VITUR(ItemID.SCYTHE_OF_VITUR),
	SCYTHE_OF_VITUR_22664(ItemID.SCYTHE_OF_VITUR_22664),
	SCYTHE_OF_VITUR_UNCHARGED(ItemID.SCYTHE_OF_VITUR_UNCHARGED),
	TRIDENT_OF_THE_SEAS(ItemID.TRIDENT_OF_THE_SEAS),
	TRIDENT_OF_THE_SEAS_E(ItemID.TRIDENT_OF_THE_SEAS_E),
	TRIDENT_OF_THE_SEAS_FULL(ItemID.TRIDENT_OF_THE_SEAS_FULL),
	TRIDENT_OF_THE_SWAMP(ItemID.TRIDENT_OF_THE_SWAMP),
	TRIDENT_OF_THE_SWAMP_E(ItemID.TRIDENT_OF_THE_SWAMP_E),
	;

	private static final Map<Integer, RechargeableItemEnum> lookup = new HashMap<>();

	static
	{
		for (RechargeableItemEnum item : RechargeableItemEnum.values())
		{
			lookup.put(item.getId(), item);
		}
	}

	@Getter
	private final int id;

	RechargeableItemEnum(int id)
	{
		this.id = id;
	}

	public static boolean containsItem(int itemId)
	{
		return lookup.containsKey(itemId);
	}

	public static RechargeableItemEnum getRechargeableItemEnum(int itemId)
	{
		return lookup.get(itemId);
	}
}
