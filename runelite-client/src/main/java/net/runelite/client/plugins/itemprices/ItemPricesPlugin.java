/*
 * Copyright (c) 2018 Charlie Waters
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
package net.runelite.client.plugins.itemprices;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.FontID;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetSizeMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.StackFormatter;

import javax.inject.Inject;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

@PluginDescriptor(
	name = "Item Prices",
	description = "Show prices on hover for items in your inventory and bank",
	tags = {"bank", "inventory", "overlay", "high", "alchemy", "grand", "exchange", "tooltips"},
	enabledByDefault = false
)
public class ItemPricesPlugin extends Plugin
{

	private static final DecimalFormat FORMATTER = new DecimalFormat("#,###.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemPricesOverlay overlay;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ItemPricesConfig itemPricesConfig;

	private Widget totalHighAlchValueWidget;

	@Provides
	ItemPricesConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemPricesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onWidgetLoaded(final WidgetLoaded event)
	{
		if (itemPricesConfig.showHighAlchOnGuidePrices())
		{
			if (WidgetID.GUIDE_PRICES_GROUP_ID == event.getGroupId())
			{

				final Widget parentWidget = client.getWidget(WidgetInfo.GUIDE_PRICES_MAIN_CONTAINER);

				final Widget totalGePricesWidget = client.getWidget(WidgetInfo.GUIDE_PRICES_ITEMS_VALUE);
				totalGePricesWidget.setWidthMode(WidgetSizeMode.ABSOLUTE);
				totalGePricesWidget.setOriginalWidth(totalGePricesWidget.getWidth() / 2);
				totalGePricesWidget.revalidate();

				this.totalHighAlchValueWidget = parentWidget.createChild(-1, WidgetType.TEXT);
				totalHighAlchValueWidget.setFontId(FontID.PLAIN_12);
				totalHighAlchValueWidget.setTextShadowed(true);
				totalHighAlchValueWidget.setTextColor(0xFF981F);
				totalHighAlchValueWidget.setXTextAlignment(1);
				totalHighAlchValueWidget.setYTextAlignment(1);
				totalHighAlchValueWidget.setText(createHighAlchemyValueText(0L));
				totalHighAlchValueWidget.setOriginalWidth(totalGePricesWidget.getWidth());
				totalHighAlchValueWidget.setOriginalHeight(totalGePricesWidget.getHeight());
				totalHighAlchValueWidget.setOriginalX(totalGePricesWidget.getOriginalX() + totalGePricesWidget.getWidth());
				totalHighAlchValueWidget.setOriginalY(totalGePricesWidget.getOriginalY());
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		if (itemPricesConfig.showHighAlchOnGuidePrices())
		{
			if (InventoryID.GUIDE_PRICES.getId() == event.getContainerId())
			{
				final ItemContainer itemContainer = event.getItemContainer();
				final Item[] items = itemContainer.getItems();
				final long totalHighAlchValue = calculateTotalHighAlchValue(items);
				this.totalHighAlchValueWidget.setText(createHighAlchemyValueText(totalHighAlchValue));
			}
		}
	}

	private long calculateTotalHighAlchValue(final Item[] items)
	{
		return Arrays.stream(items)
				.map(this::toHighAlchValue)
				.reduce(Long::sum)
				.orElse(0L);
	}

	private long toHighAlchValue(final Item item)
	{
		final int itemId = itemManager.canonicalize(item.getId());
		return calculateHighAlchValue(itemId) * item.getQuantity();
	}

	private int calculateHighAlchValue(final int itemId)
	{
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		return Math.round(itemComposition.getPrice() * Constants.HIGH_ALCHEMY_MULTIPLIER);
	}

	private String createHighAlchemyValueText(final long value)
	{
		final String formattedValue = StackFormatter.formatNumber(value);
		return String.format("Total High Alchemy value:<br><col=ffffff>%s</col>", formattedValue);
	}
}
