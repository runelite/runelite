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

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Set;
import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.plugins.cluescrolls.clues.emote.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.emote.SingleItemRequirement;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
@AllArgsConstructor
public class CoordinateClue extends ClueScroll implements TextClueScroll, LocationClueScroll
{
	public static final Set<CoordinateClue> CLUES = ImmutableSet.of(
			// Medium
			new CoordinateClue("00 degrees 05 minutes south 01 degrees 13 minutes east", new WorldPoint(2479, 3158, 0), "South of fruit tree patch, near Tree Gnome Village."),
			new CoordinateClue("00 degrees 13 minutes south 13 degrees 58 minutes east", new WorldPoint(2887, 3154, 0), "West of Banana plantation on Karamja."),
			new CoordinateClue("00 degrees 18 minutes south 09 degrees 28 minutes east", new WorldPoint(2743, 3151, 0), "Entrance of Brimhaven dungeon."),
			new CoordinateClue("00 degrees 20 minutes south 23 degrees 15 minutes east", new WorldPoint(3184, 3150, 0), "South of Lumbridge Swamp."),
			new CoordinateClue("00 degrees 30 minutes north 24 degrees 16 minutes east", new WorldPoint(3217, 3177, 0), "East of Lumbridge Swamp."),
			new CoordinateClue("00 degrees 31 minutes south 17 degrees 43 minutes east", new WorldPoint(3007, 3144, 0), "Near the entrance to the Asgarnian Ice Dungeon, south of Port Sarim (AIQ)."),
			new CoordinateClue("01 degrees 18 minutes south 14 degrees 15 minutes east", new WorldPoint(2896, 3119, 0), "Near Karambwan fishing spot (DKP)."),
			new CoordinateClue("01 degrees 26 minutes north 08 degrees 01 minutes east", new WorldPoint(2697, 3207, 0), "Centre of Moss Giant Island, west of Brimhaven."),
			new CoordinateClue("01 degrees 35 minutes south 07 degrees 28 minutes east", new WorldPoint(2679, 3110, 0), "North of Hazelmere's house (CLS)."),
			new CoordinateClue("02 degrees 43 minutes south 33 degrees 26 minutes east", new WorldPoint(3510, 3074, 0), "East of Uzer (DLQ)."),
			new CoordinateClue("02 degrees 48 minutes north 22 degrees 30 minutes east", new WorldPoint(3160, 3251, 0), "West of trapdoor leading to H.A.M Hideout."),
			new CoordinateClue("02 degrees 50 minutes north 06 degrees 20 minutes east", new WorldPoint(2643, 3252, 0), "South of Ardougne Zoo, North of Tower of Life (DJP)."),
			new CoordinateClue("03 degrees 07 minutes south 03 degrees 41 minutes west", new WorldPoint(2322, 3061, 0), "South-west of Castle wars (BKP)."),
			new CoordinateClue("03 degrees 35 minutes south 13 degrees 35 minutes east", new WorldPoint(2875, 3046, 0), "North of nature altar, North of Shilo Village (CKR)."),
			new CoordinateClue("04 degrees 00 minutes south 12 degrees 46 minutes east", new WorldPoint(2849, 3033, 0), "West of nature altar, North of Shilo Village (CKR)."),
			new CoordinateClue("04 degrees 13 minutes north 12 degrees 45 minutes east", new WorldPoint(2848, 3296, 0), "North of Crandor."),
			new CoordinateClue("05 degrees 20 minutes south 04 degrees 28 minutes east", new WorldPoint(2583, 2990, 0), "Feldip Hills, south-east of Gu'Thanoth (AKS)."),
			new CoordinateClue("05 degrees 43 minutes north 23 degrees 05 minutes east", new WorldPoint(3179, 3344, 0), "Just south of the Champions' Guild, opposite side of the River Lum in Lumbridge."),
			new CoordinateClue("06 degrees 31 minutes north 01 degrees 46 minutes west", new WorldPoint(2383, 3370, 0), "South-west of Tree Gnome Stronghold."),
			new CoordinateClue("06 degrees 41 minutes north 27 degrees 15 minutes east", new WorldPoint(3312, 3375, 0), "North-west of Exam Centre, on the hill."),
			new CoordinateClue("06 degrees 58 minutes north 21 degrees 16 minutes east", new WorldPoint(3121, 3384, 0), "North-east of Draynor Manor, near River Lum."),
			new CoordinateClue("07 degrees 05 minutes north 30 degrees 56 minutes east", new WorldPoint(3430, 3388, 0), "West of Mort Myre Swamp."),
			new CoordinateClue("07 degrees 33 minutes north 15 degrees 00 minutes east", new WorldPoint(2920, 3403, 0), "South-east of Taverley, near Lady of the Lake."),
			new CoordinateClue("08 degrees 11 minutes south 04 degrees 48 minutes east", new WorldPoint(2594, 2899, 0), "South-east of Feldip Hills, by the crimson swifts (AKS)."),
			new CoordinateClue("08 degrees 33 minutes north 01 degrees 39 minutes west", new WorldPoint(2387, 3435, 0), "West of Tree Gnome Stronghold, near the pen containing terrorbirds."),
			new CoordinateClue("09 degrees 33 minutes north 02 degrees 15 minutes east", new WorldPoint(2512, 3467, 0), "Baxtorian Falls ( Bring rope)."),
			new CoordinateClue("09 degrees 35 minutes north 01 degrees 50 minutes west", new WorldPoint(2381, 3468, 0), "West of Tree Gnome Stronghold, north of the pen with terrorbirds."),
			new CoordinateClue("09 degrees 48 minutes north 17 degrees 39 minutes east", new WorldPoint(3005, 3475, 0), "Ice Moutain, west of Edgeville."),
			new CoordinateClue("10 degrees 45 minutes north 04 degrees 31 minutes east", new WorldPoint(2585, 3505, 0), "By the shore line north of the Coal Trucks."),
			new CoordinateClue("11 degrees 03 minutes north 31 degrees 20 minutes east", new WorldPoint(3443, 3515, 0), "South of Slayer Tower."),
			new CoordinateClue("11 degrees 05 minutes north 00 degrees 45 minutes west", new WorldPoint(2416, 3516, 0), "Tree Gnome Stronghold, west of Grand Tree near swamp."),
			new CoordinateClue("11 degrees 18 minutes north 30 degrees 54 minutes east", new WorldPoint(3429, 3523, 0), "South of Slayer Tower."),
			new CoordinateClue("11 degrees 33 minutes north 02 degrees 24 minutes west", new WorldPoint(2363, 3531, 0), "North-east of Eagles' Peak."),
			new CoordinateClue("11 degrees 41 minutes north 14 degrees 58 minutes east", new WorldPoint(2919, 3535, 0), "East of Burthorpe pub."),
			new CoordinateClue("12 degrees 28 minutes north 34 degrees 37 minutes east", new WorldPoint(3548, 3560, 0), "Inside Fenkenstrain's Castle."),
			new CoordinateClue("14 degrees 20 minutes north 30 degrees 45 minutes west", new WorldPoint(1456, 3620, 0), "Graveyard west of Shayzien House."),
			new CoordinateClue("14 degrees 54 minutes north 09 degrees 13 minutes east", new WorldPoint(2735, 3638, 0), "East of Rellekka, north-west of Golden Apple Tree (AJR)."),
			new CoordinateClue("15 degrees 22 minutes north 07 degrees 31 minutes east", new WorldPoint(2681, 3653, 0), "Rellekka, in the garden of the south-east house."),
			new CoordinateClue("22 degrees 30 minutes north 03 degrees 01 minutes east", new WorldPoint(2537, 3881, 0), "Miscellania."),
			// Hard
			new CoordinateClue("00 degrees 00 minutes north 07 degrees 13 minutes west", new WorldPoint(2209, 3161, 0), "North-east of Tyras Camp."),
			new CoordinateClue("01 degrees 24 minutes north 08 degrees 05 minutes west", new WorldPoint(2181, 3206, 0), "South of Elf Camp."),
			new CoordinateClue("01 degrees 30 minutes north 20 degrees 01 minutes east", new WorldPoint(3081, 3209, 0), "Small Island (CLP)."),
			new CoordinateClue("02 degrees 46 minutes north 29 degrees 11 minutes east", new WorldPoint(3374, 3250, 0), "Duel Arena combat area."),
			new CoordinateClue("02 degrees 48 minutes north 08 degrees 05 minutes east", new WorldPoint(2699, 3251, 0), "Little island (AIR)."),
			new CoordinateClue("02 degrees 48 minutes north 34 degrees 33 minutes east", new WorldPoint(3546, 3251, 0), "North-east of Burgh de Rott."),
			new CoordinateClue("02 degrees 58 minutes north 34 degrees 30 minutes east", new WorldPoint(3544, 3256, 0), "North-east of Burgh de Rott."),
			new CoordinateClue("03 degrees 18 minutes north 12 degrees 31 minutes east", new WorldPoint(2841, 3267, 0), "Crandor island."),
			new CoordinateClue("03 degrees 45 minutes south 22 degrees 45 minutes east", new WorldPoint(3168, 3041, 0), "Bedabin Camp."),
			new CoordinateClue("04 degrees 03 minutes south 03 degrees 11 minutes east", new WorldPoint(2542, 3031, 0), "Gu'Tanoth."),
			new CoordinateClue("04 degrees 05 minutes south 04 degrees 24 minutes east", new WorldPoint(2581, 3030, 0), "Island north of Feldip Hills."),
			new CoordinateClue("04 degrees 16 minutes south 16 degrees 16 minutes east", new WorldPoint(2961, 3024, 0), "Ship yard (DKP)."),
			new CoordinateClue("04 degrees 41 minutes north 03 degrees 09 minutes west", new WorldPoint(2339, 3311, 0), "East of Tirannwn on Arandar mountain pass."),
			new CoordinateClue("05 degrees 37 minutes north 31 degrees 15 minutes east", new WorldPoint(3440, 3341, 0), "Nature Spirit's grotto."),
			new CoordinateClue("05 degrees 50 minutes south 10 degrees 05 minutes east", new WorldPoint(2763, 2974, 0), "Cairn Isle."),
			new CoordinateClue("06 degrees 00 minutes south 21 degrees 48 minutes east", new WorldPoint(3138, 2969, 0), "West of Bandid Camp."),
			new CoordinateClue("06 degrees 11 minutes south 15 degrees 07 minutes east", new WorldPoint(2924, 2963, 0), "On the southern part of eastern Karamja."),
			new CoordinateClue("07 degrees 43 minutes south 12 degrees 26 minutes east", new WorldPoint(2838, 2914, 0), "Kharazi Jungle, near water pool."),
			new CoordinateClue("08 degrees 03 minutes north 31 degrees 16 minutes east", new WorldPoint(3441, 3419, 0), "Mort Myre Swamp."),
			new CoordinateClue("08 degrees 05 minutes south 15 degrees 56 minutes east", new WorldPoint(2950, 2902, 0), "South-east of Kharazi Jungle."),
			new CoordinateClue("08 degrees 26 minutes south 10 degrees 28 minutes east", new WorldPoint(2775, 2891, 0), "South-west of Kharazi Jungle."),
			new CoordinateClue("13 degrees 46 minutes north 21 degrees 01 minutes east", new WorldPoint(3113, 3602, 0), "Wilderness. North of Edgeville (level 11)."),
			new CoordinateClue("16 degrees 03 minutes north 14 degrees 07 minutes east", new WorldPoint(2892, 3675, 0), "On the summit of Trollheim."),
			new CoordinateClue("16 degrees 07 minutes north 22 degrees 45 minutes east", new WorldPoint(3168, 3677, 0), "Wilderness. Graveyard of Shadows."),
			new CoordinateClue("16 degrees 31 minutes north 12 degrees 54 minutes east", new WorldPoint(2853, 3690, 0), "Entrance to the troll Stronghold."),
			new CoordinateClue("16 degrees 35 minutes north 27 degrees 01 minutes east", new WorldPoint(3305, 3692, 0), "Wilderness. West of eastern green dragon."),
			new CoordinateClue("16 degrees 43 minutes north 19 degrees 13 minutes east", new WorldPoint(3055, 3696, 0), "Wilderness. Bandid Camp."),
			new CoordinateClue("16 degrees 43 minutes north 26 degrees 56 minutes east", new WorldPoint(3302, 3696, 0), "Wilderness. West of eastern green dragon."),
			new CoordinateClue("16 degrees 43 minutes north 30 degrees 01 minutes west", new WorldPoint(1479, 3696, 0), "Lizardman Canyon."),
			new CoordinateClue("17 degrees 50 minutes north 08 degrees 30 minutes east", new WorldPoint(2712, 3732, 0), "North-east of Rellekka."),
			new CoordinateClue("18 degrees 22 minutes north 16 degrees 33 minutes east", new WorldPoint(2970, 3749, 0), "Wilderness. Forgotten Cemetery."),
			new CoordinateClue("18 degrees 50 minutes north 20 degrees 26 minutes east", new WorldPoint(3094, 3764, 0), "Wilderness. Mining site north of Bandit Camp."),
			new CoordinateClue("19 degrees 00 minutes north 27 degrees 13 minutes east", new WorldPoint(3311, 3769, 0), "Wilderness. North of Venenatis."),
			new CoordinateClue("19 degrees 24 minutes north 30 degrees 37 minutes west", new WorldPoint(1460, 3782, 0), "Lovakengj, near burning man."),
			new CoordinateClue("19 degrees 43 minutes north 25 degrees 07 minutes east", new WorldPoint(3244, 3792, 0), "Wilderness. South-east of Lava Dragon Isle by some Chaos Dwarves."),
			new CoordinateClue("20 degrees 05 minutes north 21 degrees 52 minutes east", new WorldPoint(3140, 3804, 0), "Wilderness. North of Ruins."),
			new CoordinateClue("20 degrees 33 minutes north 15 degrees 48 minutes east", new WorldPoint(2946, 3819, 0), "Wilderness. Chaos Temple (level 38)."),
			new CoordinateClue("20 degrees 45 minutes north 41 degrees 35 minutes east", new WorldPoint(3771, 3825, 0), "Fossil Island. East of Museum Camp."),
			new CoordinateClue("21 degrees 24 minutes north 17 degrees 54 minutes east", new WorldPoint(3013, 3846, 0), "Wilderness. West of Lava Maze, before KBD's lair."),
			new CoordinateClue("22 degrees 35 minutes north 19 degrees 18 minutes east", new WorldPoint(3058, 3884, 0), "Wilderness. Near runite ore north of Lava Maze."),
			new CoordinateClue("22 degrees 45 minutes north 26 degrees 33 minutes east", new WorldPoint(3290, 3889, 0), "Wilderness. Demonic Ruins."),
			new CoordinateClue("23 degrees 00 minutes north 41 degrees 33 minutes east", new WorldPoint(3770, 3897, 0), "Small Island north of Fossil Island."),
			new CoordinateClue("23 degrees 03 minutes north 02 degrees 01 minutes east", new WorldPoint(2505, 3899, 0), "Small Island north-east of Miscellania (AJS)."),
			new CoordinateClue("24 degrees 24 minutes north 26 degrees 24 minutes east", new WorldPoint(3285, 3942, 0), "Wilderness. Rogues' Castle."),
			new CoordinateClue("24 degrees 56 minutes north 22 degrees 28 minutes east", new WorldPoint(3159, 3959, 0), "Wilderness. North of Deserted Keep, west of Resource Area."),
			new CoordinateClue("24 degrees 58 minutes north 18 degrees 43 minutes east", new WorldPoint(3039, 3960, 0), "Wilderness. Pirates' Hideout."),
			new CoordinateClue("25 degrees 03 minutes north 17 degrees 05 minutes east", new WorldPoint(2987, 3963, 0), "Wilderness. West of Wilderness Agility Course."),
			new CoordinateClue("25 degrees 03 minutes north 23 degrees 24 minutes east", new WorldPoint(3189, 3963, 0), "Wilderness. North  of Resource Area, near magix axe hut."),
			// Elite
			new CoordinateClue("00 degrees 18 minutes south 02 degrees 35 minutes west", new WorldPoint(2357, 3151, 0), "Lletya."),
			new CoordinateClue("00 degrees 35 minutes north 35 degrees 50 minutes east", new WorldPoint(3587, 3180, 0), "Meiyerditch."),
			new CoordinateClue("02 degrees 35 minutes south 11 degrees 52 minutes east", new WorldPoint(2820, 3078, 0), "Tai Bwo Wannai. Hardwood Grove."),
			new CoordinateClue("03 degrees 09 minutes south 42 degrees 50 minutes east", new WorldPoint(3811, 3060, 0), "Small island north-east of Mos Le'Harmless."),
			new CoordinateClue("03 degrees 46 minutes north 08 degrees 07 minutes west", new WorldPoint(2180, 3282, 0), "North of Elf Camp."),
			new CoordinateClue("05 degrees 07 minutes south 13 degrees 26 minutes east", new WorldPoint(2870, 2997, 0), "North-east of Shilo Village."),
			new CoordinateClue("05 degrees 24 minutes south 26 degrees 56 minutes east", new WorldPoint(3302, 2988, 0), "On top of a cliff to the west of Pollnivneach."),
			new CoordinateClue("05 degrees 39 minutes south 02 degrees 13 minutes east", new WorldPoint(2511, 2980, 0), "Just south of Gu'Tanoth, west of Gnormadium Avlafrim's gnome glider."),
			new CoordinateClue("06 degrees 35 minutes north 09 degrees 07 minutes east", new WorldPoint(2732, 3372, 0), "Legends' Guild."),
			new CoordinateClue("08 degrees 15 minutes north 35 degrees 24 minutes east", new WorldPoint(3573, 3425, 0), "North of Dessous's tomb from Desert Treasure."),
			new CoordinateClue("09 degrees 46 minutes south 43 degrees 22 minutes east", new WorldPoint(3828, 2848, 0), "East of Harmony Island."),
			new CoordinateClue("10 degrees 05 minutes south 24 degrees 31 minutes east", new WorldPoint(3225, 2838, 0), "South of Desert Treasure pyramid."),
			new CoordinateClue("10 degrees 54 minutes north 20 degrees 50 minutes west", new WorldPoint(1773, 3510, 0), "Between magic trees South of Tithe Farm."),
			new CoordinateClue("12 degrees 31 minutes north 43 degrees 11 minutes east", new WorldPoint(3822, 3562, 0), "North-east of Dragontooth Island."),
			new CoordinateClue("12 degrees 35 minutes north 36 degrees 20 minutes east", new WorldPoint(3603, 3564, 0), "North of the wrecked ship, outside of Port Phasmatys."),
			new CoordinateClue("13 degrees 45 minutes south 15 degrees 30 minutes east", new WorldPoint(2936, 2721, 0), "Eastern shore of Crash Island."),
			new CoordinateClue("14 degrees 15 minutes south 08 degrees 01 minutes east", new WorldPoint(2697, 2705, 0), "South-west of Ape Atoll."),
			new CoordinateClue("16 degrees 09 minutes north 10 degrees 33 minutes east", new WorldPoint(2778, 3678, 0), "Mountain Camp."),
			new CoordinateClue("18 degrees 05 minutes north 12 degrees 05 minutes east", new WorldPoint(2827, 3740, 0), "West of the entrance to the Ice Path, where the Troll child resides."),
			new CoordinateClue("19 degrees 56 minutes north 02 degrees 31 minutes west", new WorldPoint(2359, 3799, 0), "Neitiznot."),
			new CoordinateClue("20 degrees 11 minutes north 07 degrees 41 minutes west", new WorldPoint(2194, 3807, 0), "Pirates' Cove."),
			new CoordinateClue("20 degrees 13 minutes north 08 degrees 07 minutes east", new WorldPoint(2700, 3808, 0), "Northwestern part of the Trollweiss and Rellekka Hunter area (DKS)."),
			new CoordinateClue("21 degrees 03 minutes north 24 degrees 13 minutes east", new WorldPoint(3215, 3835, 0), "Wilderness. Lava Dragon Isle."),
			new CoordinateClue("22 degrees 54 minutes north 29 degrees 01 minutes east", new WorldPoint(3369, 3894, 0), "Fountain of Rune."),
			new CoordinateClue("23 degrees 48 minutes north 11 degrees 43 minutes west", new WorldPoint(2065, 3923, 0), "Outside the western wall on Lunar Isle."),
			new CoordinateClue("24 degrees 07 minutes north 23 degrees 22 minutes east", new WorldPoint(3188, 3933, 0), "Wilderness. Resource Area."),
			new CoordinateClue("24 degrees 45 minutes north 17 degrees 24 minutes east", new WorldPoint(2997, 3953, 0), "Wilderness. Inside Agility Training Area."),
			new CoordinateClue("25 degrees 03 minutes north 29 degrees 22 minutes east", new WorldPoint(3380, 3963, 0), "Wilderness. North of Volcano."),
			// Master
			new CoordinateClue("01 degrees 30 minutes north 08 degrees 11 minutes west", new WorldPoint(2178, 3209, 0), "South of Elf Camp."),
			new CoordinateClue("01 degrees 54 minutes south 08 degrees 54 minutes west", new WorldPoint(2155, 3100, 0), "South of Port Tyras (BJS)."),
			new CoordinateClue("02 degrees 09 minutes south 06 degrees 58 minutes west", new WorldPoint(2217, 3092, 0), "Poison Waste (DLR)."),
			new CoordinateClue("03 degrees 09 minutes south 43 degrees 26 minutes east", new WorldPoint(3830, 3060, 0), "Small island located north-east of Mos Le'Harmless."),
			new CoordinateClue("03 degrees 26 minutes north 12 degrees 18 minutes east", new WorldPoint(2834, 3271, 0), "Crandor."),
			new CoordinateClue("03 degrees 50 minutes north 09 degrees 07 minutes east", new WorldPoint(2732, 3284, 0), "Witchaven."),
			new CoordinateClue("04 degrees 58 minutes north 36 degrees 56 minutes east", new WorldPoint(3622, 3320, 0), "Meiyerditch. Outside mine."),
			new CoordinateClue("05 degrees 13 minutes north 04 degrees 16 minutes west", new WorldPoint(2303, 3328, 0), "East of Prifddinas."),
			new CoordinateClue("07 degrees 37 minutes north 35 degrees 18 minutes east", new WorldPoint(3570, 3405, 0), "North of Dessous's tomb from Desert Treasure."),
			new CoordinateClue("08 degrees 11 minutes north 12 degrees 30 minutes east", new WorldPoint(2840, 3423, 0), "Water Obelisk Island."),
			new CoordinateClue("12 degrees 35 minutes north 36 degrees 22 minutes east", new WorldPoint(3604, 3564, 0), "North of the wrecked ship, outside of Port Phasmatys."),
			new CoordinateClue("12 degrees 45 minutes north 20 degrees 09 minutes east", new WorldPoint(3085, 3569, 0), "Wilderness. Obelisk of Air."),
			new CoordinateClue("13 degrees 33 minutes south 15 degrees 26 minutes east", new WorldPoint(2934, 2727, 0), "Eastern shore of Crash Island."),
			new CoordinateClue("16 degrees 41 minutes north 30 degrees 54 minutes west", new WorldPoint(1451, 3695, 0), "Lizardman shaman in Lizardman Canyon."),
			new CoordinateClue("18 degrees 03 minutes north 03 degrees 03 minutes east", new WorldPoint(2538, 3739, 0), "Waterbirth Island."),
			new CoordinateClue("18 degrees 26 minutes north 37 degrees 15 minutes west", new WorldPoint(1248, 3751, 0), "Farming Guild."),
			new CoordinateClue("19 degrees 43 minutes north 23 degrees 11 minutes west", new WorldPoint(1698, 3792, 0), "Arceuus church."),
			new CoordinateClue("20 degrees 35 minutes north 15 degrees 58 minutes east", new WorldPoint(2951, 3820, 0), "Wilderness. Chaos Temple (level 38)."),
			new CoordinateClue("20 degrees 45 minutes north 07 degrees 26 minutes west", new WorldPoint(2202, 3825, 0), "Pirates' Cove."),
			new CoordinateClue("21 degrees 37 minutes north 21 degrees 13 minutes west", new WorldPoint(1761, 3853, 0), "Arceuus essence mine."),
			new CoordinateClue("21 degrees 56 minutes north 10 degrees 56 minutes west", new WorldPoint(2090, 3863, 0), "South of Lunar Isle, west of Astral altar."),
			new CoordinateClue("22 degrees 24 minutes north 31 degrees 11 minutes west", new WorldPoint(1442, 3878, 0), "Sulphur Mine."),
			new CoordinateClue("24 degrees 00 minutes north 29 degrees 22 minutes east", new WorldPoint(3380, 3929, 0), "Wilderness. Near Volcano."),
			new CoordinateClue("24 degrees 18 minutes north 23 degrees 22 minutes east", new WorldPoint(3188, 3939, 0), "Resource Area."),
			new CoordinateClue("24 degrees 22 minutes north 27 degrees 00 minutes east", new WorldPoint(3304, 3941, 0), "East of Rogues' Castle."),
			new CoordinateClue("25 degrees 00 minutes north 17 degrees 18 minutes east", new WorldPoint(2994, 3961, 0), "Wilderness. Inside Agility Training Area.")
	);

