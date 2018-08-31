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

import com.google.common.collect.ImmutableSet;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

public class WidgetOverlay extends Overlay
{
	private static final Set<WidgetInfo> WIDGETS = ImmutableSet.of(
		WidgetInfo.RESIZABLE_MINIMAP_WIDGET,
		WidgetInfo.RESIZABLE_MINIMAP_STONES_WIDGET,
		WidgetInfo.EXPERIENCE_TRACKER_WIDGET,
		WidgetInfo.FOSSIL_ISLAND_OXYGENBAR
	);

	public static Set<WidgetOverlay> createOverlays(final Client client)
	{
		return WIDGETS.stream().map(w -> new WidgetOverlay(client, w)).collect(Collectors.toSet());
	}

	private final Client client;
	private final WidgetInfo widgetInfo;
	private Integer toRestoreX;
	private Integer toRestoreY;

	private WidgetOverlay(final Client client, final WidgetInfo widgetInfo)
	{
		this.client = client;
		this.widgetInfo = widgetInfo;
		setLayer(OverlayLayer.UNDER_WIDGETS);
		setPosition(OverlayPosition.DETACHED);
	}

	@Override
	public String getName()
	{
		return Objects.toString(widgetInfo);
	}

	@Override
	public Rectangle getBounds()
	{
		final Widget widget = client.getWidget(widgetInfo);

		if (widget != null && !widget.isHidden())
		{
			return new Rectangle(
				widget.getOriginalX() + widget.getRelativeX(),
				widget.getOriginalY() + widget.getRelativeY(),
				widget.getWidth(), widget.getHeight());
		}

		return new Rectangle();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget widget = client.getWidget(widgetInfo);

		if (widget == null || widget.isHidden())
		{
			return null;
		}

		if (getPreferredLocation() == null)
		{
			if (toRestoreX != null)
			{
				widget.setRelativeX(toRestoreX);
				toRestoreX = null;
			}

			if (toRestoreY != null)
			{
				widget.setRelativeY(toRestoreY);
				toRestoreY = null;
			}

			return null;
		}

		final Rectangle bounds = getBounds();
		int x = getPreferredLocation().x - widget.getOriginalX();
		int y = getPreferredLocation().y - widget.getOriginalY();
		x = Math.max(0, x);
		y = Math.max(0, y);

		final Widget parent = widget.getParent();
		final Dimension dimensions = parent == null ? client.getRealDimensions() : new Dimension(parent.getWidth(), parent.getHeight());
		x = Math.min(dimensions.width - bounds.width, x);
		y = Math.min(dimensions.height - bounds.height, y);

		if (toRestoreX == null)
		{
			toRestoreX = widget.getRelativeX();
		}

		if (toRestoreY == null)
		{
			toRestoreY = widget.getRelativeY();
		}

		widget.setRelativeX(x);
		widget.setRelativeY(y);

		return null;
	}
}
