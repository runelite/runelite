/*
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.item.ItemPrice;

@Slf4j
class MotherlodeOreOverlay extends Overlay
{
	private long totalGEPrice = 0;

	private final MotherlodePlugin plugin;
	private final MotherlodeConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private ItemManager itemManager;

	@Inject
	MotherlodeOreOverlay(MotherlodePlugin plugin, MotherlodeConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInMlm() || !config.showOresCollected())
		{
			return null;
		}

		MotherlodeSession session = plugin.getSession();
		MotherlodeOreType[] oreTypes = MotherlodeOreType.values();

		MotherlodeOreType anyCollected = Arrays.stream(oreTypes)
			.filter(v -> session.getCollected(v.oreId) > 0)
			.findAny()
			.orElse(null);

		if (anyCollected == null)
		{
			return null;
		}

		panelComponent.getChildren().clear();

		String panelTitle = "Ores" + (
				totalGEPrice > 0 ? " (" + StackFormatter.quantityToStackSize(totalGEPrice) + ')' : ""
			);

		panelComponent.getChildren().add(TitleComponent.builder().text(panelTitle).build());

		totalGEPrice = 0;

		for (MotherlodeOreType oreType : oreTypes)
		{
			Integer collected = session.getCollected(oreType.oreId);

			if (collected == null)
			{
				continue;
			}

			final ItemPrice price = itemManager.getItemPrice(oreType.oreId);

			if (price != null)
			{
				totalGEPrice += price.getPrice() * collected;
			}

			panelComponent.getChildren().add(LineComponent.builder()
				.left(oreType.oreName + ':')
				.right(Integer.toString(collected))
				.build());
		}

		return panelComponent.render(graphics);
	}
}
