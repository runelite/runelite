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
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.stretchedmode.StretchedModeConfig;

/**
 * Offscreen buffers for drawing RuneLite overlays at stretched (display) resolution
 * so they are not upscaled with the game UI.
 * <p>
 * Three overlay passes match {@link OverlayLayer} around the split client 2D texture:
 * {@link OverlayLayer#ABOVE_SCENE} under overheads, {@link OverlayLayer#UNDER_WIDGETS}
 * above overheads, and above-UI ({@link OverlayLayer#ABOVE_WIDGETS},
 * {@link OverlayLayer#ALWAYS_ON_TOP}). Overheads are snapshotted out of the canvas
 * at {@code drawAboveOverheads} so widgets can paint onto a clean buffer.
 * <p>
 * Inactive when stretched mode is off, or when stretch does not actually upscale
 * (stretched size equals canvas) — then the legacy single-buffer path is enough.
 * Each pass is fully cleared once per frame; compositors upload the full buffer
 * when the pass was touched (or to push a clear after prior content).
 */
@Singleton
public class NativeOverlayBuffer
{
	public enum Pass
	{
		/**
		 * Drawn after the scene and before overheads (HP bars, hitsplats).
		 */
		ABOVE_SCENE,
		/**
		 * Drawn after overheads and before interfaces (bank, inventory, etc.).
		 */
		UNDER_WIDGETS,
		/**
		 * Drawn after the game UI (tooltips, overlays moved over interfaces, etc.).
		 */
		ABOVE_UI
	}

	private final Client client;
	private final StretchedModeConfig stretchedModeConfig;

	private BufferedImage aboveSceneImage;
	private BufferedImage underWidgetsImage;
	private BufferedImage aboveImage;
	private int[] uploadScratch;
	private int[] overheadPixels;
	private int overheadsWidth;
	private int overheadsHeight;
	private int frameId;
	private int preparedFrameId = -1;
	private Pass activePass;

	private final PassState aboveScene = new PassState();
	private final PassState underWidgets = new PassState();
	private final PassState above = new PassState();
	private final PassState overheads = new PassState();

	@Inject
	private NativeOverlayBuffer(Client client, ConfigManager configManager)
	{
		this.client = client;
		this.stretchedModeConfig = configManager.getConfig(StretchedModeConfig.class);
	}

	/**
	 * Whether native overlay buffers should be used. Requires stretched mode and an
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

	/**
	 * Whether this overlay layer should be composited above the game UI.
	 */
	public static boolean isAboveUiLayer(OverlayLayer layer)
	{
		return layer == OverlayLayer.ABOVE_WIDGETS || layer == OverlayLayer.ALWAYS_ON_TOP;
	}

	public Pass passForLayer(OverlayLayer layer)
	{
		if (layer == OverlayLayer.ABOVE_SCENE)
		{
			return Pass.ABOVE_SCENE;
		}
		if (layer == OverlayLayer.UNDER_WIDGETS)
		{
			return Pass.UNDER_WIDGETS;
		}
		return Pass.ABOVE_UI;
	}

	public void setActivePass(Pass pass)
	{
		activePass = pass;
	}

