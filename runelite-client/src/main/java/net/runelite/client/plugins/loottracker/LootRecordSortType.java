package net.runelite.client.plugins.loottracker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.loottracker.LootRecordType;

/**
 *
 */
@Slf4j
public enum LootRecordSortType implements Comparator<LootTrackerRecord>
{
	TIMESTAMP
		{
			@Override
			public int compare(LootTrackerRecord o1, LootTrackerRecord o2)
			{
				return Long.compare(o1.getTimestamp().toEpochMilli(), o2.getTimestamp().toEpochMilli());
			}
		},
	TOTAL_VALUE
		{
			@Override
			public int compare(LootTrackerRecord o1, LootTrackerRecord o2)
			{

				// We want deaths at the bottom of the list
				if (o1.getSubTitle().equals(LootRecordType.DEATH.name()))
				{
					return Arrays.stream(o1.getItems()).flatMapToInt(lootTrackerItem ->
						IntStream.of((int) lootTrackerItem.getPrice() * lootTrackerItem.getQuantity())).sum();
				}
				if (o2.getSubTitle().equals(LootRecordType.DEATH.name()))
				{
					return Arrays.stream(o1.getItems()).flatMapToInt(lootTrackerItem ->
						IntStream.of((int) lootTrackerItem.getPrice() * lootTrackerItem.getQuantity())).sum();
				}
				int sum = Arrays.stream(o1.getItems()).flatMapToInt(lootTrackerItem ->
					IntStream.of((int) lootTrackerItem.getPrice() * lootTrackerItem.getQuantity())).sum();
				return sum + Arrays.stream(o2.getItems()).flatMapToInt(lootTrackerItem ->
					IntStream.of((int) lootTrackerItem.getPrice() * lootTrackerItem.getQuantity())).sum();
			}
		},
	ITEM_COUNT
		{
			@Override
			public int compare(LootTrackerRecord o1, LootTrackerRecord o2)
			{
				return Integer.compare(o1.getItems().length, o2.getItems().length);
			}
		}
}
