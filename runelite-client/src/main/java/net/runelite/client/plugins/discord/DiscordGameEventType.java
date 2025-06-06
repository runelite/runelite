/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, PandahRS <https://github.com/PandahRS>
 * Copyright (c) 2020, Brooklyn <https://github.com/Broooklyn>
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
package net.runelite.client.plugins.discord;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;

@AllArgsConstructor
@Getter
enum DiscordGameEventType
{

	IN_MENU("In Menu", -3, true, true, true, false),
	IN_GAME("In Game", -3, true, false, false, false),
	PLAYING_DEADMAN("Playing Deadman Mode", -3),
	PLAYING_PVP("Playing in a PVP world", -3),
	TRAINING_ATTACK(Skill.ATTACK),
	TRAINING_DEFENCE(Skill.DEFENCE),
	TRAINING_STRENGTH(Skill.STRENGTH),
	TRAINING_HITPOINTS(Skill.HITPOINTS, -1),
	TRAINING_SLAYER(Skill.SLAYER, 1),
	TRAINING_RANGED(Skill.RANGED),
	TRAINING_MAGIC(Skill.MAGIC),
	TRAINING_PRAYER(Skill.PRAYER),
	TRAINING_COOKING(Skill.COOKING),
	TRAINING_WOODCUTTING(Skill.WOODCUTTING),
	TRAINING_FLETCHING(Skill.FLETCHING),
	TRAINING_FISHING(Skill.FISHING, 1),
	TRAINING_FIREMAKING(Skill.FIREMAKING),
	TRAINING_CRAFTING(Skill.CRAFTING),
	TRAINING_SMITHING(Skill.SMITHING),
	TRAINING_MINING(Skill.MINING),
	TRAINING_HERBLORE(Skill.HERBLORE),
	TRAINING_AGILITY(Skill.AGILITY),
	TRAINING_THIEVING(Skill.THIEVING),
	TRAINING_FARMING(Skill.FARMING),
	TRAINING_RUNECRAFT(Skill.RUNECRAFT),
	TRAINING_HUNTER(Skill.HUNTER),
	TRAINING_CONSTRUCTION(Skill.CONSTRUCTION),

	// Bosses
	BOSS_ABYSSAL_SIRE("Abyssal Sire", DiscordAreaType.BOSSES, 11851, 11850, 12363, 12362),
	BOSS_ARAXXOR("Araxxor", DiscordAreaType.BOSSES, 14489),
	BOSS_CERBERUS("Cerberus", DiscordAreaType.BOSSES, 4883, 5140, 5395),
	BOSS_COMMANDER_ZILYANA("Commander Zilyana", DiscordAreaType.BOSSES, 11602),
	BOSS_CORP("Corporeal Beast", DiscordAreaType.BOSSES, 11842, 11844),
	BOSS_DKS("Dagannoth Kings", DiscordAreaType.BOSSES, 11588, 11589),
	BOSS_DUKE_SUCELLUS("Duke Sucellus", DiscordAreaType.BOSSES, 12132),
	BOSS_GENERAL_GRAARDOR("General Graardor", DiscordAreaType.BOSSES, 11347),
	BOSS_GIANT_MOLE("Giant Mole", DiscordAreaType.BOSSES, 6993, 6992),
	BOSS_GROTESQUE_GUARDIANS("Grotesque Guardians", DiscordAreaType.BOSSES, 6727),
	BOSS_HESPORI("Hespori", DiscordAreaType.BOSSES, 5021),
	BOSS_HYDRA("Alchemical Hydra", DiscordAreaType.BOSSES, 5536),
	BOSS_KQ("Kalphite Queen", DiscordAreaType.BOSSES, 13972),
	BOSS_KRAKEN("Kraken", DiscordAreaType.BOSSES, 9116),
	BOSS_KREEARRA("Kree'arra", DiscordAreaType.BOSSES, 11346),
	BOSS_KRIL_TSUTSAROTH("K'ril Tsutsaroth", DiscordAreaType.BOSSES, 11603),
	BOSS_NEX("Nex", DiscordAreaType.BOSSES, 11601),
	BOSS_NIGHTMARE("Nightmare of Ashihama", DiscordAreaType.BOSSES, 15515),
	BOSS_PHANTOM_MUSPAH("Phantom Muspah", DiscordAreaType.BOSSES, 11330),
	BOSS_SARACHNIS("Sarachnis", DiscordAreaType.BOSSES, 7322),
	BOSS_SKOTIZO("Skotizo", DiscordAreaType.BOSSES, 9048),
	BOSS_SMOKE_DEVIL("Thermonuclear smoke devil", DiscordAreaType.BOSSES, 9363, 9619),
	BOSS_TEMPOROSS("Tempoross", DiscordAreaType.BOSSES, 12078),
	BOSS_THE_LEVIATHAN("The Leviathan", DiscordAreaType.BOSSES, 8291),
	BOSS_THE_ROYAL_TITANS("The Royal Titans", DiscordAreaType.BOSSES, 11669),
	BOSS_THE_WHISPERER("The Whisperer", DiscordAreaType.BOSSES, 10595),
	BOSS_VARDORVIS("Vardorvis", DiscordAreaType.BOSSES, 4405),
	BOSS_VORKATH("Vorkath", DiscordAreaType.BOSSES, 9023),
	BOSS_WINTERTODT("Wintertodt", DiscordAreaType.BOSSES, 6462),
	BOSS_YAMA("Yama", DiscordAreaType.BOSSES, 6045),
	BOSS_ZALCANO("Zalcano", DiscordAreaType.BOSSES, 12126),
	BOSS_ZULRAH("Zulrah", DiscordAreaType.BOSSES, 9007),

