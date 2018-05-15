package net.runelite.client.plugins.grandexchangeaverage;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(name = "Grand Exchange Average")
public class GrandExchangeAveragePlugin extends Plugin
{

	@Inject
	private GrandExchangeAverageConfig config;

	@Inject
	private Client client;

	@Inject
	private GrandExchangeAverageOfferWindow offerWindow;

	@Inject
	private GrandExchangeAveragePrice averagePrice;

	@Provides
	GrandExchangeAverageConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GrandExchangeAverageConfig.class);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{

		Widget widgetGrandExchangeContainer = client.getWidget(WidgetInfo.GRAND_EXCHANGE_CONTAINER);

		if (widgetGrandExchangeContainer == null || widgetGrandExchangeContainer.isHidden())
		{
			return;
		}

		if (!offerWindow.isOpen())
		{
			return;
		}

		//Get the ID of the item currently in focus.
		int itemId = offerWindow.getItemId();
		if (itemId == -1)
		{
			return;
		}

		//Get the price.
		int itemPrice = averagePrice.getTradedPrice(itemId);
		offerWindow.appendPrice(itemPrice);

	}
}
