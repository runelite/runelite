/*
 * Copyright (c) 2020, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.itemstats;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemStatEffectTest
{
	private static final ImmutableMap<Integer, Integer> REVITALISATION_TABLE;

	static
	{
		// https://oldschool.runescape.wiki/w/Revitalisation_(+)#Maximum_stat_restoration
		REVITALISATION_TABLE = new ImmutableMap.Builder<Integer, Integer>()
			.put(1, 11)     .put(50, 26)
			.put(3, 11)     .put(53, 26)
			.put(4, 12)     .put(54, 27)
			.put(6, 12)     .put(56, 27)
			.put(7, 13)     .put(57, 28)
			.put(9, 13)     .put(59, 28)
			.put(10, 14)    .put(60, 29)
			.put(13, 14)    .put(63, 29)
			.put(14, 15)    .put(64, 30)
			.put(16, 15)    .put(66, 30)
			.put(17, 16)    .put(67, 31)
			.put(19, 16)    .put(69, 31)
			.put(20, 17)    .put(70, 32)
			.put(23, 17)    .put(73, 32)
			.put(24, 18)    .put(74, 33)
			.put(26, 18)    .put(76, 33)
			.put(27, 19)    .put(77, 34)
			.put(29, 19)    .put(79, 34)
			.put(30, 20)    .put(80, 35)
			.put(33, 20)    .put(83, 35)
			.put(34, 21)    .put(84, 36)
			.put(36, 21)    .put(86, 36)
			.put(37, 22)    .put(87, 37)
			.put(39, 22)    .put(89, 37)
			.put(40, 23)    .put(90, 38)
			.put(43, 23)    .put(93, 38)
			.put(44, 24)    .put(94, 39)
			.put(46, 24)    .put(96, 39)
			.put(47, 25)    .put(97, 40)
			.put(49, 25)    .put(99, 40)
			.build();
	}

	@Mock
	private Client client;

	private final ItemStatChanges itemStats = new ItemStatChanges();

	@Before
	public void prepare()
	{
		when(client.getBoostedSkillLevel(any(Skill.class)))
			.thenReturn(0);
	}

	@Test
	public void testRevitalisationPlus()
	{
		final Effect item = itemStats.get(ItemID.REVITALISATION_1_20957);
		matchWikiTable(REVITALISATION_TABLE, item);
	}

	private void matchWikiTable(final ImmutableMap<Integer, Integer> table, final Effect item)
	{
		for (final Map.Entry<Integer, Integer> entry : table.entrySet())
		{
			final int level = entry.getKey();
			final int theoretical = entry.getValue();

			when(client.getRealSkillLevel(any(Skill.class)))
				.thenReturn(level);

			final StatChange[] changes = item.calculate(client).getStatChanges();
			for (final StatChange change : changes)
			{
				assertEquals(theoretical, change.getTheoretical());
			}
		}
	}
}
