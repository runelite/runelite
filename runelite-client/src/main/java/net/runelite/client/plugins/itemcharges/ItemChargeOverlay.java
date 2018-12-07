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
package net.runelite.client.plugins.itemcharges;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.runelite.api.ItemID;
import net.runelite.api.Query;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.queries.EquipmentItemQuery;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.*;

import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.QueryRunner;

class ItemChargeOverlay extends Overlay
{
	private final QueryRunner queryRunner;
	private final ItemChargePlugin itemChargePlugin;
	private final ItemChargeConfig config;

	// Config values
	private boolean showDodgyCount;
	private boolean showTeleportCharges;
	private boolean showFungicideCharges;
	private boolean showImpCharges;
	private boolean showWateringCanCharges;
	private boolean showWaterskinCharges;
	private boolean showBellowCharges;
	private boolean showAbyssalBraceletCharges;
	private int veryLowWarning;
	private int lowWarning;
	private Color veryLowWarningColor;
	private Color lowWarningColor;

	private final Supplier<Collection<WidgetItem>> memorizedChargeItemWidgetList;

	@Inject
	ItemChargeOverlay(QueryRunner queryRunner, ItemChargePlugin itemChargePlugin, ItemChargeConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.queryRunner = queryRunner;
		this.itemChargePlugin = itemChargePlugin;
		this.config = config;
		updateConfig();
		this.memorizedChargeItemWidgetList = Suppliers.memoizeWithExpiration(this::getChargeWidgetItems, 500, TimeUnit.MILLISECONDS);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("itemCharge"))
			updateConfig();
	}

	private void updateConfig()
	{
		this.showDodgyCount = config.showDodgyCount();
		this.showTeleportCharges = config.showTeleportCharges();
		this.showFungicideCharges = config.showFungicideCharges();
		this.showImpCharges = config.showImpCharges();
		this.showWateringCanCharges = config.showWateringCanCharges();
		this.showWaterskinCharges = config.showWaterskinCharges();
		this.showBellowCharges = config.showBellowCharges();
		this.showAbyssalBraceletCharges = config.showAbyssalBraceletCharges();
		this.veryLowWarning = config.veryLowWarning();
		this.lowWarning = config.lowWarning();
		this.veryLowWarningColor = config.veryLowWarningColor();
		this.lowWarningColor = config.lowWarningolor();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!displayOverlay())
		{
			return null;
		}

		graphics.setFont(FontManager.getRunescapeSmallFont());

		for (WidgetItem item : memorizedChargeItemWidgetList.get())
		{
			if(item == null)
				continue;
			
			int charges;
			if (item.getId() == ItemID.DODGY_NECKLACE)
			{
				if (!showDodgyCount)
				{
					continue;
				}

				charges = itemChargePlugin.getDodgyCharges();
			}
			else
			{
				ItemWithCharge chargeItem = ItemWithCharge.findItem(item.getId());
				if (chargeItem == null)
				{
					continue;
				}

				ItemChargeType type = chargeItem.getType();
				if ((type == TELEPORT && !showTeleportCharges)
					|| (type == FUNGICIDE_SPRAY && !showFungicideCharges)
					|| (type == IMPBOX && !showImpCharges)
					|| (type == WATERCAN && !showWateringCanCharges)
					|| (type == WATERSKIN && !showWaterskinCharges)
					|| (type == BELLOWS && !showBellowCharges)
					|| (type == ABYSSAL_BRACELET && !showAbyssalBraceletCharges))
				{
					continue;
				}

				charges = chargeItem.getCharges();
			}

			final Rectangle bounds = item.getCanvasBounds();
			final TextComponent textComponent = new TextComponent();
			textComponent.setPosition(new Point(bounds.x, bounds.y + 16));
			textComponent.setText(charges < 0 ? "?" : String.valueOf(charges));
			textComponent.setColor(getColor(charges));
			textComponent.render(graphics);
		}
		return null;
	}

	private Collection<WidgetItem> getChargeWidgetItems()
	{
		Query inventoryQuery = new InventoryWidgetItemQuery();
		WidgetItem[] inventoryWidgetItems = queryRunner.runQuery(inventoryQuery);

		Query equipmentQuery = new EquipmentItemQuery().slotEquals(
			WidgetInfo.EQUIPMENT_AMULET,
			WidgetInfo.EQUIPMENT_RING,
			WidgetInfo.EQUIPMENT_GLOVES,
			WidgetInfo.EQUIPMENT_WEAPON
		);
		WidgetItem[] equipmentWidgetItems = queryRunner.runQuery(equipmentQuery);

		Collection<WidgetItem> jewellery = new ArrayList<>();
		jewellery.addAll(Arrays.asList(inventoryWidgetItems));
		jewellery.addAll(Arrays.asList(equipmentWidgetItems));
		return jewellery;
	}

	private Color getColor(int charges)
	{
		Color color = Color.WHITE;
		if (charges <= veryLowWarning)
		{
			color = veryLowWarningColor;
		}
		else if (charges <= lowWarning)
		{
			color = lowWarningColor;
		}
		return color;
	}

	private boolean displayOverlay()
	{
		return showTeleportCharges || showDodgyCount || showFungicideCharges
			|| showImpCharges || showWateringCanCharges ||showWaterskinCharges
			|| showBellowCharges || showAbyssalBraceletCharges;
	}
}
