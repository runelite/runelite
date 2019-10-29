package net.runelite.client.plugins.itemskeptondeath;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import static net.runelite.api.ItemID.ABYSSAL_TENTACLE;
import static net.runelite.api.ItemID.ABYSSAL_WHIP;
import static net.runelite.api.ItemID.GRANITE_CLAMP;
import static net.runelite.api.ItemID.GRANITE_MAUL;
import static net.runelite.api.ItemID.GRANITE_MAUL_24225;
import static net.runelite.api.ItemID.GRANITE_MAUL_24227;
import static net.runelite.api.ItemID.KRAKEN_TENTACLE;
import static net.runelite.api.ItemID.ORNATE_MAUL_HANDLE;

@Getter
@RequiredArgsConstructor
public enum TrueItemValue
{
	GRANITE_MAUL_HANDLE(GRANITE_MAUL_24225, ImmutableSet.of(ORNATE_MAUL_HANDLE, GRANITE_MAUL)),
	GRANITE_MAUL_HANDLE_OR(GRANITE_MAUL_24227, ImmutableSet.of(ORNATE_MAUL_HANDLE, GRANITE_MAUL, GRANITE_CLAMP)),
	TENTACLE_WHIP(ABYSSAL_TENTACLE, ImmutableSet.of(ABYSSAL_WHIP, KRAKEN_TENTACLE));

	private static final ImmutableMap<Integer, TrueItemValue> TRUE_ITEM_VALUE_MAP;

	private final int itemID;
	private final Set<Integer> deconstructedItem;

	static
	{
		ImmutableMap.Builder<Integer, TrueItemValue> map = ImmutableMap.builder();
		for (TrueItemValue p : values())
		{
			map.put(p.getItemID(), p);
		}
		TRUE_ITEM_VALUE_MAP = map.build();
	}

	public static TrueItemValue map(int itemId)
	{
		return TRUE_ITEM_VALUE_MAP.getOrDefault(itemId, null);
	}
}

