/*
 * Copyright (c) 2020, melky <https://github.com/melkypie>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.worldmap;

import com.google.common.base.Joiner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
enum HunterAreaLocation
{
	ALDARIN_NORTH(new WorldPoint(1357, 2977, 0), HunterCreature.COPPER_LONGTAIL),
	ALDARIN_WEST(new WorldPoint(1342, 2934, 0), HunterCreature.RUBY_HARVEST),
	AUBURNVALE_NORTH(new WorldPoint(1387, 3392, 0), HunterCreature.COMMON_KEBBIT),
	AUBURNVALE_WEST(new WorldPoint(1349, 3346, 0), HunterCreature.COPPER_LONGTAIL),
	AVIUM_SAVANNAH(new WorldPoint(1616, 2999, 0), HunterCreature.PYRE_FOX),
	AVIUM_SAVANNAH_EAST(new WorldPoint(1745, 3008, 0), HunterCreature.SUNLIGHT_ANTELOPE),
	BONEYARD_HUNTER_AREA(new WorldPoint(3294, 3673, 0), HunterCreature.BLACK_SALAMANDER),
	CANIFIS_HUNTER_AREA1(new WorldPoint(3553, 3438, 0), HunterCreature.SWAMP_LIZARD),
	CANIFIS_HUNTER_AREA2(new WorldPoint(3535, 3445, 0), HunterCreature.SWAMP_LIZARD),
	FALCONRY(new WorldPoint(2379, 3599, 0), HunterCreature.SPOTTED_KEBBIT, HunterCreature.DARK_KEBBIT,
		HunterCreature.DASHING_KEBBIT),
	FELDIP_HUNTER_AREA(new WorldPoint(2557, 2912, 0), HunterCreature.CRIMSON_SWIFT, HunterCreature.FELDIP_WEASEL,
		HunterCreature.TROPICAL_WAGTAIL, HunterCreature.SPINED_LARUPIA, HunterCreature.BARB_TAILED_KEBBIT,
		HunterCreature.BLACK_WARLOCK, HunterCreature.CARNIVOROUS_CHINCHOMPA),
	FOSSIL_ISLAND1(new WorldPoint(3693, 3800, 0), HunterCreature.HERBIBOAR),
	FOSSIL_ISLAND2(new WorldPoint(3701, 3809, 0), HunterCreature.HERBIBOAR),
	FOSSIL_ISLAND3(new WorldPoint(3703, 3829, 0), HunterCreature.HERBIBOAR),
	FOSSIL_ISLAND4(new WorldPoint(3749, 3850, 0), HunterCreature.HERBIBOAR),
	FOSSIL_ISLAND5(new WorldPoint(3684, 3870, 0), HunterCreature.HERBIBOAR),
	FOSSIL_ISLAND_UNDERWATER(new WorldPoint(3743, 10295, 0), HunterCreature.FISH_SHOAL),
	GWENITH_HUNTER_AREA_OUTSIDE(new WorldPoint(2269, 3408, 0), HunterCreature.CARNIVOROUS_CHINCHOMPA),
	GWENITH_HUNTER_AREA_INSIDE(new WorldPoint(3293, 6160, 0), HunterCreature.CARNIVOROUS_CHINCHOMPA),
	ISLE_OF_SOULS_NORTH(new WorldPoint(2207, 2964, 0), HunterCreature.COPPER_LONGTAIL),
	ISLE_OF_SOULS_NORTH_WEST(new WorldPoint(2127, 2950, 0), HunterCreature.CHINCHOMPA),
	ISLE_OF_SOULS_SOUTH_WEST(new WorldPoint(2158, 2822, 0), HunterCreature.CRIMSON_SWIFT),
	HUNTER_GUILD_CAVERNS(new WorldPoint(1559, 9420, 0), HunterCreature.MOONLIGHT_ANTELOPE),
	HUNTER_GUILD_NORTH(new WorldPoint(1556, 3091, 0), HunterCreature.SUNLIGHT_MOTH),
	HUNTER_GUILD_SOUTHEAST(new WorldPoint(1575, 3020, 0), HunterCreature.SUNLIGHT_MOTH),
	HUNTER_GUILD_WEST(new WorldPoint(1515, 3047, 0), HunterCreature.EMBERTAILED_JERBOA),
	KARAMJA_HUNTER_AREA(new WorldPoint(2786, 3001, 0), HunterCreature.HORNED_GRAAHK),
	KEBOS_SWAMP(new WorldPoint(1184, 3595, 0), HunterCreature.CRIMSON_SWIFT),
	KOUREND_WOODLAND_CENTER(new WorldPoint(1512, 3478, 0), HunterCreature.RUBY_HARVEST),
	KOUREND_WOODLAND_NORTH_WEST(new WorldPoint(1481, 3504, 0), HunterCreature.CHINCHOMPA),
	KOUREND_WOODLAND_SOUTH(new WorldPoint(1556, 3436, 0), HunterCreature.COPPER_LONGTAIL),
	LOCUS_OASIS(new WorldPoint(1671, 3001, 0), HunterCreature.EMBERTAILED_JERBOA),
	LAKE_MOLCH(new WorldPoint(1363, 3632, 0), HunterCreature.BLUEGILL, HunterCreature.COMMON_TENCH,
		HunterCreature.MOTTLED_EEL, HunterCreature.GREATER_SIREN),
	MONS_GRATIA(new WorldPoint(1443, 3235, 0), HunterCreature.CERULEAN_TWITCH, HunterCreature.SNOWY_KNIGHT,
		HunterCreature.SAPPHIRE_GLACIALIS),
	NECROPOLIS(new WorldPoint(3285, 2739, 0), HunterCreature.ORANGE_SALAMANDER),
	OURANIA_HUNTER_AREA_EAST(new WorldPoint(2447, 3219, 0), HunterCreature.RED_SALAMANDER),
	OURANIA_HUNTER_AREA_SOUTH(new WorldPoint(2475, 3240, 0), HunterCreature.RED_SALAMANDER),
	PISCATORIS_HUNTER_AREA(new WorldPoint(2335, 3584, 0), HunterCreature.COMMON_KEBBIT, HunterCreature.COPPER_LONGTAIL,
		HunterCreature.RUBY_HARVEST, HunterCreature.WILD_KEBBIT, HunterCreature.FERRET, HunterCreature.WHITE_RABBIT,
		HunterCreature.PRICKLY_KEBBIT, HunterCreature.RAZOR_BACKED_KEBBIT, HunterCreature.CHINCHOMPA),
	PORT_PISCARILIUS_BEACH(new WorldPoint(1840, 3802, 0), HunterCreature.SANDWORMS),
	RALOS_RISE(new WorldPoint(1475, 3096, 0), HunterCreature.TECU_SALAMANDER),
	RELLEKA_HUNTER_AREA(new WorldPoint(2719, 3780, 0), HunterCreature.POLAR_KEBBIT, HunterCreature.CERULEAN_TWITCH,
		HunterCreature.SAPPHIRE_GLACIALIS, HunterCreature.SNOWY_KNIGHT,
		HunterCreature.SABRE_TOOTHED_KEBBIT, HunterCreature.SABRE_TOOTHED_KYATT),
	SLEPE_NORTH(new WorldPoint(3677, 3405, 0), HunterCreature.SWAMP_LIZARD),
	TLATI_RAINFOREST_EAST(new WorldPoint(1372, 3135, 0), HunterCreature.CRIMSON_SWIFT),
	TLATI_RAINFOREST_NORTH(new WorldPoint(1315, 3169, 0), HunterCreature.CARNIVOROUS_CHINCHOMPA),
	TLATI_RAINFOREST_CENTER(new WorldPoint(1269, 3102, 0), HunterCreature.TROPICAL_WAGTAIL),
	TLATI_RAINFOREST_SOUTH(new WorldPoint(1282, 3021, 0), HunterCreature.BLACK_WARLOCK),
	UZER_HUNTER_AREA(new WorldPoint(3401, 3104, 0), HunterCreature.GOLDEN_WARBLER, HunterCreature.DESERT_DEVIL,
		HunterCreature.ORANGE_SALAMANDER),
	WILDERNESS(new WorldPoint(3142, 3771, 0), HunterCreature.BLACK_CHINCHOMPA),
	;

	private final WorldPoint location;
	private final String tooltip;

	HunterAreaLocation(WorldPoint location, HunterCreature... creatures)
	{
		this.location = location;
		this.tooltip = Joiner.on("<br>").join(creatures);
	}

	@AllArgsConstructor
	private enum HunterCreature
	{
		BARB_TAILED_KEBBIT("Barb-tailed kebbit", 33),
		BLACK_CHINCHOMPA("Black chinchompa", 73),
		BLACK_SALAMANDER("Black salamander", 67),
		BLACK_WARLOCK("Black warlock", 45),
		BLUEGILL("Bluegill", 35),
		CARNIVOROUS_CHINCHOMPA("Carnivorous chinchompa", 63),
		CERULEAN_TWITCH("Cerulean twitch", 11),
		CHINCHOMPA("Chinchompa", 53),
		COMMON_KEBBIT("Common kebbit", 3),
		COMMON_TENCH("Common tench", 51),
		COPPER_LONGTAIL("Copper longtail", 9),
		CRIMSON_SWIFT("Crimson swift", 1),
		DARK_KEBBIT("Dark kebbit", 57),
		DASHING_KEBBIT("Dashing kebbit", 69),
		DESERT_DEVIL("Desert devil", 13),
		EMBERTAILED_JERBOA("Embertailed Jerboa", 39),
		FELDIP_WEASEL("Feldip Weasel", 7),
		FERRET("Ferret", 27),
		FISH_SHOAL("Fish shoal", 44),
		GOLDEN_WARBLER("Golden warbler", 5),
		GREATER_SIREN("Greater siren", 87),
		HERBIBOAR("Herbiboar", 80),
		HORNED_GRAAHK("Horned graahk", 41),
		// IMP and MANIACAL_MONKEY do not have a specific hunter area
		MOONLIGHT_ANTELOPE("Moonlight Antelope", 91),
		MOTTLED_EEL("Mottled eel", 68),
		ORANGE_SALAMANDER("Orange salamander", 47),
		POLAR_KEBBIT("Polar kebbit", 1),
		PRICKLY_KEBBIT("Prickly kebbit", 37),
		PYRE_FOX("Pyre Fox", 57),
		RAZOR_BACKED_KEBBIT("Razor-backed kebbit", 49),
		RED_SALAMANDER("Red salamander", 59),
		RUBY_HARVEST("Ruby harvest", 15),
		SABRE_TOOTHED_KEBBIT("Sabre-toothed kebbit", 51),
		SABRE_TOOTHED_KYATT("Sabre-toothed kyatt", 55),
		SANDWORMS("Sandworms", 15),
		SAPPHIRE_GLACIALIS("Sapphire glacialis", 25),
		SNOWY_KNIGHT("Snowy knight", 35),
		SPINED_LARUPIA("Spined larupia", 31),
		SPOTTED_KEBBIT("Spotted kebbit", 43),
		SUNLIGHT_ANTELOPE("Sunlight Antelope", 72),
		SUNLIGHT_MOTH("Sunlight Moth", 65),
		SWAMP_LIZARD("Swamp lizard", 29),
		TECU_SALAMANDER("Tecu Salamander", 79),
		TROPICAL_WAGTAIL("Tropical wagtail", 19),
		WHITE_RABBIT("White rabbit", 27),
		WILD_KEBBIT("Wild kebbit", 23),
		;

		private String name;
		private int level;

		@Override
		public String toString()
		{
			return name + " (" + level + ")";
		}
	}
}
