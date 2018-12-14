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
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.Skill;

public class HiscoreResultBuilder
{
	private String player;
	private final List<Skill> skills = new ArrayList<>();

	public void setPlayer(String player)
	{
		this.player = player;
	}

	public void setNextSkill(Skill skill)
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
		hiscoreResult.setOverall(skills.get(0));
		hiscoreResult.setAttack(skills.get(1));
		hiscoreResult.setDefence(skills.get(2));
		hiscoreResult.setStrength(skills.get(3));
		hiscoreResult.setHitpoints(skills.get(4));
		hiscoreResult.setRanged(skills.get(5));
		hiscoreResult.setPrayer(skills.get(6));
		hiscoreResult.setMagic(skills.get(7));
		hiscoreResult.setCooking(skills.get(8));
		hiscoreResult.setWoodcutting(skills.get(9));
		hiscoreResult.setFletching(skills.get(10));
		hiscoreResult.setFishing(skills.get(11));
		hiscoreResult.setFiremaking(skills.get(12));
		hiscoreResult.setCrafting(skills.get(13));
		hiscoreResult.setSmithing(skills.get(14));
		hiscoreResult.setMining(skills.get(15));
		hiscoreResult.setHerblore(skills.get(16));
		hiscoreResult.setAgility(skills.get(17));
		hiscoreResult.setThieving(skills.get(18));
		hiscoreResult.setSlayer(skills.get(19));
		hiscoreResult.setFarming(skills.get(20));
		hiscoreResult.setRunecraft(skills.get(21));
		hiscoreResult.setHunter(skills.get(22));
		hiscoreResult.setConstruction(skills.get(23));
		hiscoreResult.setBountyHunterHunter(skills.get(24));
		hiscoreResult.setBountyHunterRogue(skills.get(25));
		hiscoreResult.setClueScrollAll(skills.get(26));
		hiscoreResult.setClueScrollEasy(skills.get(27));
		hiscoreResult.setClueScrollMedium(skills.get(28));
		hiscoreResult.setClueScrollHard(skills.get(29));
		hiscoreResult.setClueScrollElite(skills.get(30));
		hiscoreResult.setClueScrollMaster(skills.get(31));
		hiscoreResult.setLastManStanding(skills.get(32));
		return hiscoreResult;
	}
}
