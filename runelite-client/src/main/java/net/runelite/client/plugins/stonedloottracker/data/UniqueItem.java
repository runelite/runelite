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
package net.runelite.client.plugins.stonedloottracker.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;

@RequiredArgsConstructor
@Getter
public enum UniqueItem
{
	// Shared "Uniques" (Dropped by multiple activities)
	// God Wars
	GODSWORD_SHARD_1("Godsword shard 1", ItemID.GODSWORD_SHARD_1, "Kree'arra", "General Graardor", "Commander Zilyana", "K'ril Tsutsaroth"),
	GODSWORD_SHARD_2("Godsword shard 2", ItemID.GODSWORD_SHARD_2, "Kree'arra", "General Graardor", "Commander Zilyana", "K'ril Tsutsaroth"),
	GODSWORD_SHARD_3("Godsword shard 3", ItemID.GODSWORD_SHARD_3, "Kree'arra", "General Graardor", "Commander Zilyana", "K'ril Tsutsaroth"),
	// Wildy
	PET_CHAOS_ELEMENTAL("Pet chaos elemental", ItemID.PET_CHAOS_ELEMENTAL, "Chaos Elemental", "Chaos Fanatic"),
	// MYSTERIOUS_EMBLEM("Mysterious emblem", ItemID.MYSTERIOUS_EMBLEM , ""),
	CURVED_BONE("Curved bone", ItemID.CURVED_BONE, "Callisto", "Vet'ion", "Venenatis", "Giant Mole"),
	DRAGON_PICKAXE("Dragon pickaxe", ItemID.DRAGON_PICKAXE , "Callisto", "Vet'ion", "Venenatis", "King Black Dragon", "Chaos Elemental"),
	DRAGON_2H_SWORD("Dragon 2h sword", ItemID.DRAGON_2H_SWORD , "Callisto", "Vet'ion", "Venenatis", "Kalphite Queen"),
	// Other
	DRAGON_CHAINBODY("Dragon chainbody", ItemID.DRAGON_CHAINBODY_3140, "Thermonuclear Smoke Devil", "Kalphite Queen"),
	DRAGON_AXE("Dragon axe", ItemID.DRAGON_AXE, "Dagannoth Rex", "Dagannoth Prime", "Dagannoth Supreme"),
	UNCUT_ONYX("Uncut onyx", ItemID.UNCUT_ONYX, "Zulrah", "Skotizo"),
	DRACONIC_VISAGE("Draconic visage", ItemID.DRACONIC_VISAGE, "Vorkath", "King Black Dragon"),

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
	KODAI_INSIGNIA("Kodai insignia", ItemID.KODAI_INSIGNIA, "Chambers of Xeric", "Mage", 0),
	ANCESTRAL_HAT("Ancestral hat", ItemID.ANCESTRAL_HAT, "Chambers of Xeric", "Mage", 0),
	ANCESTRAL_ROBE_TOP("Ancestral robe top", ItemID.ANCESTRAL_ROBE_TOP, "Chambers of Xeric", "Mage", 0),
	ANCESTRAL_ROBE_BOTTOM("Ancestral robe bottom", ItemID.ANCESTRAL_ROBE_BOTTOM, "Chambers of Xeric", "Mage", 0),
	// Range
	DRAGON_THROWNAXE("Dragon thrownaxe", ItemID.DRAGON_THROWNAXE, "Chambers of Xeric", "Range", 1),
	DRAGON_HUNTER_CROSSBOW("Dragon hunter crossbow", ItemID.DRAGON_HUNTER_CROSSBOW, "Chambers of Xeric", "Range", 1),
	TWISTED_BUCKLER("Twisted buckler", ItemID.TWISTED_BUCKLER, "Chambers of Xeric", "Range", 1),
	TWISTED_BOW("Twisted bow", ItemID.TWISTED_BOW, "Chambers of Xeric", "Range", 1),
	// Melee
	DRAGON_SWORD("Dragon sword", ItemID.DRAGON_SWORD, "Chambers of Xeric", "Melee", 2),
	DRAGON_CLAWS("Dragon claws", ItemID.DRAGON_CLAWS, "Chambers of Xeric", "Melee", 2),
	DINHS_BULWARK("Dinh's bulwark", ItemID.DINHS_BULWARK, "Chambers of Xeric", "Melee", 2),
	ELDER_MAUL("Elder maul", ItemID.ELDER_MAUL, "Chambers of Xeric", "Melee", 2),
	// Prayers
	TORN_PRAYER_SCROLL("Torn prayer scroll", ItemID.TORN_PRAYER_SCROLL, "Chambers of Xeric", "Prayer", 3),
	ARCANE_PRAYER_SCROLL("Arcane prayer scroll", ItemID.ARCANE_PRAYER_SCROLL, "Chambers of Xeric", "Prayer", 3),
	DEXTEROUS_PRAYER_SCROLL("Dexterous prayer scroll", ItemID.DEXTEROUS_PRAYER_SCROLL, "Chambers of Xeric", "Prayer", 3),
	// Other
	DRAGON_HARPOON("Dragon harpoon", ItemID.DRAGON_HARPOON, "Chambers of Xeric", "Other", 4),
	DARK_RELIC("Dark relic", ItemID.DARK_RELIC, "Chambers of Xeric", "Other", 4),

	// Raids 2 Unqiues (Theater of Blood)
	// Weapons / Pet
	GHRAZI_RAPIER("Ghrazi rapier", ItemID.GHRAZI_RAPIER, "Theatre of Blood", "Weapons", 0),
	SCYTHE_OF_VITUR_UNCHARGED("Scythe of vitur (uncharged)", ItemID.SCYTHE_OF_VITUR_UNCHARGED, "Theatre of Blood", "Weapons", 0),
	SANGUINESTI_STAFF_UNCHAGRED("Sanguinesti staff (uncharged)", ItemID.SANGUINESTI_STAFF_UNCHARGED, "Theatre of Blood", "Weapons", 0),
	LIL_ZIK("Lil' zik", ItemID.LIL_ZIK, "Theatre of Blood", "Weapons", 0),
	// Armor
	AVERNIC_DEFENDER_HILT("Avernic defender hilt", ItemID.AVERNIC_DEFENDER_HILT, "Theatre of Blood", "Armor", 1),
	JUSTICIAR_FACEGUARD("Justiciar faceguard", ItemID.JUSTICIAR_FACEGUARD, "Theatre of Blood", "Armor", 1),
	JUSTICIAR_CHESTGUARD("Justiciar chestguard", ItemID.JUSTICIAR_CHESTGUARD, "Theatre of Blood", "Armor", 1),
	JUSTICIAR_LEGGUARDS("Justiciar legguards", ItemID.JUSTICIAR_LEGGUARDS, "Theatre of Blood", "Armor", 1),


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
	VORKATHS_HEAD("Vorkath's head", ItemID.VORKATHS_HEAD_21907, "Vorkath", "Uniques", 0),
	JAR_OF_DECAY("Jar of decay", ItemID.JAR_OF_DECAY, "Vorkath", "Uniques", 0),
	SKELETAL_VISAGE("Skeletal visage", ItemID.SKELETAL_VISAGE, "Vorkath", "Uniques", -1),
	VORKI("Vorki", ItemID.VORKI, "Vorkath", "Uniques", -1),


	// God Wars Dungeon
	// Kree'arra (Armadyl)
	ARMADYL_HELMET("Armadyl helmet", ItemID.ARMADYL_HELMET, "Kree'arra", "Uniques", 0),
	ARMADYL_CHESTPLATE("Armadyl chestplate", ItemID.ARMADYL_CHESTPLATE, "Kree'arra", "Uniques", 0),
	ARMADYL_CHAINSKIRT("Armadyl chainskirt", ItemID.ARMADYL_CHAINSKIRT, "Kree'arra", "Uniques", 0),
	ARMADYL_HILT("Armadyl hilt", ItemID.ARMADYL_HILT, "Kree'arra", "Uniques", 0),
	PET_KREEARRA("Pet Kree'arra", ItemID.PET_KREEARRA, "Kree'arra", "Pet", -1),
	// General Graardor (Bandos)
	BANDOS_CHESTPLATE("Bandos chestplate", ItemID.BANDOS_CHESTPLATE, "General Graardor", "Uniques", 0),
	BANDOS_TASSETS("Bandos tassets", ItemID.BANDOS_TASSETS, "General Graardor", "Uniques", 0),
	BANDOS_BOOTS("Bandos boots", ItemID.BANDOS_BOOTS, "General Graardor", "Uniques", 0),
	BANDOS_HILT("Bandos hilt", ItemID.BANDOS_HILT, "General Graardor", "Uniques", 0),
	PET_GENERAL_GRAARDOR("Pet general graardor", ItemID.PET_GENERAL_GRAARDOR, "General Graardor", "Pet", -1),
	// Command Zilyana (Saradomin)
	SARADOMIN_SWORD("Saradomin sword", ItemID.SARADOMIN_SWORD, "Commander Zilyana", "Uniques", 0),
	ARMADYL_CROSSBOW("Armadyl crossbow", ItemID.ARMADYL_CROSSBOW, "Commander Zilyana", "Uniques", 0),
	SARADOMINS_LIGHT("Saradomins light", ItemID.SARADOMINS_LIGHT, "Commander Zilyana", "Uniques", 0),
	SARADOMIN_HILT("Saradomin hilt", ItemID.SARADOMIN_HILT, "Commander Zilyana", "Uniques", 0),
	PET_ZILYANA("Pet zilyana", ItemID.PET_ZILYANA, "Commander Zilyana", "Pet", -1),
	// K'ril Tsutsaroth (Zammy)
	STEAM_BATTLESTAFF("Steam battlestaff", ItemID.STEAM_BATTLESTAFF, "K'ril Tsutsaroth", "Uniques", 0),
	STAFF_OF_THE_DEAD("Staff of the dead", ItemID.STAFF_OF_THE_DEAD, "K'ril Tsutsaroth", "Uniques", 0),
	ZAMORAKIAN_SPEAR("Zamorakian spear", ItemID.ZAMORAKIAN_SPEAR, "K'ril Tsutsaroth", "Uniques", 0),
	ZAMORAK_HILT("Zamorak hilt", ItemID.ZAMORAK_HILT, "K'ril Tsutsaroth", "Uniques", 0),
	PET_KRIL_TSUTSAROTH("Pet k'ril tsutsaroth", ItemID.PET_KRIL_TSUTSAROTH, "K'ril Tsutsaroth", "Pet", -1),


	// Wildy Bosses
	// Vet'ion
	RING_OF_THE_GODS("Ring of the gods", ItemID.RING_OF_THE_GODS , "Vet'ion", "Uniques", 0),
	VETION_JR("Vet'ion jr.", ItemID.VETION_JR , "Vet'ion", "Uniques", 0),
	SKELETON_CHAMPION_SCROLL("Skeleton champion scroll", ItemID.SKELETON_CHAMPION_SCROLL , "Vet'ion", "Uniques", 0),
	// Venenatis
	TREASONOUS_RING("Treasonous ring", ItemID.TREASONOUS_RING , "Venenatis", "Uniques", -1),
	VENENATIS_SPIDERLING("Venenatis spiderling", ItemID.VENENATIS_SPIDERLING , "Venenatis", "Uniques", -1),
	// Callisto
	TYRANNICAL_RING("Tyrannical ring", ItemID.TYRANNICAL_RING , "Callisto", "Uniques", -1),
	CALLISTO_CUB("Callisto cub", ItemID.CALLISTO_CUB , "Callisto", "Uniques", -1),
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
	PRINCE_BLACK_DRAGON("Prince black dragon", ItemID.PRINCE_BLACK_DRAGON , "King Black Dragon", "Uniques", -1),

