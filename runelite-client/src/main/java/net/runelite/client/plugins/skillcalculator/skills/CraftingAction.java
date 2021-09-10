/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@AllArgsConstructor
@Getter
public enum CraftingAction implements SkillAction
{
	BALL_OF_WOOL("Ball of wool", 1, 2.5f, ItemID.BALL_OF_WOOL),
	UNFIRED_POT("Unfired pot", 1, 6.3f, ItemID.UNFIRED_POT),
	POT("Pot", 1, 6.3f, ItemID.POT),
	LEATHER_GLOVES("Leather gloves", 1, 13.8f, ItemID.LEATHER_GLOVES),
	OPAL("Opal", 1, 15, ItemID.OPAL),
	OPAL_RING("Opal ring", 1, 10, ItemID.OPAL_RING),
	MOLTEN_GLASS("Molten glass", 1, 20, ItemID.MOLTEN_GLASS),
	BEER_GLASS("Beer glass", 1, 17.5f, ItemID.BEER_GLASS),
	EMPTY_CANDLE_LANTERN("Empty candle lantern", 4, 19, ItemID.EMPTY_CANDLE_LANTERN),
	GOLD_RING("Gold ring", 5, 15, ItemID.GOLD_RING),
	BIRD_HOUSE("Bird house", 5, 15, ItemID.BIRD_HOUSE),
	GOLD_NECKLACE("Gold necklace", 6, 20, ItemID.GOLD_NECKLACE),
	LEATHER_BOOTS("Leather boots", 7, 16.3f, ItemID.LEATHER_BOOTS),
	UNFIRED_PIE_DISH("Unfired pie dish", 7, 15, ItemID.UNFIRED_PIE_DISH),
	PIE_DISH("Pie dish", 7, 10, ItemID.PIE_DISH),
	GOLD_BRACELET("Gold bracelet", 7, 25, ItemID.GOLD_BRACELET),
	UNFIRED_BOWL("Unfired bowl", 8, 18, ItemID.UNFIRED_BOWL),
	BOWL("Bowl", 8, 15, ItemID.BOWL),
	GOLD_AMULET_U("Gold amulet (u)", 8, 30, ItemID.GOLD_AMULET_U),
	COWL("Cowl", 9, 18.5f, ItemID.LEATHER_COWL),
	CROSSBOW_STRING("Crossbow string", 10, 15, ItemID.CROSSBOW_STRING),
	BOW_STRING("Bow string", 10, 15, ItemID.BOW_STRING),
	LEATHER_VAMBRACES("Leather vambraces", 11, 22, ItemID.LEATHER_VAMBRACES),
	EMPTY_OIL_LAMP("Empty oil lamp", 12, 25, ItemID.EMPTY_OIL_LAMP),
	JADE("Jade", 13, 20, ItemID.JADE),
	JADE_RING("Jade ring", 13, 32, ItemID.JADE_RING),
	LEATHER_BODY("Leather body", 14, 25, ItemID.LEATHER_BODY),
	OAK_BIRD_HOUSE("Oak bird house", 15, 20, ItemID.OAK_BIRD_HOUSE),
	RED_TOPAZ("Red topaz", 16, 25, ItemID.RED_TOPAZ),
	TOPAZ_RING("Topaz ring", 16, 35, ItemID.TOPAZ_RING),
	HOLY_SYMBOL("Holy symbol", 16, 50, ItemID.HOLY_SYMBOL),
	OPAL_NECKLACE("Opal necklace", 16, 35, ItemID.OPAL_NECKLACE),
	UNHOLY_SYMBOL("Unholy symbol", 17, 50, ItemID.UNHOLY_SYMBOL),
	LEATHER_CHAPS("Leather chaps", 18, 27, ItemID.LEATHER_CHAPS),
	UNFIRED_PLANT_POT("Unfired plant pot", 19, 20, ItemID.UNFIRED_PLANT_POT),
	EMPTY_PLANT_POT("Empty plant pot", 19, 17.5f, ItemID.EMPTY_PLANT_POT),
	MAGIC_STRING("Magic string", 19, 30, ItemID.MAGIC_STRING),
	SAPPHIRE("Sapphire", 20, 50, ItemID.SAPPHIRE),
	SAPPHIRE_RING("Sapphire ring", 20, 40, ItemID.SAPPHIRE_RING),
	EMPTY_SACK("Empty sack", 21, 38, ItemID.EMPTY_SACK),
	SAPPHIRE_NECKLACE("Sapphire necklace", 22, 55, ItemID.SAPPHIRE_NECKLACE),
	OPAL_BRACELET("Opal bracelet", 22, 45, ItemID.OPAL_BRACELET),
	SAPPHIRE_BRACELET("Sapphire bracelet", 23, 60, ItemID.SAPPHIRE_BRACELET),
	TIARA("Tiara", 23, 52.5f, ItemID.TIARA),
	SAPPHIRE_AMULET_U("Sapphire amulet (u)", 24, 65, ItemID.SAPPHIRE_AMULET_U),
	UNFIRED_POT_LID("Unfired pot lid", 25, 20, ItemID.UNFIRED_POT_LID),
	POT_LID("Pot lid", 25, 20, ItemID.POT_LID),
	JADE_NECKLACE("Jade necklace", 25, 54, ItemID.JADE_NECKLACE),
	WILLOW_BIRD_HOUSE("Willow bird house", 25, 25, ItemID.WILLOW_BIRD_HOUSE),
	DRIFT_NET("Drift net", 26, 55, ItemID.SMALL_FISHING_NET_6209),
	EMERALD("Emerald", 27, 67.5f, ItemID.EMERALD),
	EMERALD_RING("Emerald ring", 27, 55, ItemID.EMERALD_RING),
	OPAL_AMULET_U("Opal amulet (u)", 27, 55, ItemID.OPAL_AMULET_U),
	HARDLEATHER_BODY("Hardleather body", 28, 35, ItemID.HARDLEATHER_BODY),
	EMERALD_NECKLACE("Emerald necklace", 29, 60, ItemID.EMERALD_NECKLACE),
	JADE_BRACELET("Jade bracelet", 29, 60, ItemID.JADE_BRACELET),
	EMERALD_BRACELET("Emerald bracelet", 30, 65, ItemID.EMERALD_BRACELET),
	ROPE("Rope", 30, 25, ItemID.ROPE),
	EMERALD_AMULET_U("Emerald amulet (u)", 31, 70, ItemID.EMERALD_AMULET_U),
	SPIKY_VAMBRACES("Spiky vambraces", 32, 6, ItemID.SPIKY_VAMBRACES),
	TOPAZ_NECKLACE("Topaz necklace", 32, 70, ItemID.TOPAZ_NECKLACE),
	VIAL("Vial", 33, 35, ItemID.VIAL),
	RUBY("Ruby", 34, 85, ItemID.RUBY),
	RUBY_RING("Ruby ring", 34, 70, ItemID.RUBY_RING),
	JADE_AMULET_U("Jade amulet (u)", 34, 70, ItemID.JADE_AMULET_U),
	BROODOO_SHIELD("Broodoo shield", 35, 100, ItemID.BROODOO_SHIELD),
	TEAK_BIRD_HOUSE("Teak bird house", 35, 30, ItemID.TEAK_BIRD_HOUSE),
	BASKET("Basket", 36, 56, ItemID.BASKET),
	COIF("Coif", 38, 37, ItemID.COIF),
	TOPAZ_BRACELET("Topaz bracelet", 38, 75, ItemID.TOPAZ_BRACELET),
	RUBY_NECKLACE("Ruby necklace", 40, 75, ItemID.RUBY_NECKLACE),
	HARD_LEATHER_SHIELD("Hard leather shield", 41, 70, ItemID.HARD_LEATHER_SHIELD),
	RUBY_BRACELET("Ruby bracelet", 42, 80, ItemID.RUBY_BRACELET),
	FISHBOWL("Fishbowl", 42, 42.5f, ItemID.FISHBOWL),
	DIAMOND("Diamond", 43, 107.5f, ItemID.DIAMOND),
	DIAMOND_RING("Diamond ring", 43, 85, ItemID.DIAMOND_RING),
	TOPAZ_AMULET_U("Topaz amulet (u)", 45, 80, ItemID.TOPAZ_AMULET_U),
	SNAKESKIN_BOOTS("Snakeskin boots", 45, 30, ItemID.SNAKESKIN_BOOTS),
	MAPLE_BIRD_HOUSE("Maple bird house", 45, 35, ItemID.MAPLE_BIRD_HOUSE),
	UNPOWERED_ORB("Unpowered orb", 46, 52.5f, ItemID.UNPOWERED_ORB),
	SNAKESKIN_VAMBRACES("Snakeskin vambraces", 47, 35, ItemID.SNAKESKIN_VAMBRACES),
	SNAKESKIN_BANDANA("Snakeskin bandana", 48, 45, ItemID.SNAKESKIN_BANDANA),
	LANTERN_LENS("Lantern lens", 49, 55, ItemID.LANTERN_LENS),
	RUBY_AMULET_U("Ruby amulet (u)", 50, 85, ItemID.RUBY_AMULET_U),
	MAHOGANY_BIRD_HOUSE("Mahogany bird house", 50, 40, ItemID.MAHOGANY_BIRD_HOUSE),
	SNAKESKIN_CHAPS("Snakeskin chaps", 51, 50, ItemID.SNAKESKIN_CHAPS),
	SNAKESKIN_BODY("Snakeskin body", 53, 55, ItemID.SNAKESKIN_BODY),
	WATER_BATTLESTAFF("Water battlestaff", 54, 100, ItemID.WATER_BATTLESTAFF),
	DRAGONSTONE("Dragonstone", 55, 137.5f, ItemID.DRAGONSTONE),
	DRAGONSTONE_RING("Dragonstone ring", 55, 100, ItemID.DRAGONSTONE_RING),
	DIAMOND_NECKLACE("Diamond necklace", 56, 90, ItemID.DIAMOND_NECKLACE),
	SNAKESKIN_SHIELD("Snakeskin shield", 56, 100, ItemID.SNAKESKIN_SHIELD),
	GREEN_DHIDE_VAMB("Green D'hide vamb", 57, 62, ItemID.GREEN_DHIDE_VAMBRACES),
	DIAMOND_BRACELET("Diamond bracelet", 58, 95, ItemID.DIAMOND_BRACELET),
	EARTH_BATTLESTAFF("Earth battlestaff", 58, 112.5f, ItemID.EARTH_BATTLESTAFF),
	GREEN_DHIDE_CHAPS("Green D'hide chaps", 60, 124, ItemID.GREEN_DHIDE_CHAPS),
	YEW_BIRD_HOUSE("Yew bird house", 60, 45, ItemID.YEW_BIRD_HOUSE),
	FIRE_BATTLESTAFF("Fire battlestaff", 62, 125, ItemID.FIRE_BATTLESTAFF),
	GREEN_DHIDE_SHIELD("Green D'hide shield", 62, 124, ItemID.GREEN_DHIDE_SHIELD),
	GREEN_DHIDE_BODY("Green D'hide body", 63, 186, ItemID.GREEN_DHIDE_BODY),
	AIR_BATTLESTAFF("Air battlestaff", 66, 137.5f, ItemID.AIR_BATTLESTAFF),
	BLUE_DHIDE_VAMB("Blue D'hide vamb", 66, 70, ItemID.BLUE_DHIDE_VAMBRACES),
	ONYX_RING("Onyx ring", 67, 115, ItemID.ONYX_RING),
	ONYX("Onyx", 67, 167.5f, ItemID.ONYX),
	BLUE_DHIDE_CHAPS("Blue D'hide chaps", 68, 140, ItemID.BLUE_DHIDE_CHAPS),
	BLUE_DHIDE_SHIELD("Blue D'hide shield", 69, 140, ItemID.BLUE_DHIDE_SHIELD),
	DIAMOND_AMULET_U("Diamond amulet (u)", 70, 100, ItemID.DIAMOND_AMULET_U),
	BLUE_DHIDE_BODY("Blue D'hide body", 71, 210, ItemID.BLUE_DHIDE_BODY),
	DRAGONSTONE_NECKLACE("Dragonstone necklace", 72, 105, ItemID.DRAGON_NECKLACE),
	RED_DHIDE_VAMB("Red D'hide vamb", 73, 78, ItemID.RED_DHIDE_VAMBRACES),
	DRAGONSTONE_BRACELET("Dragonstone bracelet", 74, 110, ItemID.DRAGONSTONE_BRACELET),
	RED_DHIDE_CHAPS("Red D'hide chaps", 75, 156, ItemID.RED_DHIDE_CHAPS),
	MAGIC_BIRD_HOUSE("Magic bird house", 75, 50, ItemID.MAGIC_BIRD_HOUSE),
	RED_DHIDE_SHIELD("Red D'hide shield", 76, 156, ItemID.RED_DHIDE_SHIELD),
	RED_DHIDE_BODY("Red D'hide body", 77, 234, ItemID.RED_DHIDE_BODY),
	BLACK_DHIDE_VAMB("Black D'hide vamb", 79, 86, ItemID.BLACK_DHIDE_VAMBRACES),
	DRAGONSTONE_AMULET_U("Dragonstone amulet (u)", 80, 150, ItemID.DRAGONSTONE_AMULET_U),
	BLACK_DHIDE_CHAPS("Black D'hide chaps", 82, 172, ItemID.BLACK_DHIDE_CHAPS),
	ONYX_NECKLACE("Onyx necklace", 82, 120, ItemID.ONYX_NECKLACE),
	AMETHYST_BOLT_TIPS("Amethyst bolt tips", 83, 4, ItemID.AMETHYST_BOLT_TIPS),
	BLACK_DHIDE_SHIELD("Black D'hide shield", 83, 172, ItemID.BLACK_DHIDE_SHIELD),
	BLACK_DHIDE_BODY("Black D'hide body", 84, 258, ItemID.BLACK_DHIDE_BODY),
	ONYX_BRACELET("Onyx bracelet", 84, 125, ItemID.ONYX_BRACELET),
	AMETHYST_ARROWTIPS("Amethyst arrowtips", 85, 4, ItemID.AMETHYST_ARROWTIPS),
	AMETHYST_JAVELIN_HEADS("Amethyst javelin heads", 87, 12, ItemID.AMETHYST_JAVELIN_HEADS),
	LIGHT_ORB("Light orb", 87, 70, ItemID.LIGHT_ORB),
	AMETHYST_DART_TIP("Amethyst dart tip", 89, 7.5f, ItemID.AMETHYST_DART_TIP),
	ZENYTE("Zenyte", 89, 200, ItemID.ZENYTE),
	ZENYTE_RING("Zenyte ring", 89, 150, ItemID.ZENYTE_RING),
	ONYX_AMULET_U("Onyx amulet (u)", 90, 165, ItemID.ONYX_AMULET_U),
	REDWOOD_BIRD_HOUSE("Redwood bird house", 90, 55, ItemID.REDWOOD_BIRD_HOUSE),
	ZENYTE_NECKLACE("Zenyte necklace", 92, 165, ItemID.ZENYTE_NECKLACE),
	ZENYTE_BRACELET("Zenyte bracelet", 95, 180, ItemID.ZENYTE_BRACELET),
	ZENYTE_AMULET_U("Zenyte amulet (u)", 98, 200, ItemID.ZENYTE_AMULET_U),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
}
