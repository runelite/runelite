package net.runelite.client.plugins.fishing;

import net.runelite.api.*;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.QuantityFormatter;

import javax.inject.Inject;
import java.awt.*;

public class MinnowConversionOverlay extends Overlay
{
	private final Client client;
	private final FishingConfig config;
	private final TooltipManager tooltipManager;

	@Inject
	MinnowConversionOverlay(Client client, FishingConfig config, TooltipManager tooltipManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.config = config;
		this.tooltipManager = tooltipManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.isMenuOpen() || !config.showMinnowConversion())
		{
			return null;
		}

		MenuEntry[] menuEntries = client.getMenuEntries();
		int last = menuEntries.length - 1;

		if (last < 0)
		{
			return null;
		}

		MenuEntry entry = menuEntries[last];
		int widgetId = entry.getParam1();
		int groupId = WidgetInfo.TO_GROUP(widgetId);

		switch (groupId)
		{
			case WidgetID.INVENTORY_GROUP_ID:
			case WidgetID.BANK_GROUP_ID:
			case WidgetID.BANK_INVENTORY_GROUP_ID:
				String text = createConversionText(entry);
				if (text != null) {
					tooltipManager.add(new Tooltip(ColorUtil.prependColorTag(text, new Color(238, 238, 238))));
				}
		}

		return null;
	}

	private String createConversionText(MenuEntry entry)
	{
		int widgetId = entry.getParam1();

		ItemContainer container = null;
		if (widgetId == WidgetInfo.INVENTORY.getPackedId() ||
			widgetId == WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getPackedId())
		{
			container = client.getItemContainer(InventoryID.INVENTORY);
		}
		else if (widgetId == WidgetInfo.BANK_ITEM_CONTAINER.getPackedId())
		{
			container = client.getItemContainer(InventoryID.BANK);
		}

		if (container == null)
		{
			return null;
		}

		final int index = entry.getParam0();
		final Item item = container.getItem(index);
		if (item == null || item.getId() != ItemID.MINNOW)
		{
			return null;
		}

		return "Sharks: " + QuantityFormatter.formatNumber(item.getQuantity() / 40);
	}
}
