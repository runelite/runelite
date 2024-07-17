package net.runelite.client.game;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;

@Getter
public enum GameArea
{
	// Bosses
	ABYSSAL_SIRE("Abyssal Sire", GameAreaType.BOSSES, 11851, 11850, 12363, 12362),
	ALCHEMICAL_HYDRA("Alchemical Hydra", GameAreaType.BOSSES, 5536),
	CERBERUS("Cerberus", GameAreaType.BOSSES, 4883, 5140, 5395),
	COMMANDER_ZILYANA("Commander Zilyana", GameAreaType.BOSSES, new RegionArea(11602, new WorldPoint(2889, 5258, 0), new WorldPoint(2907, 5275, 0))),
	CORPOREAL_BEAST("Corporeal Beast", GameAreaType.BOSSES, 11842, 11844),
	DAGANNOTH_KINGS("Dagannoth Kings", GameAreaType.BOSSES, 11588, 11589),
	DUKE_SUCELLUS("Duke Sucellus", GameAreaType.BOSSES, 12132),
	GENERAL_GRAARDOR("General Graardor", GameAreaType.BOSSES, new RegionArea(11347, new WorldPoint(2864, 5351, 2), new WorldPoint(2876, 5369, 2))),
	GIANT_MOLE("Giant Mole", GameAreaType.BOSSES, 6993, 6992),
	GROTESQUE_GUARDIANS("Grotesque Guardians", GameAreaType.BOSSES, 6727),
	HESPORI("Hespori", GameAreaType.BOSSES, 5021),
	KALPHITE_QUEEN("Kalphite Queen", GameAreaType.BOSSES, 13972),
	KRAKEN("Kraken", GameAreaType.BOSSES, 9116),
	KREEARRA("Kree'arra", GameAreaType.BOSSES, new RegionArea(11346, new WorldPoint(2824, 5296, 2), new WorldPoint(2842, 5308, 2))),
	KRIL_TSUTSAROTH("K'ril Tsutsaroth", GameAreaType.BOSSES, new RegionArea(11603, new WorldPoint(2918, 5318, 2), new WorldPoint(2936, 5333, 2))),
	NEX("Nex", GameAreaType.BOSSES, 11601),
	NIGHTMARE("Nightmare of Ashihama", GameAreaType.BOSSES, 15515),
	PHANTOM_MUSPAH("Phantom Muspah", GameAreaType.BOSSES, 11330),
	SARACHNIS("Sarachnis", GameAreaType.BOSSES, 7322),
	SKOTIZO("Skotizo", GameAreaType.BOSSES, 6810),
	TEMPOROSS("Tempoross", GameAreaType.BOSSES, 12078),
	THE_LEVIATHAN("The Leviathan", GameAreaType.BOSSES, 8291),
	THE_WHISPERER("The Whisperer", GameAreaType.BOSSES, 10595),
	THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear smoke devil", GameAreaType.BOSSES, 9363, 9619),
	VARDORVIS("Vardorvis", GameAreaType.BOSSES, 4405),
	VORKATH("Vorkath", GameAreaType.BOSSES, 9023),
	WINTERTODT("Wintertodt", GameAreaType.BOSSES, 6462),
	ZALCANO("Zalcano", GameAreaType.BOSSES, 12126),
	ZULRAH("Zulrah", GameAreaType.BOSSES, 9007),

