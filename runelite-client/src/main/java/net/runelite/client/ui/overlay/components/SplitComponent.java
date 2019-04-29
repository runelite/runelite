/*
 * Copyright (c) 2018, Jasper Ketelaar <jasper0781@gmail.com>
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
package net.runelite.client.ui.overlay.components;

import java.awt.*;

import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class SplitComponent implements LayoutableRenderableEntity
{
	@Builder.Default
	private Point preferredLocation = new Point();
	@Builder.Default
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 0);
	@Builder.Default
	private ComponentOrientation orientation = ComponentOrientation.VERTICAL;
	@Builder.Default
	private Point gap = new Point(0, 0);

	private LayoutableRenderableEntity first;
	private LayoutableRenderableEntity second;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		graphics.translate(preferredLocation.x, preferredLocation.y);
		first.setPreferredSize(preferredSize);
		first.setPreferredLocation(new Point(0, 0));

		final Dimension firstDimenson = first.render(graphics);
		int x = 0, y = 0;

		if (orientation == ComponentOrientation.VERTICAL)
		{
			y = firstDimenson.height + gap.y;
		}
		else
		{
			x = firstDimenson.width + gap.x;
		}

		second.setPreferredLocation(new Point(x, y));
		// Make the second component fit to whatever size is left after the first component is rendered
		second.setPreferredSize(new Dimension(preferredSize.width - x, preferredSize.height - y));

		// The total width/height need to be determined as they are now always the same as the
		// individual width/height (for example image width/height will just be the height of the image
		// and not the height of the area the image is in
		final Dimension secondDimension = second.render(graphics);
		int totalWidth, totalHeight;

		if (orientation == ComponentOrientation.VERTICAL)
		{
			totalWidth = Math.max(firstDimenson.width, secondDimension.width);
			totalHeight = y + secondDimension.height;
		}
		else
		{
			totalHeight = Math.max(firstDimenson.height, secondDimension.height);
			totalWidth = x + secondDimension.width;
		}

		graphics.translate(-preferredLocation.x, -preferredLocation.y);
		return new Dimension(totalWidth, totalHeight);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}
}
