/*
 * Copyright (c) 2018, Davis Cook <daviscook447@gmail.com>
 * Copyright (c) 2018, Daddy Dozer <Whitedylan7@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.suppliestracker;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static net.runelite.api.ItemID.*;

/**
 * The potential types that supplies can be along with a categorization function
 * that assigns the supplies to these categories
 */
@AllArgsConstructor
public enum ItemType
{
	FOOD("Food"),
	POTION("Potions"),
	RUNE("Runes"),
	AMMO("Ammo"),
	TELEPORT("Teleports"),
	COINS("Coins"),
	JEWELLERY("Jewellery"),
	CHARGES("Charges"),
	FARMING("Farming"),
	PRAYER("Prayer");

	@Getter(AccessLevel.PUBLIC)
	private String label;

	/**
	 * Takes an item and determines what ItemType it should categorize into
	 *
	 * @param item the item to determine category for
	 * @return our best guess for what category this item goes into
	 * note that if the guess is wrong (per say) it won't break anything because it will be
	 * consistently wrong but it could have an item that is clearly not food in the food section
	 */
	public static ItemType categorize(SuppliesTrackerItem item)
	{
		if (item.getName().contains("(4)"))
		{
			return ItemType.POTION;
		}
		else if ((item.getName().toLowerCase().contains("bones") && !item.getName().toLowerCase().contains(" to ")) ||
				item.getName().toLowerCase().contains("ensouled"))
		{
			return ItemType.PRAYER;
		}
		else if (item.getName().toLowerCase().contains("bolt") || item.getName().toLowerCase().contains("dart")
				|| item.getName().toLowerCase().contains(" arrow") || item.getName().toLowerCase().contains("javelin")
				|| item.getName().toLowerCase().contains("knive") || item.getName().toLowerCase().contains("throwing")
				|| item.getName().toLowerCase().contains("zulrah's scale") || item.getName().toLowerCase().contains("cannonball")
				|| item.getName().toLowerCase().contains("knife"))
		{
			return ItemType.AMMO;
		}
		else if (item.getName().toLowerCase().contains("rune"))
		{
			return ItemType.RUNE;
		}
		else if (item.getName().toLowerCase().contains("teleport"))
		{
			return ItemType.TELEPORT;
		}
		else if (item.getId() == COINS_995)
		{
			return ItemType.COINS;
		}
		else if (item.getName().toLowerCase().contains("ring of") || item.getName().toLowerCase().contains("amulet") ||
				item.getName().toLowerCase().contains("bracelet") || item.getName().toLowerCase().contains("necklace"))
		{
			return ItemType.JEWELLERY;
		}
		else if (item.getName().toLowerCase().contains(" sapling") || item.getName().toLowerCase().contains(" seed") ||
				item.getName().toLowerCase().contains("compost") || item.getName().toLowerCase().contains("plant cure"))
		{
			return ItemType.FARMING;
		}
		else if (item.getId() == SCYTHE_OF_VITUR || item.getId() == SANGUINESTI_STAFF ||
				item.getId() == TRIDENT_OF_THE_SEAS || item.getId() == TRIDENT_OF_THE_SWAMP ||
				item.getId() == BLADE_OF_SAELDOR)
		{
			return ItemType.CHARGES;
		}
		return ItemType.FOOD;
	}
}
