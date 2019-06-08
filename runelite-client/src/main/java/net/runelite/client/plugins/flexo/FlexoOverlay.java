/*
 *
 *   Copyright (c) 2019, Zeruth <TheRealNull@gmail.com>
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, this
 *      list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *   ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.runelite.client.plugins.flexo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class FlexoOverlay extends Overlay
{
	private static Rectangle clickArea;

	ArrayList<Rectangle> clickAreas = new ArrayList<>();
	ArrayList<Point> clickPoints = new ArrayList<>();

	@Inject
	private FlexoConfig config;

	@Inject
	public FlexoOverlay(FlexoConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.config = config;
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.getDebugNPCs() || config.getDebugGroundItems() || config.getDebugPlayers())
		{
			if (clickArea != null)
			{
				graphics.draw(clickArea);
			}
			if (clickAreas != null)
			{
				for (Rectangle clickArea : clickAreas)
				{
					if (clickArea != null)
					{
						graphics.draw(clickArea);
					}
				}
			}
			if (clickPoints != null)
			{
				for (Point p : clickPoints)
				{
					if (p != null)
					{
						graphics.setColor(Color.MAGENTA);
						graphics.draw(new Line2D.Double(p.x, p.y, p.x, p.y));
						graphics.draw(new Line2D.Double(p.x - 1, p.y - 1, p.x - 1, p.y - 1));
						graphics.draw(new Line2D.Double(p.x + 1, p.y + 1, p.x + 1, p.y + 1));
						graphics.draw(new Line2D.Double(p.x - 1, p.y + 1, p.x - 1, p.y + 1));
						graphics.draw(new Line2D.Double(p.x + 1, p.y - 1, p.x + 1, p.y - 1));
					}
				}
			}
		}
		return null;
	}
}
