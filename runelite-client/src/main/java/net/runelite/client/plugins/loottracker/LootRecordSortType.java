package net.runelite.client.plugins.loottracker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 *
 */
public enum LootRecordSortType implements Comparator<LootTrackerRecord>
{
	TIMESTAMP
		{
			@Override
			public int compare(LootTrackerRecord o1, LootTrackerRecord o2)
			{
				return Long.compare(o1.getTimestamp(), o2.getTimestamp());
			}
		},
	TOTAL_VALUE
		{
			@Override
			public int compare(LootTrackerRecord o1, LootTrackerRecord o2)
			{
				int sum = Arrays.stream(o1.getItems()).flatMapToInt(lootTrackerItem ->
					IntStream.of((int) lootTrackerItem.getPrice() * lootTrackerItem.getQuantity())).sum();
				return sum - Arrays.stream(o2.getItems()).flatMapToInt(lootTrackerItem ->
					IntStream.of((int) lootTrackerItem.getPrice() * lootTrackerItem.getQuantity())).sum();
			}
		},
	ITEM_COUNT
		{
			@Override
			public int compare(LootTrackerRecord o1, LootTrackerRecord o2)
			{
				return o1.getItems().length - o2.getItems().length;
			}
		}
}
