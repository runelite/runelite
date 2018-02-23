/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.grounditems;

import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.item.ItemPrice;

public class GroundItemLoader extends CacheLoader<GroundItemCacheKey, GroundItem>
{
	// ItemID for coins
	private static final int COINS = ItemID.COINS_995;

	// Used when getting High Alchemy value - multiplied by general store price.
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	// Dummy empty value
	static final GroundItem EMPTY = GroundItem.builder().build();

	private final ItemManager itemManager;
	private final ListeningExecutorService executorService;

	GroundItemLoader(ItemManager itemManager, ScheduledExecutorService executorService)
	{
		this.itemManager = itemManager;
		this.executorService = MoreExecutors.listeningDecorator(executorService);
	}

	@Override
	public GroundItem load(@Nonnull final GroundItemCacheKey key)
	{
		return EMPTY;
	}

	@Override
	public ListenableFuture<GroundItem> reload(@Nonnull final GroundItemCacheKey item, @Nonnull final GroundItem oldValue)
	{
		return executorService.submit(() -> loadGroundItem(item));
	}

	private GroundItem loadGroundItem(@Nonnull final GroundItemCacheKey item)
	{

		final int itemQuantity = item.getQuantity();
		final ItemComposition itemDefinition = item.getItemComposition();
		final String itemName = itemDefinition.getName();
		final int realItemId = itemDefinition.getNote() != -1
			? itemDefinition.getLinkedNoteId()
			: itemDefinition.getId();

		final int gePrice, haPrice;

		if (realItemId == COINS)
		{
			gePrice = itemQuantity;
			haPrice = itemQuantity;
		}
		else
		{
			ItemPrice itemPrice;

			try
			{
				itemPrice = itemManager.getItemPrice(realItemId);
			}
			catch (IOException e)
			{
				itemPrice = null;
			}

			gePrice = itemPrice == null ? 0 : itemPrice.getPrice() * itemQuantity;
			haPrice = Math.round(itemDefinition.getPrice() * HIGH_ALCHEMY_CONSTANT) * itemQuantity;
		}

		return GroundItem.builder()
			.name(itemName)
			.gePrice(gePrice)
			.haPrice(haPrice)
			.quantity(itemQuantity)
			.build();
	}
}