	// Cities
	AL_KHARID("Al Kharid", GameAreaType.CITIES, 13105, 13106),
	ARCEUUS_HOUSE("Arceuus", GameAreaType.CITIES, 6458, 6459, 6460, 6714, 6715),
	ARDOUGNE("Ardougne", GameAreaType.CITIES, 9779, 9780, 10035, 10036, 10291, 10292, 10547, 10548),
	BANDIT_CAMP("Bandit Camp", GameAreaType.CITIES, 12590),
	BARBARIAN_OUTPOST("Barbarian Outpost", GameAreaType.CITIES, 10039),
	BARBARIAN_VILLAGE("Barbarian Village", GameAreaType.CITIES, 12341),
	BEDABIN_CAMP("Bedabin Camp", GameAreaType.CITIES, 12591),
	BRIMHAVEN("Brimhaven", GameAreaType.CITIES, 11057, 11058),
	BURGH_DE_ROTT("Burgh de Rott", GameAreaType.CITIES, 13874, 13873, 14130, 14129),
	BURTHORPE("Burthorpe", GameAreaType.CITIES, 11319, 11575),
	CAM_TORUM("Cam Torum", GameAreaType.CITIES, 5525, 5780, 5781, 6037),
	CANIFIS("Canifis", GameAreaType.CITIES, 13878),
	CATHERBY("Catherby", GameAreaType.CITIES, 11317, 11318, 11061),
	CIVITAS_ILLA_FORTIS("Civitas Illa Fortis", GameAreaType.CITIES, 6448, 6449, 6704, 6705, 6960, 6961),
	CORSAIR_COVE("Corsair Cove", GameAreaType.CITIES, 10028, 10284),
	DARKMEYER("Darkmeyer", GameAreaType.CITIES, 14388, 14644),
	DORGESH_KAAN("Dorgesh-Kaan", GameAreaType.CITIES, 10835, 10834),
	DRAYNOR("Draynor", GameAreaType.CITIES, 12338, 12339),
	EDGEVILLE("Edgeville", GameAreaType.CITIES, 12342),
	ENTRANA("Entrana", GameAreaType.CITIES, 11060, 11316),
	ETCETERIA("Etceteria", GameAreaType.CITIES, 10300),
	FALADOR("Falador", GameAreaType.CITIES, 11828, 11572, 11827, 12084),
	GUTANOTH("Gu'Tanoth", GameAreaType.CITIES, 10031),
	GWENITH("Gwenith", GameAreaType.CITIES, 8757),
	HOSIDIUS_HOUSE("Hosidius", GameAreaType.CITIES, 6710, 6711, 6712, 6455, 6456, 6966, 6967, 6968, 7221, 7223, 7224, 7478, 7479),
	JATIZSO("Jatizso", GameAreaType.CITIES, 9531),
	KELDAGRIM("Keldagrim", GameAreaType.CITIES, 11423, 11422, 11679, 11678),
	LANDS_END("Land's End", GameAreaType.CITIES, 5941),
	LASSAR_UNDERCITY("Lassar Undercity", GameAreaType.CITIES, 9314, 9315, 9316, 9571, 9572, 9828, 10338, 10339, 10340, 10596, 10852),
	LLETYA("Lletya", GameAreaType.CITIES, 9265, 11103),
	LOVAKENGJ_HOUSE("Lovakengj", GameAreaType.CITIES, 5692, 5691, 5947, 6203, 6202, 5690, 5946),
	LUMBRIDGE("Lumbridge", GameAreaType.CITIES, 12850),
	LUNAR_ISLE("Lunar Isle", GameAreaType.CITIES, 8253, 8252, 8509, 8508),
	MARIM("Marim", GameAreaType.REGIONS, 11051),
	MEIYERDITCH("Meiyerditch", GameAreaType.CITIES, 14132, 14387, 14386, 14385),
	MENAPHOS("Menaphos", GameAreaType.CITIES, 12843),
	MISCELLANIA("Miscellania", GameAreaType.CITIES, 10044),
	MOR_UL_REK("Mor Ul Rek", GameAreaType.CITIES, 9808, 9807, 10064, 10063),
	MORTTON("Mort'ton", GameAreaType.CITIES, 13875),
	MOS_LE_HARMLESS("Mos Le'Harmless", GameAreaType.CITIES, 14637, 14638, 14639, 14894, 14895, 15151, 15406, 15407),
	MOUNT_KARUULM("Mount Karuulm", GameAreaType.CITIES, 5179, 4923, 5180),
	MOUNTAIN_CAMP("Mountain Camp", GameAreaType.CITIES, 11065),
	MYNYDD("Mynydd", GameAreaType.CITIES, 8501),
	NARDAH("Nardah", GameAreaType.CITIES, 13613),
	NEITIZNOT("Neitiznot", GameAreaType.CITIES, 9275),
	PISCARILIUS_HOUSE("Port Piscarilius", GameAreaType.CITIES, 6969, 6971, 7227, 6970, 7225, 7226),
	PISCATORIS("Piscatoris", GameAreaType.CITIES, 9273),
	POLLNIVNEACH("Pollnivneach", GameAreaType.CITIES, 13358),
	PORT_KHAZARD("Port Khazard", GameAreaType.CITIES, 10545),
	PORT_PHASMATYS("Port Phasmatys", GameAreaType.CITIES, 14646),
	PORT_SARIM("Port Sarim", GameAreaType.CITIES, 12081, 12082),
	PRIFDDINAS("Prifddinas", GameAreaType.CITIES, 8499, 8500, 8755, 8756, 9011, 9012, 9013, 12894, 12895, 13150, 13151),
	RELLEKKA("Rellekka", GameAreaType.CITIES, 10297, 10553),
	RIMMINGTON("Rimmington", GameAreaType.CITIES, 11826, 11570),
	SEERS_VILLAGE("Seers' Village", GameAreaType.CITIES, 10806),
	SHAYZIEN_HOUSE("Shayzien", GameAreaType.CITIES, 5944, 5943, 6200, 6199, 5686, 5687, 5688, 5689, 5945),
	SHILO_VILLAGE("Shilo Village", GameAreaType.CITIES, 11310),
	SLEPE("Slepe", GameAreaType.CITIES, 14643, 14899, 14900, 14901),
	SOPHANEM("Sophanem", GameAreaType.CITIES, 13099),
	TAI_BWO_WANNAI("Tai Bwo Wannai", GameAreaType.CITIES, 11056, 11055),
	TAVERLEY("Taverley", GameAreaType.CITIES, 11574, 11573),
	TREE_GNOME_STRONGHOLD("Tree Gnome Stronghold", GameAreaType.CITIES,
		regionGameAreas(9525, 9526, 9782, 9781),
		new RegionArea(9527, new WorldPoint(2374, 3520, 0), new WorldPoint(2399, 3537, 0)),
		new RegionArea(9527, new WorldPoint(2400, 3520, 0), new WorldPoint(2431, 3550, 0))),
	TREE_GNOME_VILLAGE("Tree Gnome Village", GameAreaType.CITIES, 10033),
	TROLL_STRONGHOLD("Troll Stronghold", GameAreaType.CITIES, 11321, 11421),
	UZER("Uzer", GameAreaType.CITIES, 13872),
	UZER_OASIS("Uzer Oasis", GameAreaType.CITIES, 13871),
	VARROCK("Varrock", GameAreaType.CITIES, 12596, 12597, 12852, 12853, 12854, 13108, 13109, 13110),
	VER_SINHAZA("Ver Sinhaza", GameAreaType.CITIES, 14642),
	VOID_OUTPOST("Void Knights' Outpost", GameAreaType.CITIES, 10537),
	WEISS("Weiss", GameAreaType.CITIES, 11325, 11581),
	WITCHHAVEN("Witchaven", GameAreaType.CITIES, 10803),
	YANILLE("Yanille", GameAreaType.CITIES, 10288, 10032),
	ZANARIS("Zanaris", GameAreaType.CITIES, 9285, 9541, 9540, 9797),
	ZULANDRA("Zul-Andra", GameAreaType.CITIES, 8495, 8751),

