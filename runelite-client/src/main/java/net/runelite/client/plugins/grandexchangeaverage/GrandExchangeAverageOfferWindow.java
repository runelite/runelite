package net.runelite.client.plugins.grandexchangeaverage;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@Slf4j
class GrandExchangeAverageOfferWindow
{


	private final Client client;

	@Inject
	GrandExchangeAverageOfferWindow(Client client)
	{
		this.client = client;
	}


	public boolean isOpen()
	{
		//Find the Offer Container.
		Widget widgetGrandExchangeOfferContainer = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_CONTAINER);

		//Return false if not opened.
		if (widgetGrandExchangeOfferContainer == null ||
				widgetGrandExchangeOfferContainer.isHidden())
		{
			return false;
		}

		//Get the first child which contains the title text.
		Widget[] children = widgetGrandExchangeOfferContainer.getDynamicChildren();
		Widget widgetGrandExchangeOfferContainerTitle = children[1];

		return widgetGrandExchangeOfferContainerTitle.getText().contains("Set up offer");
	}

	public int getItemId()
	{
		//Widget IDs in Grand Exchange interface has the same ID for some reason.
		Widget widgetGrandExchangeOfferElements = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TITLE);

		if (widgetGrandExchangeOfferElements == null ||
				widgetGrandExchangeOfferElements.isHidden())
		{
			return -1;
		}

		//The title we want is 21th child.
		Widget[] children = widgetGrandExchangeOfferElements.getDynamicChildren();

		//If itemid is -1 or 6512 (both invalid)
		if (children[21].getItemId() == -1 || children[21].getItemId() == 6512)
		{
			return -1;
		}

		return children[21].getItemId();

	}

	public void appendPrice(int itemPrice)
	{

		//Widget IDs in Grand Exchange interface has the same ID for some reason.
		Widget widgetGrandExchangeOfferText = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TEXT);

		if (widgetGrandExchangeOfferText == null ||
				widgetGrandExchangeOfferText.isHidden() ||
				itemPrice <= 0)
		{
			return;
		}

		//Get the item description.
		String defaultText = widgetGrandExchangeOfferText.getText();

		//If we have already changed the text, don't do it again.
		if (defaultText.contains("Actively traded price"))
		{
			return;
		}

		String newText = defaultText +
				"<br>" +
				"Actively traded price: " + itemPrice;

		widgetGrandExchangeOfferText.setText(newText);
	}
}
