/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.itemskeptondeath;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.client.config.OpenOSRSConfig;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemReclaimCost;
import static net.runelite.client.plugins.itemskeptondeath.ItemsKeptOnDeathPlugin.DeathItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemsKeptOnDeathPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private OpenOSRSConfig openOSRSConfig;

	@Inject
	private ItemsKeptOnDeathPlugin plugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		resetBuffs();
	}

	private void resetBuffs()
	{
		plugin.isSkulled = false;
		plugin.protectingItem = false;
		plugin.wildyLevel = -1;
	}

	// Mocks an item and the necessary itemManager functions for it
	private Item mItem(final int id, final int qty, final String name, final boolean tradeable, final int price)
	{
		// Mock Item Composition and necessary ItemManager methods for this item
		ItemDefinition c = mock(ItemDefinition.class);
		when(c.getId())
			.thenReturn(id);
		when(c.getName())
			.thenReturn(name);
		when(c.isTradeable())
			.thenReturn(tradeable);
		when(c.getPrice())
			.thenReturn(price);

		if (!tradeable)
		{
			when(c.getNote()).thenReturn(-1);
			when(c.getLinkedNoteId()).thenReturn(-1);
		}

		when(itemManager.getItemDefinition(id)).thenReturn(c);
		when(itemManager.canonicalize(id)).thenReturn(id);
		when(itemManager.getItemPrice(id, true)).thenReturn(price);

		return item(id, qty);
	}

	// Creates a new item
	private static Item item(final int id, final int qty)
	{
		return new Item(id, qty);
	}

	@Test
	public void deathPriceTestRegularItems()
	{
		final Item acs = mItem(ItemID.ARMADYL_CHAINSKIRT, 1, "Armadyl chainskirt", true, 27837495);
		assertEquals(27837495, plugin.getDeathPrice(acs));

		final Item karambwan = mItem(ItemID.COOKED_KARAMBWAN, 1, "Cooked karambwan", true, 608);
		assertEquals(608, plugin.getDeathPrice(karambwan));

		final Item defender = mItem(ItemID.RUNE_DEFENDER, 1, "Rune defender", false, 35000);
		assertEquals(35000, plugin.getDeathPrice(defender));
	}

	@Test
	public void deathPriceTestItemMapping()
	{
		mItem(ItemID.OCCULT_NECKLACE, 1, "Occult necklace", true, 1000000);
		mItem(ItemID.OCCULT_ORNAMENT_KIT, 1, "Occult ornament kit", true, 3000000);
		final Item occult = mItem(ItemID.OCCULT_NECKLACE_OR, 1, "Occult necklace (or)", false, 0);
		assertEquals(4000000, plugin.getDeathPrice(occult));

		mItem(ItemID.BLACK_MASK, 1, "Black mask", true, 1000000);
		final Item blackMask8 = mItem(ItemID.BLACK_MASK_8, 1, "Black mask (8)", false, 0);
		assertEquals(1000000, plugin.getDeathPrice(blackMask8));
		final Item slayerHelm = mItem(ItemID.SLAYER_HELMET, 1, "Slayer helmet", false, 0);
		assertEquals(1000000, plugin.getDeathPrice(slayerHelm));
	}

	@Test
	public void deathPriceTestFixedPriceItems()
	{
		mItem(ItemID.KARILS_COIF_0, 1, "Karil's coif 0", true, 35000);
		final Item coif = mItem(ItemID.KARILS_COIF_100, 1, "Karil's coif 100", false, 0);
		final int coifOffset = FixedPriceItem.KARILS_COIF_100.getOffset();
		assertEquals(35000 + coifOffset, plugin.getDeathPrice(coif));

		mItem(ItemID.AHRIMS_ROBETOP_0, 1, "Ahrim's robetop 0", true, 2500000);
		final Item robetop = mItem(ItemID.AHRIMS_ROBETOP_25, 1, "Ahrim's robetop 100", false, 0);
		final int robetopOffset = FixedPriceItem.AHRIMS_ROBETOP_25.getOffset();
		assertEquals(2500000 + robetopOffset, plugin.getDeathPrice(robetop));

		mItem(ItemID.AMULET_OF_GLORY, 1, "Amulet of glory", true, 13000);
		final Item glory = mItem(ItemID.AMULET_OF_GLORY3, 1, "Amulet of glory(3)", true, 0);
		final int gloryOffset = FixedPriceItem.AMULET_OF_GLORY3.getOffset();
		assertEquals(13000 + gloryOffset, plugin.getDeathPrice(glory));

		mItem(ItemID.COMBAT_BRACELET, 1, "Combat bracelet", true, 13500);
		final Item brace = mItem(ItemID.COMBAT_BRACELET1, 1, "Combat bracelet(1)", true, 0);
		final int braceletOffset = FixedPriceItem.COMBAT_BRACELET1.getOffset();
		assertEquals(13500 + braceletOffset, plugin.getDeathPrice(brace));

		final Item amulet = mItem(ItemID.SALVE_AMULETEI, 1, "Salve Amulet(ei)", false, 300);
		assertEquals(210200, plugin.getDeathPrice(amulet));
	}

	@Test
	public void deathPriceTestDynamicPriceItems()
	{
		final Item rod8 = mItem(ItemID.RING_OF_DUELING8, 1, "Ring of dueling(8)", true, 725);
		final Item rod3 = mItem(ItemID.RING_OF_DUELING3, 1, "Ring of dueling(3)", true, 0);
		final Item rod1 = mItem(ItemID.RING_OF_DUELING1, 1, "Ring of dueling(1)", true, 0);
		// Dynamic price items
		final int rodPrice = 725 / 8;
		assertEquals(rodPrice, plugin.getDeathPrice(rod1));
		assertEquals(725, plugin.getDeathPrice(rod8));
		assertEquals(rodPrice * 3, plugin.getDeathPrice(rod3));

		final Item nop5 = mItem(ItemID.NECKLACE_OF_PASSAGE5, 1, "Necklace of passage(5)", true, 1250);
		final Item nop4 = mItem(ItemID.NECKLACE_OF_PASSAGE4, 1, "Necklace of passage(4)", true, 0);
		final Item nop2 = mItem(ItemID.NECKLACE_OF_PASSAGE2, 1, "Necklace of passage(2)", true, 0);

		final int nopPrice = 1250 / 5;
		assertEquals(nopPrice * 2, plugin.getDeathPrice(nop2));
		assertEquals(nopPrice * 4, plugin.getDeathPrice(nop4));
		assertEquals(1250, plugin.getDeathPrice(nop5));
	}

	private Item[] getFourExpensiveItems()
	{
		return new Item[]
			{
				mItem(ItemID.TWISTED_BOW, 1, "Twister bow", true, Integer.MAX_VALUE),
				mItem(ItemID.SCYTHE_OF_VITUR, 1, "Scythe of vitur", true, Integer.MAX_VALUE),
				mItem(ItemID.ELYSIAN_SPIRIT_SHIELD, 1, "Elysian spirit shield", true, 800000000),
				mItem(ItemID.ARCANE_SPIRIT_SHIELD, 1, "Arcane spirit shield", true, 250000000)
			};
	}

	@Test
	public void alwaysLostTestRunePouch()
	{
		final Item[] inv = getFourExpensiveItems();
		final Item[] equip = new Item[]
			{
				mItem(ItemID.RUNE_POUCH, 1, "Rune pouch", false, 1)
			};

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);
		assertFalse(deathItems.isHasAlwaysLost());
	}

	@Test
	public void alwaysLostTestRunePouchWildy()
	{
		final Item[] inv = getFourExpensiveItems();
		final Item[] equip = new Item[]
			{
				mItem(ItemID.RUNE_POUCH, 1, "Rune pouch", false, 1)
			};

		plugin.wildyLevel = 1;
		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);
		assertTrue(deathItems.isHasAlwaysLost());
	}

	@Test
	public void alwaysLostTestLootBag()
	{
		final Item[] inv = getFourExpensiveItems();
		final Item[] equip = new Item[]
			{
				mItem(ItemID.LOOTING_BAG, 1, "Looting bag", false, 1)
			};

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);
		assertTrue(deathItems.isHasAlwaysLost());

	}

	@Test
	public void alwaysLostTestLootBagWildy()
	{
		final Item[] inv = getFourExpensiveItems();
		final Item[] equip = new Item[]
			{
				mItem(ItemID.LOOTING_BAG, 1, "Looting bag", false, 1)
			};

		plugin.wildyLevel = 1;
		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);
		assertTrue(deathItems.isHasAlwaysLost());
	}

	private Item[] getClueBoxTestInventory()
	{
		return new Item[]
			{
				mItem(ItemID.BLACK_DHIDE_BODY, 1, "Black d'hide body", true, 7552),
				mItem(ItemID.ARMADYL_CHAINSKIRT, 1, "Armadyl chainskirt", true, 27837495),
				mItem(ItemID.PEGASIAN_BOOTS, 1, "Pegasian boots", true, 30542187),
				mItem(ItemID.DRAGON_SCIMITAR, 1, "Dragon scimitar", true, 63123),

				mItem(ItemID.HELM_OF_NEITIZNOT, 1, "Helm of neitiznot", true, 45519),
				mItem(ItemID.RUNE_DEFENDER, 1, "Rune defender", false, 35000),
				mItem(ItemID.SPADE, 1, "Spade", true, 104),
				mItem(ItemID.CLUE_SCROLL_EASY, 1, "Clue scroll (easy)", false, 50),

				mItem(ItemID.CLUE_BOX, 1, "Clue box", false, 50),
				mItem(ItemID.COOKED_KARAMBWAN, 1, "Cooked karambwan", true, 608),
				mItem(ItemID.COOKED_KARAMBWAN, 1, "Cooked karambwan", true, 608),
				mItem(ItemID.COOKED_KARAMBWAN, 1, "Cooked karambwan", true, 608),

				mItem(ItemID.COOKED_KARAMBWAN, 1, "Cooked karambwan", true, 608),
				mItem(ItemID.COOKED_KARAMBWAN, 1, "Cooked karambwan", true, 608),
				mItem(ItemID.LAW_RUNE, 200, "Law rune", true, 212),
				mItem(ItemID.DUST_RUNE, 200, "Dust rune", true, 3),

				mItem(ItemID.CLUE_SCROLL_MASTER, 1, "Clue scroll (master)", false, 50),
				mItem(ItemID.CLUELESS_SCROLL, 1, "Clueless scroll", false, 50),
			};
	}

	@Test
	public void isClueBoxableTest()
	{
		getClueBoxTestInventory();
		mItem(ItemID.REWARD_CASKET_EASY, 1, "Reward casket (easy)", false, 50);

		assertTrue(plugin.isClueBoxable(ItemID.CLUE_SCROLL_EASY));
		assertTrue(plugin.isClueBoxable(ItemID.CLUE_SCROLL_MASTER));
		assertTrue(plugin.isClueBoxable(ItemID.REWARD_CASKET_EASY));

		assertFalse(plugin.isClueBoxable(ItemID.CLUELESS_SCROLL));
		assertFalse(plugin.isClueBoxable(ItemID.LAW_RUNE));
		assertFalse(plugin.isClueBoxable(ItemID.SPADE));
	}

	@Test
	public void clueBoxTestDefault()
	{
		final Item[] inv = getClueBoxTestInventory();
		final Item[] equip = new Item[0];

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		final List<ItemStack> expectedKept = Arrays.asList(
			new ItemStack(ItemID.PEGASIAN_BOOTS, 1),
			new ItemStack(ItemID.ARMADYL_CHAINSKIRT, 1),
			new ItemStack(ItemID.DRAGON_SCIMITAR, 1),
			new ItemStack(ItemID.RUNE_DEFENDER, 1),
			new ItemStack(ItemID.CLUE_SCROLL_EASY, 1),
			new ItemStack(ItemID.CLUE_SCROLL_MASTER, 1),
			new ItemStack(ItemID.CLUELESS_SCROLL, 1)
		);
		assertEquals(expectedKept, kept);

		final List<ItemStack> lost = deathItems.getLostItems();
		assertEquals((inv.length + equip.length) - expectedKept.size(), lost.size());
	}

	@Test
	public void clueBoxTestDeepWildy()
	{
		final Item[] inv = getClueBoxTestInventory();
		final Item[] equip = new Item[0];

		plugin.wildyLevel = 21;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		final List<ItemStack> expectedKept = Arrays.asList(
			new ItemStack(ItemID.PEGASIAN_BOOTS, 1),
			new ItemStack(ItemID.ARMADYL_CHAINSKIRT, 1),
			new ItemStack(ItemID.DRAGON_SCIMITAR, 1),
			new ItemStack(ItemID.CLUE_SCROLL_MASTER, 1)
		);
		assertEquals(expectedKept, kept);

		final List<ItemStack> lost = deathItems.getLostItems();
		final int keptOffset = expectedKept.size();
		assertEquals((inv.length + equip.length) - keptOffset, lost.size());
	}

	@Test
	public void clueBoxTestDeepWildyProtectItem()
	{
		final Item[] inv = getClueBoxTestInventory();
		final Item[] equip = new Item[0];

		plugin.wildyLevel = 21;
		plugin.protectingItem = true;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		final List<ItemStack> expectedKept = Arrays.asList(
			new ItemStack(ItemID.PEGASIAN_BOOTS, 1),
			new ItemStack(ItemID.ARMADYL_CHAINSKIRT, 1),
			new ItemStack(ItemID.DRAGON_SCIMITAR, 1),
			new ItemStack(ItemID.HELM_OF_NEITIZNOT, 1),
			new ItemStack(ItemID.CLUE_SCROLL_MASTER, 1) // Clue box
		);
		assertEquals(expectedKept, kept);

		final List<ItemStack> lost = deathItems.getLostItems();
		final int keptOffset = expectedKept.size();
		assertEquals((inv.length + equip.length) - keptOffset, lost.size());
	}

	@Test
	public void clueBoxTestDeepWildySkulled()
	{
		final Item[] inv = getClueBoxTestInventory();
		final Item[] equip = new Item[0];

		plugin.wildyLevel = 21;
		plugin.isSkulled = true;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		final List<ItemStack> expectedKept = Collections.singletonList(
			new ItemStack(ItemID.CLUE_SCROLL_MASTER, 1)
		);
		assertEquals(expectedKept, kept);

		final List<ItemStack> lost = deathItems.getLostItems();
		final int keptOffset = expectedKept.size();
		assertEquals(lost.size(), (inv.length + equip.length) - keptOffset);
	}

	@Test
	public void clueBoxTestLowWildy()
	{
		final Item[] inv = getClueBoxTestInventory();
		final Item[] equip = new Item[0];

		plugin.wildyLevel = 1;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		final List<ItemStack> expectedKept = Arrays.asList(
			new ItemStack(ItemID.PEGASIAN_BOOTS, 1),
			new ItemStack(ItemID.ARMADYL_CHAINSKIRT, 1),
			new ItemStack(ItemID.DRAGON_SCIMITAR, 1),
			new ItemStack(ItemID.RUNE_DEFENDER, 1), // Rune defender protected because of broken variant
			new ItemStack(ItemID.CLUE_SCROLL_MASTER, 1)
		);
		assertEquals(expectedKept, kept);

		final List<ItemStack> lost = deathItems.getLostItems();
		final int keptOffset = expectedKept.size();
		assertEquals(lost.size(), (inv.length + equip.length) - keptOffset);
	}

	@Test
	public void clueBoxTestLowWildyProtectItem()
	{
		final Item[] inv = getClueBoxTestInventory();
		final Item[] equip = new Item[0];

		plugin.wildyLevel = 1;
		plugin.protectingItem = true;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		final List<ItemStack> expectedKept = Arrays.asList(
			new ItemStack(ItemID.PEGASIAN_BOOTS, 1),
			new ItemStack(ItemID.ARMADYL_CHAINSKIRT, 1),
			new ItemStack(ItemID.DRAGON_SCIMITAR, 1),
			new ItemStack(ItemID.HELM_OF_NEITIZNOT, 1),
			new ItemStack(ItemID.RUNE_DEFENDER, 1), // Rune defender protected because of broken variant
			new ItemStack(ItemID.CLUE_SCROLL_MASTER, 1)
		);
		assertEquals(expectedKept, kept);

		final List<ItemStack> lost = deathItems.getLostItems();
		final int keptOffset = expectedKept.size();
		assertEquals((inv.length + equip.length) - keptOffset, lost.size());
	}

	@Test
	public void clueBoxTestLowWildySkulled()
	{
		final Item[] inv = getClueBoxTestInventory();
		final Item[] equip = new Item[0];

		plugin.wildyLevel = 1;
		plugin.isSkulled = true;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		final List<ItemStack> expectedKept = Arrays.asList(
			new ItemStack(ItemID.RUNE_DEFENDER, 1), // Rune defender protected because of broken variant
			new ItemStack(ItemID.CLUE_SCROLL_MASTER, 1)
		);
		assertEquals(expectedKept, kept);

		final List<ItemStack> lost = deathItems.getLostItems();
		final int keptOffset = expectedKept.size();
		assertEquals((inv.length + equip.length) - keptOffset, lost.size());
	}

	private Item[] getClueBoxCasketTestInventory()
	{
		// Reward caskets can stack but the clue box should only protect one
		return new Item[]
			{
				mItem(ItemID.BLACK_DHIDE_BODY, 1, "Black d'hide body", true, 7552),
				mItem(ItemID.ARMADYL_CHAINSKIRT, 1, "Armadyl chainskirt", true, 27837495),
				mItem(ItemID.PEGASIAN_BOOTS, 1, "Pegasian boots", true, 30542187),
				mItem(ItemID.DRAGON_SCIMITAR, 1, "Dragon scimitar", true, 63123),

				mItem(ItemID.SPADE, 1, "Spade", true, 104),
				mItem(ItemID.CLUE_SCROLL_EASY, 1, "Clue scroll (easy)", false, 50),
				mItem(ItemID.REWARD_CASKET_EASY, 20, "Reward casket (easy)", false, 50),
				mItem(ItemID.CLUE_BOX, 1, "Clue box", false, 50),

				mItem(ItemID.COOKED_KARAMBWAN, 1, "Cooked karambwan", true, 608),
				mItem(ItemID.COOKED_KARAMBWAN, 1, "Cooked karambwan", true, 608),
				mItem(ItemID.COOKED_KARAMBWAN, 1, "Cooked karambwan", true, 608),
				mItem(ItemID.COOKED_KARAMBWAN, 1, "Cooked karambwan", true, 608),

				mItem(ItemID.LAW_RUNE, 200, "Law rune", true, 212),
				mItem(ItemID.DUST_RUNE, 200, "Dust rune", true, 3),
			};
	}

	@Test
	public void clueBoxTestCasketProtect()
	{
		final Item[] inv = getClueBoxCasketTestInventory();
		final Item[] equip = new Item[0];

		plugin.wildyLevel = 1;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		final List<ItemStack> expectedKept = Arrays.asList(
			new ItemStack(ItemID.PEGASIAN_BOOTS, 1),
			new ItemStack(ItemID.ARMADYL_CHAINSKIRT, 1),
			new ItemStack(ItemID.DRAGON_SCIMITAR, 1),
			new ItemStack(ItemID.REWARD_CASKET_EASY, 1) // Clue box
		);
		assertEquals(expectedKept, kept);

		final List<ItemStack> lost = deathItems.getLostItems();
		final int keptOffset = expectedKept.size() - 1; // We are still losing some reward caskets.
		assertEquals((inv.length + equip.length) - keptOffset, lost.size());
	}

	private Item[] getFullGracefulItems()
	{
		return new Item[]
			{
				mItem(ItemID.GRACEFUL_HOOD, 1, "Graceful hood", false, 35),
				mItem(ItemID.GRACEFUL_CAPE, 1, "Graceful cape", false, 40),
				mItem(ItemID.GRACEFUL_TOP, 1, "Graceful top", false, 55),
				mItem(ItemID.GRACEFUL_LEGS, 1, "Graceful legs", false, 60),
				mItem(ItemID.GRACEFUL_BOOTS, 1, "Graceful boots", false, 40),
				mItem(ItemID.GRACEFUL_GLOVES, 1, "Graceful gloves", false, 30),
			};
	}

	@Test
	public void gracefulValueTest()
	{
		final Item[] inv = getFullGracefulItems();
		final Item[] equip = new Item[]
			{
				mItem(ItemID.AMULET_OF_GLORY6, 1, "Amulet of glory (6)", true, 20000)
			};


		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		final List<ItemStack> expectedKept = Arrays.asList(
			new ItemStack(ItemID.AMULET_OF_GLORY6, 1),
			new ItemStack(ItemID.GRACEFUL_CAPE, 1),
			new ItemStack(ItemID.GRACEFUL_TOP, 1),
			new ItemStack(ItemID.GRACEFUL_LEGS, 1),
			new ItemStack(ItemID.GRACEFUL_BOOTS, 1),
			new ItemStack(ItemID.GRACEFUL_HOOD, 1),
			new ItemStack(ItemID.GRACEFUL_GLOVES, 1)
		);
		assertEquals(expectedKept, kept);

		final List<ItemStack> lost = deathItems.getLostItems();
		assertEquals((inv.length + equip.length) - expectedKept.size(), lost.size());
	}

	@Test
	public void gracefulValueTestWildy()
	{
		final Item[] inv = getFullGracefulItems();
		final Item[] equip = new Item[]
			{
				mItem(ItemID.AMULET_OF_GLORY6, 1, "Amulet of glory (6)", true, 20000)
			};

		plugin.wildyLevel = 1;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		final List<ItemStack> expectedKept = Arrays.asList(
			new ItemStack(ItemID.AMULET_OF_GLORY6, 1),
			new ItemStack(ItemID.GRACEFUL_CAPE, 1),
			new ItemStack(ItemID.GRACEFUL_TOP, 1)
		);
		assertEquals(expectedKept, kept);

		final List<ItemStack> lost = deathItems.getLostItems();
		assertEquals((inv.length + equip.length) - expectedKept.size(), lost.size());
	}

	@Test
	public void lostIfNotProtectedTestLost()
	{
		final Item[] inv = getFourExpensiveItems();
		final Item[] equip = new Item[]
			{
				mItem(ItemID.SHADOW_SWORD, 1, "Shadow sword", false, 1)
			};

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> lost = deathItems.getLostItems();
		assertTrue(lost.contains(new ItemStack(ItemID.SHADOW_SWORD, 1)));
	}

	@Test
	public void lostIfNotProtectedTestKept()
	{
		final Item[] inv = new Item[]
			{
				mItem(ItemID.SHADOW_SWORD, 1, "Shadow sword", false, 1)
			};
		final Item[] equip = new Item[0];

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, equip);

		final List<ItemStack> kept = deathItems.getKeptItems();
		assertTrue(kept.contains(new ItemStack(ItemID.SHADOW_SWORD, 1)));
	}

	@Test
	public void brokenOnDeathTestRepairPrice()
	{
		// Dragon defender price should actually be pulled from BrokenOnDeathItem, and be lost on death
		final Item[] inv = new Item[]
			{
				mItem(ItemID.BARROWS_GLOVES, 1, "Barrows gloves", false, 130000),
				mItem(ItemID.DRAGON_DEFENDER, 1, "Dragon defender", false, 68007),
				mItem(ItemID.DRAGON_SCIMITAR, 1, "Dragon scimitar", true, 63123),
				mItem(ItemID.HELM_OF_NEITIZNOT, 1, "Helm of neitiznot", true, 45519),
			};

		plugin.wildyLevel = 21;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, new Item[0]);

		final List<ItemStack> lost = deathItems.getLostItems();
		assertTrue(lost.contains(new ItemStack(ItemID.DRAGON_DEFENDER, 1)));
	}

	@Test
	public void avernicDefenderPriceTest()
	{
		final Item defender = mItem(ItemID.AVERNIC_DEFENDER, 1, "Avernic defender", false, 0);
		final int defenderOffset = FixedPriceItem.AVERNIC_DEFENDER.getOffset();
		final ItemReclaimCost defenderBrokenPrice = ItemReclaimCost.of(ItemID.AVERNIC_DEFENDER);
		final int defenderExpectedPrice = (defenderBrokenPrice == null ? 0 : defenderBrokenPrice.getValue()) + defenderOffset;
		assertEquals(defenderExpectedPrice, plugin.getDeathPrice(defender));

		final Item[] inv = new Item[]
			{
				defender,
				mItem(ItemID.BERSERKER_RING_I, 1, "Berserker Ring (i)", false, 3042579)
			};

		plugin.isSkulled = true;
		plugin.protectingItem = true;
		plugin.wildyLevel = 21;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, new Item[0]);

		final List<ItemStack> kept = deathItems.getKeptItems();
		assertTrue(kept.contains(new ItemStack(ItemID.AVERNIC_DEFENDER, 1)));
	}

	@Test
	public void lockedItemTest()
	{
		// Base item data needs to exist for each locked item tested as the death price is pulled from the base item.
		final Item defenderBase = mItem(ItemID.AVERNIC_DEFENDER, 1, "Avernic defender", false, 0);
		final Item defenderLocked = mItem(ItemID.AVERNIC_DEFENDER_L, 1, "Avernic defender (l)", false, 0);

		assertEquals(plugin.getDeathPrice(defenderBase), plugin.getDeathPrice(defenderLocked));

		final Item[] inv = new Item[]
			{
				defenderLocked,
				mItem(ItemID.DRAGON_CLAWS, 1, "Dragon Claws", true, 30042579)
			};

		plugin.isSkulled = true;
		plugin.protectingItem = true;
		plugin.wildyLevel = 21;

		final DeathItems deathItems = plugin.calculateKeptLostItems(inv, new Item[0]);

		final List<ItemStack> kept = deathItems.getKeptItems();
		assertEquals(inv.length, kept.size());
	}
}
