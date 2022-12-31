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
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.components.TextComponent;

class SlayerOverlay extends WidgetItemOverlay
{
	private final static Set<Integer> SLAYER_JEWELRY = ImmutableSet.copyOf(ItemVariationMapping.getVariations(ItemID.SLAYER_RING_8));

	private final static Set<Integer> ALL_SLAYER_ITEMS = Stream.of(
		ItemVariationMapping.getVariations(ItemID.SLAYER_HELMET).stream(),
		ItemVariationMapping.getVariations(ItemID.SLAYER_RING_8).stream(),
		Stream.of(ItemID.ENCHANTED_GEM, ItemID.ETERNAL_GEM))
		.reduce(Stream::concat)
		.orElseGet(Stream::empty)
		.collect(Collectors.toSet());

	private final SlayerConfig config;
	private final SlayerPlugin plugin;

	@Inject
	private SlayerOverlay(SlayerPlugin plugin, SlayerConfig config)
	{
		this.plugin = plugin;
		this.config = config;
		showOnInventory();
		showOnEquipment();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem)
	{
		if (!ALL_SLAYER_ITEMS.contains(itemId))
		{
			return;
		}

		if (!config.showItemOverlay())
		{
			return;
		}

		int amount = plugin.getAmount();
		if (amount <= 0)
		{
			return;
		}

		graphics.setFont(FontManager.getRunescapeSmallFont());

		final Rectangle bounds = widgetItem.getCanvasBounds();
		final TextComponent textComponent = new TextComponent();
		textComponent.setText(String.valueOf(amount));

		// Draw the counter in the bottom left for equipment, and top left for jewelry
		textComponent.setPosition(new Point(bounds.x - 1, bounds.y - 1 + (SLAYER_JEWELRY.contains(itemId)
			? bounds.height
			: graphics.getFontMetrics().getHeight())));
		textComponent.render(graphics);
	}
}