	// Slayer Bosses
	// Skotizo
	DARK_CLAW("Dark claw", ItemID.DARK_CLAW, "Skotizo", "Uniques", -1),
	SKOTOS("Skotos", ItemID.SKOTOS, "Skotizo", "Uniques", -1),
	JAR_OF_DARKNESS("Jar of darkness", ItemID.JAR_OF_DARKNESS, "Skotizo", "Uniques", -1),
	// Grotesque Guardians
	GRANITE_GLOVES("Granite gloves", ItemID.GRANITE_GLOVES, "Dusk", "Uniques", 0),
	GRANITE_RING("Granite ring", ItemID.GRANITE_RING, "Dusk", "Uniques", 0),
	GRANITE_HAMMER("Granite hammer", ItemID.GRANITE_HAMMER, "Dusk", "Uniques", 0),
	BLACK_TOURMALINE_CORE("Black touramline core", ItemID.BLACK_TOURMALINE_CORE, "Dusk", "Uniques 2", 1),
	NOON("Noon", ItemID.NOON, "Dusk", "Uniques 2", 1),
	JAR_OF_STONE("Jar of stone", ItemID.JAR_OF_STONE, "Dusk", "Uniques 2", 1),
	// Abyssal Sire
	UNSIRED("Unsired", ItemID.UNSIRED, "Abyssal Sire", "Uniques", 0),
	BLUDGEON_CLAW("Bludgeon claw", ItemID.BLUDGEON_CLAW, "Abyssal Sire", "Uniques", 0),
	BLUDGEON_SPINE("Bludgeon spine", ItemID.BLUDGEON_SPINE, "Abyssal Sire", "Uniques", 0),
	BLUDGEON_AXON("Bludgeon axon", ItemID.BLUDGEON_AXON, "Abyssal Sire", "Uniques", 0),
	ABYSSAL_DAGGER("Abyssal dagger", ItemID.ABYSSAL_DAGGER, "Abyssal Sire", "Uniques 2", 1),
	ABYSSAL_WHIP("Abyssal whip", ItemID.ABYSSAL_WHIP, "Abyssal Sire", "Uniques 2", 1),
	ABYSSAL_ORPHAN("Abyssal orphan", ItemID.ABYSSAL_ORPHAN, "Abyssal Sire", "Uniques 2", 1),
	JAR_OF_MIASMA("Jar of miasma", ItemID.JAR_OF_MIASMA, "Abyssal Sire", "Uniques 2", 1),
	ABYSSAL_HEAD("Abyssal head", ItemID.ABYSSAL_HEAD, "Abyssal Sire", "Uniques 2", 1),
	// Kraken
	TRIDENT_OF_THE_SEAS_FULL("Trident of the seas (full)", ItemID.TRIDENT_OF_THE_SEAS_FULL, "Kraken", "Uniques", 0),
	KRAKEN_TENTACLE("Kraken tentacle", ItemID.KRAKEN_TENTACLE, "Kraken", "Uniques", 0),
	JAR_OF_DIRT("Jar of dirt", ItemID.JAR_OF_DIRT, "Kraken", "Uniques", 0),
	PET_KRAKEN("Pet kraken", ItemID.PET_KRAKEN, "Kraken", "Uniques", 0),
	// Cerberus
	PRIMORDIAL_CRYSTAL("Primordial crystal", ItemID.PRIMORDIAL_CRYSTAL, "Cerberus", "Uniques", 0),
	PEGASIAN_CRYSTAL("Pegasian crystal", ItemID.PEGASIAN_CRYSTAL, "Cerberus", "Uniques", 0),
	ETERNAL_CRYSTAL("Eternal crystal", ItemID.ETERNAL_CRYSTAL, "Cerberus", "Uniques", 0),
	SMOULDERING_STONE("Smouldering stone", ItemID.SMOULDERING_STONE, "Cerberus", "Uniques", 1),
	JAR_OF_SOULS("Jar of souls", ItemID.JAR_OF_SOULS, "Cerberus", "Uniques", 1),
	HELLPUPPY("Hellpuppy", ItemID.HELLPUPPY, "Cerberus", "Uniques", 1),
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
	PET_DAGANNOTH_SUPREME("Pet dagannoth supreme", ItemID.PET_DAGANNOTH_SUPREME, "Dagannoth Supreme", "Uniques", -1),

	// Beginner Clue Scrolls
	MOLE_SLIPPERS("Mole slippers", ItemID.MOLE_SLIPPERS, "Clue Scroll (Beginner)", "Slippers", -1),
	FROG_SLIPPERS("Frog slippers", ItemID.FROG_SLIPPERS, "Clue Scroll (Beginner)", "Slippers", -1),
	BEAR_FEET("Bear slippers", ItemID.BEAR_FEET, "Clue Scroll (Beginner)", "Slippers", -1),
	DEMON_FEET("Demon slippers", ItemID.DEMON_FEET, "Clue Scroll (Beginner)", "Slippers", -1),
	SANDWICH_LADY_HAT("Sandwich lady hat", ItemID.SANDWICH_LADY_HAT, "Clue Scroll (Beginner)", "Sandwich Lady", 0),
	SANDWICH_LADY_TOP("Sandwich lady top", ItemID.SANDWICH_LADY_TOP, "Clue Scroll (Beginner)", "Sandwich Lady", 0),
	SANDWICH_LADY_BOTTOM("Sandwich lady bottom", ItemID.SANDWICH_LADY_BOTTOM, "Clue Scroll (Beginner)", "Sandwich Lady", 0),
	MONKS_ROBE_TOP_T("Monk robe top (t)", ItemID.MONKS_ROBE_TOP_T, "Clue Scroll (Beginner)", "Monk Robes", 1),
	MONKS_ROBE_T("Monk robe (t)", ItemID.MONKS_ROBE_T, "Clue Scroll (Beginner)", "Monk Robes", 1),
	JESTER_CAPE("Jester cape", ItemID.JESTER_CAPE, "Clue Scroll (Beginner)", "Other", 2),
	SHOULDER_PARROT("Shoulder parrot", ItemID.SHOULDER_PARROT, "Clue Scroll (Beginner)", "Other", 2),
	AMULET_OF_DEFENCE_T("Amulet of Defence (t)", ItemID.AMULET_OF_DEFENCE_T, "Clue Scroll (Beginner)", "Other", 2),
	RUNE_SCIMITAR_ORNAMENT_KIT_GUTHIX("Rune scimitar Guthix ornament kit", ItemID.RUNE_SCIMITAR_ORNAMENT_KIT_GUTHIX, "Clue Scroll (Beginner)", "God Ornament Kit", 3),
	RUNE_SCIMITAR_ORNAMENT_KIT_SARADOMIN("Rune scimitar Saradomin ornament kit", ItemID.RUNE_SCIMITAR_ORNAMENT_KIT_SARADOMIN, "Clue Scroll (Beginner)", "God Ornament Kit", 3),
	RUNE_SCIMITAR_ORNAMENT_KIT_ZAMORAK("Rune scimitar Zamorak ornament kit", ItemID.RUNE_SCIMITAR_ORNAMENT_KIT_ZAMORAK, "Clue Scroll (Beginner)", "God Ornament Kit", 3),

