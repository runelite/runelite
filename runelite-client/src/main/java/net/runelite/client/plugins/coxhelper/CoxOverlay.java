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

package net.runelite.client.plugins.coxhelper;

import com.google.common.collect.ImmutableSet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
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

@Singleton
public class CoxOverlay extends Overlay
{
	private static final Set<Integer> GAP = ImmutableSet.of(34, 33, 26, 25, 18, 17, 10, 9, 2, 1);
	private final Client client;
	private final CoxPlugin plugin;

	@Inject
	private CoxOverlay(final Client client, final CoxPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (WorldPoint point : plugin.getOlm_Heal())
		{
			drawTile(graphics, point, plugin.getTpColor(), 2, 150);
		}

		for (WorldPoint point : plugin.getOlm_TP())
		{
			client.setHintArrow(point);
			drawTile(graphics, point, plugin.getTpColor(), 2, 150);
		}

		if (plugin.inRaid())
		{
			for (NPCContainer npcs : plugin.getNpcContainer().values())
			{
				Color color;
				List<WorldPoint> hitSquares;
				int ticksLeft;
				switch (npcs.getNpc().getId())
				{
					case NpcID.TEKTON:
					case NpcID.TEKTON_7541:
					case NpcID.TEKTON_7542:
					case NpcID.TEKTON_7545:
					case NpcID.TEKTON_ENRAGED:
					case NpcID.TEKTON_ENRAGED_7544:
						if (plugin.isTekton())
						{
							hitSquares = getHitSquares(npcs.getNpc().getWorldLocation(), npcs.getNpcSize(), 1, false);
							for (WorldPoint p : hitSquares)
							{
								drawTile(graphics, p, plugin.getTektonColor(), 0, 0);
							}
							if (plugin.isTektonTickCounter())
							{
								ticksLeft = npcs.getTicksUntilAttack();
								final int attackTicksleft = plugin.getTektonAttackTicks();
								String attacksLeftStr;
								Color attackcolor;
								if (ticksLeft > 0)
								{
									if (ticksLeft == 1)
									{
										color = npcs.getAttackStyle().getColor();
									}
									else
									{
										color = Color.WHITE;
									}
									final String ticksLeftStr = String.valueOf(ticksLeft);
									Point canvasPoint = npcs.getNpc().getCanvasTextLocation(graphics, ticksLeftStr, 0);
									renderTextLocation(graphics, ticksLeftStr, plugin.getTextSize(), plugin.getFontStyle().getFont(), color, canvasPoint);
								}
								if (attackTicksleft >= 0 && plugin.isTektonActive())
								{
									if (attackTicksleft <= 1)
									{
										attackcolor = new Color(255, 0, 0, 255);
										attacksLeftStr = "Phase Over";
									}
									else
									{
										attackcolor = new Color(255, 255, 255, 255);
										attacksLeftStr = String.valueOf(attackTicksleft);
									}

									if (npcs.getNpc() != null)
									{
										Point canvasPoint = npcs.getNpc().getCanvasTextLocation(graphics, attacksLeftStr, 0);
										renderTextLocationAbove(graphics, attacksLeftStr, plugin.getTextSize(), plugin.getFontStyle().getFont(), attackcolor, canvasPoint);
									}
								}
							}
						}
						break;
					case NpcID.MUTTADILE:
					case NpcID.MUTTADILE_7562:
					case NpcID.MUTTADILE_7563:
						if (plugin.isMuttadile())
						{
							hitSquares = getHitSquares(npcs.getNpc().getWorldLocation(), npcs.getNpcSize(), 1, false);
							for (WorldPoint p : hitSquares)
							{
								drawTile(graphics, p, plugin.getMuttaColor(), 0, 0);
							}
						}
						break;
					case NpcID.GUARDIAN:
					case NpcID.GUARDIAN_7570:
					case NpcID.GUARDIAN_7571:
					case NpcID.GUARDIAN_7572:
						if (plugin.isGuardians())
						{
							hitSquares = getHitSquares(npcs.getNpc().getWorldLocation(), npcs.getNpcSize(), 2, true);
							for (WorldPoint p : hitSquares)
							{
								drawTile(graphics, p, plugin.getGuardColor(), 0, 0);
							}
						}
						if (plugin.isGuardinTickCounter())
						{
							ticksLeft = npcs.getTicksUntilAttack();
							if (ticksLeft > 0)
							{
								if (ticksLeft == 1)
								{
									color = npcs.getAttackStyle().getColor();
								}
								else
								{
									color = Color.WHITE;
								}
								final String ticksLeftStr = String.valueOf(ticksLeft);
								Point canvasPoint = npcs.getNpc().getCanvasTextLocation(graphics, ticksLeftStr, 0);
								renderTextLocation(graphics, ticksLeftStr, plugin.getTextSize(), plugin.getFontStyle().getFont(), color, canvasPoint);
							}
						}
						break;
					case NpcID.VANGUARD_7526:
					case NpcID.VANGUARD_7527:
					case NpcID.VANGUARD_7528:
					case NpcID.VANGUARD_7529:
						if (plugin.isVangHighlight())
						{
							OverlayUtil.renderPolygon(graphics, npcs.getNpc().getConvexHull(), npcs.getAttackStyle().getColor());
						}
						break;
				}
			}

			if (plugin.isHandCripple())
			{
				int tick = plugin.getCrippleTimer();
				NPC olmHand = plugin.getHand();
				final String tickStr = String.valueOf(tick);
				Point canvasPoint = olmHand.getCanvasTextLocation(graphics, tickStr, 50);
				renderTextLocation(graphics, tickStr, plugin.getTextSize(), plugin.getFontStyle().getFont(), Color.GRAY, canvasPoint);
			}

			if (plugin.isTimers())
			{
				if (plugin.getVictims().size() > 0)
				{
					plugin.getVictims().forEach(victim ->
					{
						final int ticksLeft = victim.getTicks();
						String ticksLeftStr = String.valueOf(ticksLeft);
						Color tickcolor;
						switch (victim.getType())
						{
							case ACID:
								if (ticksLeft > 0)
								{
									if (ticksLeft > 1)
									{
										tickcolor = new Color(69, 241, 44, 255);
									}
									else
									{
										tickcolor = new Color(255, 255, 255, 255);
									}
									Point canvasPoint = victim.getPlayer().getCanvasTextLocation(graphics, ticksLeftStr, 0);
									renderTextLocation(graphics, ticksLeftStr, plugin.getTextSize(), plugin.getFontStyle().getFont(), tickcolor, canvasPoint);
								}
								break;
							case BURN:
								if (ticksLeft > 0)
								{
									if (GAP.contains(ticksLeft))
									{
										tickcolor = new Color(255, 0, 0, 255);
										ticksLeftStr = "GAP";
									}
									else
									{
										tickcolor = new Color(255, 255, 255, 255);
									}
									Point canvasPoint = victim.getPlayer().getCanvasTextLocation(graphics, ticksLeftStr, 0);
									renderTextLocation(graphics, ticksLeftStr, plugin.getTextSize(), plugin.getFontStyle().getFont(), tickcolor, canvasPoint);
								}
								break;
							case TELEPORT:
								if (plugin.isTpOverlay())
								{
									if (ticksLeft > 0)
									{
										if (ticksLeft > 1)
										{
											tickcolor = new Color(193, 255, 245, 255);
										}
										else
										{
											tickcolor = new Color(255, 255, 255, 255);
										}
										Point canvasPoint = victim.getPlayer().getCanvasTextLocation(graphics, ticksLeftStr, 0);
										renderTextLocation(graphics, ticksLeftStr, plugin.getTextSize(), plugin.getFontStyle().getFont(), tickcolor, canvasPoint);
									}
									renderActorOverlay(graphics, victim.getPlayer(), new Color(193, 255, 245, 255));
								}
								break;
						}
					});
				}
			}

			if (plugin.isRunOlm())
			{
				NPC boss = plugin.getOlm_NPC();

				if (plugin.isOlmTick())
				{
					if (boss != null)
					{
						final int tick = plugin.getOlm_TicksUntilAction();
						final int cycle = plugin.getOlm_ActionCycle();
						final int spec = plugin.getOlm_NextSpec();
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
						renderTextLocation(graphics, combinedStr, plugin.getTextSize(), plugin.getFontStyle().getFont(), Color.WHITE, canvasPoint);
					}
				}
			}
		}

		return null;
	}