	// Dungeons
	ABANDONED_MINE("Abandoned Mine", GameAreaType.DUNGEONS, 13618, 13718, 11079, 11078, 11077, 10823, 10822, 10821),
	AH_ZA_RHOON("Ah Za Rhoon", GameAreaType.DUNGEONS, 11666),
	ANCIENT_CAVERN("Ancient Cavern", GameAreaType.DUNGEONS, 6483, 6995),
	APE_ATOLL_DUNGEON("Ape Atoll Dungeon", GameAreaType.DUNGEONS, 11150, 10894),
	APE_ATOLL_BANANA_PLANTATION("Ape Atoll Banana Plantation", GameAreaType.DUNGEONS, 10895),
	ARDY_BASEMENT("West Ardougne Basement", GameAreaType.DUNGEONS, 10135),
	ARDY_SEWERS("Ardougne Sewers", GameAreaType.DUNGEONS, 10134, 10136, 10391, 10647),
	ASGARNIAN_ICE_CAVES("Asgarnian Ice Caves", GameAreaType.DUNGEONS, 11925, 12181),
	BERVIRIUS_TOMB("Tomb of Bervirius", GameAreaType.DUNGEONS, 11154),
	BRIMHAVEN_DUNGEON("Brimhaven Dungeon", GameAreaType.DUNGEONS, 10901, 10900, 10899, 10645, 10644, 10643),
	BRINE_RAT_CAVERN("Brine Rat Cavern", GameAreaType.DUNGEONS, 10910),
	CATACOMBS_OF_KOUREND("Catacombs of Kourend", GameAreaType.DUNGEONS, 6557, 6556, 6813, 6812),
	CHAMPIONS_CHALLENGE("Champions' Challenge", GameAreaType.DUNGEONS, 12696),
	CHAOS_DRUID_TOWER("Chaos Druid Tower", GameAreaType.DUNGEONS, 10392),
	CHASM_OF_FIRE("Chasm of Fire", GameAreaType.DUNGEONS, 5789),
	CHASM_OF_TEARS("Chasm of Tears", GameAreaType.DUNGEONS, 12948),
	CHINCHOMPA("Chinchompa Hunting Ground", GameAreaType.DUNGEONS, 10129),
	CIVITAS_ILLA_FORTIS_UNDERGROUND("Civitas illa Fortis Underground", GameAreaType.DUNGEONS, 6549, 6804, 6805),
	CLOCK_TOWER("Clock Tower Basement", GameAreaType.DUNGEONS, 10390),
	CORSAIR_COVE_DUNGEON("Corsair Cove Dungeon", GameAreaType.DUNGEONS, 8076, 8332),
	CRABCLAW_CAVES("Crabclaw Caves", GameAreaType.DUNGEONS, 6553, 6809),
	CRANDOR_DUNGEON("Crandor Dungeon", GameAreaType.DUNGEONS, 11414),
	CRASH_SITE_CAVERN("Crash Site Cavern", GameAreaType.DUNGEONS, 8280, 8536),
	CRUMBLING_TOWER("Crumbling Tower", GameAreaType.DUNGEONS, 7827),
	DAEYALT_ESSENCE_MINE("Daeyalt Essence Mine", GameAreaType.DUNGEONS, 14744),
	DIGSITE_DUNGEON("Digsite Dungeon", GameAreaType.DUNGEONS,
		regionGameAreas(13464, 13465),
		new RegionArea(13621, new WorldPoint(3392, 3392, 0), new WorldPoint(3401, 3455, 0)),
		new RegionArea(13621, new WorldPoint(3402, 3410, 0), new WorldPoint(3405, 3419, 0)),
		new RegionArea(13621, new WorldPoint(3402, 3434, 0), new WorldPoint(3403, 3439, 0))),
	DORGESHKAAN("Dorgesh-Kaan South Dungeon", GameAreaType.DUNGEONS, 10833),
	DORGESHUUN_MINES("Dorgeshuun Mines", GameAreaType.DUNGEONS, 12950, 13206),
	DRAYNOR_SEWERS("Draynor Sewers", GameAreaType.DUNGEONS, 12439, 12438),
	DWARVEN_MINES("Dwarven Mines", GameAreaType.DUNGEONS, 12185, 12184, 12183),
	EAGLES_PEAK_DUNGEON("Eagles' Peak Dungeon", GameAreaType.DUNGEONS, 8013),
	ECTOFUNTUS("Ectofuntus", GameAreaType.DUNGEONS, 14746),
	EDGEVILLE_DUNGEON("Edgeville Dungeon", GameAreaType.DUNGEONS, 12441, 12442, 12443, 12698),
	ELEMENTAL_WORKSHOP("Elemental Workshop", GameAreaType.DUNGEONS, 10906, 7760),
	ELVEN_RABBIT_CAVE("Elven rabbit cave", GameAreaType.DUNGEONS, 13252),
	ENAKHRAS_TEMPLE("Enakhra's Temple", GameAreaType.DUNGEONS, 12423),
	EVIL_CHICKENS_LAIR("Evil Chicken's Lair", GameAreaType.DUNGEONS, 9796),
	EXPERIMENT_CAVE("Experiment Cave", GameAreaType.DUNGEONS, 14235, 13979),
	FEROX_ENCLAVE("Ferox Enclave Dungeon", GameAreaType.DUNGEONS, 12700),
	FORTHOS("Forthos Dungeon", GameAreaType.DUNGEONS, 7323),
	FREMENNIK_SLAYER("Fremennik Slayer Dungeon", GameAreaType.DUNGEONS, 10907, 10908, 11164),
	GLARIALS_TOMB("Glarial's Tomb", GameAreaType.DUNGEONS, 10137),
	GOBLIN_CAVE("Goblin Cave", GameAreaType.DUNGEONS, 10393),
	GRAND_TREE_TUNNELS("Grand Tree Tunnels", GameAreaType.DUNGEONS, 9882),
	HAM_HIDEOUT("H.A.M. Hideout", GameAreaType.DUNGEONS, 12694),
	HAM_STORE_ROOM("H.A.M. Store room", GameAreaType.DUNGEONS, 10321),
	HEROES_GUILD("Heroes' Guild Mine", GameAreaType.DUNGEONS, 11674),
	IORWERTH("Iorwerth Dungeon", GameAreaType.DUNGEONS, 12737, 12738, 12993, 12994),
	ISLE_OF_SOULS_DUNGEON("Isle of Souls Dungeon", GameAreaType.DUNGEONS, 8593),
	JATIZSO_MINES("Jatizso Mines", GameAreaType.DUNGEONS, 9631),
	JIGGIG_BURIAL_TOMB("Jiggig Burial Tomb", GameAreaType.DUNGEONS, 9875, 9874),
	JOGRE("Jogre Dungeon", GameAreaType.DUNGEONS, 11412),
	KARAMJA_DUNGEON("Karamja Dungeon", GameAreaType.DUNGEONS, 11413),
	KARUULM("Karuulm Slayer Dungeon", GameAreaType.DUNGEONS, 5280, 5279, 5023, 5535, 5022, 4766, 4510, 4511, 4767, 4768, 4512),
	KGP_HEADQUARTERS("KGP Headquarters", GameAreaType.DUNGEONS, 10658),
	KRUK("Kruk's Dungeon", GameAreaType.DUNGEONS, 9358, 9359, 9360, 9615, 9616, 9871, 10125, 10126, 10127, 10128, 10381, 10382, 10383, 10384, 10637, 10638, 10639, 10640),
	LEGENDS_GUILD_DUNGEON("Legends' Guild Dungeon", GameAreaType.DUNGEONS, 10904),
	LIGHTHOUSE_DUNGEON("Lighthouse", GameAreaType.DUNGEONS, 10140),
	LIZARDMAN_CAVES("Lizardman Caves", GameAreaType.DUNGEONS, 5275),
	LIZARDMAN_TEMPLE("Lizardman Temple", GameAreaType.DUNGEONS, 5277),
	LUMBRIDGE_SWAMP_CAVES("Lumbridge Swamp Caves", GameAreaType.DUNGEONS, 12693, 12949),
	LUNAR_ISLE_MINE("Lunar Isle Mine", GameAreaType.DUNGEONS, 9377),
	MANIACAL_HUNTER("Maniacal Monkey Hunter Area", GameAreaType.DUNGEONS, 11662),
	MEIYERDITCH_MINE("Meiyerditch Mine", GameAreaType.DUNGEONS, 9544),
	MISCELLANIA_DUNGEON("Miscellania Dungeon", GameAreaType.DUNGEONS, 10144, 10400),
	MOGRE_CAMP("Mogre Camp", GameAreaType.DUNGEONS, 11924),
	MOS_LE_HARMLESS_CAVES("Mos Le'Harmless Caves", GameAreaType.DUNGEONS, 14994, 14995, 15251),
	MOTHERLODE_MINE("Motherlode Mine", GameAreaType.DUNGEONS, 14679, 14680, 14681, 14935, 14936, 14937, 15191, 15192, 15193),
	MOURNER_TUNNELS("Mourner Tunnels", GameAreaType.DUNGEONS, 7752, 8008),
	MOUSE_HOLE("Mouse Hole", GameAreaType.DUNGEONS, 9046),
	MEIYERDITCH_LABORATORIES("Meiyerditch Laboratories", GameAreaType.DUNGEONS, 14232, 14233, 14487, 14488),
	MYREQUE("Myreque Hideout", GameAreaType.DUNGEONS, 13721, 13974, 13977, 13978),
	MYTHS_GUILD_DUNGEON("Myths' Guild Dungeon", GameAreaType.DUNGEONS, 7564, 7820, 7821),
	OBSERVATORY_DUNGEON("Observatory Dungeon", GameAreaType.DUNGEONS, 9362),
	OGRE_ENCLAVE("Ogre Enclave", GameAreaType.DUNGEONS, 10387),
	OURANIA("Ourania Cave", GameAreaType.DUNGEONS, 12119),
	PATERDOMUS("Paterdomus", GameAreaType.DUNGEONS, 13722),
	QUIDAMORTEM_CAVE("Quidamortem Cave", GameAreaType.DUNGEONS, 4763),
	RASHILIYIAS_TOMB("Rashiliyia's Tomb", GameAreaType.DUNGEONS, 11668),
	RUINS_OF_CAMDOZAAL("Ruins of Camdozaal", GameAreaType.DUNGEONS, 11609, 11610, 11611, 11865, 11866, 11867, 12121, 12122, 12123),
	SALT_MINE("Salt Mine", GameAreaType.DUNGEONS, 11425),
	SHADE_CATACOMBS("Shade Catacombs", GameAreaType.DUNGEONS, 13975),
	SHADOW("Shadow Dungeon", GameAreaType.DUNGEONS, 10575, 10831),
	SHAYZIEN_CRYPTS("Shayzien Crypts", GameAreaType.DUNGEONS, 6043),
	SISTERHOOD_SANCTUARY("Sisterhood Sanctuary", GameAreaType.DUNGEONS, 14999, 15000, 15001, 15255, 15256, 15257, 15511, 15512, 15513),
	SMOKE("Smoke Dungeon", GameAreaType.DUNGEONS, 12946, 13202),
	SOPHANEM_DUNGEON("Sophanem Dungeon", GameAreaType.DUNGEONS, 13200),
	SOURHOG_CAVE("Sourhog Cave", GameAreaType.DUNGEONS, 12695),
	STRONGHOLD_SECURITY("Stronghold of Security", GameAreaType.DUNGEONS, 7505, 8017, 8530, 9297),
	STRONGHOLD_SLAYER("Stronghold Slayer Cave", GameAreaType.DUNGEONS, 9624, 9625, 9880, 9881),
	TARNS_LAIR("Tarn's Lair", GameAreaType.DUNGEONS, 12616, 12615),
	TAVERLEY_DUNGEON("Taverley Dungeon", GameAreaType.DUNGEONS, 11416, 11417, 11671, 11672, 11673, 11928, 11929),
	TEMPLE_OF_IKOV("Temple of Ikov", GameAreaType.DUNGEONS, 10649, 10905, 10650),
	TEMPLE_OF_LIGHT("Temple of Light", GameAreaType.DUNGEONS, 7496),
	TEMPLE_OF_MARIMBO("Temple of Marimbo", GameAreaType.DUNGEONS, 11151),
	THE_BURROW("The Burrow", GameAreaType.DUNGEONS, 6291),
	THE_WARRENS("The Warrens", GameAreaType.DUNGEONS, 7070, 7326),
	DUNGEON_OF_TOLNA("Dungeon of Tolna", GameAreaType.DUNGEONS, 13209),
	TOWER_OF_LIFE("Tower of Life Basement", GameAreaType.DUNGEONS, 12100),
	TRAHAEARN_MINE("Trahaearn Mine", GameAreaType.DUNGEONS, 13250),
	TUNNEL_OF_CHAOS("Tunnel of Chaos", GameAreaType.DUNGEONS, 12625),
	UNDERGROUND_PASS("Underground Pass", GameAreaType.DUNGEONS, 9369, 9370),
	VARROCK_SEWERS("Varrock Sewers", GameAreaType.DUNGEONS, 12954, 13210),
	VIYELDI_CAVES("Viyeldi Caves", GameAreaType.DUNGEONS, 9545, 11153),
	WARRIORS_GUILD("Warriors' Guild Basement", GameAreaType.DUNGEONS, 11675),
	WATER_RAVINE("Water Ravine", GameAreaType.DUNGEONS, 13461),
	WATERBIRTH("Waterbirth Dungeon", GameAreaType.DUNGEONS, 9886, 10142, 7492, 7748),
	WATERFALL("Waterfall Dungeon", GameAreaType.DUNGEONS, 10394),
	WEREWOLF_AGILITY("Werewolf Agility Course", GameAreaType.DUNGEONS, 14234),
	WHITE_WOLF_MOUNTAIN_CAVES("White Wolf Mountain Caves", GameAreaType.DUNGEONS, 11418, 11419),
	WITCHAVEN_SHRINE("Witchhaven Shrine Dungeon", GameAreaType.DUNGEONS, 10903),
	WIZARDS_TOWER_BASEMENT("Wizards' Tower Basement", GameAreaType.DUNGEONS, 12437),
	WOODCUTTING_GUILD_DUNGEON("Woodcutting Guild Dungeon", GameAreaType.DUNGEONS, 6298),
	WYVERN_CAVE("Wyvern Cave", GameAreaType.DUNGEONS, 14495, 14496),
	YANILLE_AGILITY_DUNGEON("Yanille Agility Dungeon", GameAreaType.DUNGEONS, 10388),

