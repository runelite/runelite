/*
 * Copyright (c) 2020, Sean Dewar <https://github.com/seandewar>
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
package net.runelite.client.plugins.camera;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.VarClientInt;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

class CameraOverlay extends Overlay
{
	private final CameraConfig config;
	private final Client client;
	private final TooltipManager tooltipManager;

	@Inject
	private CameraOverlay(final CameraConfig config, final Client client, final TooltipManager tooltipManager)
	{
		this.config = config;
		this.client = client;
		this.tooltipManager = tooltipManager;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(final Graphics2D graphics)
	{
		final Widget slider = client.getWidget(WidgetInfo.OPTIONS_CAMERA_ZOOM_SLIDER_HANDLE);
		final Point mousePos = client.getMouseCanvasPosition();

		if (slider == null || slider.isHidden() || !slider.getBounds().contains(mousePos.getX(), mousePos.getY()))
		{
			return null;
		}

		final int value = client.getVar(VarClientInt.CAMERA_ZOOM_RESIZABLE_VIEWPORT);
		final int max = config.innerLimit() ? config.INNER_ZOOM_LIMIT : CameraPlugin.DEFAULT_INNER_ZOOM_LIMIT;

		tooltipManager.add(new Tooltip("Camera Zoom: " + value + " / " + max));
		return null;
	}
}
