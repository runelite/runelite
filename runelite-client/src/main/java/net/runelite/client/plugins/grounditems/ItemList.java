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

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Value;
import net.runelite.client.util.WildcardMatcher;

@Value
class ItemList
{
	static final int NONE = 0;
	static final int WILDCARD = 1;
	static final int EXACT = 2;

	List<ItemThreshold> items;

	ItemList(List<String> items)
	{
		this.items = items.stream()
			.map(ItemThreshold::fromName)
			.filter(Objects::nonNull)
			.collect(Collectors.toList());
	}

	int matches(GroundItem item)
	{
		for (ItemThreshold it : items)
		{
			if (!it.isWildcard()
				&& it.getName().equalsIgnoreCase(item.getName())
				&& it.quantityHolds(item.getQuantity()))
			{
				return EXACT;
			}
		}

		for (ItemThreshold it : items)
		{
			if (it.isWildcard()
				&& WildcardMatcher.matches(it.getName(), item.getName())
				&& it.quantityHolds(item.getQuantity()))
			{
				return WILDCARD;
			}
		}

		return NONE;
	}
}
