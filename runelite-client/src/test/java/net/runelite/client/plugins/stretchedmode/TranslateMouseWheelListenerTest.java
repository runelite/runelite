/*
 * Copyright (c) 2026, MoonBoi9001 <https://github.com/MoonBoi9001>
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
package net.runelite.client.plugins.stretchedmode;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import net.runelite.api.Client;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TranslateMouseWheelListenerTest
{
	@Test
	public void testKeepsPreciseRotation()
	{
		final Client client = mock(Client.class);
		when(client.getStretchedDimensions()).thenReturn(new Dimension(1000, 800));
		when(client.getRealDimensions()).thenReturn(new Dimension(500, 400));

		// A trackpad scrolls in fractions of a wheel notch, which trackpad gestures in other plugins rely on
		final MouseWheelEvent event = new MouseWheelEvent(new Canvas(), MouseEvent.MOUSE_WHEEL, 0, 0, 200, 100, 200, 100,
			0, false, MouseWheelEvent.WHEEL_UNIT_SCROLL, 1, 0, 0.3);
		final MouseWheelEvent translated = new TranslateMouseWheelListener(client).mouseWheelMoved(event);

		assertEquals(100, translated.getX());
		assertEquals(50, translated.getY());
		assertEquals(0.3, translated.getPreciseWheelRotation(), 0);
	}
}