	// Easy Clue Scrolls
	BRONZE_FULL_HELM_T("Bronze full helm (t)", ItemID.BRONZE_FULL_HELM_T, "Clue Scroll (Easy)", "Armor", -1),
	BRONZE_PLATEBODY_T("Bronze platebody (t)", ItemID.BRONZE_PLATEBODY_T, "Clue Scroll (Easy)", "Armor", -1),
	BRONZE_PLATELEGS_T("Bronze platelegs (t)", ItemID.BRONZE_PLATELEGS_T, "Clue Scroll (Easy)", "Armor", -1),
	BRONZE_PLATESKIRT_T("Bronze plateskirt (t)", ItemID.BRONZE_PLATESKIRT_T, "Clue Scroll (Easy)", "Armor", -1),
	BRONZE_KITESHIELD_T("Bronze kiteshield (t)", ItemID.BRONZE_KITESHIELD_T, "Clue Scroll (Easy)", "Armor", -1),
	BRONZE_FULL_HELM_G("Bronze full helm (g)", ItemID.BRONZE_FULL_HELM_G, "Clue Scroll (Easy)", "Armor", 0),
	BRONZE_PLATEBODY_G("Bronze platebody (g)", ItemID.BRONZE_PLATEBODY_G, "Clue Scroll (Easy)", "Armor", 0),
	BRONZE_PLATELEGS_G("Bronze platelegs (g)", ItemID.BRONZE_PLATELEGS_G, "Clue Scroll (Easy)", "Armor", 0),
	BRONZE_PLATESKIRT_G("Bronze plateskirt (g)", ItemID.BRONZE_PLATESKIRT_G, "Clue Scroll (Easy)", "Armor", 0),
	BRONZE_KITESHIELD_G("Bronze kiteshield (g)", ItemID.BRONZE_KITESHIELD_G, "Clue Scroll (Easy)", "Armor", 0),
	IRON_FULL_HELM_T("Iron full helm (t)", ItemID.IRON_FULL_HELM_T, "Clue Scroll (Easy)", "Armor", 1),
	IRON_PLATEBODY_T("Iron platebody (t)", ItemID.IRON_PLATEBODY_T, "Clue Scroll (Easy)", "Armor", 1),
	IRON_PLATELEGS_T("Iron platelegs (t)", ItemID.IRON_PLATELEGS_T, "Clue Scroll (Easy)", "Armor", 1),
	IRON_PLATESKIRT_T("Iron plateskirt (t)", ItemID.IRON_PLATESKIRT_T, "Clue Scroll (Easy)", "Armor", 1),
	IRON_KITESHIELD_T("Iron kiteshield (t)", ItemID.IRON_KITESHIELD_T, "Clue Scroll (Easy)", "Armor", 1),
	IRON_FULL_HELM_G("Iron full helm (g)", ItemID.IRON_FULL_HELM_G, "Clue Scroll (Easy)", "Armor", 2),
	IRON_PLATEBODY_G("Iron platebody (g)", ItemID.IRON_PLATEBODY_G, "Clue Scroll (Easy)", "Armor", 2),
	IRON_PLATELEGS_G("Iron platelegs (g)", ItemID.IRON_PLATELEGS_G, "Clue Scroll (Easy)", "Armor", 2),
	IRON_PLATESKIRT_G("Iron plateskirt (g)", ItemID.IRON_PLATESKIRT_G, "Clue Scroll (Easy)", "Armor", 2),
	IRON_KITESHIELD_G("Iron kiteshield (g)", ItemID.IRON_KITESHIELD_G, "Clue Scroll (Easy)", "Armor", 2),
	STEEL_FULL_HELM_T("Steel full helm (t)", ItemID.STEEL_FULL_HELM_T, "Clue Scroll (Easy)", "Armor", 3),
	STEEL_PLATEBODY_T("Steel platebody (t)", ItemID.STEEL_PLATEBODY_T, "Clue Scroll (Easy)", "Armor", 3),
	STEEL_PLATELEGS_T("Steel platelegs (t)", ItemID.STEEL_PLATELEGS_T, "Clue Scroll (Easy)", "Armor", 3),
	STEEL_PLATESKIRT_T("Steel plateskirt (t)", ItemID.STEEL_PLATESKIRT_T, "Clue Scroll (Easy)", "Armor", 3),
	STEEL_KITESHIELD_T("Steel kiteshield (t)", ItemID.STEEL_KITESHIELD_T, "Clue Scroll (Easy)", "Armor", 3),
	STEEL_FULL_HELM_G("Steel full helm (g)", ItemID.STEEL_FULL_HELM_G, "Clue Scroll (Easy)", "Armor", 4),
	STEEL_PLATEBODY_G("Steel platebody (g)", ItemID.STEEL_PLATEBODY_G, "Clue Scroll (Easy)", "Armor", 4),
	STEEL_PLATELEGS_G("Steel platelegs (g)", ItemID.STEEL_PLATELEGS_G, "Clue Scroll (Easy)", "Armor", 4),
	STEEL_PLATESKIRT_G("Steel plateskirt (g)", ItemID.STEEL_PLATESKIRT_G, "Clue Scroll (Easy)", "Armor", 4),
	STEEL_KITESHIELD_G("Steel kiteshield (g)", ItemID.STEEL_KITESHIELD_G, "Clue Scroll (Easy)", "Armor", 4),
	BLACK_FULL_HELM_T("Black full helm (t)", ItemID.BLACK_FULL_HELM_T, "Clue Scroll (Easy)", "Armor", 5),
	BLACK_PLATEBODY_T("Black platebody (t)", ItemID.BLACK_PLATEBODY_T, "Clue Scroll (Easy)", "Armor", 5),
	BLACK_PLATELEGS_T("Black platelegs (t)", ItemID.BLACK_PLATELEGS_T, "Clue Scroll (Easy)", "Armor", 5),
	BLACK_PLATESKIRT_T("Black plateskirt (t)", ItemID.BLACK_PLATESKIRT_T, "Clue Scroll (Easy)", "Armor", 5),
	BLACK_KITESHIELD_T("Black kiteshield (t)", ItemID.BLACK_KITESHIELD_T, "Clue Scroll (Easy)", "Armor", 5),
	BLACK_FULL_HELM_G("Black full helm (g)", ItemID.BLACK_FULL_HELM_G, "Clue Scroll (Easy)", "Armor", 6),
	BLACK_PLATEBODY_G("Black platebody (g)", ItemID.BLACK_PLATEBODY_G, "Clue Scroll (Easy)", "Armor", 6),
	BLACK_PLATELEGS_G("Black platelegs (g)", ItemID.BLACK_PLATELEGS_G, "Clue Scroll (Easy)", "Armor", 6),
	BLACK_PLATESKIRT_G("Black plateskirt (g)", ItemID.BLACK_PLATESKIRT_G, "Clue Scroll (Easy)", "Armor", 6),
	BLACK_KITESHIELD_G("Black kiteshield (g)", ItemID.BLACK_KITESHIELD_G, "Clue Scroll (Easy)", "Armor", 6),
	BLUE_WIZARD_HAT_T("Blue wizard hat (t)", ItemID.BLUE_WIZARD_HAT_T, "Clue Scroll (Easy)", "Wizard Robes", 7),
	BLUE_WIZARD_ROBE_T("Blue wizard robe (t)", ItemID.BLUE_WIZARD_ROBE_T, "Clue Scroll (Easy)", "Wizard Robes", 7),
	BLUE_SKIRT_T("Blue skirt (t)", ItemID.BLUE_SKIRT_T, "Clue Scroll (Easy)", "Wizard Robes", 7),
	BLUE_WIZARD_HAT_G("Blue wizard hat (g)", ItemID.BLUE_WIZARD_HAT_G, "Clue Scroll (Easy)", "Wizard Robes", 8),
	BLUE_WIZARD_ROBE_G("Blue wizard robe (g)", ItemID.BLUE_WIZARD_ROBE_G, "Clue Scroll (Easy)", "Wizard Robes", 8),
	BLUE_SKIRT_G("Blue skirt (g)", ItemID.BLUE_SKIRT_G, "Clue Scroll (Easy)", "Wizard Robes", 8),
	BLACK_WIZARD_HAT_T("Black wizard hat (t)", ItemID.BLACK_WIZARD_HAT_T, "Clue Scroll (Easy)", "Wizard Robes", 9),
	BLACK_WIZARD_ROBE_T("Black wizard robe (t)", ItemID.BLACK_WIZARD_ROBE_T, "Clue Scroll (Easy)", "Wizard Robes", 9),
	BLACK_SKIRT_T("Black skirt (t)", ItemID.BLACK_SKIRT_T, "Clue Scroll (Easy)", "Wizard Robes", 9),
	BLACK_WIZARD_HAT_G("Black wizard hat (g)", ItemID.BLACK_WIZARD_HAT_G, "Clue Scroll (Easy)", "Wizard Robes", 10),
	BLACK_WIZARD_ROBE_G("Black wizard robe (g)", ItemID.BLACK_WIZARD_ROBE_G, "Clue Scroll (Easy)", "Wizard Robes", 10),
	BLACK_SKIRT_G("Black skirt (g)", ItemID.BLACK_SKIRT_G, "Clue Scroll (Easy)", "Wizard Robes", 10),
	STUDDED_BODY_T("Studded body (t)", ItemID.STUDDED_BODY_T, "Clue Scroll (Easy)", "Leather Armor", 11),
	STUDDED_CHAPS_T("Studded chaps (t)", ItemID.STUDDED_CHAPS_T, "Clue Scroll (Easy)", "Leather Armor", 11),
	STUDDED_BODY_G("Studded body (g)", ItemID.STUDDED_BODY_G, "Clue Scroll (Easy)", "Leather Armor", 11),
	STUDDED_CHAPS_G("Studded chaps (g)", ItemID.STUDDED_CHAPS_G, "Clue Scroll (Easy)", "Leather Armor", 11),
	LEATHER_CHAPS_G("Leather chaps (g)", ItemID.LEATHER_CHAPS_G, "Clue Scroll (Easy)", "Leather Armor", 12),
	LEATHER_BODY_G("Leather chaps (g)", ItemID.LEATHER_BODY_G, "Clue Scroll (Easy)", "Leather Armor", 12),
	BLACK_HELM_H1("Black helm (h1)", ItemID.BLACK_HELM_H1, "Clue Scroll (Easy)", "Heralid Helm", 13),
	BLACK_HELM_H2("Black helm (h2)", ItemID.BLACK_HELM_H2, "Clue Scroll (Easy)", "Heralid Helm", 13),
	BLACK_HELM_H3("Black helm (h3)", ItemID.BLACK_HELM_H3, "Clue Scroll (Easy)", "Heralid Helm", 13),
	BLACK_HELM_H4("Black helm (h4)", ItemID.BLACK_HELM_H4, "Clue Scroll (Easy)", "Heralid Helm", 13),
	BLACK_HELM_H5("Black helm (h5)", ItemID.BLACK_HELM_H5, "Clue Scroll (Easy)", "Heralid Helm", 13),
	BLACK_PLATEBODY_H1("Black platebody (h1)", ItemID.BLACK_PLATEBODY_H1, "Clue Scroll (Easy)", "Heralid Platebody", 14),
	BLACK_PLATEBODY_H2("Black platebody (h2)", ItemID.BLACK_PLATEBODY_H2, "Clue Scroll (Easy)", "Heralid Platebody", 14),
	BLACK_PLATEBODY_H3("Black platebody (h3)", ItemID.BLACK_PLATEBODY_H3, "Clue Scroll (Easy)", "Heralid Platebody", 14),
	BLACK_PLATEBODY_H4("Black platebody (h4)", ItemID.BLACK_PLATEBODY_H4, "Clue Scroll (Easy)", "Heralid Platebody", 14),
	BLACK_PLATEBODY_H5("Black platebody (h5)", ItemID.BLACK_PLATEBODY_H5, "Clue Scroll (Easy)", "Heralid Platebody", 14),
	BLACK_SHIELD_H1("Black shield (h1)", ItemID.BLACK_SHIELD_H1, "Clue Scroll (Easy)", "Heralid Shield", 15),
	BLACK_SHIELD_H2("Black shield (h2)", ItemID.BLACK_SHIELD_H2, "Clue Scroll (Easy)", "Heralid Shield", 15),
	BLACK_SHIELD_H3("Black shield (h3)", ItemID.BLACK_SHIELD_H3, "Clue Scroll (Easy)", "Heralid Shield", 15),
	BLACK_SHIELD_H4("Black shield (h4)", ItemID.BLACK_SHIELD_H4, "Clue Scroll (Easy)", "Heralid Shield", 15),
	BLACK_SHIELD_H5("Black shield (h5)", ItemID.BLACK_SHIELD_H5, "Clue Scroll (Easy)", "Heralid Shield", 15),
	BLUE_ELEGANT_SHIRT("Blue elegant shirt", ItemID.BLUE_ELEGANT_SHIRT, "Clue Scroll (Easy)", "Elegant", 16),
	BLUE_ELEGANT_LEGS("Blue elegant legs", ItemID.BLUE_ELEGANT_LEGS, "Clue Scroll (Easy)", "Elegant", 16),
	BLUE_ELEGANT_BLOUSE("Blue elegant blouse", ItemID.BLUE_ELEGANT_BLOUSE, "Clue Scroll (Easy)", "Elegant", 16),
	BLUE_ELEGANT_SKIRT("Blue elegant skirt", ItemID.BLUE_ELEGANT_SKIRT, "Clue Scroll (Easy)", "Elegant", 16),
	GREEN_ELEGANT_SHIRT("Green elegant shirt", ItemID.GREEN_ELEGANT_SHIRT, "Clue Scroll (Easy)", "Elegant", 17),
	GREEN_ELEGANT_LEGS("Green elegant legs", ItemID.GREEN_ELEGANT_LEGS, "Clue Scroll (Easy)", "Elegant", 17),
	GREEN_ELEGANT_BLOUSE("Green elegant blouse", ItemID.GREEN_ELEGANT_BLOUSE, "Clue Scroll (Easy)", "Elegant", 17),
	GREEN_ELEGANT_SKIRT("Green elegant skirt", ItemID.GREEN_ELEGANT_SKIRT, "Clue Scroll (Easy)", "Elegant", 17),
	RED_ELEGANT_SHIRT("Red elegant shirt", ItemID.RED_ELEGANT_SHIRT, "Clue Scroll (Easy)", "Elegant", 18),
	RED_ELEGANT_LEGS("Red elegant legs", ItemID.RED_ELEGANT_LEGS, "Clue Scroll (Easy)", "Elegant", 18),
	RED_ELEGANT_BLOUSE("Red elegant blouse", ItemID.RED_ELEGANT_BLOUSE, "Clue Scroll (Easy)", "Elegant", 18),
	RED_ELEGANT_SKIRT("Red elegant skirt", ItemID.RED_ELEGANT_SKIRT, "Clue Scroll (Easy)", "Elegant", 18),
	BOBS_RED_SHIRT("Bob's red shirt", ItemID.BOBS_RED_SHIRT, "Clue Scroll (Easy)", "Bobs Shirt", 19),
	BOBS_BLUE_SHIRT("Bob's blue shirt", ItemID.BOBS_BLUE_SHIRT, "Clue Scroll (Easy)", "Bobs Shirt", 19),
	BOBS_GREEN_SHIRT("Bob's green shirt", ItemID.BOBS_GREEN_SHIRT, "Clue Scroll (Easy)", "Bobs Shirt", 19),
	BOBS_BLACK_SHIRT("Bob's black shirt", ItemID.BOBS_BLACK_SHIRT, "Clue Scroll (Easy)", "Bobs Shirt", 19),
	BOBS_PURPLE_SHIRT("Bob's purple shirt", ItemID.BOBS_PURPLE_SHIRT, "Clue Scroll (Easy)", "Bobs Shirt", 19),
	A_POWDERED_WIG("A powdered wig", ItemID.A_POWDERED_WIG, "Clue Scroll (Easy)", "Emote Enhancers", 20),
	FLARED_TROUSERS("Flared trousers", ItemID.FLARED_TROUSERS, "Clue Scroll (Easy)", "Emote Enhancers", 20),
	PANTALOONS("Pantaloons", ItemID.PANTALOONS, "Clue Scroll (Easy)", "Emote Enhancers", 20),
	SLEEPING_CAP("Sleeping cap", ItemID.SLEEPING_CAP, "Clue Scroll (Easy)", "Emote Enhancers", 20),
	GUTHIX_ROBE_TOP("Guthix robe top", ItemID.GUTHIX_ROBE_TOP, "Clue Scroll (Easy)", "Vestment Robes", 21),
	GUTHIX_ROBE_LEGS("Guthix robe legs", ItemID.GUTHIX_ROBE_LEGS, "Clue Scroll (Easy)", "Vestment Robes", 21),
	SARADOMIN_ROBE_TOP("Saradomin robe top", ItemID.SARADOMIN_ROBE_TOP, "Clue Scroll (Easy)", "Vestment Robes", 21),
	SARADOMIN_ROBE_LEGS("Saradomin robe legs", ItemID.SARADOMIN_ROBE_LEGS, "Clue Scroll (Easy)", "Vestment Robes", 21),
	ZAMORAK_ROBE_TOP("Zamorak robe top", ItemID.ZAMORAK_ROBE_TOP, "Clue Scroll (Easy)", "Vestment Robes", 21),
	ZAMORAK_ROBE_LEGS("Zamorak robe legs", ItemID.ZAMORAK_ROBE_LEGS, "Clue Scroll (Easy)", "Vestment Robes", 21),
	ANCIENT_ROBE_TOP("Ancient robe top", ItemID.ANCIENT_ROBE_TOP, "Clue Scroll (Easy)", "Vestment Robes", 22),
	ANCIENT_ROBE_LEGS("Ancient robe legs", ItemID.ANCIENT_ROBE_LEGS, "Clue Scroll (Easy)", "Vestment Robes", 22),
	BANDOS_ROBE_TOP("Bandos robe top", ItemID.BANDOS_ROBE_TOP, "Clue Scroll (Easy)", "Vestment Robes", 22),
	BANDOS_ROBE_LEGS("Bandos robe legs", ItemID.BANDOS_ROBE_LEGS, "Clue Scroll (Easy)", "Vestment Robes", 22),
	ARMADYL_ROBE_TOP("Armadyl robe top", ItemID.ARMADYL_ROBE_TOP, "Clue Scroll (Easy)", "Vestment Robes", 22),
	ARMADYL_ROBE_LEGS("Armadyl robe legs", ItemID.ARMADYL_ROBE_LEGS, "Clue Scroll (Easy)", "Vestment Robes", 22),
	BLACK_BERET("Black beret", ItemID.BLACK_BERET, "Clue Scroll (Easy)", "Berets", 23),
	BLUE_BERET("Blue beret", ItemID.BLUE_BERET, "Clue Scroll (Easy)", "Berets", 23),
	WHITE_BERET("White beret", ItemID.WHITE_BERET, "Clue Scroll (Easy)", "Berets", 23),
	RED_BERET("Red beret", ItemID.RED_BERET, "Clue Scroll (Easy)", "Berets", 23),
	HIGHWAYMAN_MASK("Highwayman mask", ItemID.HIGHWAYMAN_MASK, "Clue Scroll (Easy)", "Masks", 24),
	IMP_MASK("Imp mask", ItemID.IMP_MASK, "Clue Scroll (Easy)", "Masks", 24),
	GOBLIN_MASK("Goblin mask", ItemID.GOBLIN_MASK, "Clue Scroll (Easy)", "Masks", 24),
	BEANIE("Beanie", ItemID.BEANIE, "Clue Scroll (Easy)", "Masks", 24),
	TEAM_CAPE_I("Team cape i", ItemID.TEAM_CAPE_I, "Clue Scroll (Easy)", "Cape", 25),
	TEAM_CAPE_X("Team cape x", ItemID.TEAM_CAPE_X, "Clue Scroll (Easy)", "Cape", 25),
	TEAM_CAPE_ZERO("Team cape zero", ItemID.TEAM_CAPE_ZERO, "Clue Scroll (Easy)", "Cape", 25),
	CAPE_OF_SKULLS("Cape of Skulls", ItemID.CAPE_OF_SKULLS, "Clue Scroll (Easy)", "CApe", 25),
	AMULET_OF_MAGIC_T("Amulet of magic (t)", ItemID.AMULET_OF_MAGIC_T, "Clue Scroll (Easy)", "Other", 26),
	AMULET_OF_POWER_T("Power Amulet (t)", ItemID.AMULET_OF_POWER_T, "Clue Scroll (Easy)", "Other", 26),
	BLACK_CANE("Black cane", ItemID.BLACK_CANE, "Clue Scroll (Easy)", "Other", 26),
	BLACK_PICKAXE("Black pickaxe", ItemID.BLACK_PICKAXE, "Clue Scroll (Easy)", "Other", 26),
	LARGE_SPADE("Large spade", ItemID.LARGE_SPADE, "Clue Scroll (Easy)", "Other", 26),
	WOODEN_SHIELD_G("Wooden shield (g)", ItemID.WOODEN_SHIELD_G, "Clue Scroll (Easy)", "Golden", 27),
	GOLDEN_CHEFS_HAT("Golden chef's hat", ItemID.GOLDEN_CHEFS_HAT, "Clue Scroll (Easy)", "Golden", 27),
	GOLDEN_APRON("Golden apron", ItemID.GOLDEN_APRON, "Clue Scroll (Easy)", "Golden", 27),
	MONKS_ROBE_TOP_G("Monk robe top (g)", ItemID.MONKS_ROBE_TOP_G, "Clue Scroll (Easy)", "Golden", 27),
	MONKS_ROBE_G("Monk robe (g)", ItemID.MONKS_ROBE_G, "Clue Scroll (Easy)", "Golden", 27),
	RAIN_BOW("Rain bow", ItemID.RAIN_BOW, "Clue Scroll (Easy)", "Other", 28),
	HAM_JOINT("Ham joint", ItemID.HAM_JOINT, "Clue Scroll (Easy)", "Other", 28),
	STAFF_OF_BOB_THE_CAT("Staff of Bob the Cat", ItemID.STAFF_OF_BOB_THE_CAT, "Clue Scroll (Easy)", "Other", 28),

