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
import net.runelite.api.Varbits;
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
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(mock(ItemContainer.class));
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
		assertEquals(0, skillChange(Skill.PRAYER, 99, 125, ancientBrew));

		assertEquals(5, skillChange(Skill.MAGIC, 65, 1, ancientBrew));
		assertEquals(3, skillChange(Skill.MAGIC, 65, 67, ancientBrew));
		assertEquals(6, skillChange(Skill.MAGIC, 99, 19, ancientBrew));
		assertEquals(6, skillChange(Skill.MAGIC, 99, 99, ancientBrew));

		assertEquals(-1, skillChange(Skill.ATTACK, 99, 1, ancientBrew));
		assertEquals(-9, skillChange(Skill.ATTACK, 79, 79, ancientBrew));
		assertEquals(-11, skillChange(Skill.ATTACK, 99, 99, ancientBrew));
		assertEquals(-13, skillChange(Skill.ATTACK, 99, 118, ancientBrew));

		assertEquals(0, skillChange(Skill.STRENGTH, 1, 0, ancientBrew));
		assertEquals(-2, skillChange(Skill.STRENGTH, 7, 2, ancientBrew));
		assertEquals(-3, skillChange(Skill.STRENGTH, 7, 10, ancientBrew));
		assertEquals(-14, skillChange(Skill.STRENGTH, 99, 120, ancientBrew));
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
	public void testMoonlightPotion()
	{
		final Effect moonlightPotion = new ItemStatChanges().get(ItemID.MOONLIGHT_POTION1);

		when(client.getBoostedSkillLevel(Skill.HERBLORE)).thenReturn(11);
		assertEquals(12, skillChange(Skill.ATTACK, 99, 1, moonlightPotion));
		assertEquals(0, skillChange(Skill.STRENGTH, 99, 99, moonlightPotion));
		assertEquals(0, skillChange(Skill.DEFENCE, 40, 33, moonlightPotion));
		assertEquals(0, skillChange(Skill.PRAYER, 99, 54, moonlightPotion));

		when(client.getBoostedSkillLevel(Skill.HERBLORE)).thenReturn(38);
		assertEquals(12, skillChange(Skill.ATTACK, 99, 99, moonlightPotion));
		assertEquals(12, skillChange(Skill.STRENGTH, 99, 99, moonlightPotion));
		assertEquals(4, skillChange(Skill.DEFENCE, 40, 43, moonlightPotion));
		assertEquals(31, skillChange(Skill.PRAYER, 99, 0, moonlightPotion));
		assertEquals(9, skillChange(Skill.PRAYER, 99, 90, moonlightPotion));

		when(client.getBoostedSkillLevel(Skill.HERBLORE)).thenReturn(54);
		assertEquals(3, skillChange(Skill.ATTACK, 60, 71, moonlightPotion));
		assertEquals(2, skillChange(Skill.STRENGTH, 60, 67, moonlightPotion));
		assertEquals(2, skillChange(Skill.DEFENCE, 60, 67, moonlightPotion));
		assertEquals(31, skillChange(Skill.PRAYER, 99, 10, moonlightPotion));

		when(client.getBoostedSkillLevel(Skill.HERBLORE)).thenReturn(65);
		assertEquals(12, skillChange(Skill.ATTACK, 50, 19, moonlightPotion));
		assertEquals(13, skillChange(Skill.STRENGTH, 58, 22, moonlightPotion));
		assertEquals(0, skillChange(Skill.DEFENCE, 34, 40, moonlightPotion));
		assertEquals(26, skillChange(Skill.PRAYER, 42, 0, moonlightPotion));
		assertEquals(4, skillChange(Skill.PRAYER, 42, 38, moonlightPotion));

		when(client.getBoostedSkillLevel(Skill.HERBLORE)).thenReturn(77);
		assertEquals(30, skillChange(Skill.PRAYER, 77, 18, moonlightPotion));

		when(client.getBoostedSkillLevel(Skill.HERBLORE)).thenReturn(80);
		assertEquals(6, skillChange(Skill.ATTACK, 80, 91, moonlightPotion));
		assertEquals(7, skillChange(Skill.STRENGTH, 92, 103, moonlightPotion));
		assertEquals(8, skillChange(Skill.DEFENCE, 75, 89, moonlightPotion));
		assertEquals(31, skillChange(Skill.PRAYER, 77, 18, moonlightPotion));

		when(client.getBoostedSkillLevel(Skill.HERBLORE)).thenReturn(99);
		assertEquals(19, skillChange(Skill.ATTACK, 99, 99, moonlightPotion));
		assertEquals(19, skillChange(Skill.STRENGTH, 99, 99, moonlightPotion));
		assertEquals(26, skillChange(Skill.DEFENCE, 99, 99, moonlightPotion));
		assertEquals(36, skillChange(Skill.PRAYER, 99, 0, moonlightPotion));

		when(client.getBoostedSkillLevel(Skill.HERBLORE)).thenReturn(102);
		assertEquals(37, skillChange(Skill.PRAYER, 99, 0, moonlightPotion));

		when(client.getBoostedSkillLevel(Skill.HERBLORE)).thenReturn(104);
		assertEquals(33, skillChange(Skill.PRAYER, 34, 1, moonlightPotion));
		assertEquals(38, skillChange(Skill.PRAYER, 54, 0, moonlightPotion));
	}

	@Test
	public void testMoonlightMoth()
	{
		final Effect moonlightMoth = new ItemStatChanges().get(ItemID.MOONLIGHT_MOTH_28893);

		assertEquals(0, skillChange(Skill.PRAYER, 1, 1, moonlightMoth));
		assertEquals(5, skillChange(Skill.PRAYER, 7, 2, moonlightMoth));
		assertEquals(22, skillChange(Skill.PRAYER, 30, 0, moonlightMoth));
		assertEquals(19, skillChange(Skill.PRAYER, 68, 49, moonlightMoth));
		assertEquals(22, skillChange(Skill.PRAYER, 99, 70, moonlightMoth));

		final Effect moonlightMothMix = new ItemStatChanges().get(ItemID.MOONLIGHT_MOTH_MIX_1);

		assertEquals(0, skillChange(Skill.PRAYER, 1, 1, moonlightMothMix));
		assertEquals(5, skillChange(Skill.PRAYER, 7, 2, moonlightMothMix));
		assertEquals(22, skillChange(Skill.PRAYER, 30, 0, moonlightMothMix));
		assertEquals(19, skillChange(Skill.PRAYER, 68, 49, moonlightMothMix));
		assertEquals(22, skillChange(Skill.PRAYER, 99, 70, moonlightMothMix));
	}

	@Test
	public void testSunlightMoth()
	{
		final Effect sunlightMoth = new ItemStatChanges().get(ItemID.SUNLIGHT_MOTH_28890);

		assertEquals(16, skillChange(Skill.AGILITY, 50, 1, sunlightMoth));
		assertEquals(0, skillChange(Skill.ATTACK, 70, 70, sunlightMoth));
		assertEquals(17, skillChange(Skill.CONSTRUCTION, 66, 49, sunlightMoth));
		assertEquals(0, skillChange(Skill.COOKING, 70, 70, sunlightMoth));
		assertEquals(12, skillChange(Skill.CRAFTING, 70, 58, sunlightMoth));
		assertEquals(21, skillChange(Skill.DEFENCE, 75, 2, sunlightMoth));
		assertEquals(13, skillChange(Skill.FARMING, 83, 70, sunlightMoth));
		assertEquals(1, skillChange(Skill.FIREMAKING, 71, 70, sunlightMoth));
		assertEquals(19, skillChange(Skill.FISHING, 89, 70, sunlightMoth));
		assertEquals(7, skillChange(Skill.FLETCHING, 77, 70, sunlightMoth));
		assertEquals(0, skillChange(Skill.HERBLORE, 1, 1, sunlightMoth));
		assertEquals(1, skillChange(Skill.HITPOINTS, 84, 83, sunlightMoth));
		assertEquals(0, skillChange(Skill.HUNTER, 75, 77, sunlightMoth));
		assertEquals(12, skillChange(Skill.MAGIC, 30, 0, sunlightMoth));
		assertEquals(19, skillChange(Skill.MINING, 68, 49, sunlightMoth));
		assertEquals(0, skillChange(Skill.PRAYER, 99, 70, sunlightMoth));
		assertEquals(25, skillChange(Skill.RANGED, 99, 70, sunlightMoth));
		assertEquals(25, skillChange(Skill.RUNECRAFT, 99, 70, sunlightMoth));
		assertEquals(12, skillChange(Skill.SLAYER, 99, 87, sunlightMoth));
		assertEquals(0, skillChange(Skill.SMITHING, 31, 31, sunlightMoth));
		assertEquals(0, skillChange(Skill.STRENGTH, 68, 81, sunlightMoth));
		assertEquals(11, skillChange(Skill.THIEVING, 28, 10, sunlightMoth));
		assertEquals(3, skillChange(Skill.WOODCUTTING, 54, 51, sunlightMoth));

		final Effect sunlightMothMix = new ItemStatChanges().get(ItemID.SUNLIGHT_MOTH_MIX_1);

		assertEquals(16, skillChange(Skill.AGILITY, 50, 1, sunlightMothMix));
		assertEquals(0, skillChange(Skill.ATTACK, 70, 70, sunlightMothMix));
		assertEquals(17, skillChange(Skill.CONSTRUCTION, 66, 49, sunlightMothMix));
		assertEquals(0, skillChange(Skill.COOKING, 70, 70, sunlightMothMix));
		assertEquals(12, skillChange(Skill.CRAFTING, 70, 58, sunlightMothMix));
		assertEquals(21, skillChange(Skill.DEFENCE, 75, 2, sunlightMothMix));
		assertEquals(13, skillChange(Skill.FARMING, 83, 70, sunlightMothMix));
		assertEquals(1, skillChange(Skill.FIREMAKING, 71, 70, sunlightMothMix));
		assertEquals(19, skillChange(Skill.FISHING, 89, 70, sunlightMothMix));
		assertEquals(7, skillChange(Skill.FLETCHING, 77, 70, sunlightMothMix));
		assertEquals(0, skillChange(Skill.HERBLORE, 1, 1, sunlightMothMix));
		assertEquals(1, skillChange(Skill.HITPOINTS, 84, 83, sunlightMothMix));
		assertEquals(0, skillChange(Skill.HUNTER, 75, 77, sunlightMothMix));
		assertEquals(12, skillChange(Skill.MAGIC, 30, 0, sunlightMothMix));
		assertEquals(19, skillChange(Skill.MINING, 68, 49, sunlightMothMix));
		assertEquals(0, skillChange(Skill.PRAYER, 99, 70, sunlightMothMix));
		assertEquals(25, skillChange(Skill.RANGED, 99, 70, sunlightMothMix));
		assertEquals(25, skillChange(Skill.RUNECRAFT, 99, 70, sunlightMothMix));
		assertEquals(12, skillChange(Skill.SLAYER, 99, 87, sunlightMothMix));
		assertEquals(0, skillChange(Skill.SMITHING, 31, 31, sunlightMothMix));
		assertEquals(0, skillChange(Skill.STRENGTH, 68, 81, sunlightMothMix));
		assertEquals(11, skillChange(Skill.THIEVING, 28, 10, sunlightMothMix));
		assertEquals(3, skillChange(Skill.WOODCUTTING, 54, 51, sunlightMothMix));
	}

	@Test
	public void testRubyHarvest()
	{
		final Effect rubyHarvest = new ItemStatChanges().get(ItemID.RUBY_HARVEST);

		assertEquals(16, skillChange(Skill.ATTACK, 82, 82, rubyHarvest));
	}

	@Test
	public void testSapphireGlacial()
	{
		final Effect sapphireGlacial = new ItemStatChanges().get(ItemID.SAPPHIRE_GLACIALIS);

		assertEquals(13, skillChange(Skill.DEFENCE, 64, 64, sapphireGlacial));
	}

	@Test
	public void testBlackWarlock()
	{
		final Effect blackWarlock = new ItemStatChanges().get(ItemID.BLACK_WARLOCK);

		assertEquals(13, skillChange(Skill.STRENGTH, 64, 64, blackWarlock));
	}

	@Test
	public void testSnowyKnight()
	{
		final Effect snowyKnight = new ItemStatChanges().get(ItemID.SNOWY_KNIGHT);

		assertEquals(5, skillChange(Skill.HITPOINTS, 49, 44, snowyKnight));
		assertEquals(0, skillChange(Skill.HITPOINTS, 64, 64, snowyKnight));
		assertEquals(15, skillChange(Skill.HITPOINTS, 99, 77, snowyKnight));

		final Effect snowyKnightMix = new ItemStatChanges().get(ItemID.SNOWY_KNIGHT_MIX_1);

		assertEquals(5, skillChange(Skill.HITPOINTS, 50, 45, snowyKnightMix));
		assertEquals(0, skillChange(Skill.HITPOINTS, 64, 64, snowyKnightMix));
		assertEquals(8, skillChange(Skill.HITPOINTS, 99, 10, snowyKnightMix));
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

	@Test
	public void leagueCombatMasteryHealingPassives()
	{
		final Effect shark = new ItemStatChanges().get(ItemID.SHARK);
		final Effect saradominBrew = new ItemStatChanges().get(ItemID.SARADOMIN_BREW4);
		final Effect moonlightMoth = new ItemStatChanges().get(ItemID.MOONLIGHT_MOTH_28893);
		final Effect prayerPotion = new ItemStatChanges().get(ItemID.PRAYER_POTION4);
		final Effect divineSuperCombat = new ItemStatChanges().get(ItemID.DIVINE_SUPER_COMBAT_POTION4);
		final Effect bloodPint = new ItemStatChanges().get(ItemID.BLOOD_PINT);

		assertEquals(20, skillChange(Skill.HITPOINTS, 99, 1, shark));
		assertEquals(16, skillChange(Skill.HITPOINTS, 99, 1, saradominBrew));
		assertEquals(-10, skillChange(Skill.HITPOINTS, 99, 99, divineSuperCombat));

		when(client.getVarbitValue(Varbits.LEAGUES_MELEE_COMBAT_MASTERY_LEVEL)).thenReturn(2);

		assertEquals(24, skillChange(Skill.HITPOINTS, 99, 1, shark));
		assertEquals(19, skillChange(Skill.HITPOINTS, 99, 1, saradominBrew));
		assertEquals(22, skillChange(Skill.PRAYER, 99, 1, moonlightMoth));
		assertEquals(31, skillChange(Skill.PRAYER, 99, 1, prayerPotion));
		assertEquals(-10, skillChange(Skill.HITPOINTS, 99, 99, divineSuperCombat));
		assertEquals(-5, skillChange(Skill.PRAYER, 99, 99, bloodPint));

		when(client.getVarbitValue(Varbits.LEAGUES_MELEE_COMBAT_MASTERY_LEVEL)).thenReturn(5);

		assertEquals(27, skillChange(Skill.PRAYER, 99, 1, moonlightMoth));
		assertEquals(38, skillChange(Skill.PRAYER, 99, 1, prayerPotion));
		assertEquals(-5, skillChange(Skill.PRAYER, 99, 99, bloodPint));
	}

	@Test
	public void sunlitBracerHealingBoost()
	{
		final Effect karambwan = new ItemStatChanges().get(ItemID.COOKED_KARAMBWAN);
		final Effect shark = new ItemStatChanges().get(ItemID.SHARK);
		final Effect saradominBrew = new ItemStatChanges().get(ItemID.SARADOMIN_BREW4);

		final ItemContainer equipment = mock(ItemContainer.class);
		when(equipment.contains(ItemID.SUNLIT_BRACERS)).thenReturn(true);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipment);

		assertEquals(36, skillChange(Skill.HITPOINTS, 99, 1, karambwan));
		assertEquals(40, skillChange(Skill.HITPOINTS, 99, 1, shark));
		assertEquals(32, skillChange(Skill.HITPOINTS, 99, 99, saradominBrew));

		// Test combined with tier 2 combat relic passive
		when(client.getVarbitValue(Varbits.LEAGUES_MELEE_COMBAT_MASTERY_LEVEL)).thenReturn(2);

		assertEquals(39, skillChange(Skill.HITPOINTS, 99, 1, karambwan));
		assertEquals(44, skillChange(Skill.HITPOINTS, 99, 1, shark));
		assertEquals(35, skillChange(Skill.HITPOINTS, 99, 99, saradominBrew));
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
