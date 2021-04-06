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
import net.runelite.api.Varbits;
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
			new XpTrackerWidgetOverlay(client, WidgetInfo.EXPERIENCE_TRACKER_WIDGET, OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.RAIDS_POINTS_INFOBOX, OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.TOB_PARTY_INTERFACE, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.TOB_PARTY_STATS, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.GWD_KC, OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.TITHE_FARM, OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.PEST_CONTROL_BOAT_INFO, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.PEST_CONTROL_INFO, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.ZEAH_MESS_HALL_COOKING_DISPLAY, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.PVP_KILLDEATH_COUNTER, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.SKOTIZO_CONTAINER, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.KOUREND_FAVOUR_OVERLAY, OverlayPosition.TOP_CENTER),
			new WidgetOverlay(client, WidgetInfo.PYRAMID_PLUNDER_DATA, OverlayPosition.TOP_CENTER),
			new WidgetOverlay(client, WidgetInfo.LMS_INFO, OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.LMS_KDA, OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.GAUNTLET_TIMER_CONTAINER, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.HALLOWED_SEPULCHRE_TIMER_CONTAINER, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.HEALTH_OVERLAY_BAR, OverlayPosition.TOP_CENTER),
			new WidgetOverlay(client, WidgetInfo.NIGHTMARE_PILLAR_HEALTH, OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, WidgetInfo.VOLCANIC_MINE_VENTS_INFOBOX_GROUP, OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, WidgetInfo.VOLCANIC_MINE_STABILITY_INFOBOX_GROUP, OverlayPosition.BOTTOM_LEFT),
			new WidgetOverlay(client, WidgetInfo.MULTICOMBAT_FIXED, OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, WidgetInfo.MULTICOMBAT_RESIZEABLE_MODERN, OverlayPosition.CANVAS_TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.MULTICOMBAT_RESIZEABLE_CLASSIC, OverlayPosition.CANVAS_TOP_RIGHT),
			new WidgetOverlay(client, WidgetInfo.TEMPOROSS_STATUS_INDICATOR, OverlayPosition.TOP_LEFT)
		);
	}

	protected final Client client;
	private final WidgetInfo widgetInfo;
	private final Rectangle parentBounds = new Rectangle();

	private WidgetOverlay(final Client client, final WidgetInfo widgetInfo, final OverlayPosition overlayPosition)
	{
		this.client = client;
		this.widgetInfo = widgetInfo;
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		setPosition(overlayPosition);
		// It's almost possible to drawAfterInterface(widgetInfo.getGroupId()) here, but that fires
		// *after* the native components are drawn, which is too late.
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
		final Rectangle parent = getParentBounds(widget);

		if (parent.isEmpty())
		{
			return null;
		}

		final Rectangle bounds = getBounds();
		// The widget relative pos is relative to the parent
		widget.setRelativeX(bounds.x - parent.x);
		widget.setRelativeY(bounds.y - parent.y);
		return new Dimension(widget.getWidth(), widget.getHeight());
	}

	private Rectangle getParentBounds(final Widget widget)
	{
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
			bounds = parent.getBounds();
		}

		parentBounds.setBounds(bounds);
		return bounds;
	}

	@Override
	public Rectangle getParentBounds()
	{
		if (!client.isClientThread())
		{
			// During overlay drag this is called on the EDT, so we just
			// cache and reuse the last known parent bounds.
			return parentBounds;
		}

		final Widget widget = client.getWidget(widgetInfo);
		return getParentBounds(widget);
	}

	private static class XpTrackerWidgetOverlay extends WidgetOverlay
	{
		private XpTrackerWidgetOverlay(Client client, WidgetInfo widgetInfo, OverlayPosition overlayPosition)
		{
			super(client, widgetInfo, overlayPosition);
		}

		/**
		 * Get the overlay position of the xptracker based on the configured location in-game.
		 *
		 * @return
		 */
		@Override
		public OverlayPosition getPosition()
		{
			if (!client.isClientThread())
			{
				// During overlay drag, getPosition() is called on the EDT, so we just
				// cache and reuse the last known configured position.
				return super.getPosition();
			}

			OverlayPosition position;
			switch (client.getVar(Varbits.EXPERIENCE_TRACKER_POSITION))
			{
				case 0:
				default:
					position = OverlayPosition.TOP_RIGHT;
					break;
				case 1:
					position = OverlayPosition.TOP_CENTER;
					break;
				case 2:
					position = OverlayPosition.TOP_LEFT;
					break;
			}
			setPosition(position);
			return position;
		}
	}
}