	// Medium Clue Scrolls
	MITHRIL_FULL_HELM_T("Mithril full helm (t)", ItemID.MITHRIL_FULL_HELM_T, "Clue Scroll (Medium)", "Armor", -1),
	MITHRIL_PLATEBODY_T("Mithril platebody (t)", ItemID.MITHRIL_PLATEBODY_T, "Clue Scroll (Medium)", "Armor", -1),
	MITHRIL_PLATELEGS_T("Mithril platelegs (t)", ItemID.MITHRIL_PLATELEGS_T, "Clue Scroll (Medium)", "Armor", -1),
	MITHRIL_PLATESKIRT_T("Mithril plateskirt (t)", ItemID.MITHRIL_PLATESKIRT_T, "Clue Scroll (Medium)", "Armor", -1),
	MITHRIL_KITESHIELD_T("Mithril kiteshield (t)", ItemID.MITHRIL_KITESHIELD_T, "Clue Scroll (Medium)", "Armor", -1),
	MITHRIL_FULL_HELM_G("Mithril full helm (g)", ItemID.MITHRIL_FULL_HELM_G, "Clue Scroll (Medium)", "Armor", 0),
	MITHRIL_PLATEBODY_G("Mithril platebody (g)", ItemID.MITHRIL_PLATEBODY_G, "Clue Scroll (Medium)", "Armor", 0),
	MITHRIL_PLATELEGS_G("Mithril platelegs (g)", ItemID.MITHRIL_PLATELEGS_G, "Clue Scroll (Medium)", "Armor", 0),
	MITHRIL_PLATESKIRT_G("Mithril plateskirt (g)", ItemID.MITHRIL_PLATESKIRT_G, "Clue Scroll (Medium)", "Armor", 0),
	MITHRIL_KITESHIELD_G("Mithril kiteshield (g)", ItemID.MITHRIL_KITESHIELD_G, "Clue Scroll (Medium)", "Armor", 0),
	ADAMANT_FULL_HELM_T("Adamant full helm (t)", ItemID.ADAMANT_FULL_HELM_T, "Clue Scroll (Medium)", "Armor", 1),
	ADAMANT_PLATEBODY_T("Adamant platebody (t)", ItemID.ADAMANT_PLATEBODY_T, "Clue Scroll (Medium)", "Armor", 1),
	ADAMANT_PLATELEGS_T("Adamant platelegs (t)", ItemID.ADAMANT_PLATELEGS_T, "Clue Scroll (Medium)", "Armor", 1),
	ADAMANT_PLATESKIRT_T("Adamant plateskirt (t)", ItemID.ADAMANT_PLATESKIRT_T, "Clue Scroll (Medium)", "Armor", 1),
	ADAMANT_KITESHIELD_T("Adamant kiteshield (t)", ItemID.ADAMANT_KITESHIELD_T, "Clue Scroll (Medium)", "Armor", 1),
	ADAMANT_FULL_HELM_G("Adamant full helm (g)", ItemID.ADAMANT_FULL_HELM_G, "Clue Scroll (Medium)", "Armor", 2),
	ADAMANT_PLATEBODY_G("Adamant platebody (g)", ItemID.ADAMANT_PLATEBODY_G, "Clue Scroll (Medium)", "Armor", 2),
	ADAMANT_PLATELEGS_G("Adamant platelegs (g)", ItemID.ADAMANT_PLATELEGS_G, "Clue Scroll (Medium)", "Armor", 2),
	ADAMANT_PLATESKIRT_G("Adamant plateskirt (g)", ItemID.ADAMANT_PLATESKIRT_G, "Clue Scroll (Medium)", "Armor", 2),
	ADAMANT_KITESHIELD_G("Adamant kiteshield (g)", ItemID.ADAMANT_KITESHIELD_G, "Clue Scroll (Medium)", "Armor", 2),
	RANGER_BOOTS("Ranger boots", ItemID.RANGER_BOOTS, "Clue Scroll (Medium)", "Boots", 3),
	HOLY_SANDALS("Holy sandals", ItemID.HOLY_SANDALS, "Clue Scroll (Medium)", "Boots", 3),
	WIZARD_BOOTS("Wizard boots", ItemID.WIZARD_BOOTS, "Clue Scroll (Medium)", "Boots", 3),
	RED_HEADBAND("Red headband", ItemID.RED_HEADBAND, "Clue Scroll (Medium)", "Headbands", 4),
	BLACK_HEADBAND("Black headband", ItemID.BLACK_HEADBAND, "Clue Scroll (Medium)", "Headbands", 4),
	BROWN_HEADBAND("Brown headband", ItemID.BROWN_HEADBAND, "Clue Scroll (Medium)", "Headbands", 4),
	PINK_HEADBAND("Pink headband", ItemID.PINK_HEADBAND, "Clue Scroll (Medium)", "Headbands", 4),
	GREEN_HEADBAND("Green headband", ItemID.GREEN_HEADBAND, "Clue Scroll (Medium)", "Headbands", 5),
	BLUE_HEADBAND("Blue headband", ItemID.BLUE_HEADBAND, "Clue Scroll (Medium)", "Headbands", 5),
	GOLD_HEADBAND("Gold headband", ItemID.GOLD_HEADBAND, "Clue Scroll (Medium)", "Headbands", 5),
	WHITE_HEADBAND("White headband", ItemID.WHITE_HEADBAND, "Clue Scroll (Medium)", "Headbands", 5),
	RED_BOATER("Red boater", ItemID.RED_BOATER, "Clue Scroll (Medium)", "Boater", 6),
	ORANGE_BOATER("Orange boater", ItemID.ORANGE_BOATER, "Clue Scroll (Medium)", "Boater", 6),
	GREEN_BOATER("Green boater", ItemID.GREEN_BOATER, "Clue Scroll (Medium)", "Boater", 6),
	BLUE_BOATER("Blue boater", ItemID.BLUE_BOATER, "Clue Scroll (Medium)", "Boater", 6),
	BLACK_BOATER("Black boater", ItemID.BLACK_BOATER, "Clue Scroll (Medium)", "Boater", 7),
	PINK_BOATER("Pink boater", ItemID.PINK_BOATER, "Clue Scroll (Medium)", "Boater", 7),
	PURPLE_BOATER("Purple boater", ItemID.PURPLE_BOATER, "Clue Scroll (Medium)", "Boater", 7),
	WHITE_BOATER("White boater", ItemID.WHITE_BOATER, "Clue Scroll (Medium)", "Boater", 7),
	ADAMANT_HELM_H1("Adamant helm (h1)", ItemID.ADAMANT_HELM_H1, "Clue Scroll (Medium)", "Heraldic", 8),
	ADAMANT_HELM_H2("Adamant helm (h2)", ItemID.ADAMANT_HELM_H2, "Clue Scroll (Medium)", "Heraldic", 8),
	ADAMANT_HELM_H3("Adamant helm (h3)", ItemID.ADAMANT_HELM_H3, "Clue Scroll (Medium)", "Heraldic", 8),
	ADAMANT_HELM_H4("Adamant helm (h4)", ItemID.ADAMANT_HELM_H4, "Clue Scroll (Medium)", "Heraldic", 8),
	ADAMANT_HELM_H5("Adamant helm (h5)", ItemID.ADAMANT_HELM_H5, "Clue Scroll (Medium)", "Heraldic", 8),
	ADAMANT_SHIELD_H1("Adamant shield (h1)", ItemID.ADAMANT_SHIELD_H1, "Clue Scroll (Medium)", "Heraldic", 9),
	ADAMANT_SHIELD_H2("Adamant shield (h2)", ItemID.ADAMANT_SHIELD_H2, "Clue Scroll (Medium)", "Heraldic", 9),
	ADAMANT_SHIELD_H3("Adamant shield (h3)", ItemID.ADAMANT_SHIELD_H3, "Clue Scroll (Medium)", "Heraldic", 9),
	ADAMANT_SHIELD_H4("Adamant shield (h4)", ItemID.ADAMANT_SHIELD_H4, "Clue Scroll (Medium)", "Heraldic", 9),
	ADAMANT_SHIELD_H5("Adamant shield (h5)", ItemID.ADAMANT_SHIELD_H5, "Clue Scroll (Medium)", "Heraldic", 9),
	ADAMANT_PLATEBODY_H1("Adamant platebody (h1)", ItemID.ADAMANT_PLATEBODY_H1, "Clue Scroll (Medium)", "Armor", 10),
	ADAMANT_PLATEBODY_H2("Adamant platebody (h2)", ItemID.ADAMANT_PLATEBODY_H2, "Clue Scroll (Medium)", "Armor", 10),
	ADAMANT_PLATEBODY_H3("Adamant platebody (h3)", ItemID.ADAMANT_PLATEBODY_H3, "Clue Scroll (Medium)", "Armor", 10),
	ADAMANT_PLATEBODY_H4("Adamant platebody (h4)", ItemID.ADAMANT_PLATEBODY_H4, "Clue Scroll (Medium)", "Armor", 10),
	ADAMANT_PLATEBODY_H5("Adamant platebody (h5)", ItemID.ADAMANT_PLATEBODY_H5, "Clue Scroll (Medium)", "Armor", 10),
	GREEN_DHIDE_BODY_T("Green dragonhide body (t)", ItemID.GREEN_DHIDE_BODY_T, "Clue Scroll (Medium)", "Dhide", 11),
	GREEN_DHIDE_CHAPS_T("Green dragonhide chaps (t)", ItemID.GREEN_DHIDE_CHAPS_T, "Clue Scroll (Medium)", "Dhide", 11),
	GREEN_DHIDE_BODY_G("Green dragonhide body (g)", ItemID.GREEN_DHIDE_BODY_G, "Clue Scroll (Medium)", "Dhide", 11),
	GREEN_DHIDE_CHAPS_G("Green dragonhide chaps (g)", ItemID.GREEN_DHIDE_CHAPS_G, "Clue Scroll (Medium)", "Dhide", 11),
	BLACK_ELEGANT_SHIRT("Black elegant shirt", ItemID.BLACK_ELEGANT_SHIRT, "Clue Scroll (Medium)", "Elegeant", 12),
	BLACK_ELEGANT_LEGS("Black elegant legs", ItemID.BLACK_ELEGANT_LEGS, "Clue Scroll (Medium)", "Elegeant", 12),
	WHITE_ELEGANT_BLOUSE("White elegant blouse", ItemID.WHITE_ELEGANT_BLOUSE, "Clue Scroll (Medium)", "Elegeant", 12),
	WHITE_ELEGANT_SKIRT("White elegant skirt", ItemID.WHITE_ELEGANT_SKIRT, "Clue Scroll (Medium)", "Elegeant", 12),
	PURPLE_ELEGANT_SHIRT("Purple elegant shirt", ItemID.PURPLE_ELEGANT_SHIRT, "Clue Scroll (Medium)", "Elegeant", 13),
	PURPLE_ELEGANT_LEGS("Purple elegant legs", ItemID.PURPLE_ELEGANT_LEGS, "Clue Scroll (Medium)", "Elegeant", 13),
	PURPLE_ELEGANT_BLOUSE("Purple elegant blouse", ItemID.PURPLE_ELEGANT_BLOUSE, "Clue Scroll (Medium)", "Elegeant", 13),
	PURPLE_ELEGANT_SKIRT("Purple elegant skirt", ItemID.PURPLE_ELEGANT_SKIRT, "Clue Scroll (Medium)", "Elegeant", 13),
	PINK_ELEGANT_SHIRT("Pink elegant shirt", ItemID.PINK_ELEGANT_SHIRT, "Clue Scroll (Medium)", "Elegeant", 14),
	PINK_ELEGANT_LEGS("Pink elegant legs", ItemID.PINK_ELEGANT_LEGS, "Clue Scroll (Medium)", "Elegeant", 14),
	PINK_ELEGANT_BLOUSE("Pink elegant blouse", ItemID.PINK_ELEGANT_BLOUSE, "Clue Scroll (Medium)", "Elegeant", 14),
	PINK_ELEGANT_SKIRT("Pink elegant skirt", ItemID.PINK_ELEGANT_SKIRT, "Clue Scroll (Medium)", "Elegeant", 14),
	GOLD_ELEGANT_SHIRT("Gold elegant shirt", ItemID.GOLD_ELEGANT_SHIRT, "Clue Scroll (Medium)", "Elegeant", 15),
	GOLD_ELEGANT_LEGS("Gold elegant legs", ItemID.GOLD_ELEGANT_LEGS, "Clue Scroll (Medium)", "Elegeant", 15),
	GOLD_ELEGANT_BLOUSE("Gold elegant blouse", ItemID.GOLD_ELEGANT_BLOUSE, "Clue Scroll (Medium)", "Elegeant", 15),
	GOLD_ELEGANT_SKIRT("Gold elegant skirt", ItemID.GOLD_ELEGANT_SKIRT, "Clue Scroll (Medium)", "Elegeant", 15),
	GUTHIX_MITRE("Guthix mitre", ItemID.GUTHIX_MITRE, "Clue Scroll (Medium)", "Vestment", 16),
	GUTHIX_CLOAK("Guthix cloak", ItemID.GUTHIX_CLOAK, "Clue Scroll (Medium)", "Vestment", 16),
	SARADOMIN_MITRE("Saradomin mitre", ItemID.SARADOMIN_MITRE, "Clue Scroll (Medium)", "Vestment", 16),
	SARADOMIN_CLOAK("Saradomin cloak", ItemID.SARADOMIN_CLOAK, "Clue Scroll (Medium)", "Vestment", 16),
	ZAMORAK_MITRE("Zamorak mitre", ItemID.ZAMORAK_MITRE, "Clue Scroll (Medium)", "Vestment", 16),
	ZAMORAK_CLOAK("Zamorak cloak", ItemID.ZAMORAK_CLOAK, "Clue Scroll (Medium)", "Vestment", 16),
	ANCIENT_MITRE("Anicent mitre", ItemID.ANCIENT_MITRE, "Clue Scroll (Medium)", "Vestment", 17),
	ANCIENT_CLOAK("Anicent cloak", ItemID.ANCIENT_CLOAK, "Clue Scroll (Medium)", "Vestment", 17),
	BANDOS_MITRE("Bandos mitre", ItemID.BANDOS_MITRE, "Clue Scroll (Medium)", "Vestment", 17),
	BANDOS_CLOAK("Bandos cloak", ItemID.BANDOS_CLOAK, "Clue Scroll (Medium)", "Vestment", 17),
	ARMADYL_MITRE("Armadyl mitre", ItemID.ARMADYL_MITRE, "Clue Scroll (Medium)", "Vestment", 17),
	ARMADYL_CLOAK("Armadyl cloak", ItemID.ARMADYL_CLOAK, "Clue Scroll (Medium)", "Vestment", 17),
	ARMADYL_STOLE("Armadyl stole", ItemID.ARMADYL_STOLE, "Clue Scroll (Medium)", "Vestment", 18),
	ARMADYL_CROZIER("Armadyl crozier", ItemID.ARMADYL_CROZIER, "Clue Scroll (Medium)", "Vestment", 18),
	ANCIENT_STOLE("Anicent stole", ItemID.ANCIENT_STOLE, "Clue Scroll (Medium)", "Vestment", 18),
	ANCIENT_CROZIER("Anicent crozier", ItemID.ANCIENT_CROZIER, "Clue Scroll (Medium)", "Vestment", 18),
	BANDOS_STOLE("Bandos stole", ItemID.BANDOS_STOLE, "Clue Scroll (Medium)", "Vestment", 18),
	BANDOS_CROZIER("Bandos crozier", ItemID.BANDOS_CROZIER, "Clue Scroll (Medium)", "Vestment", 18),
	CAT_MASK("Cat mask", ItemID.CAT_MASK, "Clue Scroll (Medium)", "Masks", 19),
	PENGUIN_MASK("Penguin mask", ItemID.PENGUIN_MASK, "Clue Scroll (Medium)", "Masks", 19),
	BLACK_UNICORN_MASK("Black unicorn mask", ItemID.BLACK_UNICORN_MASK, "Clue Scroll (Medium)", "Masks", 19),
	WHITE_UNICORN_MASK("White unicorn mask", ItemID.WHITE_UNICORN_MASK, "Clue Scroll (Medium)", "Masks", 19),
	LEPRECHAUN_HAT("Leprechaun hat", ItemID.LEPRECHAUN_HAT, "Clue Scroll (Medium)", "Masks", 19),
	BLACK_LEPRECHAUN_HAT("Black leprechaun hat", ItemID.BLACK_LEPRECHAUN_HAT, "Clue Scroll (Medium)", "Masks", 19),
	CRIER_HAT("Crier hat", ItemID.CRIER_HAT, "Clue Scroll (Medium)", "Crier", 20),
	CRIER_BELL("Crier bell", ItemID.CRIER_BELL, "Clue Scroll (Medium)", "Crier", 20),
	CRIER_COAT("Crier coat", ItemID.CRIER_COAT, "Clue Scroll (Medium)", "Crier", 20),
	ARCEUUS_BANNER("Arceeus banner", ItemID.ARCEUUS_BANNER, "Clue Scroll (Medium)", "Zeah Banners", 21),
	HOSIDIUS_BANNER("Hosidius banner", ItemID.HOSIDIUS_BANNER, "Clue Scroll (Medium)", "Zeah Banners", 21),
	LOVAKENGJ_BANNER("Lovakengj banner", ItemID.LOVAKENGJ_BANNER, "Clue Scroll (Medium)", "Zeah Banners", 21),
	PISCARILIUS_BANNER("Picarilius banner", ItemID.PISCARILIUS_BANNER, "Clue Scroll (Medium)", "Zeah Banners", 21),
	SHAYZIEN_BANNER("Shayzien banner", ItemID.SHAYZIEN_BANNER, "Clue Scroll (Medium)", "Zeah Banners", 21),
	STRENGTH_AMULET_T("Strength amulet (t)", ItemID.STRENGTH_AMULET_T, "Clue Scroll (Medium)", "Other", 22),
	ADAMANT_CANE("Adamant cane", ItemID.ADAMANT_CANE, "Clue Scroll (Medium)", "Other", 22),
	GNOMISH_FIRELIGHTER("Gnomish firelighter", ItemID.GNOMISH_FIRELIGHTER, "Clue Scroll (Medium)", "Other", 22),
	CABBAGE_ROUND_SHIELD("Cabbage round shield", ItemID.CABBAGE_ROUND_SHIELD, "Clue Scroll (Medium)", "Other", 22),
	CLUELESS_SCROLL("Clueless scroll", ItemID.CLUELESS_SCROLL, "Clue Scroll (Medium)", "Other", 22),
	SPIKED_MANACLES("Spiked manacles", ItemID.SPIKED_MANACLES, "Clue Scroll (Medium)", "Other", 23),
	WOLF_MASK("Wolf mask", ItemID.WOLF_MASK, "Clue Scroll (Medium)", "Other", 23),
	WOLF_CLOAK("Wolf cloak", ItemID.WOLF_CLOAK, "Clue Scroll (Medium)", "Other", 23),
	CLIMBING_BOOTS_G("Climbing boots (g)", ItemID.CLIMBING_BOOTS_G, "Clue Scroll (Medium)", "Other", 23),

