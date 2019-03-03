/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, PandahRS <https://github.com/PandahRS>
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;

@AllArgsConstructor
@Getter
enum DiscordGameEventType
{

	IN_GAME("In Game", -3),
	IN_MENU("In Menu", -3),
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
	TRAINING_FISHING(Skill.FISHING),
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
	BOSS_CERBERUS("Cerberus", DiscordAreaType.BOSSES, 4883, 5140, 5395),
	BOSS_COMMANDER_ZILYANA("Commander Zilyana", DiscordAreaType.BOSSES, 11602),
	BOSS_DKS("Dagannoth Kings", DiscordAreaType.BOSSES, 11588, 11589),
	BOSS_GENERAL_GRAARDOR("General Graardor", DiscordAreaType.BOSSES, 11347),
	BOSS_GIANT_MOLE("Giant Mole", DiscordAreaType.BOSSES, 6993, 6992),
	BOSS_GROTESQUE_GUARDIANS("Grotesque Guardians", DiscordAreaType.BOSSES, 6727),
	BOSS_HYDRA("Alchemical Hydra", DiscordAreaType.BOSSES, 5536),
	BOSS_KQ("Kalphite Queen", DiscordAreaType.BOSSES, 13972),
	BOSS_KRAKEN("Kraken", DiscordAreaType.BOSSES, 9116),
	BOSS_KREEARRA("Kree'arra", DiscordAreaType.BOSSES, 11346),
	BOSS_KRIL_TSUTSAROTH("K'ril Tsutsaroth", DiscordAreaType.BOSSES, 11603),
	BOSS_SKOTIZO("Skotizo", DiscordAreaType.BOSSES, 6810),
	BOSS_SMOKE_DEVIL("Thermonuclear smoke devil", DiscordAreaType.BOSSES, 9363, 9619),
	BOSS_VORKATH("Vorkath", DiscordAreaType.BOSSES, 9023),
	BOSS_WINTERTODT("Wintertodt", DiscordAreaType.BOSSES, 6462),
	BOSS_ZULRAH("Zulrah", DiscordAreaType.BOSSES, 9007),

