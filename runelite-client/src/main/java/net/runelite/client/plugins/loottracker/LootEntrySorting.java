/*
 * Copyright (c) 2019, Eingin <https://github.com/eingin>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
