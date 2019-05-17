/*
 * Copyright (c) 2019, Aleios <https://github.com/aleios>
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
package net.runelite.client.plugins.explorerring;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Point;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

import java.awt.*;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

public class ExplorerRingOverlay extends WidgetItemOverlay
{
	private static final Varbits TELEPORTS = Varbits.EXPLORER_RING_TELEPORTS;
	private static final Varbits ALCHS = Varbits.EXPLORER_RING_ALCHS;
	private static final Varbits RUNENERGY = Varbits.EXPLORER_RING_RUNENERGY;
	private static final Varbits ALCHTYPE = Varbits.EXPLORER_RING_ALCHTYPE;

	private static final int MAX_ALCHS = 30;
	private static final int MAX_TELEPORTS = 3;
	private static final int[] MAX_RUNREPLENISH = {
		2,
		3,
		4,
		3
	};

	private final Client client;
	private final ExplorerRingConfig config;

	@Inject
	ExplorerRingOverlay(Client client, ExplorerRingConfig config, TooltipManager tooltipManager)
	{
		this.client = client;
		this.config = config;

		showOnInventory();
		showOnBank();
		showOnEquipment();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		if (itemId < ItemID.EXPLORERS_RING_1 || itemId > ItemID.EXPLORERS_RING_4)
			return;

		graphics.setFont(FontManager.getRunescapeSmallFont());

		Point location = itemWidget.getCanvasLocation();
		StringBuilder tooltipBuilder = new StringBuilder();

		// Pen position tracking.
		int penShadowY = location.getY();
		int penY = location.getY();

		// Alchemy (level 4 ring is High Alc)
		int alchAmount = client.getVar(ALCHS);
		String alchStr = "A: " + (MAX_ALCHS - alchAmount);

		penShadowY += 1 + (graphics.getFontMetrics().getHeight() - 1);
		graphics.setColor(Color.BLACK);
		graphics.drawString(alchStr, location.getX() + 1,
				penShadowY);

		penY += (graphics.getFontMetrics().getHeight() - 1);
		graphics.setColor(config.fontColor());
		graphics.drawString(alchStr, location.getX(),
				penY);

		// Run energy
		int runAmount = client.getVar(RUNENERGY);
		String runStr = "R: " + (MAX_RUNREPLENISH[itemId - ItemID.EXPLORERS_RING_1] - runAmount);

		penShadowY += 1 + (graphics.getFontMetrics().getHeight() - 1);
		graphics.setColor(Color.BLACK);
		graphics.drawString(runStr, location.getX() + 1,
				penShadowY);

		penY += (graphics.getFontMetrics().getHeight() - 1);
		graphics.setColor(config.fontColor());
		graphics.drawString(runStr, location.getX(),
				penY);

		// Teleport charges (unique to level 2 ring).
		if (itemId == ItemID.EXPLORERS_RING_2)
		{
			int amount = client.getVar(TELEPORTS);
			String teleStr = "T: " + (MAX_TELEPORTS - amount);

			penShadowY += 1 + (graphics.getFontMetrics().getHeight() - 1);
			graphics.setColor(Color.BLACK);
			graphics.drawString(teleStr, location.getX() + 2,
					penShadowY);

			penY += (graphics.getFontMetrics().getHeight() - 1);
			graphics.setColor(config.fontColor());
			graphics.drawString(teleStr, location.getX() + 1,
					penY);
		}

	}
}