	// Cities
	CITY_AL_KHARID("Al Kharid" , DiscordAreaType.CITIES, 13105, 13106),
	CITY_ARCEUUS_HOUSE("Arceuus" , DiscordAreaType.CITIES, 6458, 6459, 6460, 6714, 6715),
	CITY_ARDOUGNE("Ardougne" , DiscordAreaType.CITIES, 9779, 9780, 10035, 10036, 10291, 10292, 10547, 10548),
	CITY_BANDIT_CAMP("Bandit Camp" , DiscordAreaType.CITIES, 12590),
	CITY_BARBARIAN_OUTPOST("Barbarian Outpost", DiscordAreaType.CITIES, 10039),
	CITY_BARBARIAN_VILLAGE("Barbarian Village" , DiscordAreaType.CITIES, 12341),
	CITY_BEDABIN_CAMP("Bedabin Camp" , DiscordAreaType.CITIES, 12591),
	CITY_BRIMHAVEN("Brimhaven" , DiscordAreaType.CITIES, 11057, 11058),
	CITY_BURGH_DE_ROTT("Burgh de Rott" , DiscordAreaType.CITIES, 13874, 13873, 14130, 14129),
	CITY_BURTHORPE("Burthorpe" , DiscordAreaType.CITIES, 11319, 11575),
	CITY_CAM_TORUM("Cam Torum" , DiscordAreaType.CITIES, 5525, 5780, 5781, 6037),
	CITY_CANIFIS("Canifis" , DiscordAreaType.CITIES, 13878),
	CITY_CATHERBY("Catherby" , DiscordAreaType.CITIES, 11317, 11318, 11061),
	CITY_CIVITAS_ILLA_FORTIS("Civitas Illa Fortis" , DiscordAreaType.CITIES, 6448, 6449, 6704, 6705, 6960, 6961),
	CITY_CORSAIR_COVE("Corsair Cove" , DiscordAreaType.CITIES, 10028, 10284),
	CITY_DARKMEYER("Darkmeyer", DiscordAreaType.CITIES, 14388, 14644),
	CITY_DORGESH_KAAN("Dorgesh-Kaan" , DiscordAreaType.CITIES, 10835, 10834),
	CITY_DRAYNOR("Draynor" , DiscordAreaType.CITIES, 12338, 12339),
	CITY_EDGEVILLE("Edgeville" , DiscordAreaType.CITIES, 12342),
	CITY_ENTRANA("Entrana" , DiscordAreaType.CITIES, 11060, 11316),
	CITY_ETCETERIA("Etceteria", DiscordAreaType.CITIES, 10300),
	CITY_FALADOR("Falador" , DiscordAreaType.CITIES, 11828, 11572, 11827, 12084),
	CITY_GUTANOTH("Gu'Tanoth" , DiscordAreaType.CITIES, 10031),
	CITY_GWENITH("Gwenith", DiscordAreaType.CITIES, 8757),
	CITY_HOSIDIUS_HOUSE("Hosidius" , DiscordAreaType.CITIES, 6710, 6711, 6712, 6455, 6456, 6966, 6967, 6968, 7221, 7223, 7224, 7478, 7479),
	CITY_JATIZSO("Jatizso" , DiscordAreaType.CITIES, 9531),
	CITY_KELDAGRIM("Keldagrim" , DiscordAreaType.CITIES, 11423, 11422, 11679, 11678),
	CITY_LANDS_END("Land's End", DiscordAreaType.CITIES, 5941),
	CITY_LASSAR_UNDERCITY("Lassar Undercity", DiscordAreaType.CITIES, 9314, 9315, 9316, 9571, 9572, 9828, 10338, 10339, 10340, 10596, 10852),
	CITY_LLETYA("Lletya" , DiscordAreaType.CITIES, 9265, 11103),
	CITY_LOVAKENGJ_HOUSE("Lovakengj" , DiscordAreaType.CITIES, 5692, 5691, 5947, 6203, 6202, 5690, 5946),
	CITY_LUMBRIDGE("Lumbridge" , DiscordAreaType.CITIES, 12850),
	CITY_LUNAR_ISLE("Lunar Isle" , DiscordAreaType.CITIES, 8253, 8252, 8509, 8508),
	CITY_MARIM("Marim", DiscordAreaType.REGIONS, 11051),
	CITY_MEIYERDITCH("Meiyerditch" , DiscordAreaType.CITIES, 14132, 14387, 14386, 14385),
	CITY_MENAPHOS("Menaphos", DiscordAreaType.CITIES, 12843),
	CITY_MISCELLANIA("Miscellania" , DiscordAreaType.CITIES, 10044),
	CITY_MOR_UL_REK("Mor Ul Rek" , DiscordAreaType.CITIES, 9808, 9807, 10064, 10063),
	CITY_MORTTON("Mort'ton" , DiscordAreaType.CITIES, 13875),
	CITY_MOS_LE_HARMLESS("Mos Le'Harmless" , DiscordAreaType.CITIES, 14637, 14638, 14639, 14894, 14895, 15151, 15406, 15407),
	CITY_MOUNT_KARUULM("Mount Karuulm", DiscordAreaType.CITIES, 5179, 4923, 5180),
	CITY_MOUNTAIN_CAMP("Mountain Camp", DiscordAreaType.CITIES, 11065),
	CITY_MYNYDD("Mynydd", DiscordAreaType.CITIES, 8501),
	CITY_NARDAH("Nardah" , DiscordAreaType.CITIES, 13613),
	CITY_NEITIZNOT("Neitiznot" , DiscordAreaType.CITIES, 9275),
	CITY_PISCARILIUS_HOUSE("Port Piscarilius" , DiscordAreaType.CITIES, 6969, 6971, 7227, 6970, 7225, 7226),
	CITY_PISCATORIS("Piscatoris" , DiscordAreaType.CITIES, 9273),
	CITY_POLLNIVNEACH("Pollnivneach" , DiscordAreaType.CITIES, 13358),
	CITY_PORT_KHAZARD("Port Khazard" , DiscordAreaType.CITIES, 10545),
	CITY_PORT_PHASMATYS("Port Phasmatys" , DiscordAreaType.CITIES, 14646),
	CITY_PORT_SARIM("Port Sarim" , DiscordAreaType.CITIES, 12081, 12082),
	CITY_PRIFDDINAS("Prifddinas", DiscordAreaType.CITIES, 8499, 8500, 8755, 8756, 9011, 9012, 9013, 12894, 12895, 13150, 13151),
	CITY_RELLEKKA("Rellekka" , DiscordAreaType.CITIES, 10297, 10553),
	CITY_RIMMINGTON("Rimmington" , DiscordAreaType.CITIES, 11826, 11570),
	CITY_SEERS_VILLAGE("Seers' Village" , DiscordAreaType.CITIES, 10806),
	CITY_SHAYZIEN_HOUSE("Shayzien" , DiscordAreaType.CITIES, 5944, 5943, 6200, 6199, 5686, 5687, 5688, 5689, 5945),
	CITY_SHILO_VILLAGE("Shilo Village" , DiscordAreaType.CITIES, 11310),
	CITY_SLEPE("Slepe", DiscordAreaType.CITIES, 14643, 14899, 14900, 14901),
	CITY_SOPHANEM("Sophanem" , DiscordAreaType.CITIES, 13099),
	CITY_TAI_BWO_WANNAI("Tai Bwo Wannai" , DiscordAreaType.CITIES, 11056, 11055),
	CITY_TAVERLEY("Taverley" , DiscordAreaType.CITIES, 11574, 11573),
	CITY_TREE_GNOME_STRONGHOLD("Tree Gnome Stronghold" , DiscordAreaType.CITIES, 9525, 9526, 9782, 9781),
	CITY_TREE_GNOME_VILLAGE("Tree Gnome Village" , DiscordAreaType.CITIES, 10033),
	CITY_TROLL_STRONGHOLD("Troll Stronghold" , DiscordAreaType.CITIES, 11321, 11421),
	CITY_UZER("Uzer" , DiscordAreaType.CITIES, 13872),
	CITY_UZER_OASIS("Uzer Oasis", DiscordAreaType.CITIES, 13871),
	CITY_VARROCK("Varrock" , DiscordAreaType.CITIES, 12596, 12597, 12852, 12853, 12854, 13108, 13109, 13110),
	CITY_VER_SINHAZA("Ver Sinhaza", DiscordAreaType.CITIES, 14642),
	CITY_VOID_OUTPOST("Void Knights' Outpost", DiscordAreaType.CITIES, 10537),
	CITY_WEISS("Weiss", DiscordAreaType.CITIES, 11325, 11581),
	CITY_WITCHHAVEN("Witchaven" , DiscordAreaType.CITIES, 10803),
	CITY_YANILLE("Yanille" , DiscordAreaType.CITIES, 10288, 10032),
	CITY_ZANARIS("Zanaris" , DiscordAreaType.CITIES, 9285, 9541, 9540, 9797),
	CITY_ZULANDRA("Zul-Andra" , DiscordAreaType.CITIES, 8495, 8751),