	// Cities
	CITY_AL_KHARID("Al Kharid" , DiscordAreaType.CITIES, 13105, 13106),
	CITY_APE_ATOLL("Ape Atoll" , DiscordAreaType.CITIES, 10795, 11051, 10974, 11050),
	CITY_ARCEUUS_HOUSE("Arceuus House" , DiscordAreaType.CITIES, 6459, 6715, 6458, 6714),
	CITY_ARDOUGNE("Ardougne" , DiscordAreaType.CITIES, 10548, 10547, 10292, 10291, 10036, 10035, 9780, 9779),
	CITY_BARBARIAN_VILLAGE("Barbarian Village" , DiscordAreaType.CITIES, 12341),
	CITY_BANDIT_CAMP("Bandit Camp" , DiscordAreaType.CITIES, 12591),
	CITY_BEDABIN_CAMP("Bedabin Camp" , DiscordAreaType.CITIES, 12590),
	CITY_BRIMHAVEN("Brimhaven" , DiscordAreaType.CITIES, 11057, 11058),
	CITY_BURGH_DE_ROTT("Burgh de Rott" , DiscordAreaType.CITIES, 13874, 13873, 14130, 14129),
	CITY_BURTHORPE("Burthorpe" , DiscordAreaType.CITIES, 11319, 11575),
	CITY_CANIFIS("Canifis" , DiscordAreaType.CITIES, 13878),
	CITY_CATHERBY("Catherby" , DiscordAreaType.CITIES, 11317, 11318, 11061),
	CITY_CORSAIR_CAVE("Corsair Cove" , DiscordAreaType.CITIES, 10028, 10284),
	CITY_DORGESH_KAAN("Dorgesh-Kaan" , DiscordAreaType.CITIES, 10835, 10834),
	CITY_DRAYNOR("Draynor" , DiscordAreaType.CITIES, 12338),
	CITY_EDGEVILLE("Edgeville" , DiscordAreaType.CITIES, 12342),
	CITY_ENTRANA("Entrana" , DiscordAreaType.CITIES, 11060, 11316),
	CITY_FALADOR("Falador" , DiscordAreaType.CITIES, 11828, 11572, 11571, 11827, 12084),
	CITY_GOBLIN_VILLAGE("Goblin Village" , DiscordAreaType.CITIES, 11830),
	CITY_GUTANOTH("Gu'Tanoth" , DiscordAreaType.CITIES, 10031),
	CITY_HOSIDIUS_HOUSE("Hosidius House" , DiscordAreaType.CITIES, 6713, 6712, 6455, 6711, 6710, 6965, 6966, 7222, 7223, 6967),
	CITY_JATISZO("Jatizso" , DiscordAreaType.CITIES, 9531),
	CITY_JIGGIG("Jiggig" , DiscordAreaType.CITIES, 9775),
	CITY_KARAMJA("Karamja" , DiscordAreaType.CITIES, 11569, 11568, 11567, 11566, 11313, 11312, 11311),
	CITY_KELDAGRIM("Keldagrim" , DiscordAreaType.CITIES, 11423, 11422, 11679, 11678),
	CITY_LLETYA("Lletya" , DiscordAreaType.CITIES, 9265),
	CITY_LOVAKENGJ_HOUSE("Lovakengj House" , DiscordAreaType.CITIES, 5692, 5948, 5691, 5947, 6203, 6202, 5690, 5946),
	CITY_LUMBRIDGE("Lumbridge" , DiscordAreaType.CITIES, 12850),
	CITY_LUNAR_ISLE("Lunar Isle" , DiscordAreaType.CITIES, 8253, 8252, 8509, 8508),
	CITY_MEIYERDITCH("Meiyerditch" , DiscordAreaType.CITIES, 14132, 14388, 14387, 14386, 14385),
	CITY_MISCELLANIA("Miscellania" , DiscordAreaType.CITIES, 10044, 10300),
	CITY_MOS_LE_HARMLESS("Mos Le'Harmless" , DiscordAreaType.CITIES, 14638),
	CITY_MORTTON("Mort'ton" , DiscordAreaType.CITIES, 13875),
	CITY_MOR_UI_REK("Mor UI Rek" , DiscordAreaType.CITIES, 9808, 9807, 10064, 10063),
	CITY_MOUNT_KARUULM("Mount Karuulm", DiscordAreaType.CITIES, 5179, 4923, 5180),
	CITY_NARDAH("Nardah" , DiscordAreaType.CITIES, 13613),
	CITY_NEITIZNOT("Neitiznot" , DiscordAreaType.CITIES, 9275),
	CITY_PISCATORIS("Piscatoris" , DiscordAreaType.CITIES, 9273),
	CITY_POLLNIVNEACH("Pollnivneach" , DiscordAreaType.CITIES, 13358),
	CITY_PORT_KHAZARD("Port Khazard" , DiscordAreaType.CITIES, 10545),
	CITY_PORT_PHASMATYS("Port Phasmatys" , DiscordAreaType.CITIES, 14646),
	CITY_PORT_SARIM("Port Sarim" , DiscordAreaType.CITIES, 12082),
	CITY_PISCARILIUS_HOUSE("Piscarilius House" , DiscordAreaType.CITIES, 6971, 7227, 6970, 7226),
	CITY_RELLEKKA("Rellekka" , DiscordAreaType.CITIES, 10553),
	CITY_RIMMINGTON("Rimmington" , DiscordAreaType.CITIES, 11826, 11570),
	CITY_SEERS_VILLAGE("Seers' Village" , DiscordAreaType.CITIES, 10806),
	CITY_SHAYZIEN_HOUSE("Shayzien House" , DiscordAreaType.CITIES, 5944, 5943, 6200, 6199, 5688),
	CITY_SHILO_VILLAGE("Shilo Village" , DiscordAreaType.CITIES, 11310),
	CITY_SOPHANEM("Sophanem" , DiscordAreaType.CITIES, 13099),
	CITY_TAI_BWO_WANNAI("Tai Bwo Wannai" , DiscordAreaType.CITIES, 11056, 11055),
	CITY_TAVERLEY("Taverley" , DiscordAreaType.CITIES, 11574, 11573),
	CITY_TREE_GNOME_STRONGHOLD("Tree Gnome Stronghold" , DiscordAreaType.CITIES, 9782, 9781),
	CITY_TREE_GNOME_VILLAGE("Tree Gnome Village" , DiscordAreaType.CITIES, 10033),
	CITY_TROLL_STRONGHOLD("Troll Stronghold" , DiscordAreaType.CITIES, 11321),
	CITY_TYRAS_CAMP("Tyras Camp" , DiscordAreaType.CITIES, 8753, 8752),
	CITY_UZER("Uzer" , DiscordAreaType.CITIES, 13872),
	CITY_VARROCK("Varrock" , DiscordAreaType.CITIES, 12596, 12597, 12598, 12852, 12853, 12854, 13108, 13109, 13110),
	CITY_WITCHHAVEN("Witchaven" , DiscordAreaType.CITIES, 10803),
	CITY_WOODCUTTING_GUILD("Woodcutting Guild", DiscordAreaType.CITIES, 6454, 6198, 6298),
	CITY_YANILLE("Yanille" , DiscordAreaType.CITIES, 10288, 10032),
	CITY_ZANARIS("Zanaris" , DiscordAreaType.CITIES, 9285, 9541, 9540, 9797),
	CITY_ZULANDRA("Zul-Andra" , DiscordAreaType.CITIES, 8751),

