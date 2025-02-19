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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import net.runelite.api.Varbits;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.clues.Enemy.ANCIENT_WIZARDS;
import static net.runelite.client.plugins.cluescrolls.clues.Enemy.ARMADYLEAN_GUARD;
import static net.runelite.client.plugins.cluescrolls.clues.Enemy.ARMADYLEAN_OR_BANDOSIAN_GUARD;
import static net.runelite.client.plugins.cluescrolls.clues.Enemy.BANDOSIAN_GUARD;
import static net.runelite.client.plugins.cluescrolls.clues.Enemy.BRASSICAN_MAGE;
import static net.runelite.client.plugins.cluescrolls.clues.Enemy.SARADOMIN_WIZARD;
import static net.runelite.client.plugins.cluescrolls.clues.Enemy.ZAMORAK_WIZARD;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public class CoordinateClue extends ClueScroll implements LocationClueScroll
{
	private static final int DEFAULT_RESOURCE_AREA_COST = 7500;

	static final ImmutableMap<WorldPoint, CoordinateClue> CLUES = List.of(
		// Medium
		CoordinateClue.builder()
			.location(new WorldPoint(2479, 3158, 0))
			.directions("South of fruit tree patch, west of Tree Gnome Village.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2887, 3154, 0))
			.directions("West of Banana plantation on Karamja.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2743, 3151, 0))
			.directions("Entrance of Brimhaven dungeon.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3184, 3150, 0))
			.directions("South of Lumbridge Swamp.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3217, 3177, 0))
			.directions("East of Lumbridge Swamp.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3007, 3144, 0))
			.directions("Near the entrance to the Asgarnian Ice Dungeon, south of Port Sarim (AIQ).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2896, 3119, 0))
			.directions("Near Karambwan fishing spot (DKP).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2697, 3207, 0))
			.directions("Centre of Moss Giant Island, west of Brimhaven.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2679, 3110, 0))
			.directions("North of Hazelmere's house (CLS).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3510, 3074, 0))
			.directions("East of Uzer (DLQ).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3160, 3251, 0))
			.directions("West of trapdoor leading to H.A.M Hideout.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2643, 3252, 0))
			.directions("South of Ardougne Zoo, North of Tower of Life (DJP).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2322, 3061, 0))
			.directions("South-west of Castle wars (BKP).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2875, 3046, 0))
			.directions("North of nature altar, north of Shilo Village (CKR).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2849, 3033, 0))
			.directions("West of nature altar, north of Shilo Village (CKR).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2848, 3296, 0))
			.directions("North of Crandor island.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2583, 2990, 0))
			.directions("Feldip Hills, south-east of Gu'Tanoth (AKS).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3179, 3344, 0))
			.directions("In the cow pen north of the Lumbridge windmill.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2383, 3370, 0))
			.directions("West of the outpost")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3312, 3375, 0))
			.directions("North-west of Exam Centre, on the hill.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3121, 3384, 0))
			.directions("North-east of Draynor Manor, near River Lum.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3430, 3388, 0))
			.directions("West of Mort Myre Swamp (BKR).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2920, 3403, 0))
			.directions("South-east of Taverley, near Lady of the Lake.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2594, 2899, 0))
			.directions("South-east of Feldip Hills, by the crimson swifts (AKS).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2387, 3435, 0))
			.directions("West of Tree Gnome Stronghold, near the pen containing terrorbirds.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2512, 3467, 0))
			.directions("Baxtorian Falls (Bring rope).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2381, 3468, 0))
			.directions("West of Tree Gnome Stronghold, north of the pen with terrorbirds.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3005, 3475, 0))
			.directions("Ice Mountain, west of Edgeville Monastery.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2585, 3505, 0))
			.directions("By the shore line north of the Coal Trucks.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3443, 3515, 0))
			.directions("South of Slayer Tower (CKS).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2416, 3516, 0))
			.directions("Tree Gnome Stronghold, west of Grand Tree, near swamp.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3429, 3523, 0))
			.directions("South of Slayer Tower (CKS).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2363, 3531, 0))
			.directions("North-east of Eagles' Peak (AKQ).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2919, 3535, 0))
			.directions("East of Burthorpe pub.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3548, 3560, 0))
			.directions("Inside Fenkenstrain's Castle.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1476, 3566, 0))
			.directions("Graveyard of Heroes in west Shayzien.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2735, 3638, 0))
			.directions("East of Rellekka, north-west of Golden Apple Tree (AJR).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2681, 3653, 0))
			.directions("Rellekka, in the garden of the south-east house.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2537, 3881, 0))
			.directions("Miscellania (CIP).")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2828, 3234, 0))
			.directions("Southern coast of Crandor.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1247, 3726, 0))
			.directions("Just inside the Farming Guild")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3770, 3898, 0))
			.directions("On the small island north-east of Fossil Island's mushroom forest.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1659, 3111, 0))
			.directions("Dig west of the Bazaar in Civitas illa Fortis.")
			.build(),
		// Hard
		CoordinateClue.builder()
			.location(new WorldPoint(2209, 3161, 0))
			.directions("North-east of Tyras Camp (BJS if 76 Agility).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2181, 3206, 0))
			.directions("South of Iorwerth Camp.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3081, 3209, 0))
			.directions("Small Island (CLP).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3399, 3246, 0))
			.directions("Behind the PvP Arena.")
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2699, 3251, 0))
			.directions("Little island (AIR).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3546, 3251, 0))
			.directions("North-east of Burgh de Rott.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3544, 3256, 0))
			.directions("North-east of Burgh de Rott.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2841, 3267, 0))
			.directions("Crandor island.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3168, 3041, 0))
			.directions("Bedabin Camp.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2542, 3031, 0))
			.directions("Gu'Tanoth, may require 20gp.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2581, 3030, 0))
			.directions("Gu'Tanoth island, enter cave north-west of Feldip Hills (AKS).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2961, 3024, 0))
			.directions("Ship yard (DKP).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2339, 3311, 0))
			.directions("East of Prifddinas on Arandar mountain pass.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3440, 3341, 0))
			.directions("Nature Spirit's grotto (BIP).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2763, 2974, 0))
			.directions("Cairn Isle, west of Shilo Village (CKR).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3138, 2969, 0))
			.directions("West of Bandit Camp in Kharidian Desert.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2924, 2963, 0))
			.directions("On the southern part of eastern Karamja, west of the gnome glider.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2838, 2914, 0))
			.directions("Kharazi Jungle, near water pool (CKR).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3441, 3419, 0))
			.directions("Mort Myre Swamp (BKR).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2950, 2902, 0))
			.directions("South-east of Kharazi Jungle.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2775, 2891, 0))
			.directions("South-west of Kharazi Jungle.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3113, 3602, 0))
			.directions("Wilderness. South-west of Ferox Enclave (level 11).")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2892, 3675, 0))
			.directions("On the summit of Trollheim.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3168, 3677, 0))
			.directions("Wilderness. Graveyard of Shadows.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2853, 3690, 0))
			.directions("Entrance to the troll Stronghold.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3305, 3692, 0))
			.directions("Wilderness. West of eastern green dragons.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3055, 3696, 0))
			.directions("Wilderness. Bandit Camp.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3302, 3696, 0))
			.directions("Wilderness. West of eastern green dragons.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1479, 3699, 0))
			.directions("Lizardman Canyon (DJR).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2712, 3732, 0))
			.directions("North-east of Rellekka (DKS).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2970, 3749, 0))
			.directions("Wilderness. Forgotten Cemetery.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3094, 3764, 0))
			.directions("Wilderness. Mining site north of Bandit Camp.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3311, 3769, 0))
			.directions("Wilderness. South of the Silk Chasm (Venenatis).")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1460, 3782, 0))
			.directions("Lovakengj, near burning man.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3244, 3792, 0))
			.directions("Wilderness. South-east of Lava Dragon Isle by some Chaos Dwarves.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3140, 3804, 0))
			.directions("Wilderness. North of black chinchompa hunter area.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2946, 3819, 0))
			.directions("Wilderness. Chaos Temple (level 38).")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3771, 3825, 0))
			.directions("Fossil Island. East of Museum Camp.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3013, 3846, 0))
			.directions("Wilderness. West of Lava Maze, before KBD's lair.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3058, 3884, 0))
			.directions("Wilderness. Near runite ore north of Lava Maze.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3290, 3889, 0))
			.directions("Wilderness. Demonic Ruins.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3770, 3897, 0))
			.directions("Small Island north of Fossil Island.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2505, 3899, 0))
			.directions("Small Island north-west of Miscellania (AJS).")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3285, 3942, 0))
			.directions("Wilderness. Rogues' Castle.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3159, 3959, 0))
			.directions("Wilderness. North of Deserted Keep, west of Resource Area.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3039, 3960, 0))
			.directions("Wilderness. Pirates' Hideout.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2987, 3963, 0))
			.directions("Wilderness. West of Wilderness Agility Course.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3189, 3963, 0))
			.directions("Wilderness. North of Resource Area, near magic axe hut.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2341, 3697, 0))
			.directions("North-east of the Piscatoris Fishing Colony bank.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3143, 3774, 0))
			.directions("In level 32 Wilderness, by the black chinchompa hunting area.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2970, 3913, 0))
			.directions("Frozen Waste Plateau, south-west of Wilderness Agility Course.")
			.enemy(ZAMORAK_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1410, 3611, 0))
			.directions("Lake Molch dock west of Shayzien Encampment.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1409, 3483, 0))
			.directions("South of Shayziens' Wall.")
			.enemy(SARADOMIN_WIZARD)
			.build(),
		// Elite
		CoordinateClue.builder()
			.location(new WorldPoint(2357, 3151, 0))
			.directions("Lletya.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3587, 3180, 0))
			.directions("Meiyerditch.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2820, 3078, 0))
			.directionsProvider((plugin) -> "Tai Bwo Wannai hardwood grove." + getHardwoodGroveCost(plugin))
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3811, 3060, 0))
			.directions("Small island north-east of Mos Le'Harmless.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.lightSourceVarbitId(Varbits.FIRE_PIT_MOS_LE_HARMLESS)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2180, 3282, 0))
			.directions("North of Iorwerth Camp.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2870, 2997, 0))
			.directions("North-east corner in Shilo Village.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3302, 2988, 0))
			.directions("On top of a cliff to the west of Pollnivneach.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2511, 2980, 0))
			.directions("Just south of Gu'Tanoth, west of gnome glider (AKS).")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2732, 3372, 0))
			.directions("Legends' Guild.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3573, 3425, 0))
			.directions("North of Dessous's tomb from Desert Treasure.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3828, 2848, 0))
			.directions("East of Harmony Island.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3225, 2838, 0))
			.directions("South of Desert Treasure pyramid.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1773, 3510, 0))
			.directions("Ruins north of the Hosidius mine.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3822, 3562, 0))
			.directions("North-east of Dragontooth Island. Bring a Ghostspeak Amulet and 25 Ecto-tokens to reach the island.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3603, 3564, 0))
			.directions("North of the wrecked ship, outside of Port Phasmatys.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2936, 2721, 0))
			.directions("Eastern shore of Crash Island.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2697, 2705, 0))
			.directions("South-west of Ape Atoll.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2778, 3678, 0))
			.directions("Mountain Camp.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2827, 3740, 0))
			.directions("West of the entrance to the Ice Path, where the Troll child resides.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2359, 3799, 0))
			.directions("Neitiznot.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2194, 3807, 0))
			.directions("Pirates' Cove.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2700, 3808, 0))
			.directions("Northwestern part of the Trollweiss and Rellekka Hunter area (DKS).")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3215, 3835, 0))
			.directions("Wilderness. Lava Dragon Isle.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3369, 3894, 0))
			.directions("Wilderness. Fountain of Rune.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2065, 3923, 0))
			.directions("Outside the western wall on Lunar Isle.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3188, 3933, 0))
			.directionsProvider((plugin) -> "Wilderness Resource Area." + getResourceAreaCost(plugin))
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3043, 3940, 0))
			.directions("Wilderness. South of Pirates' Hideout.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3380, 3963, 0))
			.directions("Wilderness. North of Volcano.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3051, 3736, 0))
			.directions("East of the Wilderness Obelisk in 28 Wilderness.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2316, 3814, 0))
			.directions("West of Neitiznot, near the bridge.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2872, 3937, 0))
			.directions("Weiss.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2484, 4016, 0))
			.directions("Northeast corner of the Island of Stone.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2222, 3331, 0))
			.directions("Prifddinas, west of the Tower of Voices")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3560, 3987, 0))
			.directions("Lithkren. Digsite pendant teleport if unlocked, otherwise take rowboat from west of Mushroom Meadow Mushtree.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2318, 2954, 0))
			.directions("North-east corner of the Isle of Souls (BJP).")
			.enemy(BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2094, 2889, 0))
			.directions("West side of the Isle of Souls.")
			.enemy(ARMADYLEAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1451, 3509, 0))
			.directions("Ruins of Morra.")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3318, 2706, 0))
			.directions("Necropolis mine")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1557, 3183, 0))
			.directions("North of Ortus Farm")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1571, 3245, 0))
			.directions("At the top of The Proudspire")
			.enemy(ARMADYLEAN_OR_BANDOSIAN_GUARD)
			.build(),
		// Master
		CoordinateClue.builder()
			.location(new WorldPoint(2178, 3209, 0))
			.directions("South of Iorwerth Camp.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2155, 3100, 0))
			.directions("South of Port Tyras (BJS if 76 Agility).")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2217, 3092, 0))
			.directions("Poison Waste island (DLR).")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3830, 3060, 0))
			.directions("Small island located north-east of Mos Le'Harmless.")
			.enemy(BRASSICAN_MAGE)
			.lightSourceVarbitId(Varbits.FIRE_PIT_MOS_LE_HARMLESS)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2834, 3271, 0))
			.directions("Crandor island.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2732, 3284, 0))
			.directions("Witchaven.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3622, 3320, 0))
			.directions("Meiyerditch. Outside mine.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2303, 3328, 0))
			.directions("East of Prifddinas.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3570, 3405, 0))
			.directions("North of Dessous's tomb from Desert Treasure.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2840, 3423, 0))
			.directions("Water Obelisk Island.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3604, 3564, 0))
			.directions("North of the wrecked ship, outside of Port Phasmatys (ALQ).")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3085, 3569, 0))
			.directions("Wilderness. Obelisk of Air.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2934, 2727, 0))
			.directions("Eastern shore of Crash Island.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1451, 3695, 0))
			.directions("West side of Lizardman Canyon with Lizardman shaman.")
			.enemy(ANCIENT_WIZARDS)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2538, 3739, 0))
			.directions("Waterbirth Island. Bring a pet rock and rune thrownaxe OR have 85 agility.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1248, 3751, 0))
			.directions("In the north wing of the Farming Guild.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1698, 3792, 0))
			.directions("Arceuus church.")
			.enemy(ANCIENT_WIZARDS)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2951, 3820, 0))
			.directions("Wilderness. Chaos Temple (level 38).")
			.enemy(ANCIENT_WIZARDS)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2202, 3825, 0))
			.directions("Pirates' Cove, between Lunar Isle and Rellekka.")
			.enemy(ANCIENT_WIZARDS)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1761, 3853, 0))
			.directions("Arceuus essence mine (CIS).")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(2090, 3863, 0))
			.directions("South of Lunar Isle, west of Astral altar.")
			.enemy(ANCIENT_WIZARDS)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1442, 3878, 0))
			.directions("Northern area of the Lovakengj Sulphur Mine. Facemask or Slayer Helmet recommended.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3380, 3929, 0))
			.directions("Wilderness. Near Volcano.")
			.enemy(ANCIENT_WIZARDS)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3188, 3939, 0))
			.directions("Wilderness. Resource Area.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3304, 3941, 0))
			.directions("Wilderness. East of Rogues' Castle.")
			.enemy(ANCIENT_WIZARDS)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(3028, 3928, 0))
			.directions("Wilderness. South-east of Agility Training Area.")
			.enemy(BRASSICAN_MAGE)
			.build(),
		CoordinateClue.builder()
			.location(new WorldPoint(1769, 3418, 0))
			.directions("Crabclaw Isle")
			.enemy(ANCIENT_WIZARDS)
			.build()
	)
		.stream()
		.collect(Collectors.collectingAndThen(
			Collectors.toMap(
				CoordinateClue::getLocation,
				clue -> clue
			),
			ImmutableMap::copyOf
		));

	@Getter(AccessLevel.PRIVATE)
	private final Function<ClueScrollPlugin, String> directionsProvider;
	@Nullable
	private final Enemy enemy;
	@Getter(onMethod_ = {@Varbit})
	private final int lightSourceVarbitId;
	@Getter(AccessLevel.PRIVATE)
	private final WorldPoint location;
	/**
	 * For regions which are mirrored, the location of the clue in the mirrored region.
	 */
	@Nullable
	private final WorldPoint mirrorLocation;

	@Builder
	private CoordinateClue(
		@Nullable String directions,
		@Nullable Function<ClueScrollPlugin, String> directionsProvider,
		@Nullable Enemy enemy,
		WorldPoint location,
		@Nullable @Varbit Integer lightSourceVarbitId
	)
	{
		this.directionsProvider = directionsProvider != null ? directionsProvider : (plugin) -> directions;
		this.enemy = enemy;
		this.location = location;
		this.mirrorLocation = location == null ? null : WorldPoint.getMirrorPoint(location, false);
		this.lightSourceVarbitId = lightSourceVarbitId == null ? -1 : lightSourceVarbitId;

		setFirePitVarbitId(this.lightSourceVarbitId);
		setRequiresLight(this.lightSourceVarbitId != -1);
		setRequiresSpade(true);
	}

	public static CoordinateClue forLocation(WorldPoint location)
	{
		return CLUES.get(location);
	}

	@VisibleForTesting
	String getDirections(ClueScrollPlugin plugin)
	{
		return getDirectionsProvider().apply(plugin);
	}

	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return location;
	}

	@Override
	public WorldPoint[] getLocations(ClueScrollPlugin plugin)
	{
		if (mirrorLocation != null && mirrorLocation != location)
		{
			return new WorldPoint[]{location, mirrorLocation};
		}
		else
		{
			return new WorldPoint[]{location};
		}
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Coordinate Clue").build());

		final CoordinateClue solution = CLUES.get(location);

		if (solution != null)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left(solution.getDirections(plugin))
				.build());
			panelComponent.getChildren().add(LineComponent.builder().build());
		}

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Click the clue scroll on your world map to see dig location.")
			.build());

		renderOverlayNote(panelComponent, plugin);
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		for (WorldPoint worldPoint : getLocations(plugin))
		{
			LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), worldPoint);

			if (localLocation != null)
			{
				OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
			}
		}
	}

	@Override
	public int[] getConfigKeys()
	{
		return new int[]{location.hashCode()};
	}

	private static String getResourceAreaCost(ClueScrollPlugin plugin)
	{
		if (plugin.getClient().getVarbitValue(Varbits.DIARY_WILDERNESS_ELITE) == 1)
		{
			return "";
		}

		int resourceAreaCost = DEFAULT_RESOURCE_AREA_COST;

		if (plugin.getClient().getVarbitValue(Varbits.DIARY_WILDERNESS_HARD) == 1)
		{
			resourceAreaCost = (int) (DEFAULT_RESOURCE_AREA_COST * 0.5);
		}
		else if (plugin.getClient().getVarbitValue(Varbits.DIARY_WILDERNESS_MEDIUM) == 1)
		{
			resourceAreaCost = (int) (DEFAULT_RESOURCE_AREA_COST * 0.8);
		}

		return String.format(" An entry fee of %,d coins is required.", resourceAreaCost);
	}

	private static String getHardwoodGroveCost(ClueScrollPlugin plugin)
	{
		if (plugin.getClient().getVarbitValue(Varbits.DIARY_KARAMJA_ELITE) == 1)
		{
			return "";
		}

		return " An entry fee of 100 trading sticks is required.";
	}
}
