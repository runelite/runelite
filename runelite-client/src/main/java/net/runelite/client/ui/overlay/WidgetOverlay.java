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
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

public class WidgetOverlay extends Overlay
{
	public static Collection<WidgetOverlay> createOverlays(final Client client)
	{
		return Arrays.asList(
			new WidgetOverlay(client, WidgetInfo.RESIZABLE_MINIMAP_WIDGET, OverlayPosition.CANVAS_TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.RESIZABLE_MINIMAP_STONES_WIDGET, OverlayPosition.CANVAS_TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.FOSSIL_ISLAND_OXYGENBAR, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.EXPERIENCE_TRACKER_WIDGET, OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.RAIDS_POINTS_INFOBOX, OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.TITHE_FARM, OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.PEST_CONTROL_BOAT_INFO, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.PEST_CONTROL_INFO, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.ZEAH_MESS_HALL_COOKING_DISPLAY, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.PVP_BOUNTY_HUNTER_INFO, OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.PVP_KILLDEATH_CONTAINER, OverlayPosition.TOP_LEFT, WidgetInfo.PVP_KILLDEATH_COUNTER),
			new WidgetOverlay(client, WidgetInfo.SKOTIZO_CONTAINER, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.KOUREND_FAVOUR_OVERLAY, OverlayPosition.TOP_CENTER),
			new WidgetOverlay(client, WidgetInfo.PYRAMID_PLUNDER_DATA, OverlayPosition.TOP_CENTER));
	}

	private final Client client;
	private final WidgetInfo widgetInfo;
	private final WidgetInfo[] dependentWidgets;
	private final Rectangle parentBounds = new Rectangle();

	private WidgetOverlay(final Client client, final WidgetInfo widgetInfo, final OverlayPosition overlayPosition)
	{
		this(client, widgetInfo, overlayPosition, new WidgetInfo[0]);
	}

	private WidgetOverlay(final Client client, final WidgetInfo widgetInfo, final OverlayPosition overlayPosition, final WidgetInfo... dependentWidgets)
	{
		this.client = client;
		this.widgetInfo = widgetInfo;
		this.dependentWidgets = dependentWidgets;
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
		final Rectangle parent = getParentBounds();

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
		final Rectangle parent = getParentBounds();

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

	private Rectangle getParentBounds()
	{
		final Widget widget = client.getWidget(widgetInfo);

		if (!client.isClientThread())
		{
			return parentBounds;
		}

		if (widget == null || widget.isHidden() || !anyDependentWidgetsVisible())
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

	private boolean anyDependentWidgetsVisible()
	{
		// Widgets which do not depend on any other widgets should not be gated by this check
		if (dependentWidgets.length == 0)
		{
			return true;
		}

		for (final WidgetInfo dependentWidget : dependentWidgets)
		{
			final Widget widget = client.getWidget(dependentWidget);

			if (widget != null && !widget.isHidden())
			{
				return true;
			}
		}

		return false;
	}
}
