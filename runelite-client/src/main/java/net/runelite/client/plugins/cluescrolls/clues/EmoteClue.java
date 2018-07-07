/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.cluescrolls.clues;

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;
import lombok.Getter;
import net.runelite.api.EquipmentInventorySlot;
import static net.runelite.api.EquipmentInventorySlot.AMULET;
import static net.runelite.api.EquipmentInventorySlot.BODY;
import static net.runelite.api.EquipmentInventorySlot.BOOTS;
import static net.runelite.api.EquipmentInventorySlot.CAPE;
import static net.runelite.api.EquipmentInventorySlot.GLOVES;
import static net.runelite.api.EquipmentInventorySlot.HEAD;
import static net.runelite.api.EquipmentInventorySlot.LEGS;
import static net.runelite.api.EquipmentInventorySlot.RING;
import static net.runelite.api.EquipmentInventorySlot.SHIELD;
import static net.runelite.api.EquipmentInventorySlot.WEAPON;
import net.runelite.api.Item;
import static net.runelite.api.ItemID.ABYSSAL_WHIP;
import static net.runelite.api.ItemID.ADAMANT_2H_SWORD;
import static net.runelite.api.ItemID.ADAMANT_BOOTS;
import static net.runelite.api.ItemID.ADAMANT_DAGGER;
import static net.runelite.api.ItemID.ADAMANT_FULL_HELM;
import static net.runelite.api.ItemID.ADAMANT_HALBERD;
import static net.runelite.api.ItemID.ADAMANT_MED_HELM;
import static net.runelite.api.ItemID.ADAMANT_PLATEBODY;
import static net.runelite.api.ItemID.ADAMANT_PLATELEGS;
import static net.runelite.api.ItemID.ADAMANT_PLATESKIRT;
import static net.runelite.api.ItemID.ADAMANT_SQ_SHIELD;
import static net.runelite.api.ItemID.ADAMANT_SWORD;
import static net.runelite.api.ItemID.AHRIMS_HOOD_0;
import static net.runelite.api.ItemID.AHRIMS_HOOD_100;
import static net.runelite.api.ItemID.AHRIMS_ROBESKIRT_0;
import static net.runelite.api.ItemID.AHRIMS_ROBESKIRT_100;
import static net.runelite.api.ItemID.AHRIMS_ROBETOP_0;
import static net.runelite.api.ItemID.AHRIMS_ROBETOP_100;
import static net.runelite.api.ItemID.AHRIMS_STAFF_0;
import static net.runelite.api.ItemID.AHRIMS_STAFF_100;
import static net.runelite.api.ItemID.AIR_TIARA;
import static net.runelite.api.ItemID.AMULET_OF_GLORY;
import static net.runelite.api.ItemID.AMULET_OF_GLORY1;
import static net.runelite.api.ItemID.AMULET_OF_GLORY2;
import static net.runelite.api.ItemID.AMULET_OF_GLORY3;
import static net.runelite.api.ItemID.AMULET_OF_GLORY4;
import static net.runelite.api.ItemID.AMULET_OF_GLORY5;
import static net.runelite.api.ItemID.AMULET_OF_GLORY6;
import static net.runelite.api.ItemID.AMULET_OF_POWER;
import static net.runelite.api.ItemID.AMULET_OF_STRENGTH;
import static net.runelite.api.ItemID.AMULET_OF_THE_DAMNED;
import static net.runelite.api.ItemID.ANCIENT_CROZIER;
import static net.runelite.api.ItemID.ANCIENT_MITRE;
import static net.runelite.api.ItemID.ANCIENT_STOLE;
import static net.runelite.api.ItemID.ARCLIGHT;
import static net.runelite.api.ItemID.ARMADYL_CROZIER;
import static net.runelite.api.ItemID.ARMADYL_MITRE;
import static net.runelite.api.ItemID.ARMADYL_STOLE;
import static net.runelite.api.ItemID.BANDOS_BOOTS;
import static net.runelite.api.ItemID.BANDOS_CLOAK;
import static net.runelite.api.ItemID.BANDOS_CROZIER;
import static net.runelite.api.ItemID.BANDOS_GODSWORD;
import static net.runelite.api.ItemID.BANDOS_MITRE;
import static net.runelite.api.ItemID.BANDOS_PLATEBODY;
import static net.runelite.api.ItemID.BANDOS_STOLE;
import static net.runelite.api.ItemID.BARROWS_GLOVES;
import static net.runelite.api.ItemID.BLACK_AXE;
import static net.runelite.api.ItemID.BLACK_BOATER;
import static net.runelite.api.ItemID.BLACK_CAPE;
import static net.runelite.api.ItemID.BLACK_DHIDE_BODY;
import static net.runelite.api.ItemID.BLACK_DHIDE_CHAPS;
import static net.runelite.api.ItemID.BLACK_DHIDE_VAMB;
import static net.runelite.api.ItemID.BLACK_DRAGON_MASK;
import static net.runelite.api.ItemID.BLACK_PLATEBODY;
import static net.runelite.api.ItemID.BLACK_SALAMANDER;
import static net.runelite.api.ItemID.BLACK_SLAYER_HELMET;
import static net.runelite.api.ItemID.BLACK_SLAYER_HELMET_I;
import static net.runelite.api.ItemID.BLUE_BOATER;
import static net.runelite.api.ItemID.BLUE_BOOTS;
import static net.runelite.api.ItemID.BLUE_DHIDE_BODY;
import static net.runelite.api.ItemID.BLUE_DHIDE_CHAPS;
import static net.runelite.api.ItemID.BLUE_DHIDE_VAMB;
import static net.runelite.api.ItemID.BLUE_ROBE_TOP;
import static net.runelite.api.ItemID.BLUE_WIZARD_HAT;
import static net.runelite.api.ItemID.BLUE_WIZARD_ROBE;
import static net.runelite.api.ItemID.BOBS_PURPLE_SHIRT;
import static net.runelite.api.ItemID.BOBS_RED_SHIRT;
import static net.runelite.api.ItemID.BODY_TIARA;
import static net.runelite.api.ItemID.BONE_DAGGER;
import static net.runelite.api.ItemID.BONE_SPEAR;
import static net.runelite.api.ItemID.BOOK_OF_BALANCE;
import static net.runelite.api.ItemID.BOOK_OF_DARKNESS;
import static net.runelite.api.ItemID.BOOK_OF_LAW;
import static net.runelite.api.ItemID.BOOK_OF_WAR;
import static net.runelite.api.ItemID.BRINE_SABRE;
import static net.runelite.api.ItemID.BRONZE_2H_SWORD;
import static net.runelite.api.ItemID.BRONZE_AXE;
import static net.runelite.api.ItemID.BRONZE_CHAINBODY;
import static net.runelite.api.ItemID.BRONZE_DAGGER;
import static net.runelite.api.ItemID.BRONZE_FULL_HELM;
import static net.runelite.api.ItemID.BRONZE_PLATELEGS;
import static net.runelite.api.ItemID.BRONZE_SPEAR;
import static net.runelite.api.ItemID.BRONZE_SQ_SHIELD;
import static net.runelite.api.ItemID.BROWN_APRON;
import static net.runelite.api.ItemID.BROWN_HEADBAND;
import static net.runelite.api.ItemID.BRUISE_BLUE_SNELM_3343;
import static net.runelite.api.ItemID.CAPE_OF_LEGENDS;
import static net.runelite.api.ItemID.CASTLE_WARS_BRACELET3;
import static net.runelite.api.ItemID.CASTLE_WARS_BRACELET1;
import static net.runelite.api.ItemID.CLIMBING_BOOTS;
import static net.runelite.api.ItemID.COIF;
import static net.runelite.api.ItemID.COMBAT_BRACELET;
import static net.runelite.api.ItemID.COMBAT_BRACELET4;
import static net.runelite.api.ItemID.CREAM_ROBE_TOP;
import static net.runelite.api.ItemID.DEATH_TIARA;
import static net.runelite.api.ItemID.DESERT_SHIRT;
import static net.runelite.api.ItemID.DHAROKS_GREATAXE_0;
import static net.runelite.api.ItemID.DHAROKS_GREATAXE_100;
import static net.runelite.api.ItemID.DHAROKS_HELM_0;
import static net.runelite.api.ItemID.DHAROKS_HELM_100;
import static net.runelite.api.ItemID.DHAROKS_PLATEBODY_0;
import static net.runelite.api.ItemID.DHAROKS_PLATEBODY_100;
import static net.runelite.api.ItemID.DHAROKS_PLATELEGS_0;
import static net.runelite.api.ItemID.DHAROKS_PLATELEGS_100;
import static net.runelite.api.ItemID.DIAMOND_BRACELET;
import static net.runelite.api.ItemID.DIAMOND_RING;
import static net.runelite.api.ItemID.DRAGONSTONE_AMULET;
import static net.runelite.api.ItemID.DRAGONSTONE_RING;
import static net.runelite.api.ItemID.DRAGON_2H_SWORD;
import static net.runelite.api.ItemID.DRAGON_AXE;
import static net.runelite.api.ItemID.DRAGON_BATTLEAXE;
import static net.runelite.api.ItemID.DRAGON_BOOTS;
import static net.runelite.api.ItemID.DRAGON_CHAINBODY_3140;
import static net.runelite.api.ItemID.DRAGON_DEFENDER;
import static net.runelite.api.ItemID.DRAGON_MED_HELM;
import static net.runelite.api.ItemID.DRAGON_NECKLACE;
import static net.runelite.api.ItemID.DRAGON_PICKAXE;
import static net.runelite.api.ItemID.DRAGON_PLATESKIRT;
import static net.runelite.api.ItemID.DRAGON_SPEAR;
import static net.runelite.api.ItemID.DRAGON_SQ_SHIELD;
import static net.runelite.api.ItemID.ELEMENTAL_SHIELD;
import static net.runelite.api.ItemID.EMERALD_AMULET;
import static net.runelite.api.ItemID.EMERALD_RING;
import static net.runelite.api.ItemID.FIRE_BATTLESTAFF;
import static net.runelite.api.ItemID.FIRE_CAPE;
import static net.runelite.api.ItemID.FIRE_MAX_CAPE;
import static net.runelite.api.ItemID.FLARED_TROUSERS;
import static net.runelite.api.ItemID.GOLD_NECKLACE;
import static net.runelite.api.ItemID.GOLD_RING;
import static net.runelite.api.ItemID.GRANITE_SHIELD;
import static net.runelite.api.ItemID.GREEN_BOATER;
import static net.runelite.api.ItemID.GREEN_BOOTS;
import static net.runelite.api.ItemID.GREEN_DHIDE_BODY;
import static net.runelite.api.ItemID.GREEN_DHIDE_CHAPS;
import static net.runelite.api.ItemID.GREEN_HAT;
import static net.runelite.api.ItemID.GREEN_HEADBAND;
import static net.runelite.api.ItemID.GREEN_ROBE_BOTTOMS;
import static net.runelite.api.ItemID.GREEN_ROBE_TOP;
import static net.runelite.api.ItemID.GREEN_SLAYER_HELMET;
import static net.runelite.api.ItemID.GREEN_SLAYER_HELMET_I;
import static net.runelite.api.ItemID.GUTHANS_CHAINSKIRT_0;
import static net.runelite.api.ItemID.GUTHANS_CHAINSKIRT_100;
import static net.runelite.api.ItemID.GUTHANS_HELM_0;
import static net.runelite.api.ItemID.GUTHANS_HELM_100;
import static net.runelite.api.ItemID.GUTHANS_PLATEBODY_0;
import static net.runelite.api.ItemID.GUTHANS_PLATEBODY_100;
import static net.runelite.api.ItemID.GUTHANS_WARSPEAR_0;
import static net.runelite.api.ItemID.GUTHANS_WARSPEAR_100;
import static net.runelite.api.ItemID.GUTHIX_MITRE;
import static net.runelite.api.ItemID.GUTHIX_STOLE;
import static net.runelite.api.ItemID.HAM_BOOTS;
import static net.runelite.api.ItemID.HAM_ROBE;
import static net.runelite.api.ItemID.HARDLEATHER_BODY;
import static net.runelite.api.ItemID.HELM_OF_NEITIZNOT;
import static net.runelite.api.ItemID.HOLY_BOOK;
import static net.runelite.api.ItemID.IBANS_STAFF;
import static net.runelite.api.ItemID.IBANS_STAFF_U;
import static net.runelite.api.ItemID.IRON_2H_SWORD;
import static net.runelite.api.ItemID.IRON_CHAINBODY;
import static net.runelite.api.ItemID.IRON_FULL_HELM;
import static net.runelite.api.ItemID.IRON_KITESHIELD;
import static net.runelite.api.ItemID.IRON_MED_HELM;
import static net.runelite.api.ItemID.IRON_PICKAXE;
import static net.runelite.api.ItemID.IRON_PLATEBODY;
import static net.runelite.api.ItemID.IRON_PLATELEGS;
import static net.runelite.api.ItemID.IRON_PLATESKIRT;
import static net.runelite.api.ItemID.IRON_SCIMITAR;
import static net.runelite.api.ItemID.IRON_WARHAMMER;
import static net.runelite.api.ItemID.KARILS_COIF_0;
import static net.runelite.api.ItemID.KARILS_COIF_100;
import static net.runelite.api.ItemID.KARILS_CROSSBOW_0;
import static net.runelite.api.ItemID.KARILS_CROSSBOW_100;
import static net.runelite.api.ItemID.KARILS_LEATHERSKIRT_0;
import static net.runelite.api.ItemID.KARILS_LEATHERSKIRT_100;
import static net.runelite.api.ItemID.KARILS_LEATHERTOP_0;
import static net.runelite.api.ItemID.KARILS_LEATHERTOP_100;
import static net.runelite.api.ItemID.LAVA_BATTLESTAFF;
import static net.runelite.api.ItemID.LEATHER_BOOTS;
import static net.runelite.api.ItemID.LEATHER_CHAPS;
import static net.runelite.api.ItemID.LEATHER_COWL;
import static net.runelite.api.ItemID.LEATHER_GLOVES;
import static net.runelite.api.ItemID.LONGBOW;
import static net.runelite.api.ItemID.MAGIC_LONGBOW;
import static net.runelite.api.ItemID.MAPLE_LONGBOW;
import static net.runelite.api.ItemID.MAPLE_SHORTBOW;
import static net.runelite.api.ItemID.MENAPHITE_PURPLE_HAT;
import static net.runelite.api.ItemID.MENAPHITE_PURPLE_ROBE;
import static net.runelite.api.ItemID.MENAPHITE_PURPLE_TOP;
import static net.runelite.api.ItemID.MIND_SHIELD;
import static net.runelite.api.ItemID.MITHRIL_CHAINBODY;
import static net.runelite.api.ItemID.MITHRIL_FULL_HELM;
import static net.runelite.api.ItemID.MITHRIL_MED_HELM;
import static net.runelite.api.ItemID.MITHRIL_PICKAXE;
import static net.runelite.api.ItemID.MITHRIL_PLATEBODY;
import static net.runelite.api.ItemID.MITHRIL_PLATELEGS;
import static net.runelite.api.ItemID.MITHRIL_PLATESKIRT;
import static net.runelite.api.ItemID.MITHRIL_SCIMITAR;
import static net.runelite.api.ItemID.MYSTIC_FIRE_STAFF;
import static net.runelite.api.ItemID.MYSTIC_GLOVES;
import static net.runelite.api.ItemID.MYSTIC_HAT;
import static net.runelite.api.ItemID.MYSTIC_ROBE_BOTTOM;
import static net.runelite.api.ItemID.MYSTIC_ROBE_BOTTOM_DARK;
import static net.runelite.api.ItemID.MYSTIC_ROBE_TOP;
import static net.runelite.api.ItemID.MYSTIC_ROBE_TOP_DARK;
import static net.runelite.api.ItemID.NEW_CRYSTAL_BOW_I;
import static net.runelite.api.ItemID.OAK_LONGBOW;
import static net.runelite.api.ItemID.OAK_SHORTBOW;
import static net.runelite.api.ItemID.OBSIDIAN_CAPE;
import static net.runelite.api.ItemID.ORANGE_BOATER;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE_3;
import static net.runelite.api.ItemID.PINK_BOATER;
import static net.runelite.api.ItemID.PINK_ROBE_TOP;
import static net.runelite.api.ItemID.PINK_SKIRT;
import static net.runelite.api.ItemID.PIRATE_BANDANA;
import static net.runelite.api.ItemID.PIRATE_BANDANA_7124;
import static net.runelite.api.ItemID.PIRATE_BANDANA_7130;
import static net.runelite.api.ItemID.PIRATE_BANDANA_7136;
import static net.runelite.api.ItemID.PROSELYTE_HAUBERK;
import static net.runelite.api.ItemID.PURPLE_BOATER;
import static net.runelite.api.ItemID.PURPLE_GLOVES;
import static net.runelite.api.ItemID.PURPLE_SLAYER_HELMET;
import static net.runelite.api.ItemID.PURPLE_SLAYER_HELMET_I;
import static net.runelite.api.ItemID.RED_BOATER;
import static net.runelite.api.ItemID.RED_DHIDE_CHAPS;
import static net.runelite.api.ItemID.RED_HEADBAND;
import static net.runelite.api.ItemID.RED_SLAYER_HELMET;
import static net.runelite.api.ItemID.RED_SLAYER_HELMET_I;
import static net.runelite.api.ItemID.RING_OF_DUELING1;
import static net.runelite.api.ItemID.RING_OF_DUELING2;
import static net.runelite.api.ItemID.RING_OF_DUELING3;
import static net.runelite.api.ItemID.RING_OF_DUELING4;
import static net.runelite.api.ItemID.RING_OF_DUELING5;
import static net.runelite.api.ItemID.RING_OF_DUELING6;
import static net.runelite.api.ItemID.RING_OF_DUELING7;
import static net.runelite.api.ItemID.RING_OF_DUELING8;
import static net.runelite.api.ItemID.RING_OF_FORGING;
import static net.runelite.api.ItemID.RING_OF_LIFE;
import static net.runelite.api.ItemID.RING_OF_WEALTH;
import static net.runelite.api.ItemID.RING_OF_WEALTH_1;
import static net.runelite.api.ItemID.RING_OF_WEALTH_2;
import static net.runelite.api.ItemID.RING_OF_WEALTH_3;
import static net.runelite.api.ItemID.RING_OF_WEALTH_4;
import static net.runelite.api.ItemID.RING_OF_WEALTH_5;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I1;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I2;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I3;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I4;
import static net.runelite.api.ItemID.RING_OF_WEALTH_I5;
import static net.runelite.api.ItemID.ROLLING_PIN;
import static net.runelite.api.ItemID.RUBY_AMULET;
import static net.runelite.api.ItemID.RUBY_RING;
import static net.runelite.api.ItemID.RUNE_AXE;
import static net.runelite.api.ItemID.RUNE_BOOTS;
import static net.runelite.api.ItemID.RUNE_CROSSBOW;
import static net.runelite.api.ItemID.RUNE_FULL_HELM;
import static net.runelite.api.ItemID.RUNE_HALBERD;
import static net.runelite.api.ItemID.RUNE_HELM_H1;
import static net.runelite.api.ItemID.RUNE_HELM_H5;
import static net.runelite.api.ItemID.RUNE_KITESHIELD;
import static net.runelite.api.ItemID.RUNE_LONGSWORD;
import static net.runelite.api.ItemID.RUNE_PICKAXE;
import static net.runelite.api.ItemID.RUNE_PLATEBODY;
import static net.runelite.api.ItemID.RUNE_PLATELEGS;
import static net.runelite.api.ItemID.RUNE_PLATESKIRT;
import static net.runelite.api.ItemID.RUNE_SHIELD_H1;
import static net.runelite.api.ItemID.RUNE_SHIELD_H2;
import static net.runelite.api.ItemID.RUNE_SHIELD_H3;
import static net.runelite.api.ItemID.RUNE_SHIELD_H4;
import static net.runelite.api.ItemID.RUNE_SHIELD_H5;
import static net.runelite.api.ItemID.RUNE_SPEAR;
import static net.runelite.api.ItemID.RUNE_WARHAMMER;
import static net.runelite.api.ItemID.SAPPHIRE_AMULET;
import static net.runelite.api.ItemID.SAPPHIRE_NECKLACE;
import static net.runelite.api.ItemID.SAPPHIRE_RING;
import static net.runelite.api.ItemID.SARADOMIN_CROZIER;
import static net.runelite.api.ItemID.SARADOMIN_MITRE;
import static net.runelite.api.ItemID.SARADOMIN_STOLE;
import static net.runelite.api.ItemID.SEERCULL;
import static net.runelite.api.ItemID.SHADOW_SWORD;
import static net.runelite.api.ItemID.SILVER_SICKLE;
import static net.runelite.api.ItemID.SLAYER_HELMET;
import static net.runelite.api.ItemID.SLAYER_HELMET_I;
import static net.runelite.api.ItemID.SLED_4084;
import static net.runelite.api.ItemID.SNAKESKIN_BOOTS;
import static net.runelite.api.ItemID.SNAKESKIN_CHAPS;
import static net.runelite.api.ItemID.SPINED_CHAPS;
import static net.runelite.api.ItemID.SPLITBARK_BODY;
import static net.runelite.api.ItemID.SPLITBARK_LEGS;
import static net.runelite.api.ItemID.SPOTTED_CAPE;
import static net.runelite.api.ItemID.SPOTTED_CAPE_10073;
import static net.runelite.api.ItemID.STAFF;
import static net.runelite.api.ItemID.STAFF_OF_AIR;
import static net.runelite.api.ItemID.STAFF_OF_WATER;
import static net.runelite.api.ItemID.STEEL_AXE;
import static net.runelite.api.ItemID.STEEL_FULL_HELM;
import static net.runelite.api.ItemID.STEEL_KITESHIELD;
import static net.runelite.api.ItemID.STEEL_LONGSWORD;
import static net.runelite.api.ItemID.STEEL_MACE;
import static net.runelite.api.ItemID.STEEL_MED_HELM;
import static net.runelite.api.ItemID.STEEL_PICKAXE;
import static net.runelite.api.ItemID.STEEL_PLATEBODY;
import static net.runelite.api.ItemID.STEEL_PLATESKIRT;
import static net.runelite.api.ItemID.STEEL_SQ_SHIELD;
import static net.runelite.api.ItemID.STUDDED_BODY;
import static net.runelite.api.ItemID.STUDDED_CHAPS;
import static net.runelite.api.ItemID.TEAM1_CAPE;
import static net.runelite.api.ItemID.TEAM50_CAPE;
import static net.runelite.api.ItemID.TIARA;
import static net.runelite.api.ItemID.TOKTZKETXIL;
import static net.runelite.api.ItemID.TOKTZXILUL;
import static net.runelite.api.ItemID.TORAGS_HAMMERS_0;
import static net.runelite.api.ItemID.TORAGS_HAMMERS_100;
import static net.runelite.api.ItemID.TORAGS_HELM_0;
import static net.runelite.api.ItemID.TORAGS_HELM_100;
import static net.runelite.api.ItemID.TORAGS_PLATEBODY_0;
import static net.runelite.api.ItemID.TORAGS_PLATEBODY_100;
import static net.runelite.api.ItemID.TORAGS_PLATELEGS_0;
import static net.runelite.api.ItemID.TORAGS_PLATELEGS_100;
import static net.runelite.api.ItemID.TURQUOISE_ROBE_BOTTOMS;
import static net.runelite.api.ItemID.TURQUOISE_SLAYER_HELMET;
import static net.runelite.api.ItemID.TURQUOISE_SLAYER_HELMET_I;
import static net.runelite.api.ItemID.UNHOLY_BOOK;
import static net.runelite.api.ItemID.VERACS_BRASSARD_0;
import static net.runelite.api.ItemID.VERACS_BRASSARD_100;
import static net.runelite.api.ItemID.VERACS_FLAIL_0;
import static net.runelite.api.ItemID.VERACS_FLAIL_100;
import static net.runelite.api.ItemID.VERACS_HELM_0;
import static net.runelite.api.ItemID.VERACS_HELM_100;
import static net.runelite.api.ItemID.VERACS_PLATESKIRT_0;
import static net.runelite.api.ItemID.VERACS_PLATESKIRT_100;
import static net.runelite.api.ItemID.WHITE_APRON;
import static net.runelite.api.ItemID.WHITE_BOATER;
import static net.runelite.api.ItemID.WHITE_HEADBAND;
import static net.runelite.api.ItemID.ZAMORAK_CROZIER;
import static net.runelite.api.ItemID.ZAMORAK_FULL_HELM;
import static net.runelite.api.ItemID.ZAMORAK_GODSWORD;
import static net.runelite.api.ItemID.ZAMORAK_MITRE;
import static net.runelite.api.ItemID.ZAMORAK_STOLE;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollPlugin.EMOTE_IMAGE;
import net.runelite.client.plugins.cluescrolls.clues.emote.AllRequirementsCollection;
import net.runelite.client.plugins.cluescrolls.clues.emote.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.emote.Emote;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.ANGRY;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.BECKON;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.BLOW_KISS;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.BOW;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.BULL_ROARER;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.CHEER;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.CLAP;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.CRY;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.DANCE;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.FLAP;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.GOBLIN_SALUTE;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.HEADBANG;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.JIG;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.JUMP_FOR_JOY;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.LAUGH;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.NO;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.PANIC;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.PUSH_UP;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.RASPBERRY;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.SALUTE;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.SHRUG;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.SLAP_HEAD;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.SPIN;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.STOMP;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.THINK;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.WAVE;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.YAWN;
import static net.runelite.client.plugins.cluescrolls.clues.emote.Emote.YES;
import net.runelite.client.plugins.cluescrolls.clues.emote.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.emote.RangeItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.emote.SingleItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.emote.SlotLimitationRequirement;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class EmoteClue extends ClueScroll implements TextClueScroll, LocationClueScroll
{
	private static final Set<EmoteClue> CLUES = ImmutableSet.of(
		new EmoteClue("It's coming home", new WorldPoint(2954, 2933, 0), BECKON, any("It's coming home", item(GUTHIX_STOLE), item(SARADOMIN_STOLE), item(ZAMORAK_STOLE), item(ARMADYL_STOLE), item(BANDOS_STOLE), item(ANCIENT_STOLE)), any("It's coming home", item(RUNE_SHIELD_H1), item(RUNE_SHIELD_H2), item(RUNE_SHIELD_H3), item(RUNE_SHIELD_H4), item(RUNE_SHIELD_H5))),
		new EmoteClue("It's coming home", new WorldPoint(2552, 3556, 0), CHEER, HEADBANG, item(STEEL_PLATEBODY), item(MAPLE_SHORTBOW), range("It's coming home", TEAM1_CAPE, TEAM50_CAPE)),
		new EmoteClue("It's coming home", new WorldPoint(3056, 3484, 1), BOW, any("It's coming home", item(HOLY_BOOK), item(BOOK_OF_BALANCE), item(UNHOLY_BOOK), item(BOOK_OF_LAW), item(BOOK_OF_WAR), item(BOOK_OF_DARKNESS))),
		new EmoteClue("It's coming home", new WorldPoint(2629, 5071, 0), CHEER, any("It's coming home", item(GUTHIX_MITRE), item(SARADOMIN_MITRE), item(ZAMORAK_MITRE), item(ANCIENT_MITRE), item(BANDOS_MITRE), item(ARMADYL_MITRE)), item(RUNE_CROSSBOW), item(CLIMBING_BOOTS)),
		new EmoteClue("It's coming home", new WorldPoint(3043, 4697, 3), CHEER, item(MYSTIC_ROBE_TOP), any("It's coming home", item(RUNE_SHIELD_H1), item(RUNE_SHIELD_H2), item(RUNE_SHIELD_H3), item(RUNE_SHIELD_H4), item(RUNE_SHIELD_H5))),
		new EmoteClue("It's coming home", new WorldPoint(2011, 4712, 0), DANCE, any("It's coming home", item(IBANS_STAFF), item(IBANS_STAFF_U)), item(MYSTIC_ROBE_TOP_DARK), item(MYSTIC_ROBE_BOTTOM_DARK)),
		new EmoteClue("It's coming home", new WorldPoint(2782, 3273, 0), DANCE, any("It's coming home", item(AMULET_OF_GLORY), item(AMULET_OF_GLORY1), item(AMULET_OF_GLORY2), item(AMULET_OF_GLORY3), item(AMULET_OF_GLORY4), item(AMULET_OF_GLORY5), item(AMULET_OF_GLORY6)), item(BARROWS_GLOVES), item(DRAGON_MED_HELM)),
		new EmoteClue("It's coming home", new WorldPoint(2205, 4838, 0), FLAP, any("It's coming home", item(RING_OF_WEALTH), item(RING_OF_WEALTH_1), item(RING_OF_WEALTH_2), item(RING_OF_WEALTH_3), item(RING_OF_WEALTH_4), item(RING_OF_WEALTH_5), item(RING_OF_WEALTH_I), item(RING_OF_WEALTH_I1), item(RING_OF_WEALTH_I2), item(RING_OF_WEALTH_I3), item(RING_OF_WEALTH_I4), item(RING_OF_WEALTH_I5)), item(DEATH_TIARA), item(CAPE_OF_LEGENDS)),
		new EmoteClue("It's coming home", new WorldPoint(2568, 3149, 0), HEADBANG, any("It's coming home", item(PIRATE_BANDANA), item(PIRATE_BANDANA_7124), item(PIRATE_BANDANA_7130), item(PIRATE_BANDANA_7136)), item(DRAGON_NECKLACE), item(MAGIC_LONGBOW)),
		new EmoteClue("It's coming home", new WorldPoint(3551, 9694, 0), JIG, any("It's coming home", all(range(AHRIMS_HOOD_100, AHRIMS_HOOD_0), range(AHRIMS_STAFF_100, AHRIMS_STAFF_0), range(AHRIMS_ROBETOP_100, AHRIMS_ROBETOP_0), range(AHRIMS_ROBESKIRT_100, AHRIMS_ROBESKIRT_0)), all(range(DHAROKS_HELM_100, DHAROKS_HELM_0), range(DHAROKS_GREATAXE_100, DHAROKS_GREATAXE_0), range(DHAROKS_PLATEBODY_100, DHAROKS_PLATEBODY_0), range(DHAROKS_PLATELEGS_100, DHAROKS_PLATELEGS_0)), all(range(GUTHANS_HELM_100, GUTHANS_HELM_0), range(GUTHANS_WARSPEAR_100, GUTHANS_WARSPEAR_0), range(GUTHANS_PLATEBODY_100, GUTHANS_PLATEBODY_0), range(GUTHANS_CHAINSKIRT_100, GUTHANS_CHAINSKIRT_0)), all(range(KARILS_COIF_100, KARILS_COIF_0), range(KARILS_CROSSBOW_100, KARILS_CROSSBOW_0), range(KARILS_LEATHERTOP_100, KARILS_LEATHERTOP_0), range(KARILS_LEATHERSKIRT_100, KARILS_LEATHERSKIRT_0)), all(range(TORAGS_HELM_100, TORAGS_HELM_0), range(TORAGS_HAMMERS_100, TORAGS_HAMMERS_0), range(TORAGS_PLATEBODY_100, TORAGS_PLATEBODY_0), range(TORAGS_PLATELEGS_100, TORAGS_PLATELEGS_0)), all(range(VERACS_HELM_100, VERACS_HELM_0), range(VERACS_FLAIL_100, VERACS_FLAIL_0), range(VERACS_BRASSARD_100, VERACS_BRASSARD_0), range(VERACS_PLATESKIRT_100, VERACS_PLATESKIRT_0)))),
		new EmoteClue("It's coming home", new WorldPoint(2477, 3047, 0), JIG, range("It's coming home", RUNE_HELM_H1, RUNE_HELM_H5), item(RUNE_SPEAR), item(RUNE_PLATELEGS)),
		new EmoteClue("It's coming home", new WorldPoint(2207, 4952, 0), CHEER, emptySlot("It's coming home", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING)),
		new EmoteClue("It's coming home", new WorldPoint(2676, 3169, 0), PANIC, emptySlot("It's coming home", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING)),
		new EmoteClue("It's coming home", new WorldPoint(3611, 3492, 0), PANIC, emptySlot("It's coming home", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING)),
		new EmoteClue("It's coming home", new WorldPoint(3230, 3478, 0), ANGRY, item(ZAMORAK_GODSWORD)),
		new EmoteClue("It's coming home", new WorldPoint(3088, 3254, 0), ANGRY, item(ABYSSAL_WHIP), item(CAPE_OF_LEGENDS), item(SPINED_CHAPS)),
		new EmoteClue("It's coming home", new WorldPoint(3370, 3425, 0), BECKON, BOW, item(GREEN_HAT), item(SNAKESKIN_BOOTS), item(IRON_PICKAXE)),
		new EmoteClue("It's coming home", new WorldPoint(2784, 3065, 0), BECKON, CLAP, item(GREEN_DHIDE_CHAPS), any("It's coming home", item(RING_OF_DUELING1), item(RING_OF_DUELING2), item(RING_OF_DUELING3), item(RING_OF_DUELING4), item(RING_OF_DUELING5), item(RING_OF_DUELING6), item(RING_OF_DUELING7), item(RING_OF_DUELING8)), item(MITHRIL_MED_HELM)),
		new EmoteClue("It's coming home", new WorldPoint(1545, 3594, 0), BECKON, ANGRY, item(ADAMANT_PLATELEGS), item(ADAMANT_PLATEBODY), item(ADAMANT_FULL_HELM)),
		new EmoteClue("It's coming home", new WorldPoint(2205, 3252, 0), BOW, item(NEW_CRYSTAL_BOW_I)),
		new EmoteClue("It's coming home", new WorldPoint(2729, 3349, 0), BOW, item(IRON_PLATELEGS), item(OAK_LONGBOW), item(EMERALD_AMULET)),
		new EmoteClue("It's coming home", new WorldPoint(2728, 3377, 0), BOW, item(CAPE_OF_LEGENDS), item(DRAGON_BATTLEAXE), item(AMULET_OF_GLORY)),
		new EmoteClue("It's coming home", new WorldPoint(3314, 3241, 0), BOW, item(IRON_CHAINBODY), item(LEATHER_CHAPS), item(COIF)),
		new EmoteClue("It's coming home", new WorldPoint(2511, 3641, 2), BOW, item(BLUE_DHIDE_BODY), item(BLUE_DHIDE_VAMB), emptySlot("It's coming home", AMULET, RING)),
		new EmoteClue("It's coming home", new WorldPoint(2851, 2954, 0), BLOW_KISS, item(MYSTIC_HAT), item(BONE_SPEAR), item(RUNE_PLATEBODY)),
		new EmoteClue("It's coming home", new WorldPoint(3069, 3861, 0), BLOW_KISS, item(BLACK_DHIDE_CHAPS), any("It's coming home", item(SPOTTED_CAPE), item(SPOTTED_CAPE_10073)), item(ROLLING_PIN)),
		new EmoteClue("It's coming home", new WorldPoint(2925, 5333, 0), BLOW_KISS, item(ZAMORAK_FULL_HELM), item(SHADOW_SWORD)),
		new EmoteClue("It's coming home", new WorldPoint(2925, 3484, 0), CHEER, item(BLUE_WIZARD_HAT), item(BRONZE_2H_SWORD), item(HAM_BOOTS)),
		new EmoteClue("It's coming home", new WorldPoint(3080, 3509, 0), CHEER, DANCE, item(BROWN_APRON), item(LEATHER_BOOTS), item(LEATHER_GLOVES)),
		new EmoteClue("It's coming home", new WorldPoint(2527, 3375, 0), CHEER, ANGRY, item(GREEN_DHIDE_BODY), item(GREEN_DHIDE_CHAPS), item(STEEL_SQ_SHIELD)),
		new EmoteClue("It's coming home", new WorldPoint(2852, 3349, 0), CHEER, item(BLACK_DHIDE_VAMB), item(BLACK_DHIDE_CHAPS), item(BLACK_DHIDE_BODY)),
		new EmoteClue("It's coming home", new WorldPoint(3047, 3237, 0), CHEER, item(COIF), item(STEEL_PLATESKIRT), item(SAPPHIRE_NECKLACE)),
		new EmoteClue("It's coming home", new WorldPoint(3361, 3339, 0), CLAP, item(WHITE_APRON), item(GREEN_BOOTS), item(LEATHER_GLOVES)),
		new EmoteClue("It's coming home", new WorldPoint(3113, 3196, 0), CLAP, item(IRON_MED_HELM), item(EMERALD_RING), item(WHITE_APRON)),
		new EmoteClue("It's coming home", new WorldPoint(2635, 3385, 3), CLAP, item(BLUE_ROBE_TOP), item(HAM_ROBE), item(TIARA)),
		new EmoteClue("It's coming home", new WorldPoint(2735, 3469, 0), CLAP, SPIN, item(ADAMANT_HALBERD), item(MYSTIC_ROBE_BOTTOM), item(DIAMOND_RING)),
		new EmoteClue("It's coming home", new WorldPoint(3191, 3960, 0), CLAP, item(FLARED_TROUSERS), emptySlot("It's coming home", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, GLOVES, BOOTS, RING)),
		new EmoteClue("It's coming home", new WorldPoint(2823, 3443, 0), CRY, BOW, item(BLUE_BOOTS), item(HARDLEATHER_BODY), item(SILVER_SICKLE)),
		new EmoteClue("It's coming home", new WorldPoint(2852, 3429, 0), CRY, LAUGH, item(ADAMANT_SQ_SHIELD), item(BONE_DAGGER), item(MITHRIL_PLATEBODY)),
		new EmoteClue("It's coming home", new WorldPoint(2473, 3420, 2), CRY, NO, item(STEEL_KITESHIELD), item(RING_OF_FORGING), item(GREEN_DHIDE_CHAPS)),
		new EmoteClue("It's coming home", new WorldPoint(2463, 5149, 0), CRY, any("It's coming home", item(FIRE_CAPE), item(FIRE_MAX_CAPE)), item(TOKTZXILUL)),
		new EmoteClue("It's coming home", new WorldPoint(3128, 3245, 0), CRY, JUMP_FOR_JOY, item(ADAMANT_SWORD), item(SAPPHIRE_AMULET), item(ADAMANT_PLATESKIRT)),
		new EmoteClue("It's coming home", new WorldPoint(3109, 3294, 0), DANCE, item(IRON_CHAINBODY), item(SAPPHIRE_RING), item(LONGBOW)),
		new EmoteClue("It's coming home", new WorldPoint(3045, 3376, 0), DANCE, item(STEEL_FULL_HELM), item(STEEL_PLATEBODY), item(IRON_PLATESKIRT)),
		new EmoteClue("It's coming home", new WorldPoint(3203, 3169, 0), DANCE, item(BRONZE_DAGGER), item(IRON_FULL_HELM), item(GOLD_RING)),
		new EmoteClue("It's coming home", new WorldPoint(3223, 9597, 0), DANCE, BLOW_KISS, item(STAFF_OF_AIR), item(BRONZE_FULL_HELM), item(AMULET_OF_POWER)),
		new EmoteClue("It's coming home", new WorldPoint(3294, 2781, 0), DANCE, item(RING_OF_LIFE), item(AMULET_OF_GLORY), item(ADAMANT_2H_SWORD)),
		new EmoteClue("It's coming home", new WorldPoint(3492, 3488, 0), DANCE, BOW, item(GREEN_ROBE_TOP), item(MITHRIL_PLATELEGS), item(IRON_2H_SWORD)),
		new EmoteClue("It's coming home", new WorldPoint(2271, 4680, 0), DANCE, item(BLACK_DHIDE_BODY), item(BLACK_DHIDE_VAMB), item(BLACK_DRAGON_MASK)),
		new EmoteClue("It's coming home", new WorldPoint(3165, 3467, 0), DANCE, item(PINK_SKIRT), item(PINK_ROBE_TOP), item(BODY_TIARA)),
		new EmoteClue("It's coming home", new WorldPoint(2956, 3505, 0), GOBLIN_SALUTE, item(BANDOS_PLATEBODY), item(BANDOS_CLOAK), item(BANDOS_GODSWORD)),
		new EmoteClue("It's coming home", new WorldPoint(3299, 3289, 0), HEADBANG, item(DESERT_SHIRT), item(LEATHER_GLOVES), item(LEATHER_BOOTS)),
		new EmoteClue("It's coming home", new WorldPoint(3362, 3340, 0), HEADBANG, item(MYSTIC_FIRE_STAFF), item(DIAMOND_BRACELET), item(RUNE_BOOTS)),
		new EmoteClue("It's coming home", new WorldPoint(3421, 3537, 2), HEADBANG, item(SEERCULL), range("It's coming home", COMBAT_BRACELET4, COMBAT_BRACELET), item(HELM_OF_NEITIZNOT)),
		new EmoteClue("It's coming home", new WorldPoint(2610, 3391, 0), JIG, item(EMERALD_RING), item(SAPPHIRE_AMULET), item(BRONZE_CHAINBODY)),
		new EmoteClue("It's coming home", new WorldPoint(3304, 3124, 0), JIG, BOW, item(BRUISE_BLUE_SNELM_3343), item(STAFF_OF_AIR), item(BRONZE_SQ_SHIELD)),
		new EmoteClue("It's coming home", new WorldPoint(3253, 3401, 0), JIG, item(AIR_TIARA), item(STAFF_OF_WATER)),
		new EmoteClue("It's coming home", new WorldPoint(2759, 3445, 0), JUMP_FOR_JOY, item(DESERT_SHIRT), item(GREEN_ROBE_BOTTOMS), item(STEEL_AXE)),
		new EmoteClue("It's coming home", new WorldPoint(2610, 3092, 0), JUMP_FOR_JOY, JIG, item(BROWN_APRON), item(ADAMANT_MED_HELM), item(SNAKESKIN_CHAPS)),
		new EmoteClue("It's coming home", new WorldPoint(2477, 5146, 0), JUMP_FOR_JOY, SHRUG, item(STEEL_LONGSWORD), item(BLUE_DHIDE_BODY), item(MYSTIC_GLOVES)),
		new EmoteClue("It's coming home", new WorldPoint(1768, 5366, 1), JUMP_FOR_JOY, item(GRANITE_SHIELD), item(SPLITBARK_BODY), range("It's coming home", RUNE_HELM_H1, RUNE_HELM_H5)),
		new EmoteClue("It's coming home", new WorldPoint(2375, 3850, 0), JUMP_FOR_JOY, item(RUNE_BOOTS), item(PROSELYTE_HAUBERK), item(DRAGONSTONE_RING)),
		new EmoteClue("It's coming home", new WorldPoint(2199, 3056, 0), JUMP_FOR_JOY, item(DRAGON_2H_SWORD), item(BANDOS_BOOTS), item(OBSIDIAN_CAPE)),
		new EmoteClue("It's coming home", new WorldPoint(2920, 9893, 0), LAUGH, item(SPLITBARK_LEGS), item(DRAGON_BOOTS), item(RUNE_LONGSWORD)),
		new EmoteClue("It's coming home", new WorldPoint(2812, 3681, 0), LAUGH, item(RUNE_FULL_HELM), item(BLUE_DHIDE_CHAPS), item(FIRE_BATTLESTAFF)),
		new EmoteClue("It's coming home", new WorldPoint(2741, 3536, 0), LAUGH, item(LEATHER_COWL), item(BLUE_WIZARD_ROBE), item(IRON_SCIMITAR)),
		new EmoteClue("It's coming home", new WorldPoint(2666, 3304, 0), LAUGH, any("It's coming home", range(CASTLE_WARS_BRACELET3, CASTLE_WARS_BRACELET1)), item(DRAGONSTONE_AMULET), item(RING_OF_FORGING)),
		new EmoteClue("It's coming home", new WorldPoint(3372, 3498, 0), PANIC, item(BRONZE_PLATELEGS), item(STEEL_PICKAXE), item(STEEL_MED_HELM)),
		new EmoteClue("It's coming home", new WorldPoint(3504, 3576, 0), PANIC, WAVE, item(MITHRIL_PLATESKIRT), item(MAPLE_LONGBOW), emptySlot("It's coming home", BOOTS)),
		new EmoteClue("It's coming home", new WorldPoint(3368, 3935, 0), PANIC, any("It's coming home", range(RED_HEADBAND, BROWN_HEADBAND), range(WHITE_HEADBAND, GREEN_HEADBAND)), any("It's coming home", item(ANCIENT_CROZIER), item(ARMADYL_CROZIER), item(BANDOS_CROZIER), range(SARADOMIN_CROZIER, ZAMORAK_CROZIER))),
		new EmoteClue("It's coming home", new WorldPoint(2847, 3499, 0), PANIC, item(MITHRIL_PLATELEGS), item(RING_OF_LIFE), item(RUNE_AXE)),
		new EmoteClue("It's coming home", new WorldPoint(3227, 3831, 0), PANIC, item(DRAGON_MED_HELM), item(TOKTZKETXIL), item(BRINE_SABRE), item(RUNE_PLATEBODY), item(AMULET_OF_GLORY)),
		new EmoteClue("It's coming home", new WorldPoint(2776, 3781, 0), PANIC, item(BLUE_DHIDE_VAMB), item(DRAGON_SPEAR), item(RUNE_PLATESKIRT), item(SLED_4084)),
		new EmoteClue("It's coming home", new WorldPoint(2843, 3543, 0), PUSH_UP, item(DRAGON_BATTLEAXE), item(DRAGON_DEFENDER), any("It's coming home", item(SLAYER_HELMET), item(BLACK_SLAYER_HELMET), item(GREEN_SLAYER_HELMET), item(PURPLE_SLAYER_HELMET), item(RED_SLAYER_HELMET), item(TURQUOISE_SLAYER_HELMET), item(SLAYER_HELMET_I), item(BLACK_SLAYER_HELMET_I), item(GREEN_SLAYER_HELMET_I), item(PURPLE_SLAYER_HELMET_I), item(RED_SLAYER_HELMET_I), item(TURQUOISE_SLAYER_HELMET_I))),
		new EmoteClue("It's coming home", new WorldPoint(2843, 3543, 0), RASPBERRY, item(DRAGON_BATTLEAXE), item(DRAGON_DEFENDER), any("It's coming home", item(SLAYER_HELMET), item(BLACK_SLAYER_HELMET), item(GREEN_SLAYER_HELMET), item(PURPLE_SLAYER_HELMET), item(RED_SLAYER_HELMET), item(TURQUOISE_SLAYER_HELMET), item(SLAYER_HELMET_I), item(BLACK_SLAYER_HELMET_I), item(GREEN_SLAYER_HELMET_I), item(PURPLE_SLAYER_HELMET_I), item(RED_SLAYER_HELMET_I), item(TURQUOISE_SLAYER_HELMET_I))),
		new EmoteClue("It's coming home", new WorldPoint(2607, 3282, 0), RASPBERRY, item(STUDDED_BODY), item(BRONZE_PLATELEGS), item(STAFF)),
		new EmoteClue("It's coming home", new WorldPoint(2757, 3401, 0), RASPBERRY, item(COIF), item(IRON_PLATEBODY), item(LEATHER_GLOVES)),
		new EmoteClue("It's coming home", new WorldPoint(2588, 3419, 0), RASPBERRY, item(ELEMENTAL_SHIELD), item(BLUE_DHIDE_CHAPS), item(RUNE_WARHAMMER)),
		new EmoteClue("It's coming home", new WorldPoint(2918, 3168, 0), SALUTE, item(DIAMOND_RING), item(AMULET_OF_POWER), emptySlot("It's coming home", BODY, LEGS)),
		new EmoteClue("It's coming home", new WorldPoint(2844, 3542, 0), SALUTE, item(BLACK_SALAMANDER), emptySlot("It's coming home", HEAD, CAPE, AMULET, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING)),
		new EmoteClue("It's coming home", new WorldPoint(1646, 3632, 0), SALUTE, item(RUNE_HALBERD), item(RUNE_PLATEBODY), item(AMULET_OF_STRENGTH)),
		new EmoteClue("It's coming home", new WorldPoint(2976, 3238, 0), SHRUG, item(GOLD_NECKLACE), item(GOLD_RING), item(BRONZE_SPEAR)),
		new EmoteClue("It's coming home", new WorldPoint(2808, 3440, 0), SHRUG, YAWN, item(MAPLE_LONGBOW), item(GREEN_DHIDE_CHAPS), item(IRON_MED_HELM)),
		new EmoteClue("It's coming home", new WorldPoint(3239, 3611, 0), SHRUG, item(RUNE_PLATELEGS), item(IRON_PLATEBODY), item(BLUE_DHIDE_VAMB)),
		new EmoteClue("It's coming home", new WorldPoint(1555, 3537, 0), SHRUG, item(MYSTIC_ROBE_BOTTOM), item(RUNE_KITESHIELD), range("It's coming home", BOBS_RED_SHIRT, BOBS_PURPLE_SHIRT)),
		new EmoteClue("It's coming home", new WorldPoint(1663, 10045, 0), SLAP_HEAD, item(ARCLIGHT), item(AMULET_OF_THE_DAMNED)),
		new EmoteClue("It's coming home", new WorldPoint(2981, 3276, 0), SPIN, item(GREEN_HAT), item(CREAM_ROBE_TOP), item(LEATHER_CHAPS)),
		new EmoteClue("It's coming home", new WorldPoint(3088, 3336, 0), SPIN, item(IRON_PLATEBODY), item(STUDDED_CHAPS), item(BRONZE_FULL_HELM)),
		new EmoteClue("It's coming home", new WorldPoint(1815, 3856, 0), SPIN, item(DRAGON_PICKAXE), item(HELM_OF_NEITIZNOT), item(RUNE_BOOTS)),
		new EmoteClue("It's coming home", new WorldPoint(3213, 3463, 0), SPIN, item(BLACK_AXE), item(COIF), item(RUBY_RING)),
		new EmoteClue("It's coming home", new WorldPoint(2530, 3290, 0), SPIN, item(DRAGON_SPEAR), item(RED_DHIDE_CHAPS)),
		new EmoteClue("It's coming home", new WorldPoint(3105, 3420, 0), SPIN, SALUTE, item(PURPLE_GLOVES), item(STEEL_KITESHIELD), item(MITHRIL_FULL_HELM)),
		new EmoteClue("It's coming home", new WorldPoint(3030, 4522, 0), STOMP, item(DRAGON_AXE)),
		new EmoteClue("It's coming home", new WorldPoint(3159, 3298, 0), THINK, item(BLUE_ROBE_TOP), item(TURQUOISE_ROBE_BOTTOMS), item(OAK_SHORTBOW)),
		new EmoteClue("It's coming home", new WorldPoint(2439, 3161, 0), THINK, SPIN, item(MITHRIL_CHAINBODY), item(GREEN_DHIDE_CHAPS), item(RUBY_AMULET)),
		new EmoteClue("It's coming home", new WorldPoint(3307, 3491, 0), WAVE, item(HARDLEATHER_BODY), item(LEATHER_CHAPS), item(BRONZE_AXE)),
		new EmoteClue("It's coming home", new WorldPoint(2945, 3335, 0), WAVE, item(MITHRIL_PICKAXE), item(BLACK_PLATEBODY), item(IRON_KITESHIELD)),
		new EmoteClue("It's coming home", new WorldPoint(2989, 3110, 0), WAVE, item(BLACK_CAPE), item(LEATHER_CHAPS), item(STEEL_MACE)),
		new EmoteClue("It's coming home", new WorldPoint(3560, 3385, 0), WAVE, item(DRAGON_SQ_SHIELD), item(SPLITBARK_BODY), any("It's coming home", item(RED_BOATER), item(ORANGE_BOATER), item(GREEN_BOATER), item(BLUE_BOATER), item(BLACK_BOATER), item(PINK_BOATER), item(PURPLE_BOATER), item(WHITE_BOATER))),
		new EmoteClue("It's coming home", new WorldPoint(1944, 4427, 0), YAWN, item(PHARAOHS_SCEPTRE_3), item(MENAPHITE_PURPLE_HAT), item(MENAPHITE_PURPLE_TOP), item(MENAPHITE_PURPLE_ROBE)),
		new EmoteClue("It's coming home", new WorldPoint(3209, 3492, 0), YAWN, item(GREEN_ROBE_TOP), item(HAM_ROBE), item(IRON_WARHAMMER)),
		new EmoteClue("It's coming home", new WorldPoint(3083, 3253, 0), YAWN, item(STUDDED_CHAPS), item(IRON_KITESHIELD), item(STEEL_LONGSWORD)),
		new EmoteClue("It's coming home", new WorldPoint(2440, 3092, 0), YAWN, SHRUG, item(RUBY_AMULET), item(MITHRIL_SCIMITAR), range("It's coming home", TEAM1_CAPE, TEAM50_CAPE)),
		new EmoteClue("It's coming home", new WorldPoint(3026, 3701, 0), YAWN, item(ADAMANT_SQ_SHIELD), item(BLUE_DHIDE_VAMB), item(RUNE_PICKAXE)),
		new EmoteClue("It's coming home", new WorldPoint(2590, 4452, 0), YAWN, item(LAVA_BATTLESTAFF), item(BLACK_DHIDE_VAMB), item(MIND_SHIELD)),
		new EmoteClue("It's coming home", new WorldPoint(1632, 3807, 0), YAWN, YES, item(BLUE_DHIDE_VAMB), item(ADAMANT_BOOTS), item(ADAMANT_DAGGER)),
		new EmoteClue("It's coming home", new WorldPoint(2932, 4712, 0), BULL_ROARER, item(DRAGON_PLATESKIRT), item(CLIMBING_BOOTS), item(DRAGON_CHAINBODY_3140))
	);

	private static SingleItemRequirement item(int itemId)
	{
		return new SingleItemRequirement(itemId);
	}

	private static RangeItemRequirement range(int startItemId, int endItemId)
	{
		return range(null, startItemId, endItemId);
	}

	private static RangeItemRequirement range(String name, int startItemId, int endItemId)
	{
		return new RangeItemRequirement(name, startItemId, endItemId);
	}

	private static AnyRequirementCollection any(String name, ItemRequirement... requirements)
	{
		return new AnyRequirementCollection(name, requirements);
	}

	private static AllRequirementsCollection all(ItemRequirement... requirements)
	{
		return new AllRequirementsCollection(requirements);
	}

	private static SlotLimitationRequirement emptySlot(String description, EquipmentInventorySlot... slots)
	{
		return new SlotLimitationRequirement(description, slots);
	}

	private String text;
	private WorldPoint location;
	private Emote firstEmote;
	private Emote secondEmote;
	private ItemRequirement[] itemRequirements;

	private EmoteClue(String text, WorldPoint location, Emote firstEmote, ItemRequirement... itemRequirements)
	{
		this(text, location, firstEmote, null, itemRequirements);
	}

	private EmoteClue(String text, WorldPoint location, Emote firstEmote, Emote secondEmote, ItemRequirement... itemRequirements)
	{
		this.text = text;
		this.location = location;
		this.firstEmote = firstEmote;
		this.secondEmote = secondEmote;
		this.itemRequirements = itemRequirements;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("It's coming home").build());
		panelComponent.getChildren().add(LineComponent.builder().left("It's coming home").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getFirstEmote().getName())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		if (getSecondEmote() != null)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left(getSecondEmote().getName())
				.leftColor(TITLED_CONTENT_COLOR)
				.build());
		}

		if (getItemRequirements() == null)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("It's coming home")
				.right("It's coming home")
				.build());
		}
		else
		{
			panelComponent.getChildren().add(LineComponent.builder().left("It's coming home").build());

			Item[] equipment = plugin.getEquippedItems();
			Item[] inventory = plugin.getInventoryItems();

			// If equipment is null, the player is wearing nothing
			if (equipment == null)
			{
				equipment = new Item[0];
			}

			// If inventory is null, the player has nothing in their inventory
			if (inventory == null)
			{
				inventory = new Item[0];
			}

			for (ItemRequirement requirement : getItemRequirements())
			{
				boolean equipmentFulfilled = requirement.fulfilledBy(equipment);
				boolean inventoryFulfilled = requirement.fulfilledBy(inventory);

				panelComponent.getChildren().add(LineComponent.builder()
					.left(requirement.getCollectiveName(plugin.getClient()))
					.leftColor(TITLED_CONTENT_COLOR)
					.right(equipmentFulfilled || inventoryFulfilled ? "It's coming home" : "It's coming home")
					.rightColor(equipmentFulfilled ? Color.GREEN : (inventoryFulfilled ? Color.ORANGE : Color.RED))
					.build());
			}
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation());

		if (localLocation == null)
		{
			return;
		}

		OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, EMOTE_IMAGE, Color.ORANGE);
	}

	public static EmoteClue forText(String text)
	{
		for (EmoteClue clue : CLUES)
		{
			if (clue.getText().equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return null;
	}
}
