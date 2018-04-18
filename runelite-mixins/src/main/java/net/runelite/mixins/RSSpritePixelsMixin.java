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
package net.runelite.mixins;

import java.awt.image.BufferedImage;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSSpritePixels;

@Mixin(RSSpritePixels.class)
public abstract class RSSpritePixelsMixin implements RSSpritePixels
{
	@Inject
	@Override
	public BufferedImage toBufferedImage()
	{
		int width = getWidth();
		int height = getHeight();
		int[] pixels = getPixels();
		int[] transPixels = new int[pixels.length];
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < pixels.length; i++)
		{
			if (pixels[i] != 0)
			{
				transPixels[i] = pixels[i] | 0xff000000;
			}
		}

		img.setRGB(0, 0, width, height, transPixels, 0, width);
		return img;
	}
	
	@Inject
	@Override
	public void removeOutline(int outlineColor) {
		int[] pixels = new int[this.getWidth() * this.getHeight()];
		int pixelSpot = 0;
		
		for(int y = 0; y < this.getHeight(); ++y) {
			for(int x = 0; x < this.getWidth(); ++x) {
				int pixel = this.getPixels()[pixelSpot];
				if(pixel == outlineColor) {
					if(x > 0 && this.getPixels()[pixelSpot - 1] != 0) {
						pixel = 0;
					} else if(y > 0 && this.getPixels()[pixelSpot - this.getWidth()] != 0) {
						pixel = 0;
					} else if(x < this.getWidth() - 1 && this.getPixels()[pixelSpot + 1] != 0) {
						pixel = 0;
					} else if(y < this.getHeight() - 1 && this.getPixels()[pixelSpot + this.getWidth()] != 0) {
						pixel = 0;
					}
				}
				
				pixels[pixelSpot++] = pixel;
			}
		}
		
		for (int i = 0; i < this.getWidth() * this.getHeight(); i++)
		{
			this.getPixels()[i] = pixels[i];
		}
	}
}
