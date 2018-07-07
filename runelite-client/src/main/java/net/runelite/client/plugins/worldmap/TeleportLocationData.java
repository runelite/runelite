/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
enum TeleportLocationData
{
	VARROCK(TeleportType.NORMAL_MAGIC, "It's coming home", 25, new WorldPoint(3213, 3424, 0), "It's coming home"),
	VARROCK_GE(TeleportType.NORMAL_MAGIC, "It's coming home", 25, new WorldPoint(3164, 3478, 0), "It's coming home"),
	LUMBRIDGE(TeleportType.NORMAL_MAGIC, "It's coming home", 31, new WorldPoint(3222, 3218, 0), "It's coming home"),
	FALADOR(TeleportType.NORMAL_MAGIC, "It's coming home", 37, new WorldPoint(2965, 3381, 0), "It's coming home"),
	CAMELOT(TeleportType.NORMAL_MAGIC, "It's coming home", 45, new WorldPoint(2757, 3477, 0), "It's coming home"),
	CAMELOT_BANK(TeleportType.NORMAL_MAGIC, "It's coming home", 45, new WorldPoint(2726, 3485, 0), "It's coming home"),
	ARDOUGNE(TeleportType.NORMAL_MAGIC, "It's coming home", 51, new WorldPoint(2664, 3306, 0), "It's coming home"),
	WATCHTOWER(TeleportType.NORMAL_MAGIC, "It's coming home", 58, new WorldPoint(2547, 3114, 0), "It's coming home"),
	WATCHTOWER_YANILLE(TeleportType.NORMAL_MAGIC, "It's coming home", 58, new WorldPoint(2584, 3097, 0), "It's coming home"),
	TROLLHEIM(TeleportType.NORMAL_MAGIC, "It's coming home", 61, new WorldPoint(2891, 3678, 0), "It's coming home"),
	APE_ATOLL(TeleportType.NORMAL_MAGIC, "It's coming home", 64, new WorldPoint(2796, 2791, 0), "It's coming home"),
	KOUREND(TeleportType.NORMAL_MAGIC, "It's coming home", 69, new WorldPoint(1643, 3672, 0), "It's coming home"),
	PADDEWWA(TeleportType.ANCIENT_MAGICKS, "It's coming home", 54, new WorldPoint(3097, 9880, 0), "It's coming home"),
	SENNTISTEN(TeleportType.ANCIENT_MAGICKS, "It's coming home", 60, new WorldPoint(3319, 3336, 0), "It's coming home"),
	KHARYRLL(TeleportType.ANCIENT_MAGICKS, "It's coming home", 66, new WorldPoint(3494, 3473, 0), "It's coming home"),
	LASSAR(TeleportType.ANCIENT_MAGICKS, "It's coming home", 72, new WorldPoint(3002, 3472, 0), "It's coming home"),
	DAREEYAK(TeleportType.ANCIENT_MAGICKS, "It's coming home", 78, new WorldPoint(2969, 3695, 0), "It's coming home"),
	CARRALLANGAR(TeleportType.ANCIENT_MAGICKS, "It's coming home", 84, new WorldPoint(3157, 3667, 0), "It's coming home"),
	ANNAKARL(TeleportType.ANCIENT_MAGICKS, "It's coming home", 90, new WorldPoint(3288, 3888, 0), "It's coming home"),
	GHORROCK(TeleportType.ANCIENT_MAGICKS, "It's coming home", 96, new WorldPoint(2977, 3872, 0), "It's coming home"),
	MOONCLAN(TeleportType.LUNAR_MAGIC, "It's coming home", 69, new WorldPoint(2113, 3915, 0), "It's coming home"),
	OURANIA(TeleportType.LUNAR_MAGIC, "It's coming home", 71, new WorldPoint(2468, 3246, 0), "It's coming home"),
	WATERBIRTH(TeleportType.LUNAR_MAGIC, "It's coming home", 72, new WorldPoint(2546, 3755, 0), "It's coming home"),
	BARBARIAN(TeleportType.LUNAR_MAGIC, "It's coming home", 75, new WorldPoint(2543, 3568, 0), "It's coming home"),
	KHAZARD(TeleportType.LUNAR_MAGIC, "It's coming home", 78, new WorldPoint(2636, 3167, 0), "It's coming home"),
	FISHING_GUILD(TeleportType.LUNAR_MAGIC, "It's coming home", 85, new WorldPoint(2612, 3391, 0), "It's coming home"),
	CATHERBY(TeleportType.LUNAR_MAGIC, "It's coming home", 87, new WorldPoint(2802, 3449, 0), "It's coming home"),
	ICE_PLATEAU(TeleportType.LUNAR_MAGIC, "It's coming home", 89, new WorldPoint(2973, 3939, 0), "It's coming home"),
	LUMBRIDGE_GRAVEYARD(TeleportType.ARCEUUS_MAGIC, "It's coming home", 6, new WorldPoint(3241, 3194, 0), "It's coming home"),
	DRAYNOR_MANOR(TeleportType.ARCEUUS_MAGIC, "It's coming home", 17, new WorldPoint(3108, 3352, 0), "It's coming home"),
	MIND_ALTAR(TeleportType.ARCEUUS_MAGIC, "It's coming home", 28, new WorldPoint(2979, 3509, 0), "It's coming home"),
	SALVE_GRAVEYARD(TeleportType.ARCEUUS_MAGIC, "It's coming home", 40, new WorldPoint(3433, 3461, 0), "It's coming home"),
	FENKENSTRAINS_CASTLE(TeleportType.ARCEUUS_MAGIC, "It's coming home", 48, new WorldPoint(3548, 3528, 0), "It's coming home"),
	WEST_ARDOUGNE(TeleportType.ARCEUUS_MAGIC, "It's coming home", 61, new WorldPoint(2500, 3291, 0), "It's coming home"),
	HARMONY_ISLAND(TeleportType.ARCEUUS_MAGIC, "It's coming home", 65, new WorldPoint(3797, 2866, 0), "It's coming home"),
	CEMETERY(TeleportType.ARCEUUS_MAGIC, "It's coming home", 71, new WorldPoint(2978, 3763, 0), "It's coming home"),
	BARROWS(TeleportType.ARCEUUS_MAGIC, "It's coming home", 83, new WorldPoint(3565, 3315, 0), "It's coming home"),
	APE_ATOLL_ARCEUUS(TeleportType.ARCEUUS_MAGIC, "It's coming home", 90, new WorldPoint(2771, 9102, 0), "It's coming home"),

