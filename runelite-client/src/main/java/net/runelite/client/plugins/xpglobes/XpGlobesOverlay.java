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

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XpGlobesOverlay extends Overlay
{
	private static final Logger logger = LoggerFactory.getLogger(XpGlobesOverlay.class);

	private final XpGlobes plugin;
	private final Client client = RuneLite.getClient();
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

	public XpGlobesOverlay(XpGlobes plugin)
	{
		super(OverlayPosition.DYNAMIC);
		this.config = plugin.getConfig();
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		// won't draw if not logged in or not enabled
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return null;
		}

		//check the width of the client if we can draw properly
		int clientWidth = client.isResized() ? client.getClientWidth() : client.getViewportHeight();
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

		drawEllipse(graphics, x, y);
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
			config.useSkillColors() ? skillToDraw.getSkill().getColor() : DEFAULT_PROGRESS_ARC_COLOR);

		drawSkillImage(graphics, skillToDraw, x, y);
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

	private void drawEllipse(Graphics2D graphics, int x, int y)
	{
		graphics.setColor(DEFAULT_XPGLOBE_BACKGROUND_COLOR);
		Ellipse2D backgroundCircle = new Ellipse2D.Double(x, y, DEFAULT_CIRCLE_WIDTH, DEFAULT_CIRCLE_HEIGHT);
		graphics.fill(backgroundCircle);
		graphics.draw(backgroundCircle);
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
			logger.debug("Loading skill icon from {}", skillIconPath);
			skillImage = ImageIO.read(XpGlobesOverlay.class.getResourceAsStream(skillIconPath));
			imgCache[skillIdx] = skillImage;
		}
		catch (IOException e)
		{
			logger.debug("Error Loading skill icons {}", e);
		}

		return skillImage;
	}
}