	// Hard Clue Scrolls
	RUNE_FULL_HELM_T("Rune full helm (t)", ItemID.RUNE_FULL_HELM_T, "Clue Scroll (Hard)", "Armor", -1),
	RUNE_PLATEBODY_T("Rune platebody (t)", ItemID.RUNE_PLATEBODY_T, "Clue Scroll (Hard)", "Armor", -1),
	RUNE_PLATELEGS_T("Rune platelegs (t)", ItemID.RUNE_PLATELEGS_T, "Clue Scroll (Hard)", "Armor", -1),
	RUNE_PLATESKIRT_T("Rune plateskirt (t)", ItemID.RUNE_PLATESKIRT_T, "Clue Scroll (Hard)", "Armor", -1),
	RUNE_KITESHIELD_T("Rune kiteshield (t)", ItemID.RUNE_KITESHIELD_T, "Clue Scroll (Hard)", "Armor", -1),
	RUNE_FULL_HELM_G("Rune full helm (g)", ItemID.RUNE_FULL_HELM_G, "Clue Scroll (Hard)", "Armor", 0),
	RUNE_PLATEBODY_G("Rune platebody (g)", ItemID.RUNE_PLATEBODY_G, "Clue Scroll (Hard)", "Armor", 0),
	RUNE_PLATELEGS_G("Rune platelegs (g)", ItemID.RUNE_PLATELEGS_G, "Clue Scroll (Hard)", "Armor", 0),
	RUNE_PLATESKIRT_G("Rune plateskirt (g)", ItemID.RUNE_PLATESKIRT_G, "Clue Scroll (Hard)", "Armor", 0),
	RUNE_KITESHIELD_G("Rune kiteshield (g)", ItemID.RUNE_KITESHIELD_G, "Clue Scroll (Hard)", "Armor", 0),
	GUTHIX_FULL_HELM("Guthix full helm", ItemID.GUTHIX_FULL_HELM, "Clue Scroll (Hard)", "Armor", 1),
	GUTHIX_PLATEBODY("Guthix platebody", ItemID.GUTHIX_PLATEBODY, "Clue Scroll (Hard)", "Armor", 1),
	GUTHIX_PLATELEGS("Guthix platelegs", ItemID.GUTHIX_PLATELEGS, "Clue Scroll (Hard)", "Armor", 1),
	GUTHIX_PLATESKIRT("Guthix plateskirt", ItemID.GUTHIX_PLATESKIRT, "Clue Scroll (Hard)", "Armor", 1),
	GUTHIX_KITESHIELD("Guthix kiteshield", ItemID.GUTHIX_KITESHIELD, "Clue Scroll (Hard)", "Armor", 1),
	SARADOMIN_FULL_HELM("Saradomin full helm", ItemID.SARADOMIN_FULL_HELM, "Clue Scroll (Hard)", "Armor", 2),
	SARADOMIN_PLATEBODY("Saradomin platebody", ItemID.SARADOMIN_PLATEBODY, "Clue Scroll (Hard)", "Armor", 2),
	SARADOMIN_PLATELEGS("Saradomin platelegs", ItemID.SARADOMIN_PLATELEGS, "Clue Scroll (Hard)", "Armor", 2),
	SARADOMIN_PLATESKIRT("Saradomin plateskirt", ItemID.SARADOMIN_PLATESKIRT, "Clue Scroll (Hard)", "Armor", 2),
	SARADOMIN_KITESHIELD("Saradomin kiteshield", ItemID.SARADOMIN_KITESHIELD, "Clue Scroll (Hard)", "Armor", 2),
	ZAMORAK_FULL_HELM("Zamorak full helm", ItemID.ZAMORAK_FULL_HELM, "Clue Scroll (Hard)", "Armor", 3),
	ZAMORAK_PLATEBODY("Zamorak platebody", ItemID.ZAMORAK_PLATEBODY, "Clue Scroll (Hard)", "Armor", 3),
	ZAMORAK_PLATELEGS("Zamorak platelegs", ItemID.ZAMORAK_PLATELEGS, "Clue Scroll (Hard)", "Armor", 3),
	ZAMORAK_PLATESKIRT("Zamorak plateskirt", ItemID.ZAMORAK_PLATESKIRT, "Clue Scroll (Hard)", "Armor", 3),
	ZAMORAK_KITESHIELD("Zamorak kiteshield", ItemID.ZAMORAK_KITESHIELD, "Clue Scroll (Hard)", "Armor", 3),
	ANCIENT_FULL_HELM("Ancient full helm", ItemID.ANCIENT_FULL_HELM, "Clue Scroll (Hard)", "Armor", 4),
	ANCIENT_PLATEBODY("Ancient platebody", ItemID.ANCIENT_PLATEBODY, "Clue Scroll (Hard)", "Armor", 4),
	ANCIENT_PLATELEGS("Ancient platelegs", ItemID.ANCIENT_PLATELEGS, "Clue Scroll (Hard)", "Armor", 4),
	ANCIENT_PLATESKIRT("Ancient plateskirt", ItemID.ANCIENT_PLATESKIRT, "Clue Scroll (Hard)", "Armor", 4),
	ANCIENT_KITESHIELD("Ancient kiteshield", ItemID.ANCIENT_KITESHIELD, "Clue Scroll (Hard)", "Armor", 4),
	BANDOS_FULL_HELM("Bandos full helm", ItemID.BANDOS_FULL_HELM, "Clue Scroll (Hard)", "Armor", 5),
	BANDOS_PLATEBODY("Bandos platebody", ItemID.BANDOS_PLATEBODY, "Clue Scroll (Hard)", "Armor", 5),
	BANDOS_PLATELEGS("Bandos platelegs", ItemID.BANDOS_PLATELEGS, "Clue Scroll (Hard)", "Armor", 5),
	BANDOS_PLATESKIRT("Bandos plateskirt", ItemID.BANDOS_PLATESKIRT, "Clue Scroll (Hard)", "Armor", 5),
	BANDOS_KITESHIELD("Bandos kiteshield", ItemID.BANDOS_KITESHIELD, "Clue Scroll (Hard)", "Armor", 5),
	ARMADYL_FULL_HELM("Armadyl full helm", ItemID.ARMADYL_FULL_HELM, "Clue Scroll (Hard)", "Armor", 6),
	ARMADYL_PLATEBODY("Armadyl platebody", ItemID.ARMADYL_PLATEBODY, "Clue Scroll (Hard)", "Armor", 6),
	ARMADYL_PLATELEGS("Armadyl platelegs", ItemID.ARMADYL_PLATELEGS, "Clue Scroll (Hard)", "Armor", 6),
	ARMADYL_PLATESKIRT("Armadyl plateskirt", ItemID.ARMADYL_PLATESKIRT, "Clue Scroll (Hard)", "Armor", 6),
	ARMADYL_KITESHIELD("Armadyl kiteshield", ItemID.ARMADYL_KITESHIELD, "Clue Scroll (Hard)", "Armor", 6),
	GILDED_FULL_HELM("Gilded full helm", ItemID.GILDED_FULL_HELM, "Clue Scroll (Hard)", "Gilded", 7),
	GILDED_PLATEBODY("Gilded platebody", ItemID.GILDED_PLATEBODY, "Clue Scroll (Hard)", "Gilded", 7),
	GILDED_PLATELEGS("Gilded platelegs", ItemID.GILDED_PLATELEGS, "Clue Scroll (Hard)", "Gilded", 7),
	GILDED_PLATESKIRT("Gilded plateskirt", ItemID.GILDED_PLATESKIRT, "Clue Scroll (Hard)", "Gilded", 7),
	GILDED_KITESHIELD("Gilded kiteshield", ItemID.GILDED_KITESHIELD, "Clue Scroll (Hard)", "Gilded", 7),
	GILDED_MED_HELM("Gilded med helm", ItemID.GILDED_MED_HELM, "Clue Scroll (Hard)", "Gilded", 8),
	GILDED_CHAINBODY("Gilded chainbody", ItemID.GILDED_CHAINBODY, "Clue Scroll (Hard)", "Gilded", 8),
	GILDED_SQ_SHIELD("Gilded sq shield", ItemID.GILDED_SQ_SHIELD, "Clue Scroll (Hard)", "Gilded", 8),
	GILDED_2H_SWORD("Gilded 2H sword", ItemID.GILDED_2H_SWORD, "Clue Scroll (Hard)", "Gilded", 8),
	GILDED_SPEAR("Gilded spear", ItemID.GILDED_SPEAR, "Clue Scroll (Hard)", "Gilded", 8),
	GILDED_HASTA("Gilded hasta", ItemID.GILDED_HASTA, "Clue Scroll (Hard)", "Gilded", 8),
	RUNE_HELM_H1("Rune helm (h1)", ItemID.RUNE_HELM_H1, "Clue Scroll (Hard)", "Heraldic", 9),
	RUNE_HELM_H2("Rune helm (h2)", ItemID.RUNE_HELM_H2, "Clue Scroll (Hard)", "Heraldic", 9),
	RUNE_HELM_H3("Rune helm (h3)", ItemID.RUNE_HELM_H3, "Clue Scroll (Hard)", "Heraldic", 9),
	RUNE_HELM_H4("Rune helm (h4)", ItemID.RUNE_HELM_H4, "Clue Scroll (Hard)", "Heraldic", 9),
	RUNE_HELM_H5("Rune helm (h5)", ItemID.RUNE_HELM_H5, "Clue Scroll (Hard)", "Heraldic", 9),
	RUNE_SHIELD_H1("Rune shield (h1)", ItemID.RUNE_SHIELD_H1, "Clue Scroll (Hard)", "Heraldic", 10),
	RUNE_SHIELD_H2("Rune shield (h2)", ItemID.RUNE_SHIELD_H2, "Clue Scroll (Hard)", "Heraldic", 10),
	RUNE_SHIELD_H3("Rune shield (h3)", ItemID.RUNE_SHIELD_H3, "Clue Scroll (Hard)", "Heraldic", 10),
	RUNE_SHIELD_H4("Rune shield (h4)", ItemID.RUNE_SHIELD_H4, "Clue Scroll (Hard)", "Heraldic", 10),
	RUNE_SHIELD_H5("Rune shield (h5)", ItemID.RUNE_SHIELD_H5, "Clue Scroll (Hard)", "Heraldic", 10),
	RUNE_PLATEBODY_H1("Rune platebody (h1)", ItemID.RUNE_PLATEBODY_H1, "Clue Scroll (Hard)", "Heraldic", 11),
	RUNE_PLATEBODY_H2("Rune platebody (h2)", ItemID.RUNE_PLATEBODY_H2, "Clue Scroll (Hard)", "Heraldic", 11),
	RUNE_PLATEBODY_H3("Rune platebody (h3)", ItemID.RUNE_PLATEBODY_H3, "Clue Scroll (Hard)", "Heraldic", 11),
	RUNE_PLATEBODY_H4("Rune platebody (h4)", ItemID.RUNE_PLATEBODY_H4, "Clue Scroll (Hard)", "Heraldic", 11),
	RUNE_PLATEBODY_H5 ("Rune platebody (h5)", ItemID.RUNE_PLATEBODY_H5, "Clue Scroll (Hard)", "Heraldic", 11),

