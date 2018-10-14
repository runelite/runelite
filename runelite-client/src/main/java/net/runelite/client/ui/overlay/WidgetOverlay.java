/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.ui.overlay;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

public class WidgetOverlay extends Overlay
{

	private enum RSWidgetStorage
	{
		RESIZABLE_MINIMAP_WIDGET(WidgetInfo.RESIZABLE_MINIMAP_WIDGET, OverlayPosition.CANVAS_TOP_RIGHT),
		RESIZABLE_MINIMAP_STONES_WIDGET(WidgetInfo.RESIZABLE_MINIMAP_STONES_WIDGET, OverlayPosition.CANVAS_TOP_RIGHT),
		FOSSIL_ISLAND_OXYGENBAR(WidgetInfo.FOSSIL_ISLAND_OXYGENBAR, OverlayPosition.TOP_LEFT),
		EXPERIENCE_TRACKER_WIDGET(WidgetInfo.EXPERIENCE_TRACKER_WIDGET, OverlayPosition.TOP_RIGHT),
		TITHE_FARM(WidgetInfo.TITHE_FARM, OverlayPosition.TOP_RIGHT),
		PEST_CONTROL_BOAT_INFO(WidgetInfo.PEST_CONTROL_BOAT_INFO, OverlayPosition.TOP_LEFT),
		PEST_CONTROL_INFO(WidgetInfo.PEST_CONTROL_INFO, OverlayPosition.TOP_LEFT),
		PVP_BOUNTY_HUNTER_STATS(WidgetInfo.PVP_BOUNTY_HUNTER_STATS, OverlayPosition.TOP_RIGHT),
		PVP_KILLDEATH_COUNTER(WidgetInfo.PVP_KILLDEATH_COUNTER, OverlayPosition.TOP_LEFT),
		EXPERIENCE_DROPS(WidgetInfo.EXPERIENCE_DROPS, OverlayPosition.TOP_RIGHT, new Rectangle(50, 140));

		@Getter
		private final WidgetInfo widget;
		@Getter
		private final OverlayPosition position;
		@Getter
		private final Rectangle customSize;

		RSWidgetStorage(WidgetInfo widget, OverlayPosition position)
		{
			this.widget = widget;
			this.position = position;
			this.customSize = null;
		}

		RSWidgetStorage(WidgetInfo widget, OverlayPosition position, Rectangle customSize)
		{
			this.widget = widget;
			this.position = position;
			this.customSize = customSize;
		}
	}

	public static Collection<WidgetOverlay> createOverlays(final Client client)
	{
		ArrayList<WidgetOverlay> overlays = new ArrayList<>();
		for (RSWidgetStorage widget : RSWidgetStorage.values())
		{
			overlays.add(new WidgetOverlay(client, widget.widget, widget.position, widget.customSize));
		}

		Collection<WidgetOverlay> fin = overlays;

		return fin;
	}

	private final Client client;
	private final WidgetInfo widgetInfo;
	private final Rectangle parentBounds = new Rectangle();
	private final Rectangle customSize;

	private WidgetOverlay(final Client client, final WidgetInfo widgetInfo, final OverlayPosition overlayPosition, final Rectangle customSize)
	{
		this.client = client;
		this.widgetInfo = widgetInfo;
		this.customSize = customSize;
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		setPosition(overlayPosition);
	}

	@Override
	public String getName()
	{
		return Objects.toString(widgetInfo);
	}

	@Override
	public Rectangle getBounds()
	{
		final Rectangle bounds = super.getBounds();
		if (this.customSize != null)
		{
			bounds.width = this.customSize.width;
			bounds.height = this.customSize.height;
		}
		final Rectangle parent = getParentBounds(client.getWidget(widgetInfo));

		if (parent.isEmpty())
		{
			return bounds;
		}

		int x = bounds.x;
		int y = bounds.y;
		x = Math.max(parent.x, x);
		y = Math.max(parent.y, y);
		x = Math.min((int)parent.getMaxX() - bounds.width, x);
		y = Math.min((int)parent.getMaxY() - bounds.height, y);
		bounds.setLocation(x, y);
		return bounds;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget widget = client.getWidget(widgetInfo);
		final Rectangle bounds = super.getBounds();
		final Rectangle parent = getParentBounds(widget);

		if (parent.isEmpty())
		{
			return null;
		}

		int x = bounds.x;
		int y = bounds.y;
		x = Math.max(parent.x, x);
		y = Math.max(parent.y, y);
		x = Math.min((int)parent.getMaxX() - bounds.width, x);
		y = Math.min((int)parent.getMaxY() - bounds.height, y);
		bounds.setLocation(x, y);
		widget.setOriginalX(0);
		widget.setOriginalY(0);
		widget.setRelativeX(bounds.x - parent.x);
		widget.setRelativeY(bounds.y - parent.y);
		return new Dimension(widget.getWidth(), widget.getHeight());
	}

	private Rectangle getParentBounds(final Widget widget)
	{
		if (!client.isClientThread())
		{
			return parentBounds;
		}

		if (widget == null || widget.isHidden())
		{
			parentBounds.setBounds(new Rectangle());
			return parentBounds;
		}

		final Widget parent = widget.getParent();
		final Rectangle bounds;

		if (parent == null)
		{
			bounds = new Rectangle(client.getRealDimensions());
		}
		else
		{
			bounds = new Rectangle(parent.getCanvasLocation().getX(), parent.getCanvasLocation().getY(), parent.getWidth(), parent.getHeight());
		}

		parentBounds.setBounds(bounds);
		return bounds;
	}
}