	// Dungeons
	DUNGEON_ABANDONED_MINE("Abandoned Mine", DiscordAreaType.DUNGEONS, 13718, 11079, 11078, 11077, 10823, 10822, 10821),
	DUNGEON_AH_ZA_RHOON("Ah Za Rhoon", DiscordAreaType.DUNGEONS, 11666),
	DUNGEON_ANCIENT_CAVERN("Ancient Cavern", DiscordAreaType.DUNGEONS, 6483, 6995),
	DUNGEON_APE_ATOLL("Ape Atoll Dungeon", DiscordAreaType.DUNGEONS, 11150, 10894),
	DUNGEON_ARDY_SEWERS("Ardougne Sewers", DiscordAreaType.DUNGEONS, 10136),
	DUNGEON_ASGARNIAN_ICE_CAVES("Asgarnian Ice Caves", DiscordAreaType.DUNGEONS, 12181),
	DUNGEON_BRIMHAVEN("Brimhaven Dungeon", DiscordAreaType.DUNGEONS, 10901, 10900, 10899, 10645, 10644, 10643),
	DUNGEON_BRINE_RAT_CAVERN("Brine Rat Cavern", DiscordAreaType.DUNGEONS, 10910),
	DUNGEON_CATACOMBS_OF_KOUREND("Catacombs of Kourend", DiscordAreaType.DUNGEONS, 6557, 6556, 6813, 6812),
	DUNGEON_CHASM_OF_FIRE("Chasm of Fire", DiscordAreaType.DUNGEONS, 5789),
	DUNGEON_CLOCK_TOWER("Clock Tower Basement", DiscordAreaType.DUNGEONS, 10390),
	DUNGEON_CORSAIR_COVE("Corsair Cove Dungeon", DiscordAreaType.DUNGEONS, 8076, 8332),
	DUNGEON_CRABCLAW_CAVES("Crabclaw Caves", DiscordAreaType.DUNGEONS, 6553, 6809),
	DUNGEON_DIGSITE("Digsite Dungeon", DiscordAreaType.DUNGEONS, 13465),
	DUNGEON_DORGESHKAAN("Dorgesh-Kaan South Dungeon", DiscordAreaType.DUNGEONS, 10833),
	DUNGEON_DORGESHUUN_MINES("Dorgeshuun Mines", DiscordAreaType.DUNGEONS, 12950, 13206),
	DUNGEON_DRAYNOR_SEWERS("Draynor Sewers", DiscordAreaType.DUNGEONS, 12439, 12438),
	DUNGEON_DWARVEN_MINES("Dwarven Mines", DiscordAreaType.DUNGEONS, 12185, 12184, 12183),
	DUNGEON_EAGLES_PEAK("Eagles' Peak Dungeon", DiscordAreaType.DUNGEONS, 8013),
	DUNGEON_EDGEVILLE("Edgeville Dungeon", DiscordAreaType.DUNGEONS, 12441, 12442, 12443, 12698),
	DUNGEON_ELEMENTAL_WORKSHOP("Elemental Workshop", DiscordAreaType.DUNGEONS, 10906, 7760),
	DUNGEON_ENAKHRAS_TEMPLE("Enakhra's Temple", DiscordAreaType.DUNGEONS, 12423),
	DUNGEON_ENTRANA("Entrana Dungeon", DiscordAreaType.DUNGEONS, 11416),
	DUNGEON_EVIL_CHICKENS_LAIR("Evil Chicken's Lair", DiscordAreaType.DUNGEONS, 9796),
	DUNGEON_EXPERIMENT_CAVE("Experiment Cave", DiscordAreaType.DUNGEONS, 14235, 13979),
	DUNGEON_FREMENNIK_SLAYER("Fremennik Slayer Dungeon", DiscordAreaType.DUNGEONS, 10908, 11164),
	DUNGEON_GOBLIN_CAVE("Goblin Cave", DiscordAreaType.DUNGEONS, 10393),
	DUNGEON_GRAND_TREE_TUNNELS("Grand Tree Tunnels", DiscordAreaType.DUNGEONS, 9882),
	DUNGEON_HAM("H.A.M Dungeon", DiscordAreaType.DUNGEONS, 12694, 10321),
	DUNGEON_JATIZSO_MINES("Jatizo Mines", DiscordAreaType.DUNGEONS, 9631),
	DUNGEON_JIGGIG_BURIAL_TOMB("Jiggig Burial Tomb", DiscordAreaType.DUNGEONS, 9875, 9874),
	DUNGEON_JOGRE("Jogre Dungeon", DiscordAreaType.DUNGEONS, 11412),
	DUNGEON_KARAMJA_VOLCANO("Karamja Volcano", DiscordAreaType.DUNGEONS, 11413, 11414),
	DUNGEON_KARUULM("Karuulm Slayer Dungeon", DiscordAreaType.DUNGEONS, 5280, 5279, 5023, 5535, 5022, 4766, 4510, 4511, 4767, 4768, 4512),
	DUNGEON_KHARAZI("Khazari Dungeon", DiscordAreaType.DUNGEONS, 11153),
	DUNGEON_LIGHTHOUSE("Lighthouse", DiscordAreaType.DUNGEONS, 10140),
	DUNGEON_LIZARDMAN_CAVES("Lizardman Caves", DiscordAreaType.DUNGEONS, 5275),
	DUNGEON_LUMBRIDGE_SWAMP_CAVES("Lumbridge Swamp Caves", DiscordAreaType.DUNGEONS, 12693, 12949),
	DUNGEON_LUNAR_ISLE_MINE("Lunar Isle Mine", DiscordAreaType.DUNGEONS, 9377),
	DUNGEON_MISCELLANIA("Miscellania Dungeon", DiscordAreaType.DUNGEONS, 10144, 10400),
	DUNGEON_MOGRE_CAMP("Mogre Camp", DiscordAreaType.DUNGEONS, 11924),
	DUNGEON_MOS_LE_HARMLESS_CAVES("Mos Le'Harmless Caves", DiscordAreaType.DUNGEONS, 14994, 14995, 15251),
	DUNGEON_MOUSE_HOLE("Mouse Hole", DiscordAreaType.DUNGEONS, 9046),
	DUNGEON_OBSERVATORY("Observatory Dungeon", DiscordAreaType.DUNGEONS, 9362),
	DUNGEON_OGRE_ENCLAVE("Ogre Enclave", DiscordAreaType.DUNGEONS, 10387),
	DUNGEON_QUIDAMORTEM_CAVE("Quidamortem Cave", DiscordAreaType.DUNGEONS, 4763),
	DUNGEON_RASHILIYIAS_TOMB("Rashiliyta's Tomb", DiscordAreaType.DUNGEONS, 11668),
	DUNGEON_SARADOMINSHRINE("Saradomin Shrine (Paterdomus)", DiscordAreaType.DUNGEONS, 13722),
	DUNGEON_SHADE_CATACOMBS("Shade Catacombs", DiscordAreaType.DUNGEONS, 13975),
	DUNGEON_SHAYZIEN_CRYPTS("Shayzien Crypts", DiscordAreaType.DUNGEONS, 6043),
	DUNGEON_SMOKE("Smoke Dungeon", DiscordAreaType.DUNGEONS, 12946, 13202),
	DUNGEON_SOPHANEM("Sophanem Dungeon", DiscordAreaType.DUNGEONS, 13200),
	DUNGEON_STRONGHOLD_SECURITY("Stronghold of Security", DiscordAreaType.DUNGEONS, 7505, 8017, 8530, 9297),
	DUNGEON_TARNS_LAIR("Tarn's Lair", DiscordAreaType.DUNGEONS, 12616, 12615),
	DUNGEON_TAVERLEY("Taverley Dungeon", DiscordAreaType.DUNGEONS, 11673, 11672, 11929, 11928, 11417),
	DUNGEON_TEMPLE_OF_IKOV("Temple of Ikov", DiscordAreaType.DUNGEONS, 10649, 10905, 10650),
	DUNGEON_TEMPLE_OF_MARIMBO("Temple of Marimbo", DiscordAreaType.DUNGEONS, 11151),
	DUNGEON_THE_WARRENS("The Warrens", DiscordAreaType.DUNGEONS, 7070, 7326),
	DUNGEON_TOLNA("Dungeon of Tolna", DiscordAreaType.DUNGEONS, 13209),
	DUNGEON_TOWER_OF_LIFE("Tower of Life Basement", DiscordAreaType.DUNGEONS, 12100),
	DUNGEON_TUNNEL_OF_CHAOS("Tunnel of Chaos", DiscordAreaType.DUNGEONS, 12625),
	DUNGEON_UNDERGROUND_PASS("Underground Pass", DiscordAreaType.DUNGEONS, 9369, 9370),
	DUNGEON_VARROCKSEWERS("Varrock Sewers", DiscordAreaType.DUNGEONS, 12954, 13210),
	DUNGEON_WATER_RAVINE("Water Ravine", DiscordAreaType.DUNGEONS, 13461),
	DUNGEON_WATERBIRTH("Waterbirth Dungeon", DiscordAreaType.DUNGEONS, 9886, 10142, 7492, 7748),
	DUNGEON_WATERFALL("Waterfall Dungeon", DiscordAreaType.DUNGEONS, 10394),
	DUNGEON_WHITE_WOLF_MOUNTAIN_CAVES("White Wolf Mountain Caves", DiscordAreaType.DUNGEONS, 11418, 11419, 11675),
	DUNGEON_WITCHAVEN_SHRINE("Witchhaven Shrine Dungeon", DiscordAreaType.DUNGEONS, 10903),
	DUNGEON_YANILLE_AGILITY("Yanile Agility Dungeon", DiscordAreaType.DUNGEONS, 10388),
	DUNGEON_MOTHERLODE_MINE("Motherlode Mine", DiscordAreaType.DUNGEONS, 14679, 14680, 14681, 14935, 14936, 14937, 15191, 15192, 15193),

