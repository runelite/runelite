/*
 * Copyright (c) 2019, Ron Young <https://github.com/raiyni>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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

package net.runelite.client.plugins.bank;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import net.runelite.api.ItemComposition;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.util.ImageUtil;

public class HeatmapItemOverlay extends WidgetItemOverlay
{
	private static final int ALPHA = 135;
	private static final int COLOR_BOUNDARY = 240;

	private final BankPlugin plugin;
	private final ItemManager itemManager;

	@Getter
	private final Cache<Integer, BufferedImage> heatmapImages = CacheBuilder.newBuilder()
		.maximumSize(160)
		.expireAfterWrite(2, TimeUnit.MINUTES)
		.build();

	@Inject
	HeatmapItemOverlay(BankPlugin plugin, ItemManager itemManager)
	{
		this.plugin = plugin;
		this.itemManager = itemManager;
		showOnBank();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		HeatmapItem hItem = plugin.getHeatmapItem(itemId);
		BankPlugin.HEATMAP_MODE mode = plugin.getHeatmapMode();
		if (hItem == null || itemWidget.getWidget().getParentId() != WidgetInfo.BANK_ITEM_CONTAINER.getId()
			|| mode == BankPlugin.HEATMAP_MODE.NULL
			|| (mode == BankPlugin.HEATMAP_MODE.GE && hItem.getGePrice() < 1) || (mode == BankPlugin.HEATMAP_MODE.HA && hItem.getAlchPrice() < 1))
		{
			return;
		}

		Rectangle bounds = itemWidget.getCanvasBounds();
		BufferedImage image = heatmapImages.getIfPresent(itemId);
		if (image == null)
		{
			image = getImage(hItem, mode);
			heatmapImages.put(itemId, image);
		}

		graphics.drawImage(image, bounds.x, bounds.y, null);
	}

	private static Color getColor(float value)
	{
		float h = (1 - value) * COLOR_BOUNDARY / 360;
		Color c = Color.getHSBColor(h, 1, 1f);

		return new Color(c.getRed(), c.getGreen(), c.getBlue(), ALPHA);
	}

	private BufferedImage getImage(HeatmapItem item, BankPlugin.HEATMAP_MODE mode)
	{
		ItemComposition itemComposition = itemManager.getItemComposition(item.getId());
		boolean stackable = item.getQuantity() > 1 || itemComposition.isStackable();
		BufferedImage image = itemManager.getImage(item.getId(), item.getQuantity(), stackable);
		Color color = getColor(mode == BankPlugin.HEATMAP_MODE.GE ? item.getGeFactor() : item.getAlchFactor());
		return ImageUtil.fillImage(image, color);
	}
}
