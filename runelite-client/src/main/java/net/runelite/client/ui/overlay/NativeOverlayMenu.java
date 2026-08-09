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

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.BufferProvider;
import net.runelite.api.Client;
import net.runelite.api.Menu;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.BeforeMenuRender;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;

/**
 * Defers the right-click menu while native overlays are active, then composites it
 * after ABOVE_UI so translucent menus blend over sharp overlays.
 * <p>
 * Early {@link BeforeMenuRender} is consumed so the menu never enters the UI texture.
 * After ABOVE_UI we re-post that event onto black and white scratch fills to recover
 * real per-pixel alpha.
 * <p>
 * The captured menu is placed with the same stretch as the rest of the UI, so its
 * position and hit-testing match what the client itself would have drawn.
 * <p>
 * Menu look and transparency come only from Interface Styles when that plugin is
 * enabled ({@code hdMenu} / {@code menuAlpha}). With Interface Styles off (or HD
 * off and alpha 255), capture falls back to opaque {@code drawOriginalMenu(255)}.
 */
@Singleton
public class NativeOverlayMenu
{
	/** Extra capture pad so flyout submenus beside the root are included. */
	private static final int SUBMENU_CAPTURE_PAD = 280;

	private final Client client;
	private final NativeOverlayBuffer nativeOverlayBuffer;
	private final EventBus eventBus;

	private boolean deferredMenu;
	private boolean capturingMenu;

	/** Stretched-space destination of the last successful capture. */
	@Getter
	@Nullable
	private Rectangle lastCaptureDest;

	@Inject
	private NativeOverlayMenu(
		Client client,
		NativeOverlayBuffer nativeOverlayBuffer,
		EventBus eventBus)
	{
		this.client = client;
		this.nativeOverlayBuffer = nativeOverlayBuffer;
		this.eventBus = eventBus;
		eventBus.register(this);
	}

	/**
	 * Run before Interface Styles so HD/alpha menus are deferred too.
	 * While {@link #capturingMenu}, do not consume — capture re-posts this event.
	 */
	@Subscribe(priority = 2)
	public void onBeforeMenuRender(BeforeMenuRender event)
	{
		if (capturingMenu || !nativeOverlayBuffer.isActive() || !client.isMenuOpen())
		{
			return;
		}

		event.consume();
		deferredMenu = true;
	}

	public boolean hasDeferredMenu()
	{
		return deferredMenu;
	}

	public void clearDeferredMenu()
	{
		deferredMenu = false;
	}

	/**
	 * Straight ARGB image of the menu crop, from black/white Interface Styles / client
	 * paint. Sized to the capture crop; {@link #getLastCaptureDest()} holds where it
	 * belongs in the stretched frame.
	 */
	@Nullable
	public BufferedImage captureMenuLayer()
	{
		if (!deferredMenu)
		{
			return null;
		}

		clearDeferredMenu();
		lastCaptureDest = null;

		final Rectangle menu = getCanvasBounds(client);
		if (menu == null)
		{
			return null;
		}

		final BufferProvider bufferProvider = client.getBufferProvider();
		final int[] pixels = bufferProvider.getPixels();
		final int stride = bufferProvider.getWidth();
		final int w = menu.width;
		final int h = menu.height;

		final int[] under = new int[w * h];
		copyRect(pixels, stride, menu, under);

		capturingMenu = true;
		final int[] onBlack;
		final int[] onWhite;
		try
		{
			fillRect(pixels, stride, menu, 0xFF000000);
			paintMenuViaSubscribers();
			onBlack = new int[w * h];
			copyRect(pixels, stride, menu, onBlack);

			fillRect(pixels, stride, menu, 0xFFFFFFFF);
			paintMenuViaSubscribers();
			onWhite = new int[w * h];
			copyRect(pixels, stride, menu, onWhite);
		}
		finally
		{
			capturingMenu = false;
			pasteRect(pixels, stride, menu, under);
		}

		final BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		final int[] out = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		for (int i = 0; i < onBlack.length; ++i)
		{
			final int b = onBlack[i];
			final int wh = onWhite[i];
			final int br = b >> 16 & 0xFF;
			final int bg = b >> 8 & 0xFF;
			final int bb = b & 0xFF;
			final int wr = wh >> 16 & 0xFF;
			final int wg = wh >> 8 & 0xFF;
			final int wb = wh & 0xFF;
			int invA = ((wr - br) + (wg - bg) + (wb - bb)) / 3;
			if (invA < 0)
			{
				invA = 0;
			}
			else if (invA > 255)
			{
				invA = 255;
			}
			final int a = 255 - invA;
			if (a == 0)
			{
				out[i] = 0;
			}
			else
			{
				final int sr = Math.min(255, (br * 255 + a / 2) / a);
				final int sg = Math.min(255, (bg * 255 + a / 2) / a);
				final int sb = Math.min(255, (bb * 255 + a / 2) / a);
				out[i] = a << 24 | sr << 16 | sg << 8 | sb;
			}
		}

		lastCaptureDest = computeMenuDest(menu, nativeOverlayBuffer.getScaleX(), nativeOverlayBuffer.getScaleY());
		return image;
	}

