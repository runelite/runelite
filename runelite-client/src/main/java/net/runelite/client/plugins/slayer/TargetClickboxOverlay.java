/*
 * Copyright (c) 2018, James Swindle <wilingua@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.slayer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.graphics.ModelOutlineRenderer;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.Text;

public class TargetClickboxOverlay extends Overlay
{
	private static final Color TRANSPARENT = new Color(0, 0, 0, 0);

	private final Client client;
	private final SlayerConfig config;
	private final SlayerPlugin plugin;
	private final ModelOutlineRenderer modelOutliner;

	@Inject
	TargetClickboxOverlay(Client client, SlayerConfig config, SlayerPlugin plugin,
						ModelOutlineRenderer modelOutlineRenderer)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		this.modelOutliner = modelOutlineRenderer;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.highlightTargets())
		{
			List<NPC> targets = plugin.getHighlightedTargets();
			for (NPC target : targets)
			{
				Color coloration = config.getTargetColor();
				if (plugin.isSuperior(target.getName()))
				{
					coloration = config.getSuperiorColor();
				}

				renderNpcOverlay(graphics, target, coloration);
			}
		}

		return null;
	}

	private void renderNpcOverlay(Graphics2D graphics, NPC actor, Color color)
	{
		switch (config.renderStyle())
		{
			case SOUTH_WEST_TILE:
				LocalPoint lp1 = LocalPoint.fromWorld(client, actor.getWorldLocation());
				Polygon tilePoly1 = Perspective.getCanvasTilePoly(client, lp1);

				renderPoly(graphics, color, tilePoly1);
				break;

			case TILE:
				int size = 1;
				NPCDefinition composition = actor.getTransformedDefinition();
				if (composition != null)
				{
					size = composition.getSize();
				}
				LocalPoint lp = actor.getLocalLocation();
				Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, size);

				renderPoly(graphics, color, tilePoly);
				break;

			case HULL:
				Polygon objectClickbox = actor.getConvexHull();

				renderPoly(graphics, color, objectClickbox);
				break;
			case THIN_OUTLINE:
				modelOutliner.drawOutline(actor, 1, color);
				break;

			case OUTLINE:
				modelOutliner.drawOutline(actor, 2, color);
				break;

			case THIN_GLOW:
				modelOutliner.drawOutline(actor, 4, color, TRANSPARENT);
				break;

			case GLOW:
				modelOutliner.drawOutline(actor, 8, color, TRANSPARENT);
				break;
			case TRUE_LOCATIONS:
				size = 1;
				composition = actor.getTransformedDefinition();
				if (composition != null)
				{
					size = composition.getSize();
				}
				WorldPoint wp = actor.getWorldLocation();
				lp = LocalPoint.fromWorld(client, wp);
				tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, size);

				renderPoly(graphics, color, tilePoly);
				break;
		}

		if (config.drawNames())
		{
			String npcName = Text.removeTags(actor.getName());
			Point textLocation = actor.getCanvasTextLocation(graphics, npcName, actor.getLogicalHeight() + 40);

			if (textLocation != null)
			{
				OverlayUtil.renderTextLocation(graphics, textLocation, npcName, color);
			}
		}
	}

	private static void renderPoly(Graphics2D graphics, Color color, Polygon polygon)
	{
		if (polygon != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.draw(polygon);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
			graphics.fill(polygon);
		}
	}
}
