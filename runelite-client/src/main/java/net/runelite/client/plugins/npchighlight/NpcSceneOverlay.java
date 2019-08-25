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
package net.runelite.client.plugins.npchighlight;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.graphics.ModelOutlineRenderer;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.Text;

@Singleton
public class NpcSceneOverlay extends Overlay
{
	private static final Color TRANSPARENT = new Color(0, 0, 0, 0);

	// Anything but white text is quite hard to see since it is drawn on
	// a dark background
	private static final Color TEXT_COLOR = Color.WHITE;

	private static final NumberFormat TIME_LEFT_FORMATTER = DecimalFormat.getInstance(Locale.US);

	static
	{
		((DecimalFormat) TIME_LEFT_FORMATTER).applyPattern("#0.0");
	}

	private final Client client;
	private final NpcIndicatorsPlugin plugin;
	private final ModelOutlineRenderer modelOutliner;

	@Inject
	NpcSceneOverlay(final Client client, final NpcIndicatorsPlugin plugin, final ModelOutlineRenderer modelOutliner)
	{
		this.client = client;
		this.plugin = plugin;
		this.modelOutliner = modelOutliner;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isShowRespawnTimer())
		{
			plugin.getDeadNpcsToDisplay().forEach((id, npc) -> renderNpcRespawn(npc, graphics));
		}

		for (NPC npc : plugin.getHighlightedNpcs())
		{
			renderNpcOverlay(graphics, npc, plugin.getGetHighlightColor());
		}

		return null;
	}

	private void renderNpcRespawn(final MemorizedNpc npc, final Graphics2D graphics)
	{
		if (npc.getPossibleRespawnLocations().isEmpty())
		{
			return;
		}

		final WorldPoint respawnLocation = npc.getPossibleRespawnLocations().get(0);
		final LocalPoint lp = LocalPoint.fromWorld(client, respawnLocation.getX(), respawnLocation.getY());

		if (lp == null)
		{
			return;
		}

		final Color color = plugin.getGetHighlightColor();

		final LocalPoint centerLp = new LocalPoint(
			lp.getX() + Perspective.LOCAL_TILE_SIZE * (npc.getNpcSize() - 1) / 2,
			lp.getY() + Perspective.LOCAL_TILE_SIZE * (npc.getNpcSize() - 1) / 2);

		final Polygon poly = Perspective.getCanvasTileAreaPoly(client, centerLp, npc.getNpcSize());

		if (poly != null)
		{
			OverlayUtil.renderPolygon(graphics, poly, color);
		}

		final Instant now = Instant.now();
		final double baseTick = ((npc.getDiedOnTick() + npc.getRespawnTime()) - client.getTickCount()) * (Constants.GAME_TICK_LENGTH / 1000.0);
		final double sinceLast = (now.toEpochMilli() - plugin.getLastTickUpdate().toEpochMilli()) / 1000.0;
		final double timeLeft = Math.max(0.0, baseTick - sinceLast);
		final String timeLeftStr = TIME_LEFT_FORMATTER.format(timeLeft);

		final int textWidth = graphics.getFontMetrics().stringWidth(timeLeftStr);
		final int textHeight = graphics.getFontMetrics().getAscent();

		final Point canvasPoint = Perspective
			.localToCanvas(client, centerLp, respawnLocation.getPlane());

		if (canvasPoint != null)
		{
			final Point canvasCenterPoint = new Point(
				canvasPoint.getX() - textWidth / 2,
				canvasPoint.getY() + textHeight / 2);

			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, timeLeftStr, TEXT_COLOR);
		}
	}

	private void renderNpcOverlay(Graphics2D graphics, NPC actor, Color color)
	{
		if (plugin.isDrawInteracting() && actor.getInteracting() != null
			&& actor.getInteracting() == client.getLocalPlayer())
		{
			color = plugin.getGetInteractingColor();
		}

		switch (plugin.getRenderStyle())
		{
			case SOUTH_WEST_TILE:
				final LocalPoint lp1 = LocalPoint.fromWorld(client, actor.getWorldLocation());
				Polygon tilePoly1 = null;
				if (lp1 != null)
				{
					tilePoly1 = Perspective.getCanvasTilePoly(client, lp1);
				}

				renderPoly(graphics, color, tilePoly1);
				break;
			case TILE:
				int size = 1;
				NPCDefinition composition = actor.getTransformedDefinition();
				if (composition != null)
				{
					size = composition.getSize();
				}
				final LocalPoint lp = actor.getLocalLocation();
				final Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, size);
				renderPoly(graphics, color, tilePoly);
				break;
			case HULL:
				final Polygon objectClickbox = actor.getConvexHull();
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

				final WorldPoint wp = actor.getWorldLocation();
				final Color squareColor = color;

				getSquare(wp, size).forEach(square ->
				{
					drawTile(graphics, square, squareColor, 1, 255, 50);
				});
				break;
		}

		if (plugin.isDrawNames() && actor.getName() != null)
		{
			final String npcName = Text.removeTags(actor.getName());
			final Point textLocation = actor.getCanvasTextLocation(graphics, npcName, actor.getLogicalHeight() + 40);

			if (textLocation != null)
			{
				OverlayUtil.renderTextLocation(graphics, textLocation, npcName, color);
			}
		}

		if (plugin.isDrawInteracting() && actor.getInteracting() != null)
		{
			final int drawHeight = plugin.isDrawNames() ? 80 : 40;
			final String targetName = Text.removeTags(actor.getInteracting().getName());
			final Point textLocation = actor.getCanvasTextLocation(graphics, targetName, actor.getLogicalHeight() + drawHeight);

			if (textLocation != null)
			{
				OverlayUtil.renderTextLocation(graphics, textLocation, targetName, color);
			}
		}
	}

	private void renderPoly(Graphics2D graphics, Color color, Polygon polygon)
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

	private List<WorldPoint> getSquare(WorldPoint npcLoc, int npcSize)
	{
		return new WorldArea(npcLoc.getX(), npcLoc.getY(), npcSize, npcSize, npcLoc.getPlane()).toWorldPointList();
	}

	private void drawTile(Graphics2D graphics, WorldPoint point, Color color, int strokeWidth, int outlineAlpha, int fillAlpha)
	{
		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

		if (point.distanceTo(playerLocation) >= 32)
		{
			return;
		}

		LocalPoint lp = LocalPoint.fromWorld(client, point);

		if (lp == null)
		{
			return;
		}

		Polygon poly = Perspective.getCanvasTilePoly(client, lp);

		if (poly == null)
		{
			return;
		}

		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), outlineAlpha));
		graphics.setStroke(new BasicStroke(strokeWidth));
		graphics.draw(poly);
		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), fillAlpha));
		graphics.fill(poly);
	}
}
