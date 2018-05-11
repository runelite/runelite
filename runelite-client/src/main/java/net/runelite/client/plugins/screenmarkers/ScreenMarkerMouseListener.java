/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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

import com.google.inject.Inject;
import net.runelite.client.input.MouseListener;

import java.awt.event.MouseEvent;

public class ScreenMarkerMouseListener extends MouseListener
{
	private final ScreenMarkerPlugin plugin;
	private final ScreenMarker drawingMarker;

	private int anchorX;
	private int anchorY;

	@Inject
	public ScreenMarkerMouseListener(ScreenMarkerPlugin plugin)
	{
		this.plugin = plugin;
		this.drawingMarker = this.plugin.getDrawingMarker();
	}

	@Override
	public MouseEvent mousePressed(MouseEvent e)
	{
		if (this.plugin.isPlacingMarker())
		{
			this.anchorX = e.getX();
			this.anchorY = e.getY();

			this.drawingMarker.setPosition(this.anchorX, this.anchorY);
			this.drawingMarker.setSize(0, 0);
			this.drawingMarker.setVisible(true);

			e.consume();
		}

		return e;
	}

	@Override
	public MouseEvent mouseDragged(MouseEvent e)
	{
		if (this.plugin.isPlacingMarker() && this.drawingMarker.isVisible())
		{
			int posX = this.anchorX;
			int posY = this.anchorY;

			int diffX = e.getX() - this.anchorX;
			int diffY = e.getY() - this.anchorY;

			int width = diffX;
			int height = diffY;

			if (diffX < 0) {
				width = Math.abs(diffX);
				posX -= width;
			}

			if (diffY < 0) {
				height = Math.abs(diffY);
				posY -= height;
			}

			this.drawingMarker.setSize(width, height);
			this.drawingMarker.setPosition(posX, posY);
		}

		return e;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent e)
	{
		if (this.plugin.isPlacingMarker() && this.drawingMarker.isVisible())
		{
			ScreenMarker clone = this.drawingMarker.duplicateMarker();
			this.plugin.addMarker(clone);

			clone.setVisible(this.plugin.getConfig().displayMarkers());
			this.drawingMarker.setVisible(false);
			this.plugin.updateMarkerConfig();

			e.consume();
		}

		return e;
	}
}
