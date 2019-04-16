package net.runelite.client.plugins.loottracker;

import lombok.Getter;

import java.util.Comparator;

public enum LootEntrySorting
{
	FIRST("Most Recent Drop",
		(LootTrackerBox a, LootTrackerBox b) ->
		{
			long aMax = a.getRecords()
				.stream()
				.mapToLong(LootTrackerRecord::getTimestamp)
				.max()
				.orElse(0);

			long bMax = b.getRecords()
				.stream()
				.mapToLong(LootTrackerRecord::getTimestamp)
				.max()
				.orElse(0);

			return Long.compare(aMax, bMax);
		}),
	LAST("Oldest Drop",
		(LootTrackerBox a, LootTrackerBox b) ->
		{
			long aMax = a.getRecords()
				.stream()
				.mapToLong(LootTrackerRecord::getTimestamp)
				.max()
				.orElse(0);

			long bMax = b.getRecords()
				.stream()
				.mapToLong(LootTrackerRecord::getTimestamp)
				.max()
				.orElse(0);

			return Long.compare(bMax, aMax);
		}),
	HIGHEST_VALUE("Highest Value",
		(LootTrackerBox a, LootTrackerBox b) ->
			Long.compare(a.getTotalPrice(), b.getTotalPrice())
	),
	LOWEST_VALUE("Lowest Value",
		(LootTrackerBox a, LootTrackerBox b) ->
			Long.compare(b.getTotalPrice(), a.getTotalPrice())
	);


	private final String name;

	@Getter
	private final Comparator<LootTrackerBox> sorter;


	LootEntrySorting(String name, Comparator<LootTrackerBox> sorter)
	{
		this.name = name;
		this.sorter = sorter;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
