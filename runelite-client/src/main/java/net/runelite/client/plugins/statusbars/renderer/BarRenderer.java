/*
 * Copyright (c) 2018, Rheon <https://github.com/Rheon-D>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
 *
 */

package net.runelite.client.plugins.statusbars.renderer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.client.plugins.statusbars.StatusBarsOverlay;
import net.runelite.client.plugins.statusbars.StatusBarsPlugin;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.components.TextComponent;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BarRenderer
{
	private static final TextComponent TEXT = new TextComponent();
	private static final Color COLOR_BAR_BG = new Color(0, 0, 0, 150);
	private static final Color COLOR_OVERHEAL = new Color(216, 255, 139, 150);
	private static final int BAR_WIDTH = 20;
	private static final int COUNTER_ICON_HEIGHT = 18;
	private static final int SKILL_ICON_HEIGHT = 35;
	private static final int PADDING = 1;
	private static final int OVERHEAL_OFFSET = 2;
	private static final int HEAL_OFFSET = 3;
	private static final int ICON_AND_COUNTER_OFFSET_X = 1;
	private static final int ICON_AND_COUNTER_OFFSET_Y = 21;
	private static final int OFFSET = 2;

	protected final StatusBarsPlugin plugin;
	int maximumValue;
	int currentValue;
	int restore;
	Color standardColor;
	Color restoreColor;
	Image icon;

	protected abstract void update(Client client, StatusBarsOverlay overlay);

	private void renderBar(Graphics2D graphics, int x, int y, int height)
	{
		graphics.setColor(COLOR_BAR_BG);
		graphics.drawRect(x, y, BAR_WIDTH - PADDING, height - PADDING);
		graphics.fillRect(x, y, BAR_WIDTH, height);

		final int filledHeight = getBarHeight(maximumValue, currentValue, height);
		graphics.setColor(standardColor);
		graphics.fillRect(x + PADDING,
			y + PADDING + (height - filledHeight),
			BAR_WIDTH - PADDING * OFFSET,
			filledHeight - PADDING * OFFSET);
	}

	private void renderIconsAndCounters(Graphics2D graphics, int x, int y)
	{
		final String counterText = Integer.toString(currentValue);
		final int widthOfCounter = graphics.getFontMetrics().stringWidth(counterText);
		final int centerText = (BAR_WIDTH - PADDING) / 2 - (widthOfCounter / 2);

		if (plugin.isEnableCounter())
		{
			graphics.setFont(FontManager.getRunescapeSmallFont());
			TEXT.setText(counterText);
			TEXT.setPosition(new Point(x + centerText + 1, y + COUNTER_ICON_HEIGHT));
		}
		else
		{
			TEXT.setText("");
		}

		if (plugin.isEnableSkillIcon())
		{
			graphics.drawImage(icon, x + ICON_AND_COUNTER_OFFSET_X + PADDING, y + ICON_AND_COUNTER_OFFSET_Y - icon.getWidth(null), null);
			TEXT.setPosition(new Point(x + centerText + 1, y + SKILL_ICON_HEIGHT));
		}

		TEXT.render(graphics);
	}

	private void renderRestore(Graphics2D graphics, int x, int y, int height)
	{
		if (restore <= 0)
		{
			return;
		}

		final int filledCurrentHeight = getBarHeight(maximumValue, currentValue, height);
		int filledHeight = getBarHeight(maximumValue, restore, height);
		graphics.setColor(restoreColor);

		if (filledHeight + filledCurrentHeight > height)
		{
			final int overHeal = filledHeight + filledCurrentHeight - height;
			filledHeight = filledHeight - overHeal + OVERHEAL_OFFSET;
			graphics.setColor(COLOR_OVERHEAL);
			graphics.fillRect(x + PADDING,
				y - filledCurrentHeight + (height - filledHeight) + HEAL_OFFSET,
				BAR_WIDTH - PADDING * OVERHEAL_OFFSET,
				filledHeight - PADDING * OVERHEAL_OFFSET);
		}
		else
		{
			graphics.fillRect(x + PADDING,
				y - OVERHEAL_OFFSET - filledCurrentHeight + (height - filledHeight) + HEAL_OFFSET,
				BAR_WIDTH - PADDING * OVERHEAL_OFFSET,
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

	public void draw(Client client, StatusBarsOverlay overlay, Graphics2D graphics, int x, int y, int height)
	{
		update(client, overlay);
		renderBar(graphics, x, y, height);
		if (plugin.isEnableRestorationBars())
		{
			renderRestore(graphics, x, y, height);
		}
		if (plugin.isEnableSkillIcon() || plugin.isEnableCounter())
		{
			renderIconsAndCounters(graphics, x, y);
		}
	}
}
