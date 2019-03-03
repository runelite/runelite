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
package net.runelite.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ExperienceTest
{
	private static final int XP_FOR_99 = 13_034_431;
	private static final int XP_FOR_126 = 188_884_740;

	@Test
	public void testGetXpForLevel()
	{
		int xp = Experience.getXpForLevel(99);
		Assert.assertEquals(XP_FOR_99, xp);

		xp = Experience.getXpForLevel(126);
		Assert.assertEquals(XP_FOR_126, xp);

		xp = Experience.getXpForLevel(1);
		Assert.assertEquals(0, xp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetXpForHighLevel()
	{
		int xp = Experience.getXpForLevel(Integer.MAX_VALUE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetXpForLowLevel()
	{
		int xp = Experience.getXpForLevel(0);
	}

	@Test
	public void testGetLevelForXp()
	{
		int level = Experience.getLevelForXp(XP_FOR_99);
		Assert.assertEquals(99, level);

		level = Experience.getLevelForXp(XP_FOR_99 - 1);
		Assert.assertEquals(98, level);

		level = Experience.getLevelForXp(XP_FOR_126);
		Assert.assertEquals(126, level);

		level = Experience.getLevelForXp(XP_FOR_126 - 1);
		Assert.assertEquals(125, level);

		level = Experience.getLevelForXp(Integer.MAX_VALUE);
		Assert.assertEquals(126, level);

		level = Experience.getLevelForXp(0);
		Assert.assertEquals(1, level);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetLevelForNegativeXP()
	{
		Experience.getLevelForXp(-1);
	}

	@Test
	public void testGetCombatLevel()
	{
		Assert.assertEquals(126, Experience.getCombatLevel(99, 99, 99, 99, 70, 42, 98));
		Assert.assertEquals(40, Experience.getCombatLevel(27, 22, 1, 36, 64, 45, 1));
	}

	@Test
	public void testLevelMarkersWithEnoughExperienceInBetween()
	{
		final List<Double> expectedList = new ArrayList<>();
		expectedList.add(0.083);
		expectedList.add(0.174);
		expectedList.add(0.276);
		expectedList.add(0.388);
		expectedList.add(0.512);
		expectedList.add(0.650);
		expectedList.add(0.801);
		expectedList.add(0.969);

		final List<Double> actualList = Experience.levelPercentagesBetweenExperience(0, 1000);

		// Use a loop because we want to compare doubles (with only 0.001 precision)
		for (int i = 0; i < actualList.size(); i++)
		{
			Assert.assertEquals(expectedList.get(i), actualList.get(i), 0.001);
		}
	}

	@Test
	public void testLevelMarkersWithNotEnoughExperienceInBetween()
	{
		final List<Double> expected = Collections.emptyList();

		final List<Double> actual = Experience.levelPercentagesBetweenExperience(0, 1);

		Assert.assertEquals(expected, actual);
	}
}
