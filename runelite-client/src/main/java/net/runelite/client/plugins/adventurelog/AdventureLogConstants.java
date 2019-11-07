/*
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
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
package net.runelite.client.plugins.adventurelog;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import net.runelite.api.ItemID;

public final class AdventureLogConstants
{
	public static final Set<Integer> RARE_DROPS = ImmutableSet.of(
		// Sarachnis
		ItemID.SARACHNIS_CUDGEL,
		ItemID.JAR_OF_EYES,

		// Kalphite Queen
		ItemID.DRAGON_CHAINBODY, //multiple ids, look into
		ItemID.DRAGON_2H_SWORD, //multiple ids, look into
		ItemID.KQ_HEAD, //multiple ids, look into
		ItemID.KQ_HEAD_TATTERED,
		ItemID.JAR_OF_SAND,

		// Dagannoth Kings
		ItemID.ARCHERS_RING,
		ItemID.SEERCULL,
		ItemID.WARRIOR_RING,
		ItemID.BERSERKER_RING, //multiple ids, look into
		ItemID.SEERS_RING,
		ItemID.MUD_BATTLESTAFF,

		// Commander Zilyana
		ItemID.SARADOMIN_SWORD,
		ItemID.SARADOMINS_LIGHT,
		ItemID.ARMADYL_CROSSBOW, //multiple ids, look into
		ItemID.SARADOMIN_HILT,

		// K'ril Tsutsaroth
		ItemID.STEAM_BATTLESTAFF, //multiple ids, look into
		ItemID.ZAMORAKIAN_SPEAR,
		ItemID.STAFF_OF_THE_DEAD, //multiple ids, look into
		ItemID.ZAMORAK_HILT,

		// General Graardor
		ItemID.BANDOS_CHESTPLATE,
		ItemID.BANDOS_TASSETS, //multiple ids, look into
		ItemID.BANDOS_BOOTS, //multiple ids, look into
		ItemID.BANDOS_HILT,

		// Kree'arra
		ItemID.ARMADYL_HELMET,
		ItemID.ARMADYL_CHESTPLATE,
		ItemID.ARMADYL_CHAINSKIRT,
		ItemID.ARMADYL_HILT,

		// Wilderness Bosses
		ItemID.DRAGON_PICKAXE, //multiple ids, look into
		ItemID.KBD_HEADS, //multiple ids, look into
		ItemID.TYRANNICAL_RING,
		ItemID.RING_OF_THE_GODS,
		ItemID.TREASONOUS_RING,
		ItemID.MALEDICTION_SHARD_1,
		ItemID.MALEDICTION_SHARD_2,
		ItemID.MALEDICTION_SHARD_3,
		ItemID.ODIUM_SHARD_1,
		ItemID.ODIUM_SHARD_2,
		ItemID.ODIUM_SHARD_3,
		ItemID.FEDORA,

		// Skotizo
		ItemID.JAR_OF_DARKNESS,
		ItemID.DARK_CLAW,

		// Obor
		ItemID.HILL_GIANT_CLUB,

		//Bryophyta
		ItemID.BRYOPHYTAS_ESSENCE,

		//Hespori
		ItemID.BOTTOMLESS_COMPOST_BUCKET, //multiple ids, look into

		// Zalcano
		ItemID.CRYSTAL_TOOL_SEED,
		ItemID.ZALCANO_SHARD,

		// The Gauntlet
		ItemID.BLADE_OF_SAELDOR_INACTIVE,
		ItemID.CRYSTAL_ARMOUR_SEED,
		ItemID.CRYSTAL_WEAPON_SEED,

		// Grotesque Guardians
		ItemID.GRANITE_GLOVES,
		ItemID.GRANITE_RING,
		ItemID.GRANITE_HAMMER,
		ItemID.BLACK_TOURMALINE_CORE,
		ItemID.JAR_OF_STONE,

		// Abyssal Sire
		ItemID.UNSIRED,
		ItemID.JAR_OF_MIASMA, //I don't think we actually have support for unsired yet so these below are useless
		ItemID.ABYSSAL_HEAD, //multiple ids, look into --- also can get from abby demons
		ItemID.ABYSSAL_WHIP, //multiple ids, look into --- also can get from abby demons
		ItemID.ABYSSAL_DAGGER, //also can get from abby demons
		ItemID.BLUDGEON_AXON,
		ItemID.BLUDGEON_CLAW,
		ItemID.BLUDGEON_SPINE,


		// Kraken
		ItemID.KRAKEN_TENTACLE,
		ItemID.TRIDENT_OF_THE_SEAS_FULL,
		ItemID.JAR_OF_DIRT,

		// Cerberus
		ItemID.PRIMORDIAL_CRYSTAL,
		ItemID.PEGASIAN_CRYSTAL,
		ItemID.ETERNAL_CRYSTAL,
		ItemID.SMOULDERING_STONE,
		ItemID.JAR_OF_SOULS,

		// Thermonuclear Smoke Devil
		ItemID.SMOKE_BATTLESTAFF,
		ItemID.OCCULT_NECKLACE, //multiple ids, look into

		// Alchemical Hydra
		ItemID.HYDRA_LEATHER,
		ItemID.HYDRAS_CLAW,
		ItemID.HYDRAS_EYE,
		ItemID.HYDRAS_FANG,
		ItemID.HYDRAS_HEART,
		ItemID.HYDRA_TAIL,
		ItemID.DRAGON_THROWNAXE, //multiple ids, look into
		ItemID.DRAGON_KNIFE, //multiple ids, look into
		ItemID.JAR_OF_CHEMICALS,
		ItemID.ALCHEMICAL_HYDRA_HEADS,

		// Zulrah
		ItemID.MAGMA_MUTAGEN,
		ItemID.TANZANITE_MUTAGEN,
		ItemID.TANZANITE_FANG,
		ItemID.MAGIC_FANG,
		ItemID.SERPENTINE_VISAGE,
		ItemID.ONYX,
		ItemID.JAR_OF_SWAMP,

		// Vorkath
		ItemID.VORKATHS_HEAD, //multiple ids, look into
		ItemID.DRACONIC_VISAGE,
		ItemID.SKELETAL_VISAGE,
		ItemID.DRAGONBONE_NECKLACE,
		ItemID.JAR_OF_DECAY,

		// Wyverns
		ItemID.WYVERN_VISAGE,

		// Rune/addy Dragons
		ItemID.DRAGON_LIMBS,
		ItemID.DRAGON_METAL_LUMP,
		ItemID.DRAGON_METAL_SLICE,

		// Barrows
		ItemID.AHRIMS_HOOD,
		ItemID.AHRIMS_ROBESKIRT,
		ItemID.AHRIMS_ROBETOP,
		ItemID.AHRIMS_STAFF,
		ItemID.DHAROKS_GREATAXE,
		ItemID.DHAROKS_HELM,
		ItemID.DHAROKS_PLATEBODY,
		ItemID.DHAROKS_PLATELEGS,
		ItemID.GUTHANS_CHAINSKIRT,
		ItemID.GUTHANS_HELM,
		ItemID.GUTHANS_PLATEBODY,
		ItemID.GUTHANS_WARSPEAR,
		ItemID.KARILS_COIF,
		ItemID.KARILS_CROSSBOW,
		ItemID.KARILS_LEATHERSKIRT,
		ItemID.KARILS_LEATHERTOP,
		ItemID.TORAGS_HAMMERS,
		ItemID.TORAGS_HELM,
		ItemID.TORAGS_PLATEBODY,
		ItemID.TORAGS_PLATELEGS,
		ItemID.VERACS_BRASSARD,
		ItemID.VERACS_FLAIL,
		ItemID.VERACS_HELM,
		ItemID.VERACS_PLATESKIRT,

// commented out because we track all CoX drops for now so this would duplicate data
//		// Chambers of Xeric
//		ItemID.DEXTEROUS_PRAYER_SCROLL,
//		ItemID.ARCANE_PRAYER_SCROLL,
//		ItemID.TWISTED_BUCKLER,
//		ItemID.DRAGON_HUNTER_CROSSBOW,
//		ItemID.DINHS_BULWARK,
//		ItemID.ANCESTRAL_HAT,
//		ItemID.ANCESTRAL_ROBE_BOTTOM,
//		ItemID.ANCESTRAL_ROBE_TOP,
//		ItemID.DRAGON_CLAWS, //multiple ids
//		ItemID.ELDER_MAUL, //multiple ids
//		ItemID.KODAI_INSIGNIA,
//		ItemID.TWISTED_BOW,

		// Theatre of Blood
		ItemID.AVERNIC_DEFENDER_HILT,
		ItemID.GHRAZI_RAPIER, //multiple ids
		ItemID.SANGUINESTI_STAFF_UNCHARGED,
		ItemID.JUSTICIAR_CHESTGUARD,
		ItemID.JUSTICIAR_FACEGUARD,
		ItemID.JUSTICIAR_LEGGUARDS,
		ItemID.SCYTHE_OF_VITUR_UNCHARGED,

		// Corporeal Beast
		ItemID.SPIRIT_SHIELD, //multiple ids
		ItemID.HOLY_ELIXIR,
		ItemID.SPECTRAL_SIGIL,
		ItemID.ARCANE_SIGIL,
		ItemID.ELYSIAN_SIGIL
	);
}
