/*
 * Copyright (c) 2017. l2-
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.volcanicmine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

@Slf4j
public class VolcanicMineOverlay extends Overlay
{
	private static final int THRESH_LOW = 45;
	private static final int THRESH_MED = 5;

	private static final int MAX_DISTANCE = 19; //2400/128 rounded up
	private static final int REGION_SIZE = 104;
	private static final int Z_OFFSET_TIMER = 25;
	private static final String PROTECT_MESSAGE = "Protect!";

	private final VolcanicMinePlugin plugin;
	private final VolcanicMineConfig config;

	private final Client client;
	private Image protectFromMissilesImg;

	@Inject
	VolcanicMineOverlay(@Nullable Client client, VolcanicMinePlugin plugin, VolcanicMineConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point point)
	{
		if (!plugin.getInside() || !config.enabled())
		{
			return null;
		}

		renderTileObjects(graphics);
		renderRangePrayer(graphics);
		return null;
	}

	private void renderRangePrayer(Graphics2D graphics)
	{
		if (client.getViewportWidget() == null || !plugin.getDrawRangePray() || !config.prayerHelperEnabled())
		{
			return;
		}

		Image protectFromMissiles = getProtectFromMissilesImage();
		if (protectFromMissiles == null)
		{
			return;
		}

		Rectangle viewport = client.getViewportWidget().getBounds();
		Rectangle stringBounds = graphics.getFontMetrics().getStringBounds(PROTECT_MESSAGE, graphics).getBounds();
		int x = (int) (viewport.getX() + viewport.getWidth());
		int y = (int) (viewport.getY() + viewport.getHeight());
		int width = (int) stringBounds.getWidth() + 6;
		int height = (int) (protectFromMissiles.getHeight(null) + stringBounds.getHeight()) + 5;
		Rectangle rectangle = new Rectangle(x - width, y - height, width, height);
		graphics.setColor(new Color(255, 255, 255, 150));
		graphics.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		graphics.setColor(client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES) ? Color.GREEN : Color.WHITE);
		graphics.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		graphics.drawImage(protectFromMissiles, x - protectFromMissiles.getWidth(null) - 10, y - protectFromMissiles.getHeight(null) - 15, null);
		graphics.drawString(PROTECT_MESSAGE, x - (int) stringBounds.getWidth() - 2, y);
	}

	//this is less efficient than drawing from the map however this is more accurate as it doesn't draw false positives (tiles which are not in the current region).
	private void renderTileObjects(Graphics2D graphics)
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
				renderPaths(graphics, tile);
				renderGameObjects(graphics, tile);
			}
		}
	}

	private void renderPaths(Graphics2D graphics, Tile tile)
	{
		if (config.optimalPaths() && !plugin.getObjectTimerMap().containsKey(tile))
		{
			Point worldLoc = tile.getWorldLocation();
			if (client.getLocalPlayer().getWorldLocation().distanceTo(worldLoc) > MAX_DISTANCE)
			{
				return;
			}

			if (OptimalPaths.isOptimalPathTile(worldLoc))
			{
				Point localTile = tile.getLocalLocation();
				localTile = new Point(localTile.getX() + Perspective.LOCAL_TILE_SIZE / 2, localTile.getY() + Perspective.LOCAL_TILE_SIZE / 2);
				Polygon poly = Perspective.getCanvasTilePoly(client, localTile);
				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, Color.CYAN);
				}
			}
			else if (OptimalPaths.isBoulderRangeTile(worldLoc))
			{
				Point localTile = tile.getLocalLocation();
				localTile = new Point(localTile.getX() + Perspective.LOCAL_TILE_SIZE / 2, localTile.getY() + Perspective.LOCAL_TILE_SIZE / 2);
				Polygon poly = Perspective.getCanvasTilePoly(client, localTile);
				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, Color.MAGENTA);
				}
			}
		}
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
			if (gameObject != null && plugin.getObjectTimerMap().containsKey(tile) && config.timerOverlay())
			{
				Duration duration = Duration.between(Instant.now(), plugin.getObjectTimerMap().get(tile));
				if (!duration.isNegative())
				{
					long seconds = duration.getSeconds();
					int minutes = (int) seconds / 60;
					String text = String.format("%d:%02d", minutes, seconds % 60); // format as m:ss
					Color color;
					if (seconds > THRESH_LOW)
					{
						color = config.platformColorLow();
					}
					else if (seconds > THRESH_MED)
					{
						color = config.platformColorMed();
					}
					else
					{
						color = config.platformColorHigh();
					}

					Point location = gameObject.getCanvasTextLocation(graphics, text, Z_OFFSET_TIMER);
					if (location != null)
					{
						OverlayUtil.renderTextLocation(graphics, location, text, color);
						return; //only 1 timer per tile
					}
				}
			}
		}
	}

	public Image getProtectFromMissilesImage()
	{
		if (protectFromMissilesImg == null)
		{
			String path = "/prayers/protect_from_missiles.png";
			protectFromMissilesImg = getImage(path);
		}
		return protectFromMissilesImg;
	}

	private Image getImage(String path)
	{
		Image image = null;
		try
		{
			InputStream in = VolcanicMineOverlay.class.getResourceAsStream(path);
			image = ImageIO.read(in);
		}
		catch (IOException e)
		{
			log.warn("Error loading image", e);
		}
		return image;
	}
}
