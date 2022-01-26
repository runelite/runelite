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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Item;
import static net.runelite.api.ItemID.*;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.item.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.item;
import net.runelite.client.plugins.cluescrolls.clues.item.SingleItemRequirement;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;

public class ClueScrollOverlay extends OverlayPanel
{
	private static final ItemRequirement HAS_SPADE = new SingleItemRequirement(SPADE);
	private static final ItemRequirement HAS_LIGHT = new AnyRequirementCollection("Light Source",
		item(LIT_TORCH),
		item(LIT_CANDLE),
		item(LIT_BLACK_CANDLE),
		item(CANDLE_LANTERN_4531),
		item(CANDLE_LANTERN_4534), // lit black candle lantern
		item(OIL_LAMP_4524),
		item(OIL_LANTERN_4539),
		item(BULLSEYE_LANTERN_4550),
		item(SAPPHIRE_LANTERN_4702),
		item(EMERALD_LANTERN_9065),
		item(MINING_HELMET),
		item(FIREMAKING_CAPE),
		item(FIREMAKING_CAPET),
		item(KANDARIN_HEADGEAR_1),
		item(KANDARIN_HEADGEAR_2),
		item(KANDARIN_HEADGEAR_3),
		item(KANDARIN_HEADGEAR_4),
		item(BRUMA_TORCH),
		item(MAX_CAPE),
		item(MAX_CAPE_13342));

	public static final Color TITLED_CONTENT_COLOR = new Color(190, 190, 190);

	private final ClueScrollPlugin plugin;
	private final Client client;

	@Inject
	private ClueScrollOverlay(ClueScrollPlugin plugin, Client client)
	{
		super(plugin);
		this.plugin = plugin;
		this.client = client;
		setPriority(OverlayPriority.LOW);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Clue Scroll overlay"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, "Reset", "Clue Scroll overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ClueScroll clue = plugin.getClue();

		if (clue == null)
		{
			return null;
		}

		clue.makeOverlayHint(panelComponent, plugin);

		final Item[] inventoryItems = plugin.getInventoryItems();
		final Item[] equippedItems = plugin.getEquippedItems();

		if (clue.isRequiresSpade() && inventoryItems != null)
		{
			if (!HAS_SPADE.fulfilledBy(inventoryItems))
			{
				panelComponent.getChildren().add(LineComponent.builder().left("").build());
				panelComponent.getChildren().add(LineComponent.builder().left("Requires Spade!").leftColor(Color.RED).build());
			}
		}

		if (clue.isRequiresLight()
			&& ((clue.getHasFirePit() == null || client.getVar(clue.getHasFirePit()) != 1)
				&& (inventoryItems == null || !HAS_LIGHT.fulfilledBy(inventoryItems))
					&& (equippedItems == null || !HAS_LIGHT.fulfilledBy(equippedItems))))
		{
			panelComponent.getChildren().add(LineComponent.builder().left("").build());
			panelComponent.getChildren().add(LineComponent.builder().left("Requires Light Source!").leftColor(Color.RED).build());
		}

		if (clue.getEnemy() != null)
		{
			panelComponent.getChildren().add(LineComponent.builder().left("").build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left(clue.getEnemy().getText())
				.leftColor(Color.YELLOW)
				.build());
		}

		return super.render(graphics);
	}
}
