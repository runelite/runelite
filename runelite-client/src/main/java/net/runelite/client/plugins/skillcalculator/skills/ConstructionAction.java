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
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum ConstructionAction implements NamedSkillAction
{
	PLANK("Plank", 1, 29, ItemID.WOODPLANK),
	DOCK_LEAF("Dock Leaf", 1, 31, ItemID.POH_PLANTSMALL2A),
	FERN_BIG_PLANT("Fern (big plant)", 1, 31, ItemID.POH_PLANTBIG1A),
	PLANT("Plant", 1, 31, ItemID.POH_PLANTSMALL1A),
	SHORT_PLANT("Short Plant", 1, 31, ItemID.POH_PLANTBIG2A),
	CRUDE_WOODEN_CHAIR("Crude Wooden Chair", 1, 58, ItemID.POH_ARMCHAIR_1),
	EXIT_PORTAL("Exit Portal", 1, 100, ItemID.POH_GARDEN_CENTREPIECE_1),
	BROWN_RUG("Brown Rug", 2, 30, ItemID.POH_RUG_1),
	TORN_CURTAINS("Torn Curtains", 2, 132, ItemID.POH_CURTAINS_1),
	CLAY_FIREPLACE("Clay Fireplace", 3, 30, ItemID.POH_FIREPLACE_1),
	WOODEN_BOOKCASE("Wooden Bookcase", 4, 115, ItemID.POH_BOOKCASE_1),
	CAT_BLANKET("Cat Blanket", 5, 15, ItemID.POH_CAT_BASKET_1),
	TREE("Tree", 5, 31, ItemID.POH_TREE_1),
	FIREPIT("Firepit", 5, 40, ItemID.POH_STOVE_1),
	DECORATIVE_ROCK("Decorative Rock", 5, 100, ItemID.POH_GARDEN_CENTREPIECE_2),
	BUSH("Bush", 6, 70, ItemID.POH_PLANTBIG1B),
	LARGE_LEAF_BUSH("Large Leaf Bush", 6, 70, ItemID.POH_PLANTBIG2B),
	SMALL_FERN("Small Fern", 6, 70, ItemID.POH_PLANTSMALL1B),
	THISTLE("Thistle", 6, 70, ItemID.POH_PLANTSMALL2B),
	WOODEN_SHELVES_1("Wooden Shelves 1", 6, 87, ItemID.POH_KITCHEN_SHELVES_1),
	BEER_BARREL("Beer Barrel", 7, 87, ItemID.POH_BARREL_1),
	PUMP_AND_DRAIN("Pump and Drain", 7, 100, ItemID.POH_SINK_1),
	WOODEN_CHAIR("Wooden Chair", 8, 87, ItemID.POH_ARMCHAIR_2),
	WOODEN_LARDER("Wooden Larder", 9, 228, ItemID.POH_LARDER_1),
	NICE_TREE("Nice Tree", 10, 44, ItemID.POH_TREE_2),
	POND("Pond", 10, 100, ItemID.POH_GARDEN_CENTREPIECE_3),
	WOODEN_BENCH("Wooden Bench", 10, 115, ItemID.POH_DINING_CHAIRS_1),
	WOOD_DINING_TABLE("Wood Dining Table", 10, 115, ItemID.POH_DINING_TABLE_1),
	FIREPIT_WITH_HOOK("Firepit with Hook", 11, 60, ItemID.POH_STOVE_2),
	WOOD_TABLE("Wood Table", 12, 87, ItemID.POH_DINING_TABLE_1),
	CIDER_BARREL("Cider Barrel", 12, 91, ItemID.POH_BARREL_2),
	FERN_SMALL_PLANT("Fern (small plant)", 12, 100, ItemID.POH_PLANTSMALL1C),
	HUGE_PLANT("Huge Plant", 12, 100, ItemID.POH_PLANTBIG2C),
	REEDS("Reeds", 12, 100, ItemID.POH_PLANTSMALL2C),
	TALL_PLANT("Tall Plant", 12, 100, ItemID.POH_PLANTBIG1C),
	WOODEN_SHELVES_2("Wooden Shelves 2", 12, 147, ItemID.POH_KITCHEN_SHELVES_2),
	RUG("Rug", 13, 60, ItemID.POH_RUG_2),
	ROCKING_CHAIR("Rocking Chair", 14, 87, ItemID.POH_ARMCHAIR_3),
	OAK_PLANK("Oak Plank", 15, 60, ItemID.PLANK_OAK),
	OAK_TREE("Oak Tree", 15, 70, ItemID.POH_TREE_3),
	IMP_STATUE("Imp Statue", 15, 150, ItemID.POH_GARDEN_CENTREPIECE_4),
	OAK_DECORATION("Oak Decoration", 16, 120, ItemID.POH_WALL_CREST_1),
	FIREPIT_WITH_POT("Firepit with Pot", 17, 80, ItemID.POH_STOVE_3),
	ASGARNIAN_ALE("Asgarnian Ale", 18, 184, ItemID.ASGARNIAN_ALE),
	CURTAINS("Curtains", 18, 225, ItemID.POH_CURTAINS_2),
	CAT_BASKET("Cat Basket", 19, 58, ItemID.POH_CAT_BASKET_2),
	OAK_CHAIR("Oak Chair", 19, 120, ItemID.POH_ARMCHAIR_4),
	SHOE_BOX("Shoe Box", 20, 58, ItemID.POH_WARDROBE_1),
	WOODEN_BED("Wooden Bed", 20, 117, ItemID.POH_BED_1),
	SHAVING_STAND("Shaving Stand", 21, 30, ItemID.POH_MIRROR_1),
	OAK_BENCH("Oak Bench", 22, 240, ItemID.POH_DINING_CHAIRS_2),
	OAK_DINING_TABLE("Oak Dining Table", 22, 240, ItemID.POH_DINING_TABLE_2),
	WOODEN_SHELVES_3("Wooden Shelves 3", 23, 147, ItemID.POH_KITCHEN_SHELVES_3),
	SMALL_OVEN("Small Oven", 24, 80, ItemID.POH_STOVE_4),
	OAK_CLOCK("Oak Clock", 25, 142, ItemID.POH_CLOCK_1),
	ROPE_BELL_PULL("Rope Bell-Pull", 26, 64, ItemID.POH_BELLPULL_1),
	OAK_ARMCHAIR("Oak Armchair", 26, 180, ItemID.POH_ARMCHAIR_5),
	GREENMANS_ALE("Greenman's Ale", 26, 184, ItemID.GREENMANS_ALE),
	OAK_DRAWERS("Oak Drawers", 27, 120, ItemID.POH_WARDROBE_2),
	PUMP_AND_TUB("Pump and Tub", 27, 200, ItemID.POH_SINK_2),
	DEADMAN_RUG("Deadman rug", 28, 283, ItemID.POH_RUG_DEADMAN),
	OAK_SHAVING_STAND("Oak Shaving Stand", 29, 61, ItemID.POH_MIRROR_2),
	LARGE_OVEN("Large Oven", 29, 100, ItemID.POH_STOVE_5),
	OAK_BOOKCASE("Oak Bookcase", 29, 180, ItemID.POH_BOOKCASE_2),
	WILLOW_TREE("Willow Tree", 30, 100, ItemID.POH_TREE_4),
	OAK_BED("Oak Bed", 30, 210, ItemID.POH_BED_2),
	LONG_BONE("Long Bone", 30, 4500, ItemID.DORGESH_CONSTRUCTION_BONE),
	CURVED_BONE("Curved Bone", 30, 6750, ItemID.DORGESH_CONSTRUCTION_BONE_CURVED),
	CARVED_OAK_BENCH("Carved Oak Bench", 31, 240, ItemID.POH_DINING_CHAIRS_3),
	CARVED_OAK_TABLE("Carved Oak Table", 31, 360, ItemID.POH_DINING_TABLE_3),
	OAK_KITCHEN_TABLE("Oak Kitchen Table", 32, 180, ItemID.POH_DINING_TABLE_4),
	BOXING_RING("Boxing Ring", 32, 420, ItemID.POH_COMBAT_RING_1),
	STONE_FIREPLACE("Stone Fireplace", 33, 40, ItemID.POH_FIREPLACE_2),
	CUSHIONED_BASKET("Cushioned Basket", 33, 58, ItemID.POH_CAT_BASKET_3),
	OAK_LARDER("Oak Larder", 33, 480, ItemID.POH_LARDER_2),
	GLOVE_RACK("Glove Rack", 34, 120, ItemID.POH_WEAPON_RACK_1),
	STEEL_RANGE("Steel Range", 34, 120, ItemID.POH_STOVE_6),
	OAK_SHELVES_1("Oak Shelves 1", 34, 240, ItemID.POH_KITCHEN_SHELVES_4),
	LARGE_OAK_BED("Large Oak Bed", 34, 330, ItemID.POH_BED_3),
	TEAK_PLANK("Teak Plank", 35, 90, ItemID.PLANK_TEAK),
	TEAK_ARMCHAIR("Teak Armchair", 35, 180, ItemID.POH_ARMCHAIR_6),
	TEAK_DECORATION("Teak Decoration", 36, 180, ItemID.POH_WALL_CREST_2),
	DRAGON_BITTER("Dragon Bitter", 36, 224, ItemID.DRAGON_BITTER),
	BELL_PULL("Bell-Pull", 37, 120, ItemID.POH_BELLPULL_2),
	OAK_DRESSER("Oak Dresser", 37, 121, ItemID.POH_MIRROR_3),
	TEAK_BENCH("Teak Bench", 38, 360, ItemID.POH_DINING_CHAIRS_5),
	TEAK_TABLE("Teak Table", 38, 360, ItemID.POH_DINING_TABLE_4),
	OAK_WARDROBE("Oak Wardrobe", 39, 180, ItemID.POH_WARDROBE_3),
	OAK_LECTERN("Oak Lectern", 40, 60, ItemID.POH_LECTERN_1),
	MAHOGANY_PLANK("Mahogany Plank", 40, 140, ItemID.PLANK_MAHOGANY),
	TEAK_BED("Teak Bed", 40, 300, ItemID.POH_BED_4),
	OPULENT_CURTAINS("Opulent Curtains", 40, 315, ItemID.POH_CURTAINS_3),
	MAHOGANY_BOOKCASE("Mahogany Bookcase", 40, 420, ItemID.POH_BOOKCASE_3),
	GLOBE("Globe", 41, 180, ItemID.POH_GLOBE_1),
	FENCING_RING("Fencing Ring", 41, 570, ItemID.POH_COMBAT_RING_2),
	FANCY_RANGE("Fancy Range", 42, 160, ItemID.POH_STOVE_7),
	CRYSTAL_BALL("Crystal Ball", 42, 280, ItemID.POH_CRYSTALBALL_1),
	ALCHEMICAL_CHART("Alchemical Chart", 43, 30, ItemID.POH_WALLCHART_1),
	TEAK_LARDER("Teak larder", 43, 750, ItemID.POH_LARDER_3),
	WOODEN_TELESCOPE("Wooden Telescope", 44, 121, ItemID.POH_TELESCOPE_1),
	WEAPONS_RACK("Weapons Rack", 44, 180, ItemID.POH_WEAPON_RACK_2),
	CARVED_TEAK_BENCH("Carved Teak Bench", 44, 360, ItemID.POH_DINING_CHAIRS_5),
	MAPLE_TREE("Maple Tree", 45, 122, ItemID.POH_TREE_5),
	OAK_SHELVES_2("Oak Shelves 2", 45, 240, ItemID.POH_KITCHEN_SHELVES_5),
	LARGE_TEAK_BED("Large Teak Bed", 45, 480, ItemID.POH_BED_5),
	CARVED_TEAK_TABLE("Carved Teak Table", 45, 600, ItemID.POH_DINING_TABLE_5),
	TEAK_DRESSER("Teak Dresser", 46, 181, ItemID.POH_MIRROR_4),
	DEMON_LECTERN("Demon Lectern", 47, 120, ItemID.POH_LECTERN_3),
	EAGLE_LECTERN("Eagle Lectern", 47, 120, ItemID.POH_LECTERN_2),
	SINK("Sink", 47, 300, ItemID.POH_SINK_3),
	MOUNTED_MYTHICAL_CAPE("Mounted Mythical Cape", 47, 370, ItemID.POH_TROPHY_MYTHICAL_CAPE),
	CHEFS_DELIGHT("Chef's Delight", 48, 224, ItemID.CHEFS_DELIGHT),
	TELEPORT_FOCUS("Teleport Focus", 50, 40, ItemID.POH_TELEPORT_CENTREPIECE_1),
	ORNAMENTAL_GLOBE("Ornamental Globe", 50, 270, ItemID.POH_GLOBE_2),
	TEAK_PORTAL("Teak Portal", 50, 270, ItemID.POH_PORTAL_FRAME_1),
	MAHOGANY_ARMCHAIR("Mahogany Armchair", 50, 280, ItemID.POH_ARMCHAIR_7),
	TEAK_DRAWERS("Teak Drawers", 51, 180, ItemID.POH_WARDROBE_4),
	COMBAT_RING("Combat Ring", 51, 630, ItemID.POH_COMBAT_RING_3),
	TEAK_KITCHEN_TABLE("Teak Kitchen Table", 52, 270, ItemID.POH_DINING_TABLE_4),
	MAHOGANY_BENCH("Mahogany Bench", 52, 560, ItemID.POH_DINING_CHAIRS_6),
	MAHOGANY_TABLE("Mahogany Table", 52, 840, ItemID.POH_DINING_TABLE_6),
	FOUR_POSTER_BED("4-Poster Bed", 53, 450, ItemID.POH_BED_6),
	EXTRA_WEAPONS_RACK("Extra Weapons Rack", 54, 440, ItemID.POH_WEAPON_RACK_3),
	ELEMENTAL_SPHERE("Elemental Sphere", 54, 580, ItemID.POH_CRYSTALBALL_2),
	TEAK_CLOCK("Teak Clock", 55, 202, ItemID.POH_CLOCK_2),
	FANCY_TEAK_DRESSER("Fancy Teak Dresser", 56, 182, ItemID.POH_MIRROR_5),
	TEAK_SHELVES_1("Teak Shelves 1", 56, 330, ItemID.POH_KITCHEN_SHELVES_6),
	GILDED_DECORATION("Gilded Decoration", 56, 1020, ItemID.POH_WALL_CREST_3),
	TEAK_DEMON_LECTERN("Teak Demon Lectern", 57, 180, ItemID.POH_LECTERN_5),
	TEAK_EAGLE_LECTERN("Teak Eagle Lectern", 57, 180, ItemID.POH_LECTERN_4),
	LIMESTONE_ATTACK_STONE("Limestone attack stone", 59, 200, ItemID.POH_ATTACK_STONE_2),
	LUNAR_GLOBE("Lunar Globe", 59, 570, ItemID.POH_GLOBE_3),
	YEW_TREE("Yew Tree", 60, 141, ItemID.POH_TREE_6),
	SPICE_RACK("Spice Rack", 60, 374, ItemID.POH_KITCHEN_RACK_1),
	POSH_BELL_PULL("Posh Bell-Pull", 60, 420, ItemID.POH_BELLPULL_3),
	GILDED_FOUR_POSTER_BED("Gilded 4-Poster Bed", 60, 1330, ItemID.POH_BED_7),
	GILDED_BENCH("Gilded Bench", 61, 1760, ItemID.POH_DINING_CHAIRS_7),
	ASTRONOMICAL_CHART("Astronomical Chart", 63, 45, ItemID.POH_WALLCHART_2),
	TEAK_WARDROBE("Teak Wardrobe", 63, 270, ItemID.POH_WARDROBE_5),
	MARBLE_FIREPLACE("Marble Fireplace", 63, 500, ItemID.POH_FIREPLACE_3),
	TEAK_TELESCOPE("Teak Telescope", 64, 181, ItemID.POH_TELESCOPE_2),
	MAHOGANY_DRESSER("Mahogany Dresser", 64, 281, ItemID.POH_MIRROR_6),
	OPULENT_RUG("Opulent Rug", 65, 360, ItemID.POH_RUG_3),
	MAHOGANY_PORTAL("Mahogany Portal", 65, 420, ItemID.POH_PORTAL_FRAME_2),
	GREATER_FOCUS("Greater Focus", 65, 500, ItemID.POH_TELEPORT_CENTREPIECE_2),
	TEAK_GARDEN_BENCH("Teak Garden Bench", 66, 540, ItemID.POH_SUPERIOR_GARDEN_BENCH_TEAK),
	CRYSTAL_OF_POWER("Crystal of Power", 66, 890, ItemID.POH_CRYSTALBALL_3),
	MAHOGANY_DEMON_LECTERN("Mahogany Demon Lectern", 67, 580, ItemID.POH_LECTERN_7),
	MAHOGANY_EAGLE_LECTERN("Mahogany Eagle Lectern", 67, 580, ItemID.POH_LECTERN_6),
	TEAK_SHELVES_2("Teak Shelves 2", 67, 930, ItemID.POH_KITCHEN_SHELVES_7),
	CELESTIAL_GLOBE("Celestial Globe", 68, 570, ItemID.POH_GLOBE_4),
	DUNGEON_ENTRANCE("Dungeon Entrance", 70, 500, ItemID.POH_GARDEN_CENTREPIECE_5),
	RANGING_PEDESTALS("Ranging Pedestals", 71, 720, ItemID.POH_COMBAT_RING_4),
	OPULENT_TABLE("Opulent Table", 72, 3100, ItemID.POH_DINING_TABLE_7),
	GILDED_DRESSER("Gilded Dresser", 74, 582, ItemID.POH_MIRROR_7),
	OAK_DOOR("Oak Door", 74, 600, ItemID.POH_DUNGEON_DOOR_OAK),
	MAGIC_TREE("Magic Tree", 75, 223, ItemID.POH_TREE_7),
	MAHOGANY_WARDROBE("Mahogany Wardrobe", 75, 420, ItemID.POH_WARDROBE_6),
	GNOME_BENCH("Gnome Bench", 77, 840, ItemID.POH_SUPERIOR_GARDEN_BENCH_MAHOGANY),
	ARMILLARY_GLOBE("Armillary Globe", 77, 960, ItemID.POH_GLOBE_1),
	MARBLE_PORTAL("Marble Portal", 80, 1500, ItemID.POH_PORTAL_FRAME_3),
	SCRYING_POOL("Scrying Pool", 80, 2000, ItemID.POH_TELEPORT_CENTREPIECE_3),
	BALANCE_BEAM("Balance Beam", 81, 1000, ItemID.POH_COMBAT_RING_5),
	INFERNAL_CHART("Infernal Chart", 83, 60, ItemID.POH_WALLCHART_3),
	MAHOGANY_TELESCOPE("Mahogany Telescope", 84, 281, ItemID.POH_TELESCOPE_3),
	GILDED_CLOCK("Gilded Clock", 85, 602, ItemID.POH_CLOCK_3),
	SMALL_ORRERY("Small Orrery", 86, 1320, ItemID.POH_GLOBE_6),
	GILDED_WARDROBE("Gilded Wardrobe", 87, 720, ItemID.POH_WARDROBE_7),
	LARGE_ORRERY("Large Orrery", 95, 1420, ItemID.POH_GLOBE_7),
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
