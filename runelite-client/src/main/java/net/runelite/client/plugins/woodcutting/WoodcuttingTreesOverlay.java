/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, David <Dava96@github.com>
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
package net.runelite.client.plugins.woodcutting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Instant;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

class WoodcuttingTreesOverlay extends Overlay
{
	private final Client client;
	private final WoodcuttingConfig config;
	private final ItemManager itemManager;
	private final WoodcuttingPlugin plugin;

	@Inject
	private WoodcuttingTreesOverlay(final Client client, final WoodcuttingConfig config, final ItemManager itemManager, final WoodcuttingPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.itemManager = itemManager;
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		renderAxes(graphics);
		renderTimers(graphics);
		return null;
	}

	private void renderAxes(Graphics2D graphics)
	{
		if (plugin.getSession() == null || !config.showRedwoodTrees())
		{
			return;
		}

		Axe axe = plugin.getAxe();
		if (axe == null)
		{
			return;
		}

		for (GameObject treeObject : plugin.getTreeObjects())
		{
			if (treeObject.getWorldLocation().distanceTo(client.getLocalPlayer().getWorldLocation()) <= 12)
			{
				// Redwood trees at the farming guild are multilocs rather than global objects synced for all players
				// so we must handle them here rather than relying on GameObjectSpawned events
				final ObjectComposition treeComp = client.getObjectDefinition(treeObject.getId());
				if (treeComp.getImpostorIds() != null && Tree.findTree(treeComp.getImpostor().getId()) == null)
				{
					continue;
				}
				OverlayUtil.renderImageLocation(client, graphics, treeObject.getLocalLocation(), itemManager.getImage(axe.getItemId()), 120);
			}
		}
	}

	private void renderTimers(Graphics2D graphics)
	{
		List<TreeRespawn> respawns = plugin.getRespawns();
		if (respawns.isEmpty() || !config.showRespawnTimers())
		{
			return;
		}

		Instant now = Instant.now();
		for (TreeRespawn treeRespawn : respawns)
		{
			LocalPoint minLocation = LocalPoint.fromWorld(client, treeRespawn.getWorldLocation());
			if (minLocation == null)
			{
				continue;
			}

			LocalPoint centeredLocation = new LocalPoint(
					minLocation.getX() + treeRespawn.getLenX() * Perspective.LOCAL_HALF_TILE_SIZE,
					minLocation.getY() + treeRespawn.getLenY() * Perspective.LOCAL_HALF_TILE_SIZE);
			float percent = (now.toEpochMilli() - treeRespawn.getStartTime().toEpochMilli()) / (float) treeRespawn.getRespawnTime();
			Point point = Perspective.localToCanvas(client, centeredLocation, client.getPlane());
			if (point == null || percent > 1.0f)
			{
				continue;
			}

			ProgressPieComponent ppc = new ProgressPieComponent();
			ppc.setBorderColor(Color.ORANGE);
			ppc.setFill(Color.YELLOW);
			ppc.setPosition(point);
			ppc.setProgress(percent);
			ppc.render(graphics);
		}
	}
}
