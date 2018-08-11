/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.cluescrolls.clues;

import java.awt.Color;
import java.awt.Graphics2D;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.plugins.cluescrolls.clues.emote.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.emote.SingleItemRequirement;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
@AllArgsConstructor
public class CoordinateClue extends ClueScroll implements TextClueScroll, LocationClueScroll
{
	private String text;
	private WorldPoint location;
	private static final ItemRequirement HAS_SPADE = new SingleItemRequirement(ItemID.SPADE);

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Coordinate Clue").build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Click the clue scroll along the edge of your world map to see where you should dig.")
			.build());

		if (plugin.getInventoryItems() != null)
		{
			if (!HAS_SPADE.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("").build());
				panelComponent.getChildren().add(LineComponent.builder().left("Requires Spade!").leftColor(Color.RED).build());
			}
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), getLocation());

		if (localLocation == null)
		{
			return;
		}

		OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
	}
}
