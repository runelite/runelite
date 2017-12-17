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
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.TooltipComponent;

public class TooltipOverlay extends Overlay
{
	private final TooltipManager tooltipManager;
	private final Provider<Client> clientProvider;

	@Inject
	public TooltipOverlay(TooltipManager tooltipManager, Provider<Client> clientProvider)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		this.tooltipManager = tooltipManager;
		this.clientProvider = clientProvider;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		List<Tooltip> tooltips = tooltipManager.getTooltips();

		if (tooltips.isEmpty())
		{
			return null;
		}

		for (Tooltip tooltip : tooltips)
		{
			final TooltipComponent tooltipComponent = new TooltipComponent();
			tooltipComponent.setText(tooltip.getText());

			if (tooltip.isFollowMouse())
			{
				final Client client = clientProvider.get();
				final net.runelite.api.Point mouseCanvasPosition = client != null
					? client.getMouseCanvasPosition()
					: new net.runelite.api.Point(0, 0);
				tooltipComponent.setPosition(new Point(mouseCanvasPosition.getX(), mouseCanvasPosition.getY()));
			}
			else
			{
				tooltipComponent.setPosition(tooltip.getPosition());
			}

			tooltipComponent.render(graphics, parent);
		}

		tooltipManager.clear();
		return null;
	}
}
