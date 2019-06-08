/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.ui.overlay.tooltip;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.TooltipComponent;

@Singleton
public class TooltipOverlay extends Overlay
{
	private static final int OFFSET = 24;
	private static final int PADDING = 2;
	private final TooltipManager tooltipManager;
	private final Client client;

	@Inject
	private TooltipOverlay(Client client, TooltipManager tooltipManager)
	{
		this.client = client;
		this.tooltipManager = tooltipManager;
		setPosition(OverlayPosition.TOOLTIP);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final List<Tooltip> tooltips = tooltipManager.getTooltips();

		if (tooltips.isEmpty())
		{
			return null;
		}

		final Rectangle clientCanvasBounds = new Rectangle(client.getRealDimensions());
		final net.runelite.api.Point mouseCanvasPosition = client.getMouseCanvasPosition();
		final Point mousePosition = new Point(mouseCanvasPosition.getX(), mouseCanvasPosition.getY() + OFFSET);
		final Rectangle bounds = new Rectangle(getBounds());
		bounds.setLocation(mousePosition);

		if (!clientCanvasBounds.contains(bounds))
		{
			final int clientX = (int) clientCanvasBounds.getMaxX();
			final int clientY = (int) clientCanvasBounds.getMaxY();
			final int boundsX = (int) bounds.getMaxX();
			final int boundsY = (int) bounds.getMaxY();

			if (boundsY > clientY)
			{
				graphics.translate(0, -bounds.height - OFFSET);
			}

			if (boundsX > clientX)
			{
				graphics.translate(-bounds.width + clientCanvasBounds.width - bounds.x, 0);
			}
		}

		final Rectangle newBounds = new Rectangle(-1, -1, 0, 0);

		for (Tooltip tooltip : tooltips)
		{
			final TooltipComponent tooltipComponent = new TooltipComponent();
			tooltipComponent.setModIcons(client.getModIcons());
			tooltipComponent.setText(tooltip.getText());

			if (newBounds.contains(mousePosition))
			{
				mousePosition.move(mouseCanvasPosition.getX(), mouseCanvasPosition.getY() + OFFSET + newBounds.height);
			}

			tooltipComponent.setPosition(mousePosition);
			final Dimension dimension = tooltipComponent.render(graphics);

			// Create incremental tooltip newBounds
			newBounds.x = newBounds.x != -1 ? Math.min(newBounds.x, mousePosition.x) : mousePosition.x;
			newBounds.y = newBounds.y != -1 ? Math.min(newBounds.y, mousePosition.y) : mousePosition.y;
			newBounds.height += dimension.height + PADDING;
			newBounds.width = Math.max(newBounds.width, dimension.width);
		}

		tooltipManager.clear();
		return newBounds.getSize();
	}
}
