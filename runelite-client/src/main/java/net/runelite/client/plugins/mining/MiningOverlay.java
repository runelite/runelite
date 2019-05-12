/*
 * Copyright (c) 2019, Alex <https://github.com/Barragek0>
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
package net.runelite.client.plugins.mining;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

@Slf4j
public class MiningOverlay extends Overlay
{

	private final Client client;
	private final MiningPlugin plugin;
	private final MiningConfig config;

	@Inject
	MiningOverlay(Client client, MiningPlugin plugin, MiningConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		drawNodes(graphics);
		return null;
	}

	private void drawNodes(Graphics2D graphics)
	{

			for (MiningPlugin.Obj obj : plugin.objects)
			{
				if (obj == null)
				{
					continue;
				}
				if (config.showCurrentOre() && plugin.currentNode != null && !plugin.currentNode.equalsIgnoreCase(plugin.convertObjectToNodeName(obj.getGameObject().getId())))
				{
					//log.info("Object: " + plugin.currentNode + " - " + plugin.convertObjectToNodeName(obj.getGameObject().getId()));
					continue;
				}
				drawOverlayOnNode(graphics, obj);
			}
			for (MiningPlugin.WallObj obj : plugin.wallObjects)
			{
				if (obj == null)
				{
					continue;
				}
				if (config.showCurrentOre() && plugin.currentNode != null && !plugin.currentNode.equalsIgnoreCase(plugin.convertObjectToNodeName(obj.getWallObject().getId())))
				{
					//log.info("Wall: " + plugin.currentNode + " - " + plugin.convertObjectToNodeName(obj.getWallObject().getId()));
					continue;
				}
				drawWallOverlayOnNode(graphics, obj);
			}
	}

	private void drawOverlayOnNode(Graphics2D graphics, MiningPlugin.Obj obj)
	{
		final GameObject object = obj.getGameObject();
		final long spawnTime = obj.getSpawnTime();
		final double respawnTime = obj.getRespawnTime();
		if (object == null)
		{
			return;
		}
		if (object.getWorldLocation().getPlane() != client.getPlane())
		{
			return;
		}
		LocalPoint local = LocalPoint.fromWorld(client, object.getWorldLocation());
		if (local == null)
		{
			return;
		}
		Point loc = Perspective.localToCanvas(client, local, client.getPlane());

		if (loc == null)
		{
			return;
		}
		if (client.getLocalPlayer().getWorldLocation().distanceTo(object.getWorldLocation()) > 20)
		{
			return;
		}
		if (client.getLocalPlayer().getWorldLocation().getPlane() != object.getPlane())
		{
			return;
		}
		if (client.getLocalPlayer().getWorldLocation().getRegionID() != object.getWorldLocation().getRegionID())
		{
			return;
		}
		double timeRemaining = ((System.currentTimeMillis() - spawnTime) / (double)respawnTime);
		ProgressPieComponent ppc = new ProgressPieComponent();
		ppc.setBorderColor(Color.ORANGE);
		ppc.setFill(Color.YELLOW);
		ppc.setPosition(loc);
		ppc.setProgress(timeRemaining);
		if (timeRemaining <= 1)
			ppc.render(graphics);
	}

	private void drawWallOverlayOnNode(Graphics2D graphics, MiningPlugin.WallObj obj)
	{
		final WallObject object = obj.getWallObject();
		final long spawnTime = obj.getSpawnTime();
		final double respawnTime = obj.getRespawnTime();
		if (object == null)
		{
			return;
		}
		if (object.getWorldLocation().getPlane() != client.getPlane())
		{
			return;
		}
		LocalPoint local = LocalPoint.fromWorld(client, object.getWorldLocation());
		if (local == null)
		{
			return;
		}
		Point loc = Perspective.localToCanvas(client, local, client.getPlane());

		if (loc == null)
		{
			return;
		}
		if (client.getLocalPlayer().getWorldLocation().distanceTo(object.getWorldLocation()) > 20)
		{
			return;
		}
		if (client.getLocalPlayer().getWorldLocation().getPlane() != object.getPlane())
		{
			return;
		}
		if (client.getLocalPlayer().getWorldLocation().getRegionID() != object.getWorldLocation().getRegionID())
		{
			return;
		}
		double timeRemaining = ((System.currentTimeMillis() - spawnTime) / (double)respawnTime);
		ProgressPieComponent ppc = new ProgressPieComponent();
		ppc.setBorderColor(Color.ORANGE);
		ppc.setFill(Color.YELLOW);
		ppc.setPosition(loc);
		ppc.setProgress(timeRemaining);
		if (timeRemaining <= 1)
			ppc.render(graphics);
	}
}
