/*
 * Copyright (c) 2019 Ahmad Issa
 * Copyright (c) 2019 Owain		<https://github.com/sdburns1998>
 * Copyright (c) 2019 Kyle 		<https://github.com/Kyleeld>
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
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

package net.runelite.client.plugins.highalchemy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

public class HighAlchemyOverlay extends WidgetItemOverlay
{
	private final ItemManager itemManager;
	private final HighAlchemyConfig config;
	private final HighAlchemyPlugin plugin;
	private final int alchPrice;
	private final int alchPriceNoStaff;
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	@Inject
	public HighAlchemyOverlay(ItemManager itemManager, HighAlchemyPlugin plugin, HighAlchemyConfig config)
	{
		this.itemManager = itemManager;
		this.config = config;
		this.plugin = plugin;

		int natPrice = itemManager.getItemPrice(ItemID.NATURE_RUNE);
		this.alchPrice = natPrice;
		this.alchPriceNoStaff = natPrice + 5 * itemManager.getItemPrice(ItemID.FIRE_RUNE);

		showOnBank();
		showOnInventory();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		Widget widget = itemWidget.getWidget();
		int interfaceGroup = TO_GROUP(widget.getId());

		if (!plugin.getInterfaceGroups().contains(interfaceGroup))
		{
			return;
		}

		final int id = getNotedId(itemId);
		final int gePrice = getGEPrice(id);
		final int haPrice = getHAPrice(id);
		final int materialCost = config.usingFireRunes() ? alchPriceNoStaff : alchPrice;
		final int desiredProfit = config.minProfit();
		final int haProfit = getHAProfit(haPrice, gePrice, materialCost);

		if (gePrice > 0 && haPrice > 0 && haProfit >= desiredProfit)
		{
			final Color color = config.getHighlightColor();

			if (color != null)
			{
				Rectangle bounds = itemWidget.getCanvasBounds();
				final BufferedImage outline = itemManager.getItemOutline(itemId, itemWidget.getQuantity(), color);
				graphics.drawImage(outline, (int) bounds.getX() + 1, (int) bounds.getY() + 1, null);
			}
		}
	}

	private int getGEPrice(int id)
	{
		return itemManager.getItemPrice(id);
	}

	private int getHAPrice(int id)
	{
		if (id == ItemID.COINS_995)
		{
			return 0;
		}
		ItemComposition itemComp = itemManager.getItemComposition(id);
		float haValue = itemComp.getPrice() * HIGH_ALCHEMY_CONSTANT;
		return Math.round(haValue);
	}

	private int getHAProfit(int haPrice, int gePrice, int alchCost)
	{
		return haPrice - gePrice - alchCost;
	}

	// Checks if item is noted, if not returns id
	private int getNotedId(int id)
	{
		int noteID = id;
		ItemComposition itemComposition = itemManager.getItemComposition(noteID);
		if (itemComposition.getNote() != -1)
		{
			noteID = itemComposition.getLinkedNoteId();
		}
		return noteID;
	}
}
