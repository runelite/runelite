/*
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
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContainerCalculationTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Inject
	private ContainerCalculation containerCalculation;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testCalculate()
	{
		Item coins = mock(Item.class);
		when(coins.getId())
			.thenReturn(ItemID.COINS_995);
		when(coins.getQuantity())
			.thenReturn(Integer.MAX_VALUE);

		Item whip = mock(Item.class);
		when(whip.getId())
			.thenReturn(ItemID.ABYSSAL_WHIP);
		when(whip.getQuantity())
			.thenReturn(1_000_000_000);

		Item[] items = ImmutableList.of(
			coins,
			whip
		).toArray(new Item[0]);

		ItemDefinition whipComp = mock(ItemDefinition.class);
		when(whipComp.getId())
			.thenReturn(ItemID.ABYSSAL_WHIP);
		when(whipComp.getPrice())
			.thenReturn(7); // 7 * .6 = 4, 4 * 1m overflows
		when(itemManager.getItemDefinition(ItemID.ABYSSAL_WHIP))
			.thenReturn(whipComp);

		final ContainerPrices prices = containerCalculation.calculate(items);
		assertNotNull(prices);

		long value = prices.getHighAlchPrice();
		assertTrue(value > Integer.MAX_VALUE);
	}
}