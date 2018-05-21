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
package net.runelite.client.plugins.hiscore;

import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.Skill;
import org.junit.Test;

public class HiscorePanelTest
{
	@Test
	public void testConstructor()
	{
		new HiscorePanel(new HiscoreConfig()
		{
		});
	}

	@Test
	public void testApplyResult()
	{
		HiscorePanel hiscorePanel = new HiscorePanel(new HiscoreConfig()
		{
		});

		HiscoreResult hiscoreResult = new HiscoreResult();
		Skill unranked = new Skill(-1, -1, -1);
		hiscoreResult.setOverall(unranked);
		hiscoreResult.setAttack(new Skill(1, 1, 1));
		hiscoreResult.setDefence(unranked);
		hiscoreResult.setStrength(unranked);
		hiscoreResult.setHitpoints(unranked);
		hiscoreResult.setRanged(unranked);
		hiscoreResult.setPrayer(unranked);
		hiscoreResult.setMagic(unranked);
		hiscoreResult.setCooking(unranked);
		hiscoreResult.setWoodcutting(unranked);
		hiscoreResult.setFletching(unranked);
		hiscoreResult.setFishing(unranked);
		hiscoreResult.setFiremaking(unranked);
		hiscoreResult.setCrafting(unranked);
		hiscoreResult.setSmithing(unranked);
		hiscoreResult.setMining(unranked);
		hiscoreResult.setHerblore(unranked);
		hiscoreResult.setAgility(unranked);
		hiscoreResult.setThieving(unranked);
		hiscoreResult.setSlayer(new Skill(2, 2, 2));
		hiscoreResult.setFarming(unranked);
		hiscoreResult.setRunecraft(unranked);
		hiscoreResult.setHunter(unranked);
		hiscoreResult.setConstruction(unranked);
		hiscoreResult.setClueScrollEasy(unranked);
		hiscoreResult.setClueScrollMedium(unranked);
		hiscoreResult.setClueScrollAll(unranked);
		hiscoreResult.setBountyHunterRogue(unranked);
		hiscoreResult.setBountyHunterHunter(unranked);
		hiscoreResult.setClueScrollHard(unranked);
		hiscoreResult.setLastManStanding(unranked);
		hiscoreResult.setClueScrollElite(unranked);
		hiscoreResult.setClueScrollMaster(unranked);

		hiscorePanel.applyResult(hiscoreResult);
	}

}
