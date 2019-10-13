package net.runelite.client.plugins.runecraft;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

public class PouchOverlay extends WidgetItemOverlay
{
	private final ItemManager itemManager;
	private final RunecraftPlugin plugin;

	@Inject
	private PouchOverlay(final ItemManager itemManager, final RunecraftPlugin plugin)
	{
		this.itemManager = itemManager;
		this.plugin = plugin;
		showOnInventory();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		switch (itemId)
		{
			case ItemID.MEDIUM_POUCH_5511:
			case ItemID.LARGE_POUCH_5513:
			case ItemID.GIANT_POUCH_5515:
				final Rectangle bounds = itemWidget.getCanvasBounds();
				final BufferedImage outline = itemManager.getItemOutline(itemId, itemWidget.getQuantity(), Color.RED);
				graphics.drawImage(outline, (int) bounds.getX(), (int) bounds.getY(), null);
				break;
			case ItemID.MEDIUM_POUCH:
				OverlayUtil.renderTextLocation(graphics, itemWidget.getCanvasLocation(), "~" + plugin.getMediumCharges(), Color.WHITE);
				break;
			case ItemID.LARGE_POUCH:
				OverlayUtil.renderTextLocation(graphics, itemWidget.getCanvasLocation(), "~" + plugin.getLargeCharges(), Color.WHITE);
				break;
			case ItemID.GIANT_POUCH:
				OverlayUtil.renderTextLocation(graphics, itemWidget.getCanvasLocation(), "~" + plugin.getGiantCharges(), Color.WHITE);
				break;
		}
	}
}
