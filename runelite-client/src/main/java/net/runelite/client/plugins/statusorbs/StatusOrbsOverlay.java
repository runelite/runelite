/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Sean Dewar <https://github.com/seandewar>
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
package net.runelite.client.plugins.statusorbs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.Graceful;
import org.apache.commons.lang3.StringUtils;

public class StatusOrbsOverlay extends Overlay
{
	private static final Color HITPOINTS_COLOR = brighter(0x9B0703);
	private static final Color SPECIAL_COLOR = brighter(0x1E95B0);
	private static final Color RUN_COLOR = new Color(255, 215, 0);
	private static final Color OVERLAY_COLOR = new Color(255, 255, 255, 60);
	private static final double DIAMETER = 26D;
	private static final int OFFSET = 27;

	private final Client client;
	private final StatusOrbsPlugin plugin;
	private final TooltipManager tooltipManager;

	private long last = System.nanoTime();
	private double percentHp;
	private double lastHp;
	private double percentSpec;
	private double lastSpec;
	private double percentRun;
	private double lastRun;

	private static Color brighter(int color)
	{
		float[] hsv = new float[3];
		Color.RGBtoHSB(color >>> 16, (color >> 8) & 0xFF, color & 0xFF, hsv);
		return Color.getHSBColor(hsv[0], 1.f, 1.f);
	}

	@Inject
	public StatusOrbsOverlay(Client client, StatusOrbsPlugin plugin, TooltipManager tooltipManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.plugin = plugin;
		this.tooltipManager = tooltipManager;
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		long current = System.nanoTime();
		double ms = (current - last) / (double) 1000000;

		if (plugin.isShowHitpoints())
		{
			if (lastHp == plugin.getHitpointsPercentage() && plugin.getHitpointsPercentage() != 0)
			{
				percentHp += ms * plugin.getHpPerMs();
			}
			else
			{
				percentHp = plugin.getHitpointsPercentage();
				lastHp = plugin.getHitpointsPercentage();
			}
			renderRegen(g, WidgetInfo.MINIMAP_HEALTH_ORB, percentHp, HITPOINTS_COLOR);
		}

		if (plugin.isShowSpecial())
		{
			if (client.getVar(VarPlayer.SPECIAL_ATTACK_ENABLED) == 1)
			{
				final Widget widget = client.getWidget(WidgetInfo.MINIMAP_SPEC_ORB);

				if (widget != null && !widget.isHidden())
				{
					final Rectangle bounds = widget.getBounds();
					g.setColor(OVERLAY_COLOR);
					g.fillOval(
						bounds.x + OFFSET,
						bounds.y + (int) (bounds.height / 2 - (DIAMETER) / 2),
						(int) DIAMETER, (int) DIAMETER);
				}
			}

			if (lastSpec == plugin.getSpecialPercentage() && plugin.getSpecialPercentage() != 0)
			{
				percentSpec += ms * plugin.getSpecPerMs();
			}
			else
			{
				percentSpec = plugin.getSpecialPercentage();
				lastSpec = plugin.getSpecialPercentage();
			}

			renderRegen(g, WidgetInfo.MINIMAP_SPEC_ORB, percentSpec, SPECIAL_COLOR);
		}

		final Widget runOrb = client.getWidget(WidgetInfo.MINIMAP_TOGGLE_RUN_ORB);

		if (runOrb == null || runOrb.isHidden())
		{
			return null;
		}

		final Rectangle bounds = runOrb.getBounds();

		if (bounds.getX() <= 0)
		{
			return null;
		}

		final Point mousePosition = client.getMouseCanvasPosition();

		if (bounds.contains(mousePosition.getX(), mousePosition.getY()))
		{
			StringBuilder sb = new StringBuilder();
			sb.append("Weight: ").append(client.getWeight()).append(" kg</br>");

			if (plugin.isReplaceOrbText())
			{
				sb.append("Run Energy: ").append(client.getEnergy()).append("%");
			}
			else
			{
				sb.append("Run Time Remaining: ").append(plugin.getEstimatedRunTimeRemaining(false));
			}

			int secondsUntil100 = plugin.getEstimatedRecoverTimeRemaining();
			if (secondsUntil100 > 0)
			{
				final int minutes = (int) Math.floor(secondsUntil100 / 60.0);
				final int seconds = (int) Math.floor(secondsUntil100 - (minutes * 60.0));

				sb.append("</br>").append("100% Energy In: ").append(minutes).append(':').append(StringUtils.leftPad(Integer.toString(seconds), 2, "0"));
			}

			tooltipManager.add(new Tooltip(sb.toString()));
		}

		if (plugin.isShowRun())
		{
			if (lastRun == plugin.getRunPercentage() && plugin.getRunPercentage() != 0)
			{
				double recoverRate = (48 + client.getBoostedSkillLevel(Skill.AGILITY)) / 360000.0;

				if (Graceful.hasFullSet(client.getItemContainer(InventoryID.EQUIPMENT)))
				{
					recoverRate *= 1.3; // 30% recover rate increase from Graceful set effect
				}

				percentRun += ms * recoverRate;
			}
			else
			{
				percentRun = plugin.getRunPercentage();
				lastRun = plugin.getRunPercentage();
			}
			renderRegen(g, WidgetInfo.MINIMAP_RUN_ORB, percentRun, RUN_COLOR);
		}

		last = current;

		return null;
	}

	private void renderRegen(Graphics2D g, WidgetInfo widgetInfo, double percent, Color color)
	{
		Widget widget = client.getWidget(widgetInfo);
		if (widget == null || widget.isHidden())
		{
			return;
		}
		Rectangle bounds = widget.getBounds();

		Arc2D.Double arc = new Arc2D.Double(bounds.x + OFFSET, bounds.y + (bounds.height / 2 - DIAMETER / 2), DIAMETER, DIAMETER, 90.d, -360.d * percent, Arc2D.OPEN);
		final Stroke STROKE = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
		g.setStroke(STROKE);
		g.setColor(color);
		g.draw(arc);
	}
}
