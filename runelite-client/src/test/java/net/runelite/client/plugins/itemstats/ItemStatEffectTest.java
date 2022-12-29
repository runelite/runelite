/*
 * Copyright (c) 2020, TheStonedTurtle <https://github.com/TheStonedTurtle>
 * Copyright (c) 2022, Jordan Atwood <nightfirecat@nightfirec.at>
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
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemStatEffectTest
{
	private static final ImmutableMap<Integer, Integer> REVITALISATION_TABLE;
	private static final ImmutableMap<Integer, Integer> SUPER_RESTORE_TABLE;
	private static final ImmutableMap<Integer, Integer> SANFEW_TABLE;

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

		// https://oldschool.runescape.wiki/w/Super_restore#Maximum_restoration
		SUPER_RESTORE_TABLE = new ImmutableMap.Builder<Integer, Integer>()
			.put(1, 8)      .put(36, 17)    .put(72, 26)
			.put(3, 8)      .put(39, 17)    .put(75, 26)
			.put(4, 9)      .put(40, 18)    .put(76, 27)
			.put(7, 9)      .put(43, 18)    .put(79, 27)
			.put(8, 10)     .put(44, 19)    .put(80, 28)
			.put(11, 10)    .put(47, 19)    .put(83, 28)
			.put(12, 11)    .put(48, 20)    .put(84, 29)
			.put(15, 11)    .put(51, 20)    .put(87, 29)
			.put(16, 12)    .put(52, 21)    .put(88, 30)
			.put(19, 12)    .put(55, 21)    .put(91, 30)
			.put(20, 13)    .put(56, 22)    .put(92, 31)
			.put(23, 13)    .put(59, 22)    .put(95, 31)
			.put(24, 14)    .put(60, 23)    .put(96, 32)
			.put(27, 14)    .put(63, 23)    .put(99, 32)
			.put(28, 15)    .put(64, 24)
			.put(31, 15)    .put(67, 24)
			.put(32, 16)    .put(68, 25)
			.put(35, 16)    .put(71, 25)
			.build();

		// https://oldschool.runescape.wiki/w/Sanfew_serum#Maximum_restoration
		SANFEW_TABLE = new ImmutableMap.Builder<Integer, Integer>()
			.put(1, 4)      .put(34, 14)    .put(67, 24)
			.put(3, 4)      .put(36, 14)    .put(69, 24)
			.put(4, 5)      .put(37, 15)    .put(70, 25)
			.put(6, 5)      .put(39, 15)    .put(73, 25)
			.put(7, 6)      .put(40, 16)    .put(74, 26)
			.put(9, 6)      .put(43, 16)    .put(76, 26)
			.put(10, 7)     .put(44, 17)    .put(77, 27)
			.put(13, 7)     .put(46, 17)    .put(79, 27)
			.put(14, 8)     .put(47, 18)    .put(80, 28)
			.put(16, 8)     .put(49, 18)    .put(83, 28)
			.put(17, 9)     .put(50, 19)    .put(84, 29)
			.put(19, 9)     .put(53, 19)    .put(86, 29)
			.put(20, 10)    .put(54, 20)    .put(87, 30)
			.put(23, 10)    .put(56, 20)    .put(89, 30)
			.put(24, 11)    .put(57, 21)    .put(90, 31)
			.put(26, 11)    .put(59, 21)    .put(93, 31)
			.put(27, 12)    .put(60, 22)    .put(94, 32)
			.put(29, 12)    .put(63, 22)    .put(96, 32)
			.put(30, 13)    .put(64, 23)    .put(97, 33)
			.put(33, 13)    .put(66, 23)    .put(99, 33)
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

	@Test
	public void testSuperRestore()
	{
		final Effect item = itemStats.get(ItemID.SUPER_RESTORE1);
		matchWikiTable(SUPER_RESTORE_TABLE, item);
	}

	@Test
	public void testSanfewSerum()
	{
		final Effect item = itemStats.get(ItemID.SANFEW_SERUM1);
		matchWikiTable(SANFEW_TABLE, item);
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

	@Test
	public void testAncientBrew()
	{
		final Effect ancientBrew = new ItemStatChanges().get(ItemID.ANCIENT_BREW4);

		assertEquals(4, skillChange(Skill.PRAYER, 99, 99, ancientBrew));
		assertEquals(11, skillChange(Skill.PRAYER, 99, 90, ancientBrew));
		assertEquals(11, skillChange(Skill.PRAYER, 99, 0, ancientBrew));
		assertEquals(2, skillChange(Skill.PRAYER, 50, 50, ancientBrew));
		assertEquals(7, skillChange(Skill.PRAYER, 50, 40, ancientBrew));
		assertEquals(0, skillChange(Skill.PRAYER, 1, 1, ancientBrew));
		assertEquals(1, skillChange(Skill.PRAYER, 1, 0, ancientBrew));
	}

	@Test
	public void testZamorakBrew()
	{
		final Effect zamorakBrew = new ItemStatChanges().get(ItemID.ZAMORAK_BREW4);

		assertEquals(-10, skillChange(Skill.HITPOINTS, 91, 91, zamorakBrew));
		assertEquals(-9, skillChange(Skill.HITPOINTS, 91, 81, zamorakBrew));
		assertEquals(-8, skillChange(Skill.HITPOINTS, 91, 72, zamorakBrew));
		assertEquals(-7, skillChange(Skill.HITPOINTS, 91, 64, zamorakBrew));
		assertEquals(-3, skillChange(Skill.HITPOINTS, 91, 31, zamorakBrew));
		assertEquals(-3, skillChange(Skill.HITPOINTS, 91, 28, zamorakBrew));
		assertEquals(-3, skillChange(Skill.HITPOINTS, 91, 25, zamorakBrew));
		assertEquals(-2, skillChange(Skill.HITPOINTS, 91, 22, zamorakBrew));
	}

	@Test
	public void testZamorakMix()
	{
		final Effect zamorakMix = new ItemStatChanges().get(ItemID.ZAMORAK_MIX2);

		assertEquals(-10, skillChange(Skill.HITPOINTS, 91, 91, zamorakMix));
		assertEquals(-3, skillChange(Skill.HITPOINTS, 91, 81, zamorakMix));
		assertEquals(-3, skillChange(Skill.HITPOINTS, 91, 78, zamorakMix));
		assertEquals(-3, skillChange(Skill.HITPOINTS, 91, 75, zamorakMix));
		assertEquals(3, skillChange(Skill.HITPOINTS, 91, 31, zamorakMix));
		assertEquals(2, skillChange(Skill.HITPOINTS, 91, 34, zamorakMix));
		assertEquals(2, skillChange(Skill.HITPOINTS, 91, 36, zamorakMix));
		assertEquals(2, skillChange(Skill.HITPOINTS, 91, 38, zamorakMix));
		assertEquals(0, skillChange(Skill.HITPOINTS, 91, 50, zamorakMix));
	}

	@Test
	public void testAmbrosia()
	{
		final Effect ambrosia = new ItemStatChanges().get(ItemID.AMBROSIA_2);

		assertEquals(124, skillChange(Skill.HITPOINTS, 99, 1, ambrosia));
		assertEquals(26, skillChange(Skill.HITPOINTS, 99, 99, ambrosia));
		assertEquals(10, skillChange(Skill.HITPOINTS, 99, 115, ambrosia));
		assertEquals(0, skillChange(Skill.HITPOINTS, 99, 125, ambrosia));

		assertEquals(122, skillChange(Skill.PRAYER, 99, 1, ambrosia));
		assertEquals(24, skillChange(Skill.PRAYER, 99, 99, ambrosia));
		assertEquals(10, skillChange(Skill.PRAYER, 99, 113, ambrosia));
		assertEquals(0, skillChange(Skill.PRAYER, 99, 123, ambrosia));
	}

	@Test
	public void prayerRestoreVariants()
	{
		final ItemContainer equipment = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipment);

		final Effect ppot = new ItemStatChanges().get(ItemID.PRAYER_POTION2);

		// no holy wrench boost for non-imbued ring equipped
		when(equipment.getItem(EquipmentInventorySlot.RING.getSlotIdx())).thenReturn(new Item(ItemID.RING_OF_THE_GODS, 1));
		assertEquals(31, skillChange(Skill.PRAYER, 99, 0, ppot));

		for (final int ring : new int[] { ItemID.RING_OF_THE_GODS_I, ItemID.RING_OF_THE_GODS_I_25252, ItemID.RING_OF_THE_GODS_I_26764 })
		{
			when(equipment.getItem(EquipmentInventorySlot.RING.getSlotIdx())).thenReturn(new Item(ring, 1));
			assertEquals(33, skillChange(Skill.PRAYER, 99, 0, ppot));
		}
	}

	private int skillChange(Skill skill, int maxValue, int currentValue, Effect effect)
	{
		if (effect == null)
		{
			throw new IllegalArgumentException("Applied effect is null");
		}

		when(client.getRealSkillLevel(skill)).thenReturn(maxValue);
		when(client.getBoostedSkillLevel(skill)).thenReturn(currentValue);
		final StatsChanges statsChanges = effect.calculate(client);

		for (final StatChange statChange : statsChanges.getStatChanges())
		{
			if (!statChange.getStat().getName().equals(skill.getName()))
			{
				continue;
			}

			return statChange.getRelative();
		}

		return 0;
	}
}
