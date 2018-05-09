/*
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.client.plugins.roguesden;

import java.awt.*;
import java.awt.geom.Area;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

@Slf4j
public class RoguesDenOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	private final Client client;
	private final RoguesDenPlugin plugin;
	private static Font font;

	public static final Color COL_GROUND = Color.GREEN;
	public static final Color COL_GROUND_AVOID = Color.RED;
	public static final Color COL_OBJ_BORDER = Color.RED;
	private static Color COL_OBJ = new Color(COL_OBJ_BORDER.getRed(), COL_OBJ_BORDER.getGreen(), COL_OBJ_BORDER.getBlue(), 50);
	private static Color COL_OBJ_BORDER_HOVER = COL_OBJ_BORDER.darker();

	@Inject
	public RoguesDenOverlay(Client client, RoguesDenPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		font = FontManager.getRunescapeFont().deriveFont(Font.BOLD);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isHasGem())
		{
			return null;
		}

		graphics.setFont(font);

		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();

		plugin.getObstaclesHull().forEach((obstacle, tile) ->
		{
			if (tile.getPlane() == client.getPlane() && obstacle.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
			{
				Area clickBox = obstacle.getClickbox();
				if (clickBox != null) {
					Point mouse = client.getMouseCanvasPosition();
					if (clickBox.contains(mouse.getX(), mouse.getY()))
					{
						graphics.setColor(COL_OBJ_BORDER_HOVER);
					}
					else
					{
						graphics.setColor(COL_OBJ_BORDER);
					}

					graphics.draw(clickBox);
					graphics.setColor(COL_OBJ);
					graphics.fill(clickBox);

				} else {
					Polygon p;
					if (obstacle instanceof GameObject)
						p = ((GameObject) obstacle).getConvexHull();
					else
						p = obstacle.getCanvasTilePoly();

					if (p != null) {
						graphics.setColor(COL_OBJ);
						graphics.drawPolygon(p);
					}
				}
			}
		});

		for (Obstacles.Obstacle obstacle : Obstacles.OBSTACLES) {
			LocalPoint localPoint = LocalPoint.fromWorld(client, obstacle.tile);

			if (localPoint != null && obstacle.tile.getPlane() == client.getPlane() && localPoint.distanceTo(playerLocation) < MAX_DISTANCE)
			{
				Point mp = Perspective.worldToMiniMap(client, localPoint.getX(), localPoint.getY());
				if (mp != null)
					OverlayUtil.renderMinimapLocation(graphics, mp, obstacle.objectId == -1 ? COL_GROUND : COL_OBJ_BORDER);

				if (obstacle.hint.length() > 0) {
					Polygon p = Perspective.getCanvasTilePoly(client, localPoint);
					if (p != null) {
						graphics.setColor(COL_GROUND);
						graphics.drawPolygon(p);
					}
				}

				Point textLocation = Perspective.getCanvasTextLocation(client, graphics, localPoint, obstacle.hint, 0);
				if (textLocation != null)
				{
					int x = textLocation.getX();
					int y = textLocation.getY();

					graphics.setColor(Color.LIGHT_GRAY);
					graphics.drawString(obstacle.hint, x, y);
				}
			}
		}

		for (Obstacles.Obstacle obstacle : Obstacles.OBSTACLES_AVOID) {
			LocalPoint localPoint = LocalPoint.fromWorld(client, obstacle.tile);

			if (localPoint != null && obstacle.tile.getPlane() == client.getPlane() && localPoint.distanceTo(playerLocation) < MAX_DISTANCE)
			{
				Point mp = Perspective.worldToMiniMap(client, localPoint.getX(), localPoint.getY());
				if (mp != null)
					OverlayUtil.renderMinimapLocation(graphics, mp, COL_GROUND_AVOID);

				if (obstacle.hint.length() > 0) {
					Polygon p = Perspective.getCanvasTilePoly(client, localPoint);
					if (p != null) {
						graphics.setColor(COL_GROUND_AVOID);
						graphics.drawPolygon(p);
					}
				}

				Point textLocation = Perspective.getCanvasTextLocation(client, graphics, localPoint, obstacle.hint, 0);
				if (textLocation != null)
				{
					int x = textLocation.getX();
					int y = textLocation.getY();

					graphics.setColor(Color.LIGHT_GRAY);
					graphics.drawString(obstacle.hint, x, y);
				}
			}
		}
		return null;
	}
}

@Slf4j
class RoguesDenMinimapOverlay extends Overlay {

	private Client client;
	private RoguesDenPlugin plugin;

	@Inject
	public RoguesDenMinimapOverlay(Client client, RoguesDenPlugin plugin) {
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		if (!plugin.isHasGem())
		{
			return null;
		}

		for (Obstacles.Obstacle obstacle : Obstacles.OBSTACLES) {
			LocalPoint localPoint = LocalPoint.fromWorld(client, obstacle.tile);

			if (localPoint == null || obstacle.tile.getPlane() != client.getPlane())
				continue;

			Point mp = Perspective.worldToMiniMap(client, localPoint.getX(), localPoint.getY());
			if (mp != null)
				OverlayUtil.renderMinimapLocation(graphics, mp, obstacle.objectId == -1 ? RoguesDenOverlay.COL_GROUND : RoguesDenOverlay.COL_OBJ_BORDER);
		}

		return null;
	}
}