	// Minigames
	MG_BARBARIAN_ASSAULT("Barbarian Assault", DiscordAreaType.MINIGAMES, 10332),
	MG_BARROWS("Barrows", DiscordAreaType.MINIGAMES, 14131, 14231),
	MG_BLAST_FURNACE("Blast Furnace", DiscordAreaType.MINIGAMES, 7757),
	MG_BRIMHAVEN_AGILITY_ARENA("Brimhaven Agility Arena", DiscordAreaType.MINIGAMES, 11157),
	MG_BURTHORPE_GAMES_ROOM("Burthorpe Games Room", DiscordAreaType.MINIGAMES, 8781),
	MG_CASTLE_WARS("Castle Wars", DiscordAreaType.MINIGAMES, 9520),
	MG_CLAN_WARS("Clan Wars", DiscordAreaType.MINIGAMES, 13135, 13134, 13133, 13131, 13130, 13387, 13386),
	MG_DUEL_ARENA("Duel Arena", DiscordAreaType.MINIGAMES, 13362),
	MG_FISHING_TRAWLER("Fishing Trawler", DiscordAreaType.MINIGAMES, 7499),
	MG_INFERNO("The Inferno", DiscordAreaType.MINIGAMES, 9043),
	MG_LAST_MAN_STANDING("Last Man Standing", DiscordAreaType.MINIGAMES, 13660, 13659, 13658, 13916, 13915, 13914),
	MG_MAGE_TRAINING_ARENA("Mage Training Arena", DiscordAreaType.MINIGAMES, 13462, 13463),
	MG_NIGHTMARE_ZONE("Nightmare Zone", DiscordAreaType.MINIGAMES, 9033),
	MG_PEST_CONTROL("Pest Control", DiscordAreaType.MINIGAMES, 10536),
	MG_PYRAMID_PLUNDER("Pyramid Plunder", DiscordAreaType.MINIGAMES, 7749),
	MG_ROGUES_DEN("Rogues' Den", DiscordAreaType.MINIGAMES, 11855, 11854, 12111, 12110),
	MG_SORCERESS_GARDEN("Sorceress's Garden", DiscordAreaType.MINIGAMES, 11605),
	MG_TEMPLE_TREKKING("Temple Trekking", DiscordAreaType.MINIGAMES, 8014, 8270, 8256, 8782, 9038, 9294, 9550, 9806),
	MG_TITHE_FARM("Tithe Farm", DiscordAreaType.MINIGAMES, 6968),
	MG_TROUBLE_BREWING("Trouble Brewing", DiscordAreaType.MINIGAMES, 15150),
	MG_TZHAAR_FIGHT_CAVES("Tzhaar Fight Caves", DiscordAreaType.MINIGAMES, 9551),
	MG_TZHAAR_FIGHT_PITS("Tzhaar Fight Pits", DiscordAreaType.MINIGAMES, 9552),
	MG_VOLCANIC_MINE("Volcanic Mine", DiscordAreaType.MINIGAMES, 15263, 15262),

