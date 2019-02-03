/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.cluescrolls.clues.hotcold;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.ASGARNIA;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.DESERT;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.FELDIP_HILLS;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.FREMENNIK_PROVINCE;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.KANDARIN;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.KARAMJA;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.MISTHALIN;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.MORYTANIA;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.WESTERN_PROVINCE;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.WILDERNESS;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.ZEAH;

// The locations contains all hot/cold points and their descriptions according to the wiki
// these central points were obtained by checking wiki location pictures against a coordinate map
// some central points points may be slightly off-center
// calculations are done considering the 9x9 grid around the central point where the strange device shakes
// because the calculations consider the 9x9 grid, slightly off-center points should still be found by the calculations
@AllArgsConstructor
@Getter
public enum HotColdLocation
{
	ASGARNIA_WARRIORS(new WorldPoint(2860, 3562, 0), ASGARNIA, "North of the Warriors' Guild in Burthorpe."),
	ASGARNIA_JATIX(new WorldPoint(2914, 3429, 0), ASGARNIA, "East of Jatix's Herblore Shop in Taverley."),
	ASGARNIA_BARB(new WorldPoint(3036, 3439, 0), ASGARNIA, "West of Barbarian Village."),
	ASGARNIA_MIAZRQA(new WorldPoint(2973, 3489, 0), ASGARNIA, "North of Miazrqa's tower, outside Goblin Village."),
	ASGARNIA_COW(new WorldPoint(3033, 3308, 0), ASGARNIA, "In the cow pen north of Sarah's Farming Shop."),
	ASGARNIA_PARTY_ROOM(new WorldPoint(3026, 3363, 0), ASGARNIA, "Outside the Falador Party Room."),
	ASGARNIA_CRAFT_GUILD(new WorldPoint(2917, 3295, 0), ASGARNIA, "Outside the Crafting Guild cow pen."),
	ASGARNIA_RIMMINGTON(new WorldPoint(2978, 3241, 0), ASGARNIA, "In the centre of the Rimmington mine."),
	ASGARNIA_MUDSKIPPER(new WorldPoint(2984, 3109, 0), ASGARNIA, "Mudskipper Point, on the starfish in the south-west corner."),
	ASGARNIA_TROLL(new WorldPoint(2910, 3616, 0), ASGARNIA, "The Troll arena, where the player fights Dad during the Troll Stronghold quest. Bring climbing boots if travelling from Burthorpe."),
	DESERT_GENIE(new WorldPoint(3364, 2910, 0), DESERT, "West of Nardah genie cave."),
	DESERT_ALKHARID_MINE(new WorldPoint(3282, 3270, 0), DESERT, "West of Al Kharid mine."),
	DESERT_MENAPHOS_GATE(new WorldPoint(3224, 2816, 0), DESERT, "North of Menaphos gate."),
	DESERT_BEDABIN_CAMP(new WorldPoint(3164, 3050, 0), DESERT, "Bedabin Camp, dig around the north tent."),
	DESERT_UZER(new WorldPoint(3431, 3106, 0), DESERT, "West of Uzer."),
	DESERT_POLLNIVNEACH(new WorldPoint(3287, 2975, 0), DESERT, "West of Pollnivneach."),
	DESERT_MTA(new WorldPoint(3350, 3293, 0), DESERT, "Next to Mage Training Arena."),
	DESERT_SHANTY(new WorldPoint(3294, 3106, 0), DESERT, "South-west of Shantay Pass."),
	FELDIP_HILLS_JIGGIG(new WorldPoint(2413, 3055, 0), FELDIP_HILLS, "West of Jiggig, east of the fairy ring bkp."),
	FELDIP_HILLS_SW(new WorldPoint(2582, 2895, 0), FELDIP_HILLS, "West of the southeasternmost lake in Feldip Hills."),
	FELDIP_HILLS_GNOME_GLITER(new WorldPoint(2553, 2972, 0), FELDIP_HILLS, "East of the gnome glider (Lemantolly Undri)."),
	FELDIP_HILLS_RANTZ(new WorldPoint(2611, 2946, 0), FELDIP_HILLS, "South of Rantz, six steps west of the empty glass bottles."),
	FELDIP_HILLS_SOUTH(new WorldPoint(2487, 3005, 0), FELDIP_HILLS, "South of Jiggig."),
	FELDIP_HILLS_RED_CHIN(new WorldPoint(2532, 2900, 0), FELDIP_HILLS, "Outside the red chinchompa hunting ground entrance, south of the Hunting expert's hut."),
	FELDIP_HILLS_SE(new WorldPoint(2567, 2916, 0), FELDIP_HILLS, "South-east of the ∩-shaped lake, near the icon."),
	FELDIP_HILLS_CW_BALLOON(new WorldPoint(2452, 3108, 0), FELDIP_HILLS, "Directly west of the Castle Wars balloon."),
	FREMENNIK_PROVINCE_MTN_CAMP(new WorldPoint(2804, 3672, 0), FREMENNIK_PROVINCE, "At the Mountain Camp."),
	FREMENNIK_PROVINCE_RELLEKKA_HUNTER(new WorldPoint(2724, 3783, 0), FREMENNIK_PROVINCE, "At the Rellekka Hunter area, near the icon."),
	FREMENNIK_PROVINCE_KELGADRIM_ENTRANCE(new WorldPoint(2715, 3689, 0), FREMENNIK_PROVINCE, "West of the Keldagrim entrance mine."),
	FREMENNIK_PROVINCE_SW(new WorldPoint(2605, 3648, 0), FREMENNIK_PROVINCE, "Outside the fence in the south-western corner of Rellekka."),
	FREMENNIK_PROVINCE_LIGHTHOUSE(new WorldPoint(2589, 3598, 0), FREMENNIK_PROVINCE, "South-east of the Lighthouse."),
	FREMENNIK_PROVINCE_ETCETERIA_CASTLE(new WorldPoint(2614, 3867, 0), FREMENNIK_PROVINCE, "Inside Etceteria's castle, in the southern staircase."),
	FREMENNIK_PROVINCE_MISC_COURTYARD(new WorldPoint(2529, 3867, 0), FREMENNIK_PROVINCE, "Outside Miscellania's courtyard."),
	FREMENNIK_PROVINCE_FREMMY_ISLES_MINE(new WorldPoint(2378, 3849, 0), FREMENNIK_PROVINCE, "Central Fremennik Isles mine."),
	FREMENNIK_PROVINCE_WEST_ISLES_MINE(new WorldPoint(2313, 3854, 0), FREMENNIK_PROVINCE, "West Fremennik Isles mine."),
	FREMENNIK_PROVINCE_WEST_JATIZSO_ENTRANCE(new WorldPoint(2391, 3813, 0), FREMENNIK_PROVINCE, "West of the Jatizso mine entrance."),
	FREMENNIK_PROVINCE_PIRATES_COVE(new WorldPoint(2210, 3814, 0), FREMENNIK_PROVINCE, "Pirates' Cove"),
	FREMENNIK_PROVINCE_ASTRAL_ALTER(new WorldPoint(2147, 3862, 0), FREMENNIK_PROVINCE, "Astral altar"),
	FREMENNIK_PROVINCE_LUNAR_VILLAGE(new WorldPoint(2087, 3915, 0), FREMENNIK_PROVINCE, "Lunar Isle, inside the village."),
	FREMENNIK_PROVINCE_LUNAR_NORTH(new WorldPoint(2106, 3949, 0), FREMENNIK_PROVINCE, "Lunar Isle, north of the village."),
	KANDARIN_SINCLAR_MANSION(new WorldPoint(2726, 3588, 0), KANDARIN, "North-west of the Sinclair Mansion, near the log balance shortcut."),
	KANDARIN_CATHERBY(new WorldPoint(2774, 3433, 0), KANDARIN, "Catherby, between the bank and the beehives, near small rock formation."),
	KANDARIN_GRAND_TREE(new WorldPoint(2444, 3503, 0), KANDARIN, "Grand Tree, just east of the terrorchick gnome enclosure."),
	KANDARIN_SEERS(new WorldPoint(2735, 3486, 0), KANDARIN, "Between the Seers' Village bank and Camelot."),
	KANDARIN_MCGRUBORS_WOOD(new WorldPoint(2653, 3485, 0), KANDARIN, "McGrubor's Wood"),
	KANDARIN_FISHING_BUILD(new WorldPoint(2586, 3372, 0), KANDARIN, "South of Fishing Guild"),
	KANDARIN_WITCHHAVEN(new WorldPoint(2708, 3304, 0), KANDARIN, "Outside Witchaven, west of Jeb, Holgart, and Caroline."),
	KANDARIN_NECRO_TOWER(new WorldPoint(2669, 3242, 0), KANDARIN, "Ground floor inside the Necromancer Tower. Easily accessed by using fairy ring code djp."),
	KANDARIN_FIGHT_ARENA(new WorldPoint(2587, 3134, 0), KANDARIN, "South of the Fight Arena, north-west of the Nightmare Zone."),
	KANDARIN_TREE_GNOME_VILLAGE(new WorldPoint(2526, 3160, 0), KANDARIN, "Tree Gnome Village, near the general store icon."),
	KANDARIN_GRAVE_OF_SCORPIUS(new WorldPoint(2464, 3228, 0), KANDARIN, "Grave of Scorpius"),
	KANDARIN_KHAZARD_BATTLEFIELD(new WorldPoint(2518, 3249, 0), KANDARIN, "Khazard Battlefield, in the small ruins south of tracker gnome 2."),
	KANDARIN_WEST_ARDY(new WorldPoint(2533, 3320, 0), KANDARIN, "West Ardougne, near the staircase outside the Civic Office."),
	KANDARIN_SW_TREE_GNOME_STRONGHOLD(new WorldPoint(2411, 3431, 0), KANDARIN, "South-west Tree Gnome Stronghold"),
	KANDARIN_OUTPOST(new WorldPoint(2458, 3364, 0), KANDARIN, "South of the Tree Gnome Stronghold, north-east of the Outpost."),
	KANDARIN_BAXTORIAN_FALLS(new WorldPoint(2534, 3479, 0), KANDARIN, "South-east of Almera's house on Baxtorian Falls."),
	KANDARIN_BA_AGILITY_COURSE(new WorldPoint(2536, 3546, 0), KANDARIN, "Inside the Barbarian Agility Course. Completion of Alfred Grimhand's Barcrawl is required."),
	KARAMJA_MUSA_POINT(new WorldPoint(2914, 3168, 0), KARAMJA, "Musa Point, banana plantation."),
	KARAMJA_BRIMHAVEN_FRUIT_TREE(new WorldPoint(2783, 3214, 0), KARAMJA, "Brimhaven, east of the fruit tree patch."),
	KARAMJA_WEST_BRIMHAVEN(new WorldPoint(2721, 3169, 0), KARAMJA, "West of Brimhaven."),
	KARAMJA_GLIDER(new WorldPoint(2966, 2975, 0), KARAMJA, "West of the gnome glider."),
	KARAMJA_KHARAZI_NE(new WorldPoint(2908, 2922, 0), KARAMJA, "North-eastern part of Kharazi Jungle."),
	KARAMJA_KHARAZI_SW(new WorldPoint(2783, 2898, 0), KARAMJA, "South-western part of Kharazi Jungle."),
	KARAMJA_CRASH_ISLAND(new WorldPoint(2910, 2737, 0), KARAMJA, "Northern part of Crash Island."),
	MISTHALIN_VARROCK_STONE_CIRCLE(new WorldPoint(3225, 3355, 0), MISTHALIN, "South of the stone circle near Varrock's entrance."),
	MISTHALIN_LUMBRIDGE(new WorldPoint(3238, 3169, 0), MISTHALIN, "Just north-west of the Lumbridge Fishing tutor."),
	MISTHALIN_LUMBRIDGE_2(new WorldPoint(3170, 3278, 0), MISTHALIN, "North of the pond between Lumbridge and Draynor Village."),
	MISTHALIN_GERTUDES(new WorldPoint(3158, 3421, 0), MISTHALIN, "Nort-east of Gertrude's house west of Varrock."),
	MISTHALIN_DRAYNOR_BANK(new WorldPoint(3096, 3235, 0), MISTHALIN, "South of Draynor Village bank."),
	MISTHALIN_LUMBER_YARD(new WorldPoint(3303, 3483, 0), MISTHALIN, "South of Lumber Yard, east of Assistant Serf."),
	MORYTANIA_BURGH_DE_ROTT(new WorldPoint(3545, 3253, 0), MORYTANIA, "In the north-east area of Burgh de Rott, by the reverse-L-shaped ruins."),
	MORYTANIA_PORT_PHASMATYS(new WorldPoint(3613, 3485, 0), MORYTANIA, "West of Port Phasmatys, south-east of fairy ring."),
	MORYTANIA_HOLLOWS(new WorldPoint(3500, 3423, 0), MORYTANIA, "Inside The Hollows, south of the bridge which was repaired in a quest."),
	MORYTANIA_SWAMP(new WorldPoint(3422, 3374, 0), MORYTANIA, "Inside the Mort Myre Swamp, north-west of the Nature Grotto."),
	MORYTANIA_HAUNTED_MINE(new WorldPoint(3441, 3259, 0), MORYTANIA, "At Haunted Mine quest start."),
	MORYTANIA_MAUSOLEUM(new WorldPoint(3499, 3539, 0), MORYTANIA, "South of the Mausoleum."),
	MORYTANIA_MOS_LES_HARMLESS(new WorldPoint(3744, 3041, 0), MORYTANIA, "Northern area of Mos Le'Harmless, between the lakes."),
	MORYTANIA_MOS_LES_HARMLESS_BAR(new WorldPoint(3670, 2974, 0), MORYTANIA, "Near Mos Le'Harmless southern bar."),
	MORYTANIA_DRAGONTOOTH_NORTH(new WorldPoint(3813, 3567, 0), MORYTANIA, "Northern part of Dragontooth Island."),
	MORYTANIA_DRAGONTOOTH_SOUTH(new WorldPoint(3803, 3532, 0), MORYTANIA, "Southern part of Dragontooth Island."),
	WESTERN_PROVINCE_EAGLES_PEAK(new WorldPoint(2297, 3530, 0), WESTERN_PROVINCE, "North-west of Eagles' Peak."),
	WESTERN_PROVINCE_PISCATORIS(new WorldPoint(2337, 3689, 0), WESTERN_PROVINCE, "Piscatoris Fishing Colony"),
	WESTERN_PROVINCE_PISCATORIS_HUNTER_AREA(new WorldPoint(2361, 3566, 0), WESTERN_PROVINCE, "Eastern part of Piscatoris Hunter area, south-west of the Falconry."),
	WESTERN_PROVINCE_ARANDAR(new WorldPoint(2366, 3318, 0), WESTERN_PROVINCE, "South-west of the crystal gate to Arandar."),
	WESTERN_PROVINCE_ELF_CAMP_EAST(new WorldPoint(2270, 3244, 0), WESTERN_PROVINCE, "East of Elf Camp."),
	WESTERN_PROVINCE_ELF_CAMP_NW(new WorldPoint(2174, 3280, 0), WESTERN_PROVINCE, "North-west of Elf Camp."),
	WESTERN_PROVINCE_LLETYA(new WorldPoint(2335, 3166, 0), WESTERN_PROVINCE, "In Lletya."),
	WESTERN_PROVINCE_TYRAS(new WorldPoint(2204, 3157, 0), WESTERN_PROVINCE, "Near Tyras Camp."),
	WESTERN_PROVINCE_ZULANDRA(new WorldPoint(2196, 3057, 0), WESTERN_PROVINCE, "The northern house at Zul-Andra."),
	WILDERNESS_5(new WorldPoint(3169, 3558, 0), WILDERNESS, "North of the Grand Exchange, level 5 Wilderness."),
	WILDERNESS_12(new WorldPoint(3038, 3612, 0), WILDERNESS, "South-east of the Dark Warriors' Fortress, level 12 Wilderness."),
	WILDERNESS_20(new WorldPoint(3225, 3676, 0), WILDERNESS, "East of the Corporeal Beast's lair, level 20 Wilderness."),
	WILDERNESS_28(new WorldPoint(3374, 3734, 0), WILDERNESS, "East of Venenatis' nest, level 28 Wilderness."),
	WILDERNESS_35(new WorldPoint(3153, 3795, 0), WILDERNESS, "East of the Wilderness canoe exit, level 35 Wilderness."),
	WILDERNESS_37(new WorldPoint(2975, 3811, 0), WILDERNESS, "South-east of the Chaos Temple, level 37 Wilderness."),
	WILDERNESS_38(new WorldPoint(3294, 3817, 0), WILDERNESS, "South of Callisto, level 38 Wilderness."),
	WILDERNESS_49(new WorldPoint(3140, 3910, 0), WILDERNESS, "South-west of the Deserted Keep, level 49 Wilderness."),
	WILDERNESS_54(new WorldPoint(2983, 3946, 0), WILDERNESS, "West of the Wilderness Agility Course, level 54 Wilderness."),
	ZEAH_BLASTMINE_BANK(new WorldPoint(1507, 3856, 0), ZEAH, "Next to the bank in the Lovakengj House blast mine."),
	ZEAH_BLASTMINE_NORTH(new WorldPoint(1490, 3883, 0), ZEAH, "Northern part of the Lovakengj House blast mine."),
	ZEAH_LOVAKITE_FURNACE(new WorldPoint(1505, 3814, 0), ZEAH, "Next to the lovakite furnace in the Lovakengj House."),
	ZEAH_LOVAKENGJ_MINE(new WorldPoint(1477, 3779, 0), ZEAH, "Next to mithril rock in the Lovakengj mine."),
	ZEAH_SULPHR_MINE(new WorldPoint(1428, 3866, 0), ZEAH, "Western entrance in the Lovakengj House's sulphur mine."),
	ZEAH_SHAYZIEN_BANK(new WorldPoint(1517, 3603, 0), ZEAH, "South-east of the bank in the Shayzien House."),
	ZEAH_OVERPASS(new WorldPoint(1467, 3714, 0), ZEAH, "Overpass between the Lovakengj and Shayzien House."),
	ZEAH_LIZARDMAN(new WorldPoint(1493, 3694, 0), ZEAH, "Within Lizardman Canyon, east of the ladder. Requires 5% favour with the Shayzien House."),
	ZEAH_COMBAT_RING(new WorldPoint(1557, 3580, 0), ZEAH, "Shayzien, south-east of the Combat Ring."),
	ZEAH_SHAYZIEN_BANK_2(new WorldPoint(1494, 3622, 0), ZEAH, "North-west of the bank in the Shayzien House."),
	ZEAH_LIBRARY(new WorldPoint(1601, 3842, 0), ZEAH, "North-west of the Arceuus House Library."),
	ZEAH_HOUSECHURCH(new WorldPoint(1682, 3792, 0), ZEAH, "By the entrance to the Arceuus Housechurch."),
	ZEAH_DARK_ALTAR(new WorldPoint(1699, 3879, 0), ZEAH, "West of the Dark Altar."),
	ZEAH_ARCEUUS_HOUSE(new WorldPoint(1708, 3701, 0), ZEAH, "By the southern entrance to the Arceuus House."),
	ZEAH_ESSENCE_MINE(new WorldPoint(1762, 3852, 0), ZEAH, "By the Arceuus essence mine."),
	ZEAH_ESSENCE_MINE_NE(new WorldPoint(1772, 3866, 0), ZEAH, "North-east of the Arceuus essence mine."),
	ZEAH_PISCARILUS_MINE(new WorldPoint(1768, 3705, 0), ZEAH, "South of the Piscarilius mine."),
	ZEAH_GOLDEN_FIELD_TAVERN(new WorldPoint(1718, 3647, 0), ZEAH, "South of The Golden Field tavern in the northern area of Great Kourend's Hosidius House."),
	ZEAH_MESS_HALL(new WorldPoint(1658, 3621, 0), ZEAH, "East of Mess hall."),
	ZEAH_WATSONS_HOUSE(new WorldPoint(1653, 3573, 0), ZEAH, "East of Watson's house."),
	ZEAH_VANNAHS_FARM_STORE(new WorldPoint(1806, 3521, 0), ZEAH, "North of Vannah's Farm Store, between the chicken coop and willow trees."),
	ZEAH_FARMING_GUILD_SW(new WorldPoint(1227, 3712, 0), ZEAH, "South-west of the Farming Guild."),
	ZEAH_FARMING_GUILD_W(new WorldPoint(1209, 3737, 0), ZEAH, "West of the Farming Guild."),
	ZEAH_DAIRY_COW(new WorldPoint(1320, 3718, 0), ZEAH, "North-east of the Kebos Lowlands, east of the dairy cow."),
	ZEAH_CRIMSON_SWIFTS(new WorldPoint(1186, 3583, 0), ZEAH, "South-west of the Kebos Swamp, below the crimson swifts.");

	private final WorldPoint worldPoint;
	private final HotColdArea hotColdArea;
	private final String area;

	public Rectangle2D getRect()
	{
		return new Rectangle(worldPoint.getX() - 4, worldPoint.getY() - 4, 9, 9);
	}
}
