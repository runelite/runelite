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
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.item.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.item;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LineComponent;

public class ClueScrollOverlay extends OverlayPanel
{
	private static final ItemRequirement HAS_SPADE = new AnyRequirementCollection("Spade",
		item(ItemID.SPADE),
		item(ItemID.EASTER23_SPADE));
	private static final ItemRequirement HAS_LIGHT = new AnyRequirementCollection("Light Source",
		item(ItemID.TORCH_LIT),
		item(ItemID.LIT_CANDLE),
		item(ItemID.LIT_BLACK_CANDLE),
		item(ItemID.CANDLE_LANTERN_LIT),
		item(ItemID.CANDLE_LANTERN_BLACK_LIT), // lit black candle lantern
		item(ItemID.OIL_LAMP_LIT),
		item(ItemID.OIL_LANTERN_LIT),
		item(ItemID.BULLSEYE_LANTERN_LIT),
		item(ItemID.TOG_SAPPHIRE_LANTERN_LIT),
		item(ItemID.BULLSEYE_LANTERN_LIT_LUNAR_QUEST),
		item(ItemID.CAVE_GOBLIN_MINING_HELMET_LIT),
		item(ItemID.SKILLCAPE_FIREMAKING),
		item(ItemID.SKILLCAPE_FIREMAKING_TRIMMED),
		item(ItemID.SEERS_HEADBAND_EASY),
		item(ItemID.SEERS_HEADBAND_MEDIUM),
		item(ItemID.SEERS_HEADBAND_HARD),
		item(ItemID.SEERS_HEADBAND_ELITE),
		item(ItemID.WINT_TORCH),
		item(ItemID.SKILLCAPE_MAX),
		item(ItemID.SKILLCAPE_MAX_WORN),
		item(ItemID.ABYSSAL_LANTERN_NORMAL),
		item(ItemID.ABYSSAL_LANTERN_NORMAL_BLUE),
		item(ItemID.ABYSSAL_LANTERN_NORMAL_RED),
		item(ItemID.ABYSSAL_LANTERN_NORMAL_WHITE),
		item(ItemID.ABYSSAL_LANTERN_NORMAL_PURPLE),
		item(ItemID.ABYSSAL_LANTERN_NORMAL_GREEN),
		item(ItemID.ABYSSAL_LANTERN_OAK),
		item(ItemID.ABYSSAL_LANTERN_WILLOW),
		item(ItemID.ABYSSAL_LANTERN_MAPLE),
		item(ItemID.ABYSSAL_LANTERN_YEW),
		item(ItemID.ABYSSAL_LANTERN_BLISTERWOOD),
		item(ItemID.ABYSSAL_LANTERN_MAGIC),
		item(ItemID.ABYSSAL_LANTERN_REDWOOD),
		item(ItemID.LEAGUE_CLUE_COMPASS_TELEPORT));

	public static final Color TITLED_CONTENT_COLOR = new Color(190, 190, 190);

	private final ClueScrollPlugin plugin;
	private final Client client;

	@Inject
	private ClueScrollOverlay(ClueScrollPlugin plugin, Client client)
	{
		super(plugin);
		this.plugin = plugin;
		this.client = client;
		setPriority(PRIORITY_LOW);
		addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Clue Scroll overlay");
		addMenuEntry(RUNELITE_OVERLAY, "Reset", "Clue Scroll overlay", e -> plugin.resetClue(true));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ClueScroll clue = plugin.getClue();

		if (clue == null)
		{
			return null;
		}

		panelComponent.setPreferredSize(new Dimension(ComponentConstants.STANDARD_WIDTH, 0));
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
			&& ((clue.getFirePitVarbitId() == -1 || client.getVarbitValue(clue.getFirePitVarbitId()) != 1)
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
