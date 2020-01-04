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
package net.runelite.http.api.hiscore;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HiscoreSkill
{
	OVERALL("Overall"),
	ATTACK("Attack"),
	DEFENCE("Defence"),
	STRENGTH("Strength"),
	HITPOINTS("Hitpoints"),
	RANGED("Ranged"),
	PRAYER("Prayer"),
	MAGIC("Magic"),
	COOKING("Cooking"),
	WOODCUTTING("Woodcutting"),
	FLETCHING("Fletching"),
	FISHING("Fishing"),
	FIREMAKING("Firemaking"),
	CRAFTING("Crafting"),
	SMITHING("Smithing"),
	MINING("Mining"),
	HERBLORE("Herblore"),
	AGILITY("Agility"),
	THIEVING("Thieving"),
	SLAYER("Slayer"),
	FARMING("Farming"),
	RUNECRAFT("Runecraft"),
	HUNTER("Hunter"),
	CONSTRUCTION("Construction"),
	LEAGUE_POINTS("League Points"),
	BOUNTY_HUNTER_HUNTER("Bounty Hunter - Hunter"),
	BOUNTY_HUNTER_ROGUE("Bounty Hunter - Rogue"),
	CLUE_SCROLL_ALL("Clue Scrolls (all)"),
	CLUE_SCROLL_BEGINNER("Clue Scrolls (beginner)"),
	CLUE_SCROLL_EASY("Clue Scrolls (easy)"),
	CLUE_SCROLL_MEDIUM("Clue Scrolls (medium)"),
	CLUE_SCROLL_HARD("Clue Scrolls (hard)"),
	CLUE_SCROLL_ELITE("Clue Scrolls (elite)"),
	CLUE_SCROLL_MASTER("Clue Scrolls (master)"),
	LAST_MAN_STANDING("Last Man Standing"),
	ABYSSAL_SIRE("Abyssal Sire"),
	ALCHEMICAL_HYDRA("Alchemical Hydra"),
	BARROWS_CHESTS("Barrows Chests"),
	BRYOPHYTA("Bryophyta"),
	CALLISTO("Callisto"),
	CERBERUS("Cerberus"),
	CHAMBERS_OF_XERIC("Chambers of Xeric"),
	CHAMBERS_OF_XERIC_CHALLENGE_MODE("Chambers of Xeric: Challenge Mode"),
	CHAOS_ELEMENTAL("Chaos Elemental"),
	CHAOS_FANATIC("Chaos Fanatic"),
	COMMANDER_ZILYANA("Commander Zilyana"),
	CORPOREAL_BEAST("Corporeal Beast"),
	CRAZY_ARCHAEOLOGIST("Crazy Archaeologist"),
	DAGANNOTH_PRIME("Dagannoth Prime"),
	DAGANNOTH_REX("Dagannoth Rex"),
	DAGANNOTH_SUPREME("Dagannoth Supreme"),
	DERANGED_ARCHAEOLOGIST("Deranged Archaeologist"),
	GENERAL_GRAARDOR("General Graardor"),
	GIANT_MOLE("Giant Mole"),
	GROTESQUE_GUARDIANS("Grotesque Guardians"),
	HESPORI("Hespori"),
	KALPHITE_QUEEN("Kalphite Queen"),
	KING_BLACK_DRAGON("King Black Dragon"),
	KRAKEN("Kraken"),
	KREEARRA("Kree'Arra"),
	KRIL_TSUTSAROTH("K'ril Tsutsaroth"),
	MIMIC("Mimic"),
	OBOR("Obor"),
	SARACHNIS("Sarachnis"),
	SCORPIA("Scorpia"),
	SKOTIZO("Skotizo"),
	THE_GAUNTLET("The Gauntlet"),
	THE_CORRUPTED_GAUNTLET("The Corrupted Gauntlet"),
	THEATRE_OF_BLOOD("Theatre of Blood"),
	THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil"),
	TZKAL_ZUK("TzKal-Zuk"),
	TZTOK_JAD("TzTok-Jad"),
	VENENATIS("Venenatis"),
	VETION("Vet'ion"),
	VORKATH("Vorkath"),
	WINTERTODT("Wintertodt"),
	ZALCANO("Zalcano"),
	ZULRAH("Zulrah");

	private final String name;
}