	/**
	 * Draw the captured menu crop onto a stretched frame after ABOVE_UI.
	 */
	public void compositeOntoStretched(Graphics2D g)
	{
		final BufferedImage menuImage = captureMenuLayer();
		final Rectangle dest = lastCaptureDest;
		if (menuImage == null || dest == null || !client.isStretchedEnabled())
		{
			return;
		}

		final Object oldInterp = g.getRenderingHint(RenderingHints.KEY_INTERPOLATION);
		// Nearest keeps glyph edges from picking up neighbouring translucent fill.
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		g.drawImage(menuImage, dest.x, dest.y, dest.width, dest.height, null);
		if (oldInterp != null)
		{
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, oldInterp);
		}
	}

	/**
	 * Stretched-space destination for a canvas-space menu rectangle: the menu follows
	 * the full UI stretch, so it lands exactly where the client drew it.
	 */
	public static Rectangle computeMenuDest(Rectangle menu, double scaleX, double scaleY)
	{
		return new Rectangle(
			(int) Math.round(menu.x * scaleX),
			(int) Math.round(menu.y * scaleY),
			Math.max(1, (int) Math.round(menu.width * scaleX)),
			Math.max(1, (int) Math.round(menu.height * scaleY)));
	}

	/**
	 * Let Interface Styles paint HD/alpha menus when enabled; otherwise opaque original.
	 */
	private void paintMenuViaSubscribers()
	{
		final BeforeMenuRender event = new BeforeMenuRender();
		eventBus.post(event);
		if (!event.isConsumed())
		{
			// IS off, or IS with hdMenu off and menuAlpha 255
			client.drawOriginalMenu(255);
		}
	}

	/**
	 * Padded capture bounds (includes submenu flyout pad when needed).
	 */
	@Nullable
	private static Rectangle getCanvasBounds(Client client)
	{
		if (!client.isMenuOpen())
		{
			return null;
		}

		Rectangle bounds = null;
		final Menu root = client.getMenu();
		if (root != null)
		{
			bounds = unionMenuBounds(null, root);
			if (bounds != null && menuTreeHasSubmenu(root))
			{
				bounds.grow(SUBMENU_CAPTURE_PAD, 16);
			}
		}

		if (bounds == null)
		{
			final int w = client.getMenuWidth();
			final int h = client.getMenuHeight();
			if (w <= 0 || h <= 0)
			{
				return null;
			}
			bounds = new Rectangle(client.getMenuX(), client.getMenuY(), w, h);
		}

		final Rectangle clipped = bounds.intersection(
			new Rectangle(0, 0, client.getCanvasWidth(), client.getCanvasHeight()));
		return clipped.isEmpty() ? null : clipped;
	}

	/**
	 * Union of the open menu and any open submenu rectangles.
	 */
	@Nullable
	private static Rectangle unionMenuBounds(@Nullable Rectangle acc, Menu menu)
	{
		final int w = menu.getMenuWidth();
		final int h = menu.getMenuHeight();
		if (w > 0 && h > 0)
		{
			final Rectangle r = new Rectangle(menu.getMenuX(), menu.getMenuY(), w, h);
			acc = acc == null ? r : acc.union(r);
		}

		final MenuEntry[] entries = menu.getMenuEntries();
		if (entries != null)
		{
			for (MenuEntry entry : entries)
			{
				final Menu sub = entry.getSubMenu();
				if (sub != null)
				{
					acc = unionMenuBounds(acc, sub);
				}
			}
		}
		return acc;
	}

	private static boolean menuTreeHasSubmenu(Menu menu)
	{
		final MenuEntry[] entries = menu.getMenuEntries();
		if (entries == null)
		{
			return false;
		}
		for (MenuEntry entry : entries)
		{
			if (entry.getSubMenu() != null)
			{
				return true;
			}
		}
		return false;
	}

	private static void copyRect(int[] pixels, int stride, Rectangle rect, int[] dest)
	{
		int i = 0;
		for (int y = 0; y < rect.height; ++y)
		{
			final int row = (rect.y + y) * stride + rect.x;
			System.arraycopy(pixels, row, dest, i, rect.width);
			i += rect.width;
		}
	}

	private static void pasteRect(int[] pixels, int stride, Rectangle rect, int[] src)
	{
		int i = 0;
		for (int y = 0; y < rect.height; ++y)
		{
			final int row = (rect.y + y) * stride + rect.x;
			System.arraycopy(src, i, pixels, row, rect.width);
			i += rect.width;
		}
	}

	private static void fillRect(int[] pixels, int stride, Rectangle rect, int argb)
	{
		for (int y = 0; y < rect.height; ++y)
		{
			final int row = (rect.y + y) * stride + rect.x;
			for (int x = 0; x < rect.width; ++x)
			{
				pixels[row + x] = argb;
			}
		}
	}
}
