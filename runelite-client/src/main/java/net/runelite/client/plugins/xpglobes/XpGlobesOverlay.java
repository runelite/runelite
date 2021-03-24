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
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
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
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ImageUtil;

public class XpGlobesOverlay extends Overlay
{
	private static final int MINIMUM_STEP = 10;
	private static final int PROGRESS_RADIUS_START = 90;
	private static final int PROGRESS_RADIUS_REMAINDER = 0;
	private static final int TOOLTIP_RECT_SIZE_X = 150;
	private static final Color DARK_OVERLAY_COLOR = new Color(0, 0, 0, 180);
	static final String FLIP_ACTION = "Flip";
	private static final double GLOBE_ICON_RATIO = 0.65;

	private final Client client;
	private final XpGlobesPlugin plugin;
	private final XpGlobesConfig config;
	private final XpTrackerService xpTrackerService;
	private final TooltipManager tooltipManager;
	private final SkillIconManager iconManager;
	private final Tooltip xpTooltip = new Tooltip(new PanelComponent());

	@Inject
	private XpGlobesOverlay(
		Client client,
		XpGlobesPlugin plugin,
		XpGlobesConfig config,
		XpTrackerService xpTrackerService,
		SkillIconManager iconManager,
		TooltipManager tooltipManager)
	{
		super(plugin);
		this.iconManager = iconManager;
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.xpTrackerService = xpTrackerService;
		this.tooltipManager = tooltipManager;
		this.xpTooltip.getComponent().setPreferredSize(new Dimension(TOOLTIP_RECT_SIZE_X, 0));
		setPosition(OverlayPosition.TOP_CENTER);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "XP Globes overlay"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, FLIP_ACTION, "XP Globes overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final List<XpGlobe> xpGlobes = plugin.getXpGlobes();
		final int queueSize = xpGlobes.size();
		if (queueSize == 0)
		{
			return null;
		}

		int curDrawPosition = 0;
		for (final XpGlobe xpGlobe : xpGlobes)
		{
			int startXp = xpTrackerService.getStartGoalXp(xpGlobe.getSkill());
			int goalXp = xpTrackerService.getEndGoalXp(xpGlobe.getSkill());
			if (config.alignOrbsVertically())
			{
				renderProgressCircle(graphics, xpGlobe, startXp, goalXp, 0, curDrawPosition, getBounds());
			}
			else
			{
				renderProgressCircle(graphics, xpGlobe, startXp, goalXp, curDrawPosition, 0, getBounds());
			}
			curDrawPosition += MINIMUM_STEP + config.xpOrbSize();
		}

		// Get length of markers
		final int markersLength = (queueSize * (config.xpOrbSize())) + ((MINIMUM_STEP) * (queueSize - 1));
		if (config.alignOrbsVertically())
		{
			return new Dimension(config.xpOrbSize(), markersLength);
		}
		else
		{
			return new Dimension(markersLength, config.xpOrbSize());
		}
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

			if (config.enableTooltips())
			{
				drawTooltip(skillToDraw, goalXp);
			}
		}

		graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		drawProgressArc(
			graphics,
			x, y,
			config.xpOrbSize(), config.xpOrbSize(),
			PROGRESS_RADIUS_REMAINDER, radiusToGoalXp,
			5,
			config.progressOrbOutLineColor()
		);
		drawProgressArc(
			graphics,
			x, y,
			config.xpOrbSize(), config.xpOrbSize(),
			PROGRESS_RADIUS_START, radiusCurrentXp,
			config.progressArcStrokeWidth(),
			config.enableCustomArcColor() ? config.progressArcColor() : SkillColor.find(skillToDraw.getSkill()).getColor());
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
		int drawX = x + (config.xpOrbSize() / 2) - (metrics.stringWidth(progress) / 2);
		int drawY = y + (config.xpOrbSize() / 2) + (metrics.getHeight() / 2);

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
		graphics.setColor(config.progressOrbBackgroundColor());
		Ellipse2D ellipse = new Ellipse2D.Double(x, y, config.xpOrbSize(), config.xpOrbSize());
		graphics.fill(ellipse);
		graphics.draw(ellipse);
		return ellipse;
	}

	private void drawSkillImage(Graphics2D graphics, XpGlobe xpGlobe, int x, int y)
	{
		final int orbSize = config.xpOrbSize();
		final BufferedImage skillImage = getScaledSkillIcon(xpGlobe, orbSize);

		if (skillImage == null)
		{
			return;
		}

		graphics.drawImage(
			skillImage,
			x + (orbSize / 2) - (skillImage.getWidth() / 2),
			y + (orbSize / 2) - (skillImage.getHeight() / 2),
			null
		);
	}

	private BufferedImage getScaledSkillIcon(XpGlobe xpGlobe, int orbSize)
	{
		// Cache the previous icon if the size hasn't changed
		if (xpGlobe.getSkillIcon() != null && xpGlobe.getSize() == orbSize)
		{
			return xpGlobe.getSkillIcon();
		}

		BufferedImage icon = iconManager.getSkillImage(xpGlobe.getSkill());
		if (icon == null)
		{
			return null;
		}

		final int size = orbSize - config.progressArcStrokeWidth();
		final int scaledIconSize = (int) (size * GLOBE_ICON_RATIO);
		if (scaledIconSize <= 0)
		{
			return null;
		}

		icon = ImageUtil.resizeImage(icon, scaledIconSize, scaledIconSize, true);

		xpGlobe.setSkillIcon(icon);
		xpGlobe.setSize(orbSize);
		return icon;
	}

	private void drawTooltip(XpGlobe mouseOverSkill, int goalXp)
	{
		// reset the timer on XpGlobe to prevent it from disappearing while hovered over it
		mouseOverSkill.setTime(Instant.now());

		String skillName = mouseOverSkill.getSkill().getName();
		String skillLevel = Integer.toString(mouseOverSkill.getCurrentLevel());

		DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
		String skillCurrentXp = decimalFormat.format(mouseOverSkill.getCurrentXp());

		final PanelComponent xpTooltip = (PanelComponent) this.xpTooltip.getComponent();
		xpTooltip.getChildren().clear();

		xpTooltip.getChildren().add(LineComponent.builder()
			.left(skillName)
			.right(skillLevel)
			.build());

		xpTooltip.getChildren().add(LineComponent.builder()
			.left("Current XP:")
			.leftColor(Color.ORANGE)
			.right(skillCurrentXp)
			.build());

		if (goalXp > mouseOverSkill.getCurrentXp())
		{
			XpActionType xpActionType = xpTrackerService.getActionType(mouseOverSkill.getSkill());

			if (config.showActionsLeft())
			{
				int actionsLeft = xpTrackerService.getActionsLeft(mouseOverSkill.getSkill());
				if (actionsLeft != Integer.MAX_VALUE)
				{
					String actionsLeftString = decimalFormat.format(actionsLeft);
					xpTooltip.getChildren().add(LineComponent.builder()
							.left(xpActionType.getLabel() + " left:")
							.leftColor(Color.ORANGE)
							.right(actionsLeftString)
							.build());
				}
			}

			if (config.showXpLeft())
			{
				int xpLeft = goalXp - mouseOverSkill.getCurrentXp();
				String skillXpToLvl = decimalFormat.format(xpLeft);
				xpTooltip.getChildren().add(LineComponent.builder()
						.left("XP left:")
						.leftColor(Color.ORANGE)
						.right(skillXpToLvl)
						.build());
			}

			if (config.showXpHour())
			{
				int xpHr = xpTrackerService.getXpHr(mouseOverSkill.getSkill());
				if (xpHr != 0)
				{
					String xpHrString = decimalFormat.format(xpHr);
					xpTooltip.getChildren().add(LineComponent.builder()
							.left("XP per hour:")
							.leftColor(Color.ORANGE)
							.right(xpHrString)
							.build());
				}
			}
		}

		tooltipManager.add(this.xpTooltip);
	}
}
