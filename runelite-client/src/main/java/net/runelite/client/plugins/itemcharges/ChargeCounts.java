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
	private static final Pattern CHARGES_REGEX = Pattern.compile("(\\d+)\\)");

	/** Non-chargeable items which would otherwise be matched by CHARGES_REGEX. */
	private static final RangeSet<Integer> EXCLUDED_ITEMS = TreeRangeSet.create();
	/** Potions which lack a Drink menu action but can hold multiple doses. */
	private static final RangeSet<Integer> UNDRINKABLE_POTIONS = TreeRangeSet.create();

	static
	{
		EXCLUDED_ITEMS.add(Range.closed(ItemID.SHEEP_BONES_1, ItemID.SHEEP_BONES_4));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.RUNE_HERALDIC_HELM, ItemID.RUNE_HERALDIC_HELM_8494));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.STEEL_HERALDIC_HELM, ItemID.STEEL_HERALDIC_HELM_8712));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.RUNE_KITESHIELD_8714, ItemID.RUNE_KITESHIELD_8744));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.STEEL_KITESHIELD_8746, ItemID.STEEL_KITESHIELD_8776));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.MYSTERIOUS_EMBLEM_TIER_2, ItemID.MYSTERIOUS_EMBLEM_TIER_10));
		EXCLUDED_ITEMS.add(Range.singleton(ItemID.RICKTORS_DIARY_7));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.SHAYZIEN_GLOVES_1, ItemID.SHAYZIEN_PLATEBODY_5));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.SHAYZIEN_SUPPLY_GLOVES_1, ItemID.SHAYZIEN_SUPPLY_PLATEBODY_5));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.SHAYZIEN_SUPPLY_SET_1, ItemID.SHAYZIEN_SUPPLY_SET_5));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.TORN_CLUE_SCROLL_PART_1, ItemID.TORN_CLUE_SCROLL_PART_3));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.RAW_PYSK_FISH_0, ItemID.PSYKK_BAT_6));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.ADAMANT_HERALDIC_HELM, ItemID.ADAMANT_HERALDIC_HELM_22189));
		EXCLUDED_ITEMS.add(Range.closed(ItemID.ADAMANT_KITESHIELD_22127, ItemID.ADAMANT_KITESHIELD_22157));

		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.SERUM_207_4, ItemID.SERUM_207_1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.SERUM_208_4, ItemID.SERUM_208_1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.OLIVE_OIL4, ItemID.OLIVE_OIL1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.SACRED_OIL4, ItemID.SACRED_OIL1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.COMPOST_POTION4, ItemID.COMPOST_POTION1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.GUTHIX_BALANCE4, ItemID.GUTHIX_BALANCE1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.HEALING_VIAL4, ItemID.HEALING_VIAL1));
		UNDRINKABLE_POTIONS.add(Range.closed(ItemID.VIAL_OF_TEARS_1, ItemID.VIAL_OF_TEARS_FULL));
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
		boolean isMisc = !actions.contains("Rub") && !actions.contains("Activate") && !actions.contains("Play")
				&& !actions.contains("Drink") && !UNDRINKABLE_POTIONS.contains(item.getId()) && !actions.contains("Remove-one");

		if (config.showTeleportCharges() && (actions.contains("Rub") || actions.contains("Activate") || actions.contains("Play"))
				|| config.showDrinkablePotionDoses() && actions.contains("Drink")
				|| config.showUndrinkablePotionDoses() && UNDRINKABLE_POTIONS.contains(item.getId())
				|| config.showBasketAndSackCounts() && actions.contains("Remove-one")
				|| config.showMiscItemCharges() && isMisc)
		{
			Matcher matcher = CHARGES_REGEX.matcher(item.getName());
			if (matcher.find())
			{
				return Integer.parseInt(matcher.group(1));
			}
		}

		return null;
	}
}
