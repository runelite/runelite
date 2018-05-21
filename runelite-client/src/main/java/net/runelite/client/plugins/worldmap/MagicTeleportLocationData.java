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
enum MagicTeleportLocationData
{
	VARROCK(TeleportType.NORMAL_MAGIC, "Varrock", 25, new WorldPoint(3213, 3424, 0), "varrock_teleport_icon.png"),
	VARROCK_GE(TeleportType.NORMAL_MAGIC, "Varrock GE", 25, new WorldPoint(3164, 3478, 0), "varrock_teleport_icon.png"),
	LUMBRIDGE(TeleportType.NORMAL_MAGIC, "Lumbridge", 31, new WorldPoint(3222, 3218, 0), "lumbridge_teleport_icon.png"),
	FALADOR(TeleportType.NORMAL_MAGIC, "Falador", 37, new WorldPoint(2965, 3381, 0), "falador_teleport_icon.png"),
	CAMELOT(TeleportType.NORMAL_MAGIC, "Camelot", 45, new WorldPoint(2757, 3477, 0), "camelot_teleport_icon.png"),
	CAMELOT_BANK(TeleportType.NORMAL_MAGIC, "Camelot Bank", 45, new WorldPoint(2726, 3485, 0), "camelot_teleport_icon.png"),
	ARDOUGNE(TeleportType.NORMAL_MAGIC, "Ardougne", 51, new WorldPoint(2664, 3306, 0), "ardougne_teleport_icon.png"),
	WATCHTOWER(TeleportType.NORMAL_MAGIC, "Watchtower", 58, new WorldPoint(2547, 3114, 0), "watchtower_teleport_icon.png"),
	WATCHTOWER_YANILLE(TeleportType.NORMAL_MAGIC, "Watchtower Yanille", 58, new WorldPoint(2584, 3097, 0), "watchtower_teleport_icon.png"),
	TROLLHEIM(TeleportType.NORMAL_MAGIC, "Trollheim", 61, new WorldPoint(2891, 3678, 0), "trollheim_teleport_icon.png"),
	APE_ATOLL(TeleportType.NORMAL_MAGIC, "Ape Atoll", 64, new WorldPoint(2796, 2791, 0), "ape_atoll_teleport_icon.png"),
	KOUREND(TeleportType.NORMAL_MAGIC, "Kourend", 69, new WorldPoint(1643, 3672, 0), "kourend_teleport_icon.png"),
	PADDEWWA(TeleportType.ANCIENT_MAGICKS, "Paddewwa", 54, new WorldPoint(3097, 9880, 0), "paddewwa_teleport_icon.png"),
	SENNTISTEN(TeleportType.ANCIENT_MAGICKS, "Senntisten", 60, new WorldPoint(3319, 3336, 0), "senntisten_teleport_icon.png"),
	KHARYRLL(TeleportType.ANCIENT_MAGICKS, "Kharyrll", 66, new WorldPoint(3494, 3473, 0), "kharyrll_teleport_icon.png"),
	LASSAR(TeleportType.ANCIENT_MAGICKS, "Lassar", 72, new WorldPoint(3002, 3472, 0), "lassar_teleport_icon.png"),
	DAREEYAK(TeleportType.ANCIENT_MAGICKS, "Dareeyak", 78, new WorldPoint(2969, 3695, 0), "dareeyak_teleport_icon.png"),
	CARRALLANGAR(TeleportType.ANCIENT_MAGICKS, "Carrallangar", 84, new WorldPoint(3157, 3667, 0), "carrallangar_teleport_icon.png"),
	ANNAKARL(TeleportType.ANCIENT_MAGICKS, "Annakarl", 90, new WorldPoint(3288, 3888, 0), "annakarl_teleport_icon.png"),
	GHORROCK(TeleportType.ANCIENT_MAGICKS, "Ghorrock", 96, new WorldPoint(2977, 3872, 0), "ghorrock_teleport_icon.png"),
	MOONCLAN(TeleportType.LUNAR_MAGIC, "Moonclan", 69, new WorldPoint(2113, 3915, 0), "moonclan_teleport_icon.png"),
	OURANIA(TeleportType.LUNAR_MAGIC, "Ourania", 71, new WorldPoint(2468, 3246, 0), "ourania_teleport_icon.png"),
	WATERBIRTH(TeleportType.LUNAR_MAGIC, "Waterbirth", 72, new WorldPoint(2546, 3755, 0), "waterbirth_teleport_icon.png"),
	BARBARIAN(TeleportType.LUNAR_MAGIC, "Barbarian", 75, new WorldPoint(2543, 3568, 0), "barbarian_teleport_icon.png"),
	KHAZARD(TeleportType.LUNAR_MAGIC, "Khazard", 78, new WorldPoint(2636, 3167, 0), "khazard_teleport_icon.png"),
	FISHING_GUILD(TeleportType.LUNAR_MAGIC, "Fishing Guild", 85, new WorldPoint(2612, 3391, 0), "fishing_guild_teleport_icon.png"),
	CATHERBY(TeleportType.LUNAR_MAGIC, "Catherby", 87, new WorldPoint(2802, 3449, 0), "catherby_teleport_icon.png"),
	ICE_PLATEAU(TeleportType.LUNAR_MAGIC, "Ice Plateau", 89, new WorldPoint(2973, 3939, 0), "ice_plateau_teleport_icon.png"),
	LUMBRIDGE_GRAVEYARD(TeleportType.ARCEUUS_MAGIC, "Lumbridge Graveyard", 6, new WorldPoint(3241, 3194, 0), "lumbridge_graveyard_teleport_icon.png"),
	DRAYNOR_MANOR(TeleportType.ARCEUUS_MAGIC, "Draynor Manor", 17, new WorldPoint(3108, 3352, 0), "draynor_manor_teleport_icon.png"),
	MIND_ALTAR(TeleportType.ARCEUUS_MAGIC, "Mind Altar", 28, new WorldPoint(2979, 3509, 0), "mind_altar_teleport_icon.png"),
	SALVE_GRAVEYARD(TeleportType.ARCEUUS_MAGIC, "Salve Graveyard", 40, new WorldPoint(3433, 3461, 0), "salve_graveyard_teleport_icon.png"),
	FENKENSTRAINS_CASTLE(TeleportType.ARCEUUS_MAGIC, "Fenkenstrain's Castle", 48, new WorldPoint(3548, 3528, 0), "fenkenstrains_castle_teleport_icon.png"),
	WEST_ARDOUGNE(TeleportType.ARCEUUS_MAGIC, "West Ardougne", 61, new WorldPoint(2500, 3291, 0), "west_ardougne_teleport_icon.png"),
	HARMONY_ISLAND(TeleportType.ARCEUUS_MAGIC, "Harmony Island", 65, new WorldPoint(3797, 2866, 0), "harmony_island_teleport_icon.png"),
	CEMETERY(TeleportType.ARCEUUS_MAGIC, "Cemetery", 71, new WorldPoint(2978, 3763, 0), "cemetery_teleport_icon.png"),
	BARROWS(TeleportType.ARCEUUS_MAGIC, "Barrows", 83, new WorldPoint(3565, 3315, 0), "barrows_teleport_icon.png"),
	APE_ATOLL_ARCEUUS(TeleportType.ARCEUUS_MAGIC, "Ape Atoll", 90, new WorldPoint(2771, 9102, 0), "ape_atoll_teleport_icon_arceuus.png");

	private final TeleportType type;
	private final String tooltip;
	private final int magicLevel;
	private final WorldPoint location;
	private final String iconPath;

	MagicTeleportLocationData(TeleportType type, String destination, int magicLevel, WorldPoint location, String iconPath)
	{
		this.type = type;
		this.tooltip = type.getPrefix() + " " + destination + " - lvl " + magicLevel;
		this.magicLevel = magicLevel;
		this.location = location;
		this.iconPath = iconPath;
	}
}
