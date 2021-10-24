/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Cas <https://github.com/casvandongen>
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
package net.runelite.client.plugins.agility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.AgilityShortcut;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;
import net.runelite.client.util.ColorUtil;

@Slf4j
class AgilityOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;
	private static final Color SHORTCUT_HIGH_LEVEL_COLOR = Color.ORANGE;

	private Map<Integer, Integer> trapLastPositions = new HashMap<>();
	private Map<Integer, Instant> trapStartTimers = new HashMap<>();

	private final Client client;
	private final AgilityPlugin plugin;
	private final AgilityConfig config;

	@Inject
	private AgilityOverlay(Client client, AgilityPlugin plugin, AgilityConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();
		Point mousePosition = client.getMouseCanvasPosition();
		final List<Tile> marksOfGrace = plugin.getMarksOfGrace();
		final Tile stickTile = plugin.getStickTile();

		plugin.getObstacles().forEach((object, obstacle) ->
		{
			if (Obstacles.SHORTCUT_OBSTACLE_IDS.containsKey(object.getId()) && !config.highlightShortcuts() ||
				Obstacles.TRAP_OBSTACLE_IDS.contains(object.getId()) && !config.showTrapOverlay() ||
				Obstacles.OBSTACLE_IDS.contains(object.getId()) && !config.showClickboxes() ||
				Obstacles.SEPULCHRE_OBSTACLE_IDS.contains(object.getId()) && !config.highlightSepulchreObstacles() ||
				Obstacles.SEPULCHRE_SKILL_OBSTACLE_IDS.contains(object.getId()) && !config.highlightSepulchreSkilling())
			{
				return;
			}

			Tile tile = obstacle.getTile();
			if (tile.getPlane() == client.getPlane()
				&& object.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
			{
				// This assumes that the obstacle is not clickable.
				if (Obstacles.TRAP_OBSTACLE_IDS.contains(object.getId()))
				{
					Polygon polygon = object.getCanvasTilePoly();
					if (polygon != null)
					{
						OverlayUtil.renderPolygon(graphics, polygon, config.getTrapColor());
					}
					return;
				}
				Shape objectClickbox = object.getClickbox();
				if (objectClickbox != null)
				{
					AgilityShortcut agilityShortcut = obstacle.getShortcut();
					Color configColor = agilityShortcut == null || agilityShortcut.getLevel() <= plugin.getAgilityLevel() ? config.getOverlayColor() : SHORTCUT_HIGH_LEVEL_COLOR;
					if (config.highlightMarks() && !marksOfGrace.isEmpty())
					{
						configColor = config.getMarkColor();
					}

					if (Obstacles.PORTAL_OBSTACLE_IDS.contains(object.getId()))
					{
						if (config.highlightPortals())
						{
							configColor = config.getPortalsColor();
						}
						else
						{
							return;
						}
					}

					if (objectClickbox.contains(mousePosition.getX(), mousePosition.getY()))
					{
						graphics.setColor(configColor.darker());
					}
					else
					{
						graphics.setColor(configColor);
					}

					graphics.draw(objectClickbox);
					graphics.setColor(ColorUtil.colorWithAlpha(configColor, configColor.getAlpha() / 5));
					graphics.fill(objectClickbox);
				}
			}
		});

		if (config.highlightMarks() && !marksOfGrace.isEmpty())
		{
			for (Tile markOfGraceTile : marksOfGrace)
			{
				highlightTile(graphics, playerLocation, markOfGraceTile, config.getMarkColor());
			}
		}

		if (stickTile != null && config.highlightStick())
		{
			highlightTile(graphics, playerLocation, stickTile, config.stickHighlightColor());
		}

		Set<NPC> npcs = plugin.getNpcs();
		if (!npcs.isEmpty())
		{
			Color sepulchreHighlightColor = config.sepulchreHighlightColor();
			Color trapHighlightColor = config.getTrapColor();
			npcs.forEach((npc) -> {
				if (Npcs.SEPULCHRE_NPC_IDS.contains(npc.getId()) && config.highlightSepulchreNpcs())
				{
					Polygon tilePoly = npc.getCanvasTilePoly();
					if (tilePoly != null)
					{
						OverlayUtil.renderPolygon(graphics, tilePoly, sepulchreHighlightColor);
					}
					return;
				}

				if (Npcs.TRAP_NPC_IDS.contains(npc.getId()) && config.showTrapOverlay())
				{
					Polygon tilePoly = npc.getCanvasTilePoly();
					Integer lastTrapPosition = trapLastPositions.get(npc.getId());
					WorldPoint currentPosition = npc.getWorldLocation();
					Integer xPos = currentPosition.getX();
					Integer yPos = currentPosition.getY();
					String movementDimension = Npcs.TRAP_MOVEMENT_DIMENSION.get(npc.getId());

					if (lastTrapPosition != null)
					{
						Integer restingPosition = Npcs.TRAP_RESTING_POSITION.get(npc.getId());
						boolean shouldRenderTime = false;

						if ((movementDimension.equals("x") && restingPosition.equals(xPos))
							|| (movementDimension.equals("y") && restingPosition.equals(yPos)))
						{
							shouldRenderTime = true;
						}

						if (shouldRenderTime && tilePoly != null)
						{
							if ((movementDimension.equals("x") && !lastTrapPosition.equals(xPos))
								|| (movementDimension.equals("y") && !lastTrapPosition.equals(yPos)))
							{
								trapStartTimers.put(npc.getId(), Instant.now());
							}

							final String restingTime = Npcs.TRAP_RESTING_TIME.get(npc.getId());
							final Duration trapTime = Duration.parse(restingTime);
							Instant timer = trapStartTimers.get(npc.getId());
							if (timer == null)
							{
								timer = Instant.now();
							}

							final ProgressPieComponent progressPie = new ProgressPieComponent();
							int xPiePos = (tilePoly.xpoints[0] + tilePoly.xpoints[2]) / 2;
							int yPiePos = (tilePoly.ypoints[0] + tilePoly.ypoints[2]) / 2;

							final Point position = new Point(xPiePos, yPiePos);

							Color trapBorder = ColorUtil.colorWithAlpha(trapHighlightColor, 255);

							progressPie.setFill(trapHighlightColor);
							progressPie.setBorderColor(trapBorder);
							progressPie.setPosition(position);

							final Duration duration = Duration.between(timer, Instant.now());
							progressPie.setProgress(1 - (duration.compareTo(trapTime) < 0
								? (double) duration.toMillis() / trapTime.toMillis()
								: 1));

							progressPie.render(graphics);
						}
					}

					if (movementDimension.equals("x"))
					{
						trapLastPositions.put(npc.getId(), currentPosition.getX());
					}
					else if (movementDimension.equals("y"))
					{
						trapLastPositions.put(npc.getId(), currentPosition.getY());
					}
				}
			});
		}

		return null;
	}

	private void highlightTile(Graphics2D graphics, LocalPoint playerLocation, Tile tile, Color color)
	{
		if (tile.getPlane() == client.getPlane() && tile.getItemLayer() != null
			&& tile.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
		{
			final Polygon poly = tile.getItemLayer().getCanvasTilePoly();

			if (poly != null)
			{
				OverlayUtil.renderPolygon(graphics, poly, color);
			}
		}
	}
}