	// Dungeons
	DUNGEON_ABANDONED_MINE("Abandoned Mine", DiscordAreaType.DUNGEONS, 13618, 13718, 11079, 11078, 11077, 10823, 10822, 10821),
	DUNGEON_AH_ZA_RHOON("Ah Za Rhoon", DiscordAreaType.DUNGEONS, 11666),
	DUNGEON_ANCIENT_CAVERN("Ancient Cavern", DiscordAreaType.DUNGEONS, 6483, 6995),
	DUNGEON_APE_ATOLL("Ape Atoll Dungeon", DiscordAreaType.DUNGEONS, 11150, 10894),
	DUNGEON_APE_ATOLL_BANANA_PLANTATION("Ape Atoll Banana Plantation", DiscordAreaType.DUNGEONS, 10895),
	DUNGEON_ARDY_BASEMENT("West Ardougne Basement", DiscordAreaType.DUNGEONS, 10135),
	DUNGEON_ARDY_SEWERS("Ardougne Sewers", DiscordAreaType.DUNGEONS, 10134, 10136, 10391, 10647),
	DUNGEON_ASGARNIAN_ICE_CAVES("Asgarnian Ice Caves", DiscordAreaType.DUNGEONS, 11925, 12181),
	DUNGEON_BERVIRIUS_TOMB("Tomb of Bervirius", DiscordAreaType.DUNGEONS, 11154),
	DUNGEON_BRIMHAVEN("Brimhaven Dungeon", DiscordAreaType.DUNGEONS, 10901, 10900, 10899, 10645, 10644, 10643),
	DUNGEON_BRINE_RAT_CAVERN("Brine Rat Cavern", DiscordAreaType.DUNGEONS, 10910),
	DUNGEON_CATACOMBS_OF_KOUREND("Catacombs of Kourend", DiscordAreaType.DUNGEONS, 6557, 6556, 6813, 6812),
	DUNGEON_CHAMPIONS_CHALLENGE("Champions' Challenge", DiscordAreaType.DUNGEONS, 12696),
	DUNGEON_CHAOS_DRUID_TOWER("Chaos Druid Tower", DiscordAreaType.DUNGEONS, 10392),
	DUNGEON_CHASM_OF_FIRE("Chasm of Fire", DiscordAreaType.DUNGEONS, 5789),
	DUNGEON_CHASM_OF_TEARS("Chasm of Tears", DiscordAreaType.DUNGEONS, 12948),
	DUNGEON_CHINCHOMPA("Chinchompa Hunting Ground", DiscordAreaType.DUNGEONS, 10129),
	DUNGEON_CIVITAS_ILLA_FORTIS("Civitas illa Fortis Underground", DiscordAreaType.DUNGEONS, 6549, 6804, 6805),
	DUNGEON_CLOCK_TOWER("Clock Tower Basement", DiscordAreaType.DUNGEONS, 10390),
	DUNGEON_CORSAIR_COVE("Corsair Cove Dungeon", DiscordAreaType.DUNGEONS, 8076, 8332),
	DUNGEON_CRABCLAW_CAVES("Crabclaw Caves", DiscordAreaType.DUNGEONS, 6553, 6809),
	DUNGEON_CRANDOR("Crandor Dungeon", DiscordAreaType.DUNGEONS, 11414),
	DUNGEON_CRASH_SITE_CAVERN("Crash Site Cavern", DiscordAreaType.DUNGEONS, 8280, 8536),
	DUNGEON_CRUMBLING_TOWER("Crumbling Tower", DiscordAreaType.DUNGEONS, 7827),
	DUNGEON_DAEYALT_ESSENCE_MINE("Daeyalt Essence Mine", DiscordAreaType.DUNGEONS, 14744),
	DUNGEON_DIGSITE("Digsite Dungeon", DiscordAreaType.DUNGEONS, 13464, 13465),
	DUNGEON_DORGESHKAAN("Dorgesh-Kaan South Dungeon", DiscordAreaType.DUNGEONS, 10833),
	DUNGEON_DORGESHUUN_MINES("Dorgeshuun Mines", DiscordAreaType.DUNGEONS, 12950, 13206),
	DUNGEON_DRAYNOR_SEWERS("Draynor Sewers", DiscordAreaType.DUNGEONS, 12439, 12438),
	DUNGEON_DWARVEN_MINES("Dwarven Mines", DiscordAreaType.DUNGEONS, 12185, 12184, 12183),
	DUNGEON_EAGLES_PEAK("Eagles' Peak Dungeon", DiscordAreaType.DUNGEONS, 8013),
	DUNGEON_ECTOFUNTUS("Ectofuntus", DiscordAreaType.DUNGEONS, 14746),
	DUNGEON_EDGEVILLE("Edgeville Dungeon", DiscordAreaType.DUNGEONS, 12441, 12442, 12443, 12698),
	DUNGEON_ELEMENTAL_WORKSHOP("Elemental Workshop", DiscordAreaType.DUNGEONS, 10906, 7760),
	DUNGEON_ELVEN_RABBIT_CAVE("Elven rabbit cave", DiscordAreaType.DUNGEONS, 13252),
	DUNGEON_ENAKHRAS_TEMPLE("Enakhra's Temple", DiscordAreaType.DUNGEONS, 12423),
	DUNGEON_EVIL_CHICKENS_LAIR("Evil Chicken's Lair", DiscordAreaType.DUNGEONS, 9796),
	DUNGEON_EXPERIMENT_CAVE("Experiment Cave", DiscordAreaType.DUNGEONS, 14235, 13979),
	DUNGEON_FEROX_ENCLAVE("Ferox Enclave Dungeon", DiscordAreaType.DUNGEONS, 12700),
	DUNGEON_FORTHOS("Forthos Dungeon", DiscordAreaType.DUNGEONS, 7323),
	DUNGEON_FREMENNIK_SLAYER("Fremennik Slayer Dungeon", DiscordAreaType.DUNGEONS, 10907, 10908, 11164),
	DUNGEON_GLARIALS_TOMB("Glarial's Tomb", DiscordAreaType.DUNGEONS, 10137),
	DUNGEON_GOBLIN_CAVE("Goblin Cave", DiscordAreaType.DUNGEONS, 10393),
	DUNGEON_GRAND_TREE_TUNNELS("Grand Tree Tunnels", DiscordAreaType.DUNGEONS, 9882),
	DUNGEON_HAM_HIDEOUT("H.A.M. Hideout", DiscordAreaType.DUNGEONS, 12694),
	DUNGEON_HAM_STORE_ROOM("H.A.M. Store room", DiscordAreaType.DUNGEONS, 10321),
	DUNGEON_HEROES_GUILD("Heroes' Guild Mine", DiscordAreaType.DUNGEONS, 11674),
	DUNGEON_IORWERTH("Iorwerth Dungeon", DiscordAreaType.DUNGEONS, 12737, 12738, 12993, 12994),
	DUNGEON_ISLE_OF_SOULS("Isle of Souls Dungeon", DiscordAreaType.DUNGEONS, 8593),
	DUNGEON_JATIZSO_MINES("Jatizso Mines", DiscordAreaType.DUNGEONS, 9631),
	DUNGEON_JIGGIG_BURIAL_TOMB("Jiggig Burial Tomb", DiscordAreaType.DUNGEONS, 9875, 9874),
	DUNGEON_JOGRE("Jogre Dungeon", DiscordAreaType.DUNGEONS, 11412),
	DUNGEON_KARAMJA("Karamja Dungeon", DiscordAreaType.DUNGEONS, 11413),
	DUNGEON_KARUULM("Karuulm Slayer Dungeon", DiscordAreaType.DUNGEONS, 5280, 5279, 5023, 5535, 5022, 4766, 4510, 4511, 4767, 4768, 4512),
	DUNGEON_KGP_HEADQUARTERS("KGP Headquarters", DiscordAreaType.DUNGEONS, 10658),
	DUNGEON_KRUK("Kruk's Dungeon", DiscordAreaType.DUNGEONS, 9358, 9359, 9360, 9615, 9616, 9871, 10125, 10126, 10127, 10128, 10381, 10382, 10383, 10384, 10637, 10638, 10639, 10640),
	DUNGEON_LEGENDS_GUILD("Legends' Guild Dungeon", DiscordAreaType.DUNGEONS, 10904),
	DUNGEON_LIGHTHOUSE("Lighthouse", DiscordAreaType.DUNGEONS, 10140),
	DUNGEON_LIZARDMAN_CAVES("Lizardman Caves", DiscordAreaType.DUNGEONS, 5275),
	DUNGEON_LIZARDMAN_TEMPLE("Lizardman Temple", DiscordAreaType.DUNGEONS, 5277),
	DUNGEON_LUMBRIDGE_SWAMP_CAVES("Lumbridge Swamp Caves", DiscordAreaType.DUNGEONS, 12693, 12949),
	DUNGEON_LUNAR_ISLE_MINE("Lunar Isle Mine", DiscordAreaType.DUNGEONS, 9377),
	DUNGEON_MANIACAL_HUNTER("Maniacal Monkey Hunter Area", DiscordAreaType.DUNGEONS, 11662),
	DUNGEON_MEIYERDITCH_MINE("Meiyerditch Mine", DiscordAreaType.DUNGEONS, 9544),
	DUNGEON_MISCELLANIA("Miscellania Dungeon", DiscordAreaType.DUNGEONS, 10144, 10400),
	DUNGEON_MOGRE_CAMP("Mogre Camp", DiscordAreaType.DUNGEONS, 11924),
	DUNGEON_MOS_LE_HARMLESS_CAVES("Mos Le'Harmless Caves", DiscordAreaType.DUNGEONS, 14994, 14995, 15251),
	DUNGEON_MOTHERLODE_MINE("Motherlode Mine", DiscordAreaType.DUNGEONS, 14679, 14680, 14681, 14935, 14936, 14937, 15191, 15192, 15193),
	DUNGEON_MOURNER_TUNNELS("Mourner Tunnels", DiscordAreaType.DUNGEONS, 7752, 8008),
	DUNGEON_MOUSE_HOLE("Mouse Hole", DiscordAreaType.DUNGEONS, 9046),
	DUNGEON_MEIYERDITCH_LABORATORIES("Meiyerditch Laboratories", DiscordAreaType.DUNGEONS, 14232, 14233, 14487, 14488),
	DUNGEON_MYREQUE("Myreque Hideout", DiscordAreaType.DUNGEONS, 13721, 13974, 13977, 13978),
	DUNGEON_MYTHS_GUILD("Myths' Guild Dungeon", DiscordAreaType.DUNGEONS, 7564, 7820, 7821),
	DUNGEON_OBSERVATORY("Observatory Dungeon", DiscordAreaType.DUNGEONS, 9362),
	DUNGEON_OGRE_ENCLAVE("Ogre Enclave", DiscordAreaType.DUNGEONS, 10387),
	DUNGEON_OURANIA("Ourania Cave", DiscordAreaType.DUNGEONS, 12119),
	DUNGEON_QUIDAMORTEM_CAVE("Quidamortem Cave", DiscordAreaType.DUNGEONS, 4763),
	DUNGEON_RASHILIYIAS_TOMB("Rashiliyta's Tomb", DiscordAreaType.DUNGEONS, 11668),
	DUNGEON_RUINS_OF_CAMDOZAAL("Ruins of Camdozaal", DiscordAreaType.DUNGEONS, 11609, 11610, 11611, 11865, 11866, 11867, 12121, 12122, 12123),
	DUNGEON_SALT_MINE("Salt Mine", DiscordAreaType.DUNGEONS, 11425),
	DUNGEON_SARADOMINSHRINE("Saradomin Shrine (Paterdomus)", DiscordAreaType.DUNGEONS, 13722),
	DUNGEON_SHADE_CATACOMBS("Shade Catacombs", DiscordAreaType.DUNGEONS, 13975),
	DUNGEON_SHADOW("Shadow Dungeon", DiscordAreaType.DUNGEONS, 10575, 10831),
	DUNGEON_SHAYZIEN_CRYPTS("Shayzien Crypts", DiscordAreaType.DUNGEONS, 6043),
	DUNGEON_SISTERHOOD_SANCTUARY("Sisterhood Sanctuary", DiscordAreaType.DUNGEONS, 14999, 15000, 15001, 15255, 15256, 15257, 15511, 15512, 15513),
	DUNGEON_SMOKE("Smoke Dungeon", DiscordAreaType.DUNGEONS, 12946, 13202),
	DUNGEON_SOPHANEM("Sophanem Dungeon", DiscordAreaType.DUNGEONS, 13200),
	DUNGEON_SOURHOG_CAVE("Sourhog Cave", DiscordAreaType.DUNGEONS, 12695),
	DUNGEON_STRONGHOLD_SECURITY("Stronghold of Security", DiscordAreaType.DUNGEONS, 7505, 8017, 8530, 9297),
	DUNGEON_STRONGHOLD_SLAYER("Stronghold Slayer Cave", DiscordAreaType.DUNGEONS, 9624, 9625, 9880, 9881),
	DUNGEON_TARNS_LAIR("Tarn's Lair", DiscordAreaType.DUNGEONS, 12616, 12615),
	DUNGEON_TAVERLEY("Taverley Dungeon", DiscordAreaType.DUNGEONS, 11416, 11417, 11671, 11672, 11673, 11928, 11929),
	DUNGEON_TEMPLE_OF_IKOV("Temple of Ikov", DiscordAreaType.DUNGEONS, 10649, 10905, 10650),
	DUNGEON_TEMPLE_OF_LIGHT("Temple of Light", DiscordAreaType.DUNGEONS, 7496),
	DUNGEON_TEMPLE_OF_MARIMBO("Temple of Marimbo", DiscordAreaType.DUNGEONS, 11151),
	DUNGEON_THE_BURROW("The Burrow", DiscordAreaType.DUNGEONS, 6291),
	DUNGEON_THE_WARRENS("The Warrens", DiscordAreaType.DUNGEONS, 7070, 7326),
	DUNGEON_TOLNA("Dungeon of Tolna", DiscordAreaType.DUNGEONS, 13209),
	DUNGEON_TOWER_OF_LIFE("Tower of Life Basement", DiscordAreaType.DUNGEONS, 12100),
	DUNGEON_TRAHAEARN_MINE("Trahaearn Mine", DiscordAreaType.DUNGEONS, 13250),
	DUNGEON_TUNNEL_OF_CHAOS("Tunnel of Chaos", DiscordAreaType.DUNGEONS, 12625),
	DUNGEON_UNDERGROUND_PASS("Underground Pass", DiscordAreaType.DUNGEONS, 9369, 9370),
	DUNGEON_VARROCKSEWERS("Varrock Sewers", DiscordAreaType.DUNGEONS, 12954, 13210),
	DUNGEON_VIYELDI_CAVES("Viyeldi Caves", DiscordAreaType.DUNGEONS, 9545, 11153),
	DUNGEON_WARRIORS_GUILD("Warriors' Guild Basement", DiscordAreaType.DUNGEONS, 11675),
	DUNGEON_WATER_RAVINE("Water Ravine", DiscordAreaType.DUNGEONS, 13461),
	DUNGEON_WATERBIRTH("Waterbirth Dungeon", DiscordAreaType.DUNGEONS, 9886, 10142, 7492, 7748),
	DUNGEON_WATERFALL("Waterfall Dungeon", DiscordAreaType.DUNGEONS, 10394),
	DUNGEON_WEREWOLF_AGILITY("Werewolf Agility Course", DiscordAreaType.DUNGEONS, 14234),
	DUNGEON_WHITE_WOLF_MOUNTAIN_CAVES("White Wolf Mountain Caves", DiscordAreaType.DUNGEONS, 11418, 11419),
	DUNGEON_WITCHAVEN_SHRINE("Witchhaven Shrine Dungeon", DiscordAreaType.DUNGEONS, 10903),
	DUNGEON_WIZARDS_TOWER("Wizards' Tower Basement", DiscordAreaType.DUNGEONS, 12437),
	DUNGEON_WOODCUTTING_GUILD("Woodcutting Guild Dungeon", DiscordAreaType.DUNGEONS, 6298),
	DUNGEON_WYVERN_CAVE("Wyvern Cave", DiscordAreaType.DUNGEONS, 14495, 14496),
	DUNGEON_YANILLE_AGILITY("Yanille Agility Dungeon", DiscordAreaType.DUNGEONS, 10388),