	// Raids
	RAIDS_CHAMBERS_OF_XERIC("Chambers of Xeric", DiscordAreaType.RAIDS, Varbits.IN_RAID),
	RAIDS_THEATRE_OF_BLOOD("Theatre of Blood", DiscordAreaType.RAIDS, Varbits.THEATRE_OF_BLOOD);

	private static final Map<Integer, DiscordGameEventType> FROM_REGION = new HashMap<>();
	private static final List<DiscordGameEventType> FROM_VARBITS = new ArrayList<>();

	static
	{
		for (DiscordGameEventType discordGameEventType : DiscordGameEventType.values())
		{
			if (discordGameEventType.getVarbits() != null)
			{
				FROM_VARBITS.add(discordGameEventType);
				continue;
			}

			if (discordGameEventType.getRegionIds() == null)
			{
				continue;
			}

			for (int region : discordGameEventType.getRegionIds())
			{
				assert !FROM_REGION.containsKey(region);
				FROM_REGION.put(region, discordGameEventType);
			}
		}
	}

	private String imageKey;
	private String state;
	private String details;
	private int priority;
	private boolean shouldClear;
	private boolean shouldTimeout;

	private DiscordAreaType discordAreaType;
	private Varbits varbits;
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
		this.priority = priority;
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

	DiscordGameEventType(String state, int priority)
	{
		this.state = state;
		this.priority = priority;
		this.shouldClear = true;
	}

	DiscordGameEventType(String areaName, DiscordAreaType areaType, Varbits varbits)
	{
		this.state = exploring(areaType, areaName);
		this.priority = -2;
		this.discordAreaType = areaType;
		this.varbits = varbits;
		this.shouldClear = true;
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

	public static DiscordGameEventType fromVarbit(final Client client)
	{
		for (DiscordGameEventType fromVarbit : FROM_VARBITS)
		{
			if (client.getVar(fromVarbit.getVarbits()) != 0)
			{
				return fromVarbit;
			}
		}

		return null;
	}
}
