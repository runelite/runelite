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
package net.runelite.client.plugins.bankvalue;

import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.queries.BankItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.util.QueryRunner;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BankCalculationTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private QueryRunner queryRunner;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private BankValueConfig bankValueConfig;

	@Inject
	private BankCalculation bankCalculation;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testCalculate()
	{
		when(bankValueConfig.showHA())
			.thenReturn(true);

		WidgetItem[] widgetItems = ImmutableList.of(
			new WidgetItem(ItemID.COINS_995, Integer.MAX_VALUE, -1, null),
			new WidgetItem(ItemID.ABYSSAL_WHIP, 1_000_000_000, -1, null)
		).toArray(new WidgetItem[0]);

		when(queryRunner.runQuery(any(BankItemQuery.class)))
			.thenReturn(widgetItems);

		ItemComposition whip = mock(ItemComposition.class);
		when(whip.getId())
			.thenReturn(ItemID.ABYSSAL_WHIP);
		when(whip.getPrice())
			.thenReturn(7); // 7 * .6 = 4, 4 * 1m overflows
		when(itemManager.getItemComposition(ItemID.ABYSSAL_WHIP))
			.thenReturn(whip);

		bankCalculation.calculate();

		long value = bankCalculation.getHaPrice();
		assertTrue(value > Integer.MAX_VALUE);
	}
}