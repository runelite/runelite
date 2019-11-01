/*
 * Copyright (c) 2016-2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2019, David <https://github.com/drahenshaw>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.cluescrolls;

import net.runelite.api.Client;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.item.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.item.SingleItemRequirement;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;

import static net.runelite.api.ItemID.*;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.item;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

public class ClueScrollOverlay extends Overlay
{
	private static final ItemRequirement HAS_SPADE = new SingleItemRequirement(SPADE);
	private static final ItemRequirement HAS_LIGHT = new AnyRequirementCollection("Light Source", item(LIT_CANDLE), item(CANDLE_LANTERN_4531), item(MAX_CAPE), item(FIREMAKING_CAPE), item(FIREMAKING_CAPET), item(BRUMA_TORCH), item(KANDARIN_HEADGEAR_1), item(KANDARIN_HEADGEAR_2), item(KANDARIN_HEADGEAR_3), item(KANDARIN_HEADGEAR_4), item(MINING_HELMET_5014), item(BULLSEYE_LANTERN_4550), item(OIL_LANTERN_4539), item(OIL_LAMP_4524), item(LIT_BLACK_CANDLE), item(SAPPHIRE_LANTERN_4702), item(EMERALD_LANTERN_20722), item(OIL_LAMP_4524), item(LIT_TORCH));
	public static final Color TITLED_CONTENT_COLOR = new Color(190, 190, 190);
	private final ClueScrollPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();
	private Client client;

	@Inject
	private ClueScrollOverlay(Client client, ClueScrollPlugin plugin)
	{
		super(plugin);
		this.client = client;
		this.plugin = plugin;
		setPriority(OverlayPriority.LOW);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Clue Scroll overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ClueScroll clue = plugin.getClue();

		if (clue == null)
		{
			return null;
		}

		panelComponent.getChildren().clear();
		panelComponent.setPreferredSize(new Dimension(ComponentConstants.STANDARD_WIDTH, 0));

		clue.makeOverlayHint(panelComponent, plugin);

		if (clue.isRequiresSpade() && plugin.getInventoryItems() != null)
		{
			if (!HAS_SPADE.fulfilledBy(plugin.getInventoryItems()))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("").build());
				panelComponent.getChildren().add(LineComponent.builder().left("Requires Spade!").leftColor(Color.RED).build());
			}
		}

		if (clue.isRequiresLight() && ((plugin.getInventoryItems() != null && !HAS_LIGHT.fulfilledBy(plugin.getInventoryItems()) || (plugin.getEquippedItems() != null && !HAS_LIGHT.fulfilledBy(plugin.getEquippedItems())))))
		{
			if (clue.getHasFirePit() != null && client.getVar(clue.getHasFirePit()) == 1)
			{
				return panelComponent.render(graphics);
			}
			panelComponent.getChildren().add(LineComponent.builder().left("").build());
			panelComponent.getChildren().add(LineComponent.builder().left("Requires Light!").leftColor(Color.ORANGE).build());
		}

		return panelComponent.render(graphics);
	}
}
