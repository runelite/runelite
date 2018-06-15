package net.runelite.client.plugins.grandexchangeaverages;

import com.google.common.eventbus.Subscribe;
import java.io.IOException;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.grandexchange.GrandExchangeClient;
import net.runelite.http.api.grandexchange.GrandExchangeResult;

@PluginDescriptor(
	name = "GrandExchange Averages",
	enabledByDefault = false
)
@Slf4j
public class GrandExchangeAveragesPlugin extends Plugin
{
	private static final int OFFER_CONTAINER_ITEM = 21;

	@Inject
	private Client client;

	private GrandExchangeClient grandExchangeClient = new GrandExchangeClient();

	private Widget grandExchangeOffer;

	private Widget grandExchangeText;

	private Widget grandExchangeItem;

	private int currentItemId = -1;

	private String currentItemText;

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		switch (event.getGroupId())
		{
			// Grand exchange was opened.
			case WidgetID.GRAND_EXCHANGE_GROUP_ID:
				grandExchangeOffer = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_CONTAINER);
				grandExchangeText = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TEXT);
				grandExchangeItem = grandExchangeOffer.getDynamicChildren()[OFFER_CONTAINER_ITEM];
				currentItemId = ItemID.NULL;
				break;

			// Grand exchange was closed (if it was open before).
			case WidgetID.INVENTORY_GROUP_ID:
				grandExchangeOffer = null;
				grandExchangeText = null;
				grandExchangeItem = null;
				currentItemId = ItemID.NULL;
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (grandExchangeOffer == null || grandExchangeText == null || grandExchangeItem == null)
		{
			return;
		}

		int itemId = grandExchangeItem.getItemId();
		if (itemId == currentItemId || itemId == -1)
		{
			return;
		}

		currentItemId = itemId;
		currentItemText = grandExchangeText.getText();

		setCurrentItemPrice(itemId, "Loading..");
		loadCurrentItemPrice(itemId);
	}

	private void setCurrentItemPrice(int itemId, String priceText)
	{
		if (currentItemId == itemId)
		{
			grandExchangeText.setText(currentItemText + "<br>Actively traded price: " + priceText);
		}
	}

	private void loadCurrentItemPrice(final int itemId)
	{
		try
		{
			GrandExchangeResult result = grandExchangeClient.lookupItem(itemId);
			setCurrentItemPrice(itemId, StackFormatter.formatNumber(result.getOverall()));
		}
		catch (IOException exception)
		{
			log.warn("Error while grabbing price of item id " + itemId, exception);
		}
	}
}
