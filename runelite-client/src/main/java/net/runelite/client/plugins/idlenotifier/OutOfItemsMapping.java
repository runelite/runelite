/*
 * Copyright (c) 2019, Twiglet1022 <https://github.com/Twiglet1022>
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
package net.runelite.client.plugins.idlenotifier;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import static net.runelite.api.ItemID.BLUEGILL;
import static net.runelite.api.ItemID.COMMON_TENCH;
import static net.runelite.api.ItemID.GREATER_SIREN;
import static net.runelite.api.ItemID.MOTTLED_EEL;

public enum OutOfItemsMapping
{
	AERIAL_FISHING_CUTTING(BLUEGILL, COMMON_TENCH, MOTTLED_EEL, GREATER_SIREN);

	private static final Multimap<Integer, Integer> MAPPINGS = HashMultimap.create();
	private final int groupedItemKey;
	private final int[] groupedItemIDs;

	static
	{
		for (final OutOfItemsMapping item : values())
		{
			for (int itemId : item.groupedItemIDs)
			{
				MAPPINGS.put(itemId, item.groupedItemKey);
			}
		}
	}

	OutOfItemsMapping(int groupedItemKey, int... groupedItemIDs)
	{
		this.groupedItemKey = groupedItemKey;
		this.groupedItemIDs = groupedItemIDs;
	}

	/**
	 * Some actions consume multiple different items. To properly handle these
	 * cases for the out of items notification the different items must be
	 * recognised as belonging to a single group.
	 * <p>
	 * Map an item that is part of a group of items that are consumed by a single
	 * action to the first item in that group.
	 */
	public static int mapFirst(int itemId)
	{
		final Collection<Integer> mapping = MAPPINGS.get(itemId);

		if (mapping == null || mapping.isEmpty())
		{
			return itemId;
		}

		return mapping.iterator().next();
	}

}