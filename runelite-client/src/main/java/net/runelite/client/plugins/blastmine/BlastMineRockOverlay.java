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

import com.google.common.collect.Sets;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPie;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Set;

public class BlastMineRockOverlay extends Overlay
{
	private static final int TIMER_SIZE = 25;
	private static final int TIMER_BORDER_WIDTH = 1;
	private static final int MAX_DISTANCE = 16;
	private static final int WARNING_DISTANCE = 2;
	private static final Set<Integer> WALL_OBJECTS = Collections.unmodifiableSet(Sets.newHashSet(ObjectID.NULL_28570, ObjectID.NULL_28571, ObjectID.NULL_28572, ObjectID.NULL_28573, ObjectID.NULL_28574,
			ObjectID.NULL_28575, ObjectID.NULL_28576, ObjectID.NULL_28577, ObjectID.NULL_28578, ObjectID.HARD_ROCK, ObjectID.HARD_ROCK_28580,
			ObjectID.CAVITY, ObjectID.CAVITY_28582, ObjectID.POT_OF_DYNAMITE, ObjectID.POT_OF_DYNAMITE_28584, ObjectID.POT_OF_DYNAMITE_28585,
			ObjectID.POT_OF_DYNAMITE_28586, ObjectID.SHATTERED_ROCKFACE, ObjectID.SHATTERED_ROCKFACE_28588));

	private final Client client;
	private final BlastMinePlugin plugin;
	private final BlastMinePluginConfig config;
	private final ItemManager itemManager;

	private Color timerColor;
	private Color timerBorderColor;
	private Color warningColor;

	@Inject
	BlastMineRockOverlay(@Nullable Client client, BlastMinePlugin plugin, BlastMinePluginConfig config, ItemManager itemManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		plugin.getRocks().removeIf(rock -> (rock.getRemainingTimeRelative() == 1 && rock.getType() != BlastMineRockType.NORMAL) || (rock.getRemainingFuseTimeRelative() == 1 && rock.getType() == BlastMineRockType.LIT));
		drawRocks(graphics);
		return null;
	}

	public void updateColors()
	{
		timerColor = config.getTimerFillColor();
		timerBorderColor = config.getTimerBorderColor();
		warningColor = config.getWarningColor();
	}

	private void drawRocks(Graphics2D graphics)
	{
		Tile[][][] tiles = client.getRegion().getTiles();
		BufferedImage chiselIcon = itemManager.getImage(ItemID.CHISEL);
		BufferedImage dynamiteIcon = itemManager.getImage(ItemID.DYNAMITE);
		BufferedImage tinderboxIcon = itemManager.getImage(ItemID.TINDERBOX);
		Widget viewport = client.getViewportWidget();
		for (BlastMineRock rock : plugin.getRocks())
		{
			if (viewport != null && rock.getGameObject().getCanvasLocation() != null
				&& rock.getGameObject().getWorldLocation().distanceTo(client.getLocalPlayer().getWorldLocation()) <= MAX_DISTANCE)
			{
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
						drawTimerOnRock(graphics, rock, timerColor, timerBorderColor);
						drawAreaWarning(graphics, rock, warningColor, tiles);
						break;
				}
			}
		}
	}

	private void drawIconOnRock(Graphics2D graphics, BlastMineRock rock, BufferedImage icon)
	{
		net.runelite.api.Point loc = Perspective.getCanvasImageLocation(client, graphics, rock.getGameObject().getLocalLocation(), icon, 150);
		if (loc != null && config.showRockIconOverlay())
		{
			graphics.drawImage(icon, loc.getX(), loc.getY(), null);
		}
	}

	private void drawTimerOnRock(Graphics2D graphics, BlastMineRock rock, Color fillColor, Color borderColor)
	{
		net.runelite.api.Point loc = Perspective.worldToCanvas(client, rock.getGameObject().getX(), rock.getGameObject().getY(), client.getPlane(), 150);

		if (loc != null && config.showTimerOverlay())
		{
			double timeLeft = 1 - rock.getRemainingFuseTimeRelative();
			Point position = new Point((loc.getX() - TIMER_SIZE / 2 ) + 10, (loc.getY() - TIMER_SIZE / 2) + 10);
			ProgressPie pie = new ProgressPie();
			pie.setFill(fillColor);
			pie.setBorderColor(borderColor);
			pie.render(graphics, position, timeLeft);
		}
	}

	private void drawAreaWarning(Graphics2D graphics, BlastMineRock rock, Color color, Tile[][][] tiles)
	{
		if (!config.showWarningOverlay())
		{
			return;
		}
		int z = client.getPlane();
		int x = rock.getGameObject().getLocalLocation().getX() / Perspective.LOCAL_TILE_SIZE;
		int y = rock.getGameObject().getLocalLocation().getY() / Perspective.LOCAL_TILE_SIZE;
		int orientation = tiles[z][x][y].getWallObject().getOrientationA();

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
				GameObject gameObject = tiles[z][x + i][y + j].getGameObjects()[0];
				//check if tile is empty, or is a wall...
				if (gameObject == null  || !WALL_OBJECTS.contains(gameObject.getId()))
				{
					LocalPoint localTile = new LocalPoint(
							(x + i) * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2,
							(y + j) * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2);
					Polygon poly = Perspective.getCanvasTilePoly(client, localTile);
					if (poly != null)
					{
						graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 100));
						graphics.fillPolygon(poly);
					}
				}
			}
		}
	}
}
