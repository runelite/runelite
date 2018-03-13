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
package net.runelite.client.game;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Value;
import net.runelite.api.Client;
import static net.runelite.api.Constants.CLIENT_DEFAULT_ZOOM;
import net.runelite.api.ItemComposition;
import net.runelite.api.SpritePixels;
import net.runelite.http.api.item.ItemClient;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;

@Singleton
public class ItemManager
{
	@Value
	private static class ImageKey
	{
		private final int itemId;
		private final int itemQuantity;
		private final boolean stackable;
	}

	/**
	 * not yet looked up
	 */

	static final ItemPrice EMPTY = new ItemPrice();
	/**
	 * has no price
	 */
	static final ItemPrice NONE = new ItemPrice();

	private final Client client;
	private final ItemClient itemClient = new ItemClient();
	private final LoadingCache<String, SearchResult> itemSearches;
	private final LoadingCache<Integer, ItemPrice> itemPrices;
	private final LoadingCache<ImageKey, BufferedImage> itemImages;
	private final LoadingCache<Integer, ItemComposition> itemCompositions;

	@Inject
	public ItemManager(@Nullable Client client, ScheduledExecutorService executor)
	{
		this.client = client;
		itemPrices = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(1, TimeUnit.HOURS)
			.build(new ItemPriceLoader(executor, itemClient));

		itemSearches = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(1, TimeUnit.HOURS)
			.build(new CacheLoader<String, SearchResult>()
			{
				@Override
				public SearchResult load(String key) throws Exception
				{
					return itemClient.search(key);
				}
			});

		itemImages = CacheBuilder.newBuilder()
			.maximumSize(128L)
			.expireAfterAccess(1, TimeUnit.HOURS)
			.build(new CacheLoader<ImageKey, BufferedImage>()
			{
				@Override
				public BufferedImage load(ImageKey key) throws Exception
				{
					return loadImage(key.itemId, key.itemQuantity, key.stackable);
				}
			});

		itemCompositions = CacheBuilder.newBuilder()
			.maximumSize(1024L)
			.expireAfterAccess(1, TimeUnit.HOURS)
			.build(new CacheLoader<Integer, ItemComposition>()
			{
				@Override
				public ItemComposition load(Integer key) throws Exception
				{
					return client.getItemDefinition(key);
				}
			});
	}

	/**
	 * Look up an item's price asynchronously.
	 *
	 * @param itemId item id
	 * @return the price, or null if the price is not yet loaded
	 */
	public ItemPrice getItemPriceAsync(int itemId)
	{
		ItemPrice itemPrice = itemPrices.getIfPresent(itemId);
		if (itemPrice != null && itemPrice != EMPTY)
		{
			return itemPrice == NONE ? null : itemPrice;
		}

		itemPrices.refresh(itemId);
		return null;
	}

	/**
	 * Look up an item's price synchronously
	 *
	 * @param itemId item id
	 * @return item price
	 * @throws IOException
	 */
	public ItemPrice getItemPrice(int itemId) throws IOException
	{
		ItemPrice itemPrice = itemPrices.getIfPresent(itemId);
		if (itemPrice != null && itemPrice != EMPTY)
		{
			return itemPrice == NONE ? null : itemPrice;
		}

		itemPrice = itemClient.lookupItemPrice(itemId);
		if (itemPrice == null)
		{
			itemPrices.put(itemId, NONE);
			return null;
		}

		itemPrices.put(itemId, itemPrice);
		return itemPrice;
	}

	/**
	 * Look up an item's composition
	 *
	 * @param itemName item name
	 * @return item search result
	 * @throws java.util.concurrent.ExecutionException exception when item
	 * is not found
	 */
	public SearchResult searchForItem(String itemName) throws ExecutionException
	{
		return itemSearches.get(itemName);
	}

	/**
	 * Look up an item's composition
	 *
	 * @param itemId item id
	 * @return item composition
	 */
	public ItemComposition getItemComposition(int itemId)
	{
		return itemCompositions.getUnchecked(itemId);
	}

	/**
	 * Loads item sprite from game, makes transparent, and generates image
	 *
	 * @param itemId
	 * @return
	 */
	private BufferedImage loadImage(int itemId, int quantity, boolean stackable)
	{
		SpritePixels sprite = client.createItemSprite(itemId, quantity, 1, SpritePixels.DEFAULT_SHADOW_COLOR, stackable ? 1 : 0, false, CLIENT_DEFAULT_ZOOM);
		return sprite.toBufferedImage();
	}

	/**
	 * Get item sprite image
	 *
	 * @param itemId
	 * @return
	 */
	public BufferedImage getImage(int itemId)
	{
		return getImage(itemId, 1, false);
	}

	/**
	 * Get item sprite image as BufferedImage
	 *
	 * @param itemId
	 * @param quantity
	 * @return
	 */
	public BufferedImage getImage(int itemId, int quantity, boolean stackable)
	{
		try
		{
			return itemImages.get(new ImageKey(itemId, quantity, stackable));
		}
		catch (ExecutionException ex)
		{
			return null;
		}
	}
}
