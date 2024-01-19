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

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.OSType;

@Slf4j
public class ContainableFrame extends JFrame
{
	public enum Mode
	{
		RESIZING,
		NEVER;
	}

	private static final int SCREEN_EDGE_CLOSE_DISTANCE = 40;

	@Setter
	private Mode containedInScreen;
	private boolean rightSideSuction;
	private boolean boundsOpSet;

	@Override
	@SuppressWarnings("deprecation")
	public void resize(int width, int height)
	{
		reshape(getX(), getY(), width, height);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void move(int x, int y)
	{
		reshape(x, y, getWidth(), getHeight());
	}

	@Override
	@SuppressWarnings("deprecation")
	public void reshape(int x, int y, int width, int height)
	{
		// Component has stateful behavior so that setLocation can call reshape without
		// reshape attempting to update it's x/y components.
		if (boundsOpSet)
		{
			super.reshape(x, y, width, height);
			return;
		}

		applyChange(x, y, width, height, getX(), getY(), false);
	}

	@Override
	public void pack()
	{
		try
		{
			boundsOpSet = true;
			super.pack();
		}
		finally
		{
			boundsOpSet = false;
		}
	}

	// we must use the deprecated variants since that it what Component ultimately delegates to
	@SuppressWarnings("deprecation")
	private void applyChange(int x, int y, int width, int height, int oldX, int oldY, boolean contain)
	{
		try
		{
			boundsOpSet = true;

			if (contain && !isFullScreen())
			{
				Rectangle dpyBounds = this.getGraphicsConfiguration().getBounds();
				Insets insets = this.getInsets();
				Rectangle rect = new Rectangle(x + insets.left, y + insets.top, width - (insets.left + insets.right), height - (insets.top + insets.bottom));

				if (rightSideSuction)
				{
					// only keep suction while where are near the screen edge
					rightSideSuction = getBounds().getMaxX() + SCREEN_EDGE_CLOSE_DISTANCE >= dpyBounds.getMaxX();
				}

				if (rightSideSuction && width < this.getWidth())
				{
					// shift the window so the right side is near the edge again
					rect.x += this.getWidth() - width;
				}

				rect.x -= Math.max(0, rect.getMaxX() - dpyBounds.getMaxX());
				rect.y -= Math.max(0, rect.getMaxY() - dpyBounds.getMaxY());

				// if we are just resizing don't try to move the left side out
				if (rect.x != oldX + insets.left)
				{
					rect.x = Math.max(rect.x, dpyBounds.x);
				}

				if (rect.y != oldY + insets.top)
				{
					rect.y = Math.max(rect.y, dpyBounds.y);
				}

				if (width > this.getWidth() && rect.x < x)
				{
					// we have shifted the window left to avoid the right side going oob
					rightSideSuction = true;
				}

				x = rect.x - insets.left;
				y = rect.y - insets.top;
				width = rect.width + insets.left + insets.right;
				height = rect.height + insets.top + insets.bottom;
			}

			boolean xyDifferent = getX() != x || getY() != y;
			boolean whDifferent = getWidth() != width || getHeight() != height;

			if (xyDifferent && whDifferent)
			{
				super.reshape(x, y, width, height);
			}
			else if (xyDifferent)
			{
				super.move(x, y);
			}
			else if (whDifferent)
			{
				super.resize(width, height);
			}
		}
		finally
		{
			boundsOpSet = false;
		}
	}

	/**
	 * Adjust the frame's size, containing to the screen if {@code Mode.RESIZING} is set
	 */
	public void containedSetSize(Dimension size)
	{
		applyChange(getX(), getY(), size.width, size.height, getX(), getY(), this.containedInScreen != Mode.NEVER);
	}

	/**
	 * Force minimum size of frame to be it's layout manager's minimum size
	 */
	public void revalidateMinimumSize()
	{
		Dimension minSize = getLayout().minimumLayoutSize(this);
		if (OSType.getOSType() == OSType.Windows)
		{
			// JDK-8221452 - Window.setMinimumSize does not respect DPI scaling
			AffineTransform transform = getGraphicsConfiguration().getDefaultTransform();
			int scaledX = (int) Math.round(minSize.width * transform.getScaleX());
			int scaledY = (int) Math.round(minSize.height * transform.getScaleY());
			minSize = new Dimension(scaledX, scaledY);
		}

		setMinimumSize(minSize);
	}

	private boolean isFullScreen()
	{
		return (getExtendedState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
	}
}