	BLUE_DHIDE_BODY_T("Blue dhide body (t)", ItemID.BLUE_DHIDE_BODY_T, "Clue Scroll (Hard)", "Dhide", 12),
	BLUE_DHIDE_CHAPS_T("Blue dhide chaps (t)", ItemID.BLUE_DHIDE_CHAPS_T, "Clue Scroll (Hard)", "Dhide", 12),
	BLUE_DHIDE_BODY_G("Blue dhide body (g)", ItemID.BLUE_DHIDE_BODY_G, "Clue Scroll (Hard)", "Dhide", 12),
	BLUE_DHIDE_CHAPS_G("Blue dhide chaps (g)", ItemID.BLUE_DHIDE_CHAPS_G, "Clue Scroll (Hard)", "Dhide", 12),
	RED_DHIDE_BODY_T("Red dhide body (t)", ItemID.RED_DHIDE_BODY_T, "Clue Scroll (Hard)", "Dhide", 13),
	RED_DHIDE_CHAPS_T("Red dhide chaps (t)", ItemID.RED_DHIDE_CHAPS_T, "Clue Scroll (Hard)", "Dhide", 13),
	RED_DHIDE_BODY_G("Red dhide body (g)", ItemID.RED_DHIDE_BODY_G, "Clue Scroll (Hard)", "Dhide", 13),
	RED_DHIDE_CHAPS_G("Red dhide chaps (g)", ItemID.RED_DHIDE_CHAPS_G, "Clue Scroll (Hard)", "Dhide", 13),
	ENCHANTED_HAT("Enchanted hat", ItemID.ENCHANTED_HAT, "Clue Scroll (Hard)", "Enchanted", 14),
	ENCHANTED_TOP("Enchanted top", ItemID.ENCHANTED_TOP, "Clue Scroll (Hard)", "Enchanted", 14),
	ENCHANTED_ROBE("Enchanted robe", ItemID.ENCHANTED_ROBE, "Clue Scroll (Hard)", "Enchanted", 14),
	AMULET_OF_GLORY_T("Amulet of glory (t)", ItemID.AMULET_OF_GLORY_T, "Clue Scroll (Hard)", "Enchanted", 14),
	ROBIN_HOOD_HAT("Robin hood hat", ItemID.ROBIN_HOOD_HAT, "Clue Scroll (Hard)", "Hats", 15),
	PIRATE_HAT("Pirate hat", ItemID.PIRATE_HAT, "Clue Scroll (Hard)", "Hats", 15),
	PITH_HELMET("Pith helmet", ItemID.PITH_HELMET, "Clue Scroll (Hard)", "Hats", 15),
	EXPLORER_BACKPACK("Explorer backpack", ItemID.EXPLORER_BACKPACK, "Clue Scroll (Hard)", "Hats", 15),
	RED_CAVALIER("Red cavalier", ItemID.RED_CAVALIER, "Clue Scroll (Hard)", "Cavalier", 16),
	TAN_CAVALIER("Tan cavalier", ItemID.TAN_CAVALIER, "Clue Scroll (Hard)", "Cavalier", 16),
	DARK_CAVALIER("Dark cavalier", ItemID.DARK_CAVALIER, "Clue Scroll (Hard)", "Cavalier", 16),
	BLACK_CAVALIER("Black cavalier", ItemID.BLACK_CAVALIER, "Clue Scroll (Hard)", "Cavalier", 16),
	NAVY_CAVALIER("Navy cavalier", ItemID.NAVY_CAVALIER, "Clue Scroll (Hard)", "Cavalier", 16),
	WHITE_CAVALIER("White cavalier", ItemID.WHITE_CAVALIER, "Clue Scroll (Hard)", "Cavalier", 16),
	_3RD_AGE_FULL_HELMET("3rd age full helm", ItemID._3RD_AGE_FULL_HELMET, "Clue Scroll (Hard)", "Third age", 17),
	_3RD_AGE_PLATEBODY("3rd age platebody", ItemID._3RD_AGE_PLATEBODY, "Clue Scroll (Hard)", "Third age", 17),
	_3RD_AGE_PLATELEGS("3rd age platelegs", ItemID._3RD_AGE_PLATELEGS, "Clue Scroll (Hard)", "Third age", 17),
	_3RD_AGE_PLATESKIRT("3rd age plateskirt", ItemID._3RD_AGE_PLATESKIRT, "Clue Scroll (Hard)", "Third age", 17),
	_3RD_AGE_KITESHIELD("3rd age kiteshield", ItemID._3RD_AGE_KITESHIELD, "Clue Scroll (Hard)", "Third age", 17),
	_3RD_AGE_RANGE_COIF("3rd age range coif", ItemID._3RD_AGE_RANGE_COIF, "Clue Scroll (Hard)", "Third age", 18),
	_3RD_AGE_RANGE_TOP("3rd age range top", ItemID._3RD_AGE_RANGE_TOP, "Clue Scroll (Hard)", "Third age", 18),
	_3RD_AGE_RANGE_LEGS("3rd age range legs", ItemID._3RD_AGE_RANGE_LEGS, "Clue Scroll (Hard)", "Third age", 18),
	_3RD_AGE_VAMBRACES("3rd age vambraces", ItemID._3RD_AGE_VAMBRACES, "Clue Scroll (Hard)", "Third age", 18),
	_3RD_AGE_MAGE_HAT("3rd age mage hat", ItemID._3RD_AGE_MAGE_HAT, "Clue Scroll (Hard)", "Third age", 19),
	_3RD_AGE_ROBE_TOP("3rd age robe top", ItemID._3RD_AGE_ROBE_TOP, "Clue Scroll (Hard)", "Third age", 19),
	_3RD_AGE_ROBE("3rd age robe", ItemID._3RD_AGE_ROBE, "Clue Scroll (Hard)", "Third age", 19),
	_3RD_AGE_AMULET("3rd age amulet", ItemID._3RD_AGE_AMULET, "Clue Scroll (Hard)", "Third age", 19),
	GUTHIX_COIF("Guthix coif", ItemID.GUTHIX_COIF, "Clue Scroll (Hard)", "God Dhide", 20),
	GUTHIX_DHIDE("Guthix dragonhide", ItemID.GUTHIX_DRAGONHIDE, "Clue Scroll (Hard)", "God Dhide", 20),
	GUTHIX_CHAPS("Guthix chaps", ItemID.GUTHIX_CHAPS, "Clue Scroll (Hard)", "God Dhide", 20),
	GUTHIX_BRACERS("Guthix bracers", ItemID.GUTHIX_BRACERS, "Clue Scroll (Hard)", "God Dhide", 20),
	GUTHIX_DHIDE_BOOTS("Guthix dhide boots", ItemID.GUTHIX_DHIDE_BOOTS, "Clue Scroll (Hard)", "God Dhide", 20),
	GUTHIX_DHIDE_SHIELD("Guthix dhide shield", ItemID.GUTHIX_DHIDE_SHIELD, "Clue Scroll (Hard)", "God Dhide", 20),
	SARADOMIN_COIF("Saradomin coif", ItemID.SARADOMIN_COIF, "Clue Scroll (Hard)", "God Dhide", 21),
	SARADOMIN_DHIDE("Saradomin dragonhide", ItemID.SARADOMIN_DHIDE, "Clue Scroll (Hard)", "God Dhide", 21),
	SARADOMIN_CHAPS("Saradomin chaps", ItemID.SARADOMIN_CHAPS, "Clue Scroll (Hard)", "God Dhide", 21),
	SARADOMIN_BRACERS("Saradomin bracers", ItemID.SARADOMIN_BRACERS, "Clue Scroll (Hard)", "God Dhide", 21),
	SARADOMIN_DHIDE_BOOTS("Saradomin dhide boots", ItemID.SARADOMIN_DHIDE_BOOTS, "Clue Scroll (Hard)", "God Dhide", 21),
	SARADOMIN_DHIDE_SHIELD("Saradomin dhide shield", ItemID.SARADOMIN_DHIDE_SHIELD, "Clue Scroll (Hard)", "God Dhide", 21),
	ZAMORAK_COIF("Zamorak coif", ItemID.ZAMORAK_COIF, "Clue Scroll (Hard)", "God Dhide", 22),
	ZAMORAK_DHIDE("Zamorak dragonhide", ItemID.ZAMORAK_DHIDE, "Clue Scroll (Hard)", "God Dhide", 22),
	ZAMORAK_CHAPS("Zamorak chaps", ItemID.ZAMORAK_CHAPS, "Clue Scroll (Hard)", "God Dhide", 22),
	ZAMORAK_BRACERS("Zamorak bracers", ItemID.ZAMORAK_BRACERS, "Clue Scroll (Hard)", "God Dhide", 22),
	ZAMORAK_DHIDE_BOOTS("Zamorak dhide boots", ItemID.ZAMORAK_DHIDE_BOOTS, "Clue Scroll (Hard)", "God Dhide", 22),
	ZAMORAK_DHIDE_SHIELD("Zamorak dhide shield", ItemID.ZAMORAK_DHIDE_SHIELD, "Clue Scroll (Hard)", "God Dhide", 22),
	ANCIENT_COIF("Ancient coif", ItemID.ANCIENT_COIF, "Clue Scroll (Hard)", "God Dhide", 23),
	ANCIENT_DHIDE("Ancient dragonhide", ItemID.ANCIENT_DHIDE, "Clue Scroll (Hard)", "God Dhide", 23),
	ANCIENT_CHAPS("Ancient chaps", ItemID.ANCIENT_CHAPS, "Clue Scroll (Hard)", "God Dhide", 23),
	ANCIENT_BRACERS("Ancient bracers", ItemID.ANCIENT_BRACERS, "Clue Scroll (Hard)", "God Dhide", 23),
	ANCIENT_DHIDE_BOOTS("Ancient dhide boots", ItemID.ANCIENT_DHIDE_BOOTS, "Clue Scroll (Hard)", "God Dhide", 23),
	ANCIENT_DHIDE_SHIELD("Ancient dhide shield", ItemID.ANCIENT_DHIDE_SHIELD, "Clue Scroll (Hard)", "God Dhide", 23),
	BANDOS_COIF("Bandos coif", ItemID.BANDOS_COIF, "Clue Scroll (Hard)", "God Dhide", 24),
	BANDOS_DHIDE("Bandos dragonhide", ItemID.BANDOS_DHIDE, "Clue Scroll (Hard)", "God Dhide", 24),
	BANDOS_CHAPS("Bandos chaps", ItemID.BANDOS_CHAPS, "Clue Scroll (Hard)", "God Dhide", 24),
	BANDOS_BRACERS("Bandos bracers", ItemID.BANDOS_BRACERS, "Clue Scroll (Hard)", "God Dhide", 24),
	BANDOS_DHIDE_BOOTS("Bandos dhide boots", ItemID.BANDOS_DHIDE_BOOTS, "Clue Scroll (Hard)", "God Dhide", 24),
	BANDOS_DHIDE_SHIELD("Bandos dhide shield", ItemID.BANDOS_DHIDE_SHIELD, "Clue Scroll (Hard)", "God Dhide", 24),
	ARMADYL_COIF("Armadyl coif", ItemID.ARMADYL_COIF, "Clue Scroll (Hard)", "God Dhide", 25),
	ARMADYL_DHIDE("Armadyl dragonhide", ItemID.ARMADYL_DHIDE, "Clue Scroll (Hard)", "God Dhide", 25),
	ARMADYL_CHAPS("Armadyl chaps", ItemID.ARMADYL_CHAPS, "Clue Scroll (Hard)", "God Dhide", 25),
	ARMADYL_BRACERS("Armadyl bracers", ItemID.ARMADYL_BRACERS, "Clue Scroll (Hard)", "God Dhide", 25),
	ARMADYL_DHIDE_BOOTS("Armadyl dhide boots", ItemID.ARMADYL_DHIDE_BOOTS, "Clue Scroll (Hard)", "God Dhide", 25),
	ARMADYL_DHIDE_SHIELD("Armadyl dhide shield", ItemID.ARMADYL_DHIDE_SHIELD, "Clue Scroll (Hard)", "God Dhide", 25),
	GUTHIX_STOLE("Guthix stole", ItemID.GUTHIX_STOLE, "Clue Scroll (Hard)", "Vestment", 26),
	GUTHIX_CROZIER("Guthix crozier", ItemID.GUTHIX_CROZIER, "Clue Scroll (Hard)", "Vestment", 26),
	SARADOMIN_STOLE("Saradomin stole", ItemID.SARADOMIN_STOLE, "Clue Scroll (Hard)", "Vestment", 26),
	SARADOMIN_CROZIER("Saradomin crozier", ItemID.SARADOMIN_CROZIER, "Clue Scroll (Hard)", "Vestment", 26),
	ZAMORAK_STOLE("Zamorak stole", ItemID.ZAMORAK_STOLE, "Clue Scroll (Hard)", "Vestment", 26),
	ZAMORAK_CROZIER("Zamorak crozier", ItemID.ZAMORAK_CROZIER, "Clue Scroll (Hard)", "Vestment", 26),
	GREEN_DRAGON_MASK("Green dragon mask", ItemID.GREEN_DRAGON_MASK, "Clue Scroll (Hard)", "Masks", 27),
	RED_DRAGON_MASK("Red dragon mask", ItemID.RED_DRAGON_MASK, "Clue Scroll (Hard)", "Masks", 27),
	BLUE_DRAGON_MASK("Blue dragon mask", ItemID.BLUE_DRAGON_MASK, "Clue Scroll (Hard)", "Masks", 27),
	BLACK_DRAGON_MASK("Black dragon mask", ItemID.BLACK_DRAGON_MASK, "Clue Scroll (Hard)", "Masks", 27),
	RUNE_CANE("Rune cane", ItemID.RUNE_CANE, "Clue Scroll (Hard)", "Other", 28),
	ZOMBIE_HEAD("Zombie head", ItemID.ZOMBIE_HEAD, "Clue Scroll (Hard)", "Other", 28),
	CYCLOPS_HEAD("Cyclops head", ItemID.CYCLOPS_HEAD, "Clue Scroll (Hard)", "Other", 28),
	NUNCHAKU("Nunchaku", ItemID.NUNCHAKU, "Clue Scroll (Hard)", "Other", 29),
	DUAL_SAI("Dual sai", ItemID.DUAL_SAI, "Clue Scroll (Hard)", "Other", 29),
	THIEVING_BAG("Thieving bag", ItemID.THIEVING_BAG, "Clue Scroll (Hard)", "Other", 29),
	DRAGON_BOOTS_ORNAMENT_KIT("Dragon boots ornament kit", ItemID.DRAGON_BOOTS_ORNAMENT_KIT, "Clue Scroll (Hard)", "Ornament Kit", 30),
	RUNE_DEFENDER_ORNAMENT_KIT("Rune defender ornament kit", ItemID.RUNE_DEFENDER_ORNAMENT_KIT, "Clue Scroll (Hard)", "Ornament Kit", 30),
	TZHAARKETOM_ORNAMENT_KIT("Tzhaar-ket-om ornament kit", ItemID.TZHAARKETOM_ORNAMENT_KIT, "Clue Scroll (Hard)", "Ornament Kit", 30),
	BERSERKER_NECKLACE_ORNAMENT_KIT("Berserker necklace ornament kit", ItemID.BERSERKER_NECKLACE_ORNAMENT_KIT, "Clue Scroll (Hard)", "Ornament Kit", 30),

