/*
 * Copyright (c) 2017, Tyler <http://github.com/tylerthardy>
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
package net.runelite.client.plugins.runepouch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Point;
import net.runelite.api.Varbits;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.RunepouchRune;
import static net.runelite.client.plugins.runepouch.RunepouchConfig.RunepouchOverlayMode.BOTH;
import static net.runelite.client.plugins.runepouch.RunepouchConfig.RunepouchOverlayMode.MOUSE_HOVER;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;

class RunepouchOverlay extends WidgetItemOverlay
{
	private static final int NUM_SLOTS = 3; // change this for toa
	private static final int[] AMOUNT_VARBITS = {
		Varbits.RUNE_POUCH_AMOUNT1, Varbits.RUNE_POUCH_AMOUNT2, Varbits.RUNE_POUCH_AMOUNT3, Varbits.RUNE_POUCH_AMOUNT4
	};
	private static final int[] RUNE_VARBITS = {
		Varbits.RUNE_POUCH_RUNE1, Varbits.RUNE_POUCH_RUNE2, Varbits.RUNE_POUCH_RUNE3, Varbits.RUNE_POUCH_RUNE4
	};
	private static final Dimension IMAGE_SIZE = new Dimension(11, 11);

	private final Client client;
	private final RunepouchConfig config;
	private final TooltipManager tooltipManager;
	private final ItemManager itemManager;

	@Inject
	RunepouchOverlay(Client client, RunepouchConfig config, TooltipManager tooltipManager, ItemManager itemManager)
	{
		this.tooltipManager = tooltipManager;
		this.client = client;
		this.config = config;
		this.itemManager = itemManager;
		showOnInventory();
		showOnBank();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem)
	{
		if (itemId != ItemID.RUNE_POUCH && itemId != ItemID.RUNE_POUCH_L)
		{
			return;
		}

		RunepouchRune[] runes = new RunepouchRune[NUM_SLOTS];
		int[] amounts = new int[NUM_SLOTS];
		int num = 0;

		for (int i = 0; i < NUM_SLOTS; i++)
		{
			@Varbit int amountVarbit = AMOUNT_VARBITS[i];
			int amount = client.getVarbitValue(amountVarbit);
			amounts[i] = amount;

			@Varbit int runeVarbit = RUNE_VARBITS[i];
			int runeId = client.getVarbitValue(runeVarbit);
			RunepouchRune rune = RunepouchRune.getRune(runeId);
			runes[i] = rune;

			if (amount > 0)
			{
				++num;
			}
		}

		if (num == 0)
		{
			return;
		}

		final RunepouchConfig.RunepouchOverlayMode overlayMode = config.runePouchOverlayMode();
		if (overlayMode != MOUSE_HOVER)
		{
			if (num < 4)
			{
				renderList(graphics, widgetItem, runes, amounts);
			}
			else
			{
				renderGrid(graphics, widgetItem, runes, amounts);
			}
		}

		final Point mousePos = client.getMouseCanvasPosition();
		if (widgetItem.getCanvasBounds().contains(mousePos.getX(), mousePos.getY())
			&& (overlayMode == MOUSE_HOVER || overlayMode == BOTH))
		{
			final StringBuilder tooltipBuilder = new StringBuilder();
			for (int i = 0; i < NUM_SLOTS; ++i)
			{
				final RunepouchRune rune = runes[i];
				final int amount = amounts[i];
				if (rune != null && amount > 0)
				{
					tooltipBuilder
						.append(amount)
						.append(' ')
						.append(ColorUtil.wrapWithColorTag(rune.getName(), Color.YELLOW))
						.append("</br>");
				}
			}

			final String tooltip = tooltipBuilder.toString();
			tooltipManager.add(new Tooltip(tooltip));
		}
	}

	private void renderList(Graphics2D graphics, WidgetItem widgetItem, RunepouchRune[] runes, int[] amounts)
	{
		graphics.setFont(FontManager.getRunescapeSmallFont());

		final Point location = widgetItem.getCanvasLocation();
		int runeNum = -1;
		for (int i = 0; i < NUM_SLOTS; ++i)
		{
			final RunepouchRune rune = runes[i];
			final int amount = amounts[i];

			if (rune == null || amount <= 0)
			{
				continue;
			}

			++runeNum;

			final String text = formatNumber(amount);
			final int textX = location.getX() + 11;
			final int textY = location.getY() + 12 + (graphics.getFontMetrics().getHeight() - 1) * runeNum;

			graphics.setColor(Color.BLACK);
			graphics.drawString(text, textX + 1, textY + 1);

			graphics.setColor(config.fontColor());
			graphics.drawString(text, textX, textY);

			BufferedImage image = getRuneImage(rune);
			if (image != null)
			{
				OverlayUtil.renderImageLocation(graphics,
					new Point(
						location.getX() - 1,
						location.getY() + graphics.getFontMetrics().getHeight() * runeNum - 1
					),
					image);
			}
		}
	}

	private void renderGrid(Graphics2D graphics, WidgetItem widgetItem, RunepouchRune[] runes, int[] amounts)
	{
		final Point location = widgetItem.getCanvasLocation();
		for (int i = 0; i < NUM_SLOTS; ++i)
		{
			final RunepouchRune rune = runes[i];
			final int amount = amounts[i];

			if (rune == null || amount <= 0)
			{
				continue;
			}

			final int iconX = location.getX() + 2 + (i == 1 || i == 3 ? IMAGE_SIZE.width + 2 /* pad */ + 2 /* bar offset */ : 0);
			final int iconY = location.getY() + 5 + (i >= 2 ? IMAGE_SIZE.height + 2 /* pad */ : 0);

			BufferedImage image = getRuneImage(rune);
			if (image != null)
			{
				OverlayUtil.renderImageLocation(graphics,
					new Point(iconX, iconY),
					image);
			}

			final int height;
			final Color color;

			if (amount < 1000)
			{
				// with <1k runes, the bar is shown in red with 100 increments
				height = amount / 100;
				color = Color.RED;
			}
			else
			{
				// with >=1k runes, the bar is shown in 1000 increments capped at 10k
				height = Math.min(10, amount / 1000);
				color = Color.GREEN;
			}

			graphics.setColor(color);
			graphics.fillRect(iconX + IMAGE_SIZE.width, iconY + 1 + (10 - height), 2, height);
		}
	}

	private BufferedImage getRuneImage(RunepouchRune rune)
	{
		BufferedImage runeImg = rune.getImage();
		if (runeImg != null)
		{
			return runeImg;
		}

		runeImg = itemManager.getImage(rune.getItemId());
		if (runeImg == null)
		{
			return null;
		}

		BufferedImage resizedImg = new BufferedImage(IMAGE_SIZE.width, IMAGE_SIZE.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = resizedImg.createGraphics();
		g.drawImage(runeImg, 0, 0, IMAGE_SIZE.width, IMAGE_SIZE.height, null);
		g.dispose();

		rune.setImage(resizedImg);
		return resizedImg;
	}

	private static String formatNumber(int amount)
	{
		return amount < 1000 ? String.valueOf(amount) : amount / 1000 + "K";
	}
}
