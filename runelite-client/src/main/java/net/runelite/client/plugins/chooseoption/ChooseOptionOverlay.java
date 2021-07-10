/*
 * Copyright (c) 2019, Justin <https://github.com/Jbleezy>
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
package net.runelite.client.plugins.chooseoption;

import com.google.common.base.Strings;
import net.runelite.api.*;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.ColorUtil;
import javax.inject.Inject;
import java.awt.*;

class ChooseOptionOverlay extends Overlay
{
	private final Client client;
	private final ChooseOptionConfig config;
	private final int chooseOptionInitLength = 19; // length of the bar on top of the choose option menu
	private final int chooseOptionLength = 15; // length of each choose option
	private final int chooseOptionBottomBorderLength = 3; // choose option menu won't go past the bottom 3 pixels of the client unless the menu reaches the top of the client
	private static int highlightMenuPosStart;
	private static boolean init = true;
	private static String[] menuEntryOptions = new String[100];

	@Inject
	ChooseOptionOverlay(Client client, ChooseOptionConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!client.isMenuOpen())
		{
			if (!init)
			{
				init = true;
			}

			return null;
		}

		MenuEntry[] menuEntries = client.getMenuEntries();
		int last = menuEntries.length - 1;

		if (last < 0)
		{
			return null;
		}

		MenuEntry menuEntry = menuEntries[last];
		String option = menuEntry.getOption();

		if (Strings.isNullOrEmpty(option))
		{
			return null;
		}

		if (init)
		{
			init = false;

			highlightMenuPosStart = client.getMouseCanvasPosition().getY() + chooseOptionInitLength;

			// check for choose option menu getting positioned upwards due to menu going off the bottom of the client
			int menuPosEnd = highlightMenuPosStart + (menuEntries.length * chooseOptionLength);
			if (menuPosEnd > (int) client.getRealDimensions().getHeight())
			{
				highlightMenuPosStart -= (menuPosEnd - client.getRealDimensions().getHeight()) + chooseOptionBottomBorderLength;
			}

			// check for choose option menu getting positioned downwards due to menu going off the top of the client
			if (highlightMenuPosStart < chooseOptionInitLength)
			{
				highlightMenuPosStart = chooseOptionInitLength;
			}

			// the options must be stored to be able to switch between colors
			for (int i = 0; i < menuEntries.length; i++)
			{
				menuEntryOptions[i] = menuEntries[i].getOption();
			}
		}

		int currentMenuIndex = -1;
		if (client.getMouseCanvasPosition().getY() >= highlightMenuPosStart)
		{
			for (int i = 0; i < menuEntries.length; i++)
			{
				int menuEntryPos = highlightMenuPosStart + ((last - i) * chooseOptionLength);

				if (client.getMouseCanvasPosition().getY() >= menuEntryPos)
				{
					currentMenuIndex = i;
					break;
				}
			}
		}

		for (int i = 0; i < menuEntries.length; i++)
		{
			if (i == currentMenuIndex)
			{
				menuEntries[i].setOption(ColorUtil.prependColorTag(menuEntryOptions[i], config.getChooseOptionColor()));
			}
			else
			{
				menuEntries[i].setOption(menuEntryOptions[i]);
			}
		}

		client.setMenuEntries(menuEntries);

		return null;
	}
}