	// Minigames
	MG_ARDOUGNE_RAT_PITS("Ardougne Rat Pits", DiscordAreaType.MINIGAMES, 10646),
	MG_BARBARIAN_ASSAULT("Barbarian Assault", DiscordAreaType.MINIGAMES, 7508, 7509, 10322),
	MG_BARROWS("Barrows", DiscordAreaType.MINIGAMES, 14131, 14231),
	MG_BLAST_FURNACE("Blast Furnace", DiscordAreaType.MINIGAMES, 7757),
	MG_BRIMHAVEN_AGILITY_ARENA("Brimhaven Agility Arena", DiscordAreaType.MINIGAMES, 11157),
	MG_BURTHORPE_GAMES_ROOM("Burthorpe Games Room", DiscordAreaType.MINIGAMES, 8781),
	MG_CASTLE_WARS("Castle Wars", DiscordAreaType.MINIGAMES, 9520, 9620),
	MG_CLAN_WARS("Clan Wars", DiscordAreaType.MINIGAMES, 12621, 12622, 12623, 13130, 13131, 13133, 13134, 13135, 13386, 13387, 13390, 13641, 13642, 13643, 13644, 13645, 13646, 13647, 13899, 13900, 14155, 14156),
	MG_PVP_ARENA("PvP Arena", DiscordAreaType.MINIGAMES, 13362, 13363),
	MG_FISHING_TRAWLER("Fishing Trawler", DiscordAreaType.MINIGAMES, 7499),
	MG_FORTIS_COLOSSEUM("Fortis Colosseum", DiscordAreaType.MINIGAMES, 7216),
	MG_FORTIS_COLOSSEUM_LOBBY("Fortis Colosseum Lobby", DiscordAreaType.MINIGAMES, 7316),
	MG_GAUNTLET("The Gauntlet", DiscordAreaType.MINIGAMES, 12127, 7512),
	MG_CORRUPTED_GAUNTLET("Corrupted Gauntlet", DiscordAreaType.MINIGAMES, 7768),
	MG_GIANTS_FOUNDRY("Giants' Foundry", DiscordAreaType.MINIGAMES, 13491),
	MG_GUARDIANS_OF_THE_RIFT("Guardians of the Rift", DiscordAreaType.MINIGAMES, 14484),
	MG_HALLOWED_SEPULCHRE("Hallowed Sepulchre", DiscordAreaType.MINIGAMES, 8797, 9051, 9052, 9053, 9054, 9309, 9563, 9565, 9821, 10074, 10075, 10077),
	MG_INFERNO("The Inferno", DiscordAreaType.MINIGAMES, 9043),
	MG_KELDAGRIM_RAT_PITS("Keldagrim Rat Pits", DiscordAreaType.MINIGAMES, 7753),
	MG_LAST_MAN_STANDING_DESERTED_ISLAND("LMS - Deserted Island", DiscordAreaType.MINIGAMES, 13658, 13659, 13660, 13914, 13915, 13916),
	MG_LAST_MAN_STANDING_WILD_VARROCK("LMS - Wild Varrock", DiscordAreaType.MINIGAMES, 13918, 13919, 13920, 14174, 14175, 14176, 14430, 14431, 14432),
	MG_MAGE_TRAINING_ARENA("Mage Training Arena", DiscordAreaType.MINIGAMES, 13462, 13463),
	MG_NIGHTMARE_ZONE("Nightmare Zone", DiscordAreaType.MINIGAMES, 9033),
	MG_PEST_CONTROL("Pest Control", DiscordAreaType.MINIGAMES, 10536),
	MG_PORT_SARIM_RAT_PITS("Port Sarim Rat Pits", DiscordAreaType.MINIGAMES, 11926),
	MG_PYRAMID_PLUNDER("Pyramid Plunder", DiscordAreaType.MINIGAMES, 7749),
	MG_ROGUES_DEN("Rogues' Den", DiscordAreaType.MINIGAMES, 11854, 11855, 12109, 12110, 12111),
	MG_SORCERESS_GARDEN("Sorceress's Garden", DiscordAreaType.MINIGAMES, 11605),
	MG_SOUL_WARS("Soul Wars", DiscordAreaType.MINIGAMES, 8493, 8748, 8749, 9005),
	MG_TEMPLE_TREKKING("Temple Trekking", DiscordAreaType.MINIGAMES, 8014, 8270, 8256, 8782, 9038, 9294, 9550, 9806),
	MG_TITHE_FARM("Tithe Farm", DiscordAreaType.MINIGAMES, 7222),
	MG_TROUBLE_BREWING("Trouble Brewing", DiscordAreaType.MINIGAMES, 15150),
	MG_TZHAAR_FIGHT_CAVES("Tzhaar Fight Caves", DiscordAreaType.MINIGAMES, 9551),
	MG_TZHAAR_FIGHT_PITS("Tzhaar Fight Pits", DiscordAreaType.MINIGAMES, 9552),
	MG_VARROCK_RAT_PITS("Varrock Rat Pits", DiscordAreaType.MINIGAMES, 11599),
	MG_VOLCANIC_MINE("Volcanic Mine", DiscordAreaType.MINIGAMES, 15263, 15262),