	private void drawTile(Graphics2D graphics, WorldPoint point, Color color, int strokeWidth, int outlineAlpha)
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
		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 50));
		graphics.fill(poly);
	}

	private void renderActorOverlay(Graphics2D graphics, Actor actor, Color color)
	{
		final int size = 1;
		final LocalPoint lp = actor.getLocalLocation();
		final Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, size);

		if (tilePoly != null)
		{
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 100));
			graphics.setStroke(new BasicStroke(2));
			graphics.draw(tilePoly);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 10));
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
			if (plugin.isShadows())
			{
				OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
			}
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
		}
	}

	private void renderTextLocationAbove(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint)
	{
		graphics.setFont(new Font("Arial", fontStyle, fontSize));
		if (canvasPoint != null)
		{
			final Point canvasCenterPoint = new Point(
				canvasPoint.getX(),
				canvasPoint.getY() + 20);
			final Point canvasCenterPoint_shadow = new Point(
				canvasPoint.getX() + 1,
				canvasPoint.getY() + 21);
			if (plugin.isShadows())
			{
				OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
			}
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
		}
	}

	private List<WorldPoint> getHitSquares(WorldPoint npcLoc, int npcSize, int thickness, boolean includeUnder)
	{
		final List<WorldPoint> little = new WorldArea(npcLoc, npcSize, npcSize).toWorldPointList();
		final List<WorldPoint> big = new WorldArea(npcLoc.getX() - thickness, npcLoc.getY() - thickness, npcSize + (thickness * 2), npcSize + (thickness * 2), npcLoc.getPlane()).toWorldPointList();
		if (!includeUnder)
		{
			big.removeIf(little::contains);
		}
		return big;
	}
}
