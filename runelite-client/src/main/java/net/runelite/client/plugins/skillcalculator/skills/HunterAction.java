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
public enum HunterAction implements NamedSkillAction
{
	POLAR_KEBBIT("Polar Kebbit", 1, 30, ItemID.HUNTGUIDE_POLAR_BEAST),
	CRIMSON_SWIFT("Crimson Swift", 1, 34, ItemID.HUNTGUIDE_JUNGLE_BIRD),
	COMMON_KEBBIT("Common Kebbit", 3, 36, ItemID.HUNTGUIDE_WOOD_BEAST),
	GOLDEN_WARBLER("Golden Warbler", 5, 47, ItemID.HUNTGUIDE_DESERT_BIRD),
	REGULAR_BIRD_HOUSE("Regular Bird House", 5, 280, ItemID.BIRDHOUSE_NORMAL),
	FELDIP_WEASEL("Feldip Weasel", 7, 48, ItemID.HUNTGUIDE_JUNGLE_BEAST),
	COPPER_LONGTAIL("Copper Longtail", 9, 61, ItemID.HUNTGUIDE_WOOD_BIRD),
	CERULEAN_TWITCH("Cerulean Twitch", 11, 64.5f, ItemID.HUNTGUIDE_POLAR_BIRD),
	DESERT_DEVIL("Desert Devil", 13, 66, ItemID.HUNTGUIDE_DESERT_BEAST),
	OAK_BIRD_HOUSE("Oak Bird House", 14, 420, ItemID.BIRDHOUSE_OAK),
	RUBY_HARVEST("Ruby Harvest", 15, 24, ItemID.HUNTGUIDE_RED_BUTTERFLY),
	BABY_IMPLING("Baby Impling", 17, 18, ItemID.II_CAPTURED_IMPLING_1),
	TROPICAL_WAGTAIL("Tropical Wagtail", 19, 95, ItemID.HUNTGUIDE_COLOURED_BIRD),
	MOSS_LIZARD("Moss Lizard", 20, 90, ItemID.RAW_LIZARD),
	YOUNG_IMPLING("Young Impling", 22, 20, ItemID.II_CAPTURED_IMPLING_2),
	WILD_KEBBIT("Wild Kebbit", 23, 128, ItemID.HUNTGUIDE_POLAR_BEAST),
	WILLOW_BIRD_HOUSE("Willow Bird House", 24, 560, ItemID.BIRDHOUSE_WILLOW),
	SAPPHIRE_GLACIALIS("Sapphire Glacialis", 25, 34, ItemID.HUNTGUIDE_BLUE_BUTTERFLY),
	FERRET("Ferret", 27, 115, ItemID.HUNTING_FERRET),
	WHITE_RABBIT("White Rabbit", 27, 144, ItemID.HUNTGUIDE_RABBIT),
	GOURMET_IMPLING("Gourmet Impling", 28, 22, ItemID.II_CAPTURED_IMPLING_3),
	SWAMP_LIZARD("Swamp Lizard", 29, 152, ItemID.GREEN_SALAMANDER),
	SPINED_LARUPIA("Spined Larupia", 31, 180, ItemID.HUNTING_HAT_JAGUAR),
	BARB_TAILED_KEBBIT("Barb-tailed Kebbit", 33, 168, ItemID.HUNTGUIDE_BARBTAILED_BEAST),
	TEAK_BIRD_HOUSE("Teak Bird House", 34, 700, ItemID.BIRDHOUSE_TEAK),
	SNOWY_KNIGHT("Snowy Knight", 35, 44, ItemID.HUNTGUIDE_WHITE_BUTTERFLY),
	EARTH_IMPLING("Earth Impling", 36, 25, ItemID.II_CAPTURED_IMPLING_4),
	PRICKLY_KEBBIT("Prickly Kebbit", 37, 204, ItemID.HUNTGUIDE_RAZOR_BEAST),
	EMBERTAILED_JERBOA("Embertailed Jerboa", 39, 137, ItemID.HUNTGUIDE_JERBOA),
	HORNED_GRAAHK("Horned Graahk", 41, 240, ItemID.HUNTING_HAT_LEOPARD),
	ESSENCE_IMPLING("Essence Impling", 42, 27, ItemID.II_CAPTURED_IMPLING_5),
	SPOTTED_KEBBIT("Spotted Kebbit", 43, 104, ItemID.HUNTGUIDE_SPEEDY_BEAST),
	MAPLE_BIRD_HOUSE("Maple Bird House", 44, 820, ItemID.BIRDHOUSE_MAPLE),
	BLACK_WARLOCK("Black Warlock", 45, 54, ItemID.HUNTGUIDE_BLACK_BUTTERFLY),
	ORANGE_SALAMANDER("Orange Salamander", 47, 224, ItemID.ORANGE_SALAMANDER),
	RAZOR_BACKED_KEBBIT("Razor-backed Kebbit", 49, 348, ItemID.HUNTGUIDE_RAZOR2_BEAST),
	MAHOGANY_BIRD_HOUSE("Mahogany Bird House", 49, 960, ItemID.BIRDHOUSE_MAHOGANY),
	ECLECTIC_IMPLING("Eclectic Impling", 50, 32, ItemID.II_CAPTURED_IMPLING_6),
	SABRE_TOOTHED_KEBBIT("Sabre-toothed Kebbit", 51, 200, ItemID.HUNTGUIDE_SABRE_BEAST),
	CHINCHOMPA("Chinchompa", 53, 198.4f, ItemID.HUNTGUIDE_CHINCHOMPA_CAPTURED),
	SABRE_TOOTHED_KYATT("Sabre-toothed Kyatt", 55, 300, ItemID.HUNTING_HAT_TIGER),
	DARK_KEBBIT("Dark Kebbit", 57, 132, ItemID.HUNTGUIDE_SILENT_BEAST),
	PYRE_FOX("Pyre Fox", 57, 222, ItemID.HUNTGUIDE_FENNECFOX),
	NATURE_IMPLING("Nature Impling", 58, 34, ItemID.II_CAPTURED_IMPLING_7),
	RED_SALAMANDER("Red Salamander", 59, 272, ItemID.RED_SALAMANDER),
	YEW_BIRD_HOUSE("Yew Bird House", 59, 1020, ItemID.BIRDHOUSE_YEW),
	MANIACAL_MONKEY("Maniacal Monkey", 60, 1000, ItemID.MM2_MONKEY),
	CARNIVOROUS_CHINCHOMPA("Carnivorous Chinchompa", 63, 265, ItemID.HUNTGUIDE_CHINCHOMPA_BIG_CAPTURED),
	MAGPIE_IMPLING("Magpie Impling", 65, 44, ItemID.II_CAPTURED_IMPLING_8),
	SUNLIGHT_MOTH("Sunlight Moth", 65, 74, ItemID.HUNTGUIDE_SUNLIGHT_MOTH),
	MAGPIE_IMPLING_GIELINOR("Magpie Impling (Gielinor)", 65, 216, ItemID.II_CAPTURED_IMPLING_8),
	BLACK_SALAMANDER("Black Salamander", 67, 319.5f, ItemID.BLACK_SALAMANDER),
	DASHING_KEBBIT("Dashing Kebbit", 69, 156, ItemID.HUNTGUIDE_SPEEDY2_BEAST),
	SUNLIGHT_ANTELOPE("Sunlight Antelope", 72, 380, ItemID.HUNTGUIDE_SUN_ANTLERS),
	BLACK_CHINCHOMPA("Black Chinchompa", 73, 315, ItemID.CHINCHOMPA_BLACK),
	NINJA_IMPLING("Ninja Impling", 74, 52, ItemID.II_CAPTURED_IMPLING_9),
	NINJA_IMPLING_GIELINOR("Ninja Impling (Gielinor)", 74, 240, ItemID.II_CAPTURED_IMPLING_9),
	MAGIC_BIRD_HOUSE("Magic Bird House", 74, 1140, ItemID.BIRDHOUSE_MAGIC),
	MOONLIGHT_MOTH("Moonlight Moth", 75, 84, ItemID.HUNTGUIDE_MOONLIGHT_MOTH),
	TECU_SALAMANDER("Tecu Salamander", 79, 344, ItemID.MOUNTAIN_SALAMANDER),
	CRYSTAL_IMPLING("Crystal Impling", 80, 280, ItemID.II_CAPTURED_IMPLING_12),
	DRAGON_IMPLING("Dragon Impling", 83, 65, ItemID.II_CAPTURED_IMPLING_10),
	DRAGON_IMPLING_GIELINOR("Dragon Impling (Gielinor)", 83, 300, ItemID.II_CAPTURED_IMPLING_10),
	LUCKY_IMPLING("Lucky Impling", 89, 380, ItemID.II_CAPTURED_IMPLING_11),
	REDWOOD_BIRD_HOUSE("Redwood Bird House", 89, 1200, ItemID.BIRDHOUSE_REDWOOD),
	MOONLIGHT_ANTELOPE("Moonlight Antelope", 91, 450, ItemID.HUNTGUIDE_MOON_ANTLERS),
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
