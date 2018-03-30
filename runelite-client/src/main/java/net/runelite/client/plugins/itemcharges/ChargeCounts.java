/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.itemcharges;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.runelite.api.ItemID;

public class ChargeCounts
{
	private static final RangeSet<Integer> EXCLUDED_RANGES = TreeRangeSet.create();

	static
	{
		EXCLUDED_RANGES.add(Range.closed(ItemID.SHAYZIEN_GLOVES_1, ItemID.SHAYZIEN_PLATEBODY_5));
		EXCLUDED_RANGES.add(Range.closed(ItemID.SHAYZIEN_SUPPLY_GLOVES_1, ItemID.SHAYZIEN_SUPPLY_PLATEBODY_5));
	}

	public static Integer getCharges(int itemId, String itemName)
	{
		if (EXCLUDED_RANGES.contains(itemId))
		{
			return null;
		}

		// Regex only looks for digits and an ending parenthesis,
		// to catch items like Amulet of glory (t6).
		Matcher matcher = Pattern.compile("[0-9]+\\)$").matcher(itemName);
		if (matcher.find())
		{
			String match = matcher.group();
			return Integer.parseInt(match.substring(0, match.length() - 1));
		}

		return null;
	}
}
