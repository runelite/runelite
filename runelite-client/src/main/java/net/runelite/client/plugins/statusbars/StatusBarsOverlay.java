/*
 * Copyright (c) 2018, Jos <Malevolentdev@gmail.com>
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
package net.runelite.client.plugins.statusbars;

import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.itemstats.Effect;
import net.runelite.client.plugins.itemstats.ItemStatChangesService;
import net.runelite.client.plugins.itemstats.StatChange;
import net.runelite.client.plugins.itemstats.StatsChanges;
import net.runelite.client.plugins.statusbars.renderer.BarRenderer;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;

@Singleton
public class StatusBarsOverlay extends Overlay
{
	private static final int HEIGHT = 252;
	private static final int RESIZED_BOTTOM_HEIGHT = 272;
	private static final int RESIZED_BOTTOM_OFFSET_Y = 12;
	private static final int RESIZED_BOTTOM_OFFSET_X = 10;

	private final Client client;
	private final StatusBarsPlugin plugin;
	private final ItemStatChangesService itemStatService;

	@Inject
	private StatusBarsOverlay(final Client client, final StatusBarsPlugin plugin, final ItemStatChangesService itemstatservice)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.plugin = plugin;
		this.itemStatService = itemstatservice;
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		final Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
		if (widgetBankTitleBar != null && !widgetBankTitleBar.isHidden())
		{
			return null;
		}

		Viewport curViewport = null;
		Widget curWidget = null;

		for (Viewport viewport : Viewport.values())
		{
			final Widget viewportWidget = client.getWidget(viewport.getViewport());
			if (viewportWidget != null && !viewportWidget.isHidden())
			{
				curViewport = viewport;
				curWidget = viewportWidget;
				break;
			}
		}

		if (curViewport == null)
		{
			return null;
		}
		else
		{
			curWidget.isHidden();
		}

		final Point offsetLeft = curViewport.getOffsetLeft();
		final Point offsetRight = curViewport.getOffsetRight();
		final Point location = curWidget.getCanvasLocation();
		final int height, offsetLeftBarX, offsetLeftBarY, offsetRightBarX, offsetRightBarY;

		if (curViewport == Viewport.RESIZED_BOTTOM)
		{
			height = RESIZED_BOTTOM_HEIGHT;
			offsetLeftBarX = (location.getX() + RESIZED_BOTTOM_OFFSET_X - offsetLeft.getX());
			offsetLeftBarY = (location.getY() - RESIZED_BOTTOM_OFFSET_Y - offsetRight.getY());
			offsetRightBarX = (location.getX() + RESIZED_BOTTOM_OFFSET_X - offsetRight.getX());
			offsetRightBarY = (location.getY() - RESIZED_BOTTOM_OFFSET_Y - offsetRight.getY());
		}
		else
		{
			height = HEIGHT;
			offsetLeftBarX = (location.getX() - offsetLeft.getX());
			offsetLeftBarY = (location.getY() - offsetLeft.getY());
			offsetRightBarX = (location.getX() - offsetRight.getX()) + curWidget.getWidth();
			offsetRightBarY = (location.getY() - offsetRight.getY());
		}

		BarRenderer left = plugin.getBarRenderers().get(plugin.getLeftBarMode());
		BarRenderer right = plugin.getBarRenderers().get(plugin.getRightBarMode());

		if (left != null)
		{
			left.draw(client, this, g, offsetLeftBarX, offsetLeftBarY, height);
		}

		if (right != null)
		{
			right.draw(client, this, g, offsetRightBarX, offsetRightBarY, height);
		}

		return null;
	}

	public int getRestoreValue(String skill)
	{
		final MenuEntry[] menu = client.getMenuEntries();
		final int menuSize = menu.length;
		final MenuEntry entry = menuSize > 0 ? menu[menuSize - 1] : null;
		int restoreValue = 0;

		if (entry != null && entry.getParam1() == WidgetInfo.INVENTORY.getId())
		{
			final Effect change = itemStatService.getItemStatChanges(entry.getIdentifier());

			if (change != null)
			{
				final StatsChanges statsChanges = change.calculate(client);

				for (final StatChange c : statsChanges.getStatChanges())
				{
					//final String strVar = c.getTheoretical(); this was erroring
					final String strVar = String.valueOf(c.getTheoretical());

					if (Strings.isNullOrEmpty(strVar))
					{
						continue;
					}

					final Integer value = Ints.tryParse(strVar.startsWith("+") ? strVar.substring(1) : strVar);

					if (value == null)
					{
						continue;
					}

					if (c.getStat().getName().equals(skill))
					{
						restoreValue = value;
					}

					if (restoreValue != 0)
					{
						break;
					}
				}
			}
		}

		return restoreValue;
	}
}