	// Raids
	RAIDS_CHAMBERS_OF_XERIC("Chambers of Xeric", DiscordAreaType.RAIDS, 12889, 13136, 13137, 13138, 13139, 13140, 13141, 13145, 13393, 13394, 13395, 13396, 13397, 13401),
	RAIDS_THEATRE_OF_BLOOD("Theatre of Blood", DiscordAreaType.RAIDS, 12611, 12612, 12613, 12867, 12869, 13122, 13123, 13125, 13379),
	RAIDS_TOMBS_OF_AMASCUT("Tombs of Amascut", DiscordAreaType.RAIDS, 14160, 14162, 14164, 14674, 14676, 15184, 15186, 15188, 15696, 15698, 15700),
	RAIDS_JALTEVAS_PYRAMID("Jaltevas Pyramid", DiscordAreaType.RAIDS, 13454),
	RAIDS_OSMUMTENS_BURIAL_CHAMBER("Osmumten's Burial Chamber", DiscordAreaType.RAIDS, 14672),

	// Other
	REGION_ABYSSAL_AREA("Abyssal Area", DiscordAreaType.REGIONS, 12108),
	REGION_ABYSSAL_NEXUS("Abyssal Nexus", DiscordAreaType.REGIONS, 12106),
	REGION_AGILITY_PYRAMID("Agility Pyramid", DiscordAreaType.REGIONS, 12105, 13356),
	REGION_AIR_ALTAR("Air Altar", DiscordAreaType.REGIONS, 11339),
	REGION_AL_KHARID_MINE("Al Kharid Mine", DiscordAreaType.REGIONS, 13107),
	REGION_ANCIENT_VAULT("Ancient Vault", DiscordAreaType.REGIONS, 12644, 13156),
	REGION_APE_ATOLL("Ape Atoll" , DiscordAreaType.REGIONS, 10794, 10795, 10974, 11050),
	REGION_ARANDAR("Arandar", DiscordAreaType.REGIONS, 9266, 9267, 9523),
	REGION_ASGARNIA("Asgarnia", DiscordAreaType.REGIONS, 11825, 11829, 11830, 12085, 12086),
	REGION_AVIUM_SAVANNAH("Avium Savannah", DiscordAreaType.REGIONS, 5935, 5936, 5937, 6189, 6445, 6446, 6447, 6701, 6702, 6703, 6957, 6958, 6959, 7215),
	REGION_BATTLEFIELD("Battlefield", DiscordAreaType.REGIONS, 10034),
	REGION_BATTLEFRONT("Battlefront", DiscordAreaType.REGIONS, 5433, 5434),
	REGION_BLAST_MINE("Blast Mine", DiscordAreaType.REGIONS, 5948),
	REGION_BODY_ALTAR("Body Altar", DiscordAreaType.REGIONS, 10059),
	REGION_CHAOS_ALTAR("Chaos Altar", DiscordAreaType.REGIONS, 9035),
	REGION_COSMIC_ALTAR("Cosmic Altar", DiscordAreaType.REGIONS, 8523),
	REGION_COSMIC_ENTITYS_PLANE("Cosmic Entity's Plane", DiscordAreaType.REGIONS, 8267),
	REGION_CRABCLAW_ISLE("Crabclaw Isle", DiscordAreaType.REGIONS, 6965),
	REGION_CRAFTING_GUILD("Crafting Guild", DiscordAreaType.REGIONS, 11571),
	REGION_CRANDOR("Crandor", DiscordAreaType.REGIONS, 11314, 11315),
	REGION_CRASH_ISLAND("Crash Island", DiscordAreaType.REGIONS, 11562),
	REGION_DARK_ALTAR("Dark Altar", DiscordAreaType.REGIONS, 6716),
	REGION_DEATH_ALTAR("Death Altar", DiscordAreaType.REGIONS, 8779),
	REGION_DEATH_PLATEAU("Death Plateau", DiscordAreaType.REGIONS, 11320),
	REGION_DENSE_ESSENCE("Dense Essence Mine", DiscordAreaType.REGIONS, 6972),
	REGION_DESERT_PLATEAU("Desert Plateau", DiscordAreaType.REGIONS, 13361, 13617),
	REGION_DIGSITE("Digsite", DiscordAreaType.REGIONS, 13365),
	REGION_DRAGONTOOTH("Dragontooth Island", DiscordAreaType.REGIONS, 15159),
	REGION_DRAYNOR_MANOR("Draynor Manor", DiscordAreaType.REGIONS, 12340),
	REGION_DRILL_SERGEANT("Drill Sergeant's Training Camp", DiscordAreaType.REGIONS, 12619),
	REGION_EAGLES_PEAK("Eagles' Peak", DiscordAreaType.REGIONS, 9270),
	REGION_EARTH_ALTAR("Earth Altar", DiscordAreaType.REGIONS, 10571),
	REGION_ENCHANTED_VALLEY("Enchanted Valley", DiscordAreaType.REGIONS, 12102),
	REGION_EVIL_TWIN("Evil Twin Crane Room", DiscordAreaType.REGIONS, 7504),
	REGION_EXAM_CENTRE("Exam Centre", DiscordAreaType.REGIONS, 13364),
	REGION_FALADOR_FARM("Falador Farm", DiscordAreaType.REGIONS, 12083),
	REGION_FARMING_GUILD("Farming Guild", DiscordAreaType.REGIONS, 4922),
	REGION_FELDIP_HILLS("Feldip Hills", DiscordAreaType.REGIONS, 9773, 9774, 10029, 10030, 10285, 10286, 10287, 10542, 10543),
	REGION_FENKENSTRAIN("Fenkenstrain's Castle", DiscordAreaType.REGIONS, 14135),
	REGION_FIGHT_ARENA("Fight Arena", DiscordAreaType.REGIONS, 10289),
	REGION_FIRE_ALTAR("Fire Altar", DiscordAreaType.REGIONS, 10315),
	REGION_FISHER_REALM("Fisher Realm", DiscordAreaType.REGIONS, 10569),
	REGION_FISHING_GUILD("Fishing Guild", DiscordAreaType.REGIONS, 10293),
	REGION_FISHING_PLATFORM("Fishing Platform", DiscordAreaType.REGIONS, 11059),
	REGION_FORSAKEN_TOWER("The Forsaken Tower", DiscordAreaType.REGIONS, 5435),
	REGION_FOSSIL_ISLAND("Fossil Island", DiscordAreaType.REGIONS, 14650, 14651, 14652, 14906, 14907, 14908, 15162, 15163, 15164),
	REGION_FREAKY_FORESTER("Freaky Forester's Clearing", DiscordAreaType.REGIONS, 10314),
	REGION_FREMENNIK("Fremennik Province", DiscordAreaType.REGIONS, 10296, 10552, 10808, 10809, 10810, 10811, 11064),
	REGION_FREMENNIK_ISLES("Fremennik Isles", DiscordAreaType.REGIONS, 9276, 9532),
	REGION_FROGLAND("Frogland", DiscordAreaType.REGIONS, 9802),
	REGION_GALVEK_SHIPWRECKS("Galvek Shipwrecks", DiscordAreaType.REGIONS, 6486, 6487, 6488, 6489, 6742, 6743, 6744, 6745),
	REGION_GHORROCK_DUNGEON("Ghorrock Dungeon", DiscordAreaType.REGIONS, 11681),
	REGION_GORAKS_PLANE("Gorak's Plane", DiscordAreaType.REGIONS, 12115),
	REGION_GRAND_EXCHANGE("Grand Exchange", DiscordAreaType.REGIONS, 12598),
	REGION_GWD("God Wars Dungeon", DiscordAreaType.REGIONS, 11578),
	REGION_HARMONY("Harmony Island", DiscordAreaType.REGIONS, 15148),
	REGION_HAZELMERE("Hazelmere's Island", DiscordAreaType.REGIONS, 10544),
	REGION_HUNTER_GUILD("Hunter Guild", DiscordAreaType.REGIONS, 6191),
	REGION_ICE_PATH("Ice Path", DiscordAreaType.REGIONS, 11322, 11323),
	REGION_ICEBERG("Iceberg", DiscordAreaType.REGIONS, 10558, 10559),
	REGION_ICYENE_GRAVEYARD("Icyene Graveyard", DiscordAreaType.REGIONS, 14641, 14897, 14898),
	REGION_ISAFDAR("Isafdar", DiscordAreaType.REGIONS, 8497, 8753, 8754, 9009, 9010),
	REGION_ISLAND_OF_STONE("Island of Stone", DiscordAreaType.REGIONS, 9790),
	REGION_ISLE_OF_SOULS("Isle of Souls", DiscordAreaType.REGIONS, 8236, 8237, 8238, 8491, 8492, 8494, 8747, 8750, 9003, 9004, 9006, 9260, 9261, 9262),
	REGION_JIGGIG("Jiggig" , DiscordAreaType.REGIONS, 9775),
	REGION_KANDARIN("Kandarin", DiscordAreaType.REGIONS, 9268, 9269, 9014, 9263, 9264, 9519, 9524, 9527, 9776, 9783, 10037, 10290, 10294, 10546, 10551, 10805, 11062),
	REGION_KARAMJA("Karamja" , DiscordAreaType.REGIONS, 10801, 10802, 11054, 11311, 11312, 11313, 11566, 11567, 11568, 11569, 11822),
	REGION_KEBOS_LOWLANDS("Kebos Lowlands", DiscordAreaType.REGIONS, 4665, 4666, 4667, 4921, 5178),
	REGION_KEBOS_SWAMP("Kebos Swamp", DiscordAreaType.REGIONS, 4664, 4920, 5174, 5175, 5176, 5430, 5431),
	REGION_KHARAZI_JUNGLE("Kharazi Jungle", DiscordAreaType.REGIONS, 11053, 11309, 11565, 11821),
	REGION_KHARIDIAN_DESERT("Kharidian Desert", DiscordAreaType.REGIONS, 12587, 12844, 12845, 12846, 12847, 12848, 13100, 13101, 13102, 13103, 13104, 13357, 13359, 13360, 13614, 13615, 13616, 13869, 13870),
	REGION_KILLERWATT_PLANE("Killerwatt Plane", DiscordAreaType.REGIONS, 10577),
	REGION_KOUREND("Great Kourend", DiscordAreaType.REGIONS, 6201, 6457, 6713),
	REGION_KOUREND_WOODLAND("Kourend Woodland", DiscordAreaType.REGIONS, 5942, 6197, 6453),
	REGION_LAW_ALTAR("Law Altar", DiscordAreaType.REGIONS, 9803),
	REGION_LEGENDS_GUILD("Legends' Guild", DiscordAreaType.REGIONS, 10804),
	REGION_LIGHTHOUSE("Lighthouse", DiscordAreaType.REGIONS, 10040),
	REGION_LITHKREN("Lithkren", DiscordAreaType.REGIONS, 14142, 14398),
	REGION_LUMBRIDGE_SWAMP("Lumbridge Swamp", DiscordAreaType.REGIONS, 12593, 12849),
	REGION_MAX_ISLAND("Max Island", DiscordAreaType.REGIONS, 11063),
	REGION_MCGRUBORS_WOOD("McGrubor's Wood", DiscordAreaType.REGIONS, 10550),
	REGION_MIME_STAGE("Mime's Stage", DiscordAreaType.REGIONS, 8010),
	REGION_MIND_ALTAR("Mind Altar", DiscordAreaType.REGIONS, 11083),
	REGION_MISTHALIN("Misthalin", DiscordAreaType.REGIONS, 12594, 12595, 12851),
	REGION_MOLCH("Molch", DiscordAreaType.REGIONS, 5177),
	REGION_MOLCH_ISLAND("Molch Island", DiscordAreaType.REGIONS, 5432),
	REGION_MORYTANIA("Morytania", DiscordAreaType.REGIONS, 13619, 13620, 13621, 13622, 13876, 13877, 13879, 14133, 14134, 14389, 14390, 14391, 14645, 14647),
	REGION_MOUNT_QUIDAMORTEM("Mount Quidamortem", DiscordAreaType.REGIONS, 4662, 4663, 4918, 4919),
	REGION_MR_MORDAUTS_CLASSROOM("Mr. Mordaut's Classroom", DiscordAreaType.REGIONS, 7502),
	REGION_MUDSKIPPER("Mudskipper Point", DiscordAreaType.REGIONS, 11824),
	REGION_MYSTERIOUS_OLD_MAN_MAZE("Mysterious Old Man's Maze", DiscordAreaType.REGIONS, 11590, 11591, 11846, 11847),
	REGION_MYTHS_GUILD("Myths' Guild", DiscordAreaType.REGIONS, 9772),
	REGION_NATURE_ALTAR("Nature Altar", DiscordAreaType.REGIONS, 9547),
	REGION_NECROPOLIS("Necropolis", DiscordAreaType.REGIONS, 13098, 13353, 13354, 13609, 13610),
	REGION_NORTHERN_TUNDRAS("Northern Tundras", DiscordAreaType.REGIONS, 6204, 6205, 6717),
	REGION_OBSERVATORY("Observatory", DiscordAreaType.REGIONS, 9777),
	REGION_ODD_ONE_OUT("Odd One Out", DiscordAreaType.REGIONS, 7754),
	REGION_ORTUS_FARM("Ortus Farm", DiscordAreaType.REGIONS, 6192, 6193),
	REGION_OTTOS_GROTTO("Otto's Grotto", DiscordAreaType.REGIONS, 10038),
	REGION_OURANIA_HUNTER("Ourania Hunter Area", DiscordAreaType.REGIONS, 9778),
	REGION_PIRATES_COVE("Pirates' Cove", DiscordAreaType.REGIONS, 8763),
	REGION_PISCATORIS_HUNTER_AREA("Piscatoris Hunter Area", DiscordAreaType.REGIONS, 9015, 9016, 9271, 9272, 9528),
	REGION_POH("Player Owned House", DiscordAreaType.REGIONS, 7513, 7514, 7769, 7770),
	REGION_POISON_WASTE("Poison Waste", DiscordAreaType.REGIONS, 8752, 9008),
	REGION_PORT_TYRAS("Port Tyras", DiscordAreaType.REGIONS, 8496),
	REGION_PURO_PURO("Puro-Puro", DiscordAreaType.REGIONS, 10307),
	REGION_QUARRY("Quarry", DiscordAreaType.REGIONS, 12589),
	REGION_RALOS_RISE("Ralos' Rise", DiscordAreaType.REGIONS, 5424, 5425, 5679, 5680, 5681, 5682),
	REGION_RANGING_GUILD("Ranging Guild", DiscordAreaType.REGIONS, 10549),
	REGION_RATCATCHERS_MANSION("Ratcatchers Mansion", DiscordAreaType.REGIONS, 11343),
	REGION_RUINS_OF_UNKAH("Ruins of Unkah", DiscordAreaType.REGIONS, 12588),
	REGION_RUINS_OF_ULLEK("Ruins of Ullek", DiscordAreaType.REGIONS, 13355, 13611, 13612),
	REGION_RUNE_ESSENCE_MINE("Rune Essence Mine", DiscordAreaType.REGIONS, 11595),
	// The Beekeper, Pinball, and Gravedigger randoms share a region (7758), and although they are not technically ScapeRune, that name is most commonly
	// associated with random events, so those three have been denoted ScapeRune to avoid leaving multiple random event regions without an assigned name.
	REGION_SCAPERUNE("ScapeRune", DiscordAreaType.REGIONS, 10058, 7758, 8261),
	REGION_SEA_SPIRIT_DOCK("Sea Spirit Dock", DiscordAreaType.REGIONS, 12332),
	REGION_SHIP_YARD("Ship Yard", DiscordAreaType.REGIONS, 11823),
	REGION_SILVAREA("Silvarea", DiscordAreaType.REGIONS, 13366),
	REGION_SINCLAR_MANSION("Sinclair Mansion", DiscordAreaType.REGIONS, 10807),
	REGION_SLAYER_TOWER("Slayer Tower", DiscordAreaType.REGIONS, 13623, 13723),
	REGION_SOUL_ALTAR("Soul Altar", DiscordAreaType.REGIONS, 7228),
	REGION_STRANGLEWOOD_TEMPLE("Stranglewood Temple", DiscordAreaType.REGIONS, 4761),
	REGION_SUNSET_COAST("Sunset Coast", DiscordAreaType.REGIONS, 5934, 6190),
	REGION_THE_SCAR("The Scar", DiscordAreaType.REGIONS, 8036, 8292),
	REGION_THE_STRANGLEWOOD("The Stranglewood", DiscordAreaType.REGIONS, 4403, 4404, 4659, 4660, 4661, 4916, 4917),
	REGION_TROLL_ARENA("Troll Arena", DiscordAreaType.REGIONS, 11576),
	REGION_TROLLHEIM("Trollheim", DiscordAreaType.REGIONS, 11577),
	REGION_TROLLWEISS_MTN("Trollweiss Mountain", DiscordAreaType.REGIONS, 11066, 11067, 11068),
	REGION_TUTORIAL_ISLAND("Tutorial Island", DiscordAreaType.REGIONS, 12079, 12080, 12335, 12336, 12436, 12592),
	REGION_UNDERWATER("Underwater", DiscordAreaType.REGIONS, 15008, 15264),
	REGION_WATER_ALTAR("Water Altar", DiscordAreaType.REGIONS, 10827),
	REGION_WATERBIRTH_ISLAND("Waterbirth Island", DiscordAreaType.REGIONS, 10042),
	REGION_WINTERTODT_CAMP("Wintertodt Camp", DiscordAreaType.REGIONS, 6461),
	REGION_WIZARDS_TOWER("Wizards' Tower", DiscordAreaType.REGIONS, 12337),
	REGION_WOODCUTTING_GUILD("Woodcutting Guild", DiscordAreaType.REGIONS, 6198, 6454),
	REGION_WRATH_ALTAR("Wrath Altar", DiscordAreaType.REGIONS, 9291);