	// Minigames
	ARDOUGNE_RAT_PITS("Ardougne Rat Pits", GameAreaType.MINIGAMES, 10646),
	BARBARIAN_ASSAULT("Barbarian Assault", GameAreaType.MINIGAMES, 7508, 7509, 10322),
	BARROWS("Barrows", GameAreaType.MINIGAMES, 14131),
	BARROWS_CRYPT("Barrows", GameAreaType.MINIGAMES, 14231),
	BLAST_FURNACE("Blast Furnace", GameAreaType.MINIGAMES, 7757),
	BRIMHAVEN_AGILITY_ARENA("Brimhaven Agility Arena", GameAreaType.MINIGAMES, 11157),
	BURTHORPE_GAMES_ROOM("Burthorpe Games Room", GameAreaType.MINIGAMES, 8781),
	CASTLE_WARS("Castle Wars", GameAreaType.MINIGAMES, 9520, 9620),
	CLAN_WARS("Clan Wars", GameAreaType.MINIGAMES, 12621, 12622, 12623, 13130, 13131, 13133, 13134, 13135, 13386, 13387, 13390, 13641, 13642, 13643, 13644, 13645, 13646, 13647, 13899, 13900, 14155, 14156),
	// 7499 is default trawler, 8011 is waterlogged trawler
	FISHING_TRAWLER("Fishing Trawler", GameAreaType.MINIGAMES, 7499, 8011),
	FORTIS_COLOSSEUM("Fortis Colosseum", GameAreaType.MINIGAMES, 7216),
	FORTIS_COLOSSEUM_LOBBY("Fortis Colosseum Lobby", GameAreaType.MINIGAMES, 7316),
	GAUNTLET_LOBBY("The Gauntlet Lobby", GameAreaType.MINIGAMES, 12127),
	GAUNTLET("The Gauntlet", GameAreaType.MINIGAMES, 7512),
	CORRUPTED_GAUNTLET("Corrupted Gauntlet", GameAreaType.MINIGAMES, 7768),
	GIANTS_FOUNDRY("Giants' Foundry", GameAreaType.MINIGAMES, 13491),
	GUARDIANS_OF_THE_RIFT("Guardians of the Rift", GameAreaType.MINIGAMES, 14484),
	HALLOWED_SEPULCHRE("Hallowed Sepulchre", GameAreaType.MINIGAMES, 8797, 9051, 9052, 9053, 9054, 9309, 9563, 9821, 10074, 10075, 10077),
	HALLOWED_SEPULCHRE_LOBBY("Hallowed Sepulchre Lobby", GameAreaType.MINIGAMES, 9565),
	INFERNO("The Inferno", GameAreaType.MINIGAMES, 9043),
	KELDAGRIM_RAT_PITS("Keldagrim Rat Pits", GameAreaType.MINIGAMES, 7753),
	LAST_MAN_STANDING_DESERTED_ISLAND("LMS - Deserted Island", GameAreaType.MINIGAMES, 13658, 13659, 13660, 13914, 13915, 13916),
	LAST_MAN_STANDING_WILD_VARROCK("LMS - Wild Varrock", GameAreaType.MINIGAMES, 13918, 13919, 13920, 14174, 14175, 14176, 14430, 14431, 14432),
	MAGE_TRAINING_ARENA("Mage Training Arena", GameAreaType.MINIGAMES, 13462, 13463),
	NIGHTMARE_ZONE("Nightmare Zone", GameAreaType.MINIGAMES, 9033),
	PEST_CONTROL("Pest Control", GameAreaType.MINIGAMES, 10536),
	PORT_SARIM_RAT_PITS("Port Sarim Rat Pits", GameAreaType.MINIGAMES, 11926),
	PVP_ARENA("PvP Arena", GameAreaType.MINIGAMES,
		regionGameAreas(13362, 13363),
		new RegionArea(13618, new WorldPoint(3392, 3200, 0), new WorldPoint(3405, 3263, 0))),
	PYRAMID_PLUNDER("Pyramid Plunder", GameAreaType.MINIGAMES, 7749),
	ROGUES_DEN("Rogues' Den", GameAreaType.MINIGAMES, 11854, 11855, 12109, 12110, 12111),
	SORCERESS_GARDEN("Sorceress's Garden", GameAreaType.MINIGAMES, 11605),
	SOUL_WARS("Soul Wars", GameAreaType.MINIGAMES, 8493, 8749, 9005),
	SOUL_WARS_LOBBY("Soul Wars", GameAreaType.MINIGAMES, 8748),
	TEMPLE_TREKKING("Temple Trekking", GameAreaType.MINIGAMES, 8014, 8270, 8256, 8782, 9038, 9294, 9550, 9806),
	TITHE_FARM("Tithe Farm", GameAreaType.MINIGAMES, 7222),
	TROUBLE_BREWING("Trouble Brewing", GameAreaType.MINIGAMES, 15150),
	TZHAAR_FIGHT_CAVES("Tzhaar Fight Caves", GameAreaType.MINIGAMES, 9551),
	TZHAAR_FIGHT_PITS("Tzhaar Fight Pits", GameAreaType.MINIGAMES, 9552),
	VARROCK_RAT_PITS("Varrock Rat Pits", GameAreaType.MINIGAMES, 11599),
	VOLCANIC_MINE("Volcanic Mine", GameAreaType.MINIGAMES, 15263, 15262),

