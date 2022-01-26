/*
 * Copyright (c) 2018, Jasper <Jasper0781@gmail.com>
 * Copyright (c) 2020, melky <https://github.com/melkypie>
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
package net.runelite.client.plugins.screenmarkers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

class ScreenMarkerWidgetHighlightOverlay extends Overlay
{
	private final ScreenMarkerPlugin plugin;
	private final Client client;

	@Inject
	private ScreenMarkerWidgetHighlightOverlay(final ScreenMarkerPlugin plugin, final Client client)
	{
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.DETACHED);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isCreatingScreenMarker() || plugin.isDrawingScreenMarker())
		{
			return null;
		}

		final MenuEntry[] menuEntries = client.getMenuEntries();
		if (client.isMenuOpen() || menuEntries.length == 0)
		{
			plugin.setSelectedWidgetBounds(null);
			return null;
		}

		final MenuEntry menuEntry = menuEntries[menuEntries.length - 1];
		final int childIdx = menuEntry.getParam0();
		final int widgetId = menuEntry.getParam1();
		final int groupId = WidgetInfo.TO_GROUP(widgetId);
		final int componentId = WidgetInfo.TO_CHILD(widgetId);

		final Widget widget = client.getWidget(groupId, componentId);
		if (widget == null)
		{
			plugin.setSelectedWidgetBounds(null);
			return null;
		}

		Rectangle bounds = null;
		if (childIdx > -1)
		{
			if (widget.getType() == WidgetType.INVENTORY)
			{
				final WidgetItem widgetItem = widget.getWidgetItem(childIdx);
				if (widgetItem != null)
				{
					bounds = widgetItem.getCanvasBounds();
				}
			}
			else
			{
				final Widget child = widget.getChild(childIdx);
				if (child != null)
				{
					bounds = child.getBounds();
				}
			}
		}
		else
		{
			bounds = widget.getBounds();
		}

		if (bounds == null)
		{
			plugin.setSelectedWidgetBounds(null);
			return null;
		}

		drawHighlight(graphics, bounds);
		plugin.setSelectedWidgetBounds(bounds);

		return null;
	}

	private static void drawHighlight(Graphics2D graphics, Rectangle bounds)
	{
		graphics.setColor(Color.GREEN);
		graphics.draw(bounds);
	}
}
