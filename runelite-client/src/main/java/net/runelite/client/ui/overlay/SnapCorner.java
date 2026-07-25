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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
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

	private static final int SNAP_CORNER_SIZE = 80;
	private static final int SNAP_CORNER_PADDING = 10; // padding to ensure there is always part of the snapcorner that is clickable
	private static final Color SNAP_CORNER_COLOR = new Color(0, 255, 255, 50);
	private static final Color SNAP_CORNER_ACTIVE_COLOR = new Color(0, 255, 0, 100);

	final OverlayPosition position;
	final OverlayOriginX originX;
	final OverlayOriginY originY;
	@MagicConstant(flags = {ALIGNMENT_RIGHT, ALIGNMENT_CENTER_HORIZONTAL, EXPAND_LEFT, EXPAND_RIGHT, EXPAND_UP, EXPAND_DOWN})
	private final int mode;
	CornerOverlay overlay;
	private final int offx, offy; // default offset from origin
	int curx, cury; // current offset from origin

	private int cx, cy; // corner point
	private int px, py; // current point
	private int sx, sy; // size
	int lastsx, lastsy; // last size

	SnapCorner(
		OverlayPosition position,
		int mode,
		OverlayOriginX originX,
		OverlayOriginY originY,
		int xoff,
		int yoff
	)
	{
		this.position = position;
		this.originX = originX;
		this.originY = originY;
		this.mode = mode;
		this.offx = curx = xoff;
		this.offy = cury = yoff;
	}

	boolean isRepositioned()
	{
		return curx != offx || cury != offy;
	}

	void reset()
	{
		curx = offx;
		cury = offy;
	}

	void setPosition(int x, int y)
	{
		this.cx = x;
		this.cy = y;
		this.px = x;
		this.py = y;
		this.lastsx = sx;
		this.lastsy = sy;
		this.sx = 0;
		this.sy = 0;
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

		switch (expand)
		{
			case EXPAND_UP:
			case EXPAND_DOWN:
				sx = Math.max(sx, overlayBounds.width);
				sy += overlayBounds.height + padding;
				break;
			case EXPAND_LEFT:
			case EXPAND_RIGHT:
				sx += overlayBounds.width + padding;
				sy = Math.max(sy, overlayBounds.height);
				break;
		}
	}

	// get position to draw the next overlay
	void getNextDrawPosition(Rectangle bounds, Point out)
	{
		out.setLocation(px, py);

		if ((mode & ALIGNMENT_CENTER_HORIZONTAL) != 0)
		{
			out.x -= bounds.width / 2;
		}
		else if ((mode & ALIGNMENT_RIGHT) != 0)
		{
			out.x -= bounds.width;
		}

		if ((mode & ALIGNMENT_BOTTOM) != 0)
		{
			out.y -= bounds.height;
		}
	}

	private Dimension getSize()
	{
		return new Dimension(
			Math.max(lastsx, SNAP_CORNER_SIZE) + SNAP_CORNER_PADDING,
			Math.max(lastsy, SNAP_CORNER_SIZE) + SNAP_CORNER_PADDING
		);
	}

	void translateOffsetForAlignment(Point p)
	{
		int x = p.x, y = p.y;
		var s = getSize();

		if ((mode & ALIGNMENT_CENTER_HORIZONTAL) != 0)
		{
			x -= s.width / 2;
		}
		else if ((mode & ALIGNMENT_RIGHT) != 0)
		{
			x -= s.width;
		}

		if ((mode & ALIGNMENT_BOTTOM) != 0)
		{
			y -= s.height;
		}

		p.setLocation(x, y);
	}

	Rectangle corner()
	{
		int x = cx, y = cy;
		var s = getSize();

		if ((mode & ALIGNMENT_CENTER_HORIZONTAL) != 0)
		{
			x -= s.width / 2;
		}
		else if ((mode & ALIGNMENT_RIGHT) != 0)
		{
			x -= s.width;
		}

		if ((mode & ALIGNMENT_BOTTOM) != 0)
		{
			y -= s.height;
		}

		return new Rectangle(x, y, s.width, s.height);
	}

	class CornerOverlay extends Overlay
	{
		private boolean mouseover;

		private Point translateOffsetForAlignment()
		{
			var p = new Point(curx, cury);
			SnapCorner.this.translateOffsetForAlignment(p);
			return p;
		}

		private Point translateLocationForAlignment(Point location)
		{
			int x = location.x, y = location.y;
			var s = getSize();

			if ((mode & ALIGNMENT_CENTER_HORIZONTAL) != 0)
			{
				x += s.width / 2;
			}
			else if ((mode & ALIGNMENT_RIGHT) != 0)
			{
				x += s.width;
			}

			if ((mode & ALIGNMENT_BOTTOM) != 0)
			{
				y += s.height;
			}

			return new Point(x, y);
		}

		CornerOverlay()
		{
			setPosition(OverlayPosition.DYNAMIC);
			setMovable(true);
			setSnappable(false);
			setLayer(OverlayLayer.UNDER_WIDGETS);
			setOrigin(OverlayOrigin.MANUAL);
			setOriginX(originX);
			setOriginY(originY);
			setPreferredLocation(translateOffsetForAlignment());
		}

		@Override
		public String getName()
		{
			return super.getName() + "_" + position;
		}

		@Override
		void onDrag()
		{
			var location = getPreferredLocation();
			var l = translateLocationForAlignment(location);
			curx = l.x;
			cury = l.y;
		}

		@Override
		void reset()
		{
			curx = offx;
			cury = offy;
			setPreferredPosition(null);
			setPreferredSize(null);
			setPreferredLocation(translateOffsetForAlignment());
			setOrigin(OverlayOrigin.MANUAL);
			setOriginX(originX);
			setOriginY(originY);
		}

		@Override
		public void onMouseOver()
		{
			// this is really a frame behind since it is after render(), but it's basically fine
			mouseover = true;
		}

		@Override
		public Dimension render(Graphics2D graphics)
		{
			// overlay location depends on its size, which depends on how many things it renders
			setPreferredLocation(translateOffsetForAlignment());
			var s = getSize();
			graphics.setColor(mouseover ? SNAP_CORNER_ACTIVE_COLOR : SNAP_CORNER_COLOR);
			graphics.fill(new Rectangle(s));
			mouseover = false;
			return s;
		}
	}
}
