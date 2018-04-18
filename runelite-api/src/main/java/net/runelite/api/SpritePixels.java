/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package net.runelite.api;

import java.awt.image.BufferedImage;

public interface SpritePixels
{
	int DEFAULT_SHADOW_COLOR = 3153952;

	void drawAt(int x, int y);

	int getWidth();

	int getHeight();

	int[] getPixels();
	
	/**
	 * Draws the outline for a sprite with a given color
	 * Make sure to call removeOutline after using the SpritePixels
	 * @param outlineColor
	 */
	void setOutline(int outlineColor);
	
	/**
	 * This will take the outline off of the sprite.
	 * This MUST be called anytime when using the setOutline
	 * method after being drawn or else the outline will keep
	 * drawing on top of itself.
	 * @param outlineColor
	 */
	void removeOutline(int outlineColor);

	/**
	 * Covert the SpritePixels to a BufferedImage
	 *
	 * @return
	 */
	BufferedImage toBufferedImage();
}
