/*
 * Copyright (c) 2026, StaySleeping <https://github.com/StaySleeping>
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
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;

/**
 * Offscreen buffer for drawing RuneLite overlays at stretched (display) resolution
 * so they are not upscaled with the game UI.
 * <p>
 * Inactive when stretched mode is off, or when stretch does not actually upscale
 * (stretched size equals canvas) — then the legacy single-buffer path is enough.
 * The buffer is fully cleared once per frame; compositors upload it when the pass
 * was touched (or to push a clear after prior content).
 */
@Singleton
public class NativeOverlayBuffer
{
	public enum Pass
	{
		/**
		 * Drawn after the scene and before the game UI (bank, inventory, etc.).
		 */
		UNDER_UI
	}

	private final Client client;

	private BufferedImage underImage;
	private int[] uploadScratch;
	private int frameId;
	private int preparedFrameId = -1;

	private final PassState under = new PassState();

	@Inject
	private NativeOverlayBuffer(Client client)
	{
		this.client = client;
	}

	/**
	 * Whether the native overlay buffer should be used. Requires stretched mode and an
	 * actual upscale; otherwise overlays can share the canvas buffer like before.
	 */
	public boolean isActive()
	{
		if (!client.isStretchedEnabled())
		{
			return false;
		}
		Dimension stretched = client.getStretchedDimensions();
		return stretched.width > client.getCanvasWidth()
			|| stretched.height > client.getCanvasHeight();
	}

	public double getScaleX()
	{
		if (!client.isStretchedEnabled())
		{
			return 1;
		}
		int canvasWidth = client.getCanvasWidth();
		return canvasWidth == 0 ? 1 : client.getStretchedDimensions().getWidth() / canvasWidth;
	}

	public double getScaleY()
	{
		if (!client.isStretchedEnabled())
		{
			return 1;
		}
		int canvasHeight = client.getCanvasHeight();
		return canvasHeight == 0 ? 1 : client.getStretchedDimensions().getHeight() / canvasHeight;
	}

	/**
	 * Ensures the buffer exists and is cleared once per client frame.
	 * Only allocated on GPU; the software renderer already merges scene and widgets,
	 * so an under-UI composite would draw on top of interfaces.
	 */
	public void prepareFrame()
	{
		if (!isActive())
		{
			release();
			return;
		}

		if (client.isGpu())
		{
			underImage = ensureImage(underImage, client.getStretchedDimensions());
		}
		else if (underImage != null)
		{
			underImage = null;
			under.reset();
		}

		if (preparedFrameId != frameId)
		{
			beginFrame();
			preparedFrameId = frameId;
		}
	}

	private void beginFrame()
	{
		if (underImage == null)
		{
			under.reset();
			return;
		}

		Arrays.fill(getPixels(Pass.UNDER_UI), 0);
		under.touched = false;
		// hadContent from the previous finishComposite keeps isDirty true so the
		// compositor uploads this cleared buffer once (avoids ghosted GL pixels).
	}

	private static BufferedImage ensureImage(BufferedImage image, Dimension dim)
	{
		if (image == null || image.getWidth() != dim.width || image.getHeight() != dim.height)
		{
			return new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_ARGB);
		}
		return image;
	}

	public void nextFrame()
	{
		frameId++;
	}

	/**
	 * Marks the pass as needing a full-buffer upload this frame.
	 */
	public void markDirty(Pass pass)
	{
		if (getImage(pass) == null)
		{
			return;
		}
		under.touched = true;
	}

	public boolean isDirty(Pass pass)
	{
		return under.touched || under.hadContent;
	}

	/**
	 * Full buffer rectangle when this pass needs upload, otherwise null.
	 */
	public Rectangle getUploadRect(Pass pass)
	{
		BufferedImage image = getImage(pass);
		if (image == null || !isDirty(pass))
		{
			return null;
		}
		return new Rectangle(0, 0, image.getWidth(), image.getHeight());
	}

	/**
	 * Call after a successful GPU composite so the next frame can clear this pass.
	 */
	public void finishComposite(Pass pass)
	{
		under.hadContent = under.touched;
		under.touched = false;
	}

	public BufferedImage getImage(Pass pass)
	{
		return underImage;
	}

	public int[] getPixels(Pass pass)
	{
		BufferedImage image = getImage(pass);
		if (image == null)
		{
			return null;
		}
		return ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}

	/**
	 * Zero-filled buffer for GL texture init (transparent). Reused across resizes.
	 */
	public int[] getTransparentTextureInit(int width, int height)
	{
		int need = width * height;
		if (uploadScratch == null || uploadScratch.length < need)
		{
			uploadScratch = new int[need];
		}
		else
		{
			Arrays.fill(uploadScratch, 0, need, 0);
		}
		return uploadScratch;
	}

	/**
	 * Premultiplies the upload rectangle into a tightly packed scratch buffer (row-major).
	 * Returns null if there is nothing to upload.
	 */
	public int[] getPremultipliedUploadPixels(Pass pass, Rectangle uploadRect)
	{
		int[] src = getPixels(pass);
		BufferedImage image = getImage(pass);
		if (src == null || image == null || uploadRect == null || uploadRect.width <= 0 || uploadRect.height <= 0)
		{
			return null;
		}

		final int imgW = image.getWidth();
		final int w = uploadRect.width;
		final int h = uploadRect.height;
		final int need = w * h;
		if (uploadScratch == null || uploadScratch.length < need)
		{
			uploadScratch = new int[need];
		}

		int di = 0;
		for (int y = 0; y < h; y++)
		{
			int row = (uploadRect.y + y) * imgW + uploadRect.x;
			for (int x = 0; x < w; x++)
			{
				int p = src[row + x];
				int a = (p >>> 24) & 0xFF;
				if (a == 0)
				{
					uploadScratch[di++] = 0;
				}
				else if (a == 255)
				{
					uploadScratch[di++] = p;
				}
				else
				{
					int r = (p >>> 16) & 0xFF;
					int g = (p >>> 8) & 0xFF;
					int b = p & 0xFF;
					uploadScratch[di++] = (a << 24)
						| (((r * a + 127) / 255) << 16)
						| (((g * a + 127) / 255) << 8)
						| ((b * a + 127) / 255);
				}
			}
		}
		return uploadScratch;
	}

	public void release()
	{
		underImage = null;
		uploadScratch = null;
		preparedFrameId = -1;
		under.reset();
	}

	private static final class PassState
	{
		boolean touched;
		boolean hadContent;

		void reset()
		{
			touched = false;
			hadContent = false;
		}
	}
}
