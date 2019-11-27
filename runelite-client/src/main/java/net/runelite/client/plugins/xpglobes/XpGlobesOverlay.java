/*
 * Copyright (c) 2017, Steve <steve.rs.dev@gmail.com>
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
package net.runelite.client.plugins.xpglobes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Point;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.xptracker.XpActionType;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.SkillColor;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

@Singleton
public class XpGlobesOverlay extends Overlay
{
	private static final int MINIMUM_STEP = 10;
	private static final int PROGRESS_RADIUS_START = 90;
	private static final int PROGRESS_RADIUS_REMAINDER = 0;
	private static final int TOOLTIP_RECT_SIZE_X = 150;
	private static final Color DARK_OVERLAY_COLOR = new Color(0, 0, 0, 180);

	private final Client client;
	private final XpGlobesPlugin plugin;
	private final XpTrackerService xpTrackerService;
	private final PanelComponent xpTooltip = new PanelComponent();
	private final SkillIconManager iconManager;

	@Inject
	private XpGlobesOverlay(
		final Client client,
		final XpGlobesPlugin plugin,
		final XpTrackerService xpTrackerService,
		final SkillIconManager iconManager)
	{
		super(plugin);
		this.iconManager = iconManager;
		this.client = client;
		this.plugin = plugin;

		this.xpTrackerService = xpTrackerService;
		setPosition(OverlayPosition.TOP_CENTER);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "XP Globes overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final int queueSize = plugin.getXpGlobesSize();
		if (queueSize == 0)
		{
			return null;
		}

		final List<XpGlobe> sortedXpGlobes = plugin.getXpGlobes();
		sortedXpGlobes.sort(Comparator.comparing(XpGlobe::getSkill));

		int curDrawX = 0;
		for (final XpGlobe xpGlobe : sortedXpGlobes)
		{
			int startXp = xpTrackerService.getStartGoalXp(xpGlobe.getSkill());
			int goalXp = xpTrackerService.getEndGoalXp(xpGlobe.getSkill());
			renderProgressCircle(graphics, xpGlobe, startXp, goalXp, curDrawX, 0, getBounds());
			curDrawX += MINIMUM_STEP + plugin.getXpOrbSize();
		}

		// Get width of markers
		final int markersLength = (queueSize * (plugin.getXpOrbSize())) + ((MINIMUM_STEP) * (queueSize - 1));
		return new Dimension(markersLength, plugin.getXpOrbSize());
	}

	private double getSkillProgress(int startXp, int currentXp, int goalXp)
	{
		double xpGained = currentXp - startXp;
		double xpGoal = goalXp - startXp;

		return ((xpGained / xpGoal) * 100);
	}

	private double getSkillProgressRadius(int startXp, int currentXp, int goalXp)
	{
		return -(3.6 * getSkillProgress(startXp, currentXp, goalXp)); //arc goes backwards
	}

	private void renderProgressCircle(Graphics2D graphics, XpGlobe skillToDraw, int startXp, int goalXp, int x, int y, Rectangle bounds)
	{
		double radiusCurrentXp = getSkillProgressRadius(startXp, skillToDraw.getCurrentXp(), goalXp);
		double radiusToGoalXp = 360; //draw a circle

		Ellipse2D backgroundCircle = drawEllipse(graphics, x, y);

		drawSkillImage(graphics, skillToDraw, x, y);

		Point mouse = client.getMouseCanvasPosition();
		int mouseX = mouse.getX() - bounds.x;
		int mouseY = mouse.getY() - bounds.y;

		// If mouse is hovering the globe
		if (backgroundCircle.contains(mouseX, mouseY))
		{
			// Fill a darker overlay circle
			graphics.setColor(DARK_OVERLAY_COLOR);
			graphics.fill(backgroundCircle);

			drawProgressLabel(graphics, skillToDraw, startXp, goalXp, x, y);

			if (plugin.isEnableTooltips())
			{
				drawTooltip(graphics, skillToDraw, goalXp, backgroundCircle);
			}
		}

		graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		drawProgressArc(
			graphics,
			x, y,
			plugin.getXpOrbSize(), plugin.getXpOrbSize(),
			PROGRESS_RADIUS_REMAINDER, radiusToGoalXp,
			5,
			plugin.getProgressOrbOutLineColor()
		);
		drawProgressArc(
			graphics,
			x, y,
			plugin.getXpOrbSize(), plugin.getXpOrbSize(),
			PROGRESS_RADIUS_START, radiusCurrentXp,
			plugin.getProgressArcStrokeWidth(),
			plugin.isEnableCustomArcColor() ? plugin.getProgressArcColor() : SkillColor.find(skillToDraw.getSkill()).getColor());
	}

	private void drawProgressLabel(Graphics2D graphics, XpGlobe globe, int startXp, int goalXp, int x, int y)
	{
		if (goalXp <= globe.getCurrentXp())
		{
			return;
		}

		// Convert to int just to limit the decimal cases
		String progress = (int) (getSkillProgress(startXp, globe.getCurrentXp(), goalXp)) + "%";

		final FontMetrics metrics = graphics.getFontMetrics();
		int drawX = x + (plugin.getXpOrbSize() / 2) - (metrics.stringWidth(progress) / 2);
		int drawY = y + (plugin.getXpOrbSize() / 2) + (metrics.getHeight() / 2) - metrics.getMaxDescent();

		OverlayUtil.renderTextLocation(graphics, new Point(drawX, drawY), progress, Color.WHITE);
	}

	private void drawProgressArc(Graphics2D graphics, int x, int y, int w, int h, double radiusStart, double radiusEnd, int strokeWidth, Color color)
	{
		Stroke stroke = graphics.getStroke();
		graphics.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		graphics.setColor(color);
		graphics.draw(new Arc2D.Double(
			x, y,
			w, h,
			radiusStart, radiusEnd,
			Arc2D.OPEN));
		graphics.setStroke(stroke);
	}

	private Ellipse2D drawEllipse(Graphics2D graphics, int x, int y)
	{
		graphics.setColor(plugin.getProgressOrbBackgroundColor());
		Ellipse2D ellipse = new Ellipse2D.Double(x, y, plugin.getXpOrbSize(), plugin.getXpOrbSize());
		graphics.fill(ellipse);
		graphics.draw(ellipse);
		return ellipse;
	}

	private void drawSkillImage(Graphics2D graphics, XpGlobe xpGlobe, int x, int y)
	{
		BufferedImage skillImage = iconManager.getSkillImage(xpGlobe.getSkill());

		if (skillImage == null)
		{
			return;
		}

		graphics.drawImage(
			skillImage,
			x + (plugin.getXpOrbSize() / 2) - (skillImage.getWidth() / 2),
			y + (plugin.getXpOrbSize() / 2) - (skillImage.getHeight() / 2),
			null
		);
	}

	private void drawTooltip(Graphics2D graphics, XpGlobe mouseOverSkill, int goalXp, Ellipse2D drawnGlobe)
	{
		//draw tooltip under the globe of the mouse location
		int x = (int) drawnGlobe.getX() - (TOOLTIP_RECT_SIZE_X / 2) + (plugin.getXpOrbSize() / 2);
		int y = (int) drawnGlobe.getY() + plugin.getXpOrbSize() + 10;

		// reset the timer on XpGlobe to prevent it from disappearing while hovered over it
		mouseOverSkill.setTime(Instant.now());

		String skillName = mouseOverSkill.getSkill().getName();
		String skillLevel = Integer.toString(mouseOverSkill.getCurrentLevel());

		DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
		String skillCurrentXp = decimalFormat.format(mouseOverSkill.getCurrentXp());

		xpTooltip.getChildren().clear();
		xpTooltip.setPreferredLocation(new java.awt.Point(x, y));
		xpTooltip.setPreferredSize(new Dimension(TOOLTIP_RECT_SIZE_X, 0));

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		tableComponent.addRow(skillName, skillLevel);
		tableComponent.addRow(ColorUtil.prependColorTag("Current XP:", Color.ORANGE), skillCurrentXp);

		if (goalXp > mouseOverSkill.getCurrentXp())
		{
			XpActionType xpActionType = xpTrackerService.getActionType(mouseOverSkill.getSkill());

			if (plugin.isShowActionsLeft())
			{
				int actionsLeft = xpTrackerService.getActionsLeft(mouseOverSkill.getSkill());
				if (actionsLeft != Integer.MAX_VALUE)
				{
					String actionsLeftString = decimalFormat.format(actionsLeft);

					tableComponent.addRow(ColorUtil.prependColorTag(xpActionType.getLabel() + " left:", Color.ORANGE), actionsLeftString);
				}
			}

			if (plugin.isShowXpLeft())
			{
				int xpLeft = goalXp - mouseOverSkill.getCurrentXp();
				String skillXpToLvl = decimalFormat.format(xpLeft);
				tableComponent.addRow(ColorUtil.prependColorTag("XP left:", Color.ORANGE), skillXpToLvl);
			}

			if (plugin.isShowXpHour())
			{
				int xpHr = xpTrackerService.getXpHr(mouseOverSkill.getSkill());
				if (xpHr != 0)
				{
					String xpHrString = decimalFormat.format(xpHr);
					tableComponent.addRow(ColorUtil.prependColorTag("XP per hour:", Color.ORANGE), xpHrString);
				}
			}

			if (plugin.isEnableTimeToLevel())
			{
				String timeLeft = xpTrackerService.getTimeTillGoal(mouseOverSkill.getSkill());
				tableComponent.addRow(ColorUtil.prependColorTag("TimeLeft:", Color.ORANGE), timeLeft);
			}
		}

		xpTooltip.getChildren().add(tableComponent);

		xpTooltip.render(graphics);
	}
}
