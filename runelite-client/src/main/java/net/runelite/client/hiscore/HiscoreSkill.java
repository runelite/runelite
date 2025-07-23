/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.hiscore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.gameval.SpriteID;
import static net.runelite.client.hiscore.HiscoreSkillType.ACTIVITY;
import static net.runelite.client.hiscore.HiscoreSkillType.BOSS;
import static net.runelite.client.hiscore.HiscoreSkillType.SKILL;

@AllArgsConstructor
@Getter
public enum HiscoreSkill
{
	OVERALL("Overall", HiscoreSkillType.OVERALL, SpriteID.Staticons2.TOTAL),
	ATTACK("Attack", SKILL, SpriteID.Staticons.ATTACK),
	DEFENCE("Defence", SKILL, SpriteID.Staticons.DEFENCE),
	STRENGTH("Strength", SKILL, SpriteID.Staticons.STRENGTH),
	HITPOINTS("Hitpoints", SKILL, SpriteID.Staticons.HITPOINTS),
	RANGED("Ranged", SKILL, SpriteID.Staticons.RANGED),
	PRAYER("Prayer", SKILL, SpriteID.Staticons.PRAYER),
	MAGIC("Magic", SKILL, SpriteID.Staticons.MAGIC),
	COOKING("Cooking", SKILL, SpriteID.Staticons.COOKING),
	WOODCUTTING("Woodcutting", SKILL, SpriteID.Staticons.WOODCUTTING),
	FLETCHING("Fletching", SKILL, SpriteID.Staticons.FLETCHING),
	FISHING("Fishing", SKILL, SpriteID.Staticons.FISHING),
	FIREMAKING("Firemaking", SKILL, SpriteID.Staticons.FIREMAKING),
	CRAFTING("Crafting", SKILL, SpriteID.Staticons.CRAFTING),
	SMITHING("Smithing", SKILL, SpriteID.Staticons.SMITHING),
	MINING("Mining", SKILL, SpriteID.Staticons.MINING),
	HERBLORE("Herblore", SKILL, SpriteID.Staticons.HERBLORE),
	AGILITY("Agility", SKILL, SpriteID.Staticons.AGILITY),
	THIEVING("Thieving", SKILL, SpriteID.Staticons.THIEVING),
	SLAYER("Slayer", SKILL, SpriteID.Staticons2.SLAYER),
	FARMING("Farming", SKILL, SpriteID.Staticons2.FARMING),
	RUNECRAFT("Runecraft", SKILL, SpriteID.Staticons2.RUNECRAFT),
	HUNTER("Hunter", SKILL, SpriteID.Staticons2.HUNTER),
	CONSTRUCTION("Construction", SKILL, SpriteID.Staticons2.CONSTRUCTION),
	LEAGUE_POINTS("League Points", ACTIVITY, SpriteID.IconActivities25x25.LEAGUE_POINTS),
	BOUNTY_HUNTER_HUNTER("Bounty Hunter - Hunter", ACTIVITY, SpriteID.IconActivities25x25.BOUNTY_HUNTER_HUNTER),
	BOUNTY_HUNTER_ROGUE("Bounty Hunter - Rogue", ACTIVITY, SpriteID.IconActivities25x25.BOUNTY_HUNTER_ROGUE),
	CLUE_SCROLL_ALL("Clue Scrolls (all)", ACTIVITY, SpriteID.IconActivities25x25.CLUE_SCROLL_ALL),
	CLUE_SCROLL_BEGINNER("Clue Scrolls (beginner)", ACTIVITY),
	CLUE_SCROLL_EASY("Clue Scrolls (easy)", ACTIVITY),
	CLUE_SCROLL_MEDIUM("Clue Scrolls (medium)", ACTIVITY),
	CLUE_SCROLL_HARD("Clue Scrolls (hard)", ACTIVITY),
	CLUE_SCROLL_ELITE("Clue Scrolls (elite)", ACTIVITY),
	CLUE_SCROLL_MASTER("Clue Scrolls (master)", ACTIVITY),
	LAST_MAN_STANDING("LMS - Rank", ACTIVITY, SpriteID.IconActivities25x25.LAST_MAN_STANDING),
	PVP_ARENA_RANK("PvP Arena - Rank", ACTIVITY, SpriteID.IconActivities25x25.PVP_ARENA_RANK),
	SOUL_WARS_ZEAL("Soul Wars Zeal", ACTIVITY, SpriteID.IconActivities25x25.SOUL_WARS_ZEAL),
	RIFTS_CLOSED("Rifts closed", ACTIVITY, SpriteID.IconActivities25x25.RIFTS_CLOSED),
	COLOSSEUM_GLORY("Colosseum Glory", ACTIVITY, SpriteID.IconActivities25x25.COLOSSEUM_GLORY),
	COLLECTIONS_LOGGED("Collections Logged", ACTIVITY, SpriteID.IconActivities25x25.COLLECTIONS_LOGGED),
	ABYSSAL_SIRE("Abyssal Sire", BOSS, SpriteID.IconBoss25x25.ABYSSAL_SIRE),
	ALCHEMICAL_HYDRA("Alchemical Hydra", BOSS, SpriteID.IconBoss25x25.ALCHEMICAL_HYDRA),
	AMOXLIATL("Amoxliatl", BOSS, SpriteID.IconBoss25x25.AMOXLIATL),
	ARAXXOR("Araxxor", BOSS, SpriteID.IconBoss25x25.ARAXXOR),
	ARTIO("Artio", BOSS, SpriteID.IconBoss25x25.ARTIO_CALLISTO),
	BARROWS_CHESTS("Barrows Chests", BOSS, SpriteID.IconBoss25x25.BARROWS_CHESTS),
	BRYOPHYTA("Bryophyta", BOSS, SpriteID.IconBoss25x25.BRYOPHYTA),
	CALLISTO("Callisto", BOSS, SpriteID.IconBoss25x25.ARTIO_CALLISTO),
	CALVARION("Calvar'ion", BOSS, SpriteID.IconBoss25x25.CALVARION_VETION),
	CERBERUS("Cerberus", BOSS, SpriteID.IconBoss25x25.CERBERUS),
	CHAMBERS_OF_XERIC("Chambers of Xeric", BOSS, SpriteID.IconBoss25x25.CHAMBERS_OF_XERIC),
	CHAMBERS_OF_XERIC_CHALLENGE_MODE("Chambers of Xeric: Challenge Mode", BOSS, SpriteID.IconBoss25x25.CHAMBERS_OF_XERIC_CHALLENGE_MODE),
	CHAOS_ELEMENTAL("Chaos Elemental", BOSS, SpriteID.IconBoss25x25.CHAOS_ELEMENTAL),
	CHAOS_FANATIC("Chaos Fanatic", BOSS, SpriteID.IconBoss25x25.CHAOS_FANATIC),
	COMMANDER_ZILYANA("Commander Zilyana", BOSS, SpriteID.IconBoss25x25.COMMANDER_ZILYANA),
	CORPOREAL_BEAST("Corporeal Beast", BOSS, SpriteID.IconBoss25x25.CORPOREAL_BEAST),
	CRAZY_ARCHAEOLOGIST("Crazy Archaeologist", BOSS, SpriteID.IconBoss25x25.CRAZY_ARCHAEOLOGIST),
	DAGANNOTH_PRIME("Dagannoth Prime", BOSS, SpriteID.IconBoss25x25.DAGANNOTH_PRIME),
	DAGANNOTH_REX("Dagannoth Rex", BOSS, SpriteID.IconBoss25x25.DAGANNOTH_REX),
	DAGANNOTH_SUPREME("Dagannoth Supreme", BOSS, SpriteID.IconBoss25x25.DAGANNOTH_SUPREME),
	DERANGED_ARCHAEOLOGIST("Deranged Archaeologist", BOSS, SpriteID.IconBoss25x25.DERANGED_ARCHAEOLOGIST),
	DOOM_OF_MOKHAIOTL("Doom of Mokhaiotl", BOSS, SpriteID.IconBoss25x25.DOOM_OF_MOKHAIOTL),
	DUKE_SUCELLUS("Duke Sucellus", BOSS, SpriteID.IconBoss25x25.DUKE_SUCELLUS),
	GENERAL_GRAARDOR("General Graardor", BOSS, SpriteID.IconBoss25x25.GENERAL_GRAARDOR),
	GIANT_MOLE("Giant Mole", BOSS, SpriteID.IconBoss25x25.GIANT_MOLE),
	GROTESQUE_GUARDIANS("Grotesque Guardians", BOSS, SpriteID.IconBoss25x25.GROTESQUE_GUARDIANS),
	HESPORI("Hespori", BOSS, SpriteID.IconBoss25x25.HESPORI),
	KALPHITE_QUEEN("Kalphite Queen", BOSS, SpriteID.IconBoss25x25.KALPHITE_QUEEN),
	KING_BLACK_DRAGON("King Black Dragon", BOSS, SpriteID.IconBoss25x25.KING_BLACK_DRAGON),
	KRAKEN("Kraken", BOSS, SpriteID.IconBoss25x25.KRAKEN),
	KREEARRA("Kree'Arra", BOSS, SpriteID.IconBoss25x25.KREEARRA),
	KRIL_TSUTSAROTH("K'ril Tsutsaroth", BOSS, SpriteID.IconBoss25x25.KRIL_TSUTSAROTH),
	LUNAR_CHESTS("Lunar Chests", BOSS, SpriteID.IconBoss25x25.LUNAR_CHESTS),
	MIMIC("Mimic", BOSS, SpriteID.IconBoss25x25.MIMIC),
	NEX("Nex", BOSS, SpriteID.IconBoss25x25.NEX),
	NIGHTMARE("Nightmare", BOSS, SpriteID.IconBoss25x25.NIGHTMARE),
	PHOSANIS_NIGHTMARE("Phosani's Nightmare", BOSS, SpriteID.IconBoss25x25.NIGHTMARE),
	OBOR("Obor", BOSS, SpriteID.IconBoss25x25.OBOR),
	PHANTOM_MUSPAH("Phantom Muspah", BOSS, SpriteID.IconBoss25x25.PHANTOM_MUSPAH),
	SARACHNIS("Sarachnis", BOSS, SpriteID.IconBoss25x25.SARACHNIS),
	SCORPIA("Scorpia", BOSS, SpriteID.IconBoss25x25.SCORPIA),
	SCURRIUS("Scurrius", BOSS, SpriteID.IconBoss25x25.SCURRIUS),
	SKOTIZO("Skotizo", BOSS, SpriteID.IconBoss25x25.SKOTIZO),
	SOL_HEREDIT("Sol Heredit", BOSS, SpriteID.IconBoss25x25.SOL_HEREDIT),
	SPINDEL("Spindel", BOSS, SpriteID.IconBoss25x25.SPINDEL_VENENATIS),
	TEMPOROSS("Tempoross", BOSS, SpriteID.IconBoss25x25.TEMPOROSS),
	THE_GAUNTLET("The Gauntlet", BOSS, SpriteID.IconBoss25x25.THE_GAUNTLET),
	THE_CORRUPTED_GAUNTLET("The Corrupted Gauntlet", BOSS, SpriteID.IconBoss25x25.THE_CORRUPTED_GAUNTLET),
	THE_HUEYCOATL("The Hueycoatl", BOSS, SpriteID.IconBoss25x25.THE_HUEYCOATL),
	THE_LEVIATHAN("The Leviathan", BOSS, SpriteID.IconBoss25x25.THE_LEVIATHAN),
	THE_ROYAL_TITANS("The Royal Titans", BOSS, SpriteID.IconBoss25x25.ROYAL_TITANS),
	THE_WHISPERER("The Whisperer", BOSS, SpriteID.IconBoss25x25.THE_WHISPERER),
	THEATRE_OF_BLOOD("Theatre of Blood", BOSS, SpriteID.IconBoss25x25.THEATRE_OF_BLOOD),
	THEATRE_OF_BLOOD_HARD_MODE("Theatre of Blood: Hard Mode", BOSS, SpriteID.IconBoss25x25.THEATRE_OF_BLOOD),
	THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil", BOSS, SpriteID.IconBoss25x25.THERMONUCLEAR_SMOKE_DEVIL),
	TOMBS_OF_AMASCUT("Tombs of Amascut", BOSS, SpriteID.IconBoss25x25.TOMBS_OF_AMASCUT),
	TOMBS_OF_AMASCUT_EXPERT("Tombs of Amascut: Expert Mode", BOSS, SpriteID.IconBoss25x25.TOMBS_OF_AMASCUT_EXPERT),
	TZKAL_ZUK("TzKal-Zuk", BOSS, SpriteID.IconBoss25x25.TZKAL_ZUK),
	TZTOK_JAD("TzTok-Jad", BOSS, SpriteID.IconBoss25x25.TZTOK_JAD),
	VARDORVIS("Vardorvis", BOSS, SpriteID.IconBoss25x25.VARDORVIS),
	VENENATIS("Venenatis", BOSS, SpriteID.IconBoss25x25.SPINDEL_VENENATIS),
	VETION("Vet'ion", BOSS, SpriteID.IconBoss25x25.CALVARION_VETION),
	VORKATH("Vorkath", BOSS, SpriteID.IconBoss25x25.VORKATH),
	WINTERTODT("Wintertodt", BOSS, SpriteID.IconBoss25x25.WINTERTODT),
	YAMA("Yama", BOSS, SpriteID.IconBoss25x25.YAMA),
	ZALCANO("Zalcano", BOSS, SpriteID.IconBoss25x25.ZALCANO),
	ZULRAH("Zulrah", BOSS, SpriteID.IconBoss25x25.ZULRAH);

	private final String name;
	private final HiscoreSkillType type;
	private final int spriteId;

	HiscoreSkill(String name, HiscoreSkillType type)
	{
		this.name = name;
		this.type = type;
		this.spriteId = -1;
	}
}
