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

import java.awt.Point;
import java.awt.Rectangle;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NativeOverlayMenuTest
{
	private static final Rectangle MENU = new Rectangle(40, 20, 100, 50);

	@Test
	public void computeMenuDest_defaultUniformStretch()
	{
		Rectangle dest = NativeOverlayMenu.computeMenuDest(MENU, 2.0, 2.0, false, false);
		assertEquals(new Rectangle(80, 40, 200, 100), dest);
	}

	@Test
	public void computeMenuDest_defaultNonUniformStretch()
	{
		Rectangle dest = NativeOverlayMenu.computeMenuDest(MENU, 3.0, 2.0, false, false);
		assertEquals(new Rectangle(120, 40, 300, 100), dest);
	}

	@Test
	public void computeMenuDest_fixedSizeKeepsWindowAspect()
	{
		// s=min(3,2)=2; size (100*3/2, 50*2/2)=(150,50); center X=270 → left=195; top=40
		Rectangle dest = NativeOverlayMenu.computeMenuDest(MENU, 3.0, 2.0, true, false);
		assertEquals(new Rectangle(195, 40, 150, 50), dest);
	}

	@Test
	public void computeMenuDest_fixedSizeAndAspectTrueCanvas()
	{
		Rectangle dest = NativeOverlayMenu.computeMenuDest(MENU, 3.0, 2.0, true, true);
		assertEquals(new Rectangle(220, 40, 100, 50), dest);
	}

	@Test
	public void extendedMenuOnlyHighlightsHoveredRow()
	{
		for (int rows = 33; rows <= 70; ++rows)
		{
			final int visible = 32;
			final int maxScroll = rows - visible;
			for (int hovered = 0; hovered < rows; ++hovered)
			{
				final int scroll = NativeOverlayMenu.scrollForRow(hovered, visible, maxScroll);
				final int hoverSlot = hovered - scroll;
				assertTrue(hoverSlot >= 0 && hoverSlot < visible);
				for (int row = 0; row < rows; ++row)
				{
					final int page = NativeOverlayMenu.pageForRow(row, visible, maxScroll, hoverSlot, scroll);
					final int slot = row - page;
					assertTrue("row on screen", page >= 0 && page <= maxScroll && slot >= 0 && slot < visible);
					assertEquals("rows " + rows + " hovered " + hovered + " row " + row, row == hovered, slot == hoverSlot);
				}
			}
		}
	}

	@Test
	public void pageForRowKeepsRowsOnScreenForAnyClientHoverState()
	{
		for (int visible = 1; visible <= 8; ++visible)
		{
			for (int rows = visible + 1; rows <= visible + 40; ++rows)
			{
				final int maxScroll = rows - visible;
				for (int scroll = 0; scroll <= maxScroll; ++scroll)
				{
					for (int hoverSlot = -1; hoverSlot < visible && scroll + hoverSlot < rows; ++hoverSlot)
					{
						for (int row = 0; row < rows; ++row)
						{
							final int page = NativeOverlayMenu.pageForRow(row, visible, maxScroll, hoverSlot, scroll);
							final String state = "visible " + visible + " rows " + rows + " scroll " + scroll
								+ " hoverSlot " + hoverSlot + " row " + row;
							assertTrue(state, page >= 0 && page <= maxScroll);
							assertTrue(state, row - page >= 0 && row - page < visible);
						}
					}
				}
			}
		}
	}

	@Test
	public void pageForRowWithoutHoverUsesFirstPageShowingRow()
	{
		assertEquals(0, NativeOverlayMenu.pageForRow(0, 32, 33, -1, 0));
		assertEquals(0, NativeOverlayMenu.pageForRow(31, 32, 33, -1, 0));
		assertEquals(1, NativeOverlayMenu.pageForRow(32, 32, 33, -1, 0));
		assertEquals(33, NativeOverlayMenu.pageForRow(64, 32, 33, -1, 0));
	}

	@Test
	public void pageForRowUsesCurrentPageForHoveredRow()
	{
		// Mouse over slot 16 at scroll 10 hovers row 26, which must come from the page the client has.
		assertEquals(10, NativeOverlayMenu.pageForRow(26, 32, 33, 16, 10));
	}

	@Test
	public void pageForRowSkipsHoverSlotForOtherRows()
	{
		// Row 20 first shows on page 0 at slot 20; with slot 20 hovered it moves to page 1.
		assertEquals(1, NativeOverlayMenu.pageForRow(20, 32, 33, 20, 5));
		// Row 40 first shows on page 9 at slot 31; with slot 31 hovered it moves to page 10.
		assertEquals(10, NativeOverlayMenu.pageForRow(40, 32, 33, 31, 5));
	}

	@Test
	public void scrollForRowCentresRowAndClamps()
	{
		assertEquals(0, NativeOverlayMenu.scrollForRow(0, 32, 33));
		assertEquals(0, NativeOverlayMenu.scrollForRow(16, 32, 33));
		assertEquals(1, NativeOverlayMenu.scrollForRow(17, 32, 33));
		assertEquals(24, NativeOverlayMenu.scrollForRow(40, 32, 33));
		assertEquals(33, NativeOverlayMenu.scrollForRow(64, 32, 33));
		// Fewer visible rows than half the menu: still within bounds
		assertEquals(0, NativeOverlayMenu.scrollForRow(0, 1, 5));
		assertEquals(5, NativeOverlayMenu.scrollForRow(9, 1, 5));
	}

	@Test
	public void scrollForRowPutsEveryRowOnScreen()
	{
		for (int visible = 1; visible <= 40; ++visible)
		{
			for (int rows = visible + 1; rows <= visible + 40; ++rows)
			{
				final int maxScroll = rows - visible;
				for (int row = 0; row < rows; ++row)
				{
					final int slot = row - NativeOverlayMenu.scrollForRow(row, visible, maxScroll);
					assertTrue("visible " + visible + " rows " + rows + " row " + row, slot >= 0 && slot < visible);
				}
			}
		}
	}

	// Client menu rect (100, 50, 150x300) drawn visually at (200, 100, 150x300), content scale 1.
	private static final Rectangle CLIENT_MENU = new Rectangle(100, 50, 150, 300);
	private static final Rectangle VISUAL_MENU = new Rectangle(200, 100, 150, 300);

	private static Point outside(int stretchedX, int stretchedY)
	{
		return NativeOverlayMenu.outsideMenuPoint(VISUAL_MENU, CLIENT_MENU, 1, 1, stretchedX, stretchedY, 765, 503);
	}

	@Test
	public void outsideMenuPointWithinCloseDistanceStaysJustOutsideClientMenu()
	{
		// 10px left of the visual menu: the client must not close it yet
		assertEquals(new Point(99, 200), outside(190, 150));
		// 5px right
		assertEquals(new Point(251, 200), outside(354, 150));
	}

	@Test
	public void outsideMenuPointPastCloseDistanceClosesClientMenu()
	{
		// 11px left of the visual menu
		assertEquals(new Point(89, 200), outside(189, 150));
		// 11px right
		assertEquals(new Point(261, 200), outside(349 + 11, 150));
	}

	@Test
	public void outsideMenuPointUsesVerticalDistanceToo()
	{
		// Over the menu horizontally, 11px above it: left side, past the close distance
		assertEquals(new Point(89, 200), outside(210, 89));
		// 10px above: still within the close distance
		assertEquals(new Point(99, 200), outside(210, 90));
		// 11px below, mouse in the right half
		assertEquals(new Point(261, 200), outside(300, 399 + 11));
	}

	@Test
	public void outsideMenuPointMeasuresDistanceInMenuPixels()
	{
		// 2x content scale: 20 stretched px is 10 menu px (no close), 22 is 11 (close)
		final Rectangle dest = new Rectangle(200, 100, 300, 600);
		assertEquals(new Point(99, 200), NativeOverlayMenu.outsideMenuPoint(dest, CLIENT_MENU, 2, 2, 180, 300, 765, 503));
		assertEquals(new Point(89, 200), NativeOverlayMenu.outsideMenuPoint(dest, CLIENT_MENU, 2, 2, 178, 300, 765, 503));
	}

	@Test
	public void outsideMenuPointAvoidsCanvasEdges()
	{
		// Menu at the left edge: left of it is off canvas, so use the right side
		final Rectangle left = new Rectangle(0, 50, 150, 300);
		assertEquals(new Point(151, 200),
			NativeOverlayMenu.outsideMenuPoint(new Rectangle(0, 100, 150, 300), left, 1, 1, 0, 90, 765, 503));
		// Menu at the right edge: the right side is off canvas, so use the left even for a right-side mouse
		final Rectangle right = new Rectangle(615, 50, 150, 300);
		assertEquals(new Point(614, 200),
			NativeOverlayMenu.outsideMenuPoint(new Rectangle(615, 100, 150, 300), right, 1, 1, 760, 90, 765, 503));
	}

	@Test
	public void outsideMenuPointClampsYIntoCanvas()
	{
		// Extended menu: client rect is taller than the canvas, so its centre is off canvas
		final Rectangle tall = new Rectangle(100, 300, 150, 997);
		assertEquals(new Point(99, 502),
			NativeOverlayMenu.outsideMenuPoint(new Rectangle(200, 300, 150, 997), tall, 1, 1, 195, 310, 765, 503));
	}

	@Test
	public void computeMenuDest_fixedAspectNonUniform()
	{
		// s = min(3, 2) = 2; size (200,100); center X on menu center; top-align Y at menu.y*sy
		Rectangle dest = NativeOverlayMenu.computeMenuDest(MENU, 3.0, 2.0, false, true);
		assertEquals(new Rectangle(170, 40, 200, 100), dest);
	}

	@Test
	public void computeMenuDest_fixedAspectTopAlignsOnClick()
	{
		// Aspect-only must not center vertically on the click (that floats the menu too high).
		Rectangle dest = NativeOverlayMenu.computeMenuDest(MENU, 3.0, 2.0, false, true, 800, 600, true, 90, 20);
		assertEquals(new Rectangle(170, 40, 200, 100), dest);
	}

	@Test
	public void computeMenuDest_fixedAspectUniformMatchesDefault()
	{
		Rectangle def = NativeOverlayMenu.computeMenuDest(MENU, 2.0, 2.0, false, false);
		Rectangle aspect = NativeOverlayMenu.computeMenuDest(MENU, 2.0, 2.0, false, true);
		assertEquals(def, aspect);
	}

	@Test
	public void computeMenuDest_nearEdgeCentersOnClickWhenFits()
	{
		// Client clamped menu flush-right, but smaller dest still fits centered on click.
		Rectangle menu = new Rectangle(700, 20, 100, 50);
		Rectangle dest = NativeOverlayMenu.computeMenuDest(menu, 2.0, 2.0, true, true, 800, 600, true, 750, 20);
		assertEquals(1450, dest.x);
		assertEquals(1550, dest.x + dest.width);
	}

	@Test
	public void computeMenuDest_clickPastEdgeClampsOnlyWhenNeeded()
	{
		Rectangle menu = new Rectangle(700, 20, 100, 50);
		Rectangle dest = NativeOverlayMenu.computeMenuDest(menu, 2.0, 2.0, true, true, 800, 600, true, 790, 20);
		assertEquals(1500, dest.x);
		assertEquals(1600, dest.x + dest.width);
	}

	@Test
	public void computeCaptureDest_defaultUsesCaptureBounds()
	{
		Rectangle capture = new Rectangle(0, 10, 200, 80);
		Rectangle root = new Rectangle(40, 20, 100, 50);
		Rectangle dest = NativeOverlayMenu.computeCaptureDest(capture, root, 2.0, 2.0, false, false);
		assertEquals(NativeOverlayMenu.computeMenuDest(capture, 2.0, 2.0, false, false), dest);
	}

	@Test
	public void computeCaptureDest_fixedSizeKeepsRootAnchorWithPad()
	{
		Rectangle capture = new Rectangle(0, 10, 200, 80);
		Rectangle root = new Rectangle(40, 20, 100, 50);
		Rectangle dest = NativeOverlayMenu.computeCaptureDest(capture, root, 3.0, 2.0, true, false);
		Rectangle rootDest = NativeOverlayMenu.computeMenuDest(root, 3.0, 2.0, true, false);
		// content scale X = 150/100 = 1.5, Y = 1
		assertEquals(rootDest.x - (int) Math.round(40 * 1.5), dest.x);
		assertEquals(rootDest.y - 10, dest.y);
		assertEquals(300, dest.width);
		assertEquals(80, dest.height);
		assertEquals(rootDest.x, dest.x + (int) Math.round(40 * 1.5));
	}

	@Test
	public void computeCaptureDest_rootStableWhenCaptureGrowsForSubmenu()
	{
		Rectangle root = new Rectangle(200, 20, 100, 50);
		Rectangle captureBefore = new Rectangle(0, 4, 480, 82); // padded around root
		Rectangle captureAfter = new Rectangle(40, 20, 260, 50); // root + submenu to the left
		Rectangle destBefore = NativeOverlayMenu.computeCaptureDest(captureBefore, root, 2.0, 2.0, true, true);
		Rectangle destAfter = NativeOverlayMenu.computeCaptureDest(captureAfter, root, 2.0, 2.0, true, true);
		Rectangle rootDest = NativeOverlayMenu.computeMenuDest(root, 2.0, 2.0, true, true);

		int rootVisualBefore = destBefore.x + (root.x - captureBefore.x);
		int rootVisualAfter = destAfter.x + (root.x - captureAfter.x);
		assertEquals(rootDest.x, rootVisualBefore);
		assertEquals(rootDest.x, rootVisualAfter);
		assertEquals(rootVisualBefore, rootVisualAfter);
	}
}
