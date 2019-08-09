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

	public Skill getSkill(HiscoreSkill skill)
	{
		switch (skill)
		{
			case ATTACK:
				return getAttack();
			case DEFENCE:
				return getDefence();
			case STRENGTH:
				return getStrength();
			case HITPOINTS:
				return getHitpoints();
			case RANGED:
				return getRanged();
			case PRAYER:
				return getPrayer();
			case MAGIC:
				return getMagic();
			case COOKING:
				return getCooking();
			case WOODCUTTING:
				return getWoodcutting();
			case FLETCHING:
				return getFletching();
			case FISHING:
				return getFishing();
			case FIREMAKING:
				return getFiremaking();
			case CRAFTING:
				return getCrafting();
			case SMITHING:
				return getSmithing();
			case MINING:
				return getMining();
			case HERBLORE:
				return getHerblore();
			case AGILITY:
				return getAgility();
			case THIEVING:
				return getThieving();
			case SLAYER:
				return getSlayer();
			case FARMING:
				return getFarming();
			case RUNECRAFT:
				return getRunecraft();
			case HUNTER:
				return getHunter();
			case CONSTRUCTION:
				return getConstruction();
			case OVERALL:
				return getOverall();
			case BOUNTY_HUNTER_HUNTER:
				return getBountyHunterHunter();
			case BOUNTY_HUNTER_ROGUE:
				return getBountyHunterRogue();
			case CLUE_SCROLL_ALL:
				return getClueScrollAll();
			case CLUE_SCROLL_BEGINNER:
				return getClueScrollBeginner();
			case CLUE_SCROLL_EASY:
				return getClueScrollEasy();
			case CLUE_SCROLL_MEDIUM:
				return getClueScrollMedium();
			case CLUE_SCROLL_HARD:
				return getClueScrollHard();
			case CLUE_SCROLL_ELITE:
				return getClueScrollElite();
			case CLUE_SCROLL_MASTER:
				return getClueScrollMaster();
			case LAST_MAN_STANDING:
				return getLastManStanding();
		}

		throw new IllegalArgumentException("Invalid hiscore item");
	}
}
