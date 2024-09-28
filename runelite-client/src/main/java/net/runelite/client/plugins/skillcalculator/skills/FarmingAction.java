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
import net.runelite.api.NullItemID;
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum FarmingAction implements NamedSkillAction
{
	POTATOES("Potatoes", 1, 8, ItemID.POTATO),
	WINTER_SQIRK("Winter Sq'irk", 1, 30, ItemID.WINTER_SQIRK),
	DOCK_LEAF("Dock Leaf", 1, 31, ItemID.DOCK_LEAF),
	FERN_BIG_PLANT("Fern (big plant)", 1, 31, ItemID.FERN_8186),
	PLANT("Plant", 1, 31, ItemID.PLANT),
	SHORT_PLANT("Short Plant", 1, 31, ItemID.SHORT_PLANT),
	SPRING_SQIRK("Spring Sq'irk", 1, 40, ItemID.SPRING_SQIRK),
	AUTUMN_SQIRK("Autumn Sq'irk", 1, 50, ItemID.AUTUMN_SQIRK),
	SUMMER_SQIRK("Summer Sq'irk", 1, 60, ItemID.SUMMER_SQIRK),
	BUSH("Bush", 1, 70, ItemID.BUSH),
	LARGE_LEAF_BUSH("Large Leaf Bush", 1, 70, ItemID.LARGELEAF_PLANT),
	SMALL_FERN("Small Fern", 1, 70, ItemID.SMALL_FERN),
	THISTLE("Thistle", 1, 70, ItemID.THISTLE),
	FERN_SMALL_PLANT("Fern (small plant)", 1, 100, ItemID.FERN),
	HUGE_PLANT("Huge Plant", 1, 100, ItemID.HUGE_PLANT),
	REEDS("Reeds", 1, 100, ItemID.REEDS),
	TALL_PLANT("Tall Plant", 1, 100, ItemID.TALL_PLANT),
	ONIONS("Onions", 5, 10, ItemID.ONION),
	CABBAGES("Cabbages", 7, 10, ItemID.CABBAGE),
	GUAM_LEAF("Guam Leaf", 9, 11, ItemID.GUAM_LEAF),
	TOMATOES("Tomatoes", 12, 12.5f, ItemID.TOMATO),
	MARRENTILL("Marrentill", 14, 13.5f, ItemID.MARRENTILL),
	OAK_TREE("Oak Tree", 15, 481.3f, ItemID.OAK_LOGS),
	TARROMIN("Tarromin", 19, 16, ItemID.TARROMIN),
	SWEETCORN("Sweetcorn", 20, 17, ItemID.SWEETCORN),
	GIANT_SEAWEED("Giant seaweed", 23, 21, ItemID.GIANT_SEAWEED),
	HARRALANDER("Harralander", 26, 21.5f, ItemID.HARRALANDER),
	LIMPWURT_PLANT("Limpwurt Plant", 26, 40, ItemID.LIMPWURT_ROOT),
	APPLE_TREE("Apple Tree", 27, 1221.5f, ItemID.COOKING_APPLE),
	GOUTWEED("Goutweed", 29, 105, ItemID.GOUTWEED),
	WILLOW_TREE("Willow Tree", 30, 1481.5f, ItemID.WILLOW_LOGS),
	STRAWBERRIES("Strawberries", 31, 26, ItemID.STRAWBERRY),
	RANARR_WEED("Ranarr Weed", 32, 27, ItemID.RANARR_WEED),
	BANANA_TREE("Banana Tree", 33, 1778.5f, ItemID.BANANA),
	TEAK_TREE("Teak Tree", 35, 7315, ItemID.TEAK_LOGS),
	TOADFLAX("Toadflax", 38, 34, ItemID.TOADFLAX),
	ORANGE_TREE("Orange Tree", 39, 2505.7f, ItemID.ORANGE),
	CURRY_TREE("Curry Tree", 42, 2946.9f, ItemID.CURRY_LEAF),
	IRIT_LEAF("Irit Leaf", 44, 43, ItemID.IRIT_LEAF),
	MAPLE_TREE("Maple Tree", 45, 3448.4f, ItemID.MAPLE_LOGS),
	WATERMELONS("Watermelons", 47, 49, ItemID.WATERMELON),
	AVANTOE("Avantoe", 50, 54.5f, ItemID.AVANTOE),
	PINEAPPLE_PLANT("Pineapple Plant", 51, 4662.7f, ItemID.PINEAPPLE),
	MAHOGANY_TREE("Mahogany Tree", 55, 15783, ItemID.MAHOGANY_LOGS),
	KWUARM("Kwuarm", 56, 69, ItemID.KWUARM),
	PAPAYA_TREE("Papaya Tree", 57, 6218.4f, ItemID.PAPAYA_FRUIT),
	WHITE_LILY("White lily", 58, 292, ItemID.WHITE_LILY),
	YEW_TREE("Yew Tree", 60, 7150.9f, ItemID.YEW_LOGS),
	SNAPE_GRASS("Snape grass", 61, 82, ItemID.SNAPE_GRASS),
	SNAPDRAGON("Snapdragon", 62, 87.5f, ItemID.SNAPDRAGON),
	HUASCA("Huasca", 65, 86.5f, ItemID.HUASCA),
	HESPORI("Hespori", 65, 12662, NullItemID.NULL_23044),
	CADANTINE("Cadantine", 67, 106.5f, ItemID.CADANTINE),
	PALM_TREE("Palm Tree", 68, 10260.6f, ItemID.COCONUT),
	CALQUAT_TREE("Calquat Tree", 72, 12225.5f, ItemID.CALQUAT_FRUIT),
	LANTADYME("Lantadyme", 73, 134.5f, ItemID.LANTADYME),
	CRYSTAL_TREE("Crystal Tree", 74, 13366, ItemID.CRYSTAL_SHARD),
	MAGIC_TREE("Magic Tree", 75, 13913.8f, ItemID.MAGIC_LOGS),
	DWARF_WEED("Dwarf Weed", 79, 170.5f, ItemID.DWARF_WEED),
	DRAGONFRUIT_TREE("Dragonfruit Tree", 81, 17895, ItemID.DRAGONFRUIT),
	SPIRIT_TREE("Spirit Tree", 83, 19501.3f, ItemID.SPIRIT_TREE),
	TORSTOL("Torstol", 85, 199.5f, ItemID.TORSTOL),
	CELASTRUS_TREE("Celastrus Tree", 85, 14334, ItemID.CELASTRUS_BARK),
	REDWOOD_TREE("Redwood Tree", 90, 22680, ItemID.REDWOOD_LOGS),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;

	@Override
	public boolean isMembers(final ItemManager itemManager)
	{
		return true;
	}
}
