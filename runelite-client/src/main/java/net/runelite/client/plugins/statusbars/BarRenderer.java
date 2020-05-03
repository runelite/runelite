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

import lombok.RequiredArgsConstructor;
import net.runelite.client.ui.FontManager;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.function.Supplier;

@RequiredArgsConstructor
class BarRenderer
{
	private static final Color BACKGROUND = new Color(0, 0, 0, 150);
	private static final Color OVERHEAL_COLOR = new Color(216, 255, 139, 150);
	private static final int OVERHEAL_OFFSET = 2;
	private static final int HEAL_OFFSET = 3;
	private static final int ICON_AND_COUNTER_OFFSET_X = -4;
	private static final int ICON_AND_COUNTER_OFFSET_Y = 25;
	private static final int SKILL_ICON_HEIGHT = 35;
	private static final int COUNTER_ICON_HEIGHT = 18;
	private static final int OFFSET = 2;
	private static final int WIDTH = 20;
	private static final int PADDING = 1;
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
	 * @param height The height of the bar.
	 */
	void renderBar(StatusBarsConfig config, Graphics2D graphics, int x, int y, int height)
	{
		final int filledHeight = getBarHeight(maxValue, currentValue, height);
		final Color fill = colorSupplier.get();

		refreshSkills();

		graphics.setColor(BACKGROUND);
		graphics.drawRect(x, y, WIDTH - PADDING, height - PADDING);
		graphics.fillRect(x, y, WIDTH, height);

		graphics.setColor(fill);
		graphics.fillRect(x + PADDING,
			y + PADDING + (height - filledHeight),
			WIDTH - PADDING * OFFSET,
			filledHeight - PADDING * OFFSET);

		if (config.enableRestorationBars())
		{
			renderRestore(graphics, x, y, height);
		}

		if (config.enableSkillIcon() || config.enableCounter())
		{
			renderIconsAndCounters(config, graphics, x, y);
		}
	}

	private void renderIconsAndCounters(StatusBarsConfig config, Graphics2D graphics, int x, int y)
	{
		graphics.setFont(FontManager.getRunescapeSmallFont());
		graphics.setColor(Color.WHITE);
		String counterText = Integer.toString(currentValue);
		final int widthOfCounter = graphics.getFontMetrics().stringWidth(counterText);
		int centerText = (WIDTH - PADDING) / 2 - (widthOfCounter / 2);
		final Image icon = iconSupplier.get();

		if (config.enableCounter())
		{
			if (config.enableSkillIcon())
			{
				graphics.drawImage(icon, x + ICON_AND_COUNTER_OFFSET_X + PADDING, y + ICON_AND_COUNTER_OFFSET_Y - icon.getWidth(null), null);
				graphics.drawString(counterText, x + centerText + PADDING, y + SKILL_ICON_HEIGHT);
			}
			else
			{
				graphics.drawString(counterText, x + centerText + PADDING, y + COUNTER_ICON_HEIGHT);
			}
		}
		else if (config.enableSkillIcon())
		{
			graphics.drawImage(icon, x + ICON_AND_COUNTER_OFFSET_X + PADDING, y + ICON_AND_COUNTER_OFFSET_Y - icon.getWidth(null), null);
		}
	}

	private void renderRestore(Graphics2D graphics, int x, int y, int height)
	{
		final Color color = healColorSupplier.get();
		final int heal = healSupplier.get();

		if (heal <= 0)
		{
			return;
		}

		final int filledCurrentHeight = getBarHeight(maxValue, currentValue, height);
		int filledHeight = getBarHeight(maxValue, heal, height);
		graphics.setColor(color);

		if (filledHeight + filledCurrentHeight > height)
		{
			final int overHeal = filledHeight + filledCurrentHeight - height;
			filledHeight = filledHeight - overHeal + OVERHEAL_OFFSET;
			graphics.setColor(OVERHEAL_COLOR);
			graphics.fillRect(x + PADDING,
				y - filledCurrentHeight + (height - filledHeight) + HEAL_OFFSET,
				WIDTH - PADDING * OVERHEAL_OFFSET,
				filledHeight - PADDING * OVERHEAL_OFFSET);
		}
		else
		{
			graphics.fillRect(x + PADDING,
				y - OVERHEAL_OFFSET - filledCurrentHeight + (height - filledHeight) + HEAL_OFFSET,
				WIDTH - PADDING * OVERHEAL_OFFSET,
				filledHeight + OVERHEAL_OFFSET - PADDING * OVERHEAL_OFFSET);
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
