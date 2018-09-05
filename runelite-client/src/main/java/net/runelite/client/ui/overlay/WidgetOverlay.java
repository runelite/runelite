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

import com.google.common.collect.ImmutableMap;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

public class WidgetOverlay extends Overlay
{
	private static final Map<WidgetInfo, OverlayPosition> WIDGETS = ImmutableMap
		.<WidgetInfo, OverlayPosition>builder()
		.put(WidgetInfo.RESIZABLE_MINIMAP_WIDGET, OverlayPosition.CANVAS_TOP_RIGHT)
		.put(WidgetInfo.RESIZABLE_MINIMAP_STONES_WIDGET, OverlayPosition.CANVAS_TOP_RIGHT)
		.put(WidgetInfo.FOSSIL_ISLAND_OXYGENBAR, OverlayPosition.TOP_LEFT)
		.put(WidgetInfo.EXPERIENCE_TRACKER_WIDGET, OverlayPosition.TOP_RIGHT)
		.put(WidgetInfo.PEST_CONTROL_BOAT_INFO, OverlayPosition.TOP_LEFT)
		.put(WidgetInfo.PEST_CONTROL_INFO, OverlayPosition.TOP_LEFT)
		.build();

	public static Collection<WidgetOverlay> createOverlays(final Client client)
	{
		return WIDGETS.entrySet().stream()
			.map(w -> new WidgetOverlay(client, w.getKey(), w.getValue()))
			.collect(Collectors.toList());
	}

	private final Client client;
	private final WidgetInfo widgetInfo;

	private WidgetOverlay(final Client client, final WidgetInfo widgetInfo, final OverlayPosition overlayPosition)
	{
		this.client = client;
		this.widgetInfo = widgetInfo;
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
	public Dimension render(Graphics2D graphics)
	{
		final Widget widget = client.getWidget(widgetInfo);
		if (widget == null || widget.isHidden())
		{
			return null;
		}

		final Rectangle bounds = getBounds();
		final Rectangle parent = getParentBounds(widget);
		int x = bounds.x;
		int y = bounds.y;
		x = Math.max(parent.x, x);
		y = Math.max(parent.y, y);
		x = Math.min((int)parent.getMaxX() - bounds.width, x);
		y = Math.min((int)parent.getMaxY() - bounds.height, y);
		bounds.setLocation(x, y);
		widget.setOriginalX(0);
		widget.setRelativeX(0);
		widget.setRelativeX(bounds.x - parent.x);
		widget.setRelativeY(bounds.y - parent.y);
		return new Dimension(widget.getWidth(), widget.getHeight());
	}

	private Rectangle getParentBounds(final Widget widget)
	{
		final Widget parent = widget.getParent();
		if (parent == null)
		{
			return new Rectangle(client.getRealDimensions());
		}

		return new Rectangle(parent.getCanvasLocation().getX(), parent.getCanvasLocation().getY(), parent.getWidth(), parent.getHeight());
	}
}
