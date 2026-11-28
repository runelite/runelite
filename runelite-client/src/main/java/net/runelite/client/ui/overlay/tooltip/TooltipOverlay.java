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
import java.awt.geom.AffineTransform;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.config.TooltipPositionType;
import net.runelite.client.ui.overlay.NativeOverlayBuffer;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TooltipComponent;

@Singleton
public class TooltipOverlay extends Overlay
{
	private static final int UNDER_OFFSET = 24;
	private static final int PADDING = 2;
	private final TooltipManager tooltipManager;
	private final Client client;
	private final RuneLiteConfig runeLiteConfig;
	private final NativeOverlayBuffer nativeOverlayBuffer;

	private int prevWidth, prevHeight;

	@Inject
	private TooltipOverlay(Client client, TooltipManager tooltipManager, final RuneLiteConfig runeLiteConfig,
		NativeOverlayBuffer nativeOverlayBuffer)
	{
		this.client = client;
		this.tooltipManager = tooltipManager;
		this.runeLiteConfig = runeLiteConfig;
		this.nativeOverlayBuffer = nativeOverlayBuffer;
		setPosition(OverlayPosition.TOOLTIP);
		setPriority(PRIORITY_HIGHEST);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		// additionally allow tooltips above the full screen world map and welcome screen
		drawAfterInterface(InterfaceID.TOPLEVEL_DISPLAY);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final List<Tooltip> tooltips = tooltipManager.getTooltips();

		if (tooltips.isEmpty())
		{
			return null;
		}

		try
		{
			return renderTooltips(graphics, tooltips);
		}
		finally
		{
			// Tooltips must always be cleared each frame
			tooltipManager.clear();
		}
	}

	private Dimension renderTooltips(Graphics2D graphics, List<Tooltip> tooltips)
	{
		final int canvasWidth = client.getCanvasWidth();
		final int canvasHeight = client.getCanvasHeight();
		final net.runelite.api.Point mouseCanvasPosition = client.getMouseCanvasPosition();

		// UNDER_OFFSET is display-space padding; under native stretch the transform would
		// amplify it while the OS cursor stays display-sized.
		final int underOffset = nativeOverlayBuffer.isActive()
			? (int) Math.round(UNDER_OFFSET / nativeOverlayBuffer.getScaleY())
			: UNDER_OFFSET;

		final int tooltipX = Math.min(canvasWidth - prevWidth, mouseCanvasPosition.getX());
		final int tooltipY = runeLiteConfig.tooltipPosition() == TooltipPositionType.ABOVE_CURSOR
			? Math.max(0, mouseCanvasPosition.getY() - prevHeight)
			: Math.min(canvasHeight - prevHeight, mouseCanvasPosition.getY() + underOffset);

		final AffineTransform transform = graphics.getTransform();
		int width = 0, height = 0;
		for (Tooltip tooltip : tooltips)
		{
			final LayoutableRenderableEntity entity;

			if (tooltip.getComponent() != null)
			{
				entity = tooltip.getComponent();
				if (entity instanceof PanelComponent)
				{
					((PanelComponent) entity).setBackgroundColor(runeLiteConfig.overlayBackgroundColor());
				}
			}
			else
			{
				final TooltipComponent tooltipComponent = new TooltipComponent();
				tooltipComponent.setModIcons(client.getModIcons());
				tooltipComponent.setText(tooltip.getText());
				tooltipComponent.setBackgroundColor(runeLiteConfig.overlayBackgroundColor());
				entity = tooltipComponent;
			}

			final double cx;
			final double cy;
			if (nativeOverlayBuffer.isActive())
			{
				cx = nativeOverlayBuffer.getPanelContentScaleX();
				cy = nativeOverlayBuffer.getPanelContentScaleY();
			}
			else
			{
				cx = 1.0;
				cy = 1.0;
			}

			graphics.translate(tooltipX, tooltipY + height);
			if (cx != 1.0 || cy != 1.0)
			{
				graphics.scale(cx, cy);
			}

			entity.setPreferredLocation(new Point(0, 0));
			final Dimension dimension = entity.render(graphics);
			graphics.setTransform(transform);

			final int visualWidth = (int) Math.round(dimension.width * cx);
			final int visualHeight = (int) Math.round(dimension.height * cy);
			height += visualHeight + PADDING;
			width = Math.max(width, visualWidth);
		}

		prevWidth = width;
		prevHeight = height;
		return null;
	}
}
