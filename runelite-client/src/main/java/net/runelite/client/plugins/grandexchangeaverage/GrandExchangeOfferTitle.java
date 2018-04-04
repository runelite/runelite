package net.runelite.client.plugins.grandexchangeaverage;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.StackFormatter;

public class GrandExchangeOfferTitle {

    private final Client client;
    private final GrandExchangeAverageConfig config;

    private String offerTitle;

    @Inject
    GrandExchangeOfferTitle(Client client, GrandExchangeAverageConfig config)
    {
        this.client = client;
        this.config = config;
    }


    void save()
    {
        Widget widgetOfferTitleBar = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TITLE);

        // Only save if the title hasn't been modified
        // Don't update on a search because rs seems to constantly update the title
        if (widgetOfferTitleBar == null ||
                widgetOfferTitleBar.isHidden() ||
                widgetOfferTitleBar.getText().contains("Choose"))
        {
            return;
        }

        log.debug();


        offerTitle = widgetOfferTitleBar.getText();
    }
}
