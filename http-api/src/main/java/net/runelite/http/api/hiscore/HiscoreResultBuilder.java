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

import java.util.ArrayList;
import java.util.List;

class HiscoreResultBuilder
{
	private String player;
	private final List<Skill> skills = new ArrayList<>();

	public void setPlayer(String player)
	{
		this.player = player;
	}

	void setNextSkill(Skill skill)
	{
		skills.add(skill);
	}

	public Skill getSkill(int index)
	{
		return skills.get(index);
	}

	public HiscoreResult build()
	{
		HiscoreResult hiscoreResult = new HiscoreResult();
		hiscoreResult.setPlayer(player);
		int index = 0;
		hiscoreResult.setOverall(skills.get(index++));
		hiscoreResult.setAttack(skills.get(index++));
		hiscoreResult.setDefence(skills.get(index++));
		hiscoreResult.setStrength(skills.get(index++));
		hiscoreResult.setHitpoints(skills.get(index++));
		hiscoreResult.setRanged(skills.get(index++));
		hiscoreResult.setPrayer(skills.get(index++));
		hiscoreResult.setMagic(skills.get(index++));
		hiscoreResult.setCooking(skills.get(index++));
		hiscoreResult.setWoodcutting(skills.get(index++));
		hiscoreResult.setFletching(skills.get(index++));
		hiscoreResult.setFishing(skills.get(index++));
		hiscoreResult.setFiremaking(skills.get(index++));
		hiscoreResult.setCrafting(skills.get(index++));
		hiscoreResult.setSmithing(skills.get(index++));
		hiscoreResult.setMining(skills.get(index++));
		hiscoreResult.setHerblore(skills.get(index++));
		hiscoreResult.setAgility(skills.get(index++));
		hiscoreResult.setThieving(skills.get(index++));
		hiscoreResult.setSlayer(skills.get(index++));
		hiscoreResult.setFarming(skills.get(index++));
		hiscoreResult.setRunecraft(skills.get(index++));
		hiscoreResult.setHunter(skills.get(index++));
		hiscoreResult.setConstruction(skills.get(index++));
		hiscoreResult.setLeaguePoints(skills.get(index++));
		hiscoreResult.setBountyHunterHunter(skills.get(index++));
		hiscoreResult.setBountyHunterRogue(skills.get(index++));
		hiscoreResult.setClueScrollAll(skills.get(index++));
		hiscoreResult.setClueScrollBeginner(skills.get(index++));
		hiscoreResult.setClueScrollEasy(skills.get(index++));
		hiscoreResult.setClueScrollMedium(skills.get(index++));
		hiscoreResult.setClueScrollHard(skills.get(index++));
		hiscoreResult.setClueScrollElite(skills.get(index++));
		hiscoreResult.setClueScrollMaster(skills.get(index++));
		hiscoreResult.setLastManStanding(skills.get(index++));
		// seasonal doesn't have boss hiscores
		if (index < skills.size())
		{
			hiscoreResult.setAbyssalSire(skills.get(index++));
			hiscoreResult.setAlchemicalHydra(skills.get(index++));
			hiscoreResult.setBarrowsChests(skills.get(index++));
			hiscoreResult.setBryophyta(skills.get(index++));
			hiscoreResult.setCallisto(skills.get(index++));
			hiscoreResult.setCerberus(skills.get(index++));
			hiscoreResult.setChambersOfXeric(skills.get(index++));
			hiscoreResult.setChambersOfXericChallengeMode(skills.get(index++));
			hiscoreResult.setChaosElemental(skills.get(index++));
			hiscoreResult.setChaosFanatic(skills.get(index++));
			hiscoreResult.setCommanderZilyana(skills.get(index++));
			hiscoreResult.setCorporealBeast(skills.get(index++));
			hiscoreResult.setCrazyArchaeologist(skills.get(index++));
			hiscoreResult.setDagannothPrime(skills.get(index++));
			hiscoreResult.setDagannothRex(skills.get(index++));
			hiscoreResult.setDagannothSupreme(skills.get(index++));
			hiscoreResult.setDerangedArchaeologist(skills.get(index++));
			hiscoreResult.setGeneralGraardor(skills.get(index++));
			hiscoreResult.setGiantMole(skills.get(index++));
			hiscoreResult.setGrotesqueGuardians(skills.get(index++));
			hiscoreResult.setHespori(skills.get(index++));
			hiscoreResult.setKalphiteQueen(skills.get(index++));
			hiscoreResult.setKingBlackDragon(skills.get(index++));
			hiscoreResult.setKraken(skills.get(index++));
			hiscoreResult.setKreearra(skills.get(index++));
			hiscoreResult.setKrilTsutsaroth(skills.get(index++));
			hiscoreResult.setMimic(skills.get(index++));
			hiscoreResult.setObor(skills.get(index++));
			hiscoreResult.setSarachnis(skills.get(index++));
			hiscoreResult.setScorpia(skills.get(index++));
			hiscoreResult.setSkotizo(skills.get(index++));
			hiscoreResult.setGauntlet(skills.get(index++));
			hiscoreResult.setCorruptedGauntlet(skills.get(index++));
			hiscoreResult.setTheatreOfBlood(skills.get(index++));
			hiscoreResult.setThermonuclearSmokeDevil(skills.get(index++));
			hiscoreResult.setTzKalZuk(skills.get(index++));
			hiscoreResult.setTzTokJad(skills.get(index++));
			hiscoreResult.setVenenatis(skills.get(index++));
			hiscoreResult.setVetion(skills.get(index++));
			hiscoreResult.setVorkath(skills.get(index++));
			hiscoreResult.setWintertodt(skills.get(index++));
			hiscoreResult.setZalcano(skills.get(index++));
			hiscoreResult.setZulrah(skills.get(index++));
		}
		return hiscoreResult;
	}
}
