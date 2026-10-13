/*
 * Copyright (c) 2026, RuneLite scene mirror prototype contributors
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
package net.runelite.client.plugins.gpu;

import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.util.function.Supplier;
import net.runelite.api.Client;

/** Scene-only bridge for the exact-version native picking patch. */
public final class SceneMirrorPicking
{
	private static volatile State inputState;
	private static volatile State projectionState;
	private static volatile CameraPreference cameraPreference;
	private static volatile Supplier<AffineTransform> displayTransformSupplier;

	private SceneMirrorPicking()
	{
	}

	public static int mapSceneX(int x, int y)
	{
		State current = inputState;
		return current != null && current.matches() ? current.frame.mapX(x, y) : x;
	}

	/** Only successful native world projections call this; invalid branches stay native. */
	public static int mapWorldAnchorX(int x)
	{
		State current = projectionState;
		return current != null && current.matches() ? current.frame.projectX(x) : x;
	}

	public static int mapWorldCanvasX(Client client, int x, int y)
	{
		State current = projectionState;
		if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE || current == null
			|| current.client != client || !current.matches())
		{
			return x;
		}
		return current.frame.projectX(x - current.frame.logicalX) + current.frame.logicalX;
	}

	public static boolean isMirrored(Client client)
	{
		State current = projectionState;
		return current != null && current.client == client && current.matches();
	}

	/** Preserve the Camera plugin preference while compensating displayed horizontal reflection. */
	public static void setCameraYawPreference(Client client, boolean invertYaw)
	{
		cameraPreference = new CameraPreference(client, invertYaw);
		applyCameraYaw(client);
	}

	private static void applyCameraYaw(Client client)
	{
		CameraPreference preference = cameraPreference;
		State displayed = inputState;
		boolean baseline = preference != null && preference.client == client && preference.invertYaw;
		client.setInvertYaw(baseline ^ (displayed != null && displayed.client == client));
	}

	static void publish(Client client, Frame frame)
	{
		State current = snapshot(client, frame);
		inputState = current;
		projectionState = current;
		applyCameraYaw(client);
	}

	static void beginFrame(Client client, Frame frame)
	{
		projectionState = snapshot(client, frame);
	}

	static void presentFrame(Client client, Frame frame)
	{
		State rendered = projectionState;
		inputState = rendered != null && rendered.client == client && rendered.frame == frame
			? rendered : snapshot(client, frame);
		applyCameraYaw(client);
	}

	static void setDisplayTransformSupplier(Supplier<AffineTransform> supplier)
	{
		displayTransformSupplier = supplier;
	}

	static void clear()
	{
		State previous = inputState;
		inputState = null;
		projectionState = null;
		if (previous != null)
		{
			applyCameraYaw(previous.client);
		}
	}

	private static final class CameraPreference
	{
		private final Client client;
		private final boolean invertYaw;

		private CameraPreference(Client client, boolean invertYaw)
		{
			this.client = client;
			this.invertYaw = invertYaw;
		}
	}

	private static State snapshot(Client client, Frame frame)
	{
		return client != null && frame != null && frame.valid ? new State(client, frame) : null;
	}

	private static final class State
	{
		private final Client client;
		private final Frame frame;
		private final int canvasWidth, canvasHeight, stretchedWidth, stretchedHeight;
		private final boolean stretched;
		private final double dpiX, dpiY;

		private State(Client client, Frame frame)
		{
			this.client = client;
			this.frame = frame;
			canvasWidth = client.getCanvasWidth();
			canvasHeight = client.getCanvasHeight();
			stretched = client.isStretchedEnabled();
			Dimension dimensions = stretched ? client.getStretchedDimensions() : null;
			stretchedWidth = dimensions == null ? 0 : dimensions.width;
			stretchedHeight = dimensions == null ? 0 : dimensions.height;
			AffineTransform display = displayTransform();
			dpiX = display.getScaleX();
			dpiY = display.getScaleY();
		}

		private boolean matches()
		{
			if (client.getViewportXOffset() != frame.logicalX || client.getViewportYOffset() != frame.logicalY
				|| client.getViewportWidth() != frame.logicalWidth || client.getViewportHeight() != frame.logicalHeight
				|| client.getCanvasWidth() != canvasWidth || client.getCanvasHeight() != canvasHeight
				|| client.isStretchedEnabled() != stretched)
			{
				return false;
			}
			Dimension dimensions = stretched ? client.getStretchedDimensions() : null;
			AffineTransform display = displayTransform();
			return (!stretched || dimensions != null && dimensions.width == stretchedWidth && dimensions.height == stretchedHeight)
				&& display.getScaleX() == dpiX && display.getScaleY() == dpiY;
		}
	}

	private static AffineTransform displayTransform()
	{
		Supplier<AffineTransform> supplier = displayTransformSupplier;
		return supplier == null ? new AffineTransform() : supplier.get();
	}

	/** Uses the actual rendered physical viewport, including its padding and rounding. */
	static final class Frame
	{
		static Frame capture(Client client, int physicalX, int physicalWidth, SceneMirrorViewport viewport)
		{
			if (viewport == null || client.getCanvasWidth() <= 0 || client.getCanvasHeight() <= 0)
			{
				return null;
			}
			return new Frame(client.getViewportXOffset(), client.getViewportYOffset(),
				client.getViewportWidth(), client.getViewportHeight(), physicalX, physicalWidth,
				viewport.framebufferWidth / (double) client.getCanvasWidth(),
				viewport.framebufferHeight / (double) client.getCanvasHeight(), viewport);
		}

		private final int logicalX, logicalY, logicalWidth, logicalHeight;
		private final int physicalX, physicalWidth;
		private final double scaleX, scaleY, axis;
		private final SceneMirrorViewport viewport;
		private final boolean valid;

		Frame(int logicalX, int logicalY, int logicalWidth, int logicalHeight,
			int physicalX, int physicalWidth, double scaleX, double scaleY, SceneMirrorViewport viewport)
		{
			this.logicalX = logicalX;
			this.logicalY = logicalY;
			this.logicalWidth = logicalWidth;
			this.logicalHeight = logicalHeight;
			this.physicalX = physicalX;
			this.physicalWidth = physicalWidth;
			this.scaleX = scaleX;
			this.scaleY = scaleY;
			this.viewport = viewport;
			this.axis = 2.0 * physicalX + physicalWidth;
			this.valid = logicalWidth > 0 && logicalHeight > 0 && physicalWidth > 0 && viewport != null
				&& Double.isFinite(scaleX) && Double.isFinite(scaleY) && scaleX > 0 && scaleY > 0;
		}

		int mapX(int x, int y)
		{
			if (!valid || x < 0 || x >= logicalWidth || y < 0 || y >= logicalHeight)
			{
				return x;
			}
			double mouseX = scaleX * ((double) logicalX + x + .5);
			double mouseY = viewport.framebufferHeight - scaleY * ((double) logicalY + y + .5);
			if (mouseX < viewport.destinationX0 || mouseX >= viewport.destinationX1
				|| mouseY < viewport.y0 || mouseY >= viewport.y1)
			{
				return x;
			}
			return (int) Math.floor((axis - mouseX - physicalX) * logicalWidth / physicalWidth);
		}

		private int projectX(int x)
		{
			// Reflect all valid projected vertices, including ones beyond viewport edges.
			// Text/image callers center their upright glyphs after this anchor conversion.
			double sourceX = physicalX + (double) x * physicalWidth / logicalWidth;
			return (int) Math.floor((axis - sourceX) / scaleX) - logicalX;
		}
	}
}
