/*
 * Copyright (c) 2022, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.boosts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.ImageUtil;

class CompactBoostsOverlay extends Overlay
{
	private static final int H_PADDING = 2;
	private static final int V_PADDING = 1;
	private static final int TEXT_WIDTH = 22;
	private static final BufferedImage BUFFED = ImageUtil.loadImageResource(CompactBoostsOverlay.class, "buffedsmall.png");
	private static final BufferedImage DEBUFFED = ImageUtil.loadImageResource(CompactBoostsOverlay.class, "debuffedsmall.png");

	private final Client client;
	private final BoostsConfig config;
	private final BoostsPlugin plugin;
	private final SkillIconManager skillIconManager;

	private int curY;
	private int maxX;

	@Inject
	private CompactBoostsOverlay(Client client, BoostsConfig config, BoostsPlugin plugin, SkillIconManager skillIconManager)
	{
		super(plugin);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		this.skillIconManager = skillIconManager;
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(PRIORITY_MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Set<Skill> boostedSkills = plugin.getSkillsToDisplay();
		if (!config.compactDisplay())
		{
			return null;
		}

		curY = maxX = 0;

		final FontMetrics fontMetrics = graphics.getFontMetrics();
		final int fontHeight = fontMetrics.getHeight();
		for (Skill skill : boostedSkills)
		{
			final int boosted = client.getBoostedSkillLevel(skill);
			final int base = client.getRealSkillLevel(skill);
			final int boost = boosted - base;

			if (boost == 0)
			{
				continue;
			}

			drawBoost(graphics, fontMetrics, fontHeight,
				skillIconManager.getSkillImage(skill, true),
				getTextColor(boost),
				getBoostText(boost, base, boosted));
		}

		int time = plugin.getChangeUpTicks();
		if (time != -1)
		{
			drawBoost(graphics, fontMetrics, fontHeight,
				DEBUFFED,
				time < 10 ? Color.RED.brighter() : Color.WHITE,
				Integer.toString(plugin.getChangeTime(time)));
		}

		time = plugin.getChangeDownTicks();
		if (time != -1)
		{
			drawBoost(graphics, fontMetrics, fontHeight,
				BUFFED,
				time < 10 ? Color.RED.brighter() : Color.WHITE,
				Integer.toString(plugin.getChangeTime(time)));
		}

		return new Dimension(maxX, curY);
	}

	private void drawBoost(Graphics2D graphics, FontMetrics fontMetrics, int fontHeight, BufferedImage image, Color color, String text)
	{
		graphics.drawImage(image, 0, curY, null);

		final int stringWidth = fontMetrics.stringWidth(text);
		final TextComponent textComponent = new TextComponent();
		textComponent.setColor(color);
		textComponent.setText(text);
		textComponent.setOutline(true);
		textComponent.setPosition(new Point(
			image.getWidth()
				+ H_PADDING // add a little bit of padding to get the text off the side of the image
				+ (TEXT_WIDTH - stringWidth), // right justify to TEXT_WIDTH
			// this really should be y + (image.getHeight() / 2) + (fontHeight / 2), but in practice
			// it is the same
			curY + fontHeight));
		textComponent.render(graphics);

		curY += Math.max(image.getHeight(), fontHeight)
			+ V_PADDING; // padding to keep images from touching
		maxX = Math.max(maxX, image.getWidth() + H_PADDING + TEXT_WIDTH);
	}

	private String getBoostText(int boost, int base, int boosted)
	{
		if (config.useRelativeBoost())
		{
			return boost > 0 ? "+" + boost : Integer.toString(boost);
		}
		else
		{
			return Integer.toString(boosted);
		}
	}

	private Color getTextColor(int boost)
	{
		if (boost < 0)
		{
			return new Color(238, 51, 51);
		}

		return boost <= config.boostThreshold() ? Color.YELLOW : Color.GREEN;
	}
}