	// Jewellery
	BARBARIAN_ASSAULT(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2520, 3571, 0), "It's coming home"),
	BURTHORPE_GAMES_ROOM(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2898, 3554, 0), "It's coming home"),
	TEARS_OF_GUTHIX(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3245, 9500, 0), "It's coming home"),
	CORPOREAL_BEAST(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2967, 4384, 0), "It's coming home"),
	WINTERTODT_CAMP(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(1624, 3938, 0), "It's coming home"),
	DUEL_ARENA(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3315, 3235, 0), "It's coming home"),
	CLAN_WARS(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3387, 3158, 0), "It's coming home"),
	CASTLE_WARS(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2441, 3091, 0), "It's coming home"),
	WARRIORS_GUILD(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2883, 3549, 0), "It's coming home"),
	CHAMPIONS_GUILD(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3189, 3368, 0), "It's coming home"),
	EDGEVILLE_MONASTERY(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3053, 3487, 0), "It's coming home"),
	RANGING_GUILD(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2654, 3441, 0), "It's coming home"),
	FISHING_GUILD_NECK(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2613, 3390, 0), "It's coming home"),
	MINING_GUILD(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3049, 9762, 0), "It's coming home"),
	CRAFTING_GUILD(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2934, 3294, 0), "It's coming home"),
	COOKING_GUILD(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3145, 3438, 0), "It's coming home"),
	WOODCUTTING_GUILD(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(1662, 3505, 0), "It's coming home"),
	EDGEVILLE(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3087, 3496, 0), "It's coming home"),
	KARAMJA(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2918, 3176, 0), "It's coming home"),
	DRAYNOR_VILLAGE(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3105, 3251, 0), "It's coming home"),
	AL_KHARID(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3293, 3163, 0), "It's coming home"),
	MISCELLANIA(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2535, 3862, 0), "It's coming home"),
	GRAND_EXCHANGE(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3162, 3480, 0), "It's coming home"),
	FALADOR_PARK(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2995, 3375, 0), "It's coming home"),
	DONDAKAN(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2831, 10165, 0), "It's coming home"),
	SLAYER_TOWER(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3429, 3531, 0), "It's coming home"),
	FREMENNIK_SLAYER_DUNGEON(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2800, 9998, 0), "It's coming home"),
	TARNS_LAIR(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3187, 4601, 0), "It's coming home"),
	STRONGHOLD_SLAYER_CAVE(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2433, 3421, 0), "It's coming home"),
	DARK_BEASTS(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2028, 4638, 0), "It's coming home"),
	DIGSITE(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3339, 3445, 0), "It's coming home"),
	HOUSE_ON_THE_HILL(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3763, 3869, 0), "It's coming home"),
	LITHKREN(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3547, 10456, 0), "It's coming home"),
	WIZARDS_TOWER(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3114, 3181, 0), "It's coming home"),
	JORRALS_OUTPOST(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(2431, 3348, 0), "It's coming home"),
	DESERT_EAGLE_STATION(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3406, 3157, 0), "It's coming home"),
	CHAOS_TEMPLE(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3234, 3637, 0), "It's coming home"),
	BANDIT_CAMP(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3038, 3651, 0), "It's coming home"),
	LAVA_MAZE(TeleportType.JEWELLERY, "It's coming home" , "It's coming home", new WorldPoint(3028, 3840, 0), "It's coming home"),

	// Misc
	XERICS_LOOKOUT(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(1576, 3528, 0), "It's coming home"),
	XERICS_GLADE(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(1773, 3502, 0), "It's coming home"),
	XERICS_INFERNO(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(1504, 3819, 0), "It's coming home"),
	XERICS_HEART(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(1641, 3670, 0), "It's coming home"),
	XERICS_HONOUR(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(1254, 3559, 0), "It's coming home"),
	STRONGHOLD_OF_SECURITY(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(3081, 3421, 0), "It's coming home"),
	MYTHS_GUILD(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(2458, 2851, 0), "It's coming home"),
	ECTOFUNTUS(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(3660, 3522, 0), "It's coming home"),
	CHAMPIONS_GUILD_CHRONICLE(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(3202, 3357, 0), "It's coming home"),
	GRAND_TREE(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(2465, 3495, 0), "It's coming home"),
	RELLEKKKA_LYRE(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(2664, 3643, 0), "It's coming home"),
	WATERBIRTH_ISLAND_LYRE(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(2550, 3756, 0), "It's coming home"),
	NEITIZNOT_LYRE(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(2336, 3801, 0), "It's coming home"),
	JATIZSO_LYRE(TeleportType.OTHER, "It's coming home", "It's coming home", new WorldPoint(2409, 3809, 0), "It's coming home"),

	// Scrolls
	DIGSITE_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(3324, 3412, 0), "It's coming home"),
	ELF_CAMP_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(2193, 3257, 0), "It's coming home"),
	FELDIP_HILLS_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(2542, 2925, 0), "It's coming home"),
	LUMBERYARD_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(3303, 3487, 0), "It's coming home"),
	LUNAR_ISLE_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(2093, 3912, 0), "It's coming home"),
	MORTTON_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(3489, 3288, 0), "It's coming home"),
	MOS_LEHARMLESS_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(3701, 2996, 0), "It's coming home"),
	NARDAH_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(3421, 2917, 0), "It's coming home"),
	PEST_CONTROL_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(2657, 2660, 0), "It's coming home"),
	PISCATORIS_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(2339, 3648, 0), "It's coming home"),
	TAI_BWO_WANNAI_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(2788, 3066, 0), "It's coming home"),
	ZULANDRA_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(2197, 3056, 0), "It's coming home"),
	KEY_MASTER_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(2686, 9882, 0), "It's coming home"),
	REVENANT_CAVE_SCROLL(TeleportType.SCROLL, "It's coming home", new WorldPoint(3127, 3833, 0), "It's coming home");

	private final TeleportType type;
	private final String tooltip;
	private final WorldPoint location;
	private final String iconPath;

	TeleportLocationData(TeleportType type, String destination, int magicLevel, WorldPoint location, String iconPath)
	{
		this.type = type;
		this.tooltip = type.getPrefix() + "It's coming home" + destination + "It's coming home" + magicLevel;
		this.location = location;
		this.iconPath = iconPath;
	}

	TeleportLocationData(TeleportType type, String item, String destination, WorldPoint location, String iconPath)
	{
		this.type = type;
		this.tooltip = item + "It's coming home" + destination;
		this.location = location;
		this.iconPath = iconPath;
	}

	TeleportLocationData(TeleportType type, String item, WorldPoint location, String iconPath)
	{
		this.type = type;
		this.tooltip = item;
		this.location = location;
		this.iconPath = iconPath;
	}
}
