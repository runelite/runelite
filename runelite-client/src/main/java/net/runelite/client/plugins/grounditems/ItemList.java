/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.grounditems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import lombok.Value;
import net.runelite.client.util.WildcardMatcher;

class ItemList
{
	static final int NONE = 0;
	static final int WILDCARD = 1;
	static final int EXACT = 2;

	// Use the same case folding as String.equalsIgnoreCase, including non-ASCII names.
	private final Map<String, List<ItemThreshold>> exactItems = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	private final List<WildcardItem> wildcardItems = new ArrayList<>();

	@Value
	private static class WildcardItem
	{
		ItemThreshold threshold;
		Pattern pattern;
	}

	ItemList(List<String> items)
	{
		for (String name : items)
		{
			ItemThreshold threshold = ItemThreshold.fromName(name);
			if (threshold == null)
			{
				continue;
			}
			if (threshold.isWildcard())
			{
				wildcardItems.add(new WildcardItem(threshold, WildcardMatcher.compile(threshold.getName())));
			}
			else
			{
				exactItems.computeIfAbsent(threshold.getName(), k -> new ArrayList<>()).add(threshold);
			}
		}
	}

	int matches(GroundItem item)
	{
		List<ItemThreshold> exact = exactItems.get(item.getName());
		if (exact != null)
		{
			for (ItemThreshold it : exact)
			{
				if (it.quantityHolds(item.getQuantity()))
				{
					return EXACT;
				}
			}
		}

		for (WildcardItem it : wildcardItems)
		{
			if (it.threshold.quantityHolds(item.getQuantity())
				&& it.pattern.matcher(item.getName()).matches())
			{
				return WILDCARD;
			}
		}

		return NONE;
	}
}
