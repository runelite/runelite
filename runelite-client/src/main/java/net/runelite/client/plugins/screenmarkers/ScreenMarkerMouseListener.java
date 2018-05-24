/*
 * Copyright (c) 2018, Kamiel, <https://github.com/Kamielvf>
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
package net.runelite.client.plugins.screenmarkers;

import java.awt.Point;
import java.awt.event.MouseEvent;
import static java.lang.Math.max;
import static java.lang.Math.min;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.input.MouseListener;

@Slf4j
public class ScreenMarkerMouseListener extends MouseListener
{
	private final ScreenMarkerPlugin plugin;
	private Point lastMousePoint = null;

	ScreenMarkerMouseListener(ScreenMarkerPlugin plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent event)
	{
		if (SwingUtilities.isMiddleMouseButton(event))
		{
			return event;
		}

		event.consume();
		return event;
	}

	@Override
	public MouseEvent mousePressed(MouseEvent event)
	{
		if (SwingUtilities.isMiddleMouseButton(event))
		{
			return event;
		}

		if (SwingUtilities.isLeftMouseButton(event))
		{
			lastMousePoint = event.getPoint();
			plugin.startCreation(event.getPoint());
		}
		else if (plugin.isCreatingScreenMarker())
		{
			plugin.finishCreation(true);
			lastMousePoint = null;
		}

		event.consume();
		return event;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent event)
	{
		if (SwingUtilities.isMiddleMouseButton(event))
		{
			return event;
		}

		if (SwingUtilities.isLeftMouseButton(event) && plugin.isCreatingScreenMarker())
		{
			/* Set the creation panel as "ready" (because the marker area as been drawn) */
			plugin.completeSelection();
		}

		event.consume();
		return event;
	}

	@Override
	public MouseEvent mouseDragged(MouseEvent event)
	{
		if (!plugin.isCreatingScreenMarker())
		{
			return event;
		}

		if (SwingUtilities.isLeftMouseButton(event))
		{
			Point currentPoint = event.getPoint();
			int dx = currentPoint.x - lastMousePoint.x;
			int dy = currentPoint.y - lastMousePoint.y;

			//if shift is down, constrain proportions
			if (event.isShiftDown() && dx != dy)
			{
				int x = dx;

				if (dx > 0 || dy > 0)
				{
					dx = max(dx, dy);
					dy = max(dy, x);
				}
				else
				{
					dx = min(dx, dy);
					dy = min(dy, x);
				}
			}

			plugin.resizeMarker(dx, dy);
			lastMousePoint = currentPoint;
		}

		return event;
	}
}
