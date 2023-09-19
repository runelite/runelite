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
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JFrame;
import lombok.extern.slf4j.Slf4j;
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
	/**
	 * JDK-8231564 changes Frame#setMaximizedBounds() to apply ui scaling
	 */
	private static boolean jdk8231564;
	/**
	 * JDK-8243925 changes Toolkit#getScreenInsets() to apply ui scaling
	 */
	private static boolean jdk8243925;

	static
	{
		try
		{
			String javaVersion = System.getProperty("java.version");
			jdk8231564 = jdk8231564(javaVersion);
			jdk8243925 = jdk8243925(javaVersion);
		}
		catch (Exception ex)
		{
			log.error("error checking java version", ex);
		}
	}

	@VisibleForTesting
	static boolean jdk8231564(String javaVersion)
	{
		if (isVersionOrGreater(javaVersion, 15, -1, -1))
		{
			return true; // JDK-8231564
		}
		if (isVersionOrGreater(javaVersion, 14, -1, -1))
		{
			return false; // unpatched
		}
		if (isVersionOrGreater(javaVersion, 13, 0, 4))
		{
			return true; // JDK-8247209
		}
		if (isVersionOrGreater(javaVersion, 12, -1, -1))
		{
			return false; // unpatched
		}
		return isVersionOrGreater(javaVersion, 11, 0, 8); // JDK-8243374
	}

	@VisibleForTesting
	static boolean jdk8243925(String javaVersion)
	{
		if (isVersionOrGreater(javaVersion, 15, -1, -1))
		{
			return true; // JDK-8243925
		}
		if (isVersionOrGreater(javaVersion, 14, -1, -1))
		{
			return false; // unpatched
		}
		if (isVersionOrGreater(javaVersion, 13, 0, 7))
		{
			return true; // JDK-8261342
		}
		if (isVersionOrGreater(javaVersion, 12, -1, -1))
		{
			return false; // unpatched
		}
		return isVersionOrGreater(javaVersion, 11, 0, 9);  // JDK-8246659
	}

	private static boolean isVersionOrGreater(String javaVersion, int versionMajor, int versionMinor, int versionPatch)
	{
		int idx = javaVersion.indexOf('_');
		if (idx != -1)
		{
			javaVersion = javaVersion.substring(0, idx);
		}
		String[] s = javaVersion.split("\\.");
		int major, minor, patch;
		if (s.length >= 3)
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

		int i = Integer.compare(major, versionMajor);
		if (i != 0)
		{
			return i > 0;
		}

		i = Integer.compare(minor, versionMinor);
		if (i != 0)
		{
			return i > 0;
		}

		i = Integer.compare(patch, versionPatch);
		if (i != 0)
		{
			return i > 0;
		}

		return true;
	}

	private Mode containedInScreen;
	private boolean rightSideSuction;
	private boolean boundsOpSet;
	private int oldX;
	private int oldY;

	public ContainableFrame()
	{
		addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentMoved(ComponentEvent e)
			{
				if (containedInScreen == Mode.ALWAYS)
				{
					applyChange(getX(), getY(), getWidth(), getHeight(), oldX, oldY, true);
				}
			}
		});
	}

	public void setContainedInScreen(Mode value)
	{
		this.containedInScreen = value;

		if (this.containedInScreen == Mode.ALWAYS)
		{
			// Reposition the frame if it is intersecting with the bounds
			reshape(getX(), getY(), getWidth(), getHeight());
		}
	}

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

		applyChange(x, y, width, height, getX(), getY(), this.containedInScreen == Mode.ALWAYS);
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
			this.oldX = getX();
			this.oldY = getY();
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
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		log.trace("Current bounds: {}", getBounds());
		for (GraphicsDevice device : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices())
		{
			GraphicsConfiguration graphicsConfiguration = device.getDefaultConfiguration();
			log.trace("Device: {} bounds {} insets {}", device, graphicsConfiguration.getBounds(),
				toolkit.getScreenInsets(graphicsConfiguration));
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
		Insets insets = toolkit.getScreenInsets(config);
		if (!jdk8231564)
		{
			// Prior to JDK-8231564, WFramePeer expects the bounds to be relative to the current monitor instead of the
			// primary display.
			bounds.x = bounds.y = 0;

			assert !jdk8243925 : "scaled insets without scaled bounds";
		}
		else if (!jdk8243925)
		{
			// The insets from getScreenInsets are not scaled prior to JDK-8243925, we must convert them to DPI scaled
			// pixels on 11.0.8 due to JDK-8231564 which expects the bounds to be in DPI-aware pixels.
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
}
