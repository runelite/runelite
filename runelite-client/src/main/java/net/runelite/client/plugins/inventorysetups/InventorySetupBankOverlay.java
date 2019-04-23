package net.runelite.client.plugins.inventorysetups;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Objects;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.Query;
import net.runelite.api.SpritePixels;
import net.runelite.api.queries.BankItemQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.util.QueryRunner;

@Slf4j
public class InventorySetupBankOverlay extends Overlay
{
	private final Client client;
	private final QueryRunner queryRunner;
	private final InventorySetupPlugin plugin;
	private final InventorySetupConfig config;

	@Inject
	public InventorySetupBankOverlay(Client client, QueryRunner queryRunner, InventorySetupPlugin plugin, InventorySetupConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.queryRunner = queryRunner;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.getBankHighlight())
		{
			int[] ids = plugin.getCurrentInventorySetupIds();
			if (ids == null)
			{
				return null;
			}
			ids = Arrays.stream(ids)
				.filter(Objects::nonNull)
				.filter(id -> id != -1)
				.toArray();
			final Query query = new BankItemQuery().idEquals(ids);
			final WidgetItem[] widgetItems = queryRunner.runQuery(query);
			final Widget bankContainer = client.getWidget(WidgetInfo.BANK_CONTAINER);
			for (final WidgetItem item : widgetItems)
			{
				Point canvasLocation = item.getCanvasLocation();
				Rectangle canvasBounds = item.getCanvasBounds();
				Point windowLocation = bankContainer.getCanvasLocation();

				if (canvasLocation == null || windowLocation == null)
				{
					return null;
				}

				if (!(canvasLocation.getY() + 60 >= windowLocation.getY() + bankContainer.getHeight()) && !(canvasLocation.getY() + canvasBounds.getHeight() <= windowLocation.getY() + 90))
				{
					final Color color = config.getBankHighlightColor();

					if (color != null)
					{
						final BufferedImage outline = loadItemOutline(item.getId(), item.getQuantity(), color);
						graphics.drawImage(outline, item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 1, null);
						if (item.getQuantity() > 1)
						{
							drawQuantity(graphics, item, Color.YELLOW);
						}
						else if (item.getQuantity() == 0)
						{
							drawQuantity(graphics, item, Color.YELLOW.darker());
						}
					}
				}
			}
		}
		return null;
	}

	private void drawQuantity(Graphics2D graphics, WidgetItem item, Color darker)
	{
		graphics.setColor(Color.BLACK);
		graphics.drawString(String.valueOf(item.getQuantity()), item.getCanvasLocation().getX() + 2, item.getCanvasLocation().getY() + 11);
		graphics.setColor(darker);
		graphics.setFont(FontManager.getRunescapeSmallFont());
		graphics.drawString(String.valueOf(item.getQuantity()), item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 10);
	}

	private BufferedImage loadItemOutline(final int itemId, final int itemQuantity, final Color outlineColor)
	{
		final SpritePixels itemSprite = client.createItemSprite(itemId, itemQuantity, 2, 0, 0, true, 710);
		return itemSprite.toBufferedOutline(outlineColor);
	}
}