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

import lombok.Data;

@Data
public class HiscoreResult
{
	private String player;
	private Skill overall;
	private Skill attack;
	private Skill defence;
	private Skill strength;
	private Skill hitpoints;
	private Skill ranged;
	private Skill prayer;
	private Skill magic;
	private Skill cooking;
	private Skill woodcutting;
	private Skill fletching;
	private Skill fishing;
	private Skill firemaking;
	private Skill crafting;
	private Skill smithing;
	private Skill mining;
	private Skill herblore;
	private Skill agility;
	private Skill thieving;
	private Skill slayer;
	private Skill farming;
	private Skill runecraft;
	private Skill hunter;
	private Skill construction;
	private Skill leaguePoints;
	private Skill bountyHunterHunter;
	private Skill bountyHunterRogue;
	private Skill clueScrollAll;
	private Skill clueScrollBeginner;
	private Skill clueScrollEasy;
	private Skill clueScrollMedium;
	private Skill clueScrollHard;
	private Skill clueScrollElite;
	private Skill clueScrollMaster;
	private Skill lastManStanding;
	private Skill soulWarsZeal;
	private Skill riftsClosed;
	private Skill abyssalSire;
	private Skill alchemicalHydra;
	private Skill barrowsChests;
	private Skill bryophyta;
	private Skill callisto;
	private Skill cerberus;
	private Skill chambersOfXeric;
	private Skill chambersOfXericChallengeMode;
	private Skill chaosElemental;
	private Skill chaosFanatic;
	private Skill commanderZilyana;
	private Skill corporealBeast;
	private Skill crazyArchaeologist;
	private Skill dagannothPrime;
	private Skill dagannothRex;
	private Skill dagannothSupreme;
	private Skill derangedArchaeologist;
	private Skill generalGraardor;
	private Skill giantMole;
	private Skill grotesqueGuardians;
	private Skill hespori;
	private Skill kalphiteQueen;
	private Skill kingBlackDragon;
	private Skill kraken;
	private Skill kreearra;
	private Skill krilTsutsaroth;
	private Skill mimic;
	private Skill nex;
	private Skill nightmare;
	private Skill phosanisNightmare;
	private Skill obor;
	private Skill sarachnis;
	private Skill scorpia;
	private Skill skotizo;
	private Skill tempoross;
	private Skill gauntlet;
	private Skill corruptedGauntlet;
	private Skill theatreOfBlood;
	private Skill theatreOfBloodHardMode;
	private Skill thermonuclearSmokeDevil;
	private Skill tzKalZuk;
	private Skill tzTokJad;
	private Skill venenatis;
	private Skill vetion;
	private Skill vorkath;
	private Skill wintertodt;
	private Skill zalcano;
	private Skill zulrah;

