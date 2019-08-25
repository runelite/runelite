/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TextComponentTest
{
	private Graphics2D graphics;
	private BufferedImage dest;

	@Before
	public void before()
	{
		dest = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) dest.getGraphics();
	}

	@Test
	public void testRender()
	{
		TextComponent textComponent = new TextComponent();
		textComponent.setText("test");
		textComponent.setColor(Color.RED);
		textComponent.render(graphics);
	}

	@Test
	public void testRender2()
	{
		TextComponent textComponent = new TextComponent();
		textComponent.setText("<col=0000ff>test");
		textComponent.render(graphics);
	}

	@Test
	public void testRender3()
	{
		TextComponent textComponent = new TextComponent();
		textComponent.setText("<col=0000ff>test<col=00ff00> test");
		textComponent.render(graphics);
	}

	@After
	public void after()
	{
		graphics.dispose();
		dest.flush();
	}

}
