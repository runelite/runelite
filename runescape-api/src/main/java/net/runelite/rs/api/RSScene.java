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
package net.runelite.rs.api;

import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.mapping.Import;

public interface RSScene extends Scene
{
	@Import("objects")
	RSGameObject[] getObjects();

	@Import("tiles")
	@Override
	RSTile[][][] getTiles();

	@Import("draw")
	void draw(Tile tile, boolean var2);

	@Import("tileHeights")
	int[][][] getTileHeights();

	@Import("drawTile")
	void drawTile(int[] pixels, int pixelOffset, int width, int z, int x, int y);

	@Import("updateOccluders")
	void updateOccluders();

	@Import("maxX")
	int getMaxX();

	@Import("maxY")
	int getMaxY();

	@Import("maxZ")
	int getMaxZ();

	@Import("minLevel")
	int getMinLevel();
}