	// Raids
	CHAMBERS_OF_XERIC("Chambers of Xeric", GameAreaType.RAIDS, 12889, 13136, 13137, 13138, 13139, 13140, 13141, 13145, 13393, 13394, 13395, 13396, 13397, 13401),
	THEATRE_OF_BLOOD("Theatre of Blood", GameAreaType.RAIDS, 12611, 12612, 12613, 12869, 13122, 13123, 13125),
	VERZIK_VITURS_TREASURE_VAULT("Verzik Vitur's Treasure Vault", GameAreaType.RAIDS, 12867),
	TOMBS_OF_AMASCUT("Tombs of Amascut", GameAreaType.RAIDS, 14160, 14162, 14164, 14674, 14676, 15184, 15186, 15188, 15696, 15698, 15700),
	JALTEVAS_PYRAMID("Jaltevas Pyramid", GameAreaType.RAIDS, 13454),
	OSMUMTENS_BURIAL_CHAMBER("Osmumten's Burial Chamber", GameAreaType.RAIDS, 14672),

	// Other
	ABYSSAL_AREA("Abyssal Area", GameAreaType.REGIONS, 12108),
	ABYSSAL_NEXUS("Abyssal Nexus", GameAreaType.REGIONS, 12106),
	AGILITY_PYRAMID("Agility Pyramid", GameAreaType.REGIONS, 12105, 13356),
	AIR_ALTAR("Air Altar", GameAreaType.REGIONS, 11339),
	AL_KHARID_MINE("Al Kharid Mine", GameAreaType.REGIONS, 13107),
	ANCIENT_VAULT("Ancient Vault", GameAreaType.REGIONS, 12644, 13156),
	APE_ATOLL("Ape Atoll", GameAreaType.REGIONS, 10794, 10795, 10974, 11050),
	ARANDAR("Arandar", GameAreaType.REGIONS, 9266, 9267, 9523),
	ASGARNIA("Asgarnia", GameAreaType.REGIONS, 11825, 11829, 11830, 12085, 12086),
	AVIUM_SAVANNAH("Avium Savannah", GameAreaType.REGIONS, 5935, 5936, 5937, 6189, 6445, 6446, 6447, 6701, 6702, 6703, 6957, 6958, 6959, 7215),
	BATTLEFIELD("Battlefield", GameAreaType.REGIONS, 10034),
	BATTLEFRONT("Battlefront", GameAreaType.REGIONS, 5433, 5434),
	BEEKEEPER("Beekeeper", GameAreaType.REGIONS, new RegionArea(7758, new WorldPoint(1920, 5036, 0), new WorldPoint(1934, 5051, 0))),
	BLAST_MINE("Blast Mine", GameAreaType.REGIONS, 5948),
	BODY_ALTAR("Body Altar", GameAreaType.REGIONS, 10059),
	CHAOS_ALTAR("Chaos Altar", GameAreaType.REGIONS, 9035),
	CLAN_HALL("Clan Hall", GameAreaType.REGIONS, 6997),
	COSMIC_ALTAR("Cosmic Altar", GameAreaType.REGIONS, 8523),
	COSMIC_ENTITYS_PLANE("Cosmic Entity's Plane", GameAreaType.REGIONS, 8267),
	CRABCLAW_ISLE("Crabclaw Isle", GameAreaType.REGIONS, 6965),
	CRAFTING_GUILD("Crafting Guild", GameAreaType.REGIONS, 11571),
	CRANDOR("Crandor", GameAreaType.REGIONS, 11314, 11315),
	CRASH_ISLAND("Crash Island", GameAreaType.REGIONS, 11562),
	DARK_ALTAR("Dark Altar", GameAreaType.REGIONS, 6716),
	DEATH_ALTAR("Death Altar", GameAreaType.REGIONS, 8779),
	DEATH_PLATEAU("Death Plateau", GameAreaType.REGIONS, 11320),
	DENSE_ESSENCE("Dense Essence Mine", GameAreaType.REGIONS, 6972),
	DESERT_PLATEAU("Desert Plateau", GameAreaType.REGIONS, 13361, 13617),
	DIGSITE("Digsite", GameAreaType.REGIONS, 13365),
	DRAGONTOOTH("Dragontooth Island", GameAreaType.REGIONS, 15159),
	DRAYNOR_MANOR("Draynor Manor", GameAreaType.REGIONS, 12340),
	DRILL_SERGEANT("Drill Sergeant's Training Camp", GameAreaType.REGIONS, 12619),
	EAGLES_PEAK("Eagles' Peak", GameAreaType.REGIONS, 9270),
	EARTH_ALTAR("Earth Altar", GameAreaType.REGIONS, 10571),
	ENCHANTED_VALLEY("Enchanted Valley", GameAreaType.REGIONS, 12102),
	EVIL_TWIN("Evil Twin Crane Room", GameAreaType.REGIONS, 7504),
	EXAM_CENTRE("Exam Centre", GameAreaType.REGIONS, 13364),
	FALADOR_FARM("Falador Farm", GameAreaType.REGIONS, 12083),
	FARMING_GUILD("Farming Guild", GameAreaType.REGIONS, 4922),
	FELDIP_HILLS("Feldip Hills", GameAreaType.REGIONS, 9773, 9774, 10029, 10030, 10285, 10286, 10287, 10542, 10543),
	FENKENSTRAIN("Fenkenstrain's Castle", GameAreaType.REGIONS, 14135),
	FIGHT_ARENA("Fight Arena", GameAreaType.REGIONS, 10289),
	FIRE_ALTAR("Fire Altar", GameAreaType.REGIONS, 10315),
	FISHER_REALM("Fisher Realm", GameAreaType.REGIONS, 10569),
	FISHING_GUILD("Fishing Guild", GameAreaType.REGIONS, 10293),
	FISHING_PLATFORM("Fishing Platform", GameAreaType.REGIONS, 11059),
	FORSAKEN_TOWER("The Forsaken Tower", GameAreaType.REGIONS, 5435),
	FOSSIL_ISLAND("Fossil Island", GameAreaType.REGIONS, 14650, 14651, 14652, 14906, 14907, 14908, 15162, 15163, 15164),
	FREAKY_FORESTER("Freaky Forester's Clearing", GameAreaType.REGIONS, 10314),
	FREMENNIK("Fremennik Province", GameAreaType.REGIONS, 10296, 10552, 10808, 10809, 10810, 10811, 11064),
	FREMENNIK_ISLES("Fremennik Isles", GameAreaType.REGIONS, 9276, 9532),
	FROGLAND("Frogland", GameAreaType.REGIONS, 9802),
	GALVEK_SHIPWRECKS("Galvek Shipwrecks", GameAreaType.REGIONS, 6486, 6487, 6488, 6489, 6742, 6743, 6744, 6745),
	GHORROCK_DUNGEON("Ghorrock Dungeon", GameAreaType.REGIONS, 11681),
	GORAKS_PLANE("Gorak's Plane", GameAreaType.REGIONS, 12115),
	GRAND_EXCHANGE("Grand Exchange", GameAreaType.REGIONS, 12598),
	GRAVEDIGGER("Gravedigger", GameAreaType.REGIONS, new RegionArea(7758, new WorldPoint(1921, 4993, 0), new WorldPoint(1934, 5006, 0))),
	GWD("God Wars Dungeon", GameAreaType.REGIONS, 11578, 11346, 11347, 11602, 11603),
	HARMONY("Harmony Island", GameAreaType.REGIONS, 15148),
	HAZELMERE("Hazelmere's Island", GameAreaType.REGIONS, 10544),
	HUNTER_GUILD("Hunter Guild", GameAreaType.REGIONS, 6191),
	ICE_PATH("Ice Path", GameAreaType.REGIONS, 11322, 11323),
	ICEBERG("Iceberg", GameAreaType.REGIONS, 10558, 10559),
	ICYENE_GRAVEYARD("Icyene Graveyard", GameAreaType.REGIONS, 14641, 14897, 14898),
	ISAFDAR("Isafdar", GameAreaType.REGIONS, 8497, 8753, 8754, 9009, 9010),
	ISLAND_OF_STONE("Island of Stone", GameAreaType.REGIONS, 9790),
	ISLE_OF_SOULS("Isle of Souls", GameAreaType.REGIONS, 8236, 8237, 8238, 8491, 8492, 8494, 8747, 8750, 9003, 9004, 9006, 9260, 9261, 9262),
	JIGGIG("Jiggig", GameAreaType.REGIONS, 9775),
	KANDARIN("Kandarin", GameAreaType.REGIONS, 9268, 9269, 9014, 9263, 9264, 9519, 9524, 9527, 9776, 9783, 10037, 10290, 10294, 10546, 10551, 10805, 11062),
	KARAMJA("Karamja", GameAreaType.REGIONS,
		regionGameAreas(10801, 10802, 11054, 11311, 11312, 11313, 11566, 11567, 11568, 11569, 11822),
		new RegionArea(11825, new WorldPoint(2944, 3142, 0), new WorldPoint(2960, 3159, 0))),
	KEBOS_LOWLANDS("Kebos Lowlands", GameAreaType.REGIONS, 4665, 4666, 4667, 4921, 5178),
	KEBOS_SWAMP("Kebos Swamp", GameAreaType.REGIONS, 4664, 4920, 5174, 5175, 5176, 5430, 5431),
	KHARAZI_JUNGLE("Kharazi Jungle", GameAreaType.REGIONS, 11053, 11309, 11565, 11821),
	KHARIDIAN_DESERT("Kharidian Desert", GameAreaType.REGIONS, 12587, 12844, 12845, 12846, 12847, 12848, 13100, 13101, 13102, 13103, 13104, 13357, 13359, 13360, 13614, 13615, 13616, 13869, 13870),
	KILLERWATT_PLANE("Killerwatt Plane", GameAreaType.REGIONS, 10577),
	KOUREND("Great Kourend", GameAreaType.REGIONS, 6201, 6457, 6713),
	KOUREND_WOODLAND("Kourend Woodland", GameAreaType.REGIONS, 5942, 6197, 6453),
	LAW_ALTAR("Law Altar", GameAreaType.REGIONS, 9803),
	LEGENDS_GUILD("Legends' Guild", GameAreaType.REGIONS, 10804),
	LIGHTHOUSE("Lighthouse", GameAreaType.REGIONS, 10040),
	LITHKREN("Lithkren", GameAreaType.REGIONS, 14142, 14398),
	LUMBRIDGE_SWAMP("Lumbridge Swamp", GameAreaType.REGIONS, 12593, 12849),
	MAX_ISLAND("Max Island", GameAreaType.REGIONS, new RegionArea(11063, new WorldPoint(2786, 3535, 0), new WorldPoint(2796, 3543, 0))),
	MCGRUBORS_WOOD("McGrubor's Wood", GameAreaType.REGIONS, 10550),
	MIME_STAGE("Mime's Stage", GameAreaType.REGIONS, 8010),
	MIND_ALTAR("Mind Altar", GameAreaType.REGIONS, 11083),
	MISTHALIN("Misthalin", GameAreaType.REGIONS, 12594, 12595, 12851),
	MOLCH("Molch", GameAreaType.REGIONS, 5177),
	MOLCH_ISLAND("Molch Island", GameAreaType.REGIONS, 5432),
	MORYTANIA("Morytania", GameAreaType.REGIONS, 13619, 13620, 13621, 13622, 13876, 13877, 13879, 14133, 14134, 14389, 14390, 14391, 14645, 14647),
	MOUNT_QUIDAMORTEM("Mount Quidamortem", GameAreaType.REGIONS, 4662, 4663, 4918, 4919),
	MR_MORDAUTS_CLASSROOM("Mr. Mordaut's Classroom", GameAreaType.REGIONS, 7502),
	MUDSKIPPER("Mudskipper Point", GameAreaType.REGIONS, 11824),
	MYSTERIOUS_OLD_MAN_MAZE("Mysterious Old Man's Maze", GameAreaType.REGIONS, 11590, 11591, 11846, 11847),
	MYTHS_GUILD("Myths' Guild", GameAreaType.REGIONS, 9772),
	NATURE_ALTAR("Nature Altar", GameAreaType.REGIONS, 9547),
	NECROPOLIS("Necropolis", GameAreaType.REGIONS, 13098, 13353, 13354, 13609, 13610),
	NORTHERN_TUNDRAS("Northern Tundras", GameAreaType.REGIONS, 6204, 6205, 6717),
	OBSERVATORY("Observatory", GameAreaType.REGIONS, 9777),
	ODD_ONE_OUT("Odd One Out", GameAreaType.REGIONS, 7754),
	ORTUS_FARM("Ortus Farm", GameAreaType.REGIONS, 6192, 6193),
	OTTOS_GROTTO("Otto's Grotto", GameAreaType.REGIONS, 10038),
	OURANIA_HUNTER("Ourania Hunter Area", GameAreaType.REGIONS, 9778),
	PINBALL_RANDOM("Pinball", GameAreaType.REGIONS, new RegionArea(7758, new WorldPoint(1964, 5038, 0), new WorldPoint(1980, 5053, 0))),
	PIRATES_COVE("Pirates' Cove", GameAreaType.REGIONS, 8763),
	PISCATORIS_HUNTER_AREA("Piscatoris Hunter Area", GameAreaType.REGIONS, 9015, 9016, 9271, 9272, 9528),
	POH("Player Owned House", GameAreaType.REGIONS, 7513, 7514, 7769, 7770),
	POISON_WASTE("Poison Waste", GameAreaType.REGIONS, 8752, 9008),
	PORT_TYRAS("Port Tyras", GameAreaType.REGIONS, 8496),
	PURO_PURO("Puro Puro", GameAreaType.REGIONS, 10307),
	QUARRY("Quarry", GameAreaType.REGIONS, 12589),
	RALOS_RISE("Ralos' Rise", GameAreaType.REGIONS, 5424, 5425, 5679, 5680, 5681, 5682),
	RANGING_GUILD("Ranging Guild", GameAreaType.REGIONS, 10549),
	RATCATCHERS_MANSION("Ratcatchers Mansion", GameAreaType.REGIONS, 11343),
	RUINS_OF_ULLEK("Ruins of Ullek", GameAreaType.REGIONS, 13355, 13611, 13612),
	RUINS_OF_UNKAH("Ruins of Unkah", GameAreaType.REGIONS, 12588),
	RUNE_ESSENCE_MINE("Rune Essence Mine", GameAreaType.REGIONS, 11595),
	SCAPERUNE("ScapeRune", GameAreaType.REGIONS, 10058, 8261),
	SEA_SPIRIT_DOCK("Sea Spirit Dock", GameAreaType.REGIONS, 12332),
	SHIP_YARD("Ship Yard", GameAreaType.REGIONS, 11823),
	SILVAREA("Silvarea", GameAreaType.REGIONS, 13366),
	SINCLAIR_MANSION("Sinclair Mansion", GameAreaType.REGIONS, 10807),
	SLAYER_TOWER("Slayer Tower", GameAreaType.REGIONS, 13623, 13723),
	SOUL_ALTAR("Soul Altar", GameAreaType.REGIONS, 7228),
	STRANGLEWOOD_TEMPLE("Stranglewood Temple", GameAreaType.REGIONS, 4761),
	SUNSET_COAST("Sunset Coast", GameAreaType.REGIONS, 5934, 6190),
	THE_SCAR("The Scar", GameAreaType.REGIONS, 8036, 8292),
	THE_STRANGLEWOOD("The Stranglewood", GameAreaType.REGIONS, 4403, 4404, 4659, 4660, 4661, 4916, 4917),
	TROLL_ARENA("Troll Arena", GameAreaType.REGIONS, 11576),
	TROLLHEIM("Trollheim", GameAreaType.REGIONS, 11577),
	TROLLWEISS_MTN("Trollweiss Mountain", GameAreaType.REGIONS, 11066, 11067, 11068),
	TUTORIAL_ISLAND("Tutorial Island", GameAreaType.REGIONS, 12079, 12080, 12335, 12336, 12436, 12592),
	UNDERWATER("Underwater", GameAreaType.REGIONS, 15008, 15264),
	WATER_ALTAR("Water Altar", GameAreaType.REGIONS, 10827),
	WATERBIRTH_ISLAND("Waterbirth Island", GameAreaType.REGIONS, 10042),
	WHITE_WOLF_MOUNTAIN("White Wolf Mountain", GameAreaType.REGIONS,
		new RegionArea(11062, new WorldPoint(2790, 3493, 0), new WorldPoint(2815, 3519, 0)),
		new RegionArea(11063, new WorldPoint(2795, 3520, 0), new WorldPoint(2815, 3530, 0)),
		new RegionArea(11317, new WorldPoint(2850, 3443, 0), new WorldPoint(2877, 3455, 0)),
		new RegionArea(11318, new WorldPoint(2816, 3495, 0), new WorldPoint(2879, 3519, 0)),
		new RegionArea(11318, new WorldPoint(2830, 3474, 0), new WorldPoint(2872, 3494, 0)),
		new RegionArea(11318, new WorldPoint(2834, 3462, 0), new WorldPoint(2874, 3473, 0)),
		new RegionArea(11318, new WorldPoint(2843, 3456, 0), new WorldPoint(2879, 3461, 0)),
		new RegionArea(11319, new WorldPoint(2816, 3520, 0), new WorldPoint(2873, 3529, 0))),
	WINTERTODT_CAMP("Wintertodt Camp", GameAreaType.REGIONS, 6461),
	WIZARDS_TOWER("Wizards' Tower", GameAreaType.REGIONS, 12337),
	WOODCUTTING_GUILD("Woodcutting Guild", GameAreaType.REGIONS, 6198, 6454),
	WRATH_ALTAR("Wrath Altar", GameAreaType.REGIONS, 9291),
	;

