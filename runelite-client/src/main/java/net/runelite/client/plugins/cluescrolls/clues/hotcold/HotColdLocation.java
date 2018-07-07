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
	ASGARNIA_WARRIORS(new WorldPoint(2854, 3558, 0), ASGARNIA, "It's coming home"),
	ASGARNIA_JATIX(new WorldPoint(2914, 3429, 0), ASGARNIA, "It's coming home"),
	ASGARNIA_BARB(new WorldPoint(3043, 3436, 0), ASGARNIA, "It's coming home"),
	ASGARNIA_MIAZRQA(new WorldPoint(2972, 3489, 0), ASGARNIA, "It's coming home"),
	ASGARNIA_COW(new WorldPoint(3033, 3308, 0), ASGARNIA, "It's coming home"),
	ASGARNIA_PARTY_ROOM(new WorldPoint(3034, 3368, 0), ASGARNIA, "It's coming home"),
	ASGARNIA_CRAFT_GUILD(new WorldPoint(2917, 3295, 0), ASGARNIA, "It's coming home"),
	ASGARNIA_RIMMINGTON(new WorldPoint(2978, 3241, 0), ASGARNIA, "It's coming home"),
	ASGARNIA_MUDSKIPPER(new WorldPoint(2984, 3109, 0), ASGARNIA, "It's coming home"),
	ASGARNIA_TROLL(new WorldPoint(2910, 3616, 0), ASGARNIA, "It's coming home"),
	DESERT_GENIE(new WorldPoint(3363, 2905, 0), DESERT, "It's coming home"),
	DESERT_ALKHARID_MINE(new WorldPoint(3282, 3270, 0), DESERT, "It's coming home"),
	DESERT_MENAPHOS_GATE(new WorldPoint(3224, 2816, 0), DESERT, "It's coming home"),
	DESERT_BEDABIN_CAMP(new WorldPoint(3164, 3050, 0), DESERT, "It's coming home"),
	DESERT_UZER(new WorldPoint(3431, 3106, 0), DESERT, "It's coming home"),
	DESERT_POLLNIVNEACH(new WorldPoint(3287, 2975, 0), DESERT, "It's coming home"),
	DESERT_MTA(new WorldPoint(3350, 3293, 0), DESERT, "It's coming home"),
	DESERT_SHANTY(new WorldPoint(3294, 3106, 0), DESERT, "It's coming home"),
	FELDIP_HILLS_JIGGIG(new WorldPoint(2414, 3047, 0), FELDIP_HILLS, "It's coming home"),
	FELDIP_HILLS_SW(new WorldPoint(2582, 2895, 0), FELDIP_HILLS, "It's coming home"),
	FELDIP_HILLS_GNOME_GLITER(new WorldPoint(2553, 2972, 0), FELDIP_HILLS, "It's coming home"),
	FELDIP_HILLS_RANTZ(new WorldPoint(2611, 2946, 0), FELDIP_HILLS, "It's coming home"),
	FELDIP_HILLS_SOUTH(new WorldPoint(2487, 3005, 0), FELDIP_HILLS, "It's coming home"),
	FELDIP_HILLS_RED_CHIN(new WorldPoint(2532, 2900, 0), FELDIP_HILLS, "It's coming home"),
	FELDIP_HILLS_SE(new WorldPoint(2567, 2916, 0), FELDIP_HILLS, "It's coming home"),
	FELDIP_HILLS_CW_BALLOON(new WorldPoint(2452, 3108, 0), FELDIP_HILLS, "It's coming home"),
	FREMENNIK_PROVINCE_MTN_CAMP(new WorldPoint(2804, 3672, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_RELLEKKA_HUNTER(new WorldPoint(2724, 3783, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_KELGADRIM_ENTRANCE(new WorldPoint(2719, 3688, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_SW(new WorldPoint(2605, 3648, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_LIGHTHOUSE(new WorldPoint(2589, 3598, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_ETCETERIA_CASTLE(new WorldPoint(2614, 3867, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_MISC_COURTYARD(new WorldPoint(2529, 3867, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_FREMMY_ISLES_MINE(new WorldPoint(2378, 3849, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_WEST_ISLES_MINE(new WorldPoint(2313, 3854, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_WEST_JATIZSO_ENTRANCE(new WorldPoint(2391, 3813, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_PIRATES_COVE(new WorldPoint(2210, 3814, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_ASTRAL_ALTER(new WorldPoint(2147, 3862, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_LUNAR_VILLAGE(new WorldPoint(2087, 3915, 0), FREMENNIK_PROVINCE, "It's coming home"),
	FREMENNIK_PROVINCE_LUNAR_NORTH(new WorldPoint(2106, 3949, 0), FREMENNIK_PROVINCE, "It's coming home"),
	KANDARIN_SINCLAR_MANSION(new WorldPoint(2726, 3588, 0), KANDARIN, "It's coming home"),
	KANDARIN_CATHERBY(new WorldPoint(2774, 3433, 0), KANDARIN, "It's coming home"),
	KANDARIN_GRAND_TREE(new WorldPoint(2449, 3509, 0), KANDARIN, "It's coming home"),
	KANDARIN_SEERS(new WorldPoint(2735, 3486, 0), KANDARIN, "It's coming home"),
	KANDARIN_MCGRUBORS_WOOD(new WorldPoint(2653, 3485, 0), KANDARIN, "It's coming home"),
	KANDARIN_FISHING_BUILD(new WorldPoint(2586, 3372, 0), KANDARIN, "It's coming home"),
	KANDARIN_WITCHHAVEN(new WorldPoint(2708, 3304, 0), KANDARIN, "It's coming home"),
	KANDARIN_NECRO_TOWER(new WorldPoint(2669, 3242, 0), KANDARIN, "It's coming home"),
	KANDARIN_FIGHT_ARENA(new WorldPoint(2587, 3134, 0), KANDARIN, "It's coming home"),
	KANDARIN_TREE_GNOME_VILLAGE(new WorldPoint(2526, 3160, 0), KANDARIN, "It's coming home"),
	KANDARIN_GRAVE_OF_SCORPIUS(new WorldPoint(2464, 3228, 0), KANDARIN, "It's coming home"),
	KANDARIN_KHAZARD_BATTLEFIELD(new WorldPoint(2518, 3249, 0), KANDARIN, "It's coming home"),
	KANDARIN_WEST_ARDY(new WorldPoint(2533, 3320, 0), KANDARIN, "It's coming home"),
	KANDARIN_SW_TREE_GNOME_STRONGHOLD(new WorldPoint(2411, 3431, 0), KANDARIN, "It's coming home"),
	KANDARIN_OUTPOST(new WorldPoint(2458, 3364, 0), KANDARIN, "It's coming home"),
	KANDARIN_BAXTORIAN_FALLS(new WorldPoint(2534, 3479, 0), KANDARIN, "It's coming home"),
	KANDARIN_BA_AGILITY_COURSE(new WorldPoint(2536, 3546, 0), KANDARIN, "It's coming home"),
	KARAMJA_MUSA_POINT(new WorldPoint(2914, 3168, 0), KARAMJA, "It's coming home"),
	KARAMJA_BRIMHAVEN_FRUIT_TREE(new WorldPoint(2783, 3214, 0), KARAMJA, "It's coming home"),
	KARAMJA_WEST_BRIMHAVEN(new WorldPoint(2715, 3161, 0), KARAMJA, "It's coming home"),
	KARAMJA_GLIDER(new WorldPoint(2966, 2975, 0), KARAMJA, "It's coming home"),
	KARAMJA_KHARAZI_NE(new WorldPoint(2909, 2926, 0), KARAMJA, "It's coming home"),
	KARAMJA_KHARAZI_SW(new WorldPoint(2783, 2898, 0), KARAMJA, "It's coming home"),
	KARAMJA_CRASH_ISLAND(new WorldPoint(2910, 2737, 0), KARAMJA, "It's coming home"),
	MISTHALIN_VARROCK_STONE_CIRCLE(new WorldPoint(3225, 3355, 0), MISTHALIN, "It's coming home"),
	MISTHALIN_LUMBRIDGE(new WorldPoint(3240, 3163, 0), MISTHALIN, "It's coming home"),
	MISTHALIN_LUMBRIDGE_2(new WorldPoint(3170, 3278, 0), MISTHALIN, "It's coming home"),
	MISTHALIN_GERTUDES(new WorldPoint(3158, 3421, 0), MISTHALIN, "It's coming home"),
	MISTHALIN_DRAYNOR_BANK(new WorldPoint(3096, 3235, 0), MISTHALIN, "It's coming home"),
	MISTHALIN_LUMBER_YARD(new WorldPoint(3303, 3483, 0), MISTHALIN, "It's coming home"),
	MORYTANIA_BURGH_DE_ROTT(new WorldPoint(3545, 3253, 0), MORYTANIA, "It's coming home"),
	MORYTANIA_PORT_PHASMATYS(new WorldPoint(3613, 3485, 0), MORYTANIA, "It's coming home"),
	MORYTANIA_HOLLOWS(new WorldPoint(3500, 3423, 0), MORYTANIA, "It's coming home"),
	MORYTANIA_SWAMP(new WorldPoint(3422, 3374, 0), MORYTANIA, "It's coming home"),
	MORYTANIA_HAUNTED_MINE(new WorldPoint(3441, 3259, 0), MORYTANIA, "It's coming home"),
	MORYTANIA_MAUSOLEUM(new WorldPoint(3499, 3539, 0), MORYTANIA, "It's coming home"),
	MORYTANIA_MOS_LES_HARMLESS(new WorldPoint(3744, 3041, 0), MORYTANIA, "It's coming home"),
	MORYTANIA_MOS_LES_HARMLESS_BAR(new WorldPoint(3670, 2974, 0), MORYTANIA, "It's coming home"),
	MORYTANIA_DRAGONTOOTH_NORTH(new WorldPoint(3813, 3567, 0), MORYTANIA, "It's coming home"),
	MORYTANIA_DRAGONTOOTH_SOUTH(new WorldPoint(3803, 3532, 0), MORYTANIA, "It's coming home"),
	WESTERN_PROVINCE_EAGLES_PEAK(new WorldPoint(2297, 3530, 0), WESTERN_PROVINCE, "It's coming home"),
	WESTERN_PROVINCE_PISCATORIS(new WorldPoint(2337, 3689, 0), WESTERN_PROVINCE, "It's coming home"),
	WESTERN_PROVINCE_PISCATORIS_HUNTER_AREA(new WorldPoint(2361, 3566, 0), WESTERN_PROVINCE, "It's coming home"),
	WESTERN_PROVINCE_ARANDAR(new WorldPoint(2366, 3318, 0), WESTERN_PROVINCE, "It's coming home"),
	WESTERN_PROVINCE_ELF_CAMP_EAST(new WorldPoint(2270, 3244, 0), WESTERN_PROVINCE, "It's coming home"),
	WESTERN_PROVINCE_ELF_CAMP_NW(new WorldPoint(2171, 3280, 0), WESTERN_PROVINCE, "It's coming home"),
	WESTERN_PROVINCE_LLETYA(new WorldPoint(2335, 3166, 0), WESTERN_PROVINCE, "It's coming home"),
	WESTERN_PROVINCE_TYRAS(new WorldPoint(2204, 3157, 0), WESTERN_PROVINCE, "It's coming home"),
	WESTERN_PROVINCE_ZULANDRA(new WorldPoint(2196, 3057, 0), WESTERN_PROVINCE, "It's coming home"),
	WILDERNESS_5(new WorldPoint(3169, 3558, 0), WILDERNESS, "It's coming home"),
	WILDERNESS_12(new WorldPoint(3038, 3612, 0), WILDERNESS, "It's coming home"),
	WILDERNESS_20(new WorldPoint(3225, 3676, 0), WILDERNESS, "It's coming home"),
	WILDERNESS_28(new WorldPoint(3374, 3734, 0), WILDERNESS, "It's coming home"),
	WILDERNESS_35(new WorldPoint(3153, 3795, 0), WILDERNESS, "It's coming home"),
	WILDERNESS_37(new WorldPoint(2975, 3809, 0), WILDERNESS, "It's coming home"),
	WILDERNESS_38(new WorldPoint(3294, 3817, 0), WILDERNESS, "It's coming home"),
	WILDERNESS_49(new WorldPoint(3140, 3910, 0), WILDERNESS, "It's coming home"),
	WILDERNESS_54(new WorldPoint(2983, 3946, 0), WILDERNESS, "It's coming home"),
	ZEAH_BLASTMINE_BANK(new WorldPoint(1507, 3856, 0), ZEAH, "It's coming home"),
	ZEAH_BLASTMINE_NORTH(new WorldPoint(1490, 3883, 0), ZEAH, "It's coming home"),
	ZEAH_LOVAKITE_FURNACE(new WorldPoint(1505, 3814, 0), ZEAH, "It's coming home"),
	ZEAH_LOVAKENGJ_MINE(new WorldPoint(1477, 3779, 0), ZEAH, "It's coming home"),
	ZEAH_SULPHR_MINE(new WorldPoint(1428, 3866, 0), ZEAH, "It's coming home"),
	ZEAH_SHAYZIEN_BANK(new WorldPoint(1517, 3603, 0), ZEAH, "It's coming home"),
	ZEAH_OVERPASS(new WorldPoint(1467, 3714, 0), ZEAH, "It's coming home"),
	ZEAH_LIZARDMAN(new WorldPoint(1493, 3694, 0), ZEAH, "It's coming home"),
	ZEAH_COMBAT_RING(new WorldPoint(1557, 3580, 0), ZEAH, "It's coming home"),
	ZEAH_SHAYZIEN_BANK_2(new WorldPoint(1494, 3622, 0), ZEAH, "It's coming home"),
	ZEAH_LIBRARY(new WorldPoint(1601, 3842, 0), ZEAH, "It's coming home"),
	ZEAH_HOUSECHURCH(new WorldPoint(1682, 3792, 0), ZEAH, "It's coming home"),
	ZEAH_DARK_ALTAR(new WorldPoint(1699, 3879, 0), ZEAH, "It's coming home"),
	ZEAH_ARCEUUS_HOUSE(new WorldPoint(1708, 3701, 0), ZEAH, "It's coming home"),
	ZEAH_ESSENCE_MINE(new WorldPoint(1762, 3852, 0), ZEAH, "It's coming home"),
	ZEAH_ESSENCE_MINE_NE(new WorldPoint(1772, 3866, 0), ZEAH, "It's coming home"),
	ZEAH_PISCARILUS_MINE(new WorldPoint(1768, 3705, 0), ZEAH, "It's coming home"),
	ZEAH_GOLDEN_FIELD_TAVERN(new WorldPoint(1718, 3647, 0), ZEAH, "It's coming home"),
	ZEAH_MESS_HALL(new WorldPoint(1658, 3621, 0), ZEAH, "It's coming home"),
	ZEAH_WATSONS_HOUSE(new WorldPoint(1653, 3573, 0), ZEAH, "It's coming home"),
	ZEAH_VANNAHS_FARM_STORE(new WorldPoint(1806, 3521, 0), ZEAH, "It's coming home");

	private final WorldPoint worldPoint;
	private final HotColdArea hotColdArea;
	private final String area;

	public Rectangle2D getRect()
	{
		return new Rectangle(worldPoint.getX() - 4, worldPoint.getY() - 4, 9, 9);
	}
}
