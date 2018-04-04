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
import net.runelite.client.plugins.grandexchangeaverage.GrandExchangeOfferText;
import net.runelite.client.plugins.grandexchangeaverage.GrandExchangeOfferTitle;
import javax.inject.Inject;

@Slf4j
@PluginDescriptor(name = "Grand Exchange Average")
public class GrandExchangeAveragePlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private GrandExchangeOfferTitle offerTitle;

    @Inject
    private GrandExchangeOfferText offerText;

    @Provides
    GrandExchangeAverageConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(GrandExchangeAverageConfig.class);
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        Widget widgetGrandExchangeOfferTitle = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TITLE);

        if (widgetGrandExchangeOfferTitle == null || widgetGrandExchangeOfferTitle.isHidden())
        {
            return;
        }

        log.debug("Found Offer Title!");
        //offerTitle.save();

        //int averagePrice = getGEAveragePrice(offerTitle);

    }
}
