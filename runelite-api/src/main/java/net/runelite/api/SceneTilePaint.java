/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

/**
 * Represents the paint of a tile in the current scene.
 */
public interface SceneTilePaint
{
	/**
	 * Gets the RGB value of the paint.
	 *
	 * @return the paint RGB
	 */
	int getRBG();

	/**
	 * Gets the color of the south-west corner of the tile.
	 * Used to render a Gouraud-shaded gradient along the tile plane in the scene.
	 *
	 * @return the south-west corner of the tile
	 */
	int getSwColor();

	/**
	 * Sets the color of the south-west corner of the tile.
	 * Used to render a Gouraud-shaded gradient along the tile plane in the scene.
	 *
	 * @param color the new color for the south-west corner of the tile
	 */
	void setSwColor(int color);

	/**
	 * Gets the color of the south-east corner of the tile.
	 * Used to render a Gouraud-shaded gradient along the tile plane in the scene.
	 *
	 * @return the south-east corner of the tile
	 */
	int getSeColor();

	/**
	 * Sets the color of the south-east corner of the tile.
	 * Used to render a Gouraud-shaded gradient along the tile plane in the scene.
	 *
	 * @param color the new color for the south-east corner of the tile
	 */
	void setSeColor(int color);

	/**
	 * Gets the color of the north-west corner of the tile.
	 * Used to render a Gouraud-shaded gradient along the tile plane in the scene.
	 *
	 * @return the north-west corner of the tile
	 */
	int getNwColor();

	/**
	 * Sets the color of the north-west corner of the tile.
	 * Used to render a Gouraud-shaded gradient along the tile plane in the scene.
	 *
	 * @param color the new color for the north-west corner of the tile
	 */
	void setNwColor(int color);

	/**
	 * Gets the color of the north-east corner of the tile.
	 * Used to render a Gouraud-shaded gradient along the tile plane in the scene.
	 *
	 * @return the north-east corner of the tile
	 */
	int getNeColor();

	/**
	 * Sets the color of the north-east corner of the tile.
	 * Used to render a Gouraud-shaded gradient along the tile plane in the scene.
	 *
	 * @param color the new color for the north-east corner of the tile
	 */
	void setNeColor(int color);

	/**
	 * Gets the texture to be rendered for the tile.
	 * When set, the texture will be drawn instead of a 4-point color gradient.
	 *
	 * @return the texture id to draw on the tile
	 */
	int getTexture();

	/**
	 * Sets the texture to be rendered for the tile.
	 * When set, the texture will be drawn instead of a 4-point color gradient.
	 *
	 * @param texture the texture id to be drawn on the tile
	 */
	void setTexture(int texture);

	boolean isFlat();

	int getBufferOffset();
	void setBufferOffset(int bufferOffset);

	int getUvBufferOffset();
	void setUvBufferOffset(int bufferOffset);

	int getBufferLen();
	void setBufferLen(int bufferLen);
}
