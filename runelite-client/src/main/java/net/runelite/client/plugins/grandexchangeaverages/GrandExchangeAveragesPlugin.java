/*
 * Copyright (c) 2018, AeonLucid <https://github.com/AeonLucid>
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
package net.runelite.client.plugins.grandexchangeaverages;

import com.google.common.eventbus.Subscribe;
import java.io.IOException;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.osb.grandexchange.GrandExchangeCallback;
import net.runelite.http.api.osb.grandexchange.GrandExchangeClient;
import net.runelite.http.api.osb.grandexchange.GrandExchangeResult;

@PluginDescriptor(
	name = "OSB Grand Exchange Averages",
	enabledByDefault = false
)
@Slf4j
public class GrandExchangeAveragesPlugin extends Plugin
{
	private static final int OFFER_CONTAINER_ITEM = 21;
	private static final int OFFER_DEFAULT_ITEM_ID = 6512;

	@Inject
	private Client client;

	private Widget grandExchangeText;
	private Widget grandExchangeItem;

	private int lastItem = -1;

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		switch (event.getGroupId())
		{
			// Grand exchange was opened.
			case WidgetID.GRAND_EXCHANGE_GROUP_ID:
				Widget grandExchangeOffer = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_CONTAINER);
				grandExchangeText = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_TEXT);
				grandExchangeItem = grandExchangeOffer.getDynamicChildren()[OFFER_CONTAINER_ITEM];
				lastItem = -1;
				break;

			// Grand exchange was closed (if it was open before).
			case WidgetID.INVENTORY_GROUP_ID:
				grandExchangeText = null;
				grandExchangeItem = null;
				lastItem = -1;
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (grandExchangeText == null || grandExchangeItem == null)
		{
			return;
		}

		int itemId = grandExchangeItem.getItemId();
		if (itemId == OFFER_DEFAULT_ITEM_ID
			|| itemId == -1
			|| lastItem == itemId)
		{
			return;
		}

		lastItem = itemId;

		final Widget geText = grandExchangeText;
		final GrandExchangeClient grandExchangeClient = new GrandExchangeClient();

		grandExchangeClient.lookupItem(itemId, new GrandExchangeCallback()
		{
			@Override
			public void onSuccess(GrandExchangeResult result)
			{
				String text = geText.getText() + "<br>OSBuddy actively traded price: " + StackFormatter.formatNumber(result.getOverall_average());
				geText.setText(text);
			}

			@Override
			public void onFailure(IOException exception)
			{
				log.warn("Error getting price of item {}", itemId, exception);
			}
		});
	}
}
