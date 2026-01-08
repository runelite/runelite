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

import com.formdev.flatlaf.ui.FlatNativeWindowsLibrary;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.IllegalComponentStateException;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.OSType;
import net.runelite.client.util.WinUtil;

@Slf4j
public class ContainableFrame extends JFrame
{
	public enum Mode
	{
		ALWAYS,
		RESIZING,
		NEVER;
	}

	private static final int SCREEN_EDGE_CLOSE_DISTANCE = 40;

	@Setter
	private Mode containedInScreen;
	private boolean rightSideSuction;
	private boolean scaleMinSize = false;
	private boolean overrideUndecorated;

	// we must use the deprecated variants since that it what Component ultimately delegates to
	@SuppressWarnings("deprecation")
	private void applyChange(int wX, int wY, int wWidth, int wHeight, int wOldx, int wOldY, int wOldWidth, boolean contain)
	{
		boolean isSnapped = WinUtil.isWindowArranged(this);

		if ((contain || isSnapped) && !isFullScreen())
		{
			Rectangle cDpyBounds = this.getGraphicsConfiguration().getBounds();
			Insets insets = this.getInsets();
			Rectangle cRect = new Rectangle(wX + insets.left, wY + insets.top, wWidth - (insets.left + insets.right), wHeight - (insets.top + insets.bottom));

			if (rightSideSuction || isSnapped)
			{
				// only keep suction while where are near the screen edge
				rightSideSuction = wOldx + wOldWidth - insets.right + SCREEN_EDGE_CLOSE_DISTANCE >= cDpyBounds.getMaxX();
			}

			if (rightSideSuction && wWidth < wOldWidth)
			{
				// shift the window so the right side is near the edge again
				cRect.x += wOldWidth - wWidth;
			}

			if (wWidth > wOldWidth
				&& cRect.getMaxX() > cDpyBounds.getMaxX()
				&& (wOldx + insets.left) + (wOldWidth - (insets.left + insets.right)) + SCREEN_EDGE_CLOSE_DISTANCE > cDpyBounds.getMaxX()
				&& (wOldx + insets.left) + (wOldWidth - (insets.left + insets.right)) <= cDpyBounds.getMaxX())
			{
				// attempt to retain the distance between us and the edge when shifting left
				cRect.x -= wWidth - wOldWidth;
			}

			cRect.x -= Math.max(0, cRect.getMaxX() - cDpyBounds.getMaxX());
			cRect.y -= Math.max(0, cRect.getMaxY() - cDpyBounds.getMaxY());

			// if we are just resizing don't try to move the left side out
			if (cRect.x != wOldx + insets.left)
			{
				cRect.x = Math.max(cRect.x, cDpyBounds.x);
			}

			if (cRect.y != wOldY + insets.top)
			{
				cRect.y = Math.max(cRect.y, cDpyBounds.y);
			}

			if (wWidth > wOldWidth && cRect.x < wOldx + insets.left)
			{
				// we have shifted the window left to avoid the right side going oob
				rightSideSuction = true;
			}

			wX = cRect.x - insets.left;
			wY = cRect.y - insets.top;
			wWidth = cRect.width + insets.left + insets.right;
			wHeight = cRect.height + insets.top + insets.bottom;
		}

		boolean xyDifferent = getX() != wX || getY() != wY;
		boolean whDifferent = getWidth() != wWidth || getHeight() != wHeight;

		if (xyDifferent && whDifferent)
		{
			super.reshape(wX, wY, wWidth, wHeight);
		}
		else if (xyDifferent)
		{
			super.move(wX, wY);
		}
		else if (whDifferent)
		{
			super.resize(wWidth, wHeight);
		}
	}

	/**
	 * Adjust the frame's size, containing to the screen if {@code Mode.RESIZING} is set
	 */
	public void containedSetSize(Dimension size, Rectangle oldBounds)
	{
		// accept oldSize from the outside since the min size might have been set, which forces the size to change
		applyChange(getX(), getY(), size.width, size.height, oldBounds.x, oldBounds.y, oldBounds.width, this.containedInScreen != Mode.NEVER);
	}

	/**
	 * Force minimum size of frame to be it's layout manager's minimum size
	 */
	public void revalidateMinimumSize()
	{
		Dimension minSize = getLayout().minimumLayoutSize(this);
		setMinimumSize(minSize);
	}

	@Override
	public void setMinimumSize(Dimension minSize)
	{
		if (OSType.getOSType() == OSType.Windows)
		{
			// JDK-8221452 - Window.setMinimumSize does not respect DPI scaling
			// Window::setMinimumSize will call setSize if the window is smaller
			// than the new minimum size. Because of this, and other places reading
			// minimumSize expecting scaling to be unscaled, we have to scale the size
			// only when WWindowPeer::updateMinimumSize is called. This is also called
			// during pack, but we call this afterwards so it doesn't matter much
			synchronized (getTreeLock())
			{
				try
				{
					scaleMinSize = true;
					super.setMinimumSize(minSize);
				}
				finally
				{
					scaleMinSize = false;
				}
			}
		}
		else
		{
			super.setMinimumSize(minSize);
		}
	}

	@Override
	public Dimension getMinimumSize()
	{
		Dimension minSize = super.getMinimumSize();
		if (OSType.getOSType() == OSType.Windows && minSize != null)
		{
			synchronized (getTreeLock())
			{
				if (scaleMinSize)
				{
					AffineTransform transform = getGraphicsConfiguration().getDefaultTransform();
					int scaledX = (int) Math.round(minSize.width * transform.getScaleX());
					int scaledY = (int) Math.round(minSize.height * transform.getScaleY());
					minSize = new Dimension(scaledX, scaledY);
				}
			}
		}
		return minSize;
	}

	private boolean isFullScreen()
	{
		return (getExtendedState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
	}

	void updateContainsInScreen()
	{
		if (FlatNativeWindowsLibrary.isLoaded())
		{
			FlatNativeWindowsLibrary.setContainInScreen(this, containedInScreen == Mode.ALWAYS);
		}
	}

	@Override
	public void setOpacity(float opacity)
	{
		// JDK-6993784 requires the frame to be undecorated to apply opacity, but in practice it works on Windows regardless.
		// Temporarily pretend to be an undecorated frame to satisfy Frame.setOpacity().
		overrideUndecorated = true;
		try
		{
			super.setOpacity(opacity);
		}
		catch (IllegalComponentStateException | UnsupportedOperationException | IllegalArgumentException ex)
		{
			log.warn("unable to set opacity {}", opacity, ex);
		}
		finally
		{
			overrideUndecorated = false;
		}
	}

	@Override
	public boolean isUndecorated()
	{
		return overrideUndecorated || super.isUndecorated();
	}
}