	private String text;
	private WorldPoint location;
	private String solution;
	private static final ItemRequirement HAS_SPADE = new SingleItemRequirement(ItemID.SPADE);

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Coordinate Clue").build());

		panelComponent.getChildren().add(LineComponent.builder()
				.left(getSolution())
				.build());

		panelComponent.getChildren().add(LineComponent.builder().left("").build());
		panelComponent.getChildren().add(TitleComponent.builder().text("Marked on world map.").build());

		if (plugin.getInventoryItems() != null)
		{
			if (!HAS_SPADE.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("").build());
				panelComponent.getChildren().add(LineComponent.builder().left("Requires Spade!").leftColor(Color.RED).build());
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

		OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
	}

	public static CoordinateClue forText(String text)
	{
		for (CoordinateClue clue : CLUES)
		{
			if (clue.text.equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return coordinatesToWorldPoint(text);
	}

	/**
	 * Example input: "00 degrees 00 minutes north 07 degrees 13 minutes west"
	 * Note: some clues use "1 degree" instead of "01 degrees"
	 */
	private static CoordinateClue coordinatesToWorldPoint(String text)
	{
		String[] splitText = text.split(" ");

		if (splitText.length != 10)
		{
			//log.warn("Splitting \"" + text + "\" did not result in an array of 10 cells");
			return null;
		}

		if (!splitText[1].startsWith("degree") || !splitText[3].startsWith("minute"))
		{
			//log.warn("\"" + text + "\" is not a well formed coordinate string");
			return null;
		}

		int degY = Integer.parseInt(splitText[0]);
		int minY = Integer.parseInt(splitText[2]);

		if (splitText[4].equals("south"))
		{
			degY *= -1;
			minY *= -1;
		}

		int degX = Integer.parseInt(splitText[5]);
		int minX = Integer.parseInt(splitText[7]);

		if (splitText[9].equals("west"))
		{
			degX *= -1;
			minX *= -1;
		}

		return new CoordinateClue(text, coordinatesToWorldPoint(degX, minX, degY, minY), "Click the clue scroll along the edge of your world map to see where you should dig.");
	}

	/**
	 * This conversion is explained on
	 * https://oldschool.runescape.wiki/w/Treasure_Trails/Guide/Coordinates
	 */
	private static WorldPoint coordinatesToWorldPoint(int degX, int minX, int degY, int minY)
	{
		// Center of the Observatory
		int x2 = 2440;
		int y2 = 3161;

		x2 += degX * 32 + Math.round(minX / 1.875);
		y2 += degY * 32 + Math.round(minY / 1.875);

		return new WorldPoint(x2, y2, 0);
	}
}
