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

		if (client.isMenuOpen())
		{
			plugin.setSelectedWidgetBounds(null);
			return null;
		}

		final MenuEntry[] menuEntries = client.getMenuEntries();

		final int last = menuEntries.length - 1;
		if (last < 0)
		{
			plugin.setSelectedWidgetBounds(null);
			return null;
		}

		final MenuEntry menuEntry = menuEntries[last];
		final int widgetId = menuEntry.getParam1();
		final int groupId = WidgetInfo.TO_GROUP(widgetId);
		final int childId = WidgetInfo.TO_CHILD(widgetId);

		final Widget widget = client.getWidget(groupId, childId);
		if (widget == null)
		{
			plugin.setSelectedWidgetBounds(null);
			return null;
		}

		final int param0 = menuEntry.getParam0();
		if (param0 > -1)
		{
			final WidgetItem widgetItem = widget.getWidgetItem(param0);
			if (widgetItem != null)
			{
				drawHighlight(widgetItem.getCanvasBounds(), graphics);
			}
			else
			{
				drawHighlight(widget.getChild(param0).getBounds(), graphics);
			}
		}
		else
		{
			drawHighlight(widget.getBounds(), graphics);
		}

		return null;
	}

	private void drawHighlight(Rectangle bounds, Graphics2D graphics)
	{
		graphics.setColor(Color.GREEN);
		graphics.draw(bounds);
		plugin.setSelectedWidgetBounds(bounds);
	}
}
