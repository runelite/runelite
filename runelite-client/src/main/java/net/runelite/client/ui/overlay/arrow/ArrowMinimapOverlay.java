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
import java.awt.geom.AffineTransform;
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

@Singleton
@Slf4j
public class ArrowMinimapOverlay extends Overlay
{
	private static final int MINIMAP_VISIBLE_RANGE = 17 * 128;

	private final ArrowPointManager arrowPointManager;
	private final Client client;

	@Inject
	private ArrowMinimapOverlay(Client client, ArrowPointManager arrowPointManager)
	{
		this.client = client;
		this.arrowPointManager = arrowPointManager;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		final Collection<ArrowPoint> points = arrowPointManager.getArrowPoints().values();

		if (points.isEmpty())
		{
			return null;
		}

		final LocalPoint localPlayerPos = client.getLocalPlayer().getLocalLocation();
		final WorldPoint worldPlayerPos = WorldPoint.fromLocal(client, localPlayerPos);

		for (ArrowPoint arrowPoint : points)
		{
			final WorldPoint worldPoint = arrowPoint.getWorldPoint();

			if (worldPoint.distanceTo(worldPlayerPos) < arrowPoint.getVisibleRange())
			{
				LocalPoint fallBackPoint = LocalPoint.fromWorld(client, worldPoint);
				if (arrowPoint.types.contains(ArrowType.NPC))
				{
					boolean found = false;
					for (NPC npc : client.getCachedNPCs())
					{
						if (npc != null && arrowPoint.getNpcIDs().contains(npc.getId()))
						{
							found = true;
							renderMinimapArrow(graphics, arrowPoint, npc.getLocalLocation(), localPlayerPos, worldPlayerPos);
						}
					}
					if (found || fallBackPoint == null)
					{
						continue;
					}

					renderMinimapArrow(graphics, arrowPoint, null, localPlayerPos, worldPlayerPos);
				}
				else if (arrowPoint.types.contains(ArrowType.OBJECT))
				{

					List<GameObject> objects = ArrowUtil.getObjects(client, arrowPoint.getObjectIDs());
					if (objects.isEmpty() && fallBackPoint != null)
					{
						renderMinimapArrow(graphics, arrowPoint, null, localPlayerPos, worldPlayerPos);
						continue;
					}
					for (GameObject object : objects)
					{
						renderMinimapArrow(graphics, arrowPoint, object.getLocalLocation(), localPlayerPos, worldPlayerPos);
					}
				}
				else if (arrowPoint.types.contains(ArrowType.WORLD_POINT))
				{
					renderMinimapArrow(graphics, arrowPoint, null, localPlayerPos, worldPlayerPos);
				}
			}
		}

		return null;
	}

	private void renderMinimapArrow(Graphics2D graphics, ArrowPoint arrowPoint, LocalPoint localPoint, LocalPoint localPlayerPos, WorldPoint worldPlayerPos)
	{
		final BufferedImage minimapImage = arrowPoint.getMinimapImage();
		final WorldPoint worldPoint = arrowPoint.getWorldPoint();
		final Point minimapImageOffset = arrowPoint.getMinimapImageOffset();

		if (localPoint != null && localPlayerPos.distanceTo(localPoint) < MINIMAP_VISIBLE_RANGE)
		{
			final Point minimapLoc = Perspective.getMiniMapImageLocation(client, localPoint, minimapImage);
			if (minimapLoc != null)
			{
				graphics.drawImage(minimapImage, minimapLoc.getX() + minimapImageOffset.getX(), minimapLoc.getY() + minimapImageOffset.getY(), null);
			}
		}
		else
		{
			if (!arrowPoint.isMinimapUseFallback())
			{
				return;
			}
			final Point minimapPlayerPos = Perspective.localToMinimap(client, localPlayerPos);
			double cameraAngle = ((client.getCameraYaw()) / 2048.0) * 2 * Math.PI;
			//Use localPoint if it's available for a smoother rotation
			double theta;
			if (localPoint != null)
			{
				theta = Math.atan2(localPoint.getX() - localPlayerPos.getX(), localPlayerPos.getY() - localPoint.getY());
			}
			else
			{
				theta = Math.atan2(worldPoint.getX() - worldPlayerPos.getX(), worldPlayerPos.getY() - worldPoint.getY());
			}

			AffineTransform at = new AffineTransform();
			if (arrowPoint.isMinimapImagePointToTarget())
			{
				if (minimapPlayerPos != null)
				{
					at.translate(minimapPlayerPos.getX(), minimapPlayerPos.getY());
				}
				at.rotate(cameraAngle - theta);
				at.translate(0, 66);
				at.translate(minimapImageOffset.getX() - minimapImage.getWidth() / 2, minimapImageOffset.getY() - minimapImage.getHeight() / 2);
			}
			else
			{
				//Get the correct position as if it were rotated
				at.rotate(cameraAngle - theta);
				at.translate(0, 66);
				double dX = at.getTranslateX();
				double dY = at.getTranslateY();
				//Then apply that position to an un-rotated transform
				at = new AffineTransform();
				if (minimapPlayerPos != null)
				{
					at.translate(minimapPlayerPos.getX(), minimapPlayerPos.getY());
				}
				at.translate(dX, dY);
				at.translate(minimapImageOffset.getX() - minimapImage.getWidth() / 2, minimapImageOffset.getY() - minimapImage.getHeight() / 2);
			}

			graphics.drawImage(minimapImage, at, null);
		}
	}

	private void renderMinimapArrowNPC(Graphics2D graphics, ArrowPoint arrowPoint, NPC npc, LocalPoint localPlayerPos, WorldPoint worldPlayerPos)
	{
		final BufferedImage minimapImage = arrowPoint.getMinimapImage();
		final WorldPoint worldPoint = arrowPoint.getWorldPoint();
		LocalPoint localPoint;
		if (npc != null)
		{
			localPoint = LocalPoint.fromWorld(client, worldPoint);
			if (localPoint != null)
			{
				//For whatever reason, LocalPoint.fromWorld returns a point (-1, -1) from the actual point
				localPoint = new LocalPoint(localPoint.getX() + 1, localPoint.getY() + 1);
			}
		}
		localPoint = null;

		renderMinimapArrow(graphics, arrowPoint, localPoint, localPlayerPos, worldPlayerPos);
	}
}
