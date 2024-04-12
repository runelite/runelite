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
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum HunterAction implements NamedSkillAction
{
	POLAR_KEBBIT("Polar Kebbit", 1, 30, ItemID.KEBBIT),
	CRIMSON_SWIFT("Crimson Swift", 1, 34, ItemID.CRIMSON_SWIFT),
	COMMON_KEBBIT("Common Kebbit", 3, 36, ItemID.KEBBIT_9954),
	GOLDEN_WARBLER("Golden Warbler", 5, 47, ItemID.GOLDEN_WARBLER),
	REGULAR_BIRD_HOUSE("Regular Bird House", 5, 280, ItemID.BIRD_HOUSE),
	FELDIP_WEASEL("Feldip Weasel", 7, 48, ItemID.KEBBIT_9955),
	COPPER_LONGTAIL("Copper Longtail", 9, 61, ItemID.COPPER_LONGTAIL),
	CERULEAN_TWITCH("Cerulean Twitch", 11, 64.5f, ItemID.CERULEAN_TWITCH),
	DESERT_DEVIL("Desert Devil", 13, 66, ItemID.KEBBIT_9956),
	OAK_BIRD_HOUSE("Oak Bird House", 14, 420, ItemID.OAK_BIRD_HOUSE),
	RUBY_HARVEST("Ruby Harvest", 15, 24, ItemID.BUTTERFLY),
	BABY_IMPLING("Baby Impling", 17, 18, ItemID.BABY_IMPLING_JAR),
	TROPICAL_WAGTAIL("Tropical Wagtail", 19, 95, ItemID.TROPICAL_WAGTAIL),
	MOSS_LIZARD("Moss Lizard", 20, 90, ItemID.RAW_MOSS_LIZARD),
	YOUNG_IMPLING("Young Impling", 22, 20, ItemID.YOUNG_IMPLING_JAR),
	WILD_KEBBIT("Wild Kebbit", 23, 128, ItemID.KEBBIT),
	WILLOW_BIRD_HOUSE("Willow Bird House", 24, 560, ItemID.WILLOW_BIRD_HOUSE),
	SAPPHIRE_GLACIALIS("Sapphire Glacialis", 25, 34, ItemID.BUTTERFLY_9971),
	FERRET("Ferret", 27, 115, ItemID.FERRET),
	WHITE_RABBIT("White Rabbit", 27, 144, ItemID.RABBIT),
	GOURMET_IMPLING("Gourmet Impling", 28, 22, ItemID.GOURMET_IMPLING_JAR),
	SWAMP_LIZARD("Swamp Lizard", 29, 152, ItemID.SWAMP_LIZARD),
	SPINED_LARUPIA("Spined Larupia", 31, 180, ItemID.LARUPIA_HAT),
	BARB_TAILED_KEBBIT("Barb-tailed Kebbit", 33, 168, ItemID.KEBBIT_9958),
	TEAK_BIRD_HOUSE("Teak Bird House", 34, 700, ItemID.TEAK_BIRD_HOUSE),
	SNOWY_KNIGHT("Snowy Knight", 35, 44, ItemID.BUTTERFLY_9972),
	EARTH_IMPLING("Earth Impling", 36, 25, ItemID.EARTH_IMPLING_JAR),
	PRICKLY_KEBBIT("Prickly Kebbit", 37, 204, ItemID.KEBBIT_9957),
	EMBERTAILED_JERBOA("Embertailed Jerboa", 39, 137, ItemID.EMBERTAILED_JERBOA),
	HORNED_GRAAHK("Horned Graahk", 41, 240, ItemID.GRAAHK_HEADDRESS),
	ESSENCE_IMPLING("Essence Impling", 42, 27, ItemID.ESSENCE_IMPLING_JAR),
	SPOTTED_KEBBIT("Spotted Kebbit", 43, 104, ItemID.KEBBIT_9960),
	MAPLE_BIRD_HOUSE("Maple Bird House", 44, 820, ItemID.MAPLE_BIRD_HOUSE),
	BLACK_WARLOCK("Black Warlock", 45, 54, ItemID.BUTTERFLY_9973),
	ORANGE_SALAMANDER("Orange Salamander", 47, 224, ItemID.ORANGE_SALAMANDER),
	RAZOR_BACKED_KEBBIT("Razor-backed Kebbit", 49, 348, ItemID.KEBBIT_9961),
	MAHOGANY_BIRD_HOUSE("Mahogany Bird House", 49, 960, ItemID.MAHOGANY_BIRD_HOUSE),
	ECLECTIC_IMPLING("Eclectic Impling", 50, 32, ItemID.ECLECTIC_IMPLING_JAR),
	SABRE_TOOTHED_KEBBIT("Sabre-toothed Kebbit", 51, 200, ItemID.KEBBIT_9959),
	CHINCHOMPA("Chinchompa", 53, 198.4f, ItemID.CHINCHOMPA),
	SABRE_TOOTHED_KYATT("Sabre-toothed Kyatt", 55, 300, ItemID.KYATT_HAT),
	DARK_KEBBIT("Dark Kebbit", 57, 132, ItemID.KEBBIT_9963),
	PYRE_FOX("Pyre Fox", 57, 222, ItemID.PYRE_FOX),
	NATURE_IMPLING("Nature Impling", 58, 34, ItemID.NATURE_IMPLING_JAR),
	RED_SALAMANDER("Red Salamander", 59, 272, ItemID.RED_SALAMANDER),
	YEW_BIRD_HOUSE("Yew Bird House", 59, 1020, ItemID.YEW_BIRD_HOUSE),
	MANIACAL_MONKEY("Maniacal Monkey", 60, 1000, ItemID.MONKEY_19556),
	CARNIVOROUS_CHINCHOMPA("Carnivorous Chinchompa", 63, 265, ItemID.RED_CHINCHOMPA),
	MAGPIE_IMPLING("Magpie Impling", 65, 44, ItemID.MAGPIE_IMPLING_JAR),
	SUNLIGHT_MOTH("Sunlight Moth", 65, 74, ItemID.SUNLIGHT_MOTH),
	MAGPIE_IMPLING_GIELINOR("Magpie Impling (Gielinor)", 65, 216, ItemID.MAGPIE_IMPLING_JAR),
	BLACK_SALAMANDER("Black Salamander", 67, 319.5f, ItemID.BLACK_SALAMANDER),
	DASHING_KEBBIT("Dashing Kebbit", 69, 156, ItemID.KEBBIT_9964),
	SUNLIGHT_ANTELOPE("Sunlight Antelope", 72, 380, ItemID.SUNLIGHT_ANTELOPE),
	BLACK_CHINCHOMPA("Black Chinchompa", 73, 315, ItemID.BLACK_CHINCHOMPA),
	NINJA_IMPLING("Ninja Impling", 74, 52, ItemID.NINJA_IMPLING_JAR),
	NINJA_IMPLING_GIELINOR("Ninja Impling (Gielinor)", 74, 240, ItemID.NINJA_IMPLING_JAR),
	MAGIC_BIRD_HOUSE("Magic Bird House", 74, 1140, ItemID.MAGIC_BIRD_HOUSE),
	MOONLIGHT_MOTH("Moonlight Moth", 75, 84, ItemID.MOONLIGHT_MOTH),
	TECU_SALAMANDER("Tecu Salamander", 79, 344, ItemID.TECU_SALAMANDER),
	CRYSTAL_IMPLING("Crystal Impling", 80, 280, ItemID.CRYSTAL_IMPLING_JAR),
	DRAGON_IMPLING("Dragon Impling", 83, 65, ItemID.DRAGON_IMPLING_JAR),
	DRAGON_IMPLING_GIELINOR("Dragon Impling (Gielinor)", 83, 300, ItemID.DRAGON_IMPLING_JAR),
	LUCKY_IMPLING("Lucky Impling", 89, 380, ItemID.LUCKY_IMPLING_JAR),
	REDWOOD_BIRD_HOUSE("Redwood Bird House", 89, 1200, ItemID.REDWOOD_BIRD_HOUSE),
	MOONLIGHT_ANTELOPE("Moonlight Antelope", 91, 450, ItemID.MOONLIGHT_ANTELOPE),
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
