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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum UniqueItem
{
	// Barrows Uniques
	// Ahrim
	AHRIMS_HOOD("Ahrim's hood", ItemID.AHRIMS_HOOD, "Barrows", "Ahrims", 0),
	AHRIMS_ROBETOP("Ahrim's robetop", ItemID.AHRIMS_ROBETOP, "Barrows", "Ahrims", 0),
	AHRIMS_ROBESKIRT("Ahrim's robeskirt", ItemID.AHRIMS_ROBESKIRT, "Barrows", "Ahrims", 0),
	AHRIMS_STAFF("Ahrim's staff", ItemID.AHRIMS_STAFF, "Barrows", "Ahrims", 0),
	// Dharok
	DHAROKS_HELM("Dharok's helm", ItemID.DHAROKS_HELM, "Barrows", "Dharoks", 1),
	DHAROKS_PLATEBODY("Dharok's platebody", ItemID.DHAROKS_PLATEBODY, "Barrows", "Dharoks", 1),
	DHAROKS_PLATELEGS("Dharok's platelegs", ItemID.DHAROKS_PLATELEGS, "Barrows", "Dharoks", 1),
	DHAROKS_GREATAXE("Dharok's greataxe", ItemID.DHAROKS_GREATAXE, "Barrows", "Dharoks", 1),
	// Guthans
	GUTHANS_HELM("Guthan's helm", ItemID.GUTHANS_HELM, "Barrows", "Guthans", 2),
	GUTHANS_PLATEBODY("Guthan's platebody", ItemID.GUTHANS_PLATEBODY, "Barrows", "Guthans", 2),
	GUTHANS_CHAINSKIRT("Guthan's Chainskirt", ItemID.GUTHANS_CHAINSKIRT, "Barrows", "Guthans", 2),
	GUTHANS_WARSPEAR("Guthan's warspear", ItemID.GUTHANS_WARSPEAR, "Barrows", "Guthans", 2),
	// Karils
	KARILS_COIF("Karil's coif", ItemID.KARILS_COIF, "Barrows", "Karils", 3),
	KARILS_LEATHERTOP("Karil's leathertop", ItemID.KARILS_LEATHERTOP, "Barrows", "Karils", 3),
	KARILS_LEATHERSKIRT("Karil's leatherskirt", ItemID.KARILS_LEATHERSKIRT, "Barrows", "Karils", 3),
	KARILS_CROSSBOW("Karil's crossbow ", ItemID.KARILS_CROSSBOW, "Barrows", "Karils", 3),
	//Torag
	TORAGS_HELM("Torag's helm", ItemID.TORAGS_HELM, "Barrows", "Torags", 4),
	TORAGS_PLATEBODY("Torags's platebody", ItemID.TORAGS_PLATEBODY, "Barrows", "Torags", 4),
	TORAGS_PLATELEGS("Torags's platelegs", ItemID.TORAGS_PLATELEGS, "Barrows", "Torags", 4),
	TORAGS_HAMMERS("Torag's hammers", ItemID.TORAGS_HAMMERS, "Barrows", "Torags", 4),
	// Veracs
	VERACS_HELM("Verac's helm", ItemID.VERACS_HELM, "Barrows", "Veracs", 5),
	VERACS_BRASSARD("Verac's brassard", ItemID.VERACS_BRASSARD, "Barrows", "Veracs", 5),
	VERACS_PLATESKIRT("Verac's plateskirt", ItemID.VERACS_PLATESKIRT, "Barrows", "Veracs", 5),
	VERACS_FLAIL("Verac's flail", ItemID.VERACS_FLAIL, "Barrows", "Veracs", 5),

	// Raids Uniques
	// Mage
	KODAI_INSIGNIA("Kodai insignia", ItemID.KODAI_INSIGNIA, "Raids", "Mage", 0),
	ANCESTRAL_HAT("Ancestral hat", ItemID.ANCESTRAL_HAT, "Raids", "Mage", 0),
	ANCESTRAL_ROBE_TOP("Ancestral robe top", ItemID.ANCESTRAL_ROBE_TOP, "Raids", "Mage", 0),
	ANCESTRAL_ROBE_BOTTOM("Ancestral robe bottom", ItemID.ANCESTRAL_ROBE_BOTTOM, "Raids", "Mage", 0),
	// Range
	DRAGON_THROWNAXE("Dragon thrownaxe", ItemID.DRAGON_THROWNAXE, "Raids", "Range", 1),
	DRAGON_HUNTER_CROSSBOW("Dragon hunter crossbow", ItemID.DRAGON_HUNTER_CROSSBOW, "Raids", "Range", 1),
	TWISTED_BUCKLER("Twisted buckler", ItemID.TWISTED_BUCKLER, "Raids", "Range", 1),
	TWISTED_BOW("Twisted bow", ItemID.TWISTED_BOW, "Raids", "Range", 1),
	// Melee
	DRAGON_SWORD("Dragon sword", ItemID.DRAGON_SWORD, "Raids", "Melee", 2),
	DRAGON_CLAWS("Dragon claws", ItemID.DRAGON_CLAWS, "Raids", "Melee", 2),
	DINHS_BULWARK("Dinh's bulwark", ItemID.DINHS_BULWARK, "Raids", "Melee", 2),
	ELDER_MAUL("Elder maul", ItemID.ELDER_MAUL_21003, "Raids", "Melee", 2),
	// Prayers
	TORN_PRAYER_SCROLL("Torn prayer scroll", ItemID.TORN_PRAYER_SCROLL, "Raids", "Prayer", 3),
	ARCANE_PRAYER_SCROLL("Arcane prayer scroll", ItemID.ARCANE_PRAYER_SCROLL, "Raids", "Prayer", 3),
	DEXTEROUS_PRAYER_SCROLL("Dexterous prayer scroll", ItemID.DEXTEROUS_PRAYER_SCROLL, "Raids", "Prayer", 3),
	// Other
	DRAGON_HARPOON("Dragon harpoon", ItemID.DRAGON_HARPOON, "Raids", "Other", 4),
	DARK_RELIC("Dark relic", ItemID.DARK_RELIC, "Raids", "Other", 4),

	// Zulrah
	// Uniques
	TANZANITE_FANG("Tanzanite fang", ItemID.TANZANITE_FANG, "Zulrah", "Uniques", 0),
	MAGIC_FANG("Magic fang", ItemID.MAGIC_FANG, "Zulrah", "Uniques", 0),
	SERPENTINE_VISAGE("Serpentine visage", ItemID.SERPENTINE_VISAGE, "Zulrah", "Uniques", 0),
	UNCUT_ONYX("Uncut onyx", ItemID.UNCUT_ONYX, "Zulrah", "Uniques", 0),
	// Rares
	PET_SNAKELING("Pet snakeling", ItemID.PET_SNAKELING, "Zulrah", "Rares", 1),
	TANZANITE_MUTAGEN("Tanzanite mutagen", ItemID.TANZANITE_MUTAGEN, "Zulrah", "Rares", 1),
	MAGMA_MUTAGEN("Magma mutagen", ItemID.MAGMA_MUTAGEN, "Zulrah", "Rares", 1),
	JAR_OF_SWAMP("Jar of swamp", ItemID.JAR_OF_SWAMP, "Zulrah", "Rares", 1);

	private final String name;
	private final int itemID;
	private final String activity;
	private final String setName;
	private final int position;

	// Get a specific UniqueItem by Name
	// Unused ATM
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

	// Returns an array of UniqueItems by `activity`
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

	// Return an array of UniqueItems by `setName`
	// Unused ATM
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

	// Take a list of UniqueItems and maps them by Position
	static Map<Integer, ArrayList<UniqueItem>> createPositionSetMap(ArrayList<UniqueItem> items)
	{
		Map<Integer, ArrayList<UniqueItem>> setNames = new HashMap<Integer, ArrayList<UniqueItem>>();
		for (UniqueItem item : items)
		{
			setNames.computeIfAbsent(item.getPosition(), e -> new ArrayList<UniqueItem>()).add(item);
		}
		return setNames;
	}
}