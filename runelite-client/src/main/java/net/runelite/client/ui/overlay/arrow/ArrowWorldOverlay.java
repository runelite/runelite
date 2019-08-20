/*
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.ui.overlay.arrow;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
@Slf4j
public class ArrowWorldOverlay extends Overlay
{
	private static final int Z_OFFSET = 20;

	private final ArrowPointManager arrowPointManager;
	private final Client client;

	@Inject
	private ArrowWorldOverlay(Client client, ArrowPointManager arrowPointManager)
	{
		this.client = client;
		this.arrowPointManager = arrowPointManager;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Collection<ArrowPoint> points = arrowPointManager.getArrowPoints().values();

		if (points.isEmpty())
		{
			return null;
		}

		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

		for (ArrowPoint arrowPoint : points)
		{
			WorldPoint point = arrowPoint.getWorldPoint();

			if (point.distanceTo(playerLocation) < client.getScene().getDrawDistance())
			{
				LocalPoint fallBackPoint = LocalPoint.fromWorld(client, point);
				if (arrowPoint.types.contains(ArrowType.NPC))
				{
					boolean found = false;
					for (NPC npc : client.getCachedNPCs())
					{
						if (npc != null && arrowPoint.getNpcIDs().contains(npc.getId()))
						{
							found = true;
							renderWorldArrow(graphics, arrowPoint, npc.getLocalLocation(), npc.getLogicalHeight() + Z_OFFSET);
						}
					}
					if (found || fallBackPoint == null)
					{
						continue;
					}

					renderWorldArrow(graphics, arrowPoint, fallBackPoint);
				}
				else if (arrowPoint.types.contains(ArrowType.OBJECT))
				{

					List<GameObject> objects = ArrowUtil.getObjects(client, arrowPoint.getObjectIDs());
					if (objects.isEmpty() && fallBackPoint != null)
					{
						renderWorldArrow(graphics, arrowPoint, fallBackPoint);
						continue;
					}
					for (GameObject object : objects)
					{
						if (object.getEntity().getModel() == null)
						{
							renderWorldArrow(graphics, arrowPoint, object.getLocalLocation(), 0);
						}
						else
						{
							renderWorldArrow(graphics, arrowPoint, object.getLocalLocation(), object.getEntity().getModel().getModelHeight() + Z_OFFSET);
						}
					}
				}
				else if (arrowPoint.types.contains(ArrowType.WORLD_POINT))
				{
					renderWorldArrow(graphics, arrowPoint, fallBackPoint);
				}
			}
		}
		return null;
	}

	private void renderWorldArrow(Graphics2D graphics, ArrowPoint arrowPoint, LocalPoint localPoint)
	{
		renderWorldArrow(graphics, arrowPoint, localPoint, 0);
	}

	private void renderWorldArrow(Graphics2D graphics, ArrowPoint arrowPoint, LocalPoint localPoint, int zOffset)
	{
		final BufferedImage worldImage = arrowPoint.getWorldImage();
		//Draw Tile
		Polygon poly = Perspective.getCanvasTilePoly(client, localPoint);
		if (poly != null)
		{
			OverlayUtil.renderPolygon(graphics, poly, arrowPoint.getTileColor());
		}

		Point worldIconOffset = arrowPoint.getWorldImageOffset();
		//Draw World Arrow
		Point canvasPoint = Perspective.getCanvasImageLocation(client, localPoint, worldImage, zOffset);
		if (canvasPoint != null)
		{
			graphics.drawImage(worldImage, canvasPoint.getX() + worldIconOffset.getX(), canvasPoint.getY() + worldIconOffset.getY(), null);
		}
	}
}