	// Elite Clue Scrolls
	DRAGON_FULL_HELM_ORNAMENT_KIT("Dragon full helm ornament kit", ItemID.DRAGON_FULL_HELM_ORNAMENT_KIT, "Clue Scroll (Elite)", "Ornament Kits", -1),
	DRAGON_CHAINBODY_ORNAMENT_KIT("Dragon chainbody ornament kit", ItemID.DRAGON_CHAINBODY_ORNAMENT_KIT, "Clue Scroll (Elite)", "Ornament Kits", -1),
	DRAGON_LEGSSKIRT_ORNAMENT_KIT("Dragon legs/skirt ornament kit", ItemID.DRAGON_LEGSSKIRT_ORNAMENT_KIT, "Clue Scroll (Elite)", "Ornament Kits", -1),
	DRAGON_SQ_SHIELD_ORNAMENT_KIT("Dragon sq shield ornament kit", ItemID.DRAGON_SQ_SHIELD_ORNAMENT_KIT, "Clue Scroll (Elite)", "Ornament Kits", -1),
	DRAGON_SCIMITAR_ORNAMENT_KIT("Dragon scimitar ornament kit", ItemID.DRAGON_SCIMITAR_ORNAMENT_KIT, "Clue Scroll (Elite)", "Ornament Kits", -1),
	LIGHT_INFINITY_COLOUR_KIT("Light infinity colour kit", ItemID.LIGHT_INFINITY_COLOUR_KIT, "Clue Scroll (Elite)", "Colour Kits", 0),
	DARK_INFINITY_COLOUR_KIT("Dark infinity colour kit", ItemID.DARK_INFINITY_COLOUR_KIT, "Clue Scroll (Elite)", "Colour Kits", 0),
	FURY_ORNAMENT_KIT("Fury ornament kit", ItemID.FURY_ORNAMENT_KIT, "Clue Scroll (Elite)", "Ornament Kits", 0),
	MUSKETEER_HAT("Musketeer hat", ItemID.MUSKETEER_HAT, "Clue Scroll (Elite)", "Musketeer", 1),
	MUSKETEER_TABARD("Musketeer tabard", ItemID.MUSKETEER_TABARD, "Clue Scroll (Elite)", "Musketeer", 1),
	MUSKETEER_PANTS("Musketeer pants", ItemID.MUSKETEER_PANTS, "Clue Scroll (Elite)", "Musketeer", 1),
	DRAGON_CANE("Dragon cane", ItemID.DRAGON_CANE, "Clue Scroll (Elite)", "Musketeer", 1),
	TOP_HAT("Top hat", ItemID.TOP_HAT, "Clue Scroll (Elite)", "Fancy", 2),
	MONOCLE("Monocle", ItemID.MONOCLE, "Clue Scroll (Elite)", "Fancy", 2),
	BRIEFCASE("Briefcase", ItemID.BRIEFCASE, "Clue Scroll (Elite)", "Fancy", 2),
	SAGACIOUS_SPECTACLES("Sagacious spectacles", ItemID.SAGACIOUS_SPECTACLES, "Clue Scroll (Elite)", "Fancy", 2),
	BIG_PIRATE_HAT("Big pirate hat", ItemID.BIG_PIRATE_HAT, "Clue Scroll (Elite)", "Hats", 3),
	DEERSTALKER("Deerstalker", ItemID.DEERSTALKER, "Clue Scroll (Elite)", "Hats", 3),
	BLACKSMITHS_HELM("Blacksmith's helm", ItemID.BLACKSMITHS_HELM, "Clue Scroll (Elite)", "Hats", 3),
	BUCKET_HELM("Bucket helm", ItemID.BUCKET_HELM, "Clue Scroll (Elite)", "Hats", 3),
	AFRO("Afro", ItemID.AFRO, "Clue Scroll (Elite)", "Hats", 3),
	GILDED_BOOTS("Gilded boots", ItemID.GILDED_BOOTS, "Clue Scroll (Elite)", "Rare", 4),
	GILDED_SCIMITAR("Gilded scimitar", ItemID.GILDED_SCIMITAR, "Clue Scroll (Elite)", "Rare", 4),
	RANGERS_TUNIC("Rangers' tunic", ItemID.RANGERS_TUNIC, "Clue Scroll (Elite)", "Rare", 4),
	RANGERS_TIGHTS("Rangers' tights", ItemID.RANGERS_TIGHTS, "Clue Scroll (Elite)", "Rare", 4),
	RANGER_GLOVES("Ranger gloves", ItemID.RANGER_GLOVES, "Clue Scroll (Elite)", "Rare", 4),
	BRONZE_DRAGON_MASK("Bronze dragon mask", ItemID.BRONZE_DRAGON_MASK, "Clue Scroll (Elite)", "Masks", 5),
	IRON_DRAGON_MASK("Iron dragon mask", ItemID.IRON_DRAGON_MASK, "Clue Scroll (Elite)", "Masks", 5),
	STEEL_DRAGON_MASK("Steel dragon mask", ItemID.STEEL_DRAGON_MASK, "Clue Scroll (Elite)", "Masks", 5),
	MITHRIL_DRAGON_MASK("Mithril dragon mask", ItemID.MITHRIL_DRAGON_MASK, "Clue Scroll (Elite)", "Masks", 5),
	ADAMANT_DRAGON_MASK("Adamant dragon mask", ItemID.ADAMANT_DRAGON_MASK, "Clue Scroll (Elite)", "Masks", 6),
	RUNE_DRAGON_MASK("Rune dragon mask", ItemID.RUNE_DRAGON_MASK, "Clue Scroll (Elite)", "Masks", 6),
	LAVA_DRAGON_MASK("Lava dragon mask", ItemID.LAVA_DRAGON_MASK, "Clue Scroll (Elite)", "Masks", 6),
	BLACK_DHIDE_BODY_T("Black dhide body (t)", ItemID.BLACK_DHIDE_BODY_T, "Clue Scroll (Elite)", "Dhide", 7),
	BLACK_DHIDE_CHAPS_T("Black dhide chaps (t)", ItemID.BLACK_DHIDE_CHAPS_T, "Clue Scroll (Elite)", "Dhide", 7),
	BLACK_DHIDE_BODY_G("Black dhide body (g)", ItemID.BLACK_DHIDE_BODY_G, "Clue Scroll (Elite)", "Dhide", 7),
	BLACK_DHIDE_CHAPS_G("Black dhide chaps (g)", ItemID.BLACK_DHIDE_CHAPS_G, "Clue Scroll (Elite)", "Dhide", 7),
	GILDED_COIF("Gilded coif", ItemID.GILDED_COIF, "Clue Scroll (Elite)", "Dhide", 8),
	GILDED_DHIDE_BODY("Gilded dhide body", ItemID.GILDED_DHIDE_BODY, "Clue Scroll (Elite)", "Dhide", 8),
	GILDED_DHIDE_CHAPS("Gilded dhide chaps", ItemID.GILDED_DHIDE_CHAPS, "Clue Scroll (Elite)", "Dhide", 8),
	GILDED_DHIDE_VAMBS("Gilded dhide vambs", ItemID.GILDED_DHIDE_VAMBS, "Clue Scroll (Elite)", "Dhide", 8),
	_3RD_AGE_CLOAK("3rd age cloak", ItemID._3RD_AGE_CLOAK, "Clue Scroll (Elite)", "Third Age", 9),
	_3RD_AGE_WAND("3rd age wand", ItemID._3RD_AGE_WAND, "Clue Scroll (Elite)", "Third Age", 9),
	_3RD_AGE_BOW("3rd age bow", ItemID._3RD_AGE_BOW, "Clue Scroll (Elite)", "Third Age", 9),
	_3RD_AGE_LONGSWORD("3rd age longsword", ItemID._3RD_AGE_LONGSWORD, "Clue Scroll (Elite)", "Third Age", 9),
	ROYAL_CROWN("Royal crown", ItemID.ROYAL_CROWN, "Clue Scroll (Elite)", "Royal", 10),
	ROYAL_GOWN_TOP("Royal gown top", ItemID.ROYAL_GOWN_TOP, "Clue Scroll (Elite)", "Royal", 10),
	ROYAL_GOWN_BOTTOM("Royal gown bottom", ItemID.ROYAL_GOWN_BOTTOM, "Clue Scroll (Elite)", "Royal", 10),
	ROYAL_SCEPTRE("Royal sceptre", ItemID.ROYAL_SCEPTRE, "Clue Scroll (Elite)", "Royal", 10),
	GILDED_PICKAXE("Gilded pickaxe", ItemID.GILDED_PICKAXE, "Clue Scroll (Elite)", "Gilded", 11),
	GILDED_AXE("Gilded axe", ItemID.GILDED_AXE, "Clue Scroll (Elite)", "Gilded", 11),
	GILDED_SPADE("Gilded spade", ItemID.GILDED_SPADE, "Clue Scroll (Elite)", "Gilded", 11),
	ARCEUUS_SCARF("Arceuus house scarf", ItemID.ARCEUUS_SCARF, "Clue Scroll (Elite)", "Zeah Scarfs", 12),
	HOSIDIUS_SCARF("Hosidius house scarf", ItemID.HOSIDIUS_SCARF, "Clue Scroll (Elite)", "Zeah Scarfs", 12),
	LOVAKENGJ_SCARF("Lovakengj house scarf", ItemID.LOVAKENGJ_SCARF, "Clue Scroll (Elite)", "Zeah Scarfs", 12),
	PISCARILIUS_SCARF("Piscarilius house scarf", ItemID.PISCARILIUS_SCARF, "Clue Scroll (Elite)", "Zeah Scarfs", 12),
	SHAYZIEN_SCARF("Shayzien house scarf", ItemID.SHAYZIEN_SCARF, "Clue Scroll (Elite)", "Zeah Scarfs", 12),
	DARK_BOW_TIE("Dark bow tie", ItemID.DARK_BOW_TIE, "Clue Scroll (Elite)", "Dark Tuxedo", 13),
	DARK_TUXEDO_JACKET("Dark tuxedo jacket", ItemID.DARK_TUXEDO_JACKET, "Clue Scroll (Elite)", "Dark Tuxedo", 13),
	DARK_TROUSERS("Dark trousers", ItemID.DARK_TROUSERS, "Clue Scroll (Elite)", "Dark Tuxedo", 13),
	DARK_TUXEDO_CUFFS("Dark tuxedo cuffs", ItemID.DARK_TUXEDO_CUFFS, "Clue Scroll (Elite)", "Dark Tuxedo", 13),
	DARK_TUXEDO_SHOES("Dark tuxedo shoes", ItemID.DARK_TUXEDO_SHOES, "Clue Scroll (Elite)", "Dark Tuxedo", 13),
	LIGHT_BOW_TIE("Light bow tie", ItemID.LIGHT_BOW_TIE, "Clue Scroll (Elite)", "Light Tuxedo", 14),
	LIGHT_TUXEDO_JACKET("Light tuxedo jacket", ItemID.LIGHT_TUXEDO_JACKET, "Clue Scroll (Elite)", "Light Tuxedo", 14),
	LIGHT_TROUSERS("Light trousers", ItemID.LIGHT_TROUSERS, "Clue Scroll (Elite)", "Light Tuxedo", 14),
	LIGHT_TUXEDO_CUFFS("Light tuxedo cuffs", ItemID.LIGHT_TUXEDO_CUFFS, "Clue Scroll (Elite)", "Light Tuxedo", 14),
	LIGHT_TUXEDO_SHOES("Light tuxedo shoes", ItemID.LIGHT_TUXEDO_SHOES, "Clue Scroll (Elite)", "Light Tuxedo", 14),
	HOLY_WRAPS("Holy wraps", ItemID.HOLY_WRAPS, "Clue Scroll (Elite)", "Other", 15),
	RING_OF_NATURE("Ring of nature", ItemID.RING_OF_NATURE, "Clue Scroll (Elite)", "Other", 15),
	HEAVY_CASKET("Heavy casket", ItemID.HEAVY_CASKET, "Clue Scroll (Elite)", "Other", 15),
	KATANA("Katana", ItemID.KATANA, "Clue Scroll (Elite)", "Other", 16),
	URIS_HAT("Uri's hat", ItemID.URIS_HAT, "Clue Scroll (Elite)", "Other", 16),
	FREMENNIK_KILT("Fremennik Kilt", ItemID.FREMENNIK_KILT, "Clue Scroll (Elite)", "Other", 16),