	private static final Map<Integer, DiscordGameEventType> FROM_REGION;

	static
	{
		ImmutableMap.Builder<Integer, DiscordGameEventType> regionMapBuilder = new ImmutableMap.Builder<>();
		for (DiscordGameEventType discordGameEventType : DiscordGameEventType.values())
		{
			if (discordGameEventType.getRegionIds() == null)
			{
				continue;
			}

			for (int region : discordGameEventType.getRegionIds())
			{
				regionMapBuilder.put(region, discordGameEventType);
			}
		}
		FROM_REGION = regionMapBuilder.build();
	}

	@Nullable
	private String imageKey;

	@Nullable
	private String state;

	@Nullable
	private String details;

	private int priority;

	/**
	 * Determines if event should clear other clearable events when triggered
	 */
	private boolean shouldClear;

	/**
	 * Determines if event should be processed when it timeouts based on action timeout
	 */
	private boolean shouldTimeout;

	/**
	 * Determines if event start time should be reset when processed
	 */
	private boolean shouldRestart;

	/**
	 * Determines if event should be cleared when processed
	 */
	private boolean shouldBeCleared = true;

	@Nullable
	private DiscordAreaType discordAreaType;

	@Nullable
	private int[] regionIds;

	DiscordGameEventType(Skill skill)
	{
		this(skill, 0);
	}

