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
import java.awt.Point;
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
import net.runelite.api.events.MenuOpened;
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
 * The captured menu follows the full UI stretch by default. Stretched Mode
 * {@code fixedMenuSize} / {@code fixedMenuAspectRatio} shrink it instead, anchored on the
 * click that opened it; mouse coordinates are remapped to match.
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

	/** Canvas position of the click that opened the current menu (for fixed size/aspect placement). */
	private int menuOpenCanvasX;
	private int menuOpenCanvasY;
	private boolean hasMenuOpenPoint;

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
		if (capturingMenu || !nativeOverlayBuffer.isActive())
		{
			return;
		}
		if (!client.isMenuOpen())
		{
			hasMenuOpenPoint = false;
			return;
		}

		event.consume();
		deferredMenu = true;
	}

	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{
		final net.runelite.api.Point mouse = client.getMouseCanvasPosition();
		menuOpenCanvasX = mouse.getX();
		menuOpenCanvasY = mouse.getY();
		hasMenuOpenPoint = true;
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

		// Pin dest to the root menu so opening a submenu does not re-center/shift the tree.
		final Rectangle root = getRootMenuBounds(client);
		lastCaptureDest = computeCaptureDest(
			menu,
			root != null ? root : menu,
			nativeOverlayBuffer.getScaleX(),
			nativeOverlayBuffer.getScaleY(),
			nativeOverlayBuffer.fixedMenuSize(),
			nativeOverlayBuffer.fixedMenuAspectRatio(),
			client.getCanvasWidth(),
			client.getCanvasHeight(),
			hasMenuOpenPoint,
			menuOpenCanvasX,
			menuOpenCanvasY);
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
	 * After stretch→canvas mouse translate, remap so clicks match a fixed-size or
	 * aspect-corrected visual menu. Anchored on the root menu so opening a submenu does
	 * not shift hit-testing. Returns {@code null} when no adjustment is needed.
	 */
	@Nullable
	public Point remapTranslatedMouse(int stretchedX, int stretchedY, int canvasX, int canvasY)
	{
		if (!nativeOverlayBuffer.isActive() || !client.isMenuOpen())
		{
			return null;
		}

		final boolean fixedSize = nativeOverlayBuffer.fixedMenuSize();
		final boolean fixedAspect = nativeOverlayBuffer.fixedMenuAspectRatio();
		if (!fixedSize && !fixedAspect)
		{
			return null;
		}

		final Rectangle root = getRootMenuBounds(client);
		final Rectangle hit = getTightMenuBounds(client);
		if (root == null || hit == null)
		{
			return null;
		}

		final double scaleX = nativeOverlayBuffer.getScaleX();
		final double scaleY = nativeOverlayBuffer.getScaleY();
		final Rectangle rootDest = computeMenuDest(root, scaleX, scaleY, fixedSize, fixedAspect,
			client.getCanvasWidth(), client.getCanvasHeight(), hasMenuOpenPoint, menuOpenCanvasX, menuOpenCanvasY);
		final Rectangle visualHit = mapCanvasRectFromAnchor(hit, root, rootDest);
		if (visualHit.equals(computeMenuDest(hit, scaleX, scaleY, false, false)))
		{
			return null;
		}

		if (visualHit.contains(stretchedX, stretchedY))
		{
			final double contentScaleX = rootDest.width / (double) root.width;
			final double contentScaleY = rootDest.height / (double) root.height;
			final int mx = (int) Math.floor(root.x + (stretchedX - rootDest.x) / contentScaleX);
			final int my = (int) Math.floor(root.y + (stretchedY - rootDest.y) / contentScaleY);
			return new Point(
				Math.max(hit.x, Math.min(hit.x + hit.width - 1, mx)),
				Math.max(hit.y, Math.min(hit.y + hit.height - 1, my)));
		}

		if (hit.contains(canvasX, canvasY))
		{
			// Outside the visual menu but inside the stretched hit-box — miss the menu.
			return new Point(hit.x - 1, hit.y - 1);
		}

		return null;
	}

	/**
	 * Stretched-space destination for a canvas-space menu rectangle. Without fixed size or
	 * aspect the menu follows the full UI stretch, landing exactly where the client drew it.
	 */
	public static Rectangle computeMenuDest(
		Rectangle menu,
		double scaleX,
		double scaleY,
		boolean fixedSize,
		boolean fixedAspect)
	{
		return computeMenuDest(menu, scaleX, scaleY, fixedSize, fixedAspect, 0, 0, false, 0, 0);
	}

	/**
	 * Fixed size/aspect place relative to the opening click when known (else menu center /
	 * top), then clamp into the stretched viewport only if the dest would not fit.
	 */
	public static Rectangle computeMenuDest(
		Rectangle menu,
		double scaleX,
		double scaleY,
		boolean fixedSize,
		boolean fixedAspect,
		int canvasWidth,
		int canvasHeight,
		boolean hasClickAnchor,
		int clickCanvasX,
		int clickCanvasY)
	{
		if (!fixedSize && !fixedAspect)
		{
			return new Rectangle(
				(int) Math.round(menu.x * scaleX),
				(int) Math.round(menu.y * scaleY),
				Math.max(1, (int) Math.round(menu.width * scaleX)),
				Math.max(1, (int) Math.round(menu.height * scaleY)));
		}

		final double s = Math.min(scaleX == 0 ? 1 : scaleX, scaleY == 0 ? 1 : scaleY);
		// Fixed size with fixed aspect is true canvas pixels; without it, the window aspect
		// is kept by shrinking both axes to the smaller stretch. Aspect alone scales by s.
		final double contentScaleX = fixedSize ? (fixedAspect ? 1 : scaleX / s) : s;
		final double contentScaleY = fixedSize ? (fixedAspect ? 1 : scaleY / s) : s;
		final int destWidth = Math.max(1, (int) Math.round(menu.width * contentScaleX));
		final int destHeight = Math.max(1, (int) Math.round(menu.height * contentScaleY));

		final double anchorX = hasClickAnchor ? clickCanvasX : menu.x + menu.width / 2.0;
		// The client lays the menu out below the click, so Y is top-aligned, never centered.
		final double anchorTopY = hasClickAnchor ? clickCanvasY : menu.y;
		return new Rectangle(
			clampDest((int) Math.round(anchorX * scaleX - destWidth / 2.0), destWidth, scaleX, canvasWidth),
			clampDest((int) Math.round(anchorTopY * scaleY), destHeight, scaleY, canvasHeight),
			destWidth,
			destHeight);
	}

	/**
	 * Dest for a capture crop anchored on {@code anchor} (the root menu) so submenu union
	 * growth does not re-center/shift the tree.
	 */
	public static Rectangle computeCaptureDest(
		Rectangle capture,
		Rectangle anchor,
		double scaleX,
		double scaleY,
		boolean fixedSize,
		boolean fixedAspect)
	{
		return computeCaptureDest(capture, anchor, scaleX, scaleY, fixedSize, fixedAspect, 0, 0, false, 0, 0);
	}

	public static Rectangle computeCaptureDest(
		Rectangle capture,
		Rectangle anchor,
		double scaleX,
		double scaleY,
		boolean fixedSize,
		boolean fixedAspect,
		int canvasWidth,
		int canvasHeight,
		boolean hasClickAnchor,
		int clickCanvasX,
		int clickCanvasY)
	{
		if (!fixedSize && !fixedAspect)
		{
			return computeMenuDest(capture, scaleX, scaleY, false, false);
		}

		final Rectangle anchorDest = computeMenuDest(anchor, scaleX, scaleY, fixedSize, fixedAspect,
			canvasWidth, canvasHeight, hasClickAnchor, clickCanvasX, clickCanvasY);
		return mapCanvasRectFromAnchor(capture, anchor, anchorDest);
	}

	/**
	 * Maps a canvas-space rectangle into stretched space with the same content scale as
	 * {@code anchor} → {@code anchorDest}.
	 */
	private static Rectangle mapCanvasRectFromAnchor(Rectangle canvasRect, Rectangle anchor, Rectangle anchorDest)
	{
		final double contentScaleX = anchor.width == 0 ? 1 : anchorDest.width / (double) anchor.width;
		final double contentScaleY = anchor.height == 0 ? 1 : anchorDest.height / (double) anchor.height;
		return new Rectangle(
			(int) Math.round(anchorDest.x + (canvasRect.x - anchor.x) * contentScaleX),
			(int) Math.round(anchorDest.y + (canvasRect.y - anchor.y) * contentScaleY),
			Math.max(1, (int) Math.round(canvasRect.width * contentScaleX)),
			Math.max(1, (int) Math.round(canvasRect.height * contentScaleY)));
	}

	private static int clampDest(int pos, int destSize, double scale, int canvasSize)
	{
		if (canvasSize <= 0)
		{
			return pos;
		}
		final int stretched = Math.max(destSize, (int) Math.round(canvasSize * scale));
		return Math.max(0, Math.min(pos, stretched - destSize));
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
		Rectangle bounds = getTightMenuBounds(client);
		if (bounds == null)
		{
			return null;
		}

		final Menu root = client.getMenu();
		if (root != null && menuTreeHasSubmenu(root))
		{
			bounds = new Rectangle(bounds);
			bounds.grow(SUBMENU_CAPTURE_PAD, 16);
			bounds = clipToCanvas(client, bounds);
		}

		return bounds;
	}

	/**
	 * Tight union of the open menu and any open submenu rectangles (no capture pad).
	 */
	@Nullable
	private static Rectangle getTightMenuBounds(Client client)
	{
		if (!client.isMenuOpen())
		{
			return null;
		}

		final Menu root = client.getMenu();
		final Rectangle bounds = root == null ? null : unionMenuBounds(null, root);
		return clipToCanvas(client, bounds != null ? bounds : clientMenuBounds(client));
	}

	/**
	 * Top-level menu bounds only (no submenu union), used to anchor fixed size/aspect dest.
	 */
	@Nullable
	private static Rectangle getRootMenuBounds(Client client)
	{
		if (!client.isMenuOpen())
		{
			return null;
		}

		Rectangle bounds = null;
		final Menu root = client.getMenu();
		if (root != null && root.getMenuWidth() > 0 && root.getMenuHeight() > 0)
		{
			bounds = new Rectangle(root.getMenuX(), root.getMenuY(), root.getMenuWidth(), root.getMenuHeight());
		}

		return clipToCanvas(client, bounds != null ? bounds : clientMenuBounds(client));
	}

	@Nullable
	private static Rectangle clientMenuBounds(Client client)
	{
		final int w = client.getMenuWidth();
		final int h = client.getMenuHeight();
		return w <= 0 || h <= 0 ? null : new Rectangle(client.getMenuX(), client.getMenuY(), w, h);
	}

	@Nullable
	private static Rectangle clipToCanvas(Client client, @Nullable Rectangle bounds)
	{
		if (bounds == null)
		{
			return null;
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
