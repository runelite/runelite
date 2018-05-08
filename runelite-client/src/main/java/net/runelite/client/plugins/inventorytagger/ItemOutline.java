/*
 * Copyright (c) 2018 kulers
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
package net.runelite.client.plugins.inventorytagger;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.SpritePixels;

@RequiredArgsConstructor
class ItemOutline
{
	private BufferedImage generatedPicture = new BufferedImage(36, 36, BufferedImage.TYPE_INT_ARGB);
	public static Map<String, BufferedImage> storedOutlines = new HashMap<>();
	private final Client client;
	private final int id;
	private final int stroke;
	private final Color color;

	private String getStringGeneratedId()
	{
		return this.id + "." + this.stroke + "." + this.color.getRGB();
	}

	public BufferedImage getPicture()
	{
		if (storedOutlines.containsKey(getStringGeneratedId()))
		{
			return storedOutlines.get(getStringGeneratedId());
		}

		SpritePixels itemSprite = client.createItemSprite(id, 1, this.stroke, 0, 0, true, 710);
		itemSprite.setOutline(16777215);

		Graphics2D graphics2D = this.generatedPicture.createGraphics();
		graphics2D.setColor(this.color);
		int x = 0;
		int y = 0;
		for (int pixelColor : itemSprite.getPixels())
		{
			if (x == 36)
			{
				y++;
				x = 0 ;
			}

			if (pixelColor == 16777215)
			{
				graphics2D.drawLine(x, y, x, y);
			}

			x++;
		}
		storedOutlines.put(getStringGeneratedId(), this.generatedPicture);
		return this.generatedPicture;
	}
}
