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

package net.runelite.inject.callbacks;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.OverlayRenderer;

public class RSCanvasCallback
{
	private static final int WIDTH = 765, HEIGHT = 503;
	
	private BufferedImage clientBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage gameBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	public Graphics getGraphics(Canvas canvas, Graphics superGraphics)
	{
		if (canvas.getHeight() != clientBuffer.getHeight() || canvas.getWidth() != clientBuffer.getWidth())
		{
			clientBuffer = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
			gameBuffer = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
		}

		Graphics clientGraphics = clientBuffer.getGraphics();
		clientGraphics.drawImage(gameBuffer, 0, 0, null);
		clientGraphics.dispose();

		RuneLite runelite = RuneLite.getRunelite();
		if (runelite != null)
		{
			OverlayRenderer renderer = runelite.getRenderer();
			if (renderer != null)
			{
				renderer.render(clientBuffer);
			}
		}

		superGraphics.drawImage(clientBuffer, 0, 0, null);

		return gameBuffer.getGraphics();
	}
}
