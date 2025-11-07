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
import com.google.inject.Inject;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import static net.runelite.api.Constants.CLIENT_DEFAULT_ZOOM;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.SpritePixels;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.ItemQuantityMode;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.http.api.item.ItemPrice;

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
	private final ClientThread clientThread;
	private final ItemClient itemClient;
	private final RuneLiteConfig runeLiteConfig;

	@Inject(optional = true)
	@Named("activePriceThreshold")
	@SuppressWarnings("PMD.ImmutableField")
	private double activePriceThreshold = 5;

	@Inject(optional = true)
	@Named("lowPriceThreshold")
	@SuppressWarnings("PMD.ImmutableField")
	private int lowPriceThreshold = 1000;

	private Map<Integer, ItemPrice> itemPrices = Collections.emptyMap();
	private Map<Integer, ItemStats> itemStats = Collections.emptyMap();
	private final LoadingCache<ImageKey, AsyncBufferedImage> itemImages;
	private final LoadingCache<OutlineKey, BufferedImage> itemOutlines;

	// Worn items with weight reducing property have a different worn and inventory ItemID
	private static final ImmutableMap<Integer, Integer> WORN_ITEMS = ImmutableMap.<Integer, Integer>builder().
		put(ItemID.IKOV_BOOTSOFLIGHTNESSWORN, ItemID.IKOV_BOOTSOFLIGHTNESS).
		put(ItemID.BARBASSAULT_PENANCE_GLOVES_WORN, ItemID.BARBASSAULT_PENANCE_GLOVES).

		put(ItemID.GRACEFUL_HOOD_WORN, ItemID.GRACEFUL_HOOD).
		put(ItemID.GRACEFUL_CAPE_WORN, ItemID.GRACEFUL_CAPE).
		put(ItemID.GRACEFUL_TOP_WORN, ItemID.GRACEFUL_TOP).
		put(ItemID.GRACEFUL_LEGS_WORN, ItemID.GRACEFUL_LEGS).
		put(ItemID.GRACEFUL_GLOVES_WORN, ItemID.GRACEFUL_GLOVES).
		put(ItemID.GRACEFUL_BOOTS_WORN, ItemID.GRACEFUL_BOOTS).
		put(ItemID.ZEAH_GRACEFUL_HOOD_ARCEUUS_WORN, ItemID.ZEAH_GRACEFUL_HOOD_ARCEUUS).
		put(ItemID.ZEAH_GRACEFUL_CAPE_ARCEUUS_WORN, ItemID.ZEAH_GRACEFUL_CAPE_ARCEUUS).
		put(ItemID.ZEAH_GRACEFUL_TOP_ARCEUUS_WORN, ItemID.ZEAH_GRACEFUL_TOP_ARCEUUS).
		put(ItemID.ZEAH_GRACEFUL_LEGS_ARCEUUS_WORN, ItemID.ZEAH_GRACEFUL_LEGS_ARCEUUS).
		put(ItemID.ZEAH_GRACEFUL_GLOVES_ARCEUUS_WORN, ItemID.ZEAH_GRACEFUL_GLOVES_ARCEUUS).
		put(ItemID.ZEAH_GRACEFUL_BOOTS_ARCEUUS_WORN, ItemID.ZEAH_GRACEFUL_BOOTS_ARCEUUS).
		put(ItemID.ZEAH_GRACEFUL_HOOD_PISCARILIUS_WORN, ItemID.ZEAH_GRACEFUL_HOOD_PISCARILIUS).
		put(ItemID.ZEAH_GRACEFUL_CAPE_PISCARILIUS_WORN, ItemID.ZEAH_GRACEFUL_CAPE_PISCARILIUS).
		put(ItemID.ZEAH_GRACEFUL_TOP_PISCARILIUS_WORN, ItemID.ZEAH_GRACEFUL_TOP_PISCARILIUS).
		put(ItemID.ZEAH_GRACEFUL_LEGS_PISCARILIUS_WORN, ItemID.ZEAH_GRACEFUL_LEGS_PISCARILIUS).
		put(ItemID.ZEAH_GRACEFUL_GLOVES_PISCARILIUS_WORN, ItemID.ZEAH_GRACEFUL_GLOVES_PISCARILIUS).
		put(ItemID.ZEAH_GRACEFUL_BOOTS_PISCARILIUS_WORN, ItemID.ZEAH_GRACEFUL_BOOTS_PISCARILIUS).
		put(ItemID.ZEAH_GRACEFUL_HOOD_LOVAKENGJ_WORN, ItemID.ZEAH_GRACEFUL_HOOD_LOVAKENGJ).
		put(ItemID.ZEAH_GRACEFUL_CAPE_LOVAKENGJ_WORN, ItemID.ZEAH_GRACEFUL_CAPE_LOVAKENGJ).
		put(ItemID.ZEAH_GRACEFUL_TOP_LOVAKENGJ_WORN, ItemID.ZEAH_GRACEFUL_TOP_LOVAKENGJ).
		put(ItemID.ZEAH_GRACEFUL_LEGS_LOVAKENGJ_WORN, ItemID.ZEAH_GRACEFUL_LEGS_LOVAKENGJ).
		put(ItemID.ZEAH_GRACEFUL_GLOVES_LOVAKENGJ_WORN, ItemID.ZEAH_GRACEFUL_GLOVES_LOVAKENGJ).
		put(ItemID.ZEAH_GRACEFUL_BOOTS_LOVAKENGJ_WORN, ItemID.ZEAH_GRACEFUL_BOOTS_LOVAKENGJ).
		put(ItemID.ZEAH_GRACEFUL_HOOD_SHAYZIEN_WORN, ItemID.ZEAH_GRACEFUL_HOOD_SHAYZIEN).
		put(ItemID.ZEAH_GRACEFUL_CAPE_SHAYZIEN_WORN, ItemID.ZEAH_GRACEFUL_CAPE_SHAYZIEN).
		put(ItemID.ZEAH_GRACEFUL_TOP_SHAYZIEN_WORN, ItemID.ZEAH_GRACEFUL_TOP_SHAYZIEN).
		put(ItemID.ZEAH_GRACEFUL_LEGS_SHAYZIEN_WORN, ItemID.ZEAH_GRACEFUL_LEGS_SHAYZIEN).
		put(ItemID.ZEAH_GRACEFUL_GLOVES_SHAYZIEN_WORN, ItemID.ZEAH_GRACEFUL_GLOVES_SHAYZIEN).
		put(ItemID.ZEAH_GRACEFUL_BOOTS_SHAYZIEN_WORN, ItemID.ZEAH_GRACEFUL_BOOTS_SHAYZIEN).
		put(ItemID.ZEAH_GRACEFUL_HOOD_HOSIDIUS_WORN, ItemID.ZEAH_GRACEFUL_HOOD_HOSIDIUS).
		put(ItemID.ZEAH_GRACEFUL_CAPE_HOSIDIUS_WORN, ItemID.ZEAH_GRACEFUL_CAPE_HOSIDIUS).
		put(ItemID.ZEAH_GRACEFUL_TOP_HOSIDIUS_WORN, ItemID.ZEAH_GRACEFUL_TOP_HOSIDIUS).
		put(ItemID.ZEAH_GRACEFUL_LEGS_HOSIDIUS_WORN, ItemID.ZEAH_GRACEFUL_LEGS_HOSIDIUS).
		put(ItemID.ZEAH_GRACEFUL_GLOVES_HOSIDIUS_WORN, ItemID.ZEAH_GRACEFUL_GLOVES_HOSIDIUS).
		put(ItemID.ZEAH_GRACEFUL_BOOTS_HOSIDIUS_WORN, ItemID.ZEAH_GRACEFUL_BOOTS_HOSIDIUS).
		put(ItemID.ZEAH_GRACEFUL_HOOD_KOUREND_WORN, ItemID.ZEAH_GRACEFUL_HOOD_KOUREND).
		put(ItemID.ZEAH_GRACEFUL_CAPE_KOUREND_WORN, ItemID.ZEAH_GRACEFUL_CAPE_KOUREND).
		put(ItemID.ZEAH_GRACEFUL_TOP_KOUREND_WORN, ItemID.ZEAH_GRACEFUL_TOP_KOUREND).
		put(ItemID.ZEAH_GRACEFUL_LEGS_KOUREND_WORN, ItemID.ZEAH_GRACEFUL_LEGS_KOUREND).
		put(ItemID.ZEAH_GRACEFUL_GLOVES_KOUREND_WORN, ItemID.ZEAH_GRACEFUL_GLOVES_KOUREND).
		put(ItemID.ZEAH_GRACEFUL_BOOTS_KOUREND_WORN, ItemID.ZEAH_GRACEFUL_BOOTS_KOUREND).
		put(ItemID.GRACEFUL_HOOD_SKILLCAPECOLOUR_WORN, ItemID.GRACEFUL_HOOD_SKILLCAPECOLOUR).
		put(ItemID.GRACEFUL_CAPE_SKILLCAPECOLOUR_WORN, ItemID.GRACEFUL_CAPE_SKILLCAPECOLOUR).
		put(ItemID.GRACEFUL_TOP_SKILLCAPECOLOUR_WORN, ItemID.GRACEFUL_TOP_SKILLCAPECOLOUR).
		put(ItemID.GRACEFUL_LEGS_SKILLCAPECOLOUR_WORN, ItemID.GRACEFUL_LEGS_SKILLCAPECOLOUR).
		put(ItemID.GRACEFUL_GLOVES_SKILLCAPECOLOUR_WORN, ItemID.GRACEFUL_GLOVES_SKILLCAPECOLOUR).
		put(ItemID.GRACEFUL_BOOTS_SKILLCAPECOLOUR_WORN, ItemID.GRACEFUL_BOOTS_SKILLCAPECOLOUR).
		put(ItemID.GRACEFUL_HOOD_HALLOWED_WORN, ItemID.GRACEFUL_HOOD_HALLOWED).
		put(ItemID.GRACEFUL_CAPE_HALLOWED_WORN, ItemID.GRACEFUL_CAPE_HALLOWED).
		put(ItemID.GRACEFUL_TOP_HALLOWED_WORN, ItemID.GRACEFUL_TOP_HALLOWED).
		put(ItemID.GRACEFUL_LEGS_HALLOWED_WORN, ItemID.GRACEFUL_LEGS_HALLOWED).
		put(ItemID.GRACEFUL_GLOVES_HALLOWED_WORN, ItemID.GRACEFUL_GLOVES_HALLOWED).
		put(ItemID.GRACEFUL_BOOTS_HALLOWED_WORN, ItemID.GRACEFUL_BOOTS_HALLOWED).
		put(ItemID.GRACEFUL_HOOD_TRAILBLAZER_WORN, ItemID.GRACEFUL_HOOD_TRAILBLAZER).
		put(ItemID.GRACEFUL_CAPE_TRAILBLAZER_WORN, ItemID.GRACEFUL_CAPE_TRAILBLAZER).
		put(ItemID.GRACEFUL_TOP_TRAILBLAZER_WORN, ItemID.GRACEFUL_TOP_TRAILBLAZER).
		put(ItemID.GRACEFUL_LEGS_TRAILBLAZER_WORN, ItemID.GRACEFUL_LEGS_TRAILBLAZER).
		put(ItemID.GRACEFUL_GLOVES_TRAILBLAZER_WORN, ItemID.GRACEFUL_GLOVES_TRAILBLAZER).
		put(ItemID.GRACEFUL_BOOTS_TRAILBLAZER_WORN, ItemID.GRACEFUL_BOOTS_TRAILBLAZER).
		put(ItemID.GRACEFUL_HOOD_ADVENTURER_WORN, ItemID.GRACEFUL_HOOD_ADVENTURER).
		put(ItemID.GRACEFUL_CAPE_ADVENTURER_WORN, ItemID.GRACEFUL_CAPE_ADVENTURER).
		put(ItemID.GRACEFUL_TOP_ADVENTURER_WORN, ItemID.GRACEFUL_TOP_ADVENTURER).
		put(ItemID.GRACEFUL_LEGS_ADVENTURER_WORN, ItemID.GRACEFUL_LEGS_ADVENTURER).
		put(ItemID.GRACEFUL_GLOVES_ADVENTURER_WORN, ItemID.GRACEFUL_GLOVES_ADVENTURER).
		put(ItemID.GRACEFUL_BOOTS_ADVENTURER_WORN, ItemID.GRACEFUL_BOOTS_ADVENTURER).
		put(ItemID.GRACEFUL_HOOD_WYRM_WORN, ItemID.GRACEFUL_HOOD_WYRM).
		put(ItemID.GRACEFUL_CAPE_WYRM_WORN, ItemID.GRACEFUL_CAPE_WYRM).
		put(ItemID.GRACEFUL_TOP_WYRM_WORN, ItemID.GRACEFUL_TOP_WYRM).
		put(ItemID.GRACEFUL_LEGS_WYRM_WORN, ItemID.GRACEFUL_LEGS_WYRM).
		put(ItemID.GRACEFUL_GLOVES_WYRM_WORN, ItemID.GRACEFUL_GLOVES_WYRM).
		put(ItemID.GRACEFUL_BOOTS_WYRM_WORN, ItemID.GRACEFUL_BOOTS_WYRM).

		put(ItemID.SKILLCAPE_MAX_WORN, ItemID.SKILLCAPE_MAX).

		put(ItemID.HUNTING_LIGHT_CAPE_WORN, ItemID.HUNTING_LIGHT_CAPE).
		put(ItemID.HUNTING_LIGHTER_CAPE_WORN, ItemID.HUNTING_LIGHTER_CAPE).

		put(ItemID.SKILLCAPE_AGILITY_TRIMMED_WORN, ItemID.SKILLCAPE_AGILITY_TRIMMED).
		put(ItemID.SKILLCAPE_AGILITY_WORN, ItemID.SKILLCAPE_AGILITY).

		put(ItemID.HUNTING_CAMOFLAUGE_ROBE_WOOD_WORN, ItemID.HUNTING_CAMOFLAUGE_ROBE_WOOD).
		put(ItemID.HUNTING_TROUSERS_WOOD_WORN, ItemID.HUNTING_TROUSERS_WOOD).
		put(ItemID.HUNTING_CAMOFLAUGE_ROBE_JUNGLE_WORN, ItemID.HUNTING_CAMOFLAUGE_ROBE_JUNGLE).
		put(ItemID.HUNTING_TROUSERS_JUNGLE_WORN, ItemID.HUNTING_TROUSERS_JUNGLE).
		put(ItemID.HUNTING_CAMOFLAUGE_ROBE_DESERT_WORN, ItemID.HUNTING_CAMOFLAUGE_ROBE_DESERT).
		put(ItemID.HUNTING_TROUSERS_DESERT_WORN, ItemID.HUNTING_TROUSERS_DESERT).
		put(ItemID.HUNTING_CAMOFLAUGE_ROBE_POLAR_WORN, ItemID.HUNTING_CAMOFLAUGE_ROBE_POLAR).
		put(ItemID.HUNTING_TROUSERS_POLAR_WORN, ItemID.HUNTING_TROUSERS_POLAR).
		build();

	@Inject
	public ItemManager(Client client, ScheduledExecutorService scheduledExecutorService, ClientThread clientThread,
		ItemClient itemClient, RuneLiteConfig runeLiteConfig)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.itemClient = itemClient;
		this.runeLiteConfig = runeLiteConfig;

		scheduledExecutorService.scheduleWithFixedDelay(this::loadPrices, 0, 30, TimeUnit.MINUTES);
		scheduledExecutorService.submit(this::loadStats);

		itemImages = CacheBuilder.newBuilder()
			.maximumSize(128L)
			.expireAfterAccess(1, TimeUnit.HOURS)
			.build(new CacheLoader<>()
			{
				@Override
				public AsyncBufferedImage load(ImageKey key) throws Exception
				{
					return loadImage(key.itemId, key.itemQuantity, key.stackable);
				}
			});

		itemOutlines = CacheBuilder.newBuilder()
			.maximumSize(128L)
			.expireAfterAccess(1, TimeUnit.HOURS)
			.build(new CacheLoader<>()
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
					map.put(price.getId(), price);
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

	private void loadStats()
	{
		try
		{
			final Map<Integer, ItemStats> stats = itemClient.getStats();
			if (stats != null)
			{
				itemStats = ImmutableMap.copyOf(stats);
			}

			log.debug("Loaded {} stats", itemStats.size());
		}
		catch (IOException e)
		{
			log.warn("error loading stats!", e);
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
		return getItemPriceWithSource(itemID, runeLiteConfig.useWikiItemPrices());
	}

	/**
	 * Look up an item's price
	 *
	 * @param itemID item id
	 * @param useWikiPrice use the actively traded/wiki price
	 * @return item price
	 */
	public int getItemPriceWithSource(int itemID, boolean useWikiPrice)
	{
		if (itemID == ItemID.COINS)
		{
			return 1;
		}
		if (itemID == ItemID.PLATINUM)
		{
			return 1000;
		}

		ItemComposition itemComposition = getItemComposition(itemID);
		if (itemComposition.getNote() != -1)
		{
			itemID = itemComposition.getLinkedNoteId();
		}
		itemID = WORN_ITEMS.getOrDefault(itemID, itemID);

		int price = 0;

		final Collection<ItemMapping> mappedItems = ItemMapping.map(itemID);

		if (mappedItems == null)
		{
			final ItemPrice ip = itemPrices.get(itemID);

			if (ip != null)
			{
				price = useWikiPrice ? getWikiPrice(ip) : ip.getPrice();
			}
		}
		else
		{
			for (final ItemMapping mappedItem : mappedItems)
			{
				price += getItemPriceWithSource(mappedItem.getTradeableItem(), useWikiPrice) * mappedItem.getQuantity();
			}
		}

		return price;
	}

	/**
	 * Get the wiki price for an item, with checks to try and avoid excessive price manipulation
	 * @param itemPrice
	 * @return
	 */
	public int getWikiPrice(ItemPrice itemPrice)
	{
		final int wikiPrice = itemPrice.getWikiPrice();
		final int jagPrice = itemPrice.getPrice();
		if (wikiPrice <= 0)
		{
			return jagPrice;
		}
		if (wikiPrice <= lowPriceThreshold)
		{
			return wikiPrice;
		}
		return wikiPrice < jagPrice * activePriceThreshold ? wikiPrice : jagPrice;
	}

	/**
	 * Look up an item's stats
	 * @param itemId item id
	 * @return item stats
	 */
	@Nullable
	public ItemStats getItemStats(int itemId)
	{
		ItemComposition itemComposition = getItemComposition(itemId);

		if (itemComposition.getName() == null || itemComposition.getNote() != -1)
		{
			return null;
		}

		return itemStats.get(canonicalize(itemId));
	}

	/**
	 * Look up an item's stats
	 *
	 * @param itemId item id
	 * @return item stats
	 * @deprecated See {@link #getItemStats(int)}
	 */
	@Nullable
	@Deprecated
	public net.runelite.http.api.item.ItemStats getItemStats(int itemId, boolean allowNote)
	{
		ItemComposition itemComposition = getItemComposition(itemId);

		if (itemComposition.getName() == null || (!allowNote && itemComposition.getNote() != -1))
		{
			return null;
		}

		var stats = itemStats.get(canonicalize(itemId));
		return stats != null ? stats.toHttpApiFormat() : null;
	}

	/**
	 * Search for tradeable items based on item name
	 *
	 * @param itemName item name
	 * @return
	 */
	public List<ItemPrice> search(String itemName)
	{
		itemName = itemName.toLowerCase();

		List<ItemPrice> result = new ArrayList<>();
		for (ItemPrice itemPrice : itemPrices.values())
		{
			final String name = itemPrice.getName();
			if (name.toLowerCase().contains(itemName))
			{
				result.add(itemPrice);
			}
		}
		return result;
	}

	/**
	 * Look up an item's composition
	 *
	 * @param itemId item id
	 * @return item composition
	 */
	@Nonnull
	public ItemComposition getItemComposition(int itemId)
	{
		return client.getItemDefinition(itemId);
	}

	/**
	 * Get an item's un-noted, un-placeholdered ID
	 */
	public int canonicalize(int itemID)
	{
		ItemComposition itemComposition = getItemComposition(itemID);

		if (itemComposition.getNote() != -1)
		{
			return itemComposition.getLinkedNoteId();
		}

		if (itemComposition.getPlaceholderTemplateId() != -1)
		{
			return itemComposition.getPlaceholderId();
		}

		return WORN_ITEMS.getOrDefault(itemID, itemID);
	}

	/**
	 * Loads item sprite from game, makes transparent, and generates image
	 *
	 * @param itemId
	 * @return
	 */
	private AsyncBufferedImage loadImage(int itemId, int quantity, boolean stackable)
	{
		AsyncBufferedImage img = new AsyncBufferedImage(clientThread, Constants.ITEM_SPRITE_WIDTH, Constants.ITEM_SPRITE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		clientThread.invoke(() ->
		{
			if (client.getGameState().ordinal() < GameState.LOGIN_SCREEN.ordinal())
			{
				return false;
			}
			SpritePixels sprite = client.createItemSprite(itemId, quantity, 1, SpritePixels.DEFAULT_SHADOW_COLOR,
				stackable ? ItemQuantityMode.ALWAYS : ItemQuantityMode.NEVER, false, CLIENT_DEFAULT_ZOOM);
			if (sprite == null)
			{
				return false;
			}
			sprite.toBufferedImage(img);
			img.loaded();
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
		final SpritePixels itemSprite = client.createItemSprite(itemId, itemQuantity, 1, 0, 0, false, CLIENT_DEFAULT_ZOOM);
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
