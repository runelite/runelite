package net.runelite.client.plugins.grandexchangeaverage;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.grandexchangeaverage.GrandExchangeOfferText;
import net.runelite.client.plugins.grandexchangeaverage.GrandExchangeOfferTitle;
import javax.inject.Inject;

@PluginDescriptor(name = "Grand Exchange Average")
public class GrandExchangeAveragePlugin {
    @Inject
    private Client client;

    @Inject
    private GrandExchangeOfferTitle offerTitle;

    @Inject
    private GrandExchangeOfferText offerText;


    @Subscribe
    public void onGameTick(GameTick event)
    {
        Widget widgetGrandExchangeOfferTitle = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TITLE);

        if (widgetGrandExchangeOfferTitle == null || widgetGrandExchangeOfferTitle.isHidden())
        {
            return;
        }

        offerTitle.save();

        int averagePrice = getGEAveragePrice(offerTitle);

    }
}
