/*
 * Copyright (c) 2019 Patrick Seute <https://github.com/superronjon>
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

package net.runelite.client.plugins.highalchguideprice;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.inject.Inject;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@PluginDescriptor(
		name = "High Alch Guide Prices",
		description = "Show prices for High Alchemy alongside the Grand Exchange prices in the price checker menu"
)

public class HighAlchGuidePricePlugin extends Plugin
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	private final StringBuilder stringBuilder = new StringBuilder();

	@Inject
	private ItemManager itemManager;

	@Inject
	private Client client;

	@Override
	protected void shutDown() throws Exception
	{
		Widget priceWidget = client.getWidget(WidgetInfo.GUIDE_PRICES_PRICE_CONTAINER);

		if (priceWidget != null)
		{
			Widget itemContainerWidget = client.getWidget(WidgetInfo.GUIDE_PRICES_ITEMS_CONTAINER);
			int totalPrice = 0;
			if (itemContainerWidget.getDynamicChildren() != null)
			{
				totalPrice = setDisplaydefault(itemContainerWidget.getDynamicChildren());
			}

			NumberFormat commaSep = NumberFormat.getInstance();
			commaSep.setGroupingUsed(true);
			priceWidget.setText("Total guide price: <col=ffffff>" + commaSep.format(totalPrice) + "</col>");
		}
	}

	@Subscribe
	protected void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		Widget priceWidget = client.getWidget(WidgetInfo.GUIDE_PRICES_PRICE_CONTAINER);
		Widget itemContainerWidget = client.getWidget(WidgetInfo.GUIDE_PRICES_ITEMS_CONTAINER);

		if (priceWidget != null)
		{
			String currPriceText = priceWidget.getText();
			Pattern p = Pattern.compile("<col=ffffff>(.*?)</col>");
			Matcher m = p.matcher(currPriceText);
			if (m.find())
			{
				int alchValue = 0;
				if (itemContainerWidget.getDynamicChildren() != null)
				{
					alchValue = setDisplayHighAlch(itemContainerWidget.getDynamicChildren());
				}

				currPriceText = m.group(1);

				NumberFormat commaSep = NumberFormat.getInstance();
				commaSep.setGroupingUsed(true);

				priceWidget.setText("Total guide price: <col=ffffff>" + currPriceText + "</col>   High alchemy: <col=ffffff>" + commaSep.format(alchValue) + "</col>");
			}

		}
	}

	private int setDisplayHighAlch(Widget[] itemWidgets)
	{
		int totalValue = 0;
		for (int i = 0; i < 28; i++)
		{
			if (itemWidgets[i].getItemQuantity() < 1)
			{
				break;
			}

			Widget currentItemWidget = itemWidgets[i];
			Widget currentTextWidget = itemWidgets[28 + i];
			ItemComposition itemComposition = itemManager.getItemComposition(currentItemWidget.getItemId());
			int realId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : currentItemWidget.getItemId();

			//Add alch value to total
			int alchValue = getHighAlchValue(realId);
			int geValue = getGrandExchangeValue(realId);
			totalValue += alchValue * currentItemWidget.getItemQuantity();

			//Display alch value beneath image
			currentTextWidget.setText(buildItemAlchString(alchValue, geValue, currentItemWidget.getItemQuantity()));
		}

		return totalValue;
	}

	private int setDisplaydefault(Widget[] itemWidgets)
	{
		int totalValue = 0;
		for (int i = 0; i < 28; i++)
		{
			if (itemWidgets[i].getItemQuantity() < 1)
			{
				break;
			}

			Widget currentItemWidget = itemWidgets[i];
			Widget currentTextWidget = itemWidgets[28 + i];

			int geValue = 0;
			int quantity = currentItemWidget.getItemQuantity();

			if (quantity == 1)
			{
				Pattern p = Pattern.compile("GE = (.*?)<br>");
				Matcher m = p.matcher(currentTextWidget.getText());

				if (m.find())
				{
					try
					{
						geValue = NumberFormat.getNumberInstance(java.util.Locale.US).parse(m.group(1)).intValue();
					}
					catch (ParseException e)
					{
						e.printStackTrace();
						geValue = 0;
					}

					currentTextWidget.setText(m.group(1));
				}
			}
			else
			{
				Pattern p = Pattern.compile("x (.*?)<br>");
				Matcher m = p.matcher(currentTextWidget.getText());

				if (m.find())
				{
					try
					{
						geValue = NumberFormat.getNumberInstance(java.util.Locale.US).parse(m.group(1)).intValue();
					}
					catch (ParseException e)
					{
						e.printStackTrace();
						geValue = 0;
					}
					stringBuilder.append(quantity)
							.append(" x ")
							.append(geValue)
							.append("<br>= ")
							.append(quantity * geValue);
					currentTextWidget.setText(stringBuilder.toString());
					stringBuilder.setLength(0);
				}
			}

			totalValue += geValue * quantity;

			currentTextWidget.setText(buildItemDefaultString(geValue, currentItemWidget.getItemQuantity()));
		}
		return totalValue;
	}

	private int getHighAlchValue(int itemID)
	{
		return (int)(itemManager.getItemComposition(itemID).getPrice() * HIGH_ALCHEMY_CONSTANT);
	}

	private int getGrandExchangeValue(int itemID)
	{
		return itemManager.getItemPrice(itemID);
	}

	private String buildItemAlchString(int alchValue, int geValue, int quantity)
	{
		NumberFormat commaSep = NumberFormat.getInstance();
		commaSep.setGroupingUsed(true);

		if (quantity == 1)
		{
			stringBuilder.append("GE = ")
					.append(commaSep.format(geValue))
					.append("<br>HA = ")
					.append(commaSep.format(alchValue));
		}
		else
		{
			stringBuilder.append(quantity)
					.append(" x ")
					.append(commaSep.format(geValue))
					.append("<br>GE = ")
					.append(commaSep.format(geValue * quantity))
					.append("<br>HA = ")
					.append(commaSep.format(alchValue * quantity));
		}

		final String result = stringBuilder.toString();
		stringBuilder.setLength(0);
		return result;
	}

	private String buildItemDefaultString(int geValue, int quantity)
	{
		NumberFormat commaSep = NumberFormat.getInstance();
		commaSep.setGroupingUsed(true);

		if (quantity == 1)
		{
			stringBuilder.append(commaSep.format(geValue));
		}
		else
		{
			stringBuilder.append(quantity)
					.append(" x ")
					.append(commaSep.format(geValue))
					.append("<br>= ")
					.append(commaSep.format(quantity * geValue));
		}

		final String result = stringBuilder.toString();
		stringBuilder.setLength(0);
		return result;
	}
}
