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

import com.google.common.annotations.VisibleForTesting;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JFrame;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ExpandResizeType;
import net.runelite.client.util.OSType;

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
	private static boolean jdk8231564;

	static
	{
		try
		{
			String javaVersion = System.getProperty("java.version");
			jdk8231564 = jdk8231564(javaVersion);
		}
		catch (Exception ex)
		{
			log.error("error checking java version", ex);
		}
	}

	@VisibleForTesting
	static boolean jdk8231564(String javaVersion)
	{
		int idx = javaVersion.indexOf('_');
		if (idx != -1)
		{
			javaVersion = javaVersion.substring(0, idx);
		}
		String[] s = javaVersion.split("\\.");
		int major, minor, patch;
		if (s.length == 3)
		{
			major = Integer.parseInt(s[0]);
			minor = Integer.parseInt(s[1]);
			patch = Integer.parseInt(s[2]);
		}
		else
		{
			major = Integer.parseInt(s[0]);
			minor = -1;
			patch = -1;
		}
		if (major == 12 || major == 13 || major == 14)
		{
			// These versions are since EOL & do not include JDK-8231564, except for 13.0.4+
			return false;
		}
		return major > 11 || (major == 11 && minor > 0) || (major == 11 && minor == 0 && patch >= 8);
	}

	@Setter
	private ExpandResizeType expandResizeType;
	private Mode containedInScreen;
	private boolean expandedClientOppositeDirection;

	public void setContainedInScreen(Mode value)
	{
		this.containedInScreen = value;

		if (this.containedInScreen == Mode.ALWAYS)
		{
			// Reposition the frame if it is intersecting with the bounds
			this.setLocation(this.getX(), this.getY());
			this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
	}

	@Override
	public void setLocation(int x, int y)
	{
		if (this.containedInScreen == Mode.ALWAYS)
		{
			Rectangle bounds = this.getGraphicsConfiguration().getBounds();
			x = Math.max(x, (int) bounds.getX());
			x = Math.min(x, (int) (bounds.getX() + bounds.getWidth() - this.getWidth()));
			y = Math.max(y, (int) bounds.getY());
			y = Math.min(y, (int) (bounds.getY() + bounds.getHeight() - this.getHeight()));
		}

		super.setLocation(x, y);
	}

	@Override
	public void setBounds(int x, int y, int width, int height)
	{
		if (this.containedInScreen == Mode.ALWAYS)
		{
			// XXX: this is wrong if setSize/resize is called because Component::resize sets private state that is read
			// in Window::setBounds
			Rectangle bounds = this.getGraphicsConfiguration().getBounds();
			width = Math.min(width, width - (int) bounds.getX() + x);
			x = Math.max(x, (int) bounds.getX());
			height = Math.min(height, height - (int) bounds.getY() + y);
			y = Math.max(y, (int) bounds.getY());
			width = Math.min(width, (int) (bounds.getX() + bounds.getWidth()) - x);
			height = Math.min(height, (int) (bounds.getY() + bounds.getHeight()) - y);
		}

		super.setBounds(x, y, width, height);
	}

	/**
	 * Expand frame by specified value. If the frame is going to be expanded outside of screen push the frame to
	 * the side.
	 *
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
			int newWindowX = getX();

			if (this.containedInScreen != Mode.NEVER)
			{
				final Rectangle screenBounds = getGraphicsConfiguration().getBounds();
				final boolean wouldExpandThroughEdge = getX() + newWindowWidth > screenBounds.getX() + screenBounds.getWidth();

				if (wouldExpandThroughEdge)
				{
					if (!isFrameCloseToRightEdge() || isFrameCloseToLeftEdge())
					{
						// Move the window to the edge
						newWindowX = (int) (screenBounds.getX() + screenBounds.getWidth()) - getWidth();
					}

					// Expand the window to the left as the user probably don't want the
					// window to go through the screen
					newWindowX -= increment;

					expandedClientOppositeDirection = true;
				}
			}

			setBounds(newWindowX, getY(), newWindowWidth, getHeight());
		}

		revalidateMinimumSize();
	}

	/**
	 * Contract frame by specified value. If new frame size is less than it's minimum size, force the minimum size.
	 * If the frame was pushed from side before, restore it's original position.
	 *
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
	 * Due to Java bug JDK-4737788, maximizing an undecorated frame causes it to cover the taskbar.
	 * As a workaround, Substance calls this method when the window is maximized to manually set the
	 * bounds, but its calculation ignores high-DPI scaling. We're overriding it to correctly calculate
	 * the maximized bounds.
	 */
	@Override
	public void setMaximizedBounds(Rectangle bounds)
	{
		if (OSType.getOSType() == OSType.MacOS)
		{
			// OSX seems to correctly handle DPI scaling already
			super.setMaximizedBounds(bounds);
		}
		else
		{
			super.setMaximizedBounds(getWindowAreaBounds());
		}
	}

	/**
	 * Finds the {@link GraphicsConfiguration} of the display the window is currently on. If it's on more than
	 * one screen, returns the one it's most on (largest area of intersection)
	 */
	private GraphicsConfiguration getCurrentDisplayConfiguration()
	{
		return Arrays.stream(GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices())
			.map(GraphicsDevice::getDefaultConfiguration)
			.max(Comparator.comparingInt(config ->
			{
				Rectangle intersection = config.getBounds().intersection(getBounds());
				return intersection.width * intersection.height;
			}))
			.orElseGet(this::getGraphicsConfiguration);
	}

	/**
	 * Calculates the bounds of the window area of the screen.
	 * <p>
	 * The bounds returned by {@link GraphicsEnvironment#getMaximumWindowBounds} are incorrectly calculated on
	 * high-DPI screens.
	 */
	private Rectangle getWindowAreaBounds()
	{
		log.trace("Current bounds: {}", getBounds());
		for (GraphicsDevice device : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices())
		{
			log.trace("Device: {} bounds {}", device, device.getDefaultConfiguration().getBounds());
		}

		GraphicsConfiguration config = getCurrentDisplayConfiguration();
		// get screen bounds
		Rectangle bounds = config.getBounds();
		log.trace("Chosen device: {} bounds {}", config, bounds);

		// transform bounds to dpi-independent coordinates
		if (!jdk8231564)
		{
			// JDK-8231564 fixed setMaximizedBounds to scale the bounds, so this must only be done on <11.0.8
			bounds = config.getDefaultTransform().createTransformedShape(bounds).getBounds();
			log.trace("Transformed bounds {}", bounds);
		}

		// subtract insets (taskbar, etc.)
		Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
		if (!jdk8231564)
		{
			// Prior to JDK-8231564, WFramePeer expects the bounds to be relative to the current monitor instead of the
			// primary display.
			bounds.x = bounds.y = 0;
		}
		else
		{
			// The insets from getScreenInsets are not scaled, we must convert them to DPI scaled pixels on 11.0.8 due
			// to JDK-8231564 which expects the bounds to be in DPI-aware pixels.
			double scaleX = config.getDefaultTransform().getScaleX();
			double scaleY = config.getDefaultTransform().getScaleY();
			insets.top /= scaleY;
			insets.bottom /= scaleY;
			insets.left /= scaleX;
			insets.right /= scaleX;
		}
		bounds.x += insets.left;
		bounds.y += insets.top;
		bounds.height -= (insets.bottom + insets.top);
		bounds.width -= (insets.right + insets.left);

		log.trace("Final bounds: {}", bounds);
		return bounds;
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
