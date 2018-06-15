/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class OverlayManagerTest
{
	class TestOverlay extends Overlay
	{
		TestOverlay(OverlayPosition position, OverlayPriority priority)
		{
			setPosition(position);
			setPriority(priority);
		}

		@Override
		public Dimension render(Graphics2D graphics)
		{
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	private static class OverlayA extends Overlay
	{
		@Override
		public Dimension render(Graphics2D graphics)
		{
			return null;
		}
	}

	private static class OverlayB extends Overlay
	{
		@Override
		public Dimension render(Graphics2D graphics)
		{
			return null;
		}
	}

	@Test
	public void testEquality()
	{
		Overlay a1 = new OverlayA();
		Overlay a2 = new OverlayA();
		Overlay b = new OverlayB();
		// The same instance of the same overlay should be equal
		assertTrue(a1.equals(a1));
		// A different instance of the same overlay should not be equal by default
		assertFalse(a1.equals(a2));
		// A different instance of a different overlay should not be equal
		assertFalse(a1.equals(b));
	}

	@Test
	public void testSort()
	{
		// High priorities overlays render first
		Overlay tlh = new TestOverlay(OverlayPosition.TOP_LEFT, OverlayPriority.HIGH);
		Overlay tll = new TestOverlay(OverlayPosition.TOP_LEFT, OverlayPriority.LOW);
		List<Overlay> overlays = Arrays.asList(tlh, tll);
		overlays.sort(OverlayManager.OVERLAY_COMPARATOR);
		assertEquals(tlh, overlays.get(0));
		assertEquals(tll, overlays.get(1));
	}

	@Test
	public void testSortDynamic()
	{
		// Dynamic overlays render before static overlays
		Overlay tlh = new TestOverlay(OverlayPosition.TOP_LEFT, OverlayPriority.HIGH);
		Overlay dyn = new TestOverlay(OverlayPosition.DYNAMIC, OverlayPriority.HIGH);
		List<Overlay> overlays = Arrays.asList(tlh, dyn);
		overlays.sort(OverlayManager.OVERLAY_COMPARATOR);
		assertEquals(dyn, overlays.get(0));
		assertEquals(tlh, overlays.get(1));
	}

	@Test
	public void testTooltips()
	{
		// Tooltip overlay renders after everything
		Overlay t = new TestOverlay(OverlayPosition.TOOLTIP, OverlayPriority.HIGH);
		Overlay dyn = new TestOverlay(OverlayPosition.DYNAMIC, OverlayPriority.HIGH);
		Overlay tlh = new TestOverlay(OverlayPosition.TOP_LEFT, OverlayPriority.HIGH);
		List<Overlay> overlays = Arrays.asList(t, dyn, tlh);
		overlays.sort(OverlayManager.OVERLAY_COMPARATOR);
		assertEquals(dyn, overlays.get(0));
		assertEquals(tlh, overlays.get(1));
		assertEquals(t, overlays.get(2));
	}

}