	public Pass getActivePass()
	{
		return activePass;
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
	 * When true, overlays keep their original unstretched size.
	 * When false, overlays grow with stretch (same visual size as the stretched UI).
	 */
	public boolean fixedOverlaySize()
	{
		return stretchedModeConfig.fixedOverlaySize();
	}

	/**
	 * When true (and fixed overlay size is off), interface overlays scale uniformly to the
	 * game/canvas aspect instead of matching a non-uniform window stretch.
	 */
	public boolean fixedOverlayAspectRatio()
	{
		return stretchedModeConfig.fixedOverlayAspectRatio();
	}

	/**
	 * Content scale applied after the outer stretch transform for interface overlays
	 * (infoboxes, panels, tooltips), with {@code s = min(sx, sy)}:
	 * <ul>
	 * <li>Fixed size + fixed aspect: {@code 1/sx, 1/sy} (net 1×1 canvas pixels)</li>
	 * <li>Fixed size only: {@code 1/s, 1/s} (smaller, window aspect)</li>
	 * <li>Fixed aspect only: {@code s/sx, s/sy} (uniform {@code s})</li>
	 * <li>Else: {@code 1, 1} (full window stretch)</li>
	 * </ul>
	 */
	public double getPanelContentScaleX()
	{
		return getPanelContentScale(getScaleX());
	}

	public double getPanelContentScaleY()
	{
		return getPanelContentScale(getScaleY());
	}

	private double getPanelContentScale(double axisScale)
	{
		if (axisScale == 0)
		{
			return 1;
		}
		if (fixedOverlaySize())
		{
			return 1 / (fixedOverlayAspectRatio() ? axisScale : minScale());
		}
		return fixedOverlayAspectRatio() ? minScale() / axisScale : 1;
	}

	private double minScale()
	{
		double sx = getScaleX();
		double sy = getScaleY();
		return Math.min(sx == 0 ? 1 : sx, sy == 0 ? 1 : sy);
	}

	/**
	 * Content scale for world/DYNAMIC decorations, which cancel the stretch per axis so they
	 * stay anchored to the stretched scene at their unstretched size. Ignores fixed overlay
	 * aspect ratio so object-tied overlays stay aligned with the scene.
	 */
	public double getFixedSizeContentScaleX()
	{
		return inverseScale(getScaleX());
	}

	public double getFixedSizeContentScaleY()
	{
		return inverseScale(getScaleY());
	}

	private double inverseScale(double scale)
	{
		return fixedOverlaySize() && scale != 0 ? 1 / scale : 1;
	}

	/**
	 * Ensures required buffers exist and are cleared once per client frame.
	 * Under-UI passes are only allocated on GPU (CPU keeps those overlays on the canvas,
	 * since the software renderer already merges scene and widgets).
	 */
	public void prepareFrame()
	{
		if (!isActive())
		{
			release();
			return;
		}

		Dimension dim = client.getStretchedDimensions();

		if (client.isGpu())
		{
			aboveSceneImage = ensureImage(aboveSceneImage, dim);
			underWidgetsImage = ensureImage(underWidgetsImage, dim);
		}
		else
		{
			if (aboveSceneImage != null)
			{
				aboveSceneImage = null;
				aboveScene.reset();
			}
			if (underWidgetsImage != null)
			{
				underWidgetsImage = null;
				underWidgets.reset();
			}
		}

		aboveImage = ensureImage(aboveImage, dim);

		if (preparedFrameId != frameId)
		{
			beginFrame(Pass.ABOVE_SCENE);
			beginFrame(Pass.UNDER_WIDGETS);
			beginFrame(Pass.ABOVE_UI);
			preparedFrameId = frameId;
		}
	}

	private void beginFrame(Pass pass)
	{
		PassState state = state(pass);
		if (getImage(pass) == null)
		{
			state.reset();
			return;
		}

		Arrays.fill(getPixels(pass), 0);
		state.touched = false;
		// hadContent from the previous finishComposite keeps isDirty true so the
		// compositor uploads this cleared buffer once (avoids ghosted GL/CPU pixels).
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
		state(pass).touched = true;
	}

	public boolean isDirty(Pass pass)
	{
		PassState state = state(pass);
		return state.touched || state.hadContent;
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
	 * Call after a successful GPU/CPU composite so the next frame can clear this pass.
	 */
	public void finishComposite(Pass pass)
	{
		PassState state = state(pass);
		state.hadContent = state.touched;
		state.touched = false;
	}

	public BufferedImage getImage(Pass pass)
	{
		switch (pass)
		{
			case ABOVE_SCENE:
				return aboveSceneImage;
			case UNDER_WIDGETS:
				return underWidgetsImage;
			case ABOVE_UI:
				return aboveImage;
			default:
				return null;
		}
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

	/**
	 * Copy canvas pixels (overheads) then zero the canvas so widgets paint onto a clean buffer.
	 * GPU + native only; the software renderer already has the scene in this buffer.
	 */
	public void captureAndClearOverheads(int[] canvasPixels, int width, int height)
	{
		if (canvasPixels == null || width <= 0 || height <= 0 || !isActive() || !client.isGpu())
		{
			return;
		}

		final int need = width * height;
		if (overheadPixels == null || overheadPixels.length < need)
		{
			overheadPixels = new int[need];
		}
		System.arraycopy(canvasPixels, 0, overheadPixels, 0, need);
		Arrays.fill(canvasPixels, 0, need, 0);
		overheadsWidth = width;
		overheadsHeight = height;
		overheads.touched = true;
	}

	public boolean isOverheadsDirty()
	{
		return overheads.touched || overheads.hadContent;
	}

	public int[] getOverheadPixels()
	{
		return overheadPixels;
	}

	public int getOverheadsWidth()
	{
		return overheadsWidth;
	}

	public int getOverheadsHeight()
	{
		return overheadsHeight;
	}

	/**
	 * Upload zeros when a prior overhead frame needs to be cleared from the GL texture.
	 */
	public int[] getOverheadUploadPixels()
	{
		if (!isOverheadsDirty())
		{
			return null;
		}
		if (overheads.touched)
		{
			return overheadPixels;
		}
		if (overheadsWidth <= 0 || overheadsHeight <= 0)
		{
			return null;
		}
		return getTransparentTextureInit(overheadsWidth, overheadsHeight);
	}

	public void finishOverheadsComposite()
	{
		overheads.hadContent = overheads.touched;
		overheads.touched = false;
	}

	private PassState state(Pass pass)
	{
		switch (pass)
		{
			case ABOVE_SCENE:
				return aboveScene;
			case UNDER_WIDGETS:
				return underWidgets;
			case ABOVE_UI:
				return above;
			default:
				throw new IllegalArgumentException(String.valueOf(pass));
		}
	}

	public void release()
	{
		aboveSceneImage = null;
		underWidgetsImage = null;
		aboveImage = null;
		uploadScratch = null;
		overheadPixels = null;
		overheadsWidth = 0;
		overheadsHeight = 0;
		preparedFrameId = -1;
		activePass = null;
		aboveScene.reset();
		underWidgets.reset();
		above.reset();
		overheads.reset();
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
