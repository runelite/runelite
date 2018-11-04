/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.aprilfirst;

import com.google.common.eventbus.Subscribe;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "April Fools",
	description = "Happy April Fools!",
	tags = {"April", "fools"}
)
@Slf4j
public class AprilFirstPlugin extends Plugin
{
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/dd");
	private static final String date = DATE_TIME_FORMATTER.format(LocalDate.now());
	private static final boolean enabled = date.equals("04/01") || true;
	private static final int EMPTY_BANK_CHANCE = 20; // Percent chance for feature to trigger

	@Inject
	private Client client;

	// Empty Bank values
	private boolean bankOpened = false;
	private Widget[] widgets;


	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!enabled)
		{
			return;
		}

		boolean old = bankOpened;
		bankOpened = client.getWidget(WidgetInfo.BANK_TITLE_BAR) != null;
		if (old != bankOpened)
		{
			bankToggled();
		}
	}

	private void bankToggled()
	{
		if (bankOpened)
		{
			if (rng(EMPTY_BANK_CHANCE))
			{
				emptyBank();
			}
		}
		else
		{
			widgets = null;
		}
	}

	private void emptyBank()
	{
		log.debug("Emptying bank contents");
		Widget bankWidget = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
		bankWidget.deleteAllChildren();
		log.debug("Removed all items in bank");
		Widget w2 = client.getWidget(WidgetInfo.BANK_SPACE_TITLE);
		w2.setText("0");
		log.debug("Set current bank item count to 0");
		Widget w3 = client.getWidget(WidgetInfo.BANK_TABS_BAR);
		if (widgets == null)
		{
			widgets = w3.getChildren();
			int i = 0;
			for (Widget w : widgets)
			{
				if (i != 0 && i != widgets.length / 2)
				{
					// Hide all but main tab and its icon
					w.setHidden(true);
				}
				else
				{
					// Prevent click action on main tab
					w.setAction(0, null);
					w.setAction(w.getActions().length - 1, null);
				}
				i++;
			}
		}
		w3.setChildren(widgets);
		log.debug("Removed all bank tabs");

		Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
		widgetBankTitleBar.setText("The Bank of Gielinor");
		log.debug("Reset bank title");
	}

	private boolean rng(int percent)
	{
		Random r = new Random();
		int v = r.nextInt(100);
		return v < percent;
	}
}
