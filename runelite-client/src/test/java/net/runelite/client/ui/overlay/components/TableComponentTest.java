/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.ui.overlay.components;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import net.runelite.client.ui.overlay.components.TableComponent.TableAlignment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TableComponentTest
{
	@Mock
	private Graphics2D graphics;

	@Before
	public void before()
	{
		when(graphics.getFontMetrics()).thenReturn(mock(FontMetrics.class));
	}

	@Test
	public void testRender()
	{
		TableComponent tableComponent = new TableComponent();
		tableComponent.addRow("test");
		tableComponent.setDefaultAlignment(TableAlignment.CENTER);
		tableComponent.setDefaultColor(Color.RED);
		tableComponent.render(graphics);
		verify(graphics, times(2)).drawString(eq("test"), anyInt(), anyInt());
		verify(graphics, atLeastOnce()).setColor(Color.RED);
	}

	@Test
	public void testColors()
	{
		TableComponent tableComponent = new TableComponent();
		tableComponent.addRow("test", "test", "test", "<col=ffff00>test", "test");
		tableComponent.setColumnColors(Color.RED, Color.GREEN, Color.BLUE);
		tableComponent.render(graphics);
		verify(graphics, atLeastOnce()).setColor(Color.RED);
		verify(graphics, atLeastOnce()).setColor(Color.GREEN);
		verify(graphics, atLeastOnce()).setColor(Color.BLUE);
		verify(graphics, atLeastOnce()).setColor(Color.YELLOW);
		verify(graphics, atLeastOnce()).setColor(Color.WHITE);
	}
}
