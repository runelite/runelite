/*
 * Copyright (c) 2019, Yani <yani@xenokore.com>
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
package net.runelite.client.plugins.pestcontrol;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Singleton
public class RepairOverlay extends Overlay
{
	private final PestControlPlugin plugin;
	private final Client client;

	private static final int MAX_DISTANCE = 2400;

	@Inject
	RepairOverlay(final PestControlPlugin plugin, final Client client)
	{
		this.plugin = plugin;
		this.client = client;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getGame() == null)
		{
			return null;
		}

		Point mousePosition = client.getMouseCanvasPosition();
		Scene scene = client.getScene();
		Color color = plugin.getRepairableColor();
		Tile[][][] tiles = scene.getTiles();
		int z = client.getPlane();

		for (int x = 0; x < Constants.SCENE_SIZE; ++x)
		{
			for (int y = 0; y < Constants.SCENE_SIZE; ++y)
			{
				Tile tile = tiles[z][x][y];

				if (tile == null)
				{
					continue;
				}

				Player player = client.getLocalPlayer();
				if (player == null)
				{
					continue;
				}

				// Render GameObjects
				GameObject[] gameObjects = tile.getGameObjects();
				if (gameObjects != null)
				{
					for (GameObject gameObject : gameObjects)
					{
						if (gameObject == null)
						{
							continue;
						}

						if (PestControlRepairObject.isRepairableId(gameObject.getId()))
						{

							if (player.getLocalLocation().distanceTo(gameObject.getLocalLocation()) <= MAX_DISTANCE)
							{
								renderObjectOverlay(graphics, gameObject.getClickbox(), color, mousePosition);
							}
						}
					}
				}

				// Render GameObject
				GroundObject groundObject = tile.getGroundObject();
				if (groundObject != null)
				{
					if (PestControlRepairObject.isRepairableId(groundObject.getId()))
					{

						if (player.getLocalLocation().distanceTo(groundObject.getLocalLocation()) <= MAX_DISTANCE)
						{
							renderObjectOverlay(graphics, groundObject.getClickbox(), color, mousePosition);
						}
					}
				}

				// Render WallObject
				WallObject wallObject = tile.getWallObject();
				if (wallObject != null)
				{
					if (PestControlRepairObject.isRepairableId(wallObject.getId()))
					{

						if (player.getLocalLocation().distanceTo(wallObject.getLocalLocation()) <= MAX_DISTANCE)
						{
							renderObjectOverlay(graphics, wallObject.getClickbox(), color, mousePosition);
						}
					}
				}
			}
		}







		/*if(plugin.getGame() == null)
		{
			return null;
		}

		Point mousePosition = client.getMouseCanvasPosition();

		List<TileObject> repairList = plugin.getHighlightedRepairList();

		for(TileObject tileObject: repairList)
		{
			//tileObject.getWorldLocation().distanceTo(client.getLocalPlayer().getWorldLocation());

			Polygon polygon = tileObject.getCanvasTilePoly();

			if(polygon != null)
			{
				graphics.setColor(color);
				graphics.setStroke(new BasicStroke(2));
				graphics.drawPolygon(polygon);
				graphics.setColor(setColorAlpha(color, 40));
				graphics.fill(polygon);

				if(polygon.contains(mousePosition.getX(), mousePosition.getY()))
				{
					graphics.setColor(setColorAlpha(color, 65));
					graphics.fill(polygon);
				}
			}
		}
*/
		return null;
	}

	private void renderObjectOverlay(Graphics2D graphics, Shape area, Color color, Point mousePosition)
	{
		if (area == null)
		{
			return;
		}

		graphics.setColor(color);
		graphics.setStroke(new BasicStroke(2));
		graphics.draw(area);
		graphics.setColor(setColorAlpha(color, 50));
		graphics.fill(area);

		if (area.contains(mousePosition.getX(), mousePosition.getY()))
		{
			graphics.setColor(setColorAlpha(color, 60));
			graphics.fill(area);
		}
	}

	private Color setColorAlpha(Color color, int alpha)
	{
		return new Color(
			color.getRed(),
			color.getGreen(),
			color.getBlue(),
			alpha
		);
	}
}