	DiscordGameEventType(Skill skill, int priority)
	{
		this.details = training(skill);
		this.priority = priority;
		this.imageKey = imageKeyOf(skill);
		this.shouldTimeout = true;
	}

	DiscordGameEventType(String areaName, DiscordAreaType areaType, int... regionIds)
	{
		this.state = exploring(areaType, areaName);
		this.priority = -2;
		this.discordAreaType = areaType;
		this.regionIds = regionIds;
		this.shouldClear = true;
	}

	DiscordGameEventType(String state, int priority, boolean shouldClear, boolean shouldTimeout, boolean shouldRestart, boolean shouldBeCleared)
	{
		this.state = state;
		this.priority = priority;
		this.shouldClear = shouldClear;
		this.shouldTimeout = shouldTimeout;
		this.shouldRestart = shouldRestart;
		this.shouldBeCleared = shouldBeCleared;
	}

	DiscordGameEventType(String state, int priority)
	{
		this(state, priority, true, false, false, true);
	}

	private static String training(final Skill skill)
	{
		return training(skill.getName());
	}

	private static String training(final String what)
	{
		return "Training: " + what;
	}

	private static String imageKeyOf(final Skill skill)
	{
		return imageKeyOf(skill.getName().toLowerCase());
	}

	private static String imageKeyOf(final String what)
	{
		return "icon_" + what;
	}

