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
import java.awt.Polygon;
import java.awt.Shape;
import java.time.Instant;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.ObjectComposition;
import net.runelite.api.ObjectID;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;
import net.runelite.client.util.ColorUtil;

class WoodcuttingTreesOverlay extends Overlay
{
	private static final Color ROTTING_LEAVES = new Color(179, 0, 0);
	private static final Color GREEN_LEAVES = new Color(0, 179, 0);
	private static final Color DROPPINGS = new Color(120, 88, 76);
	private static final Color WILD_MUSHROOMS = new Color(220, 220, 220);
	private static final Color SPLINTERED_BARK = new Color(0, 0, 179);

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
		renderForestryRoots(graphics);
		renderForestrySapling(graphics);
		renderForestryFlowers(graphics);
		return null;
	}

	private void renderForestryRoots(Graphics2D graphics)
	{
		if (!plugin.getRoots().isEmpty() && config.highlightGlowingRoots())
		{
			for (GameObject treeRoot : plugin.getRoots())
			{
				if (treeRoot.getId() != ObjectID.ANIMAINFUSED_TREE_ROOTS)
				{
					continue;
				}

				Shape clickbox = treeRoot.getClickbox();
				if (clickbox == null)
				{
					continue;
				}

				Color color = Color.GREEN;
				graphics.setColor(color);
				graphics.draw(clickbox);
				graphics.setColor(ColorUtil.colorWithAlpha(color, color.getAlpha() / 5));
				graphics.fill(clickbox);
			}
		}
	}

	private void renderForestrySapling(Graphics2D graphics)
	{
		if (!plugin.getSaplingIngredients().isEmpty() && config.highlightMulch())
		{
			var order = plugin.getSaplingOrder();
			var sb = new StringBuilder();

			graphics.setFont(FontManager.getRunescapeBoldFont().deriveFont(16f));

			for (GameObject ingredient : plugin.getSaplingIngredients())
			{
				char letter;
				Color color;
				switch (ingredient.getId())
				{
					case ObjectID.ROTTING_LEAVES:
						letter = 'R';
						color = ROTTING_LEAVES;
						break;
					case ObjectID.GREEN_LEAVES:
						letter = 'G';
						color = GREEN_LEAVES;
						break;
					case ObjectID.DROPPINGS:
						letter = 'D';
						color = DROPPINGS;
						break;
					case ObjectID.WILD_MUSHROOMS:
					case ObjectID.WILD_MUSHROOMS_47497:
					case ObjectID.WILD_MUSHROOMS_47498:
						letter = 'M';
						color = WILD_MUSHROOMS;
						break;
					case ObjectID.SPLINTERED_BARK:
						letter = 'B';
						color = SPLINTERED_BARK;
						break;
					default:
						continue;
				}

				// eg. M - 1 3
				sb.setLength(0);
				sb.append(letter);

				int numSolved = 0;
				boolean found = false;
				for (int i = 0; i < order.length; ++i)
				{
					if (order[i] == ingredient)
					{
						found = true;
						if (sb.length() == 1)
						{
							sb.append(" -");
						}
						sb.append(' ').append(i + 1);
					}
					if (order[i] != null)
					{
						++numSolved;
					}
				}

				// if the solution is known and this ingredient isn't part of it, don't show it
				if (numSolved >= 3 && !found)
				{
					continue;
				}

				var poly = ingredient.getCanvasTilePoly();
				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, color);
				}

				var text = sb.toString();
				var textLocation = ingredient.getCanvasTextLocation(graphics, text, 0);
				if (textLocation != null)
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, text, Color.WHITE);
				}
			}
		}
	}

	private void renderForestryFlowers(Graphics2D graphics)
	{
		if (!plugin.getFlowers().isEmpty() && config.highlightFlowers())
		{
			var activeFlowers = plugin.getActiveFlowers();
			for (NPC flower : plugin.getFlowers())
			{
				if (activeFlowers.size() == 2 && !activeFlowers.contains(flower))
				{
					continue;
				}

				Polygon poly = flower.getCanvasTilePoly();
				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, Color.YELLOW);
				}
			}
		}
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
