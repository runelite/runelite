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

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;

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
	BOSS_KQ("Kalphite Queen", DiscordAreaType.BOSSES, 13972),
	BOSS_KRAKEN("Kraken", DiscordAreaType.BOSSES, 9116),
	BOSS_KREEARRA("Kree'arra", DiscordAreaType.BOSSES, 11346),
	BOSS_KRIL_TSUTSAROTH("K'ril Tsutsaroth", DiscordAreaType.BOSSES, 11603),
	BOSS_SKOTIZO("Skotizo", DiscordAreaType.BOSSES, 6810),
	BOSS_SMOKE_DEVIL("Thermonuclear smoke devil", DiscordAreaType.BOSSES, 9363, 9619),
	BOSS_VORKATH("Vorkath", DiscordAreaType.BOSSES, 9023),
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
	CITY_BURTHOPE("Burthope" , DiscordAreaType.CITIES, 11319, 11575),
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
	CITY_YANILLE("Yanille" , DiscordAreaType.CITIES, 10288, 10032),
	CITY_ZANARIS("Zanaris" , DiscordAreaType.CITIES, 9285, 9541, 9540, 9797),
	CITY_ZULANDRA("Zul-Andra" , DiscordAreaType.CITIES, 8751);

	private static final Map<Integer, DiscordGameEventType> FROM_REGION = new HashMap<>();

	static
	{
		for (DiscordGameEventType discordGameEventType : DiscordGameEventType.values())
		{
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
	private int[] regionIds;

	DiscordGameEventType(Skill skill)
	{
		this(skill, 0);
	}

	DiscordGameEventType(Skill skill, int priority)
	{
		this.state = training(skill);
		this.priority = priority;
		this.imageKey = imageKeyOf(skill);
		this.priority = priority;
		this.shouldTimeout = true;
	}

	DiscordGameEventType(String areaName, DiscordAreaType areaType, int... regionIds)
	{
		this.details = exploring(areaType, areaName);
		this.priority = -2;
		this.discordAreaType = areaType;
		this.regionIds = regionIds;
		this.shouldClear = true;
	}

	DiscordGameEventType(String state, int priority)
	{
		this.details = state;
		this.priority = priority;
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
		switch (areaType)
		{
			case BOSSES:
				return "Fighting: " + areaName;
			case DUNGEONS:
				return "Exploring: " + areaName;
			case CITIES:
				return "Location: " + areaName;
			case MINIGAMES:
				return "Playing: " + areaName;
		}

		return "";
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
