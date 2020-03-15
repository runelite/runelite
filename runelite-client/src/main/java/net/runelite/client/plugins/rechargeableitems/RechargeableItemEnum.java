package net.runelite.client.plugins.rechargeableitems;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.NonNull;
import net.runelite.api.ItemID;

enum RechargeableItemEnum
{
	ARCLIGHT(ItemID.ARCLIGHT),
	TRIDENT_OF_THE_SWAMP(ItemID.TRIDENT_OF_THE_SWAMP),
	TRIDENT_OF_THE_SWAMP_E(ItemID.TRIDENT_OF_THE_SWAMP_E),
	TRIDENT_OF_THE_SEAS(ItemID.TRIDENT_OF_THE_SEAS),
	TRIDENT_OF_THE_SEAS_E(ItemID.TRIDENT_OF_THE_SEAS_E),
	TRIDENT_OF_THE_SEAS_FULL(ItemID.TRIDENT_OF_THE_SEAS_FULL);

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

	public static boolean containsItem(@NonNull int itemId)
	{
		return lookup.containsKey(itemId);
	}

	public static RechargeableItemEnum getRechargeableItemEnum(int itemId)
	{
		return lookup.get(itemId);
	}
}
