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
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.Subscribe;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import static net.runelite.api.Constants.CLIENT_DEFAULT_ZOOM;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.SpritePixels;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.http.api.item.ItemClient;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;

@Singleton
@Slf4j
public class ItemManager
{
	@Value
	private static class ImageKey
	{
		private final int itemId;
		private final int itemQuantity;
		private final boolean stackable;
	}

	@Value
	private static class OutlineKey
	{
		private final int itemId;
		private final int itemQuantity;
		private final Color outlineColor;
	}

	private final Client client;
	private final ScheduledExecutorService scheduledExecutorService;
	private final ClientThread clientThread;

	private final ItemClient itemClient = new ItemClient();
	private final LoadingCache<String, SearchResult> itemSearches;
	private Map<Integer, ItemPrice> itemPrices = Collections.emptyMap();
	private final LoadingCache<ImageKey, AsyncBufferedImage> itemImages;
	private final LoadingCache<Integer, ItemComposition> itemCompositions;
	private final LoadingCache<OutlineKey, BufferedImage> itemOutlines;

	@Inject
	public ItemManager(Client client, ScheduledExecutorService executor, ClientThread clientThread)
	{
		this.client = client;
		this.scheduledExecutorService = executor;
		this.clientThread = clientThread;

		scheduledExecutorService.scheduleWithFixedDelay(this::loadPrices, 0, 30, TimeUnit.MINUTES);

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
			.build(new CacheLoader<ImageKey, AsyncBufferedImage>()
			{
				@Override
				public AsyncBufferedImage load(ImageKey key) throws Exception
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

		itemOutlines = CacheBuilder.newBuilder()
			.maximumSize(128L)
			.expireAfterAccess(1, TimeUnit.HOURS)
			.build(new CacheLoader<OutlineKey, BufferedImage>()
			{
				@Override
				public BufferedImage load(OutlineKey key) throws Exception
				{
					return loadItemOutline(key.itemId, key.itemQuantity, key.outlineColor);
				}
			});
	}

	private void loadPrices()
	{
		try
		{
			ItemPrice[] prices = itemClient.getPrices();
			if (prices != null)
			{
				ImmutableMap.Builder<Integer, ItemPrice> map = ImmutableMap.builderWithExpectedSize(prices.length);
				for (ItemPrice price : prices)
				{
					map.put(price.getItem().getId(), price);
				}
				itemPrices = map.build();
			}

			log.debug("Loaded {} prices", itemPrices.size());
		}
		catch (IOException e)
		{
			log.warn("error loading prices!", e);
		}
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() == GameState.HOPPING || event.getGameState() == GameState.LOGIN_SCREEN)
		{
			itemCompositions.invalidateAll();
		}
	}

	/**
	 * Look up an item's price
	 *
	 * @param itemID item id
	 * @return item price
	 */
	public int getItemPrice(int itemID)
	{
		if (itemID == ItemID.COINS_995)
		{
			return 1;
		}
		if (itemID == ItemID.PLATINUM_TOKEN)
		{
			return 1000;
		}

		int price = 0;
		for (int mappedID : ItemMapping.map(itemID))
		{
			ItemPrice ip = itemPrices.get(mappedID);
			if (ip != null)
			{
				price += ip.getPrice();
			}
		}

		return price;
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
		assert client.isClientThread() : "getItemComposition must be called on client thread";
		return itemCompositions.getUnchecked(itemId);
	}

	/**
	 * Loads item sprite from game, makes transparent, and generates image
	 *
	 * @param itemId
	 * @return
	 */
	private AsyncBufferedImage loadImage(int itemId, int quantity, boolean stackable)
	{
		AsyncBufferedImage img = new AsyncBufferedImage(36, 32, BufferedImage.TYPE_INT_ARGB);
		clientThread.invoke(() ->
		{
			if (client.getGameState().ordinal() < GameState.LOGIN_SCREEN.ordinal())
			{
				return false;
			}
			SpritePixels sprite = client.createItemSprite(itemId, quantity, 1, SpritePixels.DEFAULT_SHADOW_COLOR,
				stackable ? 1 : 0, false, CLIENT_DEFAULT_ZOOM);
			if (sprite == null)
			{
				return false;
			}
			sprite.toBufferedImage(img);
			img.changed();
			return true;
		});
		return img;
	}

	/**
	 * Get item sprite image as BufferedImage.
	 * <p>
	 * This method may return immediately with a blank image if not called on the game thread.
	 * The image will be filled in later. If this is used for a UI label/button, it should be added
	 * using AsyncBufferedImage::addTo to ensure it is painted properly
	 *
	 * @param itemId
	 * @return
	 */
	public AsyncBufferedImage getImage(int itemId)
	{
		return getImage(itemId, 1, false);
	}

	/**
	 * Get item sprite image as BufferedImage.
	 * <p>
	 * This method may return immediately with a blank image if not called on the game thread.
	 * The image will be filled in later. If this is used for a UI label/button, it should be added
	 * using AsyncBufferedImage::addTo to ensure it is painted properly
	 *
	 * @param itemId
	 * @param quantity
	 * @return
	 */
	public AsyncBufferedImage getImage(int itemId, int quantity, boolean stackable)
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

	/**
	 * Create item sprite and applies an outline.
	 *
	 * @param itemId item id
	 * @param itemQuantity item quantity
	 * @param outlineColor outline color
	 * @return image
	 */
	private BufferedImage loadItemOutline(final int itemId, final int itemQuantity, final Color outlineColor)
	{
		final SpritePixels itemSprite = client.createItemSprite(itemId, itemQuantity, 1, 0, 0, true, 710);
		return itemSprite.toBufferedOutline(outlineColor);
	}

	/**
	 * Get item outline with a specific color.
	 *
	 * @param itemId item id
	 * @param itemQuantity item quantity
	 * @param outlineColor outline color
	 * @return image
	 */
	public BufferedImage getItemOutline(final int itemId, final int itemQuantity, final Color outlineColor)
	{
		try
		{
			return itemOutlines.get(new OutlineKey(itemId, itemQuantity, outlineColor));
		}
		catch (ExecutionException e)
		{
			return null;
		}
	}
}
