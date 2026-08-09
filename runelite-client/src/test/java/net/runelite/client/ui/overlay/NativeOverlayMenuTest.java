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

import java.awt.Rectangle;
import static org.junit.Assert.assertEquals;
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