	private final String state;
	private final GameAreaType gameAreaType;
	private final List<RegionArea> regionAreas;

	@Getter(AccessLevel.NONE)
	private Set<Integer> fullRegions;

	GameArea(String areaName, GameAreaType areaType, int... regionIds)
	{
		this(areaName, areaType, regionGameAreas(regionIds));
	}

	GameArea(String areaName, GameAreaType areaType, RegionArea... regionAreas)
	{
		this(areaName, areaType, ImmutableList.copyOf(regionAreas));
	}

	GameArea(String areaName, GameAreaType areaType, List<RegionArea> regionAreas, RegionArea... regionArea)
	{
		final ImmutableList.Builder<RegionArea> allAreas = ImmutableList.builder();
		allAreas.addAll(regionAreas);
		allAreas.add(regionArea);

		this.state = areaName;
		this.gameAreaType = areaType;
		this.regionAreas = allAreas.build();
	}

	@Getter
	@RequiredArgsConstructor
	public static class RegionArea
	{
		private final int region;
		@Nullable
		private WorldArea area; // NOPMD: ImmutableField

		/**
		 * Create a {@code RegionArea} in a given region of the area containing the given southwest and northeast corners.
		 *
		 * @param region   Region the area is within
		 * @param swCorner Southwest corner of the area
		 * @param neCorner Northeast corner of the area
		 */
		private RegionArea(final int region, final WorldPoint swCorner, final WorldPoint neCorner)
		{
			this.region = region;
			this.area = new WorldArea(swCorner, neCorner.getX() - swCorner.getX() + 1, neCorner.getY() - swCorner.getY() + 1);
		}
	}

