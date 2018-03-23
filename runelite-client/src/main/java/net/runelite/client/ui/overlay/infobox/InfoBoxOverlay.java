/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay.infobox;

import com.google.common.base.Strings;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

public class InfoBoxOverlay extends Overlay
{
	private static final int BOXSIZE = 35;
	private static final int SEPARATOR = 2;

	private final InfoBoxManager infoboxManager;
	private final TooltipManager tooltipManager;
	private final Provider<Client> clientProvider;

	@Inject
	public InfoBoxOverlay(InfoBoxManager infoboxManager, TooltipManager tooltipManager, Provider<Client> clientProvider)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.tooltipManager = tooltipManager;
		this.infoboxManager = infoboxManager;
		this.clientProvider = clientProvider;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		List<InfoBox> infoBoxes = infoboxManager.getInfoBoxes();

		if (infoBoxes.isEmpty())
		{
			return null;
		}

		int width = infoBoxes.size() * (BOXSIZE + SEPARATOR);
		int x = 0;

		for (InfoBox box : infoBoxes)
		{
			if (!box.render())
			{
				continue;
			}


			final InfoBoxComponent infoBoxComponent = new InfoBoxComponent();
			infoBoxComponent.setColor(box.getTextColor());
			infoBoxComponent.setImage(box.getImage());
			infoBoxComponent.setText(box.getText());
			infoBoxComponent.setPosition(new Point(x, 0));
			final Dimension infoBoxBounds = infoBoxComponent.render(graphics);

			if (!Strings.isNullOrEmpty(box.getTooltip()))
			{
				final Rectangle intersectionRectangle = new Rectangle(infoBoxBounds);
				intersectionRectangle.setLocation(getBounds().getLocation());
				intersectionRectangle.translate(x, 0);
				final Point transformed = OverlayUtil.transformPosition(getPosition(), intersectionRectangle.getSize());
				intersectionRectangle.translate(transformed.x, transformed.y);

				final Client client = clientProvider.get();

				if (client != null && intersectionRectangle.contains(new Point(client.getMouseCanvasPosition().getX(),
					client.getMouseCanvasPosition().getY())))
				{
					tooltipManager.add(new Tooltip(box.getTooltip()));
				}
			}

			x += BOXSIZE + SEPARATOR;
		}

		return new Dimension(width, BOXSIZE);
	}
}
