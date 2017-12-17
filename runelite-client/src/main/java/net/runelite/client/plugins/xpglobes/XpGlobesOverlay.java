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
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

@Slf4j
public class XpGlobesOverlay extends Overlay
{
	private final Client client;
	private final XpGlobesPlugin plugin;
	private final XpGlobesConfig config;

	private static final int DEFAULT_CIRCLE_WIDTH = 40;
	private static final int DEFAULT_CIRCLE_HEIGHT = 40;
	private static final int MINIMUM_STEP_WIDTH = DEFAULT_CIRCLE_WIDTH + 10;

	private static final int PROGRESS_RADIUS_START = 270;
	private static final int PROGRESS_RADIUS_REMAINDER = 0;

	private static final Color DEFAULT_XPGLOBE_BACKGROUND_COLOR = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);
	private static final Color DEFAULT_PROGRESS_ARC_COLOR = Color.ORANGE;
	private static final Color DEFAULT_PROGRESS_REMAINDER_ARC_COLOR = Color.BLACK;

	private static final int DEFAULT_START_Y = 10;

	private final BufferedImage[] imgCache = new BufferedImage[Skill.values().length - 1];

	private static final int TOOLTIP_RECT_SIZE_X = 140;
	private static final int TOOLTIP_TEXT_RECT_SIZE_X = TOOLTIP_RECT_SIZE_X - 10;
	private static final int TOOLTIP_RECT_SIZE_Y = 80;

	@Inject
	public XpGlobesOverlay(@Nullable Client client, XpGlobesPlugin plugin, XpGlobesConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point point)
	{

		// won't draw if not logged in or not enabled
		if (!config.enabled())
		{
			return null;
		}

		//check the width of the client if we can draw properly
		int clientWidth = client.isResized() ? client.getCanvas().getWidth() : client.getViewportHeight();
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
				renderProgressCircle(graphics, xpGlobe, startDrawX, DEFAULT_START_Y);
				startDrawX += MINIMUM_STEP_WIDTH;
			}
			plugin.removeExpiredXpGlobes();
		}

		return null;
	}

	private void renderProgressCircle(Graphics2D graphics, XpGlobe skillToDraw, int x, int y)
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
			drawTooltipIfMouseover(graphics, skillToDraw, backgroundCircle);
		}
	}

	private void drawProgressArc(Graphics2D graphics, int x, int y, int w, int h, double radiusStart, double radiusEnd, int strokeWidth, Color color)
	{
		graphics.setStroke(new BasicStroke(strokeWidth));
		graphics.setColor(color);
		graphics.draw(new Arc2D.Double(
			x, y,
			w, h,
			radiusStart, radiusEnd,
			Arc2D.OPEN));
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
		BufferedImage skillImage = getSkillImage(xpGlobe);

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

	private BufferedImage getSkillImage(XpGlobe xpGlobe)
	{
		int skillIdx = xpGlobe.getSkill().ordinal();
		BufferedImage skillImage = null;

		if (imgCache[skillIdx] != null)
		{
			return imgCache[skillIdx];
		}

		try
		{
			String skillIconPath = "/skill_icons/" + xpGlobe.getSkillName().toLowerCase() + ".png";
			log.debug("Loading skill icon from {}", skillIconPath);
			skillImage = ImageIO.read(XpGlobesOverlay.class.getResourceAsStream(skillIconPath));
			imgCache[skillIdx] = skillImage;
		}
		catch (IOException e)
		{
			log.debug("Error Loading skill icons {}", e);
		}

		return skillImage;
	}

	private void drawTooltipIfMouseover(Graphics2D graphics, XpGlobe mouseOverSkill, Ellipse2D drawnGlobe)
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
		int padding = (TOOLTIP_RECT_SIZE_X - TOOLTIP_TEXT_RECT_SIZE_X) / 2;
		int stringX = x + padding;

		String skillLevel = Integer.toString(mouseOverSkill.getCurrentLevel());
		String skillCurrentXp = Integer.toString(mouseOverSkill.getCurrentXp());
		String skillXpToLvl = Integer.toString((mouseOverSkill.getGoalXp() - mouseOverSkill.getCurrentXp()));

		FontMetrics fm = graphics.getFontMetrics();
		int skillLevelX = x + padding + (TOOLTIP_TEXT_RECT_SIZE_X - fm.stringWidth(skillLevel));
		int skillCurrentXpX = x + padding + (TOOLTIP_TEXT_RECT_SIZE_X - fm.stringWidth(skillCurrentXp));
		int skillXpToLvlX = x + padding + (TOOLTIP_TEXT_RECT_SIZE_X - fm.stringWidth(skillXpToLvl));
		int stringHeight = fm.getHeight();

		//draw tooltip container
		graphics.setPaint(DEFAULT_XPGLOBE_BACKGROUND_COLOR);
		graphics.fillRect(x, y, TOOLTIP_RECT_SIZE_X, TOOLTIP_RECT_SIZE_Y);
		graphics.setPaint(DEFAULT_PROGRESS_REMAINDER_ARC_COLOR);
		graphics.setStroke(new BasicStroke(2));
		graphics.drawRect(x, y, TOOLTIP_RECT_SIZE_X, TOOLTIP_RECT_SIZE_Y);

		//draw the text
		graphics.setPaint(Color.WHITE);
		graphics.drawString(mouseOverSkill.getSkillName(), stringX, y + stringHeight);
		graphics.drawString(skillLevel, skillLevelX, y + stringHeight);
		graphics.drawString("Current exp:", stringX, y + (stringHeight * 2));
		graphics.drawString(skillCurrentXp, skillCurrentXpX, y + (stringHeight * 2));
		graphics.drawString("Exp to level:", stringX, y + (stringHeight * 3));
		graphics.drawString(skillXpToLvl, skillXpToLvlX, y + (stringHeight * 3));

		//draw the progress bar
		double progress = mouseOverSkill.getSkillProgress(Experience.getXpForLevel(mouseOverSkill.getCurrentLevel()), mouseOverSkill.getCurrentXp(), mouseOverSkill.getGoalXp());
		int barWidth = TOOLTIP_TEXT_RECT_SIZE_X;
		int barHeight = 16;
		int barX = x + padding;
		int barY = y + (stringHeight * 3) + 10;

		DecimalFormat df = new DecimalFormat("#.00");
		String progressText = df.format(progress) + "%";
		int progressTextLength = fm.stringWidth(progressText);
		int progressTextX = barX + (barWidth / 2) - (progressTextLength / 2);
		int progressTextY = barY + 12;

		int progressFill = (int) ((barWidth / 100F) * progress);

		graphics.setColor(Color.WHITE);
		graphics.fillRect(barX, barY, barWidth, barHeight);
		graphics.setColor(Color.GREEN);
		graphics.fillRect(barX, barY, progressFill, barHeight);
		graphics.setPaint(Color.BLACK);
		graphics.drawString(progressText, progressTextX, progressTextY);
	}
}