	private static List<RegionArea> regionGameAreas(final int... regionIds)
	{
		return Arrays.stream(regionIds)
			.mapToObj(RegionArea::new)
			.collect(Collectors.toList());
	}

	/**
	 * Get a set complete regions the area contains. (This excludes any sub-regions this area spans to)
	 * <p>
	 * Note: A player is not guaranteed to be in this area if within this region, as another area's sub-region may cover
	 *       the player's location within the region.
	 *
	 * @return A set of full regions which correspond to the area.
	 */
	public Set<Integer> getFullRegions()
	{
		if (fullRegions != null)
		{
			return fullRegions;
		}

		final ImmutableSet.Builder<Integer> regions = ImmutableSet.builder();
		for (final RegionArea regionArea : getRegionAreas())
		{
			if (regionArea.getArea() == null)
			{
				regions.add(regionArea.getRegion());
			}
		}
		fullRegions = regions.build();
		return fullRegions;
	}

	/**
	 * Check if the area contains the given point.
	 * <p>
	 * Note: Sub-region definitions assume that {@link WorldPoint WorldPoints} will be translated from instances, such
	 *       as via {@link WorldPoint#fromLocalInstance(Client, LocalPoint)}. Points from instances will not return the
	 *       correct value otherwise.
	 *
	 * @param worldPoint The point to check whether is contained in the area.
	 * @return {@code true} if a region or sub-region of the area contains {@code worldPoint}, {@code false} otherwise.
	 */
	public boolean contains(final WorldPoint worldPoint)
	{
		for (final RegionArea regionArea : getRegionAreas())
		{
			final WorldArea subRegion = regionArea.getArea();
			if ((subRegion != null && subRegion.contains2D(worldPoint))
				|| worldPoint.getRegionID() == regionArea.getRegion())
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the area fully covers the given region.
	 *
	 * @param regionId ID of the region to check whether is contained in the area.
	 * @return {@code true} if the region is fully covered by the area, {@code false} otherwise.
	 */
	public boolean containsRegion(final int regionId)
	{
		return getFullRegions().contains(regionId);
	}

	/**
	 * Check if the given region is fully covered by any of the given game areas.
	 *
	 * @param regionId  ID of the region to check whether is fully contained in any of the given areas.
	 * @param gameAreas Areas to check whether they contain the given region.
	 * @return {@code true} if the region is fully covered by any of the given areas, {@code false} otherwise.
	 */
	public static boolean anyContainsRegion(final int regionId, final GameArea... gameAreas)
	{
		for (final GameArea gameArea : gameAreas)
		{
			if (gameArea.containsRegion(regionId))
			{
				return true;
			}
		}
		return false;
	}
}
