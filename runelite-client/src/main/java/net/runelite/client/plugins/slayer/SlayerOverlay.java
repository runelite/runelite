/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.slayer;

import com.google.common.collect.ImmutableSet;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;

class SlayerOverlay extends Overlay
{
	private final SlayerConfig config;
	private final SlayerPlugin plugin;

	private final Set<Integer> slayerJewelry = ImmutableSet.of(
		ItemID.SLAYER_RING_1,
		ItemID.SLAYER_RING_2,
		ItemID.SLAYER_RING_3,
		ItemID.SLAYER_RING_4,
		ItemID.SLAYER_RING_5,
		ItemID.SLAYER_RING_6,
		ItemID.SLAYER_RING_7,
		ItemID.SLAYER_RING_8
	);

	private final Set<Integer> slayerEquipment = ImmutableSet.of(
		ItemID.SLAYER_HELMET,
		ItemID.SLAYER_HELMET_I,
		ItemID.BLACK_SLAYER_HELMET,
		ItemID.BLACK_SLAYER_HELMET_I,
		ItemID.GREEN_SLAYER_HELMET,
		ItemID.GREEN_SLAYER_HELMET_I,
		ItemID.PURPLE_SLAYER_HELMET,
		ItemID.PURPLE_SLAYER_HELMET_I,
		ItemID.RED_SLAYER_HELMET,
		ItemID.RED_SLAYER_HELMET_I,
		ItemID.TURQUOISE_SLAYER_HELMET,
		ItemID.TURQUOISE_SLAYER_HELMET_I,
		ItemID.SLAYER_RING_ETERNAL,
		ItemID.ENCHANTED_GEM,
		ItemID.ETERNAL_GEM,
		ItemID.BRACELET_OF_SLAUGHTER,
		ItemID.EXPEDITIOUS_BRACELET
	);

	@Inject
	private SlayerOverlay(SlayerPlugin plugin, SlayerConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showItemOverlay())
		{
			return null;
		}

		int amount = plugin.getAmount();
		if (amount <= 0)
		{
			return null;
		}

		int slaughterCount = plugin.getSlaughterChargeCount();
		int expeditiousCount = plugin.getExpeditiousChargeCount();

		graphics.setFont(FontManager.getRunescapeSmallFont());

		Collection<WidgetItem> items = plugin.getSlayerItems();
		for (WidgetItem item : items)
		{
			int itemId = item.getId();

			if (!slayerEquipment.contains(itemId) && !slayerJewelry.contains(itemId))
			{
				continue;
			}

			final Rectangle bounds = item.getCanvasBounds();
			final TextComponent textComponent = new TextComponent();

			switch (item.getId())
			{
				case ItemID.EXPEDITIOUS_BRACELET:
					textComponent.setText(String.valueOf(expeditiousCount));
					break;
				case ItemID.BRACELET_OF_SLAUGHTER:
					textComponent.setText(String.valueOf(slaughterCount));
					break;
				default:
					textComponent.setText(String.valueOf(amount));
					break;
			}

			// Draw the counter in the bottom left for equipment, and top left for jewelry
			textComponent.setPosition(new Point(bounds.x, bounds.y + (slayerJewelry.contains(itemId)
				? bounds.height
				: graphics.getFontMetrics().getHeight())));
			textComponent.render(graphics);
		}

		return null;
	}
}
