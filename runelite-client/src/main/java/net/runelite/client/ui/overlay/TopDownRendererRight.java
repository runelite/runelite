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
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.client.RuneLite;

public class TopDownRendererRight implements Renderer
{
	private static final int BORDER_TOP = 0;
	private static final int BORDER_RIGHT = 10; //TODO: Make setting
	private static final int PADDING = 10;

	private final List<Overlay> overlays = new ArrayList<>();

	public void add(Overlay overlay)
	{
		overlays.add(overlay);
	}

	@Override
	public void render(BufferedImage clientBuffer)
	{
		Client client = RuneLite.getClient();
		overlays.sort((o1, o2) -> o2.getPriority().compareTo(o1.getPriority()));

		int y = BORDER_TOP;
		int clientWidth = client.getClientWidth();
		int clientHeight = client.getClientHeight();

		for (Overlay overlay : overlays)
		{
			BufferedImage image = new BufferedImage(clientWidth, clientHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics2D graphics = image.createGraphics();
			Renderer.setAntiAliasing(graphics);
			Dimension dimension = overlay.render(graphics);
			graphics.dispose();

			if (dimension == null)
			{
				continue;
			}

			image = image.getSubimage(0, 0, (int) dimension.getWidth(), (int) dimension.getHeight());

			graphics = clientBuffer.createGraphics();
			graphics.drawImage(image, clientWidth - BORDER_RIGHT - (int) dimension.getWidth(), y, null);
			graphics.dispose();

			y += dimension.getHeight() + PADDING;
		}
	}

}