	// Master Clue Scrolls
	DRAGON_PLATEBODY_ORNAMENT_KIT("Dragon platebody ornament kit", ItemID.DRAGON_PLATEBODY_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", -1),
	DRAGON_KITESHIELD_ORNAMENT_KIT("Dragon kiteshield ornament kit", ItemID.DRAGON_KITESHIELD_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", -1),
	DRAGON_DEFENDER_ORNAMENT_KIT("Dragon defender ornament kit", ItemID.DRAGON_DEFENDER_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", -1),
	TORMENTED_ORNAMENT_KIT("Tormented bracelet ornament kit", ItemID.TORMENTED_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", -1),
	ANGUISH_ORNAMENT_KIT("Anguish ornament kit", ItemID.ANGUISH_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", -1),
	TORTURE_ORNAMENT_KIT("Torture ornament kit", ItemID.TORTURE_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", -1),
	OCCULT_ORNAMENT_KIT("Occult ornament kit", ItemID.OCCULT_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", 0),
	ARMADYL_GODSWORD_ORNAMENT_KIT("Armadyl godsword ornament kit", ItemID.ARMADYL_GODSWORD_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", 0),
	BANDOS_GODSWORD_ORNAMENT_KIT("Bandos godsword ornament kit", ItemID.BANDOS_GODSWORD_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", 0),
	SARADOMIN_GODSWORD_ORNAMENT_KIT("Saradomin godsword ornament kit", ItemID.SARADOMIN_GODSWORD_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", 0),
	ZAMORAK_GODSWORD_ORNAMENT_KIT("Zamorak godsword ornament kit", ItemID.ZAMORAK_GODSWORD_ORNAMENT_KIT, "Clue Scroll (Master)", "Ornament Kits", 0),
	_3RD_AGE_AXE("3rd age axe", ItemID._3RD_AGE_AXE, "Clue Scroll (Master)", "3rd age", 1),
	_3RD_AGE_PICKAXE("3rd age pickaxe", ItemID._3RD_AGE_PICKAXE, "Clue Scroll (Master)", "3rd age", 1),
	_3RD_AGE_DRUIDIC_STAFF("3rd age druidic staff", ItemID._3RD_AGE_DRUIDIC_STAFF, "Clue Scroll (Master)", "3rd age", 2),
	_3RD_AGE_DRUIDIC_ROBE_TOP("3rd age druidic robe top", ItemID._3RD_AGE_DRUIDIC_ROBE_TOP, "Clue Scroll (Master)", "3rd age", 2),
	_3RD_AGE_DRUIDIC_ROBE_BOTTOMS("3rd age druidic robe bottom", ItemID._3RD_AGE_DRUIDIC_ROBE_BOTTOMS, "Clue Scroll (Master)", "3rd age", 2),
	_3RD_AGE_DRUIDIC_CLOAK("3rd age druidic cloak", ItemID._3RD_AGE_DRUIDIC_CLOAK, "Clue Scroll (Master)", "3rd age", 2),
	LESSER_DEMON_MASK("Lesser demon mask", ItemID.LESSER_DEMON_MASK, "Clue Scroll (Master)", "Demon Masks", 3),
	GREATER_DEMON_MASK("Greater demon mask", ItemID.GREATER_DEMON_MASK, "Clue Scroll (Master)", "Demon Masks", 3),
	BLACK_DEMON_MASK("Black demon mask", ItemID.BLACK_DEMON_MASK, "Clue Scroll (Master)", "Demon Masks", 3),
	JUNGLE_DEMON_MASK("Jungle demon mask", ItemID.JUNGLE_DEMON_MASK, "Clue Scroll (Master)", "Demon Masks", 3),
	OLD_DEMON_MASK("Old demon mask", ItemID.OLD_DEMON_MASK, "Clue Scroll (Master)", "Demon Masks", 3),
	ARCEUUS_HOOD("Arceuus house hood", ItemID.ARCEUUS_HOOD, "Clue Scroll (Master)", "House Hoods", 4),
	HOSIDIUS_HOOD("Hosidius house hood", ItemID.HOSIDIUS_HOOD, "Clue Scroll (Master)", "House Hoods", 4),
	LOVAKENGJ_HOOD("Lovakengj house hood", ItemID.LOVAKENGJ_HOOD, "Clue Scroll (Master)", "House Hoods", 4),
	PISCARILIUS_HOOD("Piscarilius house hood", ItemID.PISCARILIUS_HOOD, "Clue Scroll (Master)", "House Hoods", 4),
	SHAYZIEN_HOUSE_HOOD("Shayzien house hood", ItemID.SHAYZIEN_HOOD, "Clue Scroll (Master)", "House Hoods", 4),
	SAMURAI_KASA("Samurai kasa", ItemID.SAMURAI_KASA, "Clue Scroll (Master)", "Samurai Outfit", 5),
	SAMURAI_SHIRT("Samurai shirt", ItemID.SAMURAI_SHIRT, "Clue Scroll (Master)", "Samurai Outfit", 5),
	SAMURAI_GREAVES("Samurai greaves", ItemID.SAMURAI_GREAVES, "Clue Scroll (Master)", "Samurai Outfit", 5),
	SAMURAI_GLOVES("Samurai gloves", ItemID.SAMURAI_GLOVES, "Clue Scroll (Master)", "Samurai Outfit", 5),
	SAMURAI_BOOTS("Samurai boots", ItemID.SAMURAI_BOOTS, "Clue Scroll (Master)", "Samurai Outfit", 5),
	MUMMYS_HEAD("Mummy's head", ItemID.MUMMYS_HEAD, "Clue Scroll (Master)", "Mummy Outfit", 6),
	MUMMYS_BODY("Mummy's body", ItemID.MUMMYS_BODY, "Clue Scroll (Master)", "Mummy Outfit", 6),
	MUMMYS_LEGS("Mummy's legs", ItemID.MUMMYS_LEGS, "Clue Scroll (Master)", "Mummy Outfit", 6),
	MUMMYS_HANDS("Mummy's hands", ItemID.MUMMYS_HANDS, "Clue Scroll (Master)", "Mummy Outfit", 6),
	MUMMYS_FEET("Mummy's feet", ItemID.MUMMYS_FEET, "Clue Scroll (Master)", "Mummy Outfit", 6),
	ANKOU_MASK("Ankou mask", ItemID.ANKOU_MASK, "Clue Scroll (Master)", "Ankou Outfit", 7),
	ANKOU_TOP("Ankou top", ItemID.ANKOU_TOP, "Clue Scroll (Master)", "Ankou Outfit", 7),
	ANKOUS_LEGGINGS("Ankou's leggings", ItemID.ANKOUS_LEGGINGS, "Clue Scroll (Master)", "Ankou Outfit", 7),
	ANKOU_GLOVES("Ankou gloves", ItemID.ANKOU_GLOVES, "Clue Scroll (Master)", "Ankou Outfit", 7),
	ANKOU_SOCKS("Ankou socks", ItemID.ANKOU_SOCKS, "Clue Scroll (Master)", "Ankou Outfit", 7),
	HOOD_OF_DARKNESS("Hood of darkness", ItemID.HOOD_OF_DARKNESS, "Clue Scroll (Master)", "Robes of Darkness", 8),
	ROBE_TOP_OF_DARKNESS("Robe top of darkness", ItemID.ROBE_TOP_OF_DARKNESS, "Clue Scroll (Master)", "Robes of Darkness", 8),
	ROBE_BOTTOM_OF_DARKNESS("Robe bottom of darkness", ItemID.ROBE_BOTTOM_OF_DARKNESS, "Clue Scroll (Master)", "Robes of Darkness", 8),
	BOOTS_OF_DARKNESS("Boots of darkness", ItemID.BOOTS_OF_DARKNESS, "Clue Scroll (Master)", "Robes of Darkness", 8),
	GLOVES_OF_DARKNESS("Gloves of darkness", ItemID.GLOVES_OF_DARKNESS, "Clue Scroll (Master)", "Robes of Darkness", 8),
	RING_OF_COINS("Ring of coins", ItemID.RING_OF_COINS, "Clue Scroll (Master)", "Other", 9),
	LEFT_EYE_PATCH("Left eye patch", ItemID.LEFT_EYE_PATCH, "Clue Scroll (Master)", "Other", 9),
	OBSIDIAN_CAPE_R("Obsidian cape (r)", ItemID.OBSIDIAN_CAPE_R, "Clue Scroll (Master)", "Other", 9),
	FANCY_TIARA("Fancy tiara", ItemID.FANCY_TIARA, "Clue Scroll (Master)", "Other", 9),
	HALF_MOON_SPECTACLES("Half moon spectacles", ItemID.HALF_MOON_SPECTACLES, "Clue Scroll (Master)", "Other", 9),
	ALE_OF_THE_GODS("Ale of the gods", ItemID.ALE_OF_THE_GODS, "Clue Scroll (Master)", "Other 2", 10),
	BUCKET_HELM_G("Bucket helm (g)", ItemID.BUCKET_HELM_G, "Clue Scroll (Master)", "Other 2", 10),
	BOWL_WIG("Bowl wig", ItemID.BOWL_WIG, "Clue Scroll (Master)", "Other 2", 10),
	BLOODHOUND("Bloodhound", ItemID.BLOODHOUND, "Clue Scroll (Master)", "Other 2", 10),

	HERBI("Herbi", ItemID.HERBI, "Herbiboar", "Pet", -1);

	// Shared Unique Items
	UniqueItem(String n, int id, String... activities)
	{
		this.name = n;
		this.itemID = id;
		this.activities = activities;
		this.setName = "Shared";
		this.position = -1;
	}

	// Non-Shared Unique Items
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

	// Returns an array of UniqueItems by an individual `activities` name
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
			byName.computeIfAbsent(item.getSetName().toUpperCase(), e -> new ArrayList<>()).add(item);
		}

		return byName;
	}

	// Takes a list of UniqueItems and maps them by Position to ensure adding in predefined order
	public static Map<Integer, Collection<UniqueItemPrepared>> createPositionSetMap(Collection<UniqueItemPrepared> items)
	{
		Map<Integer, Collection<UniqueItemPrepared>> setNames = new HashMap<>();
		for (UniqueItemPrepared item : items)
		{
			setNames.computeIfAbsent(item.getUniqueItem().getPosition(), e -> new ArrayList<>()).add(item);
		}

		// Sort them by Key
		return setNames.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
}