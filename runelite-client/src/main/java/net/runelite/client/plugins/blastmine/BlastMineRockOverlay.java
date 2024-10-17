/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package net.runelite.client.plugins.blastmine;

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ItemID;
import net.runelite.api.NullObjectID;
import net.runelite.api.ObjectID;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;
import net.runelite.client.util.ColorUtil;

public class BlastMineRockOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 16;
	private static final int WARNING_DISTANCE = 1;
	private static final ImmutableSet<Integer> WALL_OBJECTS = ImmutableSet.of(
		NullObjectID.NULL_28570, NullObjectID.NULL_28571, NullObjectID.NULL_28572, NullObjectID.NULL_28573, NullObjectID.NULL_28574,
		NullObjectID.NULL_28575, NullObjectID.NULL_28576, NullObjectID.NULL_28577, NullObjectID.NULL_28578,
		ObjectID.HARD_ROCK, ObjectID.HARD_ROCK_28580, ObjectID.CAVITY, ObjectID.CAVITY_28582,
		ObjectID.POT_OF_DYNAMITE, ObjectID.POT_OF_DYNAMITE_28584, ObjectID.POT_OF_DYNAMITE_28585, ObjectID.POT_OF_DYNAMITE_28586,
		ObjectID.SHATTERED_ROCKFACE, ObjectID.SHATTERED_ROCKFACE_28588);

	private final Client client;
	private final BlastMinePlugin plugin;
	private final BlastMinePluginConfig config;

	private final BufferedImage chiselIcon;
	private final BufferedImage dynamiteIcon;
	private final BufferedImage tinderboxIcon;

	@Inject
	private BlastMineRockOverlay(Client client, BlastMinePlugin plugin, BlastMinePluginConfig config, ItemManager itemManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		chiselIcon = itemManager.getImage(ItemID.CHISEL);
		dynamiteIcon = itemManager.getImage(ItemID.DYNAMITE);
		tinderboxIcon = itemManager.getImage(ItemID.TINDERBOX);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Map<WorldPoint, BlastMineRock> rocks = plugin.getRocks();
		if (rocks.isEmpty())
		{
			return null;
		}

		final Tile[][][] tiles = client.getScene().getTiles();

		for (final BlastMineRock rock : rocks.values())
		{
			if (rock.getGameObject().getCanvasLocation() == null ||
				rock.getGameObject().getWorldLocation().distanceTo(client.getLocalPlayer().getWorldLocation()) > MAX_DISTANCE)
			{
				continue;
			}

			switch (rock.getType())
			{
				case NORMAL:
					drawIconOnRock(graphics, rock, chiselIcon);
					break;
				case CHISELED:
					drawIconOnRock(graphics, rock, dynamiteIcon);
					break;
				case LOADED:
					drawIconOnRock(graphics, rock, tinderboxIcon);
					break;
				case LIT:
					drawTimerOnRock(graphics, rock, config.getTimerColor());
					drawAreaWarning(graphics, rock, config.getWarningColor(), tiles);
					break;
			}
		}

		return null;
	}

	private void drawIconOnRock(Graphics2D graphics, BlastMineRock rock, BufferedImage icon)
	{
		if (!config.showRockIconOverlay())
		{
			return;
		}

		Point loc = Perspective.getCanvasImageLocation(client, rock.getGameObject().getLocalLocation(), icon, 150);

		if (loc != null)
		{
			graphics.drawImage(icon, loc.getX(), loc.getY(), null);
		}
	}

	private void drawTimerOnRock(Graphics2D graphics, BlastMineRock rock, Color color)
	{
		if (!config.showTimerOverlay())
		{
			return;
		}

		Point loc = Perspective.localToCanvas(client, rock.getGameObject().getLocalLocation(), rock.getGameObject().getPlane(), 150);

		if (loc != null)
		{
			final double timeLeft = 1 - rock.getRemainingFuseTimeRelative();
			final ProgressPieComponent pie = new ProgressPieComponent();
			pie.setFill(color);
			pie.setBorderColor(color);
			pie.setPosition(loc);
			pie.setProgress(timeLeft);
			pie.render(graphics);
		}
	}

	private void drawAreaWarning(Graphics2D graphics, BlastMineRock rock, Color color, Tile[][][] tiles)
	{
		if (!config.showWarningOverlay())
		{
			return;
		}

		final int z = client.getPlane();
		int x = rock.getGameObject().getLocalLocation().getX() / Perspective.LOCAL_TILE_SIZE;
		int y = rock.getGameObject().getLocalLocation().getY() / Perspective.LOCAL_TILE_SIZE;
		final int orientation = tiles[z][x][y].getWallObject().getOrientationA();

		switch (orientation) //calculate explosion around the tile in front of the wall
		{
			case 1:
				x--;
				break;
			case 4:
				x++;
				break;
			case 8:
				y--;
				break;
			default:
				y++;
		}

		for (int i = -WARNING_DISTANCE; i <= WARNING_DISTANCE; i++)
		{
			for (int j = -WARNING_DISTANCE; j <= WARNING_DISTANCE; j++)
			{
				final GameObject gameObject = tiles[z][x + i][y + j].getGameObjects()[0];

				//check if tile is empty, or is a wall...
				if (gameObject == null || !WALL_OBJECTS.contains(gameObject.getId()))
				{
					final LocalPoint localTile = new LocalPoint(
						(x + i) * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2,
						(y + j) * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2);
					final Polygon poly = Perspective.getCanvasTilePoly(client, localTile);

					if (poly != null)
					{
						graphics.setColor(ColorUtil.colorWithAlpha(color, (int) (color.getAlpha() / 2.5)));
						graphics.fillPolygon(poly);
					}
				}
			}
		}
	}
}
