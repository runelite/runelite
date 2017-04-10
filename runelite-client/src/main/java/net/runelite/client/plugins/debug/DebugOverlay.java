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
package net.runelite.client.plugins.debug;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.GroundObject;
import net.runelite.api.Point;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.WallObject;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

public class DebugOverlay extends Overlay
{
	private static final Client client = RuneLite.getClient();

	private static final int REGION_SIZE = 104;

	public DebugOverlay()
	{
		super(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		Region region = client.getRegion();
		Tile[][][] tiles = region.getTiles();

		int z = client.getPlane();

		for (int x = 0; x < REGION_SIZE; ++x)
		{
			for (int y = 0; y < REGION_SIZE; ++y)
			{
				Tile tile = tiles[z][x][y];

				if (tile == null)
				{
					continue;
				}

				render(graphics, tile);
			}
		}

		return null;
	}

	private void render(Graphics2D graphics, Tile tile)
	{
		renderDecorativeObject(graphics, tile);
		renderWallObject(graphics, tile);
		renderGroundObject(graphics, tile);
		renderGameObjects(graphics, tile);
	}

	private void renderDecorativeObject(Graphics2D graphics, Tile tile)
	{
		DecorativeObject decorativeObject = tile.getDecorativeObject();
		if (decorativeObject == null)
		{
			return;
		}

		int id = decorativeObject.getId();
		renderTileObject(graphics, decorativeObject, Color.RED, "D" + id);
	}

	private void renderWallObject(Graphics2D graphics, Tile tile)
	{
		WallObject wallObject = tile.getWallObject();
		if (wallObject == null)
		{
			return;

		}

		int id = wallObject.getId();
		renderTileObject(graphics, wallObject, Color.GREEN, "W" + id);
	}

	private void renderGroundObject(Graphics2D graphics, Tile tile)
	{
		GroundObject groundObject = tile.getGroundObject();
		if (groundObject == null)
		{
			return;

		}

		int id = groundObject.getId();
		renderTileObject(graphics, groundObject, Color.BLUE, "G" + id);
	}

	private void renderGameObjects(Graphics2D graphics, Tile tile)
	{
		GameObject[] gameObjects = tile.getGameObjects();
		if (gameObjects == null)
		{
			return;
		}

		for (GameObject gameObject : gameObjects)
		{
			if (gameObject == null)
			{
				continue;
			}

			renderTileObject(graphics, gameObject, Color.YELLOW, "GA" + gameObject.getId());
		}
	}

	private void renderTileObject(Graphics2D graphics, TileObject tileObject, Color color, String text)
	{
		Point canvasLocation = tileObject.getCanvasLocation();

		if (canvasLocation == null)
		{
			return;
		}

		graphics.setColor(color);
		graphics.drawString(text, canvasLocation.getX(), canvasLocation.getY());
	}
}
