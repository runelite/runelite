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
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Point;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;

@Slf4j
public class XpGlobesOverlay extends Overlay
{
	private final Client client;
	private final XpGlobesPlugin plugin;
	private final XpGlobesConfig config;

	@Inject
	private SkillIconManager iconManager;

	private static final int DEFAULT_CIRCLE_WIDTH = 40;
	private static final int DEFAULT_CIRCLE_HEIGHT = 40;
	private static final int MINIMUM_STEP_WIDTH = DEFAULT_CIRCLE_WIDTH + 10;

	private static final int PROGRESS_RADIUS_START = 270;
	private static final int PROGRESS_RADIUS_REMAINDER = 0;

	private static final Color DEFAULT_XPGLOBE_BACKGROUND_COLOR = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);
	private static final Color DEFAULT_PROGRESS_ARC_COLOR = Color.ORANGE;
	private static final Color DEFAULT_PROGRESS_REMAINDER_ARC_COLOR = Color.BLACK;

	private static final int DEFAULT_START_Y = 10;

	private static final int TOOLTIP_RECT_SIZE_X = 150;

	@Inject
	public XpGlobesOverlay(@Nullable Client client, XpGlobesPlugin plugin, XpGlobesConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point point)
	{
		//check the width of the client if we can draw properly
		int clientWidth = client.isResized() ? client.getCanvas().getWidth() : client.getViewportWidth();
		if (clientWidth <= 0)
		{
			return null;
		}

		int queueSize = plugin.getXpGlobesSize();
		if (queueSize > 0)
		{
			List<XpGlobe> xpChangedQueue = plugin.getXpGlobes();
			int markersLength = (queueSize * (DEFAULT_CIRCLE_WIDTH)) + ((MINIMUM_STEP_WIDTH - DEFAULT_CIRCLE_WIDTH) * (queueSize - 1));
			int startDrawX = (clientWidth - markersLength) / 2;

			for (XpGlobe xpGlobe : xpChangedQueue)
			{
				renderProgressCircle(graphics, point, xpGlobe, startDrawX, DEFAULT_START_Y);
				startDrawX += MINIMUM_STEP_WIDTH;
			}
			plugin.removeExpiredXpGlobes();
		}

		return null;
	}

	private void renderProgressCircle(Graphics2D graphics, java.awt.Point parent, XpGlobe skillToDraw, int x, int y)
	{
		double radiusCurrentXp = skillToDraw.getSkillProgressRadius();
		double radiusToGoalXp = 360; //draw a circle

		Ellipse2D backgroundCircle = drawEllipse(graphics, x, y);
		drawProgressArc(
			graphics,
			x, y,
			DEFAULT_CIRCLE_WIDTH, DEFAULT_CIRCLE_HEIGHT,
			PROGRESS_RADIUS_REMAINDER, radiusToGoalXp,
			5,
			DEFAULT_PROGRESS_REMAINDER_ARC_COLOR
		);
		drawProgressArc(
			graphics,
			x, y,
			DEFAULT_CIRCLE_WIDTH, DEFAULT_CIRCLE_HEIGHT,
			PROGRESS_RADIUS_START, radiusCurrentXp,
			2,
			DEFAULT_PROGRESS_ARC_COLOR);
		drawSkillImage(graphics, skillToDraw, x, y);

		if (config.enableTooltips())
		{
			drawTooltipIfMouseover(graphics, parent, skillToDraw, backgroundCircle);
		}
	}

	private void drawProgressArc(Graphics2D graphics, int x, int y, int w, int h, double radiusStart, double radiusEnd, int strokeWidth, Color color)
	{
		Stroke stroke = graphics.getStroke();
		graphics.setStroke(new BasicStroke(strokeWidth));
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
		graphics.setColor(DEFAULT_XPGLOBE_BACKGROUND_COLOR);
		Ellipse2D ellipse = new Ellipse2D.Double(x, y, DEFAULT_CIRCLE_WIDTH, DEFAULT_CIRCLE_HEIGHT);
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
			x + (DEFAULT_CIRCLE_WIDTH / 2) - (skillImage.getWidth() / 2),
			y + (DEFAULT_CIRCLE_HEIGHT / 2) - (skillImage.getHeight() / 2),
			null
		);
	}

	private void drawTooltipIfMouseover(Graphics2D graphics, java.awt.Point parent, XpGlobe mouseOverSkill, Ellipse2D drawnGlobe)
	{
		Point mouse = client.getMouseCanvasPosition();
		int mouseX = mouse.getX();
		int mouseY = mouse.getY();

		if (!drawnGlobe.contains(mouseX, mouseY))
		{
			return;
		}

		//draw tooltip under the globe of the mouse location
		int x = (int) drawnGlobe.getX() - (TOOLTIP_RECT_SIZE_X / 2) + (DEFAULT_CIRCLE_WIDTH / 2);
		int y = (int) drawnGlobe.getY() + DEFAULT_CIRCLE_HEIGHT + 10;

		String skillName = mouseOverSkill.getSkillName();
		String skillLevel = Integer.toString(mouseOverSkill.getCurrentLevel());

		DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
		String skillCurrentXp = decimalFormat.format(mouseOverSkill.getCurrentXp());

		PanelComponent xpTooltip = new PanelComponent();
		xpTooltip.setPosition(new java.awt.Point(x, y));
		xpTooltip.setWidth(TOOLTIP_RECT_SIZE_X);

		List<PanelComponent.Line> lines = xpTooltip.getLines();
		lines.add(new PanelComponent.Line(skillName, Color.WHITE, skillLevel, Color.WHITE));
		lines.add(new PanelComponent.Line("Current xp:", Color.ORANGE, skillCurrentXp, Color.WHITE));
		if (mouseOverSkill.getGoalXp() != -1)
		{
			String skillXpToLvl = decimalFormat.format(mouseOverSkill.getGoalXp() - mouseOverSkill.getCurrentXp());
			lines.add(new PanelComponent.Line("Xp to level:", Color.ORANGE, skillXpToLvl, Color.WHITE));

			//Create progress bar for skill.
			ProgressBarComponent progressBar = new ProgressBarComponent();
			double progress = mouseOverSkill.getSkillProgress(Experience.getXpForLevel(mouseOverSkill.getCurrentLevel()),
				mouseOverSkill.getCurrentXp(), mouseOverSkill.getGoalXp());
			progressBar.setProgress(progress);

			xpTooltip.setProgressBar(progressBar);
		}

		xpTooltip.render(graphics, parent);
	}
}
