/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.lootrecorder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum UniqueItem
{
	// Barrows Uniques
	// Ahrim
	AHRIMS_HOOD("Ahrim's hood", ItemID.AHRIMS_HOOD, "Barrows", "Ahrims"),
	AHRIMS_ROBETOP("Ahrim's robetop", ItemID.AHRIMS_ROBETOP, "Barrows", "Ahrims"),
	AHRIMS_ROBESKIRT("Ahrim's robeskirt", ItemID.AHRIMS_ROBESKIRT, "Barrows", "Ahrims"),
	AHRIMS_STAFF("Ahrim's staff", ItemID.AHRIMS_STAFF, "Barrows", "Ahrims"),
	// Dharok
	DHAROKS_HELM("Dharok's helm", ItemID.DHAROKS_HELM, "Barrows", "Dharoks"),
	DHAROKS_PLATEBODY("Dharok's platebody", ItemID.DHAROKS_PLATEBODY, "Barrows", "Dharoks"),
	DHAROKS_PLATELEGS("Dharok's platelegs", ItemID.DHAROKS_PLATELEGS, "Barrows", "Dharoks"),
	DHAROKS_GREATAXE("Dharok's greataxe", ItemID.DHAROKS_GREATAXE, "Barrows", "Dharoks"),
	// Guthans
	GUTHANS_HELM("Guthan's helm", ItemID.GUTHANS_HELM, "Barrows", "Guthans"),
	GUTHANS_PLATEBODY("Guthan's platebody", ItemID.GUTHANS_PLATEBODY, "Barrows", "Guthans"),
	GUTHANS_CHAINSKIRT("Guthan's Chainskirt", ItemID.GUTHANS_CHAINSKIRT, "Barrows", "Guthans"),
	GUTHANS_WARSPEAR("Guthan's warspear", ItemID.GUTHANS_WARSPEAR, "Barrows", "Guthans"),
	// Karils
	KARILS_COIF("Karil's coif", ItemID.KARILS_COIF, "Barrows", "Karils"),
	KARILS_LEATHERTOP("Karil's leathertop", ItemID.KARILS_LEATHERTOP, "Barrows", "Karils"),
	KARILS_LEATHERSKIRT("Karil's leatherskirt", ItemID.KARILS_LEATHERSKIRT, "Barrows", "Karils"),
	KARILS_CROSSBOW("Karil's crossbow ", ItemID.KARILS_CROSSBOW, "Barrows", "Karils"),
	//Torag
	TORAGS_HELM("Torag's helm", ItemID.TORAGS_HELM, "Barrows", "Torags"),
	TORAGS_PLATEBODY("Torags's platebody", ItemID.TORAGS_PLATEBODY, "Barrows", "Torags"),
	TORAGS_PLATELEGS("Torags's platelegs", ItemID.TORAGS_PLATELEGS, "Barrows", "Torags"),
	TORAGS_HAMMERS("Torag's hammers", ItemID.TORAGS_HAMMERS, "Barrows", "Torags"),
	// Veracs
	VERACS_HELM("Verac's helm", ItemID.VERACS_HELM, "Barrows", "Veracs"),
	VERACS_BRASSARD("Verac's brassard", ItemID.VERACS_BRASSARD, "Barrows", "Veracs"),
	VERACS_PLATESKIRT("Verac's plateskirt", ItemID.VERACS_PLATESKIRT, "Barrows", "Veracs"),
	VERACS_FLAIL("Verac's flail", ItemID.VERACS_FLAIL, "Barrows", "Veracs"),

	// Raids Uniques
	// Mage
	KODAI_INSIGNIA("Kodai insignia", ItemID.KODAI_INSIGNIA, "Raids", "Mage"),
	ANCESTRAL_HAT("Ancestral hat", ItemID.ANCESTRAL_HAT, "Raids", "Mage"),
	ANCESTRAL_ROBE_TOP("Ancestral robe top", ItemID.ANCESTRAL_ROBE_TOP, "Raids", "Mage"),
	ANCESTRAL_ROBE_BOTTOM("Ancestral robe bottom", ItemID.ANCESTRAL_ROBE_BOTTOM, "Raids", "Mage"),
	// Range
	DRAGON_THROWNAXE("Dragon thrownaxe", ItemID.DRAGON_THROWNAXE, "Raids", "Range"),
	DRAGON_HUNTER_CROSSBOW("Dragon hunter crossbow", ItemID.DRAGON_HUNTER_CROSSBOW, "Raids", "Range"),
	TWISTED_BUCKLER("Twisted buckler", ItemID.TWISTED_BUCKLER, "Raids", "Range"),
	TWISTED_BOW("Twisted bow", ItemID.TWISTED_BOW, "Raids", "Range"),
	// Melee
	DRAGON_SWORD("Dragon sword", ItemID.DRAGON_SWORD, "Raids", "Melee"),
	DRAGON_CLAWS("Dragon claws", ItemID.DRAGON_CLAWS, "Raids", "Melee"),
	DINHS_BULWARK("Dinh's bulwark", ItemID.DINHS_BULWARK, "Raids", "Melee"),
	ELDER_MAUL("Elder maul", ItemID.ELDER_MAUL, "Raids", "Melee"),
	// Prayers
	DEXTEROUS_PRAYER_SCROLL("Dexterous prayer scroll", ItemID.DEXTEROUS_PRAYER_SCROLL, "Raids", "Prayer"),
	TORN_PRAYER_SCROLL("Torn prayer scroll", ItemID.TORN_PRAYER_SCROLL, "Raids", "Prayer"),
	ARCANE_PRAYER_SCROLL("Arcane prayer scroll", ItemID.ARCANE_PRAYER_SCROLL, "Raids", "Prayer"),
	// Other
	DRAGON_HARPOON("Dragon harpoon", ItemID.DRAGON_HARPOON, "Raids", "Other"),
	DARK_RELIC("Dark relic", ItemID.DARK_RELIC, "Raids", "Other");


	private final String name;
	private final int itemID;
	private final String activity;
	private final String setName;

	private static final Map<String, UniqueItem> byName = buildNameMap();

	public static UniqueItem getByName(String name)
	{
		return byName.get(name.toUpperCase());
	}

	private static Map<String, UniqueItem> buildNameMap()
	{
		Map<String, UniqueItem> byName = new HashMap<>();
		for (UniqueItem item : values())
		{
			byName.put(item.getName().toUpperCase(), item);
		}

		return byName;
	}

	private static final Map<String, ArrayList<UniqueItem>> byActivityName = buildActivityMap();

	public static ArrayList<UniqueItem> getByActivityName(String name)
	{
		return byActivityName.get(name.toUpperCase());
	}

	private static Map<String, ArrayList<UniqueItem>> buildActivityMap()
	{
		Map<String, ArrayList<UniqueItem>> byName = new HashMap<>();
		for (UniqueItem item : values())
		{
			byName.computeIfAbsent(item.getActivity().toUpperCase(), e -> new ArrayList<UniqueItem>()).add(item);
		}

		return byName;
	}

	private static final Map<String, ArrayList<UniqueItem>> bySetName = buildSetMap();

	public static ArrayList<UniqueItem> getBySetName(String name)
	{
		return bySetName.get(name.toUpperCase());
	}

	private static Map<String, ArrayList<UniqueItem>> buildSetMap()
	{
		Map<String, ArrayList<UniqueItem>> byName = new HashMap<>();
		for (UniqueItem item : values())
		{
			byName.computeIfAbsent(item.getSetName().toUpperCase(), e -> new ArrayList<UniqueItem>()).add(item);
		}

		return byName;
	}


	static Map<String, ArrayList<UniqueItem>> createSetMap(ArrayList<UniqueItem> items)
	{
		Map<String, ArrayList<UniqueItem>> setNames = new HashMap<String, ArrayList<UniqueItem>>();
		for (UniqueItem item : items)
		{
			setNames.computeIfAbsent(item.getSetName().toUpperCase(), e -> new ArrayList<UniqueItem>()).add(item);
		}
		return setNames;
	}
}