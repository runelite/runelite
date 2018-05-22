/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.plugins.cluescrolls;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;

class ClueScrollWorldMapPoint extends WorldMapPoint
{
	private static final BufferedImage CLUE_SCROLL_WORLD_IMAGE;
	private static final BufferedImage CLUE_SCROLL_WORLD_IMAGE_EDGE;
	private static final Point CLUE_SCROLL_WORLD_IMAGE_POINT;
	static
	{
		CLUE_SCROLL_WORLD_IMAGE = new BufferedImage(ClueScrollPlugin.MAP_ARROW.getWidth(), ClueScrollPlugin.MAP_ARROW.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = CLUE_SCROLL_WORLD_IMAGE.getGraphics();
		graphics.drawImage(ClueScrollPlugin.MAP_ARROW, 0, 0, null);
		graphics.drawImage(ClueScrollPlugin.CLUE_SCROLL_IMAGE, 0, 2, null);
		CLUE_SCROLL_WORLD_IMAGE_POINT = new Point(
			CLUE_SCROLL_WORLD_IMAGE.getWidth() / 2,
			CLUE_SCROLL_WORLD_IMAGE.getHeight());

		CLUE_SCROLL_WORLD_IMAGE_EDGE = new BufferedImage(ClueScrollPlugin.MAP_EDGE_BOX.getWidth(), ClueScrollPlugin.MAP_EDGE_BOX.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics graphics2 = CLUE_SCROLL_WORLD_IMAGE_EDGE.getGraphics();
		graphics2.drawImage(ClueScrollPlugin.MAP_EDGE_BOX, 0, 0, null);
		graphics2.drawImage(ClueScrollPlugin.CLUE_SCROLL_IMAGE, 0, 2, null);
	}

	ClueScrollWorldMapPoint(final WorldPoint worldPoint)
	{
		super(worldPoint, null);

		this.setSnapToEdge(true);
		this.setJumpOnClick(true);
		this.setImage(CLUE_SCROLL_WORLD_IMAGE);
		this.setImagePoint(CLUE_SCROLL_WORLD_IMAGE_POINT);
	}

	@Override
	public void onEdgeSnap(boolean[] directions)
	{
		boolean north = directions[0];
		boolean south = directions[1];
		boolean east = directions[2];
		boolean west = directions[3];
		this.setImage(CLUE_SCROLL_WORLD_IMAGE_EDGE);
		edgeSnapImageHandler(north, south, east, west, CLUE_SCROLL_WORLD_IMAGE_EDGE);
	}

	@Override
	public void onEdgeUnsnap()
	{
		this.setImage(CLUE_SCROLL_WORLD_IMAGE);
		this.setImagePoint(CLUE_SCROLL_WORLD_IMAGE_POINT);
	}

	@Override
	public void edgeSnapImageHandler(boolean north, boolean south, boolean east, boolean west, BufferedImage image)
	{
		if (north && east)
		{
			this.setImagePoint(new Point(image.getWidth(), image.getHeight()));
		}
		else if (north && west)
		{
			this.setImagePoint(new Point(0, image.getHeight()));
		}
		else if (south && east)
		{
			this.setImagePoint(new Point(image.getWidth(), 0));
		}
		else if (south && west)
		{
			this.setImagePoint(new Point(0, 0));
		}
		else if (north)
		{
			this.setImagePoint(new Point(0, image.getHeight()));
		}
		else if (south)
		{
			this.setImagePoint(new Point(0, 0));
		}
		else if (east)
		{
			this.setImagePoint(new Point(image.getWidth(), image.getHeight()));
		}
		else if (west)
		{
			this.setImagePoint(new Point(0, image.getHeight()));
		}
	}
}
