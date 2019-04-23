package net.runelite.client.plugins.inventorysetups;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

@Slf4j
public class InventorySetupBankOverlay extends WidgetItemOverlay
{
	private final ItemManager itemManager;
	private final InventorySetupPlugin plugin;
	private final InventorySetupConfig config;

	@Inject
	public InventorySetupBankOverlay(ItemManager itemManager, InventorySetupPlugin plugin, InventorySetupConfig config)
	{
		this.itemManager = itemManager;
		this.plugin = plugin;
		this.config = config;
		showOnBank();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		if (config.getBankHighlight())
		{
			int[] ids = plugin.getCurrentInventorySetupIds();
			if (ids == null)
			{
				return;
			}

			if (IntStream.of(ids).noneMatch(x -> x == itemId))
			{
				return;
			}


			final Color color = config.getBankHighlightColor();

			if (color != null)
			{
				Rectangle bounds = itemWidget.getCanvasBounds();
				final BufferedImage outline = itemManager.getItemOutline(itemId, itemWidget.getQuantity(), color);
				graphics.drawImage(outline, (int) bounds.getX() + 1, (int) bounds.getY() + 1, null);

				if (itemWidget.getQuantity() > 1)
				{
					drawQuantity(graphics, itemWidget, Color.YELLOW);
				}
				else if (itemWidget.getQuantity() == 0)
				{
					drawQuantity(graphics, itemWidget, Color.YELLOW.darker());
				}
			}
		}
	}

	private void drawQuantity(Graphics2D graphics, WidgetItem item, Color darker)
	{
		graphics.setColor(Color.BLACK);
		graphics.drawString(String.valueOf(item.getQuantity()), item.getCanvasLocation().getX() + 2, item.getCanvasLocation().getY() + 11);
		graphics.setColor(darker);
		graphics.setFont(FontManager.getRunescapeSmallFont());
		graphics.drawString(String.valueOf(item.getQuantity()), item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 10);
	}
}