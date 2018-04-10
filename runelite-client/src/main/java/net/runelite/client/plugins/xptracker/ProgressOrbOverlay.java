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
package net.runelite.client.plugins.xptracker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;

@Slf4j
public class ProgressOrbOverlay extends Overlay
{
	private static final int MINIMUM_STEP = 10;
	private static final int PROGRESS_RADIUS_START = 90;
	private static final int PROGRESS_RADIUS_REMAINDER = 0;
	private static final int DEFAULT_START_Y = 10;
	private static final int TOOLTIP_RECT_SIZE_X = 150;
	private static final int MAXIMUM_SHOWN_GLOBES = 5;

	private final Client client;
	private final XpTrackerPlugin plugin;
	private final XpTrackerConfig config;
	private final SkillIconManager iconManager;

	@Inject
	public ProgressOrbOverlay(Client client, XpTrackerPlugin plugin, XpTrackerConfig config, SkillIconManager iconManager)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.iconManager = iconManager;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.enableProgressOrbs())
		{
			return null;
		}

		//if this is null there is no reason to draw e.g. switching between resizable and fixed
		Widget viewportWidget = client.getViewportWidget();
		if (viewportWidget == null)
		{
			return null;
		}

		//check the width of the client if we can draw properly
		int clientWidth;
		switch (config.progressOrbPosition())
		{
			case MIDDLE_CANVAS:
				clientWidth = client.getViewportWidth();
				break;
			case MIDDLE_VIEWPORT:
				clientWidth = viewportWidget.getWidth();
				break;
			case DYNAMIC:
				clientWidth = (viewportWidget.getWidth() + client.getViewportWidth()) / 2;
				break;
			default:
				clientWidth = client.getViewportWidth();
				break;
		}
		if (clientWidth <= 0)
		{
			return null;
		}

		final List<SkillXPInfo> xpInfos = plugin.getSortedXpInfos(MAXIMUM_SHOWN_GLOBES).collect(Collectors.toList());

		if (xpInfos.isEmpty())
		{
			return null;
		}

		int markersLength = (xpInfos.size() * (config.progressOrbSize())) + ((MINIMUM_STEP) * (xpInfos.size() - 1));
		int startDrawX = (clientWidth - markersLength) / 2;

		for (final SkillXPInfo xpInfo : xpInfos)
		{
			renderProgressCircle(graphics, xpInfo, startDrawX, DEFAULT_START_Y);
			startDrawX += MINIMUM_STEP + config.progressOrbSize();
		}

		return null;
	}

	private double getSkillProgressRadius(final int progress)
	{
		return  -(3.6 * progress); //arc goes backwards
	}

	private void renderProgressCircle(Graphics2D graphics, SkillXPInfo skillToDraw, int x, int y)
	{
		double radiusCurrentXp = getSkillProgressRadius(skillToDraw.getSkillProgress());
		double radiusToGoalXp = 360; //draw a circle

		Ellipse2D backgroundCircle = drawEllipse(graphics, x, y);

		Object renderHint = graphics.getRenderingHint(RenderingHints.KEY_STROKE_CONTROL);
		graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		drawProgressArc(
			graphics,
			x, y,
			config.progressOrbSize(), config.progressOrbSize(),
			PROGRESS_RADIUS_REMAINDER, radiusToGoalXp,
			5,
			config.progressOrbOutLineColor()
		);
		drawProgressArc(
			graphics,
			x, y,
			config.progressOrbSize(), config.progressOrbSize(),
			PROGRESS_RADIUS_START, radiusCurrentXp,
			config.progressOrbArcStrokeWidth(),
			config.progressOrbArcColor());

		graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, renderHint);

		drawSkillImage(graphics, skillToDraw.getSkill(), x, y);

		if (config.enableTooltips())
		{
			drawTooltipIfMouseover(graphics, skillToDraw, backgroundCircle);
		}
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
		Ellipse2D ellipse = new Ellipse2D.Double(x, y, config.progressOrbSize(), config.progressOrbSize());
		graphics.fill(ellipse);
		graphics.draw(ellipse);
		return ellipse;
	}

	private void drawSkillImage(Graphics2D graphics, Skill skill, int x, int y)
	{
		BufferedImage skillImage = iconManager.getSkillImage(skill);

		if (skillImage == null)
		{
			return;
		}

		graphics.drawImage(
			skillImage,
			x + (config.progressOrbSize() / 2) - (skillImage.getWidth() / 2),
			y + (config.progressOrbSize() / 2) - (skillImage.getHeight() / 2),
			null
		);
	}

	private void drawTooltipIfMouseover(Graphics2D graphics, SkillXPInfo mouseOverSkill, Ellipse2D drawnGlobe)
	{
		Point mouse = client.getMouseCanvasPosition();
		int mouseX = mouse.getX();
		int mouseY = mouse.getY();

		if (!drawnGlobe.contains(mouseX, mouseY))
		{
			return;
		}

		//draw tooltip under the globe of the mouse location
		int x = (int) drawnGlobe.getX() - (TOOLTIP_RECT_SIZE_X / 2) + (config.progressOrbSize() / 2);
		int y = (int) drawnGlobe.getY() + config.progressOrbSize() + 10;

		String skillName = mouseOverSkill.getSkill().getName();
		String skillLevel = Integer.toString(mouseOverSkill.getLevel());

		DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
		String skillCurrentXp = decimalFormat.format(mouseOverSkill.getCurrentXp());

		PanelComponent xpTooltip = new PanelComponent();
		xpTooltip.setPosition(new java.awt.Point(x, y));
		xpTooltip.setWidth(TOOLTIP_RECT_SIZE_X);

		List<PanelComponent.Line> lines = xpTooltip.getLines();
		lines.add(new PanelComponent.Line(skillName, Color.WHITE, skillLevel, Color.WHITE));
		lines.add(new PanelComponent.Line("Current xp:", Color.ORANGE, skillCurrentXp, Color.WHITE));
		if (mouseOverSkill.getXpRemaining() > 0)
		{
			String skillXpToLvl = decimalFormat.format(mouseOverSkill.getXpRemaining());
			lines.add(new PanelComponent.Line("Xp to level:", Color.ORANGE, skillXpToLvl, Color.WHITE));

			//Create progress bar for skill.
			ProgressBarComponent progressBar = new ProgressBarComponent();
			double progress = mouseOverSkill.getSkillProgress();
			progressBar.setProgress(progress);
			xpTooltip.setProgressBar(progressBar);
		}

		xpTooltip.render(graphics);
	}
}
