/*
 * Copyright (c) 2025, Peter Grønbæk Andersen <peter@grnbk.io>
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
package net.runelite.client.plugins.droppartychest;

import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.*;
import net.runelite.client.game.ItemManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import javax.inject.Inject;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DropPartyChestPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private DropPartyChestConfig dropPartyChestConfig;

	@Inject
	private DropPartyChestPlugin dropPartyChestPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testCalculateValue()
	{
		Item coins = new Item(ItemID.COINS_995, Integer.MAX_VALUE);

		Item whip = new Item(ItemID.ABYSSAL_WHIP, 1_000_000_000);

		Item[] items = ImmutableList.of(
			coins,
			whip
		).toArray(new Item[0]);

		when(itemManager.getItemPrice(ItemID.ABYSSAL_WHIP))
			.thenReturn(3); // 1b * 3 overflows

		final long totalValue = dropPartyChestPlugin.getTotalGrandExchangeValue(items);

		assertTrue(totalValue > Integer.MAX_VALUE);
	}
}