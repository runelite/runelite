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
	private static final Color BORDER_COLOR = new Color(0, 0, 0, 200);
	private static final Color OVERHEAL_COLOR = new Color(216, 255, 139, 150);

	private static final int COUNTER_Y_PADDING = 2;
	private static final int MIN_COUNTER_WIDTH = 12;

	private final Supplier<Integer> maxValueSupplier;
	private final Supplier<Integer> currentValueSupplier;
	private final Supplier<Integer> healSupplier;
	private final Supplier<Color> colorSupplier;
	private final Supplier<Color> healColorSupplier;
	private final Supplier<Image> iconSupplier;

	private int maxValue;
	private int currentValue;

	/**
	 * Updates the max and current values for our targeted Skill/Resource
	 */
	private void refreshValues()
	{
		maxValue = maxValueSupplier.get();
		currentValue = currentValueSupplier.get();
	}

	/**
	 * Renders a status bar along with its restoration bar(s), icons and counters as appropriate
	 *
	 * @param config   Plugin configuration which dictates certain settings, such as whether to show
	 *                 restoration bars and icons.
	 * @param graphics Graphics.
	 * @param x        The location on the client where it will draw the bar on the x-axis starting on the left side.
	 * @param y        The location on the client where it will draw the bar on the y-axis starting on the bottom side.
	 * @param height   The height of the bar.
	 */
	void renderBar(StatusBarsConfig config, Graphics2D graphics, int x, int y, int width, int height)
	{
		refreshValues();

		// Don't allow the border to be wider than half the actual bar
		final int borderSize = Math.min(width / 2, config.borderSize());
		graphics.setColor(BORDER_COLOR);
		graphics.fillRect(x, y, width, height);

		// Draw the actual bar
		final int filledHeight = getBarHeight(maxValue, currentValue, height);
		final Color fill = colorSupplier.get();

		graphics.setColor(fill);
		// By starting at `x + borderSize`, and making the width
		// `width - borderSize`, we're accounting for the border being twice as wide
		// overall as what the user has defined.
		graphics.fillRect(
			x + borderSize,
			y + borderSize + (height - filledHeight),
			width - (borderSize * 2),
			filledHeight - (borderSize * 2)
		);

		if (config.enableRestorationBars())
		{
			renderRestore(graphics, x, y, width, height, borderSize);
		}

		if (config.enableSkillIcon() || config.enableCounter())
		{
			renderIconsAndCounters(config, graphics, x, y, width, borderSize, height);
		}
	}

	private void renderIconsAndCounters(StatusBarsConfig config, Graphics2D graphics, int x, int y, int barWidth, int borderSize, int totalBarHeight)
	{
		final boolean skillIconEnabled = config.enableSkillIcon();

		int iconSize = 0;
		if (skillIconEnabled)
		{
			final Image icon = iconSupplier.get();
			if (icon != null)
			{
				final int iconYPos = y + borderSize + 2;

				iconSize = icon.getWidth(null);

				final int xDraw = x + (barWidth / 2) - (iconSize / 2);
				graphics.drawImage(icon, xDraw, iconYPos, null);
			}
		}

		// Skip drawing counters on very small bars
		if (config.enableCounter() && barWidth - (borderSize * 2) > MIN_COUNTER_WIDTH)
		{
			graphics.setFont(config.largeCounterText() ? FontManager.getRunescapeFont() : FontManager.getRunescapeSmallFont());

			final String counterText = Integer.toString(currentValue);
			final int widthOfCounter = graphics.getFontMetrics().stringWidth(counterText);
			final int centerText = (barWidth / 2) - (widthOfCounter / 2);

			final int heightOfCounter = graphics.getFontMetrics().getHeight();
			int counterYPos = y;

			switch (config.counterAlignment())
			{
				case TOP:
					counterYPos += COUNTER_Y_PADDING + heightOfCounter + (skillIconEnabled ? iconSize + COUNTER_Y_PADDING : 0);
					break;
				case MIDDLE:
					counterYPos += Math.round(totalBarHeight / 2f) + Math.round(heightOfCounter / 2f);
					break;
				case BOTTOM:
					counterYPos += totalBarHeight - borderSize - COUNTER_Y_PADDING;
					break;
			}

			final TextComponent textComponent = new TextComponent();
			textComponent.setText(counterText);
			textComponent.setPosition(new Point(x + centerText, counterYPos));
			textComponent.render(graphics);
		}
	}

	private void renderRestore(Graphics2D graphics, int x, int y, int width, int height, int borderSize)
	{
		final Color color = healColorSupplier.get();
		final int heal = healSupplier.get();

		if (heal <= 0)
		{
			return;
		}

		final int filledCurrentHeight = getBarHeight(maxValue, currentValue, height);
		final int filledHealHeight = getBarHeight(maxValue, heal, height);
		final int fillY, fillHeight;
		graphics.setColor(color);

		if (filledHealHeight + filledCurrentHeight > height)
		{
			graphics.setColor(OVERHEAL_COLOR);
			fillY = y + borderSize;
			fillHeight = height - filledCurrentHeight - borderSize;
		}
		else
		{
			fillY = y + borderSize + height - (filledCurrentHeight + filledHealHeight);
			fillHeight = filledHealHeight;
		}

		graphics.fillRect(x + borderSize,
			fillY,
			width - borderSize * 2,
			fillHeight);
	}

	/**
	 * Determines number of pixels that correspond to the current percentage of
	 * the maximum for the Bar
	 */
	private static int getBarHeight(int maxValue, int currentValue, int barMaxHeight)
	{
		final double ratio = (double) currentValue / maxValue;

		if (ratio >= 1)
		{
			return barMaxHeight;
		}

		return (int) Math.round(ratio * barMaxHeight);
	}
}
