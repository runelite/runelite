/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.xp;

import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.api.xp.XpData;
import net.runelite.http.service.xp.beans.XpEntity;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class XpMapperTest
{
	@Test
	public void testXpEntityToXpData()
	{
		XpEntity xpEntity = new XpEntity();
		xpEntity.setAgility_rank(42);
		xpEntity.setAgility_xp(9001);

		XpData xpData = XpMapper.INSTANCE.xpEntityToXpData(xpEntity);
		assertEquals(42, xpData.getAgility_rank());
		assertEquals(9001, xpData.getAgility_xp());
	}

	@Test
	public void testHiscoreResultToXpData()
	{
		HiscoreResult hiscoreResult = new HiscoreResult();
		hiscoreResult.setAgility(new Skill(42, 9, 9001));

		XpData xpData = XpMapper.INSTANCE.hiscoreResultToXpData(hiscoreResult);
		assertEquals(42, xpData.getAgility_rank());
		assertEquals(9001, xpData.getAgility_xp());
	}

}
