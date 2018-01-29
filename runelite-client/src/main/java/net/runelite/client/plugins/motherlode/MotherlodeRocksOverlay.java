/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Arrays;
import java.util.List;

import static net.runelite.api.ObjectID.ORE_VEIN_26661;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import static net.runelite.api.ObjectID.ROCKFALL;
import static net.runelite.api.ObjectID.ROCKFALL_26680;

class MotherlodeRocksOverlay extends Overlay
{
	private static final int REGION_SIZE = 104;
	private static final int MAX_DISTANCE = 2350;

	private static final List<Integer> MINE_SPOTS = Arrays.asList(ORE_VEIN_26661, ORE_VEIN_26662, ORE_VEIN_26663, ORE_VEIN_26664);

	private static final List<Integer> ROCK_OBSTACLES = Arrays.asList(ROCKFALL, ROCKFALL_26680);

	private final Client client;
	private final MotherlodePlugin plugin;
	private final MotherlodeConfig config;

	@Inject
	MotherlodeRocksOverlay(Client client, MotherlodePlugin plugin, MotherlodeConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (!config.enabled() || !config.showRocks())
		{
			return null;
		}

		Player local = client.getLocalPlayer();

		//Render mining spot
		renderTiles(graphics, local);

		return null;
	}

	private void renderTiles(Graphics2D graphics, Player local)
	{
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
				if (local.getLocalLocation().distanceTo(tile.getLocalLocation()) <= MAX_DISTANCE)
				{
					renderMine(graphics, tile);
				}
			}
		}
	}

	private void renderMine(Graphics2D graphics, Tile tile)
	{
		//Draw the Pay-dirt spots
		WallObject wallObject = tile.getWallObject();
		if (wallObject != null && MINE_SPOTS.contains(wallObject.getId()))
		{
			net.runelite.api.Point canvasLoc = Perspective.getCanvasImageLocation(client, graphics, wallObject.getLocalLocation(), plugin.getMineIcon(), 150);

			if (canvasLoc != null)
			{
				graphics.drawImage(plugin.getMineIcon(), canvasLoc.getX(), canvasLoc.getY(), null);
				return;
			}
		}

		//Draw the rock obstacles
		GameObject[] gameObjects = tile.getGameObjects();
		for (GameObject gameObject : gameObjects)
		{
			if (gameObject != null && ROCK_OBSTACLES.contains(gameObject.getId()))
			{
				Polygon poly = Perspective.getCanvasTilePoly(client, gameObject.getLocalLocation());

				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, Color.red);
				}
			}
		}
	}
}
