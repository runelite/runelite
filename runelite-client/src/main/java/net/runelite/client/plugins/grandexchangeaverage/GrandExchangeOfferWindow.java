package net.runelite.client.plugins.grandexchangeaverage;

import com.google.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@Slf4j
class GrandExchangeOfferWindow {


    private final Client client;
    private final GrandExchangeAverageConfig config;

    private String changedText;
    private int storedItemPrice;

    @Inject
    GrandExchangeOfferWindow(Client client, GrandExchangeAverageConfig config)
    {
        this.client = client;
        this.config = config;
    }


    public boolean isOpen() {
        //Widget IDs in Grand Exchange interface has the same ID for some reason.
        Widget widgetGrandExchangeOfferElements = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TITLE);

        if (widgetGrandExchangeOfferElements == null ||
                widgetGrandExchangeOfferElements.isHidden())
        {
            return false;
        }

        //The title we want is 25th child.
        Widget[] children = widgetGrandExchangeOfferElements.getDynamicChildren();
        Widget widgetGrandExchangeOfferTitle = children[25];

        return widgetGrandExchangeOfferTitle.getType() == 4;
    }

    public int getItemId() {
        //Widget IDs in Grand Exchange interface has the same ID for some reason.
        Widget widgetGrandExchangeOfferElements = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TITLE);

        if (widgetGrandExchangeOfferElements == null ||
                widgetGrandExchangeOfferElements.isHidden())
        {
            return -1;
        }

        //The title we want is 21th child.
        Widget[] children = widgetGrandExchangeOfferElements.getDynamicChildren();
        if(children[21].getItemId() == -1 || children[21].getItemId() == 6512)
        {
            return -1;
        }

        return children[21].getItemId();

    }

    public void appendPrice(int itemPrice) {

        //Widget IDs in Grand Exchange interface has the same ID for some reason.
        Widget widgetGrandExchangeOfferText = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TEXT);

        if (widgetGrandExchangeOfferText == null ||
                widgetGrandExchangeOfferText.isHidden() ||
                itemPrice <= 0)
        {
            return;
        }
        String defaultText = widgetGrandExchangeOfferText.getText();

        if(defaultText.contains("Actively traded price"))
        {
            return;
        }

        String newText = defaultText +
                "<br>" +
                "Actively traded price: " + itemPrice;

        widgetGrandExchangeOfferText.setText(newText);
    }
}
