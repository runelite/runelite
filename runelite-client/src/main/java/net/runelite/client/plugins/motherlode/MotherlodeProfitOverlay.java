/*
 * Copyright (c) 2018, Craftiii4 <craftiii4@gmail.com>
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

import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.StackFormatter;

import javax.inject.Inject;
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MotherlodeProfitOverlay extends Overlay
{
	private final MotherlodePlugin plugin;
	private final MotherlodeConfig config;
	private final PanelComponent panelComponent = new PanelComponent();
	private final ItemManager itemManager;

	@Inject
	MotherlodeProfitOverlay(MotherlodePlugin plugin, ItemManager itemManager, MotherlodeConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.plugin = plugin;
		this.config = config;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		MotherlodeSession session = plugin.getSession();

		boolean showOre = config.showOreProfit();
		boolean showTotal = config.showTotalProfit();

		if (!plugin.isInMlm() || !session.showOres() || (!showOre && !showTotal))
			return null;

		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(TitleComponent.builder().color(Color.YELLOW).text("Profit").build());

		HashMap<MotherloadeOre, Integer> profits = new HashMap<>();
		Arrays.stream(MotherloadeOre.values()).filter(o -> session.getCollectedOre(o) > 0 && o != MotherloadeOre.GOLDEN_NUGGET).forEach(o -> profits.put(o, session.getCollectedOre(o) * itemManager.getItemPrice(o.getItemID())));

		if (showOre)
		{

			profits.keySet().stream()
				.sorted(Comparator.comparing(MotherloadeOre::getName))
				.forEach(o ->
					panelComponent.getChildren().add(LineComponent.builder().left(o.getName() + ":")
					.right(StackFormatter.formatNumber(profits.get(o)))
					.build())
				);

		}

		if (showTotal)
		{

			if (showOre)
				panelComponent.getChildren().add(LineComponent.builder().build());

			int total = 0;

			panelComponent.getChildren().add(LineComponent.builder()
					.leftColor(Color.CYAN)
					.left("Total:")
					.right(StackFormatter.formatNumber(profits.values().stream().mapToInt(o -> o.intValue()).sum()))
					.build());

		}

		return panelComponent.render(graphics);
	}
}
