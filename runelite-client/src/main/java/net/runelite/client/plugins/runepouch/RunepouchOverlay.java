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
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.ItemComposition;
import net.runelite.api.Point;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.plugins.runepouch.RunepouchConfig.RunepouchOverlayMode.BOTH;
import static net.runelite.client.plugins.runepouch.RunepouchConfig.RunepouchOverlayMode.MOUSE_HOVER;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;

class RunepouchOverlay extends WidgetItemOverlay
{
	private static final int NUM_SLOTS = 6;
	private static final int[] AMOUNT_VARBITS = {
		VarbitID.RUNE_POUCH_QUANTITY_1, VarbitID.RUNE_POUCH_QUANTITY_2, VarbitID.RUNE_POUCH_QUANTITY_3, VarbitID.RUNE_POUCH_QUANTITY_4,
		VarbitID.RUNE_POUCH_QUANTITY_5, VarbitID.RUNE_POUCH_QUANTITY_6
	};
	private static final int[] RUNE_VARBITS = {
		VarbitID.RUNE_POUCH_TYPE_1, VarbitID.RUNE_POUCH_TYPE_2, VarbitID.RUNE_POUCH_TYPE_3, VarbitID.RUNE_POUCH_TYPE_4,
		VarbitID.RUNE_POUCH_TYPE_5, VarbitID.RUNE_POUCH_TYPE_6
	};
	private static final int IMAGE_SIZE = 11;
	private static final BufferedImage[] RUNE_IMAGES = {
		ImageUtil.loadImageResource(RunepouchOverlay.class, "air_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "water_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "earth_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "fire_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "mind_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "chaos_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "death_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "blood_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "cosmic_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "nature_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "law_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "body_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "soul_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "astral_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "mist_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "mud_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "dust_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "lava_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "steam_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "smoke_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "wrath_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "sunfire_rune.png"),
		ImageUtil.loadImageResource(RunepouchOverlay.class, "aether_rune.png"),
	};

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
		if (itemId != ItemID.BH_RUNE_POUCH && itemId != ItemID.BH_RUNE_POUCH_TROUVER
			&& itemId != ItemID.DIVINE_RUNE_POUCH && itemId != ItemID.DIVINE_RUNE_POUCH_TROUVER)
		{
			return;
		}

		final int[] runeIds = new int[NUM_SLOTS];
		final int[] amounts = new int[NUM_SLOTS];
		final EnumComposition runepouchEnum = client.getEnum(EnumID.RUNEPOUCH_RUNE);
		int num = 0;

		for (int i = 0; i < NUM_SLOTS; i++)
		{
			@Varbit int amountVarbit = AMOUNT_VARBITS[i];
			int amount = client.getVarbitValue(amountVarbit);
			amounts[i] = amount;

			@Varbit int runeVarbit = RUNE_VARBITS[i];
			int runeId = client.getVarbitValue(runeVarbit);
			runeIds[i] = runeId;

			if (runeId != 0 && amount > 0)
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
				renderList(graphics, widgetItem, runeIds, amounts);
			}
			else
			{
				renderGrid(graphics, widgetItem, runeIds, amounts, num);
			}
		}

		final Point mousePos = client.getMouseCanvasPosition();
		if (widgetItem.getCanvasBounds().contains(mousePos.getX(), mousePos.getY())
			&& (overlayMode == MOUSE_HOVER || overlayMode == BOTH))
		{
			final StringBuilder tooltipBuilder = new StringBuilder();
			for (int i = 0; i < NUM_SLOTS; ++i)
			{
				final int runeId = runeIds[i];
				final int amount = amounts[i];
				if (runeId != 0 && amount > 0)
				{
					ItemComposition rune = itemManager.getItemComposition(runepouchEnum.getIntValue(runeId));
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

	private void renderList(Graphics2D graphics, WidgetItem widgetItem, int[] runeIds, int[] amounts)
	{
		graphics.setFont(FontManager.getRunescapeSmallFont());

		final Point location = widgetItem.getCanvasLocation();
		int runeNum = -1;
		for (int i = 0; i < NUM_SLOTS; ++i)
		{
			final int runeId = runeIds[i];
			final int amount = amounts[i];

			if (runeId == 0 || amount <= 0)
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

			BufferedImage image = getRuneImage(runeId);
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

	private void renderGrid(Graphics2D graphics, WidgetItem widgetItem, int[] runeIds, int[] amounts, int numRunes)
	{
		final Point location = widgetItem.getCanvasLocation();
		int c = 0;
		for (int i = 0; i < NUM_SLOTS; ++i)
		{
			final int runeId = runeIds[i];
			final int amount = amounts[i];

			if (runeId == -1 || amount <= 0)
			{
				continue;
			}

			final int iconX = location.getX() + 2 + (c % 2 == 1 ? IMAGE_SIZE + 2 /* pad */ + 2 /* bar offset */ : 0);
			final int iconY = numRunes > 4 ?
				location.getY() - 1 + (c / 2) * IMAGE_SIZE :
				location.getY() + 5 + (c >= 2 ? IMAGE_SIZE + 2 /* pad */ : 0);
			c++;

			BufferedImage image = getRuneImage(runeId);
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
			graphics.fillRect(iconX + IMAGE_SIZE, iconY + 1 + (10 - height), 2, height);
		}
	}

	private BufferedImage getRuneImage(int runeId)
	{
		runeId--;
		return runeId >= 0 && runeId < RUNE_IMAGES.length ? RUNE_IMAGES[runeId] : null;
	}

	private static String formatNumber(int amount)
	{
		return amount < 1000 ? String.valueOf(amount) : amount / 1000 + "K";
	}
}
