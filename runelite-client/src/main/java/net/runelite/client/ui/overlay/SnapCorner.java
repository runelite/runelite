/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import org.intellij.lang.annotations.MagicConstant;

class SnapCorner
{
	// Alignment of pos on the snapcorner, default is top left
	static final int ALIGNMENT_RIGHT = 0x1;
	static final int ALIGNMENT_BOTTOM = 0x2;
	static final int ALIGNMENT_CENTER_HORIZONTAL = 0x4;

	// Expand direction
	static final int EXPAND_LEFT = 0x10;
	static final int EXPAND_RIGHT = 0x20;
	static final int EXPAND_UP = 0x40;
	static final int EXPAND_DOWN = 0x80;

	@MagicConstant(flags = {ALIGNMENT_RIGHT, ALIGNMENT_CENTER_HORIZONTAL, EXPAND_LEFT, EXPAND_RIGHT, EXPAND_UP, EXPAND_DOWN})
	private final int mode;
	private int cx, cy; // corner point
	private int px, py; // current point
	final OverlayPosition position;

	SnapCorner(
		OverlayPosition position,
		int mode
	)
	{
		this.position = position;
		this.mode = mode;
	}

	void setPosition(int x, int y)
	{
		this.cx = x;
		this.cy = y;
	}

	int getPositionX()
	{
		return this.cx;
	}

	int getPositionY()
	{
		return this.cy;
	}

	void reset()
	{
		px = cx;
		py = cy;
	}

	// adjust snapcorner for a drawn overlay
	void shift(Rectangle overlayBounds, int padding)
	{
		int expand = mode & 0xf0;

		switch (expand)
		{
			case EXPAND_LEFT:
				px = Math.min(px, overlayBounds.x - padding);
				break;
			case EXPAND_RIGHT:
				px = Math.max(px, overlayBounds.x + overlayBounds.width + padding);
				break;
			case EXPAND_UP:
				py = Math.min(py, overlayBounds.y - padding);
				break;
			case EXPAND_DOWN:
				py = Math.max(py, overlayBounds.y + overlayBounds.height + padding);
				break;
		}
	}

	// get position to draw the next overlay
	Point getNextDrawPosition(Rectangle bounds)
	{
		Point result = new Point(px, py);

		if ((mode & ALIGNMENT_CENTER_HORIZONTAL) != 0)
		{
			result.x -= bounds.width / 2;
		}
		else if ((mode & ALIGNMENT_RIGHT) != 0)
		{
			result.x -= bounds.width;
		}

		if ((mode & ALIGNMENT_BOTTOM) != 0)
		{
			result.y -= bounds.height;
		}

		return result;
	}

	Rectangle corner(Dimension size)
	{
		int x = cx, y = cy;

		if ((mode & ALIGNMENT_CENTER_HORIZONTAL) != 0)
		{
			x -= size.width / 2;
		}
		else if ((mode & ALIGNMENT_RIGHT) != 0)
		{
			x -= size.width;
		}

		if ((mode & ALIGNMENT_BOTTOM) != 0)
		{
			y -= size.height;
		}

		return new Rectangle(x, y, size.width, size.height);
	}
}
