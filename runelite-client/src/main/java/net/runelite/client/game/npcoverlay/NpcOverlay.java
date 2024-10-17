/*
 * Copyright (c) 2018, James Swindle <wilingua@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.game.npcoverlay;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.Map;
import java.util.function.Predicate;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer;
import net.runelite.client.util.Text;

class NpcOverlay extends Overlay
{
	private final Client client;
	private final ModelOutlineRenderer modelOutlineRenderer;
	private final Map<NPC, HighlightedNpc> highlightedNpcs;

	NpcOverlay(Client client, ModelOutlineRenderer modelOutlineRenderer, Map<NPC, HighlightedNpc> highlightedNpcs)
	{
		this.client = client;
		this.modelOutlineRenderer = modelOutlineRenderer;
		this.highlightedNpcs = highlightedNpcs;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (HighlightedNpc highlightedNpc : highlightedNpcs.values())
		{
			renderNpcOverlay(graphics, highlightedNpc);
		}

		return null;
	}

	private void renderNpcOverlay(Graphics2D graphics, HighlightedNpc highlightedNpc)
	{
		NPC actor = highlightedNpc.getNpc();
		NPCComposition npcComposition = actor.getTransformedComposition();
		if (npcComposition == null || !npcComposition.isInteractible())
		{
			return;
		}

		Predicate<NPC> render = highlightedNpc.getRender();
		if (render != null && !render.test(actor))
		{
			return;
		}

		final Color borderColor = highlightedNpc.getHighlightColor();
		float borderWidth = highlightedNpc.getBorderWidth();
		final Color fillColor = highlightedNpc.getFillColor();

		if (highlightedNpc.isHull())
		{
			Shape objectClickbox = actor.getConvexHull();
			renderPoly(graphics, borderColor, borderWidth, fillColor, objectClickbox);
		}

		if (highlightedNpc.isTile())
		{
			Polygon tilePoly = actor.getCanvasTilePoly();
			renderPoly(graphics, borderColor, borderWidth, fillColor, tilePoly);
		}

		if (highlightedNpc.isTrueTile())
		{
			LocalPoint lp = LocalPoint.fromWorld(client, actor.getWorldLocation()); // centered on sw tile
			if (lp != null)
			{
				final int size = npcComposition.getSize();
				final LocalPoint centerLp = lp.plus(
					Perspective.LOCAL_TILE_SIZE * (size - 1) / 2,
					Perspective.LOCAL_TILE_SIZE * (size - 1) / 2);
				Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, centerLp, size);
				renderPoly(graphics, borderColor, borderWidth, fillColor, tilePoly);
			}
		}

		if (highlightedNpc.isSwTile())
		{
			int size = npcComposition.getSize();
			LocalPoint lp = actor.getLocalLocation().plus(
				-((size - 1) * Perspective.LOCAL_TILE_SIZE / 2),
				-((size - 1) * Perspective.LOCAL_TILE_SIZE / 2));

			Polygon southWestTilePoly = Perspective.getCanvasTilePoly(client, lp);
			renderPoly(graphics, borderColor, borderWidth, fillColor, southWestTilePoly);
		}

		if (highlightedNpc.isSwTrueTile())
		{
			LocalPoint lp = LocalPoint.fromWorld(client, actor.getWorldLocation());
			if (lp != null)
			{
				Polygon tilePoly = Perspective.getCanvasTilePoly(client, lp);
				renderPoly(graphics, borderColor, borderWidth, fillColor, tilePoly);
			}
		}

		if (highlightedNpc.isOutline())
		{
			modelOutlineRenderer.drawOutline(actor, (int) highlightedNpc.getBorderWidth(), borderColor, highlightedNpc.getOutlineFeather());
		}

		if (highlightedNpc.isName() && actor.getName() != null)
		{
			String npcName = Text.removeTags(actor.getName());
			Point textLocation = actor.getCanvasTextLocation(graphics, npcName, actor.getLogicalHeight() + 40);

			if (textLocation != null)
			{
				OverlayUtil.renderTextLocation(graphics, textLocation, npcName, borderColor);
			}
		}
	}

	private void renderPoly(Graphics2D graphics, Color borderColor, float borderWidth, Color fillColor, Shape polygon)
	{
		if (polygon != null)
		{
			graphics.setColor(borderColor);
			graphics.setStroke(new BasicStroke(borderWidth));
			graphics.draw(polygon);
			graphics.setColor(fillColor);
			graphics.fill(polygon);
		}
	}
}
