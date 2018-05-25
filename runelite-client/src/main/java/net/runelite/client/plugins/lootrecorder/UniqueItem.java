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
	// Shared "Uniques" (Dropped by multiple activities)
	// God Wars
	GODSWORD_SHARD_1("Godsword shard 1", ItemID.GODSWORD_SHARD_1, "Armadyl", "Bandos", "Saradomin", "Zammy"),
	GODSWORD_SHARD_2("Godsword shard 2", ItemID.GODSWORD_SHARD_2, "Armadyl", "Bandos", "Saradomin", "Zammy"),
	GODSWORD_SHARD_3("Godsword shard 3", ItemID.GODSWORD_SHARD_3, "Armadyl", "Bandos", "Saradomin", "Zammy"),
	// Wildy
	PET_CHAOS_ELEMENTAL("Pet chaos elemental", ItemID.PET_CHAOS_ELEMENTAL, "Chaos Elemental", "Chaos Fanatic"),
	// MYSTERIOUS_EMBLEM("Mysterious emblem", ItemID.MYSTERIOUS_EMBLEM , ""),
	CURVED_BONE("Curved bone", ItemID.CURVED_BONE, "Callisto", "Vet'ion", "Venenatis", "Giant Mole"),
	DRAGON_PICKAXE("Dragon pickaxe", ItemID.DRAGON_PICKAXE , "Callisto", "Vet'ion", "Venenatis", "King Black Dragon"),
	DRAGON_2H_SWORD("Dragon 2h sword", ItemID.DRAGON_2H_SWORD , "Callisto", "Vet'ion", "Venenatis", "Kalphite Queen"),
	// Other
	DRAGON_CHAINBODY("Dragon chainbody", ItemID.DRAGON_CHAINBODY, "Thermonuclear Smoke Devil", "Kalphite Queen"),
	DRAGON_AXE("Dragon axe", ItemID.DRAGON_AXE, "Dagannoth Rex", "Dagannoth Prime", "Dagannoth Supreme"),
	UNCUT_ONYX("Uncut onyx", ItemID.UNCUT_ONYX, "Zulrah", "Skotizo"),


	// Unique Items
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
	TANZANITE_FANG("Tanzanite fang", ItemID.TANZANITE_FANG, "Zulrah", "Uniques", -1),
	MAGIC_FANG("Magic fang", ItemID.MAGIC_FANG, "Zulrah", "Uniques", -1),
	SERPENTINE_VISAGE("Serpentine visage", ItemID.SERPENTINE_VISAGE, "Zulrah", "Uniques", -1),
	// Rares
	PET_SNAKELING("Pet snakeling", ItemID.PET_SNAKELING, "Zulrah", "Rares", 0),
	TANZANITE_MUTAGEN("Tanzanite mutagen", ItemID.TANZANITE_MUTAGEN, "Zulrah", "Rares", 0),
	MAGMA_MUTAGEN("Magma mutagen", ItemID.MAGMA_MUTAGEN, "Zulrah", "Rares", 0),
	JAR_OF_SWAMP("Jar of swamp", ItemID.JAR_OF_SWAMP, "Zulrah", "Rares", 0),

	// Vorkath
	DRAGONBONE_NECKLACE("Dragonbone necklace", ItemID.DRAGONBONE_NECKLACE, "Vorkath", "Uniques", 0),
	VORKATHS_HEAD("Vorkath's head", ItemID.VORKATHS_HEAD, "Vorkath", "Uniques", 0),
	JAR_OF_DECAY("Jar of decay", ItemID.JAR_OF_DECAY, "Vorkath", "Uniques", 0),
	VORKI("Vorki", ItemID.VORKI, "Vorkath", "Uniques", 0),
	SKELETAL_VISAGE("Skeletal visage", ItemID.SKELETAL_VISAGE, "Vorkath", "Uniques", 0),


	// God Wars Dungeon
	// Kree'arra (Armadyl)
	ARMADYL_HELMET("Armadyl helmet", ItemID.ARMADYL_HELMET, "Armadyl", "Uniques", 0),
	ARMADYL_CHESTPLATE("Armadyl chestplate", ItemID.ARMADYL_CHESTPLATE, "Armadyl", "Uniques", 0),
	ARMADYL_CHAINSKIRT("Armadyl chainskirt", ItemID.ARMADYL_CHAINSKIRT, "Armadyl", "Uniques", 0),
	ARMADYL_HILT("Armadyl hilt", ItemID.ARMADYL_HILT, "Armadyl", "Uniques", 0),
	PET_KREEARRA("Pet Kree'arra", ItemID.PET_KREEARRA, "Armadyl", "Pet", -1),
	// General Graardor (Bandos)
	BANDOS_CHESTPLATE("Bandos chestplate", ItemID.BANDOS_CHESTPLATE, "Bandos", "Uniques", 0),
	BANDOS_TASSETS("Bandos tassets", ItemID.BANDOS_TASSETS, "Bandos", "Uniques", 0),
	BANDOS_BOOTS("Bandos boots", ItemID.BANDOS_BOOTS, "Bandos", "Uniques", 0),
	BANDOS_HILT("Bandos hilt", ItemID.BANDOS_HILT, "Bandos", "Uniques", 0),
	PET_GENERAL_GRAARDOR("Pet general graardor", ItemID.PET_GENERAL_GRAARDOR, "Bandos", "Pet", -1),
	// Command Zilyana (Saradomin)
	SARADOMIN_SWORD("Saradomin sword", ItemID.SARADOMIN_SWORD, "Saradomin", "Uniques", 0),
	ARMADYL_CROSSBOW("Armadyl crossbow", ItemID.ARMADYL_CROSSBOW, "Saradomin", "Uniques", 0),
	SARADOMINS_LIGHT("Saradomins light", ItemID.SARADOMINS_LIGHT, "Saradomin", "Uniques", 0),
	SARADOMIN_HILT("Saradomin hilt", ItemID.SARADOMIN_HILT, "Saradomin", "Uniques", 0),
	PET_ZILYANA("Pet zilyana", ItemID.PET_ZILYANA, "Saradomin", "Pet", -1),
	// K'ril Tsutsaroth (Zammy)
	STEAM_BATTLESTAFF("Steam battlestaff", ItemID.STEAM_BATTLESTAFF, "Zammy", "Uniques", 0),
	STAFF_OF_THE_DEAD("Staff of the dead", ItemID.STAFF_OF_THE_DEAD, "Zammy", "Uniques", 0),
	ZAMORAKIAN_SPEAR("Zamorakian spear", ItemID.ZAMORAKIAN_SPEAR, "Zammy", "Uniques", 0),
	ZAMORAK_HILT("Zamorak hilt", ItemID.ZAMORAK_HILT, "Zammy", "Uniques", 0),
	PET_KRIL_TSUTSAROTH("Pet k'ril tsutsaroth", ItemID.PET_KRIL_TSUTSAROTH, "Zammy", "Pet", -1),


	// Wildy Bosses
	// Vet'ion
	RING_OF_THE_GODS("Ring of the gods", ItemID.RING_OF_THE_GODS , "Vet'ion", "Uniques", 0),
	VETION_JR("Vet'ion jr.", ItemID.VETION_JR , "Vet'ion", "Uniques", 0),
	SKELETON_CHAMPION_SCROLL("Skeleton champion scroll", ItemID.SKELETON_CHAMPION_SCROLL , "Vet'ion", "Uniques", 0),
	// Venenatis
	TREASONOUS_RING("Treasonous ring", ItemID.TREASONOUS_RING , "Venenatis", "Uniques", 0),
	VENENATIS_SPIDERLING("Venenatis spiderling", ItemID.VENENATIS_SPIDERLING , "Venenatis", "Uniques", 0),
	// Callisto
	TYRANNICAL_RING("Tyrannical ring", ItemID.TYRANNICAL_RING , "Callisto", "Uniques", 0),
	CALLISTO_CUB("Callisto cub", ItemID.CALLISTO_CUB , "Callisto", "Uniques", 0),
	// Chaos Elemental Uniques are all in Shared
	// Chaos Fanatic
	ODIUM_SHARD_1("Odium shard 1", ItemID.ODIUM_SHARD_1 , "Chaos Fanatic", "Uniques", -1),
	MALEDICTION_SHARD_1("Malediction shard 1", ItemID.MALEDICTION_SHARD_1 , "Chaos Fanatic", "Uniques", -1),
	// Crazy Archaeologist
	ODIUM_SHARD_2("Odium shard 2", ItemID.ODIUM_SHARD_2 , "Crazy Archaeologist", "Uniques", 0),
	MALEDICTION_SHARD_2("Malediction shard 2", ItemID.MALEDICTION_SHARD_2 , "Crazy Archaeologist", "Uniques", 0),
	FEDORA("Fedora", ItemID.FEDORA , "Crazy Archaeologist", "Uniques", 0),
	// Scorpia
	ODIUM_SHARD_3("Odium shard 3", ItemID.ODIUM_SHARD_3 , "Scorpia", "Uniques", 0),
	MALEDICTION_SHARD_3("Malediction shard 3", ItemID.MALEDICTION_SHARD_3 , "Scorpia", "Uniques", 0),
	SCORPIAS_OFFSPRING("Scorpia's offspring", ItemID.SCORPIAS_OFFSPRING , "Scorpia", "Uniques", 0),
	// King Black Dragon,
	KBD_HEADS("Kbd heads", ItemID.KBD_HEADS , "King Black Dragon", "Uniques", -1),
	DRACONIC_VISAGE("Draconic visage", ItemID.DRACONIC_VISAGE , "King Black Dragon", "Uniques", -1),
	PRINCE_BLACK_DRAGON("Prince black dragon", ItemID.PRINCE_BLACK_DRAGON , "King Black Dragon", "Uniques", -1),

	// Slayer Bosses
	// Skotizo
	DARK_CLAW("Dark claw", ItemID.DARK_CLAW, "Skotizo", "Uniques", -1),
	SKOTOS("Skotos", ItemID.SKOTOS, "Skotizo", "Uniques", -1),
	JAR_OF_DARKNESS("Jar of darkness", ItemID.JAR_OF_DARKNESS, "Skotizo", "Uniques", -1),
	// Grotesque Guardians
	GRANITE_GLOVES("Granite gloves", ItemID.GRANITE_GLOVES, "Grotesque Guardians", "Uniques", 0),
	GRANITE_RING("Granite ring", ItemID.GRANITE_RING, "Grotesque Guardians", "Uniques", 0),
	GRANITE_HAMMER("Granite hammer", ItemID.GRANITE_HAMMER, "Grotesque Guardians", "Uniques", 0),
	BLACK_TOURMALINE_CORE("Black touramline core", ItemID.BLACK_TOURMALINE_CORE, "Grotesque Guardians", "Uniques 2", 1),
	NOON("Noon", ItemID.NOON, "Grotesque Guardians", "Uniques 2", 1),
	JAR_OF_STONE("Jar of stone", ItemID.JAR_OF_STONE, "Grotesque Guardians", "Uniques 2", 1),
	// Abyssal Sire
	UNSIRED("Unsired", ItemID.UNSIRED, "Abyssal Sire", "Uniques", 0),
	BLUDGEON_CLAW("Bludgeon claw", ItemID.BLUDGEON_CLAW, "Abyssal Sire", "Uniques", 0),
	BLUDGEON_SPINE("Bludgeon spine", ItemID.BLUDGEON_SPINE, "Abyssal Sire", "Uniques", 0),
	BLUDGEON_AXON("Bludgeon axon", ItemID.BLUDGEON_AXON, "Abyssal Sire", "Uniques", 0),
	ABYSSAL_DAGGER("Abyssal dagger", ItemID.ABYSSAL_DAGGER, "Abyssal Sire", "Uniques 2", 1),
	ABYSSAL_WHIP("Abyssal whip", ItemID.ABYSSAL_WHIP, "Abyssal Sire", "Uniques 2", 1),
	ABYSSAL_ORPHAN("Abyssal orphan", ItemID.ABYSSAL_ORPHAN, "Abyssal Sire", "Uniques 2", 1),
	JAR_OF_MIASMA("Jar of miasma", ItemID.JAR_OF_MIASMA, "Abyssal Sire", "Uniques 2", 1),
	ABYSSAL_HEAD("Abyssal head", ItemID.ABYSSAL_HEAD, "Abyssal Sire", "Uniques 3", 2),
	// Kraken
	TRIDENT_OF_THE_SEAS_FULL("Trident of the seas (full)", ItemID.TRIDENT_OF_THE_SEAS_FULL, "Kraken", "Uniques", 0),
	KRAKEN_TENTACLE("Kraken tentacle", ItemID.KRAKEN_TENTACLE, "Kraken", "Uniques", 0),
	JAR_OF_DIRT("Jar of dirt", ItemID.JAR_OF_DIRT, "Kraken", "Uniques", 0),
	PET_KRAKEN("Pet kraken", ItemID.PET_KRAKEN, "Kraken", "Uniques", 0),
	// Cerberus
	PRIMORDIAL_CRYSTAL("Primordial crystal", ItemID.PRIMORDIAL_CRYSTAL, "Cerberus", "Uniques", 0),
	PEGASIAN_CRYSTAL("Pegasian crystal", ItemID.PEGASIAN_CRYSTAL, "Cerberus", "Uniques", 0),
	ETERNAL_CRYSTAL("Eternal crystal", ItemID.ETERNAL_CRYSTAL, "Cerberus", "Uniques", 0),
	SMOULDERING_STONE("Smouldering stone", ItemID.SMOULDERING_STONE, "Cerberus", "Uniques", 0),
	JAR_OF_SOULS("Jar of souls", ItemID.JAR_OF_SOULS, "Cerberus", "Uniques", 0),
	HELLPUPPY("Hellpuppy", ItemID.HELLPUPPY, "Cerberus", "Uniques", 0),
	// Thermonuclear Smoke Devil
	SMOKE_BATTLESTAFF("Smoke battlestaff", ItemID.SMOKE_BATTLESTAFF, "Thermonuclear Smoke Devil", "Uniques", -1),
	OCCULT_NECKLACE("Occult necklace", ItemID.OCCULT_NECKLACE, "Thermonuclear Smoke Devil", "Uniques", -1),
	PET_SMOKE_DEVIL("Pet smoke devil", ItemID.PET_SMOKE_DEVIL, "Thermonuclear Smoke Devil", "Uniques", -1),


	// Other Bosses
	// Giant Mole
	BABY_MOLE("Baby Mole", ItemID.BABY_MOLE, "Giant Mole", "Uniques", -1),
	// Kalphite Queen
	KQ_HEAD("Kq head", ItemID.KQ_HEAD, "Kalphite Queen", "Uniques", -1),
	JAR_OF_SAND("Jar of sand", ItemID.JAR_OF_SAND, "Kalphite Queen", "Uniques", -1),
	KALPHITE_PRINCESS("Kalphite princess", ItemID.KALPHITE_PRINCESS, "Kalphite Queen", "Uniques", -1),
	// Corporeal Beast
	SPIRIT_SHIELD("Spirit shield", ItemID.SPIRIT_SHIELD, "Corporeal Beast", "Uniques", 0),
	HOLY_ELIXIR("Holy elixir", ItemID.HOLY_ELIXIR, "Corporeal Beast", "Uniques", 0),
	PET_DARK_CORE("Pet dark core", ItemID.PET_DARK_CORE, "Corporeal Beast", "Uniques", 0),
	SPECTRAL_SIGIL("Spectral sigil", ItemID.SPECTRAL_SIGIL, "Corporeal Beast", "Sigil", 1),
	ARCANE_SIGIL("Arcane sigil", ItemID.ARCANE_SIGIL, "Corporeal Beast", "Sigil", 1),
	ELYSIAN_SIGIL("Elysian sigil", ItemID.ELYSIAN_SIGIL, "Corporeal Beast", "Sigil", 1),
	// Dagannoth Rex
	RING_OF_LIFE("Ring of life", ItemID.RING_OF_LIFE, "Dagannoth Rex", "Uniques", -1),
	WARRIOR_RING("Warrior ring", ItemID.WARRIOR_RING, "Dagannoth Rex", "Uniques", -1),
	BERSERKER_RING("Berserk ring", ItemID.BERSERKER_RING, "Dagannoth Rex", "Uniques", -1),
	PET_DAGANNOTH_REX("Pet dagannoth rex", ItemID.PET_DAGANNOTH_REX, "Dagannoth Rex", "Uniques", -1),
	// Dagannoth Prime
	MUD_BATTLESTAFF("Mud battlestaff", ItemID.MUD_BATTLESTAFF, "Dagannoth Prime", "Uniques", -1),
	SEERS_RING("Seers ring", ItemID.SEERS_RING, "Dagannoth Prime", "Uniques", -1),
	PET_DAGANNOTH_PRIME("Pet dagannoth prime", ItemID.PET_DAGANNOTH_PRIME, "Dagannoth Prime", "Uniques", -1),
	// Dagannoth Supreme
	SEERCULL("Seercrull", ItemID.SEERCULL, "Dagannoth Supreme", "Uniques", -1),
	ARCHERS_RING("Archers ring", ItemID.ARCHERS_RING, "Dagannoth Supreme", "Uniques", -1),
	PET_DAGANNOTH_SUPREME("Pet dagannoth supreme", ItemID.PET_DAGANNOTH_SUPREME, "Dagannoth Supreme", "Uniques", -1);


	UniqueItem(String n, int id, String... activities)
	{
		this.name = n;
		this.itemID = id;
		this.activities = activities;
		this.setName = "Shared";
		this.position = -1;
	}

	UniqueItem(String n, int id, String a, String set, int position)
	{
		this.name = n;
		this.itemID = id;
		this.activities = new String[]{a};
		this.setName = set;
		this.position = position;

	}


	private final String name;
	private final int itemID;
	private final String[] activities;
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
			String[] activities = item.getActivities();
			for (String activity : activities)
			{
				byName.computeIfAbsent(activity.toUpperCase(), e -> new ArrayList<UniqueItem>()).add(item);
			}

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
		// If no unique items for this tab
		if (items == null)
			return setNames;
		for (UniqueItem item : items)
		{
			setNames.computeIfAbsent(item.getPosition(), e -> new ArrayList<UniqueItem>()).add(item);
		}
		return setNames;
	}
}