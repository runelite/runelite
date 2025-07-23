/*
 * Copyright (c) 2019, Jos <Malevolentdev@gmail.com>
 * Copyright (c) 2019, Rheon <https://github.com/Rheon-D>
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
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.statusbars;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.components.TextComponent;

@RequiredArgsConstructor
class BarRenderer
{
	private static final Color BACKGROUND = new Color(0, 0, 0, 150);
	private static final Color OVERHEAL_COLOR = new Color(216, 255, 139, 150);
	private static final int SKILL_ICON_HEIGHT = 35;
	private static final int COUNTER_ICON_HEIGHT = 18;
	private static final int SKILL_ICON_WIDTH = 24;
	private static final int COUNTER_ICON_WIDTH = 12;
	private static final int BORDER_SIZE = 1;
	private static final int MIN_ICON_AND_COUNTER_WIDTH = 16;
	private static final int MIN_ICON_AND_COUNTER_HEIGHT = 16;
	static final int DEFAULT_WIDTH = 20;
	static final int DEFAULT_HEIGHT = 6;
	static final int MIN_WIDTH = 3;
	static final int MAX_WIDTH = 40;
	private final Supplier<Integer> maxValueSupplier;
	private final Supplier<Integer> currentValueSupplier;
	private final Supplier<Integer> healSupplier;
	private final Supplier<Color> colorSupplier;
	private final Supplier<Color> healColorSupplier;
	private final Supplier<Image> iconSupplier;
	private int maxValue;
	private int currentValue;

	private void refreshSkills()
	{
		maxValue = maxValueSupplier.get();
		currentValue = currentValueSupplier.get();
	}

	/**
	 * Renders a status bar along with its restoration bar(s), icons and counters as appropriate
	 * @param config Plugin configuration which dictates certain settings, such as whether to show restoration bars and
	 *               whether or not to draw icons.
	 * @param graphics Graphics.
	 * @param x The location on the client where it will draw the bar on the x axis starting on the left side.
	 * @param y The location on the client where it will draw the bar on the y axis starting on the bottom side.
	 * @param width The width of the bar.
	 * @param height The height of the bar.
	 * @param isFixedLayout Whether the client is in Fixed layout.
	 */
	void renderBar(StatusBarsConfig config, Graphics2D graphics, int x, int y, int width, int height, boolean isFixedLayout)
	{
		final Color fill = colorSupplier.get();
		refreshSkills();

		graphics.setColor(BACKGROUND);
		graphics.drawRect(x, y, width - BORDER_SIZE, height - BORDER_SIZE);
		graphics.fillRect(x, y, width, height);

		graphics.setColor(fill);
		if (config.topBarMode() && !isFixedLayout)
		{
			final int filledWidth = getBarHeight(maxValue, currentValue, width);
			graphics.fillRect(x + BORDER_SIZE,
				y + BORDER_SIZE,
				filledWidth - BORDER_SIZE * 2,
				height - BORDER_SIZE * 2);
		}
		else
		{
			final int filledHeight = getBarHeight(maxValue, currentValue, height);
			graphics.fillRect(x + BORDER_SIZE,
				y + BORDER_SIZE + (height - filledHeight),
				width - BORDER_SIZE * 2,
				filledHeight - BORDER_SIZE * 2);
		}

		if (config.enableRestorationBars())
		{
			renderRestore(config, graphics, x, y, width, height, isFixedLayout);
		}

		if (config.enableSkillIcon() || config.enableCounter())
		{
			renderIconsAndCounters(config, graphics, x, y, width, height, isFixedLayout);
		}
	}

	private void renderIconsAndCounters(StatusBarsConfig config, Graphics2D graphics, int x, int y, int width, int height, boolean isFixedLayout)
	{
		// Icons and counters overlap the bar at small widths/heights, so they are not drawn when the bars are too small
		if (config.topBarMode())
		{
			if (height < MIN_ICON_AND_COUNTER_HEIGHT) {
				return;
			}
		}
		if (width < MIN_ICON_AND_COUNTER_WIDTH)
		{
			return;
		}

		final boolean skillIconEnabled = config.enableSkillIcon();

		if (skillIconEnabled)
		{
			final Image icon = iconSupplier.get();
			if (icon != null)
			{
				if (config.topBarMode() && !isFixedLayout)
				{
					final int yDraw = y + (height / 2) - (icon.getHeight(null) / 2);
					graphics.drawImage(icon, x + 4, yDraw, null);
				}
				else
				{
					final int xDraw = x + (width / 2) - (icon.getWidth(null) / 2);
					graphics.drawImage(icon, xDraw, y + 4, null);
				}
			}
		}

		if (config.enableCounter())
		{
			if (config.topBarMode() && !isFixedLayout) {
				graphics.setFont(FontManager.getRunescapeSmallFont());
				final String counterText = Integer.toString(currentValue);
				final int heightOfCounter = graphics.getFontMetrics().getHeight();
				final int centerText = (height / 2) + (heightOfCounter / 2);
				final int xOffset = skillIconEnabled ? SKILL_ICON_WIDTH : COUNTER_ICON_WIDTH;

				final TextComponent textComponent = new TextComponent();
				textComponent.setText(counterText);
				textComponent.setPosition(new Point(x + xOffset, y + centerText));
				textComponent.render(graphics);
			}
			else
			{
				graphics.setFont(FontManager.getRunescapeSmallFont());
				final String counterText = Integer.toString(currentValue);
				final int widthOfCounter = graphics.getFontMetrics().stringWidth(counterText);
				final int centerText = (width / 2) - (widthOfCounter / 2);
				final int yOffset = skillIconEnabled ? SKILL_ICON_HEIGHT : COUNTER_ICON_HEIGHT;

				final TextComponent textComponent = new TextComponent();
				textComponent.setText(counterText);
				textComponent.setPosition(new Point(x + centerText, y + yOffset));
				textComponent.render(graphics);
			}

		}
	}

	private void renderRestore(StatusBarsConfig config, Graphics2D graphics, int x, int y, int width, int height, boolean isFixedLayout)
	{
		final int heal = healSupplier.get();

		if (heal <= 0)
		{
			return;
		}

		if (config.topBarMode() && !isFixedLayout) {
			final int filledCurrentWidth = getBarHeight(maxValue, currentValue, width);
			final int filledHealWidth = getBarHeight(maxValue, heal, width);
			final int fillX, fillWidth;
			final Color color = healColorSupplier.get();
			graphics.setColor(color);

			if (filledHealWidth + filledCurrentWidth > width)
			{
				graphics.setColor(OVERHEAL_COLOR);
				fillX = x - BORDER_SIZE + filledCurrentWidth;
				fillWidth = width - filledCurrentWidth;
			}
			else
			{
				fillX = x - BORDER_SIZE + filledCurrentWidth;
				fillWidth = filledHealWidth;
			}

			graphics.fillRect(fillX,
				y + BORDER_SIZE,
				fillWidth,
				height - (BORDER_SIZE * 2));
		}
		else
		{
			final int filledCurrentHeight = getBarHeight(maxValue, currentValue, height);
			final int filledHealHeight = getBarHeight(maxValue, heal, height);
			final int fillY, fillHeight;
			final Color color = healColorSupplier.get();
			graphics.setColor(color);

			if (filledHealHeight + filledCurrentHeight > height)
			{
				graphics.setColor(OVERHEAL_COLOR);
				fillY = y + BORDER_SIZE;
				fillHeight = height - filledCurrentHeight - BORDER_SIZE;
			}
			else
			{
				fillY = y + BORDER_SIZE + height - (filledCurrentHeight + filledHealHeight);
				fillHeight = filledHealHeight;
			}

			graphics.fillRect(x + BORDER_SIZE,
				fillY,
				width - BORDER_SIZE * 2,
				fillHeight);
		}
	}

	private static int getBarHeight(int base, int current, int size)
	{
		final double ratio = (double) current / base;

		if (ratio >= 1)
		{
			return size;
		}

		return (int) Math.round(ratio * size);
	}
}
