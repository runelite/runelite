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

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;

public class ChargeCounts
{
	/** Regex only looks for digits and a closing parenthesis, to match items like Amulet of glory (t6). */
	private static final String CHARGES_REGEX = "[0-9]+\\)$";

	/** Non-chargeable items which would otherwise be matched by CHARGES_REGEX. */
	private static final RangeSet<Integer> EXCLUDED_ITEMS = TreeRangeSet.create();
	/** Potions which lack a Drink menu action but can hold multiple doses. */
	private static final RangeSet<Integer> UNDRINKABLE_POTIONS = TreeRangeSet.create();

	static
	{
		EXCLUDED_ITEMS.add(Range.closed(ItemID.SHAYZIEN_GLOVES_1, ItemID.SHAYZIEN_PLATEBODY_5));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.SHAYZIEN_SUPPLY_GLOVES_1, ItemID.SHAYZIEN_SUPPLY_PLATEBODY_5));

		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.SERUM_207_4, ItemID.SERUM_207_1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.SERUM_208_4, ItemID.SERUM_208_1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.OLIVE_OIL4, ItemID.OLIVE_OIL1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.SACRED_OIL4, ItemID.SACRED_OIL1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.COMPOST_POTION4, ItemID.COMPOST_POTION1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.GUTHIX_BALANCE4, ItemID.GUTHIX_BALANCE1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.REJUVENATION_POTION_4, ItemID.REJUVENATION_POTION_1));
	}

	/**
	 * Get the number of charges remaining on a given item according to its name,
	 * returning null for items which aren't chargeable or which are filtered out
	 * by the user's plugin settings.
	 *
	 * @return Number of charges remaining, or null if no count should be shown.
	 */
	public static Integer getCharges(ItemComposition item, ItemChargesConfig config)
	{
		if (EXCLUDED_ITEMS.contains(item.getId()))
		{
			return null;
		}

		List<String> actions = Arrays.asList(item.getInventoryActions());
		boolean isOther = !actions.contains("Rub") && !actions.contains("Drink") && !UNDRINKABLE_POTIONS.contains(item.getId());

		if (config.showTeleportCharges() && actions.contains("Rub")
				|| config.showDrinkablePotionDoses() && actions.contains("Drink")
				|| config.showUndrinkablePotionDoses() && UNDRINKABLE_POTIONS.contains(item.getId())
				|| config.showOtherCharges() && isOther)
		{
			Matcher matcher = Pattern.compile(CHARGES_REGEX).matcher(item.getName());
			if (matcher.find())
			{
				String match = matcher.group();
				return Integer.parseInt(match.substring(0, match.length() - 1));
			}
		}

		return null;
	}
}
