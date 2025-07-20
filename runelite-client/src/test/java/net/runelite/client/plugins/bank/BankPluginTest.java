/*
 * Copyright (c) 2019, Ron Young <https://github.com/raiyni>
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.bank;

import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BankPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private BankConfig bankConfig;

	@Inject
	private BankPlugin bankPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testValueSearch()
	{
		int itemId = ItemID.ABYSSAL_WHIP;

		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{new Item(itemId, 30)});
		when(client.getItemContainer(InventoryID.BANK)).thenReturn(itemContainer);

		ItemComposition comp = mock(ItemComposition.class);

		// 60k HA price * 30 = 1.8m
		when(comp.getHaPrice())
			.thenReturn(60_000);

		// 400k GE Price * 30 = 12m
		when(itemManager.getItemPrice(itemId))
			.thenReturn(400_000);
		when(itemManager.getItemComposition(itemId))
			.thenReturn(comp);

		assertTrue(bankPlugin.valueSearch(itemId, ">500k"));
		assertTrue(bankPlugin.valueSearch(itemId, "< 5.5b"));
		assertTrue(bankPlugin.valueSearch(itemId, "500k - 20.6m"));

		assertTrue(bankPlugin.valueSearch(itemId, "per=400k"));
		assertTrue(bankPlugin.valueSearch(itemId, "ge per 50k - 20.6m"));
		assertTrue(bankPlugin.valueSearch(itemId, "ge per > 300k"));

		assertTrue(bankPlugin.valueSearch(itemId, "ha=1.8m"));
		assertTrue(bankPlugin.valueSearch(itemId, "ha 500k - 20.6m"));
		assertTrue(bankPlugin.valueSearch(itemId, "ha > 940k"));

		assertTrue(bankPlugin.valueSearch(itemId, "ha per=60k"));
		assertTrue(bankPlugin.valueSearch(itemId, "ha per 50k - 20.6m"));
		assertTrue(bankPlugin.valueSearch(itemId, "ha per > 9k"));

		assertTrue(bankPlugin.valueSearch(itemId, "qty=0"));
		assertTrue(bankPlugin.valueSearch(itemId, "qty<600"));

		assertFalse(bankPlugin.valueSearch(itemId, "<500k"));
		assertFalse(bankPlugin.valueSearch(itemId, "ha >2m"));
		assertFalse(bankPlugin.valueSearch(itemId, "ge > 0.02b"));
		assertFalse(bankPlugin.valueSearch(itemId, "ha per >100k"));
		assertFalse(bankPlugin.valueSearch(itemId, "ge per > 1m"));

		assertFalse(bankPlugin.valueSearch(itemId, "qty=1"));
		assertFalse(bankPlugin.valueSearch(itemId, "qty>30"));

		assertFalse(bankPlugin.valueSearch(itemId, "1000k"));
	}

	@Test
	public void testCalculate()
	{
		Item coins = new Item(ItemID.COINS, Integer.MAX_VALUE);

		Item whip = new Item(ItemID.ABYSSAL_WHIP, 1_000_000_000);

		Item[] items = ImmutableList.of(
			coins,
			whip
		).toArray(new Item[0]);

		ItemComposition whipComp = mock(ItemComposition.class);
		when(whipComp.getHaPrice())
			.thenReturn(4); // 4 * 1m overflows
		when(itemManager.getItemComposition(ItemID.ABYSSAL_WHIP))
			.thenReturn(whipComp);
		when(itemManager.getItemPrice(ItemID.ABYSSAL_WHIP))
			.thenReturn(3); // 1b * 3 overflows

		final ContainerPrices prices = bankPlugin.calculate(items);
		assertNotNull(prices);

		assertTrue(prices.getHighAlchPrice() > Integer.MAX_VALUE);
		assertTrue(prices.getGePrice() > Integer.MAX_VALUE);
	}
}