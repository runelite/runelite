/*
 * Copyright (c) 2019, xzact <https://github.com/xzact>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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

package net.runelite.client.plugins.zcox;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class CoxOverlay extends Overlay
{
	private final Client client;


	private final CoxPlugin plugin;
	private final CoxConfig config;

	@Inject
	private CoxOverlay(Client client, CoxPlugin plugin, CoxConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isRunMutta())
		{
			if (config.Muttadile())
			{
				NPC boss = plugin.getMomma_NPC();

				NPC baby = plugin.getMutta_NPC();
				if (boss != null)
				{
					int size = 1;
					NPCComposition composition = boss.getTransformedComposition();
					{
						size = composition.getSize();
					}

					List<WorldPoint> meleeRangeMom = getHitSquares(boss.getWorldLocation(), size, 1, false);

					for (WorldPoint p : meleeRangeMom)
					{
						drawTile(graphics, p, Color.RED, 2, 155, 10);
					}
				}
				if (baby != null)
				{
					int size = 1;
					NPCComposition compositionbaby = baby.getTransformedComposition();
					{
						size = compositionbaby.getSize();
					}

					List<WorldPoint> meleeRange = getHitSquares(baby.getWorldLocation(), size, 1, false);

					for (WorldPoint p : meleeRange)
					{
						drawTile(graphics, p, Color.RED, 1, 155, 10);
					}
				}

			}
		}

		if (plugin.isRunGuard())
		{
			if (config.Guardians())
			{
				NPC G1 = plugin.getGuard1_NPC();
				NPC G2 = plugin.getGuard2_NPC();
				int tick = plugin.getGuardTick();
				if (tick == 5)
				{
					if (G1 != null)
					{
						int size = 1;
						NPCComposition composition = G1.getTransformedComposition();
						{
							size = composition.getSize();
						}

						List<WorldPoint> meleeRange = getHitSquares(G1.getWorldLocation(), size, 1, true);

						for (WorldPoint p : meleeRange)
						{
							drawTile(graphics, p, Color.GREEN, 1, 155, 10);
						}
					}
					if (G2 != null)
					{
						int size = 1;
						NPCComposition composition = G2.getTransformedComposition();
						{
							size = composition.getSize();
						}

						List<WorldPoint> meleeRange = getHitSquares(G2.getWorldLocation(), size, 1, true);

						for (WorldPoint p : meleeRange)
						{
							drawTile(graphics, p, Color.GREEN, 1, 155, 10);
						}
					}
				}
			}
		}


		if (plugin.isRunTekton())
		{
			if (config.Tekton())
			{

				NPC boss = plugin.getTekton_NPC();

				if (boss != null)
				{
					int size = 1;
					NPCComposition composition = boss.getTransformedComposition();
					{
						size = composition.getSize();
					}

					List<WorldPoint> meleeRange = getHitSquares(boss.getWorldLocation(), size, 1, false);

					for (WorldPoint p : meleeRange)
					{
						drawTile(graphics, p, Color.WHITE, 1, 155, 10);
					}
				}
			}
		}

		if (plugin.isRunOlm())
		{
			NPC boss = plugin.getOlm_NPC();
			if (config.OlmCrystals())
			{
				for (WorldPoint p : plugin.getOlm_Crystals())
				{
					drawTile(graphics, p, Color.RED, 1, 255, 0);
				}
				for (WorldPoint p : plugin.getOlm_Heal())
				{
					drawTile(graphics, p, Color.BLUE, 3, 255, 0);
				}
				for (WorldPoint p : plugin.getOlm_PSN())
				{
					drawTile(graphics, p, Color.GREEN, 3, 255, 0);
				}


			}
			if (config.OlmSpec())
			{


			}
			if (config.OlmTick())
			{
				if (boss != null)
				{
					int tick = plugin.getOlm_TicksUntilAction();
					int cycle = plugin.getOlm_ActionCycle();
					int spec = plugin.getOlm_NextSpec();
					final String tickStr = String.valueOf(tick);
					String cycleStr = "?";
					switch (cycle)
					{
						case 1:
							switch (spec)
							{
								case 1:
									cycleStr = "Portals";
									break;
								case 2:
									cycleStr = "lightning";
									break;
								case 3:
									cycleStr = "Crystals";
									break;
								case 4:
									cycleStr = "Heal";
									break;
								case -1:
									cycleStr = "??";
									break;
							}
							break;
						case 2:
							cycleStr = "Sauto";
							break;
						case 3:
							cycleStr = "Null";
							break;
						case 4:
							cycleStr = "Nauto";
							break;
						case -1:
							cycleStr = "??";
							break;


					}
					final String combinedStr = cycleStr + ":" + tickStr;
					Point canvasPoint = boss.getCanvasTextLocation(graphics, combinedStr, 130);
					renderTextLocation(graphics, combinedStr, 12, Font.BOLD, Color.WHITE, canvasPoint);
				}
			}

		}
		return null;
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
		//OverlayUtil.renderPolygon(graphics, poly, color);
		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), outlineAlpha));
		graphics.setStroke(new BasicStroke(strokeWidth));
		graphics.draw(poly);
		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), fillAlpha));
		graphics.fill(poly);
	}

	private void renderNpcOverlay(Graphics2D graphics, NPC actor, Color color, int outlineWidth, int outlineAlpha, int fillAlpha)
	{
		int size = 1;
		NPCComposition composition = actor.getTransformedComposition();
		if (composition != null)
		{
			size = composition.getSize();
		}
		LocalPoint lp = actor.getLocalLocation();
		Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, size);

		if (tilePoly != null)
		{
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), outlineAlpha));
			graphics.setStroke(new BasicStroke(outlineWidth));
			graphics.draw(tilePoly);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), fillAlpha));
			graphics.fill(tilePoly);
		}
	}

	private void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint)
	{
		graphics.setFont(new Font("Arial", fontStyle, fontSize));
		if (canvasPoint != null)
		{
			final Point canvasCenterPoint = new Point(
				canvasPoint.getX(),
				canvasPoint.getY());
			final Point canvasCenterPoint_shadow = new Point(
				canvasPoint.getX() + 1,
				canvasPoint.getY() + 1);
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
		}
	}

	private List<WorldPoint> getHitSquares(WorldPoint npcLoc, int npcSize, int thickness, boolean includeUnder)
	{
		List<WorldPoint> little = new WorldArea(npcLoc, npcSize, npcSize).toWorldPointList();
		List<WorldPoint> big = new WorldArea(npcLoc.getX() - thickness, npcLoc.getY() - thickness, npcSize + (thickness * 2), npcSize + (thickness * 2), npcLoc.getPlane()).toWorldPointList();
		if (!includeUnder)
		{
			for (Iterator<WorldPoint> it = big.iterator(); it.hasNext(); )
			{
				WorldPoint p = it.next();
				if (little.contains(p))
				{
					it.remove();
				}
			}
		}
		return big;
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
}