	private static String exploring(DiscordAreaType areaType, String areaName)
	{
		return areaName;
	}

	public static DiscordGameEventType fromSkill(final Skill skill)
	{
		switch (skill)
		{
			case ATTACK: return TRAINING_ATTACK;
			case DEFENCE: return TRAINING_DEFENCE;
			case STRENGTH: return TRAINING_STRENGTH;
			case RANGED: return TRAINING_RANGED;
			case PRAYER: return TRAINING_PRAYER;
			case MAGIC: return TRAINING_MAGIC;
			case COOKING: return TRAINING_COOKING;
			case WOODCUTTING: return TRAINING_WOODCUTTING;
			case FLETCHING: return TRAINING_FLETCHING;
			case FISHING: return TRAINING_FISHING;
			case FIREMAKING: return TRAINING_FIREMAKING;
			case CRAFTING: return TRAINING_CRAFTING;
			case SMITHING: return TRAINING_SMITHING;
			case MINING: return TRAINING_MINING;
			case HERBLORE: return TRAINING_HERBLORE;
			case AGILITY: return TRAINING_AGILITY;
			case THIEVING: return TRAINING_THIEVING;
			case SLAYER: return TRAINING_SLAYER;
			case FARMING: return TRAINING_FARMING;
			case RUNECRAFT: return TRAINING_RUNECRAFT;
			case HUNTER: return TRAINING_HUNTER;
			case CONSTRUCTION: return TRAINING_CONSTRUCTION;
			default: return null;
		}
	}

	public static DiscordGameEventType fromRegion(final int regionId)
	{
		return FROM_REGION.get(regionId);
	}
}
