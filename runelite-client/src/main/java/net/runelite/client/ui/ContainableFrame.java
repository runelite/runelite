/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.ui;

import java.awt.Frame;
import java.awt.Rectangle;
import javax.swing.JFrame;
import lombok.Setter;
import net.runelite.client.config.ExpandResizeType;

public class ContainableFrame extends JFrame
{
	private static final int SCREEN_EDGE_CLOSE_DISTANCE = 40;

	@Setter
	private ExpandResizeType expandResizeType;
	private boolean containedInScreen;
	private boolean expandedClientOppositeDirection;

	public void setContainedInScreen(boolean value)
	{
		this.containedInScreen = value;

		if (value)
		{
			// Reposition the frame if it is intersecting with the bounds
			this.setLocation(this.getX(), this.getY());
			this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
	}

	@Override
	public void setLocation(int x, int y)
	{
		if (containedInScreen)
		{
			Rectangle bounds = this.getGraphicsConfiguration().getBounds();
			x = Math.max(x, (int)bounds.getX());
			x = Math.min(x, (int)(bounds.getX() + bounds.getWidth() - this.getWidth()));
			y = Math.max(y, (int)bounds.getY());
			y = Math.min(y, (int)(bounds.getY() + bounds.getHeight() - this.getHeight()));
		}

		super.setLocation(x, y);
	}

	@Override
	public void setBounds(int x, int y, int width, int height)
	{
		if (containedInScreen)
		{
			Rectangle bounds = this.getGraphicsConfiguration().getBounds();
			width = Math.min(width, width - (int)bounds.getX() + x);
			x = Math.max(x, (int)bounds.getX());
			height = Math.min(height, height - (int)bounds.getY() + y);
			y = Math.max(y, (int)bounds.getY());
			width = Math.min(width, (int)(bounds.getX() + bounds.getWidth()) - x);
			height = Math.min(height, (int)(bounds.getY() + bounds.getHeight()) - y);
		}

		super.setBounds(x, y, width, height);
	}

	/**
	 * Expand frame by specified value. If the frame is going to be expanded outside of screen push the frame to
	 * the side.
	 * @param value size to expand frame by
	 */
	public void expandBy(final int value)
	{
		if (isFullScreen())
		{
			return;
		}

		int increment = value;
		boolean forcedWidthIncrease = false;

		if (expandResizeType == ExpandResizeType.KEEP_WINDOW_SIZE)
		{
			final int minimumWidth = getLayout().minimumLayoutSize(this).width;
			final int currentWidth = getWidth();

			if (minimumWidth > currentWidth)
			{
				forcedWidthIncrease = true;
				increment = minimumWidth - currentWidth;
			}
		}

		if (forcedWidthIncrease || expandResizeType == ExpandResizeType.KEEP_GAME_SIZE)
		{
			final int newWindowWidth = getWidth() + increment;
			final Rectangle screenBounds = getGraphicsConfiguration().getBounds();
			final boolean wouldExpandThroughEdge = getX() + newWindowWidth > screenBounds.getX() + screenBounds.getWidth();
			int newWindowX = getX();

			if (wouldExpandThroughEdge)
			{
				if (!isFrameCloseToRightEdge() || isFrameCloseToLeftEdge())
				{
					// Move the window to the edge
					newWindowX = (int)(screenBounds.getX() + screenBounds.getWidth()) - getWidth();
				}

				// Expand the window to the left as the user probably don't want the
				// window to go through the screen
				newWindowX -= increment;

				expandedClientOppositeDirection = true;
			}

			setBounds(newWindowX, getY(), newWindowWidth, getHeight());
		}

		revalidateMinimumSize();
	}

	/**
	 * Contract frame by specified value. If new frame size is less than it's minimum size, force the minimum size.
	 * If the frame was pushed from side before, restore it's original position.
	 * @param value value to contract frame by
	 */
	public void contractBy(final int value)
	{
		if (isFullScreen())
		{
			return;
		}

		revalidateMinimumSize();
		final Rectangle screenBounds = getGraphicsConfiguration().getBounds();
		final boolean wasCloseToLeftEdge = Math.abs(getX() - screenBounds.getX()) <= SCREEN_EDGE_CLOSE_DISTANCE;
		int newWindowX = getX();
		int newWindowWidth = getWidth() - value;

		if (isFrameCloseToRightEdge() && (expandedClientOppositeDirection || !wasCloseToLeftEdge))
		{
			// Keep the distance to the right edge
			newWindowX += value;
		}

		if (expandResizeType == ExpandResizeType.KEEP_WINDOW_SIZE && newWindowWidth > getMinimumSize().width)
		{
			// The sidebar fits inside the window, do not resize and move
			newWindowWidth = getWidth();
			newWindowX = getX();
		}

		setBounds(newWindowX, getY(), newWindowWidth, getHeight());
		expandedClientOppositeDirection = false;
	}

	/**
	 * Force minimum size of frame to be it's layout manager's minimum size
	 */
	public void revalidateMinimumSize()
	{
		setMinimumSize(getLayout().minimumLayoutSize(this));
	}

	private boolean isFullScreen()
	{
		return (getExtendedState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
	}

	private boolean isFrameCloseToLeftEdge()
	{
		Rectangle screenBounds = getGraphicsConfiguration().getBounds();
		return Math.abs(getX() - screenBounds.getX()) <= SCREEN_EDGE_CLOSE_DISTANCE;
	}

	private boolean isFrameCloseToRightEdge()
	{
		Rectangle screenBounds = getGraphicsConfiguration().getBounds();
		return Math.abs((getX() + getWidth()) - (screenBounds.getX() + screenBounds.getWidth())) <= SCREEN_EDGE_CLOSE_DISTANCE;
	}
}