	public Skill getSkill(HiscoreSkill skill)
	{
		switch (skill)
		{
			case ATTACK:
				return attack;
			case DEFENCE:
				return defence;
			case STRENGTH:
				return strength;
			case HITPOINTS:
				return hitpoints;
			case RANGED:
				return ranged;
			case PRAYER:
				return prayer;
			case MAGIC:
				return magic;
			case COOKING:
				return cooking;
			case WOODCUTTING:
				return woodcutting;
			case FLETCHING:
				return fletching;
			case FISHING:
				return fishing;
			case FIREMAKING:
				return firemaking;
			case CRAFTING:
				return crafting;
			case SMITHING:
				return smithing;
			case MINING:
				return mining;
			case HERBLORE:
				return herblore;
			case AGILITY:
				return agility;
			case THIEVING:
				return thieving;
			case SLAYER:
				return slayer;
			case FARMING:
				return farming;
			case RUNECRAFT:
				return runecraft;
			case HUNTER:
				return hunter;
			case CONSTRUCTION:
				return construction;
			case LEAGUE_POINTS:
				return leaguePoints;
			case OVERALL:
				return overall;
			case BOUNTY_HUNTER_HUNTER:
				return bountyHunterHunter;
			case BOUNTY_HUNTER_ROGUE:
				return bountyHunterRogue;
			case CLUE_SCROLL_ALL:
				return clueScrollAll;
			case CLUE_SCROLL_BEGINNER:
				return clueScrollBeginner;
			case CLUE_SCROLL_EASY:
				return clueScrollEasy;
			case CLUE_SCROLL_MEDIUM:
				return clueScrollMedium;
			case CLUE_SCROLL_HARD:
				return clueScrollHard;
			case CLUE_SCROLL_ELITE:
				return clueScrollElite;
			case CLUE_SCROLL_MASTER:
				return clueScrollMaster;
			case LAST_MAN_STANDING:
				return lastManStanding;
			case SOUL_WARS_ZEAL:
				return soulWarsZeal;
			case RIFTS_CLOSED:
				return riftsClosed;
			case ABYSSAL_SIRE:
				return abyssalSire;
			case ALCHEMICAL_HYDRA:
				return alchemicalHydra;
			case BARROWS_CHESTS:
				return barrowsChests;
			case BRYOPHYTA:
				return bryophyta;
			case CALLISTO:
				return callisto;
			case CERBERUS:
				return cerberus;
			case CHAMBERS_OF_XERIC:
				return chambersOfXeric;
			case CHAMBERS_OF_XERIC_CHALLENGE_MODE:
				return chambersOfXericChallengeMode;
			case CHAOS_ELEMENTAL:
				return chaosElemental;
			case CHAOS_FANATIC:
				return chaosFanatic;
			case COMMANDER_ZILYANA:
				return commanderZilyana;
			case CORPOREAL_BEAST:
				return corporealBeast;
			case CRAZY_ARCHAEOLOGIST:
				return crazyArchaeologist;
			case DAGANNOTH_PRIME:
				return dagannothPrime;
			case DAGANNOTH_REX:
				return dagannothRex;
			case DAGANNOTH_SUPREME:
				return dagannothSupreme;
			case DERANGED_ARCHAEOLOGIST:
				return derangedArchaeologist;
			case GENERAL_GRAARDOR:
				return generalGraardor;
			case GIANT_MOLE:
				return giantMole;
			case GROTESQUE_GUARDIANS:
				return grotesqueGuardians;
			case HESPORI:
				return hespori;
			case KALPHITE_QUEEN:
				return kalphiteQueen;
			case KING_BLACK_DRAGON:
				return kingBlackDragon;
			case KRAKEN:
				return kraken;
			case KREEARRA:
				return kreearra;
			case KRIL_TSUTSAROTH:
				return krilTsutsaroth;
			case MIMIC:
				return mimic;
			case NEX:
				return nex;
			case NIGHTMARE:
				return nightmare;
			case PHOSANIS_NIGHTMARE:
				return phosanisNightmare;
			case OBOR:
				return obor;
			case SARACHNIS:
				return sarachnis;
			case SCORPIA:
				return scorpia;
			case SKOTIZO:
				return skotizo;
			case TEMPOROSS:
				return tempoross;
			case THE_GAUNTLET:
				return gauntlet;
			case THE_CORRUPTED_GAUNTLET:
				return corruptedGauntlet;
			case THEATRE_OF_BLOOD:
				return theatreOfBlood;
			case THEATRE_OF_BLOOD_HARD_MODE:
				return theatreOfBloodHardMode;
			case THERMONUCLEAR_SMOKE_DEVIL:
				return thermonuclearSmokeDevil;
			case TZKAL_ZUK:
				return tzKalZuk;
			case TZTOK_JAD:
				return tzTokJad;
			case VENENATIS:
				return venenatis;
			case VETION:
				return vetion;
			case VORKATH:
				return vorkath;
			case WINTERTODT:
				return wintertodt;
			case ZALCANO:
				return zalcano;
			case ZULRAH:
				return zulrah;
			default:
				throw new IllegalArgumentException("Invalid hiscore skill");
		}
	}
}
