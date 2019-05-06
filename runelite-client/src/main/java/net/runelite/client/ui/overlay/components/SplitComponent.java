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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
public class SplitComponent implements LayoutableRenderableEntity
{
	private LayoutableRenderableEntity first;
	private LayoutableRenderableEntity second;

	@Builder.Default
	private Point preferredLocation = new Point();

	@Builder.Default
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 0);

	@Builder.Default
	private ComponentOrientation orientation = ComponentOrientation.VERTICAL;

	@Builder.Default
	private Point gap = new Point(0, 0);

	@Builder.Default
	@Getter
	private final Rectangle bounds = new Rectangle();

	@Override
	public Dimension render(Graphics2D graphics)
	{
		first.setPreferredLocation(preferredLocation);
		first.setPreferredSize(preferredSize);

		final Dimension firstDimension = first.render(graphics);
		int x = 0, y = 0;

		if (orientation == ComponentOrientation.VERTICAL)
		{
			y = firstDimension.height + gap.y;
		}
		else
		{
			x = firstDimension.width + gap.x;
		}

		second.setPreferredLocation(new Point(x + preferredLocation.x, y + preferredLocation.y));
		// Make the second component fit to whatever size is left after the first component is rendered
		second.setPreferredSize(new Dimension(preferredSize.width - x, preferredSize.height - y));

		// The total width/height need to be determined as they are now always the same as the
		// individual width/height (for example image width/height will just be the height of the image
		// and not the height of the area the image is in
		final Dimension secondDimension = second.render(graphics);
		int totalWidth, totalHeight;

		if (orientation == ComponentOrientation.VERTICAL)
		{
			totalWidth = Math.max(firstDimension.width, secondDimension.width);
			totalHeight = y + secondDimension.height;
		}
		else
		{
			totalHeight = Math.max(firstDimension.height, secondDimension.height);
			totalWidth = x + secondDimension.width;
		}

		final Dimension dimension = new Dimension(totalWidth, totalHeight);
		bounds.setLocation(preferredLocation);
		bounds.setSize(dimension);
		return dimension;
	}
}